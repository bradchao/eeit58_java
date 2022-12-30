package tw.com.ispan.myjava;

import tw.com.ispan.myclasses.Bike;

public class Brad29 {

	public static void main(String[] args) {
		String s1 = new String("abcdefg");
		String s2 = "abcdefg";
		String s3 = "abcdefg";
		String s4 = new String("abcdefg");
		int a = 10, b = 10;
		System.out.println(a == b);
		System.out.println(s2 == s3);
		System.out.println(s1.equals(s2));
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
		
		
	}

}
