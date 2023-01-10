package tw.com.ispan.myjava;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.com.ispan.myclasses.MyPanel;

public class MyBallGame extends JFrame {
	private MyPanel myPanel;
	
	public MyBallGame() {
	
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyBallGame();
	}
}
