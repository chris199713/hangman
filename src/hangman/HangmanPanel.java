package hangman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.*;
import javax.swing.*;

public class HangmanPanel extends JPanel implements ActionListener {

	public HangmanGuess guess;
	public int countWrongTotal = 0;

	private JButton[] letterButtons;
	private JButton newGame = new JButton("New Game");

	public HangmanPanel() {

		guess = new HangmanGuess();
		guess.chooseWord();
		this.setSize(800, 100);
		this.setLayout(null);
		// this.setLocation(0, 470);
		this.setVisible(true);
		this.setFocusable(true);

		letterButtons = new JButton[26];

		int i = 0;
		for (char c = 'A'; c <= 'Z'; c++, i++) {
			letterButtons[i] = new JButton("" + c);
			this.add(letterButtons[i]);
			letterButtons[i].addActionListener(this);
		}

		for (int j = 0, k = 0; j < 13; j++, k += 55) {
			letterButtons[j].setBounds(3 + k, 450, 50, 50);
		}

		for (int j = 13, k = 0; j < 26; j++, k += 55) {
			letterButtons[j].setBounds(3 + k, 505, 50, 50);
		}

		this.add(newGame);
		newGame.addActionListener(this);
		newGame.setBounds(600, 15, 100, 50);

		countWrongTotal = 0;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 65));
		g.drawChars(guess.hangmanLetters, 0, guess.charArray.length, 450, 300);

		Graphics2D g2 = (Graphics2D) g;
		Stroke stroke = new BasicStroke(3.0f);
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

			for (int j = 0; j < 26; j++) {
				letterButtons[j].setEnabled(false);
			}

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

			for (int j = 0; j < 26; j++) {
				letterButtons[j].setEnabled(false);
			}

		}

		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == newGame) || (guess.wrongGuess == 7 || guess.winOrLoose == true)) {

			for (int j = 0; j < 26; j++) {
				letterButtons[j].setEnabled(true);
			}

			guess.wrongGuess = 0;
			guess.chooseWord();
			guess.winOrLoose = false;
			for (int i = 0; i < 26; i++) {
				guess.usedLetterList[i] = '-';
			}
		}

		if (e.getSource() == letterButtons[0]) {
			letterButtons[0].setEnabled(false);
			char ch = 'a';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[1]) {
			letterButtons[1].setEnabled(false);
			char ch = 'b';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[2]) {
			letterButtons[2].setEnabled(false);
			char ch = 'c';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[3]) {
			letterButtons[3].setEnabled(false);
			char ch = 'd';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[4]) {
			letterButtons[4].setEnabled(false);
			char ch = 'e';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[5]) {
			letterButtons[5].setEnabled(false);
			char ch = 'f';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[6]) {
			letterButtons[6].setEnabled(false);
			char ch = 'g';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[7]) {
			letterButtons[7].setEnabled(false);
			char ch = 'h';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[8]) {
			letterButtons[8].setEnabled(false);
			char ch = 'i';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[9]) {
			letterButtons[9].setEnabled(false);
			char ch = 'j';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[10]) {
			letterButtons[10].setEnabled(false);
			char ch = 'k';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[11]) {
			letterButtons[11].setEnabled(false);
			char ch = 'l';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[12]) {
			letterButtons[12].setEnabled(false);
			char ch = 'm';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[13]) {
			letterButtons[13].setEnabled(false);
			char ch = 'n';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[14]) {
			letterButtons[14].setEnabled(false);
			char ch = 'o';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[15]) {
			letterButtons[15].setEnabled(false);
			char ch = 'p';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[16]) {
			letterButtons[16].setEnabled(false);
			char ch = 'q';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[17]) {
			letterButtons[17].setEnabled(false);
			char ch = 'r';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[18]) {
			letterButtons[18].setEnabled(false);
			char ch = 's';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[19]) {
			letterButtons[19].setEnabled(false);
			char ch = 't';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[20]) {
			letterButtons[20].setEnabled(false);
			char ch = 'u';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[21]) {
			letterButtons[21].setEnabled(false);
			char ch = 'v';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[22]) {
			letterButtons[22].setEnabled(false);
			char ch = 'w';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[23]) {
			letterButtons[23].setEnabled(false);
			char ch = 'x';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[24]) {
			letterButtons[24].setEnabled(false);
			char ch = 'y';
			guess.checkWord(ch);
		} else if (e.getSource() == letterButtons[25]) {
			letterButtons[25].setEnabled(false);
			char ch = 'z';
			guess.checkWord(ch);
		}

	}

}
