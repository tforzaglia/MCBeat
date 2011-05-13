import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.Vector;
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
        Vector<Track> tracks = new Vector<Track>();
        //create the 4 initial track objects and the master track
        tracks.add(new Track("Track 1"));
        tracks.add(new Track("Track 2"));
        tracks.add(new Track("Track 3"));
        tracks.add(new Track("Track 4"));


        //create the frame for the GUI
        JFrame f = new JFrame("MCBE@");
        f.setResizable(false);

         Container content = f.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());



        content.setLayout(new BoxLayout(content, 1));
        GUIUpdater g = new GUIUpdater(content, f);
        g.updateGUI(tracks);

        //add exit option to the menu
        JMenuBar menuBar = new JMenuBar();
        f.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem addTrack = new JMenuItem("Add a New Track...");
        fileMenu.add(addTrack);
        addTrack.addActionListener( new AddTrackActionListener(tracks, g));
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        exit.addActionListener(new CloseWindow());
       

        f.pack();
        f.setVisible(true);
    }
}
