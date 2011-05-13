import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
*
* action listener to stop recording a track
* 
*/

public class StopRecButtonActionListener implements ActionListener {

    Track track;

    public StopRecButtonActionListener(Track track) {
        this.track = track;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        track.stopRecording();
        try {
        	try {
                        //put the thread to sleep to initialize the clip
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			}
                //initialize the clip for playback
		track.initClip();
	} catch (IOException ioe) {
		ioe.printStackTrace();
		}
    }
}