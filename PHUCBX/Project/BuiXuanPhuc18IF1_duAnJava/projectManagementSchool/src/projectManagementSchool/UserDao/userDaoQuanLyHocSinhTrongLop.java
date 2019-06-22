package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.hocSinhTrongLop;
import projectManagementSchool.model.salary;

public class userDaoQuanLyHocSinhTrongLop {
//	public static boolean isExistUser(String username, String password) {
//		String sql = "SELECT * FROM hocsinhtronglop WHERE username = ? and password = ?";
//
//		ConnectUtil connectUtil = new ConnectUtil();
//		Connection conn = connectUtil.getConnect("localhost", "quanlyclass", "root", "");
//		try {
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, username);
//			statement.setString(2, password);
//
//			ResultSet result = statement.executeQuery();
//			return result.next();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connectUtil.disconnect(conn);
//		}
//		return false;
//	}

	public static List<hocSinhTrongLop> getAllUser() {
		String sql = "SELECT * FROM hocsinhtronglop";
		List<hocSinhTrongLop> listUser = new ArrayList<hocSinhTrongLop>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			hocSinhTrongLop hstl;
			while (result.next()) {
				hstl = new hocSinhTrongLop();
				hstl.setId(result.getString("id"));
				hstl.setMaLop(result.getString("maLop"));
				hstl.setMaHocSinh(result.getString("maHocSinh"));
				hstl.setTenHocSinh(result.getString("tenHocSinh"));
				hstl.setGioiTinh(result.getString("gioiTinh"));
				hstl.setNgaySinh(result.getString("ngaySinh"));
				hstl.setHanhKiem(result.getString("hanhKiem"));
				hstl.setGhiChu(result.getString("ghiChu"));
				listUser.add(hstl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public static void addUser(hocSinhTrongLop hstl) {
		String sql = "INSERT INTO hocsinhtronglop VALUES(NULL,?, ?,  ?, ?, ?, ?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, hstl.getId());
			statement.setString(1, hstl.getMaLop());
			statement.setString(2, hstl.getMaHocSinh());
			statement.setString(3, hstl.getTenHocSinh());
			statement.setString(4, hstl.getGioiTinh());
			statement.setString(5, hstl.getNgaySinh());
			statement.setString(6, hstl.getHanhKiem());
			statement.setString(7, hstl.getGhiChu());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void updateUser(hocSinhTrongLop hstl) {
		String sql = "UPDATE hocsinhtronglop SET maLop = ?, maHocSinh = ?, tenHocSinh = ?,gioiTinh = ?,  ngaySinh = ?, hanhKiem = ?, ghiChu = ? WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, hstl.getMaLop());
			statement.setString(2, hstl.getMaHocSinh());
			statement.setString(3, hstl.getTenHocSinh());
			statement.setString(4, hstl.getGioiTinh());
			statement.setString(5, hstl.getNgaySinh());
			statement.setString(6, hstl.getHanhKiem());
			statement.setString(7, hstl.getGhiChu());
			statement.setString(8, hstl.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void deleteUser(String maHocSinh) {
		String sql = "DELETE FROM hocsinhtronglop WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maHocSinh);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public hocSinhTrongLop search(String tenHocSinh) {
		hocSinhTrongLop hstl = null;
		String sql = "SELECT * FROM hocsinhtronglop WHERE tenHocSinh = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tenHocSinh);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				hstl = new hocSinhTrongLop();

				hstl.setId(result.getString("id"));
				hstl.setMaLop(result.getString("maLop"));
				hstl.setMaHocSinh(result.getString("maHocSinh"));
				hstl.setTenHocSinh(result.getString("tenHocSinh"));
				hstl.setGioiTinh(result.getString("gioiTinh"));
				hstl.setNgaySinh(result.getString("ngaySinh"));
				hstl.setHanhKiem(result.getString("hanhKiem"));
				hstl.setGhiChu(result.getString("ghiChu"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connectUtil.disconnect(conn);
		}
		return hstl;
	}

}
