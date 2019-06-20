package Model.bean;

import java.util.ArrayList;

public class DanhMucLop {
	private String MaLop;
	private String TenLop;
	private ArrayList<Hoso> Hosolop;
	
	public void themLop(Hoso lop) {
		this.Hosolop.add(lop);
		lop.setLop(this);
	}

	public DanhMucLop() {
		super();
		this.Hosolop = new ArrayList<Hoso>();
	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public ArrayList<Hoso> getHosolop() {
		return Hosolop;
	}

	public void setHosolop(ArrayList<Hoso> hosolop) {
		Hosolop = hosolop;
	}

	public DanhMucLop(String maLop, String tenLop, ArrayList<Hoso> hosolop) {
		super();
		MaLop = maLop;
		TenLop = tenLop;
		Hosolop = hosolop;
	}

}
