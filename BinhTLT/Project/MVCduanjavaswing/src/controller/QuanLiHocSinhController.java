package controller;

import view.FromBangDiem;
import view.FromQuanLiGiaoVienView;
import view.FromQuanLiSinhVienView;

public class QuanLiHocSinhController {
	private FromQuanLiSinhVienView qlsv = new FromQuanLiSinhVienView();
	private FromQuanLiGiaoVienView qlgv = new FromQuanLiGiaoVienView();
	private FromBangDiem bd = new FromBangDiem();
	
	public void loadProgram(){
		qlsv.display();
		qlgv.hienthi();
		bd.chaybangdiem();
	}
}
