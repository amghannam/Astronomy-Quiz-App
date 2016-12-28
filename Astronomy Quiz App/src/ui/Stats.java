package ui;

import utils.ReportGenerator;
import utils.Result;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stats extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Result r = new Result(); 

	/**
	 * Create the frame.
	 */
	public Stats() {
		setTitle("Detailed Stats");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 330);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), ""
				+ "Your stats for this quiz session", TitledBorder.CENTER, TitledBorder.TOP, null, 
				new Color(0, 0, 128)));
		panel.setBounds(10, 11, 364, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScoreText = new JLabel("Total score percentage:");
		lblScoreText.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreText.setBounds(10, 41, 344, 14);
		panel.add(lblScoreText);
		
		JLabel lblScore = new JLabel("");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(10, 66, 344, 14);
		panel.add(lblScore);
		lblScore.setText(String.valueOf(r.getPercentage()).concat("%"));
		
		JLabel lblIncorrectNumText = new JLabel("Number of questions answered incorrectly:");
		lblIncorrectNumText.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrectNumText.setBounds(10, 85, 344, 14);
		panel.add(lblIncorrectNumText);
		
		JLabel lblNumIncorrect = new JLabel("");
		lblNumIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumIncorrect.setBounds(10, 110, 344, 14);
		panel.add(lblNumIncorrect);
		lblNumIncorrect.setText(String.valueOf(r.getIncorrectAnswerCount()));
		
		JLabel lblQuestionsAnsweredIncorrectlyText = new JLabel("Question(s) answered incorrectly:");
		lblQuestionsAnsweredIncorrectlyText.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionsAnsweredIncorrectlyText.setBounds(10, 127, 344, 14);
		panel.add(lblQuestionsAnsweredIncorrectlyText);
		
		JLabel lblIncorrectList = new JLabel("", SwingConstants.CENTER);
		lblIncorrectList.setBounds(10, 152, 344, 14);
		panel.add(lblIncorrectList);
		lblIncorrectList.setText(r.getIncorrectlyAnswered());
		
		JLabel lblTotalTimeTakenText = new JLabel("Total time taken to complete quiz:");
		lblTotalTimeTakenText.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTimeTakenText.setBounds(10, 177, 344, 14);
		panel.add(lblTotalTimeTakenText);
		
		JLabel lblTimeTaken = new JLabel("", SwingConstants.CENTER);
		lblTimeTaken.setBounds(10, 202, 344, 14);
		panel.add(lblTimeTaken);
		lblTimeTaken.setText(String.valueOf(r.getElapsedTime()) + " minutes");
		
		JButton btnClose = new JButton("Close");
		btnClose.setToolTipText("Close this window.");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(10, 267, 130, 23);
		contentPane.add(btnClose);
		
		JButton btnExport = new JButton("Export to file");
		btnExport.setToolTipText("Generate and save a report of your stats.");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ReportGenerator.hasGeneratedReport()) {
					JOptionPane.showMessageDialog(null, "You have already generated a report for this session.");
				} else {
					ReportGenerator.generate();
					JOptionPane.showMessageDialog(null, "Done! A copy of the report has been exported "
							+ "to your desktop."); 
				}
			}
		});
		btnExport.setBounds(244, 267, 130, 23);
		contentPane.add(btnExport);
	}
}
