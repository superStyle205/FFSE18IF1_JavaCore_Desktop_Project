package subjects;

public class MonHoc {
	public String Id_MonHoc;
	public String Ten_Mon;
	public String Id_GiaoVien;
	
	public MonHoc() {
		super();
	}

	public MonHoc(String id_MonHoc, String ten_Mon, String id_GiaoVien) {
		super();
		Id_MonHoc = id_MonHoc;
		Ten_Mon = ten_Mon;
		Id_GiaoVien = id_GiaoVien;
	}

	public String getId_MonHoc() {
		return Id_MonHoc;
	}

	public void setId_MonHoc(String id_MonHoc) {
		Id_MonHoc = id_MonHoc;
	}

	public String getTen_Mon() {
		return Ten_Mon;
	}

	public void setTen_Mon(String ten_Mon) {
		Ten_Mon = ten_Mon;
	}

	public String getId_GiaoVien() {
		return Id_GiaoVien;
	}

	public void setId_GiaoVien(String id_GiaoVien) {
		Id_GiaoVien = id_GiaoVien;
	}
	
	
}
