package tw.com.ispan.myclasses;

public class Bike extends Object {
	protected double speed;
	
	public Bike() {
		System.out.println("Bike()");
	}
	
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.4;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
	}
	
	public double getSpeed() {
		return speed;
	}
	
//	@Override
//	public String toString() {
//		return "Brad";
//	}
	
	
}
