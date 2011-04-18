import java.io.*;
import java.util.Vector;
import javax.sound.sampled.*;

public class Music
{
	public boolean stopCapture = false;
  	public boolean paused = false;
  	public boolean playTogether = false;
  	
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
	ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
	ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
	ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
	
  	AudioFormat audioFormat;
  	TargetDataLine targetDataLine;
  	SourceDataLine sourceDataLine;
  	
  	AudioInputStream audioInputStream;
  	AudioInputStream audioInputStream1;
  	AudioInputStream audioInputStream2;
  	AudioInputStream audioInputStream3;
  	AudioInputStream audioInputStream4;
  	
  	int numRecs = 1;
  	
	Vector<String>TrackNames = new Vector<String>();
	
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
			e.printStackTrace();
      			System.exit(0);
    			}
  	}
	
	// plays back the audio data that has been saved in the ByteArrayOutputStream
  	public void playAudio() 
	{
  		byte[] audioData1 = new byte[10000];
  		byte[] audioData2 = new byte[10000];
  		byte[] audioData3 = new byte[10000];
  		byte[] audioData4 = new byte[10000];
  		
  	/*	padWith0s(audioData1);
 		padWith0s(audioData2);
 		padWith0s(audioData3);
 		padWith0s(audioData4);
  		
      
            audioData1 = byteArrayOutputStream1.toByteArray();
            audioData2 = byteArrayOutputStream2.toByteArray();
            audioData3 = byteArrayOutputStream3.toByteArray();
            audioData4 = byteArrayOutputStream4.toByteArray();*/
            try {
                if (numRecs == 2 && !playTogether) {
                    // Get an input stream on the byte array containing the data
                    InputStream byteArrayInputStream = new ByteArrayInputStream(audioData1);
                    AudioFormat audioFormat = getAudioFormat();
                    audioInputStream1 = new AudioInputStream(byteArrayInputStream, audioFormat,
                            audioData1.length / audioFormat.getFrameSize());
                    DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                    sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                    sourceDataLine.open(audioFormat);
                    sourceDataLine.start();

                    // Create a thread to play back the data
                    Thread playThread = new PlayThread(audioInputStream1, sourceDataLine, this);
                    playThread.start();
                } else if (numRecs == 3 && !playTogether) {
                    // Get an input stream on the byte array containing the data
                    InputStream byteArrayInputStream = new ByteArrayInputStream(audioData2);
                    AudioFormat audioFormat = getAudioFormat();
                    audioInputStream2 = new AudioInputStream(byteArrayInputStream, audioFormat,
                            audioData2.length / audioFormat.getFrameSize());
                    DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                    sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                    sourceDataLine.open(audioFormat);
                    sourceDataLine.start();

                    // Create a thread to play back the data
                    Thread playThread = new PlayThread(audioInputStream2, sourceDataLine, this);
                    playThread.start();
                } else if (numRecs == 4 && !playTogether) {
                    // Get an input stream on the byte array containing the data
                    InputStream byteArrayInputStream = new ByteArrayInputStream(audioData3);
                    AudioFormat audioFormat = getAudioFormat();
                    audioInputStream3 = new AudioInputStream(byteArrayInputStream, audioFormat,
                            audioData3.length / audioFormat.getFrameSize());
                    DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                    sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                    sourceDataLine.open(audioFormat);
                    sourceDataLine.start();

                    // Create a thread to play back the data
                    Thread playThread = new PlayThread(audioInputStream3, sourceDataLine, this);
                    playThread.start();
                } else if (numRecs == 5 && !playTogether) {
                    // Get an input stream on the byte array containing the data
                    InputStream byteArrayInputStream = new ByteArrayInputStream(audioData4);
                    AudioFormat audioFormat = getAudioFormat();
                    audioInputStream4 = new AudioInputStream(byteArrayInputStream, audioFormat,
                            audioData4.length / audioFormat.getFrameSize());
                    DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                    sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                    sourceDataLine.open(audioFormat);
                    sourceDataLine.start();

                    // Create a thread to play back the data
                    Thread playThread = new PlayThread(audioInputStream4, sourceDataLine, this);
                    playThread.start();
                } else if (playTogether) {
                    playTogether(audioData1, audioData2, audioData3, audioData4);
                }
            } catch (LineUnavailableException lue) {
                lue.printStackTrace();
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
	
	//sets boolean to stop recording
	public void stopRecording()
	{
		stopCapture = true;
	}

	//sets boolean to pause playback
	public void pausePlayback()
	{
		 paused = true;
	}

	//sets boolean to resume playback
	public void resumePlay()
	{
		 paused = false;
	}
	
	//fills byte arrays with os
	public void padWith0s(byte[] array)
	{
		for(int i = 0; i<10000; i++)
			array[i] = 0;
	}
	
	//mix byte arrays containing the 4 audio tracks
	public void playTogether(byte[] buff1, byte[] buff2, byte[] buff3, byte[] buff4)
	{
		try{
			byte[] mixedOutput = new byte[10000];
			int count;

                        System.out.println(buff1.length + " " + buff2.length + " " + buff3.length + " " + buff4.length);
			padWith0s(mixedOutput);
			for(int i = 0; i<10000; i++)
			{
				//add elements of all 4 track buffers track1[0]+track2[0]+track3[0]+track4[0]and so on for all elements of the arrays
                                mixedOutput[i] = 0;
                                if (i < buff1.length)
                                    mixedOutput[i] += buff1[i];
                                if (i < buff2.length)
                                    mixedOutput[i] += buff2[i];
                                if (i < buff3.length)
                                    mixedOutput[i] += buff3[i];
                                if (i < buff4.length)
                                    mixedOutput[i] += buff4[i];

			}
			// Get an input stream on the byte array containing the data
	      		InputStream byteArrayInputStream = new ByteArrayInputStream( mixedOutput );
	      		AudioFormat audioFormat = getAudioFormat();
	      		audioInputStream = new AudioInputStream( byteArrayInputStream, audioFormat,
				mixedOutput.length/audioFormat.getFrameSize());
	      		DataLine.Info dataLineInfo = new DataLine.Info( SourceDataLine.class, audioFormat );
	      		sourceDataLine = (SourceDataLine) AudioSystem.getLine( dataLineInfo );
	     		sourceDataLine.open( audioFormat );
	      		sourceDataLine.start();
	
	      		// Create a thread to play back the data 
	      		Thread playThread = new PlayThread(audioInputStream, sourceDataLine, this);
	      		playThread.start();
	  	}catch (LineUnavailableException e) {
	  		e.printStackTrace();
	  		System.exit(0);	
		}
	}
}