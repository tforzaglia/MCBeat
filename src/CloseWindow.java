import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Closes the JFrame using the menu bar
 */
public class CloseWindow implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}