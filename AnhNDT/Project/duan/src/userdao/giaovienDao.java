package userdao;


import giaovien.giaovien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import duan.ConnectUtil;

public class giaovienDao {
	public ArrayList<giaovien> getAllUser() {
		String sql = "SELECT * FROM giaovien";
		ArrayList<giaovien> listUser = new ArrayList<giaovien>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			giaovien user;
			while (result.next()) {
				user = new giaovien();
				user.setMaGiaoVien(result.getString("maGiaoVien"));
				user.setTenGiaoVien(result.getString("tenGiaoVien"));
				user.setEmailGiaoVien(result.getString("emailGiaoVien"));
				user.setSdtGiaoVien(result.getString("sdtGiaoVien"));
				user.setMaKhoi(result.getString("maKhoi"));
				listUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}
	public void addUser(giaovien user) {
		String sql = "INSERT INTO giaovien VALUES(?,?, ?, ?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getMaGiaoVien());
			statement.setString(2, user.getTenGiaoVien());
			statement.setString(3, user.getEmailGiaoVien());
			statement.setString(4, user.getSdtGiaoVien());
			statement.setString(5, user.getMaKhoi());
			

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateUser(giaovien user) {
		String sql = "UPDATE lop SET tenGiaoVien = ?, emailGiaoVien= ?, sdtGiaoVien= ?, maKhoi = ?  WHERE maGiaoVien = ?";
	
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getTenGiaoVien());
			statement.setString(2, user.getEmailGiaoVien());
			statement.setString(3, user.getSdtGiaoVien());
			statement.setString(4, user.getMaKhoi());
			statement.setString(5, user.getMaGiaoVien());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteUser(String id) {
		String sql = "DELETE FROM giaovien WHERE maGiaoVien = ?";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
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
}
