package QuanLiGiaoVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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

import Model.Dao.ThongTinGiaoVienDao;
import Model.bean.ThongTinGiaoVien;
import TrangChu.TrangChu;

public class TabThongTinGiaoVien extends JPanel implements ActionListener,MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelInPutTTGV;
	private JPanel panelCongCuTTGV;
	private JPanel panelSapXepTTGV;
	private JLabel lblThongTinGiaoVien;
	private JLabel lblMaGiaoVienTimKiemTTGV;
	private JLabel lblMaGiaoVienTTGV;
	private JLabel lblSoThuTuTTGV;
	private JLabel lblTenGiaoVienTTGV;
	private JLabel lblGioiTinhTTGV;
	private JLabel lblNgaySinhTTGV;
	private JLabel lblDiaChiTTGV;
	private JLabel lblLopChuNhiemTTGV;
	private JLabel lblMonDayTTGV;
	private JLabel lblSoDienThoaiTTGV;
	private JLabel lblSapXepTTGV;
	
	private JTextField textFieldTimKiemTTGV;
	private JTextField textFieldMaGiaoVienTTGV;
	private JTextField textFieldSoThuTuTTGV;
	private JTextField textFieldTenGiaoVienTTGV;
	private JComboBox< String>comboBoxGioiTinhTTGV;
	private JTextField textFieldNgaySinhTTGV;
	private JTextField textFieldDiaChiTTGV;
	private JComboBox< String>comboBoxLopChuNhiemTTGV;
	private JComboBox< String>comboBoxMonDayTTGV;
	private JTextField textFieldSoDienThoaiTTGV;
	
	private JButton btnTimKiemTTGV;
	private JButton btnCleanTimKiemTTGV;
	private JButton btnLoadTTGV;
	private JButton btnThemTTGV;
	private JButton btnSuaTTGV;
	private JButton btnXoaTTGV;
	private JButton btnCleanTTGV;
	private JButton btnAZTTGV;
	private JButton btnZATTGV;
	private JButton btnInTTGV;
	private JButton btnThoatTTGV;
	private JFrame jFrame;
	private JTable jTableTTGV;
	private DefaultTableModel tableTTGV;
	private JScrollPane jScrollPaneTTGV;
	private ThongTinGiaoVienDao thongTinGiaoVienDao;
	public TabThongTinGiaoVien(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		thongTinGiaoVienDao = new ThongTinGiaoVienDao();
		
		{
			lblThongTinGiaoVien = new JLabel("THÔNG TIN GIÁO VIÊN");
			lblThongTinGiaoVien.setForeground(Color.RED);
			lblThongTinGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblThongTinGiaoVien.setBounds(780, 55, 394, 59);
			add(lblThongTinGiaoVien);
		}
		
		panelInPutTTGV = new JPanel();
		panelInPutTTGV.setBorder(new LineBorder(Color.GRAY));
		panelInPutTTGV.setBackground(Color.LIGHT_GRAY);
		panelInPutTTGV.setBounds(0, 238, 448, 725);
		add(panelInPutTTGV);
		panelInPutTTGV.setLayout(null);
		
		lblSoThuTuTTGV = new JLabel("Số Thứ Tự");
		lblSoThuTuTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoThuTuTTGV.setBounds(21, 45, 119, 35);
		panelInPutTTGV.add(lblSoThuTuTTGV);
		
		textFieldSoThuTuTTGV = new JTextField();
		textFieldSoThuTuTTGV.setBounds(197, 45, 200, 35);
		panelInPutTTGV.add(textFieldSoThuTuTTGV);
		textFieldSoThuTuTTGV.setColumns(10);
		
		lblMaGiaoVienTTGV = new JLabel("Mã Giáo Viên");
		lblMaGiaoVienTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaGiaoVienTTGV.setBounds(21, 108, 119, 35);
		panelInPutTTGV.add(lblMaGiaoVienTTGV);
		
		textFieldMaGiaoVienTTGV = new JTextField();
		textFieldMaGiaoVienTTGV.setBounds(197, 110, 200, 35);
		panelInPutTTGV.add(textFieldMaGiaoVienTTGV);
		textFieldMaGiaoVienTTGV.setColumns(10);
		
		lblTenGiaoVienTTGV = new JLabel("Tên Giáo Viên");
		lblTenGiaoVienTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenGiaoVienTTGV.setBounds(21, 177, 119, 35);
		panelInPutTTGV.add(lblTenGiaoVienTTGV);
		
		textFieldTenGiaoVienTTGV = new JTextField();
		textFieldTenGiaoVienTTGV.setBounds(197, 179, 200, 35);
		panelInPutTTGV.add(textFieldTenGiaoVienTTGV);
		textFieldTenGiaoVienTTGV.setColumns(10);
		
		lblGioiTinhTTGV = new JLabel("Giới Tính");
		lblGioiTinhTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGioiTinhTTGV.setBounds(21, 248, 102, 35);
		panelInPutTTGV.add(lblGioiTinhTTGV);
		
		comboBoxGioiTinhTTGV = new JComboBox<String>();
		comboBoxGioiTinhTTGV.addItem("Nam");
		comboBoxGioiTinhTTGV.addItem("Nữ");
		comboBoxGioiTinhTTGV.setBounds(197, 253, 200, 35);
		panelInPutTTGV.add(comboBoxGioiTinhTTGV);
		
		lblNgaySinhTTGV = new JLabel("Ngày Sinh");
		lblNgaySinhTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgaySinhTTGV.setBounds(21, 320, 102, 35);
		panelInPutTTGV.add(lblNgaySinhTTGV);
		
		textFieldNgaySinhTTGV = new JTextField();
		textFieldNgaySinhTTGV.setBounds(197, 322, 200, 35);
		panelInPutTTGV.add(textFieldNgaySinhTTGV);
		textFieldNgaySinhTTGV.setColumns(10);
		
		lblDiaChiTTGV = new JLabel("Địa Chỉ");
		lblDiaChiTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiaChiTTGV.setBounds(21, 390, 119, 35);
		panelInPutTTGV.add(lblDiaChiTTGV);
		
		textFieldDiaChiTTGV= new JTextField();
		textFieldDiaChiTTGV.setBounds(197, 390, 200, 35);
		panelInPutTTGV.add(textFieldDiaChiTTGV);
		textFieldDiaChiTTGV.setColumns(10);
		
		lblLopChuNhiemTTGV = new JLabel("Lớp Chủ Nhiệm");
		lblLopChuNhiemTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLopChuNhiemTTGV.setBounds(21, 458, 143, 35);
		panelInPutTTGV.add(lblLopChuNhiemTTGV);
		
		comboBoxLopChuNhiemTTGV = new JComboBox<String>();
		comboBoxLopChuNhiemTTGV.addItem("10A1");
		comboBoxLopChuNhiemTTGV.addItem("10A2");
		comboBoxLopChuNhiemTTGV.addItem("10A3");
		comboBoxLopChuNhiemTTGV.addItem("10A4");
		comboBoxLopChuNhiemTTGV.addItem("10A5");
		comboBoxLopChuNhiemTTGV.addItem("10A6");
		comboBoxLopChuNhiemTTGV.addItem("10A7");
		comboBoxLopChuNhiemTTGV.addItem("10A8");
		comboBoxLopChuNhiemTTGV.addItem("10A9");
		comboBoxLopChuNhiemTTGV.addItem("10A10");
		comboBoxLopChuNhiemTTGV.addItem("11A1");
		comboBoxLopChuNhiemTTGV.addItem("11A2");
		comboBoxLopChuNhiemTTGV.addItem("11A3");
		comboBoxLopChuNhiemTTGV.addItem("11A4");
		comboBoxLopChuNhiemTTGV.addItem("11A5");
		comboBoxLopChuNhiemTTGV.addItem("11A6");
		comboBoxLopChuNhiemTTGV.addItem("11A7");
		comboBoxLopChuNhiemTTGV.addItem("11A8");
		comboBoxLopChuNhiemTTGV.addItem("11A9");
		comboBoxLopChuNhiemTTGV.addItem("11A10");
		comboBoxLopChuNhiemTTGV.addItem("12A1");
		comboBoxLopChuNhiemTTGV.addItem("12A2");
		comboBoxLopChuNhiemTTGV.addItem("12A3");
		comboBoxLopChuNhiemTTGV.addItem("12A4");
		comboBoxLopChuNhiemTTGV.addItem("12A5");
		comboBoxLopChuNhiemTTGV.addItem("12A6");
		comboBoxLopChuNhiemTTGV.addItem("12A7");
		comboBoxLopChuNhiemTTGV.addItem("12A8");
		comboBoxLopChuNhiemTTGV.addItem("12A9");
		comboBoxLopChuNhiemTTGV.addItem("12A10");
		
		comboBoxLopChuNhiemTTGV.setBounds(197, 458, 200, 41);
		panelInPutTTGV.add(comboBoxLopChuNhiemTTGV);
		
		lblMonDayTTGV = new JLabel("Môn Dạy");
		lblMonDayTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonDayTTGV.setBounds(21, 529, 119, 35);
		panelInPutTTGV.add(lblMonDayTTGV);
		
		comboBoxMonDayTTGV = new JComboBox<String>();
		comboBoxMonDayTTGV.addItem("Toán");
		comboBoxMonDayTTGV.addItem("Vật Lí");
		comboBoxMonDayTTGV.addItem("Hóa Học");
		comboBoxMonDayTTGV.addItem("Sinh Học");
		comboBoxMonDayTTGV.addItem("Lịch Sử");
		comboBoxMonDayTTGV.addItem("Địa Lí");
		comboBoxMonDayTTGV.addItem("GDCD");
		comboBoxMonDayTTGV.addItem("Công Nghệ");
		comboBoxMonDayTTGV.addItem("Tin Học");
		comboBoxMonDayTTGV.addItem("Tiếng Anh");
		comboBoxMonDayTTGV.addItem("Ngữ Văn");
		comboBoxMonDayTTGV.addItem("GDQP");
		comboBoxMonDayTTGV.addItem("Thể Dục");
		comboBoxMonDayTTGV.setBounds(197, 531, 200, 35);
		panelInPutTTGV.add(comboBoxMonDayTTGV);
		
		lblSoDienThoaiTTGV = new JLabel("Số Điện Thoại");
		lblSoDienThoaiTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoDienThoaiTTGV.setBounds(21, 608, 143, 35);
		panelInPutTTGV.add(lblSoDienThoaiTTGV);
		
		textFieldSoDienThoaiTTGV = new JTextField();
		textFieldSoDienThoaiTTGV.setBounds(197, 608, 200, 35);
		panelInPutTTGV.add(textFieldSoDienThoaiTTGV);
		textFieldSoDienThoaiTTGV.setColumns(10);
		
		panelCongCuTTGV = new JPanel();
		panelCongCuTTGV.setBorder(new LineBorder(Color.GRAY));
		panelCongCuTTGV.setBackground(Color.LIGHT_GRAY);
		panelCongCuTTGV.setBounds(450, 764, 750, 199);
		add(panelCongCuTTGV);
		panelCongCuTTGV.setLayout(null);
		
		btnThemTTGV = new JButton("Thêm");
		btnThemTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemTTGV.setIcon(new ImageIcon("add.png"));
		btnThemTTGV.addActionListener(this);
		btnThemTTGV.setBounds(159, 38, 186, 46);
		panelCongCuTTGV.add(btnThemTTGV);
		
		btnSuaTTGV = new JButton("Sửa");
		btnSuaTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaTTGV.setIcon(new ImageIcon("update.png"));
		btnSuaTTGV.addActionListener(this);
		btnSuaTTGV.setBounds(159, 111, 186, 46);
		panelCongCuTTGV.add(btnSuaTTGV);
		
		btnXoaTTGV = new JButton("Xóa");
		btnXoaTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaTTGV.setIcon(new ImageIcon("delete.png"));
		btnXoaTTGV.addActionListener(this);
		btnXoaTTGV.setBounds(405, 38, 186, 46);
		panelCongCuTTGV.add(btnXoaTTGV);
		
		btnCleanTTGV = new JButton("Clean");
		btnCleanTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCleanTTGV.setIcon(new ImageIcon("clean.png"));
		btnCleanTTGV.addActionListener(this);
		btnCleanTTGV.setBounds(405, 111, 186, 46);
		panelCongCuTTGV.add(btnCleanTTGV);
		
		tableTTGV = new DefaultTableModel();
		tableTTGV.addColumn("STT");
		tableTTGV.addColumn("Mã Giáo Viên");
		tableTTGV.addColumn("Tên Giáo Viên");
		tableTTGV.addColumn("Giới Tính");
		tableTTGV.addColumn("Ngày Sinh");
		tableTTGV.addColumn("Địa Chỉ");
		tableTTGV.addColumn("Lớp Chủ Nhiệm");
		tableTTGV.addColumn("Môn Dạy");
		tableTTGV.addColumn("Số Điện Thoại");
		jTableTTGV = new JTable(tableTTGV);
		TableColumnModel columnModelHSHS = jTableTTGV.getColumnModel();
		columnModelHSHS.getColumn(0).setPreferredWidth(10);	
		columnModelHSHS.getColumn(1).setPreferredWidth(20);
		columnModelHSHS.getColumn(2).setPreferredWidth(150);
		columnModelHSHS.getColumn(3).setPreferredWidth(20);
		columnModelHSHS.getColumn(4).setPreferredWidth(20);
		columnModelHSHS.getColumn(5).setPreferredWidth(200);
		columnModelHSHS.getColumn(6).setPreferredWidth(20);
		columnModelHSHS.getColumn(7).setPreferredWidth(50);
		columnModelHSHS.getColumn(8).setPreferredWidth(50);
	
		jTableTTGV.addMouseListener(this);
		jScrollPaneTTGV = new JScrollPane(jTableTTGV);
		jScrollPaneTTGV.setBounds(450, 238, 1450, 523);
		add(jScrollPaneTTGV);
		
		
		lblMaGiaoVienTimKiemTTGV = new JLabel("Mã Giáo Viên");
		lblMaGiaoVienTimKiemTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaGiaoVienTimKiemTTGV.setBounds(596, 148, 116, 47);
		add(lblMaGiaoVienTimKiemTTGV);
		
		textFieldTimKiemTTGV = new JTextField();
		textFieldTimKiemTTGV.setBounds(707, 148, 202, 47);
		add(textFieldTimKiemTTGV);
		textFieldTimKiemTTGV.setColumns(10);
		
		btnTimKiemTTGV = new JButton("Tìm Kiếm");
		btnTimKiemTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiemTTGV.setBounds(937, 148, 133, 47);
		btnTimKiemTTGV.setIcon(new ImageIcon("timkiem.png"));
		btnTimKiemTTGV.addActionListener(this);
		add(btnTimKiemTTGV);
		
		btnCleanTimKiemTTGV = new JButton("Clean");
		btnCleanTimKiemTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCleanTimKiemTTGV.setBounds(1080, 148, 133, 47);
		btnCleanTimKiemTTGV.setIcon(new ImageIcon("clean.png"));
		btnCleanTimKiemTTGV.addActionListener(this);
		add(btnCleanTimKiemTTGV);
		
		btnLoadTTGV = new JButton("Load");
		btnLoadTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoadTTGV.setIcon(new ImageIcon("load.png"));
		btnLoadTTGV.addActionListener(this);
		btnLoadTTGV.setBounds(1223, 148, 133, 47);
		add(btnLoadTTGV);
		
		btnThoatTTGV = new JButton("Thoát");
		btnThoatTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoatTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoatTTGV.setIcon(new ImageIcon("thoat.png"));
		btnThoatTTGV.addActionListener(this);
		btnThoatTTGV.setBounds(1694, 41, 129, 47);
		add(btnThoatTTGV); 
		
		panelSapXepTTGV = new JPanel();
		panelSapXepTTGV.setBounds(1200, 764, 700, 199);
		panelSapXepTTGV.setBorder(new LineBorder(Color.GRAY));
		panelSapXepTTGV.setBackground(Color.LIGHT_GRAY);
		add(panelSapXepTTGV);
		panelSapXepTTGV.setLayout(null);
		
		btnAZTTGV = new JButton("A -Z");
		btnAZTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAZTTGV.setBounds(153, 82, 135, 44);
		btnAZTTGV.setIcon(new ImageIcon("AZ.png"));
		btnAZTTGV.addActionListener(this);
		panelSapXepTTGV.add(btnAZTTGV);
		
		btnZATTGV = new JButton("Z -A");
		btnZATTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnZATTGV.setBounds(322, 82, 135, 44);
		btnZATTGV.setIcon(new ImageIcon("ZA.png"));
		btnZATTGV.addActionListener(this);
		panelSapXepTTGV.add(btnZATTGV);
		
		btnInTTGV = new JButton("In");
		btnInTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInTTGV.setBounds(530, 63, 122, 76);
		btnInTTGV.setIcon(new ImageIcon("printer.png"));
		btnInTTGV.addActionListener(this);
		panelSapXepTTGV.add(btnInTTGV);
		
		
		lblSapXepTTGV = new JLabel("Sắp Xếp");
		lblSapXepTTGV.setForeground(Color.RED);
		lblSapXepTTGV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSapXepTTGV.setBounds(29, 82, 83, 44);
		panelSapXepTTGV.add(lblSapXepTTGV);
		loadDaTaForTableTTGV();
		
	}
	public void loadDaTaForTableTTGV() {
		tableTTGV.setRowCount(0);
		List<ThongTinGiaoVien> listThongTinGiaoVien = thongTinGiaoVienDao.getAllGiaoVienTTGV();
		for(ThongTinGiaoVien thongTinGiaoVien : listThongTinGiaoVien) {
			tableTTGV.addRow(new String [] {""+ thongTinGiaoVien.getSoThuTu(),thongTinGiaoVien.getMaGV(),thongTinGiaoVien.getTenGV(),thongTinGiaoVien.getGioiTinh(),thongTinGiaoVien.getNgaySinh(),
					thongTinGiaoVien.getDiaChi(),thongTinGiaoVien.getLopChuNhiem(),thongTinGiaoVien.getMonDay(),thongTinGiaoVien.getSoDienThoai()});
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnTimKiemTTGV) {
			timKiemTTGV();
		}
		else if(e.getSource() == btnCleanTimKiemTTGV) {
			textFieldTimKiemTTGV.setText("");
		}
		else if (e.getSource() == btnLoadTTGV) {
			loadDaTaForTableTTGV();
		}
		else if (e.getSource() == btnThoatTTGV) {
			int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
			TrangChu trangChu = new TrangChu();
			trangChu.loadTrangChu();
			trangChu.setVisible(true);
			jFrame.dispose();
			}
		}
		else if (e.getSource() == btnThemTTGV) {
			if(textFieldSoThuTuTTGV.getText().equals("")||textFieldMaGiaoVienTTGV.getText().equals("")||textFieldTenGiaoVienTTGV.getText().equals("")||
					textFieldNgaySinhTTGV.getText().equals("")||textFieldDiaChiTTGV.getText().equals("")||textFieldSoDienThoaiTTGV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy nhập đầy đủ thông tin để thêm thông tin giáo viên");
			}
			else {
			addTTGV();
			loadDaTaForTableTTGV();
			}
		}
		else if (e.getSource() == btnSuaTTGV) {
			updateTTGV();
			loadDaTaForTableTTGV();
			JOptionPane.showMessageDialog(null, "bạn đã update thông tin giáo viên thành công");
		}
		else if(e.getSource() == btnXoaTTGV) {
			deleteTTGV();
			loadDaTaForTableTTGV();
		}
		else if(e.getSource() == btnCleanTTGV) {
			cleanTTGV();
		}
		else if(e.getSource() == btnAZTTGV) {
			tableTTGV.setRowCount(0);
			List<ThongTinGiaoVien>listThongTinGiaoVien = thongTinGiaoVienDao.showTableByAZ();
			for(ThongTinGiaoVien thongTinGiaoVien :listThongTinGiaoVien) {
				tableTTGV.addRow(new String [] {""+ thongTinGiaoVien.getSoThuTu(),thongTinGiaoVien.getMaGV(),thongTinGiaoVien.getTenGV(),thongTinGiaoVien.getGioiTinh(),thongTinGiaoVien.getNgaySinh(),
						thongTinGiaoVien.getDiaChi(),thongTinGiaoVien.getLopChuNhiem(),thongTinGiaoVien.getMonDay(),thongTinGiaoVien.getSoDienThoai()});
			}
			
		}
		else if(e.getSource() == btnZATTGV) {
			tableTTGV.setRowCount(0);
			List<ThongTinGiaoVien>listThongTinGiaoVien = thongTinGiaoVienDao.showTableByZA();
			for(ThongTinGiaoVien thongTinGiaoVien :listThongTinGiaoVien) {
				tableTTGV.addRow(new String [] {""+ thongTinGiaoVien.getSoThuTu(),thongTinGiaoVien.getMaGV(),thongTinGiaoVien.getTenGV(),thongTinGiaoVien.getGioiTinh(),thongTinGiaoVien.getNgaySinh(),
						thongTinGiaoVien.getDiaChi(),thongTinGiaoVien.getLopChuNhiem(),thongTinGiaoVien.getMonDay(),thongTinGiaoVien.getSoDienThoai()});
			}
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
			textFieldSoThuTuTTGV.setText((String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),0));
			textFieldMaGiaoVienTTGV.setText((String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),1));
			textFieldTenGiaoVienTTGV.setText((String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),2));
			comboBoxGioiTinhTTGV.setSelectedItem(jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(), 3));
			textFieldNgaySinhTTGV.setText((String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),4));
			textFieldDiaChiTTGV.setText((String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),5));
			comboBoxLopChuNhiemTTGV.setSelectedItem(jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),6));
			comboBoxMonDayTTGV.setSelectedItem(jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),7));
			textFieldSoDienThoaiTTGV.setText((String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(),8));
			textFieldSoThuTuTTGV.setEditable(false);
			textFieldMaGiaoVienTTGV.setEditable(false);
		
		
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
	private void timKiemTTGV() {
		tableTTGV.setRowCount(0);
		String magv = textFieldTimKiemTTGV.getText();
		ThongTinGiaoVien thongTinGiaoVien = new ThongTinGiaoVien();
		thongTinGiaoVien = thongTinGiaoVienDao.getThongTinGiaoVienByMaGV(magv);
		if(magv.equals("")) {
			loadDaTaForTableTTGV();
			JOptionPane.showMessageDialog(null,"bạn hãy nhập mã giáo viên để tìm kiếm thông tin giáo viên");
		}
		else if(magv.equals(thongTinGiaoVien.getMaGV())) {
			tableTTGV.addRow(new String [] {""+ thongTinGiaoVien.getSoThuTu(),thongTinGiaoVien.getMaGV(),thongTinGiaoVien.getTenGV(),thongTinGiaoVien.getGioiTinh(),thongTinGiaoVien.getNgaySinh(),
					thongTinGiaoVien.getDiaChi(),thongTinGiaoVien.getLopChuNhiem(),thongTinGiaoVien.getMonDay(),thongTinGiaoVien.getSoDienThoai()});
		}
		else if(!magv.equals(thongTinGiaoVien.getMaGV())) {
			loadDaTaForTableTTGV();
			JOptionPane.showMessageDialog(null, "mã giáo viên bạn nhập không tồn tại trong danh sách");
		}
	}
	private void addTTGV() {
		ckeckAddTTGV();
	}
	private void ckeckAddTTGV() {
		String stt = textFieldSoThuTuTTGV.getText();
		String magv = textFieldMaGiaoVienTTGV.getText();
		if(thongTinGiaoVienDao.checkaddTTGV(magv, stt) == false) {
			JOptionPane.showMessageDialog(null, "số thứ tự hoặc mã giáo viên đã tồn tại");
		}
		else {
			ThongTinGiaoVien thongTinGiaoVien = new ThongTinGiaoVien();
			thongTinGiaoVien.setSoThuTu(textFieldSoThuTuTTGV.getText());
			thongTinGiaoVien.setMaGV(textFieldMaGiaoVienTTGV.getText());
			thongTinGiaoVien.setTenGV(textFieldTenGiaoVienTTGV.getText());
			thongTinGiaoVien.setGioiTinh((String) comboBoxGioiTinhTTGV.getSelectedItem());
			thongTinGiaoVien.setNgaySinh(textFieldNgaySinhTTGV.getText());
			thongTinGiaoVien.setDiaChi(textFieldDiaChiTTGV.getText());
			thongTinGiaoVien.setLopChuNhiem((String) comboBoxLopChuNhiemTTGV.getSelectedItem());
			thongTinGiaoVien.setMonDay((String) comboBoxMonDayTTGV.getSelectedItem());
			thongTinGiaoVien.setSoDienThoai(textFieldSoDienThoaiTTGV.getText());
			thongTinGiaoVienDao.addThongTinGiaoVien(thongTinGiaoVien);
			JOptionPane.showMessageDialog(null, "bạn đã thêm thông tin giáo viên thành công");
			
		}
	}
	private void updateTTGV() {
		ThongTinGiaoVien thongTinGiaoVien = new ThongTinGiaoVien();
		thongTinGiaoVien.setSoThuTu(textFieldSoThuTuTTGV.getText());
		thongTinGiaoVien.setMaGV(textFieldMaGiaoVienTTGV.getText());
		thongTinGiaoVien.setTenGV(textFieldTenGiaoVienTTGV.getText());
		thongTinGiaoVien.setGioiTinh((String) comboBoxGioiTinhTTGV.getSelectedItem());
		thongTinGiaoVien.setNgaySinh(textFieldNgaySinhTTGV.getText());
		thongTinGiaoVien.setDiaChi(textFieldDiaChiTTGV.getText());
		thongTinGiaoVien.setLopChuNhiem((String) comboBoxLopChuNhiemTTGV.getSelectedItem());
		thongTinGiaoVien.setMonDay((String) comboBoxMonDayTTGV.getSelectedItem());
		thongTinGiaoVien.setSoDienThoai(textFieldSoDienThoaiTTGV.getText());
		thongTinGiaoVienDao.updateThongTinGiaoVien(thongTinGiaoVien);
	}
	private void deleteTTGV() {
		String magv = (String) jTableTTGV.getValueAt(jTableTTGV.getSelectedRow(), 1);
		int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa thông tin của giáo viên có mã "+magv+" không?","Xóa",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
		thongTinGiaoVienDao.deleteThongTinGiaoVien(magv);
		JOptionPane.showMessageDialog(null, "bạn đã xóa thông tin giáo viên có mã "+magv+" thành công");
		}
	}
	private void cleanTTGV() {
		textFieldSoThuTuTTGV.setText("");
		textFieldMaGiaoVienTTGV.setText("");
		textFieldTenGiaoVienTTGV.setText("");
		textFieldNgaySinhTTGV.setText("");
		textFieldDiaChiTTGV.setText("");
		textFieldSoDienThoaiTTGV.setText("");
		textFieldSoThuTuTTGV.setEditable(true);
		textFieldMaGiaoVienTTGV.setEditable(true);
	}

}
