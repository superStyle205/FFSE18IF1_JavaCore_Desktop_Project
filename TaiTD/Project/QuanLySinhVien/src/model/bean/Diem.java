package model.bean;

public class Diem {
   private String MaSV;
   private String MaMH;
   private String LanThi;
   private String DiemThi;
   
   public Diem(){
	   
   }
public Diem(String maSV, String maMH, String lanThi, String diemThi) {
	super();
	MaSV = maSV;
	MaMH = maMH;
	LanThi = lanThi;
	DiemThi = diemThi;
}
public String getMaSV() {
	return MaSV;
}
public void setMaSV(String maSV) {
	MaSV = maSV;
}
public String getMaMH() {
	return MaMH;
}
public void setMaMH(String maMH) {
	MaMH = maMH;
}
public String getLanThi() {
	return LanThi;
}
public void setLanThi(String lanThi) {
	LanThi = lanThi;
}
public String getDiemThi() {
	return DiemThi;
}
public void setDiemThi(String diemThi) {
	DiemThi = diemThi;
}
   
}
