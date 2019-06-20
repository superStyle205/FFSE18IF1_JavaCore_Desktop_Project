package QuanLiTaiKhoan;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class JFrameQuanLiTaiKhoan extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane;
	private Container container;
	public JFrameQuanLiTaiKhoan() {
		QuanLiTaiKhoan();
	}
	public void QuanLiTaiKhoan() {
		setTitle("Quản Lí Tài Khoản");
		setSize(500, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jTabbedPane = new JTabbedPane();
		jTabbedPane.addTab("Đổi Mật Khẩu", new ImageIcon("padlock.png"), new TabDoiMatKhau(this));
		jTabbedPane.addTab("Đăng Kí", new ImageIcon("domain.png"),new TabDangKiTaiKhoan() );
	
		container = getContentPane();
		container.add(jTabbedPane);
	}
	public static void main(String[] args) {
		JFrameQuanLiTaiKhoan jFrameQuanLiTaiKhoan = new JFrameQuanLiTaiKhoan();
		jFrameQuanLiTaiKhoan.setVisible(true);
	}
}
