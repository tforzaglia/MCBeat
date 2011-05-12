import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * class to display the tracks set up by the TrackGUI class
 */

public class TrackDisplay extends Canvas {
    private Track track;

    public TrackDisplay(Track track){
        this.track= track;
        this.setSize(300, 20);
        this.setBackground(Color.gray);
        this.repaint();

    }

    @Override
    public void paint(Graphics g){
        g.setFont(new Font("Courier", Font.PLAIN,  18));
        g.drawString(track.getName(), 5, 25);
    }
}


