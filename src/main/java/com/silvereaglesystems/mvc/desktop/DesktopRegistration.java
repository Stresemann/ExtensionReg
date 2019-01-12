package com.silvereaglesystems.mvc.desktop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.silvereaglesystems.mvc.models.Client;
import com.silvereaglesystems.mvc.models.Extension;
import com.silvereaglesystems.mvc.services.RegisterService;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;

public class DesktopRegistration {

	private JFrame frame;
	JLabel l1, l2, l3, l4;
	 JTextField tf1, tf2;
	 JButton btn1;
	 JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void showRegistration() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesktopRegistration window = new DesktopRegistration();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesktopRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		JFrame frame = new JFrame("Login Form");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  l1 = new JLabel("Enter your vCenter Information");
		  l1.setForeground(Color.blue);
		  l1.setFont(new Font("Serif", Font.BOLD, 20));
		 
		  l2 = new JLabel("Username");
		  l3 = new JLabel("Password");
		  l4 = new JLabel("vCenter Url");
		  tf1 = new JTextField();
		  tf2 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Login");
		 
		  l1.setBounds(100, 30, 400, 30);
		  l2.setBounds(80, 70, 200, 30);
		  l3.setBounds(80, 110, 200, 30);
		  l4.setBounds(80, 150, 200, 30);
		  tf1.setBounds(300, 70, 200, 30);
		  tf2.setBounds(300, 150, 200, 30);
		  p1.setBounds(300, 110, 200, 30);
		  btn1.setBounds(150, 190, 100, 30);
		 
		  frame.add(l1);
		  frame.add(l2);
		  frame.add(tf1);
		  frame.add(tf2);
		  frame.add(l3);
		  frame.add(l4);
		  frame.add(p1);
		  frame.add(btn1);
		 
		  frame.setSize(600, 400);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  btn1.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	registerPlugin(tf1.getText(), tf2.getText(), p1.getText());
			    }
			});
	}

	private void registerPlugin(String username, String password, String url) {
		Extension extension = new Extension();
		extension.setKey("1.0.0");
		extension.setVersion("1.0.0");
		RegisterService registerService = new RegisterService();
		Client client = new Client();
    	client.setUrl("https://www.google.com/");
    	extension.setClient(client);
    	registerService.pluginAction(extension, "registerPlugin", url, username, password);
	}
}
