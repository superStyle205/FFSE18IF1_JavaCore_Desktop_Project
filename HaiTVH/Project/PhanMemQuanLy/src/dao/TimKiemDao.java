package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.ConnectUtil;

public class TimKiemDao {
	
	public void showTableSinhVienTimKiem(JTable table, String key) {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("ID");
		cols.addElement("Họ Tên");
		cols.addElement("ID Lớp");
		cols.addElement("Ngày Sinh");
		cols.addElement("Địa Chỉ");
		cols.addElement("Giới Tính");
		cols.addElement("Số Điện Thoại");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.sinhvien";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
		
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
	
			while (result.next()) {
				Vector hocsinh = new Vector();
				hocsinh.addElement(result.getString("idhs"));
				hocsinh.addElement(result.getString("hoten"));
				hocsinh.addElement(result.getString("idlop"));
				hocsinh.addElement(result.getDate("ngaysinh"));
				hocsinh.addElement(result.getString("diachi"));
				hocsinh.addElement(result.getString("gioitinh"));
				hocsinh.addElement(result.getString("sdt"));

				if (hocsinh.toString().contains(key)) {
					data.addElement(hocsinh);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}
	
	public ArrayList<HocSinh> searchHs(String tenHocsinh) {
		String sql = "SELECT * FROM project.sinhvien  where hoten= ?";

		ArrayList<HocSinh> listSearchHs = new ArrayList<HocSinh>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			HocSinh hocsinh;
			statement.setString(1, tenHocsinh);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				hocsinh = new HocSinh();
				
				hocsinh.setIdHocSinh(result.getString("idhs"));
				hocsinh.setHoTen(result.getString("hoten"));
				hocsinh.setIdLop(result.getString("idlop"));
				hocsinh.setNgaySinh(result.getString("ngaysinh"));
				hocsinh.setDiaChi(result.getString("diachi"));
				hocsinh.setGioiTinh(result.getString("gioitinh"));
				hocsinh.setSdt(result.getString("sdt"));

				listSearchHs.add(hocsinh);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return listSearchHs;
	}

	public void showTableGiaoVienTimKiem(JTable table, String key) {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("ID");
		cols.addElement("Họ Tên");
		cols.addElement("ID Môn Dạy");
		cols.addElement("Ngày Sinh");
		cols.addElement("Giới Tính");
		cols.addElement("Email");
		cols.addElement("Số Điện Thoại");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.giaovien";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Vector giaovien = new Vector();
				giaovien.addElement(result.getString("idgv"));
				giaovien.addElement(result.getString("hoten"));
				giaovien.addElement(result.getString("idmon"));
				giaovien.addElement(result.getDate("ngaysinh"));
				giaovien.addElement(result.getString("gioitinh"));
				giaovien.addElement(result.getString("email"));
				giaovien.addElement(result.getString("sdt"));

				if (giaovien.toString().contains(key)) {
					data.addElement(giaovien);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}


	public void showTableLopTimKiem(JTable table, String key) {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã Lớp");
		cols.addElement("Tên Lớp");
	
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.lop";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Vector lop = new Vector();
				
				lop.addElement(result.getString("idlop"));
				lop.addElement(result.getString("lop"));

				if (lop.toString().contains(key)) {
					data.addElement(lop);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableMonTimKiem(JTable table, String key) {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã Môn Học");
		cols.addElement("Tên Môn Học");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.mon";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Vector mon = new Vector();
			
				mon.addElement(result.getString("idmon"));
				mon.addElement(result.getString("mon"));

				if (mon.toString().contains(key)) {
					data.addElement(mon);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		table.setModel(new DefaultTableModel(data, cols));
	}
}
