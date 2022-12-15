package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class CONTACTUS extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CONTACTUS frame = new CONTACTUS();
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
	public CONTACTUS() {
		getContentPane().setBackground(new Color(0, 139, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton.setBounds(766, 489, 137, 46);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 FIRSTPAGE a = new FIRSTPAGE();
         	    a.frame.setVisible(true);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128), new Color(0, 128, 128)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(205, 131, 559, 315);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Give us a call ");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(88, 59, 143, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(423)8770592");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(88, 86, 169, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Send us an email");
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(259, 59, 194, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("farmkeyus@gmail.com");
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(259, 86, 238, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Come see us");
		lblNewLabel_4.setForeground(new Color(0, 128, 128));
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(259, 159, 262, 29);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("900 Dr Vishnuvardhan Road");
		lblNewLabel_5.setForeground(new Color(0, 128, 128));
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(259, 188, 262, 29);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("BGS & SJBIT cities");
		lblNewLabel_6.setForeground(new Color(0, 128, 128));
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(259, 212, 300, 29);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kengeri - 560060");
		lblNewLabel_7.setForeground(new Color(0, 128, 128));
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(259, 238, 228, 23);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-22 at 5.39.33 PM.png"));
		lblNewLabel_9.setBounds(88, 116, 180, 182);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Contact Us");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.BOLD, 45));
		lblNewLabel_8.setBounds(49, 19, 302, 70);
		getContentPane().add(lblNewLabel_8);
	}

}
