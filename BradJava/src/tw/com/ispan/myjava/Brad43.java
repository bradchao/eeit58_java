package tw.com.ispan.myjava;

public class Brad43 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		System.out.println(b1.getLegs());
		try {
			b1.setLegs(2);
			System.out.println(b1.getLegs());
		}catch(LegsException e) {
			System.out.println("XX");
		}
	}
}

class Bird {
	private int legs;
	void setLegs(int num) throws LegsException {
		if (num >=0 && num <=2) {
			legs = num;
		}else {
			throw new LegsException();
		}
	}
	int getLegs() {
		return legs;
	}
}
class LegsException extends Exception {
	
}
