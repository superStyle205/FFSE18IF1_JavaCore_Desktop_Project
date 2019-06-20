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
import java.io.Serializable;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import projectManagementSchool.UserDao.userDaoQuanLyMonHoc;
import projectManagementSchool.UserDao.userDaoQuanLyNhanSu;
import projectManagementSchool.model.MonHoc;
import projectManagementSchool.model.giangVien;
import projectManagementSchool.model.phongBan;

public class QuanLyNhanSu extends JFrame implements Serializable, ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JComboBox<phongBan> cboPhongBan;
	private JLabel lblId, lblMaPhongBan, lblMaNhanVien, lblMaMonHoc, lblTen, lblNgayVaoLam, lblNamSinh, lblDiaChi,
			lblEmail, lblChucVu, lblDanToc, lblTonGiao, lblSdt, lblNguyenQuan, lblQueQuan, lblGhiChu;
	private JTextField txtId, txtTimKiem, txtMaPhongBan, txtMaNhanVien, txtMaMonHoc, txtTen, txtNgayVaoLam, txtNamSinh,
			txtDiaChi, txtEmail, txtChucVu, txtDanToc, txtTonGiao, txtSdt, txtQueQuan, txtNguyenQuan, txtGhiChu;
	private JButton btnAdd, btnDelete, btnTimKiem, btnThoat, btnClean, btnUpdate;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;

	public QuanLyNhanSu(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public JPanel addControls() {

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnQuanLyGiaoVien = new JPanel();
		pnQuanLyGiaoVien.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblQuanLyGiaoVien = new JLabel("QUẢN LÝ NHÂN SỰ");
		lblQuanLyGiaoVien.setFont(new Font("Time New Roman", Font.BOLD, 30));
		lblQuanLyGiaoVien.setForeground(Color.blue);
		pnQuanLyGiaoVien.add(lblQuanLyGiaoVien);
		pnMain.add(pnQuanLyGiaoVien);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		txtTimKiem = new JTextField(15);
		btnTimKiem = new JButton("Tìm Kiếm");
		btnThoat = new JButton("Thoát");
		pnTimKiem.add(txtTimKiem);
		pnTimKiem.add(btnTimKiem);
		pnTimKiem.add(btnThoat);

		pnMain.add(pnTimKiem);

//		JPanel pnPhongBan = new JPanel();
//		pnPhongBan.setLayout(new FlowLayout(FlowLayout.CENTER));
//		pnMain.add(pnPhongBan);
//		JLabel lblPhongBan = new JLabel("Chọn Phòng Ban");
//		cboPhongBan = new JComboBox<phongBan>();
//		cboPhongBan.setPreferredSize(new Dimension(200, 25));
//		pnPhongBan.add(lblPhongBan);
//		pnPhongBan.add(cboPhongBan);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new GridLayout(4, 4));

		Border BorderChiTiet = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderChiTiet = new TitledBorder(BorderChiTiet, "Chi Tiết");
		titledBorderChiTiet.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titledBorderChiTiet.setTitleColor(Color.red);
		pnChiTiet.setBorder(titledBorderChiTiet);

		JPanel pnId = new JPanel();
		pnId.setLayout(new FlowLayout());
		lblId = new JLabel("Mã PB: ");
		txtId = new JTextField(15);
		pnId.add(lblId);
		pnId.add(txtId);
//		pnChiTiet.add(pnMa);

		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout());
		lblMaPhongBan = new JLabel("Mã PB: ");
		txtMaPhongBan = new JTextField(15);
		pnMa.add(lblMaPhongBan);
		pnMa.add(txtMaPhongBan);
		pnChiTiet.add(pnMa);

		JPanel pnMaNV = new JPanel();
		pnMaNV.setLayout(new FlowLayout());
		lblMaNhanVien = new JLabel("Mã NV: ");
		txtMaNhanVien = new JTextField(15);
		pnMaNV.add(lblMaNhanVien);
		pnMaNV.add(txtMaNhanVien);
		pnChiTiet.add(pnMaNV);

		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		lblTen = new JLabel("Tên NV: ");
		txtTen = new JTextField(15);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnChiTiet.add(pnTen);

		JPanel pnChucVu = new JPanel();
		pnChucVu.setLayout(new FlowLayout());
		lblChucVu = new JLabel("Chức Vụ: ");
		txtChucVu = new JTextField(15);
		pnChucVu.add(lblChucVu);
		pnChucVu.add(txtChucVu);
		pnChiTiet.add(pnChucVu);

		JPanel pnNamSinh = new JPanel();
		pnNamSinh.setLayout(new FlowLayout());
		lblNamSinh = new JLabel("Năm Sinh: ");
		txtNamSinh = new JTextField(15);
		pnNamSinh.add(lblNamSinh);
		pnNamSinh.add(txtNamSinh);
		pnChiTiet.add(pnNamSinh);

		JPanel pnDiachi = new JPanel();
		pnDiachi.setLayout(new FlowLayout());
		lblDiaChi = new JLabel("Địa Chỉ: ");
		txtDiaChi = new JTextField(15);
		pnDiachi.add(lblDiaChi);
		pnDiachi.add(txtDiaChi);
		pnChiTiet.add(pnDiachi);

		JPanel pnDanToc = new JPanel();
		pnDanToc.setLayout(new FlowLayout());
		lblDanToc = new JLabel("Dân Tộc: ");
		txtDanToc = new JTextField(15);
		pnDanToc.add(lblDanToc);
		pnDanToc.add(txtDanToc);
		pnChiTiet.add(pnDanToc);

		JPanel pnTonGiao = new JPanel();
		pnTonGiao.setLayout(new FlowLayout());
		lblTonGiao = new JLabel("Tôn Giáo: ");
		txtTonGiao = new JTextField(15);
		pnTonGiao.add(lblTonGiao);
		pnTonGiao.add(txtTonGiao);
		pnChiTiet.add(pnTonGiao);

		JPanel pnNgayVaoLam = new JPanel();
		pnNgayVaoLam.setLayout(new FlowLayout());
		lblNgayVaoLam = new JLabel("Ngày Vào Làm: ");
		txtNgayVaoLam = new JTextField(15);
		pnNgayVaoLam.add(lblNgayVaoLam);
		pnNgayVaoLam.add(txtNgayVaoLam);
		pnChiTiet.add(pnNgayVaoLam);

		JPanel pnQueQuan = new JPanel();
		pnQueQuan.setLayout(new FlowLayout());
		lblQueQuan = new JLabel("Quê Quán: ");
		txtQueQuan = new JTextField(15);
		pnQueQuan.add(lblQueQuan);
		pnQueQuan.add(txtQueQuan);
		pnChiTiet.add(pnQueQuan);

		JPanel pnNguyenQuan = new JPanel();
		pnNguyenQuan.setLayout(new FlowLayout());
		lblNguyenQuan = new JLabel("Nguyên Quán: ");
		txtNguyenQuan = new JTextField(15);
		pnNguyenQuan.add(lblNguyenQuan);
		pnNguyenQuan.add(txtNguyenQuan);
		pnChiTiet.add(pnNguyenQuan);

		JPanel pnSdt = new JPanel();
		pnSdt.setLayout(new FlowLayout());
		lblSdt = new JLabel("Số Điện Thoại: ");
		txtSdt = new JTextField(15);
		pnSdt.add(lblSdt);
		pnSdt.add(txtSdt);
		pnChiTiet.add(pnSdt);

		JPanel pnemail = new JPanel();
		pnemail.setLayout(new FlowLayout());
		lblEmail = new JLabel("Email: ");
		txtEmail = new JTextField(15);
		pnemail.add(lblEmail);
		pnemail.add(txtEmail);
		pnChiTiet.add(pnemail);

		JPanel pnGhiChu = new JPanel();
		pnGhiChu.setLayout(new FlowLayout());
		lblGhiChu = new JLabel("Ghi Chú: ");
		txtGhiChu = new JTextField(15);
		pnGhiChu.add(lblGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnChiTiet.add(pnGhiChu);

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
		table.addColumn("Mã PB");
		table.addColumn("Mã NV");
		table.addColumn("Tên NV");
		table.addColumn("Chức Vụ");
		table.addColumn("Năm Sinh");
		table.addColumn("Địa Chỉ");
		table.addColumn("Dân Tộc");
		table.addColumn("Tôn Giáo");
		table.addColumn("Ngày Vào Làm");
		table.addColumn("Quê Quán");
		table.addColumn("Nguyên Quán");
		table.addColumn("Số Điện Thoại");
		table.addColumn("Email");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnDanhSach.add(sc);

		pnMain.add(pnDanhSach);

		lblMaPhongBan.setPreferredSize(lblNgayVaoLam.getPreferredSize());
		lblNamSinh.setPreferredSize(lblNgayVaoLam.getPreferredSize());
		lblEmail.setPreferredSize(lblNgayVaoLam.getPreferredSize());
		lblMaNhanVien.setPreferredSize(lblQueQuan.getPreferredSize());
		lblDiaChi.setPreferredSize(lblQueQuan.getPreferredSize());
		lblGhiChu.setPreferredSize(lblQueQuan.getPreferredSize());
		lblTen.setPreferredSize(lblNguyenQuan.getPreferredSize());
		lblDanToc.setPreferredSize(lblNguyenQuan.getPreferredSize());
		lblChucVu.setPreferredSize(lblNguyenQuan.getPreferredSize());
		lblTonGiao.setPreferredSize(lblSdt.getPreferredSize());

		loadDataforTableUser();

		return pnMain;
	}

	private void loadDataforTableUser() {
		// TODO Auto-generated method stub
		// xoa du lieu cu
		table.setRowCount(0);

		// su dung ham UserDao#getAllUser() de lay tat ca thong tin user trong database
		List<giangVien> listUser = userDaoQuanLyNhanSu.getAllUser();

		// duyet danh sach user lay tu database va them vao table
//		for (giangVien gv : listUser) {
//			table.addRow(new String[] { "" + gv.getId(), gv.getMaPB(), gv.getMaNV(), gv.getTenNV(), gv.getChucVu(),
//					gv.getNgaySinh(), gv.getDiaChi(), gv.getDanToc(), gv.getTonGiao(), gv.getNgayVaoLam(),
//					gv.getQueQuan(), gv.getNguyenQuan(), gv.getSoDienThoai(), gv.getEmail(), gv.getGhiChu() });
//		}
		
		for(int i = 0; i < listUser.size();i++) {
			table.addRow(new String[] { "" + listUser.get(i).getId(), listUser.get(i).getMaPB(), listUser.get(i).getMaNV(), listUser.get(i).getTenNV(), listUser.get(i).getChucVu(),
					listUser.get(i).getNgaySinh(), listUser.get(i).getDiaChi(), listUser.get(i).getDanToc(), listUser.get(i).getTonGiao(), listUser.get(i).getNgayVaoLam(),
					listUser.get(i).getQueQuan(), listUser.get(i).getNguyenQuan(), listUser.get(i).getSoDienThoai(), listUser.get(i).getEmail(), listUser.get(i).getGhiChu() });
		}
	}

	public void addEvents() {

	}

	public void showWindown() {
		this.setSize(800, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void clearInputInfoLop() {
		txtMaPhongBan.setText("");
		txtMaNhanVien.setText("");
		txtTen.setText("");
		txtChucVu.setText("");
		txtMaMonHoc.setText("");
		txtNamSinh.setText("");
		txtDiaChi.setText("");
		txtDanToc.setText("");
		txtTonGiao.setText("");
		txtNgayVaoLam.setText("");
		txtQueQuan.setText("");
		txtNguyenQuan.setText("");
		txtSdt.setText("");
		txtEmail.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDaoQuanLyNhanSu.deleteUser(username);
	}

	private void updateUser() {
		giangVien gv = new giangVien();

		gv.setId(txtId.getText());
		gv.setMaPB(txtMaPhongBan.getText());
		gv.setMaNV(txtMaNhanVien.getText());
		gv.setTenNV(txtTen.getText());
		gv.setChucVu(txtChucVu.getText());
		gv.setNgaySinh(txtNamSinh.getText());
		gv.setDiaChi(txtDiaChi.getText());
		gv.setDanToc(txtDanToc.getText());
		gv.setTonGiao(txtTonGiao.getText());
		gv.setNgayVaoLam(txtNgayVaoLam.getText());
		gv.setQueQuan(txtQueQuan.getText());
		gv.setNguyenQuan(txtNguyenQuan.getText());
		gv.setSoDienThoai(txtSdt.getText());
		gv.setEmail(txtEmail.getText());
		gv.setGhiChu(txtGhiChu.getText());
		userDaoQuanLyNhanSu.updateUser(gv);
	}

	private void addUser() {
		giangVien gv = new giangVien();

		gv.setId(txtId.getText());
		gv.setMaPB(txtMaPhongBan.getText());
		gv.setMaNV(txtMaNhanVien.getText());
		gv.setTenNV(txtTen.getText());
		gv.setChucVu(txtChucVu.getText());
		gv.setNgaySinh(txtNamSinh.getText());
		gv.setDiaChi(txtDiaChi.getText());
		gv.setDanToc(txtDanToc.getText());
		gv.setTonGiao(txtTonGiao.getText());
		gv.setNgayVaoLam(txtNgayVaoLam.getText());
		gv.setQueQuan(txtQueQuan.getText());
		gv.setNguyenQuan(txtNguyenQuan.getText());
		gv.setSoDienThoai(txtSdt.getText());
		gv.setEmail(txtEmail.getText());
		gv.setGhiChu(txtGhiChu.getText());

		userDaoQuanLyNhanSu.addUser(gv);
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
		txtMaPhongBan.setText((String) tab.getValueAt(rowSelected, 1));
		txtMaNhanVien.setText((String) tab.getValueAt(rowSelected, 2));
		txtTen.setText((String) tab.getValueAt(rowSelected, 3));
		txtChucVu.setText((String) tab.getValueAt(rowSelected, 4));
		txtNamSinh.setText((String) tab.getValueAt(rowSelected, 5));
		txtDiaChi.setText((String) tab.getValueAt(rowSelected, 6));
		txtDanToc.setText((String) tab.getValueAt(rowSelected, 7));
		txtTonGiao.setText((String) tab.getValueAt(rowSelected, 8));
		txtNgayVaoLam.setText((String) tab.getValueAt(rowSelected, 9));
		txtQueQuan.setText((String) tab.getValueAt(rowSelected, 10));
		txtNguyenQuan.setText((String) tab.getValueAt(rowSelected, 11));
		txtSdt.setText((String) tab.getValueAt(rowSelected, 12));
		txtEmail.setText((String) tab.getValueAt(rowSelected, 13));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected, 14));
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
