package tw.com.ispan.myjava;

public class Brad20 {

	public static void main(String[] args) {
		int[] p = new int[7];	// p[0]=0, p[1]=0,....p[6]=0;
		
		for (int i=0; i<1000000; i++) {
			int rand = (int)(Math.random()*9+1);
			p[rand>6?rand-3:rand]++;
		}

//		for (int i=0; i<=6; i++) {
//			System.out.printf("%d點出現%d次\n", i, p[i]);
//		}
		
		for (int i=0; i<p.length; i++) {
			System.out.println(p[i]);
		}
		System.out.println("---");
		// for-each p
		for (int v : p) {
			System.out.println(v);
		}
		
	}

}
