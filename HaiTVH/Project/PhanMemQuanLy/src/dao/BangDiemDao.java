package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.ConnectUtil;

public class BangDiemDao {
	public void showTableBangDiemSearch(JTable table_Bangdiem, String sql, String search) {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("STT");
		cols.addElement("ID Học Sinh");
		cols.addElement("Tên Học Sinh");
		cols.addElement("Điểm 15p");
		cols.addElement("Điểm 45p");
		cols.addElement("Điểm thi");
		cols.addElement("Tổng Kết");
		cols.addElement("Kết Quả");
		cols.addElement("Môn");
		cols.addElement("Lớp");
		cols.addElement("ID Giáo Viên");
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		// Data table
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			int i = 0;
			while (result.next()) {
				
				Vector xemdiem = new Vector<Object>();
				
				xemdiem.addElement(i++);
				xemdiem.addElement(result.getString("diem.idhs"));
				xemdiem.addElement(result.getString("sinhvien.hoten"));
				xemdiem.addElement(result.getFloat("diem.diem15"));
				xemdiem.addElement(result.getFloat("diem.diem45"));
				xemdiem.addElement(result.getFloat("diem.diemthi"));
				xemdiem.addElement(result.getFloat("diem.tongket"));
				xemdiem.addElement(result.getString("diem.ketqua"));
				xemdiem.addElement(result.getString("mon.mon"));
				xemdiem.addElement(result.getString("lop.lop"));
				xemdiem.addElement(result.getString("diem.idgv"));
				
				if (xemdiem.toString().contains(search)) {
					data.addElement(xemdiem);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableBangDiem(JTable table_Bangdiem, String sql, String idhs, String mon) {

		Vector<String> cols = new Vector<String>();
		cols.addElement("STT");
		cols.addElement("ID Học Sinh");
		cols.addElement("Tên Học Sinh");
		cols.addElement("Điểm 15p");
		cols.addElement("Điểm 45p");
		cols.addElement("Điểm thi");
		cols.addElement("Tổng Kết");
		cols.addElement("Kết Quả");
		cols.addElement("Môn");
		cols.addElement("Lớp");
		cols.addElement("ID Giáo Viên");
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		// Data table
		Vector data = new Vector();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, idhs);
			statement.setString(2, mon);
			
			ResultSet result = statement.executeQuery();
	
			int i = 0;
			while (result.next()) {
				Vector xemdiem = new Vector();
				
				xemdiem.addElement(i++);
				xemdiem.addElement(result.getString("diem.idhs"));
				xemdiem.addElement(result.getString("sinhvien.hoten"));
				xemdiem.addElement(result.getFloat("diem.diem15"));
				xemdiem.addElement(result.getFloat("diem.diem45"));
				xemdiem.addElement(result.getFloat("diem.diemthi"));
				xemdiem.addElement(result.getFloat("diem.tongket"));
				xemdiem.addElement(result.getString("diem.ketqua"));
				xemdiem.addElement(result.getString("mon.mon"));
				xemdiem.addElement(result.getString("lop.lop"));
				xemdiem.addElement(result.getString("diem.idgv"));
				data.add(xemdiem);
			}
		} catch (Exception e) {
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
		
	}
	public void showTableBangDiem(JTable table_Bangdiem,String sql, String where) {
		
		Vector<String> cols = new Vector<String>();
		cols.addElement("STT");
		cols.addElement("ID Học Sinh");
		cols.addElement("Tên Học Sinh");
		cols.addElement("Điểm 15p");
		cols.addElement("Điểm 45p");
		cols.addElement("Điểm thi");
		cols.addElement("Tổng Kết");
		cols.addElement("Kết Quả");
		cols.addElement("Môn");
		cols.addElement("Lớp");
		cols.addElement("ID Giáo Viên");
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		// Data table
		Vector data = new Vector();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, where);
			
			ResultSet result = statement.executeQuery();
	
			int i = 0;
			while (result.next()) {
				Vector xemdiem = new Vector();
				
				xemdiem.addElement(i++);
				xemdiem.addElement(result.getString("diem.idhs"));
				xemdiem.addElement(result.getString("sinhvien.hoten"));
				xemdiem.addElement(result.getFloat("diem.diem15"));
				xemdiem.addElement(result.getFloat("diem.diem45"));
				xemdiem.addElement(result.getFloat("diem.diemthi"));
				xemdiem.addElement(result.getFloat("diem.tongket"));
				xemdiem.addElement(result.getString("diem.ketqua"));
				xemdiem.addElement(result.getString("mon.mon"));
				xemdiem.addElement(result.getString("lop.lop"));
				xemdiem.addElement(result.getString("diem.idgv"));
				data.add(xemdiem);
			}
		} catch (Exception e) {
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
