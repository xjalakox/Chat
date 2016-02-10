package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import chat.ResourceLoader;

public class Menu {
	
	public JFrame mainframe;
	public JPanel mainpanel;
	public JLabel mainlabel;
	public JFrame friendlistframe;
	public JPanel friendlistpanel;
	public JLabel friendlistlabel;
	
	int a,b = 0;
	int atemp, btemp = 0;
	
	Color yellow = new Color(241, 196, 15);

	public Menu(){
		
		/////////////////////////////IMAGES///////////////////////////////////////////

		BufferedImage mainpanel_bf = null;
		BufferedImage friendlistpanel_bf = null;
		
		try {
			mainpanel_bf = ImageIO.read(ResourceLoader.load("/Mainpanel.png"));
			friendlistpanel_bf = ImageIO.read(ResourceLoader.load("/friendlist.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		///////////////////////////MAIN COMPONENTS///////////////////////////////////
		
		JFrame mainframe = new JFrame("WeChat");
		mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainframe.setBounds(0,0,1000, 800);
		mainframe.setLocationRelativeTo(null);
		mainframe.setResizable(false);
		mainframe.setVisible(true);
		
		a = mainframe.getX();
		b = mainframe.getY();
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(0,0,1200,800);
		mainpanel.setBackground(yellow);

		JLabel mainlabel = new JLabel(new ImageIcon(mainpanel_bf));
		mainlabel.setBounds(0,0,1200,800);
		

		////////////////////////////OTHER COMPONENTS////////////////////////////////////

		JFrame friendlistframe = new JFrame("Freunde");
		friendlistframe.setBounds(a+995,b,300, 800);
		friendlistframe.setResizable(false);
		friendlistframe.setVisible(true);
		
		JPanel friendlistpanel = new JPanel();
		friendlistpanel.setBounds(0,0,200,800);
		friendlistpanel.setBackground(yellow);
		
		JLabel friendlistlabel = new JLabel(new ImageIcon(friendlistpanel_bf));
		friendlistlabel.setBounds(0,0,200,800);
		
		
		mainframe.add(mainpanel);
		mainpanel.add(mainlabel);
		friendlistframe.add(friendlistpanel);
		friendlistpanel.add(friendlistlabel);
		mainframe.repaint();
		
		
		
		while(true){
			atemp = mainframe.getX();
			btemp = mainframe.getY();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			if(a != atemp)friendlistframe.setBounds(atemp+995, btemp, 300, 800);
			if(b != btemp)friendlistframe.setBounds(atemp+995, btemp, 300, 800);
		}

	}
	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}
