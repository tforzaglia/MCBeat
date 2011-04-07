import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class playButtonActionListener implements ActionListener {
	Music m;
	public playButtonActionListener(Music m){
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		m.playAudio();

	}

}
