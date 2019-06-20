package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.HoSoHocSinh;
import model.bean.HocSinh;

public class HoSoHocSinhDao {
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

	public ArrayList<HoSoHocSinh> getAllUser() {
		String sql = "SELECT * FROM hosohocsinh";
		ArrayList<HoSoHocSinh> listHShs = new ArrayList<HoSoHocSinh>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			HoSoHocSinh hs;
			while (result.next()) {
				hs = new HoSoHocSinh();
				hs.setMalop(result.getString("malop"));
				hs.setMahocsinh(result.getInt("mahocsinh"));
				hs.setHoten(result.getString("hoten"));		
				hs.setDiachi(result.getString("diachi"));
				hs.setDantoc(result.getString("dantoc"));
				hs.setNamsinh(result.getString("namsinh"));
				hs.setGioitinh(result.getString("gioitinh"));
				hs.setEmail(result.getString("email"));
				hs.setHotenme(result.getString("hotencha"));
				hs.setHotenme(result.getString("hotenme"));
				hs.setGhichu(result.getString("ghichu"));
				
				
				listHShs.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return listHShs;

	}

	public void addUser(HoSoHocSinh hs) {

		String sql = "INSERT INTO hosohocsinh VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getMalop());
			statement.setInt(2, hs.getMahocsinh());
			statement.setString(3, hs.getHoten());
			statement.setString(4, hs.getDiachi());
			statement.setString(5, hs.getDantoc());
			statement.setString(6, hs.getNamsinh());
			statement.setString(7, hs.getGioitinh());
			statement.setString(8, hs.getEmail());
			statement.setString(9, hs.getHotencha());
			statement.setString(10, hs.getHotenme());
			statement.setString(11, hs.getGhichu() 	);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(HoSoHocSinh hs) {
		String sql = "UPDATE hosohocsinh SET mahocsinh= ?, hoten = ? , diachi = ?, dantoc = ?, namsinh = ?, gioitinh = ?, email = ? hotencha = ?, hotenme = ?, ghichu = ? WHERE malop = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, hs.getMahocsinh());
			statement.setString(2, hs.getHoten());
			statement.setString(3, hs.getDiachi());
			statement.setString(4, hs.getDantoc());
			statement.setString(5, hs.getNamsinh());
			statement.setString(6, hs.getGioitinh());
			statement.setString(7, hs.getEmail());
			statement.setString(8, hs.getHotencha());
			statement.setString(9, hs.getHotenme());
			statement.setString(10, hs.getGhichu());
			statement.setString(11, hs.getMalop());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String malop) {
		String sql = "DELETE FROM hosohocsinh WHERE malop = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, malop);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public HoSoHocSinh searchInfor(String malop ) {
		HoSoHocSinh studentinfor = null;
		String sql = "SELECT * FROM hosohocsinh WHERE malop = ?";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, malop);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new HoSoHocSinh();
				studentinfor.setMalop(result.getString("malop"));
				studentinfor.setMahocsinh(result.getInt("mahocsinh"));
				studentinfor.setHoten(result.getString("hoten"));
				studentinfor.setGioitinh(result.getString("gioitinh"));
				studentinfor.setDiachi(result.getString("diachi"));
				studentinfor.setEmail(result.getString("email"));
				studentinfor.setMalop(result.getString("malop"));
				studentinfor.setNamsinh(result.getString("namsinh"));
				studentinfor.setHotencha(result.getString("hotencha"));
				studentinfor.setHotenme(result.getString("hotenme"));
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
