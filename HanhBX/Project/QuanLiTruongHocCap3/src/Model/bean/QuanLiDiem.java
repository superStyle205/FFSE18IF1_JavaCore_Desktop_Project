package Model.bean;

public class QuanLiDiem {
	private String soThuTu;
	private String maHS;
	private String tenHS;
	private String monHoc;
	private String diemHocKi1;
	private String diemHocKi2;
	private String diemCuoiNam;
	
	
	
	
	
	
	
	
	public QuanLiDiem() {
		super();
		
	}
	public QuanLiDiem(String soThuTu, String maHS, String tenHS, String monHoc, String diemHocKi1, String diemHocKi2,
			String diemCuoiNam) {
		super();
		this.soThuTu = soThuTu;
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.monHoc = monHoc;
		this.diemHocKi1 = diemHocKi1;
		this.diemHocKi2 = diemHocKi2;
		this.diemCuoiNam = diemCuoiNam;
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
	public String getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public String getDiemHocKi1() {
		return diemHocKi1;
	}
	public void setDiemHocKi1(String diemHocKi1) {
		this.diemHocKi1 = diemHocKi1;
	}
	public String getDiemHocKi2() {
		return diemHocKi2;
	}
	public void setDiemHocKi2(String diemHocKi2) {
		this.diemHocKi2 = diemHocKi2;
	}
	public String getDiemCuoiNam() {
		return diemCuoiNam;
	}
	public void setDiemCuoiNam(String diemCuoiNam) {
		this.diemCuoiNam = diemCuoiNam;
	}
	
	
	
	
}
