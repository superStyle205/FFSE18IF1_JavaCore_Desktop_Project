package model;

public class Diem {
	private int maHoSinh;
	private String tenHocSinh_Diem;
	private String maLop;
	private String tenLop_Diem;
	private String maMon;
	private String tenMon_Diem;
	public float diem15P1;
	public float diem15P2;
	public float diem1T;
	public float diemHocKy1;
	public float diemHocKy2;
	public float tongDiem;
	
	public  Diem() {
		
	}

	public Diem(int maHoSinh, String tenHocSinh_Diem, String maLop, String tenLop_Diem, String maMon,
			String tenMon_Diem, float diem15p1, float diem15p2, float diem1t, float diemHocKy1, float diemHocKy2,
			float tongDiem) {
		super();
		this.maHoSinh = maHoSinh;
		this.tenHocSinh_Diem = tenHocSinh_Diem;
		this.maLop = maLop;
		this.tenLop_Diem = tenLop_Diem;
		this.maMon = maMon;
		this.tenMon_Diem = tenMon_Diem;
		diem15P1 = diem15p1;
		diem15P2 = diem15p2;
		diem1T = diem1t;
		this.diemHocKy1 = diemHocKy1;
		this.diemHocKy2 = diemHocKy2;
		this.tongDiem = tongDiem;
	}

	public int getMaHoSinh() {
		return maHoSinh;
	}

	public void setMaHoSinh(int maHoSinh) {
		this.maHoSinh = maHoSinh;
	}

	public String getTenHocSinh_Diem() {
		return tenHocSinh_Diem;
	}

	public void setTenHocSinh_Diem(String tenHocSinh_Diem) {
		this.tenHocSinh_Diem = tenHocSinh_Diem;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop_Diem() {
		return tenLop_Diem;
	}

	public void setTenLop_Diem(String tenLop_Diem) {
		this.tenLop_Diem = tenLop_Diem;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon_Diem() {
		return tenMon_Diem;
	}

	public void setTenMon_Diem(String tenMon_Diem) {
		this.tenMon_Diem = tenMon_Diem;
	}

	public float getDiem15P1() {
		return diem15P1;
	}

	public void setDiem15P1(float diem15p1) {
		diem15P1 = diem15p1;
	}

	public float getDiem15P2() {
		return diem15P2;
	}

	public void setDiem15P2(float diem15p2) {
		diem15P2 = diem15p2;
	}

	public float getDiem1T() {
		return diem1T;
	}

	public void setDiem1T(float diem1t) {
		diem1T = diem1t;
	}

	public float getDiemHocKy1() {
		return diemHocKy1;
	}

	public void setDiemHocKy1(float diemHocKy1) {
		this.diemHocKy1 = diemHocKy1;
	}

	public float getDiemHocKy2() {
		return diemHocKy2;
	}

	public void setDiemHocKy2(float diemHocKy2) {
		this.diemHocKy2 = diemHocKy2;
	}

	public float getTongDiem() {
		return tongDiem;
	}

	public void setTongDiem(float tongDiem) {
		this.tongDiem = tongDiem;
	}

	
}
