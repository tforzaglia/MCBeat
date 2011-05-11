import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
//import mcbea.PushButtonActionListener;
//import mcbea.Track;

public class OpenButtonActionListener implements ActionListener {

    private Track track;
    private File file;
    final JFileChooser fc = new JFileChooser();

    public OpenButtonActionListener(Track track) {
        this.track = track;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
       

            int ret = fc.showDialog(null, "Open file");

            if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                track.open(fc.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(OpenButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
                    System.out.println("OPENED");
                    track.rename(fc.getSelectedFile().getName());
                
            }
        
    }
}