package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class CUSTOMER extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField croid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CUSTOMER frame = new CUSTOMER();
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
	public CUSTOMER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(533, 87, 416, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(210, 180, 140));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("CEREALS");
		btnNewButton.setBounds(269, 78, 252, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'CEREALS' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JButton btnSeeds = new JButton("SEEDS");
		btnSeeds.setBounds(269, 110, 252, 33);
		btnSeeds.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'SEEDS' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnSeeds);
		
		JButton btnPulses = new JButton("PULSES");
		btnPulses.setBounds(269, 142, 252, 33);
		btnPulses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'PULSES' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnPulses.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnPulses);
		
		JButton btnNewButton_1_1 = new JButton("OIL SEEDS");
		btnNewButton_1_1.setBounds(269, 174, 252, 33);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'OIL SEEDS' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1_1);
		
		JButton btnFruits = new JButton("FRUITS");
		btnFruits.setBounds(269, 206, 252, 33);
		btnFruits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'FRUITS' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnFruits.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnFruits);
		
		JButton btnNewButton_1_2 = new JButton("VEGETABLES");
		btnNewButton_1_2.setBounds(269, 238, 252, 33);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'VEGETABLES' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1_2);
		
		JButton btnSpices = new JButton("SPICES");
		btnSpices.setBounds(269, 270, 252, 33);
		btnSpices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'SPICES' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnSpices.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnSpices);
		
		JButton btnNewButton_1_3 = new JButton("FODDER CROPS");
		btnNewButton_1_3.setBounds(269, 301, 252, 33);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'FODDER CROPS' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1_3);
		
		JButton btnCommercialCrops = new JButton("COMMERCIAL CROPS");
		btnCommercialCrops.setBounds(269, 333, 252, 33);
		btnCommercialCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT CROPID,CROP_NAME,NAME,PHONENO,ADDRESS FROM CROPS,FARMERS WHERE CROP_TYPE = 'COMMERCIAL CROPS' and farmer_id=id");
					 ResultSet rs = Pstatement.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnCommercialCrops.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnCommercialCrops);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setBounds(34, 522, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN frame = new LOGIN();
				frame.setVisible(true);
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Available Crops");
		lblNewLabel.setBounds(612, 45, 252, 45);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(6, 45, 262, 377);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-21 at 3.28.33 PM.png"));
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(269, 395, 680, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Crop Id :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(72, 26, 148, 36);
		panel.add(lblNewLabel_2);
		
		croid = new JTextField();
		croid.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		croid.setBounds(270, 29, 288, 36);
		panel.add(croid);
		croid.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ORDER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO ORDERS (CROPID,CUSTOMER_ID) VALUES(?,?)");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,croid.getText());
	                Pstatement.setString(2, LOGIN.userid.getText());
	                if(croid.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Ordered Successfully");
	                    
	                    
	                    
	                  
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"invalid!!");
	                }
				} catch (SQLException e1) {
	                e1.printStackTrace();
	            }
				
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_2.setBounds(405, 509, 150, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CANCEL ORDER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Creating Connection Object
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	                //Preapared Statement
	                PreparedStatement Pstatement=connection.prepareStatement("delete from ORDERS where ORDER_ID = ?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,croid.getText());
	                
	                
	                
	               
	                //Checking for the Password match
	                if(croid.getText()!="")
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Order Cancelled Succesfully");
	                    
	                    
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"Enter valid pesid id");
	                }

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
				
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_3.setBounds(666, 512, 150, 48);
		contentPane.add(btnNewButton_3);
	}
}
