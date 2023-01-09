package tw.com.ispan.myjava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad49 {

	public static void main(String[] args) {
		String data = "I am Brad\nOK";
		try {
			FileOutputStream fout = new FileOutputStream("./dir2/file1.txt");
			fout.write(data.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
