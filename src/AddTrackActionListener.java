import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class AddTrackActionListener implements ActionListener {
    Vector<Track> tracks;
    GUIUpdater g;
    AddTrackActionListener(Vector<Track> tracks, GUIUpdater g) {
        this.tracks = tracks;
        this.g=g;
    }

    public void actionPerformed(ActionEvent e) {
        if(tracks.size()<10){
            tracks.add(new Track("Track "+(tracks.size()+1)));
            g.updateGUI(tracks);
        }
    }
	
}
