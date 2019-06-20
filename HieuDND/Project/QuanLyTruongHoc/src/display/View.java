package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import account.TaiKhoan;
import account.TaiKhoanDao;
import class_room.Lop;
import class_room.LopDao;
import login.Login;
import point.DiemHocSinh;
import point.DiemHocSinhDao;
import school_year.NienKhoa;
import school_year.NienKhoaDao;
import students.HoSoHSDao;
import students.HoSo_Student;
import students.HocSinh;
import students.HocSinhDao;
import subjects.MonHoc;
import subjects.MonHocDao;
import summary.TongKet;
import summary.TongKetDao;
import teacher.GiaoVien;
import teacher.GiaoVienDao;
import teacher.HoSoGVDao;
import teacher.HoSo_Teacher;

public class View extends JFrame implements ActionListener, MouseListener {
	
	private JTabbedPane myTabled;
	
	private static final long serialVersionUID = 1L;

	private JPanel pnLabel;
	private JLabel lbMenu;
	private TitledBorder borderTitle;
	private Border border;
//////////////////////////////////1 - QUẢN LÝ HỌC SINH	
	private DefaultTableModel tableHocSinh;
	private JTable jTable;
	private JScrollPane jScrollPane;

	private JButton btnAddHs;
	private JButton btnUpdateHs;
	private JButton btnDeleteHs;
	private JButton btnCleanHs;

	private JLabel lblMaHS;
	private JLabel lblHoHS;
	private JLabel lblTenHS;
	private JLabel lblTuoiHs;
	private JLabel lblDiaChiHs;
	private JLabel lblGioiTinhHs;
	private JLabel lblNgaySinhHs;
	private JLabel lblSDTHs;
	private JLabel lblEmailHs;
	private JLabel lblBuoiVangHs;
	private JLabel lblId_LopHs;
	

	private JTextField txtMaHS;
	private JTextField txtHoHS;
	private JTextField txtTenHS;
	private JTextField txtTuoiHs;
	private JTextField txtDiaChiHs;
	private JTextField txtGioiTinhHs;
	private JTextField txtNgaySinhHs;
	private JTextField txtSDTHs;
	private JTextField txtEmailHs;
	private JTextField txtBuoiVangHs;
	private JTextField txtId_LopHs;
	
	private JButton btSearchHs;
	private JTextField txtSearchHs;

	private HocSinhDao hocSinhDao;

//////////////////////////////////2 - HỒ SƠ HỌC SINH
	private DefaultTableModel tableHoSoHS;
	private JTable HoSoHS;
	private JScrollPane jSHoSoHS;

	private JButton btnAddHsHs;
	private JButton btnUpdateHsHs;
	private JButton btnDeleteHsHs;
	private JButton btnCleanHsHs;

	private JLabel HoSoMaHS;
	private JLabel HoSoHoHS;
	private JLabel HoSoTenHS;
	private JLabel HoSoTuoiHsHs;
	private JLabel HoSoDiaChiHsHs;
	private JLabel HoSoGioiTinhHsHs;
	private JLabel HoSoNgaySinhHsHs;
	private JLabel HoSoTieuHoc;
	private JLabel HoSoTHCS;
	private JLabel HoSoTHPT;
	private JLabel HoSoHocLucHsHs;
	private JLabel HoSoHanhKiemHsHs;

	private JTextField txHoSoMaHS;
	private JTextField txHoSoHoHS;
	private JTextField txHoSoTenHS;
	private JTextField txHoSoHSTuoi;
	private JTextField txHoSoHSDiaChi;
	private JTextField txHoSoHSGioiTinh;
	private JTextField txHoSoHSNgaySinh;
	private JTextField txHoSoHSTieuHoc;
	private JTextField txHoSoHSTHCS;
	private JTextField txHoSoHSTHPT;
	private JTextField txHoSoHSHocLuc;
	private JTextField txHoSoHSHanhKiem;
	
	private JButton btSearchHsHs;
	private JTextField txtSearchHsHs;

	private HoSoHSDao hoSoDao;
	
//////////////////////////////////3 - QUẢN LÝ GIÁO VIÊN
	private DefaultTableModel tableGiaoVien;
	private JTable jTableGiaoVien;
	private JScrollPane jScrollPaneGiaoVien;

	private JButton btnAddGv;
	private JButton btnUpdateGv;
	private JButton btnDeleteGv;
	private JButton btnCleanGv;

	private JLabel lblMaGV;
	private JLabel lblHoGV;
	private JLabel lblTenGV;
	private JLabel lblTuoiGv;
	private JLabel lblDiaChiGv;
	private JLabel lblGioiTinhGv;
	private JLabel lblNgaySinhGv;
	private JLabel lblSDTGv;
	private JLabel lblEmailGv;
	private JLabel lblChucVu;

	private JTextField txtMaGV;
	private JTextField txtHoGV;
	private JTextField txtTenGV;
	private JTextField txtTuoiGv;
	private JTextField txtDiaChiGv;
	private JTextField txtGioiTinhGv;
	private JTextField txtNgaySinhGv;
	private JTextField txtSDTGv;
	private JTextField txtEmailGv;
	private JTextField txtChucVu;
	
	private JButton btSearchGv;
	private JTextField txtSearchGv;

	private GiaoVienDao giaoVienDao;
	
//////////////////////////////////4 - HỒ SƠ GIÁO VIÊN
	private DefaultTableModel tableHoSoGV;
	private JTable jTableHSGV;
	private JScrollPane jScrollPaneHSGV;

	private JButton btnAddHsGv;
	private JButton btnUpdateHsGv;
	private JButton btnDeleteHsGv;
	private JButton btnCleanHsGv;

	private JLabel lblMaHoSoGV;
	private JLabel lblHoHoSoGV;
	private JLabel lblTenHoSoGV;
	private JLabel lblTuoiHsGv;
	private JLabel lblDiaChiHsGv;
	private JLabel lblGioiTinhHsGv;
	private JLabel lblNgaySinhHsGv;
	private JLabel lblSDTHsGv;
	private JLabel lblEmailHsGv;
	private JLabel lblDaiHoc;
	private JLabel lblKinhNghiem;

	private JTextField txtMaHoSoGV;
	private JTextField txtHoHoSoGV;
	private JTextField txtTenHoSoGV;
	private JTextField txtTuoiHsGv;
	private JTextField txtDiaChiHsGv;
	private JTextField txtGioiTinhHsGv;
	private JTextField txtNgaySinhHsGv;
	private JTextField txtSDTHsGv;
	private JTextField txtEmailHsGv;
	private JTextField txtDaiHoc;
	private JTextField txtKinhNghiem;
	
	private JButton btSearchHsGv;
	private JTextField txtSearchHsGv;

	private HoSoGVDao hoSoGVDao;
//////////////////////////////////5 - LỚP HỌC	
	private DefaultTableModel tableLopHoc;
	private JTable jTableLopHoc;
	private JScrollPane jScrollPaneLopHoc;
	
	private JButton btnAddLopHoc;
	private JButton btnUpdateLopHoc;
	private JButton btnDeleteLopHoc;
	private JButton btnCleanLopHoc;
	
	private JLabel lblMaLopHoc;
	private JLabel lblTenLopHoc;
	private JLabel lblMaNienKhoa;

	private JTextField txtMaLopHoc;
	private JTextField txtTenLopHoc;
	private JTextField txtMaNienKhoa;
	
	private JButton btSearchLopHoc;
	private JTextField txtSearchLopHoc;
	
	private LopDao lopDao;
//////////////////////////////////6 - MÔN HỌC
	private DefaultTableModel tableMonHoc;
	private JTable jTableMonHoc;
	private JScrollPane jScrollPaneMonHoc;
	
	private JButton btnAddMonHoc;
	private JButton btnUpdateMonHoc;
	private JButton btnDeleteMonHoc;
	private JButton btnCleanMonHoc;
	
	private JLabel lblMaMonHoc;
	private JLabel lblTenMonHoc;
	private JLabel lblMaGiaoVien;

	private JTextField txtMaMonHoc;
	private JTextField txtTenMonHoc;
	private JTextField txtMaGiaoVien;
	
	private JButton btSearchMonHoc;
	private JTextField txtSearchMonHoc;
	
	private MonHocDao monHocDao;
//////////////////////////////////7 - ĐIỂM
	private DefaultTableModel tableDiem;
	private JTable jTableDiem;
	private JScrollPane jScrollPaneDiem;
	
	private JButton btnAddDiem;
	private JButton btnUpdateDiem;
	private JButton btnDeleteDiem;
	private JButton btnCleanDiem;
	
	private JLabel lblId_MonHoc;
	private JLabel lblId_HocSinh;
	private JLabel lblDiem_Mieng;
	private JLabel lblDiem15p;
	private JLabel lblDiem1Tiet;
	private JLabel lblDiemHocKi;

	private JTextField txtId_MonHoc;
	private JTextField txtId_HocSinh;
	private JTextField txtDiem_Mieng;
	private JTextField txtDiem15p;
	private JTextField txtDiem1Tiet;
	private JTextField txtDiemHocKi;
	
	private JButton btSearchDiem;
	private JTextField txtSearchDiem;
	
	private DiemHocSinhDao diemHocsinhDao;
//////////////////////////////////8 - NIÊN KHOÁ
	private DefaultTableModel tableNienKhoa;
	private JTable jTableNienKhoa;
	private JScrollPane jScrollPaneNienKhoa;
	
	private JButton btnAddNienKhoa;
	private JButton btnUpdateNienKhoa;
	private JButton btnDeleteNienKhoa;
	private JButton btnCleanNienKhoa;
	
	private JLabel lblId_NienKhoa;
	private JLabel lblNienKhoa;
	
	private JTextField txtId_NienKhoa;
	private JTextField txtNienKhoa;
	
	private JButton btSearchNienKhoa;
	private JTextField txtSearchNienKhoa;
	
	private NienKhoaDao nienKhoaDao;
	
//////////////////////////////////9 - TỔNG KẾT
	private DefaultTableModel tableTongKet;
	private JTable jTableTK;
	private JScrollPane jScrollPaneTK;

	private JButton btnAddTk;
	private JButton btnUpdateTk;
	private JButton btnDeleteTk;
	private JButton btnCleanTk;

	private JLabel lblMaHSTk;
	private JLabel lblHoHSTk;
	private JLabel lblTenHSTk;
	private JLabel lblLop;
	private JLabel lblHocLuc1;
	private JLabel lblHanhKiem1;
	private JLabel lblHocLuc2;
	private JLabel lblHanhKiem2;
	private JLabel lblHocLucCN;
	private JLabel lblHanhKiemCN;
	private JLabel lblIdNienKhoa;

	private JTextField txtMaHSTk;
	private JTextField txtHoHSTk;
	private JTextField txtTenHSTk;
	private JTextField txtLop;
	private JTextField txtHocLuc1;
	private JTextField txtHanhKiem1;
	private JTextField txtHocLuc2;
	private JTextField txtHanhKiem2;
	private JTextField txtHocLucCN;
	private JTextField txtHanhKiemCN;
	private JTextField txtIdNienKhoa;
	
	private JButton btSearchTk;
	private JTextField txtSearchTk;

	private TongKetDao tongKetDao;
	
//////////////////////////////////10 - QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG
	private DefaultTableModel tableTaiKhoan;
	private JTable jTableTaiKhoan;
	private JScrollPane jScrollPaneTaiKhoan;

	private JButton btnAddTaiKhoan;
	private JButton btnUpdateTaiKhoan;
	private JButton btnDeleteTaiKhoan;
	private JButton btnCleanTaiKhoan;

	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblId_Rule;

	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtId_Rule;
	
	private JButton btSearchTaiKhoan;
	private JTextField txtSearchTaiKhoan;

