package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad54 {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		try (FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
				FileOutputStream fout = new FileOutputStream("dir2/coffee4.jpg");) {
			
			int len; byte[] buf = new byte[4096]; 
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			fout.flush();
			
			System.out.println("OK:" + (System.currentTimeMillis() - now));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
