package tw.com.ispan.myclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private BufferedImage ball0, ball1;
	private Timer timer;
	private int viewW, viewH;
	
	public MyPanel() {
		setBackground(Color.GREEN);
		
		timer = new Timer();
		
		try {
			ball0 = ImageIO.read(new File("dir1/ball0.jpg"));
			ball1 = ImageIO.read(new File("dir1/ball1.png"));
		} catch (IOException e) {
			
		}
		
		addMouseListener(new MyListener());
		timer.schedule(new RefreshTask(), 0, 16);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		viewW = getWidth(); viewH = getHeight();
		
		Graphics2D g2d = (Graphics2D)g;
		for (BallTask ball : balls) {
			g2d.drawImage(ball1, ball.x, ball.y, null);
		}
	}
	
	private LinkedList<BallTask> balls = new LinkedList<>();
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			BallTask ball = new BallTask(e.getX()-32, e.getY()-32);
			balls.add(ball);
			timer.schedule(ball, 200, 30);
		}
	}
	
	private class RefreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class BallTask extends TimerTask {
		int x, y, dx, dy;
		
		public BallTask(int x, int y) {
			this.x = x; this.y = y;
			dx = dy = 4;
		}
		
		public void run() {
			if (x <= 0 || x+64 >= viewW) {
				dx *= -1;
			}
			if (y <= 0 || y+64 >= viewH) {
				dy *= -1;
			}
			x += dx;
			y += dy;
		}
	}
	
	
}
