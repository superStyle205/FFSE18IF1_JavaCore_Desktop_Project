package dao;

public class Login {
	private String user;
	private String id;
	private String hello;

	
	
	public String getUser() {
		return user;
	}
	public String getId() {
		return id;
	}
	public String getHello() {
		return hello;
	}
	public Login(String user, String id, String hello) {
		
		this.user = user;
		this.id = id;
		this.hello = hello;
	}

}
