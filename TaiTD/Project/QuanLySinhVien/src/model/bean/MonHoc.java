package model.bean;

public class MonHoc {
	private String maMonHoc;
	private String tenMonHoc;
	private String soGio;
	public MonHoc(){
		
	}
	public MonHoc(String maMonHoc, String tenMonHoc, String soGio) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.soGio = soGio;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getMaMonHoc() {
		
		return maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getSoGio() {
		return soGio;
	}
	public void setSoGio(String soGio) {
		this.soGio = soGio;
	}
	
}
