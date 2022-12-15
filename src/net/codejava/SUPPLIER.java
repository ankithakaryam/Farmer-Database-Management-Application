package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SUPPLIER extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUPPLIER frame = new SUPPLIER();
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
	public SUPPLIER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("PESTISIDES");
		btnNewButton.setBounds(40, 68, 300, 100);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PESTISIDES frame = new PESTISIDES();
				frame.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnFertilizers = new JButton("FERTILIZERS");
		btnFertilizers.setBounds(40, 219, 300, 100);
		btnFertilizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FERTILIZERS f =new FERTILIZERS();
				f.setVisible(true);
			}
		});
		btnFertilizers.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnFertilizers);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.setBounds(769, 513, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN l = new LOGIN();
				l.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(0, 549, 970, 29);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(233, 150, 122));
		panel_2.setBounds(941, 0, 29, 578);
		contentPane.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("ORDERS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement(" select inputid,customer_id,name,phoneno,address from orders1,farmers,pestisides where customer_id = id and pes_id = inputid and supplier_id =?");
					 Pstatement.setString(1, LOGIN.userid.getText());
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_2.setBounds(40, 368, 300, 100);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 68, 371, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 228, 196));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-21 at 4.05.49 PM.png"));
		lblNewLabel.setBounds(463, 219, 372, 284);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 150, 122));
		panel.setBounds(0, 0, 382, 552);
		contentPane.add(panel);
	}
}
