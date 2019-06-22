package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import common.database.ConnectData;
import model.bean.Class;

public class ClassDao {

	public List<Class> getData(){
	String sql = "SELECT * FROM lop";
	List<Class> listData = new ArrayList<Class>();
	
	ConnectData connect = new ConnectData();
	Connection conn = connect.connect();
	try {
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		
		Class classstudent;
		while(result.next()){
			classstudent = new Class();
			
			classstudent.setMaLop(result.getInt("MaLop"));
			classstudent.setMaGiaoVien(result.getString("MaGiaoVien"));
			classstudent.setTenLop(result.getString("TenLop"));
			classstudent.setTenLopTruong(result.getString("TenLopTruong"));
			
			listData.add(classstudent);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		connect.disconnect(conn);
	}

	return listData;

}
	
	public void addClass(Class classstudent){
		String sql = "INSERT INTO lop VALUES(NULL, ?, ?, ?)";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, classstudent.getMaGiaoVien());
			statement.setString(2, classstudent.getTenLop());
			statement.setString(3, classstudent.getTenLopTruong());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.disconnect(conn);
		}
	}
	
	public void updateClass(Class classstudent){
		String sql = "UPDATE lop SET MaGiaoVien = ?, TenLop = ?, TenLopTruong = ? WHERE MaLop = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, classstudent.getMaGiaoVien());
			statement.setString(2, classstudent.getTenLop());
			statement.setString(3, classstudent.getTenLopTruong());
			statement.setInt(4, classstudent.getMaLop());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public void deleteClass(String maLop){
		String sql = "DELETE FROM lop WHERE MaLop = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, maLop);
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public Class searchClass(String maLop){
		Class classstudent = null;
		String sql = "SELECT * FROM lop WHERE MaLop = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maLop);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				classstudent = new Class();

				classstudent.setMaLop(result.getInt("MaLop"));
				classstudent.setMaGiaoVien(result.getString("MaGiaoVien"));
				classstudent.setTenLop(result.getString("TenLop"));
				classstudent.setTenLopTruong(result.getString("TenLopTruong"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
		
		return classstudent;
		
	}
}
