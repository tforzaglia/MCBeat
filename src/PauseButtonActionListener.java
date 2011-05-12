import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.j3d.Clip;
 
/**
 * action listener to stop a track when the pause button is pressed
 *
 */

public class PauseButtonActionListener implements ActionListener {
	Track track;
	public PauseButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
		track.clip.stop();	
	}
}
