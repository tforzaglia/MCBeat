import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import javax.sound.sampled.TargetDataLine;


public class CaptureThread extends Thread {
	byte tempBuffer[] = new byte[10000];
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
			byteArrayOutputStream = new ByteArrayOutputStream();
			music.stopCapture = false;
			try{
				//Loop until stopCapture is set by another thread 
  				while( !music.stopCapture )
  				{
    				//Read data from the internal buffer of the data line.
    				int count = targetDataLine.read( tempBuffer, 0, tempBuffer.length );
    				if( count > 0 )
    				{
      					//Save data in output stream object.
      					byteArrayOutputStream.write( tempBuffer, 0, count );
    				}
  				}
			
  				Scanner scan = new Scanner(System.in);
  				System.out.println("Name the track");
  				String name = scan.next();
  				
  				//add track name to string vector
  				music.TrackNames.add(name);
  				System.out.println(music.TrackNames);

  				// add audio data to audio vector
  				//Audio.add( byteArrayOutputStream );
  				
  				//Track t = new Track( name, byteArrayOutputStream );
  				//Tracks.add( t );

  				byteArrayOutputStream.close();
			

			}catch (Exception e) {
  				System.out.println(e);
  				System.exit(0);
			}
		}

}

