package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad69 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://www.iii.org.tw");
			URLConnection conn = (HttpsURLConnection)url.openConnection();
//			if (conn instanceof HttpsURLConnection) {
//				System.out.println("OK");
//			}else {
//				System.out.println("XX");
//			}
			
			conn.connect();
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ( (line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
