package model.bean;

import java.util.ArrayList;

public class HocSinh {
	public int mahocsinh;
	public String hoten;
	public String gioitinh;
	public String diachi, email;
	public String malop, namhoc, namsinh;
	
	private Lop lops;
	

	public HocSinh() {
		super();

	}


	public HocSinh(int mahocsinh, String hoten, String gioitinh, String diachi, String email, String malop,
			String namhoc, String namsinh, Lop lops) {
		super();
		this.mahocsinh = mahocsinh;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.email = email;
		this.malop = malop;
		this.namhoc = namhoc;
		this.namsinh = namsinh;
		this.lops = lops;
	}


	public int getMahocsinh() {
		return mahocsinh;
	}


	public void setMahocsinh(int mahocsinh) {
		this.mahocsinh = mahocsinh;
	}


	public String getHoten() {
		return hoten;
	}


	public void setHoten(String hoten) {
		this.hoten = hoten;
	}


	public String getGioitinh() {
		return gioitinh;
	}


	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}


	public String getDiachi() {
		return diachi;
	}


	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMalop() {
		return malop;
	}


	public void setMalop(String malop) {
		this.malop = malop;
	}


	public String getNamhoc() {
		return namhoc;
	}


	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}


	public String getNamsinh() {
		return namsinh;
	}


	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}


	public Lop getLops() {
		return lops;
	}


	public void setLops(Lop lops) {
		this.lops = lops;
	}

	
	

	

}
