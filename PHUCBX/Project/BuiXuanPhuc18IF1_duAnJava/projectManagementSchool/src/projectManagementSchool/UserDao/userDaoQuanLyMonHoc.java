package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.MonHoc;

public class userDaoQuanLyMonHoc {
	public static List<MonHoc> getAllUser() {
		String sql = "SELECT * FROM monhoc";
		List<MonHoc> listUser = new ArrayList<MonHoc>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			MonHoc mh;
			while (result.next()) {
				mh = new MonHoc();
				
				mh.setId(result.getString("id"));
				mh.setMaMonHoc(result.getString("maMonHoc"));
				mh.setTenMonHoc(result.getString("tenMonHoc"));
				mh.setMaNhanVien(result.getString("maNhanVien"));
				mh.setSoTietDay(result.getString("soTiet"));
				mh.setGhiChu(result.getString("ghiChu"));
				listUser.add(mh);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public static void addUser(MonHoc mh) {
		String sql = "INSERT INTO monhoc VALUES(NULL, ?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
//			statement.setString(1, mh.getId());
			statement.setString(1, mh.getMaMonHoc());
			statement.setString(2, mh.getTenMonHoc());
			statement.setString(3, mh.getMaNhanVien());
			statement.setString(4, mh.getSoTietDay());
			statement.setString(5, mh.getGhiChu());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void updateUser(MonHoc mh) {
		String sql = "UPDATE monhoc SET maMonHoc = ?,tenMonHoc = ?, maNhanVien = ?, soTiet = ?, ghiChu = ?  WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, mh.getMaMonHoc());
			statement.setString(2, mh.getTenMonHoc());
			statement.setString(3, mh.getMaNhanVien());
			statement.setString(4, mh.getSoTietDay());
			statement.setString(5, mh.getGhiChu());
			statement.setString(6, mh.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void deleteUser(String maLop) {
		String sql = "DELETE FROM monhoc WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maLop);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

}
