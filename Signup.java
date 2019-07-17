package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class Signup {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCno;
	private JTextField txtAddress;
	private JTextField txtUserid;
	private JTextField txtPass;
	private JTextField txtEmail;
	private JTable table;
	private JTextField txtGender;

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}
		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}
		return new DefaultTableModel(data, columnNames);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
		try {
			Connection cn = ConnectionUtils.getConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from student_details;");
			table.setModel(buildTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.txtName, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 611, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtId = new JTextField();
		txtId.setBounds(205, 60, 116, 22);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(205, 95, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAge = new JTextField();
		txtAge.setBounds(205, 136, 116, 22);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);

		txtCno = new JTextField();
		txtCno.setBounds(205, 171, 116, 22);
		frame.getContentPane().add(txtCno);
		txtCno.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(205, 206, 116, 22);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtUserid = new JTextField();
		txtUserid.setBounds(205, 241, 116, 22);
		frame.getContentPane().add(txtUserid);
		txtUserid.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(205, 276, 116, 22);
		frame.getContentPane().add(txtPass);
		txtPass.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(205, 311, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBackground(new Color(255, 255, 255));
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setBounds(56, 63, 111, 16);
		frame.getContentPane().add(lblId);

		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(56, 98, 111, 16);
		frame.getContentPane().add(lblName);

		JLabel lblAge = new JLabel("AGE");
		lblAge.setForeground(new Color(0, 0, 0));
		lblAge.setBounds(56, 133, 111, 16);
		frame.getContentPane().add(lblAge);

		JLabel lblCno = new JLabel("CONTACT NUMBER");
		lblCno.setForeground(new Color(0, 0, 0));
		lblCno.setBounds(56, 174, 111, 16);
		frame.getContentPane().add(lblCno);

		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setBounds(56, 209, 111, 16);
		frame.getContentPane().add(lblAddress);

		JLabel lblUserid = new JLabel("USER ID");
		lblUserid.setForeground(new Color(0, 0, 0));
		lblUserid.setBounds(56, 244, 111, 16);
		frame.getContentPane().add(lblUserid);

		JLabel lblPass = new JLabel("PASSWORD");
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setBounds(56, 279, 111, 16);
		frame.getContentPane().add(lblPass);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBounds(56, 314, 111, 16);
		frame.getContentPane().add(lblEmail);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(SystemColor.activeCaptionText);
		btnDelete.setBackground(UIManager.getColor("RadioButtonMenuItem.foreground"));
		btnDelete.setBounds(406, 188, 97, 25);
		frame.getContentPane().add(btnDelete);

		JButton btnUpdate = new JButton(" Update");
		btnUpdate.setForeground(SystemColor.activeCaptionText);
		btnUpdate.setBackground(UIManager.getColor("RadioButtonMenuItem.background"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setBounds(406, 240, 97, 25);
		frame.getContentPane().add(btnUpdate);

		JButton btnSignup = new JButton("SignUp");
		btnSignup.setForeground(SystemColor.activeCaptionText);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Driver Manager Driver Load
				// Connection
				// Statement - Prepared Statement
				// Result Set

				try {
					String sqlInsert = "INSERT INTO studentdb.student_details" + "(name," + "age," + "contactnumber,"
							+ "address," + "userid," + "pasword," + "emailaddress," + "gender," + "student_detailscol)"
							+ "VALUES" + "(?,?,?,?,?,?,?,?,?);";
					Connection cnctn = ConnectionUtils.getConnection();
					PreparedStatement stmt = cnctn.prepareStatement(sqlInsert);
					stmt.setString(1, txtName.getText());
					stmt.setInt(2, Integer.parseInt(txtAge.getText()));
					stmt.setString(3, txtCno.getText());
					stmt.setString(4, txtAddress.getText());
					stmt.setString(5, txtUserid.getText());
					stmt.setString(6, txtPass.getText());
					stmt.setString(7, txtEmail.getText());
					stmt.setString(8, txtGender.getText());
					stmt.setString(9, "-NA-");
					int noOfRows = stmt.executeUpdate();
					JOptionPane.showMessageDialog(btnSignup, noOfRows + " Record Updated");
					// cnctn.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(btnSignup, "Error " + e1.getMessage());
				}

			}
		});
		btnSignup.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
		btnSignup.setBounds(126, 434, 266, 25);
		frame.getContentPane().add(btnSignup);

		table = new JTable();
		table.setBounds(582, 563, -565, -72);
		frame.getContentPane().add(table);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setBounds(56, 349, 111, 16);
		frame.getContentPane().add(lblGender);

		txtGender = new JTextField();
		txtGender.setBounds(205, 346, 116, 22);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);

		JLabel lblWelcomeToTraining = new JLabel("Welcome to Training Basket");
		lblWelcomeToTraining.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToTraining.setFont(new Font("Georgia", Font.BOLD, 17));
		lblWelcomeToTraining.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		lblWelcomeToTraining.setBounds(79, 13, 357, 34);
		frame.getContentPane().add(lblWelcomeToTraining);

		JCheckBox chkbxAgree = new JCheckBox("Agree to Terms & Conditions");
		chkbxAgree.setFont(new Font("Sitka Display", Font.ITALIC, 11));
		chkbxAgree.setBounds(412, 409, 161, 16);
		frame.getContentPane().add(chkbxAgree);

	}

}
