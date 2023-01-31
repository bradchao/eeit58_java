package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad71 {

	public static void main(String[] args) {
		try {
			String json = getData("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			
		}catch(Exception e) {
			System.out.println(e);
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
