package tw.com.ispan.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.com.ispan.myclasses.MyDrawerV2;
import tw.com.ispan.myclasses.MyDrawerV3;

public class Sign extends JFrame{
	private JButton clear, undo, redo;
	private MyDrawerV3 myDrawer;
	
	public Sign() {
		super("簽名");
		
		clear = new JButton("清除");
		undo = new JButton("上一步");
		redo = new JButton("下一步");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);
		
		setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		
		myDrawer = new MyDrawerV3();
		add(myDrawer, BorderLayout.CENTER);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		init();
	}
	
	private void init() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		
	}

	public static void main(String[] args) {
		new Sign();
	}

}
