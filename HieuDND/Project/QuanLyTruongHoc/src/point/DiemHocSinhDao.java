package point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class DiemHocSinhDao {
	public boolean Login(String Diem) {
		String sql = "SELECT * FROM diem_hoc_sinh WHERE Diem_Mieng = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Diem);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<DiemHocSinh> getAllUser() {
		String sql = "SELECT * FROM diem_hoc_sinh";

		List<DiemHocSinh> listDiem = new ArrayList<DiemHocSinh>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			DiemHocSinh diemHocSinh;
			while (result.next()) {
				diemHocSinh = new DiemHocSinh();
				diemHocSinh.setId_MonHoc(result.getString("Id_MonHoc"));
				diemHocSinh.setId_HocSinh(result.getString("Id_HocSinh"));
				diemHocSinh.setDiem_Mieng(result.getString("Diem_Mieng"));
				diemHocSinh.setDiem15p(result.getString("Diem15p"));
				diemHocSinh.setDiem1Tiet(result.getString("Diem1Tiet"));
				diemHocSinh.setDiemHocKi(result.getString("DiemHocKi"));
				
				listDiem.add(diemHocSinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listDiem;
	}

	public void addUser(DiemHocSinh diemHocSinh) {
		String sql = "INSERT INTO diem_hoc_sinh(Id_MonHoc,Id_HocSinh,Diem_Mieng,Diem15p,Diem1Tiet,DiemHocKi) VALUES (?,?,?,?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, diemHocSinh.getId_MonHoc());
			statement.setString(2, diemHocSinh.getId_HocSinh());
			statement.setString(3, diemHocSinh.getDiem_Mieng());
			statement.setString(4, diemHocSinh.getDiem15p());
			statement.setString(5, diemHocSinh.getDiem1Tiet());
			statement.setString(6, diemHocSinh.getDiemHocKi());
			
			statement.executeUpdate();//executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(DiemHocSinh diemHocSinh) {
		String sql = "UPDATE diem_hoc_sinh SET Id_MonHoc = ?, Id_HocSinh = ?, Diem15p = ?, Diem1Tiet = ?, DiemHocKi = ? WHERE  Diem_Mieng = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, diemHocSinh.getId_MonHoc());
			statement.setString(2, diemHocSinh.getId_HocSinh());
			statement.setString(3, diemHocSinh.getDiem15p());
			statement.setString(4, diemHocSinh.getDiem1Tiet());
			statement.setString(5, diemHocSinh.getDiemHocKi());
			statement.setString(6, diemHocSinh.getDiem_Mieng());

			statement.executeUpdate();//executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Diem_Mieng) {
		String sql = "DELETE FROM diem_hoc_sinh WHERE Diem_Mieng = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);//�?ối tượng đại diện cho 1 câu lệnh SQL 
			statement.setString(1, Diem_Mieng);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}

