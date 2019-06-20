package userdao;



import giaovien.mon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import duan.ConnectUtil;

public class monDao {

	public   ArrayList<mon> getAllMon() {
		String sql = "SELECT * FROM mon";
		ArrayList<mon> listUser = new ArrayList<mon>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			mon user;
			while (result.next()) {
				user = new mon();
				user.setMaMon(result.getString("maMon"));
				user.setTenMon(result.getString("tenMon"));
				user.setMaGV(result.getString("maGV"));
				user.setTenGV(result.getString("tenGV"));
				user.setSoTiet(result.getString("soTiet"));
				user.setGhiChu(result.getString("ghiChu"));
				listUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public void addUser(mon user) {
		String sql = "INSERT INTO mon VALUES(?,?, ?, ?, ?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getMaMon());
			statement.setString(2, user.getTenMon());
			statement.setString(3, user.getMaGV());
			statement.setString(4, user.getTenGV());
			statement.setString(5, user.getSoTiet());
			statement.setString(6, user.getGhiChu());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateUser(mon user) {
		String sql = "UPDATE mon SET tenMon = ?, maGV = ?, soTiet = ? ,GhiChu = ? WHERE maMon = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getTenMon());
			statement.setString(2, user.getMaGV());
			statement.setString(3, user.getSoTiet());
			statement.setString(4, user.getSoTiet());
			statement.setString(5, user.getGhiChu());
			statement.setString(6, user.getMaMon());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteUser(String maNhanVien) {
		String sql = "DELETE FROM mon WHERE manhanvien = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maNhanVien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}