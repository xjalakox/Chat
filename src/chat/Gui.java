package chat;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Gui{

	private JLabel Background;
	public static JTextField Username_field;
	public static String username;
	public JPasswordField password_field;
	public JButton login;
	public JLabel register;
	
	
	
	public Gui(){
		
		BufferedImage bg = null;
		BufferedImage windowIcon = null;
		try {
			bg = ImageIO.read(ResourceLoader.load("/Login.png"));
			windowIcon = ImageIO.read(ResourceLoader.load("/chat32x32.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JFrame Mainframe = new JFrame("WeChat");
		Mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Mainframe.setIconImage(windowIcon);
		Mainframe.setSize(800, 600);
		Mainframe.setLocationRelativeTo(null);
		Mainframe.setResizable(false);
		Mainframe.setVisible(true);
		
		JLabel Background = new JLabel(new ImageIcon(bg));
		Background.setBounds(0, 0, 800, 600);

		JTextField Username_field = new JTextField("Benutzername"); 
		Username_field.setBounds(290,220,230,40);
		Username_field.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	Username_field.setText("");
            }
        });
		
		JButton login = new JButton("Login");
		login.setBounds(290,410,230,40);
		login.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	            	System.out.println(Username_field.getText());
	            	username = Username_field.getText();
	            	Client c = new Client();
	            	c.createGUI();
	            	Mainframe.dispose();
	            }
	        }); 
		
		
		JPasswordField password_field = new JPasswordField("Passwort"); 
		password_field.setBounds(290,310,230,40);
		password_field.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	password_field.setText("");
            }
        });
		
		
		JLabel register = new JLabel("Noch kein Mitglied? Registriere dich hier!");
		register.setBounds(290,480,235,100);
		register.setVisible(true);
		register.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
			      if (e.getClickCount() > 0) {
			          if (Desktop.isDesktopSupported()) {
			                Desktop desktop = Desktop.getDesktop();
			                try {
			                    URI uri = new URI("www.java-pokemon.tk");
			                    desktop.browse(uri);
			                } catch (IOException ex) {
			                    ex.printStackTrace();
			                } catch (URISyntaxException ex) {
			                    ex.printStackTrace();
			                }
			        }
			      }
			   }
			});
		
		
		Mainframe.add(Username_field);
		Mainframe.add(password_field);
		Mainframe.add(register);
		Mainframe.add(login);
		Mainframe.add(Background);
		
		Mainframe.repaint();

		
	}
}
