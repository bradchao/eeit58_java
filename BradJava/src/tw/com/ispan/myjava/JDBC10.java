package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import tw.com.ispan.myclasses.Bike;

public class JDBC10 {
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private final static String SQL_ICON = "UPDATE member SET icon = ?, bike = ? WHERE id = ?";
	//private final static String SQL_BIKE = "UPDATE member SET bike = ? WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		
		
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_ICON);
			
			FileInputStream fin = new FileInputStream("dir1/ball0.jpg");
			pstmt.setBinaryStream(1, fin);
			pstmt.setObject(2, b1);
			pstmt.setInt(3, 4);
			if (pstmt.executeUpdate() > 0 ) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
