package projectManagementSchool.Menu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import projectManagementSchool.QuanLy.QuanLyNhanSu;
import projectManagementSchool.QuanLy.quanLyHeThong;
import projectManagementSchool.QuanLy.quanLyMonHoc;
import projectManagementSchool.QuanLy.QuanLyDiemTungMon;
import projectManagementSchool.QuanLy.QuanLyHoSoHocSinh;
import projectManagementSchool.QuanLy.QuanLyKhoi;
import projectManagementSchool.QuanLy.QuanLyLop;
import projectManagementSchool.QuanLy.QuanLyLuong;

public class Menu extends JFrame implements ActionListener, MouseListener {
	private QuanLyKhoi qlKhoi = new QuanLyKhoi("");
	private QuanLyNhanSu qlGiangVien = new QuanLyNhanSu("");
	private QuanLyLop qlLop = new QuanLyLop("");
	private QuanLyHoSoHocSinh qlHoSoHocSinh = new QuanLyHoSoHocSinh("");
	private QuanLyDiemTungMon qlDiemTungMon = new QuanLyDiemTungMon("");
	private QuanLyLuong qlLuong = new QuanLyLuong("");
	private quanLyHeThong qlHeThong = new quanLyHeThong("");
	private quanLyMonHoc qlMonHoc = new quanLyMonHoc("");
	private static final long serialVersionUID = 1L;

	public Menu(String title) {

		super(title);
		addControls();
		addEvents();

	}

	public void showWindown() {
		this.setSize(new Dimension(getMaximumSize()));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void addControls() {
		Container conn = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);

		JPanel pnCtrlsQuanLyKhoi = qlKhoi.addControlsQuanLyKhoi();
		JPanel pnCtrlsQuanLyGiangVien = qlGiangVien.addControls();
		JPanel pnCtrlsQuanLyLop = qlLop.addControls();
		JPanel pnCtrlsQuanLyHoSoHocSinh = qlHoSoHocSinh.addControls();
		JPanel pnCtrlsQuanLyDiemTungMon = qlDiemTungMon.addControls();
		JPanel pnCtrlsQuanLyLuong = qlLuong.addControls();
		JPanel pnCtrlsQuanLyHeThong = qlHeThong.addControls();
		JPanel pnCtrlsQuanLyMonHoc = qlMonHoc.addControls();
		JTabbedPane myTabled = new JTabbedPane();
		myTabled.addTab("Menu", null, pnCtrlsQuanLyHeThong);
		myTabled.addTab("Quản Lý Lớp", null, pnCtrlsQuanLyKhoi);
		myTabled.addTab("Quản Lý Học Sinh", null, pnCtrlsQuanLyLop);
		myTabled.addTab("Quản Lý Hồ Sơ Học Sinh", null, pnCtrlsQuanLyHoSoHocSinh);
		myTabled.addTab("Quản Lý Môn Học", null, pnCtrlsQuanLyMonHoc);
		myTabled.addTab("Quản Lý Điểm Từng Môn", null, pnCtrlsQuanLyDiemTungMon);
		myTabled.addTab("Quản Lý Nhân Sự", null, pnCtrlsQuanLyGiangVien);
		myTabled.addTab("Quản Lý Lương", null, pnCtrlsQuanLyLuong);

		pnMain.add(myTabled);
	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
