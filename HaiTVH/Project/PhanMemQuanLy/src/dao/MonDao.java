package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connect.ConnectUtil;

public class MonDao {
	
	public ArrayList<Mon> getAllMon() {

		String sql = " SELECT * FROM project.mon ";

		ArrayList<Mon> listMon = new ArrayList<Mon>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			Mon mon;

			while (result.next()) {

				mon = new Mon();

				mon.setIdMon(result.getString("idmon"));
				mon.setTenMon(result.getString("mon"));

				listMon.add(mon);

			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}
		return listMon;
	}
	
	public void addMon(Mon mon) {

		String sql = "INSERT INTO project.mon VALUE (?,?) ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mon.getIdMon());
			statement.setString(2, mon.getTenMon());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm môn thành công !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm môn không thành công !");
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	public void updateMon(Mon mon) {

		String sql = "UPDATE project.mon SET  mon = ?  WHERE idmon = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mon.getTenMon());
			statement.setString(2, mon.getIdMon());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Sửa môn thành công !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sửa môn không thành công !");
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	public void deleteMon(String mon) {

		Object[] options = { "Yes", "No" };

		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (n == 0) {

			// Delete Data
			String sql = "DELETE FROM project.mon  WHERE idmon = ?";

			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();

			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, mon);

				statement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công !");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không thể xóa ");
				System.out.println(e);
			} finally {
				connectUtil.disconnect(conn);
			}

		}

	}
}
