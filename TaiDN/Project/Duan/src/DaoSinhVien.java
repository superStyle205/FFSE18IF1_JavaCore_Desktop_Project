import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoSinhVien {
	public ArrayList<Sinhvien> getAlluser(){
		ArrayList<Sinhvien> listSinhvien = new ArrayList<Sinhvien>();
		String sqlsinhvien = "SELECT * FROM sinhvien";
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();
		
		try {
			PreparedStatement ss = sc.prepareStatement(sqlsinhvien);
			ResultSet resultSet = ss.executeQuery();
			while (resultSet.next()) {
				Sinhvien sv = new Sinhvien();
				sv.setMasv(resultSet.getString("masv"));
				sv.setHoten(resultSet.getString("hoten"));
				sv.setNgaysinh(resultSet.getString("ngaysinh"));
				sv.setGioitinh(resultSet.getString("gioitinh"));
				sv.setDiachi(resultSet.getString("diachi"));
				sv.setMalop(resultSet.getString("malop"));
			//System.out.println(resultSet.getString("ngaysinh"));
				listSinhvien.add(sv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return listSinhvien;
		
	}
//	public static void main(String [] args) {
//		DaoSinhVien daoSinhVien = new DaoSinhVien();
//		daoSinhVien.getAlluser();
//	}
	 public void AddSinhVien(Sinhvien sv) {
		 Ketnoisql connect = new Ketnoisql();
		 Connection conn = connect.connect();
		 String sqlsinhvien = "INSERT INTO sinhvien(masv, hoten,ngaysinh,gioitinh,diachi,malop ) VALUES(?,?,?,?,?,?)";
		 try {
			PreparedStatement svn = conn.prepareStatement(sqlsinhvien);
			svn.setString(1, sv.getMasv());
			svn.setString(2, sv.getHoten());
			svn.setString(3, sv.getNgaysinh());
			svn.setString(4, sv.getGioitinh());
			svn.setString(5, sv.getDiachi());
			svn.setString(6, sv.getMalop());
			svn.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public void UpdateSinhvien(Sinhvien sv ) {
		 Ketnoisql connect = new Ketnoisql();
		 Connection conn = connect.connect();
		 String sqlsinhvien = "UPDATE sinhvien SET hoten=?,ngaysinh=?,gioitinh=?,diachi=?,malop=? WHERE masv=? ";
		 try {
			PreparedStatement svn = conn.prepareStatement(sqlsinhvien);
			svn.setString(1,sv.getHoten());
			svn.setString(2,sv.getNgaysinh());
			svn.setString(3,sv.getGioitinh());
			svn.setString(4,sv.getDiachi());
			svn.setString(5,sv.getMalop());
			svn.setString(6,sv.getMasv());
			svn.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 public void DeleteSinhvien(String masv) {
		 Ketnoisql connect = new Ketnoisql();
		 Connection conn = connect.connect();
		 String sqlsinhvien = "DELETE FROM sinhvien WHERE masv=? ";
		 try {
			PreparedStatement svn = conn.prepareStatement(sqlsinhvien);
			svn.setString(1, masv);
			svn.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
}
