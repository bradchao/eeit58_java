package tw.com.ispan.myjava;

import java.io.File;

public class Brad45 {

	public static void main(String[] args) {
		File f1 = new File("c:/brad/dir2");
		if (!f1.exists()) {
			f1.mkdir();
		}
	}

}
