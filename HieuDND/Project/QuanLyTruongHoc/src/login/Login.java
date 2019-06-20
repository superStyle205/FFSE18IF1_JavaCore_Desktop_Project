package login;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import display.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton Login;
	private JPanel panel;
	private JLabel Username, Password;
	private JLabel login;

	private TitledBorder borderTitle;
	private Border border;

	public Login() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Welcome");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setTitle("ĐĂNG NHẬP QUẢN LÝ TRƯỜNG HỌC");

		Font fontLogin = new Font("Arial", Font.BOLD | Font.PLAIN, 40);
		JPanel lbLogin = new JPanel();
		login = new JLabel("Quản Lý Trường Học");
		login.setFont(fontLogin);
		lbLogin.add(login);
		border = BorderFactory.createLineBorder(Color.CYAN, 2, true);
		borderTitle = BorderFactory.createTitledBorder(border);

		JPanel user = new JPanel();
		Username = new JLabel();
		Username.setText("Username");
		Font font = new Font("Arial", Font.BOLD | Font.PLAIN, 25);
		Username.setFont(font);
		textUsername = new JTextField(15);
		textUsername.setFont(font);
		user.add(Username);
		user.add(textUsername);

		JPanel pass = new JPanel();
		Password = new JLabel();
		Password.setText("Password");
		Password.setFont(font);
		textPassword = new JPasswordField(15);
		textPassword.setFont(font);
		pass.add(Password);
		pass.add(textPassword);

		JPanel btLogin = new JPanel();
		Login = new JButton("Đăng Nhập");
		Login.setFont(font);
		Login.setBackground(Color.CYAN);
		btLogin.add(Login);
		Login.addActionListener(this);

		panel = new JPanel();
		panel.add(lbLogin);
		panel.add(user);
		panel.add(pass);
		panel.add(btLogin);
		panel.setBorder(borderTitle);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Container conn = getContentPane();
		conn.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == Login) {
			if (textUsername.getText().equals("") && (textPassword.getText()).equals("")) {
				JOptionPane.showMessageDialog(null, "Làm ơn điền đầy đủ Username và Password trước khi đăng nhập");
			}else {
				LoginDao loginDao = new LoginDao();
				if (loginDao.Login(textUsername.getText(), textPassword.getText())) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
					View view = new View();
					view.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Username hoặc Password sai. Vui lòng nhập lại");
				}
			}
		}
	}
	public static void main(String[] args) {
		Login lg = new Login();
		lg.setVisible(true);
	}
}
