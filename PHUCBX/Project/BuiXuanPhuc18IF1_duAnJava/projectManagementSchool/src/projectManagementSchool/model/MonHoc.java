package projectManagementSchool.model;

public class MonHoc {

	private String id, maMonHoc, tenMonHoc, maNhanVien, soTietDay, ghiChu;

	@Override
	public String toString() {
		return tenMonHoc;
	}

	public MonHoc(String id, String maMonHoc, String tenMonHoc, String maNhanVien, String soTietDay, String ghiChu) {
		super();
		this.id = id;
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.maNhanVien = maNhanVien;
		this.soTietDay = soTietDay;
		this.ghiChu = ghiChu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String MaNhanVien) {
		this.maNhanVien = MaNhanVien;
	}

	public String getSoTietDay() {
		return soTietDay;
	}

	public void setSoTietDay(String soTietDay) {
		this.soTietDay = soTietDay;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public MonHoc() {
		super();
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

}