	private TaiKhoanDao taiKhoanDao;

	
	public View() {
		super("QUẢN LÝ TRƯỜNG HỌC");
		setSize(1700, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font fontLbMenu = new Font("Arial", Font.PLAIN, 60);
		pnLabel = new JPanel(new FlowLayout());
		pnLabel.setPreferredSize(new Dimension(1700,40));
		border = BorderFactory.createLineBorder(Color.CYAN, 2, true);
		borderTitle = BorderFactory.createTitledBorder(border);
		lbMenu = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ TRƯỜNG HỌC");
		lbMenu.setFont(fontLbMenu);
		lbMenu.setForeground(Color.RED);
		pnLabel.add(lbMenu);
		pnLabel.setBorder(borderTitle);
		pnLabel.setBackground(Color.WHITE);
		
		
		myTabled = new JTabbedPane(JTabbedPane.TOP);//////////TAB
		
/////////////////////////////////////////////1 - QUẢN LÝ HỌC SINH
		JPanel pnTab1 = new JPanel(new BorderLayout());
		pnTab1.setBackground(Color.CYAN);

		hocSinhDao = new HocSinhDao();

		tableHocSinh = new DefaultTableModel();
		tableHocSinh.addColumn("Mã Học Sinh");
		tableHocSinh.addColumn("Họ Học Sinh");
		tableHocSinh.addColumn("Tên Học Sinh");
		tableHocSinh.addColumn("Tuổi");
		tableHocSinh.addColumn("Địa Chỉ");
		tableHocSinh.addColumn("Giới Tính");
		tableHocSinh.addColumn("Ngày Sinh");
		tableHocSinh.addColumn("SĐT Liên Hệ");
		tableHocSinh.addColumn("Email");
		tableHocSinh.addColumn("Số Buổi Vắng");
		tableHocSinh.addColumn("Mã Lớp");
		
		jTable = new JTable(tableHocSinh);
		jTable.setPreferredSize(new Dimension(1680, 1000));
		Font font = new Font("Arial", Font.PLAIN, 17);
		jTable.setFont(font);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBorder(borderTitle);
		jTable.addMouseListener(this);

		// cac nut button
		Font fontBt = new Font("Arial", Font.PLAIN, 20);
		btnAddHs = new JButton("Add");
		btnAddHs.setFont(fontBt);
		btnUpdateHs = new JButton("Update");
		btnUpdateHs.setFont(fontBt);
		btnDeleteHs = new JButton("Delete");
		btnDeleteHs.setFont(fontBt);
		btnCleanHs = new JButton("Clean");
		btnCleanHs.setFont(fontBt);
		JPanel paneActionButton = new JPanel();
		paneActionButton.setBackground(Color.CYAN);
		paneActionButton.add(btnAddHs);
		paneActionButton.add(btnUpdateHs);
		paneActionButton.add(btnDeleteHs);
		paneActionButton.add(btnCleanHs);
		
		btnAddHs.addActionListener(this);
		btnUpdateHs.addActionListener(this);
		btnDeleteHs.addActionListener(this);
		btnCleanHs.addActionListener(this);
		
		Font fontSearch = new Font("Arial", Font.BOLD | Font.PLAIN, 20);
		JPanel TimKiemHs = new JPanel();
		TimKiemHs.setLayout(new BoxLayout(TimKiemHs, BoxLayout.X_AXIS));
		txtSearchHs = new JTextField();
		txtSearchHs.setFont(fontSearch);
		btSearchHs = new JButton("Tìm Kiếm");
		btSearchHs.setFont(fontSearch);
		TimKiemHs.add(txtSearchHs);
		TimKiemHs.add(btSearchHs);
		
		JPanel lbTxt = new JPanel();
		lbTxt.setLayout(new BoxLayout(lbTxt, BoxLayout.Y_AXIS));
		lbTxt.setBackground(Color.YELLOW);
		Font fontJLabel = new Font("Arial", Font.BOLD | Font.PLAIN, 17);
		txtSearchHs = new JTextField("Tìm Kiếm");
		txtSearchHs.setFont(fontJLabel);
		btSearchHs = new JButton();
		btSearchHs.setFont(fontBt);
		lblMaHS = new JLabel("Mã Học Sinh:");
		lblMaHS.setFont(fontJLabel);
		lblHoHS = new JLabel("Họ Học Sinh:");
		lblHoHS.setFont(fontJLabel);
		lblTenHS = new JLabel("Tên Học Sinh :");
		lblTenHS.setFont(fontJLabel);
		lblTuoiHs = new JLabel("Tuổi :");
		lblTuoiHs.setFont(fontJLabel);
		lblDiaChiHs = new JLabel("Địa Chỉ:");
		lblDiaChiHs.setFont(fontJLabel);
		lblGioiTinhHs = new JLabel("Giới Tính:");
		lblGioiTinhHs.setFont(fontJLabel);
		lblNgaySinhHs = new JLabel("Ngày Sinh:");
		lblNgaySinhHs.setFont(fontJLabel);
		lblSDTHs = new JLabel("SĐT:");
		lblSDTHs.setFont(fontJLabel);
		lblEmailHs = new JLabel("Email:");
		lblEmailHs.setFont(fontJLabel);
		lblBuoiVangHs = new JLabel("Số Buổi Vắng:");
		lblBuoiVangHs.setFont(fontJLabel);
		lblId_LopHs = new JLabel("Mã Lớp");
		lblId_LopHs.setFont(fontJLabel);

		Font fontTXT = new Font("Arial", Font.BOLD | Font.PLAIN, 17);
		txtMaHS = new JTextField();
		txtMaHS.setFont(fontTXT);
		txtHoHS = new JTextField();
		txtHoHS.setFont(fontTXT);
		txtTenHS = new JTextField();
		txtTenHS.setFont(fontTXT);
		txtTuoiHs = new JTextField();
		txtTuoiHs.setFont(fontTXT);
		txtDiaChiHs = new JTextField();
		txtDiaChiHs.setFont(fontTXT);
		txtGioiTinhHs = new JTextField();
		txtGioiTinhHs.setFont(fontTXT);
		txtNgaySinhHs = new JTextField();
		txtNgaySinhHs.setFont(fontTXT);
		txtSDTHs = new JTextField();
		txtSDTHs.setFont(fontTXT);
		txtEmailHs = new JTextField();
		txtEmailHs.setFont(fontTXT);
		txtBuoiVangHs = new JTextField();
		txtBuoiVangHs.setFont(fontTXT);
		txtId_LopHs = new JTextField();
		txtId_LopHs.setFont(fontTXT);
		JPanel paneInput = new JPanel();
		paneInput.setLayout(new BoxLayout(paneInput, BoxLayout.Y_AXIS));
		paneInput.setBorder(borderTitle);
		lbTxt.add(lblMaHS);
		lbTxt.add(txtMaHS);
		lbTxt.add(lblHoHS);
		lbTxt.add(txtHoHS);
		lbTxt.add(lblTenHS);
		lbTxt.add(txtTenHS);
		lbTxt.add(lblTuoiHs);
		lbTxt.add(txtTuoiHs);
		lbTxt.add(lblDiaChiHs);
		lbTxt.add(txtDiaChiHs);
		lbTxt.add(lblGioiTinhHs);
		lbTxt.add(txtGioiTinhHs);
		lbTxt.add(lblNgaySinhHs);
		lbTxt.add(txtNgaySinhHs);
		lbTxt.add(lblSDTHs);
		lbTxt.add(txtSDTHs);
		lbTxt.add(lblEmailHs);
		lbTxt.add(txtEmailHs);
		lbTxt.add(lblBuoiVangHs);
		lbTxt.add(txtBuoiVangHs);
		lbTxt.add(lblId_LopHs);
		lbTxt.add(txtId_LopHs);
		paneInput.add(lbTxt);
		paneInput.add(paneActionButton);
		pnTab1.add(TimKiemHs,BorderLayout.NORTH);
		pnTab1.add(jScrollPane, BorderLayout.CENTER);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInput, pnTab1);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(500);

		loadingTableHS();
/////////////////////////////////////////////2 - HỒ SƠ HỌC SINH

		JPanel pnTab2 = new JPanel(new BorderLayout());
		pnTab2.setBackground(Color.CYAN);

		hoSoDao = new HoSoHSDao();

		tableHoSoHS = new DefaultTableModel();
		tableHoSoHS.addColumn("Mã Học Sinh");
		tableHoSoHS.addColumn("Họ Học Sinh");
		tableHoSoHS.addColumn("Tên Học Sinh");
		tableHoSoHS.addColumn("Tuổi");
		tableHoSoHS.addColumn("Địa Chỉ");
		tableHoSoHS.addColumn("Giới Tính");
		tableHoSoHS.addColumn("Ngày Sinh");
		tableHoSoHS.addColumn("Tiểu h�?c");
		tableHoSoHS.addColumn("Trường THCS");
		tableHoSoHS.addColumn("Trường THPT");
		tableHoSoHS.addColumn("Học Lực");
		tableHoSoHS.addColumn("Hạnh Kiểm");

		HoSoHS = new JTable(tableHoSoHS);
		HoSoHS.setPreferredSize(new Dimension(1680, 1000));
		Font f = new Font("Arial", Font.PLAIN, 15);
		HoSoHS.setFont(f);
		jSHoSoHS = new JScrollPane(HoSoHS);
		jSHoSoHS.setBorder(borderTitle);
		HoSoHS.addMouseListener(this);

		Font fontBtn = new Font("Arial", Font.PLAIN, 20);
		btnAddHsHs = new JButton("Add");
		btnAddHsHs.setFont(fontBtn);
		btnUpdateHsHs = new JButton("Update");
		btnUpdateHsHs.setFont(fontBtn);
		btnDeleteHsHs = new JButton("Delete");
		btnDeleteHsHs.setFont(fontBtn);
		btnCleanHsHs = new JButton("Clean");
		btnCleanHsHs.setFont(fontBtn);
		JPanel paneActionBtnHoSoHS = new JPanel();
		paneActionBtnHoSoHS.setBackground(Color.CYAN);
		paneActionBtnHoSoHS.add(btnAddHsHs);
		paneActionBtnHoSoHS.add(btnUpdateHsHs);
		paneActionBtnHoSoHS.add(btnDeleteHsHs);
		paneActionBtnHoSoHS.add(btnCleanHsHs);

		btnAddHsHs.addActionListener(this);
		btnUpdateHsHs.addActionListener(this);
		btnDeleteHsHs.addActionListener(this);
		btnCleanHsHs.addActionListener(this);

		JPanel TimKiemHsHs = new JPanel();
		TimKiemHsHs.setLayout(new BoxLayout(TimKiemHsHs, BoxLayout.X_AXIS));
		txtSearchHsHs = new JTextField();
		txtSearchHsHs.setFont(fontSearch);
		btSearchHsHs = new JButton("Tìm Kiếm");
		btSearchHsHs.setFont(fontSearch);
		TimKiemHsHs.add(txtSearchHsHs);
		TimKiemHsHs.add(btSearchHsHs);
		
		JPanel lbTxtHoSoHS = new JPanel();
		lbTxtHoSoHS.setLayout(new BoxLayout(lbTxtHoSoHS, BoxLayout.Y_AXIS));
		lbTxtHoSoHS.setBackground(Color.YELLOW);
		Font fontHoSoHS = new Font("Arial", Font.BOLD | Font.PLAIN, 17);
		HoSoMaHS = new JLabel("Mã Học Sinh:");
		HoSoMaHS.setFont(fontHoSoHS);
		HoSoHoHS = new JLabel("Họ Học Sinh:");
		HoSoHoHS.setFont(fontHoSoHS);
		HoSoTenHS = new JLabel("Tên Học Sinh :");
		HoSoTenHS.setFont(fontHoSoHS);
		HoSoTuoiHsHs = new JLabel("Tuổi :");
		HoSoTuoiHsHs.setFont(fontHoSoHS);
		HoSoDiaChiHsHs = new JLabel("Địa Chỉ:");
		HoSoDiaChiHsHs.setFont(fontHoSoHS);
		HoSoGioiTinhHsHs = new JLabel("Giới Tính:");
		HoSoGioiTinhHsHs.setFont(fontHoSoHS);
		HoSoNgaySinhHsHs = new JLabel("Ngày Sinh:");
		HoSoNgaySinhHsHs.setFont(fontHoSoHS);
		HoSoTieuHoc = new JLabel("Trường Tiểu Học:");
		HoSoTieuHoc.setFont(fontHoSoHS);
		HoSoTHCS = new JLabel("Trường THCS:");
		HoSoTHCS.setFont(fontHoSoHS);
		HoSoTHPT = new JLabel("Trường THPT:");
		HoSoTHPT.setFont(fontHoSoHS);
		HoSoHocLucHsHs = new JLabel("Học Lực:");
		HoSoHocLucHsHs.setFont(fontHoSoHS);
		HoSoHanhKiemHsHs = new JLabel("Hạnh Kiểm:");
		HoSoHanhKiemHsHs.setFont(fontHoSoHS);

		txHoSoMaHS = new JTextField();
		txHoSoMaHS.setFont(fontTXT);
		txHoSoHoHS = new JTextField();
		txHoSoHoHS.setFont(fontTXT);
		txHoSoTenHS = new JTextField();
		txHoSoTenHS.setFont(fontTXT);
		txHoSoHSTuoi = new JTextField();
		txHoSoHSTuoi.setFont(fontTXT);
		txHoSoHSDiaChi = new JTextField();
		txHoSoHSDiaChi.setFont(fontTXT);
		txHoSoHSGioiTinh = new JTextField();
		txHoSoHSGioiTinh.setFont(fontTXT);
		txHoSoHSNgaySinh = new JTextField();
		txHoSoHSNgaySinh.setFont(fontTXT);
		txHoSoHSTieuHoc = new JTextField();
		txHoSoHSTieuHoc.setFont(fontTXT);
		txHoSoHSTHCS = new JTextField();
		txHoSoHSTHCS.setFont(fontTXT);
		txHoSoHSTHPT = new JTextField();
		txHoSoHSTHPT.setFont(fontTXT);
		txHoSoHSHocLuc = new JTextField();
		txHoSoHSHocLuc.setFont(fontTXT);
		txHoSoHSHanhKiem = new JTextField();
		txHoSoHSHanhKiem.setFont(fontTXT);

		JPanel paneInputHoSoHS = new JPanel();
		paneInputHoSoHS.setLayout(new BoxLayout(paneInputHoSoHS, BoxLayout.Y_AXIS));
		lbTxtHoSoHS.add(HoSoMaHS);
		lbTxtHoSoHS.add(txHoSoMaHS);
		lbTxtHoSoHS.add(HoSoHoHS);
		lbTxtHoSoHS.add(txHoSoHoHS);
		lbTxtHoSoHS.add(HoSoTenHS);
		lbTxtHoSoHS.add(txHoSoTenHS);
		lbTxtHoSoHS.add(HoSoTuoiHsHs);
		lbTxtHoSoHS.add(txHoSoHSTuoi);
		lbTxtHoSoHS.add(HoSoDiaChiHsHs);
		lbTxtHoSoHS.add(txHoSoHSDiaChi);
		lbTxtHoSoHS.add(HoSoGioiTinhHsHs);
		lbTxtHoSoHS.add(txHoSoHSGioiTinh);
		lbTxtHoSoHS.add(HoSoNgaySinhHsHs);
		lbTxtHoSoHS.add(txHoSoHSNgaySinh);
		lbTxtHoSoHS.add(HoSoTieuHoc);
		lbTxtHoSoHS.add(txHoSoHSTieuHoc);
		lbTxtHoSoHS.add(HoSoTHCS);
		lbTxtHoSoHS.add(txHoSoHSTHCS);
		lbTxtHoSoHS.add(HoSoTHPT);
		lbTxtHoSoHS.add(txHoSoHSTHPT);
		lbTxtHoSoHS.add(HoSoHocLucHsHs);
		lbTxtHoSoHS.add(txHoSoHSHocLuc);
		lbTxtHoSoHS.add(HoSoHanhKiemHsHs);
		lbTxtHoSoHS.add(txHoSoHSHanhKiem);
		paneInputHoSoHS.add(lbTxtHoSoHS);
		paneInputHoSoHS.add(paneActionBtnHoSoHS);
		pnTab2.add(TimKiemHsHs,BorderLayout.NORTH);
		pnTab2.add(jSHoSoHS, BorderLayout.CENTER);

		JSplitPane splitHoSoHS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputHoSoHS, pnTab2);
		splitHoSoHS.setOneTouchExpandable(true);
		splitHoSoHS.setDividerLocation(500);

		loadingTableHoSoHS();
		
/////////////////////////////////////////////3 - QUẢN LÝ GIÁO VIÊN

		JPanel pnTab3 = new JPanel(new BorderLayout());
		pnTab3.setBackground(Color.CYAN);

		giaoVienDao = new GiaoVienDao();

		tableGiaoVien = new DefaultTableModel();
		tableGiaoVien.addColumn("Mã Giáo Viên");
		tableGiaoVien.addColumn("Họ Giáo Viên");
		tableGiaoVien.addColumn("Tên Giáo Viên");
		tableGiaoVien.addColumn("Tuổi");
		tableGiaoVien.addColumn("Địa Chỉ");
		tableGiaoVien.addColumn("Giới Tính");
		tableGiaoVien.addColumn("Ngày Sinh");
		tableGiaoVien.addColumn("SĐT Liên Hệ");
		tableGiaoVien.addColumn("Email");
		tableGiaoVien.addColumn("Chức Vụ");

