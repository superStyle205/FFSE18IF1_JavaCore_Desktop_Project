package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectUtil.ConnectUtil;

public class HocSinhDao {

	public boolean isLogin(String masinhvien, String tensinhvien, String lop, String nienkhoa, String diemtrungbinh, String Mahs, String Tenhs, String NgaySinhhs, String GioiTinhhs, String Quehs, String Lophs) {
		String sql = "SELECT * FROM hocsinh WHERE Mahs = ? and Tenhs= ? and NgaySinhhs = ? and GioiTinhhs = ? and Quehs = ? and Lophs = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,  Mahs);
			statement.setString(2, Tenhs);
			statement.setString(3, NgaySinhhs);
			statement.setString(4, GioiTinhhs);
			statement.setString(5, Quehs);
			statement.setString(6, Lophs);

			ResultSet result = statement.executeQuery();
			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return false;
	}
	public void addUser(HocSinhDao dao) {
		String sql = "INSERT INTO hocsinh VALUES( ?, ?, ?, ?, ?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dao.get);
			statement.setString(2, dao.getTensinhvien());
			statement.setString(3, dao.getLop());
			statement.setString(4, dao.getNienkhoa());
			statement.setString(5, dao.getDiemtrungbinh());
			

			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

}
