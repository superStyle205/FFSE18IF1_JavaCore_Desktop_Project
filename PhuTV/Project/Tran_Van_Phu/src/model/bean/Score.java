package model.bean;

public class Score {

	private int STT;
	private String maHocSinh;
	private String maMonHoc;
	private String diemDauNam;
	private String diemGiuaKy;
	private String diemCuoiKy;
	private String diemTongKet;

	public Score() {

	}

	public Score(int stt, String maHocSinh, String maMonHoc, String diemDauNam, String diemGiuaKy, String diemCuoiKy,
			String diemTongKet) {
		super();
		STT = stt;
		this.maHocSinh = maHocSinh;
		this.maMonHoc = maMonHoc;
		this.diemDauNam = diemDauNam;
		this.diemGiuaKy = diemGiuaKy;
		this.diemCuoiKy = diemCuoiKy;
		this.diemTongKet = diemTongKet;
	}

	public int getStt() {
		return STT;
	}

	public void setStt(int stt) {
		STT = stt;
	}

	public String getMaHocSinh() {
		return maHocSinh;
	}

	public void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getDiemDauNam() {
		return diemDauNam;
	}

	public void setDiemDauNam(String diemDauNam) {
		this.diemDauNam = diemDauNam;
	}

	public String getDiemGiuaKy() {
		return diemGiuaKy;
	}

	public void setDiemGiuaKy(String diemGiuaKy) {
		this.diemGiuaKy = diemGiuaKy;
	}

	public String getDiemCuoiKy() {
		return diemCuoiKy;
	}

	public void setDiemCuoiKy(String diemCuoiKy) {
		this.diemCuoiKy = diemCuoiKy;
	}

	public String getDiemTongKet() {
		return diemTongKet;
	}

	public void setDiemTongKet(String diemTongKet) {
		this.diemTongKet = diemTongKet;
	}

	
}
