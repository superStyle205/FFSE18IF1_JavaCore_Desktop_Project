package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.BangDiem;
import Model.bean.ThongKeHS;

public class ThongKeHSDao {
	public List<ThongKeHS> getAllThongKeHS(){
		String sql = "SELECT * FROM thongke";
		List<ThongKeHS> listThongKeHS = new ArrayList<ThongKeHS>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongKeHS thongKeHS;
			while (resultSet.next()) { 
				thongKeHS = new ThongKeHS();
				thongKeHS.setSoThuTu(resultSet.getString("sothutu"));
				thongKeHS.setLop(resultSet.getString("lop"));
				thongKeHS.setTongSo(resultSet.getString("tongso"));
				thongKeHS.setSoHocSinhNam(resultSet.getString("sohocsinhnam"));
				thongKeHS.setSoHocSinhNu(resultSet.getString("sohocsinhnu"));
				thongKeHS.setSoHocSinhGioi(resultSet.getString("sohocsinhgioi"));
				thongKeHS.setSoHocSinhKha(resultSet.getString("sohocsinhkha"));
				thongKeHS.setSoHocSinhTB(resultSet.getString("sohocsinhtb"));
				thongKeHS.setSoHocSinhYeu(resultSet.getString("sohocsinhyeu"));
				thongKeHS.setSoHanhKiemTot(resultSet.getString("sohanhkiemtot"));
				thongKeHS.setSoHanhKiemKha(resultSet.getString("sohanhkiemkha"));
				thongKeHS.setSoHanhKiemTB(resultSet.getString("sohanhkiemtb"));
				thongKeHS.setSoHanhKiemYeu(resultSet.getString("sohanhkiemyeu"));
				thongKeHS.setSoHocSinhOLaiLop(resultSet.getString("sohocsinholailop"));
				thongKeHS.setSoHocSinhThiLai(resultSet.getString("sohocsinhthilai"));
				listThongKeHS.add(thongKeHS);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongKeHS;
	}
	
	public List<ThongKeHS> showTableByAZTK(){
		String sql = "SELECT * FROM thongke ORDER BY sothutu ASC";
		List<ThongKeHS> listThongKeHS = new ArrayList<ThongKeHS>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongKeHS thongKeHS;
			while (resultSet.next()) { 
				thongKeHS = new ThongKeHS();
				thongKeHS.setSoThuTu(resultSet.getString("sothutu"));
				thongKeHS.setLop(resultSet.getString("lop"));
				thongKeHS.setTongSo(resultSet.getString("tongso"));
				thongKeHS.setSoHocSinhNam(resultSet.getString("sohocsinhnam"));
				thongKeHS.setSoHocSinhNu(resultSet.getString("sohocsinhnu"));
				thongKeHS.setSoHocSinhGioi(resultSet.getString("sohocsinhgioi"));
				thongKeHS.setSoHocSinhKha(resultSet.getString("sohocsinhkha"));
				thongKeHS.setSoHocSinhTB(resultSet.getString("sohocsinhtb"));
				thongKeHS.setSoHocSinhYeu(resultSet.getString("sohocsinhyeu"));
				thongKeHS.setSoHanhKiemTot(resultSet.getString("sohanhkiemtot"));
				thongKeHS.setSoHanhKiemKha(resultSet.getString("sohanhkiemkha"));
				thongKeHS.setSoHanhKiemTB(resultSet.getString("sohanhkiemtb"));
				thongKeHS.setSoHanhKiemYeu(resultSet.getString("sohanhkiemyeu"));
				thongKeHS.setSoHocSinhOLaiLop(resultSet.getString("sohocsinholailop"));
				thongKeHS.setSoHocSinhThiLai(resultSet.getString("sohocsinhthilai"));
				listThongKeHS.add(thongKeHS);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongKeHS;
	}
	public List<ThongKeHS> showTableByZATK(){
		String sql = "SELECT * FROM thongke ORDER BY sothutu DESC";
		List<ThongKeHS> listThongKeHS = new ArrayList<ThongKeHS>();
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ThongKeHS thongKeHS;
			while (resultSet.next()) { 
				thongKeHS = new ThongKeHS();
				thongKeHS.setSoThuTu(resultSet.getString("sothutu"));
				thongKeHS.setLop(resultSet.getString("lop"));
				thongKeHS.setTongSo(resultSet.getString("tongso"));
				thongKeHS.setSoHocSinhNam(resultSet.getString("sohocsinhnam"));
				thongKeHS.setSoHocSinhNu(resultSet.getString("sohocsinhnu"));
				thongKeHS.setSoHocSinhGioi(resultSet.getString("sohocsinhgioi"));
				thongKeHS.setSoHocSinhKha(resultSet.getString("sohocsinhkha"));
				thongKeHS.setSoHocSinhTB(resultSet.getString("sohocsinhtb"));
				thongKeHS.setSoHocSinhYeu(resultSet.getString("sohocsinhyeu"));
				thongKeHS.setSoHanhKiemTot(resultSet.getString("sohanhkiemtot"));
				thongKeHS.setSoHanhKiemKha(resultSet.getString("sohanhkiemkha"));
				thongKeHS.setSoHanhKiemTB(resultSet.getString("sohanhkiemtb"));
				thongKeHS.setSoHanhKiemYeu(resultSet.getString("sohanhkiemyeu"));
				thongKeHS.setSoHocSinhOLaiLop(resultSet.getString("sohocsinholailop"));
				thongKeHS.setSoHocSinhThiLai(resultSet.getString("sohocsinhthilai"));
				listThongKeHS.add(thongKeHS);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return listThongKeHS;
	}
	
	public void addThongKeHS(ThongKeHS thongKeHS) {
		String sql = "INSERT INTO thongke VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,thongKeHS.getSoThuTu());
			statement.setString(2,thongKeHS.getLop());
			statement.setString(3,thongKeHS.getTongSo());
			statement.setString(4, thongKeHS.getSoHocSinhNam());
			statement.setString(5, thongKeHS.getSoHocSinhNu());
			statement.setString(6, thongKeHS.getSoHocSinhGioi());
			statement.setString(7, thongKeHS.getSoHocSinhKha());
			statement.setString(8, thongKeHS.getSoHocSinhTB());
			statement.setString(9, thongKeHS.getSoHocSinhYeu());
			statement.setString(10, thongKeHS.getSoHanhKiemTot());
			statement.setString(11, thongKeHS.getSoHanhKiemKha());
			statement.setString(12, thongKeHS.getSoHanhKiemTB());
			statement.setString(13, thongKeHS.getSoHanhKiemYeu());
			statement.setString(14, thongKeHS.getSoHocSinhOLaiLop());
			statement.setString(15, thongKeHS.getSoHocSinhThiLai());
			
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkaddTK(String stt, String lop) {
		String sql = "SELECT * FROM thongke WHERE (sothutu = ? AND lop = ?) OR (sothutu= ? OR lop = ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag =true;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, stt);
			statement.setString(2, lop);
			statement.setString(3, stt);
			statement.setString(4, lop);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()==true) {
				flag = false;
			}else {
				flag = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		return flag;
	}
	public void updateThongKe(ThongKeHS thongKeHS) {
		String sql = "UPDATE thongke SET sothutu = ?,tongso = ?,sohocsinhnam = ?,sohocsinhnu = ?,sohocsinhgioi = ?,sohocsinhkha = ?,sohocsinhtb = ?,sohocsinhyeu = ?,sohanhkiemtot = ?,sohanhkiemkha = ?,sohanhkiemtb = ?,sohanhkiemyeu = ?,sohocsinholailop =?,sohocsinhthilai = ? WHERE lop= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,thongKeHS.getSoThuTu());
			statement.setString(2,thongKeHS.getTongSo());
			statement.setString(3, thongKeHS.getSoHocSinhNam());
			statement.setString(4, thongKeHS.getSoHocSinhNu());
			statement.setString(5, thongKeHS.getSoHocSinhGioi());
			statement.setString(6, thongKeHS.getSoHocSinhKha());
			statement.setString(7, thongKeHS.getSoHocSinhTB());
			statement.setString(8, thongKeHS.getSoHocSinhYeu());
			statement.setString(9, thongKeHS.getSoHanhKiemTot());
			statement.setString(10, thongKeHS.getSoHanhKiemKha());
			statement.setString(11, thongKeHS.getSoHanhKiemTB());
			statement.setString(12, thongKeHS.getSoHanhKiemYeu());
			statement.setString(13, thongKeHS.getSoHocSinhOLaiLop());
			statement.setString(14, thongKeHS.getSoHocSinhThiLai());
			statement.setString(15,thongKeHS.getLop());
			
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	
	
	
	public void deleteThongKe(String lop) {
		String sql = "DELETE FROM thongke WHERE lop = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop);																																						
			statement.executeUpdate();
		}
		catch(SQLException e) {
		e.printStackTrace();
	}
		finally {
			connectUtil.disconnect(conn);
		}
	}

}
