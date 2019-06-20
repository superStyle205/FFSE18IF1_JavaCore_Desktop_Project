package Model.bean;

import java.io.Serializable;
import java.sql.Date;

public class Hoso implements Serializable {
	private static final long serialVersionUID = 1L;

	private String Id;
	private String Ten;
	private Date NgaySinh;
	private double GioiTinh;
	private String QueQuan;
	private DanhMucLop Lop;

	public DanhMucLop getLop() {
		return Lop;
	}

	public void setLop(DanhMucLop lop) {
		Lop = lop;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public double getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(double gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getQueQuan() {
		return QueQuan;
	}

	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Hoso(String id, String ten, Date ngaySinh, double gioiTinh, String queQuan) {
		super();
		Id = id;
		Ten = ten;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		QueQuan = queQuan;
	}

	public Hoso() {
		super();
		// TODO Auto-generated constructor stub
	}

}
