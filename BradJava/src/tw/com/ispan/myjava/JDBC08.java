package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.com.ispan.myclasses.BCrypt;
import tw.com.ispan.myclasses.Member;

public class JDBC08 {
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private final static String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
	private final static String SQL_CHPASSWD = "UPDATE member SET passwd = ? WHERE id = ?";

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
					Member member = new Member(rs.getInt("id"),
							rs.getString("account"), rs.getString("realname"), null);
					System.out.printf(
						"Welcome, %s / %s\n", member.getRealname(), member.getAccount());
					
					// change password process
					System.out.print("Change Password(newpasswd or NO): ");
					String newPasswd = scanner.next();
					
					if (newPasswd.length() >= 6) {
						PreparedStatement pstmt2 = conn.prepareStatement(SQL_CHPASSWD);
						pstmt2.setString(1, BCrypt.hashpw(newPasswd, BCrypt.gensalt()));
						pstmt2.setInt(2, member.getId());
						if (pstmt2.executeUpdate() > 0 ) {
							// SUCCESS
							System.out.println("change passwd success!");
						}else {
							// 更換失敗
							System.out.println("change passwd failure!");
						}
					}else {
						// 不想換
						System.out.println("no change");
					}
					
					
				}else {
					// failure
					System.out.println("login failure(1)");
				}
			}else {
				// 帳號不存在
				System.out.println("login failure(2)");
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
