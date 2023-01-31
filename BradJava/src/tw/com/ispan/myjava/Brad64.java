package tw.com.ispan.myjava;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad64 {

	public static void main(String[] args) {
		for (int i=0; i<65536; i++) {
			try {
				Socket socket = new Socket(InetAddress.getByName("10.10.243.1"), i);
				socket.close();
				System.out.println("OK:" + i);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
