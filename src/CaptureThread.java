import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.TargetDataLine;

/**
*
* class to create a thread that will capture audio from a microphone
*
*/

public class CaptureThread extends Thread {

    byte buffer[] = new byte[10000];
    ByteArrayOutputStream byteArrayOutputStream;
    TargetDataLine targetDataLine;
    Track track;

    //constructor for CaptureThread objects
    public CaptureThread(ByteArrayOutputStream byteArrayOutputStream, TargetDataLine targetDataLine, Track track) {
        this.byteArrayOutputStream = byteArrayOutputStream;
        this.targetDataLine = targetDataLine;
        this.track = track;
    }

    //thread's run method to capture audio data
    public void run() {
        try {

            //loop until stop button is pressed
            while (track.isRecording()) {
                //read data from the internal buffer of the data line.
                int count = targetDataLine.read(buffer, 0, buffer.length);
                if (count > 0) {
                    //save data in output stream object.
                    byteArrayOutputStream.write(buffer, 0, count);
                }
            }
            
            byteArrayOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(0);
        }
    }
}
