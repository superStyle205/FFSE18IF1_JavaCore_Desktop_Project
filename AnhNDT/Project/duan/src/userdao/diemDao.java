package userdao;


	import giaovien.diem;
import giaovien.giaovien;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import duan.ConnectUtil;

	public class diemDao {
		public ArrayList<diem> getAllUser() {
			String sql = "SELECT * FROM diem";
			ArrayList<diem> listUser = new ArrayList<diem>();

			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();
			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				ResultSet result = statement.executeQuery();

				diem user;
				while (result.next()) {
					user = new diem();
					user.setMaMon(result.getString("maMon"));
					user.setTenMon(result.getString("tenMon"));
					user.setDiemKtrHK1(result.getString("diemKtrHK1"));
					user.setDiemKtrHK2(result.getString("diemKtrHK2"));
					user.setDiemTB(result.getString("diemTB"));
					listUser.add(user);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connectUtil.disconnect(conn);
			}

			return listUser;
		}
		public void addUser(diem user) {
			String sql = "INSERT INTO giaovien VALUES(?,?, ?, ?,?)";
			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, user.getMaMon());
				statement.setString(2, user.getTenMon());
				statement.setString(3, user.getDiemKtrHK1());
				statement.setString(4, user.getDiemKtrHK2());
				statement.setString(5, user.getDiemTB());
				

				statement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connectUtil.disconnect(conn);
			}
		}
		public void updateUser(diem user) {
			String sql = "UPDATE lop SET tenMon = ?, diemKtrHK1= ?, diemKtrHK2= ?, diemTB = ?  WHERE maMon = ?";
		
			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, user.getTenMon());
				statement.setString(2, user.getDiemKtrHK1());
				statement.setString(3, user.getDiemKtrHK2());
				statement.setString(4, user.getDiemTB());
				statement.setString(5, user.getMaMon());
				statement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connectUtil.disconnect(conn);
			}
		}
		
		public void deleteUser(String id) {
			String sql = "DELETE FROM diem WHERE maMon = ?";
			
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
