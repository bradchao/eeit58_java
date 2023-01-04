package tw.com.ispan.myjava;

public class Brad36 {

	public static void main(String[] args) {
		int a = 10;
		Integer b = new Integer(10);
		System.out.println(a);
		System.out.println(b);
		byte bb = b.byteValue();
		Integer c = 10;	// auto-boxing
		System.out.println(c.byteValue());
		int d = c;	// auto-unboxing
		byte f = 12;
		//Integer e = f;
		
		
	}

}
