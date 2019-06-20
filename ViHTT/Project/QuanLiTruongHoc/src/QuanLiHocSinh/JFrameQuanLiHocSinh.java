package QuanLiHocSinh;

import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.bean.ThongTinHocSinh;
import Model.dao.ThongTinHocSinhDao;

public class JFrameQuanLiHocSinh extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane;
	private Container container;
	private DefaultTableModel tableModel;
	private JTable jtable;
	private JScrollPane jscrollpane;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private AbstractButton btnClean;
	private JPanel panelButton;
	private JTextField TextFieldMaSV;
	private JTextField TextFieldTenSV;
	private JTextField TextFieldLop;
	private JTextField TextFieldNienKhoa;
	private JTextField TextFieldDiemTB;
	private JPanel panelInput;
	private Object thongTinHocSinihDao;
	public JFrameQuanLiHocSinh() {
		loadQuanLiHocSinh();
	}
	public void loadQuanLiHocSinh() {
		setTitle("QUẢN LÍ HỌC SINH");
		setSize(1350,720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jTabbedPane = new JTabbedPane();
		jTabbedPane.addTab("Thông tin học sinh", new ImageIcon("contacts.png"),new TabThongTinHocSinh());
		jTabbedPane.addTab("quan li diem", new ImageIcon("contacts.png"),new TabQuanLiDiem());
		jTabbedPane.addTab("bảng điểm", new ImageIcon("contacts.png"),new TabBangDiem());
		container = getContentPane();
		container.add(jTabbedPane);
		
		
		

		
		}
//		private void loadTable() {
//		// TODO Auto-generated method stub
//		
//	}
	public static void main(String[] args) {
		JFrameQuanLiHocSinh jFrameQuanLiHocSinh = new JFrameQuanLiHocSinh();
		jFrameQuanLiHocSinh.setVisible(true);
	}
}
