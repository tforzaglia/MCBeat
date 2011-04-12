import java.io.*;
import java.util.Vector;
import javax.sound.sampled.*;

public class Music
{
	public boolean stopCapture = false;
  	public boolean paused = false;
  	
	ByteArrayOutputStream byteArrayOutputStream;
  	AudioFormat audioFormat;
  	TargetDataLine targetDataLine;
  	AudioInputStream audioInputStream;
  	SourceDataLine sourceDataLine;
	
	Vector<ByteArrayOutputStream> Audio = new Vector<ByteArrayOutputStream>();
	Vector<String>TrackNames = new Vector<String>();
	//Vector<Track> Tracks = new Vector<Track>();
	
	// captures audio input from a microphone and saves it in a ByteArrayOutputStream object.
  	public void captureAudio()
	{
    		try{
      			// Get everything set up for capture
      			audioFormat = getAudioFormat();
      			DataLine.Info dataLineInfo = new DataLine.Info( TargetDataLine.class, audioFormat );
      			targetDataLine = (TargetDataLine) AudioSystem.getLine( dataLineInfo );
      			targetDataLine.open( audioFormat );
      			targetDataLine.start();

      			// Create a thread to capture the microphone data and start it  
      			Thread captureThread = new CaptureThread(byteArrayOutputStream, targetDataLine, this);
      			captureThread.start();
       		} catch (Exception e) {
			System.out.println(e);
      			System.exit(0);
    			}
  	}
	
	// plays back the audio data that has been saved in the ByteArrayOutputStream
  	public void playAudio() 
	{
    		try{
      			// Get everything set up for playback.
      			// Get the previously-saved data into a byte array object.
      			byte audioData[] = byteArrayOutputStream.toByteArray();
      			
			// Get an input stream on the byte array containing the data
      			InputStream byteArrayInputStream = new ByteArrayInputStream( audioData );
      			AudioFormat audioFormat = getAudioFormat();
      			audioInputStream = new AudioInputStream( byteArrayInputStream, audioFormat,
					audioData.length/audioFormat.getFrameSize());
      			DataLine.Info dataLineInfo = new DataLine.Info( SourceDataLine.class, audioFormat );
      			sourceDataLine = (SourceDataLine) AudioSystem.getLine( dataLineInfo );
     			sourceDataLine.open( audioFormat );
      			sourceDataLine.start();

      			// Create a thread to play back the data 
      			Thread playThread = new PlayThread(audioInputStream, sourceDataLine, this);
      			playThread.start();
    		
		} catch (Exception e) {
      			System.out.println(e);
      			System.exit(0);
    			}
  	}

	// creates and returns an AudioFormat object 
  	public AudioFormat getAudioFormat()
	{
    		float sampleRate = 8000.0F;
    		int sampleSizeInBits = 16;
    		int channels = 1;
    		boolean isSigned = true;
    		boolean bigEndian = false;
    		return new AudioFormat( sampleRate, sampleSizeInBits, channels, isSigned, bigEndian);
  	}
	
	public void stopRecording()
	{
		stopCapture = true;
	}

	public void pausePlayback()
	{
		 paused = true;
	}

	public void resumePlay()
	{
		 paused = false;
	}
	
}
	
	
