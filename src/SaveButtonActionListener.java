import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class SaveButtonActionListener implements ActionListener {

    final Track track;
    final JFileChooser fc = new JFileChooser();

    public SaveButtonActionListener(Track track) {
        this.track = track;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        int ret = fc.showDialog(null, "Save file");
        fc.setVisible(true);
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                track.save(new File(fc.getSelectedFile().toString()+".wav"));
            } catch (IOException ex) {
                Logger.getLogger(SaveButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }





    }
}
