import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

/**
*
* class that describes the variables and methods associated with track objects
*  
*/

public class Track extends Canvas {

    Clip clip;
    private ByteArrayOutputStream byteArrayOutputStream;
    private String name;
    private boolean paused = false;
    private boolean isRecording = false;
    private boolean isPlaying = false;
    private float volume;
    private boolean isLooping = false;

    //constructor for track objects
    public Track(String name) {
        this.name = name;
        byteArrayOutputStream = new ByteArrayOutputStream();
        this.setSize(300, 50);
        this.setBackground(Color.white);
        this.repaint();
    }

    //method to rename a track
    public void rename(String s) {
        name = s;
        this.repaint();
    }

    //method that returns the name of the track
    public String getName() {
        return name;
    }

    //method to start recording a track
    public void startRecording() {
        isRecording = true;
        AudioFormat audioFormat;
        TargetDataLine targetDataLine;

        try {
            //get everything set up for recording via the target data line
            audioFormat = getAudioFormat();
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            //create and start a thread to capture data  
            Thread captureThread = new CaptureThread(byteArrayOutputStream, targetDataLine, this);
            captureThread.start();
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
            System.exit(0);
        }
    }

   //method to flip boolean that will terminate recording
    public void stopRecording() {
        isRecording = false;
    }

    //method to initialize the clip and get it ready for playback
    public void initClip() throws IOException {
        isPlaying = true;
        byte[] audioData = new byte[10000];
        AudioInputStream audioInputStream;
        audioData = byteArrayOutputStream.toByteArray();

        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioFormat audioFormat = getAudioFormat();

            //create an audio input stream using the previously captured data
            audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
                    audioData.length / audioFormat.getFrameSize());
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
           
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
            }      
    }

    //method to begin playback and set volume of the playback
    public void startPlay() throws IOException {
    	//if the loop box is checked, loop continuously  
        if (isLooping){  
        	clip.setFramePosition(0);
        	clip.loop(Clip.LOOP_CONTINUOUSLY);
        	FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(getVolume());
        }
        //if the loop box is not checked, play the clip once
        else{
             clip.setFramePosition(0);
        	 clip.start();           	 
        	 FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                 volume.setValue(getVolume());
        }     
    }

    //method to flip boolean that will terminate playback
    public void stopPlay() {
        isPlaying = false;
    }

    //method to add a track to the master playback track
    public void addTrack(Track track) throws IOException {

        byte[] master = byteArrayOutputStream.toByteArray();
        byte[] newTrack = track.byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();

        //add the bytes from the master track and added track to mix the audio 
        if (master.length < newTrack.length) {
            for (int i = 0; i < master.length; i++) {
                newTrack[i] += master[i];
            }
            byteArrayOutputStream.write(newTrack);
        } else {
            for (int i = 0; i < newTrack.length; i++) {
                master[i] += newTrack[i];
            }
            byteArrayOutputStream.write(master);
        }
    }
 
    //method to set volume 
    public void setVolume(int newVol) {
    	FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(getVolume());
    }
    
    //method to return the current volume
    public float getVolume() {  
    	return volume;     
    }

    //method to save a track as a .wav file
    public void save(File file) throws IOException{
        AudioInputStream audioInputStream;
        byte[] audioData = new byte[10000];
        audioData = byteArrayOutputStream.toByteArray();
        InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
        AudioFormat audioFormat = getAudioFormat();
        audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
            audioData.length / audioFormat.getFrameSize());
        AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
        
        //write the audio input stream to the .wav file 
        AudioSystem.write(audioInputStream, fileType, file);
    }
    
    //method to load a .wav file into a track
    public void open(File file) throws IOException{
        try{
              byteArrayOutputStream.reset();
              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
              byte[] audioData = new byte[10000];

              //write data from audioInputStream to byteArrayOutputStream
              int count;
              while (( count = audioInputStream.read(audioData, 0, audioData.length)) != -1)
              {
                  if (count > 0)
                      byteArrayOutputStream.write(audioData, 0, count);
              }
        }catch(UnsupportedAudioFileException uafe){
                  uafe.printStackTrace();
              }

              //initialize the clip to get ready for playback of the opened file
              this.initClip();
    }

    //method to flip boolean that will stop a track from playing
    public void pause() {
        paused = true;
    }

    //method that tests whether a track is paused or not
    public boolean isPaused() {
        return paused;
    }

    //method that tests whether a track is being recorded or not
    public boolean isRecording() {
        return isRecording;
    }

    //method that tests whether a track is playing or not
    public boolean isPlaying() {
        return isPlaying;
    }

    //method to clear a track by resetting its output stream
    public void clearTrack() {
        byteArrayOutputStream.reset();
    }

    //method to manipulate the color of the track display
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.PLAIN, 18));
        g.drawString(this.getName(), 100, 45);
        if(isPlaying){
            //set track to a new color when it is playing
            g.setColor(new Color(150,200,132,45));
            //g.fillRect(0, 0, (int)(this.percentDone*300), 50);
        }
    }

    //method to return the audio format for the audio data
    private AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean isSigned = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, isSigned, bigEndian);
    }
    
    //method to test whether the loop box is checked or not
    public boolean isLooping(){
        return isLooping;
    }
    
    public void setLooping(boolean isLooping){
        this.isLooping = isLooping;
    }
}