		jTableGiaoVien = new JTable(tableGiaoVien);
		jTableGiaoVien.setPreferredSize(new Dimension(1680, 1000));
		Font fontGv = new Font("Arial", Font.PLAIN, 15);
		jTableGiaoVien.setFont(fontGv);
		jScrollPaneGiaoVien = new JScrollPane(jTableGiaoVien);
		jScrollPaneGiaoVien.setBorder(borderTitle);
		jTableGiaoVien.addMouseListener(this);

		// cac nut button
		Font fontBtGv = new Font("Arial", Font.PLAIN, 20);
		btnAddGv = new JButton("Add");
		btnAddGv.setFont(fontBtGv);
		btnUpdateGv = new JButton("Update");
		btnUpdateGv.setFont(fontBtGv);
		btnDeleteGv = new JButton("Delete");
		btnDeleteGv.setFont(fontBtGv);
		btnCleanGv = new JButton("Clean");
		btnCleanGv.setFont(fontBtGv);
		JPanel paneActionBtnGV = new JPanel();
		paneActionBtnGV.setBackground(Color.CYAN);
		paneActionBtnGV.add(btnAddGv);
		paneActionBtnGV.add(btnUpdateGv);
		paneActionBtnGV.add(btnDeleteGv);
		paneActionBtnGV.add(btnCleanGv);

		btnAddGv.addActionListener(this);
		btnUpdateGv.addActionListener(this);
		btnDeleteGv.addActionListener(this);
		btnCleanGv.addActionListener(this);

		JPanel TimKiemGv = new JPanel();
		TimKiemGv.setLayout(new BoxLayout(TimKiemGv, BoxLayout.X_AXIS));
		txtSearchGv = new JTextField();
		txtSearchGv.setFont(fontSearch);
		btSearchGv = new JButton("Tìm Kiếm");
		btSearchGv.setFont(fontSearch);
		TimKiemGv.add(txtSearchGv);
		TimKiemGv.add(btSearchGv);
		
		JPanel lbTxtGV = new JPanel();
		lbTxtGV.setLayout(new BoxLayout(lbTxtGV, BoxLayout.Y_AXIS));
		lbTxtGV.setBackground(Color.YELLOW);
		Font fontJLabelGv = new Font("Arial", Font.BOLD | Font.PLAIN, 17);
		lblMaGV = new JLabel("Mã Giáo Viên:");
		lblMaGV.setFont(fontJLabelGv);
		lblHoGV = new JLabel("Họ Giáo Viên:");
		lblHoGV.setFont(fontJLabelGv);
		lblTenGV = new JLabel("Tên Giáo Viên :");
		lblTenGV.setFont(fontJLabelGv);
		lblTuoiGv = new JLabel("Tuổi :");
		lblTuoiGv.setFont(fontJLabelGv);
		lblDiaChiGv = new JLabel("Địa Chỉ:");
		lblDiaChiGv.setFont(fontJLabelGv);
		lblGioiTinhGv = new JLabel("Giới Tính:");
		lblGioiTinhGv.setFont(fontJLabelGv);
		lblNgaySinhGv = new JLabel("Ngày Sinh:");
		lblNgaySinhGv.setFont(fontJLabelGv);
		lblSDTGv = new JLabel("SĐT:");
		lblSDTGv.setFont(fontJLabelGv);
		lblEmailGv = new JLabel("Email:");
		lblEmailGv.setFont(fontJLabelGv);
		lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setFont(fontJLabelGv);

		txtMaGV = new JTextField();
		txtMaGV.setFont(fontTXT);
		txtHoGV = new JTextField();
		txtHoGV.setFont(fontTXT);
		txtTenGV = new JTextField();
		txtTenGV.setFont(fontTXT);
		txtTuoiGv = new JTextField();
		txtTuoiGv.setFont(fontTXT);
		txtDiaChiGv = new JTextField();
		txtDiaChiGv.setFont(fontTXT);
		txtGioiTinhGv = new JTextField();
		txtGioiTinhGv.setFont(fontTXT);
		txtNgaySinhGv = new JTextField();
		txtNgaySinhGv.setFont(fontTXT);
		txtSDTGv = new JTextField();
		txtSDTGv.setFont(fontTXT);
		txtEmailGv = new JTextField();
		txtEmailGv.setFont(fontTXT);
		txtChucVu = new JTextField();
		txtChucVu.setFont(fontTXT);

		JPanel paneInputGV = new JPanel();
		paneInputGV.setLayout(new BoxLayout(paneInputGV, BoxLayout.Y_AXIS));
		lbTxtGV.add(lblMaGV);
		lbTxtGV.add(txtMaGV);
		lbTxtGV.add(lblHoGV);
		lbTxtGV.add(txtHoGV);
		lbTxtGV.add(lblTenGV);
		lbTxtGV.add(txtTenGV);
		lbTxtGV.add(lblTuoiGv);
		lbTxtGV.add(txtTuoiGv);
		lbTxtGV.add(lblDiaChiGv);
		lbTxtGV.add(txtDiaChiGv);
		lbTxtGV.add(lblGioiTinhGv);
		lbTxtGV.add(txtGioiTinhGv);
		lbTxtGV.add(lblNgaySinhGv);
		lbTxtGV.add(txtNgaySinhGv);
		lbTxtGV.add(lblSDTGv);
		lbTxtGV.add(txtSDTGv);
		lbTxtGV.add(lblEmailGv);
		lbTxtGV.add(txtEmailGv);
		lbTxtGV.add(lblChucVu);
		lbTxtGV.add(txtChucVu);
		paneInputGV.add(lbTxtGV);
		paneInputGV.add(paneActionBtnGV);
		pnTab3.add(TimKiemGv,BorderLayout.NORTH);
		pnTab3.add(jScrollPaneGiaoVien, BorderLayout.CENTER);

		JSplitPane splitPaneGv = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputGV, pnTab3);
		splitPaneGv.setOneTouchExpandable(true);
		splitPaneGv.setDividerLocation(500);

		loadingTableGV();
		
/////////////////////////////////////////////4 - HỒ SƠ GIÁO VIÊN
		
		JPanel pnTab4 = new JPanel(new BorderLayout());
		pnTab4.setBackground(Color.CYAN);

		hoSoGVDao = new HoSoGVDao();

		tableHoSoGV = new DefaultTableModel();
		tableHoSoGV.addColumn("Mã Giáo Viên");
		tableHoSoGV.addColumn("Họ Giáo Viên");
		tableHoSoGV.addColumn("Tên Giáo Viên");
		tableHoSoGV.addColumn("Tuổi");
		tableHoSoGV.addColumn("Địa Chỉ");
		tableHoSoGV.addColumn("Giới Tính");
		tableHoSoGV.addColumn("Ngày Sinh");
		tableHoSoGV.addColumn("SĐT Liên Hệ");
		tableHoSoGV.addColumn("Email");
		tableHoSoGV.addColumn("Trường Đại Học");
		tableHoSoGV.addColumn("Kinh Nghiệm(năm)");

		jTableHSGV = new JTable(tableHoSoGV);
		jTableHSGV.setPreferredSize(new Dimension(1680, 1000));
		Font fontHSGV = new Font("Arial", Font.PLAIN, 15);
		jTableHSGV.setFont(fontHSGV);
		jScrollPaneHSGV = new JScrollPane(jTableHSGV);
		jScrollPaneHSGV.setBorder(borderTitle);
		jTableHSGV.addMouseListener(this);

		// cac nut button
		Font fontBtHsGv = new Font("Arial", Font.PLAIN, 20);
		btnAddHsGv = new JButton("Add");
		btnAddHsGv.setFont(fontBtHsGv);
		btnUpdateHsGv = new JButton("Update");
		btnUpdateHsGv.setFont(fontBtHsGv);
		btnDeleteHsGv = new JButton("Delete");
		btnDeleteHsGv.setFont(fontBtHsGv);
		btnCleanHsGv = new JButton("Clean");
		btnCleanHsGv.setFont(fontBtHsGv);
		JPanel paneActionBtnHSGV = new JPanel();
		paneActionBtnHSGV.setBackground(Color.CYAN);
		paneActionBtnHSGV.add(btnAddHsGv);
		paneActionBtnHSGV.add(btnUpdateHsGv);
		paneActionBtnHSGV.add(btnDeleteHsGv);
		paneActionBtnHSGV.add(btnCleanHsGv);

		btnAddHsGv.addActionListener(this);
		btnUpdateHsGv.addActionListener(this);
		btnDeleteHsGv.addActionListener(this);
		btnCleanHsGv.addActionListener(this);

		JPanel TimKiemHsGv = new JPanel();
		TimKiemHsGv.setLayout(new BoxLayout(TimKiemHsGv, BoxLayout.X_AXIS));
		txtSearchHsGv = new JTextField();
		txtSearchHsGv.setFont(fontSearch);
		btSearchHsGv = new JButton("Tìm Kiếm");
		btSearchHsGv.setFont(fontSearch);
		TimKiemHsGv.add(txtSearchHsGv);
		TimKiemHsGv.add(btSearchHsGv);
		
		JPanel lbTxtHSGV = new JPanel();
		lbTxtHSGV.setLayout(new BoxLayout(lbTxtHSGV, BoxLayout.Y_AXIS));
		lbTxtHSGV.setBackground(Color.YELLOW);
		lblMaHoSoGV = new JLabel("Mã Giáo Viên:");
		lblMaHoSoGV.setFont(fontJLabel);
		lblHoHoSoGV = new JLabel("Họ Giáo Viên:");
		lblHoHoSoGV.setFont(fontJLabel);
		lblTenHoSoGV = new JLabel("Tên Giáo Viên:");
		lblTenHoSoGV.setFont(fontJLabel);
		lblTuoiHsGv = new JLabel("Tuổi :");
		lblTuoiHsGv.setFont(fontJLabel);
		lblDiaChiHsGv = new JLabel("Địa Chỉ:");
		lblDiaChiHsGv.setFont(fontJLabel);
		lblGioiTinhHsGv = new JLabel("Giới Tính:");
		lblGioiTinhHsGv.setFont(fontJLabel);
		lblNgaySinhHsGv = new JLabel("Ngày Sinh:");
		lblNgaySinhHsGv.setFont(fontJLabel);
		lblSDTHsGv = new JLabel("SĐT:");
		lblSDTHsGv.setFont(fontJLabel);
		lblEmailHsGv = new JLabel("Email:");
		lblEmailHsGv.setFont(fontJLabel);
		lblDaiHoc = new JLabel("Trường Đại Học:");
		lblDaiHoc.setFont(fontJLabel);
		lblKinhNghiem = new JLabel("Kinh Nghiệm:");
		lblKinhNghiem.setFont(fontJLabel);

		txtMaHoSoGV = new JTextField();
		txtMaHoSoGV.setFont(fontTXT);
		txtHoHoSoGV = new JTextField();
		txtHoHoSoGV.setFont(fontTXT);
		txtTenHoSoGV = new JTextField();
		txtTenHoSoGV.setFont(fontTXT);
		txtTuoiHsGv = new JTextField();
		txtTuoiHsGv.setFont(fontTXT);
		txtDiaChiHsGv = new JTextField();
		txtDiaChiHsGv.setFont(fontTXT);
		txtGioiTinhHsGv = new JTextField();
		txtGioiTinhHsGv.setFont(fontTXT);
		txtNgaySinhHsGv = new JTextField();
		txtNgaySinhHsGv.setFont(fontTXT);
		txtSDTHsGv = new JTextField();
		txtSDTHsGv.setFont(fontTXT);
		txtEmailHsGv = new JTextField();
		txtEmailHsGv.setFont(fontTXT);
		txtDaiHoc = new JTextField();
		txtDaiHoc.setFont(fontTXT);
		txtKinhNghiem = new JTextField();
		txtKinhNghiem.setFont(fontTXT);

		JPanel paneInputHSGV = new JPanel();
		paneInputHSGV.setLayout(new BoxLayout(paneInputHSGV, BoxLayout.Y_AXIS));
		lbTxtHSGV.add(lblMaHoSoGV);
		lbTxtHSGV.add(txtMaHoSoGV);
		lbTxtHSGV.add(lblHoHoSoGV);
		lbTxtHSGV.add(txtHoHoSoGV);
		lbTxtHSGV.add(lblTenHoSoGV);
		lbTxtHSGV.add(txtTenHoSoGV);
		lbTxtHSGV.add(lblTuoiHsGv);
		lbTxtHSGV.add(txtTuoiHsGv);
		lbTxtHSGV.add(lblDiaChiHsGv);
		lbTxtHSGV.add(txtDiaChiHsGv);
		lbTxtHSGV.add(lblGioiTinhHsGv);
		lbTxtHSGV.add(txtGioiTinhHsGv);
		lbTxtHSGV.add(lblNgaySinhHsGv);
		lbTxtHSGV.add(txtNgaySinhHsGv);
		lbTxtHSGV.add(lblSDTHsGv);
		lbTxtHSGV.add(txtSDTHsGv);
		lbTxtHSGV.add(lblEmailHsGv);
		lbTxtHSGV.add(txtEmailHsGv);
		lbTxtHSGV.add(lblDaiHoc);
		lbTxtHSGV.add(txtDaiHoc);
		lbTxtHSGV.add(lblKinhNghiem);
		lbTxtHSGV.add(txtKinhNghiem);
		paneInputHSGV.add(lbTxtHSGV);
		paneInputHSGV.add(paneActionBtnHSGV);
		pnTab4.add(TimKiemHsGv,BorderLayout.NORTH);
		pnTab4.add(jScrollPaneHSGV, BorderLayout.CENTER);

		JSplitPane splitPaneHSGV = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputHSGV, pnTab4);
		splitPaneHSGV.setOneTouchExpandable(true);
		splitPaneHSGV.setDividerLocation(500);

		loadingTableHoSoGV();
		
