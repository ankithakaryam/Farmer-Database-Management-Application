package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class FC extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField pesid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FC frame = new FC();
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
	public FC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(84, 34, 846, 39);
		toolBar.setBackground(new Color(32, 178, 170));
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("CROPS");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PESTISIDES");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("FERTILIZERS");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("HOME");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FIRSTPAGE f = new FIRSTPAGE();
				f.frame.setVisible(true);
			}
			
		});
		
		JButton btnNewButton_7 = new JButton("ORDERS RECEIVED");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement(" select o.cropid,o.customer_id,c.name,c.phoneno,c.address from orders o,customers c,crops r,farmers f where o.customer_id=c.id and o.cropid= r.cropid and f.id= ?");
					 	
					 Pstatement.setString(1, LOGIN.userid.getText());
					 ResultSet rs = Pstatement.executeQuery();
					 
					 table_1.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		toolBar.add(btnNewButton_7);
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN l = new LOGIN();
				l.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		toolBar.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 105, 722, 307);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(255, 255, 255));
		table_1.setBackground(new Color(0, 139, 139));
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-118, 172, 322, 336);
		lblNewLabel.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-21 at 10.37.41 AM.png"));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(208, 450, 722, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pestiside/Fertilizer Id :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(38, 36, 207, 37);
		panel.add(lblNewLabel_1);
		
		pesid = new JTextField();
		pesid.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		pesid.setBackground(new Color(255, 255, 255));
		pesid.setBounds(272, 38, 231, 37);
		panel.add(pesid);
		pesid.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Order");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	               
	                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO ORDERS1 (INPUTID,CUSTOMER_ID) VALUES(?,?)");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,pesid.getText());
	                Pstatement.setString(2, LOGIN.userid.getText());
	                if(pesid.getText()!="")
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
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_5.setBounds(531, 6, 156, 39);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Cancel Order");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
	                //Creating Connection Object
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	                //Preapared Statement
	                PreparedStatement Pstatement=connection.prepareStatement("delete from ORDERS1 where ORDER_ID = ?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,pesid.getText());
	                
	                
	                
	               
	                //Checking for the Password match
	                if(pesid.getText()!="")
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
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_6.setBounds(531, 57, 156, 38);
		panel.add(btnNewButton_6);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT FERTILIZER_ID,FERTILIZER_NAME,NAME,PHONENO,ADDRESS FROM SUPPLIERS JOIN FERTILIZERS WHERE SUPPLIER_ID = ID");
					 ResultSet rs = Pstatement.executeQuery();
					 table_1.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
					 PreparedStatement Pstatement=connection.prepareStatement("SELECT PES_ID,PES_NAME,NAME,PHONENO,ADDRESS FROM PESTISIDES JOIN SUPPLIERS WHERE SUPPLIER_ID = ID");
					 ResultSet rs = Pstatement.executeQuery();
					 table_1.setModel(DbUtils.resultSetToTableModel(rs));
					 
					 
					
				}catch (SQLException e1) {
		            e1.printStackTrace();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CROPS c = new CROPS();
				c.setVisible(true);
			}
		});
	}
}
