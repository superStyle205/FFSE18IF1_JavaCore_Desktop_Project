package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.dao.LoginDao;
import view.ApplicationFrame;

public class LoginMainJFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
	private JLabel lblDangNhap;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;

	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;

	private JButton btnLogin;
	private JButton btnReset;
	private JButton btnExit;
	private JCheckBox ViewPass;
	private JLabel lblViewPass;

	private LoginDao loginDao;

	public LoginMainJFrame() {
		super("ĐĂNG NHẬP PHẦN MỀM QUẢN LÝ TRƯỜNG HỌC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\school.png"));
		setBounds(434, 191, 981, 652);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		loginDao = new LoginDao();
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(40, 40, 885, 525);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setAlignmentX(CENTER_ALIGNMENT);
		lblDangNhap.setFont(new Font("SVN-Agency FB", Font.BOLD, 50));
		lblDangNhap.setBounds(350, 42, 205, 57);
		panel.add(lblDangNhap);

		lblTaiKhoan = new JLabel("Tài Khoản :");
		lblTaiKhoan.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTaiKhoan.setBounds(126, 167, 122, 33);
		panel.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(260, 160, 462, 42);
		panel.add(txtTaiKhoan);

		lblMatKhau = new JLabel("Mật Khẩu :");
		lblMatKhau.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblMatKhau.setBounds(126, 290, 122, 33);
		panel.add(lblMatKhau);

		btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\login.png"));
		btnLogin.addActionListener(this);
		btnLogin.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLogin.setForeground(Color.RED);
		btnLogin.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnLogin.setBounds(126, 419, 152, 77);
		getRootPane().setDefaultButton(btnLogin);
		panel.add(btnLogin);

		btnReset = new JButton("RESET");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\reset.png"));
		btnReset.addActionListener(this);
		btnReset.setHorizontalTextPosition(SwingConstants.LEFT);
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnReset.setBounds(388, 419, 152, 77);
		panel.add(btnReset);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(260, 282, 462, 42);
		panel.add(txtMatKhau);

		btnExit = new JButton("EXIT");
		btnExit.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\exit.png"));
		btnExit.addActionListener(this);

		btnExit.setHorizontalTextPosition(SwingConstants.LEFT);
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnExit.setBounds(642, 419, 152, 77);
		panel.add(btnExit);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(126, 378, 668, 2);
		panel.add(separator_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(126, 131, 668, 2);
		panel.add(separator);

		ViewPass = new JCheckBox("");
		ViewPass.addActionListener(this);
		ViewPass.setBounds(730, 282, 39, 41);
		panel.add(ViewPass);

		lblViewPass = new JLabel("");
		lblViewPass.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\view.png"));
		lblViewPass.setBounds(777, 282, 42, 41);
		panel.add(lblViewPass);

	}

	@SuppressWarnings("deprecation")
	private void Login() {
		String MatKhau = txtMatKhau.getText();
		String TaiKhoan = txtTaiKhoan.getText();

		if (txtMatKhau.getText().equals("") || txtTaiKhoan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tài khoản và mật khẩu");
		} else {
			if (loginDao.LoginJframe(TaiKhoan, MatKhau) == false) {
				JOptionPane.showMessageDialog(null, "Bạn Nhập Sai Tài Khoản Hoặc Mật Khẩu");

			} else {
				JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công ");
				ApplicationFrame application = new ApplicationFrame();
				application.main(null);
			}
		}

	}

	private void ExitLogin() {
		jFrame = new JFrame("Exit");
		if (JOptionPane.showConfirmDialog(jFrame, "Xác Nhận Nếu Bạn Muốn Thoát", "Thoát",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}

	private void ViewPass() {

		if (ViewPass.isSelected()) {
			txtMatKhau.setEchoChar((char) 0);
		} else {
			txtMatKhau.setEchoChar('*');
		}

	}

	private void ResetLogin() {

		txtTaiKhoan.setText(null);
		txtMatKhau.setText(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object action = e.getSource();
		if (action == btnLogin) {
			Login();
		} else if (action == btnExit) {
			ExitLogin();
		} else if (action == ViewPass) {
			ViewPass();
		} else if (action == btnReset) {
			ResetLogin();
		}
	}

	public static void main(String[] args) {

		LoginMainJFrame loginJFrame = new LoginMainJFrame();
		loginJFrame.setVisible(true);
	}
}
