package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.MainFrame;
import model.dao.StudentDao;
import model.dao.UserDao;



public class FormLogin extends JFrame implements  ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel lblTitle;
		private JLabel lblUsername;
		static JTextField username;
		private JLabel lblPassword;
		static JPasswordField password;
		private JLabel lblCheckBox;
		private JCheckBox checkBox;
		private JButton btnLogin;
		private JButton btnExit;
		private FormLogin login;
		 
		public void display() {
			add(add(ManagerFormLogin()));	
			setVisible(true);
			setSize(500, 200);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  //thêm hang bản điều khiển 
			//Tắt chế độ phóng to màn hình
			setResizable(false);
		}

		
		public JPanel ManagerFormLogin() {
			JPanel panel = new JPanel();
			panel.setBackground(Color.CYAN);
			
			JPanel top = new JPanel();
			top.setBackground(Color.CYAN);
			JPanel bot = new JPanel(new GridLayout(4, 2, 5, 5));
			bot.setBackground(Color.CYAN);
			
			lblTitle = new JLabel("Đăng nhập");
			lblUsername = new JLabel("Tài khoản");
			username = new JTextField(20);
			lblPassword = new  JLabel("Mật khẩu");
			password = new JPasswordField(20);
			lblCheckBox = new JLabel("Hiện mật khẩu");
			checkBox = new JCheckBox();
			checkBox.setBackground(Color.CYAN);
			checkBox.addActionListener(this);
			btnLogin = new JButton("Đăng nhập");
			btnLogin.addActionListener(this);
			getRootPane().setDefaultButton(btnLogin);
			btnExit = new JButton("Thoát");
			btnExit.addActionListener(this);
			
			top.add(lblTitle);
			top.add(username);
			bot.add(lblUsername);
			bot.add(username);
			bot.add(lblPassword);
			bot.add(password);
			bot.add(lblCheckBox);
			bot.add(checkBox);
			bot.add(btnLogin);
			bot.add(btnExit);
			panel.add(top);
     		panel.add(bot);
			
			return panel;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnLogin) {
				if(username.getText().equals("") || String.valueOf(password.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tài khoản và mật khẩu");
				}else {//Ngược lại, tài khoản và mật khẩu nhập vào.
					UserDao userDao = new UserDao();
					if(userDao.isLogint(username.getText(), String.valueOf(password.getPassword()))) {
						JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
						MainApp main = new MainApp();
						new MainFrame();				
						dispose();
					} else {
						JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
					}
					
				}
			} if(e.getSource() == btnExit) {
				//icon mặc định, tiêu đề tùy chỉnh
				int n = JOptionPane.showConfirmDialog(login, "Bạn thật sự muốn thoát ?", "Thông báo", JOptionPane.YES_NO_OPTION);
				//nếu n = 0 thì thoát chương trình ngươc lại n = 1 không thoát
				if(n!=1)
				//lệnh thoát chương trình
				System.exit(0);
			 } if(checkBox.isSelected()) {
				lblCheckBox.setText("Ẩn mật khẩu");
				password.setEchoChar((char)0);
			 } else {
				lblCheckBox.setText("Hiện mật khẩu");
				password.setEchoChar('*');	
			 }
			
		}
		
		public static void main(String[] args) {
			FormLogin formLogin = new FormLogin();
			formLogin.display();
			
		}
}
