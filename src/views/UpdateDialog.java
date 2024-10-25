package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.Product;
import models.Store;
import presenters.Event;

//import models.Product;
//import models.Store;
//import presenters.Event;

public class UpdateDialog extends JDialog{
	private static final String TXT_UPDATE = "Update";
	private static final String SELECT_CODE = "Seleccione el codigo para actualizar";
	private static final String TXT_IMG = "Arrasre la imagen aca";
	private static final String TXT_TYPE_PRICE = "Digite el precio";
	private static final String TXT_ADD = "Add";
	private static final String TXT_TYPE_YOUR_PROVIDER = "Digite proveedor";
	private static final String TXT_TYPE_YOUR_NAME = "Digite el nombre";
	private static final int SIZE = 500;
	private JTextField txName;
	private JTextArea txImg;
	private JTextField txPrice;
	private JTextField txProvider;
	private JComboBox<String> nameBox;

	private static final Color COLOR_LIGTH_GRAY = Color.decode("#969696");
	private static final Border BTN_LINE_BORDER = BorderFactory.createLineBorder(
			COLOR_LIGTH_GRAY, 1, true);
	public static final Color COLOR_GRAY = Color.decode("#BDBDBD");
	public static final Font MAIN_FONT = new Font("Arial", Font.PLAIN, 25);
	public UpdateDialog(ActionListener listener, ArrayList<Product> list) {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		setSize(SIZE, SIZE);
		setModal(true);
		setBackground(COLOR_GRAY);
		init(listener, list);
	}

	private void init(ActionListener listener,ArrayList<Product> list) {
		String[] nameList=new String[list.size()];
		for (int i = 0; i < nameList.length; i++) {
			nameList[i] = ""+list.get(i).getId();
		}
		nameBox = new JComboBox(nameList);
		nameBox.setBorder(BorderFactory.createTitledBorder(SELECT_CODE));
		nameBox.setSelectedIndex(0);
		nameBox.addActionListener(listener);
		add(nameBox);
		
		txName = new JTextField();
		txName.setBorder(BorderFactory.createTitledBorder(TXT_TYPE_YOUR_NAME));
		add(txName);

		txPrice = new JTextField();
		txPrice.setBorder(BorderFactory.createTitledBorder(TXT_TYPE_PRICE));
		add(txPrice);
	
		txProvider = new JTextField();
		txProvider.setBorder(BorderFactory.createTitledBorder(TXT_TYPE_YOUR_PROVIDER));
		add(txProvider);
		
		txImg = new JTextArea();
		txImg.setBorder(BorderFactory.createTitledBorder(TXT_IMG));
		txImg.setDropTarget(new DropTarget() {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("unchecked")
			public synchronized void drop(DropTargetDropEvent evt) {
		        try {
		            evt.acceptDrop(DnDConstants.ACTION_COPY);
		            List<File> droppedFiles = (List<File>)evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
		            for (File file : droppedFiles) {
		                txImg.setText(file.getPath());
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		add(txImg);
		
		JPanel panelButtons = new JPanel(new GridLayout(1, 1));
//		JButton btnBuy = new JButton(new ImageIcon(getClass().getResource(BUY_ICON_PATH)));
		JButton btnUpdate = new JButton(TXT_UPDATE);
		btnUpdate.addActionListener(listener);
		btnUpdate.setToolTipText(TXT_ADD);
		btnUpdate.setBackground(COLOR_GRAY);
		btnUpdate.setActionCommand(Event.UPDATE_PRODUCT.toString());
		btnUpdate.setFont(MAIN_FONT);
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(BTN_LINE_BORDER);
		panelButtons.add(btnUpdate);
		add(panelButtons, BorderLayout.PAGE_END);
		
	}
	//surerencias -------instalar y crear en el presentador
	//conectar la ventana con el evento 
	//editar la ventana, cambiar evento del boton
	//editar el metodo get de la ventana
	//agrgar el metodo crate en el modelo
	//agregar add en el presentador como metodo del evento del boton 
	//agegar add al presentador (metodo de el boton)
	///// pasar la lista por medio del refresh a el init del panel objetivo
	
	
	public Product getProduct() throws NumberFormatException, IOException, URISyntaxException {
		return Store.updateProduct(txName.getText(), Integer.parseInt(txPrice.getText()), 
				txProvider.getText(), txImg.getText(), 
				Integer.parseInt(nameBox.getSelectedItem().toString()));
//		NameBox.getSelectedItem().toString();//permite retornar la seleccion
	}
	public int getIndex() {
		System.out.println("posicion en el vector"+(Integer.parseInt(nameBox.getSelectedItem().toString())-1));
		return Integer.parseInt(nameBox.getSelectedItem().toString())-1;
	}
	
	public void cleanForm() {
		txName.setText("");
		txPrice.setText("");
		txProvider.setText("");
		txImg.setText("");
	}
	/// 1 ). Modificar getProduct()
	//  2 ). Agregar en el modelo createProduct y addProduct
//	public void addProduct(Product product) {
//		productList.add(product);
//	}
//	
//	public static Product createProduct(String name,int price,String provider , String file) throws IOException, URISyntaxException {
//		String path = "./db/img/" + Product.idCounter+1
//				+ file.substring(file.lastIndexOf("."), file.length());
//		Files.copy(Paths.get(file), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
//		return new Product(name, price, provider, path);
//	}
	
	/// 3 ). Crear e instanciar en el presentador
	/// 4 ). Dar visibilidad en la accion del presentador (action perform)(SHOW DIALOG)
	
	/// 5 ). copiar en presentador y agregar al evento del boton add
//	private void addProduct() {
//		try {
//			Product product = addDialog.getProduct();
//			store.addProduct(product);
//			addDialog.setVisible(false);
//			addDialog.cleanForm();
//			refreshList();
//			///// pasar la lista por medio del refresh a el init del panel objetivo
//		} catch (NumberFormatException | IOException | URISyntaxException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	private void refreshList() {
//		FileManager.write(store.getProductList());
//		pursacheWindow.refreshProducts(this, store.getProductList(), store.getClientList());
//	}
	
	///// Ageragar al init del panel objetivo
//	removeAll();//agregar al inicio
//	revalidate();//agregar al final
}


