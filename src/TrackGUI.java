package mcbe;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Mazuoyan
 */
public class TrackGUI {
    private JPanel trackPanel  = new JPanel();

    public TrackGUI(Track track, Track trackMaster){

        JButton playButton = new JButton(new ImageIcon("sketchBlackPlay.png"));
        JButton stopRecButton = new JButton(new ImageIcon("sketchBlackStop.png"));
        JButton recordButton = new JButton(new ImageIcon("sketchBlackRecord.png"));
        JButton pauseButton = new JButton(new ImageIcon("sketchBlackPause.png"));
        JButton pushButton = new JButton(new ImageIcon("sketchBlackPush.png"));
        JButton deleteButton = new JButton(new ImageIcon("sketchBlackClear.png"));
        JButton saveButton = new JButton("Save");
        JSlider volume = new JSlider();
         JButton openButton = new JButton("Open");
        pauseButton.addActionListener(new PauseButtonActionListener(track));
        playButton.addActionListener(new PlayButtonActionListener(track));
        recordButton.addActionListener(new RecordButtonActionListener(track));
        stopRecButton.addActionListener(new StopRecButtonActionListener(track));
        pushButton.addActionListener(new PushButtonActionListener(track, trackMaster));
        deleteButton.addActionListener(new ClearButtonActionListener(track));
        openButton.addActionListener(new OpenButtonActionListener(track));
        saveButton.addActionListener(new SaveButtonActionListener(track));

        volume.addChangeListener(new volumeSliderChangeListener(track, volume));

            JPanel volumePanel = new JPanel();
        JLabel volumeLabel = new JLabel("Volume", JLabel.CENTER);
        volumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        volumePanel.add(volumeLabel);
        volumePanel.add(volume);
        volumePanel.setLayout(new BoxLayout(volumePanel, 1));
        trackPanel.setLayout(new BoxLayout(trackPanel, 0));

        trackPanel.add(recordButton);
        trackPanel.add(stopRecButton);
        trackPanel.add(Box.createRigidArea(new Dimension(10,0)));
        trackPanel.add(playButton);
        trackPanel.add(pauseButton);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(track);
        trackPanel.add(Box.createRigidArea(new Dimension(5,0)));
        trackPanel.add(volumePanel);
        trackPanel.add(deleteButton);
        trackPanel.add(pushButton);
        trackPanel.add(openButton);
        trackPanel.add(saveButton);


    }

    public JPanel getTrackPanel(){
        return trackPanel;
    }

}
