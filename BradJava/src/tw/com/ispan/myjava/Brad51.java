package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad51 {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/coffee3.jpg");
			
			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();
			fout.close();
			
			fin.close();
			System.out.println("OK:" + (System.currentTimeMillis() - now));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
