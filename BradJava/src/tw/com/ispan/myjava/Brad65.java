package tw.com.ispan.myjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad65 {

	public static void main(String[] args) {
		while (true) {
			try {
				ServerSocket server = new ServerSocket(7777);
				System.out.println("Lintenning...");
				Socket socket =  server.accept();
				
				String who = socket.getInetAddress().getHostAddress();
				System.out.print(who + ":");
				
				BufferedReader br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
				
				String line;
				while ( (line = br.readLine()) != null) {
					System.out.println(line);
				}
				
				br.close();
				server.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
