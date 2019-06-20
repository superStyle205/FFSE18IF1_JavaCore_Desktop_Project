package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.ConnectUtil;
import model.bean.Lop;
import model.bean.MonHoc;

public class MonHocDao {
	public ArrayList<MonHoc> getAllMH() {
		String sql = "SELECT * FROM monhoc";
		ArrayList<MonHoc> listMH = new ArrayList<MonHoc>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			MonHoc user;
			while (result.next()) {
				user = new MonHoc();
				user.setMaMonHoc(result.getString("MaMH"));
				user.setTenMonHoc(result.getString("TenMh"));
				user.setSoGio(result.getString("SoGio"));
				listMH.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listMH;
	}
	public void addMH(MonHoc mh) {
		String sql = "INSERT INTO monhoc VALUES(?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mh.getMaMonHoc());
			statement.setString(2, mh.getTenMonHoc());
			statement.setString(3, mh.getSoGio());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateMH(MonHoc mh) {
		String sql = "UPDATE monhoc SET TenMh = ? , SoGio = ? WHERE MaMH = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mh.getTenMonHoc());
			statement.setString(2, mh.getSoGio());
			statement.setString(3, mh.getMaMonHoc());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void deleteMH(String mh) {
		String sql = "DELETE FROM monhoc WHERE MaMH = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mh);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
