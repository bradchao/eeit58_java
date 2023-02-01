package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		// 2. create connection
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/iii";
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			prop.setProperty("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(url, prop);
			System.out.println("OK2");
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO tb1 (f1, f2) VALUES ('tony','1999-01-02')";
			int num = stmt.executeUpdate(sql);
			System.out.println(num);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
