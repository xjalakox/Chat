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
	
	public JFrame Mainframe;
	public JPanel Mainpanel;
	public JLabel Mainlabel;

	

	Dimension minimumSize = new Dimension(100, 50);
	
	public Menu(){
		
		/////////////////////////////IMAGES//////////////////////////////////////////
		
		BufferedImage mainpanel_bf = null;
		
		try {
			mainpanel_bf = ImageIO.read(ResourceLoader.load("/Mainpanel.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		///////////////////////////MAIN COMPONENTS///////////////////////////////////
		
		JFrame Mainframe = new JFrame("WeChat");
		Mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Mainframe.setSize(1200, 800);
		Mainframe.setLocationRelativeTo(null);
		Mainframe.setResizable(false);
		Mainframe.setVisible(true);
		
		Color red = new Color(241, 196, 15);
		
		JPanel Mainpanel = new JPanel();
		Mainpanel.setBounds(0,0,1200,800);
		Mainpanel.setBackground(red);
		
		JLabel Mainlabel = new JLabel(new ImageIcon(mainpanel_bf));
		Mainlabel.setBounds(0,0,1200,800);

		////////////////////////////OTHER COMPONENTS////////////////////////////////////

		
		
		Mainframe.add(Mainpanel);
		Mainpanel.add(Mainlabel);
		Mainframe.repaint();

	}
	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}
