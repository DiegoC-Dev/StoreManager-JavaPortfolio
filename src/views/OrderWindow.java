package views;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.Order;

public class OrderWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String ICON_PATH = "/img/icon.png";
	private static final String TITLE = "Ordenes";
	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;
	private OrderPanel orderPanel;
	
	public OrderWindow(ActionListener listener) throws IOException {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITLE);
//		setIconImage(new ImageIcon(getClass().getResource(ICON_PATH)).getImage());
		
//		setJMenuBar(new MenuBar(lister));
		
		orderPanel = new OrderPanel(listener);
//		add(orderPanel, BorderLayout.CENTER);
		add(orderPanel);
		WindowUtils.configureAdaptiveBounds(this, WIDTH, HEIGHT);
	}
	public void repaintTable(ArrayList<Order> userList) {
		orderPanel.repaintTable(userList);
	}
}