/////////////////////////////////////////////5 - LỚP HỌC
		JPanel pnTab5 = new JPanel(new BorderLayout());
		pnTab5.setBackground(Color.CYAN);

		lopDao = new LopDao();

		tableLopHoc = new DefaultTableModel();
		tableLopHoc.addColumn("Mã Lớp Học");
		tableLopHoc.addColumn("Tên Lớp");
		tableLopHoc.addColumn("Mã Niên Khoá");
		
		jTableLopHoc = new JTable(tableLopHoc);
		jTableLopHoc.setPreferredSize(new Dimension(1680, 1000));
		Font fontLopHoc = new Font("Arial", Font.PLAIN, 15);
		jTableLopHoc.setFont(fontLopHoc);
		jScrollPaneLopHoc = new JScrollPane(jTableLopHoc);
		jScrollPaneLopHoc.setBorder(borderTitle);
		jTableLopHoc.addMouseListener(this);

		// cac nut button
		Font fontBtLopHoc = new Font("Arial", Font.PLAIN, 20);
		btnAddLopHoc = new JButton("Add");
		btnAddLopHoc.setFont(fontBtLopHoc);
		btnUpdateLopHoc = new JButton("Update");
		btnUpdateLopHoc.setFont(fontBtLopHoc);
		btnDeleteLopHoc = new JButton("Delete");
		btnDeleteLopHoc.setFont(fontBtLopHoc);
		btnCleanLopHoc = new JButton("Clean");
		btnCleanLopHoc.setFont(fontBtLopHoc);
		JPanel paneActionBtnLopHoc = new JPanel();
		paneActionBtnLopHoc.setBackground(Color.CYAN);
		paneActionBtnLopHoc.add(btnAddLopHoc);
		paneActionBtnLopHoc.add(btnUpdateLopHoc);
		paneActionBtnLopHoc.add(btnDeleteLopHoc);
		paneActionBtnLopHoc.add(btnCleanLopHoc);

		btnAddLopHoc.addActionListener(this);
		btnUpdateLopHoc.addActionListener(this);
		btnDeleteLopHoc.addActionListener(this);
		btnCleanLopHoc.addActionListener(this);

		JPanel TimKiemLopHoc = new JPanel();
		TimKiemLopHoc.setLayout(new BoxLayout(TimKiemLopHoc, BoxLayout.X_AXIS));
		txtSearchLopHoc = new JTextField();
		txtSearchLopHoc.setFont(fontSearch);
		btSearchLopHoc = new JButton("Tìm Kiếm");
		btSearchLopHoc.setFont(fontSearch);
		TimKiemLopHoc.add(txtSearchLopHoc);
		TimKiemLopHoc.add(btSearchLopHoc);
		
		JPanel lbTxtLopHoc = new JPanel();
		lbTxtLopHoc.setLayout(new BoxLayout(lbTxtLopHoc, BoxLayout.Y_AXIS));
		lbTxtLopHoc.setBackground(Color.YELLOW);
		lblMaLopHoc = new JLabel("Mã Lớp Học:");
		lblMaLopHoc.setFont(fontJLabel);
		lblTenLopHoc = new JLabel("Tên Lớp Học:");
		lblTenLopHoc.setFont(fontJLabel);
		lblMaNienKhoa = new JLabel("Mã Niên Khoá:");
		lblMaNienKhoa.setFont(fontJLabel);

		txtMaLopHoc = new JTextField();
		txtMaLopHoc.setFont(fontTXT);
		txtTenLopHoc = new JTextField();
		txtTenLopHoc.setFont(fontTXT);
		txtTenLopHoc = new JTextField();
		txtTenLopHoc.setFont(fontTXT);
		txtMaNienKhoa = new JTextField();
		txtMaNienKhoa.setFont(fontTXT);

		JPanel paneInputLopHoc = new JPanel();
		paneInputLopHoc.setLayout(new BoxLayout(paneInputLopHoc, BoxLayout.Y_AXIS));
		lbTxtLopHoc.add(lblMaLopHoc);
		lbTxtLopHoc.add(txtMaLopHoc);
		lbTxtLopHoc.add(lblTenLopHoc);
		lbTxtLopHoc.add(txtTenLopHoc);
		lbTxtLopHoc.add(lblMaNienKhoa);
		lbTxtLopHoc.add(txtMaNienKhoa);
		paneInputLopHoc.add(lbTxtLopHoc);
		paneInputLopHoc.add(paneActionBtnLopHoc);
		pnTab5.add(TimKiemLopHoc,BorderLayout.NORTH);
		pnTab5.add(jScrollPaneLopHoc,BorderLayout.CENTER);

		JSplitPane splitPaneLopHoc = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputLopHoc, pnTab5);
		splitPaneLopHoc.setOneTouchExpandable(true);
		splitPaneLopHoc.setDividerLocation(500);

		loadingTableLopHoc();
		
/////////////////////////////////////////////6 - MÔN HỌC
		JPanel pnTab6 = new JPanel(new BorderLayout());
		pnTab6.setBackground(Color.CYAN);

		monHocDao = new MonHocDao();

		tableMonHoc = new DefaultTableModel();
		tableMonHoc.addColumn("Mã Môn Học");
		tableMonHoc.addColumn("Tên Môn Học");
		tableMonHoc.addColumn("Mã Giáo Viên");
		
		jTableMonHoc = new JTable(tableMonHoc);
		jTableMonHoc.setPreferredSize(new Dimension(1680, 1000));
		Font fontMonHoc = new Font("Arial", Font.PLAIN, 15);
		jTableMonHoc.setFont(fontMonHoc);
		jScrollPaneMonHoc = new JScrollPane(jTableMonHoc);
		jScrollPaneMonHoc.setBorder(borderTitle);
		jTableMonHoc.addMouseListener(this);

		// cac nut button
		Font fontBtMonHoc = new Font("Arial", Font.PLAIN, 20);
		btnAddMonHoc = new JButton("Add");
		btnAddMonHoc.setFont(fontBtMonHoc);
		btnUpdateMonHoc = new JButton("Update");
		btnUpdateMonHoc.setFont(fontBtMonHoc);
		btnDeleteMonHoc = new JButton("Delete");
		btnDeleteMonHoc.setFont(fontBtMonHoc);
		btnCleanMonHoc = new JButton("Clean");
		btnCleanMonHoc.setFont(fontBtMonHoc);
		JPanel paneActionBtnMonHoc = new JPanel();
		paneActionBtnMonHoc.setBackground(Color.CYAN);
		paneActionBtnMonHoc.add(btnAddMonHoc);
		paneActionBtnMonHoc.add(btnUpdateMonHoc);
		paneActionBtnMonHoc.add(btnDeleteMonHoc);
		paneActionBtnMonHoc.add(btnCleanMonHoc);

		btnAddMonHoc.addActionListener(this);
		btnUpdateMonHoc.addActionListener(this);
		btnDeleteMonHoc.addActionListener(this);
		btnCleanMonHoc.addActionListener(this);

		JPanel TimKiemMonHoc = new JPanel();
		TimKiemMonHoc.setLayout(new BoxLayout(TimKiemMonHoc, BoxLayout.X_AXIS));
		txtSearchMonHoc = new JTextField();
		txtSearchMonHoc.setFont(fontSearch);
		btSearchMonHoc = new JButton("Tìm Kiếm");
		btSearchMonHoc.setFont(fontSearch);
		TimKiemMonHoc.add(txtSearchMonHoc);
		TimKiemMonHoc.add(btSearchMonHoc);
		
		JPanel lbTxtMonHoc = new JPanel();
		lbTxtMonHoc.setLayout(new BoxLayout(lbTxtMonHoc, BoxLayout.Y_AXIS));
		lbTxtMonHoc.setBackground(Color.YELLOW);
		lblMaMonHoc = new JLabel("Mã Môn Học:");
		lblMaMonHoc.setFont(fontJLabel);
		lblTenMonHoc = new JLabel("Tên Môn Học:");
		lblTenMonHoc.setFont(fontJLabel);
		lblMaGiaoVien = new JLabel("Mã Giáo Viên:");
		lblMaGiaoVien.setFont(fontJLabel);

		txtMaMonHoc = new JTextField();
		txtMaMonHoc.setFont(fontTXT);
		txtTenMonHoc = new JTextField();
		txtTenMonHoc.setFont(fontTXT);
		txtMaGiaoVien = new JTextField();
		txtMaGiaoVien.setFont(fontTXT);

		JPanel paneInputMonHoc = new JPanel();
		paneInputMonHoc.setLayout(new BoxLayout(paneInputMonHoc, BoxLayout.Y_AXIS));
		lbTxtMonHoc.add(lblMaMonHoc);
		lbTxtMonHoc.add(txtMaMonHoc);
		lbTxtMonHoc.add(lblTenMonHoc);
		lbTxtMonHoc.add(txtTenMonHoc);
		lbTxtMonHoc.add(lblMaGiaoVien);
		lbTxtMonHoc.add(txtMaGiaoVien);
		paneInputMonHoc.add(lbTxtMonHoc);
		paneInputMonHoc.add(paneActionBtnMonHoc);
		pnTab6.add(TimKiemMonHoc,BorderLayout.NORTH);
		pnTab6.add(jScrollPaneMonHoc,BorderLayout.CENTER);

		JSplitPane splitPaneMonHoc = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputMonHoc, pnTab6);
		splitPaneMonHoc.setOneTouchExpandable(true);
		splitPaneMonHoc.setDividerLocation(500);

		loadingTableMonHoc();
		
/////////////////////////////////////////////7 - BẢNG ĐIỂM
		JPanel pnTab7 = new JPanel(new BorderLayout());
		pnTab7.setBackground(Color.CYAN);

		diemHocsinhDao = new DiemHocSinhDao();

		tableDiem = new DefaultTableModel();
		tableDiem.addColumn("Mã Môn Học");
		tableDiem.addColumn("Mã Học Sinh");
		tableDiem.addColumn("Điểm Miệng");
		tableDiem.addColumn("Điểm 15 phút");
		tableDiem.addColumn("Điểm 1 Tiết");
		tableDiem.addColumn("Điểm Học Kì");
		
		jTableDiem = new JTable(tableDiem);
		jTableDiem.setPreferredSize(new Dimension(1680, 1000));
		Font fontDiem = new Font("Arial", Font.PLAIN, 15);
		jTableDiem.setFont(fontDiem);
		jScrollPaneDiem = new JScrollPane(jTableDiem);
		jScrollPaneDiem.setBorder(borderTitle);
		jTableDiem.addMouseListener(this);

		// cac nut button
		Font fontBtDiem = new Font("Arial", Font.PLAIN, 20);
		btnAddDiem = new JButton("Add");
		btnAddDiem.setFont(fontBtDiem);
		btnUpdateDiem = new JButton("Update");
		btnUpdateDiem.setFont(fontBtDiem);
		btnDeleteDiem = new JButton("Delete");
		btnDeleteDiem.setFont(fontBtDiem);
		btnCleanDiem = new JButton("Clean");
		btnCleanDiem.setFont(fontBtDiem);
		JPanel paneActionBtnDiem = new JPanel();
		paneActionBtnDiem.setBackground(Color.CYAN);
		paneActionBtnDiem.add(btnAddDiem);
		paneActionBtnDiem.add(btnUpdateDiem);
		paneActionBtnDiem.add(btnDeleteDiem);
		paneActionBtnDiem.add(btnCleanDiem);

		btnAddDiem.addActionListener(this);
		btnUpdateDiem.addActionListener(this);
		btnDeleteDiem.addActionListener(this);
		btnCleanDiem.addActionListener(this);

		JPanel TimKiemDiem = new JPanel();
		TimKiemDiem.setLayout(new BoxLayout(TimKiemDiem, BoxLayout.X_AXIS));
		txtSearchDiem = new JTextField();
		txtSearchDiem.setFont(fontSearch);
		btSearchDiem = new JButton("Tìm Kiếm");
		btSearchDiem.setFont(fontSearch);
		TimKiemDiem.add(txtSearchMonHoc);
		TimKiemDiem.add(btSearchMonHoc);
			
		JPanel lbTxtDiem = new JPanel();
		lbTxtDiem.setLayout(new BoxLayout(lbTxtDiem, BoxLayout.Y_AXIS));
		lbTxtDiem.setBackground(Color.YELLOW);
		lblId_MonHoc = new JLabel("Mã Môn Học:");
		lblId_MonHoc.setFont(fontJLabel);
		lblId_HocSinh = new JLabel("Mã Giáo Viên:");
		lblId_HocSinh.setFont(fontJLabel);
		lblDiem_Mieng = new JLabel("Điểm Miệng:");
		lblDiem_Mieng.setFont(fontJLabel);
		lblDiem15p = new JLabel("Điểm 15 phút:");
		lblDiem15p.setFont(fontJLabel);
		lblDiem1Tiet = new JLabel("Điểm 1 Tiết:");
		lblDiem1Tiet.setFont(fontJLabel);
		lblDiemHocKi = new JLabel("Điểm Học Kì:");
		lblDiemHocKi.setFont(fontJLabel);

		txtId_MonHoc = new JTextField();
		txtId_MonHoc.setFont(fontTXT);
		txtId_HocSinh = new JTextField();
		txtId_HocSinh.setFont(fontTXT);
		txtDiem_Mieng = new JTextField();
		txtDiem_Mieng.setFont(fontTXT);
		txtDiem15p = new JTextField();
		txtDiem15p.setFont(fontTXT);
		txtDiem1Tiet = new JTextField();
		txtDiem1Tiet.setFont(fontTXT);
		txtDiemHocKi = new JTextField();
		txtDiemHocKi.setFont(fontTXT);

		JPanel paneInputDiem = new JPanel();
		paneInputDiem.setLayout(new BoxLayout(paneInputDiem, BoxLayout.Y_AXIS));
		lbTxtDiem.add(lblId_MonHoc);
		lbTxtDiem.add(txtId_MonHoc);
		lbTxtDiem.add(lblId_HocSinh);
		lbTxtDiem.add(txtId_HocSinh);
		lbTxtDiem.add(lblDiem_Mieng);
		lbTxtDiem.add(txtDiem_Mieng);
		lbTxtDiem.add(lblDiem15p);
		lbTxtDiem.add(txtDiem15p);
		lbTxtDiem.add(lblDiem1Tiet);
		lbTxtDiem.add(txtDiem1Tiet);
		lbTxtDiem.add(lblDiemHocKi);
		lbTxtDiem.add(txtDiemHocKi);
		paneInputDiem.add(lbTxtDiem);
		paneInputDiem.add(paneActionBtnDiem);
		pnTab7.add(TimKiemDiem,BorderLayout.NORTH);
		pnTab7.add(jScrollPaneDiem,BorderLayout.CENTER);

		JSplitPane splitPaneDiem = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputDiem, pnTab7);
		splitPaneDiem.setOneTouchExpandable(true);
		splitPaneDiem.setDividerLocation(500);

		loadingTableDiem();
