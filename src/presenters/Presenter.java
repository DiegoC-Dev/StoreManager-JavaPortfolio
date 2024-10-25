package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;

import models.Order;
import models.Product;
import models.Store;
import persistence.FileManager;
import views.AddDialog;
import views.MainWindow;
import views.OrderWindow;
import views.PursacheWindow;
import views.UpdateDialog;

public class Presenter implements ActionListener{
	
	private MainWindow mainWindow;
	private PursacheWindow pursacheWindow;
	private OrderWindow orderWindow;
	private Store store;
	private AddDialog addDialog;
	private UpdateDialog updateDialog;
	public Presenter() {
		try {
			store = new Store();
			updateDialog = new UpdateDialog(this,store.getProductList());
			orderWindow = new OrderWindow(this);
			orderWindow.repaintTable(store.getOrderList());
			pursacheWindow = new PursacheWindow(this,store.getProductList(),
					store.getClientList());
			mainWindow = new MainWindow(this);
			addDialog = new AddDialog(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case PURSACHE_MENU:
			pursacheMenu();
			break;
		case ORDER_MENU:
			orderMenu();
			break;			
		case BUY:
			getBuy(e);
			break;
		case ORDER:
			getOrder();
			break;
		case ADD_PRODUCT:
			addProduct();
			break;
		case UPDATE_PRODUCT:
			updateProduct();
			break;
		case SHOW_ADD_PRODUCT:
			showAddProduct();
			break;
		case SHOW_UPDATE_PRODUCT:
			showUpdateProduct();
			break;
		default:
			break;
		}
	}
	private void updateProduct() {
		try {
			Product product = updateDialog.getProduct();
//			product.setId(id);
			store.setProduct(product,updateDialog.getIndex());//agregar al modelo
			updateDialog.setVisible(false);
			updateDialog.cleanForm();
			refreshList();
			///// pasar la lista por medio del refresh a el init del panel objetivo
		} catch (NumberFormatException | IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	private void refreshList() {
//		FileManager.write(store.getProductList());
		pursacheWindow.refreshProducts(this, store.getProductList(), store.getClientList());
	}

	private void showUpdateProduct() {
		updateDialog.setVisible(true);
	}
	private void showAddProduct() {
		addDialog.setVisible(true);
	}
	private void addProduct() {
		try {
			Product product = addDialog.getProduct();
			store.addProduct(product);
			addDialog.setVisible(false);
			addDialog.cleanForm();
			FileManager.write(store.getProductList());
			pursacheWindow.refreshProducts(this, store.getProductList(), store.getClientList());
//			refreshList();
		} catch (NumberFormatException | IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	private void orderMenu() {
		orderWindow.setVisible(true);
	}
	private void pursacheMenu() {
		pursacheWindow.setVisible(true);
	}
	
	private void getOrder() {
	}
	private void getBuy(ActionEvent e) {
		try {
			store.addOrder(new Order(0,store.searchProduct(getProfileId(e)), 
					store.searchClient(pursacheWindow.getClientName())));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		orderWindow.repaintTable(store.getOrderList());
		pursacheWindow.setVisible(false);
	}
	
	private int getProfileId(ActionEvent e) {
		return Integer.parseInt(((JButton)e.getSource()).getName());
	}
}
