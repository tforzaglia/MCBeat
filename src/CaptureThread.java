import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import javax.sound.sampled.TargetDataLine;


public class CaptureThread extends Thread {
	byte tempBuffer[] = new byte[10000];
	byte buffer1[] = new byte[10000];
	byte buffer2[] = new byte[10000];
	byte buffer3[] = new byte[10000];
	byte buffer4[] = new byte[10000];
	ByteArrayOutputStream byteArrayOutputStream;
	
	TargetDataLine targetDataLine;
	Music music;

		public CaptureThread(ByteArrayOutputStream byteArrayOutputStream, TargetDataLine targetDataLine, Music music) {
			this.byteArrayOutputStream = byteArrayOutputStream;
			this.targetDataLine = targetDataLine;
			this.music = music;
		}
		
		public void run()
		{
			music.byteArrayOutputStream1 = new ByteArrayOutputStream();
			music.byteArrayOutputStream2 = new ByteArrayOutputStream();
			music.byteArrayOutputStream3 = new ByteArrayOutputStream();
			music.byteArrayOutputStream4 = new ByteArrayOutputStream();
			music.stopCapture = false;
				
			try{
				if (music.numRecs == 1)
				{
					//Loop until stopCapture is set by another thread 
	  				while( !music.stopCapture )
	  				{
	    				//Read data from the internal buffer of the data line.
	    				int count = targetDataLine.read( buffer1, 0, buffer1.length );
	    				if( count > 0 )
	    				{
	      					//Save data in output stream object.
	      					music.byteArrayOutputStream1.write( buffer1, 0, count );
	    				}
	  				}
	  				music.numRecs++;
					music.byteArrayOutputStream1.close();
				}
				else if (music.numRecs == 2)
				{
					//Loop until stopCapture is set by another thread 
	  				while( !music.stopCapture )
	  				{
	    				//Read data from the internal buffer of the data line.
	    				int count = targetDataLine.read( buffer2, 0, buffer2.length );
	    				if( count > 0 )
	    				{
	      					//Save data in output stream object.
	      					music.byteArrayOutputStream2.write( buffer2, 0, count );
	    				}
	  				}
	  				music.numRecs++;
					music.byteArrayOutputStream2.close();
				}
				else if (music.numRecs == 3)
				{
					//Loop until stopCapture is set by another thread 
	  				while( !music.stopCapture )
	  				{
	    				//Read data from the internal buffer of the data line.
	    				int count = targetDataLine.read( buffer3, 0, buffer3.length );
	    				if( count > 0 )
	    				{
	      					//Save data in output stream object.
	      					music.byteArrayOutputStream3.write( buffer3, 0, count );
	    				}
	  				}
	  				music.numRecs++;
					music.byteArrayOutputStream3.close();
				}
				else if (music.numRecs == 4)
				{
					//Loop until stopCapture is set by another thread 
	  				while( !music.stopCapture )
	  				{
	    				//Read data from the internal buffer of the data line.
	    				int count = targetDataLine.read( buffer4, 0, buffer4.length );
	    				if( count > 0 )
	    				{
	      					//Save data in output stream object.
	      					music.byteArrayOutputStream4.write( buffer4, 0, count );
	    				}
	  				}
	  				music.numRecs++;
					music.byteArrayOutputStream4.close();
				}
				else
					System.out.println("No more tracks available");
  				/*
  				Scanner scan = new Scanner(System.in);
  				System.out.println("Name the track");
  				String name = scan.next();
  				
  				//add track name to string vector
  				music.TrackNames.add(name);
  				System.out.println(music.TrackNames);
				*/
			}catch (Exception e) {
  				System.out.println(e);
  				System.exit(0);
			}
		}

}

