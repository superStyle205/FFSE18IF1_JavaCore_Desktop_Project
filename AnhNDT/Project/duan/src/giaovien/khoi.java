package giaovien;

import java.util.ArrayList;

public class khoi {
private String maKhoi,tenKhoi;
private ArrayList<lop> Lops;
public String getMaKhoi() {
	return maKhoi;
}

public void setMaKhoi(String maKhoi) {
	this.maKhoi = maKhoi;
}

public String getTenKhoi() {
	return tenKhoi;
}

public void setTenKhoi(String tenKhoi) {
	this.tenKhoi = tenKhoi;
}

public khoi() {
	super();
	this.Lops = new ArrayList<lop>();
}
}
