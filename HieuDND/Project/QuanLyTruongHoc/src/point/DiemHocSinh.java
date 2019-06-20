package point;

public class DiemHocSinh {
	public String Id_MonHoc;
	public String Id_HocSinh;
	public String Diem_Mieng;
	public String Diem15p;
	public String Diem1Tiet;
	public String DiemHocKi;
	
	public DiemHocSinh() {
		super();
	}

	public DiemHocSinh(String id_MonHoc, String id_HocSinh, String diem_Mieng, String diem15p, String diem1Tiet,
			String diemHocKi) {
		super();
		Id_MonHoc = id_MonHoc;
		Id_HocSinh = id_HocSinh;
		Diem_Mieng = diem_Mieng;
		Diem15p = diem15p;
		Diem1Tiet = diem1Tiet;
		DiemHocKi = diemHocKi;
	}

	public String getId_MonHoc() {
		return Id_MonHoc;
	}

	public void setId_MonHoc(String id_MonHoc) {
		Id_MonHoc = id_MonHoc;
	}

	public String getId_HocSinh() {
		return Id_HocSinh;
	}

	public void setId_HocSinh(String id_HocSinh) {
		Id_HocSinh = id_HocSinh;
	}

	public String getDiem_Mieng() {
		return Diem_Mieng;
	}

	public void setDiem_Mieng(String diem_Mieng) {
		Diem_Mieng = diem_Mieng;
	}

	public String getDiem15p() {
		return Diem15p;
	}

	public void setDiem15p(String diem15p) {
		Diem15p = diem15p;
	}

	public String getDiem1Tiet() {
		return Diem1Tiet;
	}

	public void setDiem1Tiet(String diem1Tiet) {
		Diem1Tiet = diem1Tiet;
	}

	public String getDiemHocKi() {
		return DiemHocKi;
	}

	public void setDiemHocKi(String diemHocKi) {
		DiemHocKi = diemHocKi;
	}
	
}
