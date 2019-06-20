package model.bean;

public class HocKi {
	public String mahocki, tenhocki;
	
	
	/**
	 * 
	 */
	public HocKi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMahocki() {
		return mahocki;
	}

	public void setMahocki(String mahocki) {
		this.mahocki = mahocki;
	}

	public String getTenhocki() {
		return tenhocki;
	}

	public void setTenhocki(String tenhocki) {
		this.tenhocki = tenhocki;
	}

	/**
	 * @param mahocki
	 * @param tenhocki
	 */
	public HocKi(String mahocki, String tenhocki) {
		super();
		this.mahocki = mahocki;
		this.tenhocki = tenhocki;
	}


}
