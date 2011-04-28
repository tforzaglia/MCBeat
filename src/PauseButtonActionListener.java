import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PauseButtonActionListener implements ActionListener {
	Track track;
	public PauseButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		track.pause();
	}

}
