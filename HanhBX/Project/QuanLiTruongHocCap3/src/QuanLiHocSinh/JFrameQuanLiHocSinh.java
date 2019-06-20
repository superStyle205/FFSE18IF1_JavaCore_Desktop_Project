package QuanLiHocSinh;


import java.awt.Container;




import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;




public class JFrameQuanLiHocSinh extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JTabbedPane jTabbedPane;
	
	
	private Container container;

	public JFrameQuanLiHocSinh() {
		loadQuanLiHocSinh();
	}
	public void loadQuanLiHocSinh() {
	
		setTitle("QUẢN LÍ HỌC SINH");
		setSize(1920, 1030);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jTabbedPane = new JTabbedPane();
		jTabbedPane.addTab("Thông Tin học sinh", new ImageIcon("contact.png"),  new TabThongTinHocSinh(this));
		jTabbedPane.addTab("Quản Lí Điểm", new ImageIcon("notebook.png"), new TabQuanLiDiem(this));
		jTabbedPane.addTab("Bảng điểm", new ImageIcon("student.png"),new TabBangDiem(this));
		jTabbedPane.addTab("Kết Quả học tập",new ImageIcon("test.png"),new TabKetQuaHocTap(this));
		jTabbedPane.addTab("Hồ sơ học sinh", new ImageIcon("folder.png"),new TabHoSoHocSinh(this));
		jTabbedPane.addTab("Thống Kê", new ImageIcon("growth.png"),new TabThongKeHocSinh(this) );
		container = getContentPane();
		container.add(jTabbedPane);
	}
	public static void main(String[] args) {
		JFrameQuanLiHocSinh jFrameQuanLiHocSinh = new JFrameQuanLiHocSinh();
		jFrameQuanLiHocSinh.setVisible(true);
	}
}
