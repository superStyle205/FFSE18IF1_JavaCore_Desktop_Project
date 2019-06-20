package projectManagementSchool.Login;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JLabel user;
	private JLabel pass;
	private JLabel name;
	private JTextField textUser;
	private JPasswordField textPass;
	private JButton btnLogin;
	private JButton btnExit;

	private JPanel pn;
	private JPanel pn1;
	private JPanel pn2;
	private JPanel pn3;

	public Login() {
		// TODO Auto-generated constructor stub
		super("Login");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Font font = new Font("Time New Roman", Font.BOLD, 30);
		Font font1 = new Font("Time New Roman", Font.BOLD, 40);

		name = new JLabel("Management Student");
		name.setFont(font1);
		name.setForeground(Color.RED);
		pn = new JPanel();
		pn.add(name);

		user = new JLabel("User               ");
		user.setFont(font);
		textUser = new JTextField(15);
		pn1 = new JPanel();
		pn1.add(user);
		pn1.add(textUser);

		pass = new JLabel("Password      ");
		pass.setFont(font);
		textPass = new JPasswordField(15);
		pn2 = new JPanel();
		pn2.add(pass);
		pn2.add(textPass);

		btnLogin = new JButton("Login");
		btnLogin.setMargin(new Insets(10,20,10,20));
		btnExit = new JButton("Exit");
		btnExit.setMargin(new Insets(10,20,10,20));
		pn3 = new JPanel();
		pn3.setLayout(new FlowLayout());
		pn3.add(btnLogin);
		pn3.add(btnExit);
		
		Container conn = getContentPane();
		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));
		conn.add(pn);
		conn.add(pn1);
		conn.add(pn2);
		conn.add(pn3);
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}
}
