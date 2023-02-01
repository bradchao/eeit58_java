package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04 {

	public static void main(String[] args) {
		// 2. create connection
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/iii";
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			prop.setProperty("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(url, prop);
			
			String sql = "INSERT INTO tb1 (f1,f2) VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "eric1");
			pstmt.setString(2, "1999-03-04");
			int num = pstmt.executeUpdate();
			System.out.println(num);

			
			pstmt.setString(1, "eric2");
			pstmt.setString(2, "1999-03-04");
			num = pstmt.executeUpdate();
			System.out.println(num);

			pstmt.setString(1, "eric3");
			pstmt.setString(2, "1999-03-04");
			num = pstmt.executeUpdate();
			System.out.println(num);
			// https://github.com/dalers/mywind
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
