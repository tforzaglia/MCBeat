import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JCheckBox;

/**
 *
 * class to set up the tracks with buttons and action listeners
 */

public class TrackGUI {
    private JPanel trackPanel  = new JPanel();

    public TrackGUI(Track track, Track trackMaster){

        //add buttons and checkbox to track display 
        JButton playButton = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton pushButton = new JButton(new ImageIcon("sketchBlackPush.png"));
        JButton deleteButton = new JButton(new ImageIcon("sketchBlackTrashClear.png"));
        JButton saveButton = new JButton(new ImageIcon("sketchBlackSaveFile.png"));
        JButton openButton = new JButton(new ImageIcon("sketchBlackOpenFile.png"));
        JButton renameButton = new JButton(new ImageIcon("sketchBlackRename.png"));
        JCheckBox loopCheckBox = new JCheckBox("Loop");
        JButton removeTrackButton = new JButton(new ImageIcon("sketchBlackRemoveTrack.png"));
        
        //add the volume slider to track display
        JSlider volume = new JSlider();
        volume.setMaximum(7);
        volume.setMinimum(-15);
        
        //add action listeners to buttons, sliders, and checkboxes
        pauseButton.addActionListener(new PauseButtonActionListener(track));
        playButton.addActionListener(new PlayButtonActionListener(track));
        recordButton.addActionListener(new RecordButtonActionListener(track));
        stopRecButton.addActionListener(new StopRecButtonActionListener(track));
        pushButton.addActionListener(new PushButtonActionListener(track, trackMaster));
        deleteButton.addActionListener(new ClearButtonActionListener(track));
        saveButton.addActionListener(new SaveButtonActionListener(track));
        openButton.addActionListener(new OpenButtonActionListener(track));
        renameButton.addActionListener(new RenameButtonActionListener(track));
        volume.addChangeListener(new VolumeSliderChangeListener(track, volume));
        loopCheckBox.addActionListener(new LoopCheckBoxActionListener(loopCheckBox, track));
        //removeTrackButton.addActionListener(new RemoveTrackButtonActionListener(track));

        JPanel volumePanel = new JPanel();
        JLabel volumeLabel = new JLabel("Volume", JLabel.CENTER);
        volumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        volumePanel.add(volumeLabel);
        volumePanel.add(volume);
        volumePanel.setLayout(new BoxLayout(volumePanel, 1));
        volumePanel.setBackground(Color.white);
        trackPanel.setLayout(new BoxLayout(trackPanel, 0));
        trackPanel.setBackground(Color.WHITE);

        trackPanel.add(recordButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(stopRecButton);
        trackPanel.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel.add(new JSeparator(JSeparator.VERTICAL),BorderLayout.LINE_START);
        trackPanel.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel.add(playButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(pauseButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(loopCheckBox);
        trackPanel.add(track);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(volumePanel);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(renameButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(pushButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(saveButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(openButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(deleteButton);
        trackPanel.add(removeTrackButton);

    }

    public JPanel getTrackPanel(){
        return trackPanel;
    }

}
