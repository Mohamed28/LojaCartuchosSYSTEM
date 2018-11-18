package com.grupo9.util;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_cartucho_system?useSSL=false", "lojacartucho", "123456"); 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
