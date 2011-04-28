import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;

public class PlayThread extends Thread {

    byte[] buffer = new byte[10000];
    AudioInputStream audioInputStream;
    SourceDataLine sourceDataLine;
    Track track;

    public PlayThread(AudioInputStream audioInputStream, SourceDataLine sourceDataLine, Track track) {
        this.audioInputStream = audioInputStream;
        this.sourceDataLine = sourceDataLine;
        this.track = track;
    }

    @Override
    public void run() {
        
        try {
            int count;

            //Keep looping until the input read method returns -1 for empty stream.
            while ((count = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
                
                if (count > 0 && !(track.isPaused())) {
                    //Write data to the internal buffer of the data line
                    sourceDataLine.write(buffer, 0, count);
                }


            }
            //Block and wait for internal buffer of the data line to empty.
            sourceDataLine.drain();
            sourceDataLine.close();
            


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
