package projectManagementSchool.QuanLy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import projectManagementSchool.UserDao.userDaoQuanLyLuong;
import projectManagementSchool.model.hocSinhTrongLop;
import projectManagementSchool.model.salary;

public class QuanLyLuong extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JLabel id, thongTinLuong, maGiaoVien, tenGiaoVien, thang, heSoLuong, phuCap, ngayLamViec, luongTamUng,
			tienLuong, tienThuong, ghiChu;
	private JTextField txtTongLuong, txtId, txtTimKiem, txtTenGiaoVien, txtThang, txtHeSoLuong, txtPhuCap,
			txtNgayLamViec, txtLuongTamUng, txtTienLuong, txtTienThuong, txtGhiChu, txtMaGiaoVien;
	private JButton btnTimKiem, btnThoat, btnAdd, btnUpdate, btnDelete, btnClean;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;
	private salary luong = new salary();
	private userDaoQuanLyLuong userDao;

	public QuanLyLuong(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public JPanel addControls() {

		userDao = new userDaoQuanLyLuong();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel pnThongTinLuong = new JPanel();
		thongTinLuong = new JLabel("THÔNG TIN LƯƠNG");
		thongTinLuong.setForeground(Color.blue);
		thongTinLuong.setFont(new Font("Time New Roman", Font.BOLD, 30));
		thongTinLuong.setLayout(new BoxLayout(thongTinLuong, BoxLayout.Y_AXIS));
		pnThongTinLuong.add(thongTinLuong);
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
		id = new JLabel("Mã Giáo Viên:");
		txtId = new JTextField(10);
		pnId.add(id);
		pnId.add(txtId);

		JPanel pnMaGiaoVien = new JPanel();
		maGiaoVien = new JLabel("Mã Giáo Viên:");
		txtMaGiaoVien = new JTextField(10);
		pnMaGiaoVien.add(maGiaoVien);
		pnMaGiaoVien.add(txtMaGiaoVien);
		pnChiTiet.add(pnMaGiaoVien);

		JPanel pnTenGiaoVien = new JPanel();
		tenGiaoVien = new JLabel("Tên Giáo Viên: ");
		txtTenGiaoVien = new JTextField(10);
		pnTenGiaoVien.add(tenGiaoVien);
		pnTenGiaoVien.add(txtTenGiaoVien);
		pnChiTiet.add(pnTenGiaoVien);

		JPanel pnThang = new JPanel();
		thang = new JLabel("Tháng:");
		txtThang = new JTextField(10);
		pnThang.add(thang);
		pnThang.add(txtThang);
		pnChiTiet.add(pnThang);

		JPanel pnHeSoLuong = new JPanel();
		heSoLuong = new JLabel("Hệ Số Lương: ");
		txtHeSoLuong = new JTextField(10);
		pnHeSoLuong.add(heSoLuong);
		pnHeSoLuong.add(txtHeSoLuong);
		pnChiTiet.add(pnHeSoLuong);

		JPanel pnPhuCap = new JPanel();
		phuCap = new JLabel("Phụ Cấp:");
		txtPhuCap = new JTextField(10);
		pnPhuCap.add(phuCap);
		pnPhuCap.add(txtPhuCap);
		pnChiTiet.add(pnPhuCap);

		JPanel pnNgayLamViec = new JPanel();
		ngayLamViec = new JLabel("Ngày Làm Việc: ");
		txtNgayLamViec = new JTextField(10);
		pnNgayLamViec.add(ngayLamViec);
		pnNgayLamViec.add(txtNgayLamViec);
		pnChiTiet.add(pnNgayLamViec);

		JPanel pnLuongTamUng = new JPanel();
		luongTamUng = new JLabel("Lương Tạm Ứng:");
		txtLuongTamUng = new JTextField(10);
		pnLuongTamUng.add(luongTamUng);
		pnLuongTamUng.add(txtLuongTamUng);
		pnChiTiet.add(pnLuongTamUng);

		JPanel pnTienLuong = new JPanel();
		tienLuong = new JLabel("Tiền Lương: ");
		txtTienLuong = new JTextField(10);
		pnTienLuong.add(tienLuong);
		pnTienLuong.add(txtTienLuong);
//		pnChiTiet.add(pnTienLuong);

		JPanel pnTienThuong = new JPanel();
		tienThuong = new JLabel("Tiền Thưởng:");
		txtTienThuong = new JTextField(10);
		pnTienThuong.add(tienThuong);
		pnTienThuong.add(txtTienThuong);
		pnChiTiet.add(pnTienThuong);

		JPanel pnGhiChu = new JPanel();
		ghiChu = new JLabel("Ghi Chú: ");
		txtGhiChu = new JTextField(10);
		pnGhiChu.add(ghiChu);
		pnGhiChu.add(txtGhiChu);
		pnChiTiet.add(pnGhiChu);

		maGiaoVien.setPreferredSize(ngayLamViec.getPreferredSize());
		tenGiaoVien.setPreferredSize(luongTamUng.getPreferredSize());
		thang.setPreferredSize(tienThuong.getPreferredSize());
//		tienThuong.setPreferredSize(heSoLuong.getPreferredSize());
		ghiChu.setPreferredSize(heSoLuong.getPreferredSize());

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
		btnTimKiem.addActionListener(this);

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
		table.addColumn("Mã Giáo Viên");
		table.addColumn("Tên Giáo Viên");
		table.addColumn("Tháng");
		table.addColumn("Hệ Số Lương");
		table.addColumn("Phụ Cấp");
		table.addColumn("Ngày Làm Việc");
		table.addColumn("Lương Tạm Ứng");
		table.addColumn("Tiền Lương");
		table.addColumn("Tiền Thưởng");
		table.addColumn("Tổng Lương");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab);

		pnDanhSach.add(sc);
		pnMain.add(pnDanhSach);

		loadDataforTableUser();

		return pnMain;
	}

	public void addEvents() {
	}

	private void loadDataforTableUser() {
		// TODO Auto-generated method stub
		// xoa du lieu cu
		table.setRowCount(0);

		// su dung ham UserDao#getAllUser() de lay tat ca thong tin user trong database
		List<salary> listUser = userDao.getAllUser();

		// duyet danh sach user lay tu database va them vao table

		for (salary slr : listUser) {
			table.addRow(new String[] { "" + slr.getId(), slr.getMaGiaoVien(), slr.getTenGiaoVien(),
					"" + slr.getThang(), "" + slr.getHeSoLuong(), "" + slr.getPhuCap(), "" + slr.getNgayLamViec(),
					"" + slr.getLuongTamUng(), "" + slr.getTienLuong(), "" + slr.getTienThuong(),
					"" + slr.getTongLuong(), slr.getGhiChu() });
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
		txtMaGiaoVien.setText("");
		txtTenGiaoVien.setText("");
		txtThang.setText("");
		txtHeSoLuong.setText("");
		txtPhuCap.setText("");
		txtNgayLamViec.setText("");
		txtLuongTamUng.setText("");
		txtTienThuong.setText("");
		txtGhiChu.setText("");
	}

	private void deleteUser() {
		String username = (String) tab.getValueAt(tab.getSelectedRow(), 0);
		userDao.deleteUser(username);
	}

	private void updateUser() {
		salary slr = new salary();
		
		slr.setId(txtId.getText());
		slr.setMaGiaoVien(txtMaGiaoVien.getText());
		slr.setTenGiaoVien(txtTenGiaoVien.getText());
		slr.setThang(Integer.parseInt(txtThang.getText()));
		slr.setHeSoLuong(Integer.parseInt(txtHeSoLuong.getText()));
		slr.setPhuCap(Integer.parseInt(txtPhuCap.getText()));
		slr.setNgayLamViec(Integer.parseInt(txtNgayLamViec.getText()));
		slr.setLuongTamUng(Integer.parseInt(txtLuongTamUng.getText()));
		int tienLuong = (Integer.parseInt(txtNgayLamViec.getText()) * 180000);
		slr.setTienLuong(tienLuong);
		slr.setTienThuong(Integer.parseInt(txtTienThuong.getText()));
		int tongLuong = (Integer.parseInt(txtTienLuong.getText()) * Integer.parseInt(txtHeSoLuong.getText()))
				+ Integer.parseInt(txtPhuCap.getText()) + Integer.parseInt(txtTienThuong.getText())
				- Integer.parseInt(txtLuongTamUng.getText());
		slr.setTongLuong(tongLuong);
		slr.setGhiChu(txtGhiChu.getText());
		
		userDao.updateUser(slr);
	}

	private void addUser() {
		salary slr = new salary();

		slr.setId(txtId.getText());
		slr.setMaGiaoVien(txtMaGiaoVien.getText());
		slr.setTenGiaoVien(txtTenGiaoVien.getText());
		slr.setThang(Integer.parseInt(txtThang.getText()));
		slr.setHeSoLuong(Integer.parseInt(txtHeSoLuong.getText()));
		slr.setPhuCap(Integer.parseInt(txtPhuCap.getText()));
		slr.setNgayLamViec(Integer.parseInt(txtNgayLamViec.getText()));
		slr.setLuongTamUng(Integer.parseInt(txtLuongTamUng.getText()));
		slr.setTienLuong(luong.getTienLuong());
		slr.setTienThuong(Integer.parseInt(txtTienThuong.getText()));
		slr.setTongLuong(luong.getTongLuong());
		slr.setGhiChu(txtGhiChu.getText());

		userDao.addUser(slr);
	}

	private void search() {
		table.setRowCount(0);
		String magiaovien = txtTimKiem.getText();

		userDaoQuanLyLuong userDao = new userDaoQuanLyLuong();
		salary slr = new salary();
		slr = userDao.search(magiaovien);

		table.addRow(new String[] { "" + slr.getId(), slr.getMaGiaoVien(), slr.getTenGiaoVien(), "" + slr.getThang(),
				"" + slr.getHeSoLuong(), "" + slr.getPhuCap(), "" + slr.getNgayLamViec(), "" + slr.getLuongTamUng(),
				"" + slr.getTienLuong(), "" + slr.getTienThuong(), "" + slr.getTongLuong(), "" + slr.getGhiChu() });
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
		txtMaGiaoVien.setText((String) tab.getValueAt(rowSelected, 1));
		txtTenGiaoVien.setText((String) tab.getValueAt(rowSelected, 2));
		txtThang.setText((String) tab.getValueAt(rowSelected, 3));
		txtHeSoLuong.setText((String) tab.getValueAt(rowSelected, 4));
		txtPhuCap.setText((String) tab.getValueAt(rowSelected, 5));
		txtNgayLamViec.setText((String) tab.getValueAt(rowSelected, 6));
		txtLuongTamUng.setText((String) tab.getValueAt(rowSelected, 7));
		txtTienLuong.setText((String) tab.getValueAt(rowSelected, 8));
		txtTienThuong.setText((String) tab.getValueAt(rowSelected, 9));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected, 11));
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
