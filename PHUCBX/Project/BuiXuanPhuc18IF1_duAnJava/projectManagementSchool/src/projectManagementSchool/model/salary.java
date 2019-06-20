package projectManagementSchool.model;

public class salary {

	private int thang, ngayLamViec, tienLuong;
	private String maGiaoVien, tenGiaoVien, GhiChu, id;
	private int heSoLuong, phuCap, luongTamUng, tienThuong, tongLuong;

	@Override
	public String toString() {
		return tenGiaoVien;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNgayLamViec() {
		return ngayLamViec;
	}

	public void setNgayLamViec(int ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
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

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public int getTienLuong() {
		return (getNgayLamViec() * 180000);
	}

	public void setTienLuong(int tienLuong) {
		this.tienLuong = tienLuong;
	}

	public int getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public int getLuongTamUng() {
		return luongTamUng;
	}

	public void setLuongTamUng(int luongTamUng) {
		this.luongTamUng = luongTamUng;
	}

	public int getTienThuong() {
		return tienThuong;
	}

	public void setTienThuong(int tienThuong) {
		this.tienThuong = tienThuong;
	}

	public int getTongLuong() {
		int tongLuong = (getTienLuong() * getHeSoLuong()) + getPhuCap() + getTienThuong() - getLuongTamUng();
				return tongLuong;
			}

	public void setTongLuong(int tongLuong) {
		this.tongLuong = tongLuong;
	}

	public salary() {
		super();
	}

	public salary(int thang, int ngayLamViec, String maGiaoVien, String tenGiaoVien, String ghiChu, int tienLuong,
			int heSoLuong, int phuCap, int luongTamUng, int tienThuong, int tongLuong, String id) {
		super();
		this.id = id;
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
		this.thang = thang;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
		this.ngayLamViec = ngayLamViec;
		this.luongTamUng = luongTamUng;
		this.tienLuong = tienLuong;
		this.tienThuong = tienThuong;
		this.tongLuong = tongLuong;
		this.GhiChu = ghiChu;
	}

}