/////////////////////////////////////////////8 - NIÊN KHOÁ	
		JPanel pnTab8 = new JPanel(new BorderLayout());
		pnTab8.setBackground(Color.CYAN);

		nienKhoaDao = new NienKhoaDao();

		tableNienKhoa = new DefaultTableModel();
		tableNienKhoa.addColumn("Mã Niên Khoá");
		tableNienKhoa.addColumn("Niên Khoá");
		
		jTableNienKhoa = new JTable(tableNienKhoa);
		jTableNienKhoa.setPreferredSize(new Dimension(1680, 1000));
		Font fontNienKhoa = new Font("Arial", Font.PLAIN, 15);
		jTableNienKhoa.setFont(fontNienKhoa);
		jScrollPaneNienKhoa = new JScrollPane(jTableNienKhoa);
		jScrollPaneNienKhoa.setBorder(borderTitle);
		jTableNienKhoa.addMouseListener(this);

		// cac nut button
		Font fontBtNienKhoa = new Font("Arial", Font.PLAIN, 20);
		btnAddNienKhoa = new JButton("Add");
		btnAddNienKhoa.setFont(fontBtNienKhoa);
		btnUpdateNienKhoa = new JButton("Update");
		btnUpdateNienKhoa.setFont(fontBtNienKhoa);
		btnDeleteNienKhoa = new JButton("Delete");
		btnDeleteNienKhoa.setFont(fontBtNienKhoa);
		btnCleanNienKhoa = new JButton("Clean");
		btnCleanNienKhoa.setFont(fontBtNienKhoa);
		JPanel paneActionBtNienKhoa = new JPanel();
		paneActionBtNienKhoa.setBackground(Color.CYAN);
		paneActionBtNienKhoa.add(btnAddNienKhoa);
		paneActionBtNienKhoa.add(btnUpdateNienKhoa);
		paneActionBtNienKhoa.add(btnDeleteNienKhoa);
		paneActionBtNienKhoa.add(btnCleanNienKhoa);

		btnAddNienKhoa.addActionListener(this);
		btnUpdateNienKhoa.addActionListener(this);
		btnDeleteNienKhoa.addActionListener(this);
		btnCleanNienKhoa.addActionListener(this);

		JPanel TimKiemNienKhoa = new JPanel();
		TimKiemNienKhoa.setLayout(new BoxLayout(TimKiemNienKhoa, BoxLayout.X_AXIS));
		txtSearchNienKhoa = new JTextField();
		txtSearchNienKhoa.setFont(fontSearch);
		btSearchNienKhoa = new JButton("Tìm Kiếm");
		btSearchNienKhoa.setFont(fontSearch);
		TimKiemNienKhoa.add(txtSearchNienKhoa);
		TimKiemNienKhoa.add(btSearchNienKhoa);
			
		JPanel lbTxtNienKhoa = new JPanel();
		lbTxtNienKhoa.setLayout(new BoxLayout(lbTxtNienKhoa, BoxLayout.Y_AXIS));
		lbTxtNienKhoa.setBackground(Color.YELLOW);
		lblId_NienKhoa = new JLabel("Mã Niên Khoá:");
		lblId_NienKhoa.setFont(fontJLabel);
		lblNienKhoa = new JLabel("Niên Khoá:");
		lblNienKhoa.setFont(fontJLabel);

		txtId_NienKhoa = new JTextField();
		txtId_NienKhoa.setFont(fontTXT);
		txtNienKhoa = new JTextField();
		txtNienKhoa.setFont(fontTXT);

		JPanel paneInputNienKhoa = new JPanel();
		paneInputNienKhoa.setLayout(new BoxLayout(paneInputNienKhoa, BoxLayout.Y_AXIS));
		lbTxtNienKhoa.add(lblId_NienKhoa);
		lbTxtNienKhoa.add(txtId_NienKhoa);
		lbTxtNienKhoa.add(lblNienKhoa);
		lbTxtNienKhoa.add(txtNienKhoa);
		paneInputNienKhoa.add(lbTxtNienKhoa);
		paneInputNienKhoa.add(paneActionBtNienKhoa);
		pnTab8.add(TimKiemNienKhoa,BorderLayout.NORTH);
		pnTab8.add(jScrollPaneNienKhoa,BorderLayout.CENTER);

		JSplitPane splitPaneNienKhoa = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputNienKhoa, pnTab8);
		splitPaneNienKhoa.setOneTouchExpandable(true);
		splitPaneNienKhoa.setDividerLocation(500);

		loadingTableNienKhoa();
/////////////////////////////////////////////9 - TỔNG KẾT
		JPanel pnTab9 = new JPanel(new BorderLayout());
		pnTab9.setBackground(Color.CYAN);

		tongKetDao = new TongKetDao();

		tableTongKet = new DefaultTableModel();
		tableTongKet.addColumn("Mã Học Sinh");
		tableTongKet.addColumn("Họ Học Sinh");
		tableTongKet.addColumn("Tên Học Sinh");
		tableTongKet.addColumn("Lớp");
		tableTongKet.addColumn("Học Lực(HK1)");
		tableTongKet.addColumn("Hạnh Kiểm(HK1)");
		tableTongKet.addColumn("Học Lực(HK2)");
		tableTongKet.addColumn("Hạnh Kiểm(HK2)");
		tableTongKet.addColumn("Học Lực(Cả Năm)");
		tableTongKet.addColumn("Hạnh Kiểm(Cả Năm)");
		tableTongKet.addColumn("Niên Khoá");

		jTableTK = new JTable(tableTongKet);
		jTableTK.setPreferredSize(new Dimension(1680, 1000));
		Font fontTk = new Font("Arial", Font.PLAIN, 15);
		jTableTK.setFont(fontTk);
		jScrollPaneTK = new JScrollPane(jTableTK);
		jScrollPaneTK.setBorder(borderTitle);
		jTableTK.addMouseListener(this);

		// cac nut button
		Font fontBtTk = new Font("Arial", Font.PLAIN, 20);
		btnAddTk = new JButton("Add");
		btnAddTk.setFont(fontBtTk);
		btnUpdateTk = new JButton("Update");
		btnUpdateTk.setFont(fontBtTk);
		btnDeleteTk = new JButton("Delete");
		btnDeleteTk.setFont(fontBtTk);
		btnCleanTk = new JButton("Clean");
		btnCleanTk.setFont(fontBtTk);
		JPanel paneActionBtnTK = new JPanel();
		paneActionBtnTK.setBackground(Color.CYAN);
		paneActionBtnTK.add(btnAddTk);
		paneActionBtnTK.add(btnUpdateTk);
		paneActionBtnTK.add(btnDeleteTk);
		paneActionBtnTK.add(btnCleanTk);

		btnAddTk.addActionListener(this);
		btnUpdateTk.addActionListener(this);
		btnDeleteTk.addActionListener(this);
		btnCleanTk.addActionListener(this);

		JPanel TimKiemTk = new JPanel();
		TimKiemTk.setLayout(new BoxLayout(TimKiemTk, BoxLayout.X_AXIS));
		txtSearchTk = new JTextField();
		txtSearchTk.setFont(fontSearch);
		btSearchTk = new JButton("Tìm Kiếm");
		btSearchTk.setFont(fontSearch);
		TimKiemTk.add(txtSearchTk);
		TimKiemTk.add(btSearchTk);
		
		JPanel lbTxtTK = new JPanel();
		lbTxtTK.setLayout(new BoxLayout(lbTxtTK, BoxLayout.Y_AXIS));
		lbTxtTK.setBackground(Color.YELLOW);
		lblMaHSTk = new JLabel("Mã Học Sinh:");
		lblMaHSTk.setFont(fontJLabel);
		lblHoHSTk = new JLabel("Họ Học Sinh:");
		lblHoHSTk.setFont(fontJLabel);
		lblTenHSTk = new JLabel("Tên Học Sinh :");
		lblTenHSTk.setFont(fontJLabel);
		lblLop = new JLabel("Lớp:");
		lblLop.setFont(fontJLabel);
		lblHocLuc1 = new JLabel("Học Lực(HK1):");
		lblHocLuc1.setFont(fontJLabel);
		lblHanhKiem1 = new JLabel("Hạnh Kiểm(HK1):");
		lblHanhKiem1.setFont(fontJLabel);
		lblHocLuc2 = new JLabel("Học Lực(HK2):");
		lblHocLuc2.setFont(fontJLabel);
		lblHanhKiem2 = new JLabel("Hạnh Kiểm(HK2):");
		lblHanhKiem2.setFont(fontJLabel);
		lblHocLucCN = new JLabel("Học Lực(Cả Năm):");
		lblHocLucCN.setFont(fontJLabel);
		lblHanhKiemCN = new JLabel("Hạnh Kiểm(Cả Năm):");
		lblHanhKiemCN.setFont(fontJLabel);
		lblIdNienKhoa = new JLabel(" Id Niên Khoá:");
		lblIdNienKhoa.setFont(fontJLabel);

		txtMaHSTk = new JTextField();
		txtMaHSTk.setFont(fontTXT);
		txtHoHSTk = new JTextField();
		txtHoHSTk.setFont(fontTXT);
		txtTenHSTk = new JTextField();
		txtTenHSTk.setFont(fontTXT);
		txtLop = new JTextField();
		txtLop.setFont(fontTXT);
		txtHocLuc1 = new JTextField();
		txtHocLuc1.setFont(fontTXT);
		txtHanhKiem1 = new JTextField();
		txtHanhKiem1.setFont(fontTXT);
		txtHocLuc2 = new JTextField();
		txtHocLuc2.setFont(fontTXT);
		txtHanhKiem2 = new JTextField();
		txtHanhKiem2.setFont(fontTXT);
		txtHocLucCN = new JTextField();
		txtHocLucCN.setFont(fontTXT);
		txtHanhKiemCN = new JTextField();
		txtHanhKiemCN.setFont(fontTXT);
		txtIdNienKhoa = new JTextField();
		txtIdNienKhoa.setFont(fontTXT);
		JPanel paneInputTK = new JPanel();
		paneInputTK.setLayout(new BoxLayout(paneInputTK, BoxLayout.Y_AXIS));
		lbTxtTK.add(lblMaHSTk);
		lbTxtTK.add(txtMaHSTk);
		lbTxtTK.add(lblHoHSTk);
		lbTxtTK.add(txtHoHSTk);
		lbTxtTK.add(lblTenHSTk);
		lbTxtTK.add(txtTenHSTk);
		lbTxtTK.add(lblLop);
		lbTxtTK.add(txtLop);
		lbTxtTK.add(lblHocLuc1);
		lbTxtTK.add(txtHocLuc1);
		lbTxtTK.add(lblHanhKiem1);
		lbTxtTK.add(txtHanhKiem1);
		lbTxtTK.add(lblHocLuc2);
		lbTxtTK.add(txtHocLuc2);
		lbTxtTK.add(lblHanhKiem2);
		lbTxtTK.add(txtHanhKiem2);
		lbTxtTK.add(lblHocLucCN);
		lbTxtTK.add(txtHocLucCN);
		lbTxtTK.add(lblHanhKiemCN);
		lbTxtTK.add(txtHanhKiemCN);
		lbTxtTK.add(lblIdNienKhoa);
		lbTxtTK.add(txtIdNienKhoa);
		paneInputTK.add(lbTxtTK);
		paneInputTK.add(paneActionBtnTK);
		pnTab9.add(TimKiemTk,BorderLayout.NORTH);
		pnTab9.add(jScrollPaneTK, BorderLayout.CENTER);

		JSplitPane splitPaneTK = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputTK, pnTab9);
		splitPaneTK.setOneTouchExpandable(true);
		splitPaneTK.setDividerLocation(500);

		loadingTableTK();
		
/////////////////////////////////////////////10 - QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG
		JPanel pnTab10 = new JPanel(new BorderLayout());
		pnTab10.setBackground(Color.CYAN);

		taiKhoanDao = new TaiKhoanDao();

		tableTaiKhoan = new DefaultTableModel();
		tableTaiKhoan.addColumn("Username");
		tableTaiKhoan.addColumn("Password");
		tableTaiKhoan.addColumn("Id_Rule");

		jTableTaiKhoan = new JTable(tableTaiKhoan);
		jTableTaiKhoan.setPreferredSize(new Dimension(1680, 1000));
		Font fontTaiKhoan = new Font("Arial", Font.PLAIN, 15);
		jTableTaiKhoan.setFont(fontTaiKhoan);
		jScrollPaneTaiKhoan = new JScrollPane(jTableTaiKhoan);
		jScrollPaneTaiKhoan.setBorder(borderTitle);
		jTableTaiKhoan.addMouseListener(this);

		// cac nut button
		Font fontBtTaiKhoan = new Font("Arial", Font.PLAIN, 20);
		btnAddTaiKhoan = new JButton("Add");
		btnAddTaiKhoan.setFont(fontBtTaiKhoan);
		btnUpdateTaiKhoan = new JButton("Update");
		btnUpdateTaiKhoan.setFont(fontBtTaiKhoan);
		btnDeleteTaiKhoan = new JButton("Delete");
		btnDeleteTaiKhoan.setFont(fontBtTaiKhoan);
		btnCleanTaiKhoan = new JButton("Clean");
		btnCleanTaiKhoan.setFont(fontBtTaiKhoan);
		JPanel paneActionBtnTaiKhoan = new JPanel();
		paneActionBtnTaiKhoan.setBackground(Color.CYAN);
		paneActionBtnTaiKhoan.add(btnAddTaiKhoan);
		paneActionBtnTaiKhoan.add(btnUpdateTaiKhoan);
		paneActionBtnTaiKhoan.add(btnDeleteTaiKhoan);
		paneActionBtnTaiKhoan.add(btnCleanTaiKhoan);

		btnAddTaiKhoan.addActionListener(this);
		btnUpdateTaiKhoan.addActionListener(this);
		btnDeleteTaiKhoan.addActionListener(this);
		btnCleanTaiKhoan.addActionListener(this);

		JPanel TimKiemTaiKhoan = new JPanel();
		TimKiemTaiKhoan.setLayout(new BoxLayout(TimKiemTaiKhoan, BoxLayout.X_AXIS));
		txtSearchTaiKhoan = new JTextField();
		txtSearchTaiKhoan.setFont(fontSearch);
		btSearchTaiKhoan = new JButton("Tìm Kiếm");
		btSearchTaiKhoan.setFont(fontSearch);
		TimKiemTaiKhoan.add(txtSearchTaiKhoan);
		TimKiemTaiKhoan.add(btSearchTaiKhoan);
		
		JPanel lbTxtTaiKhoan = new JPanel();
		lbTxtTaiKhoan.setLayout(new BoxLayout(lbTxtTaiKhoan, BoxLayout.Y_AXIS));
		lbTxtTaiKhoan.setBackground(Color.YELLOW);
		Font fontTaiKhaon = new Font("Arial", Font.BOLD | Font.PLAIN, 17);
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(fontTaiKhaon);
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(fontTaiKhaon);
		lblId_Rule = new JLabel("Id_Rule:");
		lblId_Rule.setFont(fontTaiKhaon);

		txtUsername = new JTextField();
		txtUsername.setFont(fontTXT);
		txtPassword = new JTextField();
		txtPassword.setFont(fontTXT);
		txtId_Rule = new JTextField();
		txtId_Rule.setFont(fontTXT);

		JPanel paneInputTaiKhoan = new JPanel();
		paneInputTaiKhoan.setLayout(new BoxLayout(paneInputTaiKhoan, BoxLayout.Y_AXIS));
		lbTxtTaiKhoan.add(lblUsername);
		lbTxtTaiKhoan.add(txtUsername);
		lbTxtTaiKhoan.add(lblPassword);
		lbTxtTaiKhoan.add(txtPassword);
		lbTxtTaiKhoan.add(lblId_Rule);
		lbTxtTaiKhoan.add(txtId_Rule);
		paneInputTaiKhoan.add(lbTxtTaiKhoan);
		paneInputTaiKhoan.add(paneActionBtnTaiKhoan);
		pnTab10.add(TimKiemTaiKhoan,BorderLayout.NORTH);
		pnTab10.add(jScrollPaneTaiKhoan, BorderLayout.CENTER);

		JSplitPane splitPaneTaiKhoan = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneInputTaiKhoan, pnTab10);
		splitPaneTaiKhoan.setOneTouchExpandable(true);
		splitPaneTaiKhoan.setDividerLocation(500);

		loadingTableTaiKhoan();
