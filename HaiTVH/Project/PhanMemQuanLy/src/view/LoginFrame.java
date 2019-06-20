package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import connect.ConnectUtil;
import dao.Login;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null); // canh giữa màn hình
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null); // xét layout
		contentPane.setBackground(new Color(209, 220, 241));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/Apps-preferences-system-login-icon.png"));
		setContentPane(contentPane);

		Border bd = BorderFactory.createLineBorder(Color.CYAN, 2);
		contentPane.setBorder(bd);

		// thông báo có muốn thoát chương trình hay không

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				int hoi = JOptionPane.showConfirmDialog(null, "                 Thoát hả?", null,
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangNhap();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(244, 190, 133, 42);
		btnNewButton.setIcon(new ImageIcon("icon/User-Interface-Login-icon (1).png"));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(55, 44, 93, 32);
		contentPane.add(lblNewLabel);

		JButton button = new JButton("Hủy");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(69, 190, 133, 42);
		button.setIcon(new ImageIcon("C:/Users/Admin/Desktop/JAVA/PhanMemQuanLy/icon/Delete-icon (1).png"));
		contentPane.add(button);

		JLabel label = new JLabel("PassWord");
		label.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		label.setBounds(55, 115, 93, 32);
		contentPane.add(label);

		textField = new JTextField(5);
		textField.setBounds(176, 40, 201, 42);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField(10);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dangNhap();
				}
			}
		});
		passwordField.setBounds(176, 111, 201, 42);
		contentPane.add(passwordField);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 170, 414, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 11, 414, 2);
		contentPane.add(separator_1);
	}

	public void dangNhap() {

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		String sqlsv = "SELECT * FROM project.sinhvien WHERE hoten=? AND idhs=? ";

		String dangNhap = textField.getText();
		@SuppressWarnings("deprecation")
		String matKhau = passwordField.getText();

		try {
			PreparedStatement statement = conn.prepareStatement(sqlsv);

			if (dangNhap.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Username không được để trống !");
			} else if (matKhau.toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "Password không được để trống !");
			} else {
				statement.setString(1, dangNhap);
				statement.setString(2, matKhau);

				ResultSet result = statement.executeQuery();

				if (result.next()) {
					String a = dangNhap, b = result.getString("hoten");
					if (a.equalsIgnoreCase(b)) {

						Login login = new Login(result.getString("hoten"), result.getString("idhs"),
								"Xin chào học sinh");

						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

						FrMain mainForm = new FrMain(login);
						mainForm.setVisible(true);

						this.dispose();

						mainForm.tabbedPane.remove(mainForm.quan_ly); // Xoa tab ql

					}
				} else {
					giaovien();
				}
			}
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập \n" + e2);
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	public void giaovien() {

		String sqlgv = "SELECT * FROM project.giaovien WHERE hoten=? AND pass=? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		String dangNhap = textField.getText();
		@SuppressWarnings("deprecation")
		String matKhau = passwordField.getText();

		try {

			PreparedStatement statement = conn.prepareStatement(sqlgv);
			statement = conn.prepareStatement(sqlgv);
			statement.setString(1, dangNhap);
			statement.setString(2, matKhau);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				String a = dangNhap, b = result.getString("hoten");
				if (a.equalsIgnoreCase(b)) {

					Login login = new Login(result.getString("hoten"), result.getString("idgv"), "Xin chào giáo viên ");

					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

					FrMain mainForm = new FrMain(login);

					this.dispose();

					mainForm.setVisible(true);
					mainForm.btnQlgv.setEnabled(false);
					mainForm.btnQlLop.setEnabled(false);
					mainForm.btnQlMon.setEnabled(false);
					mainForm.btnQLTaiKhoan.setEnabled(false);
				}
			} else {
				giaovu();
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập \n" + e1);
		}
	}

	public void giaovu() {

		String sql = "SELECT * FROM project.users WHERE username=? AND pass=? and role = 2";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		String dangNhap = textField.getText();
		@SuppressWarnings("deprecation")
		String matKhau = passwordField.getText();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, dangNhap);
			statement.setString(2, matKhau);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				String a = dangNhap, b = result.getString("username");
				if (a.equalsIgnoreCase(b)) {
					Login login = new Login(result.getString("username"), result.getString("FullName"),
							"Xin chào Giáo Vụ");
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

					FrMain mainForm = new FrMain(login);

					this.dispose();
					mainForm.setVisible(true);
					mainForm.btnDiem.setEnabled(false);
					mainForm.btnQLTaiKhoan.setEnabled(false);

				}
			} else {
				admin();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập" + e1);
		}
	}

	public void admin() {

		String sql = "SELECT * FROM project.users WHERE username=? AND pass=? and role = 1";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		String dangNhap = textField.getText();
		@SuppressWarnings("deprecation")
		String matKhau = passwordField.getText();
		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, dangNhap);
			statement.setString(2, matKhau);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				String a = dangNhap, b = result.getString("username");
				if (a.equals(b)) {

					Login login = new Login(result.getString("username"), result.getString("FullName"),
							"Xin chào ADMIN");
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

					textField.setText("");
					passwordField.setText("");

					FrMain mainForm = new FrMain(login);

					this.dispose();
					mainForm.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, mật khẩu hoặc tài khoản không đúng !", null,
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập" + e1);
			System.out.println(e1);
		}
	}

}
