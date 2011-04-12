import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;


public class PlayThread extends Thread {
	
		byte buffer1[] = new byte[10000];
		byte buffer2[] = new byte[10000];
		byte buffer3[] = new byte[10000];
		byte buffer4[] = new byte[10000];
		AudioInputStream audioInputStream;
		SourceDataLine sourceDataLine;
		Music music;
		
		public PlayThread(AudioInputStream audioInputStream, SourceDataLine sourceDataLine, Music music) {
			this.audioInputStream = audioInputStream;
			this.sourceDataLine = sourceDataLine;
			this.music = music;
		}

		public void run()
		{
			try{
//  				int count;
  				int numRecs = 1;
  				
  				//fill the appropriate buffer with info from the audio input stream
  			     if(numRecs == 1)
  			       {
  			             audioInputStream.read( buffer1, 0, buffer1.length );
  			             numRecs++;
  			      }
  			     if(numRecs == 2)
  			       {
  			             audioInputStream.read( buffer2, 0, buffer2.length );
  			             numRecs++;
  			      }
  			     if(numRecs == 3)
  			     {
  			             audioInputStream.read( buffer3, 0, buffer3.length );
  			             numRecs++;
  			      }
  			     if(numRecs == 4)
  			       {
  			             audioInputStream.read( buffer4, 0, buffer4.length );
  			             numRecs++;
  			      }

/*  				
  				//Keep looping until the input read method returns -1 for empty stream.
  				while(( count = audioInputStream.read( tempBuffer, 0, tempBuffer.length ) ) != -1 )
  				{
    				if( count > 0 && !music.paused )// maybe need to use sourceDataLine.stop() to be able to resume in same spot
    				{
      					//Write data to the internal buffer of the data line
      					sourceDataLine.write( tempBuffer, 0, count );
    				}
  				}
*/
  				//Block and wait for internal buffer of the data line to empty.
  				sourceDataLine.drain();
  				sourceDataLine.close();
			}catch (Exception e) {
  				System.out.println(e);
  				System.exit(0);
				}
		}
		public void playTogether()
		{
			//pad arrays with 0s
			//try doing buffer.asList and returning size using .size() to see how many 0s need to be added
			
		}
		
}
//take from each buffer -- add elements of all 4 track buffers so track1[0]+track2[0]+track3[0]+track4[0] for all elements of the arrays
