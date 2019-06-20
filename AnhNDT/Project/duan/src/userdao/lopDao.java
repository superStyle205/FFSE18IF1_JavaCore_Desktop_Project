package userdao;

import giaovien.lop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import duan.ConnectUtil;



public class lopDao {
	
	public ArrayList<lop> getAllUser() {
		String sql = "SELECT * FROM lop";
		ArrayList<lop> listUser = new ArrayList<lop>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			lop user;
			while (result.next()) {
				user = new lop();
				user.setId(result.getString("malop"));
				user.setTenHs(result.getString("tenlop"));
				user.setTenGV(result.getString("tenGV"));
				user.setKhoa(result.getString("maKhoi"));
				listUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}
	public void addUser(lop user) {
		String sql = "INSERT INTO lop VALUES(?,?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getId());
			statement.setString(2, user.getTenHs());
			statement.setString(3, user.getTenGV());
			statement.setString(4, user.getKhoa());
			

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateUser(lop user) {
		String sql = "UPDATE lop SET tenlop = ?, tenGV= ?, maKhoi = ?  WHERE malop = ?";
	
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getTenHs());
			statement.setString(2, user.getTenGV());
			statement.setString(3, user.getKhoa());
			statement.setString(4, user.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteUser(String id) {
		String sql = "DELETE FROM lop WHERE malop = ?";
		
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
	}}
