package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.com.ispan.myclasses.BCrypt;

public class JDBC08 {
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private final static String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String passwd = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);

		try (Connection conn = DriverManager.getConnection(URL, prop);
				PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN)) {
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(passwd, rs.getString("passwd"))) {
					// login
					
					
					
					
				}else {
					// failure
				}
			}else {
				// 帳號不存在
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
