package tw.com.ispan.myjava;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Brad05 {

	public static void main(String[] args) {
		// 輸入
		String s1 = JOptionPane.showInputDialog("X = ?");
		int v1 = Integer.parseInt(s1);
		String s2 = JOptionPane.showInputDialog("Y = ?");
		int v2 = Integer.parseInt(s2);
		
		// 運算
		int v3 = v1 + v2;
		int v4 = v1 - v2;
		int v5 = v1 * v2;
		int v6 = v1 / v2;	// int
		int v7 = v1 % v2;	
		
		// 輸出
//		System.out.printf("%d + %d = %d\n", v1, v2, v3);
//		System.out.printf("%d - %d = %d\n", v1, v2, v4);
//		System.out.printf("%d x %d = %d\n", v1, v2, v5);
//		System.out.printf("%d / %d = %d ...... %d\n", v1, v2, v6, v7);

		JOptionPane.showMessageDialog(null, "Hello, World");
		
		
		
	}

}
