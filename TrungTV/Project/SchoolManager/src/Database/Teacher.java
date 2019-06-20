package Database;

public class Teacher {
	private String teacherID;
	private String name;
	private String level;
	private String phonenumber;
	private String subjectID;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String teacherID, String name, String subjectID, String level, String phonenumber) {
		super();
		this.teacherID = teacherID;
		this.name = name;
		this.subjectID = subjectID;
		this.level = level;
		this.phonenumber = phonenumber;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
