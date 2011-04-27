/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mcbe;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mazuoyan
 */
class volumeSliderChangeListener implements ChangeListener{
    Track track;
    JSlider vol;
    public volumeSliderChangeListener(Track track, JSlider vol) {
        this.track = track;
        this.vol = vol;
    }

    public void stateChanged(ChangeEvent e) {
        System.out.println(vol.getValue());


    }



}
