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
		
		JFrame f = new JFrame("MCBE@");
		PlayerCanvas PC = new PlayerCanvas(); //Canvas for frame
		
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
