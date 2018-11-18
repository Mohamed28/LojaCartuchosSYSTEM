package com.grupo9.main;

import java.sql.SQLException;

import com.grupo9.view.StartView;

public class LojaCartuchoSYSTEM {

	public static void main(String[] args) throws SQLException {
		new Thread(new StartView()).start();
	
	}

}
