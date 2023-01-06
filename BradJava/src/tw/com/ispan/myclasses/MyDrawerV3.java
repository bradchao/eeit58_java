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

public class MyDrawerV3 extends JPanel {
	private LinkedList<Line> lines, recycler;
	
	public MyDrawerV3() {
		setBackground(Color.YELLOW);
		
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		lines = new LinkedList<>();
		recycler = new LinkedList<>();
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
//		g2d.setColor(Color.BLUE);
//		g2d.setStroke(new BasicStroke(4));

		for (Line line  : lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			
			for (int i = 1; i< line.getPoints().size(); i++) {
				HashMap<String, Integer> p0 = line.getPoints().get(i - 1);
				HashMap<String, Integer> p1 = line.getPoints().get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));			
			}
		
		}
		
		
		
	}
	
	private class MyListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());
			
			Line line = new Line(Color.GREEN, 2);
			line.getPoints().add(point);
			
//			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
//			line.add(point);
//			
			lines.add(line);
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());

			lines.getLast().getPoints().add(point);
			//lines.getLast().add(point);
			
			repaint();
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


