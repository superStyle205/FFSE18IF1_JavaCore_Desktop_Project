package QuanLiTaiKhoan;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;

import Model.Dao.LoginDao;
import Model.bean.Login;
import TrangChu.TrangChu;


public class TabDoiMatKhau extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDoiMatKhau;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhauCu;
	private JLabel lblMatKhauMoi;
	private JLabel lblNhapLaiMatKhau;
	private JLabel txtCheck;
	
	private JTextField textFieldTaiKhoan;
	private JPasswordField passwordFieldMatKhauCu;
	private JPasswordField passwordFieldMatKhauMoi;
	private JPasswordField passwordFieldNhapLaiMatKhau;
	private JCheckBox checkBoxHienPass;
	
	private JButton btnDoiMatKhau;
	private JButton btnClean;
	private JButton btnThoat;
	private JFrame frame;
	private LoginDao loginDao;
	
	
	
	public TabDoiMatKhau(JFrame frame) {
		this.frame = frame;
		setLayout(null);
		loginDao = new LoginDao();
		lblDoiMatKhau = new JLabel("ĐỔI MẬT KHẨU");
		lblDoiMatKhau.setForeground(Color.RED);
		lblDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoiMatKhau.setBounds(169, 32, 197, 35);
		add(lblDoiMatKhau);
		
		lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTaiKhoan.setForeground(new Color(0, 0, 0));
		lblTaiKhoan.setBounds(32, 98, 101, 29);
		add(lblTaiKhoan);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setBounds(209, 96, 216, 37);
		textFieldTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTaiKhoan.setForeground(Color.RED);
		add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);
		
		
		
		lblMatKhauCu = new JLabel("Mật Khẩu Cũ");
		lblMatKhauCu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatKhauCu.setBounds(32, 161, 101, 29);
		add(lblMatKhauCu);
		
		passwordFieldMatKhauCu = new JPasswordField();
		passwordFieldMatKhauCu.setBounds(209, 159, 216, 37);
		passwordFieldMatKhauCu.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordFieldMatKhauCu.setForeground(Color.RED);
		add(passwordFieldMatKhauCu);
		passwordFieldMatKhauCu.setColumns(10);
		
		lblMatKhauMoi = new JLabel("Mật Khẩu Mới");
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatKhauMoi.setBounds(32, 226, 101, 35);
		add(lblMatKhauMoi);
		
		passwordFieldMatKhauMoi = new JPasswordField();
		passwordFieldMatKhauMoi.setBounds(209, 227, 216, 37);
		passwordFieldMatKhauMoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordFieldMatKhauMoi.setForeground(Color.RED);
		add(passwordFieldMatKhauMoi);
		passwordFieldMatKhauMoi.setColumns(10);
		
		lblNhapLaiMatKhau = new JLabel("nhập lại Mật Khẩu mới");
		lblNhapLaiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhapLaiMatKhau.setBounds(32, 296, 187, 35);
		add(lblNhapLaiMatKhau);
		
		passwordFieldNhapLaiMatKhau = new JPasswordField();
		passwordFieldNhapLaiMatKhau.setBounds(209, 295, 216, 35);
		passwordFieldNhapLaiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordFieldNhapLaiMatKhau.setForeground(Color.RED);

		add(passwordFieldNhapLaiMatKhau);
		passwordFieldNhapLaiMatKhau.setColumns(10);
		
		checkBoxHienPass = new JCheckBox("");
		checkBoxHienPass.setBounds(190, 362, 18, 23);
		txtCheck = new JLabel("Hiện Password");
		txtCheck.setBounds(220, 362, 110, 20);
		txtCheck.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(txtCheck);
		checkBoxHienPass.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    if(checkBoxHienPass.isSelected()){
			     txtCheck.setText("Ẩn password");
			     passwordFieldMatKhauCu.setEchoChar((char)0);
			     passwordFieldMatKhauMoi.setEchoChar((char)0);
			     passwordFieldNhapLaiMatKhau.setEchoChar((char)0);
			    }else{
			     txtCheck.setText("Hiện password");
			     passwordFieldMatKhauCu.setEchoChar('*');
			     passwordFieldMatKhauMoi.setEchoChar('*');
			     passwordFieldNhapLaiMatKhau.setEchoChar('*');
			    }
			   }
			  });
		add(checkBoxHienPass);
		
		btnDoiMatKhau = new JButton("Đổi Mật Khẩu");
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoiMatKhau.setBounds(25, 405, 155, 42);
		btnDoiMatKhau.addActionListener(this);
		btnDoiMatKhau.setIcon(new ImageIcon("power.png"));
		add(btnDoiMatKhau);
		
		btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClean.setBounds(195, 405, 113, 42);
		btnClean.addActionListener(this);
		btnClean.setIcon(new ImageIcon("clean.png"));
		add(btnClean);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(322, 405, 131, 42);
		btnThoat.addActionListener(this);
		btnThoat.setIcon(new ImageIcon("thoat.png"));
		add(btnThoat);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == btnThoat) {
		int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			TrangChu trangChu = new TrangChu();
			trangChu.loadTrangChu();
			trangChu.setVisible(true);
		frame.dispose();
		}
	}
	else if(e.getSource() == btnClean) {
		textFieldTaiKhoan.setText("");
		passwordFieldMatKhauCu.setText("");
		passwordFieldMatKhauMoi.setText("");
		passwordFieldNhapLaiMatKhau.setText("");
		
	}	
	else if(e.getSource() == btnDoiMatKhau) {
		if(textFieldTaiKhoan.getText().equals("")||passwordFieldMatKhauCu.getText().equals("")||passwordFieldMatKhauMoi.getText().equals("")||
				passwordFieldNhapLaiMatKhau.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "bạn hãy nhập đầy đủ thông tin để đổi mật khẩu");
		}
//		else if(!passwordFieldMatKhauMoi.getText().equals(passwordFieldNhapLaiMatKhau.getText())) {
//			JOptionPane.showMessageDialog(null, "bạn nhập lại mật khẩu mới không đúng");
//		}
		else {
		doiMatKhau();
		}
	}
	}
	private void doiMatKhau() {
		ckeckDoiMatKhau();
	}
	private void ckeckDoiMatKhau() {
		String username = textFieldTaiKhoan.getText();
		String password = passwordFieldMatKhauCu.getText();
		if(loginDao.checkDoiMatKhau(username, password)==false) {
			JOptionPane.showMessageDialog(null, "tài khoản hoặc mật khẩu cũ bạn nhập sai");
		}
		else if (passwordFieldMatKhauCu.getText().equals(passwordFieldMatKhauMoi.getText())) {
			JOptionPane.showMessageDialog(null, "mật khẩu mới không được trùng mật khẩu cũ");
		}
		else if(!passwordFieldMatKhauMoi.getText().equals(passwordFieldNhapLaiMatKhau.getText())) {
			JOptionPane.showMessageDialog(null, "bạn nhập lại mật khẩu mới không đúng");
		}
		else {
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(passwordFieldMatKhauMoi.getText());
			loginDao.doiMatKhau(login);
			JOptionPane.showMessageDialog(null,"bạn đã đổi mật khẩu thành công");
		}
	}
}
