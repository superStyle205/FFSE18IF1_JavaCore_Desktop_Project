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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import projectManagementSchool.UserDao.userDaoQuanLyHoSoHocSinh;
import projectManagementSchool.UserDao.userDaoQuanLyHocSinhTrongLop;
import projectManagementSchool.model.Khoi;
import projectManagementSchool.model.Lop;
import projectManagementSchool.model.hoSoHocSinh;
import projectManagementSchool.model.hocSinhTrongLop;

public class QuanLyHoSoHocSinh extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JComboBox<Khoi> cboKhoi;
	private JComboBox<Lop> cboLop;
	private JLabel lblId,lblMaHocSinh, lblTenHocSinh, lblGioiTinh, lblTuoi, lblDiaChi, lblSoDienThoai, lblTenCha, lblTenMe,
			lblEmail, lblGhiChu, lblNoiSinh, lblMaLop;
	private JTextField txtId,txtTenHocSinh,txtMaHocSinh, txtGioiTinh, txtTuoi, txtDiaChi, txtSoDienThoai, txtTenCha, txtTenMe, txtEmail,
			txtGhiChu, txtNoiSinh, txtMaLop;
	private JButton btnAdd, btnDelete, btnClean, btnUpdate;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;

	public QuanLyHoSoHocSinh(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}

	public JPanel addControls() {
		// TODO Auto-generated method stub

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel qlsv = new JPanel();
		qlsv.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbqlsv = new JLabel("QUẢN LÝ HỒ SƠ HỌC SINH");
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
//
//		JPanel pnLop = new JPanel();
//		pnLop.setLayout(new FlowLayout(FlowLayout.CENTER));
//		pnMain.add(pnKhoi);
//		JLabel lblLop = new JLabel("Chọn Lớp: ");
//		cboLop = new JComboBox<Lop>();
//		cboLop.setPreferredSize(new Dimension(200, 25));
//		pnKhoi.add(lblLop);
//		pnKhoi.add(cboLop);
//
//		pnMain.add(pnKhoi);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new GridLayout(4, 5));

		Border BorderChiTiet = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderChiTiet = new TitledBorder(BorderChiTiet, "Chi Tiết");
		titledBorderChiTiet.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titledBorderChiTiet.setTitleColor(Color.red);
		pnChiTiet.setBorder(titledBorderChiTiet);
		
//		JPanel pnId= new JPanel();
//		pnId.setLayout(new FlowLayout());
		lblId = new JLabel();
		txtId = new JTextField(15);
//		pnId.add(lblId);
//		pnId.add(txtId);
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

		JPanel pnNoiSinh = new JPanel();
		pnNoiSinh.setLayout(new FlowLayout());
		lblNoiSinh = new JLabel("Nơi Sinh: ");
		txtNoiSinh = new JTextField(15);
		pnNoiSinh.add(lblNoiSinh);
		pnNoiSinh.add(txtNoiSinh);
		pnChiTiet.add(pnNoiSinh);

		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		lblDiaChi = new JLabel("Địa Chỉ: ");
		txtDiaChi = new JTextField(15);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnChiTiet.add(pnDiaChi);

		JPanel pnEmail = new JPanel();
		pnEmail.setLayout(new FlowLayout());
		lblEmail = new JLabel("Email: ");
		txtEmail = new JTextField(15);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnChiTiet.add(pnEmail);

		JPanel pnTenCha = new JPanel();
		pnTenCha.setLayout(new FlowLayout());
		lblTenCha = new JLabel("Họ tên Bố: ");
		txtTenCha = new JTextField(15);
		pnTenCha.add(lblTenCha);
		pnTenCha.add(txtTenCha);
		pnChiTiet.add(pnTenCha);

		JPanel pnTenMe = new JPanel();
		pnTenMe.setLayout(new FlowLayout());
		lblTenMe = new JLabel("Họ tên Mẹ: ");
		txtTenMe = new JTextField(15);
		pnTenMe.add(lblTenMe);
		pnTenMe.add(txtTenMe);
		pnChiTiet.add(pnTenMe);

		JPanel pnSoDienThoai = new JPanel();
		pnSoDienThoai.setLayout(new FlowLayout());
		lblSoDienThoai = new JLabel("Số Điện Thoại: ");
		txtSoDienThoai = new JTextField(15);
		pnSoDienThoai.add(lblSoDienThoai);
		pnSoDienThoai.add(txtSoDienThoai);
		pnChiTiet.add(pnSoDienThoai);

		JPanel pnGhiChu = new JPanel();
		pnGhiChu.setLayout(new FlowLayout());
		lblGhiChu = new JLabel("Ghi Chú: ");
		txtGhiChu = new JTextField(15);
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnChiTiet.add(pnGhiChu);

		lblMaLop.setPreferredSize(lblTenMe.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTenMe.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTenMe.getPreferredSize());
		lblMaHocSinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblTuoi.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblEmail.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblNoiSinh.setPreferredSize(lblTenHocSinh.getPreferredSize());
		lblTenCha.setPreferredSize(lblTenHocSinh.getPreferredSize());
		lblGhiChu.setPreferredSize(lblTenHocSinh.getPreferredSize());
		

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
		table.addColumn("Mã Lớp");
		table.addColumn("Mã Học Sinh");
		table.addColumn("Tên Học Sinh");
		table.addColumn("Giới Tính");
		table.addColumn("Ngày Sinh");
		table.addColumn("Nơi Sinh");
		table.addColumn("Địa Chỉ");
		table.addColumn("Email");
		table.addColumn("Họ Tên Bố");
		table.addColumn("Họ Tên Mẹ");
		table.addColumn("Số Điện Thoại");
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
		List<hoSoHocSinh> listUser = userDaoQuanLyHoSoHocSinh.getAllUser();

		// duyet danh sach user lay tu database va them vao table
		for (hoSoHocSinh hshs : listUser) {
			table.addRow(new String[] { "" + hshs.getId(), hshs.getMaLop(), hshs.getMaHocSinh(), hshs.getTenHocSinh(),
					hshs.getGioiTinh(), hshs.getNgaySinh(), hshs.getNoiSinh(), hshs.getDiaChi(), hshs.getEmail(),
					hshs.getHoTenBo(), hshs.getHoTenMe(), hshs.getSoDienThoai(), hshs.getGhiChu() });
		}
	}

	public void showWindown() {
		this.setSize(1100, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void clearInputInfoLop() {
		txtId.setText("");
		txtMaLop.setText("");
		txtMaHocSinh.setText("");
		txtTenHocSinh.setText("");
		txtGioiTinh.setText("");
		txtTuoi.setText("");
		txtNoiSinh.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtTenCha.setText("");
		txtTenMe.setText("");
		txtSoDienThoai.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDaoQuanLyHoSoHocSinh.deleteUser(username);
	}

	private void updateUser() {
		hoSoHocSinh hshs = new hoSoHocSinh();

		hshs.setId(txtId.getText());
		hshs.setMaLop(txtMaLop.getText());
		hshs.setMaHocSinh(txtMaHocSinh.getText());
		hshs.setTenHocSinh(txtTenHocSinh.getText());
		hshs.setGioiTinh(txtGioiTinh.getText());
		hshs.setNgaySinh(txtTuoi.getText());
		hshs.setNoiSinh(txtNoiSinh.getText());
		hshs.setDiaChi(txtDiaChi.getText());
		hshs.setEmail(txtEmail.getText());
		hshs.setHoTenBo(txtTenCha.getText());
		hshs.setHoTenMe(txtTenMe.getText());
		hshs.setSoDienThoai(txtSoDienThoai.getText());
		hshs.setGhiChu(txtGhiChu.getText());
		userDaoQuanLyHoSoHocSinh.updateUser(hshs);
	}

	private void addUser() {
		hoSoHocSinh hshs = new hoSoHocSinh();

		hshs.setId(txtId.getText());
		hshs.setMaLop(txtMaLop.getText());
		hshs.setMaHocSinh(txtMaHocSinh.getText());
		hshs.setTenHocSinh(txtTenHocSinh.getText());
		hshs.setGioiTinh(txtGioiTinh.getText());
		hshs.setNgaySinh(txtTuoi.getText());
		hshs.setNoiSinh(txtNoiSinh.getText());
		hshs.setDiaChi(txtDiaChi.getText());
		hshs.setEmail(txtEmail.getText());
		hshs.setHoTenBo(txtTenCha.getText());
		hshs.setHoTenMe(txtTenMe.getText());
		hshs.setSoDienThoai(txtSoDienThoai.getText());
		hshs.setGhiChu(txtGhiChu.getText());

		userDaoQuanLyHoSoHocSinh.addUser(hshs);
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
		txtNoiSinh.setText((String) tab.getValueAt(rowSelected, 6));
		txtDiaChi.setText((String) tab.getValueAt(rowSelected, 7));
		txtEmail.setText((String) tab.getValueAt(rowSelected, 8));
		txtTenCha.setText((String) tab.getValueAt(rowSelected, 9));
		txtTenMe.setText((String) tab.getValueAt(rowSelected, 10));
		txtSoDienThoai.setText((String) tab.getValueAt(rowSelected, 11));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected, 12));
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
