package model.bean;

public class Teacher {

	private int maGiaoVien;
	private String hoTenGiaoVien;
	private String chucVu;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	
	public Teacher() {
		
	}

	public Teacher(int maGiaoVien, String hoTenGiaoVien, String chucVu, String gioiTinh, String diaChi,
			String soDienThoai) {
		super();
		this.maGiaoVien = maGiaoVien;
		this.hoTenGiaoVien = hoTenGiaoVien;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public int getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getHoTenGiaoVien() {
		return hoTenGiaoVien;
	}

	public void setHoTenGiaoVien(String hoTenGiaoVien) {
		this.hoTenGiaoVien = hoTenGiaoVien;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	
}
