package hangman;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HangmanFrame {
	
	HangmanPanel panel;
	
	public HangmanFrame() {
		panel = new HangmanPanel();		
		JFrame frame = new JFrame();
		frame.setTitle("Hangman");
		frame.setSize(730,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}

