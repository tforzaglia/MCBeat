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

public class Track extends Canvas {

    private ByteArrayOutputStream byteArrayOutputStream;
    private String name;
    private boolean paused = false;
    private boolean isRecording = false;
    private boolean isPlaying = false;
    public long trackLength;
    private long startTime;
    public long startPlayTime;
    public double percentDone = 0.0;
    private float volume;

    public Track(String name) {
        this.name = name;
        byteArrayOutputStream = new ByteArrayOutputStream();
        this.setSize(300, 50);
        this.setBackground(Color.white);
        this.repaint();
    }

    public void rename(String s) {
        name = s;
        this.repaint();
    }

    public String getName() {
        return name;
    }

    public void startRecording() {
        isRecording = true;
        startPlayTime = System.currentTimeMillis();
        AudioFormat audioFormat;
        TargetDataLine targetDataLine;

        try {
            // Get everything set up for capture
            audioFormat = getAudioFormat();
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            targetDataLine.open(audioFormat);
            targetDataLine.start();


            // Create a thread to capture the microphone data and start it
            Thread captureThread = new CaptureThread(byteArrayOutputStream, targetDataLine, this);
            captureThread.start();
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
            System.exit(0);
        }
    }

    public void stopRecording() {
        isRecording = false;
    }

    public void startPlay() {
        isPlaying = true;
        paused = false;
        byte[] audioData = new byte[10000];
        SourceDataLine sourceDataLine;
        AudioInputStream audioInputStream;
        audioData = byteArrayOutputStream.toByteArray();

        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioFormat audioFormat = getAudioFormat();
            audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
                    audioData.length / audioFormat.getFrameSize());
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            // Create a thread to startPlay back the data
            Thread playThread = new PlayThread(audioInputStream, sourceDataLine, this);
            playThread.start();

        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }

    }

    public void stopPlay() {
        isPlaying = false;
    }

    public void addTrack(Track t) throws IOException {

        byte[] master = byteArrayOutputStream.toByteArray();
        byte[] newTrack = t.byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();

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

    public void volume(int newVol) throws LineUnavailableException{    
        
        SourceDataLine sourceDataLine;
        AudioFormat audioFormat = getAudioFormat();
        
        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();
        FloatControl volume = (FloatControl) sourceDataLine.getControl(FloatControl.Type.VOLUME);
        volume.setValue((float) newVol);
    }
    
    public void setVolume(int newVol) {
    	volume = (float) newVol;
    	
    }
    
    public float getVolume() {
    	return volume;
    }

    public void save(File file) throws IOException{
    	AudioInputStream audioInputStream;
    	byte[] audioData = new byte[10000];
    	audioData = byteArrayOutputStream.toByteArray();
    	InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
        AudioFormat audioFormat = getAudioFormat();
        audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
        	audioData.length / audioFormat.getFrameSize());
	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
	AudioSystem.write(audioInputStream, fileType, file);
    }
	
    public void open() throws IOException{
	try{
	        File audioFile = new File("track.wav");
      		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
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
	}

    public void pause() {
        paused = true;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isRecording() {
        return isRecording;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void clearTrack() {
        byteArrayOutputStream.reset();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.PLAIN, 18));
        g.drawString(this.getName(), 20, 45);
        if(isPlaying){
            g.setColor(new Color(150,200,132,45));
            g.fillRect(0, 0, (int)(this.percentDone*300), 50);
        }
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean isSigned = true;
        boolean bigEndian = false;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, isSigned, bigEndian);
    }
}
