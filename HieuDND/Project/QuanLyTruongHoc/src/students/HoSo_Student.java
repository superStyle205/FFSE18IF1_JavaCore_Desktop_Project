package students;

public class HoSo_Student{
	public String Id_HocSinh;
	public String FirstName;
	public String LastName;
	public int Age;
	public String Address;
	public String Sex;
	public String Birth;
	public String PrimarySchool;
	public String JuniorHighSchool;
	public String HighSchool;
	public String StudyCapacity;
	public String Conduct;
	
	public HoSo_Student() {
		super();
	}

	public HoSo_Student(String id_HocSinh, String firstName, String lastName, int age, String address, String sex, String birth,
			String primarySchool, String juniorHighSchool, String highSchool, String studyCapacity, String conduct) {
		super();
		Id_HocSinh = id_HocSinh;
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Address = address;
		Sex = sex;
		Birth = birth;
		PrimarySchool = primarySchool;
		JuniorHighSchool = juniorHighSchool;
		HighSchool = highSchool;
		StudyCapacity = studyCapacity;
		Conduct = conduct;
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

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getBirth() {
		return Birth;
	}

	public void setBirth(String birth) {
		Birth = birth;
	}

	public String getPrimarySchool() {
		return PrimarySchool;
	}

	public void setPrimarySchool(String primarySchool) {
		PrimarySchool = primarySchool;
	}

	public String getJuniorHighSchool() {
		return JuniorHighSchool;
	}

	public void setJuniorHighSchool(String juniorHighSchool) {
		JuniorHighSchool = juniorHighSchool;
	}

	public String getHighSchool() {
		return HighSchool;
	}

	public void setHighSchool(String highSchool) {
		HighSchool = highSchool;
	}

	public String getStudyCapacity() {
		return StudyCapacity;
	}

	public void setStudyCapacity(String studyCapacity) {
		StudyCapacity = studyCapacity;
	}

	public String getConduct() {
		return Conduct;
	}

	public void setConduct(String conduct) {
		Conduct = conduct;
	}
}
