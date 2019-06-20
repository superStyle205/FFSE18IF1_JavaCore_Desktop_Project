import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoKetQua {
	public ArrayList<Ketqua> getAlluser(){
		ArrayList<Ketqua> listketqua = new ArrayList<Ketqua>();
		String sqlKetqua = "SELECT * FROM ketqua";
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();
		
		try {
			PreparedStatement ss = sc.prepareStatement(sqlKetqua);
			ResultSet resultSet = ss.executeQuery();
			while (resultSet.next()) {
				Ketqua kq = new Ketqua();
				kq.setMasv(resultSet.getString("masv"));
				kq.setHoten(resultSet.getString("hoten"));
				kq.setHanhkiem(resultSet.getString("hanhkiem"));
				kq.setMamon(resultSet.getString("mamon"));
				kq.setDiemtb(resultSet.getString("diemtb"));
				kq.setDiemthilan1(resultSet.getString("diemthilan1"));
				kq.setDiemthilan2(resultSet.getString("diemthilan2"));
				kq.setDiemtongket(resultSet.getString("diemtongket"));
				
				listketqua.add(kq);
			//	System.out.println(resultSet.getString("masv"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listketqua;
	} 
	
	public void AddKetqua(Ketqua ketqua) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlKetqua = "INSERT INTO ketqua(masv,hoten,hanhkiem,mamon,diemtb,diemthilan1,diemthilan2,diemtongket) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ketquasv = conn.prepareStatement(sqlKetqua);
			ketquasv.setString(1, ketqua.getMasv());
			ketquasv.setString(2, ketqua.getHoten());
			
			ketquasv.setString(3, ketqua.getHanhkiem());
			ketquasv.setString(4, ketqua.getMamon());
			ketquasv.setString(5, ketqua.getDiemtb());
			ketquasv.setString(6, ketqua.getDiemthilan1());
			ketquasv.setString(7, ketqua.getDiemthilan2());
			ketquasv.setString(8, ketqua.getDiemtongket());
			
			ketquasv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void UpdateKetqua( Ketqua ketqua) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlKetqua = "UPDATE ketqua SET hoten=?,hanhkiem=?,mamon=?,diemtb=?,diemthilan1=?,diemthilan2=?,diemtongket=? WHERE masv=?";
		try {
			PreparedStatement ketquasv = conn.prepareStatement(sqlKetqua);
			ketquasv.setString(1, ketqua.getHoten());
			ketquasv.setString(2, ketqua.getHanhkiem());
			ketquasv.setString(3, ketqua.getMamon());
			ketquasv.setString(4, ketqua.getDiemtb());
			ketquasv.setString(5, ketqua.getDiemthilan1());
			ketquasv.setString(6, ketqua.getDiemthilan2());
			ketquasv.setString(7, ketqua.getDiemtongket());
			
			
			ketquasv.setString(8, ketqua.getMasv());
			ketquasv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeleteKetqua(String masv) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn =connect.connect();
		String sqlKetqua = "DELETE FROM ketqua WHERE masv=? ";
		try {
			PreparedStatement ketquasv = conn.prepareStatement(sqlKetqua);
			ketquasv.setString(1, masv);
			ketquasv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
