package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.BangDiem;
import model.bean.GiaoVien;
import model.bean.HocSinh;

public class BangDiemDao {
	public boolean isLogint(String username, String password) {
		String sql = "SELECT * FROM login WHERE username = ? and password = ? ";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, username);
			stsm.setString(2, password);
			ResultSet result = stsm.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

			// } finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public boolean isLogin(int mahocsinh, String malop, String mamon, double diem_mieng, double diem_15p,
			double diem_45p, double diem_thi) {
		String sql = "SELECT * FROM bangDiem WHERE mahocsinh = ? and malop = ? and mamon = ?  and diem_mieng = ? and diem_15p  = ? and diem_45p = ? and diem_thi = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setInt(1, mahocsinh);
			stsm.setString(2, malop);
			stsm.setString(3, mamon);
			stsm.setDouble(4, diem_mieng);
			stsm.setDouble(5, diem_15p);
			stsm.setDouble(6, diem_45p);
			stsm.setDouble(7, diem_thi);
			ResultSet result = stsm.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public ArrayList<BangDiem> getAllUser() {
		String sql = "SELECT * FROM bangDiem";
		ArrayList<BangDiem> listbd = new ArrayList<BangDiem>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			BangDiem bd;
			while (result.next()) {
				bd = new BangDiem();
				bd.setMahocsinh(result.getInt("mahocsinh"));
				bd.setMalop(result.getString("malop"));
				bd.setMamon(result.getString("mamon"));
				bd.setDiem_mieng(result.getString("diem_mieng"));
				bd.setDiem_15p(result.getString("diem_15p"));
				bd.setDiem_45p(result.getString("diem_45p"));
				bd.setDiem_thi(result.getString("diem_thi"));
				bd.setMahocki(result.getString("mahocki"));
				bd.setGhichu(result.getString("ghichu"));
				listbd.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return listbd;

	}

	public void addUser(BangDiem bd) {

		String sql = "INSERT INTO bangDiem VALUES (NULL,?,?,?,?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, bd.getMalop());
			statement.setString(2, bd.getMamon());
			statement.setString(3, bd.getDiem_mieng());
			statement.setString(4, bd.getDiem_15p());
			statement.setString(5, bd.getDiem_45p());
			statement.setString(6, bd.getDiem_thi());
			statement.setString(7, bd.getGhichu());
			statement.setString(8, bd.getMahocki());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(BangDiem bd) {
		String sql = "UPDATE bangDiem SET malop= ?, mamon = ?, diem_mieng = ?, diem_15p = ?, diem_45p = ?, diem_thi = ?, ghichu = ?, mahocki = ? WHERE mahocsinh = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, bd.getMalop());
			statement.setString(2, bd.getMamon());
			statement.setString(3, bd.getDiem_mieng());
			statement.setString(4, bd.getDiem_15p());
			statement.setString(5, bd.getDiem_45p());
			statement.setString(6, bd.getDiem_thi());
			statement.setString(7, bd.getGhichu());
			statement.setString(8, bd.getMahocki());
			statement.setInt(9, bd.getMahocsinh());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String mahocsinh) {
		String sql = "DELETE FROM bangDiem WHERE mahocsinh = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mahocsinh);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public BangDiem search(String mahocsinh) {
		BangDiem studentinfor = null;
		String sql = "SELECT * FROM sinhvien WHERE mahocsinh = ?";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mahocsinh);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new BangDiem();

				studentinfor.setMahocsinh(result.getInt("mahocsinh"));
				studentinfor.setMalop(result.getString("malop"));
				studentinfor.setMamon(result.getString("mamon"));
				studentinfor.setMahocki(result.getString("mahocki"));
				studentinfor.setDiem_mieng(result.getString("diem_mieng"));
				studentinfor.setDiem_15p(result.getString("diem_15p"));
				studentinfor.setDiem_45p(result.getString("diem_45p"));
				studentinfor.setDiem_thi(result.getString("diem_thi"));
				studentinfor.setGhichu(result.getString("ghichu"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return studentinfor;
	}
}
