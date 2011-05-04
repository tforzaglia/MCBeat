import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PushFromMasterButtonActionListener implements ActionListener {
	
	Track track1;
	Track track2;
	Track track3;
	Track track4;
	Track master;
	JFrame f;
	
	public PushFromMasterButtonActionListener(JFrame f, Track master, Track track1, Track track2, Track track3, Track track4) {
		this.master = master;
		this.track1 = track1;
		this.track2 = track2;
		this.track3 = track3;
		this.track4 = track4;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] possibilities = {track1.getName(), track2.getName(), track3.getName(), track4.getName()};
		String s = (String)JOptionPane.showInputDialog(
		                    f,
		                    " Select a track to clear and push the master track to ",
		                    "Push Master Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    track1.getName());

		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
		    if(s.equals(track1.getName())){
		    	track1.clearTrack();
		    	try {
					track1.addTrack(master);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    else if (s.equals(track2.getName())){
		    	track2.clearTrack();
		    	try {
					track2.addTrack(master);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    else if(s.equals(track3.getName())){
		    	track3.clearTrack();
		    	try {
					track3.addTrack(master);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    else {
		    	track4.clearTrack();
		    	try {
					track4.addTrack(master);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		}
	}
	
}
