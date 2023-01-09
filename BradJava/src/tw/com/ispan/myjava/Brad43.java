package tw.com.ispan.myjava;

public class Brad43 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		System.out.println(b1.getLegs());
		try {
			b1.setLegs(-3);
			System.out.println(b1.getLegs());
		}catch(LegsException e) {
			e.showMessage();
		}
	}
}

class Bird {
	private int legs;
	void setLegs(int num) throws LegsException {
		if (num >=0 && num <=2) {
			legs = num;
		}else if (num < 0){
			throw new LegsException("xxx1");
		}else if (num > 2){
			throw new LegsException("xxx2");
		}
	}
	int getLegs() {
		return legs;
	}
}
class LegsException extends Exception {
	private String mesg;
	public LegsException(String mesg) {
		this.mesg = mesg;
	}
	
	public void showMessage() {
		System.out.println(mesg);
	}
}
