package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.QuanLiDiem;

public class QuanLiDiemDao {
	public List<QuanLiDiem> getAllDiemQLD(){
		String sql = "SELECT * FROM quanlidiem";
		List<QuanLiDiem> listQuanLiDiem = new ArrayList<QuanLiDiem>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			QuanLiDiem quanLiDiem;
			while (resultSet.next()) { 
				quanLiDiem = new QuanLiDiem();
				quanLiDiem.setSoThuTu(resultSet.getString("sothutu"));
				quanLiDiem.setMaHS(resultSet.getString("mahs"));
				quanLiDiem.setTenHS(resultSet.getString("tenhs"));
				quanLiDiem.setMonHoc(resultSet.getString("monhoc"));
				quanLiDiem.setDiemHocKi1(resultSet.getString("diemhocki1"));
				quanLiDiem.setDiemHocKi2(resultSet.getString("diemhocki2"));
				quanLiDiem.setDiemCuoiNam(resultSet.getString("diemcuoinam"));
				listQuanLiDiem.add(quanLiDiem);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listQuanLiDiem;
	}
	public List<QuanLiDiem> showTableByAZQLD(){
		String sql = "SELECT * FROM quanlidiem ORDER BY sothutu ASC";
		List<QuanLiDiem> listQuanLiDiem = new ArrayList<QuanLiDiem>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			QuanLiDiem quanLiDiem;
			while (resultSet.next()) { 
				quanLiDiem = new QuanLiDiem();
				quanLiDiem.setSoThuTu(resultSet.getString("sothutu"));
				quanLiDiem.setMaHS(resultSet.getString("mahs"));
				quanLiDiem.setTenHS(resultSet.getString("tenhs"));
				quanLiDiem.setMonHoc(resultSet.getString("monhoc"));
				quanLiDiem.setDiemHocKi1(resultSet.getString("diemhocki1"));
				quanLiDiem.setDiemHocKi2(resultSet.getString("diemhocki2"));
				quanLiDiem.setDiemCuoiNam(resultSet.getString("diemcuoinam"));
				listQuanLiDiem.add(quanLiDiem);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listQuanLiDiem;
	}
	public List<QuanLiDiem> showTableByZAQLD(){
		String sql = "SELECT * FROM quanlidiem ORDER BY sothutu DESC";
		List<QuanLiDiem> listQuanLiDiem = new ArrayList<QuanLiDiem>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			QuanLiDiem quanLiDiem;
			while (resultSet.next()) { 
				quanLiDiem = new QuanLiDiem();
				quanLiDiem.setSoThuTu(resultSet.getString("sothutu"));
				quanLiDiem.setMaHS(resultSet.getString("mahs"));
				quanLiDiem.setTenHS(resultSet.getString("tenhs"));
				quanLiDiem.setMonHoc(resultSet.getString("monhoc"));
				quanLiDiem.setDiemHocKi1(resultSet.getString("diemhocki1"));
				quanLiDiem.setDiemHocKi2(resultSet.getString("diemhocki2"));
				quanLiDiem.setDiemCuoiNam(resultSet.getString("diemcuoinam"));
				listQuanLiDiem.add(quanLiDiem);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listQuanLiDiem;
	}
	
	public void addDiemQLD(QuanLiDiem quanLiDiem) {
		String sql = "INSERT INTO quanlidiem VALUES(?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,quanLiDiem.getSoThuTu());
			statement.setString(2,quanLiDiem.getMaHS());
			statement.setString(3,quanLiDiem.getTenHS());
			statement.setString(4, quanLiDiem.getMonHoc());
			statement.setString(5, quanLiDiem.getDiemHocKi1());
			statement.setString(6, quanLiDiem.getDiemHocKi2());
			statement.setString(7, quanLiDiem.getDiemCuoiNam());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddQLD(String mahs, String stt) {
		String sql = "SELECT * FROM quanlidiem WHERE (mahs= ? AND sothutu = ?) OR (mahs= ? OR sothutu = ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag =true;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			statement.setString(2, stt);
			statement.setString(3, mahs);
			statement.setString(4, stt);
			ResultSet resultSet =statement.executeQuery();
			if(resultSet.next()==true) {
				flag = false;
			}else {
				flag = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		return flag;
	}
	public void updateDiemQLD(QuanLiDiem quanLiDiem) {
		String sql = "UPDATE quanlidiem SET sothutu = ? ,tenhs = ?,monhoc = ?,diemhocki1 = ?,diemhocki2 = ?,diemcuoinam = ? WHERE mahs= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, quanLiDiem.getSoThuTu());
			statement.setString(2, quanLiDiem.getTenHS());
			statement.setString(3, quanLiDiem.getMonHoc());
			statement.setString(4, quanLiDiem.getDiemHocKi1());
			statement.setString(5, quanLiDiem.getDiemHocKi2());
			statement.setString(6, quanLiDiem.getDiemCuoiNam());
			statement.setString(7, quanLiDiem.getMaHS());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteDiemQLD(String mahs) {
		String sql = "DELETE FROM quanlidiem WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);																																						
			statement.executeUpdate();
		}
		catch(SQLException e) {
		e.printStackTrace();
	}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public QuanLiDiem getDiemByMaHSQLD(String mahs) {
		QuanLiDiem quanLiDiem = null;
		String sql = "SELECT * FROM quanlidiem WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			quanLiDiem = new QuanLiDiem();
			if(resultSet.next()) {
				quanLiDiem.setSoThuTu(resultSet.getString("sothutu"));
				quanLiDiem.setMaHS(resultSet.getString("mahs"));
				quanLiDiem.setTenHS(resultSet.getString("tenhs"));
				quanLiDiem.setMonHoc(resultSet.getString("monhoc"));
				quanLiDiem.setDiemHocKi1(resultSet.getString("diemhocki1"));
				quanLiDiem.setDiemHocKi2(resultSet.getString("diemhocki2"));
				quanLiDiem.setDiemCuoiNam(resultSet.getString("diemcuoinam"));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return quanLiDiem;
	}
	
}
