	package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.database.ConnectData;
import model.bean.Score;

public class ScoreDao {
	public List<Score> getData() {
		String sql = "SELECT * FROM bangdiem";
		List<Score> listData = new ArrayList<Score>();

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			Score score;
			while (result.next()) {
				score = new Score();

				score.setStt(result.getInt("STT"));
				score.setMaHocSinh(result.getString("MaHocSinh"));
				score.setMaMonHoc(result.getString("MaMonHoc"));
				score.setDiemDauNam(result.getString("DiemDauNam"));
				score.setDiemGiuaKy(result.getString("DiemGiuaKy"));
				score.setDiemCuoiKy(result.getString("DiemCuoiKy"));
				score.setDiemTongKet(result.getString("DiemTongKet"));

				listData.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.disconnect(conn);
		}
		return listData;
	}
	
	public void addScore(Score score){
		String sql = "INSERT INTO bangdiem VALUES(NULL, ?, ?, ?, ?, ?, ?)";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, score.getMaHocSinh());
			statement.setString(2, score.getMaMonHoc());
			statement.setString(3, score.getDiemDauNam());
			statement.setString(4, score.getDiemGiuaKy());
			statement.setString(5, score.getDiemCuoiKy());
			statement.setString(6, score.getDiemTongKet());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public void updateScore(Score score){
		String sql = "UPDATE bangdiem SET MaHocSinh = ?, MaMonHoc = ?, DiemDauNam = ?, DiemGiuaKy = ?, DiemCuoiKy = ?, DiemTongKet = ? WHERE STT = ?";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, score.getMaHocSinh());
			statement.setString(2, score.getMaMonHoc());
			statement.setString(3, score.getDiemDauNam());
			statement.setString(4, score.getDiemGiuaKy());
			statement.setString(5, score.getDiemCuoiKy());
			statement.setString(6, score.getDiemTongKet());
			statement.setInt(7, score.getStt());
			
			
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			
		} finally {
			connect.disconnect(conn);
		}
	}
	
	public void deleteScore(String Stt){
		String sql = "DELETE FROM bangdiem WHERE STT = ?";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, Stt);
			statement.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}
	
	public Score searchScore(String Stt){
		Score scorestudent = null;
		String sql = "SELECT * FROM bangdiem WHERE STT = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, Stt);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				scorestudent = new Score();

				scorestudent.setStt(result.getInt("STT"));
				scorestudent.setMaHocSinh(result.getString("MaHocSinh"));
				scorestudent.setMaMonHoc(result.getString("MaMonHoc"));
				scorestudent.setDiemDauNam(result.getString("DiemDauNam"));
				scorestudent.setDiemGiuaKy(result.getString("DiemGiuaKy"));
				scorestudent.setDiemCuoiKy(result.getString("DiemCuoiKy"));
				scorestudent.setDiemTongKet(result.getString("DiemTongKet"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
		
		return scorestudent;
		
	}
}
