package model.bean;

public class HoSoHocSinh {
	public int mahocsinh;
	public String malop, hoten, diachi, dantoc;
	public String namsinh, gioitinh, email;
	public String hotencha, hotenme, ghichu;

	/**
	 * 
	 */
	public HoSoHocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mahocsinh
	 * @param malop
	 * @param hoten
	 * @param daichi
	 * @param dantoc
	 * @param namsinh
	 * @param gioitinh
	 * @param email
	 * @param hotencha
	 * @param hotenme
	 * @param ghichu
	 */
	public HoSoHocSinh(int mahocsinh, String malop, String hoten, String diachi, String dantoc, String namsinh,
			String gioitinh, String email, String hotencha, String hotenme, String ghichu) {
		super();
		this.mahocsinh = mahocsinh;
		this.malop = malop;
		this.hoten = hoten;
		this.diachi = diachi;
		this.dantoc = dantoc;
		this.namsinh = namsinh;
		this.gioitinh = gioitinh;
		this.email = email;
		this.hotencha = hotencha;
		this.hotenme = hotenme;
		this.ghichu = ghichu;
	}

	public int getMahocsinh() {
		return mahocsinh;
	}

	public void setMahocsinh(int mahocsinh) {
		this.mahocsinh = mahocsinh;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getDantoc() {
		return dantoc;
	}

	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHotencha() {
		return hotencha;
	}

	public void setHotencha(String hotencha) {
		this.hotencha = hotencha;
	}

	public String getHotenme() {
		return hotenme;
	}

	public void setHotenme(String hotenme) {
		this.hotenme = hotenme;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

}
