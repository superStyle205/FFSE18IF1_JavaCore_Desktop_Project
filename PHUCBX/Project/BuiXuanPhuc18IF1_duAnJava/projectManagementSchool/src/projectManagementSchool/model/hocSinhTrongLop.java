package projectManagementSchool.model;

import java.io.Serializable;
import java.sql.Date;

public class hocSinhTrongLop implements Serializable {

	private static final long serialVersionUID = 1L;
	private String maHocSinh, tenHocSinh, gioiTinh, hanhKiem, ghiChu, maLop;
	private String ngaySinh;
	private String id;

	@Override
	public String toString() {
		return tenHocSinh;
	}

	public hocSinhTrongLop(String id, String maHocSinh, String tenHocSinh, String gioiTinh, String hanhKiem, String ghiChu,
			String ngaySinh, String maLop) {
		super();
		this.id = id;
		this.maLop = maLop;
		this.maHocSinh = maHocSinh;
		this.tenHocSinh = tenHocSinh;
		this.gioiTinh = gioiTinh;
		this.hanhKiem = hanhKiem;
		this.ngaySinh = ngaySinh;
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

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public hocSinhTrongLop() {
		super();
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHanhKiem() {
		return hanhKiem;
	}

	public void setHanhKiem(String hanhKiem) {
		this.hanhKiem = hanhKiem;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
