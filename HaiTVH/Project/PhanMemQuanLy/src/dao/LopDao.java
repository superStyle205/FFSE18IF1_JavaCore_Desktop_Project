package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connect.ConnectUtil;

public class LopDao {

	public ArrayList<Lop> getAllLop() {

		String sql = " SELECT * FROM project.lop ";

		ArrayList<Lop> listLop = new ArrayList<Lop>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			Lop lop;

			while (result.next()) {

				lop = new Lop();

				lop.setIdLop(result.getString("idlop"));
				lop.setTenLop(result.getString("lop"));

				listLop.add(lop);

			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}
		return listLop;
	}

	public void addLop(Lop lop) {

		String sql = "INSERT INTO project.lop VALUE (?,?) ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, lop.getIdLop());
			statement.setString(2, lop.getTenLop());

			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Thêm lớp thành công !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm lớp không thành công !");
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	public void updateLop(Lop lop) {

		String sql = "UPDATE project.lop SET  lop = ?  WHERE idlop = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, lop.getTenLop());
			statement.setString(2, lop.getIdLop());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Sửa lớp thành công !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sửa lớp không thành công !");
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	public void deleteLop(String lop) {

		Object[] options = { "Yes", "No" };

		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (n == 0) {

			// Delete Data
			String sql = "DELETE FROM project.lop  WHERE idlop = ?";

			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();

			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, lop);

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
