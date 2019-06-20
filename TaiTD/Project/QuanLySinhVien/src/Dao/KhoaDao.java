package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectUtil;
import model.bean.Khoa;


public class KhoaDao {
	public ArrayList<Khoa> getAllKhoa() {
		String sql = "SELECT * FROM khoa";
		ArrayList<Khoa> listKhoa = new ArrayList<Khoa>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Khoa user;
			while (result.next()) {
				user = new Khoa();
				user.setMaKhoa(result.getString("MaKhoa"));
				user.setTenKhoa(result.getString("tenkhoa"));
				listKhoa.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listKhoa;
	}
	public void addKhoa(Khoa kk) {
		String sql = "INSERT INTO khoa VALUES(?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kk.getMaKhoa());
			statement.setString(2, kk.getTenKhoa());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateKhoa(Khoa kk) {
		String sql = "UPDATE khoa SET TenKhoa = ? WHERE MaKhoa = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kk.getTenKhoa());
			statement.setString(2, kk.getMaKhoa());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void deleteKhoa(String kk) {
		String sql = "DELETE FROM khoa WHERE MaKhoa = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kk);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
