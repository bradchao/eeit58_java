import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad68 {

	public static void main(String[] args) {
		while (true) {
			try {
				ServerSocket server = new ServerSocket(6666);
				Socket socket = server.accept();
				String ip = socket.getInetAddress().getHostAddress();
				FileOutputStream fout = new FileOutputStream(String.format("dir3/%s.jpg", ip));
				
				BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
				byte[] buf = new byte[2*1024]; int len;
				while ( (len = bin.read(buf)) != -1) {
					fout.write(buf, 0, len);
				}
				
				fout.flush();
				fout.close();
				
				bin.close();
				
				server.close();
				
				System.out.println("TCP Receive OK:"  + ip);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
