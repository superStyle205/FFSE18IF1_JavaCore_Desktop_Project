package projectManagementSchool.model;

public class hocKi {

	private String maHocKi,tenHocKi;

	@Override
	public String toString() {
		return tenHocKi;
	}

	public String getMaHocKi() {
		return maHocKi;
	}

	public void setMaHocKi(String maHocKi) {
		this.maHocKi = maHocKi;
	}

	public String getTenHocKi() {
		return tenHocKi;
	}

	public void setTenHocKi(String tenHocKi) {
		this.tenHocKi = tenHocKi;
	}

	public hocKi(String maHocKi, String tenHocKi) {
		super();
		this.maHocKi = maHocKi;
		this.tenHocKi = tenHocKi;
	}

	public hocKi() {
		super();
	}
	
}
