package Database;

public class Subject {
	private String subjectID;
	private String subject;
	private int credits;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(String subjectID, String subject, int credits) {
		super();
		this.subjectID = subjectID;
		this.subject = subject;
		this.credits = credits;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
