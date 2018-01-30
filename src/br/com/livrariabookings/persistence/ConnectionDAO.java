package br.com.livrariabookings.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	public ConnectionDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/lovefood";
		Connection conn = DriverManager.getConnection(url, "root", "");
		return conn;
	}
}
