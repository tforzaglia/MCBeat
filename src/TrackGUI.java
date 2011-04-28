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
        JButton deleteButton = new JButton(new ImageIcon("sketchBlackTrashClear.png"));
        JButton saveButton = new JButton(new ImageIcon("sketchBlackSaveFile.png"));
        JSlider volume = new JSlider();
        JButton openButton = new JButton(new ImageIcon("sketchBlackOpenFile.png"));
        pauseButton.addActionListener(new PauseButtonActionListener(track));
        playButton.addActionListener(new PlayButtonActionListener(track));
        recordButton.addActionListener(new RecordButtonActionListener(track));
        stopRecButton.addActionListener(new StopRecButtonActionListener(track));
        pushButton.addActionListener(new PushButtonActionListener(track, trackMaster));
        deleteButton.addActionListener(new ClearButtonActionListener(track));
        saveButton.addActionListener(new SaveButtonActionListener(track));
        openButton.addActionListener(new OpenButtonActionListener(track));

        volume.addChangeListener(new VolumeSliderChangeListener(track, volume));

        JPanel volumePanel = new JPanel();
        JLabel volumeLabel = new JLabel("Volume", JLabel.CENTER);
        volumeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        volumePanel.add(volumeLabel);
        volumePanel.add(volume);
        volumePanel.setLayout(new BoxLayout(volumePanel, 1));
        volumePanel.setBackground(Color.white);
        trackPanel.setLayout(new BoxLayout(trackPanel, 0));
        Canvas trackDisplay = new TrackDisplay(track);
        trackPanel.setBackground(Color.WHITE);

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
        trackPanel.add(saveButton);
        trackPanel.add(openButton);


    }

    public JPanel getTrackPanel(){
        return trackPanel;
    }

}
