package ft.coffee.model.bean;

public class Staff {

	private int staffId;
	private String userName;
	private String password;
	private String staffCode;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private int taxCode;
	private String email;
	private int deptId;
	private int role;

	public Staff() {
	}

	public Staff(int staffId, String userName, String password, String staffCode, String firstName, String lastName,
			String address, String phone, int taxCode, String email, int deptId, int role) {
		this.staffId = staffId;
		this.userName = userName;
		this.password = password;
		this.staffCode = staffCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.taxCode = taxCode;
		this.email = email;
		this.deptId = deptId;
		this.role = role;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(int taxCode) {
		this.taxCode = taxCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
