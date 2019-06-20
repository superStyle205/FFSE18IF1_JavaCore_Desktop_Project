package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import database.ConnectUtil;
import database.SchoolDao;
import model.ClassStudent;
import model.Diem;
import model.Mon;
import model.Student;
import model.Teacher;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class AppView extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SchoolDao schoolDao;
	Student student;
	ClassStudent classStudent;
	public JTabbedPane tabbedPane;
	private JLabel lblTChu;
	private JTextField txtMaHS;
	private JTextField txtHTenHS;
	private JTextField txtQuQuan;
	private JTextField txtSDTHS;
	private JTextField txtGhChuHS;
	private JTextField txtTenCha;
	private JTextField txtTenMe;
	private JTextField txtDiaChi;
	private JTextField txtNgSinh;
	private JTextField txtSDTPhHuynh;
	private JTextField txtTenLop;
	private DefaultTableModel tableHS;
	private JTable jtableHS;
	private JScrollPane scrollPaneHS;
	private JTextField txtMaGV;
	private JTextField txtNgSinhGV;
	private JTextField txtHTenGV;
	private JTextField txtQuQuanGV;
	private JTextField txtSDTGV;
	private JTextField txtGhChuGV;
	private JTextField txtTrinhDo;
	private JTextField txtEmail;
	public JButton btnThemHS;
	public JButton btnXoaHS;
	public JButton btnSuaHS;
	public JButton btnLamMoiHS;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private ButtonGroup group;
	private ButtonGroup groupGV;
	private DefaultTableModel tableGV;
	private JTable jtableGV;
	private JScrollPane scrollPaneGV;
	private JRadioButton radioNam;
	private JRadioButton radioNu;
	public JButton btnThemGV;
	public JButton btnSuaGV;
	public JButton btnXoaGV;
	public JButton btnLamMoiGV;
	private JLabel lblFixHS2;
	private JLabel lblFixHS3;
	private JLabel lblFixHS4;
	private JLabel lblFixHS5;
	private JLabel lblFixHS6;
	private JLabel lblFixHS8;
	private DefaultComboBoxModel<String> boxmodelHS;
	private JComboBox<String> comboBoxHS;
	private JLabel lblFixGV2;
	private JLabel lblFixGV1;
	private JLabel lblFixGV3;
	private JLabel lblFixGV4;
	private JLabel lblFixGV5;
	private JLabel lblFixGV6;
	private JLabel lblMaLopHoc;
	private JLabel lblMaMon_Mon;
	private JTextField txtTenLopHoc;
	private JTextField txtTenMon_Mon;
	private JTextField txtMaGiaoVien;
	private JTextField txtMaGiaoVien_Mon;
	private JTextField txtTenGiaoVien;
	private JTextField txtTenGiaoVien_Mon;
	private JLabel lblQLyDiem;
	private JPanel panelTTinBangDiem;
	private JLabel lblMaHocSinh_Diem;
	private JTextField txtMaHocSinh_Diem;
	private JLabel lblTenHocSinh_Diem;
	private JTextField txtTenHocSinh_Diem;
	private JLabel lblMaLop_Diem;
	private JTextField txtMaLop_Diem;
	private JLabel lblTenLop_Diem;
	private JTextField txtTenLop_Diem;
	private JLabel lblMaMon_Diem;
	private JTextField txtMaMon_Diem;
	private JLabel lblTenMon_Diem;
	private JTextField txtTenMon_Diem;
	private JTextField txtMaLopHoc;
	private JTextField txtMaMon_Mon;
	private DefaultTableModel tableLop;
	private JTable jtableLop;
	private JScrollPane scrollLop;
	private JLabel lblFixLop1;
	private JLabel lblFixLop2;
	public JButton btnThemLop;
	private JButton btnThemMon;
	public JButton btnSuaLop;
	private JButton btnSuaMon;
	public JButton btnXoaLop;
	private JButton btnXoaMon;
	public JButton btnLamMoiLop;
	private JButton btnLamMoiMon;
	private JLabel lblGhiChuLop;
	private JTextField txtGhiChuLop;
	private ArrayList<ClassStudent> litsClass;
	public JPanel thong_tin_GV;
	public JPanel thong_tin_HS;
	public JPanel lop;
	public JPanel mon_hoc;
	public JPanel diem_HS;
	public JPanel panelTTinHs;
	private JTextField txtDiem15p1;
	private JTextField txtDiem15p2;
	private JTextField txtDiem1T;
	private JLabel lblDiem1T;
	private JLabel lblDiemKi1;
	private JTextField txtDiemKi1;
	private JLabel lblDiemKi2;
	private JTextField txtDiemKi2;
	private JLabel lblTongDiem;
	private JTextField txtTongDiem;
	private JPanel panelChNangDiem;
	private DefaultTableModel tableDiem;
	private JTable jtableDiem;
	private JScrollPane scrollDiem;
	private ArrayList<Diem> litsDiem;
	public JButton btnThemDiem;
	public JButton btnSuaDiem;
	public JButton btnXoaDiem;
	public JButton btnLamMoiDiem;
	private JLabel lblFixDiem1;
	private JLabel lblFixDiem2;
	private JLabel lblFixLop3;
	private JLabel lblQunLThng_1;
	private JPanel panelTTinMon;
	private JLabel lblTenMon_Mon;
	private JLabel lblMaGiaoVien_Mon;
	private JLabel lblTenGiaoVien_Mon;
	private JPanel panelCNangMon;
	private DefaultTableModel tableMon;
	private JTable jtableMon;
	private JScrollPane scrollMon;
	private JTextField txtGhiChuMon;
	private ArrayList<Mon> litsMon;
	private JLabel lblFixMon1;
	private JLabel lblFixMon2;
	private JLabel lblFixMon3;
	private JTextField txtSearchHS;
	private JButton btnSearchHS;
	private JTextField txtSearchGV;
	private JButton btnSearchGV;
	private JLabel lblSearchGV;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// AppView frame = new AppView();
	// frame.setVisible(true);
	// }

	/**
	 * Create the frame.
	 */
	public AppView() {
		super("SchoolManagement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1350, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		// tab Trang Chủ
		JPanel trang_chu = new JPanel();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1350, 700);
		tabbedPane.setForeground(new Color(0, 0, 128)); // màu chữ Trang chủ
		getContentPane().add(tabbedPane);
		ImageIcon anh_TChu = new ImageIcon(
				"vinh-quang-sofware-chuyen-cung-cap-nhung-phan-mem-quan-ly-truong-hoc-mien-phi_1.jpg");

		tabbedPane.addTab("Trang Chủ", new ImageIcon("house.png"), trang_chu, null);
		lblTChu = new JLabel();
		trang_chu.setLayout(null);
		lblTChu.setIcon(anh_TChu);
		trang_chu.add(lblTChu);
		lblTChu.setBounds(450, 100, 700, 500);

		JLabel lblTieuDeTChu = new JLabel("Phần Mền Quản Lý Trường Học ");
		lblTieuDeTChu.setForeground(new Color(0, 0, 255));
		lblTieuDeTChu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTieuDeTChu.setBounds(481, 45, 394, 91);
		trang_chu.add(lblTieuDeTChu);

		// tab Thông Tin Học Sinh
		thong_tin_HS = new JPanel();
		tabbedPane.addTab("Quản lý thông Tin học sinh", new ImageIcon("placeholder.png"), thong_tin_HS, null);
		Border borderTTinHS = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleTTinHS = BorderFactory.createTitledBorder(borderTTinHS, "Thông Tin Học Sinh");
		thong_tin_HS.setLayout(null);

		JLabel lblTieuDeHS = new JLabel("Quản Lý Thông Tin Học Sinh");
		lblTieuDeHS.setBounds(492, 11, 353, 72);
		lblTieuDeHS.setForeground(new Color(0, 0, 255));
		lblTieuDeHS.setFont(new Font("Tahoma", Font.BOLD, 24));
		thong_tin_HS.add(lblTieuDeHS);

		// panel thông tin của học sinh
		panelTTinHs = new JPanel();
		panelTTinHs.setForeground(Color.RED);
		panelTTinHs.setBounds(10, 83, 1313, 291);
		thong_tin_HS.add(panelTTinHs);
		panelTTinHs.setBorder(titleTTinHS);
		panelTTinHs.setLayout(null);

		txtMaHS = new JTextField();
		txtMaHS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				removeCheck();
			}
		});
		txtMaHS.setBounds(103, 27, 136, 23);
		panelTTinHs.add(txtMaHS);
		txtMaHS.setColumns(10);
		txtMaHS.setEnabled(false);

		txtHTenHS = new JTextField();
		txtHTenHS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheck();
			}
		});
		txtHTenHS.setBounds(103, 84, 136, 23);
		panelTTinHs.add(txtHTenHS);
		txtHTenHS.setColumns(10);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(103, 187, 59, 23);
		panelTTinHs.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(180, 187, 59, 23);
		panelTTinHs.add(rdbtnNu);

		group = new ButtonGroup();
		group.add(rdbtnNam);
		group.add(rdbtnNu);

		JLabel lblMaHS = new JLabel("Mã HS");
		lblMaHS.setBounds(28, 24, 59, 29);
		lblMaHS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaHS.setForeground(new Color(0, 0, 255));
		panelTTinHs.add(lblMaHS);

		JLabel lblNgSinh = new JLabel("Ngày Sinh");
		lblNgSinh.setBounds(28, 142, 70, 14);
		lblNgSinh.setForeground(new Color(0, 0, 255));
		lblNgSinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelTTinHs.add(lblNgSinh);

		JLabel lblHTenHS = new JLabel("Họ Và Tên");
		lblHTenHS.setBounds(23, 88, 70, 14);
		lblHTenHS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHTenHS.setForeground(new Color(0, 0, 255));
		panelTTinHs.add(lblHTenHS);

		JLabel lblGTinh = new JLabel("Giới Tính");
		lblGTinh.setBounds(28, 191, 59, 14);
		lblGTinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGTinh.setForeground(new Color(0, 0, 255));
		panelTTinHs.add(lblGTinh);

		JLabel lblQuQuan = new JLabel("Quê Quán");
		lblQuQuan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuQuan.setForeground(new Color(0, 0, 255));
		lblQuQuan.setBounds(287, 27, 70, 23);
		panelTTinHs.add(lblQuQuan);

		JLabel lblDThoai = new JLabel("SDT HS");
		lblDThoai.setForeground(new Color(0, 0, 255));
		lblDThoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDThoai.setBounds(287, 83, 70, 24);
		panelTTinHs.add(lblDThoai);

		JLabel lblMaLop = new JLabel("Mã Lớp");
		lblMaLop.setForeground(new Color(0, 0, 255));
		lblMaLop.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaLop.setBounds(287, 142, 59, 23);
		panelTTinHs.add(lblMaLop);

		JLabel lblGhChu = new JLabel("Ghi Chú");
		lblGhChu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGhChu.setForeground(new Color(0, 0, 255));
		lblGhChu.setBounds(548, 187, 70, 23);
		panelTTinHs.add(lblGhChu);

		txtQuQuan = new JTextField();
		txtQuQuan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheck();
			}
		});
		txtQuQuan.setBounds(367, 27, 136, 23);
		panelTTinHs.add(txtQuQuan);
		txtQuQuan.setColumns(10);

		txtSDTHS = new JTextField();
		txtSDTHS.setBounds(367, 84, 136, 23);
		panelTTinHs.add(txtSDTHS);
		txtSDTHS.setColumns(10);

		txtGhChuHS = new JTextField();
		txtGhChuHS.setBounds(643, 187, 417, 23);
		panelTTinHs.add(txtGhChuHS);
		txtGhChuHS.setColumns(10);

		JLabel lblTenCha = new JLabel("Họ Tên Cha");
		lblTenCha.setForeground(new Color(0, 0, 255));
		lblTenCha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenCha.setBounds(542, 32, 76, 23);
		panelTTinHs.add(lblTenCha);

		JLabel lblTenMe = new JLabel("Họ Tên Mẹ");
		lblTenMe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenMe.setForeground(new Color(0, 0, 255));
		lblTenMe.setBounds(542, 92, 76, 17);
		panelTTinHs.add(lblTenMe);

		JLabel lblaDiaChi = new JLabel("Địa Chỉ Liên Lạc");
		lblaDiaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblaDiaChi.setForeground(new Color(0, 0, 255));
		lblaDiaChi.setBounds(542, 138, 87, 30);
		panelTTinHs.add(lblaDiaChi);

		txtTenCha = new JTextField();
		txtTenCha.setBounds(643, 27, 136, 23);
		panelTTinHs.add(txtTenCha);
		txtTenCha.setColumns(10);

		txtTenMe = new JTextField();
		txtTenMe.setBounds(643, 84, 136, 23);
		panelTTinHs.add(txtTenMe);
		txtTenMe.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheck();
			}
		});
		txtDiaChi.setText("");
		txtDiaChi.setBounds(643, 142, 136, 23);
		panelTTinHs.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		txtNgSinh = new JTextField();
		txtNgSinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				removeCheck();
			}
		});
		txtNgSinh.setBounds(103, 137, 136, 23);
		panelTTinHs.add(txtNgSinh);
		txtNgSinh.setColumns(10);

		JLabel lblSdtPhHuynh = new JLabel("SDT Phụ Huynh");
		lblSdtPhHuynh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSdtPhHuynh.setForeground(new Color(0, 0, 255));
		lblSdtPhHuynh.setBounds(810, 140, 87, 19);
		panelTTinHs.add(lblSdtPhHuynh);

		JLabel lblTenLop = new JLabel("Tên Lớp");
		lblTenLop.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenLop.setForeground(new Color(0, 0, 255));
		lblTenLop.setBounds(287, 185, 76, 26);
		panelTTinHs.add(lblTenLop);

		txtSDTPhHuynh = new JTextField();
		txtSDTPhHuynh.setBounds(912, 138, 148, 23);
		panelTTinHs.add(txtSDTPhHuynh);
		txtSDTPhHuynh.setColumns(10);

		txtTenLop = new JTextField();
		txtTenLop.setBounds(367, 182, 136, 23);
		panelTTinHs.add(txtTenLop);
		txtTenLop.setColumns(10);
		txtTenLop.setEnabled(false);

		boxmodelHS = new DefaultComboBoxModel<String>();
		boxmodelHS.addElement("");

		comboBoxHS = new JComboBox<String>(boxmodelHS);
		comboBoxHS.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				removeCheck();
			}
		});
		comboBoxHS.setBounds(367, 139, 136, 20);
		panelTTinHs.add(comboBoxHS);
		getIdLop();

		// panel chứa các chức năng của tab học sinh
		JPanel panelChNangHS = new JPanel();
		panelChNangHS.setBounds(1094, 27, 209, 241);
		panelTTinHs.add(panelChNangHS);
		panelChNangHS.setLayout(null);
		Border borderChNang = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleChNang = BorderFactory.createTitledBorder(borderChNang, "Chức Năng");
		panelChNangHS.setBorder(titleChNang);

		btnThemHS = new JButton("Thêm");
		btnThemHS.setBounds(79, 37, 111, 29);
		panelChNangHS.add(btnThemHS);
		Icon iconThemHS = new ImageIcon("add.png");
		btnThemHS.setIcon(iconThemHS);

		btnSuaHS = new JButton("Sửa");
		btnSuaHS.setBounds(79, 85, 111, 29);
		panelChNangHS.add(btnSuaHS);
		Icon iconSuaHS = new ImageIcon("technics.png");
		btnSuaHS.setIcon(iconSuaHS);

		btnXoaHS = new JButton("Xóa");
		btnXoaHS.setBounds(79, 139, 111, 28);
		panelChNangHS.add(btnXoaHS);
		Icon iconXoaHS = new ImageIcon("cancel.png");
		btnXoaHS.setIcon(iconXoaHS);

		btnLamMoiHS = new JButton("Làm Mới");
		btnLamMoiHS.setBounds(79, 188, 111, 29);
		panelChNangHS.add(btnLamMoiHS);
		Icon iconLamMoiHS = new ImageIcon("reset.png");
		btnLamMoiHS.setIcon(iconLamMoiHS);

		// các label dùng để fix lỗi ô trống
		lblFixHS2 = new JLabel("Ô không được trống");
		lblFixHS2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFixHS2.setForeground(Color.RED);
		lblFixHS2.setBounds(103, 107, 136, 14);
		lblFixHS2.setVisible(false);
		panelTTinHs.add(lblFixHS2);

		lblFixHS3 = new JLabel("Ô không được trống");
		lblFixHS3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFixHS3.setForeground(Color.RED);
		lblFixHS3.setBounds(103, 159, 136, 14);
		lblFixHS3.setVisible(false);
		panelTTinHs.add(lblFixHS3);

		lblFixHS5 = new JLabel("Ô không được trống");
		lblFixHS5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFixHS5.setForeground(Color.RED);
		lblFixHS5.setBounds(367, 50, 136, 14);
		lblFixHS5.setVisible(false);
		panelTTinHs.add(lblFixHS5);

		lblFixHS6 = new JLabel("Ô không được trống");
		lblFixHS6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFixHS6.setForeground(Color.RED);
		lblFixHS6.setBounds(367, 159, 136, 14);
		lblFixHS6.setVisible(false);
		panelTTinHs.add(lblFixHS6);

		lblFixHS8 = new JLabel("Ô không được trống");
		lblFixHS8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFixHS8.setForeground(Color.RED);
		lblFixHS8.setBounds(643, 169, 136, 14);
		lblFixHS8.setVisible(false);
		panelTTinHs.add(lblFixHS8);

		lblFixHS4 = new JLabel("Ô không được trống");
		lblFixHS4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFixHS4.setForeground(new Color(255, 0, 0));
		lblFixHS4.setBounds(103, 211, 136, 14);
		panelTTinHs.add(lblFixHS4);
		lblFixHS4.setVisible(false);

		// các label để thông báo lưu ý
		JLabel lblLuuYHS1 = new JLabel("*");
		lblLuuYHS1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYHS1.setForeground(Color.RED);
		lblLuuYHS1.setBounds(243, 31, 27, 14);
		panelTTinHs.add(lblLuuYHS1);

		JLabel lblLuuYHS2 = new JLabel("*");
		lblLuuYHS2.setForeground(Color.RED);
		lblLuuYHS2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYHS2.setBounds(511, 191, 27, 14);
		panelTTinHs.add(lblLuuYHS2);

		JLabel lblLuuYHS3 = new JLabel("* Các ô này không cần nhập. Phần mền sẽ hỗ trợ bạn phần này.");
		lblLuuYHS3.setForeground(Color.RED);
		lblLuuYHS3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYHS3.setBounds(454, 607, 476, 24);
		thong_tin_HS.add(lblLuuYHS3);

		// dưới đây là dùng để tìm kiếm học sinh
		txtSearchHS = new JTextField();
		txtSearchHS.setBounds(456, 238, 209, 23);
		panelTTinHs.add(txtSearchHS);
		txtSearchHS.setColumns(10);

		btnSearchHS = new JButton("Search");
		btnSearchHS.setBounds(709, 238, 89, 23);
		panelTTinHs.add(btnSearchHS);

		JLabel lblSearchHS = new JLabel("Vui lòng nhập họ tên học sinh");
		lblSearchHS.setForeground(Color.RED);
		lblSearchHS.setBounds(456, 266, 209, 14);
		panelTTinHs.add(lblSearchHS);

		// thêm bảng cho tab học sinh
		tableHS = new DefaultTableModel();
		tableHS.addColumn("Mã HS");
		tableHS.addColumn("Họ Và Tên");
		tableHS.addColumn("Ngày Sinh");
		tableHS.addColumn("Giới Tính");
		tableHS.addColumn("Quê Quán");
		tableHS.addColumn("SDT HS");
		tableHS.addColumn("Mã Lớp");
		tableHS.addColumn("Họ Và Tên Cha");
		tableHS.addColumn("Họ Và Tên Mẹ");
		tableHS.addColumn("SDT Phụ Huynh");
		tableHS.addColumn("Địa Chỉ Liên Lạc");
		tableHS.addColumn("Tên Lớp");
		tableHS.addColumn("Ghi Chú");

		jtableHS = new JTable(tableHS);
		jtableHS.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // thêm sự kiện click để lấy dữ liệu cho tab học sinh
				int rowSelectedHS = jtableHS.getSelectedRow();
				txtMaHS.setText((String) jtableHS.getValueAt(rowSelectedHS, 0));
				txtMaHS.setEnabled(false);
				txtHTenHS.setText((String) jtableHS.getValueAt(rowSelectedHS, 1));
				txtNgSinh.setText((String) jtableHS.getValueAt(rowSelectedHS, 2));
				if (jtableHS.getValueAt(rowSelectedHS, 3).toString().contains("Nam")) {
					rdbtnNam.setSelected(true);
					rdbtnNu.setSelected(false);
				} else if (jtableHS.getValueAt(rowSelectedHS, 3).toString().contains("Nữ")) {
					rdbtnNu.setSelected(true);
					rdbtnNam.setSelected(false);
				}
				txtQuQuan.setText((String) jtableHS.getValueAt(rowSelectedHS, 4));
				txtSDTHS.setText((String) jtableHS.getValueAt(rowSelectedHS, 5));
				comboBoxHS.setSelectedItem((String) jtableHS.getValueAt(rowSelectedHS, 6));
				txtTenCha.setText((String) jtableHS.getValueAt(rowSelectedHS, 7));
				txtTenMe.setText((String) jtableHS.getValueAt(rowSelectedHS, 8));
				txtSDTPhHuynh.setText((String) jtableHS.getValueAt(rowSelectedHS, 9));
				txtDiaChi.setText((String) jtableHS.getValueAt(rowSelectedHS, 10));
				txtTenLop.setText((String) jtableHS.getValueAt(rowSelectedHS, 11));
				txtGhChuHS.setText((String) jtableHS.getValueAt(rowSelectedHS, 12));

				btnThemHS.setEnabled(false);
			}
		});
		;
		scrollPaneHS = new JScrollPane(jtableHS);
		scrollPaneHS.setBounds(10, 385, 1313, 219);
		thong_tin_HS.add(scrollPaneHS);

		loadDataforTableHS();

		btnThemHS.addActionListener(this);
		btnSuaHS.addActionListener(this);
		btnXoaHS.addActionListener(this);
		btnLamMoiHS.addActionListener(this);
		btnSearchHS.addActionListener(this);

		// tab Thông Tin giáo Viên

		thong_tin_GV = new JPanel();
		tabbedPane.addTab("Quản lý thông Tin giáo viên", new ImageIcon("placeholder.png"), thong_tin_GV, null);
		thong_tin_GV.setLayout(null);
		Border borderTTinGV = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleTTinGV = BorderFactory.createTitledBorder(borderTTinGV, "Thông Tin Giáo Viên");

		JLabel lblQunLThng = new JLabel("Quản Lý Thông Tin Giáo Viên");
		lblQunLThng.setBounds(482, 11, 353, 72);
		lblQunLThng.setForeground(Color.BLUE);
		lblQunLThng.setFont(new Font("Tahoma", Font.BOLD, 24));
		thong_tin_GV.add(lblQunLThng);

		// panel thông tin của giáo viên
		JPanel panelTTGiVien = new JPanel();
		panelTTGiVien.setLayout(null);
		panelTTGiVien.setBounds(10, 94, 1313, 249);
		panelTTGiVien.setBorder(titleTTinGV);
		thong_tin_GV.add(panelTTGiVien);

		txtMaGV = new JTextField();
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(103, 31, 136, 25);
		panelTTGiVien.add(txtMaGV);
		txtMaGV.setEnabled(false);

		txtNgSinhGV = new JTextField();
		txtNgSinhGV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				removeCheckGV();
			}
		});
		txtNgSinhGV.setColumns(10);
		txtNgSinhGV.setBounds(103, 90, 136, 25);
		panelTTGiVien.add(txtNgSinhGV);

		radioNam = new JRadioButton("Nam");
		radioNam.setBounds(103, 145, 62, 25);
		panelTTGiVien.add(radioNam);

		radioNu = new JRadioButton("Nữ");
		radioNu.setBounds(177, 145, 62, 25);
		panelTTGiVien.add(radioNu);

		groupGV = new ButtonGroup();
		groupGV.add(radioNam);
		groupGV.add(radioNu);
		if (group.getSelection() != null) {
			lblFixHS4.setVisible(false);
		}

		JLabel lblMaGv = new JLabel("Mã GV");
		lblMaGv.setForeground(Color.BLUE);
		lblMaGv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaGv.setBounds(28, 31, 59, 25);
		panelTTGiVien.add(lblMaGv);

		JLabel lblNgSinhGV = new JLabel("Ngày Sinh");
		lblNgSinhGV.setForeground(Color.BLUE);
		lblNgSinhGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgSinhGV.setBounds(28, 86, 70, 32);
		panelTTGiVien.add(lblNgSinhGV);

		JLabel lblGiTinhGV = new JLabel("Giới Tính");
		lblGiTinhGV.setForeground(Color.BLUE);
		lblGiTinhGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiTinhGV.setBounds(28, 148, 59, 29);
		panelTTGiVien.add(lblGiTinhGV);

		JLabel lblHoTenGV = new JLabel("Họ Tên");
		lblHoTenGV.setForeground(Color.BLUE);
		lblHoTenGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHoTenGV.setBounds(287, 35, 70, 17);
		panelTTGiVien.add(lblHoTenGV);

		JLabel lblQuQuanGV = new JLabel("Quê Quán");
		lblQuQuanGV.setForeground(Color.BLUE);
		lblQuQuanGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuQuanGV.setBounds(287, 91, 70, 23);
		panelTTGiVien.add(lblQuQuanGV);

		JLabel lblSDTGV = new JLabel("SĐT");
		lblSDTGV.setForeground(Color.BLUE);
		lblSDTGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSDTGV.setBounds(287, 150, 46, 24);
		panelTTGiVien.add(lblSDTGV);

		JLabel lblGhChuGV = new JLabel("Ghi Chú");
		lblGhChuGV.setForeground(Color.BLUE);
		lblGhChuGV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGhChuGV.setBounds(542, 145, 70, 25);
		panelTTGiVien.add(lblGhChuGV);

		txtHTenGV = new JTextField();
		txtHTenGV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				removeCheckGV();
			}
		});
		txtHTenGV.setColumns(10);
		txtHTenGV.setBounds(367, 31, 136, 25);
		panelTTGiVien.add(txtHTenGV);

		txtQuQuanGV = new JTextField();
		txtQuQuanGV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				removeCheckGV();
			}
		});
		txtQuQuanGV.setColumns(10);
		txtQuQuanGV.setBounds(367, 90, 136, 25);
		panelTTGiVien.add(txtQuQuanGV);

		txtSDTGV = new JTextField();
		txtSDTGV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				removeCheckGV();
			}
		});
		txtSDTGV.setColumns(10);
		txtSDTGV.setBounds(367, 145, 136, 25);
		panelTTGiVien.add(txtSDTGV);

		txtGhChuGV = new JTextField();
		txtGhChuGV.setColumns(10);
		txtGhChuGV.setBounds(643, 145, 417, 25);
		panelTTGiVien.add(txtGhChuGV);

		JLabel lblTrinhDo = new JLabel("Trình Độ");
		lblTrinhDo.setForeground(Color.BLUE);
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrinhDo.setBounds(542, 31, 76, 25);
		panelTTGiVien.add(lblTrinhDo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(542, 87, 76, 30);
		panelTTGiVien.add(lblEmail);

		txtTrinhDo = new JTextField();
		txtTrinhDo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				removeCheckGV();
			}
		});
		txtTrinhDo.setColumns(10);
		txtTrinhDo.setBounds(643, 31, 136, 25);
		panelTTGiVien.add(txtTrinhDo);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(643, 90, 136, 25);
		panelTTGiVien.add(txtEmail);

		// panel chứa các chức năng của tab giáo viên
		JPanel panelChNangGV = new JPanel();
		panelChNangGV.setLayout(null);
		panelChNangGV.setBounds(1103, 11, 200, 174);
		panelTTGiVien.add(panelChNangGV);
		Border borderChNangGV = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleChNangGV = BorderFactory.createTitledBorder(borderChNangGV, "Chức Năng");
		panelChNangGV.setBorder(titleChNangGV);

		btnThemGV = new JButton("Thêm");
		btnThemGV.setBounds(79, 15, 111, 29);
		panelChNangGV.add(btnThemGV);
		Icon iconThemGV = new ImageIcon("add.png");
		btnThemGV.setIcon(iconThemGV);

		btnSuaGV = new JButton("Sửa");
		btnSuaGV.setBounds(79, 55, 111, 29);
		panelChNangGV.add(btnSuaGV);
		Icon iconSuaGV = new ImageIcon("technics.png");
		btnSuaGV.setIcon(iconSuaGV);

		btnXoaGV = new JButton("Xóa");
		btnXoaGV.setBounds(79, 95, 111, 28);
		panelChNangGV.add(btnXoaGV);
		Icon iconXoaGV = new ImageIcon("cancel.png");
		btnXoaGV.setIcon(iconXoaGV);

		btnLamMoiGV = new JButton("Làm Mới");
		btnLamMoiGV.setBounds(79, 134, 111, 29);
		panelChNangGV.add(btnLamMoiGV);
		Icon iconLamMoiGV = new ImageIcon("reset.png");
		btnLamMoiGV.setIcon(iconLamMoiGV);

		// dùng để tìm kiếm giáo viên
		txtSearchGV = new JTextField();
		txtSearchGV.setBounds(473, 196, 178, 25);
		panelTTGiVien.add(txtSearchGV);
		txtSearchGV.setColumns(10);

		btnSearchGV = new JButton("Search");
		btnSearchGV.setBounds(688, 195, 89, 23);
		panelTTGiVien.add(btnSearchGV);

		lblSearchGV = new JLabel("Vui lòng nhập họ tên giáo viên ");
		lblSearchGV.setForeground(Color.RED);
		lblSearchGV.setBounds(473, 224, 178, 14);
		panelTTGiVien.add(lblSearchGV);

		// các label dùng để fix các ô trống
		lblFixGV2 = new JLabel("Ô không được trống");
		lblFixGV2.setForeground(Color.RED);
		lblFixGV2.setBackground(Color.WHITE);
		lblFixGV2.setBounds(103, 122, 136, 14);
		panelTTGiVien.add(lblFixGV2);
		lblFixGV2.setVisible(false);

		lblFixGV3 = new JLabel("Ô không được trống");
		lblFixGV3.setForeground(Color.RED);
		lblFixGV3.setBackground(Color.WHITE);
		lblFixGV3.setBounds(367, 59, 136, 14);
		panelTTGiVien.add(lblFixGV3);
		lblFixGV3.setVisible(false);

		lblFixGV4 = new JLabel("Ô không được trống");
		lblFixGV4.setForeground(Color.RED);
		lblFixGV4.setBackground(Color.WHITE);
		lblFixGV4.setBounds(367, 120, 136, 14);
		panelTTGiVien.add(lblFixGV4);
		lblFixGV4.setVisible(false);

		lblFixGV5 = new JLabel("Ô không được trống");
		lblFixGV5.setForeground(Color.RED);
		lblFixGV5.setBackground(Color.WHITE);
		lblFixGV5.setBounds(367, 171, 136, 14);
		panelTTGiVien.add(lblFixGV5);
		lblFixGV5.setVisible(false);

		lblFixGV6 = new JLabel("Ô không được trống");
		lblFixGV6.setForeground(Color.RED);
		lblFixGV6.setBackground(Color.WHITE);
		lblFixGV6.setBounds(643, 59, 136, 14);
		panelTTGiVien.add(lblFixGV6);
		lblFixGV6.setVisible(false);

		lblFixGV1 = new JLabel("Ô không được trống");
		lblFixGV1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFixGV1.setBackground(Color.WHITE);
		lblFixGV1.setForeground(Color.RED);
		lblFixGV1.setBounds(103, 171, 136, 14);
		panelTTGiVien.add(lblFixGV1);
		lblFixGV1.setVisible(false);

		// các label dùng để đưa ra ghi chú
		JLabel lblLuuYGV1 = new JLabel("*");
		lblLuuYGV1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYGV1.setForeground(Color.RED);
		lblLuuYGV1.setBounds(250, 34, 27, 14);
		panelTTGiVien.add(lblLuuYGV1);

		JLabel lblLuuYGV2 = new JLabel("* Các ô này không cần nhập. Phần mền sẽ hỗ trợ bạn phần này.");
		lblLuuYGV2.setForeground(Color.RED);
		lblLuuYGV2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYGV2.setBounds(427, 607, 476, 24);
		thong_tin_GV.add(lblLuuYGV2);

		// thêm bảng cho tab giáo viên
		tableGV = new DefaultTableModel();
		tableGV.addColumn("Mã Giáo Viên");
		tableGV.addColumn("Tên Giáo Viên");
		tableGV.addColumn("Ngày Sinh");
		tableGV.addColumn("Giới Tính");
		tableGV.addColumn("Quê Quán");
		tableGV.addColumn("SĐT Giáo Viên");
		tableGV.addColumn("Trình Độ");
		tableGV.addColumn("Email");
		tableGV.addColumn("Ghi Chú");

		jtableGV = new JTable(tableGV);
		jtableGV.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowSelectedGV = jtableGV.getSelectedRow();
				txtMaGV.setText((String) jtableGV.getValueAt(rowSelectedGV, 0));
				txtHTenGV.setText((String) jtableGV.getValueAt(rowSelectedGV, 1));
				txtNgSinhGV.setText((String) jtableGV.getValueAt(rowSelectedGV, 2));
				if (jtableGV.getValueAt(rowSelectedGV, 3).toString().contains("Nam")) {
					radioNam.setSelected(true);
					radioNu.setSelected(false);
				} else if (jtableGV.getValueAt(rowSelectedGV, 3).toString().contains("Nữ")) {
					radioNu.setSelected(true);
					radioNam.setSelected(false);
				}
				txtQuQuanGV.setText((String) jtableGV.getValueAt(rowSelectedGV, 4));
				txtSDTGV.setText((String) jtableGV.getValueAt(rowSelectedGV, 5));
				txtTrinhDo.setText((String) jtableGV.getValueAt(rowSelectedGV, 6));
				txtEmail.setText((String) jtableGV.getValueAt(rowSelectedGV, 7));
				txtGhChuGV.setText((String) jtableGV.getValueAt(rowSelectedGV, 8));

				btnThemGV.setEnabled(false);
			}
		});
		scrollPaneGV = new JScrollPane(jtableGV);
		scrollPaneGV.setBounds(10, 354, 1313, 248);
		thong_tin_GV.add(scrollPaneGV);

		loadDataforTableGV();

		btnThemGV.addActionListener(this);
		btnSuaGV.addActionListener(this);
		btnXoaGV.addActionListener(this);
		btnLamMoiGV.addActionListener(this);
		btnSearchGV.addActionListener(this);

		// tab Lớp
		lop = new JPanel();
		tabbedPane.addTab("Quản lý lớp học", new ImageIcon("presentation.png"), lop, null);
		lop.setLayout(null);

		JLabel lblThngTinLop = new JLabel("Quản Lý Thông Tin Của Các Lớp Học");
		lblThngTinLop.setForeground(Color.BLUE);
		lblThngTinLop.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblThngTinLop.setBounds(445, 11, 452, 82);
		lop.add(lblThngTinLop);

		// panel thông tin lớp học
		JPanel panelTTinLop = new JPanel();
		panelTTinLop.setBounds(68, 104, 1216, 191);
		lop.add(panelTTinLop);
		Border borderTTinLop = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleTTinLop = BorderFactory.createTitledBorder(borderTTinLop, "Thông Tin Của Lớp");
		panelTTinLop.setBorder(titleTTinLop);
		panelTTinLop.setLayout(null);

		lblMaLopHoc = new JLabel("Mã Lớp");
		lblMaLopHoc.setBounds(27, 41, 56, 20);
		panelTTinLop.add(lblMaLopHoc);

		JLabel lblTenLopHoc = new JLabel("Tên Lớp");
		lblTenLopHoc.setBounds(237, 41, 56, 20);
		panelTTinLop.add(lblTenLopHoc);

		txtTenLopHoc = new JTextField();
		txtTenLopHoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				removeCheckLop();
			}
		});
		txtTenLopHoc.setBounds(303, 41, 124, 20);
		panelTTinLop.add(txtTenLopHoc);
		txtTenLopHoc.setColumns(10);

		JLabel lblMaGiaoVien = new JLabel("Mã Giáo Viên");
		lblMaGiaoVien.setBounds(465, 43, 78, 17);
		panelTTinLop.add(lblMaGiaoVien);

		txtMaGiaoVien = new JTextField();
		txtMaGiaoVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheckLop();
			}
		});
		txtMaGiaoVien.setBounds(563, 41, 124, 20);
		panelTTinLop.add(txtMaGiaoVien);
		txtMaGiaoVien.setColumns(10);

		JLabel lblTenGiaoVien = new JLabel("Tên Giáo Viên");
		lblTenGiaoVien.setBounds(721, 43, 78, 17);
		panelTTinLop.add(lblTenGiaoVien);

		txtTenGiaoVien = new JTextField();
		txtTenGiaoVien.setBounds(824, 41, 124, 20);
		panelTTinLop.add(txtTenGiaoVien);
		txtTenGiaoVien.setColumns(10);
		txtTenGiaoVien.setEnabled(false);

		txtMaLopHoc = new JTextField();
		txtMaLopHoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				removeCheckLop();
			}
		});
		txtMaLopHoc.setBounds(80, 41, 124, 20);
		panelTTinLop.add(txtMaLopHoc);
		txtMaLopHoc.setColumns(10);

		// panel chức chức năng của tab lớp học
		JPanel panelCNangLop = new JPanel();
		panelCNangLop.setLayout(null);
		panelCNangLop.setBounds(282, 92, 629, 75);
		panelTTinLop.add(panelCNangLop);

		btnThemLop = new JButton("Thêm");
		btnThemLop.setBounds(70, 35, 111, 29);
		panelCNangLop.add(btnThemLop);

		btnSuaLop = new JButton("Sửa");
		btnSuaLop.setBounds(217, 35, 111, 29);
		panelCNangLop.add(btnSuaLop);

		btnXoaLop = new JButton("Xóa");
		btnXoaLop.setBounds(359, 35, 111, 28);
		panelCNangLop.add(btnXoaLop);

		btnLamMoiLop = new JButton("Làm Mới");
		btnLamMoiLop.setBounds(496, 35, 111, 29);
		panelCNangLop.add(btnLamMoiLop);
		Border borderCNangLop = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleCNangLop = BorderFactory.createTitledBorder(borderCNangLop, "Chức Năng");
		panelCNangLop.setBorder(titleCNangLop);

		// các label dùng để fix lỗi ô trống
		lblFixLop1 = new JLabel("Ô không được trống");
		lblFixLop1.setForeground(Color.RED);
		lblFixLop1.setBounds(80, 67, 124, 14);
		panelTTinLop.add(lblFixLop1);
		lblFixLop1.setVisible(false);

		lblFixLop2 = new JLabel("Ô không được trống");
		lblFixLop2.setForeground(Color.RED);
		lblFixLop2.setBounds(303, 67, 124, 14);
		panelTTinLop.add(lblFixLop2);
		lblFixLop2.setVisible(false);

		lblGhiChuLop = new JLabel("Ghi Chú");
		lblGhiChuLop.setBounds(982, 44, 46, 14);
		panelTTinLop.add(lblGhiChuLop);

		txtGhiChuLop = new JTextField();
		txtGhiChuLop.setBounds(1048, 41, 126, 20);
		panelTTinLop.add(txtGhiChuLop);
		txtGhiChuLop.setColumns(10);

		lblFixLop3 = new JLabel("Ô không được trống");
		lblFixLop3.setForeground(Color.RED);
		lblFixLop3.setBounds(563, 67, 124, 14);
		panelTTinLop.add(lblFixLop3);

		// các label dùng để đưa ra ghi chú
		JLabel lblLuuYLop1 = new JLabel("*");
		lblLuuYLop1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYLop1.setForeground(Color.RED);
		lblLuuYLop1.setBounds(955, 44, 17, 14);
		panelTTinLop.add(lblLuuYLop1);
		lblFixLop3.setVisible(false);

		JLabel lblLuuYLop2 = new JLabel("* Các ô này không cần nhập. Phần mền sẽ hỗ trợ bạn phần này.");
		lblLuuYLop2.setForeground(Color.RED);
		lblLuuYLop2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYLop2.setBounds(448, 603, 476, 24);
		lop.add(lblLuuYLop2);

		// thêm bảng cho tab lớp học
		tableLop = new DefaultTableModel();
		tableLop.addColumn("Mã Lớp");
		tableLop.addColumn("Tên Lớp");
		tableLop.addColumn("Mã Giáo Viên");
		tableLop.addColumn("Tên Giáo Viên Chủ Nhiệm");
		tableLop.addColumn("Ghi Chú");

		jtableLop = new JTable(tableLop);
		jtableLop.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowSelectedLop = jtableLop.getSelectedRow();
				txtMaLopHoc.setText((String) jtableLop.getValueAt(rowSelectedLop, 0));
				txtTenLopHoc.setText((String) jtableLop.getValueAt(rowSelectedLop, 1));
				txtMaGiaoVien.setText((String) jtableLop.getValueAt(rowSelectedLop, 2));
				txtTenGiaoVien.setText((String) jtableLop.getValueAt(rowSelectedLop, 3));

				txtMaLopHoc.setEnabled(false);
				btnThemLop.setEnabled(false);
			}
		});
		scrollLop = new JScrollPane(jtableLop);
		lop.add(scrollLop);
		scrollLop.setBounds(68, 306, 1216, 292);

		loadDataforTableLop();

		btnThemLop.addActionListener(this);
		btnSuaLop.addActionListener(this);
		btnXoaLop.addActionListener(this);
		btnLamMoiLop.addActionListener(this);

		// tab Điểm
		diem_HS = new JPanel();
		tabbedPane.addTab("Quản lý điểm học sinh", new ImageIcon("table.png"), diem_HS, null);
		diem_HS.setLayout(null);

		lblQLyDiem = new JLabel("Quản Lí Bảng Điểm Học Sinh");
		lblQLyDiem.setBounds(467, 21, 452, 82);
		lblQLyDiem.setForeground(Color.BLUE);
		lblQLyDiem.setFont(new Font("Tahoma", Font.BOLD, 24));
		diem_HS.add(lblQLyDiem);

		// panel thông tin điểm
		panelTTinBangDiem = new JPanel();
		panelTTinBangDiem.setBounds(10, 114, 1309, 248);
		diem_HS.add(panelTTinBangDiem);
		Border borderTTinDiem = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleTTinDiem = BorderFactory.createTitledBorder(borderTTinDiem, "Thông Tin Bảng Điểm");
		panelTTinBangDiem.setBorder(titleTTinDiem);
		panelTTinBangDiem.setLayout(null);

		lblMaHocSinh_Diem = new JLabel("Mã Học Sinh");
		lblMaHocSinh_Diem.setBounds(34, 39, 82, 14);
		panelTTinBangDiem.add(lblMaHocSinh_Diem);

		txtMaHocSinh_Diem = new JTextField();
		txtMaHocSinh_Diem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheckDiem();
			}
		});
		txtMaHocSinh_Diem.setBounds(114, 36, 106, 20);
		panelTTinBangDiem.add(txtMaHocSinh_Diem);
		txtMaHocSinh_Diem.setColumns(10);

		lblTenHocSinh_Diem = new JLabel("Tên Học Sinh");
		lblTenHocSinh_Diem.setBounds(251, 39, 86, 14);
		panelTTinBangDiem.add(lblTenHocSinh_Diem);

		txtTenHocSinh_Diem = new JTextField();
		txtTenHocSinh_Diem.setBounds(337, 36, 106, 20);
		panelTTinBangDiem.add(txtTenHocSinh_Diem);
		txtTenHocSinh_Diem.setColumns(10);
		txtTenHocSinh_Diem.setEnabled(false);

		lblMaLop_Diem = new JLabel("Mã Lớp");
		lblMaLop_Diem.setBounds(477, 39, 58, 14);
		panelTTinBangDiem.add(lblMaLop_Diem);

		txtMaLop_Diem = new JTextField();
		txtMaLop_Diem.setBounds(545, 36, 106, 20);
		panelTTinBangDiem.add(txtMaLop_Diem);
		txtMaLop_Diem.setColumns(10);
		txtMaLop_Diem.setEnabled(false);

		lblTenLop_Diem = new JLabel("Tên Lớp");
		lblTenLop_Diem.setBounds(682, 39, 58, 14);
		panelTTinBangDiem.add(lblTenLop_Diem);

		txtTenLop_Diem = new JTextField();
		txtTenLop_Diem.setBounds(750, 36, 106, 20);
		panelTTinBangDiem.add(txtTenLop_Diem);
		txtTenLop_Diem.setColumns(10);
		txtTenLop_Diem.setEnabled(false);

		lblMaMon_Diem = new JLabel("Mã Môn");
		lblMaMon_Diem.setBounds(892, 39, 58, 14);
		panelTTinBangDiem.add(lblMaMon_Diem);

		txtMaMon_Diem = new JTextField();
		txtMaMon_Diem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheckDiem();
			}
		});
		txtMaMon_Diem.setBounds(960, 36, 106, 20);
		panelTTinBangDiem.add(txtMaMon_Diem);
		txtMaMon_Diem.setColumns(10);

		lblTenMon_Diem = new JLabel("Tên Môn");
		lblTenMon_Diem.setBounds(1095, 39, 58, 14);
		panelTTinBangDiem.add(lblTenMon_Diem);

		txtTenMon_Diem = new JTextField();
		txtTenMon_Diem.setBounds(1163, 36, 106, 20);
		panelTTinBangDiem.add(txtTenMon_Diem);
		txtTenMon_Diem.setColumns(10);
		txtTenMon_Diem.setEnabled(false);

		JLabel lblDiem15p1 = new JLabel("Điểm 15P Lần 1");
		lblDiem15p1.setBounds(22, 94, 94, 14);
		panelTTinBangDiem.add(lblDiem15p1);

		txtDiem15p1 = new JTextField();
		txtDiem15p1.setBounds(114, 91, 106, 20);
		panelTTinBangDiem.add(txtDiem15p1);
		txtDiem15p1.setColumns(10);

		JLabel lblDiem15p2 = new JLabel("Điểm 15P Lần 2");
		lblDiem15p2.setBounds(240, 94, 97, 14);
		panelTTinBangDiem.add(lblDiem15p2);

		txtDiem15p2 = new JTextField();
		txtDiem15p2.setBounds(337, 91, 106, 20);
		panelTTinBangDiem.add(txtDiem15p2);
		txtDiem15p2.setColumns(10);

		txtDiem1T = new JTextField();
		txtDiem1T.setBounds(545, 91, 106, 20);
		panelTTinBangDiem.add(txtDiem1T);
		txtDiem1T.setColumns(10);

		lblDiem1T = new JLabel("Điểm 1T");
		lblDiem1T.setBounds(477, 94, 58, 14);
		panelTTinBangDiem.add(lblDiem1T);

		lblDiemKi1 = new JLabel("Điểm Kì 1");
		lblDiemKi1.setBounds(682, 94, 69, 14);
		panelTTinBangDiem.add(lblDiemKi1);

		txtDiemKi1 = new JTextField();
		txtDiemKi1.setBounds(750, 91, 106, 20);
		panelTTinBangDiem.add(txtDiemKi1);
		txtDiemKi1.setColumns(10);

		lblDiemKi2 = new JLabel("Điểm Kì 2");
		lblDiemKi2.setBounds(892, 94, 70, 14);
		panelTTinBangDiem.add(lblDiemKi2);

		txtDiemKi2 = new JTextField();
		txtDiemKi2.setBounds(960, 91, 106, 20);
		panelTTinBangDiem.add(txtDiemKi2);
		txtDiemKi2.setColumns(10);

		lblTongDiem = new JLabel("Tổng Điểm");
		lblTongDiem.setBounds(1094, 94, 70, 14);
		panelTTinBangDiem.add(lblTongDiem);

		txtTongDiem = new JTextField();
		txtTongDiem.setBounds(1163, 91, 106, 20);
		panelTTinBangDiem.add(txtTongDiem);
		txtTongDiem.setColumns(10);
		txtTongDiem.setEnabled(false);

		// panel chức các chức năng của tab điểm
		panelChNangDiem = new JPanel();
		panelChNangDiem.setLayout(null);
		panelChNangDiem.setBounds(333, 151, 629, 75);
		panelTTinBangDiem.add(panelChNangDiem);
		Border borderChNangDiem = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleChNangDiem = BorderFactory.createTitledBorder(borderChNangDiem, "Chức Năng");
		panelChNangDiem.setBorder(titleChNangDiem);

		btnThemDiem = new JButton("Thêm");
		btnThemDiem.setBounds(70, 35, 111, 29);
		panelChNangDiem.add(btnThemDiem);

		btnSuaDiem = new JButton("Sửa");
		btnSuaDiem.setBounds(217, 35, 111, 29);
		panelChNangDiem.add(btnSuaDiem);

		btnXoaDiem = new JButton("Xóa");
		btnXoaDiem.setBounds(359, 35, 111, 28);
		panelChNangDiem.add(btnXoaDiem);

		btnLamMoiDiem = new JButton("Làm Mới");
		btnLamMoiDiem.setBounds(496, 35, 111, 29);
		panelChNangDiem.add(btnLamMoiDiem);

		// các label dùng để fix lỗi ô trống
		lblFixDiem1 = new JLabel("Ô không được trống");
		lblFixDiem1.setForeground(Color.RED);
		lblFixDiem1.setBounds(114, 64, 127, 14);
		panelTTinBangDiem.add(lblFixDiem1);
		lblFixDiem1.setVisible(false);

		lblFixDiem2 = new JLabel("Ô không được trống");
		lblFixDiem2.setForeground(Color.RED);
		lblFixDiem2.setBounds(960, 64, 135, 14);
		panelTTinBangDiem.add(lblFixDiem2);

		// các label dùng để đưa ra ghi chú
		JLabel lblLuuYDiem1 = new JLabel("*");
		lblLuuYDiem1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYDiem1.setForeground(Color.RED);
		lblLuuYDiem1.setBounds(453, 39, 23, 14);
		panelTTinBangDiem.add(lblLuuYDiem1);

		JLabel lblLuuYDiem2 = new JLabel("*");
		lblLuuYDiem2.setForeground(Color.RED);
		lblLuuYDiem2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYDiem2.setBounds(661, 39, 23, 14);
		panelTTinBangDiem.add(lblLuuYDiem2);

		JLabel lblLuuYDiem3 = new JLabel("*");
		lblLuuYDiem3.setForeground(Color.RED);
		lblLuuYDiem3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYDiem3.setBounds(859, 39, 23, 14);
		panelTTinBangDiem.add(lblLuuYDiem3);

		JLabel lblLuuYDiem4 = new JLabel("*");
		lblLuuYDiem4.setForeground(Color.RED);
		lblLuuYDiem4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYDiem4.setBounds(1276, 39, 23, 14);
		panelTTinBangDiem.add(lblLuuYDiem4);

		JLabel lblLuuYDiem5 = new JLabel("*");
		lblLuuYDiem5.setForeground(Color.RED);
		lblLuuYDiem5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYDiem5.setBounds(1276, 94, 23, 14);
		panelTTinBangDiem.add(lblLuuYDiem5);
		lblFixDiem2.setVisible(false);

		JLabel lblLuuYDiem6 = new JLabel("* Các ô này không cần nhập. Phần mền sẽ hỗ trợ bạn phần này.");
		lblLuuYDiem6.setForeground(Color.RED);
		lblLuuYDiem6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYDiem6.setBounds(460, 609, 476, 24);
		diem_HS.add(lblLuuYDiem6);

		// thêm bảng cho tab điểm
		tableDiem = new DefaultTableModel();
		tableDiem.addColumn("Mã Học Sinh");
		tableDiem.addColumn("Tên Học Sinh");
		tableDiem.addColumn("Mã Lớp");
		tableDiem.addColumn("Tên Lớp");
		tableDiem.addColumn("Mã Môn");
		tableDiem.addColumn("Tên Môn");
		tableDiem.addColumn("Điểm 15P L1");
		tableDiem.addColumn("Điểm 15P L2");
		tableDiem.addColumn("Điểm 1T");
		tableDiem.addColumn("Điểm Kì 1");
		tableDiem.addColumn("Điểm Kì 2");
		tableDiem.addColumn("Điểm Tổng");

		jtableDiem = new JTable(tableDiem);
		jtableDiem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowSelectedLop = jtableDiem.getSelectedRow();
				txtMaHocSinh_Diem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 0));
				txtTenHocSinh_Diem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 1));
				txtMaLop_Diem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 2));
				txtTenLop_Diem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 3));
				txtMaMon_Diem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 4));
				txtTenMon_Diem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 5));
				txtDiem15p1.setText((String) jtableDiem.getValueAt(rowSelectedLop, 6));
				txtDiem15p2.setText((String) jtableDiem.getValueAt(rowSelectedLop, 7));
				txtDiem1T.setText((String) jtableDiem.getValueAt(rowSelectedLop, 8));
				txtDiemKi1.setText((String) jtableDiem.getValueAt(rowSelectedLop, 9));
				txtDiemKi2.setText((String) jtableDiem.getValueAt(rowSelectedLop, 10));
				txtTongDiem.setText((String) jtableDiem.getValueAt(rowSelectedLop, 11));

				txtMaHocSinh_Diem.setEnabled(false);
				btnThemDiem.setEnabled(false);
			}
		});
		scrollDiem = new JScrollPane(jtableDiem);
		scrollDiem.setBounds(10, 373, 1310, 225);
		diem_HS.add(scrollDiem);

		loadDataforTableDiem();

		btnThemDiem.addActionListener(this);
		btnSuaDiem.addActionListener(this);
		btnXoaDiem.addActionListener(this);
		btnLamMoiDiem.addActionListener(this);

		// tab Môn Học
		mon_hoc = new JPanel();
		tabbedPane.addTab("Quản lý môn học", new ImageIcon("books.png"), mon_hoc, null);
		mon_hoc.setLayout(null);

		lblQunLThng_1 = new JLabel("Quản Lý Thông Tin Của Các Môn Học");
		lblQunLThng_1.setForeground(Color.BLUE);
		lblQunLThng_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQunLThng_1.setBounds(454, 23, 452, 82);
		mon_hoc.add(lblQunLThng_1);

		// panel thông tin môn học
		panelTTinMon = new JPanel();
		panelTTinMon.setBounds(68, 116, 1216, 191);
		mon_hoc.add(panelTTinMon);
		Border borderTTinMon = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleTTinMon = BorderFactory.createTitledBorder(borderTTinMon, "Thông Tin Môn Học");
		panelTTinMon.setBorder(titleTTinMon);
		panelTTinMon.setLayout(null);

		lblMaMon_Mon = new JLabel("Mã Môn");
		lblMaMon_Mon.setBounds(25, 41, 56, 20);
		panelTTinMon.add(lblMaMon_Mon);

		lblTenMon_Mon = new JLabel("Tên Môn");
		lblTenMon_Mon.setBounds(245, 41, 56, 20);
		panelTTinMon.add(lblTenMon_Mon);

		txtTenMon_Mon = new JTextField();
		txtTenMon_Mon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				removeCheckMon();
			}
		});
		txtTenMon_Mon.setBounds(321, 41, 124, 20);
		panelTTinMon.add(txtTenMon_Mon);
		txtTenMon_Mon.setColumns(10);

		lblMaGiaoVien_Mon = new JLabel("Mã Giáo Viên");
		lblMaGiaoVien_Mon.setBounds(476, 43, 78, 17);
		panelTTinMon.add(lblMaGiaoVien_Mon);

		txtMaGiaoVien_Mon = new JTextField();
		txtMaGiaoVien_Mon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				removeCheckMon();
			}
		});
		txtMaGiaoVien_Mon.setBounds(564, 41, 124, 20);
		panelTTinMon.add(txtMaGiaoVien_Mon);
		txtMaGiaoVien_Mon.setColumns(10);

		lblTenGiaoVien_Mon = new JLabel("Tên Giáo Viên");
		lblTenGiaoVien_Mon.setBounds(724, 43, 78, 17);
		panelTTinMon.add(lblTenGiaoVien_Mon);

		txtTenGiaoVien_Mon = new JTextField();
		txtTenGiaoVien_Mon.setBounds(825, 41, 124, 20);
		panelTTinMon.add(txtTenGiaoVien_Mon);
		txtTenGiaoVien_Mon.setColumns(10);
		txtTenGiaoVien_Mon.setEnabled(false);

		txtMaMon_Mon = new JTextField();
		txtMaMon_Mon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				removeCheckMon();
			}
		});
		txtMaMon_Mon.setBounds(91, 41, 124, 20);
		panelTTinMon.add(txtMaMon_Mon);
		txtMaMon_Mon.setColumns(10);

		// panel chức năng của tab môn học
		panelCNangMon = new JPanel();
		panelCNangMon.setLayout(null);
		panelCNangMon.setBounds(282, 92, 629, 75);
		panelTTinMon.add(panelCNangMon);

		btnThemMon = new JButton("Thêm");
		btnThemMon.setBounds(70, 35, 111, 29);
		panelCNangMon.add(btnThemMon);

		btnSuaMon = new JButton("Sửa");
		btnSuaMon.setBounds(217, 35, 111, 29);
		panelCNangMon.add(btnSuaMon);

		btnXoaMon = new JButton("Xóa");
		btnXoaMon.setBounds(359, 35, 111, 28);
		panelCNangMon.add(btnXoaMon);

		btnLamMoiMon = new JButton("Làm Mới");
		btnLamMoiMon.setBounds(496, 35, 111, 29);
		panelCNangMon.add(btnLamMoiMon);

		Border borderCNangMon = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleCNangMon = BorderFactory.createTitledBorder(borderCNangMon, "Chức Năng");
		panelCNangMon.setBorder(titleCNangMon);

		JLabel lblGhiChuMon = new JLabel("Ghi Chú");
		lblGhiChuMon.setBounds(980, 44, 56, 14);
		panelTTinMon.add(lblGhiChuMon);

		txtGhiChuMon = new JTextField();
		txtGhiChuMon.setBounds(1046, 41, 121, 20);
		panelTTinMon.add(txtGhiChuMon);
		txtGhiChuMon.setColumns(10);

		// các label dùng để fix lỗi ô trống
		lblFixMon1 = new JLabel("Ô không được trống");
		lblFixMon1.setForeground(Color.RED);
		lblFixMon1.setBounds(91, 65, 124, 14);
		panelTTinMon.add(lblFixMon1);
		lblFixMon1.setVisible(false);

		lblFixMon2 = new JLabel("Ô không được trống");
		lblFixMon2.setForeground(Color.RED);
		lblFixMon2.setBounds(321, 65, 124, 14);
		panelTTinMon.add(lblFixMon2);
		lblFixMon2.setVisible(false);

		lblFixMon3 = new JLabel("Ô không được trống");
		lblFixMon3.setForeground(Color.RED);
		lblFixMon3.setBounds(564, 65, 124, 14);
		panelTTinMon.add(lblFixMon3);
		lblFixMon3.setVisible(false);

		// các label dùng để đưa ra ghi chú
		JLabel lblLuuYMon1 = new JLabel("*");
		lblLuuYMon1.setForeground(Color.RED);
		lblLuuYMon1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYMon1.setBounds(959, 44, 23, 14);
		panelTTinMon.add(lblLuuYMon1);

		JLabel lblLuuYMon2 = new JLabel("* Các ô này không cần nhập. Phần mền sẽ hỗ trợ bạn phần này.");
		lblLuuYMon2.setForeground(Color.RED);
		lblLuuYMon2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuuYMon2.setBounds(448, 609, 476, 24);
		mon_hoc.add(lblLuuYMon2);

		// thêm bảng cho tab môn học
		tableMon = new DefaultTableModel();
		tableMon.addColumn("Mã Môn");
		tableMon.addColumn("Tên Môn");
		tableMon.addColumn("Mã Giáo Viên");
		tableMon.addColumn("Tên Giáo Viên");
		tableMon.addColumn("Ghi Chú");

		jtableMon = new JTable(tableMon);
		jtableMon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowSelectedMon = jtableMon.getSelectedRow();
				txtMaMon_Mon.setText((String) jtableMon.getValueAt(rowSelectedMon, 0));
				txtTenMon_Mon.setText((String) jtableMon.getValueAt(rowSelectedMon, 1));
				txtMaGiaoVien_Mon.setText((String) jtableMon.getValueAt(rowSelectedMon, 2));
				txtTenGiaoVien_Mon.setText((String) jtableMon.getValueAt(rowSelectedMon, 3));
				txtGhiChuMon.setText((String) jtableMon.getValueAt(rowSelectedMon, 4));

				txtMaMon_Mon.setEnabled(false);
				btnThemMon.setEnabled(false);
			}
		});
		scrollMon = new JScrollPane(jtableMon);
		mon_hoc.add(scrollMon);
		scrollMon.setBounds(68, 318, 1216, 288);

		loadDataforTableMon();

		btnThemMon.addActionListener(this);
		btnSuaMon.addActionListener(this);
		btnXoaMon.addActionListener(this);
		btnLamMoiMon.addActionListener(this);
	}

	// hàm loadDatabase cho bảng của tab học sinh
	private void loadDataforTableHS() {
		tableHS.setRowCount(0);
		schoolDao = new SchoolDao();
		ArrayList<Student> litsStudent = schoolDao.getAllStudent();
		for (Student student : litsStudent) {
			tableHS.addRow(new String[] { "HS" + student.getMaHocSinh(), student.getTenHocSinh(),
					student.getNgaySinhHS(), student.getGioiTinhHS(), student.getQueQuanHS(), student.getSDTHocSinh(),
					student.getMaLop(), student.getHoTenCha(), student.getHoTenMe(), student.getSDTPhuHuynh(),
					student.getDiaChiLienHe(), student.getTenLop(), student.getGhiChuHS() });
		}
	}

	// hàm loadDatabase cho bảng của tab giáo viên
	private void loadDataforTableGV() {
		tableGV.setRowCount(0);
		schoolDao = new SchoolDao();
		ArrayList<Teacher> listTeacher = schoolDao.getAllTeacher();
		for (Teacher teacher : listTeacher) {
			tableGV.addRow(new String[] { "GV" + teacher.getMaGV(), teacher.getTenGV(), teacher.getNgaySinhGV(),
					teacher.getGioiTinhGV(), teacher.getQueQuanGV(), teacher.getSDTGV(), teacher.getTrinhDo(),
					teacher.getEmail(), teacher.getGhiChuGV() });
		}

	}

	// hàm loadDatabase cho bảng của tab lớp
	private void loadDataforTableLop() {
		tableLop.setRowCount(0);
		schoolDao = new SchoolDao();
		litsClass = schoolDao.getAllClassStudent();
		for (ClassStudent classStudent : litsClass) {
			tableLop.addRow(new String[] { "" + classStudent.getMaLop(), classStudent.getTenLop(),
					classStudent.getMaGiaoVien_lop(), classStudent.getTenGiaoVien_lop(), classStudent.getGhiChuLop() });
		}
	}

	// hàm loadDatabase cho bảng của tab điểm
	private void loadDataforTableDiem() {
		tableDiem.setRowCount(0);
		schoolDao = new SchoolDao();
		litsDiem = schoolDao.getAllDiem();
		for (Diem diem : litsDiem) {
			tableDiem.addRow(new String[] { "" + Integer.toString(diem.getMaHoSinh()), diem.getTenHocSinh_Diem(),
					diem.getMaLop(), diem.getTenLop_Diem(), diem.getMaMon(), diem.getTenMon_Diem(),
					Float.toString(diem.getDiem15P1()), Float.toString(diem.getDiem15P2()),
					Float.toString(diem.getDiem1T()), Float.toString(diem.getDiemHocKy1()),
					Float.toString(diem.getDiemHocKy2()), Float.toString(diem.getTongDiem()) });
		}
	}

	// hàm loadDatabase cho bảng của tab môn học
	private void loadDataforTableMon() {
		tableMon.setRowCount(0);
		schoolDao = new SchoolDao();
		litsMon = schoolDao.getAllMon();
		for (Mon mon : litsMon) {
			tableMon.addRow(new String[] { "" + mon.getMaMon_Mon(), mon.getTenMon_Mon(), mon.getMaGiaoVien_Mon(),
					mon.getTenGiaoVien_Mon(), mon.getGhiChuMon() });
		}
	}

	// hàm loadDatabase lên bảng trong tab học sinh khi tìm kiếm
	private void loadSearchHS() {
		tableHS.setRowCount(0);

		ArrayList<Student> searchStudent = schoolDao.searchStudent(txtSearchHS.getText());

		if (searchStudent.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên này không có trong danh sách", "ERROR!", 2);
		} else {
			for (Student student : searchStudent) {
				tableHS.addRow(new String[] { "HS" + student.getMaHocSinh(), student.getTenHocSinh(),
						student.getNgaySinhHS(), student.getGioiTinhHS(), student.getQueQuanHS(),
						student.getSDTHocSinh(), student.getMaLop(), student.getHoTenCha(), student.getHoTenMe(),
						student.getSDTPhuHuynh(), student.getDiaChiLienHe(), student.getTenLop(),
						student.getGhiChuHS() });
			}
		}
	}

	// hàm loadDatabase lên bảng trong tab giáo viên khi tìm kiếm
	private void loadSearchGV() {
		tableGV.setRowCount(0);

		ArrayList<Teacher> searchTeacher = schoolDao.searchTeacher(txtSearchGV.getText());

		if (searchTeacher.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên này không có trong danh sách", "ERROR!", 2);
		} else {
			for (Teacher teacher : searchTeacher) {
				tableGV.addRow(new String[] { "GV" + teacher.getMaGV(), teacher.getTenGV(), teacher.getNgaySinhGV(),
						teacher.getGioiTinhGV(), teacher.getQueQuanGV(), teacher.getSDTGV(), teacher.getTrinhDo(),
						teacher.getEmail(), teacher.getGhiChuGV() });
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnThemHS) {
			checkValue();
			addStudent();
			loadDataforTableHS();
		} else if (action == btnSuaHS) {
			updateStudent();
			loadDataforTableHS();
		} else if (action == btnXoaHS) {
			deleteStudent();
			loadDataforTableHS();
		} else if (action == btnLamMoiHS) {
			cleanStudent();
			loadDataforTableHS();
		} else if (action == btnSearchHS) {
			loadSearchHS();
		} else if (action == btnThemGV) {
			checkValueGV();
			boolean check = checkValueGV();
			if (check == true) {
				addTeacher();
			}
			loadDataforTableGV();
		} else if (action == btnSuaGV) {
			updateTeacher();
			loadDataforTableGV();
		} else if (action == btnXoaGV) {
			deleteTeacher();
			loadDataforTableGV();
		} else if (action == btnLamMoiGV) {
			cleanTeacher();
			loadDataforTableGV();
		} else if (action == btnSearchGV) {
			loadSearchGV();
		} else if (action == btnThemLop) {
			checkValueLop();
			boolean checkLop = checkValueLop();
			if (checkLop == true) {
				checkIdLopAndIdGV();
				boolean idLop = checkIdLopAndIdGV();
				if (idLop == true) {
					JOptionPane.showMessageDialog(null, "Id Không Được Trùng Hoặc Giáo Viên Không Được Trùng");
				} else {
					addClassStudent();
				}
			}
			comboBoxHS.removeAllItems();
			getIdLop();
			loadDataforTableLop();
		} else if (action == btnSuaLop) {
			updateClassStudent();
			loadDataforTableLop();
		} else if (action == btnXoaLop) {
			deleteClassStudent();
			comboBoxHS.removeAllItems();
			getIdLop();
			loadDataforTableLop();
		} else if (action == btnLamMoiLop) {
			cleanLop();
		} else if (action == btnThemDiem) {
			checkValueDiem();
			boolean checkDiem = checkValueDiem();
			if (checkDiem == true) {
				checkIdDiemAndMon();
				boolean idDiemAndMon = checkIdDiemAndMon();
				if (idDiemAndMon == true) {
					JOptionPane.showMessageDialog(null, "Điểm Của Môn Này Đã Tồn Tại");
				} else {
					addDiem();
				}
			}
			loadDataforTableDiem();
		} else if (action == btnSuaDiem) {
			updateDiem();
			loadDataforTableDiem();
		} else if (action == btnXoaDiem) {
			deleteDiem();
			loadDataforTableDiem();
		} else if (action == btnLamMoiDiem) {
			cleanDiem();
		} else if (action == btnThemMon) {
			checkValueMon();
			boolean checkMon = checkValueMon();
			if (checkMon == true) {
				checkIdMon();
				boolean idMonAndGV = checkIdMon();
				if (idMonAndGV == true) {
					JOptionPane.showMessageDialog(null, "Môn Này Đã Tồn Tại");
				} else {
					addMon();
				}
			}
			loadDataforTableMon();
		} else if (action == btnSuaMon) {
			updateMon();
			loadDataforTableMon();
		} else if (action == btnXoaMon) {
			deleteMon();
			loadDataforTableMon();
		} else {
			cleanMon();
		}

	}

	// các hàm add của phầm mền
	public void addStudent() {
		Student student = new Student();

		student.setTenHocSinh(txtHTenHS.getText());
		student.setNgaySinhHS(txtNgSinh.getText());
		if (rdbtnNam.isSelected()) {
			student.setGioiTinhHS("Nam");
		} else {
			student.setGioiTinhHS("Nữ");
		}
		student.setQueQuanHS(txtQuQuan.getText());
		student.setSDTHocSinh(txtSDTHS.getText());
		student.setMaLop(comboBoxHS.getSelectedItem().toString());
		student.setHoTenCha(txtTenCha.getText());
		student.setHoTenMe(txtTenMe.getText());
		student.setSDTPhuHuynh(txtSDTPhHuynh.getText());
		student.setDiaChiLienHe(txtDiaChi.getText());
		student.setTenLop(txtTenLop.getText());
		student.setGhiChuHS(txtGhChuHS.getText());

		schoolDao.addStudentDao(student);

	}

	public void addTeacher() {
		Teacher teacher = new Teacher();

		teacher.setTenGV(txtHTenGV.getText());
		teacher.setNgaySinhGV(txtNgSinhGV.getText());
		if (radioNam.isSelected()) {
			teacher.setGioiTinhGV("Nam");
		} else {
			teacher.setGioiTinhGV("Nữ");
		}
		teacher.setQueQuanGV(txtQuQuanGV.getText());
		teacher.setSDTGV(txtSDTGV.getText());
		teacher.setTrinhDo(txtTrinhDo.getText());
		teacher.setEmail(txtEmail.getText());
		teacher.setGhiChuGV(txtGhChuGV.getText());

		schoolDao.addTeacherDao(teacher);
	}

	public void addClassStudent() {
		ClassStudent classStudent = new ClassStudent();

		classStudent.setMaLop(txtMaLopHoc.getText());
		classStudent.setTenLop(txtTenLopHoc.getText());
		classStudent.setMaGiaoVien_lop(txtMaGiaoVien.getText());
		classStudent.setTenGiaoVien_lop(txtTenGiaoVien.getText());
		classStudent.setGhiChuLop(txtGhiChuLop.getText());

		schoolDao.addClassStudentDao(classStudent);
	}

	public void addDiem() {
		Diem diem = new Diem();

		diem.setMaHoSinh(Integer.parseInt(txtMaHocSinh_Diem.getText()));
		diem.setTenHocSinh_Diem(txtTenHocSinh_Diem.getText());
		diem.setMaLop(txtMaLop_Diem.getText());
		diem.setTenLop_Diem(txtTenLop_Diem.getText());
		diem.setMaMon(txtMaMon_Diem.getText());
		diem.setTenMon_Diem(txtTenMon_Diem.getText());
		diem.setDiem15P1(Float.parseFloat(txtDiem15p1.getText()));
		diem.setDiem15P2(Float.parseFloat(txtDiem15p2.getText()));
		diem.setDiem1T(Float.parseFloat(txtDiem1T.getText()));
		diem.setDiemHocKy1(Float.parseFloat(txtDiemKi1.getText()));
		diem.setDiemHocKy2(Float.parseFloat(txtDiemKi2.getText()));
		Float a = Float.parseFloat(txtDiem15p1.getText());
		Float b = Float.parseFloat(txtDiem15p2.getText());
		Float c = Float.parseFloat(txtDiem1T.getText());
		Float d = Float.parseFloat(txtDiemKi1.getText());
		Float e = Float.parseFloat(txtDiemKi2.getText());
		diem.setTongDiem((a + b + (c * 2) + (d * 3) + (e * 3)) / 10);

		schoolDao.addDiemDao(diem);
	}

	public void addMon() {
		Mon mon = new Mon();

		mon.setMaMon_Mon(txtMaMon_Mon.getText());
		mon.setTenMon_Mon(txtTenMon_Mon.getText());
		mon.setMaGiaoVien_Mon(txtMaGiaoVien_Mon.getText());
		mon.setTenGiaoVien_Mon(txtTenGiaoVien_Mon.getText());
		mon.setGhiChuMon(txtGhiChuMon.getText());

		schoolDao.addMonDao(mon);
	}

	// các hàm update của phần mền
	public void updateStudent() {
		Student student = new Student();

		student.setMaHocSinh(txtMaHS.getText());
		String outputUpdateHS[] = student.getMaHocSinh().split("HS");
		String maUpHS = outputUpdateHS[1];
		student.setMaHocSinh(maUpHS);
		student.setTenHocSinh(txtHTenHS.getText());
		student.setNgaySinhHS(txtNgSinh.getText());
		if (rdbtnNam.isSelected()) {
			student.setGioiTinhHS("Nam");
		} else {
			student.setGioiTinhHS("Nữ");
		}
		student.setQueQuanHS(txtQuQuan.getText());
		student.setSDTHocSinh(txtSDTHS.getText());
		student.setMaLop(comboBoxHS.getSelectedItem().toString());
		student.setHoTenCha(txtTenCha.getText());
		student.setHoTenMe(txtTenMe.getText());
		student.setSDTPhuHuynh(txtSDTPhHuynh.getText());
		student.setDiaChiLienHe(txtDiaChi.getText());
		student.setTenLop(txtTenLop.getText());
		student.setGhiChuHS(txtGhChuHS.getText());

		schoolDao.updateStusentDao(student);
	}

	public void updateTeacher() {
		Teacher teacher = new Teacher();

		teacher.setMaGV(txtMaGV.getText());
		String outputUpdateGV[] = teacher.getMaGV().split("GV");
		String maUpGV = outputUpdateGV[1];
		teacher.setMaGV(maUpGV);
		teacher.setTenGV(txtHTenGV.getText());
		teacher.setNgaySinhGV(txtNgSinhGV.getText());
		if (radioNam.isSelected()) {
			teacher.setGioiTinhGV("Nam");
		} else {
			teacher.setGioiTinhGV("Nữ");
		}
		teacher.setQueQuanGV(txtQuQuanGV.getText());
		teacher.setSDTGV(txtSDTGV.getText());
		teacher.setTrinhDo(txtTrinhDo.getText());
		teacher.setEmail(txtEmail.getText());
		teacher.setGhiChuGV(txtGhChuGV.getText());

		schoolDao.updateTeacherDao(teacher);
	}

	public void updateClassStudent() {
		ClassStudent classStudent = new ClassStudent();

		classStudent.setMaLop(txtMaHocSinh_Diem.getText());
		classStudent.setTenLop(txtTenHocSinh_Diem.getText());
		classStudent.setMaGiaoVien_lop(txtMaGiaoVien.getText());
		classStudent.setTenGiaoVien_lop(txtTenGiaoVien.getText());
		classStudent.setGhiChuLop(txtGhiChuLop.getText());

		schoolDao.updateClassStudentDao(classStudent);
	}

	public void updateDiem() {
		Diem diem = new Diem();

		diem.setMaHoSinh(Integer.parseInt(txtMaHocSinh_Diem.getText()));
		diem.setTenHocSinh_Diem(txtTenHocSinh_Diem.getText());
		diem.setMaLop(txtMaLop_Diem.getText());
		diem.setTenLop_Diem(txtTenLop_Diem.getText());
		diem.setMaMon(txtMaMon_Diem.getText());
		diem.setTenMon_Diem(txtTenMon_Diem.getText());
		diem.setDiem15P1(Float.parseFloat(txtDiem15p1.getText()));
		diem.setDiem15P2(Float.parseFloat(txtDiem15p2.getText()));
		diem.setDiem1T(Float.parseFloat(txtDiem1T.getText()));
		diem.setDiemHocKy1(Float.parseFloat(txtDiemKi1.getText()));
		diem.setDiemHocKy2(Float.parseFloat(txtDiemKi2.getText()));
		Float a = Float.parseFloat(txtDiem15p1.getText());
		Float b = Float.parseFloat(txtDiem15p2.getText());
		Float c = Float.parseFloat(txtDiem1T.getText());
		Float d = Float.parseFloat(txtDiemKi1.getText());
		Float e = Float.parseFloat(txtDiemKi2.getText());
		diem.setTongDiem((a + b + (c * 2) + (d * 3) + (e * 3)) / 10);

		schoolDao.updateDiemDao(diem);
	}

	public void updateMon() {
		Mon mon = new Mon();

		mon.setMaMon_Mon(txtMaMon_Mon.getText());
		mon.setTenMon_Mon(txtTenMon_Mon.getText());
		mon.setMaGiaoVien_Mon(txtMaGiaoVien_Mon.getText());
		mon.setTenGiaoVien_Mon(txtTenGiaoVien_Mon.getText());
		mon.setGhiChuMon(txtGhiChuMon.getText());

		schoolDao.updateMonDao(mon);
	}

	// các hàm xóa của phần mền
	public void deleteStudent() {
		String maHocSinh = (String) jtableHS.getValueAt(jtableHS.getSelectedRow(), 0);
		String outputDeleHS[] = maHocSinh.split("HS");
		String mahs = outputDeleHS[1];
		schoolDao.deleteStudentDao(mahs);
	}

	public void deleteTeacher() {
		String maGiaoVien = (String) jtableGV.getValueAt(jtableGV.getSelectedRow(), 0);
		String outputDeleGV[] = maGiaoVien.split("GV");
		String maGV = outputDeleGV[1];
		schoolDao.deleteTeacherDao(maGV);
	}

	public void deleteClassStudent() {
		String maLop = (String) jtableLop.getValueAt(jtableLop.getSelectedRow(), 0);
		schoolDao.deleteClassStudentDao(maLop);
	}

	public void deleteDiem() {
		String maHocSinh = (String) jtableDiem.getValueAt(jtableDiem.getSelectedRow(), 0);
		String maMonHoc = (String) jtableDiem.getValueAt(jtableDiem.getSelectedRow(), 5);
		schoolDao.deleteDiemDao(maHocSinh, maMonHoc);
	}

	public void deleteMon() {
		String maMonHoc = (String) jtableMon.getValueAt(jtableMon.getSelectedRow(), 0);
		schoolDao.deleteMonDao(maMonHoc);
	}

	// các hàm clean của phần mền
	public void cleanStudent() {
		txtMaHS.setText("");
		txtHTenHS.setText("");
		txtNgSinh.setText("");
		group.clearSelection();
		txtQuQuan.setText("");
		txtSDTHS.setText("");
		comboBoxHS.setSelectedItem("");
		txtTenCha.setText("");
		txtTenMe.setText("");
		txtSDTPhHuynh.setText("");
		txtDiaChi.setText("");
		txtTenLop.setText("");
		txtGhChuHS.setText("");
		txtSearchHS.setText("");

		if (txtHTenHS.getText().length() == 0) {
			lblFixHS2.setVisible(false);
		}
		if (txtNgSinh.getText().length() == 0) {
			lblFixHS3.setVisible(false);
		}
		if (group.getSelection() == null) {
			lblFixHS4.setVisible(false);
		}
		if (txtQuQuan.getText().length() == 0) {
			lblFixHS5.setVisible(false);
		}
		if (comboBoxHS.getSelectedItem().toString().length() < 1) {
			lblFixHS6.setVisible(false);
		}
		if (txtDiaChi.getText().length() == 0) {
			lblFixHS8.setVisible(false);
		}

		btnThemHS.setEnabled(true);
	}

	public void cleanTeacher() {
		txtMaGV.setText("");
		txtHTenGV.setText("");
		txtNgSinhGV.setText("");
		groupGV.clearSelection();
		txtQuQuanGV.setText("");
		txtSDTGV.setText("");
		txtTrinhDo.setText("");
		txtEmail.setText("");
		txtGhChuGV.setText("");
		txtSearchGV.setText("");

		if (txtNgSinhGV.getText().length() == 0) {
			lblFixGV2.setVisible(false);
		}
		if (groupGV.getSelection() == null) {
			lblFixGV1.setVisible(false);
		}
		if (txtHTenGV.getText().length() == 0) {
			lblFixGV3.setVisible(false);
		}
		if (txtQuQuanGV.getText().length() == 0) {
			lblFixGV4.setVisible(false);
		}
		if (txtSDTGV.getText().length() == 0) {
			lblFixGV5.setVisible(false);
		}
		if (txtTrinhDo.getText().length() == 0) {
			lblFixGV6.setVisible(false);
		}

		btnThemGV.setEnabled(true);
	}

	private void cleanLop() {
		txtMaLopHoc.setText("");
		txtTenLopHoc.setText("");
		txtMaGiaoVien.setText("");
		txtTenGiaoVien.setText("");

		if (txtMaLopHoc.getText().length() == 0) {
			lblFixLop1.setVisible(false);
		}
		if (txtTenLopHoc.getText().length() == 0) {
			lblFixLop2.setVisible(false);
		}
		if (txtMaGiaoVien.getText().length() == 0) {
			lblFixLop3.setVisible(false);
		}

		txtMaLopHoc.setEnabled(true);
		btnThemLop.setEnabled(true);
	}

	private void cleanDiem() {

		txtMaHocSinh_Diem.setText("");
		txtTenHocSinh_Diem.setText("");
		txtMaLop_Diem.setText("");
		txtTenLop_Diem.setText("");
		txtMaMon_Diem.setText("");
		txtTenMon_Diem.setText("");
		txtDiem15p1.setText("");
		txtDiem15p2.setText("");
		txtDiem1T.setText("");
		txtDiemKi1.setText("");
		txtDiemKi2.setText("");
		txtTongDiem.setText("");

		if (txtMaHocSinh_Diem.getText().length() == 0) {
			lblFixDiem1.setVisible(false);
		}
		if (txtMaMon_Diem.getText().length() == 0) {
			lblFixDiem2.setVisible(false);
		}

		btnThemDiem.setEnabled(true);
		txtMaHocSinh_Diem.setEnabled(true);
	}

	private void cleanMon() {
		txtMaMon_Mon.setText("");
		txtTenMon_Mon.setText("");
		txtMaGiaoVien_Mon.setText("");
		txtTenGiaoVien_Mon.setText("");
		txtGhiChuMon.setText("");

		if (txtMaMon_Mon.getText().length() == 0) {
			lblFixMon1.setVisible(false);
		}
		if (txtTenMon_Mon.getText().length() == 0) {
			lblFixMon2.setVisible(false);
		}
		if (txtMaGiaoVien_Mon.getText().length() == 0) {
			lblFixMon3.setVisible(false);
		}

		txtMaMon_Mon.setEnabled(true);
		btnThemMon.setEnabled(true);
	}

	// các hàm checkvalue dùng để ràng buộc 1 số ô phải có dữ liệu
	public void checkValue() {
		if (txtHTenHS.getText().length() == 0) {
			lblFixHS2.setVisible(true);
		}
		if (txtNgSinh.getText().length() == 0) {
			lblFixHS3.setVisible(true);
		}
		if (group.getSelection() == null) {
			lblFixHS4.setVisible(true);
		}
		if (txtQuQuan.getText().length() == 0) {
			lblFixHS5.setVisible(true);
		}
		if (comboBoxHS.getSelectedItem().toString().length() < 1) {
			lblFixHS6.setVisible(true);
		}
		if (txtDiaChi.getText().length() == 0) {
			lblFixHS8.setVisible(true);
		}
	}

	public boolean checkValueGV() {
		boolean flagGV = true;
		if (txtNgSinhGV.getText().length() == 0) {
			lblFixGV2.setVisible(true);
			flagGV = false;
		}
		if (groupGV.getSelection() == null) {
			lblFixGV1.setVisible(true);
		}
		if (txtHTenGV.getText().length() == 0) {
			lblFixGV3.setVisible(true);
		}
		if (txtQuQuanGV.getText().length() == 0) {
			lblFixGV4.setVisible(true);
		}
		if (txtSDTGV.getText().length() == 0) {
			lblFixGV5.setVisible(true);
		}
		if (txtTrinhDo.getText().length() == 0) {
			lblFixGV6.setVisible(true);
		}
		return flagGV;
	}

	public boolean checkValueLop() {
		boolean flagLop = true;
		if (txtMaLopHoc.getText().length() == 0) {
			lblFixLop1.setVisible(true);
			flagLop = false;
		}
		if (txtTenLopHoc.getText().length() == 0) {
			lblFixLop2.setVisible(true);
		}
		if (txtMaGiaoVien.getText().length() == 0) {
			lblFixLop3.setVisible(true);
		}
		return flagLop;
	}

	public boolean checkValueDiem() {
		boolean flagDiem = true;
		if (txtMaHocSinh_Diem.getText().length() == 0) {
			lblFixDiem1.setVisible(true);
			flagDiem = false;
		}
		if (txtMaMon_Diem.getText().length() == 0) {
			lblFixDiem2.setVisible(true);
		}
		return flagDiem;
	}

	public boolean checkValueMon() {
		boolean flagMon = true;
		if (txtMaMon_Mon.getText().length() == 0) {
			lblFixMon1.setVisible(true);
			flagMon = false;
		}
		if (txtTenMon_Mon.getText().length() == 0) {
			lblFixMon2.setVisible(true);
		}
		if (txtMaGiaoVien_Mon.getText().length() == 0) {
			lblFixMon3.setVisible(true);
		}
		return flagMon;
	}

	// hàm checkIdLopAndIdGV dùng để ràng buộc ko được trùng id lớp trong tab lớp
	// hoặc id giáo viên trong tab lớp
	public boolean checkIdLopAndIdGV() {
		boolean checkIdLopAndIdGV = false;
		for (ClassStudent classStudent : litsClass) {
			if (txtMaLopHoc.getText().toString().equalsIgnoreCase(classStudent.getMaLop().toString()) == true
					|| txtMaGiaoVien.getText().toString()
							.equalsIgnoreCase(classStudent.getMaGiaoVien_lop().toString()) == true) {
				checkIdLopAndIdGV = true;
			}
		}
		return checkIdLopAndIdGV;
	}

	// hàm checkIdDiemAndMon dùng để ràng buộc ko được trùng id học sinh trong tab
	// điểm và id môn trong tab điểm
	public boolean checkIdDiemAndMon() {
		boolean checkDiemAndMon = false;
		for (Diem diem : litsDiem) {
			if (txtMaHocSinh_Diem.getText().toString().equals(Integer.toString(diem.getMaHoSinh())) == true
					&& txtMaMon_Diem.getText().toString().equals(diem.getMaMon().toString()) == true) {
				checkDiemAndMon = true;
			}
		}
		return checkDiemAndMon;
	}

	// hàm checkIdMon dùng để ràng buộc ko được trùng id môn trong tab môn
	public boolean checkIdMon() {
		boolean checkIdMon = false;
		for (Mon mon : litsMon) {
			if (txtMaMon_Mon.getText().toString().equals(mon.getMaMon_Mon()) == true) {
				checkIdMon = true;
			}
		}
		return checkIdMon;
	}

	// các hàm removeCheck dùng để remove hàm checkValue
	private void removeCheck() {
		if (txtHTenHS.getText().length() != 0) {
			lblFixHS2.setVisible(false);
		}
		if (txtNgSinh.getText().length() != 0) {
			lblFixHS3.setVisible(false);
		}
		if (group.getSelection() != null) {
			lblFixHS4.setVisible(false);
		}
		if (txtQuQuan.getText().length() != 0) {
			lblFixHS5.setVisible(false);
		}
		if (comboBoxHS.getSelectedItem().toString().length() > 1) {
			lblFixHS6.setVisible(false);
		}
		if (txtDiaChi.getText().length() != 0) {
			lblFixHS8.setVisible(false);
		}
	}

	private void removeCheckGV() {
		if (txtNgSinhGV.getText().length() != 0) {
			lblFixGV2.setVisible(false);
		}
		if (groupGV.getSelection() != null) {
			lblFixGV1.setVisible(false);
		}
		if (txtHTenGV.getText().length() != 0) {
			lblFixGV3.setVisible(false);
		}
		if (txtQuQuanGV.getText().length() != 0) {
			lblFixGV4.setVisible(false);
		}
		if (txtSDTGV.getText().length() != 0) {
			lblFixGV5.setVisible(false);
		}
		if (txtTrinhDo.getText().length() != 0) {
			lblFixGV6.setVisible(false);
		}
	}

	private void removeCheckLop() {
		if (txtMaLopHoc.getText().length() != 0) {
			lblFixLop1.setVisible(false);
		}
		if (txtTenLopHoc.getText().length() != 0) {
			lblFixLop2.setVisible(false);
		}
		if (txtMaGiaoVien.getText().length() != 0) {
			lblFixLop3.setVisible(false);
		}
	}

	private void removeCheckDiem() {
		if (txtMaHocSinh_Diem.getText().length() != 0) {
			lblFixDiem1.setVisible(false);
		}
		if (txtMaMon_Diem.getText().length() != 0) {
			lblFixDiem2.setVisible(false);
		}
	}

	private void removeCheckMon() {
		if (txtMaMon_Mon.getText().length() != 0) {
			lblFixMon1.setVisible(false);
		}
		if (txtTenMon_Mon.getText().length() != 0) {
			lblFixMon2.setVisible(false);
		}
		if (txtMaGiaoVien_Mon.getText().length() != 0) {
			lblFixMon3.setVisible(false);
		}
	}

	// hàm này dùng để load id lớp mới nhập lên combobox
	public void getIdLop() {

		String sql = "SELECT * FROM lop";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				// Display comboBox set from databse
				comboBoxHS.addItem(result.getString("malop"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
