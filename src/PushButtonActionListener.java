package mcbe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PushButtonActionListener implements ActionListener {

    Track track;
    Track master;

    public PushButtonActionListener(Track track, Track master) {
        this.track = track;
        this.master = master;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(track.getName());
        try {
            master.addTrack(track);
        } catch (IOException ex) {
            Logger.getLogger(PushButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
