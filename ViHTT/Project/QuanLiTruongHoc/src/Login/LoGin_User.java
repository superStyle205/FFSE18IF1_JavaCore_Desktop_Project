package Login;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Model.dao.LoGinDao;
import QuanLiHocSinh.JFrameQuanLiHocSinh;

import javax.swing.JButton;


public class LoGin_User extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnOk;
	private JButton btnClean;
	private JButton btnThoat;
	private LoGinDao loGinDao;
	
	public LoGin_User() {
		loadLoGin();
	}
	public void loadLoGin() {
		setTitle("LOGIN");
		setSize(350,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		loGinDao = new LoGinDao();
		
		JLabel lblngNhp = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblngNhp.setForeground(Color.RED);
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblngNhp.setBounds(108, 29, 123, 27);
		getContentPane().add(lblngNhp);
		
		JLabel lblTiKhon = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTiKhon.setBounds(33, 86, 75, 27);
		getContentPane().add(lblTiKhon);
		
		textField = new JTextField();
		textField.setBounds(124, 86, 155, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMtKhu.setBounds(33, 144, 75, 27);
		getContentPane().add(lblMtKhu);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 144, 155, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(10, 208, 85, 35);
		btnOk.addActionListener(this);
		getContentPane().add(btnOk);
		
		btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClean.setBounds(121, 208, 89, 35);
		btnClean.addActionListener(this);
		getContentPane().add(btnClean);
		
		btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(235, 208, 89, 35);
		btnThoat.addActionListener(this);
		getContentPane().add(btnThoat);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			load();
		}
		
	}
	private void load() {
		String username = textField.getText();
		String password = textField_1.getText();
		if(loGinDao.getAll(username, password)==true) {
			JFrameQuanLiHocSinh jFrameQuanLiHocSinh = new JFrameQuanLiHocSinh();
			jFrameQuanLiHocSinh.loadQuanLiHocSinh();
			jFrameQuanLiHocSinh.setVisible(true);
		}
		if(loGinDao.getAll(username, password)==false) {
			JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
		}
		
	}
	public static void main(String[] args) {
		LoGin_User loGin = new LoGin_User();
		loGin.setVisible(true);
	}
}
