package tw.com.ispan.myjava;

import tw.com.ispan.myclasses.TWId;

public class Brad30 {

	public static void main(String[] args) {
		TWId id1 = new TWId();
		TWId id2 = new TWId(true);
		TWId id3 = new TWId(4);
		TWId id4 = new TWId(false, 0);
		TWId id5 = TWId.createTWId("A123456780");
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		System.out.println(id5.getId());
	}

}
