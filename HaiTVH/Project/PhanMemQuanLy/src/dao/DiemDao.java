package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import connect.ConnectUtil;

public class DiemDao {
	public ArrayList<Diem> getALLDiem() {

		String sql = " SELECT * FROM project.diem ";

		ArrayList<Diem> listDiem = new ArrayList<Diem>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			Diem diem;

			while (result.next()) {

				diem = new Diem();

				diem.setIdLop(result.getString("idlop"));
				diem.setIdHocSinh(result.getString("idhs"));
				diem.setMonHoc(result.getString("mon"));
				diem.setIdMonHoc(result.getString("idmon"));
				diem.setDiem15(result.getString("diem15"));
				diem.setDiem45(result.getString("diem45"));
				diem.setDiemThi(result.getString("diemthi"));
				diem.setTongKet(result.getString("tongKet"));
				diem.setKetQua(result.getString("ketQua"));
				diem.setIdGv(result.getString("idGv"));

				listDiem.add(diem);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return listDiem;
	}

	public void addDiem(Diem diem) {
		String sql = " INSERT INTO project.diem VALUES  (?,?,?,?, ?,?, ?,?, ?,?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, diem.getIdLop());
			statement.setString(2, diem.getMonHoc());
			statement.setString(3, diem.getIdMonHoc());
			statement.setString(4, diem.getIdHocSinh());

			statement.setString(5, diem.getDiem15());
			statement.setString(6, diem.getDiem45());
			statement.setString(7, diem.getDiemThi());
			statement.setString(8, diem.getTongKet());

			statement.setString(9, diem.getKetQua());
			statement.setString(10, diem.getIdGv());

			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Thêm thành công !");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công!");
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateDiem(Diem diem) {

		String sql = "UPDATE project.diem SET idlop=?, mon=?, idmon=?, idhs=?, diem15=?, diem45=?,diemthi=?, tongket=?, ketqua=?, idgv=? WHERE idhs=? AND idmon=?";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, diem.getIdLop());
			statement.setString(2, diem.getMonHoc());
			statement.setString(3, diem.getIdMonHoc());
			statement.setString(4, diem.getIdHocSinh());

			statement.setString(5, diem.getDiem15());
			statement.setString(6, diem.getDiem45());
			statement.setString(7, diem.getDiemThi());
			statement.setString(8, diem.getTongKet());

			statement.setString(9, diem.getKetQua());
			statement.setString(10, diem.getIdGv());
			
			statement.setString(11, diem.getIdHocSinh());
			statement.setString(12, diem.getIdMonHoc());

			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhập!");
			System.out.println(e2);
		} finally {
			connectUtil.disconnect(conn);
		}

	}

	public void deleteDiem(String diem, String mon) {

		Object[] options = { "Yes", "No" };

		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == 0) {

			// Delete Data
			String sql = "DELETE FROM project.diem WHERE idhs = ? AND idmon = ?";

			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();

			try {

				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, diem);
				statement.setString(2, mon);

				statement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công !");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không thể xóa  ");
				System.out.println(e);

			} finally {
				connectUtil.disconnect(conn);
			}

		}

	}

}
