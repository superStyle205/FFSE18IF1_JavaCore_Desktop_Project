package giaovien;

public class diem {
private String maMon, tenMon, diemKtrHK1, diemKtrHK2, diemTB;
public diem(){
	
}
public diem(String maMon, String tenMon, String diemKtrHK1, String diemKtrHK2,
		String diemTB) {
	super();
	this.maMon = maMon;
	this.tenMon = tenMon;
	this.diemKtrHK1 = diemKtrHK1;
	this.diemKtrHK2 = diemKtrHK2;
	this.diemTB = diemTB;
}

public String getMaMon() {
	return maMon;
}

public void setMaMon(String maMon) {
	this.maMon = maMon;
}

public String getTenMon() {
	return tenMon;
}

public void setTenMon(String tenMon) {
	this.tenMon = tenMon;
}

public String getDiemKtrHK1() {
	return diemKtrHK1;
}

public void setDiemKtrHK1(String diemKtrHK1) {
	this.diemKtrHK1 = diemKtrHK1;
}

public String getDiemKtrHK2() {
	return diemKtrHK2;
}

public void setDiemKtrHK2(String diemKtrHK2) {
	this.diemKtrHK2 = diemKtrHK2;
}

public String getDiemTB() {
	return diemTB;
}

public void setDiemTB(String diemTB) {
	this.diemTB = diemTB;
}

}
