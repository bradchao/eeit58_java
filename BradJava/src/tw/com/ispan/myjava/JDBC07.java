package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.com.ispan.myclasses.BCrypt;

public class JDBC07 {
	private static Connection conn;
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private final static String SQL_CHECK = "SELECT count(*) count FROM member WHERE account = ?";
	private final static String SQL_INSERT = "INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String passwd = scanner.next();

		System.out.print("Real name: ");
		String realname = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);

		try {
			conn = DriverManager.getConnection(URL, prop);
			if (checkAccount(account)) {
				if (addMember(account, passwd, realname)) {
					System.out.println("Register success");
				}else {
					System.out.println("Register failue");
				}
			}else {
				// 相同帳號
				System.out.println("account exist");
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static boolean checkAccount(String account) throws Exception {
		boolean ret;
		PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		ret = rs.getInt("count") == 0;
		pstmt.close();
		
		return ret;
	}
	
	private static boolean addMember(String account, String passwd, String realname) throws Exception {
		boolean isOK = false;
		PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, realname);
		isOK = pstmt.executeUpdate() != 0;
		pstmt.close();
		
		return isOK;
	}
	

}
