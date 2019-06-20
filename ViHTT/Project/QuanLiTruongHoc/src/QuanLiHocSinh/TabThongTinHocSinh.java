package QuanLiHocSinh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.bean.ThongTinHocSinh;
import Model.dao.ThongTinHocSinhDao;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class TabThongTinHocSinh extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSoThuTu;
	private JTextField tfMaHocSinh;
	private JTextField tfTenHocSinh;
	private JTextField tfNgaySinh;
	private JTextField tfDiaChi;
	private JTextField tfSoDienThoai;
	private ThongTinHocSinhDao thongTinHocSinhDao;

	private DefaultTableModel table;
//	private DefaultTableModel tableModel;
//	private Object listThongTinHocSinh;
//	private JTable jtable;
//	private JScrollPane jscrollpane;
//	private Component scrollpane;
//	private JButton btnAdd;
//	private JButton btnUpdate;
//	private JButton btnDelete;
//	private JTextField tfClean;
//	private Container panelButton;
//	private JTextField tfMaSV;
//	private JTextField tfTenSV;
//	private JTextField tfNienKhoa;
//	private JTextField tfLop;
//	private JPanel panelInput;
//	private JTextField tfDiemTB;

	private JButton btnThoat;
	private JButton btnClean;
	private JButton btnIn;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnSua;
	private JComboBox< String > comboBox;
	private JComboBox< String > comboBox_1;
	private JTable jTable;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TabThongTinHocSinh() {
		setLayout(null);
		setSize(1350, 720);
		JLabel lblThngTinHc = new JLabel("THÔNG TIN HỌC SINH");
		lblThngTinHc.setForeground(Color.RED);
		lblThngTinHc.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblThngTinHc.setBounds(530, 57, 341, 44);
		add(lblThngTinHc);
		thongTinHocSinhDao = new ThongTinHocSinhDao();
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(0, 155, 351, 483);
		add(panel);
		panel.setLayout(null);

		JLabel lblSThT = new JLabel("Số thứ tự");
		lblSThT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSThT.setBounds(32, 30, 77, 27);
		panel.add(lblSThT);

		tfSoThuTu = new JTextField();
		tfSoThuTu.setBounds(173, 31, 140, 28);
		panel.add(tfSoThuTu);
		tfSoThuTu.setColumns(10);

		JLabel lblMHcSinh = new JLabel("Mã học sinh");
		lblMHcSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMHcSinh.setBounds(32, 85, 96, 27);
		panel.add(lblMHcSinh);

		tfMaHocSinh = new JTextField();
		tfMaHocSinh.setBounds(173, 86, 140, 28);
		panel.add(tfMaHocSinh);
		tfMaHocSinh.setColumns(10);

		JLabel lblTnHcSinh = new JLabel("Tên Học sinh");
		lblTnHcSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnHcSinh.setBounds(32, 140, 96, 27);
		panel.add(lblTnHcSinh);

		tfTenHocSinh = new JTextField();
		tfTenHocSinh.setBounds(173, 142, 140, 27);
		panel.add(tfTenHocSinh);
		tfTenHocSinh.setColumns(10);

		JLabel lblNewLabel = new JLabel("Giới tính");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 197, 96, 27);
		panel.add(lblNewLabel);

		JLabel lblNgySinh = new JLabel("Ngày Sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgySinh.setBounds(32, 254, 96, 27);
		panel.add(lblNgySinh);

		comboBox = new JComboBox<String>();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		comboBox.setBounds(173, 199, 140, 27);
		panel.add(comboBox);

		tfNgaySinh = new JTextField();
		tfNgaySinh.setBounds(173, 256, 140, 27);
		panel.add(tfNgaySinh);
		tfNgaySinh.setColumns(10);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(32, 315, 96, 27);
		panel.add(lblaCh);

		tfDiaChi = new JTextField();
		tfDiaChi.setBounds(173, 317, 140, 27);
		panel.add(tfDiaChi);
		tfDiaChi.setColumns(10);

		JLabel lblLp = new JLabel("Lớp");
		lblLp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLp.setBounds(32, 375, 77, 27);
		panel.add(lblLp);

		 comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("10A1");
		comboBox_1.addItem("10A2");
		comboBox_1.addItem("10A3");
		comboBox_1.addItem("10A4");
		comboBox_1.addItem("10A5");
		comboBox_1.addItem("10A6");
		comboBox_1.addItem("10A7");
		comboBox_1.addItem("10A8");
		comboBox_1.addItem("10A9");
		comboBox_1.addItem("10A10");
		comboBox_1.addItem("11A1");
		comboBox_1.addItem("11A2");
		comboBox_1.addItem("11A3");
		comboBox_1.addItem("11A4");
		comboBox_1.addItem("11A5");
		comboBox_1.addItem("11A6");
		comboBox_1.addItem("11A7");
		comboBox_1.addItem("11A8");
		comboBox_1.addItem("11A9");
		comboBox_1.addItem("11A10");
		comboBox_1.addItem("12A1");
		comboBox_1.addItem("12A2");
		comboBox_1.addItem("12A3");
		comboBox_1.addItem("12A4");
		comboBox_1.addItem("12A5");
		comboBox_1.addItem("12A6");
		comboBox_1.addItem("12A7");
		comboBox_1.addItem("12A8");
		comboBox_1.addItem("12A9");
		comboBox_1.addItem("12A10");

		comboBox_1.setBounds(172, 377, 141, 27);
		panel.add(comboBox_1);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSinThoi.setBounds(21, 434, 107, 27);
		panel.add(lblSinThoi);

		tfSoDienThoai = new JTextField();
		tfSoDienThoai.setBounds(174, 437, 139, 27);
		panel.add(tfSoDienThoai);
		tfSoDienThoai.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(354, 510, 996, 128);
		add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(53, 47, 123, 34);
		btnThem.addActionListener(this);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(239, 47, 123, 34);
		btnSua.addActionListener(this);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(425, 47, 123, 34);
		btnXoa.addActionListener(this);
		panel_1.add(btnXoa);

		btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClean.setBounds(608, 47, 123, 34);
		btnClean.addActionListener(this);
		panel_1.add(btnClean);

		btnIn = new JButton("IN");
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIn.setBounds(840, 24, 111, 74);
		btnIn.addActionListener(this);
		panel_1.add(btnIn);

		table = new DefaultTableModel();
		table.addColumn("Số thứ tự");
		table.addColumn("Mã học sinh");
		table.addColumn("Tên Học sinh");
		table.addColumn("Giới tính");
		table.addColumn("Ngày sinh");
		table.addColumn("Địa chỉ");
		table.addColumn("Lớp");
		table.addColumn("Số điện thoại");
		jTable = new JTable(table);
		jTable.addMouseListener(this);
		JScrollPane jScrollPane = new JScrollPane(jTable);

		jScrollPane.setBorder(new LineBorder(Color.GRAY));
		jScrollPane.setBounds(354, 155, 996, 353);
		add(jScrollPane);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(1180, 45, 129, 37);
		btnThoat.addActionListener(this);
		add(btnThoat);
		loadTable();

	}

	public void loadTable() {
		// Xóa dữ liệu
		table.setRowCount(0);
		// Lấy thông tin từ dữ liệu class ThongTinHocSinhDao cho vào database
		List<ThongTinHocSinh> listThongTinHocSinh = thongTinHocSinhDao.getAllThongTinHocSinh();
		// duyet danh sach thongtinhocsinh lay tu database va them vao table
		for (ThongTinHocSinh thongTinHocSinh : listThongTinHocSinh) {
			table.addRow(new String[] { "" + thongTinHocSinh.getSoThuTu(), thongTinHocSinh.getMaHS(),
					thongTinHocSinh.getTenHS(), thongTinHocSinh.getGioiTinh(), thongTinHocSinh.getNgaysinh(),
					thongTinHocSinh.getDiachi(), thongTinHocSinh.getLop(), thongTinHocSinh.getSodienthoai() });
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		tfSoThuTu.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
		tfMaHocSinh.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 1));
		tfTenHocSinh.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 2));
		comboBox.setSelectedItem(jTable.getValueAt(jTable.getSelectedRow(), 3));
		tfNgaySinh.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 4));
		tfDiaChi.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 5));
		comboBox_1.setSelectedItem(jTable.getValueAt(jTable.getSelectedRow(), 6));
		tfSoDienThoai.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 7));

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnThoat) {
			System.exit(0);
		} else if (action == btnClean) {
			tfSoThuTu.setText("");
			tfMaHocSinh.setText("");
			tfTenHocSinh.setText("");
			tfNgaySinh.setText("");
			tfDiaChi.setText("");
			tfDiaChi.setText("");
			tfSoDienThoai.setText("");
		} else if (action == btnIn) {

		} else if (action == btnSua) {
			update();
			loadTable();
		} else if (action == btnXoa) {
			delete();
			loadTable();

		} else if (action == btnThem) {
			add();
			loadTable();
		}

	}
	private void add() {
		ThongTinHocSinh thongTinHocSinh = new ThongTinHocSinh();
		thongTinHocSinh.setSoThuTu(tfSoThuTu.getText());
		thongTinHocSinh.setMaHS(tfMaHocSinh.getText());
		thongTinHocSinh.setTenHS(tfTenHocSinh.getText());
		thongTinHocSinh.setGioiTinh((String) comboBox.getSelectedItem());
		thongTinHocSinh.setNgaysinh(tfNgaySinh.getText());
		thongTinHocSinh.setDiachi(tfDiaChi.getText());
		thongTinHocSinh.setLop((String) comboBox_1.getSelectedItem());
		thongTinHocSinh.setSodienthoai(tfSoDienThoai.getText());
		thongTinHocSinhDao.addThongTinHocSinh(thongTinHocSinh);
	}
	private void update() {
		ThongTinHocSinh thongTinHocSinh = new ThongTinHocSinh();
		thongTinHocSinh.setSoThuTu(tfSoThuTu.getText());
		thongTinHocSinh.setMaHS(tfMaHocSinh.getText());
		thongTinHocSinh.setTenHS(tfTenHocSinh.getText());
		thongTinHocSinh.setGioiTinh((String) comboBox.getSelectedItem());
		thongTinHocSinh.setNgaysinh(tfNgaySinh.getText());
		thongTinHocSinh.setDiachi(tfDiaChi.getText());
		thongTinHocSinh.setLop((String) comboBox_1.getSelectedItem());
		thongTinHocSinh.setSodienthoai(tfSoDienThoai.getText());
		thongTinHocSinhDao.updateThongTinHocSinh(thongTinHocSinh);
	}
	private void delete() {
		String mahs = (String) jTable.getValueAt(jTable.getSelectedRow(), 1);
		thongTinHocSinhDao.deleteThongTinHocSinh(mahs);
	}

}
