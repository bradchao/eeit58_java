package tw.com.ispan.myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad53 {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		try {
			File source = new File("dir1/coffee.jpg");
			FileInputStream fin = new FileInputStream(source);
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			fin.close();
			
			FileOutputStream fout = new FileOutputStream("dir2/coffee5.jpg");
			fout.write(buf);
			fout.flush();
			fout.close();
			
			System.out.println("OK:" + (System.currentTimeMillis() - now));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
