import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayButtonActionListener implements ActionListener {
	Track track;
        int count = 0;
	public PlayButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
                try{              
                	if(count == 0){
                		track.startPlay();//plays clip from beginning
                		count++;//this will need to be changed when checks are added
                	}
                	else //if checked
                		track.resume();//resumes a paused track
                }catch(IOException ioe) {
            		ioe.printStackTrace();
                }
	}

}
