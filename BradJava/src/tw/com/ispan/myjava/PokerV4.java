package tw.com.ispan.myjava;

import java.util.ArrayList;
import java.util.Collections;

public class PokerV4 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> poker = new ArrayList<>();
		for (int i=0; i<52; i++) poker.add(i);
		Collections.shuffle(poker);
		for(Integer v : poker) {
			System.out.println(v);
		}
		System.out.println("---");
		System.out.println(System.currentTimeMillis()-start);
	}

}
