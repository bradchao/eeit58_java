package tw.com.ispan.myjava;

public class Brad31 {
	public static void main(String[] args) {
		//Brad313 obj1 = new Brad313();
		Brad313 obj2 = new Brad313(2);
	}
}

class Brad311 {
	Brad311(int a){System.out.println("Brad311(int)");}
}
class Brad312 extends Brad311 {
	Brad312(){super(1);System.out.println("Brad312()");}
	Brad312(int b){super(2);System.out.println("Brad312(int)");}
}
class Brad313 extends Brad312 {
	Brad313(){
		super(3);
		//this(3);
		System.out.println("Brad313()");
	}
	Brad313(int a){
		this();
		System.out.println("Brad313(int)");
	}
}
