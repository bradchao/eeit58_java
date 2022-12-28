package tw.com.ispan.myjava;

import tw.com.ispan.myclasses.Bike;

public class Brad25 {
	public static void main(String[] args) {
		Bike bike1 = new Bike();
		Bike bike2 = new Bike();
		bike1.upSpeed();bike1.upSpeed();bike1.upSpeed();bike1.upSpeed();
		bike2.upSpeed();bike2.upSpeed();bike2.upSpeed();bike2.downSpeed();
		System.out.println(bike1.getSpeed());
		System.out.println(bike2.getSpeed());
		
		System.out.println(bike1.getSpeed());
		
	}
}
