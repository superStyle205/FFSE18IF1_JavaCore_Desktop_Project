package school_year;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class NienKhoaDao {
	public boolean Login(String Id_NienKhoa) {
		String sql = "SELECT * FROM nien_khoa WHERE Id_NienKhoa = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_NienKhoa);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<NienKhoa> getAllUser() {
		String sql = "SELECT * FROM nien_khoa";

		List<NienKhoa> listMonHoc = new ArrayList<NienKhoa>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			NienKhoa nienKhoa;
			while (result.next()) {
				nienKhoa = new NienKhoa();
				nienKhoa.setId_NienKhoa(result.getString("Id_NienKhoa"));
				nienKhoa.setSchoolYear(result.getString("SchoolYear"));
				
				listMonHoc.add(nienKhoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listMonHoc;
	}

	public void addUser(NienKhoa nienKhoa) {
		String sql = "INSERT INTO nien_khoa(Id_NienKhoa, SchoolYear) VALUES (?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nienKhoa.getId_NienKhoa());
			statement.setString(2, nienKhoa.getSchoolYear());
			
			statement.executeUpdate();//executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(NienKhoa nienKhoa) {
		String sql = "UPDATE nien_khoa SET SchoolYear = ? WHERE  Id_NienKhoa = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nienKhoa.getSchoolYear());
			statement.setString(2, nienKhoa.getId_NienKhoa());

			statement.executeUpdate();//executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_NienKhoa) {
		String sql = "DELETE FROM nien_khoa WHERE Id_NienKhoa = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);//�?ối tượng đại diện cho 1 câu lệnh SQL 
			statement.setString(1, Id_NienKhoa);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
