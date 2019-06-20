package projectManagementSchool.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Khoi implements Serializable {

	private static final long serialVersionUID = 1L;
	private String maKhoi, tenKhoi;

	@Override
	public String toString() {
		return tenKhoi;
	}

	public Khoi(String maKhoi, String tenKhoi) {
		super();
		this.maKhoi = maKhoi;
		this.tenKhoi = tenKhoi;
	}

	public String getMaKhoi() {
		return maKhoi;
	}

	public void setMaKhoi(String maKhoi) {
		this.maKhoi = maKhoi;
	}

	public String getTenKhoi() {
		return tenKhoi;
	}

	public void setTenKhoi(String tenKhoi) {
		this.tenKhoi = tenKhoi;
	}

	public Khoi() {
		super();
	}

}
