package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad47 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("./dir1/file1.txt");
			
			int c1;
			while ( (c1 = fin.read()) != -1) {
				System.out.print((char)c1);
			}
			
			fin.close();
			
			System.out.println();
			System.out.println("------");
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
	}

}
