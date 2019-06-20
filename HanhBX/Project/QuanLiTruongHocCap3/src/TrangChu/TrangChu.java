package TrangChu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LoGin.LoginQLTH;
import QuanLiGiaoVien.JFrameQuanLiGiaoVien;
import QuanLiHocSinh.JFrameQuanLiHocSinh;
import QuanLiTaiKhoan.JFrameQuanLiTaiKhoan;


public class TrangChu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenpan;
	private JLabel lblQlnt;
	private JButton btnQuanLiHocSinh;
	private JButton btnQuanLiGiaoVien;
	private JButton btnDangXuat;
	private JButton btnGioiThieu;
	private JButton btnTaiKhoan;
	
	private JLabel lblChuThich_1;
	private JLabel lblChuThich_2;

	public TrangChu() {
		loadTrangChu();
	}

	public void loadTrangChu() {
		setTitle("TRANG CHỦ");
		setSize(1600,900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenpan = new JPanel();
		setContentPane(contenpan);
		contenpan.setLayout(null);

		lblQlnt = new JLabel("QUẢN LÍ NHÀ TRƯỜNG");
		lblQlnt.setForeground(Color.RED);
		lblQlnt.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQlnt.setBounds(600, 43, 400, 50);
		contenpan.add(lblQlnt);

		btnQuanLiHocSinh = new JButton("Quản lí Học Sinh");
		btnQuanLiHocSinh.setIcon(new ImageIcon("student.png"));
		btnQuanLiHocSinh.setForeground(Color.BLUE);
		btnQuanLiHocSinh.setFont(new Font("Tahoma", Font.BOLD,14));

		btnQuanLiHocSinh.setBounds(100, 620, 201, 44);
		contenpan.add(btnQuanLiHocSinh);
		btnQuanLiHocSinh.addActionListener(this);

		btnQuanLiGiaoVien = new JButton("Quản Lí Giáo Viên");
		btnQuanLiGiaoVien.setForeground(Color.BLUE);
		btnQuanLiGiaoVien.setIcon(new ImageIcon("teacher.png"));
		btnQuanLiGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuanLiGiaoVien.setBounds(400, 620, 216, 44);
		btnQuanLiGiaoVien.addActionListener(this);
		contenpan.add(btnQuanLiGiaoVien);

		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setForeground(Color.BLUE);
		btnDangXuat.setIcon(new ImageIcon("dangxuat.png"));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuat.setBounds(700, 620, 201, 44);
		contenpan.add(btnDangXuat);
		btnDangXuat.addActionListener(this);

		btnGioiThieu = new JButton("Giới Thiệu");
		btnGioiThieu.setForeground(Color.BLUE);
		btnGioiThieu.setIcon(new ImageIcon("globe.png"));
		btnGioiThieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGioiThieu.setBounds(1000, 620, 201, 44);
		contenpan.add(btnGioiThieu);
		
		btnTaiKhoan = new JButton("Tài Khoản");
		btnTaiKhoan.setForeground(Color.BLUE);
		btnTaiKhoan.setIcon(new ImageIcon("shield.png"));
		btnTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTaiKhoan.setBounds(1300, 620, 201, 44);
		btnTaiKhoan.addActionListener(this);
		contenpan.add(btnTaiKhoan);

		lblChuThich_1 = new JLabel("Phần mềm quản lí nhà trường");
		lblChuThich_1.setForeground(Color.BLACK);
		lblChuThich_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChuThich_1.setBounds(1250, 800, 307, 14);
		contenpan.add(lblChuThich_1);

		lblChuThich_2 = new JLabel("Mọi thắc mắc xin liên hệ sdt:0372348350");
		lblChuThich_2.setForeground(Color.BLACK);
		lblChuThich_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChuThich_2.setBounds(1300, 820, 253, 14);
		contenpan.add(lblChuThich_2);
		
		JLabel lblanhchinh = new JLabel();
		lblanhchinh.setBounds(310, 172, 1000, 382);
		lblanhchinh.setIcon(new ImageIcon("namdan.jpg"));
		
		contenpan.add(lblanhchinh);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(0, 0, 493, 145);
		lblLogo.setIcon(new ImageIcon("logo.png"));
		contenpan.add(lblLogo);
	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action == btnQuanLiHocSinh) {
			JFrameQuanLiHocSinh jFrameQuanLiHocSinh = new JFrameQuanLiHocSinh();
			jFrameQuanLiHocSinh.loadQuanLiHocSinh();
			jFrameQuanLiHocSinh.setVisible(true);
		}
		else if(action == btnQuanLiGiaoVien) {
			JFrameQuanLiGiaoVien jFrameQuanLiGiaoVien = new JFrameQuanLiGiaoVien();
			jFrameQuanLiGiaoVien.loadQuanLiGiaoVien();
			jFrameQuanLiGiaoVien.setVisible(true);
		}

		else if(action == btnDangXuat) {
			int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn đăng xuất không?","Đăng Xuất",JOptionPane.YES_NO_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
			LoginQLTH loginQLTH = new LoginQLTH();
			JOptionPane.showMessageDialog(null,"Bạn đã đăng xuất thành công");
			loginQLTH.loadLoGin();
			loginQLTH.setVisible(true);
			}
			

		}
		else if (action == btnTaiKhoan) {
			JFrameQuanLiTaiKhoan jFrameQuanLiTaiKhoan = new JFrameQuanLiTaiKhoan();
			jFrameQuanLiTaiKhoan.QuanLiTaiKhoan();
			jFrameQuanLiTaiKhoan.setVisible(true);
		}

	}

	public static void main(String[] args) {
		TrangChu trangChu = new TrangChu();
		trangChu.setVisible(true);
	}

}
