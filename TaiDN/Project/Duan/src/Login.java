import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JButton btndangnhap1;
	JTextField username;
	JPasswordField password;
	
	public static void main(String [] args) {
		Login login = new Login();
		login.form();
		login.setSize(400, 250);
		login.setVisible(true);
		login.setLocationRelativeTo(null);
	
	}
	public void form() {
		JPanel dangnhapform = new JPanel();
		dangnhapform.setLayout(new BoxLayout(dangnhapform, BoxLayout.Y_AXIS));
		JLabel dangnhap = new JLabel("ĐĂNG NHẬP");
		
		dangnhap.setPreferredSize(new Dimension(200, 50));
		dangnhap.setFont(new Font("Courier New", Font.BOLD, 20));
		dangnhapform.add(dangnhap);
		
		
		JPanel user = new JPanel();
		JLabel user1 = new JLabel("USERNAME");
		username = new JTextField(15);
		user.add(user1);
		user.add(username);
		dangnhapform.add(user);
		JPanel user2 = new JPanel();
		JLabel user21 = new JLabel("PASSWORD");
		password = new JPasswordField(15);
		user2.add(user21);
		user2.add(password);
		dangnhapform.add(user2);
		
		JPanel btndangnhap = new JPanel();
		btndangnhap1 = new JButton("Đăng Nhập");
		btndangnhap1.addActionListener(this);
		JButton btnthoat = new JButton("Reset");
		btndangnhap.add(btndangnhap1);
		btndangnhap.add(btnthoat);
		dangnhapform.add(btndangnhap);
		
		
		Container conn = getContentPane();
		conn.add(dangnhapform);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource()==btndangnhap1) {
//			String user = username.getText();
//			String pass = password.getText();
//			JOptionPane alert = new JOptionPane();
//			if(user.equals("")) {
//				
//				alert.showMessageDialog(this,"Vui long nhap username");
//				
//			}else {
//				if(pass.equals("")) {
//					alert.showMessageDialog(this,"Vui long nhap password");
//				}else {
//					Giaodien giaodien = new Giaodien();
//				}
//			}
//		}
//		
		String UserId = username.getText();
		String Password = password.getText();
		DaoLogin daologin = new DaoLogin();
		JOptionPane alert = new JOptionPane();
		if(username.getText().equals("")||password.getText().equals("")) {
			alert.showMessageDialog(this,"nhap vao mk tk");
		}else {
			if (daologin.LoginJframe(UserId, Password)== false) {
				alert.showMessageDialog(this,"nhập sai tài khoản hoặc mật khẩu");
			} else {
				alert.showMessageDialog(this,"đăng nhập thành công ");
				Giaodien giaodien = new Giaodien();
			}
		}
	}
}
