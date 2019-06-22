package ft.coffee.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ft.coffee.common.ConnectUtil;
import ft.coffee.model.bo.StaffBo;

public class LoginFrame extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JLabel bannerImage;

	private JLabel lblLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;

	private JTextField tfUsername;
	private JTextField tfPassword;

	private JButton btnLogin;
	private JButton btnExit;

	private StaffBo staffBo;

	public LoginFrame(StaffBo staffBo) {
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// hide title bar
		this.setUndecorated(true);

		this.staffBo = staffBo;

		// init item in screen
		initScreen();

	}

	private void initScreen() {
		// tao banner
		bannerImage = new JLabel(new ImageIcon("orange.jpg"));
		bannerImage.setPreferredSize(new Dimension(500, 300));

		// tao phan noi dung dang nhap
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font(lblLogin.getName(), Font.PLAIN, 25));
		lblLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(lblLogin);

		JPanel inputUserLogin = new JPanel();
		inputUserLogin.setLayout(new BoxLayout(inputUserLogin, BoxLayout.Y_AXIS));
		lblUsername = new JLabel("Username :");
		lblPassword = new JLabel("Password :");
		tfUsername = new JTextField(15);
		tfUsername.setText("admin");
		tfPassword = new JTextField(15);
		JPanel inputUsername = new JPanel();
		inputUsername.add(lblUsername);
		inputUsername.add(tfUsername);
		JPanel inputPassword = new JPanel();
		inputPassword.add(lblPassword);
		inputPassword.add(tfPassword);
		inputUserLogin.add(inputUsername);
		inputUserLogin.add(inputPassword);
		mainPanel.add(inputUserLogin);

		tfUsername.addKeyListener(this);
		tfPassword.addKeyListener(this);

		// phan button login va exit
		JPanel actionPanel = new JPanel();
		btnLogin = new JButton(" Login");
		btnExit = new JButton(" Exit ");
		actionPanel.add(btnLogin);
		actionPanel.add(btnExit);
		mainPanel.add(actionPanel);

		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);

		btnLogin.addKeyListener(this);
		btnExit.addKeyListener(this);

		Container container = getContentPane();
		container.add(bannerImage, BorderLayout.NORTH);
		container.add(mainPanel, BorderLayout.CENTER);

	}

	public void checkExistUser() {
		if (!ConnectUtil.isConnectDatabase()) {
			JOptionPane.showMessageDialog(this, "connect database fail", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			if (!staffBo.isExistStaff("admin")) {
				staffBo.addNewAdminAccount();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnLogin) {
			loadMainFrame();
		} else {
			this.dispose();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == btnExit && e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.dispose();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			loadMainFrame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	private void loadMainFrame() {
		try {
			if (staffBo.isExistStaff(tfUsername.getText(), tfPassword.getText())) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Sai username hoặc password", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
