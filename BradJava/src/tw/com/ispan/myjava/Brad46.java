package tw.com.ispan.myjava;

import java.io.File;

public class Brad46 {

	public static void main(String[] args) {
		File root = new File(".");
		System.out.println(root.getAbsolutePath());
		File dir1 = new File("./dir1");
		System.out.println(dir1.exists());
		File dir2 = new File("./dir2");
		if (!dir2.exists()) {
			dir2.mkdir();
		}
		File dir3 = new File("dir3");
		if (!dir3.exists()) {
			dir3.mkdir();
		}
		
	}

}
