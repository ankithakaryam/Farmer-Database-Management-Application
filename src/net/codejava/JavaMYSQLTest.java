package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaMYSQLTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/LOGIN";
		String username = "root";
		String password = "Ankitha@123";
		
		
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connected to the database");
		} catch (SQLException e) {
			System.out.println("Oops, error!");
			e.printStackTrace();
		}

	}

}
