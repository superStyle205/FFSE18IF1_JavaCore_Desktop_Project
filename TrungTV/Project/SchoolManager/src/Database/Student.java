package Database;

public class Student {
	private String id;
	private String lastname;
	private String firstname;
	private String birthday;
	private String sex;
	private String country;
	private String classid;
	public Student() {
		
	}
	public Student(String id, String lastname, String firstname, String birthday, String sex, String country,
			String classid) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.sex = sex;
		this.country = country;
		this.classid = classid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
}
