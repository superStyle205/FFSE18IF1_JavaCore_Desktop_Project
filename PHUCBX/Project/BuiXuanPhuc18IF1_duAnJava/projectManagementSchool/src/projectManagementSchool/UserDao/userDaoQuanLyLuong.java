package projectManagementSchool.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projectManagementSchool.ConnectUtil.ConnectUtil;
import projectManagementSchool.model.salary;

public class userDaoQuanLyLuong {
	public static List<salary> getAllUser() {
		String sql = "SELECT * FROM luong";
		List<salary> listUser = new ArrayList<salary>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			salary slr;
			while (result.next()) {
				slr = new salary();
				slr.setId(result.getString("id"));
				slr.setMaGiaoVien(result.getString("maGiaoVien"));
				slr.setTenGiaoVien(result.getString("tenGiaoVien"));
				slr.setThang(result.getInt("thang"));
				slr.setHeSoLuong(result.getInt("heSoLuong"));
				slr.setPhuCap(result.getInt("phuCap"));
				slr.setNgayLamViec(result.getInt("soNgayLamViec"));
				slr.setLuongTamUng(result.getInt("luongTamUng"));
				slr.setTienLuong(result.getInt("tienLuong"));
				slr.setTienThuong(result.getInt("tienThuong"));
				slr.setTongLuong(result.getInt("tongluong"));
				slr.setGhiChu(result.getString("ghiChu"));
				listUser.add(slr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listUser;
	}

	public void addUser(salary slr) {
		String sql = "INSERT INTO luong VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, hstl.getId());
			statement.setString(1, slr.getMaGiaoVien());
			statement.setString(2, slr.getTenGiaoVien());
			statement.setInt(3, slr.getThang());
			statement.setInt(4, slr.getHeSoLuong());
			statement.setInt(5, slr.getPhuCap());
			statement.setInt(6, slr.getNgayLamViec());
			statement.setInt(7, slr.getLuongTamUng());
			statement.setInt(8, slr.getTienLuong());
			statement.setInt(9, slr.getTienThuong());
			statement.setInt(10, slr.getTongLuong());
			statement.setString(11, slr.getGhiChu());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateUser(salary slr) {
		String sql = "UPDATE `luong` SET `maGiaoVien`= ?,`tenGiaoVien`= ?,`thang`= ?,`heSoLuong`= ?,`phuCap`= ?,`soNgayLamViec`= ? ,`luongTamUng`= ?,`tienLuong`= ?,`tienThuong`= ?,`tongLuong`= ?,`ghiChu`= ? WHERE id = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, slr.getMaGiaoVien());
			statement.setString(2, slr.getTenGiaoVien());
			statement.setInt(3, slr.getThang());
			statement.setInt(4, slr.getHeSoLuong());
			statement.setInt(5, slr.getPhuCap());
			statement.setInt(6, slr.getNgayLamViec());
			statement.setInt(7, slr.getLuongTamUng());
			statement.setInt(8, slr.getTienLuong());
			statement.setInt(9, slr.getTienThuong());
			statement.setInt(10, slr.getTongLuong());
			statement.setString(11, slr.getGhiChu());
			statement.setString(12, slr.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteUser(String maHocSinh) {
		String sql = "DELETE FROM luong WHERE id = ?";
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
	
	public salary search(String tenGiaoVien){
		salary slr = null;
		String sql = "SELECT * FROM luong WHERE tenGiaoVien = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.getConnect("localhost", "quanly", "root", "");

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, tenGiaoVien);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				slr = new salary();

				slr.setId(result.getString("id"));
				slr.setMaGiaoVien(result.getString("maGiaoVien"));
				slr.setTenGiaoVien(result.getString("tenGiaoVien"));
				slr.setThang(result.getInt("thang"));
				slr.setHeSoLuong(result.getInt("heSoLuong"));
				slr.setPhuCap(result.getInt("phuCap"));
				slr.setNgayLamViec(result.getInt("soNgayLamViec"));
				slr.setLuongTamUng(result.getInt("luongTamUng"));
				slr.setTienLuong(result.getInt("tienLuong"));
				slr.setTienThuong(result.getInt("tienThuong"));
				slr.setTongLuong(result.getInt("tongluong"));
				slr.setGhiChu(result.getString("ghiChu"));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connectUtil.disconnect(conn);
		}
		return slr;
	}
	
}
