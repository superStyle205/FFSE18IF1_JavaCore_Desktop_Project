package Model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.ThongTinHocSinh;


public class ThongTinHocSinhDao {
	public List<ThongTinHocSinh> getAllThongTinHocSinh(){
		String sql = "SELECT * FROM thongtinhocsinh";
		List<ThongTinHocSinh> listThongTinHocSinh = new ArrayList<ThongTinHocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongTinHocSinh thongTinHocSinh;
			while (resultSet.next()) { 
				thongTinHocSinh = new ThongTinHocSinh();
				thongTinHocSinh.setSoThuTu(resultSet.getString("sothutu"));
				thongTinHocSinh.setMaHS(resultSet.getString("mahs"));
				thongTinHocSinh.setTenHS(resultSet.getString("tenhs"));
				thongTinHocSinh.setGioiTinh(resultSet.getString("gioitinh"));
				thongTinHocSinh.setNgaysinh(resultSet.getString("ngaysinh"));
				thongTinHocSinh.setDiachi(resultSet.getString("diachi"));
				thongTinHocSinh.setLop(resultSet.getString("lop"));
				thongTinHocSinh.setSodienthoai(resultSet.getString("sodienthoai"));
				listThongTinHocSinh.add(thongTinHocSinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongTinHocSinh;
	}
	
	
	public void addThongTinHocSinh(ThongTinHocSinh thongTinHocSinh) {
		String sql = "INSERT INTO thongtinhocsinh VALUES(?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,thongTinHocSinh.getSoThuTu());
			statement.setString(2,thongTinHocSinh.getMaHS());
			statement.setString(3,thongTinHocSinh.getTenHS());
			statement.setString(4,thongTinHocSinh.getGioiTinh());
			statement.setString(5,thongTinHocSinh.getNgaysinh());
			statement.setString(6,thongTinHocSinh.getDiachi());
			statement.setString(7,thongTinHocSinh.getLop());
			statement.setString(8,thongTinHocSinh.getSodienthoai());
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
		String sql = "SELECT * FROM thongtinhocsinh WHERE (mahs= ? AND sothutu = ?) OR (mahs= ? OR sothutu = ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag =true;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			statement.setString(2, stt);
			statement.setString(3, mahs);
			statement.setString(4, stt);
			ResultSet resultSet = statement.executeQuery();
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
	public void updateThongTinHocSinh(ThongTinHocSinh thongTinHocSinh) {
		String sql = "UPDATE thongtinhocsinh SET sothutu = ? ,tenhs = ?,gioitinh = ?,ngaysinh = ?,diachi = ?,lop = ?,sodienthoai = ? WHERE mahs= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, thongTinHocSinh.getSoThuTu());
			statement.setString(2, thongTinHocSinh.getTenHS());
			statement.setString(3, thongTinHocSinh.getGioiTinh());
			statement.setString(4, thongTinHocSinh.getNgaysinh());
			statement.setString(5, thongTinHocSinh.getDiachi());
			statement.setString(6, thongTinHocSinh.getLop());
			statement.setString(7, thongTinHocSinh.getSodienthoai());
			statement.setString(8, thongTinHocSinh.getMaHS());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	public void deleteThongTinHocSinh(String mahs) {
		String sql = "DELETE FROM thongtinhocsinh WHERE mahs = ?";
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
	public ThongTinHocSinh getHocSinhByMaHS(String mahs) {
		ThongTinHocSinh thongTinHocSinh = null;
		String sql = "SELECT * FROM thongtinhocsinh WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			thongTinHocSinh = new ThongTinHocSinh();
			if(resultSet.next()) {
				thongTinHocSinh.setSoThuTu(resultSet.getString("sothutu"));
				thongTinHocSinh.setMaHS(resultSet.getString("mahs"));
				thongTinHocSinh.setTenHS(resultSet.getString("tenhs"));
				thongTinHocSinh.setGioiTinh(resultSet.getString("gioitinh"));
				thongTinHocSinh.setNgaysinh(resultSet.getString("ngaysinh"));
				thongTinHocSinh.setDiachi(resultSet.getString("diachi"));
				thongTinHocSinh.setLop(resultSet.getString("tenlop"));
				thongTinHocSinh.setSodienthoai(resultSet.getString("sodienthoai"));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return thongTinHocSinh;
	}


	public List<ThongTinHocSinh> getAllSinhVien() {
		// TODO Auto-generated method stub
		return null;
	}
}
