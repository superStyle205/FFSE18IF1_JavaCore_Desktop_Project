package summary;

public class TongKet {
	public String Id_HocSinh;
	public String FirstName;
	public String LastName;
	public String Id_Lop;
	public String StudyCapacity_Semester1;
	public String Conduct_Semester1;
	public String StudyCapacity_Semester2;
	public String Conduct_Semester2;
	public String StudyCapacity_WholeYear;
	public String Conduct_WholeYear;
	public String Id_NienKhoa;
	
	public TongKet() {
		super();
	}

	public TongKet(String id_HocSinh, String firstName, String lastName, String id_Lop, String studyCapacity_Semester1,
			String conduct_Semester1, String studyCapacity_Semester2, String conduct_Semester2,
			String studyCapacity_WholeYear, String conduct_WholeYear, String id_NienKhoa) {
		super();
		Id_HocSinh = id_HocSinh;
		FirstName = firstName;
		LastName = lastName;
		Id_Lop = id_Lop;
		StudyCapacity_Semester1 = studyCapacity_Semester1;
		Conduct_Semester1 = conduct_Semester1;
		StudyCapacity_Semester2 = studyCapacity_Semester2;
		Conduct_Semester2 = conduct_Semester2;
		StudyCapacity_WholeYear = studyCapacity_WholeYear;
		Conduct_WholeYear = conduct_WholeYear;
		Id_NienKhoa = id_NienKhoa;
	}

	public String getId_HocSinh() {
		return Id_HocSinh;
	}

	public void setId_HocSinh(String id_HocSinh) {
		Id_HocSinh = id_HocSinh;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getId_Lop() {
		return Id_Lop;
	}

	public void setId_Lop(String id_Lop) {
		Id_Lop = id_Lop;
	}

	public String getStudyCapacity_Semester1() {
		return StudyCapacity_Semester1;
	}

	public void setStudyCapacity_Semester1(String studyCapacity_Semester1) {
		StudyCapacity_Semester1 = studyCapacity_Semester1;
	}

	public String getConduct_Semester1() {
		return Conduct_Semester1;
	}

	public void setConduct_Semester1(String conduct_Semester1) {
		Conduct_Semester1 = conduct_Semester1;
	}

	public String getStudyCapacity_Semester2() {
		return StudyCapacity_Semester2;
	}

	public void setStudyCapacity_Semester2(String studyCapacity_Semester2) {
		StudyCapacity_Semester2 = studyCapacity_Semester2;
	}

	public String getConduct_Semester2() {
		return Conduct_Semester2;
	}

	public void setConduct_Semester2(String conduct_Semester2) {
		Conduct_Semester2 = conduct_Semester2;
	}

	public String getStudyCapacity_WholeYear() {
		return StudyCapacity_WholeYear;
	}

	public void setStudyCapacity_WholeYear(String studyCapacity_WholeYear) {
		StudyCapacity_WholeYear = studyCapacity_WholeYear;
	}

	public String getConduct_WholeYear() {
		return Conduct_WholeYear;
	}

	public void setConduct_WholeYear(String conduct_WholeYear) {
		Conduct_WholeYear = conduct_WholeYear;
	}

	public String getId_NienKhoa() {
		return Id_NienKhoa;
	}

	public void setId_NienKhoa(String id_NienKhoa) {
		Id_NienKhoa = id_NienKhoa;
	}
}
