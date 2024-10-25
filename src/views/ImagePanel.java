package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	Image image;
	public ImagePanel(String path) {
		setBackground(Color.green);
		image = (new ImageIcon(path)).getImage();
		// TODO Auto-generated constructor stub
	}
	public void paintComponent (Graphics g){
//        if(image == null) return;
//        int imageWidth = image.getWidth(this);
//        int imageHeight = image.getHeight(this);

//		g.drawImage(image, 50, 50, this);
		g.drawImage(image, (getWidth()-image.getWidth(this))/2, (getHeight()-image.getHeight(this))/2, this);

//        for (int i = 0; i*imageWidth <= getWidth(); i++)
//            for(int j = 0; j*imageHeight <= getHeight();j++)
//                if(i+j>0) g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
    }
//	public void paintBackground(Graphics2D g)
//	{
//	float x = getX();
//	float y = getY();
//	AffineTransform transform = AffineTransform.getTranslateInstance(x,y);
//	Image bg = (new ImageIcon("lol.png")).getImage();
//	g.drawImage(bg, transform, game.getView());
//	}
}
