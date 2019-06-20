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

public class DiemDao {
	public ArrayList<Diem> getAllDiem() {
		String sql = "SELECT * FROM diem";
		ArrayList<Diem> listDiem = new ArrayList<Diem>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Diem user;
			while (result.next()) {
				user = new Diem();
				user.setMaSV(result.getString("MaSV"));
				user.setMaMH(result.getString("MaMH"));
				user.setLanThi(result.getString("LanThi"));
				user.setDiemThi(result.getNString("DiemThi"));
				listDiem.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listDiem;
	}
	public void addDiem(Diem d) {
		String sql = "INSERT INTO diem VALUES(?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, d.getMaSV());
			statement.setString(2, d.getMaMH());
			statement.setString(3, d.getLanThi());
			statement.setString(4, d.getDiemThi());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateDiem(Diem dd) {
		String sql = "UPDATE diem SET MaMH = ?, LanThi = ?, DiemThi = ? WHERE MaSV = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dd.getMaMH());
			statement.setString(2, dd.getLanThi());
			statement.setString(3, dd.getDiemThi());
			statement.setString(4, dd.getMaSV());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void deleteDiem(String dd) {
		String sql = "DELETE FROM diem WHERE MaSV = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dd);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
