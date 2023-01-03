package tw.com.ispan.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tw.com.ispan.myclasses.Bike;

public class GuessNumber extends JFrame implements ActionListener {
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private String answer;
	
	public GuessNumber() {
		super("猜數字遊戲");

		input = new JTextField();
		guess = new JButton("猜");
		log = new JTextArea();
		
		setLayout(new BorderLayout());
		add(log, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new BorderLayout());
		add(top, BorderLayout.NORTH);
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		guess.addActionListener(this);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		answer = createAnswer(3);
		//System.out.println(answer);
	}

	public static void main(String[] args) {
		new GuessNumber();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputString = input.getText();
		if (inputString.length() == 3) {
			String result = checkAB(inputString);
			log.append(inputString + ":" + result + "\n");
			input.setText("");
		}
	}
	
	private String createAnswer(int d) {
		int[] poker = new int[10];	// poker[第幾張] = 值 => 52 => 0
		boolean isRepeat;
		int rand;
		for (int i=0; i<poker.length; i++) {
			do {
				rand = (int)(Math.random()*10);	// rand 0 - 51
				
				// 檢查機制
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (poker[j] == rand) {
						// 重複了
						isRepeat = true;
						break;
					}
				}
			}while (isRepeat);
			
			poker[i] = rand;
			//System.out.println(poker[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<d; i++) {
			sb.append(poker[i]);
		}
		
		return sb.toString();
	}
	
	private String checkAB(String g) {
		//System.out.printf("%s : %s", answer, g);
		int a, b; a = b = 0;
		for (int i=0; i<answer.length(); i++) {
			if (answer.charAt(i) == g.charAt(i)) {
				a++;
			}else if (answer.indexOf(g.charAt(i)) >= 0) {
				b++;
			}
		}
		return String.format("%dA%dB", a,b);
	}

}
