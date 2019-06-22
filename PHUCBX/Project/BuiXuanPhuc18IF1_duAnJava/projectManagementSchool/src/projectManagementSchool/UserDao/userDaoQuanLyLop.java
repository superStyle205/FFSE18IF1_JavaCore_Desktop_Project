package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.Lop;

public class userDaoQuanLyLop {

	public List<Lop> getAllUser() {
		String sql = "SELECT * FROM lop";
		List<Lop> listUser = new ArrayList<Lop>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Lop lop;
			while (result.next()) {
				lop = new Lop();
				lop.setId(result.getString("id"));
				lop.setMaKhoi(result.getString("maKhoi"));
				lop.setMaLop(result.getString("maLop"));
				lop.setTenLop(result.getString("tenLop"));
				lop.setMaNhanVien(result.getString("maNhanVien"));
				lop.setTenNhanVien(result.getString("tenNhanVien"));
				lop.setNienKhoa(result.getString("nienKhoa"));
				lop.setGhiChu(result.getString("ghiChu"));
				listUser.add(lop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public void addUser(Lop lop) {
		String sql = "INSERT INTO lop VALUES(NULL, ?, ?, ?, ?, ?, ?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, lop.getId());
			statement.setString(1, lop.getMaKhoi());
			statement.setString(2, lop.getMaLop());
			statement.setString(3, lop.getTenLop());
			statement.setString(4, lop.getMaNhanVien());
			statement.setString(5, lop.getTenNhanVien());
			statement.setString(6, lop.getNienKhoa());
			statement.setString(7, lop.getGhiChu());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateUser(Lop lop) {
		String sql = "UPDATE lop SET maKhoi = ?, maLop = ?, tenLop = ?, maNhanVien = ?, tenNhanVien = ?, nienKhoa = ?, ghiChu = ? WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getMaKhoi());
			statement.setString(2, lop.getMaLop());
			statement.setString(3, lop.getTenLop());
			statement.setString(4, lop.getMaNhanVien());
			statement.setString(5, lop.getTenNhanVien());
			statement.setString(6, lop.getNienKhoa());
			statement.setString(7, lop.getGhiChu());
			statement.setString(8, lop.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteUser(String id) {
		String sql = "DELETE FROM lop WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public Lop search(String tenLop){
		Lop lop = null;
		String sql = "SELECT * FROM lop WHERE tenLop = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tenLop);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				lop = new Lop();

				lop.setId(result.getString("id"));
				lop.setMaKhoi(result.getString("maKhoi"));
				lop.setMaLop(result.getString("maLop"));
				lop.setTenLop(result.getString("tenLop"));
				lop.setMaNhanVien(result.getString("maNhanVien"));
				lop.setTenNhanVien(result.getString("tenNhanVien"));
				lop.setNienKhoa(result.getString("nienKhoa"));
				lop.setGhiChu(result.getString("ghiChu"));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connectUtil.disconnect(conn);
		}
		return lop;
	}
	
}
