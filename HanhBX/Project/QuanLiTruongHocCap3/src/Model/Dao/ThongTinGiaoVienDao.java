package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.ThongTinGiaoVien;

public class ThongTinGiaoVienDao {
	public List<ThongTinGiaoVien> getAllGiaoVienTTGV(){
		String sql = "SELECT * FROM thongtingiaovien";
		List<ThongTinGiaoVien> listThongTinGiaoVien = new ArrayList<ThongTinGiaoVien>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongTinGiaoVien thongTinGiaoVien;
			while (resultSet.next()) { 
				thongTinGiaoVien = new ThongTinGiaoVien();
				thongTinGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				thongTinGiaoVien.setMaGV(resultSet.getString("magv"));
				thongTinGiaoVien.setTenGV(resultSet.getString("tengv"));
				thongTinGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				thongTinGiaoVien.setNgaySinh(resultSet.getString("ngaysinh"));
				thongTinGiaoVien.setDiaChi(resultSet.getString("diachi"));
				thongTinGiaoVien.setLopChuNhiem(resultSet.getString("lopchunhiem"));
				thongTinGiaoVien.setMonDay(resultSet.getString("monday"));
				thongTinGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				listThongTinGiaoVien.add(thongTinGiaoVien);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongTinGiaoVien;
	}
	public List<ThongTinGiaoVien> showTableByAZ(){
		String sql = "SELECT * FROM thongtingiaovien ORDER BY sothutu ASC";
		List<ThongTinGiaoVien> listThongTinGiaoVien = new ArrayList<ThongTinGiaoVien>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongTinGiaoVien thongTinGiaoVien;
			while (resultSet.next()) { 
				thongTinGiaoVien = new ThongTinGiaoVien();
				thongTinGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				thongTinGiaoVien.setMaGV(resultSet.getString("magv"));
				thongTinGiaoVien.setTenGV(resultSet.getString("tengv"));
				thongTinGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				thongTinGiaoVien.setNgaySinh(resultSet.getString("ngaysinh"));
				thongTinGiaoVien.setDiaChi(resultSet.getString("diachi"));
				thongTinGiaoVien.setLopChuNhiem(resultSet.getString("lopchunhiem"));
				thongTinGiaoVien.setMonDay(resultSet.getString("monday"));
				thongTinGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				listThongTinGiaoVien.add(thongTinGiaoVien);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongTinGiaoVien;
	}
	public List<ThongTinGiaoVien> showTableByZA(){
		String sql = "SELECT * FROM thongtingiaovien ORDER BY sothutu DESC";
		List<ThongTinGiaoVien> listThongTinGiaoVien = new ArrayList<ThongTinGiaoVien>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongTinGiaoVien thongTinGiaoVien;
			while (resultSet.next()) { 
				thongTinGiaoVien = new ThongTinGiaoVien();
				thongTinGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				thongTinGiaoVien.setMaGV(resultSet.getString("magv"));
				thongTinGiaoVien.setTenGV(resultSet.getString("tengv"));
				thongTinGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				thongTinGiaoVien.setNgaySinh(resultSet.getString("ngaysinh"));
				thongTinGiaoVien.setDiaChi(resultSet.getString("diachi"));
				thongTinGiaoVien.setLopChuNhiem(resultSet.getString("lopchunhiem"));
				thongTinGiaoVien.setMonDay(resultSet.getString("monday"));
				thongTinGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
				listThongTinGiaoVien.add(thongTinGiaoVien);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongTinGiaoVien;
	}
	
	public void addThongTinGiaoVien(ThongTinGiaoVien thongTinGiaoVien) {
		String sql = "INSERT INTO thongtingiaovien VALUES(?,?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,thongTinGiaoVien.getSoThuTu());
			statement.setString(2,thongTinGiaoVien.getMaGV());
			statement.setString(3,thongTinGiaoVien.getTenGV());
			statement.setString(4, thongTinGiaoVien.getGioiTinh());
			statement.setString(5, thongTinGiaoVien.getNgaySinh());
			statement.setString(6, thongTinGiaoVien.getDiaChi());
			statement.setString(7, thongTinGiaoVien.getLopChuNhiem());
			statement.setString(8, thongTinGiaoVien.getMonDay());
			statement.setString(9, thongTinGiaoVien.getSoDienThoai());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddTTGV(String magv, String stt) {
		String sql = "SELECT * FROM thongtingiaovien WHERE (magv= ? AND sothutu = ?) OR (magv= ? OR sothutu = ?)";
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
	public void updateThongTinGiaoVien(ThongTinGiaoVien thongTinGiaoVien) {
		String sql = "UPDATE thongtingiaovien SET sothutu = ? ,tengv = ?,gioitinh = ?,ngaysinh = ?,diachi = ?,lopchunhiem = ?,monday = ?,sodienthoai = ? WHERE magv= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,thongTinGiaoVien.getSoThuTu());
			statement.setString(2,thongTinGiaoVien.getTenGV());
			statement.setString(3, thongTinGiaoVien.getGioiTinh());
			statement.setString(4, thongTinGiaoVien.getNgaySinh());
			statement.setString(5, thongTinGiaoVien.getDiaChi());
			statement.setString(6, thongTinGiaoVien.getLopChuNhiem());
			statement.setString(7, thongTinGiaoVien.getMonDay());
			statement.setString(8, thongTinGiaoVien.getSoDienThoai());
			statement.setString(9,thongTinGiaoVien.getMaGV());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	public void deleteThongTinGiaoVien(String magv) {
		String sql = "DELETE FROM thongtingiaovien WHERE magv = ?";
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
	public ThongTinGiaoVien getThongTinGiaoVienByMaGV(String magv) {
		ThongTinGiaoVien thongTinGiaoVien = null;
		String sql = "SELECT * FROM thongtingiaovien WHERE magv = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, magv);
			ResultSet resultSet = statement.executeQuery();
			thongTinGiaoVien = new ThongTinGiaoVien();
			if(resultSet.next()) {
				thongTinGiaoVien = new ThongTinGiaoVien();
				thongTinGiaoVien.setSoThuTu(resultSet.getString("sothutu"));
				thongTinGiaoVien.setMaGV(resultSet.getString("magv"));
				thongTinGiaoVien.setTenGV(resultSet.getString("tengv"));
				thongTinGiaoVien.setGioiTinh(resultSet.getString("gioitinh"));
				thongTinGiaoVien.setNgaySinh(resultSet.getString("ngaysinh"));
				thongTinGiaoVien.setDiaChi(resultSet.getString("diachi"));
				thongTinGiaoVien.setLopChuNhiem(resultSet.getString("lopchunhiem"));
				thongTinGiaoVien.setMonDay(resultSet.getString("monday"));
				thongTinGiaoVien.setSoDienThoai(resultSet.getString("sodienthoai"));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return thongTinGiaoVien;
	}
	public boolean checkSoDienThoaiDangKiQLD(String sodienthoai) {
		String sql = "SELECT * FROM thongtingiaovien WHERE sodienthoai = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag = false;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sodienthoai);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()==true) {
				flag = true;
			}else {
				flag = false;
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
}
