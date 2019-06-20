package Database;

public class Class {
	private String classID;
	private String className;
	private String teacherID;
	private String subject;
	private int schoolYear;
	
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Class(String classID, String className, String teacherID, String subject, int schoolYear) {
		super();
		this.classID = classID;
		this.className = className;
		this.teacherID = teacherID;
		this.subject = subject;
		this.schoolYear = schoolYear;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

}
