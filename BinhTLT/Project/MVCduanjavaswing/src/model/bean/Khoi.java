package model.bean;

public class Khoi {
	public String makhoi, tenkhoi;

	public String getMakhoi() {
		return makhoi;
	}

	public void setMakhoi(String makhoi) {
		this.makhoi = makhoi;
	}

	public String getTenkhoi() {
		return tenkhoi;
	}

	public void setTenkhoi(String tenkhoi) {
		this.tenkhoi = tenkhoi;
	}

	/**
	 * @param makhoi
	 * @param tenkhoi
	 */
	public Khoi(String makhoi, String tenkhoi) {
		super();
		this.makhoi = makhoi;
		this.tenkhoi = tenkhoi;
	}

	/**
	 * 
	 */
	public Khoi() {
		super();
		// TODO Auto-generated constructor stub
	}
}
