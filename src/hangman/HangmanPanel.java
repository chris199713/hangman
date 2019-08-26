package hangman;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.*;
import javax.swing.*;

public class HangmanPanel extends JPanel implements ActionListener {

	public HangmanGuess guess;
	public int countWrongTotal = 0;
	protected JButton btnA = new JButton("A");
	protected JButton btnB = new JButton("B");
	protected JButton btnC = new JButton("C");
	protected JButton btnD = new JButton("D");
	protected JButton btnE = new JButton("E");
	protected JButton btnF = new JButton("F");
	protected JButton btnG = new JButton("G");
	protected JButton btnH = new JButton("H");
	protected JButton btnI = new JButton("I");
	protected JButton btnJ = new JButton("J");
	protected JButton btnK = new JButton("K");
	protected JButton btnL = new JButton("L");
	protected JButton btnM = new JButton("M");
	protected JButton btnN = new JButton("N");
	protected JButton btnO = new JButton("O");
	protected JButton btnP = new JButton("P");
	protected JButton btnQ = new JButton("Q");
	protected JButton btnR = new JButton("R");
	protected JButton btnS = new JButton("S");
	protected JButton btnT = new JButton("T");
	protected JButton btnU = new JButton("U");
	protected JButton btnV = new JButton("V");
	protected JButton btnW = new JButton("W");
	protected JButton btnX = new JButton("X");
	protected JButton btnY = new JButton("Y");
	protected JButton btnZ = new JButton("Z");
	protected JButton newGame = new JButton("New Game");

