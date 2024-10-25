package views;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final String ICON_PATH = "/img/Icon.png";
	private static final String TITLE = "Tu compra app";
	private static final int HEIGHT = 700;
	private static final int WIDTH = 700;
	private MainPanel mainPanel;

	public MainWindow(ActionListener listener) throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setTitle(TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ICON_PATH)).getImage());
		mainPanel = new MainPanel(listener); 
		add(mainPanel);
		
		setJMenuBar(new JMmainMenu(listener));
		setVisible(true);
	}

}
