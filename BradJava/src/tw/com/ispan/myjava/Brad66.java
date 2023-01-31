package tw.com.ispan.myjava;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad66 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("10.10.243.1"), 7777);
			
			OutputStream out = socket.getOutputStream();
			out.write("Hello, Brad".getBytes());
			out.flush();
			out.close();
			
			socket.close();
			System.out.println("TCP Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
