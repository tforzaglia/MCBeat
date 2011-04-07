import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class pauseButtonActionListener implements ActionListener {
	Music m;
	public pauseButtonActionListener(Music m){
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		m.paused=true;
	}

}