//////////////////////////////////////////////////////////////////////

		myTabled.add(splitPane, "Quản Lý Học Sinh");
		myTabled.add(splitHoSoHS, "Hồ Sơ Học Sinh");
		myTabled.add(splitPaneGv, "Quản Lý Giáo Viên");
		myTabled.add(splitPaneHSGV, "Hồ Sơ Giáo Viên");
		myTabled.add(splitPaneLopHoc, "Quản Lý Lớp");
		myTabled.add(splitPaneMonHoc, "Quản Lý Môn Học");
		myTabled.add(splitPaneDiem, "Quản Lý Điểm");
		myTabled.add(splitPaneNienKhoa, "Quản Lý Niên Khoá");
		myTabled.add(splitPaneTK, "Tổng Kết");
		myTabled.add(splitPaneTaiKhoan, "Quản Lý Tài Khoản");

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(pnLabel);
		container.add(myTabled);
		container.setBackground(Color.CYAN);
	}

/////////////////////////////////////////////1 - QUẢN LÝ HỌC SINH
	private void loadingTableHS() {
		tableHocSinh.setRowCount(0);

		List<HocSinh> listHocSinh = hocSinhDao.getAllUser();

		for (HocSinh hs : listHocSinh) {
			tableHocSinh.addRow(new String[] { "" + hs.getId_HocSinh(), hs.getFirstName(), hs.getLastName(),
					String.valueOf(hs.getAge()), hs.getAddress(), hs.getSex(), hs.getBirth(), hs.getNumberPhone(),
					hs.getEmail(), String.valueOf(hs.getAbsence()),hs.getId_Lop() });
		}
	}

	private void addHS() {
		HocSinh hs = new HocSinh();

		hs.setId_HocSinh(txtMaHS.getText());
		hs.setFirstName(txtHoHS.getText());
		hs.setLastName(txtTenHS.getText());
		hs.setAge(Integer.parseInt(txtTuoiHs.getText()));
		hs.setAddress(txtDiaChiHs.getText());
		hs.setSex(txtGioiTinhHs.getText());
		hs.setBirth(txtNgaySinhHs.getText());
		hs.setNumberPhone(txtSDTHs.getText());
		hs.setEmail(txtEmailHs.getText());
		hs.setAbsence(Integer.parseInt(txtBuoiVangHs.getText()));
		hs.setId_Lop(txtId_LopHs.getText());

		hocSinhDao.addUser(hs);
	}

	private void updateHS() {
		HocSinh hs = new HocSinh();

		hs.setId_HocSinh(txtMaHS.getText());
		hs.setFirstName(txtHoHS.getText());
		hs.setLastName(txtTenHS.getText());
		hs.setAge(Integer.parseInt(txtTuoiHs.getText()));
		hs.setAddress(txtDiaChiHs.getText());
		hs.setSex(txtGioiTinhHs.getText());
		hs.setBirth(txtNgaySinhHs.getText());
		hs.setNumberPhone(txtSDTHs.getText());
		hs.setEmail(txtEmailHs.getText());
		hs.setAbsence(Integer.parseInt(txtBuoiVangHs.getText()));
		hs.setId_Lop(txtId_LopHs.getText());

		hocSinhDao.updateUser(hs);
	}

	private void deleteHS() {
		String maHS = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);
		hocSinhDao.deleteUser(maHS);
	}

	private void clearInfoHS() {

		txtMaHS.setText("");
		txtHoHS.setText("");
		txtTenHS.setText("");
		txtTuoiHs.setText("");
		txtDiaChiHs.setText("");
		txtGioiTinhHs.setText("");
		txtNgaySinhHs.setText("");
		txtSDTHs.setText("");
		txtEmailHs.setText("");
		txtBuoiVangHs.setText("");
		txtId_LopHs.setText("");
	}

/////////////////////////////////////////////2 - HỒ SƠ HỌC SINH

	private void loadingTableHoSoHS() {
		tableHoSoHS.setRowCount(0);

		List<HoSo_Student> listHoSoHocSinh = hoSoDao.getAllUser();

		for (HoSo_Student hoSoHS : listHoSoHocSinh) {
			tableHoSoHS.addRow(new String[] { "" + hoSoHS.getId_HocSinh(), hoSoHS.getFirstName(), hoSoHS.getLastName(),
					String.valueOf(hoSoHS.getAge()), hoSoHS.getAddress(), hoSoHS.getSex(), hoSoHS.getBirth(),
					hoSoHS.getPrimarySchool(), hoSoHS.getJuniorHighSchool(), hoSoHS.getHighSchool(),
					hoSoHS.getStudyCapacity(), hoSoHS.getConduct() });
		}
	}

	private void addHoSoHS() {
		HoSo_Student hoSoHS = new HoSo_Student();

		hoSoHS.setId_HocSinh(txHoSoMaHS.getText());
		hoSoHS.setFirstName(txHoSoHoHS.getText());
		hoSoHS.setLastName(txHoSoTenHS.getText());
		hoSoHS.setAge(Integer.parseInt(txHoSoHSTuoi.getText()));
		hoSoHS.setAddress(txHoSoHSDiaChi.getText());
		hoSoHS.setSex(txHoSoHSGioiTinh.getText());
		hoSoHS.setBirth(txHoSoHSNgaySinh.getText());
		hoSoHS.setPrimarySchool(txHoSoHSTieuHoc.getText());
		hoSoHS.setJuniorHighSchool(txHoSoHSTHCS.getText());
		hoSoHS.setHighSchool(txHoSoHSTHPT.getText());
		hoSoHS.setStudyCapacity(txHoSoHSHocLuc.getText());
		hoSoHS.setConduct(txHoSoHSHanhKiem.getText());

		hoSoDao.addUser(hoSoHS);
	}

	private void updateHoSoHS() {
		HoSo_Student hoSoHS = new HoSo_Student();

		hoSoHS.setId_HocSinh(txHoSoMaHS.getText());
		hoSoHS.setFirstName(txHoSoHoHS.getText());
		hoSoHS.setLastName(txHoSoTenHS.getText());
		hoSoHS.setAge(Integer.parseInt(txHoSoHSTuoi.getText()));
		hoSoHS.setAddress(txHoSoHSDiaChi.getText());
		hoSoHS.setSex(txHoSoHSGioiTinh.getText());
		hoSoHS.setBirth(txHoSoHSNgaySinh.getText());
		hoSoHS.setPrimarySchool(txHoSoHSTieuHoc.getText());
		hoSoHS.setJuniorHighSchool(txHoSoHSTHCS.getText());
		hoSoHS.setHighSchool(txHoSoHSTHPT.getText());
		hoSoHS.setStudyCapacity(txHoSoHSHocLuc.getText());
		hoSoHS.setConduct(txHoSoHSHanhKiem.getText());

		hoSoDao.updateUser(hoSoHS);
	}

	private void deleteHoSoHS() {
		String maHoSoHS = (String) HoSoHS.getValueAt(HoSoHS.getSelectedRow(), 0);
		hoSoDao.deleteUser(maHoSoHS);
	}

	private void clearInfoHoSoHS() {
		txHoSoMaHS.setText("");
		txHoSoHoHS.setText("");
		txHoSoTenHS.setText("");
		txHoSoHSTuoi.setText("");
		txHoSoHSDiaChi.setText("");
		txHoSoHSGioiTinh.setText("");
		txHoSoHSNgaySinh.setText("");
		txHoSoHSTieuHoc.setText("");
		txHoSoHSTHCS.setText("");
		txHoSoHSTHPT.setText("");
		txHoSoHSHocLuc.setText("");
		txHoSoHSHanhKiem.setText("");
	}
/////////////////////////////////////////////3 - QUẢN LÝ GIÁO VIÊN

	private void loadingTableGV() {
		tableGiaoVien.setRowCount(0);

		List<GiaoVien> listGiaoVien = giaoVienDao.getAllUser();

		for (GiaoVien gv : listGiaoVien) {
			tableGiaoVien.addRow(new String[] { "" + gv.getId_GiaoVien(), gv.getFirstName(), gv.getLastName(),
					String.valueOf(gv.getAge()), gv.getAddress(), gv.getSex(), gv.getBirth(), gv.getNumberPhone(),
					gv.getEmail(), gv.getPosition() });
		}
	}

	private void addGV() {
		GiaoVien gv = new GiaoVien();

		gv.setId_GiaoVien(txtMaGV.getText());
		gv.setFirstName(txtHoGV.getText());
		gv.setLastName(txtTenGV.getText());
		gv.setAge(Integer.parseInt(txtTuoiGv.getText()));
		gv.setAddress(txtDiaChiGv.getText());
		gv.setSex(txtGioiTinhGv.getText());
		gv.setBirth(txtNgaySinhGv.getText());
		gv.setNumberPhone(txtSDTGv.getText());
		gv.setEmail(txtEmailGv.getText());
		gv.setPosition(txtChucVu.getText());

		giaoVienDao.addUser(gv);
	}

	private void updateGV() {
		GiaoVien gv = new GiaoVien();

		gv.setId_GiaoVien(txtMaGV.getText());
		gv.setFirstName(txtHoGV.getText());
		gv.setLastName(txtTenGV.getText());
		gv.setAge(Integer.parseInt(txtTuoiGv.getText()));
		gv.setAddress(txtDiaChiGv.getText());
		gv.setSex(txtGioiTinhGv.getText());
		gv.setBirth(txtNgaySinhGv.getText());
		gv.setNumberPhone(txtSDTGv.getText());
		gv.setEmail(txtEmailGv.getText());
		gv.setPosition(txtChucVu.getText());
		giaoVienDao.updateUser(gv);
	}

	private void deleteGV() {
		String maGV = (String) jTableGiaoVien.getValueAt(jTableGiaoVien.getSelectedRow(), 0);
		giaoVienDao.deleteUser(maGV);
	}

	private void clearInfoGV() {
		txtMaGV.setText("");
		txtHoGV.setText("");
		txtTenGV.setText("");
		txtTuoiGv.setText("");
		txtDiaChiGv.setText("");
		txtGioiTinhGv.setText("");
		txtNgaySinhGv.setText("");
		txtSDTGv.setText("");
		txtEmailGv.setText("");
		txtChucVu.setText("");
	}
/////////////////////////////////////////////4 - HỒ SƠ GI�?O VI�?N

	private void loadingTableHoSoGV() {
		tableHoSoGV.setRowCount(0);

		List<HoSo_Teacher> listHoSoGV = hoSoGVDao.getAllUser();

		for (HoSo_Teacher hosoGV : listHoSoGV) {
			tableHoSoGV.addRow(new String[] { "" + hosoGV.getId_GiaoVien(), hosoGV.getFirstName(), hosoGV.getLastName(),
					String.valueOf(hosoGV.getAge()), hosoGV.getAddress(), hosoGV.getSex(), hosoGV.getBirth(),
					String.valueOf(hosoGV.getNumberPhone()), hosoGV.getEmail(), hosoGV.getUniversity(), hosoGV.getExperience() });
		}
	}

	private void addHoSoGV() {
		HoSo_Teacher hosoGV = new HoSo_Teacher();

		hosoGV.setid_GiaoVien(txtMaHoSoGV.getText());
		hosoGV.setFirstName(txtHoHoSoGV.getText());
		hosoGV.setLastName(txtTenHoSoGV.getText());
		hosoGV.setAge(Integer.parseInt(txtTuoiHsGv.getText()));
		hosoGV.setAddress(txtDiaChiHsGv.getText());
		hosoGV.setSex(txtGioiTinhHsGv.getText());
		hosoGV.setBirth(txtNgaySinhHsGv.getText());
		hosoGV.setNumberPhone(txtSDTHsGv.getText());
		hosoGV.setEmail(txtEmailHsGv.getText());
		hosoGV.setUniversity(txtDaiHoc.getText());
		hosoGV.setExperience(txtKinhNghiem.getText());

		hoSoGVDao.addUser(hosoGV);
	}

	private void updateHoSoGV() {
		HoSo_Teacher hosoGV = new HoSo_Teacher();

		hosoGV.setid_GiaoVien(txtMaHoSoGV.getText());
		hosoGV.setFirstName(txtHoHoSoGV.getText());
		hosoGV.setLastName(txtTenHoSoGV.getText());
		hosoGV.setAge(Integer.parseInt(txtTuoiHsGv.getText()));
		hosoGV.setAddress(txtDiaChiHsGv.getText());
		hosoGV.setSex(txtGioiTinhHsGv.getText());
		hosoGV.setBirth(txtNgaySinhHsGv.getText());
		hosoGV.setNumberPhone(txtSDTHsGv.getText());
		hosoGV.setEmail(txtEmailHsGv.getText());
		hosoGV.setUniversity(txtDaiHoc.getText());
		hosoGV.setExperience(txtKinhNghiem.getText());

		hoSoGVDao.updateUser(hosoGV);
	}

	private void deleteHoSoGV() {
		String maHSGV = (String) jTableHSGV.getValueAt(jTableHSGV.getSelectedRow(), 0);
		hoSoGVDao.deleteUser(maHSGV);
	}

	private void clearInfoHoSoGV() {

		txtMaHoSoGV.setText("");
		txtHoHoSoGV.setText("");
		txtTenHoSoGV.setText("");
		txtTuoiHsGv.setText("");
		txtDiaChiHsGv.setText("");
		txtGioiTinhHsGv.setText("");
		txtNgaySinhHsGv.setText("");
		txtSDTHsGv.setText("");
		txtEmailHsGv.setText("");
		txtDaiHoc.setText("");
		txtKinhNghiem.setText("");
	}
