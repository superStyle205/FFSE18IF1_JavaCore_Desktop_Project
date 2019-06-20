package school_year;

public class NienKhoa {
	public String Id_NienKhoa;
	public String SchoolYear;
	
	public NienKhoa() {
		super();
	}

	public NienKhoa(String id_NienKhoa, String schoolYear) {
		super();
		Id_NienKhoa = id_NienKhoa;
		SchoolYear = schoolYear;
	}

	public String getId_NienKhoa() {
		return Id_NienKhoa;
	}

	public void setId_NienKhoa(String id_NienKhoa) {
		Id_NienKhoa = id_NienKhoa;
	}

	public String getSchoolYear() {
		return SchoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		SchoolYear = schoolYear;
	}
	
}
