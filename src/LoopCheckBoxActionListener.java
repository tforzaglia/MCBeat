import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmerriman.student
 */
public class LoopCheckBoxActionListener  implements ActionListener{
    private Track track;
    private JCheckBox lcb;
    LoopCheckBoxActionListener(JCheckBox lcb, Track track) {
        this.track = track;
        this.lcb = lcb;
    }

    public void actionPerformed(ActionEvent ae) {
        if(lcb.isSelected()){
            track.setLooping(true);
        }
        if(!lcb.isSelected()){
            track.setLooping(false);
        }
    }



}