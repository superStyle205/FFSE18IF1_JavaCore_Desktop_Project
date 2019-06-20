package projectManagementSchool.QuanLy;

import java.awt.BorderLayout;
import java.awt.Color;
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
import projectManagementSchool.UserDao.userDaoQuanLyMonHoc;
import projectManagementSchool.model.MonHoc;
import projectManagementSchool.model.hocSinhTrongLop;

public class quanLyMonHoc extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblId,lblMaMon, lblTenMon, lblTenGiaoVienBoMon, lblMaGiaoVienBoMon, lblSoTiet, lblThongTinMon, lblGhiChu;
	private JTextField txtId,txtMaMon, txtTenMon, txtTenGiaoVienBoMon, txtMaGiaoVienBoMon, txtSoTiet, txtTimKiem, txtGhiChu;
	private JButton btnTimKiem, btnThoat, btnAdd, btnUpdate, btnDelete, btnClean;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;

	public quanLyMonHoc(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addControls();
		addEvents();
	}

	public JPanel addControls() {
		// TODO Auto-generated method stub
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnThongTinLuong = new JPanel();
		lblThongTinMon = new JLabel("THÔNG TIN MÔN HỌC");
		lblThongTinMon.setForeground(Color.blue);
		lblThongTinMon.setFont(new Font("Time New Roman", Font.BOLD, 30));
		lblThongTinMon.setLayout(new BoxLayout(lblThongTinMon, BoxLayout.Y_AXIS));
		pnThongTinLuong.add(lblThongTinMon);
		pnMain.add(pnThongTinLuong);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		txtTimKiem = new JTextField(15);
		btnTimKiem = new JButton("Tìm Kiếm");
		btnThoat = new JButton("Thoát");
		pnTimKiem.add(txtTimKiem);
		pnTimKiem.add(btnTimKiem);
		pnTimKiem.add(btnThoat);

		pnMain.add(pnTimKiem);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new GridLayout(2, 5));

		Border BorderChiTiet = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderChiTiet = new TitledBorder(BorderChiTiet, "Chi Tiết");
		titledBorderChiTiet.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titledBorderChiTiet.setTitleColor(Color.red);
		pnChiTiet.setBorder(titledBorderChiTiet);

		JPanel pnId = new JPanel();
		lblId = new JLabel("Id:");
		txtId = new JTextField(10);
		pnId.add(lblId);
		pnId.add(txtId);
//		pnChiTiet.add(pnId);
		
		JPanel pnMaMon = new JPanel();
		lblMaMon = new JLabel("Mã Môn:");
		txtMaMon = new JTextField(10);
		pnMaMon.add(lblMaMon);
		pnMaMon.add(txtMaMon);
		pnChiTiet.add(pnMaMon);

		JPanel pnTenMon = new JPanel();
		lblTenMon = new JLabel("Tên Môn: ");
		txtTenMon = new JTextField(10);
		pnTenMon.add(lblTenMon);
		pnTenMon.add(txtTenMon);
		pnChiTiet.add(pnTenMon);

		JPanel pnMaGiaoVienBoMon = new JPanel();
		lblMaGiaoVienBoMon = new JLabel("Mã Giáo Viên Bộ Môn: ");
		txtMaGiaoVienBoMon = new JTextField(10);
		pnMaGiaoVienBoMon.add(lblMaGiaoVienBoMon);
		pnMaGiaoVienBoMon.add(txtMaGiaoVienBoMon);
		pnChiTiet.add(pnMaGiaoVienBoMon);

		JPanel pnSoTiet = new JPanel();
		lblSoTiet = new JLabel("Số Tiết Dạy:");
		txtSoTiet = new JTextField(10);
		pnSoTiet.add(lblSoTiet);
		pnSoTiet.add(txtSoTiet);
		pnChiTiet.add(pnSoTiet);

		JPanel pnGhiChu = new JPanel();
		lblGhiChu = new JLabel("Ghi Chú:");
		txtGhiChu = new JTextField(10);
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnChiTiet.add(pnGhiChu);

		lblMaMon.setPreferredSize(lblSoTiet.getPreferredSize());
		lblGhiChu.setPreferredSize(lblTenMon.getPreferredSize());

		pnMain.add(pnChiTiet);

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
		table.addColumn("Mã Môn");
		table.addColumn("Tên Môn");
		table.addColumn("Mã Giáo Viên Bộ Môn");
		table.addColumn("Số Tiết Dạy");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab);

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
		List<MonHoc> listUser = userDaoQuanLyMonHoc.getAllUser();

		// duyet danh sach user lay tu database va them vao table
		for (MonHoc mh : listUser) {
			table.addRow(new String[] { "" + mh.getId(), mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getMaNhanVien(), mh.getSoTietDay(),
					mh.getGhiChu() });
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}

	private void clearInputInfoLop() {
		txtId.setText("");
		txtMaMon.setText("");
		txtTenMon.setText("");
		txtMaGiaoVienBoMon.setText("");
		txtSoTiet.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDaoQuanLyMonHoc.deleteUser(username);
	}

	private void updateUser() {
		MonHoc mh = new MonHoc();
		
		mh.setId(txtId.getText());
		mh.setMaMonHoc(txtMaMon.getText());
		mh.setTenMonHoc(txtTenMon.getText());
		mh.setMaNhanVien(txtMaGiaoVienBoMon.getText());
		mh.setSoTietDay(txtSoTiet.getText());
		mh.setGhiChu(txtGhiChu.getText());
		userDaoQuanLyMonHoc.updateUser(mh);
	}

	private void addUser() {
		MonHoc mh = new MonHoc();

		mh.setId(txtId.getText());
		mh.setMaMonHoc(txtMaMon.getText());
		mh.setTenMonHoc(txtTenMon.getText());
		mh.setMaNhanVien(txtMaGiaoVienBoMon.getText());
		mh.setSoTietDay(txtSoTiet.getText());
		mh.setGhiChu(txtGhiChu.getText());

		userDaoQuanLyMonHoc.addUser(mh);
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
		txtMaMon.setText((String) tab.getValueAt(rowSelected, 1));
		txtTenMon.setText((String) tab.getValueAt(rowSelected, 2));
		txtMaGiaoVienBoMon.setText((String) tab.getValueAt(rowSelected, 3));
		txtSoTiet.setText((String) tab.getValueAt(rowSelected, 4));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected, 5));
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
