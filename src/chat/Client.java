package chat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Gui.Gui;

public class Client {
	
	JFrame clientFrame;
	JPanel clientPanel;
	JTextArea textArea_Messages;
	JTextField textField_ClientMessage;
	JButton button_SendMessage;
	JTextField textField_Username;
	JScrollPane scrollPane_Messages;
	
	Socket client;
	PrintWriter writer;
	BufferedReader reader;
	
	
	public void createGUI() {
		clientFrame = new JFrame("Chat-Room 1 (Default)");
		clientFrame.setSize(800, 600);
		
		clientFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
            	sendQuitMessage();
            	clientFrame.setVisible(false);
            	clientFrame.dispose(); 
                
            }
        });
		
		// Panel erzeugen, welches alle anderen Inhalte enth�lt
		clientPanel = new JPanel();
		
		textArea_Messages = new JTextArea();
		textArea_Messages.setEditable(false);
		
		textField_ClientMessage = new JTextField(38);
		textField_ClientMessage.addKeyListener(new SendPressEnterListener());
		
		button_SendMessage = new JButton("Senden");
		button_SendMessage.addActionListener(new SendButtonListener());
		
		
		// Scrollbalken zur textArea hinzuf�gen
		scrollPane_Messages = new JScrollPane(textArea_Messages);
		scrollPane_Messages.setPreferredSize(new Dimension(700, 500));
		scrollPane_Messages.setMinimumSize(new Dimension(700, 500));
		scrollPane_Messages.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_Messages.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);		
		
		
		if(!connectToServer()) {
			// Connect-Label anzeigen ob verbunden oder nicht...
		}
		
		Thread t = new Thread(new MessagesFromServerListener());
		t.start();
		
		clientPanel.add(scrollPane_Messages);
		clientPanel.add(textField_ClientMessage);
		clientPanel.add(button_SendMessage);
		
		// Panel zum ContentPane (Inhaltsbereich) hinzuf�gen
		clientFrame.getContentPane().add(BorderLayout.CENTER, clientPanel);
		
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);
	}
	
	public boolean connectToServer() {
		try {
			client = new Socket("java-pokemon.tk", 1337);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream());
		//	appendTextMessages("Du bist dem Chat-Room beigetreten");
			sendJoinMessage();
			
			return true;
		} catch(Exception e) {
			appendTextMessages("Netzwerkverbindung konnte nicht hergestellt werden");
			e.printStackTrace();
			
			return false;
		}
	}
	
	public void sendMessageToServer() {
		writer.println(Gui.username + ": " + textField_ClientMessage.getText());
		writer.flush();
		
		textField_ClientMessage.setText("");
		textField_ClientMessage.requestFocus();
	}
	
	public void sendQuitMessage(){
		writer.println(Gui.username + " hat den Chat verlassen.");
		writer.flush();
	}
	
	public void sendJoinMessage(){
		writer.println(Gui.username + " ist dem Chat beigetreten!");
		writer.flush();
	}
	
	public void appendTextMessages(String message) {
		textArea_Messages.append(message + "\n");
	}
	
	// Listener
	public class SendPressEnterListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				sendMessageToServer();
			}	
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}

		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
	
	public class SendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sendMessageToServer();			
		}
		
	}
	
	public class MessagesFromServerListener implements Runnable {

		@Override
		public void run() {
			String message;
			
			try {
				while((message = reader.readLine()) != null) {
					appendTextMessages(message);
					textArea_Messages.setCaretPosition(textArea_Messages.getText().length());
					
				}
			} catch (IOException e) {
				appendTextMessages("Nachricht konnte nicht empfangen werden! Pr�fe deine Internetverbindung oder wende dich an den Support");
				e.printStackTrace();
			}
		}
		
	}
}