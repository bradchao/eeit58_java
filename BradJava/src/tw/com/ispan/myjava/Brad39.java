package tw.com.ispan.myjava;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad39 {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		while (set.size() < 6) {
			set.add((int)(Math.random()*49+1));
		}
		System.out.println(set);
	}

}
