import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            //clear the track by calling the track's clearTrack method
            master.clearTrack();
        } catch (IOException ex) {
            Logger.getLogger(ClearButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
