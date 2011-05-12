import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * action listener to clear the audio data from a track when the trash button is clicked
 */

class ClearButtonActionListener implements ActionListener{
    Track master;
    public ClearButtonActionListener(Track master) {
        this.master = master;
    }

    public void actionPerformed(ActionEvent e) {
        //clear the track by calling the track's clearTrack method
        master.clearTrack();
    }
}
