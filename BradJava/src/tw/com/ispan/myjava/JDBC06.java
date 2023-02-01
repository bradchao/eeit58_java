package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC06 {

	public static void main(String[] args) {
		// 2. create connection
		Scanner scanner = new Scanner(System.in);
		System.out.print("page = ");
		int page = scanner.nextInt();
		int rpp = 10;
		int start = (page -1)*rpp;
		
		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/iii";
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			prop.setProperty("serverTimezone", "Asia/Taipei");
			Connection conn = DriverManager.getConnection(url, prop);

			
			String sqlCount = "SELECT count(*) count FROM gift";
			Statement stmt = conn.createStatement();
			ResultSet rsCount = stmt.executeQuery(sqlCount);
			rsCount.next();
			int count = rsCount.getInt("count");
			//System.out.println("total:" + count);
			int pages = (int)Math.ceil(count*1.0 / rpp);
			
			if (page < 0 || page > pages) throw new MyPageException("aaaaa");
			
			String sql = "SELECT id, name, place addr FROM gift ORDER BY id LIMIT ?, ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String v0 = rs.getString("id");
				String v1 = rs.getString("addr");
				String v2 = rs.getString("name");
				System.out.printf("%s : %s : %s\n", v0, v1, v2);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class MyPageException extends Exception {
	private String mesg;
	public MyPageException(String mesg) {
		this.mesg = mesg;
	}
	@Override
	public String toString() {
		return mesg;
	}
}



