package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.GiaoVien;
import model.bean.HocSinh;

public class TeaCherDao {
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

//		} finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public boolean isLogin(int magiaovien, String hoten, String gioitinh, String malop, String namsinh
			) {
		String sql = "SELECT * FROM giaovien WHERE magiaovien = ? and hoten = ? and gioitinh = ?  and malop = ? and namsinh  = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setInt(1, magiaovien);
			stsm.setString(2, hoten);
			stsm.setString(3, gioitinh);
			stsm.setString(4, malop);
			stsm.setString(5, namsinh);
			ResultSet result = stsm.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public ArrayList<GiaoVien> getAllUser() {
		String sql = "SELECT * FROM giaovien";
		ArrayList<GiaoVien> listGV = new ArrayList<GiaoVien>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			GiaoVien gv;
			while (result.next()) {
				gv = new GiaoVien();
				gv.setMagiaovien(result.getInt("magiaovien"));
				gv.setHoten(result.getString("hoten"));
				gv.setGioitinh(result.getString("gioitinh"));
				gv.setMalop(result.getString("malop"));		
				gv.setNamsinh(result.getString("namsinh"));
				gv.setMamon(result.getString("mamon"));
				
				listGV.add(gv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return listGV;

	}

	public void addUser(GiaoVien gv) {
		
		String sql = "INSERT INTO giaovien VALUES (NULL,?,?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, gv.getHoten());
			statement.setString(2, gv.getGioitinh());
			statement.setString(3, gv.getMalop());
			statement.setString(4, gv.getNamsinh());
			statement.setString(5, gv.getMamon());
		
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(GiaoVien gv) {
		String sql = "UPDATE giaovien SET hoten= ?, gioitinh = ?, malop = ?, namsinh = ?,mamon = ? WHERE magiaovien = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, gv.getHoten());
			statement.setString(2, gv.getGioitinh());
			statement.setString(3, gv.getMalop());
			statement.setString(4, gv.getNamsinh());
			statement.setString(5, gv.getMamon());
			statement.setInt(6, gv.getMagiaovien());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String magiaovien) {
		String sql = "DELETE FROM giaovien WHERE magiaovien = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, magiaovien);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}
	public GiaoVien search(String magiaovien){
		GiaoVien studentinfor = null;
		String sql = "SELECT * FROM hocsinh WHERE mahocsinh = ?";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, magiaovien);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new GiaoVien();

				studentinfor.setMagiaovien(result.getInt("mahocsinh"));
				studentinfor.setHoten(result.getString("hoten"));
				studentinfor.setGioitinh(result.getString("gioitinh"));
				studentinfor.setMalop(result.getString("malop"));
				studentinfor.setNamsinh(result.getString("namsinh"));
				studentinfor.setMamon(result.getString("namhoc"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return studentinfor;
	}

}
