package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class Database {

	Connection conn = null;
	
	public Connection connect() {
		String db = "emissaogases";
		String user = "postgres";
		String password = "root";
		String url = "jdbc:postgresql://localhost:5432/"+db;
		try {
	        Class.forName("org.postgresql.Driver");
	        conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public PreparedStatement getPreparedStatement(String sql) {
		conn = connect();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			return stmt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
