package dao;


public class HocSinh extends Lop {

	private String idHocSinh;
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private String gioiTinh;
	private String sdt;

	public HocSinh() {

	}

	public HocSinh(String idHocSinh, String hoTen, String ngaySinh, String diaChi, String gioiTinh,
			String sdt) {

		this.idHocSinh = idHocSinh;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
	}

	public String getIdHocSinh() {
		return idHocSinh;
	}

	public void setIdHocSinh(String idSinhVien) {
		this.idHocSinh = idSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


}
