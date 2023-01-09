package tw.com.ispan.myjava;

public class Brad56 {

	public static void main(String[] args) {

	}

}

class Student {
	private int ch, eng, math;
	private String name;
	Student(String name, int ch, int eng, int math){
		this.name = name;
		this.ch = ch; this.eng = eng; this.math = math;
	}
	int sum() {return ch + eng + math;}
	double avg() { return sum() / 3.0;}
	
	@Override
	public String toString() {
		return String.format("%s:%d:%d:%d", name, ch, eng, math);
	}
}
