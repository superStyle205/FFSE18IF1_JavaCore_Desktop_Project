import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoLop {
	public ArrayList<Lop> getAlluser(){
		ArrayList<Lop> listlop = new ArrayList<Lop>();
		String sqlLop = "SELECT * FROM lop";
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();
		
		try {
			PreparedStatement ss = sc.prepareStatement(sqlLop);
			ResultSet resultSet = ss.executeQuery();
			while (resultSet.next()) {
				Lop lop = new Lop();
				lop.setMakhoa(resultSet.getString("makhoa"));
				lop.setMalop(resultSet.getString("malop"));
				lop.setTenlop(resultSet.getString("tenlop"));
				
			//	System.out.println(resultSet.getString("makhoa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listlop;
	} 
//	public static void main(String [] args ) {
//		DaoLop daoLop = new DaoLop();
//		daoLop.getAlluser();
//	}
	public void AddLop(Lop lop) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlLop = "INSERT INTON lop(makhoa,malop,tenlop) VALUES (?,?,?)";
		try {
			PreparedStatement lopsv = conn.prepareStatement(sqlLop);
			lopsv.setString(1, lop.getMakhoa());
			lopsv.setString(2, lop.getMalop());
			lopsv.setString(3, lop.getTenlop());
			lopsv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void UpdateLop (Lop lop) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlLop = "UPDATE lop SET malop=? , tenlop=? WHERE makhoa=?";
		try {
			PreparedStatement lopsv = conn.prepareStatement(sqlLop);
			lopsv.setString(1, lop.getMalop());
			lopsv.setString(2, lop.getTenlop());
			lopsv.setString(3, lop.getMakhoa());
			lopsv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void DeleteLop(String malop) {
		Ketnoisql connect = new Ketnoisql();
		Connection conn = connect.connect();
		String sqlLop= "DELETE FROM lop WHERE malop =?";
		try {
			PreparedStatement lopsv = conn.prepareStatement(sqlLop);
			lopsv.setString(1, malop);
			lopsv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
