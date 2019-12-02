package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3333/javadb";
		// mandatory in  Java EE
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, "root", "actscdac");
	}
}
