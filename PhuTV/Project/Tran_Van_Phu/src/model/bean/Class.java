package model.bean;

public class Class {

	private int maLop;
	private String maGiaoVien;
	private String tenLop;
	private String tenLopTruong;

	public Class() {

	}

	public Class(int maLop, String tenLop, String tenLopTruong, String hoTenGV, String maMonHoc, String maGiaoVien) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.tenLopTruong = tenLopTruong;
		this.maGiaoVien = maGiaoVien;
	}

	public int getMaLop() {
		return maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTenLopTruong() {
		return tenLopTruong;
	}

	public void setTenLopTruong(String tenLopTruong) {
		this.tenLopTruong = tenLopTruong;
	}

	public String getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

}
