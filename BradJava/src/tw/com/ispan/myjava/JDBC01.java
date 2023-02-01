package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {

	public static void main(String[] args) {
		// CREATE TABLE tb2 (id INT PRIMARY KEY AUTO_INCREMENT, f1 VARCHAR(100), f2 DATE);

		// 1. Load Driver
		// sqlserver : com.microsoft.sqlserver.jdbc.SQLServerDriver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
		}
		
		// 2. create connection
		try {
			// jdbc:sqlserver://localhost;database=iii;user=sa;
			// 
			//jdbc:mysql://localhost:3306/database_name?enabledTLSProtocols=TLSv1.2

			String url = "jdbc:mysql://127.0.0.1:3306/iii?user=root&password=root&useSSL=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url);
			System.out.println("OK2");
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO tb1 (f1, f2) VALUES ('brad','1999-01-02')";
			int num = stmt.executeUpdate(sql);
			System.out.println(num);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		
		
	}

}
