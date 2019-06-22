package QuanLiTaiKhoan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Dao.LoginDao;
import Model.Dao.ThongTinGiaoVienDao;
import Model.bean.Login;
import TrangChu.TrangChu;

public class TabDangKiTaiKhoan extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDangKi;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;
	private JLabel lblSoDienThoai;
	private JLabel txtCheck;
	
	private JTextField textFieldTaiKhoan;
	private JPasswordField passwordFieldMatKhau;
	private JTextField textFieldSoDienThoai;
	private JCheckBox checkBoxHienPass;
	
	private JButton btnDangKi;
	private JButton btnClean;
	private JButton btnThoat;
	private ThongTinGiaoVienDao thongTinGiaoVienDao;
	private LoginDao loginDao;
	
	public TabDangKiTaiKhoan() {
		setLayout(null);
		thongTinGiaoVienDao = new ThongTinGiaoVienDao();
		loginDao = new LoginDao();
		lblDangKi = new JLabel("ĐĂNG KÍ");
		lblDangKi.setForeground(Color.RED);
		lblDangKi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDangKi.setBounds(179, 53, 131, 37);
		add(lblDangKi);
		
		lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTaiKhoan.setBounds(49, 119, 89, 37);
		add(lblTaiKhoan);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setBounds(187, 119, 211, 37);
		textFieldTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTaiKhoan.setForeground(Color.RED);
		add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);
		
		lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatKhau.setBounds(49, 200, 89, 35);
		add(lblMatKhau);
		
		passwordFieldMatKhau = new JPasswordField();
		passwordFieldMatKhau.setBounds(187, 198, 211, 37);
		passwordFieldMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordFieldMatKhau.setForeground(Color.RED);
		add(passwordFieldMatKhau);
		passwordFieldMatKhau.setColumns(10);
		
		lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoDienThoai.setBounds(49, 285, 108, 29);
		add(lblSoDienThoai);
		
		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setBounds(187, 285, 211, 37);
		textFieldSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSoDienThoai.setForeground(Color.RED);
		add(textFieldSoDienThoai);
		textFieldSoDienThoai.setColumns(10);
		
		checkBoxHienPass = new JCheckBox("");
		checkBoxHienPass.setBounds(190, 350, 18, 23);
		txtCheck = new JLabel("Hiện Password");
		txtCheck.setBounds(220, 350, 110, 20);
		txtCheck.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(txtCheck);
		checkBoxHienPass.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    if(checkBoxHienPass.isSelected()){
			     txtCheck.setText("Ẩn password");
			     passwordFieldMatKhau.setEchoChar((char)0);
			    }else{
			     txtCheck.setText("Hiện password");
			     passwordFieldMatKhau.setEchoChar('*');			    }
			   }
			  });
		add(checkBoxHienPass);
		
		btnDangKi = new JButton("Đăng Kí");
		btnDangKi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDangKi.setBounds(28, 395, 131, 46);
		btnDangKi.addActionListener(this);
		btnDangKi.setIcon(new ImageIcon("power.png"));
		add(btnDangKi);
		
		btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClean.setBounds(179, 395, 124, 46);
		btnClean.addActionListener(this);
		btnClean.setIcon(new ImageIcon("clean.png"));
		add(btnClean);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(323, 395, 124, 46);
		btnThoat.addActionListener(this);
		btnThoat.setIcon(new ImageIcon("thoat.png"));
		add(btnThoat);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThoat) {
			int choose = JOptionPane.showConfirmDialog(null,"bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
			TrangChu trangChu = new TrangChu();
			trangChu.loadTrangChu();
			trangChu.setVisible(true);
			}
		}
		else if(e.getSource() == btnClean) {
			textFieldTaiKhoan.setText("");
			passwordFieldMatKhau.setText("");
			textFieldSoDienThoai.setText("");
		}
		else if (e.getSource() == btnDangKi) {
			if(textFieldTaiKhoan.getText().equals("")||passwordFieldMatKhau.getText().equals("")||textFieldSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"bạn hãy nhập đầy đủ thông tin để đăng kí tài khoản");	
			}
			else {
			dangKiTaiKhoan();
			}
		}
	}
	private void dangKiTaiKhoan() {
		ckeckDangKiTaiKhoan();
	}
	private void ckeckDangKiTaiKhoan() {
		String sodienthoai = textFieldSoDienThoai.getText();
		if(thongTinGiaoVienDao.checkSoDienThoaiDangKiQLD(sodienthoai) == false) {
			JOptionPane.showMessageDialog(null, "số điện thoại đăng kí không có trong danh sách nhà trường");
		}
		else {
			Login login = new Login();
			login.setUsername(textFieldTaiKhoan.getText());
			login.setPassword(passwordFieldMatKhau.getText());
			loginDao.addTaiKhoan(login);
			JOptionPane.showMessageDialog(null,"bạn đã đăng kí tài khoản thành công");
		}
	}
}
