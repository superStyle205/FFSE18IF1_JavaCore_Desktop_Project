package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.HoSoHocSinh;
import Model.bean.HocSinh;

public class HoSoHocSinhDao {
	public List<HoSoHocSinh> getAllHoSoHocSinh(){
		String sql = "SELECT * FROM hosohocsinh";
		List<HoSoHocSinh> listHoSoHocSinh = new ArrayList<HoSoHocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			HoSoHocSinh hoSoHocSinh;
			while (resultSet.next()) { 
				hoSoHocSinh = new HoSoHocSinh();
				hoSoHocSinh.setSoThuTu(resultSet.getString("sothutu"));
				hoSoHocSinh.setMaHS(resultSet.getString("mahs"));
				hoSoHocSinh.setTenHS(resultSet.getString("tenhs"));
				hoSoHocSinh.setGioiTinh(resultSet.getString("gioitinh"));
				hoSoHocSinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hoSoHocSinh.setLop(resultSet.getString("lop"));
				hoSoHocSinh.setDiaChi(resultSet.getString("diachi"));
				hoSoHocSinh.setDanToc(resultSet.getString("dantoc"));
				hoSoHocSinh.setTonGiao(resultSet.getString("tongiao"));
				hoSoHocSinh.setTenBo(resultSet.getString("tenbo"));
				hoSoHocSinh.setTenMe(resultSet.getString("tenme"));
				hoSoHocSinh.setNgheNghiepBo(resultSet.getString("nghenghiepbo"));
				hoSoHocSinh.setNgheNghiepMe(resultSet.getString("nghenghiepme"));
				hoSoHocSinh.setSoDienThoaiBo(resultSet.getString("sodienthoaibo"));
				hoSoHocSinh.setSoDienThoaiMe(resultSet.getString("sodienthoaime"));
				listHoSoHocSinh.add(hoSoHocSinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listHoSoHocSinh;
	}
	public List<HoSoHocSinh> showTableByAZ(){
		String sql = "SELECT * FROM hosohocsinh ORDER BY sothutu ASC";
		List<HoSoHocSinh> listHoSoHocSinh = new ArrayList<HoSoHocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			HoSoHocSinh hoSoHocSinh;
			while (resultSet.next()) { 
				hoSoHocSinh = new HoSoHocSinh();
				hoSoHocSinh.setSoThuTu(resultSet.getString("sothutu"));
				hoSoHocSinh.setMaHS(resultSet.getString("mahs"));
				hoSoHocSinh.setTenHS(resultSet.getString("tenhs"));
				hoSoHocSinh.setGioiTinh(resultSet.getString("gioitinh"));
				hoSoHocSinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hoSoHocSinh.setLop(resultSet.getString("lop"));
				hoSoHocSinh.setDiaChi(resultSet.getString("diachi"));
				hoSoHocSinh.setDanToc(resultSet.getString("dantoc"));
				hoSoHocSinh.setTonGiao(resultSet.getString("tongiao"));
				hoSoHocSinh.setTenBo(resultSet.getString("tenbo"));
				hoSoHocSinh.setTenMe(resultSet.getString("tenme"));
				hoSoHocSinh.setNgheNghiepBo(resultSet.getString("nghenghiepbo"));
				hoSoHocSinh.setNgheNghiepMe(resultSet.getString("nghenghiepme"));
				hoSoHocSinh.setSoDienThoaiBo(resultSet.getString("sodienthoaibo"));
				hoSoHocSinh.setSoDienThoaiMe(resultSet.getString("sodienthoaime"));
				listHoSoHocSinh.add(hoSoHocSinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listHoSoHocSinh;
	}
	public List<HoSoHocSinh> showTableByZA(){
		String sql = "SELECT * FROM hosohocsinh ORDER BY sothutu DESC";
		List<HoSoHocSinh> listHoSoHocSinh = new ArrayList<HoSoHocSinh>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			HoSoHocSinh hoSoHocSinh;
			while (resultSet.next()) { 
				hoSoHocSinh = new HoSoHocSinh();
				hoSoHocSinh.setSoThuTu(resultSet.getString("sothutu"));
				hoSoHocSinh.setMaHS(resultSet.getString("mahs"));
				hoSoHocSinh.setTenHS(resultSet.getString("tenhs"));
				hoSoHocSinh.setGioiTinh(resultSet.getString("gioitinh"));
				hoSoHocSinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hoSoHocSinh.setLop(resultSet.getString("lop"));
				hoSoHocSinh.setDiaChi(resultSet.getString("diachi"));
				hoSoHocSinh.setDanToc(resultSet.getString("dantoc"));
				hoSoHocSinh.setTonGiao(resultSet.getString("tongiao"));
				hoSoHocSinh.setTenBo(resultSet.getString("tenbo"));
				hoSoHocSinh.setTenMe(resultSet.getString("tenme"));
				hoSoHocSinh.setNgheNghiepBo(resultSet.getString("nghenghiepbo"));
				hoSoHocSinh.setNgheNghiepMe(resultSet.getString("nghenghiepme"));
				hoSoHocSinh.setSoDienThoaiBo(resultSet.getString("sodienthoaibo"));
				hoSoHocSinh.setSoDienThoaiMe(resultSet.getString("sodienthoaime"));
				listHoSoHocSinh.add(hoSoHocSinh);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listHoSoHocSinh;
	}
	
	public void addHoSoHocSinh(HoSoHocSinh hoSoHocSinh) {
		String sql = "INSERT INTO hosohocsinh VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,hoSoHocSinh.getSoThuTu());
			statement.setString(2,hoSoHocSinh.getMaHS());
			statement.setString(3,hoSoHocSinh.getTenHS());
			statement.setString(4, hoSoHocSinh.getGioiTinh());
			statement.setString(5, hoSoHocSinh.getNgaySinh());
			statement.setString(6, hoSoHocSinh.getLop());
			statement.setString(7, hoSoHocSinh.getDiaChi());
			statement.setString(8, hoSoHocSinh.getDanToc());
			statement.setString(9, hoSoHocSinh.getTonGiao());
			statement.setString(10, hoSoHocSinh.getTenBo());
			statement.setString(11, hoSoHocSinh.getTenMe());
			statement.setString(12, hoSoHocSinh.getNgheNghiepBo());
			statement.setString(13, hoSoHocSinh.getNgheNghiepMe());
			statement.setString(14, hoSoHocSinh.getSoDienThoaiBo());
			statement.setString(15, hoSoHocSinh.getSoDienThoaiMe());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddHSHS(String mahs, String stt) {
		String sql = "SELECT * FROM hosohocsinh WHERE (mahs= ? AND sothutu = ?) OR (mahs= ? OR sothutu = ?)";
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
	public void updateHoSoHocSinh(HoSoHocSinh hoSoHocSinh) {
		String sql = "UPDATE hosohocsinh SET sothutu = ? ,tenhs = ?,gioitinh = ?,ngaysinh = ?,lop = ?,diachi = ?,dantoc = ?,tongiao = ?,tenbo = ?,tenme =?,nghenghiepbo = ?,nghenghiepme = ?,sodienthoaibo = ?,sodienthoaime = ? WHERE mahs= ?";
		ConnectUtil connectUtil = new ConnectUtil ();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,hoSoHocSinh.getSoThuTu());
			
			statement.setString(2,hoSoHocSinh.getTenHS());
			statement.setString(3, hoSoHocSinh.getGioiTinh());
			statement.setString(4, hoSoHocSinh.getNgaySinh());
			statement.setString(5, hoSoHocSinh.getLop());
			statement.setString(6, hoSoHocSinh.getDiaChi());
			statement.setString(7, hoSoHocSinh.getDanToc());
			statement.setString(8, hoSoHocSinh.getTonGiao());
			statement.setString(9, hoSoHocSinh.getTenBo());
			statement.setString(10, hoSoHocSinh.getTenMe());
			statement.setString(11, hoSoHocSinh.getNgheNghiepBo());
			statement.setString(12, hoSoHocSinh.getNgheNghiepMe());
			statement.setString(13, hoSoHocSinh.getSoDienThoaiBo());
			statement.setString(14, hoSoHocSinh.getSoDienThoaiMe());
			statement.setString(15,hoSoHocSinh.getMaHS());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	public void deleteHoSoHocSinh(String mahs) {
		String sql = "DELETE FROM hosohocsinh WHERE mahs = ?";
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
	public HoSoHocSinh getHoSoHocSinhByMaHS(String mahs) {
		HoSoHocSinh hoSoHocSinh = null;
		String sql = "SELECT * FROM hosohocsinh WHERE mahs = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			hoSoHocSinh = new HoSoHocSinh();
			if(resultSet.next()) {
				hoSoHocSinh = new HoSoHocSinh();
				hoSoHocSinh.setSoThuTu(resultSet.getString("sothutu"));
				hoSoHocSinh.setMaHS(resultSet.getString("mahs"));
				hoSoHocSinh.setTenHS(resultSet.getString("tenhs"));
				hoSoHocSinh.setGioiTinh(resultSet.getString("gioitinh"));
				hoSoHocSinh.setNgaySinh(resultSet.getString("ngaysinh"));
				hoSoHocSinh.setLop(resultSet.getString("lop"));
				hoSoHocSinh.setDiaChi(resultSet.getString("diachi"));
				hoSoHocSinh.setDanToc(resultSet.getString("dantoc"));
				hoSoHocSinh.setTonGiao(resultSet.getString("tongiao"));
				hoSoHocSinh.setTenBo(resultSet.getString("tenbo"));
				hoSoHocSinh.setTenMe(resultSet.getString("tenme"));
				hoSoHocSinh.setNgheNghiepBo(resultSet.getString("nghenghiepbo"));
				hoSoHocSinh.setNgheNghiepMe(resultSet.getString("nghenghiepme"));
				hoSoHocSinh.setSoDienThoaiBo(resultSet.getString("sodienthoaibo"));
				hoSoHocSinh.setSoDienThoaiMe(resultSet.getString("sodienthoaime"));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		
		return hoSoHocSinh;
	}
}
