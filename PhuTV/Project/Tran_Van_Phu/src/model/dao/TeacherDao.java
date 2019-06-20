package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import common.database.ConnectData;
import model.bean.Teacher;

public class TeacherDao {
	public List<Teacher> getData(){
		String sql = "SELECT * FROM giaovien";
		List<Teacher> listData = new ArrayList<Teacher>();
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			Teacher teacher;
			while(result.next()){
				teacher = new Teacher();
				teacher.setMaGiaoVien(result.getInt("MaGiaoVien"));
				teacher.setHoTenGiaoVien(result.getString("HoTenGiaoVien"));
				teacher.setChucVu(result.getString("ChucVu"));
				teacher.setGioiTinh(result.getString("GioiTinh"));
				teacher.setDiaChi(result.getString("DiaChi"));
				teacher.setSoDienThoai(result.getString("SoDienThoai"));
				
				listData.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.disconnect(conn);
		}
		return listData;
	}
	
	public void addTeacher(Teacher teacher){
		String sql = "INSERT INTO giaovien VALUES(NULL, ?, ?, ?, ?, ?)";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, teacher.getHoTenGiaoVien());
			statement.setString(2, teacher.getChucVu());
			statement.setString(3, teacher.getGioiTinh());
			statement.setString(4, teacher.getDiaChi());
			statement.setString(5, teacher.getSoDienThoai());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public void updateTeacher(Teacher teacher){
		String sql = "UPDATE giaovien SET HoTenGiaoVien = ?, ChucVu = ?, GioiTinh = ?, DiaChi = ?, SoDienThoai = ? WHERE MaGiaoVien = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, teacher.getHoTenGiaoVien());
			statement.setString(2, teacher.getChucVu());
			statement.setString(3, teacher.getGioiTinh());
			statement.setString(4, teacher.getDiaChi());
			statement.setString(5, teacher.getSoDienThoai());
			statement.setInt(6, teacher.getMaGiaoVien());
			
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public void deleteTeacher(String maGiaoVien){
		String sql = "DELETE FROM giaovien WHERE MaGiaoVien = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, maGiaoVien);
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public Teacher searchTeacher(String maGiaoVien){
		Teacher teacher = null;
		String sql = "SELECT * FROM giaovien WHERE MaGiaoVien = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maGiaoVien);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				teacher = new Teacher();

				teacher.setMaGiaoVien(result.getInt("MaGiaoVien"));
				teacher.setHoTenGiaoVien(result.getString("HoTenGiaoVien"));
				teacher.setChucVu(result.getString("ChucVu"));
				teacher.setGioiTinh(result.getString("GioiTinh"));
				teacher.setDiaChi(result.getString("DiaChi"));
				teacher.setSoDienThoai(result.getString("SoDienThoai"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
		
		return teacher;
		
	}
	
}
