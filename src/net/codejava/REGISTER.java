package net.codejava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class REGISTER extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField password;
	private JTextField address;
	private JPasswordField confirmpassword;
	private JTextField gender;
	private JTextField name;
	private JTextField phno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGISTER frame = new REGISTER();
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
	public REGISTER() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration ");
		lblNewLabel.setBounds(32, 19, 414, 99);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Bodoni 72 Oldstyle", Font.BOLD, 60));
		contentPane.add(lblNewLabel);
		
		JComboBox reBox = new JComboBox();
		reBox.setBounds(574, 91, 276, 27);
		reBox.setModel(new DefaultComboBoxModel(new String[] {"FARMER", "SUPPLIER", "CUSTOMER"}));
		contentPane.add(reBox);
		
		userid = new JTextField();
		userid.setBounds(574, 222, 276, 26);
		contentPane.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(430, 130, 113, 16);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender :");
		lblNewLabel_2.setBounds(482, 178, 61, 16);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(574, 266, 276, 26);
		contentPane.add(password);
		
		JLabel lblNewLabel_4 = new JLabel("Password :");
		lblNewLabel_4.setBounds(430, 270, 113, 16);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password :");
		lblNewLabel_5.setBounds(383, 309, 160, 16);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address :");
		lblNewLabel_6.setBounds(467, 389, 76, 16);
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_6);
		
		address = new JTextField();
		address.setBounds(574, 385, 276, 26);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.setBounds(600, 498, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reBox.setSelectedIndex(0);
				userid.setText("");
				gender.setText("");
				name.setText("");
				password.setText("");
				confirmpassword.setText("");
				address.setText("");
				phno.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.setBounds(793, 498, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(reBox.getSelectedIndex()== 0) {
				try {
	                //Creating Connection Object
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	                //Preapared Statement
	                PreparedStatement Pstatement=connection.prepareStatement("insert into FARMERS values(?,?,?,?,?,?)");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,userid.getText());
	                Pstatement.setString(2,name.getText());
	                Pstatement.setString(3,gender.getText());
	                Pstatement.setString(4,password.getText());
	                Pstatement.setString(5,address.getText());
	                Pstatement.setString(6,phno.getText());
	                //Checking for the Password match
	                if(password.getText().equalsIgnoreCase(confirmpassword.getText()))
	                {
	                    //Executing query
	                    Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                    LOGIN newFrame = new LOGIN();
	    				newFrame.setVisible(true);
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"password did not match");
	                }

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
				}
				else if(reBox.getSelectedIndex()== 1) {
					
					try {
		                //Creating Connection Object
		                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
		                //Preapared Statement
		                PreparedStatement Pstatement=connection.prepareStatement("insert into SUPPLIERS values(?,?,?,?,?,?)");
		                //Specifying the values of it's parameter
		                Pstatement.setString(1,userid.getText());
		                Pstatement.setString(2,name.getText());
		                Pstatement.setString(3,gender.getText());
		                Pstatement.setString(4,password.getText());
		                Pstatement.setString(5,address.getText());
		                Pstatement.setString(6,phno.getText());
		                //Checking for the Password match
		                if(password.getText().equalsIgnoreCase(confirmpassword.getText()))
		                {
		                    //Executing query
		                    Pstatement.executeUpdate();
		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		                    LOGIN newFrame = new LOGIN();
		    				newFrame.setVisible(true);
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"password did not match");
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
					
					
				}
				else if(reBox.getSelectedIndex()==2) {
					try {
		                //Creating Connection Object
		                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
		                //Preapared Statement
		                PreparedStatement Pstatement=connection.prepareStatement("insert into CUSTOMERS values(?,?,?,?,?,?)");
		                //Specifying the values of it's parameter
		                Pstatement.setString(1,userid.getText());
		                Pstatement.setString(2,name.getText());
		                Pstatement.setString(3,gender.getText());
		                Pstatement.setString(4,password.getText());
		                Pstatement.setString(5,address.getText());
		                Pstatement.setString(6,phno.getText());
		                //Checking for the Password match
		                if(password.getText().equalsIgnoreCase(confirmpassword.getText()))
		                {
		                    //Executing query
		                    Pstatement.executeUpdate();
		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		                    LOGIN newFrame = new LOGIN();
		    				newFrame.setVisible(true);
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"password did not match");
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
					
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setBounds(415, 498, 117, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIRSTPAGE window = new FIRSTPAGE();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton_2);
		
		confirmpassword = new JPasswordField();
		confirmpassword.setBounds(574, 305, 276, 26);
		contentPane.add(confirmpassword);
		
		gender = new JTextField();
		gender.setBounds(574, 174, 276, 26);
		contentPane.add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("User Id :");
		lblNewLabel_8.setBounds(467, 226, 76, 16);
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_8);
		
		name = new JTextField();
		name.setBounds(574, 130, 276, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Phone No :");
		lblNewLabel_9.setBounds(430, 347, 113, 16);
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_9);
		
		phno = new JTextField();
		phno.setBounds(574, 343, 276, 26);
		contentPane.add(phno);
		phno.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-21 at 10.54.48 AM.png"));
		lblNewLabel_10.setBounds(-67, 192, 494, 421);
		contentPane.add(lblNewLabel_10);
	}
}
