package tw.com.ispan.myclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GiftDB {
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private Connection conn;

	public GiftDB() throws SQLException {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		Connection conn = DriverManager.getConnection(URL, prop);
	}
}
