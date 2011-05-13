import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * action listener to push audio from master track to one of the other tracks
 *
 */
public class PushFromMasterButtonActionListener implements ActionListener {

    Vector<Track> tracks;
    Track master;
    JFrame f;

    public PushFromMasterButtonActionListener(Track master, Vector<Track> tracks) {
        this.master = master;
        this.tracks = tracks;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object[] possibilities = new Object[tracks.size()];
        //store possibilities to push the master track to in an array
        for (int i = 0; i < tracks.size(); i++) {

                possibilities[i] = tracks.get(i).getName();
            
        }

        String s = (String) JOptionPane.showInputDialog(
                null,
                " Select a track to clear and push the master track to ",
                "Push Master Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Select a track");

        for (Track t : tracks) {
            if ((s != null) && (s.length() > 0)) {
                //track 1 was selected by user
                if (s.equals(t.getName())) {
                    
                    try {
                        //add master track to selected track
                        t.addTrack(master);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }


        }
    }
}
