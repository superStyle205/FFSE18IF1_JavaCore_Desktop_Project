package class_room;

public class Lop {
	public String Id_Lop;
	public String ClassName;
	public String Id_NienKhoa;
	
	public Lop() {
		super();
	}

	public Lop(String id_Lop, String className, String id_NienKhoa) {
		super();
		Id_Lop = id_Lop;
		ClassName = className;
		Id_NienKhoa = id_NienKhoa;
	}

	public String getId_Lop() {
		return Id_Lop;
	}

	public void setId_Lop(String id_Lop) {
		Id_Lop = id_Lop;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getId_NienKhoa() {
		return Id_NienKhoa;
	}

	public void setId_NienKhoa(String id_NienKhoa) {
		Id_NienKhoa = id_NienKhoa;
	}
}
