import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Timer;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author bmerriman.student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Track track1 = new Track("Track 1");
        Track track2 = new Track("Track 2");
        Track track3 = new Track("Track 3");
        Track track4 = new Track("Track 4");
        Track trackMaster = new Track("Master");


        JFrame f = new JFrame("MCBE@");
        
        JMenuBar menuBar = new JMenuBar();
        f.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem saveFile = new JMenuItem("Save File...");
        fileMenu.add(saveFile);
        JMenuItem openFile = new JMenuItem("Open File...");
        fileMenu.add(openFile);
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        Container content = f.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());


        JButton playButtonMaster = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton pauseButtonMaster = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton clearButtonMaster = new JButton(new ImageIcon("sketchBlackTrashClear.png"));
        JButton saveButtonMaster = new JButton(new ImageIcon("sketchBlackSaveFile.png"));
        JButton openButtonMaster = new JButton(new ImageIcon("sketchBlackOpenFile.png"));

        playButtonMaster.addActionListener(new PlayButtonActionListener(trackMaster));
        pauseButtonMaster.addActionListener(new PauseButtonActionListener(trackMaster));
        clearButtonMaster.addActionListener(new ClearButtonActionListener(trackMaster));


        JPanel trackPanelMaster = new JPanel();
        trackPanelMaster.setLayout(new BoxLayout(trackPanelMaster, 0));
        trackPanelMaster.add(playButtonMaster);
        trackPanelMaster.add(pauseButtonMaster);
        trackPanelMaster.add(clearButtonMaster);
        trackPanelMaster.add(saveButtonMaster);
        trackPanelMaster.add(openButtonMaster);

        content.setLayout(new BoxLayout(content, 1));
        content.add(new TrackGUI(track1, trackMaster).getTrackPanel());
        content.add(Box.createRigidArea(new Dimension(0,10)));
        content.add(new TrackGUI(track2, trackMaster).getTrackPanel());
        content.add(Box.createRigidArea(new Dimension(0,10)));
        content.add(new TrackGUI(track3, trackMaster).getTrackPanel());
        content.add(Box.createRigidArea(new Dimension(0,10)));
        content.add(new TrackGUI(track4, trackMaster).getTrackPanel());
        content.add(Box.createRigidArea(new Dimension(0,20)));
        content.add(trackPanelMaster);


        f.pack();
        f.setVisible(true);
    }
}