/////////////////////////////////////////////5 - QUẢN L�? L�?P
	private void loadingTableLopHoc() {
		tableLopHoc.setRowCount(0);

		List<Lop> listLop = lopDao.getAllUser();

		for (Lop lop : listLop) {
			tableLopHoc.addRow(new String[] { "" + lop.getId_Lop(), lop.getClassName(),lop.getId_NienKhoa() });
		}
	}

	private void addLop() {
		Lop lop = new Lop();

		lop.setId_Lop(txtMaLopHoc.getText());
		lop.setClassName(txtTenLopHoc.getText());
		lop.setId_NienKhoa(txtMaNienKhoa.getText());

		lopDao.addUser(lop);
	}

	private void updateLop() {
		Lop lop = new Lop();

		lop.setId_Lop(txtMaLopHoc.getText());
		lop.setClassName(txtTenLopHoc.getText());
		lop.setId_NienKhoa(txtMaNienKhoa.getText());

		lopDao.updateUser(lop);
	}

	private void deleteLop() {
		String maLop = (String) jTableLopHoc.getValueAt(jTableLopHoc.getSelectedRow(), 0);
		lopDao.deleteUser(maLop);
	}

	private void clearInfoLop() {
		txtMaLopHoc.setText("");
		txtTenLopHoc.setText("");
		txtMaNienKhoa.setText("");
	}
/////////////////////////////////////////////6 - MÔN HỌC
	private void loadingTableMonHoc() {
		tableMonHoc.setRowCount(0);

		List<MonHoc> listMonHoc = monHocDao.getAllUser();

		for (MonHoc mon : listMonHoc) {
			tableMonHoc.addRow(new String[] { "" + mon.getId_MonHoc(), mon.getTen_Mon(), mon.getId_GiaoVien() });
		}
	}

	private void addMonHoc() {
		MonHoc mon = new MonHoc();

		mon.setId_MonHoc(txtMaMonHoc.getText());
		mon.setTen_Mon(txtTenMonHoc.getText());
		mon.setId_GiaoVien(txtMaGiaoVien.getText());
		
		monHocDao.addUser(mon);
	}

	private void updateMonHoc() {
		MonHoc mon = new MonHoc();

		mon.setId_MonHoc(txtMaMonHoc.getText());
		mon.setTen_Mon(txtTenMonHoc.getText());
		mon.setId_GiaoVien(txtMaGiaoVien.getText());
		
		monHocDao.updateUser(mon);
	}

	private void deleteMonHoc() {
		String maMon = (String) jTableMonHoc.getValueAt(jTableMonHoc.getSelectedRow(), 0);
		monHocDao.deleteUser(maMon);
	}

	private void clearInfoMonHoc() {
		txtMaMonHoc.setText("");
		txtTenMonHoc.setText("");
		txtMaGiaoVien.setText("");
	}
/////////////////////////////////////////////7 - BẢNG �?IỂM
	private void loadingTableDiem() {
		tableDiem.setRowCount(0);

		List<DiemHocSinh> listDiem = diemHocsinhDao.getAllUser();

		for (DiemHocSinh diem : listDiem) {
			tableDiem.addRow(new String[] { "" + diem.getId_MonHoc(), diem.getId_HocSinh(), diem.getDiem_Mieng() ,diem.getDiem15p(),diem.getDiem1Tiet(),diem.getDiemHocKi() });
		}
	}

	private void addDiem() {
		DiemHocSinh diem = new DiemHocSinh();

		diem.setId_MonHoc(txtId_MonHoc.getText());
		diem.setId_HocSinh(txtId_HocSinh.getText());
		diem.setDiem_Mieng(txtDiem_Mieng.getText());
		diem.setDiem15p(txtDiem15p.getText());
		diem.setDiem1Tiet(txtDiem1Tiet.getText());
		diem.setDiemHocKi(txtDiemHocKi.getText());
		
		diemHocsinhDao.addUser(diem);
	}

	private void updateDiem() {
		DiemHocSinh diem = new DiemHocSinh();

		diem.setId_MonHoc(txtId_MonHoc.getText());
		diem.setId_HocSinh(txtId_HocSinh.getText());
		diem.setDiem_Mieng(txtDiem_Mieng.getText());
		diem.setDiem15p(txtDiem15p.getText());
		diem.setDiem1Tiet(txtDiem1Tiet.getText());
		diem.setDiemHocKi(txtDiemHocKi.getText());
		
		diemHocsinhDao.updateUser(diem);
	}

	private void deleteDiem() {
		String diem = (String) jTableDiem.getValueAt(jTableDiem.getSelectedRow(), 0);
		diemHocsinhDao.deleteUser(diem);
	}

	private void clearInfoDiem() {
		txtId_MonHoc.setText("");
		txtId_HocSinh.setText("");
		txtDiem_Mieng.setText("");
		txtDiem15p.setText("");
		txtDiem1Tiet.setText("");
		txtDiemHocKi.setText("");
	}
	
/////////////////////////////////////////////8 - NI�?N KHO�?
	private void loadingTableNienKhoa() {
		tableNienKhoa.setRowCount(0);

		List<NienKhoa> listNienKhoa = nienKhoaDao.getAllUser();

		for (NienKhoa nienkhoa : listNienKhoa) {
			tableNienKhoa.addRow(new String[] { "" + nienkhoa.getId_NienKhoa(), nienkhoa.getSchoolYear() });
		}
	}

	private void addNienKhoa() {
		NienKhoa nienkhoa = new NienKhoa();

		nienkhoa.setId_NienKhoa(txtId_NienKhoa.getText());
		nienkhoa.setSchoolYear(txtNienKhoa.getText());
		
		nienKhoaDao.addUser(nienkhoa);
	}

	private void updateNienKhoa() {
		NienKhoa nienkhoa = new NienKhoa();

		nienkhoa.setId_NienKhoa(txtId_NienKhoa.getText());
		nienkhoa.setSchoolYear(txtNienKhoa.getText());
		
		nienKhoaDao.updateUser(nienkhoa);
	}

	private void deleteNienKhoa() {
		String nienKhoa = (String) jTableNienKhoa.getValueAt(jTableNienKhoa.getSelectedRow(), 0);
		nienKhoaDao.deleteUser(nienKhoa);
	}

	private void clearInfonNienKhoa() {
		txtId_NienKhoa.setText("");
		txtNienKhoa.setText("");
	}
	
/////////////////////////////////////////////9 - TỔNG KẾT
	private void loadingTableTK() {
		tableTongKet.setRowCount(0);

		List<TongKet> listTongKet = tongKetDao.getAllUser();

		for (TongKet tk : listTongKet) {
			tableTongKet.addRow(new String[] { "" + tk.getId_HocSinh(), tk.getFirstName(), tk.getLastName(), tk.getId_Lop(),
					tk.getStudyCapacity_Semester1(), tk.getConduct_Semester1(), tk.getStudyCapacity_Semester2(),
					tk.getConduct_Semester2(), tk.getStudyCapacity_WholeYear(), tk.getConduct_WholeYear(),
					tk.getId_NienKhoa() });
		}
	}

	private void addTK() {
		TongKet tk = new TongKet();

		tk.setId_HocSinh(txtMaHSTk.getText());
		tk.setFirstName(txtHoHSTk.getText());
		tk.setLastName(txtTenHSTk.getText());
		tk.setId_Lop(txtLop.getText());
		tk.setStudyCapacity_Semester1(txtHocLuc1.getText());
		tk.setConduct_Semester1(txtHanhKiem1.getText());
		tk.setStudyCapacity_Semester2(txtHocLuc2.getText());
		tk.setConduct_Semester2(txtHanhKiem2.getText());
		tk.setStudyCapacity_WholeYear(txtHocLucCN.getText());
		tk.setConduct_WholeYear(txtHanhKiemCN.getText());
		tk.setId_NienKhoa(txtIdNienKhoa.getText());

		tongKetDao.addUser(tk);
	}

	private void updateTK() {
		TongKet tk = new TongKet();

		tk.setId_HocSinh(txtMaHSTk.getText());
		tk.setFirstName(txtHoHSTk.getText());
		tk.setLastName(txtTenHSTk.getText());
		tk.setId_Lop(txtLop.getText());
		tk.setStudyCapacity_Semester1(txtHocLuc1.getText());
		tk.setConduct_Semester1(txtHanhKiem1.getText());
		tk.setStudyCapacity_Semester2(txtHocLuc2.getText());
		tk.setConduct_Semester2(txtHanhKiem2.getText());
		tk.setStudyCapacity_WholeYear(txtHocLucCN.getText());
		tk.setConduct_WholeYear(txtHanhKiemCN.getText());
		tk.setId_NienKhoa(txtIdNienKhoa.getText());

		tongKetDao.updateUser(tk);
	}

	private void deleteTK() {
		String maTK = (String) jTableTK.getValueAt(jTableTK.getSelectedRow(), 0);
		tongKetDao.deleteUser(maTK);
	}

	private void clearInfoTK() {

		txtMaHSTk.setText("");
		txtHoHSTk.setText("");
		txtTenHSTk.setText("");
		txtLop.setText("");
		txtHocLuc1.setText("");
		txtHanhKiem1.setText("");
		txtHocLuc2.setText("");
		txtHanhKiem2.setText("");
		txtHocLucCN.setText("");
		txtHanhKiemCN.setText("");
		txtIdNienKhoa.setText("");
	}

/////////////////////////////////////////////10 - QUẢN L�? TÀI KHOẢN NGUƯỜI DÙNG
	private void loadingTableTaiKhoan() {
		tableTaiKhoan.setRowCount(0);

		List<TaiKhoan> listTaiKhoan = taiKhoanDao.getAllUser();

		for (TaiKhoan taikhoan : listTaiKhoan) {
			tableTaiKhoan.addRow(new String[] { "" + taikhoan.getUserName(), taikhoan.getPassword(),
					taikhoan.getId_Rule() });
		}
	}

	private void addTaiKhoan() {
		TaiKhoan taikhoan = new TaiKhoan();

		taikhoan.setUserName(txtUsername.getText());
		taikhoan.setPassword(txtPassword.getText());
		taikhoan.setId_Rule(txtId_Rule.getText());

		taiKhoanDao.addUser(taikhoan);
	}

	private void updateTaiKhoan() {
		TaiKhoan taikhoan = new TaiKhoan();

		taikhoan.setUserName(txtUsername.getText());
		taikhoan.setPassword(txtPassword.getText());
		taikhoan.setId_Rule(txtId_Rule.getText());
		
		taiKhoanDao.updateUser(taikhoan);
	}

	private void deleteTaiKhoan() {
		String id_rule = (String) jTableTaiKhoan.getValueAt(jTableTaiKhoan.getSelectedRow(), 0);
		taiKhoanDao.deleteUser(id_rule);
	}

	private void clearInfoTaiKhoan() {
		txtUsername.setText("");
		txtPassword.setText("");
		txtId_Rule.setText("");
	}
	
	
