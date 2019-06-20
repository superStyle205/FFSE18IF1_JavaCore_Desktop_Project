package model;

public class Student {
	private String maHocSinh;
	private String tenHocSinh;
	private String ngaySinhHS;
	private String gioiTinhHS;
	private String queQuanHS;
	private String SDTHocSinh;
	private String maLop;
	private String hoTenCha;
	private String hoTenMe;
	private String SDTPhuHuynh;
	private String diaChiLienHe;
	private String tenLop;
	private String ghiChuHS;
	
	public Student() {
		
	}

	public Student(String maHocSinh, String tenHocSinh, String ngaySinhHS, String gioiTinhHS, String queQuanHS,
			String sDTHocSinh,String maLop, String hoTenCha, String hoTenMe, String sDTPhuHuynh, String diaChiLienHe,
			String tenLop, String ghiChuHS) {
		super();
		this.maHocSinh = maHocSinh;
		this.tenHocSinh = tenHocSinh;
		this.ngaySinhHS = ngaySinhHS;
		this.gioiTinhHS = gioiTinhHS;
		this.queQuanHS = queQuanHS;
		SDTHocSinh = sDTHocSinh;
		this.maLop = maLop;
		this.hoTenCha = hoTenCha;
		this.hoTenMe = hoTenMe;
		SDTPhuHuynh = sDTPhuHuynh;
		this.diaChiLienHe = diaChiLienHe;
		this.tenLop = tenLop;
		this.ghiChuHS = ghiChuHS;
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

	public String getNgaySinhHS() {
		return ngaySinhHS;
	}

	public void setNgaySinhHS(String ngaySinhHS) {
		this.ngaySinhHS = ngaySinhHS;
	}

	public String getGioiTinhHS() {
		return gioiTinhHS;
	}

	public void setGioiTinhHS(String gioiTinhHS) {
		this.gioiTinhHS = gioiTinhHS;
	}

	public String getQueQuanHS() {
		return queQuanHS;
	}

	public void setQueQuanHS(String queQuanHS) {
		this.queQuanHS = queQuanHS;
	}

	public String getSDTHocSinh() {
		return SDTHocSinh;
	}

	public void setSDTHocSinh(String sDTHocSinh) {
		SDTHocSinh = sDTHocSinh;
	}

	public String getHoTenCha() {
		return hoTenCha;
	}

	public void setHoTenCha(String hoTenCha) {
		this.hoTenCha = hoTenCha;
	}

	public String getHoTenMe() {
		return hoTenMe;
	}

	public void setHoTenMe(String hoTenMe) {
		this.hoTenMe = hoTenMe;
	}

	public String getSDTPhuHuynh() {
		return SDTPhuHuynh;
	}

	public void setSDTPhuHuynh(String sDTPhuHuynh) {
		SDTPhuHuynh = sDTPhuHuynh;
	}

	public String getDiaChiLienHe() {
		return diaChiLienHe;
	}

	public void setDiaChiLienHe(String diaChiLienHe) {
		this.diaChiLienHe = diaChiLienHe;
	}

	public String getGhiChuHS() {
		return ghiChuHS;
	}

	public void setGhiChuHS(String ghiChuHS) {
		this.ghiChuHS = ghiChuHS;
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

	
	
}
