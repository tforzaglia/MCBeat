/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcbe;

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

        JButton playButton1 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton1 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton1 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton1 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton pushButton1 = new JButton(new ImageIcon("sketchBlackPush.png"));
        Canvas track1Display = new TrackDisplay(track1);

        pauseButton1.addActionListener(new PauseButtonActionListener(track1));
        playButton1.addActionListener(new PlayButtonActionListener(track1));
        recordButton1.addActionListener(new RecordButtonActionListener(track1));
        stopRecButton1.addActionListener(new StopRecButtonActionListener(track1));
        pushButton1.addActionListener(new PushButtonActionListener(track1, trackMaster));

        JPanel trackPanel1 = new JPanel();
        trackPanel1.setLayout(new BoxLayout(trackPanel1, 0));

        trackPanel1.add(recordButton1);
        trackPanel1.add(stopRecButton1);
        trackPanel1.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel1.add(playButton1);
        trackPanel1.add(pauseButton1);
        trackPanel1.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel1.add(track1);
        trackPanel1.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel1.add(pushButton1);


        JButton playButton2 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton2 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton2 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton2 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton pushButton2 = new JButton(new ImageIcon("sketchBlackPush.png"));
        Canvas track2Display = new TrackDisplay(track2);

        playButton2.addActionListener(new PlayButtonActionListener(track2));
        pauseButton2.addActionListener(new PauseButtonActionListener(track2));
        recordButton2.addActionListener(new RecordButtonActionListener(track2));
        stopRecButton2.addActionListener(new StopRecButtonActionListener(track2));
        pushButton2.addActionListener(new PushButtonActionListener(track2, trackMaster));

        JPanel trackPanel2 = new JPanel();
        trackPanel2.setLayout(new BoxLayout(trackPanel2, 0));
        trackPanel2.add(recordButton2);
        trackPanel2.add(stopRecButton2);
        trackPanel2.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel2.add(playButton2);
        trackPanel2.add(pauseButton2);
        trackPanel2.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel2.add(track2Display);
        trackPanel2.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel2.add(pushButton2);

        JButton playButton3 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton3 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton3 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton3 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton pushButton3 = new JButton(new ImageIcon("sketchBlackPush.png"));
        Canvas track3Display = new TrackDisplay(track3);



        playButton3.addActionListener(new PlayButtonActionListener(track3));
        pauseButton3.addActionListener(new PauseButtonActionListener(track3));
        recordButton3.addActionListener(new RecordButtonActionListener(track3));
        stopRecButton3.addActionListener(new StopRecButtonActionListener(track3));
        pushButton3.addActionListener(new PushButtonActionListener(track3, trackMaster));

        JPanel trackPanel3 = new JPanel();
        trackPanel3.setLayout(new BoxLayout(trackPanel3, 0));
        trackPanel3.add(recordButton3);
        trackPanel3.add(stopRecButton3);
        trackPanel3.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel3.add(playButton3); 
        trackPanel3.add(pauseButton3);
        trackPanel3.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel3.add(track3Display);
        trackPanel3.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel3.add(pushButton3);

        JButton playButton4 = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton4 = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton4 = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton4 = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton pushButton4 = new JButton(new ImageIcon("sketchBlackPush.png"));
        Canvas track4Display = new TrackDisplay(track4);


        playButton4.addActionListener(new PlayButtonActionListener(track4));
        pauseButton4.addActionListener(new PauseButtonActionListener(track4));
        recordButton4.addActionListener(new RecordButtonActionListener(track4));
        stopRecButton4.addActionListener(new StopRecButtonActionListener(track4));
        pushButton4.addActionListener(new PushButtonActionListener(track4, trackMaster));

        JPanel trackPanel4 = new JPanel();
        trackPanel4.setLayout(new BoxLayout(trackPanel4, 0));
        trackPanel4.add(recordButton4);
        trackPanel4.add(stopRecButton4);
        trackPanel4.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel4.add(playButton4);
        trackPanel4.add(pauseButton4);
        trackPanel4.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel4.add(track4Display);
        trackPanel4.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel4.add(pushButton4);

        JButton playButtonMaster = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton pauseButtonMaster = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton clearButtonMaster = new JButton(new ImageIcon("sketchBlackClear.png"));

        playButtonMaster.addActionListener(new PlayButtonActionListener(trackMaster));
        pauseButtonMaster.addActionListener(new PauseButtonActionListener(trackMaster));
        clearButtonMaster.addActionListener(new ClearButtonActionListener(trackMaster));


        JPanel trackPanelMaster = new JPanel();
        trackPanelMaster.setLayout(new BoxLayout(trackPanelMaster, 0));
        trackPanelMaster.add(playButtonMaster);
        trackPanelMaster.add(pauseButtonMaster);
     
        trackPanelMaster.add(clearButtonMaster);


        content.setLayout(new BoxLayout(content, 1));
        content.add(trackPanel1);
        content.add(Box.createRigidArea(new Dimension(0,10)));
        content.add(trackPanel2);
        content.add(Box.createRigidArea(new Dimension(0,10)));
        content.add(trackPanel3);
        content.add(Box.createRigidArea(new Dimension(0,10)));
        content.add(trackPanel4);
        content.add(Box.createRigidArea(new Dimension(0,20)));
        content.add(trackPanelMaster);


        f.pack();
        f.setVisible(true);
    }
}
