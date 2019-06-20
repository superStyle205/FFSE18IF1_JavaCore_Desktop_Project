package teacher;

public class GiaoVien {
	public String Id_GiaoVien;
	public String FirstName;
	public String LastName;
	public int Age;
	public String Address;
	public String Sex;
	public String Birth;
	public String NumberPhone;
	public String Email;
	public String Position;
	
	public GiaoVien() {
		super();
	}

	public GiaoVien(String id_GiaoVien, String firstName, String lastName, int age, String address, String sex, String birth,
			String numberPhone, String email, String position) {
		super();
		Id_GiaoVien = id_GiaoVien;
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Address = address;
		Sex = sex;
		Birth = birth;
		NumberPhone = numberPhone;
		Email = email;
		Position = position;
	}

	public String getId_GiaoVien() {
		return Id_GiaoVien;
	}

	public void setId_GiaoVien(String id_GiaoVien) {
		Id_GiaoVien = id_GiaoVien;
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

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}
	
}
