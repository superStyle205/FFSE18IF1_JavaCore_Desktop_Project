package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.ConnectUtil;

public class LoginView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectUtil connectUtil;
	JFrame frame;
	AppView appView;

	private JPanel contentPane;
	private JTextField txtAccount;
	private JLabel lblAccount;
	private JLabel lblPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginView frame = new LoginView();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		super("Login App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 350, 250);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtAccount = new JTextField();
		txtAccount.setBounds(130, 67, 140, 30);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);

		lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccount.setBounds(40, 65, 75, 30);
		contentPane.add(lblAccount);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(40, 106, 75, 30);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(130, 108, 140, 30);
		contentPane.add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dangNhap();
				}
			}

		});

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLogin.setForeground(new Color(100, 149, 237));
		lblLogin.setBounds(132, 11, 83, 31);
		contentPane.add(lblLogin);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangNhap();
			}
		});

		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(60, 160, 90, 25);
		contentPane.add(btnLogin);

		JButton btnCanel = new JButton("Canel");
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCanel.setBounds(185, 160, 90, 25);
		contentPane.add(btnCanel);

	}

	private void dangNhap() {
		String sql = "SELECT * FROM user WHERE userName = ? and password = ? and role = 1";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {

			String Account = txtAccount.getText();
			@SuppressWarnings("deprecation")
			String PassWord = passwordField.getText();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Account);
			statement.setString(2, PassWord);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				AppView frameApp = new AppView();
				frameApp.setVisible(true);
				dispose();
			} else if (Account.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Account và PassWord không được trống");
			} else if (PassWord.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Account và PassWord không được trống");
			} else if (result.next()) {
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
			} else {
				giaovien();
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, vui lòng kiểm tra lại");
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	private void giaovien() {
		String sql = "SELECT * FROM giaovien WHERE email = ? and SDTGV = ? ";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {

			String Account = txtAccount.getText();
			@SuppressWarnings("deprecation")
			String PassWord = passwordField.getText();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Account);
			statement.setString(2, PassWord);

			ResultSet result = statement.executeQuery();
			if (result.next()) {

				AppView frame = new AppView();
				frame.setVisible(true);
				frame.tabbedPane.remove(frame.mon_hoc);
				frame.btnThemHS.setEnabled(false);
				frame.btnSuaHS.setEnabled(false);
				frame.btnXoaHS.setEnabled(false);
				frame.btnThemGV.setEnabled(false);
				frame.btnSuaGV.setEnabled(false);
				frame.btnXoaGV.setEnabled(false);
				frame.btnThemLop.setEnabled(false);
				frame.btnSuaLop.setEnabled(false);
				frame.btnXoaLop.setEnabled(false);

				dispose();

			} else if (Account.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Account và PassWord không được trống");
			} else if (PassWord.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Account và PassWord không được trống");
			} else if (result.next()) {
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
			} else {
				hocsinh();
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, vui lòng kiểm tra lại");
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	private void hocsinh() {
		String sql = "SELECT * FROM hocsinh WHERE tenHocSinh = ? and SDTHocSinh = ? ";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {

			String Account = txtAccount.getText();
			@SuppressWarnings("deprecation")
			String PassWord = passwordField.getText();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Account);
			statement.setString(2, PassWord);

			ResultSet result = statement.executeQuery();
			if (result.next()) {

				AppView frame = new AppView();
				frame.setVisible(true);

				frame.tabbedPane.remove(frame.thong_tin_GV);
				frame.tabbedPane.remove(frame.lop);
				frame.tabbedPane.remove(frame.mon_hoc);
				frame.btnThemHS.setEnabled(false);
				frame.btnSuaHS.setEnabled(false);
				frame.btnXoaHS.setEnabled(false);
				frame.btnThemDiem.setEnabled(false);
				frame.btnSuaDiem.setEnabled(false);
				frame.btnXoaDiem.setEnabled(false);

				dispose();

			} else if (Account.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Account và PassWord không được trống");
			} else if (PassWord.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Account và PassWord không được trống");
			} else if (result.next()) {
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, vui  kiểm tra lại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
