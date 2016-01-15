package Gui;

import java.awt.Color;
import java.awt.Dimension;
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

	Color yellow = new Color(241, 196, 15);
	
	private int x;
	private int y;
	
	public Menu(){
		
		/////////////////////////////IMAGES//////////////////////////////////////////

		BufferedImage mainpanel_bf = null;
		try {
			mainpanel_bf = ImageIO.read(ResourceLoader.load("/Mainpanel.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		///////////////////////////MAIN COMPONENTS///////////////////////////////////
		
		JFrame mainframe = new JFrame("WeChat");
		mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainframe.setBounds(x,y,1000, 800);
		mainframe.setLocationRelativeTo(null);
		mainframe.setResizable(false);
		mainframe.setVisible(true);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(0,0,1200,800);
		mainpanel.setBackground(yellow);
		
		JLabel mainlabel = new JLabel(new ImageIcon(mainpanel_bf));
		mainlabel.setBounds(0,0,1200,800);

		////////////////////////////OTHER COMPONENTS////////////////////////////////////

		JFrame friendlistframe = new JFrame("Friends");
		friendlistframe.setBounds(0,0,300, 800);
		friendlistframe.setLocationRelativeTo(null);
		friendlistframe.setResizable(false);
		friendlistframe.setVisible(true);
		
		JPanel friendlistpanel = new JPanel();
		friendlistpanel.setBounds(0,0,200,800);
		friendlistpanel.setBackground(yellow);
		
		JLabel friendlistlabel = new JLabel(new ImageIcon(mainpanel_bf));
		friendlistlabel.setBounds(0,0,200,800);
		
		mainframe.add(mainpanel);
		mainpanel.add(mainlabel);
		mainframe.repaint();

	}
	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}
