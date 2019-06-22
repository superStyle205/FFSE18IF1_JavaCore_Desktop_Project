package LoGin;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;


import Model.Dao.LoginDao;
import Model.bean.Login;
//import QuanLiHocSinh.ThongTinSinhVien;
import TrangChu.TrangChu;







public class LoginQLTH extends JFrame implements ActionListener,MouseListener {
	private JLabel labelLogin;
	private JPanel contentPane;
	private JTextField txtUsername;

	private JButton buttonOk;
	private JButton buttonClean;
	private JButton buttonExit;
	private JPasswordField passwordField;
	private ImageIcon icon;
	private JLabel txtCheck;
		public LoginQLTH() {
			loadLoGin();
		}
		public void loadLoGin() {
			setTitle("LOGIN");
			setSize(400,350); 
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	
			contentPane = new JPanel();

			setContentPane(contentPane);
			contentPane.setLayout(null);
			//label đăng nhập
			JLabel lblNewLabel = new JLabel("Đăng Nhập");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(140, 21, 200, 35);
			contentPane.add(lblNewLabel);
			// ô input
			
			JLabel lblUsename = new JLabel("tài khoản");
			lblUsename.setForeground(new Color(0, 0, 0));
			lblUsename.setIcon(new ImageIcon("user.png"));
			lblUsename.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblUsename.setBounds(25, 90, 100, 40);
			contentPane.add(lblUsename);
			txtUsername = new JTextField();
			txtUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtUsername.setBackground(Color.WHITE);
			txtUsername.setForeground(Color.RED);
			contentPane.add(txtUsername);
			txtUsername.setBounds(140, 90, 204, 40);
			JLabel lblPassword = new JLabel("mật khẩu");
			lblPassword.setIcon(new ImageIcon("lock.png"));
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPassword.setForeground(Color.BLACK);
			lblPassword.setBounds(25, 170, 105, 40);
			contentPane.add(lblPassword);
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
			passwordField.setEchoChar('*');
			passwordField.setForeground(Color.RED);
			passwordField.setBounds(140,170,204,40);
			contentPane.add(passwordField);
			//thêm các button
			buttonOk = new JButton("OK");
			buttonOk.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonOk.setIcon(new ImageIcon("power.png"));
			buttonOk.setBounds(20, 250, 80, 30);
			getRootPane().setDefaultButton(buttonOk);
			contentPane.add(buttonOk);
			buttonOk.addActionListener(this);
			buttonClean = new JButton("CLEAN");
			buttonClean.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonClean.setIcon(new ImageIcon("clean.png"));
			buttonClean.setBounds(130, 250, 105, 30);
			contentPane.add(buttonClean);
			buttonClean.addActionListener(this);
			buttonExit = new JButton("THOÁT");
			buttonExit.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonExit.setIcon(new ImageIcon("thoat.png"));
			buttonExit.setBounds(260, 250, 104, 30);
			buttonExit.addActionListener(this);
			contentPane.add(buttonExit);
			
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setBounds(140, 220, 18, 23);
			txtCheck = new JLabel("Hiện Password");
			txtCheck.setBounds(164, 225, 108, 14);
			contentPane.add(txtCheck);
			checkBox.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
				    if(checkBox.isSelected()){
				     txtCheck.setText("Ẩn password");
				     passwordField.setEchoChar((char)0);
				    }else{
				     txtCheck.setText("Hiện password");
				     passwordField.setEchoChar('*');
				    }
				   }
				  });
			contentPane.add(checkBox);
		}
		

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object action = e.getSource();
			if(action == buttonOk) {
				Load();
			}
			else if(action == buttonClean) {
				Clean();
			}
			else {
				exit();
			}
			
		}
		private void exit() {
			int a = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát khỏi phần mềm","Thoát",JOptionPane.YES_OPTION);
			if(a == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

		private void Clean() {
			txtUsername.setText("");
			passwordField.setText("");
			
		}

		private void Load() {

			LoginDao loginDao = new LoginDao();
			String username = txtUsername.getText();
			String password = passwordField.getText();
			List<Login> listLogin = loginDao.getAllLogin();
			if(txtUsername.getText().equals("")&& passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"bạn hãy nhập tài khoản và mật khẩu");
			}
			else if(txtUsername.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"tài khoản không được trống");
			}
			else if(passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"mật khẩu không được trống");
			}
			else if (loginDao.checkLoGin(username, password) == true) {
				JOptionPane.showMessageDialog(null, "đăng nhập thành công");
				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
			}
			else if (loginDao.checkLoGin(username, password) == false) {
				JOptionPane.showMessageDialog(null, "tài khoản hoặc mật khẩu không chính xác");
			}
		}

			
				
			
		

		public static void main(String[] args) {
			LoginQLTH testLogin = new LoginQLTH();
			testLogin.setVisible(true);
		}
}
