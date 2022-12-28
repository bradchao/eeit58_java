package tw.com.ispan.myclasses;

public class Scooter extends Bike {
	private int gear;
	private String color;
	
	public Scooter() {
		System.out.println("Scooter()");
		color = "黃色";
	}
	public Scooter(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * gear * 2.4;
	}
	
	public void upSpeed(int a) {
		
	}
	
	public boolean changeGear(int newgear) {
		if (gear >=0 || gear <=4) {
			this.gear = gear;
			return true;
		}else {
			return false;
		}
	}
	
}
