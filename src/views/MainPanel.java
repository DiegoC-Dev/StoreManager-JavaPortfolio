package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import presenters.Event;

public class MainPanel extends JPanel{
	
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
	
	public MainPanel(ActionListener listener) throws IOException {
		setLayout(new BorderLayout());
		setBackground(COLOR_GREEN);
		init(listener);
		setVisible(true);
	}

	private void init(ActionListener listener) throws IOException {
//		JMmainMenu jMmainMenu = new JMmainMenu(listener);
//		add(jMmainMenu,BorderLayout.NORTH);
		
		JLabel lbImg = new JLabel();
		Image image= new ImageIcon(getClass().getResource(MAIN_IMG)).getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH);
		lbImg.setIcon(new ImageIcon(image));
		lbImg.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbImg, BorderLayout.CENTER);
		
		createButtonBar(listener);
	}
	
	private void createButtonBar(ActionListener listener) throws IOException {
		JPanel panelButtons = new JPanel(new GridLayout(1, 2));
		
		JButton btnBuy = new JButton(new ImageIcon(getClass().getResource(BUY_ICON_PATH)));
		btnBuy.addActionListener(listener);
		btnBuy.setToolTipText(TXT_BUY);
		btnBuy.setBackground(COLOR_GRAY);
		btnBuy.setActionCommand(Event.PURSACHE_MENU.toString());
		btnBuy.setFont(MAIN_FONT);
		btnBuy.setFocusable(false);
		btnBuy.setBorder(BTN_LINE_BORDER);
		panelButtons.add(btnBuy);
		
		JButton btnOrder = new JButton(new ImageIcon(getClass().getResource(ORDER_ICON_PATH)));
		btnOrder.addActionListener(listener);
		btnOrder.setToolTipText(TXT_ORDER);
		btnOrder.setBackground(COLOR_GRAY);
		btnOrder.setActionCommand(Event.ORDER_MENU.toString());
		btnOrder.setFont(MAIN_FONT);
		btnOrder.setFocusable(false);
		btnOrder.setBorder(BTN_LINE_BORDER);
		panelButtons.add(btnOrder);
		
		add(panelButtons, BorderLayout.PAGE_END);
	}
}
