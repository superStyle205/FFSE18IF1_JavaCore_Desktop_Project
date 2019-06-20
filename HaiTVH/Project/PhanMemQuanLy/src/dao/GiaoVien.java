package dao;

public class GiaoVien {
	private String idGv;
	private String hoTenGv;
	private String idMonday;
	private String idLop;
	private String ngaySinh;
	private String gioiTinh;
	private String email;
	private String sdtGv;

	public GiaoVien() {

	}

	public GiaoVien(String idGv, String hoTenGv, String idMonday, String idLop, String ngaySinh, String gioiTinh,
			String email, String sdtGv) {

		this.idGv = idGv;
		this.hoTenGv = hoTenGv;
		this.idMonday = idMonday;
		this.idLop = idLop;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.sdtGv = sdtGv;

	}

	public String getIdGv() {
		return idGv;
	}

	public void setIdGv(String idGv) {
		this.idGv = idGv;
	}

	public String getHoTenGv() {
		return hoTenGv;
	}

	public void setHoTenGv(String hoTenGv) {
		this.hoTenGv = hoTenGv;
	}

	public String getIdMonday() {
		return idMonday;
	}

	public void setIdMonday(String idMonday) {
		this.idMonday = idMonday;
	}

	public String getIdLop() {
		return idLop;
	}

	public void setIdLop(String idLop) {
		this.idLop = idLop;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinhGv() {
		return gioiTinh;
	}

	public void setGioiTinhGv(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdtGv() {
		return sdtGv;
	}

	public void setSdtGv(String sdtGv) {
		this.sdtGv = sdtGv;
	}
}
