import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoMon {
	public ArrayList<Mon> getAlluser(){
		ArrayList<Mon> listmon = new ArrayList<Mon>();
		String sqlMon = "SELECT * FROM mon";
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();
		
		try {
			PreparedStatement ss = sc.prepareStatement(sqlMon);
			ResultSet resultSet = ss.executeQuery();
			while (resultSet.next()) {
				Mon mon = new Mon();
				mon.setMamon(resultSet.getString("mamon"));
				mon.setTenmon(resultSet.getString("tenmon"));
				mon.setMagv(resultSet.getString("magv"));
				mon.setHocki(resultSet.getString("hocki"));
				mon.setMakhoa(resultSet.getString("makhoa"));
				listmon.add(mon);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listmon;
	} 
	public void AddMon(Mon mon) {
		Ketnoisql connect =  new Ketnoisql();
		Connection conn = connect.connect();
		String sqlMon = "INSERT INTO mon( mamon,tenmon,magv,hocki,makhoa) VALUES( ?,?,?,?,?)";
		try {
			PreparedStatement monsv = conn.prepareStatement(sqlMon);
			monsv.setString(1,mon.getMamon());
			monsv.setString(2, mon.getTenmon());
			monsv.setString(3, mon.getMagv());
			monsv.setString(4, mon.getHocki());
			monsv.setString(5, mon.getMakhoa());
			monsv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void UpdateMon(Mon mon) {
		Ketnoisql connect =  new Ketnoisql();
		Connection conn = connect.connect();
		String sqlMon = "UPDATE mon SET tenmon=?,magv=?,hocki=?,makhoa=? WHERE mamon=?";
		try {
			PreparedStatement monsv = conn.prepareStatement(sqlMon);
			monsv.setString(1, mon.getTenmon());
			monsv.setString(2, mon.getMagv());
			monsv.setString(3, mon.getHocki());
			monsv.setString(4, mon.getMakhoa());
			monsv.setString(5, mon.getMamon());
			monsv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void DeleteMon( String mamon) {
		Ketnoisql connect =  new Ketnoisql();
		Connection conn = connect.connect();
		String sqlMon = "DELETE FROM mon WHERE mamon=?";
		try {
			PreparedStatement monsv = conn.prepareStatement(sqlMon);
			monsv.setString(1, mamon);
			monsv.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
