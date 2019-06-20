package model;

public class Teacher {
	private String maGV;
	private String tenGV;
	private String ngaySinhGV;
	private String gioiTinhGV;
	private String queQuanGV;
	private String SDTGV;
	private String trinhDo;
	private String email;
	private String ghiChuGV;
	
	public Teacher() {
		
	}

	public Teacher(String maGV, String tenGV, String ngaySinhGV, String gioiTinhGV, String queQuanGV, String sDTGV,
			String trinhDo, String email, String ghiChuGV) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.ngaySinhGV = ngaySinhGV;
		this.gioiTinhGV = gioiTinhGV;
		this.queQuanGV = queQuanGV;
		SDTGV = sDTGV;
		this.trinhDo = trinhDo;
		this.email = email;
		this.ghiChuGV = ghiChuGV;
	}

	public String getGhiChuGV() {
		return ghiChuGV;
	}

	public void setGhiChuGV(String ghiChuGV) {
		this.ghiChuGV = ghiChuGV;
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

	public String getNgaySinhGV() {
		return ngaySinhGV;
	}

	public void setNgaySinhGV(String ngaySinhGV) {
		this.ngaySinhGV = ngaySinhGV;
	}

	public String getGioiTinhGV() {
		return gioiTinhGV;
	}

	public void setGioiTinhGV(String gioiTinhGV) {
		this.gioiTinhGV = gioiTinhGV;
	}

	public String getQueQuanGV() {
		return queQuanGV;
	}

	public void setQueQuanGV(String queQuanGV) {
		this.queQuanGV = queQuanGV;
	}

	public String getSDTGV() {
		return SDTGV;
	}

	public void setSDTGV(String sDTGV) {
		SDTGV = sDTGV;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
