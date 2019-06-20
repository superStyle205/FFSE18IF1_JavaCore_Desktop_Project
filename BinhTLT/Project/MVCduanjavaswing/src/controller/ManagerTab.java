package controller;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import view.FormHoSoHocSinhView;
import view.FormKetQuaHocTapView;
import view.FormLopHocView;
import view.FormQuanLiMonHoc;
import view.FromBangDiem;
import view.FromQuanLiGiaoVienView;
import view.FromQuanLiSinhVienView;

public class ManagerTab extends JTabbedPane {
	private JPanel FromBangDiem;
	private JSplitPane FromQuanLiSinhVienView;
	private JFrame FromQuanLiGiaoVienView;
	

	// thêm icon cho các tap và các nút button thêm , sửa , xóa , clean,.
	ImageIcon imageIconAdd = new ImageIcon("add.png");
	ImageIcon imageIconUpdate = new ImageIcon("update.png");
	ImageIcon imageIconDelete = new ImageIcon("delete.png");
	ImageIcon imageIconClean = new ImageIcon("clean.png");
	ImageIcon imageIconSearch = new ImageIcon("searchh.png");
	ImageIcon imageIconQLHS = new ImageIcon("student.png");
	ImageIcon imageIconQLGV = new ImageIcon("classroom.png");
	ImageIcon imageIconHSHS = new ImageIcon("folder.png");
	ImageIcon imageIconDIEM = new ImageIcon("diem.png");
	ImageIcon imageIconThongke = new ImageIcon("tk.png");
	ImageIcon imageIconMonhoc = new ImageIcon("book.png");
	ImageIcon imageIconclass = new ImageIcon("class.png");

	public ManagerTab() {

		FromQuanLiSinhVienView fromQuanLiSinhVienView = new FromQuanLiSinhVienView();
		FromQuanLiGiaoVienView fromQuanLiGiaoVienView = new FromQuanLiGiaoVienView();
		FromBangDiem fromBangDiem = new FromBangDiem();

		FormQuanLiMonHoc formQuanLiMonHoc = new FormQuanLiMonHoc();
		FormHoSoHocSinhView formHoSoHocSinhView = new FormHoSoHocSinhView();
		FormLopHocView formLopHocView = new FormLopHocView();
		FormKetQuaHocTapView formKetQuaHocTapView = new FormKetQuaHocTapView();

		JSplitPane managerstudent = fromQuanLiSinhVienView.quanlihocsinh();
		JSplitPane managerteacher = fromQuanLiGiaoVienView.quanligiaovien();
		JPanel diem = fromBangDiem.quanlidiem();

		JPanel monhoc = formQuanLiMonHoc.quanlimon();
		JSplitPane hshs = formHoSoHocSinhView.hosohocsinh();
		JPanel lophoc = formLopHocView.quanlilop();
		JPanel kqht = formKetQuaHocTapView.ketquahoctap();

		addTab("Quản Lí Học Sinh", imageIconQLHS, managerstudent);
		addTab("Quản Lí Giáo Viên", imageIconQLGV, managerteacher);
		addTab("Quản Lí Điểm", imageIconDIEM, diem);
		addTab("Quản Lí Môn Học", imageIconQLGV, monhoc);
		addTab("Hồ Sơ Học Sinh", imageIconHSHS, hshs);
		addTab("Quản Lí Lớp Học", imageIconclass, lophoc);
		addTab("Kết Quả Học Tập", imageIconMonhoc, kqht);

	}
}
