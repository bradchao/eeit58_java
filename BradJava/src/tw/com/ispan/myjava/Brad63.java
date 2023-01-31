package tw.com.ispan.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad63 {

	public static void main(String[] args) {
		while (true) {
			byte[] buf = new byte[1024];
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				System.out.println("waiting...");
				socket.receive(packet);
				socket.close();
				
				String urip = packet.getAddress().getHostAddress();
				int len = packet.getLength();
				byte[] data = packet.getData();
				String mesg = new String(data, 0, len);
				System.out.printf("%s => %s\n", urip, mesg);
				
				if (mesg.equals("quit")) {
					break;
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

}
