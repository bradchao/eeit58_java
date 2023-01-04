package tw.com.ispan.myjava;

import java.util.HashSet;
import java.util.Iterator;

public class Brad38 {

	public static void main(String[] args) {
		HashSet<String> names = new HashSet<>();
		names.add("Brad");
		names.add("Peter");
		names.add("Peter");
		names.add("Eric");
		names.add("Andy");
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
		System.out.println("----");
		for(String name : names) {
			System.out.println(name);
		}
		
		
	}

}
