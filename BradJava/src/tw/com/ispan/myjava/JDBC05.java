package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {

	public static void main(String[] args) {
		// 2. create connection
		Scanner scanner = new Scanner(System.in);
		System.out.print("Keyword = ");
		String key = scanner.next();
		
		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/iii";
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			prop.setProperty("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(url, prop);

			String sql = "SELECT * FROM gift WHERE name LIKE ? OR place LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");
			pstmt.setString(2, "%" + key + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String v1 = rs.getString("place");
				String v2 = rs.getString("name");
				System.out.printf("%s : %s\n", v1, v2);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
