package projectManagementSchool.model;

public class diemTungMon {
	private String id, maLop, maMon, maHocKi, maHocSinh, tenHocSinh, ghiChu;
	private String mieng, diem15pLan1, diem15pLan2, diem1Tiet, diemHocKi;

	public diemTungMon() {
		super();
	}

	public diemTungMon(String id, String maLop, String maMon, String maHocKi, String maHocSinh, String tenHocSinh,
			String ghiChu, String mieng, String diem15pLan1, String diem15pLan2, String diem1Tiet, String diemHocKi) {
		super();
		this.id = id;
		this.maLop = maLop;
		this.maMon = maMon;
		this.maHocKi = maHocKi;
		this.maHocSinh = maHocSinh;
		this.tenHocSinh = tenHocSinh;
		this.mieng = mieng;
		this.diem15pLan1 = diem15pLan1;
		this.diem15pLan2 = diem15pLan2;
		this.diem1Tiet = diem1Tiet;
		this.diemHocKi = diemHocKi;
		this.ghiChu = ghiChu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getMaHocKi() {
		return maHocKi;
	}

	public void setMaHocKi(String maHocKi) {
		this.maHocKi = maHocKi;
	}

	public String getMaHocSinh() {
		return maHocSinh;
	}

	public void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}

	public String getTenHocSinh() {
		return tenHocSinh;
	}

	public void setTenHocSinh(String tenHocSinh) {
		this.tenHocSinh = tenHocSinh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMieng() {
		return mieng;
	}

	public void setMieng(String mieng) {
		this.mieng = mieng;
	}

	public String getDiem15pLan1() {
		return diem15pLan1;
	}

	public void setDiem15pLan1(String diem15pLan1) {
		this.diem15pLan1 = diem15pLan1;
	}

	public String getDiem15pLan2() {
		return diem15pLan2;
	}

	public void setDiem15pLan2(String diem15pLan2) {
		this.diem15pLan2 = diem15pLan2;
	}

	public String getDiem1Tiet() {
		return diem1Tiet;
	}

	public void setDiem1Tiet(String diem1Tiet) {
		this.diem1Tiet = diem1Tiet;
	}

	public String getDiemHocKi() {
		return diemHocKi;
	}

	public void setDiemHocKi(String diemHocKi) {
		this.diemHocKi = diemHocKi;
	}

}
