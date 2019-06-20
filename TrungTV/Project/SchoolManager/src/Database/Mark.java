package Database;

public class Mark {
	private String subjectID;
	private String id;
	private double midtest;
	private double finaltest;
	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mark(String subjectID, String id, double midtest, double finaltest) {
		super();
		this.subjectID = subjectID;
		this.id = id;
		this.midtest = midtest;
		this.finaltest = finaltest;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMidtest() {
		return midtest;
	}
	public void setMidtest(double midtest) {
		this.midtest = midtest;
	}
	public double getFinaltest() {
		return finaltest;
	}
	public void setFinaltest(double finaltest) {
		this.finaltest = finaltest;
	}
	
}
