package model.bean;

public class NienKhoa {
	public String tennienkhoa;
	public String manienkhoa;
	public String getTennienkhoa() {
		return tennienkhoa;
	}
	public void setTennienkhoa(String tennienkhoa) {
		this.tennienkhoa = tennienkhoa;
	}
	public String getManienkhoa() {
		return manienkhoa;
	}
	public void setManienkhoa(String manienkhoa) {
		this.manienkhoa = manienkhoa;
	}
	/**
	 * @param tennienkhoa
	 * @param manienkhoa
	 */
	public NienKhoa(String tennienkhoa, String manienkhoa) {
		super();
		this.tennienkhoa = tennienkhoa;
		this.manienkhoa = manienkhoa;
	}
	/**
	 * 
	 */
	public NienKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
}
