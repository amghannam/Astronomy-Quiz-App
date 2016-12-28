package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import utils.IncorrectlyAnsweredList;
import utils.ScoreUpdater;

import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TenthQuestion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public TenthQuestion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		setLocationRelativeTo(null); 
		setTitle("Astronomy Quiz: Question 10");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNextQuestion = new JButton("Next question");
		btnNextQuestion.setEnabled(false);
		
		JPanel pnlQuestion = new JPanel();
		pnlQuestion.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), 
				"Question 10", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pnlQuestion.setBounds(10, 11, 424, 80);
		contentPane.add(pnlQuestion);
		pnlQuestion.setLayout(null);
		
		JLabel lblQuestionText = new JLabel("<html> Which of the following is closest to the estimated "
				+ "age of the Solar System?");
		lblQuestionText.setBounds(10, 25, 394, 44);
		pnlQuestion.add(lblQuestionText);
		
		JPanel pnlChoices = new JPanel();
		pnlChoices.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), 
				"Select an answer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pnlChoices.setBounds(10, 102, 424, 148);
		contentPane.add(pnlChoices);
		pnlChoices.setLayout(null);
		
		JRadioButton rdbtFirst = new JRadioButton("4,500 years");
		rdbtFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtFirst.isSelected()) btnNextQuestion.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtFirst);
		rdbtFirst.setBounds(114, 9, 140, 23);
		pnlChoices.add(rdbtFirst);
		
		JRadioButton rdbtSecond = new JRadioButton("4,500,000 years");
		rdbtSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtSecond.isSelected()) btnNextQuestion.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtSecond);
		rdbtSecond.setBounds(114, 35, 140, 23);
		pnlChoices.add(rdbtSecond);
		
		JRadioButton rdbtThird = new JRadioButton("4,500,000,000 years");
		rdbtThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtThird.isSelected()) btnNextQuestion.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtThird);
		rdbtThird.setBounds(114, 61, 140, 23);
		pnlChoices.add(rdbtThird);
		
		JRadioButton rdbtFourth = new JRadioButton("4,500,000,000,000 years");
		rdbtFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtFourth.isSelected()) btnNextQuestion.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtFourth);
		rdbtFourth.setBounds(114, 92, 256, 23);
		pnlChoices.add(rdbtFourth); 
		
		JRadioButton rdbtFifth = new JRadioButton("The age of the Solar System is not yet known.");
		rdbtFifth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtFifth.isSelected()) btnNextQuestion.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtFifth);
		rdbtFifth.setBounds(114, 118, 304, 23);
		pnlChoices.add(rdbtFifth);
		
		btnNextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtThird.isSelected()) {
					ScoreUpdater.updateScore();
				} else {
					IncorrectlyAnsweredList.update("10");
				}
				dispose();
				new EleventhQuestion().setVisible(true);
			}
		});
		btnNextQuestion.setBounds(303, 261, 131, 23);
		contentPane.add(btnNextQuestion);
	}
}
