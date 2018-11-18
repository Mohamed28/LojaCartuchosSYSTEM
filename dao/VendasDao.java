package com.grupo9.dao;

import java.sql.Connection;

import com.grupo9.util.ConnectionFactory;

public class VendasDao {
	
	Connection connection;
	
	public VendasDao() {
		this.connection = ConnectionFactory.getConnection();
	}
}
