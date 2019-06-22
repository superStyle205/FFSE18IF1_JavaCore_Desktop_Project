package QuanLiGiaoVien;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class JFrameQuanLiGiaoVien extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTabbedPane jTabbedPane;
	
	
	private Container container;
	public JFrameQuanLiGiaoVien() {
		loadQuanLiGiaoVien();
	}
	public void loadQuanLiGiaoVien() {

		setTitle("QUẢN LÍ GIÁO VIÊN");
		setSize(1920, 1030);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jTabbedPane = new JTabbedPane();
		jTabbedPane.addTab("Thông Tin Giáo Viên", new ImageIcon("contact.png"), new TabThongTinGiaoVien(this));
		jTabbedPane.addTab("Quản Lí Giáo Viên", new ImageIcon("giaovien.png"),new TabQuanLiGiaoVien(this));
	
		container = getContentPane();
		container.add(jTabbedPane);
	}
	public static void main(String[] args) {
		JFrameQuanLiGiaoVien jFrameQuanLiGiaoVien = new JFrameQuanLiGiaoVien();
		jFrameQuanLiGiaoVien.setVisible(true);
	}
	
}
