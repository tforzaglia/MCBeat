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
import javax.swing.JCheckBox;

/**
 *
 * main driver class for the MCBE@ application
 *  sets up frame, menu bar
 *  creates track objects and master track
 */

public class Main {

    public static void main(String[] args) {

        //create the 4 initial track objects and the master track
        Track track1 = new Track("Track 1");
        Track track2 = new Track("Track 2");
        Track track3 = new Track("Track 3");
        Track track4 = new Track("Track 4");
        Track trackMaster = new Track("Master");

        //create the frame for the GUI
        JFrame f = new JFrame("MCBE@");
        f.setResizable(false);

        //add exit option to the menu
        JMenuBar menuBar = new JMenuBar();
        f.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem addTrack = new JMenuItem("Add a New Track...");
        fileMenu.add(addTrack);
        //addTrack.addActionListener(new AddTrackActionListener());
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        exit.addActionListener(new CloseWindow());
        Container content = f.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());

        //add buttons and checkbox for the master track
        JButton playButtonMaster = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton pauseButtonMaster = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton clearButtonMaster = new JButton(new ImageIcon("sketchBlackTrashClear.png"));
        JButton saveButtonMaster = new JButton(new ImageIcon("sketchBlackSaveFile.png"));
        JButton openButtonMaster = new JButton(new ImageIcon("sketchBlackOpenFile.png"));
        JButton pushButtonMaster = new JButton(new ImageIcon("sketchBlackPush.png"));
        JCheckBox loopMaster = new JCheckBox("Loop");

        //add action listeners for the master track
        playButtonMaster.addActionListener(new PlayButtonActionListener(trackMaster));
        pauseButtonMaster.addActionListener(new PauseButtonActionListener(trackMaster));
        clearButtonMaster.addActionListener(new ClearButtonActionListener(trackMaster));
        pushButtonMaster.addActionListener(new PushFromMasterButtonActionListener(f, trackMaster, track1,track2,track3,track4));
        saveButtonMaster.addActionListener(new SaveButtonActionListener(trackMaster));
        openButtonMaster.addActionListener(new OpenButtonActionListener(trackMaster));
        loopMaster.addActionListener(new LoopCheckBoxActionListener(loopMaster,trackMaster));
        
        //set up the master track layout
        JPanel trackPanelMaster = new JPanel();
        trackPanelMaster.setLayout(new BoxLayout(trackPanelMaster, 0));
        trackPanelMaster.setBackground(Color.WHITE);
        trackPanelMaster.add(playButtonMaster);
        trackPanelMaster.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanelMaster.add(pauseButtonMaster);
        trackPanelMaster.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanelMaster.add(loopMaster);
        trackPanelMaster.add(saveButtonMaster);
        trackPanelMaster.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanelMaster.add(openButtonMaster);
        trackPanelMaster.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanelMaster.add(clearButtonMaster);
        trackPanelMaster.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanelMaster.add(pushButtonMaster);

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
