package tw.com.ispan.myjava;

import tw.com.ispan.myclasses.Bike;

public class Brad32 {

	public static void main(String[] args) {
		Brad321 obj1 = new Brad321();
		Brad322 obj2 = new Brad322();
		Brad321 obj3 = new Brad322();
		obj3.m1();
		Brad322 obj4 = (Brad322)obj3;
		obj4.m2();
		System.out.println("---");
		test1(obj3);
		System.out.println("---");
		//Brad322 obj5 = (Brad322)obj1;
		
		if (obj3 instanceof Brad321) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	}
	
	static void test1( Brad321 obj) {
		obj.m1();
	}

}
class Brad321 {
	void m1() {
		System.out.println("Brad321:m1()");
	}
}
class Brad322 extends Brad321 {
	void m1() {
		System.out.println("Brad322:m1()");
	}
	void m2() {
		System.out.println("Brad322:m2()");
	}
}
class Brad323 extends Brad321 {
	void m1() {
		System.out.println("Brad323:m1()");
	}
	void m2() {
		System.out.println("Brad323:m2()");
	}
}
