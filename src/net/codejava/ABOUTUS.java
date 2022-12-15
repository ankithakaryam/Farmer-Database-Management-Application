package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class ABOUTUS extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABOUTUS frame = new ABOUTUS();
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
	public ABOUTUS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("About Us");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setBounds(68, 33, 353, 66);
		lblNewLabel.setFont(new Font("Bodoni 72 Oldstyle", Font.BOLD, 69));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBounds(785, 509, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIRSTPAGE window = new FIRSTPAGE();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(68, 84, 609, 454);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-22 at 4.24.57 PM.png"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-22 at 3.19.07 PM.png"));
		lblNewLabel_2.setBounds(656, 130, 228, 356);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(912, 0, 58, 578);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 375, 10, 203);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(6, 568, 228, 10);
		contentPane.add(panel_2);
	}
}
