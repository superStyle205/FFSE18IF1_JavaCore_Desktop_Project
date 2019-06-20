package Model.bean;

public class HocSinh {
	private String soThuTu;
	private String maHS;
	private String tenHS;
	private String gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String tenLop;
	private String soDienThoai;
	
	
	
	
	
	
	
	
	
	public HocSinh() {
		super();
		
	}
	public HocSinh(String soThuTu, String maHS, String tenHS, String gioiTinh, String ngaySinh, String diaChi,
			String tenLop, String soDienThoai) {
		super();
		this.soThuTu = soThuTu;
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.tenLop = tenLop;
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
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	
	
}
