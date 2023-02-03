package tw.com.ispan.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.com.ispan.myclasses.MyTable;

public class JDBC13 extends JFrame{
	private JButton add, del;
	private MyTable myTable;
	
	public JDBC13() throws Exception {
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		add = new JButton("Add"); top.add(add);
		del = new JButton("Del"); top.add(del);
		add(top, BorderLayout.NORTH);
		
		myTable = new MyTable();
		add(myTable, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		try {
			new JDBC13();
		}catch(Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}

}
