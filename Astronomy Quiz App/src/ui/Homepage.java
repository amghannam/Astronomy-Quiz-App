package ui;

import utils.Timer; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class Homepage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Homepage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 362);
		setLocationRelativeTo(null); 
		setTitle("Astronomy Quiz");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem menuItem = new JMenuItem("About");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Astronomy Quiz is a 15-question general background test "
						+ "\non basic astronomy and astrophysics topics typically covered \nin a freshman-level course. "
						+ "After you have finished the test, you \nwill be able to view and save a report of "
						+ "your performance.\n\nAuthor: Ahmed Ghannam. All rights reserved (2017).", "About", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Astronomy Quiz!", SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setBounds(10, 11, 438, 24);
		pnlMain.add(lblWelcome);
		
		JButton btnBegin = new JButton("Start Quiz");
		btnBegin.setToolTipText("Click here to start the quiz. Once you start, you cannot go back.");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstQuestion nextFrame = new FirstQuestion();
				nextFrame.setVisible(true); 
				dispose();
				Timer.start();
			}
		});
		btnBegin.setBounds(171, 234, 122, 57);
		pnlMain.add(btnBegin);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(10, 46, 438, 177);
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/resources/icon.png")));
		pnlMain.add(lblIcon);
	}
}
