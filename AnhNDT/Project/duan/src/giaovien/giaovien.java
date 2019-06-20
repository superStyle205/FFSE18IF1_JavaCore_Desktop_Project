package giaovien;

import java.sql.Date;

public class giaovien {
private String maGiaoVien,tenGiaoVien, emailGiaoVien ,sdtGiaoVien, maKhoi;
public giaovien(){
	
}
public giaovien(String maGiaoVien, String tenGiaoVien, String emailGiaoVien,
		String sdtGiaoVien, String maKhoi) {
	super();
	this.maGiaoVien = maGiaoVien;
	this.tenGiaoVien = tenGiaoVien;
	this.emailGiaoVien = emailGiaoVien;
	this.sdtGiaoVien = sdtGiaoVien;
	this.maKhoi = maKhoi;
}

public String getMaGiaoVien() {
	return maGiaoVien;
}

public void setMaGiaoVien(String maGiaoVien) {
	this.maGiaoVien = maGiaoVien;
}

public String getTenGiaoVien() {
	return tenGiaoVien;
}

public void setTenGiaoVien(String tenGiaoVien) {
	this.tenGiaoVien = tenGiaoVien;
}

public String getEmailGiaoVien() {
	return emailGiaoVien;
}

public void setEmailGiaoVien(String emailGiaoVien) {
	this.emailGiaoVien = emailGiaoVien;
}

public String getSdtGiaoVien() {
	return sdtGiaoVien;
}

public void setSdtGiaoVien(String sdtGiaoVien) {
	this.sdtGiaoVien = sdtGiaoVien;
}

public String getMaKhoi() {
	return maKhoi;
}

public void setMaKhoi(String maKhoi) {
	this.maKhoi = maKhoi;
}

}
