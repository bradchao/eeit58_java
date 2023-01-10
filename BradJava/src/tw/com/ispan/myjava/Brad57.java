package tw.com.ispan.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Brad57 {
	public static void main(String[] args) {
		
		try {
			ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("dir1/brad.score"));
			Student s1 = (Student)oin.readObject();
			oin.close();
			System.out.println(s1);
			System.out.println(s1.sum());
			System.out.println(s1.avg());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
