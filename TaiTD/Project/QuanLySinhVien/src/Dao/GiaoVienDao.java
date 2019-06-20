package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectUtil;
import model.bean.GiaoVien;

public class GiaoVienDao {
	public ArrayList<GiaoVien> getAllGV() {
		String sql = "SELECT * FROM giaovien";
		ArrayList<GiaoVien> listGV = new ArrayList<GiaoVien>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			GiaoVien user;
			while (result.next()) {
				user = new GiaoVien();
				user.setMaGV(result.getString("MaGV"));
				user.setTenGV(result.getString("TenGV"));
				user.setChuyenNganh(result.getString("ChuyenNganh"));
				user.setMaKhoa(result.getNString("MaKhoa"));
				listGV.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listGV;
	}
	public void addGV(GiaoVien gv) {
		String sql = "INSERT INTO giaovien VALUES(?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, gv.getMaGV());
			statement.setString(2, gv.getTenGV());
			statement.setString(3, gv.getChuyenNganh());
			statement.setString(4, gv.getMaKhoa());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateGV(GiaoVien gv) {
		String sql = "UPDATE giaovien SET TenGV = ?, ChuyenNganh = ?, MaKhoa = ? WHERE MaGV = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, gv.getTenGV());
			statement.setString(2, gv.getChuyenNganh());
			statement.setString(3, gv.getMaKhoa());
			statement.setString(4, gv.getMaGV());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void deleteGV(String gv) {
		String sql = "DELETE FROM giaovien WHERE MaGV = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, gv);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
