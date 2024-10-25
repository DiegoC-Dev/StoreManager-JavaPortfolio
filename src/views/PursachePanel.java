package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import models.Client;
import models.Product;

public class PursachePanel extends JPanel{

	private static final String TXT_SELECT_YOUR_PRODUCT = "Seleccione su producto";
	private static final String TXT_SELECT_YOUR_NAME = "Seleccione su nombre";
	private static final Color COLOR_LIGTH_GRAY = Color.decode("#969696");
	private static final Border BTN_LINE_BORDER = BorderFactory.createLineBorder(
			COLOR_LIGTH_GRAY, 1, true);
	public static final Color COLOR_RED = Color.decode("#ef5734");
	public static final Color COLOR_GREEN = Color.decode("#2baf2b");
	public static final Color COLOR_GRAY = Color.decode("#BDBDBD");
	public static final Font MAIN_FONT = new Font("Arial", Font.PLAIN, 25);
	private static final long serialVersionUID = 1L;
	private static final String TXT_ORDER = "Order";
	private static final String TXT_BUY = "Buy";
	private static final String ORDER_ICON_PATH = "/img/Order.png";
	private static final String BUY_ICON_PATH = "/img/Buy.png";
	private static final String MAIN_IMG = "/img/MainImage.png";
	private JComboBox<String> clientNameBox;
	
	public PursachePanel(ActionListener listener, ArrayList<Product> productList, 
			ArrayList<Client> clientList) {
		setLayout(new BorderLayout());
		setBackground(COLOR_GRAY);
		init(listener, productList, clientList);
		setVisible(true);
	}

	public void init(ActionListener listener, ArrayList<Product> productList,
			ArrayList<Client> clientList) {	
		removeAll();
		revalidate();
		createComboBoxSection(clientList);
		createCardsSection(listener, productList);
	}

	private void createCardsSection(ActionListener listener, ArrayList<Product> productList) {
		JPanel panelCenterScrol = new JPanel(new BorderLayout());
		
		JPanel panelCenter = new JPanel(
				new GridLayout(productList.size()%2==0?productList.size()/2:productList.size()/2+1,2));
		
		for (int i = 0; i < productList.size(); i++) {
			ProductCard productCard = new ProductCard(listener,  productList.get(i));
			panelCenter.add(productCard,BorderLayout.CENTER);			
		}
		
		panelCenterScrol.add(panelCenter, BorderLayout.CENTER);
		
		add(new JScrollPane(panelCenterScrol), BorderLayout.CENTER);
	}

	private void createComboBoxSection(ArrayList<Client> clientList) {
		JPanel comboBoxPanel = new JPanel(new GridLayout(3,1));
		
		JLabel lblclientNameList = new JLabel(TXT_SELECT_YOUR_NAME);
		lblclientNameList.setHorizontalAlignment(SwingConstants.CENTER);
		comboBoxPanel.add(lblclientNameList);
		
		String[] clientNameList=new String[clientList.size()];
		for (int i = 0; i < clientNameList.length; i++) {
			clientNameList[i] = clientList.get(i).getName();
		}
		clientNameBox = new JComboBox(clientNameList);
		clientNameBox.setSelectedIndex(0);
		comboBoxPanel.add(clientNameBox);
		
		JLabel lblproductNameList = new JLabel(TXT_SELECT_YOUR_PRODUCT);
		lblproductNameList.setHorizontalAlignment(SwingConstants.CENTER);
		comboBoxPanel.add(lblproductNameList);

		
		add(comboBoxPanel,BorderLayout.NORTH);
	}
		
	public String getClientName() {
		return clientNameBox.getSelectedItem().toString();
	}

}
