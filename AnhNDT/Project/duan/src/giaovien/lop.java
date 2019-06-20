package giaovien;

import java.util.ArrayList;

public class lop {
private String id,tenHs,tenGV, khoa ;
public  lop(){
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getTenHs() {
	return tenHs;
}

public void setTenHs(String tenHs) {
	this.tenHs = tenHs;
}

public String getTenGV() {
	return tenGV;
}

public void setTenGV(String tenGV) {
	this.tenGV = tenGV;
}

public String getKhoa() {
	return khoa;
}

public void setKhoa(String khoa) {
	this.khoa = khoa;
}

public lop(String id, String tenHs, String tenGV, String khoa) {
	super();
	this.id = id;
	this.tenHs = tenHs;
	this.tenGV = tenGV;
	this.khoa = khoa;
}


}

