package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.database.ConnectData;
import model.bean.Subject;

public class SubjectDao {
	public List<Subject> getData() {
		String sql = "SELECT * FROM monhoc";
		List<Subject> listData = new ArrayList<Subject>();

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			Subject subject;
			while (result.next()) {
				subject = new Subject();

				subject.setMaMonHoc(result.getInt("MaMonHoc"));
				subject.setTenMonHoc(result.getString("TenMonHoc"));

				listData.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.disconnect(conn);
		}
		return listData;

	}

	public void addSubject(Subject subject) {
		String sql = "INSERT INTO monhoc VALUES(NULL, ?)";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, subject.getTenMonHoc());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}

	public void updateSubject(Subject subject) {
		String sql = "UPDATE monhoc SET TenMonHoc = ? WHERE MaMonHoc = ?";
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, subject.getTenMonHoc());
			statement.setInt(2, subject.getMaMonHoc());

			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}

	public void deleteSubject(String maMonHoc) {
		String sql = "DELETE FROM monhoc WHERE MaMonHoc = ?";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maMonHoc);
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public Subject searchSubject(String maMonHoc){
		Subject subject = null;
		String sql = "SELECT * FROM monhoc WHERE MaMonHoc = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maMonHoc);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				subject = new Subject();

				subject.setMaMonHoc(result.getInt("MaMonHoc"));
				subject.setTenMonHoc(result.getString("TenMonHoc"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
		
		return subject;
		
	}
}
