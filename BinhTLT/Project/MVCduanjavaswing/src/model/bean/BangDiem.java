package model.bean;

public class BangDiem {
	public int mahocsinh;
	public String malop, mamon, mahocki;
	public String diem_mieng, diem_15p;
	public String diem_45p, diem_thi, ghichu;

	public BangDiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mahocsinh
	 * @param malop
	 * @param mamon
	 * @param mahocki
	 * @param diem_mieng
	 * @param diem_15p
	 * @param diem_45p
	 * @param diem_thi
	 * @param ghichu
	 */
	public BangDiem(int mahocsinh, String malop, String mamon, String mahocki, String diem_mieng, String diem_15p,
			String diem_45p, String diem_thi, String ghichu) {
		super();
		this.mahocsinh = mahocsinh;
		this.malop = malop;
		this.mamon = mamon;
		this.mahocki = mahocki;
		this.diem_mieng = diem_mieng;
		this.diem_15p = diem_15p;
		this.diem_45p = diem_45p;
		this.diem_thi = diem_thi;
		this.ghichu = ghichu;
	}

	public int getMahocsinh() {
		return mahocsinh;
	}

	public void setMahocsinh(int mahocsinh) {
		this.mahocsinh = mahocsinh;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getMamon() {
		return mamon;
	}

	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public String getMahocki() {
		return mahocki;
	}

	public void setMahocki(String mahocki) {
		this.mahocki = mahocki;
	}

	public String getDiem_mieng() {
		return diem_mieng;
	}

	public void setDiem_mieng(String diem_mieng) {
		this.diem_mieng = diem_mieng;
	}

	public String getDiem_15p() {
		return diem_15p;
	}

	public void setDiem_15p(String diem_15p) {
		this.diem_15p = diem_15p;
	}

	public String getDiem_45p() {
		return diem_45p;
	}

	public void setDiem_45p(String diem_45p) {
		this.diem_45p = diem_45p;
	}

	public String getDiem_thi() {
		return diem_thi;
	}

	public void setDiem_thi(String diem_thi) {
		this.diem_thi = diem_thi;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

}
