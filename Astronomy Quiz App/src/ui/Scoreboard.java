package ui;

import utils.IncorrectlyAnsweredList;
import utils.ReportGenerator;
import utils.Result;
import utils.ScoreUpdater;
import utils.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class Scoreboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Result r = new Result();

	/**
	 * Create the frame.
	 */
	public Scoreboard() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Astronomy Quiz: Result");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(null);

		JButton btnDetailedStats = new JButton("View detailed stats");
		btnDetailedStats.setToolTipText("More information about your performance on the test.");
		btnDetailedStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Stats().setVisible(true);
			}
		});
		btnDetailedStats.setBounds(142, 156, 149, 49);
		pnlMain.add(btnDetailedStats);

		JLabel lblYourScore = new JLabel("Your score: ", SwingConstants.CENTER);
		lblYourScore.setBounds(10, 38, 414, 14);
		pnlMain.add(lblYourScore);

		JLabel lblScore = new JLabel("0", SwingConstants.CENTER);
		lblScore.setBounds(10, 96, 414, 14);
		pnlMain.add(lblScore);
		lblScore.setText(String.valueOf(r.getScore()).concat(" out of 15"));

		JButton btnBackToMenu = new JButton("Back to menu");
		btnBackToMenu.setToolTipText("Return to the main menu.");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (true) {
					int selection = JOptionPane.showConfirmDialog(null,
							"This will terminate the current session and discard any unsaved progress."
									+ "\nAre you sure you want to return to the main menu?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (selection == JOptionPane.NO_OPTION) {
						break;
					} else {
						resetAll(); 
						dispose();
						new Homepage().setVisible(true);
						break; 
					}
				}
			}
		});
		btnBackToMenu.setBounds(10, 227, 125, 23);
		pnlMain.add(btnBackToMenu);

		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Quit the application.");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (true) {
					int selection = JOptionPane.showConfirmDialog(null,
							"This will terminate the current session and discard any unsaved progress."
									+ "\nAre you sure you want to return to quit?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
					if (selection == JOptionPane.NO_OPTION) {
						break;
					} else {
						System.exit(0);
					}
				}
			}
		});
		btnExit.setBounds(299, 227, 125, 23);
		pnlMain.add(btnExit);
	}
	
	private void resetAll() {
		Timer.reset();
		ScoreUpdater.resetScore();
		IncorrectlyAnsweredList.reset();
		ReportGenerator.reset();
	}
}
