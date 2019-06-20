import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

	public boolean isLogin(String masinhvien, String tensinhvien, String lop, String nienkhoa, String diemtrungbinh) {
		String sql = "SELECT * FROM quanlysinhvien WHERE masinhvien = ? and tensinhvien= ? and lop = ? and nienkhoa = ? and diemtrungbinh = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, masinhvien);
			statement.setString(2, tensinhvien);
			statement.setString(3, lop);
			statement.setString(4, nienkhoa);
			statement.setString(5, diemtrungbinh);

			ResultSet result = statement.executeQuery();
			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return false;
	}

	public static ArrayList<User> getAllUser() {
		String sql = "SELECT * FROM quanlysinhvien";
		ArrayList<User> listqlsv = new ArrayList<User>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			User user;

			while (result.next()) {
				user = new User();

				user.setMasinhvien(result.getString("MaSinhVien"));
				user.setTensinhvien(result.getString("TenSinhVien"));
				user.setLop(result.getString("Lop"));
				user.setNienkhoa(result.getString("NienKhoa"));
				user.setDiemtrungbinh(result.getString("DiemTrungBinh"));

				listqlsv.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listqlsv;

	}
	public void addUser(User user) {
		String sql = "INSERT INTO quanlysinhvien VALUES( ?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getMasinhvien());
			statement.setString(2, user.getTensinhvien());
			statement.setString(3, user.getLop());
			statement.setString(4, user.getNienkhoa());
			statement.setString(5, user.getDiemtrungbinh());
			

			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteUser(String MaSinhVien) {
		String sql = "DELETE FROM quanlysinhvien WHERE MaSinhVien = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, MaSinhVien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		
	}

	public void updateUser(User user) {
		String sql = "UPDATE quanlysinhvien SET  tensinhvien = ?, lop = ?, nienkhoa = ?, diemtrungbinh = ? WHERE masinhvien = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getTensinhvien());
			statement.setString(2, user.getLop());
			statement.setString(3, user.getNienkhoa());
			statement.setString(4, user.getDiemtrungbinh());
			statement.setString(5, user.getMasinhvien());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		
	}
	
	
	
	
	

}
