package model;

public class ClassStudent {
	private String maLop;
	private String tenLop;
	private String maGiaoVien_lop;
	private String tenGiaoVien_lop;
	private String ghiChuLop;
	
	public  ClassStudent() {
		
	}

	public ClassStudent(String maLop, String tenLop, String maGiaoVien_lop, String tenGiaoVien_lop, String ghiChuLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.maGiaoVien_lop = maGiaoVien_lop;
		this.tenGiaoVien_lop = tenGiaoVien_lop;
		this.ghiChuLop = ghiChuLop;
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

	public String getMaGiaoVien_lop() {
		return maGiaoVien_lop;
	}

	public void setMaGiaoVien_lop(String maGiaoVien_lop) {
		this.maGiaoVien_lop = maGiaoVien_lop;
	}

	public String getTenGiaoVien_lop() {
		return tenGiaoVien_lop;
	}

	public void setTenGiaoVien_lop(String tenGiaoVien_lop) {
		this.tenGiaoVien_lop = tenGiaoVien_lop;
	}

	public String getGhiChuLop() {
		return ghiChuLop;
	}

	public void setGhiChuLop(String ghiChuLop) {
		this.ghiChuLop = ghiChuLop;
	}
	
	
}
