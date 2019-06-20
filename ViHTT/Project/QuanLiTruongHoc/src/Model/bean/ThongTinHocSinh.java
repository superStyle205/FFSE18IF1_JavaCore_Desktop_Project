package Model.bean;

public class ThongTinHocSinh {
	public String soThuTu;
	public String maHS;
	public String tenHS;
	public String gioiTinh;
	public String ngaySinh;
	public String diaChi;
	public String lop;
	public String soDienThoai;
	
	
	
	
	
	public ThongTinHocSinh() {
		super();
	
	}
	public ThongTinHocSinh(String soThuTu, String maHS, String tenHS, String gioiTinh, String ngaysinh, String diachi,
			String lop, String sodienthoai) {
		super();
		this.soThuTu = soThuTu;
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diachi;
		this.lop = lop;
		this.soDienThoai = soDienThoai;
	}
	public String getSoThuTu() {
		return soThuTu;
	}
	public void setSoThuTu(String soThuTu) {
		this.soThuTu = soThuTu;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getTenHS() {
		return tenHS;
	}
	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaysinh() {
		return ngaySinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaySinh = ngaysinh;
	}
	public String getDiachi() {
		return diaChi;
	}
	public void setDiachi(String diachi) {
		this.diaChi = diachi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getSodienthoai() {
		return soDienThoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.soDienThoai = soDienThoai;
	}

}
