package tw.com.ispan.myclasses;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;

public class Line {
	private LinkedList<HashMap<String, Integer>> points;
	private Color color;
	private float width;
	
	public Line(Color color, float width) {
		this.color = color;
		this.width = width;
		points = new LinkedList<>();
	}
	
	public LinkedList<HashMap<String, Integer>> getPoints() {
		return points;
	}
	public void setPoints(LinkedList<HashMap<String, Integer>> points) {
		this.points = points;
	}
	public Color getColor() {
		return color;
	}
	public float getWidth() {
		return width;
	}
	
}
