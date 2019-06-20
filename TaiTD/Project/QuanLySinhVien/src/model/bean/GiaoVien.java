package model.bean;

public class GiaoVien {
    private String MaGV;
    private String TenGV;
    private String ChuyenNganh;
    private String MaKhoa;
    
    public GiaoVien(){
    	
    }
    
	public GiaoVien(String maGV, String tenGV, String chuyenNganh, String maKhoa) {
		super();
		MaGV = maGV;
		TenGV = tenGV;
		ChuyenNganh = chuyenNganh;
		MaKhoa = maKhoa;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getTenGV() {
		return TenGV;
	}
	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}
	public String getChuyenNganh() {
		return ChuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		ChuyenNganh = chuyenNganh;
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
    
    
}
