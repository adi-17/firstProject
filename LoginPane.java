package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginPane {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPane window = new LoginPane();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel(" User ID");
		lblUserId.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setBounds(103, 59, 75, 16);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblPassword.setBounds(103, 117, 75, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(261, 56, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(261, 114, 116, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(145, 199, 97, 25);
		frame.getContentPane().add(btnClear);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(302, 199, 97, 25);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 547, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
