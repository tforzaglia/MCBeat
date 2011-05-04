import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class RenameButtonActionListener implements ActionListener {
	
	Track track;
	
	public RenameButtonActionListener(Track track) {
		this.track = track;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
      String name = (String) JOptionPane.showInputDialog(new Frame() ,"Enter a name for the track", null);
      track.rename(name);
	}

}
