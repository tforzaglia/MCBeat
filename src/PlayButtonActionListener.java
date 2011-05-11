import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayButtonActionListener implements ActionListener {
	Track track;
	public PlayButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		track.stopPlay();
		
		if(!track.clip.isRunning())  
        	try {
				track.startPlay();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
						
                		
                
	}

}
