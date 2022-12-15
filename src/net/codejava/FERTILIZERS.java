package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class FERTILIZERS extends JFrame {

	private JPanel contentPane;
	private JTextField fername;
	private JTextField fertid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FERTILIZERS frame = new FERTILIZERS();
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
	public FERTILIZERS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(255, 255, 255));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 970, 578);
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 79, 456, 308);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "ADD FERTILIZER", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Fertilizer Name :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(33, 109, 159, 30);
		panel.add(lblNewLabel_1);
		
		fername = new JTextField();
		fername.setColumns(10);
		fername.setBounds(223, 111, 204, 30);
		panel.add(fername);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO FERTILIZERS(FERTILIZER_NAME,SUPPLIER_ID) VALUES(?,?)");
	                //Specifying the values of it's parameter
	               
	                Pstatement.setString(1,fername.getText());
	                Pstatement.setString(2, LOGIN.userid.getText());
	                if(fername.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Added Successfully");
	
	    				fername.setText("");
	    				fertid.setText("");
	                    
	                    
	                    
	                  
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
		btnNewButton.setBounds(310, 229, 117, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SUPPLIER s = new SUPPLIER();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.setBounds(33, 230, 117, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				fername.setText("");
				fertid.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_2.setBounds(170, 230, 117, 39);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 453, 851, 101);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane_1.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Fertilizer Id :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(30, 36, 154, 31);
		panel_1.add(lblNewLabel_3);
		
		fertid = new JTextField();
		fertid.setColumns(10);
		fertid.setBounds(224, 40, 190, 26);
		panel_1.add(fertid);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("UPDATE FERTILIZERS SET FERTILIZER_NAME=? WHERE FERTILIZER_ID =?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1, fername.getText());
	                Pstatement.setString(2,fertid.getText());
	                
	               
	                if(fername.getText()!="")
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
	                PreparedStatement Pstatement=connection.prepareStatement("delete from FERTILIZERS where FERTILIZER_ID = ?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,fertid.getText());
	                
	                
	                
	               
	                //Checking for the Password match
	                if(fertid.getText()!="")
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
		
		JButton load = new JButton("Refresh For Fertilizers Available");
		load.setBounds(552, 400, 297, 29);
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT FERTILIZER_ID,FERTILIZER_NAME FROM FERTILIZERS where supplier_id =?");
					 Pstatement.setString(1, LOGIN.userid.getText());
					 ResultSet rs = Pstatement.executeQuery();
					
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		contentPane_1.add(load);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 79, 400, 300);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(32, 178, 170));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(911, 0, 59, 578);
		panel_2.setBackground(new Color(32, 178, 170));
		contentPane_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 17, 578);
		panel_3.setBackground(new Color(32, 178, 170));
		contentPane_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(17, 568, 909, 10);
		panel_4.setBackground(new Color(32, 178, 170));
		contentPane_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(32, 178, 170));
		panel_5.setBounds(17, 0, 909, 10);
		contentPane_1.add(panel_5);
	}
}
