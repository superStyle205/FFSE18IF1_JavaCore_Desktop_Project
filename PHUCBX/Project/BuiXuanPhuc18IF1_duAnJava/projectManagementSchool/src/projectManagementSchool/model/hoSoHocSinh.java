package projectManagementSchool.model;

public class hoSoHocSinh {
	private String soDienThoai;
	private String id, maLop, maHocSinh, tenHocSinh, gioiTinh, noiSinh, diaChi, email, hoTenBo, hoTenMe, ghiChu,
			ngaySinh;

	@Override
	public String toString() {
		return tenHocSinh;
	}

	public hoSoHocSinh(String id, String soDienThoai, String maLop, String maHocSinh, String tenHocSinh,
			String gioiTinh, String noiSinh, String diaChi, String email, String hoTenBo, String hoTenMe, String ghiChu,
			String ngaySinh) {
		super();

		this.id = id;
		this.maLop = maLop;
		this.maHocSinh = maHocSinh;
		this.tenHocSinh = tenHocSinh;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
		this.email = email;
		this.hoTenBo = hoTenBo;
		this.hoTenMe = hoTenMe;
		this.soDienThoai = soDienThoai;
		this.ghiChu = ghiChu;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public hoSoHocSinh() {
		super();
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
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

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTenBo() {
		return hoTenBo;
	}

	public void setHoTenBo(String hoTenBo) {
		this.hoTenBo = hoTenBo;
	}

	public String getHoTenMe() {
		return hoTenMe;
	}

	public void setHoTenMe(String hoTenMe) {
		this.hoTenMe = hoTenMe;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
