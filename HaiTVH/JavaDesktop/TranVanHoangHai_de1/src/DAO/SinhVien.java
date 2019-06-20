package DAO;

public class SinhVien {
	private String id;
	private String ten;
	private String lop;
	private String nienkhoa;
	private String diem;

	public SinhVien() {

	}

	public SinhVien(String id, String ten, String lop, String nienkhoa, String diem) {
		super();
		this.id = id;
		this.ten = ten;
		this.lop = lop;
		this.nienkhoa = nienkhoa;
		this.diem = diem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getNienkhoa() {
		return nienkhoa;
	}

	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	

}