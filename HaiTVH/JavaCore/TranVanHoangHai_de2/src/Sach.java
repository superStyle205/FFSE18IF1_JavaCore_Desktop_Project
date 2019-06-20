
public class Sach {
	
	private int id;
	private String ten;
	private String tacGia;
	private int namXuatBan;
	private double giaCa;

	public Sach(int id, String ten, String tacGia, int namXuatBan, double giaCa) {
		this.id = id;
		this.ten = ten;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaCa = giaCa;
	}

	public Sach() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getGiaCa() {
		return giaCa;
	}

	public void setGiaCa(double giaCa) {
		this.giaCa = giaCa;
	}

}
