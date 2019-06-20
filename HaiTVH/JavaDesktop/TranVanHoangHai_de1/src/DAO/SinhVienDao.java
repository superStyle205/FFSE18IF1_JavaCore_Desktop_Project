package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.ConnectUtil;

public class SinhVienDao {


	public ArrayList<SinhVien> getALLSinhVien() {
		
		String sql = " SELECT * FROM sinhvien ";
		ArrayList<SinhVien> listUser = new ArrayList<SinhVien>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			SinhVien sinhvien;
			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setId(result.getString("id"));
				sinhvien.setTen(result.getString("ten"));
				sinhvien.setLop(result.getString("lop"));
				sinhvien.setNienkhoa(result.getString("nienkhoa"));
				sinhvien.setDiem(result.getString("diem"));
				listUser.add(sinhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return listUser;
	}

	public void addSv(SinhVien sinhvien) {
		String sql = " INSERT INTO sinhvien VALUES (?, ?, ?, ?, ?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getId());
			statement.setString(2, sinhvien.getTen());
			statement.setString(3, sinhvien.getLop());
			statement.setString(4, sinhvien.getNienkhoa());
			statement.setString(5, sinhvien.getDiem());

			statement.executeUpdate();
			
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "phải đủ vào giá trị !");
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateSv(SinhVien sinhvien) {
		String sql = "UPDATE sinhvien SET ten = ? , lop = ?, nienkhoa = ?, diem= ? WHERE id = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getTen());
			statement.setString(2, sinhvien.getLop());
			statement.setString(3, sinhvien.getNienkhoa());
			statement.setString(4, sinhvien.getDiem());
			statement.setString(5, sinhvien.getId());
			
			
			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Tên sinh viên không được trùng");
		} finally {
			connectUtil.disconnect(conn);
		}
	}


	public void deleteSv(String sinhvien) {
		String sql = "DELETE FROM sinhvien  WHERE id = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

}
