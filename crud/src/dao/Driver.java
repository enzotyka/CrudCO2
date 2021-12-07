package dao;
import com.mysql.jdbc.PreparedStatement;

import java.io.IOException;
import java.sql.*;

public class Driver {

	public static void main(String[] args){
		Connection conn = null;
		String db = "postgres";
		String user = "postgres";
		String password = "root";
		String url = "jdbc:postgresql://localhost:5432/"+db;
		try {
	        Class.forName("org.postgresql.Driver");
	        conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
