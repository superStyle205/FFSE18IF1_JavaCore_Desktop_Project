package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectUtil;
import model.bean.Lop;


public class LopDao {
	public ArrayList<Lop> getAllLop() {
		String sql = "SELECT * FROM lop";
		ArrayList<Lop> listLop = new ArrayList<Lop>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Lop user;
			while (result.next()) {
				user = new Lop();
				user.setMaLop(result.getString("MaLop"));
				user.setTenLop(result.getString("TenLop"));
				user.setMaKhoa(result.getString("MaKhoa"));
				listLop.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listLop;
	}
	public void addLop(Lop ll) {
		String sql = "INSERT INTO lop VALUES(?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ll.getMaLop());
			statement.setString(2, ll.getTenLop());
			statement.setString(3, ll.getMaKhoa());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateLop(Lop ll) {
		String sql = "UPDATE lop SET TenLop = ? , MaKhoa = ? WHERE MaLop = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ll.getTenLop());
			statement.setString(2, ll.getMaKhoa());
			statement.setString(3, ll.getMaLop());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void deleteLop(String ll) {
		String sql = "DELETE FROM lop WHERE MaLop = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ll);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
