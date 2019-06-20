package summary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class TongKetDao {
	public boolean Login(String Id_HocSinh, String ClassName) {
		String sql = "SELECT * FROM tongket WHERE Id_HocSinh = ? and ClassName = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_HocSinh);
			statement.setString(2, ClassName);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<TongKet> getAllUser() {
		String sql = "SELECT * FROM tongket";

		List<TongKet> listTongKet = new ArrayList<TongKet>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			TongKet tk;
			while (result.next()) {
				tk = new TongKet();
				
				tk.setId_HocSinh(result.getString("Id_HocSinh"));
				tk.setFirstName(result.getString("FirstName"));
				tk.setLastName(result.getString("LastName"));
				tk.setId_Lop(result.getString("Id_Lop"));
				tk.setStudyCapacity_Semester1(result.getString("StudyCapacity_Semester1"));
				tk.setConduct_Semester2(result.getString("Conduct_Semester1"));
				tk.setStudyCapacity_Semester2(result.getString("StudyCapacity_Semester2"));
				tk.setConduct_Semester1(result.getString("Conduct_Semester2"));
				tk.setStudyCapacity_WholeYear(result.getString("StudyCapacity_WholeYear"));
				tk.setConduct_WholeYear(result.getString("Conduct_WholeYear"));
				tk.setId_NienKhoa(result.getString("Id_NienKhoa"));
				
				listTongKet.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listTongKet;
	}

	public void addUser(TongKet tk) {
		String sql = "INSERT INTO tongket(Id_HocSinh,FirstName,LastName,Id_Lop,StudyCapacity_Semester1,Conduct_Semester1,StudyCapacity_Semester2,Conduct_Semester2,StudyCapacity_WholeYear,Conduct_WholeYear,Id_NienKhoa) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tk.getId_HocSinh());
			statement.setString(2, tk.getFirstName());
			statement.setString(3, tk.getLastName());
			statement.setString(4, tk.getId_Lop());
			statement.setString(5, tk.getStudyCapacity_Semester1());
			statement.setString(6, tk.getConduct_Semester1());
			statement.setString(7, tk.getStudyCapacity_Semester2());
			statement.setString(8, tk.getConduct_Semester2());
			statement.setString(9, tk.getStudyCapacity_WholeYear());
			statement.setString(10, tk.getConduct_WholeYear());
			statement.setString(11, tk.getId_NienKhoa());
			

			statement.executeUpdate();// executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(TongKet tongket) {
		String sql = "UPDATE tongket SET FirstName = ?, LastName = ?, Id_Lop = ?, StudyCapacity_Semester1 = ?, Conduct_Semester1 = ?, StudyCapacity_Semester2 = ?, Conduct_Semester2 = ?, StudyCapacity_WholeYear = ?, Conduct_WholeYear = ?, SchoolYear = ? WHERE  Id_HocSinh = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tongket.getFirstName());
			statement.setString(2, tongket.getLastName());
			statement.setString(3, tongket.getId_Lop());
			statement.setString(4, tongket.getStudyCapacity_Semester1());
			statement.setString(5, tongket.getConduct_Semester1());
			statement.setString(6, tongket.getStudyCapacity_Semester2());
			statement.setString(7, tongket.getConduct_Semester2());
			statement.setString(8, tongket.getStudyCapacity_WholeYear());
			statement.setString(9, tongket.getConduct_WholeYear());
			statement.setString(10, tongket.getId_NienKhoa());
			statement.setString(11, tongket.getId_HocSinh());

			statement.executeUpdate();// executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_HocSinh) {
		String sql = "DELETE FROM tongket WHERE Id_HocSinh = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);// �?ối tượng đại diện cho 1 câu lệnh SQL
			statement.setString(1, Id_HocSinh);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
