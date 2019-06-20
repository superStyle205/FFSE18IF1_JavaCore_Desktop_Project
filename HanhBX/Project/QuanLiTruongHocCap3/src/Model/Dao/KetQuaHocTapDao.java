package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.BangDiem;
import Model.bean.KetQuaHocTap;

public class KetQuaHocTapDao {
	public List<KetQuaHocTap> getAllKetQuaKQHT(){
		String sql = "SELECT * FROM ketquahoctap";
		List<KetQuaHocTap> listKetQuaHocTap = new ArrayList<KetQuaHocTap>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			KetQuaHocTap ketQuaHocTap;
			while (resultSet.next()) { 
				ketQuaHocTap = new KetQuaHocTap();
				ketQuaHocTap.setSoThuTu(resultSet.getString("sothutu"));
				ketQuaHocTap.setMaHS(resultSet.getString("mahs"));
				ketQuaHocTap.setTenHS(resultSet.getString("tenhs"));
				ketQuaHocTap.setDiemTongKet(resultSet.getString("diemtrungbinhmon"));
				ketQuaHocTap.setXepLoai(resultSet.getString("xeploai"));
				ketQuaHocTap.setHanhKiem(resultSet.getString("hanhkiem"));
				ketQuaHocTap.setKetQua(resultSet.getString("ketqua"));
				
				
				
				listKetQuaHocTap.add(ketQuaHocTap);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listKetQuaHocTap;
	}
	
	public List<KetQuaHocTap> showTableByAZKQHT(){
		String sql = "SELECT * FROM ketquahoctap ORDER BY sothutu ASC";
		List<KetQuaHocTap> listKetQuaHocTap = new ArrayList<KetQuaHocTap>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			KetQuaHocTap ketQuaHocTap;
			while (resultSet.next()) { 
				ketQuaHocTap = new KetQuaHocTap();
				ketQuaHocTap = new KetQuaHocTap();
				ketQuaHocTap.setSoThuTu(resultSet.getString("sothutu"));
				ketQuaHocTap.setMaHS(resultSet.getString("mahs"));
				ketQuaHocTap.setTenHS(resultSet.getString("tenhs"));
				ketQuaHocTap.setDiemTongKet(resultSet.getString("diemtrungbinhmon"));
				ketQuaHocTap.setXepLoai(resultSet.getString("xeploai"));
				ketQuaHocTap.setHanhKiem(resultSet.getString("hanhkiem"));
				ketQuaHocTap.setKetQua(resultSet.getString("ketqua"));
				listKetQuaHocTap.add(ketQuaHocTap);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listKetQuaHocTap;
	}
	public List<KetQuaHocTap> showTableByZAKQHT(){
		String sql = "SELECT * FROM ketquahoctap ORDER BY sothutu DESC";
		List<KetQuaHocTap> listKetQuaHocTap = new ArrayList<KetQuaHocTap>(); 
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			KetQuaHocTap ketQuaHocTap;
			while (resultSet.next()) { 
				ketQuaHocTap = new KetQuaHocTap();
				ketQuaHocTap.setSoThuTu(resultSet.getString("sothutu"));
				ketQuaHocTap.setMaHS(resultSet.getString("mahs"));
				ketQuaHocTap.setTenHS(resultSet.getString("tenhs"));
				ketQuaHocTap.setDiemTongKet(resultSet.getString("diemtrungbinhmon"));
				ketQuaHocTap.setXepLoai(resultSet.getString("xeploai"));
				ketQuaHocTap.setHanhKiem(resultSet.getString("hanhkiem"));
				ketQuaHocTap.setKetQua(resultSet.getString("ketqua"));
				listKetQuaHocTap.add(ketQuaHocTap);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listKetQuaHocTap;
	}
	
	public void addKetQuaKQHT(KetQuaHocTap ketQuaHocTap) {
		String sql = "INSERT INTO ketquahoctap VALUES(?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,ketQuaHocTap.getSoThuTu());
			statement.setString(2,ketQuaHocTap.getMaHS());
			statement.setString(3,ketQuaHocTap.getTenHS());
			statement.setString(4, ketQuaHocTap.getDiemTongKet());
			statement.setString(5, ketQuaHocTap.getXepLoai());
			statement.setString(6, ketQuaHocTap.getHanhKiem());
			statement.setString(7, ketQuaHocTap.getKetQua());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddKQHT(String mahs, String stt) {
		String sql = "SELECT * FROM ketquahoctap WHERE (mahs= ? AND sothutu = ?) OR (mahs= ? OR sothutu = ?)";
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
	public void updateKetQuaKQHT(KetQuaHocTap ketQuaHocTap) {
		String sql = "UPDATE ketquahoctap SET sothutu = ? ,tenhs = ?,diemtrungbinhmon = ?,xeploai = ?,hanhkiem = ?,ketqua = ? WHERE mahs= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,ketQuaHocTap.getSoThuTu());
			statement.setString(2,ketQuaHocTap.getTenHS());
			statement.setString(3, ketQuaHocTap.getDiemTongKet());
			statement.setString(4, ketQuaHocTap.getXepLoai());
			statement.setString(5, ketQuaHocTap.getHanhKiem());
			statement.setString(6, ketQuaHocTap.getKetQua());
			statement.setString(7,ketQuaHocTap.getMaHS());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteKetQuaKQHT(String mahs) {
		String sql = "DELETE FROM ketquahoctap WHERE mahs = ?";
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
	public KetQuaHocTap getKetQuaByMaHSKQHT(String mahs) {
		KetQuaHocTap ketQuaHocTap = null;
		String sql = "SELECT * FROM ketquahoctap WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			ketQuaHocTap = new KetQuaHocTap();
			if(resultSet.next()) {
				ketQuaHocTap = new KetQuaHocTap();
				ketQuaHocTap.setSoThuTu(resultSet.getString("sothutu"));
				ketQuaHocTap.setMaHS(resultSet.getString("mahs"));
				ketQuaHocTap.setTenHS(resultSet.getString("tenhs"));
				ketQuaHocTap.setDiemTongKet(resultSet.getString("diemtrungbinhmon"));
				ketQuaHocTap.setXepLoai(resultSet.getString("xeploai"));
				ketQuaHocTap.setHanhKiem(resultSet.getString("hanhkiem"));
				ketQuaHocTap.setKetQua(resultSet.getString("ketqua"));
				
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return ketQuaHocTap;
	}
}
