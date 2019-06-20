package dao;

public class Mon {
	String idMon;
	String tenMon;

	public Mon() {

	}

	public Mon(String idMon, String tenMon) {
		
		this.idMon = idMon;
		this.tenMon = tenMon;
	}

	public String getIdMon() {
		return idMon;
	}

	public void setIdMon(String idMon) {
		this.idMon = idMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
}
