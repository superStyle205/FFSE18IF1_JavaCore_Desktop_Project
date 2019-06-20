package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.GiaoVien;
import model.bean.HocSinh;
import model.bean.MonHoc;

public class MonHocDao {
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

	public boolean isLogin(String mamonhoc, String tenmonhoc, int magiaovien, String sotietday) {
		String sql = "SELECT * FROM monhoc WHERE mamonhoc = ? and tenmonhoc = ? and magiaovien = ? and sotietday = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, mamonhoc);
			stsm.setString(2, tenmonhoc);
			stsm.setInt(3, magiaovien);
			stsm.setString(4, sotietday);
			ResultSet result = stsm.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return false;
	}

	public ArrayList<MonHoc> getAllUser() {
		String sql = "SELECT * FROM monhoc";
		ArrayList<MonHoc> lsitMH = new ArrayList<MonHoc>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			MonHoc mh;
			while (result.next()) {
				mh = new MonHoc();
				mh.setMamon(result.getString("mamon"));
				mh.setTenmonhoc(result.getString("tenmonhoc"));
				mh.setMagiaovien(result.getInt("magiaovien"));
				mh.setSotietday(result.getString("sotietday"));

				lsitMH.add(mh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return lsitMH;

	}

	public void addUser(MonHoc mh) {

		String sql = "INSERT INTO monhoc VALUES (?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mh.getMamon());
			statement.setString(2, mh.getTenmonhoc());
			statement.setInt(3, mh.getMagiaovien());
			statement.setString(4, mh.getSotietday());
			
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(MonHoc mh) {
		String sql = "UPDATE monhoc SET tenmonhoc= ?, magiaovien = ?, sotietday = ? WHERE mamonhoc = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mh.getTenmonhoc() );
			statement.setInt(2, mh.getMagiaovien());
			statement.setString(3, mh.getSotietday());
			statement.setString(4, mh.getMamon());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String mamon) {
		String sql = "DELETE FROM monhoc WHERE mamon = ?";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, mamon);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	
	public MonHoc searchInfor(String mamon ) {
		MonHoc studentinfor = null;
		String sql = "SELECT * FROM monhoc WHERE mamon = ?";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mamon);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new MonHoc();

				studentinfor.setMagiaovien(result.getInt("magiaovien"));
				studentinfor.setMamon(result.getString("mamonhoc"));
				studentinfor.setTenmonhoc(result.getString("tenmonhoc"));
				studentinfor.setSotietday(result.getString("sotietday"));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return studentinfor;
	}
}
