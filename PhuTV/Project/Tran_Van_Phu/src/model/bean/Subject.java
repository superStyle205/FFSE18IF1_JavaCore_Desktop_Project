package model.bean;

public class Subject {

	private int maMonHoc;
	private String tenMonHoc;

	public Subject() {

	}

	public Subject(int maMonHoc, String tenMonHoc) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
	}
	public int getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(int maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}




	
}
