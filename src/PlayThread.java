import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import java.util.Vector;


public class PlayThread extends Thread {
	
		byte[] buffer = new byte[10000];
		byte[] mixedBuffer = new byte[10000];
	
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
	  			int count;
	  			if(!music.playTogether)
	  			{
		  		    //Keep looping until the input read method returns -1 for empty stream.
	  				while(( count = audioInputStream.read( buffer, 0, buffer.length ) ) != -1 )
					{
	    					if( count > 0 && !music.paused )
	    			 		{
	      						//Write data to the internal buffer of the data line
	      						sourceDataLine.write( buffer, 0, count );
	    					}
	  				}						
	  				//Block and wait for internal buffer of the data line to empty.
	  				sourceDataLine.drain();
	  				sourceDataLine.close();
	  			}
	 			if(music.playTogether)
	  			{
					//Keep looping until the input read method returns -1 for empty stream.
	  				while(( count = audioInputStream.read( mixedBuffer, 0, mixedBuffer.length ) ) != -1 )
	  				{
	    					if( count > 0 && !music.paused )
	    					{
	      						//Write data to the internal buffer of the data line
	      						sourceDataLine.write( mixedBuffer, 0, count );
	    					}
	  				}
	
	 				//Block and wait for internal buffer of the data line to empty.
	  				sourceDataLine.drain();
	  				sourceDataLine.close();
					music.playTogether = false;
	  			}				
			}catch (Exception e) {
  				System.out.println(e);
  				System.exit(0);
				}
		}
}
