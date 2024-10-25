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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.Product;
import models.Store;
import presenters.Event;

public class AddDialog extends JDialog{
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

	private static final Color COLOR_LIGTH_GRAY = Color.decode("#969696");
	private static final Border BTN_LINE_BORDER = BorderFactory.createLineBorder(
			COLOR_LIGTH_GRAY, 1, true);
	public static final Color COLOR_GRAY = Color.decode("#BDBDBD");
	public static final Font MAIN_FONT = new Font("Arial", Font.PLAIN, 25);
	public AddDialog(ActionListener listener) {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		setSize(SIZE, SIZE);
		setModal(true);
		setBackground(COLOR_GRAY);
		init(listener);
	}

	private void init(ActionListener listener) {
		
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
		JButton btnBuy = new JButton(TXT_ADD);
		btnBuy.addActionListener(listener);
		btnBuy.setToolTipText(TXT_ADD);
		btnBuy.setBackground(COLOR_GRAY);
		btnBuy.setActionCommand(Event.ADD_PRODUCT.toString());
		btnBuy.setFont(MAIN_FONT);
		btnBuy.setFocusable(false);
		btnBuy.setBorder(BTN_LINE_BORDER);
		panelButtons.add(btnBuy);
		add(panelButtons, BorderLayout.PAGE_END);
		
	}
	
	public Product getProduct() throws NumberFormatException, IOException, URISyntaxException {
		return Store.createProduct(txName.getText(), Integer.parseInt(txPrice.getText()), 
				txProvider.getText(), txImg.getText());
	}
	
	public void cleanForm() {
		txName.setText("");
		txPrice.setText("");
		txProvider.setText("");
		txImg.setText("");
	}
	//surerencias -------instalar y crear en el presentador
		//conectar la ventana con el evento 
		//editar la ventana, cambiar evento del boton
		//editar el metodo get de la ventana
		//agrgar el metodo crate en el modelo
		//agregar add en el presentador como metodo del evento del boton 
		//agegar add al presentador (metodo de el boton)
		///// pasar la lista por medio del refresh a el init del panel objetivo
		
	
	
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
//			FileManager.write(store.getProductList());
//			pursacheWindow.refreshProducts(this, store.getProductList(), store.getClientList());
//			///// pasar la lista por medio del refresh a el init del panel objetivo
//		} catch (NumberFormatException | IOException | URISyntaxException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	///// Ageragar al init del panel objetivo
//	removeAll();//agregar al inicio
//	revalidate();//agregar al final
}


