package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.QuanLiGiaoVien;
import Model.bean.ThongTinGiaoVien;

public class QuanLiGiaoVienDao {
	public List<QuanLiGiaoVien> getAllGiaoVienQLGV(){
		String sql = "SELECT * FROM quanligiaovien";
		List<QuanLiGiaoVien> listQuanLiGiaoVien = new ArrayList<QuanLiGiaoVien>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			QuanLiGiaoVien quanLiGiaoVien;
			while (resultSet.next()) { 
				quanLiGiaoVien = new QuanLiGiaoVien();
				quanLiGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				quanLiGiaoVien.setMaGV(resultSet.getString("magv"));
				quanLiGiaoVien.setTenGV(resultSet.getString("tengv"));
				quanLiGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				quanLiGiaoVien.setTrinhDo(resultSet.getString("trinhdo"));
				quanLiGiaoVien.setDiaChi(resultSet.getString("diachi"));
				quanLiGiaoVien.setChoOHienNay(resultSet.getString("choohiennay"));
				quanLiGiaoVien.setSoTietDayTrongTuan(resultSet.getString("sotietdaytrongtuan"));
				quanLiGiaoVien.setSoNgayNghi(resultSet.getString("songaynghi"));
				quanLiGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				quanLiGiaoVien.setSoCMND(resultSet.getString("socmnd"));
				quanLiGiaoVien.setEmail(resultSet.getString("email"));
				listQuanLiGiaoVien.add(quanLiGiaoVien);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listQuanLiGiaoVien;
	}
	public List<QuanLiGiaoVien> showTableByAZ(){
		String sql = "SELECT * FROM quanligiaovien ORDER BY sothutu ASC";
		List<QuanLiGiaoVien> listQuanLiGiaoVien = new ArrayList<QuanLiGiaoVien>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			QuanLiGiaoVien quanLiGiaoVien;
			while (resultSet.next()) { 
				quanLiGiaoVien = new QuanLiGiaoVien();
				quanLiGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				quanLiGiaoVien.setMaGV(resultSet.getString("magv"));
				quanLiGiaoVien.setTenGV(resultSet.getString("tengv"));
				quanLiGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				quanLiGiaoVien.setTrinhDo(resultSet.getString("trinhdo"));
				quanLiGiaoVien.setDiaChi(resultSet.getString("diachi"));
				quanLiGiaoVien.setChoOHienNay(resultSet.getString("choohiennay"));
				quanLiGiaoVien.setSoTietDayTrongTuan(resultSet.getString("sotietdaytrongtuan"));
				quanLiGiaoVien.setSoNgayNghi(resultSet.getString("songaynghi"));
				quanLiGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				quanLiGiaoVien.setSoCMND(resultSet.getString("socmnd"));
				quanLiGiaoVien.setEmail(resultSet.getString("email"));
				listQuanLiGiaoVien.add(quanLiGiaoVien);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listQuanLiGiaoVien;
	}
	public List<QuanLiGiaoVien> showTableByZA(){
		String sql = "SELECT * FROM quanligiaovien ORDER BY sothutu DESC";
		List<QuanLiGiaoVien> listQuanLiGiaoVien = new ArrayList<QuanLiGiaoVien>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			QuanLiGiaoVien quanLiGiaoVien;
			while (resultSet.next()) { 
				quanLiGiaoVien = new QuanLiGiaoVien();
				quanLiGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				quanLiGiaoVien.setMaGV(resultSet.getString("magv"));
				quanLiGiaoVien.setTenGV(resultSet.getString("tengv"));
				quanLiGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				quanLiGiaoVien.setTrinhDo(resultSet.getString("trinhdo"));
				quanLiGiaoVien.setDiaChi(resultSet.getString("diachi"));
				quanLiGiaoVien.setChoOHienNay(resultSet.getString("choohiennay"));
				quanLiGiaoVien.setSoTietDayTrongTuan(resultSet.getString("sotietdaytrongtuan"));
				quanLiGiaoVien.setSoNgayNghi(resultSet.getString("songaynghi"));
				quanLiGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				quanLiGiaoVien.setSoCMND(resultSet.getString("socmnd"));
				quanLiGiaoVien.setEmail(resultSet.getString("email"));
				listQuanLiGiaoVien.add(quanLiGiaoVien);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listQuanLiGiaoVien;
	}
	
	public void addQuanLiGiaoVien(QuanLiGiaoVien quanLiGiaoVien) {
		String sql = "INSERT INTO quanligiaovien VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,quanLiGiaoVien.getSoThuTu());
			statement.setString(2,quanLiGiaoVien.getMaGV());
			statement.setString(3,quanLiGiaoVien.getTenGV());
			statement.setString(4, quanLiGiaoVien.getGioiTinh());
			statement.setString(5, quanLiGiaoVien.getTrinhDo());
			statement.setString(6, quanLiGiaoVien.getDiaChi());
			statement.setString(7, quanLiGiaoVien.getChoOHienNay());
			statement.setString(8, quanLiGiaoVien.getSoTietDayTrongTuan());
			statement.setString(9, quanLiGiaoVien.getSoNgayNghi());
			statement.setString(10, quanLiGiaoVien.getSoDienThoai());
			statement.setString(11, quanLiGiaoVien.getSoCMND());
			statement.setString(12, quanLiGiaoVien.getEmail());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddQLGV(String magv, String stt) {
		String sql = "SELECT * FROM quanligiaovien WHERE (magv= ? AND sothutu = ?) OR (magv= ? OR sothutu = ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag =true;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, magv);
			statement.setString(2, stt);
			statement.setString(3, magv);
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
	public void updateQuanLiGiaoVien(QuanLiGiaoVien quanLiGiaoVien) {
		String sql = "UPDATE quanligiaovien SET sothutu = ? ,tengv = ?,gioitinh = ?,trinhdo = ?,diachi = ?,choohiennay = ?,sotietdaytrongtuan = ?,songaynghi = ?,sodienthoai =?,socmnd = ?,email =? WHERE magv= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,quanLiGiaoVien.getSoThuTu());
			statement.setString(2,quanLiGiaoVien.getTenGV());
			statement.setString(3, quanLiGiaoVien.getGioiTinh());
			statement.setString(4, quanLiGiaoVien.getTrinhDo());
			statement.setString(5, quanLiGiaoVien.getDiaChi());
			statement.setString(6, quanLiGiaoVien.getChoOHienNay());
			statement.setString(7, quanLiGiaoVien.getSoTietDayTrongTuan());
			statement.setString(8, quanLiGiaoVien.getSoNgayNghi());
			statement.setString(9, quanLiGiaoVien.getSoDienThoai());
			statement.setString(10, quanLiGiaoVien.getSoCMND());
			statement.setString(11, quanLiGiaoVien.getEmail());
			statement.setString(12,quanLiGiaoVien.getMaGV());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	public void deleteQuanLiGiaoVien(String magv) {
		String sql = "DELETE FROM quanligiaovien WHERE magv = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, magv);																																						
			statement.executeUpdate();
		}
		catch(SQLException e) {
		e.printStackTrace();
	}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public QuanLiGiaoVien getQuanLiGiaoVienByMaGV(String magv) {
		QuanLiGiaoVien quanLiGiaoVien = null;
		String sql = "SELECT * FROM quanligiaovien WHERE magv = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, magv);
			ResultSet resultSet = statement.executeQuery();
			quanLiGiaoVien = new QuanLiGiaoVien();
			if(resultSet.next()) {
				quanLiGiaoVien = new QuanLiGiaoVien();
				quanLiGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				quanLiGiaoVien.setMaGV(resultSet.getString("magv"));
				quanLiGiaoVien.setTenGV(resultSet.getString("tengv"));
				quanLiGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				quanLiGiaoVien.setTrinhDo(resultSet.getString("trinhdo"));
				quanLiGiaoVien.setDiaChi(resultSet.getString("diachi"));
				quanLiGiaoVien.setChoOHienNay(resultSet.getString("choohiennay"));
				quanLiGiaoVien.setSoTietDayTrongTuan(resultSet.getString("sotietdaytrongtuan"));
				quanLiGiaoVien.setSoNgayNghi(resultSet.getString("songaynghi"));
				quanLiGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				quanLiGiaoVien.setSoCMND(resultSet.getString("socmnd"));
				quanLiGiaoVien.setEmail(resultSet.getString("email"));
				
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return quanLiGiaoVien;
	}
}
