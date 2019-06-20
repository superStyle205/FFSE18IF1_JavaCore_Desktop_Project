package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class HocSinhDao {
	public boolean Login(String Id_HocSinh, String Age) {
		String sql = "SELECT * FROM hocsinh WHERE Id_HocSinh = ? AND Age = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_HocSinh);
			statement.setString(2, Age);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<HocSinh> getAllUser() {
		String sql = "SELECT * FROM hocsinh";

		List<HocSinh> listHocSinh = new ArrayList<HocSinh>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			HocSinh hs;
			while (result.next()) {
				hs = new HocSinh();
				hs.setId_HocSinh(result.getString("Id_HocSinh"));
				hs.setFirstName(result.getString("FirstName"));
				hs.setLastName(result.getString("LastName"));
				hs.setAge(result.getInt("Age"));
				hs.setAddress(result.getString("Address"));
				hs.setSex(result.getString("Sex"));
				hs.setBirth(result.getString("Birth"));
				hs.setNumberPhone(result.getString("NumberPhone"));
				hs.setEmail(result.getString("Email"));
				hs.setAbsence(result.getInt("Absence"));
				hs.setId_Lop(result.getString("Id_Lop"));
				
				listHocSinh.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listHocSinh;
	}

	public void addUser(HocSinh hs) {
		String sql = "INSERT INTO hocsinh(Id_HocSinh,FirstName,LastName,Age,Address,Sex,Birth,NumberPhone,Email,Absence,Id_Lop) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getId_HocSinh());
			statement.setString(2, hs.getFirstName());
			statement.setString(3, hs.getLastName());
			statement.setInt(4, hs.getAge());
			statement.setString(5, hs.getAddress());
			statement.setString(6, hs.getSex());
			statement.setString(7, hs.getBirth());
			statement.setString(8, hs.getNumberPhone());
			statement.setString(9, hs.getEmail());
			statement.setInt(10, hs.getAbsence());
			statement.setString(11, hs.getId_Lop());
			
			statement.executeUpdate();//executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(HocSinh hs) {
		String sql = "UPDATE hocsinh SET FirstName = ?, LastName = ?, Age = ?, Address = ?, Sex = ?, Birth = ?, NumberPhone = ?, Email = ?, Absence = ?, Id_Lop = ?  WHERE  Id_HocSinh = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hs.getFirstName());
			statement.setString(2, hs.getLastName());
			statement.setInt(3, hs.getAge());
			statement.setString(4, hs.getAddress());
			statement.setString(5, hs.getSex());
			statement.setString(6, hs.getBirth());
			statement.setString(7, hs.getNumberPhone());
			statement.setString(8, hs.getEmail());
			statement.setInt(9, hs.getAbsence());
			statement.setString(10, hs.getId_Lop());
			statement.setString(11, hs.getId_HocSinh());

			statement.executeUpdate();//executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_HocSinh) {
		String sql = "DELETE FROM quanlyhocsinh WHERE Id_HocSinh = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);//�?ối tượng đại diện cho 1 câu lệnh SQL 
			statement.setString(1, Id_HocSinh);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

}