	public HangmanPanel() {

		guess = new HangmanGuess();
		guess.chooseWord();
		this.setSize(800, 100);
		this.setLayout(null);
		//this.setLocation(0, 470);
		this.setVisible(true);
		this.setFocusable(true);

		this.add(btnA);
		this.add(btnB);
		this.add(btnC);
		this.add(btnD);
		this.add(btnE);
		this.add(btnF);
		this.add(btnG);
		this.add(btnH);
		this.add(btnI);
		this.add(btnJ);
		this.add(btnK);
		this.add(btnL);
		this.add(btnM);
		this.add(btnN);
		this.add(btnO);
		this.add(btnP);
		this.add(btnQ);
		this.add(btnR);
		this.add(btnS);
		this.add(btnT);
		this.add(btnU);
		this.add(btnV);
		this.add(btnW);
		this.add(btnX);
		this.add(btnY);
		this.add(btnZ);

		this.add(newGame);

		btnA.addActionListener(this);
		btnB.addActionListener(this);
		btnC.addActionListener(this);
		btnD.addActionListener(this);
		btnE.addActionListener(this);
		btnF.addActionListener(this);
		btnG.addActionListener(this);
		btnH.addActionListener(this);
		btnI.addActionListener(this);
		btnJ.addActionListener(this);
		btnK.addActionListener(this);
		btnL.addActionListener(this);
		btnM.addActionListener(this);
		btnN.addActionListener(this);
		btnO.addActionListener(this);
		btnP.addActionListener(this);
		btnQ.addActionListener(this);
		btnR.addActionListener(this);
		btnS.addActionListener(this);
		btnT.addActionListener(this);
		btnU.addActionListener(this);
		btnV.addActionListener(this);
		btnW.addActionListener(this);
		btnX.addActionListener(this);
		btnY.addActionListener(this);
		btnZ.addActionListener(this);

		newGame.addActionListener(this);

		btnA.setBounds(3,450,50, 50);
		btnB.setBounds(58,450,50, 50);
		btnC.setBounds(113,450,50, 50);
		btnD.setBounds(168,450,50, 50);
		btnE.setBounds(223,450,50, 50);
		btnF.setBounds(278,450,50, 50);
		btnG.setBounds(333,450,50, 50);
		btnH.setBounds(388,450,50, 50);
		btnI.setBounds(443,450,50, 50);
		btnJ.setBounds(498,450,50, 50);
		btnK.setBounds(553,450,50, 50);
		btnL.setBounds(608,450,50, 50);//
		btnM.setBounds(663,450,50, 50);
		btnN.setBounds(3,505,50, 50);
		btnO.setBounds(58,505,50, 50);
		btnP.setBounds(113,505,50, 50);
		btnQ.setBounds(168,505,50, 50);
		btnR.setBounds(223,505,50, 50);
		btnS.setBounds(278,505,50, 50);
		btnT.setBounds(333,505,50, 50);
		btnU.setBounds(388,505,50, 50);
		btnV.setBounds(443,505,50, 50);
		btnW.setBounds(498,505,50, 50);
		btnX.setBounds(553,505,50, 50);
		btnY.setBounds(608,505,50, 50);
		btnZ.setBounds(663,505,50, 50);
		
		newGame.setBounds(600, 15, 100, 50);

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
			
			btnA.setEnabled(false);
			btnB.setEnabled(false);
			btnC.setEnabled(false);
			btnD.setEnabled(false);
			btnE.setEnabled(false);
			btnF.setEnabled(false);
			btnG.setEnabled(false);
			btnH.setEnabled(false);
			btnI.setEnabled(false);
			btnJ.setEnabled(false);
			btnK.setEnabled(false);
			btnL.setEnabled(false);
			btnM.setEnabled(false);
			btnN.setEnabled(false);
			btnO.setEnabled(false);
			btnP.setEnabled(false);
			btnQ.setEnabled(false);
			btnR.setEnabled(false);
			btnS.setEnabled(false);
			btnT.setEnabled(false);
			btnU.setEnabled(false);
			btnV.setEnabled(false);
			btnW.setEnabled(false);
			btnX.setEnabled(false);
			btnY.setEnabled(false);
			btnZ.setEnabled(false);
			

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
			
			btnA.setEnabled(false);
			btnB.setEnabled(false);
			btnC.setEnabled(false);
			btnD.setEnabled(false);
			btnE.setEnabled(false);
			btnF.setEnabled(false);
			btnG.setEnabled(false);
			btnH.setEnabled(false);
			btnI.setEnabled(false);
			btnJ.setEnabled(false);
			btnK.setEnabled(false);
			btnL.setEnabled(false);
			btnM.setEnabled(false);
			btnN.setEnabled(false);
			btnO.setEnabled(false);
			btnP.setEnabled(false);
			btnQ.setEnabled(false);
			btnR.setEnabled(false);
			btnS.setEnabled(false);
			btnT.setEnabled(false);
			btnU.setEnabled(false);
			btnV.setEnabled(false);
			btnW.setEnabled(false);
			btnX.setEnabled(false);
			btnY.setEnabled(false);
			btnZ.setEnabled(false);

		}

		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == newGame) || (guess.wrongGuess == 7 || guess.winOrLoose == true)) {

			btnA.setEnabled(true);
			btnB.setEnabled(true);
			btnC.setEnabled(true);
			btnD.setEnabled(true);
			btnE.setEnabled(true);
			btnF.setEnabled(true);
			btnG.setEnabled(true);
			btnH.setEnabled(true);
			btnI.setEnabled(true);
			btnJ.setEnabled(true);
			btnK.setEnabled(true);
			btnL.setEnabled(true);
			btnM.setEnabled(true);
			btnN.setEnabled(true);
			btnO.setEnabled(true);
			btnP.setEnabled(true);
			btnQ.setEnabled(true);
			btnR.setEnabled(true);
			btnS.setEnabled(true);
			btnT.setEnabled(true);
			btnU.setEnabled(true);
			btnV.setEnabled(true);
			btnW.setEnabled(true);
			btnX.setEnabled(true);
			btnY.setEnabled(true);
			btnZ.setEnabled(true);

			guess.wrongGuess = 0;
			guess.chooseWord();
			guess.winOrLoose = false;
			for (int i = 0; i < 26; i++) {
				guess.usedLetterList[i] = '-';
			}
		}

		if (e.getSource() == btnA) {
			btnA.setEnabled(false);
			char ch = 'a';
			guess.checkWord(ch);
		} else if (e.getSource() == btnB) {
			btnB.setEnabled(false);
			char ch = 'b';
			guess.checkWord(ch);
		} else if (e.getSource() == btnC) {
			btnC.setEnabled(false);
			char ch = 'c';
			guess.checkWord(ch);
		} else if (e.getSource() == btnD) {
			btnD.setEnabled(false);
			char ch = 'd';
			guess.checkWord(ch);
		} else if (e.getSource() == btnE) {
			btnE.setEnabled(false);
			char ch = 'e';
			guess.checkWord(ch);
		} else if (e.getSource() == btnF) {
			btnF.setEnabled(false);
			char ch = 'f';
			guess.checkWord(ch);
		} else if (e.getSource() == btnG) {
			btnG.setEnabled(false);
			char ch = 'g';
			guess.checkWord(ch);
		} else if (e.getSource() == btnH) {
			btnH.setEnabled(false);
			char ch = 'h';
			guess.checkWord(ch);
		} else if (e.getSource() == btnI) {
			btnI.setEnabled(false);
			char ch = 'i';
			guess.checkWord(ch);
		} else if (e.getSource() == btnJ) {
			btnJ.setEnabled(false);
			char ch = 'j';
			guess.checkWord(ch);
		} else if (e.getSource() == btnK) {
			btnK.setEnabled(false);
			char ch = 'k';
			guess.checkWord(ch);
		} else if (e.getSource() == btnL) {
			btnL.setEnabled(false);
			char ch = 'l';
			guess.checkWord(ch);
		} else if (e.getSource() == btnM) {
			btnM.setEnabled(false);
			char ch = 'm';
			guess.checkWord(ch);
		} else if (e.getSource() == btnN) {
			btnN.setEnabled(false);
			char ch = 'n';
			guess.checkWord(ch);
		} else if (e.getSource() == btnO) {
			btnO.setEnabled(false);
			char ch = 'o';
			guess.checkWord(ch);
		} else if (e.getSource() == btnP) {
			btnP.setEnabled(false);
			char ch = 'p';
			guess.checkWord(ch);
		} else if (e.getSource() == btnQ) {
			btnQ.setEnabled(false);
			char ch = 'q';
			guess.checkWord(ch);
		} else if (e.getSource() == btnR) {
			btnR.setEnabled(false);
			char ch = 'r';
			guess.checkWord(ch);
		} else if (e.getSource() == btnS) {
			btnS.setEnabled(false);
			char ch = 's';
			guess.checkWord(ch);
		} else if (e.getSource() == btnT) {
			btnT.setEnabled(false);
			char ch = 't';
			guess.checkWord(ch);
		} else if (e.getSource() == btnU) {
			btnU.setEnabled(false);
			char ch = 'u';
			guess.checkWord(ch);
		} else if (e.getSource() == btnV) {
			btnV.setEnabled(false);
			char ch = 'v';
			guess.checkWord(ch);
		} else if (e.getSource() == btnW) {
			btnW.setEnabled(false);
			char ch = 'w';
			guess.checkWord(ch);
		} else if (e.getSource() == btnX) {
			btnX.setEnabled(false);
			char ch = 'x';
			guess.checkWord(ch);
		} else if (e.getSource() == btnY) {
			btnY.setEnabled(false);
			char ch = 'y';
			guess.checkWord(ch);
		} else if (e.getSource() == btnZ) {
			btnZ.setEnabled(false);
			char ch = 'z';
			guess.checkWord(ch);
		}

	}

}

