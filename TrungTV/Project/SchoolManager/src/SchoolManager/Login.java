package SchoolManager;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	private JFrame login;
	private JTextField textField;
	private JPasswordField passwordField;
	

	public static void main(String[] args) {

		Login window = new Login();
		window.login.setVisible(true);
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		login = new JFrame();
		login.getContentPane().setBackground(SystemColor.menu);
		login.setTitle("LOGIN");
		login.setBounds(100, 100, 593, 355);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		login.setLocationRelativeTo(null);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(250, 87, 237, 36);
		login.getContentPane().add(textField);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String username = textField.getText();

					@SuppressWarnings("deprecation")
					String password = passwordField.getText();

					String sql = "SELECT * FROM login WHERE Username = ? and Password = ?";

					ConnectUtil connectUtil = new ConnectUtil();
					Connection conn = connectUtil.connect();
					try {
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setString(1, username);
						statement.setString(2, password);

						ResultSet result = statement.executeQuery();
						if (result.next()) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										DesktopManager frame = new DesktopManager();
										frame.setVisible(true);
										login.dispose();
										
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						} else {
							JOptionPane.showMessageDialog(null, "Please try again", "ERROR!!", 2);
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						connectUtil.disconnection(conn);
					}
				}
			}
		});
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(250, 139, 237, 36);
		login.getContentPane().add(passwordField);

		JLabel username = new JLabel("Username :");
		username.setBackground(Color.WHITE);
		username.setFont(new Font("Arial", Font.PLAIN, 18));
		username.setBounds(92, 84, 110, 43);
		login.getContentPane().add(username);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(92, 136, 110, 43);
		login.getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String username = textField.getText();

				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				String sql = "SELECT * FROM login WHERE Username = ? and Password = ?";

				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, username);
					statement.setString(2, password);

					ResultSet result = statement.executeQuery();
					if (result.next()) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									DesktopManager frame = new DesktopManager();
									frame.setVisible(true);
									login.dispose();
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "Please try again", "ERROR!!", 2);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					connectUtil.disconnection(conn);
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String username = textField.getText();

				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				String sql = "SELECT * FROM login WHERE Username = ? and Password = ?";

				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, username);
					statement.setString(2, password);

					ResultSet result = statement.executeQuery();
					if (result.next()) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									DesktopManager frame = new DesktopManager();
									frame.setVisible(true);
									login.dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "Please try again", "ERROW!!", 2);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					connectUtil.disconnection(conn);
				}
			}
		});
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.setBounds(92, 206, 172, 51);
		login.getContentPane().add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setBounds(315, 206, 172, 51);
		login.getContentPane().add(btnCancel);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(250, 16, 102, 36);
		login.getContentPane().add(lblNewLabel);
	}
}
