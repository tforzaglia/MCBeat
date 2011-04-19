
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BoxLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Beat_Main implements WindowListener {

    /**
     * @param args
     */
    public static void main(String[] args) {

        JFrame f = new JFrame("MCBE@");
        PlayerCanvas PC = new PlayerCanvas(); //Canvas for frame
        Music recorder = new Music();

        JMenuBar menuBar = new JMenuBar();
        f.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem saveFile = new JMenuItem("Save File...");
        fileMenu.add(saveFile);
        JMenuItem openFile = new JMenuItem("Open File...");
        fileMenu.add(openFile);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new CloseWindow());
        fileMenu.add(exit);

        Container content = f.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());
        
        // 5 sets of of buttons
        JButton playButton1 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton1 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton1 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton1 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton playAllButton1 = new JButton(new ImageIcon("sketchBlackPush.png"));
        
        JButton playButton2 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton2 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton2 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton2 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton playAllButton2 = new JButton(new ImageIcon("sketchBlackPush.png"));
        
        JButton playButton3 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton3 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton3 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton3 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton playAllButton3 = new JButton(new ImageIcon("sketchBlackPush.png"));

        JButton playButton4 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton4 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton4 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton4 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton playAllButton4 = new JButton(new ImageIcon("sketchBlackPush.png"));

        // these are the ActionListeners for our four sets of buttons
//        playButton1.addActionListener(new playButtonActionListener(recorder));
//        stopRecButton1.addActionListener(new stopRecButtonActionListener(recorder));
//        recordButton1.addActionListener(new recordButtonActionListener(recorder));
//        pauseButton1.addActionListener(new pauseButtonActionListener(recorder));
//        playAllButton1.addActionListener(new playAllButtonActionListener(recorder));
//        
//        playButton2.addActionListener(new playButtonActionListener(recorder));
//        stopRecButton2.addActionListener(new stopRecButtonActionListener(recorder));
//        recordButton2.addActionListener(new recordButtonActionListener(recorder));
//        pauseButton2.addActionListener(new pauseButtonActionListener(recorder));
//        playAllButton2.addActionListener(new playAllButtonActionListener(recorder));
//
//        playButton3.addActionListener(new playButtonActionListener(recorder));
//        stopRecButton3.addActionListener(new stopRecButtonActionListener(recorder));
//        recordButton3.addActionListener(new recordButtonActionListener(recorder));
//        pauseButton3.addActionListener(new pauseButtonActionListener(recorder));
//        playAllButton3.addActionListener(new playAllButtonActionListener(recorder));
//        
//        playButton4.addActionListener(new playButtonActionListener(recorder));
//        stopRecButton4.addActionListener(new stopRecButtonActionListener(recorder));
//        recordButton4.addActionListener(new recordButtonActionListener(recorder));
//        pauseButton4.addActionListener(new pauseButtonActionListener(recorder));
//        playAllButton4.addActionListener(new playAllButtonActionListener(recorder));
 
        JPanel trackPanel1 = new JPanel();
        trackPanel1.setLayout(new BoxLayout(trackPanel1, 0));
        trackPanel1.setBackground(Color.WHITE);
        trackPanel1.add(recordButton1);
        trackPanel1.add(Box.createRigidArea(new Dimension(10,0))); // adds spacing between each button
        trackPanel1.add(stopRecButton1);
        trackPanel1.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel1.add(pauseButton1);
        trackPanel1.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel1.add(playButton1);
        trackPanel1.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel1.add(playAllButton1);
        
        JPanel trackPanel2 = new JPanel();
        trackPanel2.setLayout(new BoxLayout(trackPanel2, 0));
        trackPanel2.setBackground(Color.WHITE);
        trackPanel2.add(recordButton2);
        trackPanel2.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel2.add(stopRecButton2);
        trackPanel2.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel2.add(pauseButton2);
        trackPanel2.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel2.add(playButton2);
        trackPanel2.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel2.add(playAllButton2);
        
        JPanel trackPanel3 = new JPanel();
        trackPanel3.setLayout(new BoxLayout(trackPanel3, 0));
        trackPanel3.setBackground(Color.WHITE);
        trackPanel3.add(recordButton3);
        trackPanel3.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel3.add(stopRecButton3);
        trackPanel3.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel3.add(pauseButton3);
        trackPanel3.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel3.add(playButton3);
        trackPanel3.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel3.add(playAllButton3);
        
        JPanel trackPanel4 = new JPanel();
        trackPanel4.setLayout(new BoxLayout(trackPanel4, 0));
        trackPanel4.setBackground(Color.WHITE);
        trackPanel4.add(recordButton4);
        trackPanel4.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel4.add(stopRecButton4);
        trackPanel4.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel4.add(pauseButton4);
        trackPanel4.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel4.add(playButton4);
        trackPanel4.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel4.add(playAllButton4);
        
        // lays out the 5 sets of buttons on to the container
        content.setLayout(new BoxLayout(content, 1));
        content.add(trackPanel1);
        content.add(Box.createRigidArea(new Dimension(0,25))); // adds spacing between each container
        content.add(trackPanel2);
        content.add(Box.createRigidArea(new Dimension(0,25)));
        content.add(trackPanel3);
        content.add(Box.createRigidArea(new Dimension(0,25)));
        content.add(trackPanel4);

        f.pack();
        f.setVisible(true);
        f.addWindowListener(new Beat_Main());

    }

    /*
     * These methods are automatically required below to add a
     * window listener for when the "X" on the frame is pressed
     * the program closes.
     */
    @Override
    public void windowClosing(WindowEvent arg0) {
        System.exit(0);
    }
    @Override
    public void windowActivated(WindowEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void windowClosed(WindowEvent arg0) {
        // TODO Auto-generated method stub	
    }
    @Override
    public void windowDeactivated(WindowEvent arg0) {
        // TODO Auto-generated method stub	
    }
    @Override
    public void windowDeiconified(WindowEvent arg0) {
        // TODO Auto-generated method stub	
    }
    @Override
    public void windowIconified(WindowEvent arg0) {
        // TODO Auto-generated method stub	
    }
    @Override
    public void windowOpened(WindowEvent arg0) {
        // TODO Auto-generated method stub	
    }
}
