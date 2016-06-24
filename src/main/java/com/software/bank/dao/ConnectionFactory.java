package com.software.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
	
	private static String parameter = "jdbc:h2:mem:bank";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(parameter);
	}
}