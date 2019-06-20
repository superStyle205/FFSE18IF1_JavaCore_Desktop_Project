package Model.bean;

public class ThongTinGiaoVien {
	private String soThuTu;
	private String maGV;
	private String tenGV;
	private String gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String lopChuNhiem;
	private String monDay;
	private String soDienThoai;
	
	
	
	
	
	
	
	public ThongTinGiaoVien() {
		super();
		
	}
	public ThongTinGiaoVien(String soThuTu, String maGV, String tenGV, String gioiTinh, String ngaySinh, String diaChi,
			String lopChuNhiem, String monDay, String soDienThoai) {
		super();
		this.soThuTu = soThuTu;
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.lopChuNhiem = lopChuNhiem;
		this.monDay = monDay;
		this.soDienThoai = soDienThoai;
	}
	public String getSoThuTu() {
		return soThuTu;
	}
	public void setSoThuTu(String soThuTu) {
		this.soThuTu = soThuTu;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
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
	public String getLopChuNhiem() {
		return lopChuNhiem;
	}
	public void setLopChuNhiem(String lopChuNhiem) {
		this.lopChuNhiem = lopChuNhiem;
	}
	public String getMonDay() {
		return monDay;
	}
	public void setMonDay(String monDay) {
		this.monDay = monDay;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
}
