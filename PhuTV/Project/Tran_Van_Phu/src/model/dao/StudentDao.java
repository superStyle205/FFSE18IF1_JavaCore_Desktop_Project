package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.database.ConnectData;
import model.bean.Student;

public class StudentDao {

	public List<Student> getData() {
		String sql = "SELECT * FROM hocsinh";
		List<Student> listData = new ArrayList<Student>();

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			Student studentinfor;
			while (result.next()) {
				studentinfor = new Student();

				studentinfor.setMaHocSinh(result.getInt("MaHocSinh"));
				studentinfor.setMaLop(result.getString("MaLop"));
				studentinfor.setHoTen(result.getString("HoTen"));
				studentinfor.setNgaySinh(result.getString("NgaySinh"));
				studentinfor.setGioiTinh(result.getString("GioiTinh"));
				studentinfor.setNoiSinh(result.getString("NoiSinh"));
				studentinfor.setDanToc(result.getString("DanToc"));
				studentinfor.setTonGiao(result.getString("TonGiao"));
				studentinfor.setNienKhoa(result.getString("NienKhoa"));
				studentinfor.setSdtPhuHuynh(result.getString("SdtPhuHuynh"));

				listData.add(studentinfor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.disconnect(conn);
		}

		return listData;

	}

	public void addInfor(Student studentinfor) {
		String sql = "INSERT INTO hocsinh VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, studentinfor.getMaLop());
			statement.setString(2, studentinfor.getHoTen());
			statement.setString(3, studentinfor.getNgaySinh());
			statement.setString(4, studentinfor.getGioiTinh());
			statement.setString(5, studentinfor.getNoiSinh());
			statement.setString(6, studentinfor.getDanToc());
			statement.setString(7, studentinfor.getTonGiao());
			statement.setString(8, studentinfor.getNienKhoa());
			statement.setString(9, studentinfor.getSdtPhuHuynh());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}

	public void updateInfor(Student studentinfor) {
		String sql = "UPDATE hocsinh SET MaLop = ?, HoTen = ?, NgaySinh = ?, GioiTinh = ?, NoiSinh = ?, DanToc = ?, TonGiao = ?, NienKhoa = ?, SdtPhuHuynh = ? WHERE MaHocSinh = ?";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, studentinfor.getMaLop());
			statement.setString(2, studentinfor.getHoTen());
			statement.setString(3, studentinfor.getNgaySinh());
			statement.setString(4, studentinfor.getGioiTinh());
			statement.setString(5, studentinfor.getNoiSinh());
			statement.setString(6, studentinfor.getDanToc());
			statement.setString(7, studentinfor.getTonGiao());
			statement.setString(8, studentinfor.getNienKhoa());
			statement.setString(9, studentinfor.getSdtPhuHuynh());
			statement.setInt(10, studentinfor.getMaHocSinh());

			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}

	public void deleteInfor(String maHocSinh) {
		String sql = "DELETE FROM hocsinh WHERE MaHocSinh = ?";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maHocSinh);
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
	}

	public Student searchInfor(String maHocSinh) {
		Student studentinfor = null;
		String sql = "SELECT * FROM hocsinh WHERE MaHocSinh = ?";

		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maHocSinh);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				studentinfor = new Student();

				studentinfor.setMaHocSinh(result.getInt("MaHocSinh"));
				studentinfor.setMaLop(result.getString("MaLop"));
				studentinfor.setHoTen(result.getString("HoTen"));
				studentinfor.setNgaySinh(result.getString("NgaySinh"));
				studentinfor.setGioiTinh(result.getString("GioiTinh"));
				studentinfor.setNoiSinh(result.getString("NoiSinh"));
				studentinfor.setDanToc(result.getString("DanToc"));
				studentinfor.setTonGiao(result.getString("TonGiao"));
				studentinfor.setNienKhoa(result.getString("NienKhoa"));
				studentinfor.setSdtPhuHuynh(result.getString("SdtPhuHuynh"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
		return studentinfor;
	}
	
	
}
