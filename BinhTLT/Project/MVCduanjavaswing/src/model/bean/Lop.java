package model.bean;

import java.util.ArrayList;

public class Lop {
	public String malop, gvchu_nghiem, makhoi;
	public String tenlop, makhoa, tennienkhoa;

	/**
	 * 
	 */
	public Lop() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param malop
	 * @param gvchu_nghiem
	 * @param makhoi
	 * @param tenlop
	 * @param makhoa
	 * @param tennienkhoa
	 */
	public Lop(String malop, String gvchu_nghiem, String makhoi, String tenlop, String makhoa, String tennienkhoa) {
		super();
		this.malop = malop;
		this.gvchu_nghiem = gvchu_nghiem;
		this.makhoi = makhoi;
		this.tenlop = tenlop;
		this.makhoa = makhoa;
		this.tennienkhoa = tennienkhoa;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getGvchu_nghiem() {
		return gvchu_nghiem;
	}

	public void setGvchu_nghiem(String gvchu_nghiem) {
		this.gvchu_nghiem = gvchu_nghiem;
	}

	public String getMakhoi() {
		return makhoi;
	}

	public void setMakhoi(String makhoi) {
		this.makhoi = makhoi;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	public String getMakhoa() {
		return makhoa;
	}

	public void setMakhoa(String makhoa) {
		this.makhoa = makhoa;
	}

	public String getTennienkhoa() {
		return tennienkhoa;
	}

	public void setTennienkhoa(String tennienkhoa) {
		this.tennienkhoa = tennienkhoa;
	}

	/**
	 * @param malop
	 * @param gvchu_nghiem
	 * @param makhoi
	 * @param tenlop
	 * @param makhoa
	 * @param tennienkhoa
	 * @param hs
	 */

}
