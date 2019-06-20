package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import connect.ConnectUtil;

public class HocSinhDao {

	public ArrayList<HocSinh> getALLHocSinh() {

		String sql = " SELECT * FROM project.sinhvien ";

		ArrayList<HocSinh> listHS = new ArrayList<HocSinh>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			HocSinh hocsinh;

			while (result.next()) {

				hocsinh = new HocSinh();

				hocsinh.setIdHocSinh(result.getString("idhs"));
				hocsinh.setHoTen(result.getString("hoten"));
				hocsinh.setIdLop(result.getString("idlop"));
				hocsinh.setNgaySinh(result.getString("ngaysinh"));
				hocsinh.setDiaChi(result.getString("diachi"));
				hocsinh.setGioiTinh(result.getString("gioitinh"));
				hocsinh.setSdt(result.getString("sdt"));

				listHS.add(hocsinh);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return listHS;
	}

	public void addHs(HocSinh hocsinh) {
		String sql = " INSERT INTO project.sinhvien VALUES  (?,?,?,?,?,?,?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, hocsinh.getIdHocSinh());
			statement.setString(2, hocsinh.getHoTen());
			statement.setString(3, hocsinh.getIdLop());
			statement.setString(4, hocsinh.getNgaySinh());
			statement.setString(5, hocsinh.getDiaChi());
			statement.setString(6, hocsinh.getGioiTinh());
			statement.setString(7, hocsinh.getSdt());

			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Thêm thành công !");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công!");
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateHs(HocSinh hocsinh) {

		String sql = "UPDATE project.sinhvien SET hoten=?, idlop=?, ngaysinh=?, diachi=?, gioitinh=?, sdt=? WHERE idhs=?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, hocsinh.getHoTen());
			statement.setString(2, hocsinh.getIdLop());
			statement.setString(3, hocsinh.getNgaySinh());
			statement.setString(4, hocsinh.getDiaChi());
			statement.setString(5, hocsinh.getGioiTinh());
			statement.setString(6, hocsinh.getSdt());
			statement.setString(7, hocsinh.getIdHocSinh());

			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cập nhật thành công !");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "lỗi cập nhập !");
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteHs(String hocsinh) {

		Object[] options = { "Yes", "No" };

		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == 0) {

			// Delete Data
			String sql = "DELETE FROM project.sinhvien  WHERE idhs = ?";

			ConnectUtil connectUtil = new ConnectUtil();
			Connection conn = connectUtil.connect();

			try {
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, hocsinh);
				statement.executeUpdate();
				JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công !");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không thể xóa  ");

			} finally {
				connectUtil.disconnect(conn);
			}

		}

	}

}
