package subjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class MonHocDao {
	public boolean Login(String Id_MonHoc,String Ten_Mon) {
		String sql = "SELECT * FROM mon_hoc WHERE Id_MonHoc = ?, Ten_Mon = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_MonHoc);
			statement.setString(2, Ten_Mon);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<MonHoc> getAllUser() {
		String sql = "SELECT * FROM mon_hoc";

		List<MonHoc> listMonHoc = new ArrayList<MonHoc>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			MonHoc monHoc;
			while (result.next()) {
				monHoc = new MonHoc();
				
				monHoc.setId_MonHoc(result.getString("Id_MonHoc"));
				monHoc.setTen_Mon(result.getString("Ten_Mon"));
				monHoc.setId_GiaoVien(result.getString("Id_GiaoVien"));
				
				listMonHoc.add(monHoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listMonHoc;
	}

	public void addUser(MonHoc monHoc) {
		String sql = "INSERT INTO mon_hoc(Id_MonHoc,Ten_Mon,Id_GiaoVien) VALUES (?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getId_MonHoc());
			statement.setString(2, monHoc.getTen_Mon());
			statement.setString(3, monHoc.getId_GiaoVien());
			
			statement.executeUpdate();//executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(MonHoc monHoc) {
		String sql = "UPDATE mon_hoc SET Ten_Mon = ?, Id_GiaoVien = ? WHERE  Id_MonHoc = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getTen_Mon());
			statement.setString(2, monHoc.getId_GiaoVien());
			statement.setString(3, monHoc.getId_MonHoc());

			statement.executeUpdate();//executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_MonHoc) {
		String sql = "DELETE FROM mon_hoc WHERE Id_MonHoc = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);//�?ối tượng đại diện cho 1 câu lệnh SQL 
			statement.setString(1, Id_MonHoc);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
