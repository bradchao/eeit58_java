package tw.com.ispan.myjava;

public class Brad14 {

	public static void main(String[] args) {
		byte a = 12;
		final byte b = 12;
		switch(a) {		// byte, short, char, int, String
			case 1:
				System.out.println("A");
				break;
			case 10:
				System.out.println("B");
				//break;
			case b + 2 :
				System.out.println("B");
				//break;
			default:
				System.out.println("X");
				//break;
			case 127:
				System.out.println("C");
				break;
		}
		
		System.out.println("finish");
		
		
	}

}
