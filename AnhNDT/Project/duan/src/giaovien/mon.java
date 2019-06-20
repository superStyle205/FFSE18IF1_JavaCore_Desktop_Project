package giaovien;

public class mon {
private String maMon , tenMon, maGV, tenGV, soTiet, ghiChu ;
public mon(){
	
}
public mon(String maMon, String tenMon, String maGV, String tenGV,
		String soTiet, String ghiChu) {
	super();
	this.maMon = maMon;
	this.tenMon = tenMon;
	this.maGV = maGV;
	this.tenGV = tenGV;
	this.soTiet = soTiet;
	this.ghiChu = ghiChu;
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

public String getMaGV() {
	return maGV;
}

public void setMaGV(String maGV) {
	this.maGV = maGV;
}

public String getTenGV() {
	return tenGV;
}

public void setTenGV(String tenGV) {
	this.tenGV = tenGV;
}

public String getSoTiet() {
	return soTiet;
}

public void setSoTiet(String soTiet) {
	this.soTiet = soTiet;
}

public String getGhiChu() {
	return ghiChu;
}

public void setGhiChu(String ghiChu) {
	this.ghiChu = ghiChu;
}

}
