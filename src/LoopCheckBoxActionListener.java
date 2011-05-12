import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/**
 *
 * class to control looping of tracks through checkboxes
 */

public class LoopCheckBoxActionListener  implements ActionListener{
    private Track track;
    private JCheckBox lcb;
    LoopCheckBoxActionListener(JCheckBox lcb, Track track) {
        this.track = track;
        this.lcb = lcb;
    }

    public void actionPerformed(ActionEvent ae) {
        //when box is checked, enable looping
        if(lcb.isSelected()){
            track.setLooping(true);
        }
        //if box is checked, don't loop
        if(!lcb.isSelected()){
            track.setLooping(false);
        }
    }
}