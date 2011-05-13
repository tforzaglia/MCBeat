import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
*
* action listener to play a track when the play button is pressed
* 
*/

public class PlayButtonActionListener implements ActionListener {
	Track track;
	public PlayButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		track.stopPlay();
		
                //only allow playing the clip when no other clip is playing
		if(!track.clip.isRunning())  
        	try {
			track.startPlay();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		        }       
	}
}
