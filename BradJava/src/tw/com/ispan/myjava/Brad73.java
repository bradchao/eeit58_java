package tw.com.ispan.myjava;

import tw.com.ispan.myclasses.BCrypt;

public class Brad73 {

	public static void main(String[] args) {
		String passwd = "123456";
		String passwd2 = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(passwd2);
		
		String passwd3 = "123455";
		if (BCrypt.checkpw(passwd3, passwd2)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
