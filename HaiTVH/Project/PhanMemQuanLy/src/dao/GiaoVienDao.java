package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connect.ConnectUtil;

public class GiaoVienDao {
	
	public ArrayList<GiaoVien> getALLGiaoVien() {

		String sql = " SELECT * FROM project.giaovien ";

		ArrayList<GiaoVien> listGV = new ArrayList<GiaoVien>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			GiaoVien giaovien;

			while (result.next()) {

				giaovien = new GiaoVien();

				giaovien.setIdGv(result.getString("idgv"));
				giaovien.setHoTenGv(result.getString("hoten"));
				giaovien.setIdMonday(result.getString("idmon"));
				giaovien.setIdLop(result.getString("idlop"));
				giaovien.setNgaySinh(result.getString("ngaysinh"));
				giaovien.setGioiTinhGv(result.getString("gioitinh"));
				giaovien.setEmail(result.getString("email"));
				giaovien.setSdtGv(result.getString("sdt"));

				listGV.add(giaovien);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			connectUtil.disconnect(conn);
		}
		return listGV;
	}
	
	public void addGv(GiaoVien giaovien) {
		String sql = " INSERT INTO project.giaovien VALUES (?,?,?,?,?,?,?,?,null)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, giaovien.getIdGv());
			statement.setString(2, giaovien.getHoTenGv());
			statement.setString(3, giaovien.getIdMonday());
			statement.setString(4, giaovien.getIdLop());
			statement.setString(5, giaovien.getNgaySinh());
			statement.setString(6, giaovien.getGioiTinhGv());
			statement.setString(7, giaovien.getEmail());
			statement.setString(8, giaovien.getSdtGv());

			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Thêm thành công !");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công! \n" + e);
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void updateGv(GiaoVien giaovien) {

		String sql = "UPDATE project.giaovien SET hoten=?, idlop=?, idmon=?, ngaysinh=?, gioitinh=?, email=?, sdt=? WHERE idgv=?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, giaovien.getHoTenGv());
			statement.setString(2, giaovien.getIdLop());
			statement.setString(3, giaovien.getIdMonday());
			statement.setString(4, giaovien.getNgaySinh());
			statement.setString(5, giaovien.getGioiTinhGv());
			statement.setString(6, giaovien.getEmail());
			statement.setString(7, giaovien.getSdtGv());
			statement.setString(8, giaovien.getIdGv());

			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cập nhật thành công !");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "lỗi cập nhập !");
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteGv(String giaovien) {

		Object[] options = { "Yes", "No" };

		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == 0) {

			// Delete Data
			String sql = "DELETE FROM project.giaovien  WHERE idgv = ?";

			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();

			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, giaovien);
				statement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công !");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không thể xóa ");

			} finally {
				connectUtil.disconnect(conn);
			}

		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
