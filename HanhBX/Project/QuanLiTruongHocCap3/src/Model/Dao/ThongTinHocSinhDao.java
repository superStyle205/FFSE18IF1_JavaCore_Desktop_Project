package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.HocSinh;

public class ThongTinHocSinhDao {
	public List<HocSinh> getAllHocSinh(){
		String sql = "SELECT * FROM thongtinsinhvien";
		List<HocSinh> listHocSinh = new ArrayList<HocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			HocSinh hocsinh;
			while (resultSet.next()) { 
				hocsinh = new HocSinh();
				hocsinh.setSoThuTu(resultSet.getString("sothutu"));
				hocsinh.setMaHS(resultSet.getString("mahs"));
				hocsinh.setTenHS(resultSet.getString("tenhs"));
				hocsinh.setGioiTinh(resultSet.getString("gioitinh"));
				hocsinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hocsinh.setDiaChi(resultSet.getString("diachi"));
				hocsinh.setTenLop(resultSet.getString("tenlop"));
				hocsinh.setSoDienThoai(resultSet.getString("sodienthoai"));
				listHocSinh.add(hocsinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listHocSinh;
	}
	public List<HocSinh> showTableByAZ(){
		String sql = "SELECT * FROM thongtinsinhvien ORDER BY sothutu ASC";
		List<HocSinh> listHocSinh = new ArrayList<HocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			HocSinh hocsinh;
			while (resultSet.next()) { 
				hocsinh = new HocSinh();
				hocsinh.setSoThuTu(resultSet.getString("sothutu"));
				hocsinh.setMaHS(resultSet.getString("mahs"));
				hocsinh.setTenHS(resultSet.getString("tenhs"));
				hocsinh.setGioiTinh(resultSet.getString("gioitinh"));
				hocsinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hocsinh.setDiaChi(resultSet.getString("diachi"));
				hocsinh.setTenLop(resultSet.getString("tenlop"));
				hocsinh.setSoDienThoai(resultSet.getString("sodienthoai"));
				listHocSinh.add(hocsinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listHocSinh;
	}
	public List<HocSinh> showTableByZA(){
		String sql = "SELECT * FROM thongtinsinhvien ORDER BY sothutu DESC";
		List<HocSinh> listHocSinh = new ArrayList<HocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			HocSinh hocsinh;
			while (resultSet.next()) { 
				hocsinh = new HocSinh();
				hocsinh.setSoThuTu(resultSet.getString("sothutu"));
				hocsinh.setMaHS(resultSet.getString("mahs"));
				hocsinh.setTenHS(resultSet.getString("tenhs"));
				hocsinh.setGioiTinh(resultSet.getString("gioitinh"));
				hocsinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hocsinh.setDiaChi(resultSet.getString("diachi"));
				hocsinh.setTenLop(resultSet.getString("tenlop"));
				hocsinh.setSoDienThoai(resultSet.getString("sodienthoai"));
				listHocSinh.add(hocsinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listHocSinh;
	}
	
	public void addHocSinh(HocSinh hocsinh) {
		String sql = "INSERT INTO thongtinsinhvien VALUES(?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,hocsinh.getSoThuTu());
			statement.setString(2,hocsinh.getMaHS());
			statement.setString(3,hocsinh.getTenHS());
			statement.setString(4, hocsinh.getGioiTinh());
			statement.setString(5, hocsinh.getNgaySinh());
			statement.setString(6, hocsinh.getDiaChi());
			statement.setString(7, hocsinh.getTenLop());
			statement.setString(8, hocsinh.getSoDienThoai());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddTTHS(String mahs, String stt) {
		String sql = "SELECT * FROM thongtinsinhvien WHERE (mahs= ? AND sothutu = ?) OR (mahs= ? OR sothutu = ?)";
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
	public void updateHocSinh(HocSinh hocsinh) {
		String sql = "UPDATE thongtinsinhvien SET sothutu = ? ,tenhs = ?,gioitinh = ?,ngaysinh = ?,diachi = ?,tenlop = ?,sodienthoai = ? WHERE mahs= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hocsinh.getSoThuTu());
			statement.setString(2, hocsinh.getTenHS());
			statement.setString(3, hocsinh.getGioiTinh());
			statement.setString(4, hocsinh.getNgaySinh());
			statement.setString(5, hocsinh.getDiaChi());
			statement.setString(6, hocsinh.getTenLop());
			statement.setString(7, hocsinh.getSoDienThoai());
			statement.setString(8, hocsinh.getMaHS());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	public void deleteHocSinh(String mahs) {
		String sql = "DELETE FROM thongtinsinhvien WHERE mahs = ?";
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
	public HocSinh getHocSinhByMaHS(String mahs) {
		HocSinh hocsinh = null;
		String sql = "SELECT * FROM thongtinsinhvien WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			hocsinh = new HocSinh();
			if(resultSet.next()) {
				hocsinh.setSoThuTu(resultSet.getString("sothutu"));
				hocsinh.setMaHS(resultSet.getString("mahs"));
				hocsinh.setTenHS(resultSet.getString("tenhs"));
				hocsinh.setGioiTinh(resultSet.getString("gioitinh"));
				hocsinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hocsinh.setDiaChi(resultSet.getString("diachi"));
				hocsinh.setTenLop(resultSet.getString("tenlop"));
				hocsinh.setSoDienThoai(resultSet.getString("sodienthoai"));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return hocsinh;
	}
}
