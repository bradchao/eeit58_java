package tw.com.ispan.myjava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tw.com.ispan.myclasses.Bike;

public class Brad56 {

	public static void main(String[] args) {
		Student s1 = new Student("Brad", 80, 32, 13);
		System.out.println(s1);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("dir1/brad.score"));
			oout.writeObject(s1);
			oout.flush();
			oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

class Student implements Serializable {
	private int ch, eng, math;
	private String name;
	private Bike bike;
	
	Student(String name, int ch, int eng, int math){
		this.name = name;
		this.ch = ch; this.eng = eng; this.math = math;
		bike = new Bike();
	}
	int sum() {return ch + eng + math;}
	double avg() { return sum() / 3.0;}
	
	@Override
	public String toString() {
		return String.format("%s:%d:%d:%d", name, ch, eng, math);
	}
}
