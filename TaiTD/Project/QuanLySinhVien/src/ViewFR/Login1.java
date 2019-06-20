package ViewFR;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.HocSinhDao;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Login1 extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField textField,nameInput ;
	private JPasswordField passwordField;
    private JButton btnDangNhap,btnThoat;
    private JLabel lblNewLabel,lblNewLabel_1,lblchekbox;
    private java.lang.String username;
    private java.lang.String password;
    private Login1 login;
    private JCheckBox checkBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Login1 frame = new Login1();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public Login1() {
		
		setSize(450,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(193, 67, 193, 43);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(193, 132, 193, 43);
		contentPane.add(passwordField);

	    lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 76, 115, 34);
		contentPane.add(lblNewLabel);

		 lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 136, 115, 34);
		contentPane.add(lblNewLabel_1);

		 btnDangNhap = new JButton("Đăng nhập");
		 btnDangNhap.setBounds(89, 216, 109, 34);
		getRootPane().setDefaultButton(btnDangNhap);
		contentPane.add(btnDangNhap);
		
		
		 btnThoat = new JButton("Thoát");
		btnThoat.setBounds(202, 216, 109, 34);
		contentPane.add(btnThoat);
		
		JLabel lblngNhp = new JLabel("Đăng nhập");
		lblngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblngNhp.setBounds(156, 26, 100, 30);
		contentPane.add(lblngNhp);
		
		lblchekbox = new JLabel("Hiện mật khẩu");
		lblchekbox.setBounds(70, 186, 97, 23);
		contentPane.add(lblchekbox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox();
		chckbxNewCheckBox.setBounds(193, 186, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
	   this.username = textField.getText();
	   this.password = passwordField.getText();
	   btnDangNhap.addActionListener(this);
	   btnThoat.addActionListener(this);
	   
	     
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDangNhap){
			if(textField.getText().equals("")|| String.valueOf(passwordField.getPassword()).equals("")){
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tài khoản và mật khẩu");
			}else{
				HocSinhDao hsDao = new HocSinhDao();
				if(hsDao.isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
					GiaoDien giaodien = new GiaoDien();
					//FormAdminView chay = new FormAdminView();
					giaodien.gg();
					dispose();
				}else{
					JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
				}
			}
		}if(e.getSource() == btnThoat){
			
			int n = JOptionPane.showConfirmDialog(login, "Bạn thật sự muốn thoát ?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if(n!=1)
				
				System.exit(0);
		}
		/*Object object = e.getSource();
		if(object == btnNewButton){
			HocSinhDao  hocsinh = new HocSinhDao();
			if (hocsinh.isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
				Fame giaoDien = new Fame();
				giaoDien.gg();
				dispose();
				System.out.println("ok");
			} else {
				JOptionPane.showMessageDialog(null, "Thất bại");
			}
			if(e.getSource() == btnExit) {
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
		}*/
		
	}
	/*public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin) {
			if(username.getText().equals("") || String.valueOf(password.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tài khoản và mật khẩu");
			}else {//Ngược lại, tài khoản và mật khẩu nhập vào.
				SinhVienDao userDao = new SinhVienDao();
				if(userDao.isLogint(username.getText(), String.valueOf(password.getPassword()))) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
					Main main = new Main();
					FormAdminView chay = new FormAdminView();
					chay.display();
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
		
	}*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
