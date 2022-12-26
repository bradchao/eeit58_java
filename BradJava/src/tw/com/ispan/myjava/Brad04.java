package tw.com.ispan.myjava;

import java.util.Scanner;

public class Brad04 {

	public static void main(String[] args) {
		// 輸入
		Scanner scanner = new Scanner(System.in);
		System.out.print("X = ");
		int v1 = scanner.nextInt();
		System.out.print("Y = ");
		int v2 = scanner.nextInt();
		
		// 運算
		int v3 = v1 + v2;
		int v4 = v1 - v2;
		int v5 = v1 * v2;
		int v6 = v1 / v2;
		
		// 輸出
		System.out.printf("%d + %d = %d\n", v1, v2, v3);
		System.out.printf("%d - %d = %d\n", v1, v2, v4);
		System.out.printf("%d x %d = %d\n", v1, v2, v5);
		System.out.printf("%d / %d = %d\n", v1, v2, v6);
		
		
	}

}
