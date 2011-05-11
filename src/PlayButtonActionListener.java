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
                try{
                	if(track.isLooping())
                		track.resume();
                	else
                		track.startPlay();
                		
                }catch(IOException ioe) {
            		ioe.printStackTrace();
                }
	}

}
