package hangman;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class HangmanPanel2 extends JPanel implements ActionListener {
	public HangmanGuess guess;
	public int countWrongTotal = 0;
	HangmanButton[] buttonArray=new HangmanButton[26];
	JButton Start = new HangmanButton("START");
	public HangmanPanel2() {
		
		for (int i =0 ;i < 26 ; i++) {
			char c = (char) ('A'+i);
			buttonArray[i] = new HangmanButton(Character.toString(c));

		}
		JButton Start = new HangmanButton("START");

		guess = new HangmanGuess();
		guess.chooseWord();
		this.setSize(800, 100);
		this.setLayout(null);
		//this.setLocation(0, 470);
		this.setVisible(true);
		this.setFocusable(true);
		
		for(int i = 0; i < 26; i++) {
			this.add(buttonArray[i]);
		}
		this.add(Start);
		for(int i = 0; i < 26; i++) {
			buttonArray[i].addActionListener(this);
		}
	Start.addActionListener(this);
	for(int i = 0; i < 13; i++) {
		buttonArray[i].setBounds(3+55*i,450,50,50);
	}
	for(int i = 13; i < 26; i++) {
		buttonArray[i].setBounds(3+55*(i-13),505,50,50);
	}
	Start.setBounds(600,15,100,50);
	countWrongTotal = 0;
    }

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 65));
		g.drawChars(guess.hangmanLetters, 0, guess.charArray.length, 450, 300);
		
		Graphics2D g2=(Graphics2D)g;
		Stroke stroke=new BasicStroke(3.0f);
		g2.setStroke(stroke);
		
		g.drawLine(50, 370, 300, 370);// bottom
		g.drawLine(100, 370, 100, 70);// pole
		g.drawLine(100, 70, 200, 70);// horizontal
		g.drawLine(100, 120, 150, 70);// slash
		g.drawLine(200, 70, 200, 100);// hang

		if (guess.wrongGuess == 1) {
			g.drawOval(170, 100, 60, 60);// head
		}
		if (guess.wrongGuess == 2) {
			g.drawOval(170, 100, 60, 60);// head
			g.drawLine(200, 160, 195, 245);// body
		}
		if (guess.wrongGuess == 3) {
			g.drawOval(170, 100, 60, 60);// head
			g.drawLine(200, 160, 195, 245);// body
			g.drawLine(199, 180, 179, 240);// left arm
		}
		if (guess.wrongGuess == 4) {
			g.drawOval(170, 100, 60, 60);// head
			g.drawLine(200, 160, 195, 245);// body
			g.drawLine(199, 180, 179, 240);// left arm
			g.drawLine(199, 180, 205, 245);// right arm
		}
		if (guess.wrongGuess == 5) {
			g.drawOval(170, 100, 60, 60);// head
			g.drawLine(200, 160, 195, 245);// body
			g.drawLine(199, 180, 179, 240);// left arm
			g.drawLine(199, 180, 205, 245);// right arm
			g.drawLine(195, 245, 185, 255);// left leg
			g.drawLine(185, 255, 170, 320);
			g.drawLine(170, 320, 165, 325);
		}
		if (guess.wrongGuess == 6) {
			g.drawOval(170, 100, 60, 60);// head
			g.drawLine(200, 160, 195, 245);// body
			g.drawLine(199, 180, 179, 240);// left arm
			g.drawLine(199, 180, 205, 245);// right arm
			g.drawLine(195, 245, 185, 255);// left leg
			g.drawLine(185, 255, 170, 320);
			g.drawLine(170, 320, 165, 325);
			g.drawLine(195, 245, 205, 260);// right leg
			g.drawLine(205, 260, 210, 320);
			g.drawLine(210, 320, 215, 324);
		}
		if (guess.wrongGuess == 7) {
			g.drawOval(170, 100, 60, 60);// head
			g.drawLine(200, 160, 195, 245);// body
			g.drawLine(199, 180, 179, 240);// left arm
			g.drawLine(199, 180, 205, 245);// right arm
			g.drawLine(195, 245, 185, 255);// left leg
			g.drawLine(185, 255, 170, 320);
			g.drawLine(170, 320, 165, 325);
			g.drawLine(195, 245, 205, 260);// right leg
			g.drawLine(205, 260, 210, 320);
			g.drawLine(210, 320, 215, 324);
			g.drawLine(183, 117, 189, 123);// die die eye
			g.drawLine(189, 117, 183, 123);
			g.drawLine(207, 117, 213, 123);
			g.drawLine(213, 117, 207, 123);
			g.drawLine(200, 137, 195, 142);
			g.drawLine(200, 137, 205, 142);
			

			g.setColor(Color.RED);
			g.drawString("Hanged", 400, 180);

		for(int i = 0; i < 26; i++) {
			buttonArray[i].setEnabled(false);
		}
		if (guess.winOrLoose == true) {
			if (guess.wrongGuess == 1) {
				g.drawOval(170, 100, 60, 60);// head
				g.drawLine(200, 145, 195, 140);// smile
				g.drawLine(200, 145, 205, 140);
				g.drawLine(186, 120, 186, 120);
				g.drawLine(210, 120, 210, 120);
			}
			if (guess.wrongGuess == 2) {
				g.drawOval(170, 100, 60, 60);// head
				g.drawLine(200, 160, 195, 245);// body
				g.drawLine(200, 145, 195, 140);// smile
				g.drawLine(200, 145, 205, 140);
				g.drawLine(186, 120, 186, 120);
				g.drawLine(210, 120, 210, 120);
			}
			if (guess.wrongGuess == 3) {
				g.drawOval(170, 100, 60, 60);// head
				g.drawLine(200, 160, 195, 245);// body
				g.drawLine(199, 180, 179, 240);// left arm
				g.drawLine(200, 145, 195, 140);// smile
				g.drawLine(200, 145, 205, 140);
				g.drawLine(186, 120, 186, 120);
				g.drawLine(210, 120, 210, 120);
			}
			if (guess.wrongGuess == 4) {
				g.drawOval(170, 100, 60, 60);// head
				g.drawLine(200, 160, 195, 245);// body
				g.drawLine(199, 180, 179, 240);// left arm
				g.drawLine(199, 180, 205, 245);// right arm
				g.drawLine(200, 145, 195, 140);// smile
				g.drawLine(200, 145, 205, 140);
				g.drawLine(186, 120, 186, 120);
				g.drawLine(210, 120, 210, 120);
			}
			if (guess.wrongGuess == 5) {
				g.drawOval(170, 100, 60, 60);// head
				g.drawLine(200, 160, 195, 245);// body
				g.drawLine(199, 180, 179, 240);// left arm
				g.drawLine(199, 180, 205, 245);// right arm
				g.drawLine(195, 245, 185, 255);// left leg
				g.drawLine(185, 255, 170, 320);
				g.drawLine(170, 320, 165, 325);
				g.drawLine(200, 145, 195, 140);// smile
				g.drawLine(200, 145, 205, 140);
				g.drawLine(186, 120, 186, 120);
				g.drawLine(210, 120, 210, 120);
			}
			if (guess.wrongGuess == 6) {
				g.drawOval(170, 100, 60, 60);// head
				g.drawLine(200, 160, 195, 245);// body
				g.drawLine(199, 180, 179, 240);// left arm
				g.drawLine(199, 180, 205, 245);// right arm
				g.drawLine(195, 245, 185, 255);// left leg
				g.drawLine(185, 255, 170, 320);
				g.drawLine(170, 320, 165, 325);
				g.drawLine(195, 245, 205, 260);// right leg
				g.drawLine(205, 260, 210, 320);
				g.drawLine(210, 320, 215, 324);
				g.drawLine(200, 145, 195, 140);// smile
				g.drawLine(200, 145, 205, 140);
				g.drawLine(186, 120, 186, 120);
				g.drawLine(210, 120, 210, 120);
			}
			
			g.setColor(Color.RED);
			g.drawString("you win ~", 400, 180);	
	}
		for(int i = 0; i < 26; i++) {
			buttonArray[i].setEnabled(false);
		}
		}
		repaint();
		}

		public void actionPerformed(ActionEvent e) {
			if ((e.getSource() == Start) || (guess.wrongGuess == 7 || guess.winOrLoose == true)) {
				for(int i = 0; i < 26; i++) {
					buttonArray[i].setEnabled(true);
				}
				guess.wrongGuess = 0;
				guess.chooseWord();
				guess.winOrLoose = false;
				for (int i = 0; i < 26; i++) {
					guess.usedLetterList[i] = '-';
				}
			}
			for (int i = 0; i < 26; i++) {
				if (e.getSource() == buttonArray[i]) {
					buttonArray[i].setEnabled(false);
					char ch = (char)('a'+i);
					guess.checkWord(ch);
				}
			}
			
      }
}
	