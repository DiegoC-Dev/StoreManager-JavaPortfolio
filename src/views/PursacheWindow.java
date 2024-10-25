package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import models.Client;
import models.Product;

public class PursacheWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final String ICON_PATH = "/img/Icon.png";
	private static final String TITLE = "Compras";
	private static final int HEIGHT = 700;
	private static final int WIDTH = 700;
	private PursachePanel pursachePanel;
	
	public PursacheWindow(ActionListener listener, ArrayList<Product> productList,
			ArrayList<Client> clientList) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setTitle(TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ICON_PATH)).getImage());
		
		pursachePanel = new PursachePanel(listener,productList,clientList); 
		add(pursachePanel);
		
	}
	
	public String getClientName() {
		return pursachePanel.getClientName();
	}
	
	public void refreshProducts(ActionListener listener,ArrayList<Product> productList,
			ArrayList<Client> clientList){
		pursachePanel.init(listener, productList, clientList);
	}

}