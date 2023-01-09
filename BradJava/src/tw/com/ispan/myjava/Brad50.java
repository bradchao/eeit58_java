package tw.com.ispan.myjava;

import java.io.FileReader;
import java.io.IOException;

public class Brad50 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/file1.txt");
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char)c);
			}
			reader.close();
			System.out.println();
			System.out.println("----");
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
