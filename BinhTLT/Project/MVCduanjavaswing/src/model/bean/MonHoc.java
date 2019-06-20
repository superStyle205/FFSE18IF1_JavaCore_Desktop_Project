package model.bean;

public class MonHoc {
	public int magiaovien;
	public String mamon, sotietday;
	public String tenmonhoc;

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param magiaovien
	 * @param mamon
	 * @param sotietday
	 * @param tenmonhoc
	 */
	public MonHoc(int magiaovien, String mamon, String sotietday, String tenmonhoc) {
		super();
		this.magiaovien = magiaovien;
		this.mamon = mamon;
		this.sotietday = sotietday;
		this.tenmonhoc = tenmonhoc;
	}

	public int getMagiaovien() {
		return magiaovien;
	}

	public void setMagiaovien(int magiaovien) {
		this.magiaovien = magiaovien;
	}

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public String getSotietday() {
		return sotietday;
	}

	public void setSotietday(String sotietday) {
		this.sotietday = sotietday;
	}

	public String getTenmonhoc() {
		return tenmonhoc;
	}

	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}

}
