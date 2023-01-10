package tw.com.ispan.myjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tw.com.ispan.myclasses.MyDrawer;
import tw.com.ispan.myclasses.MyDrawerV3;

public class Sign extends JFrame{
	private JButton clear, undo, redo, chWidth, chColor, saveJpeg;
	private JTextField inputWidth;
	private MyDrawer myDrawer;
	
	public Sign() {
		super("簽名");
		
		clear = new JButton("清除");
		undo = new JButton("上一步");
		redo = new JButton("下一步");
		chWidth = new JButton("換粗細");
		inputWidth = new JTextField(4);
		chColor = new JButton("換顏色");
		saveJpeg = new JButton("存JPEG");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);
		top.add(inputWidth); top.add(chWidth);
		top.add(chColor); top.add(saveJpeg);
		
		setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		
		myDrawer = new MyDrawer();
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
		
		chWidth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//myDrawer.setNowWidth(Float.parseFloat(inputWidth.getText()));
			}
		});
		
		chColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		
		saveJpeg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();
			}
		});
		
	}
	
	private void changeColor() {
//		Color newColor = JColorChooser.showDialog(this, "選顏色", myDrawer.getNowColor());
//		if (newColor != null) {
//			myDrawer.setNowColor(newColor);
//		}
	}

	public static void main(String[] args) {
		new Sign();
	}

}
