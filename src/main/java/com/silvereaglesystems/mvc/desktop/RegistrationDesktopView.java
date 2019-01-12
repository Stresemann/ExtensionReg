package com.silvereaglesystems.mvc.desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class RegistrationDesktopView extends JFrame {
	private JTable table;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public void showView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationDesktopView frame = new RegistrationDesktopView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationDesktopView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

Object[][] data = {
{"Kathy", "Smith",
"Snowboarding", new Integer(5), new Boolean(false)},
{"John", "Doe",
"Rowing", new Integer(3), new Boolean(true)},
{"Sue", "Black",
"Knitting", new Integer(2), new Boolean(false)},
{"Jane", "White",
"Speed reading", new Integer(20), new Boolean(true)},
{"Joe", "Brown",
"Pool", new Integer(10), new Boolean(false)}
};
		
		table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
		getContentPane().add(table, BorderLayout.CENTER);
		
		JButton btnRegisterPlugin = new JButton("Register Plugin");
		btnRegisterPlugin.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	DesktopRegistration desk = new DesktopRegistration();
		    	desk.showRegistration();
		    }
		});
		getContentPane().add(btnRegisterPlugin, BorderLayout.SOUTH);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
