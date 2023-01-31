package tw.com.ispan.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad63 {

	public static void main(String[] args) {
		byte[] buf = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			System.out.println("waiting...");
			socket.receive(packet);
			socket.close();
			System.out.println("Receive OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
