package tw.com.ispan.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		
		g2d.setStroke(new BasicStroke(4));
		g2d.drawLine(0, 0, 100, 200);
		
	}
	
	private class MyListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Press:" + e.getX() + "," + e.getY());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("Drag:" + e.getX() + "," + e.getY());
		}
		
	}
	
	
}
