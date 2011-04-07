import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class stopRecButtonActionListener implements ActionListener {
	Music m;
	public stopRecButtonActionListener(Music m){
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		m.stopCapture=true;
	}

}
