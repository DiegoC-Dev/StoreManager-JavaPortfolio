package views;

import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.Order;

public class OrderPanel extends JPanel{
	
	private JPTableElements jpTableElements;
//	private JPtable jPtable;
		
	public OrderPanel(ActionListener listener) throws IOException {
		setLayout(new BorderLayout());
		init(listener);
	}

	private void init(ActionListener listener) throws IOException {
		
		jpTableElements = new JPTableElements(listener);
		this.add(jpTableElements, BorderLayout.CENTER);
	}
	
	public void repaintTable(ArrayList<Order> userList) {
		jpTableElements.repaintTable(userList);
	}
}