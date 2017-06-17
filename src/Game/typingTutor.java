package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//JFrame Class is used for making window

public class typingTutor extends JFrame {

	JLabel lblTimer, lblScore, lblWord;
	JTextField txtWord;
	JButton stopButton, startButton;

	public typingTutor() {

		// gridlayout
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		Font font = new Font("Comic Sans MS", 1, 40);

		lblTimer = new JLabel();
		lblTimer.setText("Timer: ");
		lblTimer.setFont(font);
		super.add(lblTimer);

		lblScore = new JLabel();
		lblScore.setText("Score: ");
		lblScore.setFont(font);
		super.add(lblScore);

		lblWord = new JLabel();
		// lblWord.setText("Timer ");
		lblWord.setFont(font);
		lblWord.setOpaque(true);
		// black
		lblWord.setBackground(Color.RED);
		super.add(lblWord);

		txtWord = new JTextField();
		// lblTimer.setText("Timer ");
		txtWord.setFont(font);
		super.add(txtWord);

		startButton = new JButton();
		startButton.setText("START");
		startButton.setFont(font);
		super.add(startButton);

		stopButton = new JButton();
		stopButton.setText("STOP");
		stopButton.setFont(font);
		super.add(stopButton);

		super.setTitle("Game");
		setSize(500, 500);
		setVisible(true);

	}

	public void initGame() {

	}

	public void actionPerformed() {

	}

	public void handleStart() {

	}

	public void handleStop() {

	}

	public void handleTimer() {

	}

}