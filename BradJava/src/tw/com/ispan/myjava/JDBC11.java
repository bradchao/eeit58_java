package tw.com.ispan.myjava;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.com.ispan.myclasses.Bike;

public class JDBC11 {
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private final static String SQL_QUERY = "SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 4);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			InputStream in = rs.getBinaryStream("icon");
			FileOutputStream fout = new FileOutputStream("dir3/icon.jpg");
			byte[] buf = new byte[64*1024];
			int len = in.read(buf);
			fout.write(buf, 0, len);
			in.close();
			fout.flush();
			fout.close();
			
			
			InputStream bin = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(bin);
			Object obj = oin.readObject();
			if ( obj instanceof Bike) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			Bike b1 = (Bike)obj;
			System.out.println(b1.getSpeed());
			
			System.out.println("OK");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
