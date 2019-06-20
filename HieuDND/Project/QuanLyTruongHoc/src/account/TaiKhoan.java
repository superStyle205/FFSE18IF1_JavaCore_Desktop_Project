package account;

public class TaiKhoan {
	public String UserName;
	public String Password;
	public String Id_Rule;
	
	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String userName, String password, String id_Rule) {
		super();
		UserName = userName;
		Password = password;
		Id_Rule = id_Rule;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getId_Rule() {
		return Id_Rule;
	}

	public void setId_Rule(String id_Rule) {
		Id_Rule = id_Rule;
	}
}
