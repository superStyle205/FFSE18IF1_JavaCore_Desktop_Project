package dao;

public class Diem {
	private String idLop;
	private String monHoc;
	private String idMonHoc;
	private String idHocSinh;
	
	private String diem15;
	private String diem45;
	private String diemThi;
	private String tongKet;
	
	private String ketQua;
	private String idGv;

	public Diem() {

	}

	public Diem(String idLop, String monHoc, String idMonHoc, String idHocSinh, String diem15, String diem45,
			String diemThi, String tongKet, String ketQua, String idGv) {
		
		this.idLop = idLop;
		this.monHoc = monHoc;
		this.idMonHoc = idMonHoc;
		this.idHocSinh = idHocSinh;
		
		this.diem15 = diem15;
		this.diem45 = diem45;
		this.diemThi = diemThi;
		this.tongKet = tongKet;
		
		this.ketQua = ketQua;
		this.idGv = idGv;
		
	}

	public String getIdLop() {
		return idLop;
	}

	public void setIdLop(String idLop) {
		this.idLop = idLop;
	}

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public String getIdMonHoc() {
		return idMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		this.idMonHoc = idMonHoc;
	}

	public String getIdHocSinh() {
		return idHocSinh;
	}

	public void setIdHocSinh(String idHocSinh) {
		this.idHocSinh = idHocSinh;
	}

	public String getDiem15() {
		return diem15;
	}

	public void setDiem15(String diem15) {
		this.diem15 = diem15;
	}

	public String getDiem45() {
		return diem45;
	}

	public void setDiem45(String diem45) {
		this.diem45 = diem45;
	}

	public String getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(String diemThi) {
		this.diemThi = diemThi;
	}

	public String getTongKet() {
		return tongKet;
	}

	public void setTongKet(String tongKet) {
		this.tongKet = tongKet;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	public String getIdGv() {
		return idGv;
	}

	public void setIdGv(String idGv) {
		this.idGv = idGv;
	}
}
