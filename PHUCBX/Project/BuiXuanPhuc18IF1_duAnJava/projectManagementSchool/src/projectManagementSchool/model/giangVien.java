package projectManagementSchool.model;

import java.io.Serializable;
import java.util.Date;

public class giangVien implements Serializable {

	private static final long serialVersionUID = 1L;
	private String maPB, maNV, tenNV, chucVu, ngaySinh, diaChi, danToc, tonGiao, ngayVaoLam, queQuan,
			nguyenQuan, soDienThoai, Email, ghiChu;
	private String id;

	public giangVien(String id, String maPB, String maNV, String tenNV, String chucVu, String ngaySinh,
			String diaChi, String danToc, String tonGiao, String ngayVaoLam, String queQuan, String nguyenQuan,
			String soDienThoai, String email, String ghiChu) {
		super();
		this.id = id;
		this.maPB = maPB;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.danToc = danToc;
		this.tonGiao = tonGiao;
		this.ngayVaoLam = ngayVaoLam;
		this.queQuan = queQuan;
		this.nguyenQuan = nguyenQuan;
		this.soDienThoai = soDienThoai;
		Email = email;
		this.ghiChu = ghiChu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public giangVien() {
		super();
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(String ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getNguyenQuan() {
		return nguyenQuan;
	}

	public void setNguyenQuan(String nguyenQuan) {
		this.nguyenQuan = nguyenQuan;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
