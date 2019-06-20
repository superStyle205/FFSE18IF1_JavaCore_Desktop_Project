package model.bean;

public class KetQuaHocTap {
	public int mahocsinh;
	public String malop, hoten, hocluc, hanhkiem;
	public String diemtrungbinh, xeploai, tennienkhoa;

	/**
	 * 
	 */
	public KetQuaHocTap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mahocsinh
	 * @param malop
	 * @param hoten
	 * @param hocluc
	 * @param hanhkiem
	 * @param diemtrungbinh
	 * @param xeploai
	 * @param tennienkhoa
	 */
	public KetQuaHocTap(int mahocsinh, String malop, String hoten, String hocluc, String hanhkiem, String diemtrungbinh,
			String xeploai, String tennienkhoa) {
		super();
		this.mahocsinh = mahocsinh;
		this.malop = malop;
		this.hoten = hoten;
		this.hocluc = hocluc;
		this.hanhkiem = hanhkiem;
		this.diemtrungbinh = diemtrungbinh;
		this.xeploai = xeploai;
		this.tennienkhoa = tennienkhoa;
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

	public String getHocluc() {
		return hocluc;
	}

	public void setHocluc(String hocluc) {
		this.hocluc = hocluc;
	}

	public String getHanhkiem() {
		return hanhkiem;
	}

	public void setHanhkiem(String hanhkiem) {
		this.hanhkiem = hanhkiem;
	}

	public String getDiemtrungbinh() {
		return diemtrungbinh;
	}

	public void setDiemtrungbinh(String diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}

	public String getXeploai() {
		return xeploai;
	}

	public void setXeploai(String xeploai) {
		this.xeploai = xeploai;
	}

	public String getTennienkhoa() {
		return tennienkhoa;
	}

	public void setTennienkhoa(String tennienkhoa) {
		this.tennienkhoa = tennienkhoa;
	}

}
