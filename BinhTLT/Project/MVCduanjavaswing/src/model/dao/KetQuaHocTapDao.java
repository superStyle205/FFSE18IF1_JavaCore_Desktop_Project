package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.ConnectionUntil;
import model.bean.HocSinh;
import model.bean.KetQuaHocTap;

public class KetQuaHocTapDao {
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

	public ArrayList<KetQuaHocTap> getAllUser() {
		String sql = "SELECT * FROM ketquahoctap";
		ArrayList<KetQuaHocTap> listkq = new ArrayList<KetQuaHocTap>();

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			KetQuaHocTap hs;
			while (result.next()) {
				hs = new KetQuaHocTap();
				hs.setMahocsinh(result.getInt("mahocsinh"));
				hs.setMalop(result.getString("malop"));
				hs.setHoten(result.getString("hoten"));
				hs.setHocluc(result.getString("hocluc"));
				hs.setHanhkiem(result.getString("hanhkiem"));
				hs.setDiemtrungbinh(result.getString("diemtrungbinh"));
				hs.setXeploai(result.getString("xeploai"));
				hs.setTennienkhoa(result.getString("tennienkhoa"));
				listkq.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
		return listkq;

	}

	public void addUser(KetQuaHocTap kq) {

		String sql = "INSERT INTO ketquahocsinh VALUES (?,?,?,?,?,?,?,?)";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, kq.getMahocsinh());
			statement.setString(2, kq.getMalop());
			statement.setString(3, kq.getHoten());
			statement.setString(4, kq.getHocluc());
			statement.setString(5, kq.getHanhkiem());
			statement.setString(6, kq.getDiemtrungbinh());
			statement.setString(7, kq.getXeploai());
			statement.setString(8, kq.getTennienkhoa());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void updateUser(KetQuaHocTap kq) {
		String sql = "UPDATE ketquahoctap SET malop= ?, hoten = ? ,hocluc = ?, hanhkiem = ?, hanhkiem = ?, diemtrungbinh = ?, xeploai = ?, tennienkhoa = ? WHERE mahocsinh = ? ";

		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kq.getMalop());
			statement.setString(2, kq.getHoten());
			statement.setString(3, kq.getHocluc());
			statement.setString(4, kq.getHanhkiem());
			statement.setString(5, kq.getDiemtrungbinh());
			statement.setString(6, kq.getXeploai());
			statement.setString(7, kq.getTennienkhoa());
			statement.setInt(8, kq.getMahocsinh());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connnect.disconnect(conn);
		}
	}

	public void deleteUser(String mahocsinh) {
		String sql = "DELETE FROM ketquahoctap WHERE mahocsinh = ?";
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

}