////////////////////////////////////////////////////////////////////XÉT SỰ KIỆN MOUSE CLICK CHO TỪNG BẢNG/////////////
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		int row = jTable.getSelectedRow();
		int row2 = HoSoHS.getSelectedRow();
		int row3 = jTableGiaoVien.getSelectedRow();
		int row4 = jTableHSGV.getSelectedRow();
		int row5 = jTableLopHoc.getSelectedRow();
		int row6 = jTableMonHoc.getSelectedRow();
		int row7 = jTableDiem.getSelectedRow();
		int row8 = jTableNienKhoa.getSelectedRow();
		int row9 = jTableTK.getSelectedRow();
		int row10 = jTableTaiKhoan.getSelectedRow();
		
		if (obj == jTable) {  ///////BẢNG QUẢN L�? HỌC SINH
			txtMaHS.setText((String) jTable.getValueAt(row, 0));
			txtHoHS.setText((String) jTable.getValueAt(row, 1));
			txtTenHS.setText((String) jTable.getValueAt(row, 2));
			txtTuoiHs.setText((String) jTable.getValueAt(row, 3));
			txtDiaChiHs.setText((String) jTable.getValueAt(row, 4));
			txtGioiTinhHs.setText((String) jTable.getValueAt(row, 5));
			txtNgaySinhHs.setText((String) jTable.getValueAt(row, 6));
			txtSDTHs.setText((String) jTable.getValueAt(row, 7));
			txtEmailHs.setText((String) jTable.getValueAt(row, 8));
			txtBuoiVangHs.setText((String) jTable.getValueAt(row, 9));
			txtId_LopHs.setText((String) jTable.getValueAt(row, 10));
			
		} else if (obj == HoSoHS) { ///////BẢNG HỒ SƠ HỌC SINH
			txHoSoMaHS.setText((String) HoSoHS.getValueAt(row2, 0));
			txHoSoHoHS.setText((String) HoSoHS.getValueAt(row2, 1));
			txHoSoTenHS.setText((String) HoSoHS.getValueAt(row2, 2));
			txHoSoHSTuoi.setText((String) HoSoHS.getValueAt(row2, 3));
			txHoSoHSDiaChi.setText((String) HoSoHS.getValueAt(row2, 4));
			txHoSoHSGioiTinh.setText((String) HoSoHS.getValueAt(row2, 5));
			txHoSoHSNgaySinh.setText((String) HoSoHS.getValueAt(row2, 6));
			txHoSoHSTieuHoc.setText((String) HoSoHS.getValueAt(row2, 7));
			txHoSoHSTHCS.setText((String) HoSoHS.getValueAt(row2, 8));
			txHoSoHSTHPT.setText((String) HoSoHS.getValueAt(row2, 9));
			txHoSoHSHocLuc.setText((String) HoSoHS.getValueAt(row2, 10));
			txHoSoHSHanhKiem.setText((String) HoSoHS.getValueAt(row2, 11));

		} else if (obj == jTableGiaoVien) { ///////BẢNG QUẢN L�? GI�?O VI�?N
			txtMaGV.setText((String) jTableGiaoVien.getValueAt(row3, 0));
			txtHoGV.setText((String) jTableGiaoVien.getValueAt(row3, 1));
			txtTenGV.setText((String) jTableGiaoVien.getValueAt(row3, 2));
			txtTuoiGv.setText((String) jTableGiaoVien.getValueAt(row3, 3));
			txtDiaChiGv.setText((String) jTableGiaoVien.getValueAt(row3, 4));
			txtGioiTinhGv.setText((String) jTableGiaoVien.getValueAt(row3, 5));
			txtNgaySinhGv.setText((String) jTableGiaoVien.getValueAt(row3, 6));
			txtSDTGv.setText((String) jTableGiaoVien.getValueAt(row3, 7));
			txtEmailGv.setText((String) jTableGiaoVien.getValueAt(row3, 8));
			txtChucVu.setText((String) jTableGiaoVien.getValueAt(row3, 9));

		} else if (obj == jTableHSGV) { ///////BẢNG HỒ SƠ GI�?O VI�?N
			txtMaHoSoGV.setText((String) jTableHSGV.getValueAt(row4, 0));
			txtHoHoSoGV.setText((String) jTableHSGV.getValueAt(row4, 1));
			txtTenHoSoGV.setText((String) jTableHSGV.getValueAt(row4, 2));
			txtTuoiHsGv.setText((String) jTableHSGV.getValueAt(row4, 3));
			txtDiaChiHsGv.setText((String) jTableHSGV.getValueAt(row4, 4));
			txtGioiTinhHsGv.setText((String) jTableHSGV.getValueAt(row4, 5));
			txtNgaySinhHsGv.setText((String) jTableHSGV.getValueAt(row4, 6));
			txtSDTHsGv.setText((String) jTableHSGV.getValueAt(row4, 7));
			txtEmailHsGv.setText((String) jTableHSGV.getValueAt(row4, 8));
			txtDaiHoc.setText((String) jTableHSGV.getValueAt(row4, 9));
			txtKinhNghiem.setText((String) jTableHSGV.getValueAt(row4, 10));
			
		} else if (obj == jTableLopHoc) { ///////BẢNG L�?P HỌC
			txtMaLopHoc.setText((String) jTableLopHoc.getValueAt(row5, 0));
			txtTenLopHoc.setText((String) jTableLopHoc.getValueAt(row5, 1));
			txtMaNienKhoa.setText((String) jTableLopHoc.getValueAt(row5, 2));

		} else if (obj == jTableMonHoc) { ///////BẢNG MÔN HỌC
			txtMaMonHoc.setText((String) jTableMonHoc.getValueAt(row6, 0));
			txtTenMonHoc.setText((String) jTableMonHoc.getValueAt(row6, 1));
			txtMaGiaoVien.setText((String) jTableMonHoc.getValueAt(row6, 2));
			
		} else if (obj == jTableDiem) { ///////BẢNG �?IỂM
			txtId_MonHoc.setText((String) jTableDiem.getValueAt(row7, 0));
			txtId_HocSinh.setText((String) jTableDiem.getValueAt(row7, 1));
			txtDiem_Mieng.setText((String) jTableDiem.getValueAt(row7, 2));
			txtDiem15p.setText((String) jTableDiem.getValueAt(row7, 3));
			txtDiem1Tiet.setText((String) jTableDiem.getValueAt(row7, 4));
			txtDiemHocKi.setText((String) jTableDiem.getValueAt(row7, 5));
			
		} else if (obj == jTableNienKhoa) { ///////BẢNG MÔN HỌC
			txtId_NienKhoa.setText((String) jTableNienKhoa.getValueAt(row8, 0));
			txtNienKhoa.setText((String) jTableNienKhoa.getValueAt(row8, 1));
			
		} else if (obj == jTableTK) { ///////BẢNG TỔNG K�?T
			txtMaHSTk.setText((String) jTableTK.getValueAt(row9, 0));
			txtHoHSTk.setText((String) jTableTK.getValueAt(row9, 1));
			txtTenHSTk.setText((String) jTableTK.getValueAt(row9, 2));
			txtLop.setText((String) jTableTK.getValueAt(row9, 3));
			txtHocLuc1.setText((String) jTableTK.getValueAt(row9, 4));
			txtHanhKiem1.setText((String) jTableTK.getValueAt(row9, 5));
			txtHocLuc2.setText((String) jTableTK.getValueAt(row9, 6));
			txtHanhKiem2.setText((String) jTableTK.getValueAt(row9, 7));
			txtHocLucCN.setText((String) jTableTK.getValueAt(row9, 8));
			txtHanhKiemCN.setText((String) jTableTK.getValueAt(row9, 9));
			txtIdNienKhoa.setText((String) jTableTK.getValueAt(row9, 10));

		} else { ///////BẢNG QUẢN L�? TÀI KHOẢN NGƯỜI DÙNG
			txtUsername.setText((String) jTableTaiKhoan.getValueAt(row10, 0));
			txtPassword.setText((String) jTableTaiKhoan.getValueAt(row10, 1));
			txtId_Rule.setText((String) jTableTaiKhoan.getValueAt(row10, 2));
		}
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

////////////////////////////////////////////////////////////////////XÉT SỰ KIỆN CHO TỪNG BUTTON CỦA TỪNG BẢNG/////////////
	
////////////////BUTTON BẢNG 1 - QUẢN L�? HỌC SINH
	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAddHs) {
			if (txtMaHS.getText().equals("") 
					|| (txtHoHS.getText()).equals("") 
					|| (txtTenHS.getText()).equals("")
					|| String.valueOf(txtTuoiHs.getText()).equals("") 
					|| (txtDiaChiHs.getText()).equals("")
					|| (txtGioiTinhHs.getText()).equals("") 
					|| (txtNgaySinhHs.getText()).equals("")
					|| (txtEmailHs.getText()).equals("") 
					|| String.valueOf(txtSDTHs.getText()).equals("")
					|| String.valueOf(txtBuoiVangHs.getText()).equals("")
					|| (txtId_LopHs.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addHS();
				loadingTableHS();
			}

		} else if (action == btnUpdateHs) {
			updateHS();
			loadingTableHS();

		} else if (action == btnDeleteHs) {
			deleteHS();
			loadingTableHS();
			
		}else {
			clearInfoHS();
		}
		
////////////////BUTTON BẢNG	2 - HỒ SƠ HỌC SINH
		Object action2 = e.getSource();
		if (action2 == btnAddHsHs) {
			if (txHoSoMaHS.getText().equals("") 
					|| (txHoSoHoHS.getText()).equals("")
					|| (txHoSoTenHS.getText()).equals("") 
					|| String.valueOf(txHoSoHSTuoi.getText()).equals("")
					|| (txHoSoHSDiaChi.getText()).equals("") 
					|| (txHoSoHSGioiTinh.getText()).equals("")
					|| (txHoSoHSNgaySinh.getText()).equals("") 
					|| (txHoSoHSTieuHoc.getText()).equals("")
					|| (txHoSoHSTHCS.getText()).equals("") 
					|| (txHoSoHSTHPT.getText()).equals("")
					|| (txHoSoHSHocLuc.getText()).equals("") 
					|| (txHoSoHSHanhKiem.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addHoSoHS();
				loadingTableHoSoHS();
			}

		} else if (action2 == btnUpdateHsHs) {
			updateHoSoHS();
			loadingTableHoSoHS();

		} else if (action2 == btnDeleteHsHs) {
			deleteHoSoHS();
			loadingTableHoSoHS();

		}else {
			clearInfoHoSoHS();
		}
		
////////////////BUTTON BẢNG 3 - QUẢN L�? GI�?O VI�?N
		Object action3 = e.getSource();
		if (action3 == btnAddGv) {
			if (txtMaGV.getText().equals("") 
					|| (txtHoGV.getText()).equals("") 
					|| (txtTenGV.getText()).equals("")
					|| String.valueOf(txtTuoiGv.getText()).equals("") 
					|| (txtDiaChiGv.getText()).equals("")
					|| (txtGioiTinhGv.getText()).equals("") 
					|| (txtNgaySinhGv.getText()).equals("")
					|| (txtEmailGv.getText()).equals("") 
					|| (txtSDTGv.getText()).equals("")
					|| (txtChucVu.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addGV();
				loadingTableGV();
			}

		} else if (action3 == btnUpdateGv) {
			updateGV();
			loadingTableGV();

		} else if (action3 == btnDeleteGv) {
			deleteGV();
			loadingTableGV();
			
		}else {
			clearInfoGV();
		}
		
////////////////BUTTON BẢNG 4 - HỒ SƠ GI�?O VI�?N
		Object action4 = e.getSource();
		if (action4 == btnAddHsGv) {
			if (txtMaHoSoGV.getText().equals("") 
					|| (txtHoHoSoGV.getText()).equals("")
					|| (txtTenHoSoGV.getText()).equals("") 
					|| String.valueOf(txtTuoiHsGv.getText()).equals("")
					|| (txtDiaChiHsGv.getText()).equals("") 
					|| (txtGioiTinhHsGv.getText()).equals("")
					|| (txtNgaySinhHsGv.getText()).equals("") 
					|| (txtEmailHsGv.getText()).equals("")
					|| (txtDaiHoc.getText()).equals("") 
					|| (txtKinhNghiem.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addHoSoGV();
				loadingTableHoSoGV();
			}

		} else if (action4 == btnUpdateHsGv) {
			updateHoSoGV();
			loadingTableHoSoGV();

		} else if (action4 == btnDeleteHsGv) {
			deleteHoSoGV();
			loadingTableHoSoGV();

		}else {
			clearInfoHoSoGV();
		}
		
////////////////BUTTON BẢNG 5 - L�?P HỌC
		Object action5 = e.getSource();
		if (action5 == btnAddLopHoc) {
			if (txtMaLopHoc.getText().equals("") 
					|| (txtTenLopHoc.getText()).equals("")
					|| (txtMaNienKhoa.getText()).equals("")){
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addLop();
				loadingTableLopHoc();
			}

		} else if (action5 == btnUpdateLopHoc) {
			updateLop();
			loadingTableLopHoc();

		} else if (action5 == btnDeleteLopHoc) {
			deleteLop();
			loadingTableLopHoc();

		}else {
			clearInfoLop();
		}
////////////////BUTTON BẢNG 6 - MÔN HỌC
		Object action6 = e.getSource();
		if (action6 == btnAddMonHoc) {
			if (txtMaMonHoc.getText().equals("") 
					|| (txtTenMonHoc.getText()).equals("")
					|| (txtMaGiaoVien.getText()).equals("")){
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addMonHoc();
				loadingTableMonHoc();
			}

		} else if (action6 == btnUpdateMonHoc) {
			updateMonHoc();
			loadingTableMonHoc();

		} else if (action6 == btnDeleteMonHoc) {
			deleteMonHoc();
			loadingTableMonHoc();

		}else {
			clearInfoMonHoc();
		}
		
////////////////BUTTON BẢNG 7 - BẢNG �?IỂM
		Object action7 = e.getSource();
		if (action7 == btnAddDiem) {
			if (txtId_MonHoc.getText().equals("") 
					|| (txtId_HocSinh.getText()).equals("")
					|| (txtDiem_Mieng.getText()).equals("")
					|| (txtDiem15p.getText()).equals("")
					|| (txtDiem1Tiet.getText()).equals("")
					|| (txtDiemHocKi.getText()).equals("")){
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addDiem();
				loadingTableDiem();
			}

		} else if (action7 == btnUpdateDiem) {
			updateDiem();
			loadingTableDiem();

		} else if (action7 == btnDeleteDiem) {
			deleteDiem();
			loadingTableDiem();

		}else {
			clearInfoDiem();
		}
////////////////BUTTON BẢNG 8 - NI�?N KHO�?
		Object action8 = e.getSource();
		if (action8 == btnAddNienKhoa) {
			if (txtIdNienKhoa.getText().equals("") 
					|| (txtNienKhoa.getText()).equals("")){
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addNienKhoa();
				loadingTableNienKhoa();
			}

		} else if (action8 == btnUpdateNienKhoa) {
			updateNienKhoa();
			loadingTableNienKhoa();

		} else if (action8 == btnDeleteNienKhoa) {
			deleteNienKhoa();
			loadingTableNienKhoa();

		}else {
			clearInfonNienKhoa();
		}
////////////////BUTTON BẢNG 9 - TỔNG KẾT
		Object action9 = e.getSource();
		if (action9 == btnAddTk) {
			if (txtMaHSTk.getText().equals("") 
					|| (txtHoHSTk.getText()).equals("") 
					|| (txtTenHSTk.getText()).equals("")
					|| (txtLop.getText()).equals("") 
					|| (txtHocLuc1.getText()).equals("")
					|| (txtHanhKiem1.getText()).equals("") 
					|| (txtHocLuc2.getText()).equals("")
					|| (txtHanhKiem2.getText()).equals("") 
					|| (txtHocLucCN.getText()).equals("")
					|| (txtHanhKiemCN.getText()).equals("") 
					|| (txtIdNienKhoa.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addTK();
				loadingTableTK();
			}

		} else if (action5 == btnUpdateTk) {
			updateTK();
			loadingTableTK();

		} else if (action5 == btnDeleteTk) {
			deleteTK();
			loadingTableTK();

		}else {
			clearInfoTK();
		}
		
////////////////BUTTON BẢNG 10 - QUẢN L�? TÀI KHOẢN NGƯỜI DÙNG
		Object action10 = e.getSource();
		if (action == btnAddTaiKhoan) {
			if (txtUsername.getText().equals("") 
					|| (txtPassword.getText()).equals("")
					|| (txtId_Rule.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Làm ơn điền đầy đủ thông tin trước khi thêm");
																									
			} else {
				addTaiKhoan();
				loadingTableTaiKhoan();
			}

		} else if (action10 == btnUpdateTaiKhoan) {
			updateTaiKhoan();
			loadingTableTaiKhoan();

		} else if (action10 == btnDeleteTaiKhoan) {
			deleteTaiKhoan();
			loadingTableTaiKhoan();

		}else {
			clearInfoTaiKhoan();
		}
	}
	
//	///////////_Hàm Thoát Chương Trình
//	public void exit() {
//		View ex = new View();
//		ex.setVisible(false);
}