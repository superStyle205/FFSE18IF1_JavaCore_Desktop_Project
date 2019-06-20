package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.hoSoHocSinh;

public class userDaoQuanLyHoSoHocSinh {
	public static List<hoSoHocSinh> getAllUser() {
		String sql = "SELECT * FROM hosohocsinh";
		List<hoSoHocSinh> listUser = new ArrayList<hoSoHocSinh>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			hoSoHocSinh hshs;
			while (result.next()) {
				hshs = new hoSoHocSinh();
				hshs.setId(result.getString("id"));
				hshs.setMaLop(result.getString("maLop"));
				hshs.setMaHocSinh(result.getString("maHocSinh"));
				hshs.setTenHocSinh(result.getString("tenHocSinh"));
				hshs.setGioiTinh(result.getString("gioiTinh"));
				hshs.setNgaySinh(result.getString("ngaySinh"));
				hshs.setNoiSinh(result.getString("noiSinh"));
				hshs.setDiaChi(result.getString("diaChi"));
				hshs.setEmail(result.getString("Email"));
				hshs.setHoTenBo(result.getString("hoTenBo"));
				hshs.setHoTenMe(result.getString("hoTenMe"));
				hshs.setSoDienThoai(result.getString("SoDienThoai"));
				hshs.setGhiChu(result.getString("ghiChu"));
				listUser.add(hshs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public static void addUser(hoSoHocSinh hshs) {
		String sql = "INSERT INTO hosohocsinh VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
//			statement.setString(1, hshs.getId());
			statement.setString(1, hshs.getMaLop());
			statement.setString(2, hshs.getMaHocSinh());
			statement.setString(3, hshs.getTenHocSinh());
			statement.setString(4, hshs.getGioiTinh());
			statement.setString(5, hshs.getNgaySinh());
			statement.setString(6, hshs.getNoiSinh());
			statement.setString(7, hshs.getDiaChi());
			statement.setString(8, hshs.getEmail());
			statement.setString(9, hshs.getHoTenBo());
			statement.setString(10, hshs.getHoTenMe());
			statement.setString(11, hshs.getSoDienThoai());
			statement.setString(12, hshs.getGhiChu());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void updateUser(hoSoHocSinh hshs) {
		String sql = "UPDATE hosohocsinh SET maLop = ?,maHocSinh = ?, tenHocSinh = ?, gioiTinh = ?, ngaySinh = ?, noiSinh = ?, diaChi = ?,Email = ?,hoTenBo = ?,hoTenMe = ?,soDienThoai = ?, ghiChu = ? WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, hshs.getMaLop());
			statement.setString(2, hshs.getMaHocSinh());
			statement.setString(3, hshs.getTenHocSinh());
			statement.setString(4, hshs.getGioiTinh());
			statement.setString(5, hshs.getNgaySinh());
			statement.setString(6, hshs.getNoiSinh());
			statement.setString(7, hshs.getDiaChi());
			statement.setString(8, hshs.getEmail());
			statement.setString(9, hshs.getHoTenBo());
			statement.setString(10, hshs.getHoTenMe());
			statement.setString(11, hshs.getSoDienThoai());
			statement.setString(12, hshs.getGhiChu());
			statement.setString(13, hshs.getId());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void deleteUser(String maHocSinh) {
		String sql = "DELETE FROM hosohocsinh WHERE id = ?";
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
