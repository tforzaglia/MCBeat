import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class RemoveTrackButtonActionListener implements ActionListener {
     Vector<Track> tracks;
     Track track;
     GUIUpdater guiUpdater;
    RemoveTrackButtonActionListener(Track track, Vector<Track> tracks, GUIUpdater guiUpdater) {
        this.track = track;
        this.tracks = tracks;
        this.guiUpdater =  guiUpdater;
    }

    public void actionPerformed(ActionEvent e) {
        if(tracks.size()>1){
            tracks.remove(track);
            guiUpdater.updateGUI(tracks);
        }
    }
	
}
