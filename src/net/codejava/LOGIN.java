package net.codejava;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
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
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.Color;



public class LOGIN extends JFrame {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	static JTextField userid;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
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
	@SuppressWarnings("rawtypes")
	public LOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox reBox = new JComboBox();
		reBox.setBounds(539, 135, 162, 27);
		reBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reBox.setModel(new DefaultComboBoxModel(new String[] {"FARMER", "SUPPLIER", "CUSTOMER"}));
		contentPane.add(reBox);
		
		JLabel lblNewLabel = new JLabel("UserId :");
		lblNewLabel.setBounds(335, 212, 114, 19);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		userid = new JTextField();
		userid.setBounds(510, 209, 219, 26);
		contentPane.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(291, 288, 158, 27);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(510, 291, 219, 26);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBounds(341, 407, 117, 50);
		btnNewButton.setMnemonic('a');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIRSTPAGE window = new FIRSTPAGE();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBounds(549, 407, 117, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				reBox.setSelectedIndex(0);
				userid.setText("");
				password.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.setBounds(750, 407, 117, 50);
		btnNewButton_2.addActionListener(new ActionListener() {
			private JOptionPane wrong;

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(reBox.getSelectedIndex()== 0) {
				
				try {
	                //Creating Connection Object
	                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
	                //Prepared Statement
	                PreparedStatement Pstatement=connection.prepareStatement("select NAME from FARMERS where ID = ? and PASSWORD = ?");
	                //Specifying the values of it's parameter
	                Pstatement.setString(1,userid.getText());
	                
	                Pstatement.setString(2,password.getText());
	                
	                ResultSet rs = Pstatement.executeQuery();
	                //Checking for the Password match
	                if(rs.next()) {
	                
	                    JOptionPane.showMessageDialog(null,"Welcome "+rs.getString(1));
	                    
	                    FC f = new FC();
	                    f.setVisible(true);
	                    
  
	                }
	                
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"invalid user/password!!");
	                }

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
				}
				else if(reBox.getSelectedIndex()==1) {
					
					try {
		                //Creating Connection Object
		                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
		                //Prepared Statement
		                PreparedStatement Pstatement=connection.prepareStatement("select NAME from SUPPLIERS where ID = ? and PASSWORD = ?");
		                //Specifying the values of it's parameter
		                Pstatement.setString(1,userid.getText());
		                
		                Pstatement.setString(2,password.getText());
		      
		                
		                ResultSet rs = Pstatement.executeQuery();
		                //Checking for the Password match
		                if(rs.next()) {
		                
		                    JOptionPane.showMessageDialog(null,"Welcome "+rs.getString(1));
		                    SUPPLIER s = new SUPPLIER();
		                    s.setVisible(true);
	  
		                }
		                
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"invalid user/password!!");
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
				
					
				}
				else if(reBox.getSelectedIndex()==2) {
					try {
		                //Creating Connection Object
		                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/FARMARDBMS","root","Ankitha@123");
		                //Prepared Statement
		                PreparedStatement Pstatement=connection.prepareStatement("select NAME from CUSTOMERS where ID = ? and PASSWORD = ?");
		                //Specifying the values of it's parameter
		                Pstatement.setString(1,userid.getText());
		                
		                Pstatement.setString(2,password.getText());
		               
		      
		                
		                ResultSet rs = Pstatement.executeQuery();
		                //Checking for the Password match
		                if(rs.next()) {
		                
		                    JOptionPane.showMessageDialog(null,"Welcome "+rs.getString(1));
		                    CUSTOMER C = new CUSTOMER();
		                    C.setVisible(true);
	  
		                }
		                
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"invalid user/password!!");
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
					
				}
			
			
				
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Login..");
		lblNewLabel_2.setBounds(356, 20, 232, 103);
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Bodoni 72 Oldstyle", Font.BOLD, 70));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Click Here If You Have Not Registered");
		btnNewButton_3.setBounds(356, 509, 439, 29);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				REGISTER newFrame = new REGISTER();
				newFrame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(771, 66, 198, 314);
		lblNewLabel_3.setIcon(new ImageIcon("/Users/Kunny/Desktop/Screenshot 2022-01-21 at 10.46.08 AM.png"));
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(-14, 0, 232, 591);
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
	}
}
