import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoGiangVien {
	public ArrayList<GiangVien> getAlluser(){
		ArrayList<GiangVien> listgiangvien = new ArrayList<GiangVien>();
		String sqlGiangVien = "SELECT * FROM giangvien";
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();
		
		try {
			PreparedStatement ss = sc.prepareStatement(sqlGiangVien);
			ResultSet resultSet = ss.executeQuery();
			while (resultSet.next()) {
				GiangVien gv = new GiangVien();
				gv.setMagv(resultSet.getString("magv"));
				gv.setTengv(resultSet.getString("tengv"));
				gv.setGioitinh(resultSet.getString("gioitinh"));
				gv.setPhone(resultSet.getString("phone"));
				gv.setEmail(resultSet.getString("email"));
				gv.setPhanloaigv(resultSet.getString("phanloaigv"));
				listgiangvien.add(gv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return listgiangvien;
		
	}
	public void AddGiangvien(GiangVien giangvien) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlGiagvien = "INSERT INTO giangvien(magv,tengv,gioitinh,phone,email,phanloaigv) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement giangviensv = conn.prepareStatement(sqlGiagvien);
			giangviensv.setString(1, giangvien.getMagv());
			giangviensv.setString(2, giangvien.getTengv());
			giangviensv.setString(3, giangvien.getGioitinh());
			giangviensv.setString(4, giangvien.getPhone());
			giangviensv.setString(5, giangvien.getEmail());
			giangviensv.setString(6, giangvien.getPhanloaigv());
			giangviensv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	public void UpdateGiangvien(GiangVien giangvien) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlGiangvien = "UPDATE giangvien SET tengv = ? , gioitinh=? , phone = ? , email = ? , phanloaigv =? WHERE magv = ?";
		try {
			PreparedStatement giangviensv = conn.prepareStatement(sqlGiangvien);
			giangviensv.setString(1, giangvien.getTengv());
			giangviensv.setString(2, giangvien.getGioitinh());
			giangviensv.setString(3, giangvien.getPhone());
			giangviensv.setString(4, giangvien.getEmail());
			giangviensv.setString(5, giangvien.getPhanloaigv());
			giangviensv.setString(6, giangvien.getMagv());
			giangviensv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void DeleteGiangvien( String magv) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlGiangvien = "DELETE FROM giangvien WHERE magv = ?";
		try {
			PreparedStatement giangviensv = conn.prepareStatement(sqlGiangvien);
			giangviensv.setString(1, magv);
			giangviensv.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
