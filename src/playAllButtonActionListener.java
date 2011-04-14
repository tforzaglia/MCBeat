import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playAllButtonActionListener implements ActionListener {

	Music m;
	public playAllButtonActionListener(Music m){
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    		m.playTogether = true;                                    
	}
}
