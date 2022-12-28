package tw.com.ispan.myjava;

public class Brad21 {

	public static void main(String[] args) {
		int[][] a = new int[3][];
		a[0] = new int[4];
		a[1] = new int[2];
		a[2] = new int[3];
		
		a[0][1] = 123;
		a[0][2] = 17;
		a[1][0] = 32;
		a[2][2] = 67;
		
		for(int[] v : a) {
			for(int vv : v) {
				System.out.print(vv + " ");
			}
			System.out.println();
		}
		System.out.println("---");
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
