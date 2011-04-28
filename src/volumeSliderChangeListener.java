import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mazuoyan
 */
class VolumeSliderChangeListener implements ChangeListener{
    Track track;
    JSlider vol;
    public VolumeSliderChangeListener(Track track, JSlider vol) {
        this.track = track;
        this.vol = vol;
    }

    public void stateChanged(ChangeEvent e) {
        System.out.println(vol.getValue());


    }



}
