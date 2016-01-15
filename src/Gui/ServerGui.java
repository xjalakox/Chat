package Gui;

import java.awt.Desktop;
import java.awt.GridLayout;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import chat.Client;
import chat.ResourceLoader;
import chat.Server;

public class ServerGui implements ActionListener{
	
	public JFrame Mainframe;
	
	public JButton start;
	public JButton stop;	
	public JLabel statuslabel;
	///////////////////////////////


	
	public ServerGui(){
		
		Mainframe = new JFrame("WeChat");
		Mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Mainframe.setLayout(new GridLayout(3,1));
		Mainframe.setSize(400, 300);
		Mainframe.setLocationRelativeTo(null);
		Mainframe.setResizable(false);
		Mainframe.setVisible(true);
		

		statuslabel = new JLabel("", SwingConstants.CENTER);
		
		start = new JButton("Server starten");
		start.addActionListener(this);
		
		stop = new JButton("Server stoppen");
		stop.addActionListener(this);
		
		
		
		
		

		
		
		Mainframe.add(start);
		Mainframe.add(stop);
		Mainframe.add(statuslabel);
		
		Mainframe.repaint();
	}
	
	
	
	public static void main(String args[]){
		ServerGui gui = new ServerGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			statuslabel.setText("Server an!");
			start.setEnabled(false);
	    	Server.start();
		}
    	if(e.getSource() == stop) {
    		statuslabel.setText("Server aus!");
    		Server.stop();
    	}
	}
}