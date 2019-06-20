package giaovien;

import java.sql.Date;

public class hocsinh {
	private String ma,sdt,tuoi, ten,diaChi, email;
	public hocsinh(){
		
	}
	public hocsinh(String ma, String sdt, String tuoi, String ten,
			String diaChi, String email) {
		super();
		this.ma = ma;
		this.sdt = sdt;
		this.tuoi = tuoi;
		this.ten = ten;
		this.diaChi = diaChi;
		this.email = email;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
