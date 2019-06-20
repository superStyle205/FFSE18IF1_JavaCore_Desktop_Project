package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.HocSinh;
import model.bean.Student;

public class StudentDao {
	private static final String sql = null;

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

		} finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public boolean isLogin(int mahocsinh, String hoten, String malop, String diachi, String email, String namsinh,
			String namhoc, String gioitinh) {
		String sql = "SELECT * FROM hocsinh WHERE mahocsinh = ? and hoten = ? and malop = ?  and diachi = ? and email = ? and namsinh = ? and namhoc = ? and gioitinh = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setInt(1, mahocsinh);
			stsm.setString(2, hoten);
			stsm.setString(3, malop);
			stsm.setString(4, diachi);
			stsm.setString(5, email);
			stsm.setString(6, namsinh);
			stsm.setString(7, namhoc);
			stsm.setString(8, gioitinh);
			ResultSet result = stsm.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public ArrayList<HocSinh> getAllUser() {
		String sql = "SELECT * FROM hocsinh";
		ArrayList<HocSinh> listHS = new ArrayList<HocSinh>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			HocSinh hs;
			while (result.next()) {
				hs = new HocSinh();
				hs.setMahocsinh(result.getInt("mahocsinh"));
				hs.setHoten(result.getString("hoten"));
				hs.setMalop(result.getString("malop"));
				hs.setDiachi(result.getString("diachi"));
				hs.setEmail(result.getString("email"));
				hs.setNamsinh(result.getString("namsinh"));
				hs.setNamhoc(result.getString("namhoc"));
				hs.setGioitinh(result.getString("gioitinh"));
				listHS.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return listHS;

	}

	public void addUser(HocSinh hs) {

		String sql = "INSERT INTO hocsinh VALUES (NULL,?,?,?,?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getHoten());
			statement.setString(2, hs.getGioitinh());
			statement.setString(3, hs.getEmail());
			statement.setString(4, hs.getDiachi());
			statement.setString(5, hs.getMalop());
			statement.setString(6, hs.getNamsinh());
			statement.setString(7, hs.getNamhoc());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(HocSinh hs) {
		String sql = "UPDATE hocsinh SET hoten= ?, gioitinh = ? , diachi = ?, email = ?, malop = ?, namsinh = ?, namhoc = ? WHERE mahocsinh = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getHoten());
			statement.setString(2, hs.getGioitinh());
			statement.setString(3, hs.getDiachi());
			statement.setString(4, hs.getEmail());
			statement.setString(5, hs.getMalop());
			statement.setString(6, hs.getNamsinh());
			statement.setString(7, hs.getNamhoc());
			statement.setInt(8, hs.getMahocsinh());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String mahocsinh) {
		String sql = "DELETE FROM hocsinh WHERE mahocsinh = ?";
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

	public HocSinh searchInfor(String mahocsinh ) {
		HocSinh studentinfor = null;
		String sql = "SELECT * FROM hocsinh WHERE mahocsinh = ?";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mahocsinh);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new HocSinh();

				studentinfor.setMahocsinh(result.getInt("mahocsinh"));
				studentinfor.setHoten(result.getString("hoten"));
				studentinfor.setGioitinh(result.getString("gioitinh"));
				studentinfor.setDiachi(result.getString("diachi"));
				studentinfor.setEmail(result.getString("email"));
				studentinfor.setMalop(result.getString("malop"));
				studentinfor.setNamsinh(result.getString("namsinh"));
				studentinfor.setNamhoc(result.getString("namhoc"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return studentinfor;
	}

}
