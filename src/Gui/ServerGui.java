package Gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import chat.Client;
import chat.ResourceLoader;

public class ServerGui{

	public JButton start;
	public JButton stop;	
	
	public ServerGui(){
		
		JFrame Mainframe = new JFrame("WeChat");
		Mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Mainframe.setSize(800, 600);
		Mainframe.setLocationRelativeTo(null);
		Mainframe.setResizable(false);
		Mainframe.setVisible(true);
		

		
		JButton start = new JButton("Server starten");
		start.setBounds(290,410,230,40);
		
		

		
		
		Mainframe.add(start);
		
		Mainframe.repaint();
	}
	
	public static void main(String args[]){
		ServerGui gui = new ServerGui();
	}
}