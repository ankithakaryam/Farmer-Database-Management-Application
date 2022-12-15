package net.codejava;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FIRSTPAGE {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FIRSTPAGE window = new FIRSTPAGE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FIRSTPAGE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("        ");
		frame.setBounds(100, 100, 970, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.setBounds(912, 544, 39, 16);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this will exit the application
				System.exit(0);
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 970, 203);
		panel.setBackground(new Color(0, 139, 139));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FarmKey");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bodoni 72 Oldstyle", Font.BOLD, 80));
		lblNewLabel.setBounds(152, 22, 354, 98);
		panel.add(lblNewLabel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(152, 145, 659, 38);
		panel.add(toolBar);
		toolBar.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBackground(new Color(211, 211, 211));
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIRSTPAGE window = new FIRSTPAGE();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JButton btnNewButton_1 = new JButton("About Us");
		toolBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABOUTUS newFrame = new ABOUTUS();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JButton btnNewButton_5 = new JButton("Contact Us");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 CONTACTUS a = new CONTACTUS();
         	    a.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		toolBar.add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.setToolTipText("register");
		toolBar.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				REGISTER newFrame = new REGISTER();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JButton btnNewButton_3 = new JButton("Login");
		btnNewButton_3.setToolTipText("login");
		toolBar.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN newFrame = new LOGIN();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("");
		toolBar.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("CROPS");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN newFrame = new LOGIN();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_6.setForeground(new Color(0, 139, 139));
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		btnNewButton_6.setBounds(311, 259, 527, 75);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("PESTISIDES");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN newFrame = new LOGIN();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_6_1.setForeground(new Color(0, 139, 139));
		btnNewButton_6_1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		btnNewButton_6_1.setBounds(311, 358, 527, 75);
		frame.getContentPane().add(btnNewButton_6_1);
		
		JButton btnNewButton_6_2 = new JButton("FERTILIZERS");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN newFrame = new LOGIN();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_6_2.setForeground(new Color(0, 139, 139));
		btnNewButton_6_2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		btnNewButton_6_2.setBounds(311, 458, 527, 75);
		frame.getContentPane().add(btnNewButton_6_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-23 at 11.18.18 PM.png"));
		lblNewLabel_2.setBounds(38, 202, 193, 370);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
