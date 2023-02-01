package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad71 {

	public static void main(String[] args) {
		try {
			String json = getData("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx");
			//System.out.println(json);
			parseJSON(json);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			String name = row.getString("Name");
			String country = row.getString("City");
			String town = row.getString("Town");
			System.out.printf("%s:%s:%s\n", name, country, town);
		}
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