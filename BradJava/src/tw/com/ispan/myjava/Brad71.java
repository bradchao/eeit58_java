package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad71 {

	public static void main(String[] args) {
		try {
			String json = getData("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			//System.out.println(json);
			parseJSON(json);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/iii";
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		prop.setProperty("serverTimezone", "Asia/Taipei");
		Connection conn = DriverManager.getConnection(url, prop);
		
		String sql = "INSERT INTO gift (name,place,city,town,lat,lng,pic) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		JSONArray root = new JSONArray(json);
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			String name = row.getString("Name");
			String place = row.getString("SalePlace");
			String city = row.getString("County");
			String town = row.getString("Township");
			String lat = row.getString("Latitude");
			String lng = row.getString("Longitude");
			String pic = row.getString("Column1");
			
			pstmt.setString(1, name);
			pstmt.setString(2, place);
			pstmt.setString(3, city);
			pstmt.setString(4, town);
			pstmt.setString(5, lat);
			pstmt.setString(6, lng);
			pstmt.setString(7, pic);
			pstmt.executeUpdate();
		}
		System.out.println("OK");
	}
	
	
	static String getData(String urlString) throws Exception {
		URL url = new URL(urlString);
		URLConnection conn = (HttpsURLConnection)url.openConnection();
		
		conn.connect();
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(
				conn.getInputStream()));
		String line; StringBuffer sb = new StringBuffer();
		while ( (line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
			
		return sb.toString();
	}
	
	
	
	

}
