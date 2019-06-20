package projectManagementSchool.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Lop implements Serializable {

	private static final long serialVersionUID = 1L;
	private String maKhoi, maLop, tenLop, maNhanVien, tenNhanVien, nienKhoa, ghiChu;
	private String id;

	@Override
	public String toString() {
		return tenLop;
	}

	public Lop(String id, String maKhoi, String maLop, String tenLop, String maNhanVien, String tenNhanVien,
			String nienKhoa, String ghiChu) {
		super();
		this.id = id;
		this.maKhoi = maKhoi;
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.nienKhoa = nienKhoa;
		this.ghiChu = ghiChu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Lop() {
		super();
	}

	public String getMaKhoi() {
		return maKhoi;
	}

	public void setMaKhoi(String maKhoi) {
		this.maKhoi = maKhoi;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
