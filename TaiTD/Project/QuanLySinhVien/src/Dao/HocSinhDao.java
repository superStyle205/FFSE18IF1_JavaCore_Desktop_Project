package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectUtil;
import model.bean.Diem;
import model.bean.GiaoVien;
import model.bean.HocSinh;



public class HocSinhDao {
	public boolean isLogin(String username, String password) {
		String sql = "SELECT * FROM taikhoan WHERE username = ? and password = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet result = statement.executeQuery();
			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return false;
	}

	public ArrayList<HocSinh> getAllSV() {
		String sql = "SELECT * FROM hocsinh";
		ArrayList<HocSinh> listSV = new ArrayList<HocSinh>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			HocSinh sv;
			while (result.next()) {
				sv = new HocSinh();
				sv.setMaSinhVien(result.getString("MaSV"));
				sv.setTenSinhVien(result.getString("TenSV"));
				sv.setLop(result.getString("MaLop"));
				sv.setGioiTinh(result.getNString("GioiTinh"));
				sv.setNgaySinh(result.getString("NgaySinh"));
				listSV.add(sv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listSV;
	}

	public void addUser(HocSinh hs) {
		String sql = "INSERT INTO hocsinh VALUES(?,?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getMaSinhVien());
			statement.setString(2, hs.getTenSinhVien());
			statement.setString(3, hs.getLop());
			statement.setString(4, hs.getGioiTinh());
			statement.setString(5, hs.getNgaySinh());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateUser(HocSinh hs) {
		String sql = "UPDATE hocsinh SET TenSV = ?, MaLop = ?, GioiTinh = ?, NgaySinh = ? WHERE MaSV = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getTenSinhVien());
			statement.setString(2, hs.getLop());
			statement.setString(3, hs.getGioiTinh());
			statement.setString(4, hs.getNgaySinh());
			statement.setString(5, hs.getMaSinhVien());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteUser(String hs) {
		String sql = "DELETE FROM hocsinh WHERE MaSV = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	///quản lý giáo viên
	
//	public ArrayList<Diem> getAllDiem() {
//		String sql = "SELECT * FROM diem";
//		ArrayList<Diem> listDiem = new ArrayList<Diem>();
//
//		ConnectUtil connectUtil = new ConnectUtil();
//		Connection conn = connectUtil.connect();
//		try {
//			PreparedStatement statement = conn.prepareStatement(sql);
//
//			ResultSet result = statement.executeQuery();
//
//			Diem user;
//			while (result.next()) {
//				user = new Diem();
//				user.setMaSV(result.getString("MaSV"));
//				user.setMaMH(result.getString("MaMH"));
//				user.setLanThi(result.getString("LanThi"));
//				user.setDiemThi(result.getNString("DiemThi"));
//				listDiem.add(user);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectUtil.disconnect(conn);
//		}
//
//		return listDiem;
//	}
//	public void addDiem(Diem d) {
//		String sql = "INSERT INTO giaovien VALUES(?, ?, ?, ?)";
//		ConnectUtil connectUtil = new ConnectUtil();
//		Connection conn = connectUtil.connect();
//		try {
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, d.getMaSV());
//			statement.setString(2, d.getMaMH());
//			statement.setString(3, d.getLanThi());
//			statement.setString(4, d.getDiemThi());
//			
//			statement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectUtil.disconnect(conn);
//		}
//	}
	/*public HocSinh getUserById(int id) {
		HocSinh user = null;
		String sql = "SELECT * FROM user WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				user = new HocSinh();
				user.setId(result.getInt("id"));
				user.setName(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setEmail(result.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return user;
	}

	public HocSinh getUserByUsername(String username) {
		HocSinh user = null;
		String sql = "SELECT * FROM user WHERE username = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				user = new HocSinh();
				user.setId(result.getInt("id"));
				user.setName(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setEmail(result.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return user;
	}*/
}


