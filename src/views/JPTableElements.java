package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Order;
import presenters.Presenter;

public class JPTableElements extends JPanel{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements; 
	private JTable jtElements;
	private JScrollPane jsTable;

	public JPTableElements(ActionListener listener){
		initComponents();
		setVisible(true);
	}

	public JPTableElements(){

	}

	private void initComponents(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#30373D"));

		dtmElements = new DefaultTableModel();
		changeLanguageColunmJtable();
		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 14);

		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.getTableHeader().setBackground(Color.decode("#282E33"));
		jtElements.getTableHeader().setForeground(Color.white);
		jtElements.getTableHeader().setFont(fontHeader);
		jtElements.setBackground(Color.white);
		jtElements.setBorder(null);

		jsTable = new JScrollPane(jtElements);
		jsTable.setForeground(Color.white);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jsTable, BorderLayout.PAGE_END);
		this.setBorder(null);
	}

	public void changeLanguageColunmJtable(){
		String[] headers = {"Id","Proveedor","Producto","Cliente"};
		dtmElements.setColumnIdentifiers(headers);
		repaint();
	}
	public void repaintTable(ArrayList<Order> userList) {
		removeElements(userList);
		addElements(userList);
	}

	public void addElements(ArrayList<Order> userList) {
		for (int i = 0; i < userList.size(); i++) {
			dtmElements.addRow(userList.get(i).toStringVector());
		}
	}

	private void removeElements(ArrayList<Order> userList) {
		dtmElements.getDataVector().removeAllElements();
	}
}