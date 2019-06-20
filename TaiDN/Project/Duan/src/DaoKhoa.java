import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoKhoa {
	public ArrayList<Khoa> getAlluser(){
		ArrayList<Khoa> listkhoa = new ArrayList<Khoa>();
		String sqlKhoa = "SELECT * FROM khoa";
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();
		
		try {
			PreparedStatement ss = sc.prepareStatement(sqlKhoa);
			ResultSet resultSet = ss.executeQuery();
			while (resultSet.next()) {
				Khoa khoa = new Khoa();
				khoa.setMakhoa(resultSet.getString("makhoa"));
				khoa.setTenkhoa(resultSet.getString("tenkhoa"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listkhoa;
	} 
	
	public void AddKhoa(Khoa khoa) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlKhoa = "INSERT INTO khoa(makhoa,tenkhoa) VALUES (?,?)";
		try {
			PreparedStatement khoasv = conn.prepareStatement(sqlKhoa);
			khoasv.setString(1, khoa.getMakhoa());
			khoasv.setString(2, khoa.getTenkhoa());
			khoasv.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void UpdateKhoa (Khoa khoa) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlKhoa = "UPDATE khoa SET tenkhoa=? WHERE makhoa=?";
		try {
			PreparedStatement khoasv = conn.prepareStatement(sqlKhoa);
			khoasv.setString(1, khoa.getTenkhoa());
			khoasv.setString(2, khoa.getMakhoa());
			khoasv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeleteKhoa(String makhoa) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlKhoa = "DELETE FROM khoa WHERE makhoa=?";
		try {
			PreparedStatement khoasv = conn.prepareStatement(sqlKhoa);
			khoasv.setString(1, makhoa);
			khoasv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
