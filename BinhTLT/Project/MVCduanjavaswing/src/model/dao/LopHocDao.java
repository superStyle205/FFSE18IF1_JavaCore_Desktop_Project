package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.Lop;
import model.bean.MonHoc;

public class LopHocDao {
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

	public ArrayList<Lop> getAllUser() {
		String sql = "SELECT * FROM lophoc";
		ArrayList<Lop> lsitlop = new ArrayList<Lop>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Lop lop;
			while (result.next()) {
				lop = new Lop();
				lop.setMalop(result.getString("malop"));
				lop.setTenlop(result.getString("tenlop"));
				lop.setGvchu_nghiem(result.getString("gvchu_nghiem"));
				lop.setMakhoa(result.getString("makhoa"));
				lop.setMakhoi(result.getString("makhoi"));
				lop.setTennienkhoa(result.getString("tennienkhoa"));
				

				lsitlop.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return lsitlop;

	}

	public void addUser(Lop lop) {

		String sql = "INSERT INTO lophoc VALUES (?,?,?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getMalop());
			statement.setString(2, lop.getTenlop());
			statement.setString(3, lop.getGvchu_nghiem());
			statement.setString(4, lop.getMakhoa());
			statement.setString(5, lop.getMakhoi());
			statement.setString(6, lop.getTennienkhoa());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(Lop lop) {
		String sql = "UPDATE lophoc SET tenlop= ?, gvchu_nghiem = ?, makhoa = ?, makhoi = ?, tennienkhoa = ? WHERE malop = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getTenlop() );
			statement.setString(2, lop.getGvchu_nghiem());
			statement.setString(3, lop.getMakhoa());
			statement.setString(4, lop.getMakhoi());
			statement.setString(5, lop.getTennienkhoa());
			statement.setString(6, lop.getMalop());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String malop) {
		String sql = "DELETE FROM lophoc WHERE malop = ?";
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

	
	public Lop searchInfor(String malop ) {
	Lop studentinfor = null;
		String sql = "SELECT * FROM lophoc WHERE malop = ?";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, malop);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new Lop();

				studentinfor.setTenlop(result.getString("tenlop"));
				studentinfor.setGvchu_nghiem(result.getString("gvchu_nghiem"));
				studentinfor.setMakhoa(result.getString("makhoa"));
				studentinfor.setMakhoi(result.getString("makhoi"));
				studentinfor.setTennienkhoa(result.getString("tennienkhoa"));
			
				
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return studentinfor;
	}

}
