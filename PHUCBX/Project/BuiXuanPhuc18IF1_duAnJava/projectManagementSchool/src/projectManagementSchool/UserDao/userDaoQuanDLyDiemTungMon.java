package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.diemTungMon;

public class userDaoQuanDLyDiemTungMon {
	
	public List<diemTungMon> getAllUser() {
		String sql = "SELECT * FROM diemtungmonhoc";
		List<diemTungMon> listUser = new ArrayList<diemTungMon>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			diemTungMon dtm;
			while (result.next()) {
				dtm = new diemTungMon();

				dtm.setId(result.getString("id"));
				dtm.setMaLop(result.getString("maLop"));
				dtm.setMaMon(result.getString("maMonHoc"));
				dtm.setMaHocKi(result.getString("maHocKi"));
				dtm.setMaHocSinh(result.getString("maHocSinh"));
				dtm.setTenHocSinh(result.getString("tenHocSinh"));
				dtm.setMieng(result.getString("Mieng"));
				dtm.setDiem15pLan1(result.getString("diem15pLan1"));
				dtm.setDiem15pLan2(result.getString("diem15pLan2"));
				dtm.setDiem1Tiet(result.getString("diem1Tiet"));
				dtm.setDiemHocKi(result.getString("diemHocKi"));
				dtm.setGhiChu(result.getString("ghiChu"));
				listUser.add(dtm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public void addUser(diemTungMon dtm) {
		String sql = "INSERT INTO diemtungmonhoc VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

//			statement.setString(1, dtm.getId());
			statement.setString(1, dtm.getMaLop());
			statement.setString(2, dtm.getMaMon());
			statement.setString(3, dtm.getMaHocKi());
			statement.setString(4, dtm.getMaHocSinh());
			statement.setString(5, dtm.getTenHocSinh());
			statement.setString(6, dtm.getMieng());
			statement.setString(7, dtm.getDiem15pLan1());
			statement.setString(8, dtm.getDiem15pLan2());
			statement.setString(9, dtm.getDiem1Tiet());
			statement.setString(10, dtm.getDiemHocKi());
			statement.setString(11, dtm.getGhiChu());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateUser(diemTungMon dtm) {
		String sql = "UPDATE diemtungmonhoc SET maLop = ?, maMonHoc = ?, maHocKi = ?, maHocSinh = ?, tenHocSinh = ?, Mieng = ?, diem15pLan1 = ?, diem15pLan2 = ?,diem1Tiet = ?, diemHocKi = ?, ghiChu = ? WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, dtm.getMaLop());
			statement.setString(2, dtm.getMaMon());
			statement.setString(3, dtm.getMaHocKi());
			statement.setString(4, dtm.getMaHocSinh());
			statement.setString(5, dtm.getTenHocSinh());
			statement.setString(6, dtm.getMieng());
			statement.setString(7, dtm.getDiem15pLan1());
			statement.setString(8, dtm.getDiem15pLan2());
			statement.setString(9, dtm.getDiem1Tiet());
			statement.setString(10, dtm.getDiemHocKi());
			statement.setString(11, dtm.getGhiChu());
			statement.setString(12, dtm.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteUser(String maHocSinh) {
		String sql = "DELETE FROM diemtungmonhoc WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maHocSinh);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
}
