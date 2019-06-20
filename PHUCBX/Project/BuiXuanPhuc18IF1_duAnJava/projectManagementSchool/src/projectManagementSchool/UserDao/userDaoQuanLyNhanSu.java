package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.giangVien;

public class userDaoQuanLyNhanSu {
	public static List<giangVien> getAllUser() {
		String sql = "SELECT * FROM giaovien";
		List<giangVien> listUser = new ArrayList<giangVien>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			giangVien gv;
			while (result.next()) {
				gv = new giangVien();
				
				gv.setId(result.getString("id"));
				gv.setMaPB(result.getString("maPhongBan"));
				gv.setMaNV(result.getString("maNhanVien"));
				gv.setTenNV(result.getString("tenNhanVien"));
				gv.setChucVu(result.getString("chucVu"));
				gv.setNgaySinh(result.getString("ngaySinh"));
				gv.setDiaChi(result.getString("diaChi"));
				gv.setDanToc(result.getString("danToc"));
				gv.setTonGiao(result.getString("tonGiao"));
				gv.setNgayVaoLam(result.getString("ngayVaoLamViec"));
				gv.setQueQuan(result.getString("queQuan"));
				gv.setNguyenQuan(result.getString("nguyenQuan"));
				gv.setSoDienThoai(result.getString("SoDienThoai"));
				gv.setEmail(result.getString("Email"));
				gv.setGhiChu(result.getString("ghiChu"));
				listUser.add(gv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public static void addUser(giangVien gv) {
		String sql = "INSERT INTO giaovien VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, gv.getId());
			statement.setString(1, gv.getMaPB());
			statement.setString(2, gv.getMaNV());
			statement.setString(3, gv.getTenNV());
			statement.setString(4, gv.getChucVu());
			statement.setString(5, gv.getNgaySinh());
			statement.setString(6, gv.getDiaChi());
			statement.setString(7, gv.getDanToc());
			statement.setString(8, gv.getTonGiao());
			statement.setString(9, gv.getNgayVaoLam());
			statement.setString(10, gv.getQueQuan());
			statement.setString(11, gv.getNguyenQuan());
			statement.setString(12, gv.getSoDienThoai());
			statement.setString(13, gv.getEmail());
			statement.setString(14, gv.getGhiChu());
			

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void updateUser(giangVien gv) {
		String sql = "UPDATE giaovien SET maPhongBan = ?,maNhanVien = ?, tenNhanVien = ?, chucVu = ?, ngaySinh = ?, diaChi = ?, danToc = ?, tonGiao = ?, ngayVaoLamViec = ?, queQuan = ?, nguyenQuan = ?, SoDienThoai = ?, Email = ?, ghiChu = ?   WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, gv.getMaPB());
			statement.setString(2, gv.getMaNV());
			statement.setString(3, gv.getTenNV());
			statement.setString(4, gv.getChucVu());
			statement.setString(5, gv.getNgaySinh());
			statement.setString(6, gv.getDiaChi());
			statement.setString(7, gv.getDanToc());
			statement.setString(8, gv.getTonGiao());
			statement.setString(9, gv.getNgayVaoLam());
			statement.setString(10, gv.getQueQuan());
			statement.setString(11, gv.getNguyenQuan());
			statement.setString(12, gv.getSoDienThoai());
			statement.setString(13, gv.getEmail());
			statement.setString(14, gv.getGhiChu());
			statement.setString(15, gv.getId());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public static void deleteUser(String maNhanVien) {
		String sql = "DELETE FROM giaovien WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maNhanVien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

}
