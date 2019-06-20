package model.bean;

import java.io.Serializable;

public class GiaoVien implements Serializable {
	public int magiaovien;
	public String hoten, gioitinh;
	public String malop, namsinh, mamon;

	public GiaoVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param magiaovien
	 * @param hoten
	 * @param gioitinh
	 * @param malop
	 * @param namsinh
	 * @param mamon
	 */
	public GiaoVien(int magiaovien, String hoten, String gioitinh, String malop, String namsinh, String mamon) {
		super();
		this.magiaovien = magiaovien;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.malop = malop;
		this.namsinh = namsinh;
		this.mamon = mamon;
	}

	public int getMagiaovien() {
		return magiaovien;
	}

	public void setMagiaovien(int magiaovien) {
		this.magiaovien = magiaovien;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

}
