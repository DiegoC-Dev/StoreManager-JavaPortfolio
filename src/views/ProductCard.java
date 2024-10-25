package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import models.Product;
import presenters.Event;

public class ProductCard extends JPanel{

	private static final Color COLOR_LIGTH_GRAY = Color.decode("#969696");
	private static final Border BTN_LINE_BORDER = BorderFactory.createLineBorder(
			COLOR_LIGTH_GRAY, 1, true);
	public static final Color COLOR_RED = Color.decode("#ef5734");
	public static final Color COLOR_GREEN = Color.decode("#2baf2b");
	public static final Color COLOR_GRAY = Color.decode("#BDBDBD");
	public static final Font MAIN_FONT = new Font("Arial", Font.PLAIN, 25);
	private static final long serialVersionUID = 1L;
	private static final String TXT_LIKE = "Like";
	private static final String TXT_BUY = "Comprar";
	private static final String LIKE_ICON_PATH = "/img/like.png";
	private static final String DISLIKE_ICON_PATH = "/img/dislike.png";
	private static final String BUY_ICON_PATH = "/img/Buy.png";
	
	public ProductCard(ActionListener listener, Product product) {
		setLayout(new BorderLayout());
		setBackground(COLOR_GRAY);
		
		CentralComponents(product);
//		add(lbImg);

//		switch (profile.getStatus()) {
//			case NEW:
//				createButtonBar(listener, profile);
//				break;
//			case LIKE:
//				setBackground(COLOR_GREEN);
//				break;
//			case DISLIKE:
//				setBackground(COLOR_RED);
//				break;
//		}
		createButtonBar(listener, product);
	}

	private void CentralComponents(Product product) {
		JPanel centralPanel = new JPanel(new GridLayout(2, 1));

		JLabel lbImg = new JLabel();
		Image image= new ImageIcon(product.getImgPath()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lbImg.setIcon(new ImageIcon(image));
		lbImg.setHorizontalAlignment(SwingConstants.CENTER);
		centralPanel.add(lbImg);
		
		createLabelsBar(product, centralPanel);
		

		add(centralPanel);
	}

	private void createLabelsBar(Product product, JPanel centralPanel) {
		JPanel panel = new JPanel(new GridLayout(3, 1));
		
		JLabel lbName = new JLabel(""+product.getName(),SwingConstants.CENTER);
		lbName.setFont(MAIN_FONT);
		lbName.setForeground(Color.BLUE);
		panel.add(lbName,BorderLayout.CENTER);
		
		JLabel lbId = new JLabel(""+product.getPrice(),SwingConstants.CENTER);
		lbId.setFont(MAIN_FONT);
		lbId.setForeground(Color.BLACK);
		panel.add(lbId);

		JLabel lbPath = new JLabel(""+product.getProvider(),SwingConstants.CENTER);
		lbPath.setFont(MAIN_FONT);
		lbPath.setForeground(Color.BLACK);
		panel.add(lbPath);

		centralPanel.add(panel);
	}

	private void createButtonBar(ActionListener listener, Product product) {
		JPanel panelButtons = new JPanel(new GridLayout(1, 2));
		
		JButton btnBuy = new JButton(new ImageIcon(getClass().getResource(BUY_ICON_PATH)));
//		JButton btnBuy = new JButton(TXT_BUY);
		btnBuy.addActionListener(listener);
		btnBuy.setToolTipText(TXT_BUY);
		btnBuy.setBackground(COLOR_GRAY);
		btnBuy.setActionCommand(Event.BUY.toString());
		btnBuy.setName(String.valueOf(product.getId()));
		btnBuy.setFont(MAIN_FONT);
		btnBuy.setFocusable(false);
		btnBuy.setBorder(BTN_LINE_BORDER);
		panelButtons.add(btnBuy);
		
		add(panelButtons, BorderLayout.PAGE_END);
	}
}