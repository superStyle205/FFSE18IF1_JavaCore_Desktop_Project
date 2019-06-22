package projectManagementSchool.QuanLy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

import projectManagementSchool.UserDao.userDaoQuanDLyDiemTungMon;
import projectManagementSchool.UserDao.userDaoQuanLyLuong;
import projectManagementSchool.model.Khoi;
import projectManagementSchool.model.Lop;
import projectManagementSchool.model.MonHoc;
import projectManagementSchool.model.diemTungMon;
import projectManagementSchool.model.hocKi;
import projectManagementSchool.model.salary;

public class QuanLyDiemTungMon extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lbCapNhatDiem;
	private JLabel lblId, lblMaLop, lblMaMon, lblMaHocKi, lblMaHocSinh, lblTenHocSinh, lblMieng, lblGhiChu, lbl15pLan1,
			lbl15pLan2, lbl45p, lblDiemHocKi, lblDiemTrungBinh;
	private JTextField txtId, txtMaLop, txtMaMon, txtMaHocKi, txtMaHocSinh, txtTenHocSinh, txtMiengLan1, txtGhiChu,
			txt15pLan1, txt15pLan2, txt45p, txtDiemHocKi, txtTimKiem, txtDiemTrungBinh;
	private JButton btnAdd, btnUpdate, btnDelete, btnClean, btnTimKiem, btnThoat;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;
	private userDaoQuanDLyDiemTungMon userDao;

	public QuanLyDiemTungMon(String title) {
		super(title);
		addControls();
		addEvends();

	}

	public JPanel addControls() {
		userDao = new userDaoQuanDLyDiemTungMon();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnCapNhatDiem = new JPanel();
		lbCapNhatDiem = new JLabel("QUẢN LÝ ĐIỂM HỌC SINH");
		lbCapNhatDiem.setForeground(Color.blue);
		lbCapNhatDiem.setFont(new Font("Time New Roman", Font.BOLD, 30));
		pnCapNhatDiem.add(lbCapNhatDiem);
		pnMain.add(pnCapNhatDiem);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		txtTimKiem = new JTextField(15);
		btnTimKiem = new JButton("Tìm Kiếm");
		btnThoat = new JButton("Thoát");
		pnTimKiem.add(txtTimKiem);
		pnTimKiem.add(btnTimKiem);
		pnTimKiem.add(btnThoat);

		pnMain.add(pnTimKiem);

		JPanel pnbtnNhapDiem = new JPanel();
		pnbtnNhapDiem.setLayout(new GridLayout(3, 4));

		Border BorderButton1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton1 = new TitledBorder(BorderButton1, "Nhập Điểm");
		titledBorderButton1.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton1.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton1.setTitleColor(Color.red);
		pnbtnNhapDiem.setBorder(titledBorderButton1);

		JPanel pnId = new JPanel();
		lblId = new JLabel("Id:");
		txtId = new JTextField(10);
		pnId.add(lblId);
		pnId.add(txtId);
//		pnbtnNhapDiem.add(pnMaLop);

		JPanel pnMaLop = new JPanel();
		lblMaLop = new JLabel("Mã Lớp:");
		txtMaLop = new JTextField(10);
		pnMaLop.add(lblMaLop);
		pnMaLop.add(txtMaLop);
		pnbtnNhapDiem.add(pnMaLop);

		JPanel pnMaMon = new JPanel();
		lblMaMon = new JLabel("Mã Môn:");
		txtMaMon = new JTextField(10);
		pnMaMon.add(lblMaMon);
		pnMaMon.add(txtMaMon);
		pnbtnNhapDiem.add(pnMaMon);

		JPanel pnMaHocKi = new JPanel();
		lblMaHocKi = new JLabel("Mã Học Kì:");
		txtMaHocKi = new JTextField(10);
		pnMaHocKi.add(lblMaHocKi);
		pnMaHocKi.add(txtMaHocKi);
		pnbtnNhapDiem.add(pnMaHocKi);

		JPanel pnMaHocSinh = new JPanel();
		lblMaHocSinh = new JLabel("Mã Học Sinh:");
		txtMaHocSinh = new JTextField(10);
		pnMaHocSinh.add(lblMaHocSinh);
		pnMaHocSinh.add(txtMaHocSinh);
		pnbtnNhapDiem.add(pnMaHocSinh);

		JPanel pnTenHocSinh = new JPanel();
		lblTenHocSinh = new JLabel("Tên Học Sinh: ");
		txtTenHocSinh = new JTextField(10);
		pnTenHocSinh.add(lblTenHocSinh);
		pnTenHocSinh.add(txtTenHocSinh);
		pnbtnNhapDiem.add(pnTenHocSinh);

		JPanel pnMiengLan1 = new JPanel();
		lblMieng = new JLabel("Miệng: ");
		txtMiengLan1 = new JTextField(10);
		pnMiengLan1.add(lblMieng);
		pnMiengLan1.add(txtMiengLan1);
		pnbtnNhapDiem.add(pnMiengLan1);

		JPanel pn15pLan1 = new JPanel();
		lbl15pLan1 = new JLabel("15p Lần 1: ");
		txt15pLan1 = new JTextField(10);
		pn15pLan1.add(lbl15pLan1);
		pn15pLan1.add(txt15pLan1);
		pnbtnNhapDiem.add(pn15pLan1);

		JPanel pn15pLan2 = new JPanel();
		lbl15pLan2 = new JLabel("15p Lần 2: ");
		txt15pLan2 = new JTextField(10);
		pn15pLan2.add(lbl15pLan2);
		pn15pLan2.add(txt15pLan2);
		pnbtnNhapDiem.add(pn15pLan2);

		JPanel pn45p = new JPanel();
		lbl45p = new JLabel("1 Tiết: ");
		txt45p = new JTextField(10);
		pn45p.add(lbl45p);
		pn45p.add(txt45p);
		pnbtnNhapDiem.add(pn45p);

		JPanel pnDiemHocKi = new JPanel();
		lblDiemHocKi = new JLabel("Điểm Học Kì: ");
		txtDiemHocKi = new JTextField(10);
		pnDiemHocKi.add(lblDiemHocKi);
		pnDiemHocKi.add(txtDiemHocKi);
		pnbtnNhapDiem.add(pnDiemHocKi);

		txtDiemTrungBinh = new JTextField(10);

		JPanel pnGhiChu = new JPanel();
		lblGhiChu = new JLabel("Ghi chú: ");
		txtGhiChu = new JTextField(10);
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnbtnNhapDiem.add(pnGhiChu);

		lblMaLop.setPreferredSize(lblTenHocSinh.getPreferredSize());
		lbl45p.setPreferredSize(lblTenHocSinh.getPreferredSize());
		lblMieng.setPreferredSize(lblDiemHocKi.getPreferredSize());
		lblMaMon.setPreferredSize(lblDiemHocKi.getPreferredSize());
		lbl15pLan1.setPreferredSize(lblMaHocKi.getPreferredSize());
		lblGhiChu.setPreferredSize(lblMaHocKi.getPreferredSize());
		lbl15pLan2.setPreferredSize(lblMaHocSinh.getPreferredSize());

		pnMain.add(pnbtnNhapDiem);

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

		btnAdd.setForeground(Color.blue);
		btnUpdate.setForeground(Color.blue);
		btnDelete.setForeground(Color.blue);
		btnClean.setForeground(Color.blue);

		btnAdd.setPreferredSize(btnUpdate.getPreferredSize());
		btnDelete.setPreferredSize(btnUpdate.getPreferredSize());
		btnClean.setPreferredSize(btnUpdate.getPreferredSize());

		btnAdd.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClean.addActionListener(this);
		btnTimKiem.addActionListener(this);

		pnMain.add(pnButton);

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
		table.addColumn("Mã Môn");
		table.addColumn("Mã Học Kì");
		table.addColumn("Mã Học Sinh");
		table.addColumn("Tên Học Sinh");
		table.addColumn("Miệng");
		table.addColumn("15p lần 1");
		table.addColumn("15p lần 2");
		table.addColumn("1 tiết ");
		table.addColumn("Điểm Học Kì");
		table.addColumn("Điểm Trung Bình");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnDanhSach.add(sc);
		pnMain.add(pnDanhSach);

		loadDataforTableUser();

		return pnMain;
	}

	private void addEvends() {

	}

	private void loadDataforTableUser() {
		// TODO Auto-generated method stub
		// xoa du lieu cu
		table.setRowCount(0);

		// su dung ham UserDao#getAllUser() de lay tat ca thong tin user trong database
		List<diemTungMon> listUser = userDao.getAllUser();

		// duyet danh sach user lay tu database va them vao table
		for (diemTungMon dtm : listUser) {
			table.addRow(new String[] { "" + dtm.getId(), dtm.getMaLop(), dtm.getMaMon(), dtm.getMaHocKi(),
					dtm.getMaHocSinh(), dtm.getTenHocSinh(), "" + dtm.getMieng(), "" + dtm.getDiem15pLan1(),
					"" + dtm.getDiem15pLan2(), "" + dtm.getDiem1Tiet(), "" + dtm.getDiemHocKi(),
					"" + dtm.getDiemTrungBinh(), dtm.getGhiChu() });
		}
	}

	private void clearInputInfoLop() {

		txtMaLop.setText("");
		txtMaMon.setText("");
		txtMaHocKi.setText("");
		txtMaHocSinh.setText("");
		txtTenHocSinh.setText("");
		txtMiengLan1.setText("");
		txt15pLan1.setText("");
		txt15pLan2.setText("");
		txt45p.setText("");
		txtDiemHocKi.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDao.deleteUser(username);
	}

	private void updateUser() {
		diemTungMon dtm = new diemTungMon();

		dtm.setId(txtId.getText());
		dtm.setMaLop(txtMaLop.getText());
		dtm.setMaMon(txtMaMon.getText());
		dtm.setMaHocKi(txtMaHocKi.getText());
		dtm.setMaHocSinh(txtMaHocSinh.getText());
		dtm.setTenHocSinh(txtTenHocSinh.getText());
		dtm.setMieng(Double.parseDouble(txtMiengLan1.getText()));
		dtm.setDiem15pLan1(Double.parseDouble(txt15pLan1.getText()));
		dtm.setDiem15pLan2(Double.parseDouble(txt15pLan2.getText()));
		dtm.setDiem1Tiet(Double.parseDouble(txt45p.getText()));
		dtm.setDiemHocKi(Double.parseDouble(txtDiemHocKi.getText()));
		Double diemTrungBinh = (Double.parseDouble(txtMiengLan1.getText()) + Double.parseDouble(txt15pLan1.getText())
				+ Double.parseDouble(txt15pLan2.getText()) + (Double.parseDouble(txt45p.getText()) * 2)
				+ (Double.parseDouble(txtDiemHocKi.getText()) * 3)) / 8;
		dtm.setDiemTrungBinh(diemTrungBinh);
		dtm.setGhiChu(txtGhiChu.getText());

		userDao.updateUser(dtm);
	}

	private void addUser() {
		diemTungMon dtm = new diemTungMon();

		dtm.setId(txtId.getText());
		dtm.setMaLop(txtMaLop.getText());
		dtm.setMaMon(txtMaMon.getText());
		dtm.setMaHocKi(txtMaHocKi.getText());
		dtm.setMaHocSinh(txtMaHocSinh.getText());
		dtm.setTenHocSinh(txtTenHocSinh.getText());
		dtm.setMieng(Double.parseDouble(txtMiengLan1.getText()));
		dtm.setDiem15pLan1(Double.parseDouble(txt15pLan1.getText()));
		dtm.setDiem15pLan2(Double.parseDouble(txt15pLan2.getText()));
		dtm.setDiem1Tiet(Double.parseDouble(txt45p.getText()));
		dtm.setDiemHocKi(Double.parseDouble(txtDiemHocKi.getText()));
		dtm.setDiemTrungBinh(dtm.getDiemTrungBinh());
		dtm.setGhiChu(txtGhiChu.getText());

		userDao.addUser(dtm);
	}

	private void search() {
		table.setRowCount(0);
		String magiaovien = txtTimKiem.getText();

		userDaoQuanDLyDiemTungMon userDao = new userDaoQuanDLyDiemTungMon();
		diemTungMon dtm = new diemTungMon();
		dtm = userDao.search(magiaovien);

		table.addRow(new String[] { "" + dtm.getId(), dtm.getMaLop(), dtm.getMaMon(), dtm.getMaHocKi(),
				dtm.getMaHocSinh(), dtm.getTenHocSinh(), "" + dtm.getMieng(), "" + dtm.getDiem15pLan1(),
				"" + dtm.getDiem15pLan2(), "" + dtm.getDiem1Tiet(), "" + dtm.getDiemHocKi(),
				"" + dtm.getDiemTrungBinh(), dtm.getGhiChu() });
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
		} else if (action == btnTimKiem) {
			search();
		} else {
			clearInputInfoLop();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = tab.getSelectedRow();

		txtId.setText((String) tab.getValueAt(rowSelected, 0));
		txtMaLop.setText((String) tab.getValueAt(rowSelected, 1));
		txtMaMon.setText((String) tab.getValueAt(rowSelected, 2));
		txtMaHocKi.setText((String) tab.getValueAt(rowSelected, 3));
		txtMaHocSinh.setText((String) tab.getValueAt(rowSelected, 4));
		txtTenHocSinh.setText((String) tab.getValueAt(rowSelected, 5));
		txtMiengLan1.setText((String) tab.getValueAt(rowSelected, 6));
		txt15pLan1.setText((String) tab.getValueAt(rowSelected, 7));
		txt15pLan2.setText((String) tab.getValueAt(rowSelected, 8));
		txt45p.setText((String) tab.getValueAt(rowSelected, 9));
		txtDiemHocKi.setText((String) tab.getValueAt(rowSelected, 10));
		txtDiemTrungBinh.setText((String) tab.getValueAt(rowSelected, 11));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected, 12));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
