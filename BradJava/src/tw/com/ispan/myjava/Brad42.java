package tw.com.ispan.myjava;

import tw.com.ispan.myclasses.Bike;

public class Brad42 {

	public static void main(String[] args) {
		int a = 0, b = 3;
		int c;
		
		try {
			c = a / b;
			System.out.println(c);
			int[] d = {1,2,3,4};
			System.out.println(d[3]);
			Bike b1 = null;
			b1.upSpeed();
			
		}catch (RuntimeException e) {
			System.out.println("Err1");
		}
		
		System.out.println("Game Over");
		
	}

}
