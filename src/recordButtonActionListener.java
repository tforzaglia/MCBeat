import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class recordButtonActionListener implements ActionListener {

	Music m;
	public recordButtonActionListener(Music m){
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		m.captureAudio();
	}

}
