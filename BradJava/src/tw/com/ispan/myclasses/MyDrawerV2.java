package tw.com.ispan.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyDrawerV2 extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycler;
	
	public MyDrawerV2() {
		setBackground(Color.YELLOW);
		
		MyListener listener = new MyListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		lines = new LinkedList<>();
		recycler = new LinkedList<>();
		
	}
	
	LinkedList<LinkedList<HashMap<String, Integer>>> getLines(){
		return lines;
	}
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));

		for (LinkedList<HashMap<String, Integer>> line  : lines) {
			for (int i = 1; i< line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i - 1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));			
			}
		
		}
		
		
		
	}
	
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		recycler.add(lines.removeLast());
		repaint();
	}
	
	public void redo() {
		lines.add(recycler.removeLast());
		repaint();
	}
}

class MyListener extends MouseAdapter {
	private MyDrawerV2 myDrawerV2;
	
	public MyListener(MyDrawerV2 myDrawerV2) {
		this.myDrawerV2 = myDrawerV2;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		HashMap<String, Integer> point = new HashMap<>();
		point.put("x", e.getX()); point.put("y", e.getY());
		
		LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
		line.add(point);
		
		myDrawerV2.getLines().add(line);
		myDrawerV2.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		HashMap<String, Integer> point = new HashMap<>();
		point.put("x", e.getX()); point.put("y", e.getY());

		myDrawerV2.getLines().getLast().add(point);
//		line.add(point);
		
		myDrawerV2.repaint();
	}
	
}







