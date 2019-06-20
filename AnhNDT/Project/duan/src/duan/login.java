package duan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    private JButton btnngNhp;
    private java.lang.String username;
    private java.lang.String password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					login frame = new login();
					frame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setSize(370,270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên Đăng Nhập :");
		lblNewLabel.setBounds(17, 38, 110, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("     Mật Khẩu :");
		lblNewLabel_1.setBounds(17, 89, 74, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(127, 35, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		 btnngNhp = new JButton("Đăng Nhập");
		btnngNhp.setBounds(86, 142, 99, 23);
		contentPane.add(btnngNhp);

		JButton btnThot = new JButton("Thoát");
		btnThot.setBounds(205, 142, 89, 23);
		contentPane.add(btnThot);

		passwordField = new JPasswordField();
		passwordField.setBounds(127, 86, 167, 20);
		contentPane.add(passwordField);
		
		this.username = textField.getText();
		this.password = passwordField.getText();
		btnngNhp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if(object == btnngNhp){
			HocSinhDao  hocsinh = new HocSinhDao();
			if (hocsinh.isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
				menu giaoDien = new menu();
				giaoDien.menu();
				dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng tên đăng nhập và mật khẩu");
			}
		}
		
	}
	
}
