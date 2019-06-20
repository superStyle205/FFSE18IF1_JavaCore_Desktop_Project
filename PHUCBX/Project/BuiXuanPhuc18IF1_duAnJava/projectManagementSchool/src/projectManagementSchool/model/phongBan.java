package projectManagementSchool.model;

import java.io.Serializable;
import java.util.ArrayList;

public class phongBan implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maPhong, tenPhong;

	@Override
	public String toString() {
		return tenPhong;
	}

	public phongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
	}

	public phongBan() {
		super();
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

}
