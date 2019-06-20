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

import projectManagementSchool.UserDao.userDaoQuanLyLop;
import projectManagementSchool.model.Khoi;
import projectManagementSchool.model.Lop;

public class QuanLyKhoi extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JComboBox<Khoi> cboKhoi;
	private JLabel lblId,lblTenLop, lblMaLop, lblGiaoVienChuNhiem, lbMaGiaoVien, lblNienKhoa, lblGhiChu, lblMaKhoi;
	private JTextField txtId,txtTimKiem, txtTenLop, txtMaLop, txtGiaoVienChuNhiem, txtMaGiaoVien, txtNienKhoa, txtGhiChu,
			txtMaKhoi;
	private JButton btnAdd, btnDelete, btnClean, btnUpdate, btnTimKiem, btnThoat;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;

	private userDaoQuanLyLop userDao;

	public QuanLyKhoi(String title) {
		super(title);
		addControlsQuanLyKhoi();
		addEvents();
	}

	private void addEvents() {

	}

	public JPanel addControlsQuanLyKhoi() {

		userDao = new userDaoQuanLyLop();

		JPanel pnMainQuanLyKhoi = new JPanel();
		pnMainQuanLyKhoi.setLayout(new BoxLayout(pnMainQuanLyKhoi, BoxLayout.Y_AXIS));

		JPanel pnKhoi = new JPanel();
		pnKhoi.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnMainQuanLyKhoi.add(pnKhoi);

		JPanel pnQuanLyLop = new JPanel();
		pnQuanLyLop.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblQuanLyGiaoVien = new JLabel("QUẢN LÝ LỚP");
		lblQuanLyGiaoVien.setFont(new Font("Time New Roman", Font.BOLD, 30));
		lblQuanLyGiaoVien.setForeground(Color.blue);
		pnQuanLyLop.add(lblQuanLyGiaoVien);
		pnMainQuanLyKhoi.add(pnQuanLyLop);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		txtTimKiem = new JTextField(15);
		btnTimKiem = new JButton("Tìm Kiếm");
		btnThoat = new JButton("Thoát");
		pnTimKiem.add(txtTimKiem);
		pnTimKiem.add(btnTimKiem);
		pnTimKiem.add(btnThoat);

		pnMainQuanLyKhoi.add(pnTimKiem);

//		JLabel lblKhoi = new JLabel("Chọn Khối: ");
//		cboKhoi = new JComboBox<Khoi>();
//		cboKhoi.setPreferredSize(new Dimension(200, 25));
//		pnKhoi.add(lblKhoi);
//		pnKhoi.add(cboKhoi);
//
//		pnMainQuanLyKhoi.add(pnKhoi);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new GridLayout(2, 5));

		Border BorderChiTiet = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderChiTiet = new TitledBorder(BorderChiTiet, "Chi Tiết");
		titledBorderChiTiet.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titledBorderChiTiet.setTitleColor(Color.red);
		pnChiTiet.setBorder(titledBorderChiTiet);

		JPanel pnId = new JPanel();
		lblId = new JLabel("Id: ");
		txtId = new JTextField(12);
		pnId.add(lblId);
		pnId.add(txtId);
//		pnChiTiet.add(pnId);
		
		JPanel pnMaKhoi = new JPanel();
		lblMaKhoi = new JLabel("Mã Khối: ");
		txtMaKhoi = new JTextField(12);
		pnMaKhoi.add(lblMaKhoi);
		pnMaKhoi.add(txtMaKhoi);
		pnChiTiet.add(pnMaKhoi);

		JPanel pnMaLop = new JPanel();
		lblMaLop = new JLabel("Mã Lớp: ");
		txtMaLop = new JTextField(12);
		pnMaLop.add(lblMaLop);
		pnMaLop.add(txtMaLop);
		pnChiTiet.add(pnMaLop);

		JPanel pnTenLop = new JPanel();
		lblTenLop = new JLabel("Tên Lớp: ");
		txtTenLop = new JTextField(15);
		pnTenLop.add(lblTenLop);
		pnTenLop.add(txtTenLop);
		pnChiTiet.add(pnTenLop);

		JPanel pnMaGiaoVien = new JPanel();
		lbMaGiaoVien = new JLabel("Mã Nhân Viên: ");
		txtMaGiaoVien = new JTextField(12);
		pnMaGiaoVien.add(lbMaGiaoVien);
		pnMaGiaoVien.add(txtMaGiaoVien);
		pnChiTiet.add(pnMaGiaoVien);

		JPanel pnGiaoVienChuNhiem = new JPanel();
		lblGiaoVienChuNhiem = new JLabel("Tên Nhân Viên: ");
		txtGiaoVienChuNhiem = new JTextField(15);
		pnGiaoVienChuNhiem.add(lblGiaoVienChuNhiem);
		pnGiaoVienChuNhiem.add(txtGiaoVienChuNhiem);
		pnChiTiet.add(pnGiaoVienChuNhiem);

		JPanel pnNienKhoa = new JPanel();
		lblNienKhoa = new JLabel("Niên Khóa: ");
		txtNienKhoa = new JTextField(12);
		pnNienKhoa.add(lblNienKhoa);
		pnNienKhoa.add(txtNienKhoa);
		pnChiTiet.add(pnNienKhoa);

		JPanel pnGhiChu = new JPanel();
		lblGhiChu = new JLabel("Ghi Chú: ");
		txtGhiChu = new JTextField(15);
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnChiTiet.add(pnGhiChu);

		lblMaKhoi.setPreferredSize(lbMaGiaoVien.getPreferredSize());
		lblMaLop.setPreferredSize(lblNienKhoa.getPreferredSize());
		lblGhiChu.setPreferredSize(lblTenLop.getPreferredSize());

		pnMainQuanLyKhoi.add(pnChiTiet);

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
		pnMainQuanLyKhoi.add(pnButton);

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
		table.addColumn("Mã Khối");
		table.addColumn("Mã Lớp");
		table.addColumn("Tên Lớp");
		table.addColumn("Mã Nhân Viên");
		table.addColumn("Tên Nhân Viên");
		table.addColumn("Niên Khóa");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnDanhSach.add(sc);
		pnMainQuanLyKhoi.add(pnDanhSach);

		loadDataforTableUser();

		return pnMainQuanLyKhoi;
	}

	private void loadDataforTableUser() {
		// TODO Auto-generated method stub
		// xoa du lieu cu
		table.setRowCount(0);

		// su dung ham UserDao#getAllUser() de lay tat ca thong tin user trong database
		List<Lop> listUser = userDao.getAllUser();

		// duyet danh sach user lay tu database va them vao table
		for (Lop lop : listUser) {
			table.addRow(new String[] { "" + lop.getId(), lop.getMaKhoi(), lop.getMaLop(), lop.getTenLop(), lop.getMaNhanVien(),
					lop.getTenNhanVien(), lop.getNienKhoa(), lop.getGhiChu() });
		}
	}

	public void showWindown() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void clearInputInfoLop() {
	
		txtId.setText("");
		txtMaKhoi.setText("");
		txtMaLop.setText("");
		txtTenLop.setText("");
		txtGiaoVienChuNhiem.setText("");
		txtMaGiaoVien.setText("");
		txtNienKhoa.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDao.deleteUser(username);
	}

	private void updateUser() {
		Lop lop = new Lop();

		lop.setId(txtId.getText());
		lop.setMaKhoi(txtMaKhoi.getText());
		lop.setMaLop(txtMaLop.getText());
		lop.setTenLop(txtTenLop.getText());
		lop.setMaNhanVien(txtMaGiaoVien.getText());
		lop.setTenNhanVien(txtGiaoVienChuNhiem.getText());
		lop.setNienKhoa(txtNienKhoa.getText());
		lop.setGhiChu(txtGhiChu.getText());
		userDao.updateUser(lop);
	}

	private void addUser() {
		Lop lop = new Lop();

		lop.setId(txtId.getText());
		lop.setMaKhoi(txtMaKhoi.getText());
		lop.setMaLop(txtMaLop.getText());
		lop.setTenLop(txtTenLop.getText());
		lop.setMaNhanVien(txtMaGiaoVien.getText());
		lop.setTenNhanVien(txtGiaoVienChuNhiem.getText());
		lop.setNienKhoa(txtNienKhoa.getText());
		lop.setGhiChu(txtGhiChu.getText());

		userDao.addUser(lop);
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
		txtId.setText((String) tab.getValueAt(rowSelected, 0));
		txtMaKhoi.setText((String) tab.getValueAt(rowSelected, 1));
		txtMaLop.setText((String) tab.getValueAt(rowSelected, 2));
		txtTenLop.setText((String) tab.getValueAt(rowSelected, 3));
		txtMaGiaoVien.setText((String) tab.getValueAt(rowSelected, 4));
		txtGiaoVienChuNhiem.setText((String) tab.getValueAt(rowSelected, 5));
		txtNienKhoa.setText((String) tab.getValueAt(rowSelected, 6));
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
