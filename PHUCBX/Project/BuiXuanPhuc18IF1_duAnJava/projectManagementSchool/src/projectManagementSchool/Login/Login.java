package projectManagementSchool.Login;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projectManagementSchool.Menu.menuGiaoVien;
import projectManagementSchool.Menu.menuHieuTruong;
import projectManagementSchool.Menu.menuHocSinh;
import projectManagementSchool.UserDao.userDaoMenu;

public class Login extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel user;
	private JLabel pass;
	private JLabel name;
	private JTextField textUser;
	private JPasswordField textPass;
	private JButton btnLogin;
	private JButton btnExit;


	public Login() {
		// TODO Auto-generated constructor stub
		super("Login");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		Font font1 = new Font("Time New Roman", Font.BOLD, 40);

		JPanel pnTieuDe = new JPanel();
		name = new JLabel("Management Student");
		name.setFont(font1);
		name.setForeground(Color.RED);
		pnTieuDe.add(name);
		pnMain.add(pnTieuDe);
		
		JPanel pnUser = new JPanel();
		user = new JLabel("User");
		user.setFont(font);
		textUser = new JTextField(15);
		pnUser.add(user);
		pnUser.add(textUser);
		pnMain.add(pnUser);

		JPanel pnPass = new JPanel();
		pass = new JLabel("Password");
		pass.setFont(font);
		textPass = new JPasswordField(15);
		pnPass.add(pass);
		pnPass.add(textPass);
		pnMain.add(pnPass);
		
		user.setPreferredSize(pass.getPreferredSize());

		JPanel pnBtn = new JPanel();
		btnLogin = new JButton("Login");
		btnLogin.setMargin(new Insets(10, 20, 10, 20));
		btnExit = new JButton("Exit");
		btnExit.setMargin(new Insets(10, 20, 10, 20));
		pnBtn.add(btnLogin);
//		pnBtn.add(btnExit);
		pnMain.add(pnBtn);
		
		btnLogin.addActionListener(this);

		Container conn = getContentPane();
		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));
		conn.add(pnMain);
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			if (user.getText().equals("") || String.valueOf(textPass.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tài khoản và mật khẩu");
			} else if (user.getText().equals("admin") || String.valueOf(textPass.getPassword()).equals("123456")) {
				menuHieuTruong menu = new menuHieuTruong("Management student");
				menu.showWindown();
			}  else {// Ngược lại, tài khoản và mật khẩu nhập vào.
				JOptionPane.showMessageDialog(this, "Bạn đã nhập sai tài khoản hoặc mật khẩu");

			}
		}
	}
}
