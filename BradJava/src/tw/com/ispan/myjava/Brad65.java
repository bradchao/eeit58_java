package tw.com.ispan.myjava;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad65 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("Lintenning...");
			Socket socket =  server.accept();
			server.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
