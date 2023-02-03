package tw.com.ispan.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC12 {
	private final static String USER = "root"; 
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/iii";
	private final static String SQL_QUERY = "SELECT * FROM gift";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			
			System.out.println("---");
			
			rs.first();
			String name = rs.getString("name");
			System.out.println(name);

			System.out.println("---");
			
			rs.absolute(5);
			name = rs.getString("name");
			System.out.println(name);

			//rs.deleteRow();

			System.out.println("---");

			rs.absolute(2);
			name = rs.getString("name");
			System.out.println(name);
			
			rs.updateString("name", "Brad豪華禮盒");
			rs.updateString("city", "台中市");
			rs.updateRow();
			
			System.out.println("---");

			rs.moveToInsertRow();
			rs.updateString("name", "Brad超級極品豪華禮盒");
			rs.updateString("place", "台中市");
			rs.updateString("city", "台中市");
			rs.updateString("town", "台中市");
			rs.insertRow();
			
			
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
