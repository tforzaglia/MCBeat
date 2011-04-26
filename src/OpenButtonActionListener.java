import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenButtonActionListener implements ActionListener {
	Track track;
	public OpenButtonActionListener(Track track){
		this.track = track;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			track.open();
        	} catch (IOException ex) {
        		Logger.getLogger(PushButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        		}
	}
    
}
