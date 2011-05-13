import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Vector;
import javax.swing.Box;

/**
 *
 * @author Mazuoyan
 */
class GUIUpdater {
    private final Container content;
    private final Frame f;

    public GUIUpdater(Container content, Frame f){
        this.content = content;
        this.f = f;
    }

    public void updateGUI(Vector<Track> tracks) {
        content.removeAll();
        for (Track t : tracks) {
            content.add(new TrackGUI(t, tracks, this).getTrackPanel());
            content.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        f.pack();
    }

}
