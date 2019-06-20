package model.bean;

public class Student {

	private int maHocSinh;
	private String maLop;
	private String hoTen;
	private String ngaySinh;
	private String gioiTinh;
	private String noiSinh;
	private String danToc;
	private String tonGiao;
	private String nienKhoa;
	private String SdtPhuHuynh;


	public Student() {

	}


	public Student(int maHocSinh, String maLop, String hoTen, String ngaySinh, String gioiTinh, String noiSinh,
			String danToc, String tonGiao, String nienKhoa, String sdtPhuHuynh) {
		super();
		this.maHocSinh = maHocSinh;
		this.maLop = maLop;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.noiSinh = noiSinh;
		this.danToc = danToc;
		this.tonGiao = tonGiao;
		this.nienKhoa = nienKhoa;
		this.SdtPhuHuynh = sdtPhuHuynh;
	}


	public int getMaHocSinh() {
		return maHocSinh;
	}


	public void setMaHocSinh(int maHocSinh) {
		this.maHocSinh = maHocSinh;
	}


	public String getMaLop() {
		return maLop;
	}


	public void setMaLop(String maLop) {
		this.maLop = maLop;
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


	public String getNienKhoa() {
		return nienKhoa;
	}


	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}


	public String getSdtPhuHuynh() {
		return SdtPhuHuynh;
	}


	public void setSdtPhuHuynh(String sdtPhuHuynh) {
		SdtPhuHuynh = sdtPhuHuynh;
	}

	

	
}
