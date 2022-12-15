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
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CROPS extends JFrame {

	private JPanel contentPane;
	private JTextField croname;
	private JTextField cropid;
	private JTextField crodescript;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CROPS frame = new CROPS();
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
	public CROPS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(24, 56, 456, 371);
		panel.setBorder(new TitledBorder(null, "Add pestiside", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crop Name :");
		lblNewLabel_1.setBounds(33, 73, 159, 30);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		croname = new JTextField();
		croname.setBounds(223, 75, 204, 30);
		croname.setColumns(10);
		panel.add(croname);
		
		JLabel lblNewLabel_2 = new JLabel("Crop Type :");
		lblNewLabel_2.setBounds(16, 135, 176, 30);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);
		
		JComboBox croBox = new JComboBox();
		croBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CEREALS", "SEEDS", "PULSES", "OIL SEEDS", "FRUITS", "VEGETABLES", "SPICES", "FODDER CROPS", "COMMERCIAL CROPS"}));
		croBox.setBounds(223, 140, 209, 27);
		croBox.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		panel.add(croBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO CROPS(CROP_NAME,CROP_TYPE,CROP_QUANTITY,FARMER_ID) VALUES(?,?,?,?)");
	                //Specifying the values of it's parameter
	               
	                Pstatement.setString(1,croname.getText());
	                Pstatement.setString(2,croBox.getSelectedItem().toString());
	                Pstatement.setString(3,crodescript.getText());
	                Pstatement.setString(4, LOGIN.userid.getText());
	                if(croname.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Added Successfully");
	                    croBox.setSelectedIndex(0);
	    				croname.setText("");
	    				crodescript.setText("");
	                    
	           
	                  
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
		btnNewButton.setBounds(310, 261, 117, 40);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FC f = new FC();
				f.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(33, 262, 117, 39);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				croBox.setSelectedIndex(0);
				croname.setText("");
				crodescript.setText("");
				cropid.setText("");
			}
		});
		btnNewButton_2.setBounds(170, 262, 117, 39);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Crop Quantity :");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(16, 196, 176, 30);
		panel.add(lblNewLabel_4);
		
		crodescript = new JTextField();
		crodescript.setBounds(223, 200, 204, 26);
		panel.add(crodescript);
		crodescript.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(24, 458, 733, 101);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Crop Id :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(30, 36, 154, 31);
		panel_1.add(lblNewLabel_3);
		
		cropid = new JTextField();
		cropid.setColumns(10);
		cropid.setBounds(224, 40, 190, 26);
		panel_1.add(cropid);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("UPDATE CROPS SET CROP_NAME=?,CROP_TYPE=?,CROP_QUANTITY=? WHERE CROPID =?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1, croname.getText());
	                Pstatement.setString(2,croBox.getSelectedItem().toString());
	                Pstatement.setString(3,crodescript.getText());
	                Pstatement.setString(4,cropid.getText());
	                
	               
	                if(cropid.getText()!="")
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
		btnNewButton_3.setBounds(452, 28, 117, 46);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
	                //Creating Connection Object
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	                //Preapared Statement
	                PreparedStatement Pstatement=connection.prepareStatement("delete from CROPS where CROPID = ?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,cropid.getText());
	                
	                
	                
	               
	                //Checking for the Password match
	                if(cropid.getText()!="")
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
		btnNewButton_4.setBounds(592, 28, 117, 46);
		panel_1.add(btnNewButton_4);
		
		JButton load = new JButton("Click Here For Available Crops\n");
		load.setBounds(540, 398, 297, 29);
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,CROP_TYPE,CROP_QUANTITY FROM CROPS WHERE FARMER_ID =?");
					 Pstatement.setString(1, LOGIN.userid.getText());
					 ResultSet rs = Pstatement.executeQuery();
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		contentPane.add(load);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(540, 68, 396, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(107, 142, 35));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-21 at 6.16.57 PM.png"));
		lblNewLabel_5.setBounds(751, 326, 216, 354);
		contentPane.add(lblNewLabel_5);
	}
}
