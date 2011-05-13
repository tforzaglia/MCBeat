import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
*
* action listener to push audio from master track to one of the other tracks
* 
*/

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
                //store possibilities to push the master track to in an array
		Object[] possibilities = {track1.getName(), track2.getName(), track3.getName(), track4.getName()};
		String s = (String)JOptionPane.showInputDialog(
		                    f,
		                    " Select a track to clear and push the master track to ",
		                    "Push Master Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    track1.getName());

		//if a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
                    //track 1 was selected by user
		    if(s.equals(track1.getName())){
                        //clear the selected track
		    	try {
					track1.clearTrack();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
                                //add master track to selected track
				track1.addTrack(master);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				}
		    }
                    //track 2 was selected by the user
		    else if (s.equals(track2.getName())){
                        //clear the selected track
		    	try {
					track2.clearTrack();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
                                //add master track to selected track
				track2.addTrack(master);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				}
		    }
                    //track 3 was selected by the user
		    else if(s.equals(track3.getName())){
                        //clear the selected track
		    	try {
					track3.clearTrack();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
                                //add master track to selected track
				track3.addTrack(master);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				}
		    }
                    //track 4 was selected by the user
		    else {
                        //clear the selected track
		    	try {
					track4.clearTrack();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
                                //add master track to selected track
				track4.addTrack(master);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			        }
		    }
		}
	}	
}
