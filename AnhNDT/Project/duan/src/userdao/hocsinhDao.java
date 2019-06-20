package userdao;



import giaovien.hocsinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import duan.ConnectUtil;

public class hocsinhDao {
	public ArrayList<hocsinh> getAllUser() {
		String sql = "SELECT * FROM hocsinh";
		ArrayList<hocsinh> listUser = new ArrayList<hocsinh>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			hocsinh user;
			while (result.next()) {
				user = new hocsinh();
				user.setMa(result.getString("maHocSinh"));
				user.setTen(result.getString("ten"));
				user.setTuoi(result.getString("tuoi"));
				user.setSdt(result.getString("sdt"));
				user.setDiaChi(result.getString("diaChi"));
				user.setEmail(result.getString("email"));
				
				listUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}
	public void addUser(hocsinh user) {
		String sql = "INSERT INTO lop VALUES(?,?, ?, ?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getMa());
			statement.setString(2, user.getTen());
			statement.setString(3, user.getTuoi());
			statement.setString(4, user.getSdt());
			statement.setString(5, user.getDiaChi());
			statement.setString(6, user.getEmail());
			
			

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	public void updateUser(hocsinh user) {
		String sql = "UPDATE lop SET ten = ?, tuoi= ?, sdt = ?, diaChinh = ?, email= ?  WHERE maHocSinh = ?";
	
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getTen());
			statement.setString(2, user.getTuoi());
			statement.setString(3, user.getSdt());
			statement.setString(4, user.getDiaChi());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getMa());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteUser(String id) {
		String sql = "DELETE FROM hocsinh WHERE malop = ?";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
