package model.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	public String id, name, classs, address;
	public String year_of_birth, school_year;
	public String gioitinh;
	ArrayList<Lop> lops;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, String classs, String address, String year_of_birth, String school_year,
			String gioitinh, ArrayList<Lop> lops) {
		super();
		this.id = id;
		this.name = name;
		this.classs = classs;
		this.address = address;
		this.year_of_birth = year_of_birth;
		this.school_year = school_year;
		this.gioitinh = gioitinh;
		this.lops = lops;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getYear_of_birth() {
		return year_of_birth;
	}

	public void setYear_of_birth(String year_of_birth) {
		this.year_of_birth = year_of_birth;
	}

	public String getSchool_year() {
		return school_year;
	}

	public void setSchool_year(String school_year) {
		this.school_year = school_year;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public ArrayList<Lop> getLops() {
		return lops;
	}

	public void setLops(ArrayList<Lop> lops) {
		this.lops = lops;
	}

	

}
