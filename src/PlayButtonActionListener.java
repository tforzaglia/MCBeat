package mcbe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayButtonActionListener implements ActionListener {
	Track track;
	public PlayButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
                track.startPlay();
	}

}
