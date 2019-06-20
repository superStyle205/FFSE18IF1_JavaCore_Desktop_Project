package model.bean;

public class HocSinh {
	  private String maSinhVien;
	  private String tenSinhVien;
	  private String lop;
	  private String ngaySinh;
	  private String gioiTinh;
	  
	  public HocSinh(){
		  
	  }
	public HocSinh(String maSinhVien, String tenSinhVien, String lop, String ngaySinh, String gioiTinh) {
		
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.lop = lop;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
}

