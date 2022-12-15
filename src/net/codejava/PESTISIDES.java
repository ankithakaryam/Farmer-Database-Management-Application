package net.codejava;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

@SuppressWarnings({ "unused", "serial" })
public class PESTISIDES extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField pesname;
	private JTextField pestisideid;
	private JTable table;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PESTISIDES frame = new PESTISIDES();
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
	
	
	public PESTISIDES() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(37, 86, 456, 332);
		panel.setBorder(new TitledBorder(null, "Add pestiside", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pestiside Name :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(33, 113, 159, 30);
		panel.add(lblNewLabel_1);
		
		pesname = new JTextField();
		pesname.setBounds(223, 115, 204, 30);
		panel.add(pesname);
		pesname.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO PESTISIDES(PES_NAME,SUPPLIER_ID) VALUES(?,?)");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,pesname.getText());
	                
	                Pstatement.setString(2, LOGIN.userid.getText());
	                if(pesname.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Added Successfully");
	                    pesname.setText("");
	    				pestisideid.setText("");
	                    
	                    
	                  
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"Enter all details");
	                }
				} catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	                
				
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(310, 218, 117, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SUPPLIER s =  new SUPPLIER();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.setBounds(33, 219, 117, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				pesname.setText("");
				pestisideid.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_2.setBounds(170, 219, 117, 39);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(37, 457, 851, 101);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Pestiside Id :");
		lblNewLabel_3.setBackground(new Color(143, 188, 143));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(30, 36, 154, 31);
		panel_1.add(lblNewLabel_3);
		
		pestisideid = new JTextField();
		pestisideid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					
					
					
				String PES_ID = pestisideid.getText();
				
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
				PreparedStatement Pstatement=connection.prepareStatement("SELECT PES_ID,PES_NAME FROM PESTISIDES WHERE PES_ID = ?");
				Pstatement.setString(1,pestisideid.getText());

				 ResultSet rs = Pstatement.executeQuery();
				 
				 if(rs.next()==true)
				 {
					 
					 
					 String PES_NAME = rs.getString(1);
					 String PES_CATEGORY = rs.getString(2);
					 
					 
					
					 
				 }
			}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		pestisideid.setBounds(224, 40, 190, 26);
		panel_1.add(pestisideid);
		pestisideid.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("UPDATE PESTISIDES SET PES_NAME=? WHERE PES_ID =?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1, pesname.getText());
	                Pstatement.setString(2,pestisideid.getText());
	                
	               
	                if(pestisideid.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data updated Successfully");
	                    
	                    
	                    
	                  
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"Enter all details");
	                }
				} catch (SQLException e1) {
	                e1.printStackTrace();
	            }
				
				
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_3.setBounds(500, 28, 117, 46);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
	                //Creating Connection Object
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	                //Preapared Statement
	                PreparedStatement Pstatement=connection.prepareStatement("delete from PESTISIDES where PES_ID = ?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,pestisideid.getText());
	                
	                
	                
	               
	                //Checking for the Password match
	                if(pestisideid.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data deleted Successfully");
	                    
	                    
	                    
	                  
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"Enter valid cropid");
	                }

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
				
				
				
				
				
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_4.setBounds(657, 28, 117, 46);
		panel_1.add(btnNewButton_4);
		
		JPanel tableJPanel = new JPanel();
		tableJPanel.setBounds(498, 99, 400, 300);
		contentPane.add(tableJPanel);
		tableJPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 400, 300);
		tableJPanel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(0, 128, 128));
		scrollPane.setViewportView(table);
		
		JButton load = new JButton("Refresh For Pestisides Available");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT PES_ID,PES_NAME FROM PESTISIDES where supplier_id =?");
					 Pstatement.setString(1, LOGIN.userid.getText());
					 ResultSet rs = Pstatement.executeQuery();

					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		load.setBounds(552, 409, 297, 29);
		contentPane.add(load);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(0, 0, 18, 578);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBounds(922, 0, 48, 578);
		contentPane.add(panel_3);
		
		
	}
}
