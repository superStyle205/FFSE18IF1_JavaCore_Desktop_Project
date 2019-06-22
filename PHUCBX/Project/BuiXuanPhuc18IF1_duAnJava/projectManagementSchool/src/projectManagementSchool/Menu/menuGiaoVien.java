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

import projectManagementSchool.QuanLy.QuanLyDiemTungMon;
import projectManagementSchool.QuanLy.QuanLyHoSoHocSinh;
import projectManagementSchool.QuanLy.QuanLyKhoi;
import projectManagementSchool.QuanLy.QuanLyLop;
import projectManagementSchool.QuanLy.QuanLyNhanSu;
import projectManagementSchool.QuanLy.quanLyMonHoc;

public class menuGiaoVien extends JFrame implements ActionListener, MouseListener {

	private QuanLyKhoi qlKhoi = new QuanLyKhoi("");
	private QuanLyNhanSu qlGiangVien = new QuanLyNhanSu("");
	private QuanLyLop qlLop = new QuanLyLop("");
	private QuanLyHoSoHocSinh qlHoSoHocSinh = new QuanLyHoSoHocSinh("");
	private QuanLyDiemTungMon qlDiemTungMon = new QuanLyDiemTungMon("");
	private quanLyMonHoc qlMonHoc = new quanLyMonHoc("");
	private static final long serialVersionUID = 1L;

	public menuGiaoVien(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addControls();
		addEvents();

	}
	
	private void addEvents() {
		// TODO Auto-generated method stub
		
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
		JPanel pnCtrlsQuanLyMonHoc = qlMonHoc.addControls();
		JTabbedPane myTabled = new JTabbedPane();
		myTabled.addTab("Quản Lý Lớp", null, pnCtrlsQuanLyKhoi);
		myTabled.addTab("Quản Lý Học Sinh", null, pnCtrlsQuanLyLop);
		myTabled.addTab("Quản Lý Hồ Sơ Học Sinh", null, pnCtrlsQuanLyHoSoHocSinh);
		myTabled.addTab("Quản Lý Môn Học", null, pnCtrlsQuanLyMonHoc);
		myTabled.addTab("Quản Lý Điểm Từng Môn", null, pnCtrlsQuanLyDiemTungMon);
		myTabled.addTab("Quản Lý Nhân Sự", null, pnCtrlsQuanLyGiangVien);

		pnMain.add(myTabled);
	}
	
	public void showWindown() {
		this.setSize(new Dimension(getMaximumSize()));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
		this.setVisible(true);
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
