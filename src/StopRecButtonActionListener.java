import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			track.initClip();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}