import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopRecButtonActionListener implements ActionListener {

    Track track;

    public StopRecButtonActionListener(Track track) {
        this.track = track;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        track.stopRecording();
    }
}