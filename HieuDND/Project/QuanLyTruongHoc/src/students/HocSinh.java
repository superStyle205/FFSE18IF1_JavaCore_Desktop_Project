package students;

public class HocSinh {
	public String Id_HocSinh;
	public String FirstName;
	public String LastName;
	public int Age;
	public String Address;
	public String Sex;
	public String Birth;
	public String NumberPhone;
	public String Email;
	public int Absence;
	public String Id_Lop;

	public HocSinh() {
		super();
	}

	public HocSinh(String id_HocSinh, String firstName, String lastName, int age, String address, String sex, String birth,
			String numberPhone, String email, int absence, String id_Lop) {
		super();
		Id_HocSinh = id_HocSinh;
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Address = address;
		Sex = sex;
		Birth = birth;
		NumberPhone = numberPhone;
		Email = email;
		Absence = absence;
		Id_Lop = id_Lop;
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

	public String getNumberPhone() {
		return NumberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		NumberPhone = numberPhone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getAbsence() {
		return Absence;
	}

	public void setAbsence(int absence) {
		Absence = absence;
	}

	public String getId_Lop() {
		return Id_Lop;
	}

	public void setId_Lop(String id_Lop) {
		Id_Lop = id_Lop;
	}
}
