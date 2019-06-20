package projectManagementSchool.QuanLy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import projectManagementSchool.UserDao.userDaoQuanLyHocSinhTrongLop;
import projectManagementSchool.model.Khoi;
import projectManagementSchool.model.hocSinhTrongLop;

public class QuanLyLop extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JComboBox<Khoi> cboKhoi;
	private JLabel lblId, lblMaLop, lblMaHocSinh, lblGioiTinh, lblTenHocSinh, lblTuoi, lblHanhKiem, lblGhiChu;
	private JTextField txtId, txtMaLop, txtMaHocSinh, txtGioiTinh, txtTenHocSinh, txtTuoi, txtHanhKiem, txtGhiChu;
	private JButton btnAdd, btnDelete, btnClean, btnUpdate;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;

	public QuanLyLop(String title) {
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {

	}

	public JPanel addControls() {

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel qlsv = new JPanel();
		qlsv.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbqlsv = new JLabel("QUẢN LÝ HỌC SINH TRONG LỚP");
		lbqlsv.setForeground(Color.blue);
		lbqlsv.setFont(new Font("Time New Roman", Font.BOLD, 30));
		qlsv.add(lbqlsv);
		pnMain.add(qlsv);

//		JPanel pnKhoi = new JPanel();
//		pnKhoi.setLayout(new FlowLayout(FlowLayout.CENTER));
//		pnMain.add(pnKhoi);
//		JLabel lblKhoi = new JLabel("Chọn Khối: ");
//		cboKhoi = new JComboBox<Khoi>();
//		cboKhoi.setPreferredSize(new Dimension(200, 25));
//		pnKhoi.add(lblKhoi);
//		pnKhoi.add(cboKhoi);

//		JPanel pnLop = new JPanel();
//		pnLop.setLayout(new FlowLayout(FlowLayout.CENTER));
//		pnMain.add(pnKhoi);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new GridLayout(2, 5));

		Border BorderChiTiet = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderChiTiet = new TitledBorder(BorderChiTiet, "Chi Tiết");
		titledBorderChiTiet.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titledBorderChiTiet.setTitleColor(Color.red);
		pnChiTiet.setBorder(titledBorderChiTiet);

		JPanel pnId = new JPanel();
//		pnId.setLayout(new FlowLayout());
		lblId = new JLabel("Id: ");
		txtId = new JTextField(15);
		pnId.add(lblId);
		pnId.add(txtId);
//		pnChiTiet.add(pnId);

		JPanel pnMaLop = new JPanel();
		pnMaLop.setLayout(new FlowLayout());
		lblMaLop = new JLabel("Mã Lớp: ");
		txtMaLop = new JTextField(15);
		pnMaLop.add(lblMaLop);
		pnMaLop.add(txtMaLop);
		pnChiTiet.add(pnMaLop);

		JPanel pnMaHocSinh = new JPanel();
		pnMaHocSinh.setLayout(new FlowLayout());
		lblMaHocSinh = new JLabel("Mã Học Sinh: ");
		txtMaHocSinh = new JTextField(15);
		pnMaHocSinh.add(lblMaHocSinh);
		pnMaHocSinh.add(txtMaHocSinh);
		pnChiTiet.add(pnMaHocSinh);

		JPanel pnHocSinh = new JPanel();
		pnHocSinh.setLayout(new FlowLayout());
		lblTenHocSinh = new JLabel("Tên Học Sinh: ");
		txtTenHocSinh = new JTextField(15);
		pnHocSinh.add(lblTenHocSinh);
		pnHocSinh.add(txtTenHocSinh);
		pnChiTiet.add(pnHocSinh);

		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setLayout(new FlowLayout());
		lblGioiTinh = new JLabel("Giới Tính: ");
		txtGioiTinh = new JTextField(15);
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(txtGioiTinh);
		pnChiTiet.add(pnGioiTinh);

		JPanel pnTuoi = new JPanel();
		pnTuoi.setLayout(new FlowLayout());
		lblTuoi = new JLabel("Ngày Sinh: ");
		txtTuoi = new JTextField(15);
		pnTuoi.add(lblTuoi);
		pnTuoi.add(txtTuoi);
		pnChiTiet.add(pnTuoi);

		JPanel pnHanhKiem = new JPanel();
		pnHanhKiem.setLayout(new FlowLayout());
		lblHanhKiem = new JLabel("Hạnh Kiểm: ");
		txtHanhKiem = new JTextField(15);
		pnHanhKiem.add(lblHanhKiem);
		pnHanhKiem.add(txtHanhKiem);
		pnChiTiet.add(pnHanhKiem);

		JPanel pnGhiChu = new JPanel();
		pnGhiChu.setLayout(new FlowLayout());
		lblGhiChu = new JLabel("Ghi Chú: ");
		txtGhiChu = new JTextField(15);
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnChiTiet.add(pnGhiChu);

		pnMain.add(pnChiTiet);

		lblMaLop.setPreferredSize(lblTuoi.getPreferredSize());
		lblHanhKiem.setPreferredSize(lblMaHocSinh.getPreferredSize());
		lblGhiChu.setPreferredSize(lblTenHocSinh.getPreferredSize());
		
			
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));

		Border BorderButton = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton = new TitledBorder(BorderButton, "Chọn Chức Năng");
		titledBorderButton.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton.setTitleColor(Color.red);
		pnButton.setBorder(titledBorderButton);

		btnAdd = new JButton("Add");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnClean = new JButton("Clean");
		pnButton.add(btnAdd);
		pnButton.add(btnUpdate);
		pnButton.add(btnDelete);
		pnButton.add(btnClean);
		pnMain.add(pnButton);

		btnAdd.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClean.addActionListener(this);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setLayout(new BorderLayout());

		Border BorderDanhSach = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titleBorderDanhSach = new TitledBorder(BorderDanhSach, "Danh Sách");
		titleBorderDanhSach.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.red);
		pnDanhSach.setBorder(titleBorderDanhSach);

		table = new DefaultTableModel();
		table.addColumn("Id");
		table.addColumn("Mã Lớp");
		table.addColumn("Mã Học Sinh");
		table.addColumn("Tên Học Sinh");
		table.addColumn("Giới Tính");
		table.addColumn("Ngày Sinh");
		table.addColumn("Hạnh Kiểm");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnDanhSach.add(sc);

		pnMain.add(pnDanhSach);

		loadDataforTableUser();

		return pnMain;

	}

	private void loadDataforTableUser() {
		// TODO Auto-generated method stub
		// xoa du lieu cu
		table.setRowCount(0);

		// su dung ham UserDao#getAllUser() de lay tat ca thong tin user trong database
		List<hocSinhTrongLop> listUser = userDaoQuanLyHocSinhTrongLop.getAllUser();

		// duyet danh sach user lay tu database va them vao table

		for (hocSinhTrongLop hstl : listUser) {
			table.addRow(new String[] { "" + hstl.getId(), hstl.getMaLop(), hstl.getMaHocSinh(), hstl.getTenHocSinh(),
					hstl.getGioiTinh(), hstl.getNgaySinh(), hstl.getHanhKiem(), hstl.getGhiChu() });
		}
	}



	public void showWindown() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void clearInputInfoLop() {
		txtMaHocSinh.setText("");
		txtMaLop.setText("");
		txtId.setText("");
		txtTenHocSinh.setText("");
		txtGioiTinh.setText("");
		txtTuoi.setText("");
		txtHanhKiem.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDaoQuanLyHocSinhTrongLop.deleteUser(username);
	}

	private void updateUser() {
		hocSinhTrongLop hstl = new hocSinhTrongLop();

		hstl.setId(txtId.getText());
		hstl.setMaLop(txtMaLop.getText());
		hstl.setMaHocSinh(txtMaHocSinh.getText());
		hstl.setTenHocSinh(txtTenHocSinh.getText());
		hstl.setGioiTinh(txtGioiTinh.getText());
		hstl.setNgaySinh(txtTuoi.getText());
		hstl.setHanhKiem(txtHanhKiem.getText());
		hstl.setGhiChu(txtGhiChu.getText());
		userDaoQuanLyHocSinhTrongLop.updateUser(hstl);
	}

	private void addUser() {
		hocSinhTrongLop hstl = new hocSinhTrongLop();
		hstl.setId(txtId.getText());
		hstl.setMaLop(txtMaLop.getText());
		hstl.setMaHocSinh(txtMaHocSinh.getText());
		hstl.setTenHocSinh(txtTenHocSinh.getText());
		hstl.setGioiTinh(txtGioiTinh.getText());
		hstl.setNgaySinh(txtTuoi.getText());
		hstl.setHanhKiem(txtHanhKiem.getText());
		hstl.setGhiChu(txtGhiChu.getText());

		userDaoQuanLyHocSinhTrongLop.addUser(hstl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAdd) {
			addUser();
			loadDataforTableUser();
		} else if (action == btnUpdate) {
			updateUser();
			loadDataforTableUser();
		} else if (action == btnDelete) {
			deleteUser();
			loadDataforTableUser();
		} else {
			clearInputInfoLop();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = tab.getSelectedRow();
		// idUser = Integer.parseInt((String) jTable.getValueAt(rowSelected, 0));
		txtId.setText((String) tab.getValueAt(rowSelected, 0));
		txtMaLop.setText((String) tab.getValueAt(rowSelected, 1));
		txtMaHocSinh.setText((String) tab.getValueAt(rowSelected, 2));
		txtTenHocSinh.setText((String) tab.getValueAt(rowSelected, 3));
		txtGioiTinh.setText((String) tab.getValueAt(rowSelected, 4));
		txtTuoi.setText((String) tab.getValueAt(rowSelected, 5));
		txtHanhKiem.setText((String) tab.getValueAt(rowSelected, 6));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected, 7));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
