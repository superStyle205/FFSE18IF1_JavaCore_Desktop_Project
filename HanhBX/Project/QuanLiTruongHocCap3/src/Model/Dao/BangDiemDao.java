package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;

import Model.bean.BangDiem;
import Model.bean.QuanLiDiem;

public class BangDiemDao {
	public List<BangDiem> getAllDiemBD(){
		String sql = "SELECT * FROM bangdiem";
		List<BangDiem> listBangDiem = new ArrayList<BangDiem>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			BangDiem bangDiem;
			while (resultSet.next()) { 
				bangDiem = new BangDiem();
				bangDiem.setSoThuTu(resultSet.getString("sothutu"));
				bangDiem.setMaHS(resultSet.getString("mahs"));
				bangDiem.setTenHS(resultSet.getString("tenhs"));
				bangDiem.setLop(resultSet.getString("lop"));
				bangDiem.setDiemMonToan(resultSet.getString("toan"));
				bangDiem.setDiemMonVatLi(resultSet.getString("vatli"));
				bangDiem.setDiemMonHoaHoc(resultSet.getString("hoahoc"));
				bangDiem.setDiemMonSinhHoc(resultSet.getString("sinhhoc"));
				bangDiem.setDiemMonLichSu(resultSet.getString("lichsu"));
				bangDiem.setDiemMonDiaLi(resultSet.getString("diali"));
				bangDiem.setDiemMonGDCD(resultSet.getString("gdcd"));
				bangDiem.setDiemMonCongNghe(resultSet.getString("congnghe"));
				bangDiem.setDiemMonTin(resultSet.getString("tinhoc"));
				bangDiem.setDiemMonNguVan(resultSet.getString("nguvan"));
				bangDiem.setDiemMonTiengAnh(resultSet.getString("tienganh"));
				bangDiem.setDiemMonGDQP(resultSet.getString("gdqp"));
				bangDiem.setDiemMonTheDuc(resultSet.getString("theduc"));
				
				
				listBangDiem.add(bangDiem);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listBangDiem;
	}
	
	public List<BangDiem> showTableByAZBD(){
		String sql = "SELECT * FROM bangdiem ORDER BY sothutu ASC";
		List<BangDiem> listBangDiem = new ArrayList<BangDiem>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			BangDiem bangDiem;
			while (resultSet.next()) { 
				bangDiem = new BangDiem();
				bangDiem.setSoThuTu(resultSet.getString("sothutu"));
				bangDiem.setMaHS(resultSet.getString("mahs"));
				bangDiem.setTenHS(resultSet.getString("tenhs"));
				bangDiem.setLop(resultSet.getString("lop"));
				bangDiem.setDiemMonToan(resultSet.getString("toan"));
				bangDiem.setDiemMonVatLi(resultSet.getString("vatli"));
				bangDiem.setDiemMonHoaHoc(resultSet.getString("hoahoc"));
				bangDiem.setDiemMonSinhHoc(resultSet.getString("sinhhoc"));
				bangDiem.setDiemMonLichSu(resultSet.getString("lichsu"));
				bangDiem.setDiemMonDiaLi(resultSet.getString("diali"));
				bangDiem.setDiemMonGDCD(resultSet.getString("gdcd"));
				bangDiem.setDiemMonCongNghe(resultSet.getString("congnghe"));
				bangDiem.setDiemMonTin(resultSet.getString("tinhoc"));
				bangDiem.setDiemMonNguVan(resultSet.getString("nguvan"));
				bangDiem.setDiemMonTiengAnh(resultSet.getString("tienganh"));
				bangDiem.setDiemMonGDQP(resultSet.getString("gdqp"));
				bangDiem.setDiemMonTheDuc(resultSet.getString("theduc"));
				listBangDiem.add(bangDiem);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listBangDiem;
	}
	public List<BangDiem> showTableByZABD(){
		String sql = "SELECT * FROM bangdiem ORDER BY sothutu DESC";
		List<BangDiem> listBangDiem = new ArrayList<BangDiem>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			BangDiem bangDiem;
			while (resultSet.next()) { 
				bangDiem = new BangDiem();
				bangDiem.setSoThuTu(resultSet.getString("sothutu"));
				bangDiem.setMaHS(resultSet.getString("mahs"));
				bangDiem.setTenHS(resultSet.getString("tenhs"));
				bangDiem.setLop(resultSet.getString("lop"));
				bangDiem.setDiemMonToan(resultSet.getString("toan"));
				bangDiem.setDiemMonVatLi(resultSet.getString("vatli"));
				bangDiem.setDiemMonHoaHoc(resultSet.getString("hoahoc"));
				bangDiem.setDiemMonSinhHoc(resultSet.getString("sinhhoc"));
				bangDiem.setDiemMonLichSu(resultSet.getString("lichsu"));
				bangDiem.setDiemMonDiaLi(resultSet.getString("diali"));
				bangDiem.setDiemMonGDCD(resultSet.getString("gdcd"));
				bangDiem.setDiemMonCongNghe(resultSet.getString("congnghe"));
				bangDiem.setDiemMonTin(resultSet.getString("tinhoc"));
				bangDiem.setDiemMonNguVan(resultSet.getString("nguvan"));
				bangDiem.setDiemMonTiengAnh(resultSet.getString("tienganh"));
				bangDiem.setDiemMonGDQP(resultSet.getString("gdqp"));
				bangDiem.setDiemMonTheDuc(resultSet.getString("theduc"));
				listBangDiem.add(bangDiem);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listBangDiem;
	}
	
	public void addDiemBD(BangDiem bangDiem) {
		String sql = "INSERT INTO bangdiem VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,bangDiem.getSoThuTu());
			statement.setString(2,bangDiem.getMaHS());
			statement.setString(3,bangDiem.getTenHS());
			statement.setString(4, bangDiem.getLop());
			statement.setString(5, bangDiem.getDiemMonToan());
			statement.setString(6, bangDiem.getDiemMonVatLi());
			statement.setString(7, bangDiem.getDiemMonHoaHoc());
			statement.setString(8, bangDiem.getDiemMonSinhHoc());
			statement.setString(9, bangDiem.getDiemMonLichSu());
			statement.setString(10, bangDiem.getDiemMonDiaLi());
			statement.setString(11, bangDiem.getDiemMonGDCD());
			statement.setString(12, bangDiem.getDiemMonCongNghe());
			statement.setString(13, bangDiem.getDiemMonTin());
			statement.setString(14, bangDiem.getDiemMonNguVan());
			statement.setString(15, bangDiem.getDiemMonTiengAnh());
			statement.setString(16, bangDiem.getDiemMonGDQP());
			statement.setString(17, bangDiem.getDiemMonTheDuc());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddBD(String mahs, String stt) {
		String sql = "SELECT * FROM bangdiem WHERE (mahs= ? AND sothutu = ?) OR (mahs= ? OR sothutu = ?)";
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
	public void updateDiemBD(BangDiem bangDiem) {
		String sql = "UPDATE bangdiem SET sothutu = ? ,tenhs = ?,lop = ?,toan = ?,vatli = ?,hoahoc = ?,sinhhoc = ?,lichsu = ?,diali = ?,gdcd = ?,congnghe = ?,tinhoc = ?,nguvan = ?,tienganh = ?,gdqp =?,theduc = ? WHERE mahs= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,bangDiem.getSoThuTu());
			
			statement.setString(2,bangDiem.getTenHS());
			statement.setString(3, bangDiem.getLop());
			statement.setString(4, bangDiem.getDiemMonToan());
			statement.setString(5, bangDiem.getDiemMonVatLi());
			statement.setString(6, bangDiem.getDiemMonHoaHoc());
			statement.setString(7, bangDiem.getDiemMonSinhHoc());
			statement.setString(8, bangDiem.getDiemMonLichSu());
			statement.setString(9, bangDiem.getDiemMonDiaLi());
			statement.setString(10, bangDiem.getDiemMonGDCD());
			statement.setString(11, bangDiem.getDiemMonCongNghe());
			statement.setString(12, bangDiem.getDiemMonTin());
			statement.setString(13, bangDiem.getDiemMonNguVan());
			statement.setString(14, bangDiem.getDiemMonTiengAnh());
			statement.setString(15, bangDiem.getDiemMonGDQP());
			statement.setString(16, bangDiem.getDiemMonTheDuc());
			statement.setString(17,bangDiem.getMaHS());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	
	public void deleteDiemBD(String mahs) {
		String sql = "DELETE FROM bangdiem WHERE mahs = ?";
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
	public BangDiem getDiemByMaHSBD(String mahs) {
		BangDiem bangDiem = null;
		String sql = "SELECT * FROM bangdiem WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			bangDiem = new BangDiem();
			if(resultSet.next()) {
				bangDiem.setSoThuTu(resultSet.getString("sothutu"));
				bangDiem.setMaHS(resultSet.getString("mahs"));
				bangDiem.setTenHS(resultSet.getString("tenhs"));
				bangDiem.setLop(resultSet.getString("lop"));
				bangDiem.setDiemMonToan(resultSet.getString("toan"));
				bangDiem.setDiemMonVatLi(resultSet.getString("vatli"));
				bangDiem.setDiemMonHoaHoc(resultSet.getString("hoahoc"));
				bangDiem.setDiemMonSinhHoc(resultSet.getString("sinhhoc"));
				bangDiem.setDiemMonLichSu(resultSet.getString("lichsu"));
				bangDiem.setDiemMonDiaLi(resultSet.getString("diali"));
				bangDiem.setDiemMonGDCD(resultSet.getString("gdcd"));
				bangDiem.setDiemMonCongNghe(resultSet.getString("congnghe"));
				bangDiem.setDiemMonTin(resultSet.getString("tinhoc"));
				bangDiem.setDiemMonNguVan(resultSet.getString("nguvan"));
				bangDiem.setDiemMonTiengAnh(resultSet.getString("tienganh"));
				bangDiem.setDiemMonGDQP(resultSet.getString("gdqp"));
				bangDiem.setDiemMonTheDuc(resultSet.getString("theduc"));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return bangDiem;
	}
	
}
