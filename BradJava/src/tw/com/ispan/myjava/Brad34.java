package tw.com.ispan.myjava;

public class Brad34 {

	public static void main(String[] args) {
		Shape s1 = new RecShape(10, 4);
		Shape s2 = new CircleShape(10);
		System.out.println(s1.getArea());
		System.out.println(s2.getArea());
	}
	
	static void sum(Shape s1, Shape s2) {
		System.out.println(s1.getLength() + s2.getLength());
	}

}

interface Shape {
	double getLength();
	double getArea();
}
class RecShape implements Shape {
	double w, h;
	public RecShape(int w, int h) {
		this.w = w; this.h = h;
	}
	public double getLength() { return 2*(w+h);}
	public double getArea() { return w*h;}
}

class CircleShape implements Shape {
	double r;
	public CircleShape(double r) {
		this.r = r;
	}
	public double getLength() { return 2*Math.PI*r;}
	public double getArea() { return Math.PI*r*r;}
}


