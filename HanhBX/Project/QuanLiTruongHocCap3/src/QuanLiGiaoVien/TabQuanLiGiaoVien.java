package QuanLiGiaoVien;

import java.awt.event.MouseListener;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Model.Dao.QuanLiGiaoVienDao;
import Model.bean.QuanLiGiaoVien;
import TrangChu.TrangChu;
import javafx.scene.image.Image;

public class TabQuanLiGiaoVien extends JPanel implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
	private JLabel lblQuanLiGiaoVien;
	private JLabel lblMaGiaoVienTimKiem;
	private JLabel lblMaGiaoVien;
	private JLabel lblSoThuTu;
	private JLabel lblTenGiaoVien;
	private JLabel lblGioiTinh;
	private JLabel lblDiaChi;
	private JLabel lblSoDienThoai;
	private JLabel lblSoTietDayTrongTuan;
	private JLabel lblTrinhDo;
	private JLabel lblChoOHienNay;
	private JLabel lblSoNgayNghi;
	private JLabel lblSoCMND;
	private JLabel lblEmail;
	private JLabel lblSapXep;
	
	private  JTextField textFieldMaGiaoVienTimKiem;
	private  JTextField textFieldSoThuTu;
	private  JTextField textFieldMaGiaoVien;
	private  JTextField textFieldTenGiaoVien;
	private JComboBox<String> comboBoxGioiTinh;
	private  JTextField textFieldTrinhDo;
	private  JTextField textFieldDiaChi;
	private  JTextField textFieldSoTietDayTrongTuan;
	private  JTextField textFieldSoNgayNghi;
	private  JTextField textFieldSoDienThoai;
	private  JTextField textFieldSoCMND;
	private  JTextField textFieldEmail;
	private  JTextField textFieldChoOHienNay;
	
	private JPanel panelInPut;
	private JPanel panelCongCu;
	private JPanel panelSapXep;
	
	private JButton btnTimKiem;
	private JButton btnCleanTimKiem;
	private JButton btnLoad;
	private JButton btnThoat;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnClean;
	private JButton btnIn;
	private JButton btnAZ;
	private JButton btnZA;
	
	private JTable jTable;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private QuanLiGiaoVienDao quanLiGiaoVienDao;
	
	
	public TabQuanLiGiaoVien(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		quanLiGiaoVienDao = new QuanLiGiaoVienDao();
		{
			lblQuanLiGiaoVien = new JLabel("QUẢN LÍ GIÁO VIÊN");
			lblQuanLiGiaoVien.setForeground(Color.RED);
			lblQuanLiGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblQuanLiGiaoVien.setBounds(857, 51, 385, 57);
			add(lblQuanLiGiaoVien);
		}
		{
			tableModel = new DefaultTableModel();
			tableModel.addColumn("STT");
			tableModel.addColumn("Mã Giáo Viên");
			tableModel.addColumn("Tên Giáo Viên");
			tableModel.addColumn("Giới Tính");
			tableModel.addColumn("Trình Độ");
			tableModel.addColumn("Địa Chỉ");
			tableModel.addColumn("Chỗ Ở Hiện Nay");
			tableModel.addColumn("Số Tiết Dạy Trong Tuần");
			tableModel.addColumn("Số Ngày Nghĩ");
			tableModel.addColumn("Số Điện Thoại");
			tableModel.addColumn("Số CMND");
			tableModel.addColumn("Email");
			jTable = new JTable(tableModel);
			jTable.addMouseListener(this);
			TableColumnModel columnModelHSHS = jTable.getColumnModel();
			columnModelHSHS.getColumn(0).setPreferredWidth(10);	
			columnModelHSHS.getColumn(1).setPreferredWidth(20);
			columnModelHSHS.getColumn(2).setPreferredWidth(150);
			columnModelHSHS.getColumn(3).setPreferredWidth(20);
			columnModelHSHS.getColumn(4).setPreferredWidth(50);
			columnModelHSHS.getColumn(5).setPreferredWidth(200);
			columnModelHSHS.getColumn(6).setPreferredWidth(200);
			columnModelHSHS.getColumn(7).setPreferredWidth(50);
			columnModelHSHS.getColumn(8).setPreferredWidth(50);
			columnModelHSHS.getColumn(9).setPreferredWidth(20);
			columnModelHSHS.getColumn(10).setPreferredWidth(20);
			columnModelHSHS.getColumn(11).setPreferredWidth(70);
			scrollPane = new JScrollPane(jTable);
			scrollPane.setBorder(new LineBorder(Color.GRAY));
			scrollPane.setBounds(0, 179, 1899, 324);
			add(scrollPane);
		}
		{
			panelInPut = new JPanel();
			panelInPut.setBackground(Color.LIGHT_GRAY);
			panelInPut.setBorder(new LineBorder(Color.GRAY));
			panelInPut.setBounds(0, 506, 1446, 345);
			add(panelInPut);
			panelInPut.setLayout(null);
			{
				lblSoThuTu = new JLabel("Số thứ tự");
				lblSoThuTu.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoThuTu.setBounds(72, 47, 128, 38);
				panelInPut.add(lblSoThuTu);
			}
			{
				textFieldSoThuTu = new JTextField();
				textFieldSoThuTu.setBounds(221, 49, 211, 38);
				panelInPut.add(textFieldSoThuTu);
				textFieldSoThuTu.setColumns(10);
			}
			{
				lblMaGiaoVien = new JLabel("Mã Giáo Viên");
				lblMaGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblMaGiaoVien.setBounds(72, 117, 128, 35);
				panelInPut.add(lblMaGiaoVien);
			}
			{
				textFieldMaGiaoVien = new JTextField();
				textFieldMaGiaoVien.setBounds(221, 117, 211, 38);
				panelInPut.add(textFieldMaGiaoVien);
				textFieldMaGiaoVien.setColumns(10);
			}
			{
				lblTenGiaoVien = new JLabel("Tên Giáo Viên");
				lblTenGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTenGiaoVien.setBounds(72, 187, 128, 35);
				panelInPut.add(lblTenGiaoVien);
			}
			{
				textFieldTenGiaoVien = new JTextField();
				textFieldTenGiaoVien.setBounds(221, 187, 211, 38);
				panelInPut.add(textFieldTenGiaoVien);
				textFieldTenGiaoVien.setColumns(10);
			}
			{
				lblGioiTinh = new JLabel("Giới Tính");
				lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblGioiTinh.setBounds(72, 255, 113, 35);
				panelInPut.add(lblGioiTinh);
			}
			{
				lblTrinhDo = new JLabel("Trình Độ");
				lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTrinhDo.setBounds(528, 47, 113, 38);
				panelInPut.add(lblTrinhDo);
			}
			{
				comboBoxGioiTinh = new JComboBox();
				comboBoxGioiTinh.addItem("Nam");
				comboBoxGioiTinh.addItem("Nữ");
				comboBoxGioiTinh.setBounds(221, 255, 211, 38);
				panelInPut.add(comboBoxGioiTinh);
			}
			{
				textFieldTrinhDo = new JTextField();
				textFieldTrinhDo.setBounds(721, 49, 211, 38);
				panelInPut.add(textFieldTrinhDo);
				textFieldTrinhDo.setColumns(10);
			}
			{
				lblDiaChi = new JLabel("Địa Chỉ");
				lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDiaChi.setBounds(528, 115, 113, 38);
				panelInPut.add(lblDiaChi);
			}
			{
				textFieldDiaChi = new JTextField();
				textFieldDiaChi.setBounds(721, 117, 211, 38);
				panelInPut.add(textFieldDiaChi);
				textFieldDiaChi.setColumns(10);
			}
			{
				lblChoOHienNay = new JLabel("Chỗ ở hiện nay");
				lblChoOHienNay.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblChoOHienNay.setBounds(528, 185, 140, 38);
				panelInPut.add(lblChoOHienNay);
			}
			{
				textFieldChoOHienNay = new JTextField();
				textFieldChoOHienNay.setBounds(721, 184, 211, 38);
				panelInPut.add(textFieldChoOHienNay);
				textFieldChoOHienNay.setColumns(10);
			}
			{
				lblSoTietDayTrongTuan = new JLabel("Số tiết dạy trong tuần");
				lblSoTietDayTrongTuan.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoTietDayTrongTuan.setBounds(528, 253, 154, 38);
				panelInPut.add(lblSoTietDayTrongTuan);
			}
			{
				textFieldSoTietDayTrongTuan = new JTextField();
				textFieldSoTietDayTrongTuan.setBounds(721, 255, 211, 38);
				panelInPut.add(textFieldSoTietDayTrongTuan);
				textFieldSoTietDayTrongTuan.setColumns(10);
			}
			{
				lblSoNgayNghi = new JLabel("Số ngày nghĩ");
				lblSoNgayNghi.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoNgayNghi.setBounds(1038, 47, 140, 38);
				panelInPut.add(lblSoNgayNghi);
			}
			{
				textFieldSoNgayNghi = new JTextField();
				textFieldSoNgayNghi.setBounds(1188, 47, 211, 38);
				panelInPut.add(textFieldSoNgayNghi);
				textFieldSoNgayNghi.setColumns(10);
			}
			{
				lblSoDienThoai= new JLabel("Số Điện thoại");
				lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoDienThoai.setBounds(1038, 115, 140, 38);
				panelInPut.add(lblSoDienThoai);
			}
			{
				textFieldSoDienThoai = new JTextField();
				textFieldSoDienThoai.setBounds(1188, 117, 211, 38);
				panelInPut.add(textFieldSoDienThoai);
				textFieldSoDienThoai.setColumns(10);
			}
			{
				lblSoCMND = new JLabel("Số CMND");
				lblSoCMND.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoCMND.setBounds(1038, 185, 113, 38);
				panelInPut.add(lblSoCMND);
			}
			{
				textFieldSoCMND = new JTextField();
				textFieldSoCMND.setBounds(1188, 185, 211, 38);
				panelInPut.add(textFieldSoCMND);
				textFieldSoCMND.setColumns(10);
			}
			{
				lblEmail = new JLabel("Email");
				lblEmail.setBackground(Color.LIGHT_GRAY);
				lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblEmail.setBounds(1038, 253, 99, 38);
				panelInPut.add(lblEmail);
			}
			{
				textFieldEmail = new JTextField();
				textFieldEmail.setBounds(1188, 255, 211, 38);
				panelInPut.add(textFieldEmail);
				textFieldEmail.setColumns(10);
			}
		}
		{
			panelCongCu = new JPanel();
			panelCongCu.setBackground(Color.LIGHT_GRAY);
			panelCongCu.setBorder(new LineBorder(Color.GRAY));
			panelCongCu.setBounds(1449, 506, 450, 345);
			add(panelCongCu);
			panelCongCu.setLayout(null);
			{
				btnThem = new JButton("Thêm");
				btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnThem.setBounds(73, 43, 140, 52);
				btnThem.addActionListener(this);
				btnThem.setIcon(new ImageIcon("add.png"));
				panelCongCu.add(btnThem);
			}
			{
				btnSua = new JButton("Sửa");
				btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnSua.setBounds(239, 43, 140, 52);
				btnSua.addActionListener(this);
				btnSua.setIcon(new ImageIcon("update.png"));
				panelCongCu.add(btnSua);
			}
			{
				btnXoa = new JButton("Xóa");
				btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnXoa.setBounds(73, 119, 140, 52);
				btnXoa.addActionListener(this);
				btnXoa.setIcon(new ImageIcon("delete.png"));
				panelCongCu.add(btnXoa);
			}
			{
				btnClean = new JButton("Clean");
				btnClean.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnClean.setBounds(239, 119, 140, 52);
				btnClean.addActionListener(this);
				btnClean.setIcon(new ImageIcon("clean.png"));
				panelCongCu.add(btnClean);
			}
			{
				btnIn = new JButton("In");
				btnIn.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnIn.setBounds(145, 205, 172, 97);
				btnIn.addActionListener(this);
				btnIn.setIcon(new ImageIcon("printer.png"));
				panelCongCu.add(btnIn);
			}
		}
		{
			btnThoat = new JButton("Thoát");
			btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnThoat.setBounds(1680, 36, 150, 48);
			btnThoat.addActionListener(this);
			btnThoat.setIcon(new ImageIcon("thoat.png"));
			add(btnThoat);
		}
		{
			lblMaGiaoVienTimKiem = new JLabel("Mã Giáo Viên");
			lblMaGiaoVienTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMaGiaoVienTimKiem.setBounds(29, 80, 117, 48);
			add(lblMaGiaoVienTimKiem);
		}
		{
			textFieldMaGiaoVienTimKiem = new JTextField();
			textFieldMaGiaoVienTimKiem.setBounds(145, 77, 150, 51);
			add(textFieldMaGiaoVienTimKiem);
			textFieldMaGiaoVienTimKiem.setColumns(10);
		}
		{
			btnTimKiem = new JButton("Tìm Kiếm");
			btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnTimKiem.setBounds(327, 78, 134, 52);
			btnTimKiem.addActionListener(this);
			btnTimKiem.setIcon(new ImageIcon("timkiem.png"));
			add(btnTimKiem);
		}
		{
			btnCleanTimKiem = new JButton("Clean");
			btnCleanTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnCleanTimKiem.setBounds(471, 78, 124, 52);
			btnCleanTimKiem.addActionListener(this);
			btnCleanTimKiem.setIcon(new ImageIcon("clean.png"));
			add(btnCleanTimKiem);
		}
		{
			btnLoad = new JButton("Load");
			btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLoad.setBounds(605, 78, 134, 52);
			btnLoad.addActionListener(this);
			btnLoad.setIcon(new ImageIcon("load.png"));
			add(btnLoad);
		}
		{
			panelSapXep = new JPanel();
			panelSapXep.setBackground(Color.LIGHT_GRAY);
			panelSapXep.setBorder(new LineBorder(Color.GRAY));
			panelSapXep.setBounds(0, 854, 1899, 109);
			add(panelSapXep);
			panelSapXep.setLayout(null);
			{
				lblSapXep = new JLabel("Sắp Xếp");
				lblSapXep.setForeground(Color.RED);
				lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSapXep.setBounds(510, 48, 142, 34);
				panelSapXep.add(lblSapXep);
			}
			{
				btnAZ = new JButton("A -Z");
				btnAZ.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnAZ.setBounds(610, 37, 169, 45);
				btnAZ.addActionListener(this);
				btnAZ.setIcon(new ImageIcon("AZ.png"));
				panelSapXep.add(btnAZ);
			}
			{
				btnZA = new JButton("Z -A");
				btnZA.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnZA.setBounds(821, 37, 169, 45);
				btnZA.addActionListener(this);
				btnZA.setIcon(new ImageIcon("ZA.png"));
				panelSapXep.add(btnZA);
			}
		}
		loadDataForTable();
	}
	public void loadDataForTable() {
		tableModel.setRowCount(0);
		List<QuanLiGiaoVien>listQuanLiGiaoVien = quanLiGiaoVienDao.getAllGiaoVienQLGV();
		for(QuanLiGiaoVien quanLiGiaoVien : listQuanLiGiaoVien) {
			tableModel.addRow(new String [] {"" + quanLiGiaoVien.getSoThuTu(),quanLiGiaoVien.getMaGV(),quanLiGiaoVien.getTenGV(),quanLiGiaoVien.getGioiTinh(),
					quanLiGiaoVien.getTrinhDo(),quanLiGiaoVien.getDiaChi(),quanLiGiaoVien.getChoOHienNay(),quanLiGiaoVien.getSoTietDayTrongTuan(),
					quanLiGiaoVien.getSoNgayNghi(),quanLiGiaoVien.getSoDienThoai(),quanLiGiaoVien.getSoCMND(),quanLiGiaoVien.getEmail()});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThoat) {
			int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
			TrangChu trangChu = new TrangChu();
			trangChu.loadTrangChu();
			trangChu.setVisible(true);
			jFrame.dispose();
			}
		}
		else if(e.getSource() == btnTimKiem) {
			timKiem();
		}
		else if(e.getSource() == btnCleanTimKiem) {
			textFieldMaGiaoVienTimKiem.setText("");
		}
		else if(e.getSource() == btnLoad) {
			loadDataForTable();
		}
		else if(e.getSource() == btnThem) {
			if(textFieldSoThuTu.getText().equals("")||textFieldMaGiaoVien.getText().equals("")||textFieldTenGiaoVien.getText().equals("")||textFieldTrinhDo.getText().equals("")||
					textFieldDiaChi.getText().equals("")||textFieldChoOHienNay.getText().equals("")||textFieldSoTietDayTrongTuan.getText().equals("")||textFieldSoNgayNghi.getText().equals("")||
					textFieldSoDienThoai.getText().equals("")||textFieldSoCMND.getText().equals("")||textFieldEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy nhập đầy đủ thông tin để thêm giáo viên");
			}
			else {
			addGV();
			loadDataForTable();
			}
		}
		else if(e.getSource() == btnSua) {
			if(textFieldSoThuTu.getText().equals("")||textFieldMaGiaoVien.getText().equals("")||textFieldTenGiaoVien.getText().equals("")||textFieldTrinhDo.getText().equals("")||
					textFieldDiaChi.getText().equals("")||textFieldChoOHienNay.getText().equals("")||textFieldSoTietDayTrongTuan.getText().equals("")||textFieldSoNgayNghi.getText().equals("")||
					textFieldSoDienThoai.getText().equals("")||textFieldSoCMND.getText().equals("")||textFieldEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy nhập đầy đủ thông tin để update giáo viên");
			}
			else {
				updateGV();
				loadDataForTable();
				JOptionPane.showMessageDialog(null, "bạn đã update giáo viên thành công");
			}
		}
		else if(e.getSource() == btnXoa) {
			deleteGV();
			loadDataForTable();
		}
		else if(e.getSource() == btnClean) {
			cleanGV();
		}
		else if(e.getSource() == btnAZ) {
			tableModel.setRowCount(0);
			List<QuanLiGiaoVien>listQuanLiGiaoVien = quanLiGiaoVienDao.showTableByAZ();
			for(QuanLiGiaoVien quanLiGiaoVien : listQuanLiGiaoVien) {
				tableModel.addRow(new String [] {"" + quanLiGiaoVien.getSoThuTu(),quanLiGiaoVien.getMaGV(),quanLiGiaoVien.getTenGV(),quanLiGiaoVien.getGioiTinh(),
						quanLiGiaoVien.getTrinhDo(),quanLiGiaoVien.getDiaChi(),quanLiGiaoVien.getChoOHienNay(),quanLiGiaoVien.getSoTietDayTrongTuan(),
						quanLiGiaoVien.getSoNgayNghi(),quanLiGiaoVien.getSoDienThoai(),quanLiGiaoVien.getSoCMND(),quanLiGiaoVien.getEmail()});
			}
			
		}
		else if(e.getSource() == btnZA) {
			tableModel.setRowCount(0);
			List<QuanLiGiaoVien>listQuanLiGiaoVien = quanLiGiaoVienDao.showTableByZA();
			for(QuanLiGiaoVien quanLiGiaoVien : listQuanLiGiaoVien) {
				tableModel.addRow(new String [] {"" + quanLiGiaoVien.getSoThuTu(),quanLiGiaoVien.getMaGV(),quanLiGiaoVien.getTenGV(),quanLiGiaoVien.getGioiTinh(),
						quanLiGiaoVien.getTrinhDo(),quanLiGiaoVien.getDiaChi(),quanLiGiaoVien.getChoOHienNay(),quanLiGiaoVien.getSoTietDayTrongTuan(),
						quanLiGiaoVien.getSoNgayNghi(),quanLiGiaoVien.getSoDienThoai(),quanLiGiaoVien.getSoCMND(),quanLiGiaoVien.getEmail()});
			}
			
		}
	}
	
	private void timKiem() {
		tableModel.setRowCount(0);
		QuanLiGiaoVien quanLiGiaoVien = new QuanLiGiaoVien();
		String magv = textFieldMaGiaoVienTimKiem.getText();
		quanLiGiaoVien = quanLiGiaoVienDao.getQuanLiGiaoVienByMaGV(magv);
		if(magv.equals("")) {
			loadDataForTable();
			JOptionPane.showMessageDialog(null,"bạn hãy nhập mã giáo viên để tìm kiếm giáo viên");
		}
		else if (magv.equals(quanLiGiaoVien.getMaGV())) {
			tableModel.addRow(new String [] {"" + quanLiGiaoVien.getSoThuTu(),quanLiGiaoVien.getMaGV(),quanLiGiaoVien.getTenGV(),quanLiGiaoVien.getGioiTinh(),
					quanLiGiaoVien.getTrinhDo(),quanLiGiaoVien.getDiaChi(),quanLiGiaoVien.getChoOHienNay(),quanLiGiaoVien.getSoTietDayTrongTuan(),
					quanLiGiaoVien.getSoNgayNghi(),quanLiGiaoVien.getSoDienThoai(),quanLiGiaoVien.getSoCMND(),quanLiGiaoVien.getEmail()});
		}
		else if (!magv.equals(quanLiGiaoVien.getMaGV())) {
			loadDataForTable();
			JOptionPane.showMessageDialog(null,"Mã giáo viên bạn nhập không tồn tại trong danh sách");
		}
	}
	
	private void addGV() {
		ckeckAdd();
	}
	private void  ckeckAdd() {
		String magv = textFieldMaGiaoVien.getText();
		String stt = textFieldSoThuTu.getText();
		if(quanLiGiaoVienDao.checkaddQLGV(magv, stt)==false) {
			JOptionPane.showMessageDialog(null,"số thứ tự hoặc mã giáo viên đã tồn tại");
		}
		else {
			QuanLiGiaoVien quanLiGiaoVien = new QuanLiGiaoVien();
			quanLiGiaoVien.setSoThuTu(textFieldSoThuTu.getText());
			quanLiGiaoVien.setMaGV(textFieldMaGiaoVien.getText());
			quanLiGiaoVien.setTenGV(textFieldTenGiaoVien.getText());
			quanLiGiaoVien.setGioiTinh((String) comboBoxGioiTinh.getSelectedItem());
			quanLiGiaoVien.setTrinhDo(textFieldTrinhDo.getText());
			quanLiGiaoVien.setDiaChi(textFieldDiaChi.getText());
			quanLiGiaoVien.setChoOHienNay(textFieldChoOHienNay.getText());
			quanLiGiaoVien.setSoTietDayTrongTuan(textFieldSoTietDayTrongTuan.getText());
			quanLiGiaoVien.setSoNgayNghi(textFieldSoNgayNghi.getText());
			quanLiGiaoVien.setSoDienThoai(textFieldSoDienThoai.getText());
			quanLiGiaoVien.setSoCMND(textFieldSoCMND.getText());
			quanLiGiaoVien.setEmail(textFieldEmail.getText());
			quanLiGiaoVienDao.addQuanLiGiaoVien(quanLiGiaoVien);
			JOptionPane.showMessageDialog(null, "bạn đã thêm giáo viên thành công");
			
		}
		
	}
	private void updateGV() {
		QuanLiGiaoVien quanLiGiaoVien = new QuanLiGiaoVien();
		quanLiGiaoVien.setSoThuTu(textFieldSoThuTu.getText());
		quanLiGiaoVien.setMaGV(textFieldMaGiaoVien.getText());
		quanLiGiaoVien.setTenGV(textFieldTenGiaoVien.getText());
		quanLiGiaoVien.setGioiTinh((String) comboBoxGioiTinh.getSelectedItem());
		quanLiGiaoVien.setTrinhDo(textFieldTrinhDo.getText());
		quanLiGiaoVien.setDiaChi(textFieldDiaChi.getText());
		quanLiGiaoVien.setChoOHienNay(textFieldChoOHienNay.getText());
		quanLiGiaoVien.setSoTietDayTrongTuan(textFieldSoTietDayTrongTuan.getText());
		quanLiGiaoVien.setSoNgayNghi(textFieldSoNgayNghi.getText());
		quanLiGiaoVien.setSoDienThoai(textFieldSoDienThoai.getText());
		quanLiGiaoVien.setSoCMND(textFieldSoCMND.getText());
		quanLiGiaoVien.setEmail(textFieldEmail.getText());
		quanLiGiaoVienDao.updateQuanLiGiaoVien(quanLiGiaoVien);
		
	}
	private void deleteGV() {
		String magv = (String) jTable.getValueAt(jTable.getSelectedRow(),1);
		int choose = JOptionPane.showConfirmDialog(null,"bạn có muốn giáo viên có mã "+magv+" không?","Xóa",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			quanLiGiaoVienDao.deleteQuanLiGiaoVien(magv);
			JOptionPane.showMessageDialog(null, "bạn đã xóa giáo viên có mã "+magv+" thành công");
		}
	}
	private void cleanGV() {
		textFieldSoThuTu.setText("");
		textFieldMaGiaoVien.setText("");
		textFieldTenGiaoVien.setText("");
		textFieldTrinhDo.setText("");
		textFieldDiaChi.setText("");
		textFieldChoOHienNay.setText("");
		textFieldSoTietDayTrongTuan.setText("");
		textFieldSoNgayNghi.setText("");
		textFieldSoDienThoai.setText("");
		textFieldSoCMND.setText("");
		textFieldEmail.setText("");
		textFieldSoThuTu.setEditable(true);
		textFieldMaGiaoVien.setEditable(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		textFieldSoThuTu.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
		textFieldMaGiaoVien.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 1));
		textFieldTenGiaoVien.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 2));
		comboBoxGioiTinh.setSelectedItem((String) jTable.getValueAt(jTable.getSelectedRow(), 3));
		textFieldTrinhDo.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 4));
		textFieldDiaChi.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 5));
		textFieldChoOHienNay.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 6));
		textFieldSoTietDayTrongTuan.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 7));
		textFieldSoNgayNghi.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 8));
		textFieldSoDienThoai.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 9));
		textFieldSoCMND.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 10));
		textFieldEmail.setText((String) jTable.getValueAt(jTable.getSelectedRow(), 11));
		textFieldSoThuTu.setEditable(false);
		textFieldMaGiaoVien.setEditable(false);
		
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
