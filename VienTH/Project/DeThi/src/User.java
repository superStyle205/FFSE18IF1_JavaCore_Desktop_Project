
public class User {

	private String masinhvien;
	private String tensinhvien;
	private String lop;
	private String nienkhoa;
	private String diemtrungbinh;
	
	
	public String getMasinhvien() {
		return masinhvien;
	}
	public void setMasinhvien(String i) {
		this.masinhvien = i;
	}
	public String getTensinhvien() {
		
		return tensinhvien;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setTensinhvien(String tensinhvien) {
		this.tensinhvien = tensinhvien;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public User(String masinhvien, String tensinhvien, String lop, String nienkhoa, String diemtrungbinh) {
		super();
		this.masinhvien = masinhvien;
		this.tensinhvien = tensinhvien;
		this.lop = lop;
		this.nienkhoa = nienkhoa;
		this.diemtrungbinh = diemtrungbinh;
	}
	public String getNienkhoa() {
		return nienkhoa;
	}
	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	public String getDiemtrungbinh() {
		return diemtrungbinh;
	}
	public void setDiemtrungbinh(String diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}
	

	
	



}
