//Beat Main
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Beat_Main implements WindowListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Frame f = new Frame("MCBE@");
		PlayerCanvas PC = new PlayerCanvas(); //Canvas for frame
		
		MenuBar menuBar = new MenuBar();
		f.setMenuBar(menuBar);
		Menu fileMenu = new Menu("File");
		menuBar.add(fileMenu);
		MenuItem exit = new MenuItem("Exit");
		exit.addActionListener(new CloseWindow());
		fileMenu.add(exit);
		
		f.add(PC);
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
