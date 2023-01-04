package tw.com.ispan.myjava;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad35 extends JFrame implements ActionListener {
	private JButton b1, b2, b3;
	
	public Brad35() {
		
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String eventString = e.getActionCommand();
		if (e.getSource() == b1) {
			System.out.println("Brad B1");
		}else if (e.getSource() == b2) {
			System.out.println("Brad B2");
		}else if (e.getSource() == b3) {
			System.out.println("Brad B3");
		}
	}

	public static void main(String[] args) {
		new Brad35();
	}

}
