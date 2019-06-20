package model;

public class Mon {
	private String maMon_Mon;
	private String tenMon_Mon;
	private String maGiaoVien_Mon;
	private String tenGiaoVien_Mon;
	private String ghiChuMon;
	
	public  Mon() {
		
	}

	public Mon(String maMon_Mon, String tenMon_Mon, String maGiaoVien_Mon, String tenGiaoVien_Mon, String ghiChuMon) {
		super();
		this.maMon_Mon = maMon_Mon;
		this.tenMon_Mon = tenMon_Mon;
		this.maGiaoVien_Mon = maGiaoVien_Mon;
		this.tenGiaoVien_Mon = tenGiaoVien_Mon;
		this.ghiChuMon = ghiChuMon;
	}

	public String getMaMon_Mon() {
		return maMon_Mon;
	}

	public void setMaMon_Mon(String maMon_Mon) {
		this.maMon_Mon = maMon_Mon;
	}

	public String getTenMon_Mon() {
		return tenMon_Mon;
	}

	public void setTenMon_Mon(String tenMon_Mon) {
		this.tenMon_Mon = tenMon_Mon;
	}

	public String getMaGiaoVien_Mon() {
		return maGiaoVien_Mon;
	}

	public void setMaGiaoVien_Mon(String maGiaoVien_Mon) {
		this.maGiaoVien_Mon = maGiaoVien_Mon;
	}

	public String getTenGiaoVien_Mon() {
		return tenGiaoVien_Mon;
	}

	public void setTenGiaoVien_Mon(String tenGiaoVien_Mon) {
		this.tenGiaoVien_Mon = tenGiaoVien_Mon;
	}

	public String getGhiChuMon() {
		return ghiChuMon;
	}

	public void setGhiChuMon(String ghiChuMon) {
		this.ghiChuMon = ghiChuMon;
	}
	
	

}
