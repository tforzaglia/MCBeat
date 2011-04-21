package mcbe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.TargetDataLine;

public class CaptureThread extends Thread {

    byte buffer[] = new byte[10000];
    ByteArrayOutputStream byteArrayOutputStream;
    TargetDataLine targetDataLine;
    Track track;

    public CaptureThread(ByteArrayOutputStream byteArrayOutputStream, TargetDataLine targetDataLine, Track track) {
        this.byteArrayOutputStream = byteArrayOutputStream;
        this.targetDataLine = targetDataLine;
        this.track = track;
    }

    public void run() {
        try {

            //Loop until stopCapture is set by another thread
            while (track.isRecording()) {
                //Read data from the internal buffer of the data line.
                int count = targetDataLine.read(buffer, 0, buffer.length);
                if (count > 0) {
                    //Save data in output stream object.
                    byteArrayOutputStream.write(buffer, 0, count);
                }
            }
            track.trackLength = System.currentTimeMillis() - track.startPlayTime;
            System.out.println(track.trackLength);
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
