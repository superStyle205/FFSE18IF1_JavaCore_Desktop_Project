package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import connect.ConnectUtil;
import dao.BangDiemDao;
import dao.Diem;
import dao.DiemDao;
import dao.Export;
import dao.GiaoVien;
import dao.GiaoVienDao;
import dao.HocSinh;
import dao.HocSinhDao;
import dao.Login;
import dao.Lop;
import dao.LopDao;
import dao.Mon;
import dao.MonDao;
import dao.Print;
import dao.TimKiemDao;

public class FrMain extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frmMarkManagerSystem;
	
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel_1;
	private JTable table;
	private JTable table_1;
	private JScrollPane jScrollPane;
	private JScrollPane jScrollPane1;
	public JTabbedPane tabbedPane;
	
	private JPanel contentPane;
	public  JPanel quan_ly;
	public  JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_5;
	private JPanel panel_9;

	private JTextField txtId;
	private JTextField txtTenSv;
	private JTextField txtSdt;
	private JTextField txtDiaChi;
	private	JComboBox<Object> jcbMaLop;
	private	JComboBox<Object> jcbMaLopGv;
	private JComboBox<Object> jcbMonDay;
	
	private JTextField txtIdGv;
	private JTextField txtTenGv;
	private JTextField txtSdtGv;
	private JTextField txtEmailGv;
	
	
	private JTextField txt_Id;
	private JTextField txt_User;
	private JTextField txt_Pw;
	private JComboBox<Object>  jcb_Role;
	private JTextField txt_FullName;

	
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnReset;
	
	private JButton btnAddGv;
	private JButton btnUpdateGv;
	private JButton btnDeleteGv;
	private JButton btnClearGv;
	
	public JButton btnQlhs;
	public JButton btnQlgv;
	public JButton btnDiem;
	public JButton btnQlLop;
	public JButton btnQlMon;
	public JButton btnQLTaiKhoan;
	
	private JDateChooser txtNgaysinhHocSinh;
	private JDateChooser txtNgaysinhGv;
	private JRadioButton radioNam;
	private JRadioButton radioNu;
	private JRadioButton radioGvNam;
	private JRadioButton radioGvNu;

	private JInternalFrame internalFrame;
	private JInternalFrame internalFrame_1;
	private JInternalFrame internalFrame_2;
	private JInternalFrame internalFrame_3;
	private JInternalFrame internalFrame_4;
	private JInternalFrame internalFrame_5;
	
	private String user, id, hello;
	private float a, b, c;
	
	private JPanel panel_13;
	private JPanel panel_15;
	private JPanel panel_14;
	private JPanel panel_16;

	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;	
	private JPanel panel_21;
	private JPanel panel_20;
	private JPanel panel_22;
	
	// panel lớp 
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25
	;private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;

	private JTable tableAdmin;

	private JTable tableGV;
	private JTextField txtDiem45p;
	private JTextField txtDiemThi;
	private JTextField txtTongKet;

	private	JComboBox<Object> cbbMaLop;
	private JComboBox<Object> cbbMaHs;
	private JComboBox<Object> cbbMaMon;

	private JTextField txtTenMon;
	private JTextField txtDiem15p;

	private DefaultTableModel tableModel_2;
	private DefaultTableModel tableModel_3;
	private DefaultTableModel tableModel_4;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	private JScrollPane scrollPaneDiem;

	private JButton btnThemDiem;
	private JButton btnUpdateDiem;
	private JButton btnDeleteDiem;
	private JButton btnClearDiem;

	private JRadioButton rdbDat;
	private JRadioButton rdbKhongDat;
	private JPanel panel_29;
		
	private JButton btnUpdateLop;
	private JButton btnAddlop;
	private JButton btnDeleteLop;
	private JButton btnClearLop;

	private JTextField txtLop;
	private JTextField txtIdLop;
	
	private JButton btnAddMon;
	private JButton btnUpdateMon;
	private JButton btnDeleteMon;
	private JButton btnClearMon;
	
	private JTextField txtIdMon;
	private JTextField txtMon;

	
	public  JPanel panel_30;
	private JPanel panel_31;
	private JPanel panel_32;
	private JPanel panel_33;
	private JPanel panel_34;
	private JPanel panel_35;
	private JPanel panel_36;
	
	
	private JPanel panel_37;
	private JPanel panel_38;

	private JScrollPane scrollPaneXemDiem;
	private JLabel lblBangDiem;


	private JTable table_Bangdiem;
	private JTextField txtSearch;
	private JLabel lblSearch;

	private JTextField txtTimKiem;
	private JComboBox<Object> cbbTimKiem;

	private JTable table_Searchsinhvien;
	private JTable table_Searchgiaovien;
	private JTable table_Searchlop;
	private JTable table_Searchmon;
	


	HocSinhDao hocsinhDao = new HocSinhDao();
	HocSinh hocsinh = new HocSinh();
	
	GiaoVienDao giaovienDao = new GiaoVienDao();
	GiaoVien giaovien = new GiaoVien();
	
	Diem diem = new Diem();
	DiemDao diemDao = new DiemDao();
	
	Lop lop = new Lop();
	LopDao lopDao = new LopDao();
	
	Mon mon = new Mon ();
	MonDao monDao = new MonDao();
	
	BangDiemDao bangdiemDao = new BangDiemDao();
	
	TimKiemDao timkiemDAO = new TimKiemDao();







	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		FrMain mainForm = new FrMain();
//		mainForm.setVisible(true);
//
//	}

	/**
	 * Create the frame.
	 */
	
	public FrMain(Login a) {
		
		FrMain();
		user = a.getUser();
		id = a.getId();
		hello = a.getHello();
		
		JLabel txtManager = new JLabel("");
		txtManager.setFont(new Font("Arial", Font.BOLD, 27));
		txtManager.setForeground(new Color(220, 20, 60));
		panel_1.add(txtManager);
		txtManager.setText(hello);
		
		// Quan ly
		JLabel lblUser = new JLabel("");
		lblUser.setFont(new Font("Arial", Font.BOLD, 20));
		lblUser.setForeground(new Color(0, 0, 128));
		panel_1.add(lblUser);
		lblUser.setText(user + " " + id);
		
		
		
		 //Bang diem
		JLabel txtChaobanBD = new JLabel("");
		txtChaobanBD.setFont(new Font("Arial", Font.BOLD, 15));
		txtChaobanBD.setForeground(new Color(220, 20, 60));
		txtChaobanBD.setIcon(new ImageIcon("icon\\community-users-icon-1.png"));
		txtChaobanBD.setBounds(24, 20, 308, 35);
		panel_30.add(txtChaobanBD);
		txtChaobanBD.setText(hello);

		JLabel txtTenBD = new JLabel("");
		txtTenBD.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTenBD.setForeground(new Color(0, 0, 128));
		txtTenBD.setBounds(50, 50, 256, 26);
		panel_30.add(txtTenBD);
		txtTenBD.setText(user + " " + id);
		
	//	 Tim kiem
		JLabel txtChaobanTK = new JLabel("");
		txtChaobanTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtChaobanTK.setForeground(new Color(220, 20, 60));
		txtChaobanTK.setBounds(24, 40, 308, 35);
		panel_32.add(txtChaobanTK);
		txtChaobanTK.setIcon(new ImageIcon("icon\\community-users-icon-1.png"));
		txtChaobanTK.setText(hello);

		JLabel txtTenTK = new JLabel("");
		txtTenTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTenTK.setForeground(new Color(0, 0, 128));
		txtTenTK.setBounds(50, 65, 256, 26);
		panel_32.add(txtTenTK);
		txtTenTK.setText(user + " " + id);
		
		internalFrame.setVisible(true);
	}

//	public FrMain() {
//		// TODO Auto-generated constructor stub
//		FrMain();
//	}

	public void FrMain() {
		
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500, 1000);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// thông báo có muốn thoát chương trình hay không

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				int hoi = JOptionPane.showConfirmDialog(null, "                 Thoát hả?", null,
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 128)); // màu chữ Trang chủ
		getContentPane().add(tabbedPane);

		// tab Trang Chủ

		JPanel trang_chu = new JPanel();
		tabbedPane.addTab("Trang Chủ", new ImageIcon("icon\\Home-icon.png"),
				trang_chu, null);
		trang_chu.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1459, 831);
		trang_chu.add(panel);

		JLabel label = new JLabel("");
		// label.setBounds(690, 39, 484, 140);
		label.setIcon(new ImageIcon("icon\\fpt-logo.png"));
		panel.add(label);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 1183, 656);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon(" icon\\background-trong.png"));
		
		JPanel panel_40 = new JPanel();
		panel_40.setBackground(SystemColor.inactiveCaption);
		panel_40.setBounds(10, 853, 1459, 69);
		trang_chu.add(panel_40);
		panel_40.setLayout(null);
		
		JButton btnDangxuat = new JButton("Đăng Xuất");
		btnDangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DangXuat();
				}
		});
		btnDangxuat.setFont(new Font("Arial", Font.BOLD, 20));
		btnDangxuat.setBounds(1278, 11, 171, 47);
		panel_40.add(btnDangxuat);

		// tab QUẢN LÝ

		quan_ly = new JPanel();
		tabbedPane.addTab("Quản lý",
				new ImageIcon("icon\\Control-Panel-icon (1).png"), quan_ly,
				null);
		quan_ly.setLayout(null);
		quan_ly.setBounds(10, 11, 293, 122);

		panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 11, 293, 122);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		quan_ly.add(panel_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("icon\\BarTender.png"));
		panel_1.add(label_2);


		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(10, 144, 293, 758);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		quan_ly.add(panel_2);
		panel_2.setLayout(null);
		
		btnQlhs = new JButton("Quản Lý Học Sinh");
		btnQlhs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(true);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
			}
		});
		btnQlhs.setFont(new Font("Arial", Font.BOLD, 20));
		btnQlhs.setBounds(10, 37, 273, 76);
		btnQlhs.setIcon(new ImageIcon("icon\\Buddypress-icon.png"));
		panel_2.add(btnQlhs);

		panel_3 = new JPanel();
		panel_3.setBounds(313, 144, 1146, 758);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		quan_ly.add(panel_3);
		panel_3.setLayout(null);

		// internalFrame QUẢN LÝ HỌC SINH
		
		internalFrame = new JInternalFrame("Quản lý học sinh");
		internalFrame.setBounds(10, 11, 1126, 736);
		panel_3.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBounds(0, 0, 934, 29);
		internalFrame.getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnFile.setIcon(new ImageIcon("icon\\folder-documents-icon (1).png"));
		menuBar.add(mnFile);

		JMenu mnExport = new JMenu("Export");
		mnExport.setIcon(new ImageIcon("icon\\Save-icon.png"));
		mnFile.add(mnExport);

		JMenuItem mntmExcel = new JMenuItem("Excel ");
		mntmExcel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table);
			}
		});
		mntmExcel.setIcon(
				new ImageIcon("icon\\MS-Office-2003-Excel-icon.png"));
		mnExport.add(mntmExcel);

		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table, "Danh Sách Sinh Viên");
			}
		});
		mntmPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint.setIcon(new ImageIcon("icon\\Print-icon.png"));
		mnFile.add(mntmPrint);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(0, 29, 1110, 35);
		internalFrame.getContentPane().add(panel_4);

		JLabel lblThongTinSV = new JLabel("Thông Tin Sinh Viên");
		lblThongTinSV.setForeground(new Color(0, 0, 0)); // màu chữ
		lblThongTinSV.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblThongTinSV);

		
		tableModel = new DefaultTableModel();
		
		tableModel.addColumn("ID học sinh");
		tableModel.addColumn("Tên học sinh");
		tableModel.addColumn("ID lớp");
		tableModel.addColumn("Ngày sinh");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("Số điện thoại");
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row = table.getSelectedRow();

					txtId.             setText((String) table.getValueAt(row, 0));
					txtTenSv.            setText((String) table.getValueAt(row, 1));
					jcbMaLop.  		 setSelectedItem((String) table.getValueAt(row, 2));

					Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row, 3));
					txtNgaysinhHocSinh.  setDate((Date) date);	
					
					txtDiaChi.           setText((String) table.getValueAt(row, 4));
					
					if (table.getValueAt(row, 5).toString().contains("Nam")) {
						radioNam.setSelected(true);
						radioNu.setSelected(false);
					}else if (table_1.getValueAt(row, 5).toString().contains("Nữ")) {
						radioNu.setSelected(true);
						radioNam.setSelected(false);
					}
					
					txtSdt.    		  setText((String) table.getValueAt(row, 6));
					
				} catch (Exception e) {
					
				}
			}
		});
		
		
		jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 73, 1090, 321);
		internalFrame.getContentPane().add(jScrollPane);
		
		loadDataForTable();
		
		panel_5 = new JPanel();
		panel_5.setBounds(10, 403, 848, 44);
		internalFrame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnSelect = new JButton("Select All");
		btnSelect.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSelect.setBounds(0, 0, 144, 44);
		btnSelect.setIcon(new ImageIcon("icon\\Select-icon.png"));
		panel_5.add(btnSelect);
		
		JButton btnUnselect = new JButton("Unselect ");
		btnUnselect.setFont(new Font("Arial", Font.PLAIN, 15));
		btnUnselect.setBounds(154, 0, 144, 44);
		btnUnselect.setIcon(new ImageIcon("icon\\close-icon.png"));
		panel_5.add(btnUnselect);
		
		JButton btnAZ = new JButton("A - Z");
		btnAZ.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAZ.setBounds(550, 0, 144, 44);
		btnAZ.setIcon(new ImageIcon("icon\\sort-ascending-icon.png"));
		panel_5.add(btnAZ);
		
		JButton btnZA = new JButton("Z - A");
		btnZA.setFont(new Font("Arial", Font.PLAIN, 15));
		btnZA.setBounds(704, 0, 144, 44);
		btnZA.setIcon(new ImageIcon("icon\\sort-descending-icon.png"));
		panel_5.add(btnZA);
		
		
		JLabel lblSapXep = new JLabel("Sắp xếp");
		lblSapXep.setFont(new Font("Arial", Font.BOLD, 15));
		lblSapXep.setBounds(309, 0, 78, 44);
		panel_5.add(lblSapXep);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaption);
		panel_6.setBounds(868, 403, 232, 292);
		internalFrame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
		btnAdd.setBounds(36, 20, 169, 57);
		btnAdd.setIcon(new ImageIcon("icon\\add-icon.png"));
		panel_6.add(btnAdd);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
		btnUpdate.setBounds(36, 88, 169, 57);
		btnUpdate.setIcon(new ImageIcon("icon\\update-icon.png"));
		panel_6.add(btnUpdate);
		
		btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
		btnDelete.setBounds(36, 156, 169, 57);
		btnDelete.setIcon(new ImageIcon("icon/delete-icon.png"));
		panel_6.add(btnDelete);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setFont(new Font("Arial", Font.BOLD, 20));
		btnReset.setBounds(36, 224, 169, 57);
		btnReset.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		panel_6.add(btnReset);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaption);
		panel_7.setForeground(Color.BLACK);
		panel_7.setBounds(10, 458, 848, 237);
		internalFrame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 14));
		txtId.setBounds(115, 11, 187, 31);
		panel_7.add(txtId);
		txtId.setColumns(10);
		
		txtTenSv = new JTextField();
		txtTenSv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenSv.setColumns(10);
		txtTenSv.setBounds(115, 98, 187, 31);
		panel_7.add(txtTenSv);
		
		jcbMaLop = new JComboBox<>() ;
		jcbMaLop.setBounds(115, 180, 187, 31);
		panel_7.add(jcbMaLop);
		
		txtNgaysinhHocSinh =  new JDateChooser();
		txtNgaysinhHocSinh.setBounds(504, 11, 187, 31);
		txtNgaysinhHocSinh.setDateFormatString("yyyy-MM-dd");
		panel_7.add(txtNgaysinhHocSinh);
		
		radioNam = new JRadioButton("Nam");
		radioNam.setFont(new Font("Arial", Font.BOLD, 18));
		radioNam.setBackground(SystemColor.inactiveCaption);
		radioNam.setBounds(504, 125, 109, 31);
		panel_7.add(radioNam);
		
		radioNu = new JRadioButton("Nữ");
		radioNu.setFont(new Font("Arial", Font.BOLD, 18));
		radioNu.setBackground(SystemColor.inactiveCaption);
		radioNu.setBounds(614, 125, 109, 31);
		panel_7.add(radioNu);
		
	    ButtonGroup genderGroup = new ButtonGroup();
	    genderGroup.add(radioNam);
	    genderGroup.add(radioNu);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDiaChi.setBounds(504, 65, 187, 31);
		panel_7.add(txtDiaChi);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSdt.setBounds(504, 179, 187, 31);
		panel_7.add(txtSdt);
		
		JLabel lblMaHs = new JLabel("Mã học sinh");
		lblMaHs.setForeground(Color.BLUE);
		lblMaHs.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaHs.setBounds(10, 11, 107, 31);
		panel_7.add(lblMaHs);
		
		JLabel lblTenSv = new JLabel("Tên sinh viên:");
		lblTenSv.setForeground(Color.BLUE);
		lblTenSv.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenSv.setBounds(10, 98, 107, 31);
		panel_7.add(lblTenSv);
		
		JLabel lblMaLop = new JLabel("Mã lớp:");
		lblMaLop.setForeground(Color.BLUE);
		lblMaLop.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaLop.setBounds(10, 179, 107, 31);
		panel_7.add(lblMaLop);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setForeground(Color.BLUE);
		lblNgaySinh.setFont(new Font("Arial", Font.BOLD, 15));
		lblNgaySinh.setBounds(387, 11, 107, 31);
		panel_7.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 15));
		lblDiaChi.setBounds(387, 65, 107, 31);
		panel_7.add(lblDiaChi);
		
		JLabel lblGoiTinh = new JLabel("Giới tính:");
		lblGoiTinh.setForeground(Color.BLUE);
		lblGoiTinh.setFont(new Font("Arial", Font.BOLD, 15));
		lblGoiTinh.setBounds(387, 125, 107, 31);
		panel_7.add(lblGoiTinh);
		
		JLabel lblSoDt = new JLabel("Số điện thoại:");
		lblSoDt.setForeground(Color.BLUE);
		lblSoDt.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoDt.setBounds(387, 179, 107, 31);
		panel_7.add(lblSoDt);
		
		
		
		
		// Quản Lý Giáo Viên
		
		btnQlgv = new JButton("Quản Lý Giáo Viên");
		btnQlgv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(true);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
			}
		});
		btnQlgv.setFont(new Font("Arial", Font.BOLD, 20));
		btnQlgv.setBounds(10, 165, 273, 76);
		btnQlgv.setIcon(new ImageIcon("icon\\Carbonmade-icon.png"));
		panel_2.add(btnQlgv);
	
		
		internalFrame_1 = new JInternalFrame("Quản lý giáo viên");
		internalFrame_1.setBounds(10, 11, 1126, 736);
		panel_3.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.activeCaption);
		panel_8.setBounds(0, 29, 1110, 35);
		internalFrame_1.getContentPane().add(panel_8);
		
		JMenuBar menuBar1 = new JMenuBar();
		menuBar1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar1.setBounds(0, 0, 934, 29);
		internalFrame_1.getContentPane().add(menuBar1);

		JMenu mnFile1 = new JMenu("File");
		mnFile1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnFile1.setIcon(new ImageIcon("icon\\folder-documents-icon (1).png"));
		menuBar1.add(mnFile1);

		JMenu mnExport1 = new JMenu("Export");
		mnExport1.setIcon(new ImageIcon("icon\\Save-icon.png"));
		mnFile1.add(mnExport1);

		JMenuItem mntmExcel1 = new JMenuItem("Excel ");
		mntmExcel1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table);
			}
		});
		mntmExcel1.setIcon(
				new ImageIcon("icon\\MS-Office-2003-Excel-icon.png"));
		mnExport1.add(mntmExcel1);

		JMenuItem mntmPrint1 = new JMenuItem("Print");
		mntmPrint1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table, "Danh Sách Sinh Viên");
			}
		});
		mntmPrint1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint1.setIcon(new ImageIcon("C:\\Users\\Lonely\\workspace\\ProjectDTD\\icon\\Print-icon.png"));
		mnFile1.add(mntmPrint1);

		JMenuItem mntmExit1 = new JMenuItem("Exit");
		mnFile1.add(mntmExit1);
		
		JLabel lblThongTinGV = new JLabel("Thông Tin Giáo Viên");
		lblThongTinGV.setForeground(new Color(0, 0, 0)); // màu chữ
		lblThongTinGV.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_8.add(lblThongTinGV);
		
		tableModel_1 = new DefaultTableModel();
		
		tableModel_1.addColumn("ID giáo viên");
		tableModel_1.addColumn("Tên giáo viên");
		tableModel_1.addColumn("ID Môn");
		tableModel_1.addColumn("Id lớp");
		tableModel_1.addColumn("Ngày sinh");
		tableModel_1.addColumn("Giới tính");
		tableModel_1.addColumn("Email");
		tableModel_1.addColumn("Số điện thoại");

		
		table_1 = new JTable(tableModel_1);
		jScrollPane1 = new JScrollPane(table_1);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row = table_1.getSelectedRow();

					txtIdGv.             setText((String) table_1.getValueAt(row, 0));
					txtTenGv.            setText((String) table_1.getValueAt(row, 1));
					jcbMonDay.  		 setSelectedItem((String) table_1.getValueAt(row, 2));
					jcbMaLopGv.          setSelectedItem((String) table_1.getValueAt(row, 3));
					
					Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)table_1.getValueAt(row, 4));
					txtNgaysinhGv.  setDate((Date) date);	
					
					if (table_1.getValueAt(row, 5).toString().contains("Nam")) {
						radioGvNam.setSelected(true);
						radioGvNu.setSelected(false);
					}else if (table_1.getValueAt(row, 5).toString().contains("Nữ")) {
						radioGvNu.setSelected(true);
						radioGvNam.setSelected(false);
					}
					
					txtEmailGv.           setText((String) table_1.getValueAt(row, 6));
					txtSdtGv.    		  setText((String) table_1.getValueAt(row, 7));
					
				} catch (Exception e) {
					
				}
			}
		});
		
		jScrollPane1.setBounds(10, 73, 1090, 321);
		internalFrame_1.getContentPane().add(jScrollPane1);
		//scrollPane.setViewportView(table);
		loadDataForTableGv();
		
		panel_9 = new JPanel();
		panel_9.setBounds(10, 403, 848, 44);
		internalFrame_1.getContentPane().add(panel_9);
		panel_9.setLayout(null);
	
		JButton btnAZGv = new JButton("A - Z");
		btnAZGv.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAZGv.setBounds(550, 0, 144, 44);
		btnAZGv.setIcon(new ImageIcon("icon\\sort-ascending-icon.png"));
		panel_9.add(btnAZGv);
		
		JButton btnZAGv = new JButton("Z - A");
		btnZAGv.setFont(new Font("Arial", Font.PLAIN, 15));
		btnZAGv.setBounds(704, 0, 144, 44);
		btnZAGv.setIcon(new ImageIcon("icon\\sort-descending-icon.png"));
		panel_9.add(btnZAGv);
		
		JLabel lblSapXepGv = new JLabel("Sắp xếp");
		lblSapXepGv.setFont(new Font("Arial", Font.BOLD, 15));
		lblSapXepGv.setBounds(309, 0, 78, 44);
		panel_9.add(lblSapXepGv);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.inactiveCaption);
		panel_10.setBounds(868, 403, 232, 292);
		internalFrame_1.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		btnAddGv = new JButton("Thêm");
		btnAddGv.addActionListener(this);
		btnAddGv.setFont(new Font("Arial", Font.BOLD, 20));
		btnAddGv.setBounds(36, 20, 169, 57);
		btnAddGv.setIcon(new ImageIcon("icon\\add-icon.png"));
		panel_10.add(btnAddGv);
		
		btnUpdateGv = new JButton("Sửa");
		btnUpdateGv.addActionListener(this);
		btnUpdateGv.setFont(new Font("Arial", Font.BOLD, 20));
		btnUpdateGv.setBounds(36, 88, 169, 57);
		btnUpdateGv.setIcon(new ImageIcon("icon\\update-icon.png"));
		panel_10.add(btnUpdateGv);
		
		btnDeleteGv = new JButton("Xóa");
		btnDeleteGv.addActionListener(this);
		btnDeleteGv.setFont(new Font("Arial", Font.BOLD, 20));
		btnDeleteGv.setBounds(36, 156, 169, 57);
		btnDeleteGv.setIcon(new ImageIcon("icon\\delete-icon.png"));
		panel_10.add(btnDeleteGv);
		
		btnClearGv = new JButton("Clear");
		btnClearGv.addActionListener(this);
		btnClearGv.setFont(new Font("Arial", Font.BOLD, 20));
		btnClearGv.setBounds(36, 224, 169, 57);
		btnClearGv.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		panel_10.add(btnClearGv);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.inactiveCaption);
		panel_11.setForeground(Color.BLACK);
		panel_11.setBounds(10, 458, 848, 237);
		internalFrame_1.getContentPane().add(panel_11);
		panel_11.setLayout(null);
		
		txtIdGv = new JTextField();
		txtIdGv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIdGv.setBounds(132, 11, 187, 31);
		panel_11.add(txtIdGv);
		txtIdGv.setColumns(10);
		
		txtTenGv = new JTextField();
		txtTenGv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenGv.setColumns(10);
		txtTenGv.setBounds(132, 73, 187, 31);
		panel_11.add(txtTenGv);
		
		jcbMaLopGv = new JComboBox<Object>();
		jcbMaLopGv.setBounds(132, 180, 187, 31);
		panel_11.add(jcbMaLopGv);
		getIdLop();
		
		jcbMonDay = new JComboBox<Object>();
		jcbMonDay.setBounds(132, 127, 187, 31);
		panel_11.add(jcbMonDay);
		getIdMon();
		
		txtNgaysinhGv =  new JDateChooser();
		txtNgaysinhGv.setBounds(504, 11, 187, 31);
		txtNgaysinhGv.setDateFormatString("yyyy-MM-dd");
		panel_11.add(txtNgaysinhGv);
		
		radioGvNam = new JRadioButton("Nam");
		radioGvNam.setFont(new Font("Arial", Font.BOLD, 18));
		radioGvNam.setBackground(SystemColor.inactiveCaption);
		radioGvNam.setBounds(504, 72, 109, 31);
		panel_11.add(radioGvNam);
		
		radioGvNu = new JRadioButton("Nữ");
		radioGvNu.setFont(new Font("Arial", Font.BOLD, 18));
		radioGvNu.setBackground(SystemColor.inactiveCaption);
		radioGvNu.setBounds(615, 72, 109, 31);
		panel_11.add(radioGvNu);
		
	    ButtonGroup genderGvGroup = new ButtonGroup();
	    genderGvGroup.add(radioGvNam);
	    genderGvGroup.add(radioGvNu);
		
		txtEmailGv = new JTextField();
		txtEmailGv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmailGv.setBounds(504, 126, 187, 31);
		panel_11.add(txtEmailGv);
		
		txtSdtGv = new JTextField();
		txtSdtGv.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSdtGv.setBounds(504, 179, 187, 31);
		panel_11.add(txtSdtGv);
		
		JLabel lblMaGV = new JLabel("Mã Giáo viên");
		lblMaGV.setForeground(Color.BLUE);
		lblMaGV.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaGV.setBounds(10, 11, 107, 31);
		panel_11.add(lblMaGV);
		
		JLabel lblTenGv = new JLabel("Tên Giáo viên:");
		lblTenGv.setForeground(Color.BLUE);
		lblTenGv.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenGv.setBounds(10, 73, 107, 31);
		panel_11.add(lblTenGv);
		
		JLabel lblMonDay = new JLabel("Mã Môn dạy:");
		lblMonDay.setForeground(Color.BLUE);
		lblMonDay.setFont(new Font("Arial", Font.BOLD, 15));
		lblMonDay.setBounds(15, 126, 107, 31);
		panel_11.add(lblMonDay);
		
		
		JLabel lblNgaySinhGv = new JLabel("Ngày sinh:");
		lblNgaySinhGv.setForeground(Color.BLUE);
		lblNgaySinhGv.setFont(new Font("Arial", Font.BOLD, 15));
		lblNgaySinhGv.setBounds(387, 11, 107, 31);
		panel_11.add(lblNgaySinhGv);
		
		JLabel lblEmailGv = new JLabel("Email:");
		lblEmailGv.setForeground(Color.BLUE);
		lblEmailGv.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailGv.setBounds(387, 126, 107, 31);
		panel_11.add(lblEmailGv);
		
		JLabel lblGoiTinhGv = new JLabel("Giới tính:");
		lblGoiTinhGv.setForeground(Color.BLUE);
		lblGoiTinhGv.setFont(new Font("Arial", Font.BOLD, 15));
		lblGoiTinhGv.setBounds(387, 73, 107, 31);
		panel_11.add(lblGoiTinhGv);
		
		JLabel lblSoDtGv = new JLabel("Số điện thoại:");
		lblSoDtGv.setForeground(Color.BLUE);
		lblSoDtGv.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoDtGv.setBounds(387, 179, 107, 31);
		panel_11.add(lblSoDtGv);
		
		JLabel lblLp = new JLabel("Mã Lớp:");
		lblLp.setForeground(Color.BLUE);
		lblLp.setFont(new Font("Arial", Font.BOLD, 15));
		lblLp.setBounds(15, 179, 107, 31);
		panel_11.add(lblLp);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.inactiveCaption);
		panel_12.setBounds(313, 11, 1146, 122);
		quan_ly.add(panel_12);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setIcon(new ImageIcon("icon/banner.gif"));
		panel_12.add(lblBanner);
		
		
		// QUẢN LÝ ĐIỂM
		
		
		btnDiem = new JButton("Quản Lý Điểm");
		btnDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(true);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
			}
		});
		btnDiem.setFont(new Font("Arial", Font.BOLD, 20));
		btnDiem.setBounds(10, 293, 273, 76);
		btnDiem.setIcon(new ImageIcon("icon/Arto-icon (1).png"));
		panel_2.add(btnDiem);
		
		internalFrame_2 = new JInternalFrame("Quản lý điểm");
		internalFrame_2.setBounds(10, 11, 1126, 736);
		panel_3.add(internalFrame_2);
		internalFrame_2.getContentPane().setLayout(null);
		
		panel_19 = new JPanel();
		panel_19.setBounds(0, 29, 1110, 35);
		panel_19.setBackground(SystemColor.activeCaption);
		internalFrame_2.getContentPane().add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDiem= new JLabel("Nhập Điểm");
		lblDiem.setForeground(new Color(0, 0, 0)); // màu chữ
		lblDiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_19.add(lblDiem);
		
		panel_20 = new JPanel();
		panel_20.setBackground(SystemColor.inactiveCaption);
		panel_20.setBounds(10, 75, 848, 269);
		internalFrame_2.getContentPane().add(panel_20);
		panel_20.setLayout(null);
		
		// Button
		
		JButton btnLayMaLop = new JButton("Lấy mã lớp");
		btnLayMaLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "SELECT idlop FROM project.giaovien WHERE idgv='" + id + "'";
				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();
				try {
					
					PreparedStatement statement =conn.prepareStatement(sql);
					ResultSet   rs = statement.executeQuery();
					
					while (rs.next()) {
						cbbMaLop.addItem(rs.getString("idlop"));
					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy tên ID lop\n");
				}
			}
		});
		btnLayMaLop.setIcon(new ImageIcon("icon\\Step-Forward-Normal-icon.png"));
		btnLayMaLop.setFont(new Font("Arial", Font.BOLD, 15));
		btnLayMaLop.setBounds(10, 45, 154, 34);
		panel_20.add(btnLayMaLop);
		
		JButton btnMaHs = new JButton("Mã học sinh");
		btnMaHs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cbbMaHs.removeAllItems();
				String sql = "SELECT idhs FROM project.sinhvien WHERE idlop=?";
				
				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();
				
				try {
					
					PreparedStatement statement =conn.prepareStatement(sql);
					statement.setString(1, cbbMaLop.getSelectedItem().toString());
					ResultSet   rs = statement.executeQuery();


					while (rs.next()) {
						cbbMaHs.addItem(rs.getString("idhs"));
					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy ID sinh viên\n");
				}
			}
		});
		btnMaHs.setIcon(new ImageIcon("icon\\Step-Forward-Normal-icon.png"));
		btnMaHs.setFont(new Font("Arial", Font.BOLD, 15));
		btnMaHs.setBounds(10, 90, 154, 34);
		panel_20.add(btnMaHs);
		
		JButton btnLayMaMon = new JButton("Lấy mã môn");
		btnLayMaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cbbMaMon.removeAllItems(); // Reset comboBox
				String sql = "SELECT * FROM project.giaovien JOIN project.mon ON giaovien.idmon = mon.idmon WHERE giaovien.idgv='"
						+ id + "'";
				
				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();
				
				try {
					
					PreparedStatement statement =conn.prepareStatement(sql);
					ResultSet   rs = statement.executeQuery();
				
					while (rs.next()) {
						cbbMaMon.addItem(rs.getString("idmon"));

					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy mã môn\n");
				}
				
			}
		});
		btnLayMaMon.setIcon(new ImageIcon("icon\\Step-Forward-Normal-Blue-icon.png"));
		btnLayMaMon.setFont(new Font("Arial", Font.BOLD, 15));
		btnLayMaMon.setBounds(10, 145, 154, 34);
		panel_20.add(btnLayMaMon);
		
		JButton btnLayTenMon = new JButton("Lấy tên môn");
		btnLayTenMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "SELECT mon FROM project.mon WHERE idmon=?";
				
				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();
				
				try {
					
					PreparedStatement statement =conn.prepareStatement(sql);
					statement.setString(1, cbbMaMon.getSelectedItem().toString());

					ResultSet   rs = statement.executeQuery();
					
					while (rs.next()) {
						txtTenMon.setText(rs.getString("mon"));
					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy tên môn\n");
				}
			}
		});
		btnLayTenMon.setIcon(new ImageIcon("icon\\Step-Forward-Normal-Blue-icon.png"));
		btnLayTenMon.setFont(new Font("Arial", Font.BOLD, 15));
		btnLayTenMon.setBounds(10, 190, 154, 34);
		panel_20.add(btnLayTenMon);
		
		
		// combobox
		
		cbbMaLop = new JComboBox<Object>();
		cbbMaLop.setBounds(174, 45, 165, 34);
		panel_20.add(cbbMaLop);
		
		cbbMaHs = new JComboBox<Object>();
		cbbMaHs.setBounds(174, 90, 165, 34);
		panel_20.add(cbbMaHs);
		
		cbbMaMon = new JComboBox<Object>();
		cbbMaMon.setBounds(174, 146, 165, 34);
		panel_20.add(cbbMaMon);
		
		txtTenMon= new JTextField();
		txtTenMon	.setBounds(174, 190, 165, 34);
		panel_20.add(txtTenMon);

		
		panel_22 = new JPanel();
		panel_22.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_22.setBackground(new Color(204, 255, 204));
		panel_22.setBounds(639, 45, 199, 179);
		panel_20.add(panel_22);
		panel_22.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          Trạng thái");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(10, 11, 179, 33);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		panel_22.add(lblNewLabel);
		
		rdbDat = new JRadioButton("Đạt");
		rdbDat.setEnabled(false);
		rdbDat.setFont(new Font("Arial", Font.BOLD, 14));
		rdbDat.setBackground(new Color(204, 255, 204));
		rdbDat.setBounds(63, 67, 126, 23);
		panel_22.add(rdbDat);
		
		rdbKhongDat = new JRadioButton("Không đạt");
		rdbKhongDat.setEnabled(false);
		rdbKhongDat.setFont(new Font("Arial", Font.BOLD, 14));
		rdbKhongDat.setBackground(new Color(204, 255, 204));
		rdbKhongDat.setBounds(63, 109, 126, 23);
		panel_22.add(rdbKhongDat);
		
		 ButtonGroup checkKq  = new ButtonGroup();
		 checkKq.add(rdbDat);
		 checkKq.add(rdbKhongDat);
		

		txtDiem15p = new JTextField();
		txtDiem15p.setFont(new Font("Arial", Font.BOLD, 13));
		txtDiem15p.setBounds(522, 46, 86, 34);
		panel_20.add(txtDiem15p);
		txtDiem15p.setColumns(10);
		
		txtDiem45p = new JTextField();
		txtDiem45p.setFont(new Font("Arial", Font.BOLD, 13));
		txtDiem45p.setColumns(10);
		txtDiem45p.setBounds(522, 90, 86, 34);
		panel_20.add(txtDiem45p);
		
		txtDiemThi = new JTextField();
		txtDiemThi.setFont(new Font("Arial", Font.BOLD, 13));
		txtDiemThi.setColumns(10);
		txtDiemThi.setBounds(522, 145, 86, 34);
		panel_20.add(txtDiemThi);
		
		txtTongKet = new JTextField();
		txtTongKet.setEnabled(false);
		txtTongKet.setFont(new Font("Arial", Font.BOLD, 13));
		txtTongKet.setColumns(10);
		txtTongKet.setBounds(522, 190, 86, 34);
		panel_20.add(txtTongKet);
		
		JButton btnTongKet = new JButton("Tổng kết");
		btnTongKet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					a = Float.parseFloat(txtDiem15p.getText());
					b = Float.parseFloat(txtDiem45p.getText());
					c = Float.parseFloat(txtDiemThi.getText()) * 2;
					
					txtTongKet.setText(Float.toString((a + b + c) / 4));
					
					if (Float.parseFloat(txtDiem15p.getText()) > 10) {
						JOptionPane.showMessageDialog(null, "Điểm 15p không được lớn hơn 10!");
					}else if (Float.parseFloat(txtDiem45p.getText()) > 10) {
						JOptionPane.showMessageDialog(null, "Điểm 45p không được lớn hơn 10!");
					}else if (Float.parseFloat(txtDiemThi.getText()) > 10) {
						JOptionPane.showMessageDialog(null, "Điểm thi không được lớn hơn 10!");
					}else if ((a + b + c) / 4 >= 5 && a >= 1 && b >= 1 && c >= 1) {
						rdbDat.setSelected(true);
					} else {
						rdbKhongDat.setSelected(true);
					}
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Để lấy được điểm tổng kết \n Bạn phải nhập đầy đủ 3 loại điểm \n Và chỉ được nhập điểm số ");
				}
				
			}
		});
		
		btnTongKet.setIcon(new ImageIcon("icon\\Step-Forward-Normal-Red-icon.png"));
		btnTongKet.setFont(new Font("Arial", Font.PLAIN, 13));
		btnTongKet.setBounds(390, 190, 104, 34);
		panel_20.add(btnTongKet);
		
		JLabel lblDiem15p = new JLabel("Điểm 15'p");
		lblDiem15p.setFont(new Font("Arial", Font.BOLD, 17));
		lblDiem15p.setBounds(401, 45, 93, 34);
		panel_20.add(lblDiem15p);
		
		JLabel lblDiem45p = new JLabel("Điểm 45'p");
		lblDiem45p.setFont(new Font("Arial", Font.BOLD, 17));
		lblDiem45p.setBounds(401, 90, 93, 34);
		panel_20.add(lblDiem45p);
		
		JLabel lblDiemthi = new JLabel("Điểm thi");
		lblDiemthi.setFont(new Font("Arial", Font.BOLD, 17));
		lblDiemthi.setBounds(401, 145, 93, 34);
		panel_20.add(lblDiemthi);
		
		panel_21 = new JPanel();
		panel_21.setBackground(SystemColor.inactiveCaption);
		panel_21.setBounds(868, 75, 232, 269);
		internalFrame_2.getContentPane().add(panel_21);
		panel_21.setLayout(null);
		
		btnThemDiem = new JButton("Thêm");
		btnThemDiem.addActionListener(this);
		btnThemDiem.setFont(new Font("Arial", Font.BOLD, 20));
		btnThemDiem.setIcon(new ImageIcon("icon\\add-icon.png"));
		btnThemDiem.setBounds(10, 11, 212, 54);
		panel_21.add(btnThemDiem);
		
		btnUpdateDiem = new JButton("Sửa");
		btnUpdateDiem.addActionListener(this);
		btnUpdateDiem.setIcon(new ImageIcon("icon\\update-icon.png"));
		btnUpdateDiem.setFont(new Font("Arial", Font.BOLD, 20));
		btnUpdateDiem.setBounds(10, 76, 212, 54);
		panel_21.add(btnUpdateDiem);
		
		btnDeleteDiem = new JButton("Xóa");
		btnDeleteDiem.addActionListener(this);
		btnDeleteDiem.setIcon(new ImageIcon("icon\\delete-icon.png"));
		btnDeleteDiem.setFont(new Font("Arial", Font.BOLD, 20));
		btnDeleteDiem.setBounds(10, 141, 212, 54);
		panel_21.add(btnDeleteDiem);
		
		btnClearDiem = new JButton("Clear");
		btnClearDiem.addActionListener(this);
		btnClearDiem.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		btnClearDiem.setFont(new Font("Arial", Font.BOLD, 20));
		btnClearDiem.setBounds(10, 206, 212, 54);
		panel_21.add(btnClearDiem);
		
		
		tableModel_2 = new DefaultTableModel();
		
		tableModel_2.addColumn("ID Lớp");
		tableModel_2.addColumn("ID Học Sinh");
		tableModel_2.addColumn("ID Môn");
		tableModel_2.addColumn("Môn Học");
		tableModel_2.addColumn("Điểm 15p");
		tableModel_2.addColumn("Điểm 45p");
		tableModel_2.addColumn("Điểm thi");
		tableModel_2.addColumn("Tổng Kết");
		tableModel_2.addColumn("Kết Quả");
		tableModel_2.addColumn("Giáo Viên");
		
		table_2 = new JTable(tableModel_2);
		scrollPaneDiem = new JScrollPane(table_2);
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row = table_2.getSelectedRow();
					cbbMaLop.   setSelectedItem((String) table_2.getValueAt(row, 0));
					cbbMaHs.    setSelectedItem((String) table_2.getValueAt(row, 1));
					cbbMaMon.   setSelectedItem((String) table_2.getValueAt(row, 2));
					txtTenMon.  setText((String) table_2.getValueAt(row, 3));
					
					txtDiem15p. setText((String) table_2.getValueAt(row, 4));
					txtDiem45p. setText((String) table_2.getValueAt(row, 5));
					txtDiemThi. setText((String) table_2.getValueAt(row, 6));
					txtTongKet.setText((String) table_2.getValueAt(row, 7));
					
					if (table_2.getValueAt(row, 8).toString().contains("Đạt")) {
						rdbDat.setSelected(true);
						rdbKhongDat.setSelected(false);
					}else if (table_2.getValueAt(row, 8).toString().contains("Không đạt")) {
						rdbDat.setSelected(false);
						rdbKhongDat.setSelected(true);
					}
					
				} catch (Exception e) {
					
				}

			}
		});
		scrollPaneDiem.setBounds(10, 355, 1090, 340);
		internalFrame_2.getContentPane().add(scrollPaneDiem);
		
		loadDataForTableDiem();
		
		
		// QUẢN LÝ LỚP
		
		btnQlLop = new JButton("Quản Lý Lớp");
		btnQlLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(true);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
			}
		});
		btnQlLop.setFont(new Font("Arial", Font.BOLD, 20));
		btnQlLop.setBounds(10, 421, 273, 76);
		btnQlLop.setIcon(new ImageIcon("icon/Aim-icon (1).png"));
		panel_2.add(btnQlLop);
		
		internalFrame_3 = new JInternalFrame("Quản lý lớp");
		internalFrame_3.setBounds(10, 11, 1126, 736);
		panel_3.add(internalFrame_3);
		internalFrame_3.getContentPane().setLayout(null);
		
		panel_23 = new JPanel();
		panel_23.setBackground(SystemColor.activeCaption);
		panel_23.setBounds(0, 29, 1110, 35);
		internalFrame_3.getContentPane().add(panel_23);
		
		JLabel lblNhapLop = new JLabel("Nhập Lớp");
		lblNhapLop.setForeground(new Color(0, 0, 0)); // màu chữ
		lblNhapLop.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_23.add(lblNhapLop);
		
		panel_24 = new JPanel();
		panel_24.setBackground(SystemColor.inactiveCaption);
		panel_24.setBounds(10, 75, 456, 276);
		internalFrame_3.getContentPane().add(panel_24);
		panel_24.setLayout(null);
		
		txtLop = new JTextField();
		txtLop.setBounds(109, 205, 245, 44);
		panel_24.add(txtLop);
		txtLop.setColumns(10);
		
		txtIdLop = new JTextField();
		txtIdLop.setColumns(10);
		txtIdLop.setBounds(109, 82, 245, 44);
		panel_24.add(txtIdLop);
		
		JLabel lblIdLp = new JLabel("ID Lớp");
		lblIdLp.setFont(new Font("Arial", Font.BOLD, 20));
		lblIdLp.setBounds(192, 27, 129, 44);
		panel_24.add(lblIdLp);
		
		JLabel lblTnLp = new JLabel("Tên Lớp");
		lblTnLp.setFont(new Font("Arial", Font.BOLD, 20));
		lblTnLp.setBounds(192, 150, 129, 44);
		panel_24.add(lblTnLp);
		
		panel_25 = new JPanel();
		panel_25.setBackground(SystemColor.inactiveCaption);
		panel_25.setBounds(10, 362, 456, 205);
		internalFrame_3.getContentPane().add(panel_25);
		panel_25.setLayout(null);
		
		btnAddlop = new JButton("Thêm");
		btnAddlop.setIcon(new ImageIcon("icon\\add-icon.png"));
		btnAddlop.addActionListener(this);
		btnAddlop.setBounds(10, 11, 212, 54);
		btnAddlop.setFont(new Font("Arial", Font.BOLD, 20));
		panel_25.add(btnAddlop);
		
		btnUpdateLop = new JButton("Sửa");
		btnUpdateLop.setIcon(new ImageIcon("icon\\update-icon.png"));
		btnUpdateLop.addActionListener(this);
		btnUpdateLop.setBounds(232, 11, 212, 54);
		btnUpdateLop.setFont(new Font("Arial", Font.BOLD, 20));
		panel_25.add(btnUpdateLop);
		
		btnDeleteLop = new JButton("Xóa");
		btnDeleteLop.addActionListener(this);
		btnDeleteLop.setIcon(new ImageIcon("icon\\delete-icon.png"));
		btnDeleteLop.setFont(new Font("Arial", Font.BOLD, 20));
		btnDeleteLop.setBounds(10, 139, 212, 54);
		panel_25.add(btnDeleteLop);
		
		btnClearLop = new JButton("Clear");
		btnClearLop.addActionListener(this);
		btnClearLop.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		btnClearLop.setFont(new Font("Arial", Font.BOLD, 20));
		btnClearLop.setBounds(232, 139, 212, 54);
		panel_25.add(btnClearLop);
		
		tableModel_3 = new DefaultTableModel();
		
		tableModel_3.addColumn("ID Lớp");
		tableModel_3.addColumn("Tên Lớp");

		
		table_3 = new JTable(tableModel_3);
		JScrollPane scrollPaneLop = new JScrollPane(table_3);
		
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row = table_3.getSelectedRow();
					txtIdLop.   setText((String) table_3.getValueAt(row, 0));
					txtLop.     setText((String) table_3.getValueAt(row, 1));
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		scrollPaneLop.setBounds(476, 78, 624, 489);
		internalFrame_3.getContentPane().add(scrollPaneLop);
		
		loadDataForTableLop();
		
		panel_26 = new JPanel();
		panel_26.setBackground(SystemColor.activeCaption);
		panel_26.setBounds(10, 578, 1090, 117);
		internalFrame_3.getContentPane().add(panel_26);
		
	
		// QUẢN LÝ MÔN
		
		
		btnQlMon = new JButton("Quản Lý Môn");
		btnQlMon.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(true);
				internalFrame_5.setVisible(false);
			}
		});
		btnQlMon.setFont(new Font("Arial", Font.BOLD, 20));
		btnQlMon.setBounds(10, 549, 273, 76);
		btnQlMon.setIcon(new ImageIcon("icon\\Delicious-icon (1).png"));
		panel_2.add(btnQlMon);
		
		internalFrame_4 = new JInternalFrame("Quản lý môn");
		internalFrame_4.setBounds(10, 11, 1126, 736);
		panel_3.add(internalFrame_4);
		internalFrame_4.getContentPane().setLayout(null);
		
		panel_27 = new JPanel();
		panel_27.setBackground(SystemColor.activeCaption);
		panel_27.setBounds(0, 29, 1110, 35);
		internalFrame_4.getContentPane().add(panel_27);
		panel_27.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNhapMon= new JLabel("Nhập Môn");
		lblNhapMon.setForeground(new Color(0, 0, 0)); // màu chữ
		lblNhapMon.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_27.add(lblNhapMon);
		
		tableModel_4 = new DefaultTableModel();
		
		tableModel_4.addColumn("ID Lớp");
		tableModel_4.addColumn("Tên Lớp");

		table_4 = new JTable(tableModel_4);
		JScrollPane scrollPaneMon = new JScrollPane(table_4);
		
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row = table_4.getSelectedRow();
					txtIdMon.   setText((String) table_4.getValueAt(row, 0));
					txtMon.     setText((String) table_4.getValueAt(row, 1));
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		scrollPaneMon.setBounds(10, 75, 697, 466);
		internalFrame_4.getContentPane().add(scrollPaneMon);
		
		loadDataForTableMon();
		
		panel_28 = new JPanel();
		panel_28.setBackground(SystemColor.inactiveCaption);
		panel_28.setBounds(717, 75, 383, 188);
		internalFrame_4.getContentPane().add(panel_28);
		panel_28.setLayout(null);
		
		txtIdMon = new JTextField(10);
		txtIdMon.setFont(new Font("Arial", Font.BOLD, 15));
		txtIdMon.setBounds(174, 22, 199, 50);
		panel_28.add(txtIdMon);
		
		txtMon = new JTextField(10);
		txtMon.setFont(new Font("Arial", Font.BOLD, 15));
		txtMon.setBounds(174, 111, 199, 50);
		panel_28.add(txtMon);
		
		JLabel lblIdMon = new JLabel("ID Môn :");
		lblIdMon.setFont(new Font("Arial", Font.BOLD, 18));
		lblIdMon.setBounds(10, 22, 104, 50);
		panel_28.add(lblIdMon);
		
		JLabel lblTnMn = new JLabel("Tên Môn :");
		lblTnMn.setFont(new Font("Arial", Font.BOLD, 18));
		lblTnMn.setBounds(10, 109, 104, 50);
		panel_28.add(lblTnMn);
		
		panel_29 = new JPanel();
		panel_29.setBackground(SystemColor.inactiveCaption);
		panel_29.setBounds(717, 274, 383, 267);
		internalFrame_4.getContentPane().add(panel_29);
		panel_29.setLayout(null);
		
		btnAddMon = new JButton("Thêm");
		btnAddMon.addActionListener(this);
		btnAddMon.setIcon(new ImageIcon("icon\\add-icon.png"));
		btnAddMon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddMon.setBounds(81, 11, 212, 54);;
		panel_29.add(btnAddMon);
		
		btnUpdateMon = new JButton("Sửa");
		btnUpdateMon.addActionListener(this);
		btnUpdateMon.setIcon(new ImageIcon("icon\\update-icon.png"));
		btnUpdateMon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdateMon.setBounds(81, 73, 212, 54);
		panel_29.add(btnUpdateMon);
		
		btnDeleteMon = new JButton("Xóa");
		btnDeleteMon.addActionListener(this);
		btnDeleteMon.setIcon(new ImageIcon("icon\\delete-icon.png"));
		btnDeleteMon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteMon.setBounds(81, 138, 212, 54);
		panel_29.add(btnDeleteMon);
		
		btnClearMon = new JButton("Clear");
		btnClearMon.addActionListener(this);
		btnClearMon.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		btnClearMon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClearMon.setBounds(81, 202, 212, 54);
		panel_29.add(btnClearMon);
		
		panel_34 = new JPanel();
		panel_34.setBackground(SystemColor.activeCaption);
		panel_34.setBounds(10, 552, 1090, 143);
		internalFrame_4.getContentPane().add(panel_34);
		
		// QUẢN LÝ TÀI KHOẢN
		
		btnQLTaiKhoan = new JButton("Quản Lý Tài Khoản");
		btnQLTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(true);
			}
		});
		btnQLTaiKhoan.setIcon(new ImageIcon("icon\\Buddypress-icon.png"));
		btnQLTaiKhoan.setFont(new Font("Arial", Font.BOLD, 20));
		btnQLTaiKhoan.setBounds(10, 671, 273, 76);
		panel_2.add(btnQLTaiKhoan);

		internalFrame_5 = new JInternalFrame("Quản lý tài khoản");
		internalFrame_5.setBounds(10, 11, 1126, 736);
		panel_3.add(internalFrame_5);
		internalFrame_5.getContentPane().setLayout(null);
		
		panel_13 = new JPanel();
		panel_13.setBackground(SystemColor.activeCaption);
		panel_13.setBounds(0, 29, 1110, 35);
		internalFrame_5.getContentPane().add(panel_13);
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblThongTinTK= new JLabel("Thông Tin Tài Khoản");
		lblThongTinTK.setForeground(new Color(0, 0, 0)); // màu chữ
		lblThongTinTK.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_13.add(lblThongTinTK);
		
		panel_14 = new JPanel();
		panel_14.setBackground(SystemColor.inactiveCaption);
		panel_14.setBounds(0, 75, 1110, 620);
		panel_14.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 1090, 598);
		
		panel_14.add(tabbedPane_1);
		internalFrame_5.getContentPane().add(panel_14);
		
		// TABBEDPANE ADMIN

		panel_15 = new JPanel();
		tabbedPane_1.addTab("Tài khoản Admin", panel_15);
		panel_15.setLayout(null);
		
		JScrollPane scrollPaneAdmin = new JScrollPane();
		scrollPaneAdmin.setBounds(10, 11, 1065, 316);
		panel_15.add(scrollPaneAdmin);
		
		tableAdmin = new JTable();
		tableAdmin.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					int row = tableAdmin.getSelectedRow();

					txt_Id.setText((String) tableAdmin.getValueAt(row, 0));
					txt_User.setText((String) tableAdmin.getValueAt(row, 1));
					txt_Pw.setText((String) tableAdmin.getValueAt(row, 2));
					jcb_Role.setSelectedItem((String) tableAdmin.getValueAt(row, 3));
					txt_FullName.setText((String) tableAdmin.getValueAt(row, 4));

				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});
		scrollPaneAdmin.setViewportView(tableAdmin);
		showAdmin();

		panel_17 = new JPanel();
		panel_17.setBackground(SystemColor.activeCaption);
		panel_17.setBounds(10, 338, 1065, 221);
		panel_15.add(panel_17);
		panel_17.setLayout(null);
		
		// thêm lable cho tab admin
		
		JLabel lbID = new JLabel("ID : ");
		lbID.setFont(new Font("Arial", Font.BOLD, 15));
		lbID.setBounds(45, 34, 55, 31);
		panel_17.add(lbID);
		
		JLabel lbUser = new JLabel("User : ");
		lbUser.setFont(new Font("Arial", Font.BOLD, 15));
		lbUser.setBounds(45, 87, 55, 31);
		panel_17.add(lbID);
		
		JLabel	lbPw = new JLabel("Pass ");
		lbPw.setBounds(247, 8, 25, 14);
		panel_17.add(lbUser);
		
		JLabel	lbRole= new JLabel("Role :");
		lbRole.setFont(new Font("Arial", Font.BOLD, 15));
		lbRole.setBounds(355, 35, 55, 31);
		panel_17.add(lbRole);
		
		JLabel	lbFullName= new JLabel("FullName : ");
		lbFullName.setFont(new Font("Arial", Font.BOLD, 15));
		lbFullName.setBounds(355, 143, 78, 31);
		panel_17.add(lbFullName);

		// thêm textfiled cho tab admin

		txt_Id = new JTextField(10);
		txt_Id.setBounds(98, 35, 187, 31);
		panel_17.add(txt_Id);
		
		txt_User = new JTextField(10);
		txt_User.setBounds(98, 87, 187, 31);
		panel_17.add(txt_User);
		
		txt_Pw = new JTextField(10);
		txt_Pw.setBounds(98, 144, 187, 31);
		panel_17.add(txt_Pw);
		
		jcb_Role = new JComboBox<Object>();
		jcb_Role.setBounds(443, 35, 187, 31);
		jcb_Role.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2" }));
		panel_17.add(jcb_Role);
		
		txt_FullName = new JTextField(10);
		txt_FullName.setBounds(443, 144, 187, 31);
		panel_17.add(txt_FullName);
		
		JLabel lblPass = new JLabel("Pass: ");
		lblPass.setFont(new Font("Arial", Font.BOLD, 15));
		lblPass.setBounds(45, 143, 55, 31);
		panel_17.add(lblPass);
		
		JButton btnThemAd = new JButton("Thêm");
		btnThemAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = "INSERT INTO project.users VALUES (?, ?, ?, ?, ?)";

				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();

				try {
					 
					PreparedStatement statement = conn.prepareStatement(sql);

					if (txt_Id.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "ID admin không được để trống !");
					} else if (txt_User.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					} else if (txt_Pw.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					} else if (jcb_Role.getSelectedItem().toString() == null) {
						JOptionPane.showMessageDialog(null, "Role không được để trống !");
					} else if (txt_FullName.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "FullName không được để trống !");
					} else {

						statement.setString(1, txt_Id.getText());
						statement.setString(2, txt_User.getText());
						statement.setString(3, txt_Pw.getText());
						statement.setString(4, jcb_Role.getSelectedItem().toString());
						statement.setString(5, txt_FullName.getText());

						statement.executeUpdate();
						JOptionPane.showMessageDialog(null, "Thêm thành công !");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Thêm không thành công  ! \n ID hoặc user đã tồn tại");
				} finally {
					connectUtil.disconnect(conn);
				}
				showAdmin();
				txt_Id.setText("");
				txt_User.setText("");
				txt_Pw.setText("");
				jcb_Role.setSelectedItem("");
				txt_FullName.setText("");
			}
		});
		btnThemAd.setIcon(new ImageIcon("icon\\add-icon.png"));
		btnThemAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThemAd.setBounds(852, 11, 167, 40);
		panel_17.add(btnThemAd);
		
		JButton btnUpdateAd = new JButton("Sửa");
		btnUpdateAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "UPDATE  project.users SET username=?, pass=?, role=?, FullName=? WHERE ID=?";

				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();

				try {

					PreparedStatement statement = conn.prepareStatement(sql);
						
						statement.setString(1, txt_User.getText());
						statement.setString(2, txt_Pw.getText());
						statement.setString(3, jcb_Role.getSelectedItem().toString());
						statement.setString(4, txt_FullName.getText());
						statement.setString(5, txt_Id.getText());

					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Sửa thành công !");
						

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi cập nhập" + e2);
				} finally {
					connectUtil.disconnect(conn);
				}
				showAdmin();
				txt_Id.setText("");
				txt_User.setText("");
				txt_Pw.setText("");
				jcb_Role.setSelectedItem("");
				txt_FullName.setText("");
			}
				
			
		});

		btnUpdateAd.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\JAVA\\PhanMemQuanLy\\icon\\update-icon.png"));
		btnUpdateAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdateAd.setBounds(852, 64, 167, 40);
		panel_17.add(btnUpdateAd);
		
		JButton btnDeleteAd = new JButton("Xóa");
		btnDeleteAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "DELETE FROM project.users WHERE ID=?";

				ConnectUtil connectUtil = new ConnectUtil();
				Connection conn = connectUtil.connect();

				try {

					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, txt_Id.getText());

					int reponse = JOptionPane.showConfirmDialog(null,
							"Có chắc chắn xóa  " + txt_FullName.getText() + " chưa?", null,
							JOptionPane.YES_NO_OPTION);

					String message = "?";

					switch (reponse) {

					case JOptionPane.YES_OPTION:
						message = "Xóa thành CMN công !";
						statement.executeUpdate();
						break;
					case JOptionPane.NO_OPTION:
						message = "Không xóa  " + txt_FullName.getText() + " hả ?";
						break;
					default:
						;
					}
					JOptionPane.showMessageDialog(null, message);
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Lỗi \n" + e2);
				} finally {
					connectUtil.disconnect(conn);
				}
				showAdmin();
				txt_Id.setText("");
				txt_User.setText("");
				txt_Pw.setText("");
				jcb_Role.setSelectedItem("");
				txt_FullName.setText("");
			}
		});
		btnDeleteAd.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\JAVA\\PhanMemQuanLy\\icon\\delete-icon.png"));
		btnDeleteAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteAd.setBounds(852, 115, 167, 40);
		panel_17.add(btnDeleteAd);
		
		JButton btnClearAd = new JButton("Clear");
		btnClearAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnClearAd.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\JAVA\\PhanMemQuanLy\\icon\\Actions-edit-redo-icon.png"));
		btnClearAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClearAd.setBounds(852, 166, 167, 40);
		panel_17.add(btnClearAd);	
		
		// TABBEDPANE GIÁO VIÊN
		
		panel_16 = new JPanel();
		tabbedPane_1.addTab("Tài khoản giáo viên", panel_16);
		panel_16.setLayout(null);

		JScrollPane scrollPaneGV = new JScrollPane();
		scrollPaneGV.setBounds(10, 11, 1065, 316);
		panel_16.add(scrollPaneGV);
		
		tableGV = new JTable();
		tableGV.addMouseListener(new MouseAdapter() {
			private JTextField txt_Id_Gv;
			private JTextField txt_User_Gv;
			private JTextField txt_Pw_Gv;

			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					int row = tableGV.getSelectedRow();

					txt_Id_Gv.setText((String) tableGV.getValueAt(row, 0));
					txt_User_Gv.setText((String) tableGV.getValueAt(row, 1));
					txt_Pw_Gv.setText((String) tableGV.getValueAt(row, 3));

				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});
		scrollPaneGV.setViewportView(tableGV);
		showGiaoVien();
		
		panel_18 = new JPanel();
		panel_18.setBackground(SystemColor.activeCaption);
		panel_18.setBounds(10, 338, 1065, 221);
		panel_16.add(panel_18);
		
		JPanel xem_diem = new JPanel();
		tabbedPane.addTab("Xem điểm",
				new ImageIcon("icon/Apps-Aegisub-icon (6).png"), xem_diem,
				null);
		xem_diem.setLayout(null);
		
		panel_30 = new JPanel();
		panel_30.setBackground(SystemColor.inactiveCaption);
		panel_30.setBounds(10, 11, 1459, 166);
		xem_diem.add(panel_30);
		panel_30.setLayout(null);
		
		lblBangDiem =  new JLabel("Bảng Điểm");
		lblBangDiem.setFont(new Font("Arial", Font.BOLD, 30));
		lblBangDiem.setBounds(654, 50, 162, 37);
		panel_30.add(lblBangDiem);
		
		panel_31 = new JPanel();
		panel_31.setBackground(SystemColor.inactiveCaption);
		panel_31.setBounds(10, 859, 1459, 63);
		xem_diem.add(panel_31);
		panel_31.setLayout(null);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_Bangdiem, "Bảng Điểm");
			}
		});
		btnPrint.setIcon(new ImageIcon("icon\\Print-icon.png"));
		btnPrint.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrint.setBounds(1306, 11, 119, 41);
		panel_31.add(btnPrint);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table_Bangdiem);
			}
		});
		btnExport.setIcon(new ImageIcon("icon\\MS-Office-2003-Excel-icon.png"));
		btnExport.setFont(new Font("Arial", Font.BOLD, 15));
		btnExport.setBounds(1183, 11, 113, 41);
		panel_31.add(btnExport);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(690, 11, 471, 41);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idhs = sinhvien.idhs INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.lop ON sinhvien.idlop = lop.idlop";
				
				BangDiemDao bangdiemDao = new BangDiemDao();
				
				bangdiemDao.showTableBangDiemSearch(table_Bangdiem, sql, txtSearch.getText());
			}
		});
		panel_31.add(txtSearch);
		
		// Tab TÌM KIẾM
		
		lblSearch = new JLabel("Tìm Kiếm");
		lblSearch.setFont(new Font("Arial", Font.BOLD, 14));
		lblSearch.setBounds(552, 11, 128, 41);
		panel_31.add(lblSearch);
		
		scrollPaneXemDiem = new JScrollPane();
		scrollPaneXemDiem.setBounds(10, 188, 1459, 660);
		xem_diem.add(scrollPaneXemDiem);
		
		table_Bangdiem = new JTable();
		scrollPaneXemDiem.setViewportView(table_Bangdiem);
		showTableBangDiem();
	
		JPanel tim_kiem = new JPanel();
		tabbedPane.addTab("Tìm Kiếm",
				new ImageIcon("icon/Search-icon (2).png"), tim_kiem,
				null);
		tim_kiem.setLayout(null);
		
		panel_32 = new JPanel();
		panel_32.setBackground(SystemColor.inactiveCaption);
		panel_32.setBounds(10, 11, 1459, 166);
		tim_kiem.add(panel_32);
		panel_32.setLayout(null);
		
		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setBounds(663, 5, 133, 35);
		lblTmKim.setFont(new Font("Arial", Font.BOLD, 30));
		panel_32.add(lblTmKim);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(663, 64, 503, 41);
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if (cbbTimKiem.getSelectedItem().equals("Học sinh")) {

					timkiemDAO.showTableSinhVienTimKiem(table_Searchsinhvien, txtTimKiem.getText().trim());
					
				} else if (cbbTimKiem.getSelectedItem().equals("Giáo viên")) {

					timkiemDAO.showTableGiaoVienTimKiem(table_Searchgiaovien, txtTimKiem.getText().trim());
				} else if (cbbTimKiem.getSelectedItem().equals("Lớp")) {
				
					timkiemDAO.showTableLopTimKiem(table_Searchlop, txtTimKiem.getText().trim());
				} else if (cbbTimKiem.getSelectedItem().equals("Môn")) {
					
					timkiemDAO.showTableMonTimKiem(table_Searchmon, txtTimKiem.getText().trim());
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn lại cách tìm kiếm khác");
				}
			}
		});
		panel_32.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		cbbTimKiem = new JComboBox<Object>();
		cbbTimKiem.setFont(new Font("Arial", Font.BOLD, 15));
		cbbTimKiem.setModel(new DefaultComboBoxModel<Object>(new String[] { "Học sinh", "Giáo viên", "Lớp", "Môn" }));
		cbbTimKiem.setBounds(456, 64, 181, 41);
		panel_32.add(cbbTimKiem);
		
		panel_33 = new JPanel();
		panel_33.setBackground(SystemColor.inactiveCaption);
		panel_33.setBounds(10, 859, 1459, 63);
		tim_kiem.add(panel_33);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 188, 1459, 660);
		tim_kiem.add(tabbedPane_2);
		
		panel_35 = new JPanel();
		tabbedPane_2.addTab("Học Sinh",new ImageIcon("icon\\Buddypress-icon (1).png"), panel_35,null);
		panel_35.setLayout(null);
		
		JScrollPane scrollPaneHs = new JScrollPane();
		scrollPaneHs.setBounds(10, 11, 1434, 610);
		panel_35.add(scrollPaneHs);

		table_Searchsinhvien = new JTable();
		scrollPaneHs.setViewportView(table_Searchsinhvien);
		showTableSinhVienSearch();
		
		panel_36 = new JPanel();
		tabbedPane_2.addTab("Giáo Viên", new ImageIcon("icon\\Carbonmade-icon (1).png"), panel_36,null);
		panel_36.setLayout(null);
		
		JScrollPane scrollPaneGv = new JScrollPane();
		scrollPaneGv.setBounds(10, 11, 1434, 610);
		panel_36.add(scrollPaneGv);
		
		table_Searchgiaovien = new JTable();
		scrollPaneGv.setViewportView(table_Searchgiaovien);
		showTableGiaoVienSearch();
		
		panel_37 = new JPanel();
		tabbedPane_2.addTab("Lớp", new ImageIcon("icon\\Aim-icon.png"), panel_37,null);
		
		panel_37.setLayout(null);
		
		JScrollPane scrollPaneLOP = new JScrollPane();
		scrollPaneLOP.setBounds(10, 11, 1434, 610);
		panel_37.add(scrollPaneLOP);
		
		table_Searchlop = new JTable();
		scrollPaneLOP.setViewportView(table_Searchlop);
		showTableLopSearch();
		
		panel_38 = new JPanel();
		tabbedPane_2.addTab("Môn", new ImageIcon("icon\\Dribbble-icon.png"), panel_38,null);
		panel_38.setLayout(null);
		
		JScrollPane scrollPaneMON = new JScrollPane();
		scrollPaneMON.setBounds(10, 11, 1434, 610);
		panel_38.add(scrollPaneMON);
		
		table_Searchmon = new JTable();
		scrollPaneMON.setViewportView(table_Searchmon);
		showTableMonSearch();
		
		

	}



	private void showAdmin() {
		// Name Column table

		Vector<String> cols = new Vector<String>();
		cols.addElement("ID");
		cols.addElement("Username");
		cols.addElement("Password");
		cols.addElement("Role");
		cols.addElement("Full name");

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		// Data table

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		String sql = "SELECT * FROM project.users";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Vector<String> user = new Vector<String>();

				user.addElement(result.getString("ID"));
				user.addElement(result.getString("username"));
				user.addElement(result.getString("pass"));
				user.addElement(result.getString("role"));
				user.addElement(result.getString("FullName"));

				data.add(user);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}
		tableAdmin.setModel(new DefaultTableModel(data, cols));
		
	}

	public void showGiaoVien() {

		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("ID");
		cols.addElement("Username");
		cols.addElement("Password");
		cols.addElement("Role");


		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		// Data table

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		String sql = "SELECT * FROM project.giaovien";

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				Vector<String> admin = new Vector<String>();

				admin.addElement(result.getString("idgv"));
				admin.addElement(result.getString("hoten"));
				admin.addElement(result.getString("pass"));

				data.add(admin);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			connectUtil.disconnect(conn);
		}
		tableGV.setModel(new DefaultTableModel(data, cols));
	}

	private void loadDataForTable() {

		// xóa dữ liêu cũ trùng lặp
		tableModel.setRowCount(0);

		HocSinhDao hocsinhDao = new HocSinhDao();
		ArrayList<HocSinh> listHS = hocsinhDao.getALLHocSinh();

		for (HocSinh hocsinh : listHS) {
			tableModel.addRow(new String[] { "" + hocsinh.getIdHocSinh(), hocsinh.getHoTen(),
					hocsinh.getIdLop(), hocsinh.getNgaySinh(), hocsinh.getDiaChi(), hocsinh.getGioiTinh(), 
						hocsinh.getSdt() });
		}
		
	}
	
	private void loadDataForTableGv() {
		
		tableModel_1.setRowCount(0);
		
	//	GiaoVienDao giaovienDao = new GiaoVienDao();
		ArrayList<GiaoVien> listGV = giaovienDao.getALLGiaoVien();
	
		for (GiaoVien giaovien : listGV) {
			tableModel_1.addRow(new String[] { "" + giaovien.getIdGv(), giaovien.getHoTenGv(),
				giaovien.getIdMonday(),giaovien.getIdLop(),giaovien.getNgaySinh(),
					giaovien.getGioiTinhGv(),  giaovien.getEmail(),
						giaovien.getSdtGv() });
		}
	}

	
	private void loadDataForTableDiem() {
		
		tableModel_2.setRowCount(0);
		
		//DiemDao diemDao = new DiemDao();
		ArrayList<Diem> listDiem = diemDao.getALLDiem();
		
		for (Diem diem : listDiem) {
			tableModel_2.addRow(new String[] { "" + diem.getIdLop(),diem.getIdHocSinh(),
					diem.getIdMonHoc(),diem.getMonHoc(),diem.getDiem15(),
						diem.getDiem45(),diem.getDiemThi(), diem.getTongKet(),
							diem.getKetQua(),diem.getIdGv()});
			}

	}
	
	private void loadDataForTableLop() {
		
		tableModel_3.setRowCount(0);
		
	//	LopDao lopDao = new LopDao();
		ArrayList<Lop> listLop = lopDao.getAllLop();
		
		for (Lop lop : listLop) {
			tableModel_3.addRow(new String[] { "" + lop.getIdLop(),lop.getTenLop()});
			}

		
	}
	
	private void loadDataForTableMon() {
		
		tableModel_4.setRowCount(0);
	
		ArrayList<Mon> listMon = monDao.getAllMon();
		
		for (Mon mon : listMon) {
			tableModel_4.addRow(new String[] { "" + mon.getIdMon(),mon.getTenMon()});
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAdd) {
			addHs();
			loadDataForTable();
			clear();
		} else if (action == btnUpdate) {
			updateHs();
			loadDataForTable();
			clear();
		} else if (action == btnDelete) {
			deleteHs();
			loadDataForTable();
			clear();
		} else if(action == btnReset) {
			clear();
		}else if(action == btnAddGv) {
			addGv();
			loadDataForTableGv();
			clearGv();
		}else if(action == btnUpdateGv) {
			updateGv();
			loadDataForTableGv();
			clearGv();
		}else if(action == btnDeleteGv) {
			deleteGv();
			loadDataForTableGv();
			clearGv();
		}else if(action == btnClearGv) {
			clearGv();
		}else if(action == btnThemDiem) {
			addDiem();
			loadDataForTableDiem();
		}else if(action == btnUpdateDiem) {
			updateDiem();
			loadDataForTableDiem();
		}else if(action == btnDeleteDiem) {
			deleteDiem();
			loadDataForTableDiem();
		}else if(action == btnClearDiem) {
			clearDiem();
		}else if(action == btnAddlop) {
			addLop();
			loadDataForTableLop();
			clearLop();
		}else if(action == btnUpdateLop) {
			updateLop();
			loadDataForTableLop();
			clearLop();
		}else if(action == btnDeleteLop) {
			deleteLop();
			loadDataForTableLop();
			clearLop();
		}else if(action == btnClearLop) {
			clearLop();
		}else if(action == btnAddMon) {
			addMon();
			loadDataForTableMon();
		}else if(action == btnUpdateMon) {
			updateMon();
			loadDataForTableMon();
		}else if(action == btnDeleteMon) {
			deleteMon();
			loadDataForTableMon();
		}else if(action == btnClearMon) {
			clearMon();
		}
	}



		// THÊM SỬA XÓA HỌC SINH
	

	private void addHs() {
			
		if (txtId.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã học sinh không đươc để trống !");
		} else if (txtTenSv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên học sinh không đươc để trống !");
		} else if (jcbMaLop.getSelectedItem().toString() == null) {
			JOptionPane.showMessageDialog(null, "Mã lớp không đươc để trống !");
		}else if (txtNgaysinhHocSinh.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống !");
		} else if (txtDiaChi.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
		} else if (radioNam.isSelected() == false && radioNu.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Giới tính vui lòng chọn Nam hoặc Nữ !");
		} else if (txtSdt.getText().matches("(.*)[a-zA-Z](.*)")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
		} else if (txtSdt.getText().length() <= 9 || txtSdt.getText().length() >= 11) {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
		} else {
			
	
			Date datehs = txtNgaysinhHocSinh.getDate();
			String datesvinput = new SimpleDateFormat("yyyy/MM/dd").format(datehs);
			
			hocsinh.setIdHocSinh  (txtId.getText());
			hocsinh.setHoTen      (txtTenSv.getText());
			hocsinh.setIdLop      (jcbMaLop.getSelectedItem().toString());
			hocsinh.setNgaySinh   (datesvinput);
			hocsinh.setDiaChi     (txtDiaChi.getText());
		
		if (radioNam.isSelected()) {
			hocsinh.setGioiTinh("Nam");
		} else {
			hocsinh.setGioiTinh("Nữ");
		}
		
		hocsinh.setSdt        (txtSdt.getText());
		
		hocsinhDao.addHs(hocsinh);
		
		}
		
	}

	private void updateHs() {
		
		if (txtId.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã học sinh không đươc để trống !");
		} else if (txtTenSv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên học sinh không đươc để trống !");
		} else if (jcbMaLop.getSelectedItem().toString() == null) {
			JOptionPane.showMessageDialog(null, "Mã lớp không đươc để trống !");
		} else if (txtNgaysinhHocSinh.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống !");
		} else if (txtDiaChi.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
		} else if (radioNam.isSelected() == false && radioNu.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Giới tính vui lòng chọn Nam hoặc Nữ !");
		} else if (txtSdt.getText().matches("(.*)[a-zA-Z](.*)")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
		} else if (txtSdt.getText().length() <= 9 || txtSdt.getText().length() >= 11) {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
		} else {
			
			Date datehs = txtNgaysinhHocSinh.getDate();
			String datesvinput = new SimpleDateFormat("yyyy/MM/dd").format(datehs);
		
			hocsinh.setIdHocSinh  (txtId.getText());
			hocsinh.setHoTen      (txtTenSv.getText());
			hocsinh.setIdLop      (jcbMaLop.getSelectedItem().toString());
			hocsinh.setNgaySinh   (datesvinput);
			hocsinh.setDiaChi     (txtDiaChi.getText());
		
			if (radioNam.isSelected()) {
				hocsinh.setGioiTinh("Nam");
			} else {
				hocsinh.setGioiTinh("Nữ");
			}
			
			hocsinh.setSdt        (txtSdt.getText());
			
			hocsinhDao.updateHs(hocsinh);
		
		}
		
	}
	
	
	private void deleteHs() {
		
		String id = (String) table.getValueAt(table.getSelectedRow(), 0);
		hocsinhDao.deleteHs(id);
		
	}
	
	private void clear() {
		
		txtId.setText("");
		txtTenSv.setText("");
		jcbMaLop.setSelectedItem("");
		txtNgaysinhHocSinh.setDate(null);
		radioNam.setSelected(false);
		radioNu.setSelected(false);
		txtDiaChi.setText("");
		txtSdt.setText("");
		
	}
	
	// THÊM SỬA XÓA GIÁO VIÊN
	
	private void addGv() {
		
		
		if (txtIdGv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã giáo viên không đươc để trống !");
		} else if (txtTenGv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên giáo viên không đươc để trống !");
		} else if (jcbMaLopGv.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Mã lớp không đươc để trống !");
		} else if (txtNgaysinhGv.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống !");
		} else if (jcbMonDay.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Mã môn không được để trống !");
		} else if (radioGvNam.isSelected() == false && radioGvNu.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Giới tính vui lòng chọn Nam hoặc Nữ !");
		} else if (txtEmailGv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Email không được để trống !");
		} else if (txtSdtGv.getText().matches("(.*)[a-zA-Z](.*)")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
		} else if (txtSdtGv.getText().length() <= 9 || txtSdt.getText().length() >= 11) {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
		} else {
			
			Date dateGv = txtNgaysinhGv.getDate();
			String dateGvInput = new SimpleDateFormat("yyyy/MM/dd").format(dateGv);
		
			giaovien.setIdGv 		(txtIdGv.getText());
			giaovien.setHoTenGv     (txtTenGv.getText());
			giaovien.setIdLop       (jcbMaLopGv.getSelectedItem().toString());
			giaovien.setIdMonday    (jcbMonDay.getSelectedItem().toString());
			giaovien.setNgaySinh    (dateGvInput);
		
			if (radioGvNam.isSelected()) {
				giaovien.setGioiTinhGv("Nam");
			} else {
				giaovien.setGioiTinhGv("Nữ");
			}
			
			giaovien.setEmail        (txtEmailGv.getText());
			giaovien.setSdtGv        (txtSdtGv.getText());
		
		giaovienDao.addGv(giaovien);
		
		}
	}
	
	private void updateGv() {
		
		if (txtIdGv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Mã giáo viên không đươc để trống !");
		} else if (txtTenGv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên giáo viên không đươc để trống !");
		} else if (jcbMaLopGv.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Mã lớp không đươc để trống !");
		} else if (txtNgaysinhGv.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống !");
		} else if (jcbMonDay.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Mã môn không được để trống !");
		} else if (radioGvNam.isSelected() == false && radioGvNu.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Giới tính vui lòng chọn Nam hoặc Nữ !");
		} else if (txtEmailGv.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Email không được để trống !");
		} else if (txtSdtGv.getText().matches("(.*)[a-zA-Z](.*)")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
		} else if (txtSdtGv.getText().length() <= 9 || txtSdt.getText().length() >= 11) {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
		} else {
			
			Date dateGv = txtNgaysinhGv.getDate();
			String dateGvInput = new SimpleDateFormat("yyyy/MM/dd").format(dateGv);
		
			giaovien.setIdGv 		(txtIdGv.getText());
			giaovien.setHoTenGv     (txtTenGv.getText());
			giaovien.setIdLop       (jcbMaLopGv.getSelectedItem().toString());
			giaovien.setIdMonday    (jcbMonDay.getSelectedItem().toString());
			giaovien.setNgaySinh    (dateGvInput);
		
			if (radioGvNam.isSelected()) {
				giaovien.setGioiTinhGv("Nam");
			} else {
				giaovien.setGioiTinhGv("Nữ");
			}
			
			giaovien.setEmail        (txtEmailGv.getText());
			giaovien.setSdtGv        (txtSdtGv.getText());
		
		giaovienDao.updateGv(giaovien);
		
		}
		
	}
	
	private void deleteGv() {
		String id = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
		giaovienDao.deleteGv(id);
	}
	
	private void clearGv() {
		
		txtIdGv.setText("");
		txtTenGv.setText("");
		txtNgaysinhGv.setDate(null);
		txtEmailGv.setText("");
		txtSdtGv.setText("");	
	}
	
	// THÊM SỬA XÓA ĐIỂM
	
	private void addDiem() {
	
		// Bat loi nguoi dung nhap diem
		if (cbbMaLop.getSelectedItem() == null || cbbMaHs.getSelectedItem() == null
				|| cbbMaMon.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng lấy đầy đủ thông tin hộp chọn");
		} else if (txtTenMon.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên môn không được để trống !");
		} else if (txtDiem15p.getText().length() == 0 || txtDiem45p.getText().length() == 0
				|| txtDiemThi.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Không được để trống ô điểm!");
		} else if (txtDiem15p.getText().matches("(.*)[a-zA-Z](.*)")
				|| txtDiem45p.getText().matches("(.*)[a-zA-Z](.*)")
				|| txtDiemThi.getText().matches("(.*)[a-zA-Z](.*)")) {
			JOptionPane.showMessageDialog(null, "Không được nhập chữ vào ô điểm!");
		} else if (txtTongKet.getText().length() == 0 || txtTongKet.getText() == null) {
			JOptionPane.showMessageDialog(null, "Điểm tổng kết không được để trống!");
		} else {
			diem.setIdLop(cbbMaLop.getSelectedItem().toString());
			diem.setMonHoc(txtTenMon.getText());
			diem.setIdMonHoc(cbbMaMon.getSelectedItem().toString());
			diem.setIdHocSinh(cbbMaHs.getSelectedItem().toString());
			diem.setDiem15(txtDiem15p.getText());
			diem.setDiem45(txtDiem45p.getText());
			diem.setDiemThi(txtDiemThi.getText());
			diem.setTongKet(txtTongKet.getText());
			
			if (rdbDat.isSelected()) {
				diem.setKetQua("Đạt");
			} else {
				diem.setKetQua("Không đạt");
			}
			
			diem.setIdGv(id);
		
			diemDao.addDiem(diem);
		}
		
	}
	

	private void updateDiem() {	
	
		// Bat loi nguoi dung nhap diem
		if (cbbMaLop.getSelectedItem() == null || cbbMaHs.getSelectedItem() == null
				|| cbbMaMon.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng lấy đầy đủ thông tin hộp chọn");
		} else if (txtTenMon.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên môn không được để trống !");
		} else if (txtDiem15p.getText().length() == 0 || txtDiem45p.getText().length() == 0
				|| txtDiemThi.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Không được để trống ô điểm!");
		} else if (txtDiem15p.getText().matches("(.*)[a-zA-Z](.*)")
				|| txtDiem45p.getText().matches("(.*)[a-zA-Z](.*)")
				|| txtDiemThi.getText().matches("(.*)[a-zA-Z](.*)")) {
			JOptionPane.showMessageDialog(null, "Không được nhập chữ vào ô điểm!");
		 
		} else if (txtTongKet.getText().length() == 0 || txtTongKet.getText() == null) {
			JOptionPane.showMessageDialog(null, "Điểm tổng kết không được để trống!");
		} else {
			diem.setIdLop(cbbMaLop.getSelectedItem().toString());
			diem.setMonHoc(txtTenMon.getText().toString());
			diem.setIdMonHoc(cbbMaMon.getSelectedItem().toString());
			diem.setIdHocSinh(cbbMaHs.getSelectedItem().toString());
			diem.setDiem15(txtDiem15p.getText());
			diem.setDiem45(txtDiem45p.getText());
			diem.setDiemThi(txtDiemThi.getText());
			diem.setTongKet(txtTongKet.getText());
			
			if (rdbDat.isSelected()) {
				diem.setKetQua("Đạt");
			} else {
				diem.setKetQua("Không đạt");
			}
			
			diem.setIdGv(id);
			diemDao.updateDiem(diem);
		}
	}

	private void deleteDiem() {
	
		String idHs = (String) table_2.getValueAt(table_2.getSelectedRow(), 1);
		String idMon = (String) table_2.getValueAt(table_2.getSelectedRow(), 2);
		
		diemDao.deleteDiem(idHs,idMon);
	}

	private void clearDiem() {	

		txtDiem15p.setText("");
		txtDiem45p.setText("");
		txtDiemThi.setText("");
		txtTongKet.setText("");

	}
	
	// THÊM SỬA XÓA LỚP
	
	private void addLop() {
		
		if(txtIdLop.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "ID lớp không được để trống");
		}else if(txtLop.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên lớp không được để trống");
		}else {
			lop.setIdLop(txtIdLop.getText());
			lop.setTenLop(txtLop.getText());
			
			lopDao.addLop(lop);
		}
		
	}

	private void updateLop() {

		if(txtIdLop.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "ID lớp không được để trống");
		}else if(txtLop.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên lớp không được để trống");
		}else {
			lop.setIdLop(txtIdLop.getText());
			lop.setTenLop(txtLop.getText());
			
			lopDao.updateLop(lop);
		}
		
	}

	private void deleteLop() {
		
		String id = (String) table_3.getValueAt(table_3.getSelectedRow(), 0);
		lopDao.deleteLop(id);
		
	}
		
	private void clearLop() {
		txtIdLop.setText("");
		txtLop.setText("");
	}
	
	
	// THÊM SỬA XÓA MÔN
	
	private void addMon() {
		
		if(txtIdMon.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "ID môn không được để trống");
		}else if(txtMon.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên môn không được để trống");
		}else {
			mon.setIdMon(txtIdMon.getText());
			mon.setTenMon(txtMon.getText());
			monDao.addMon(mon);
		}
	}

	private void updateMon() {

		if(txtIdMon.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "ID môn không được để trống");
		}else if(txtMon.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên môn không được để trống");
		}else {
			mon.setIdMon(txtIdMon.getText());
			mon.setTenMon(txtMon.getText());
			monDao.updateMon(mon);
		}
	}

	private void deleteMon() {
		
		String id = (String) table_4.getValueAt(table_4.getSelectedRow(), 0);
		monDao.deleteMon(id);
		
	}
		
	private void clearMon() {
		txtIdMon.setText("");
		txtMon.setText("");
	}
	

	private void getIdLop() {
		
		String sql = "SELECT * FROM project.lop";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		 try {
			 
			PreparedStatement statement =conn.prepareStatement(sql);
			ResultSet   rs = statement.executeQuery();
			
		  while (rs.next()) {

		   // Display comboBox set from databse
		   jcbMaLop.addItem(rs.getString("idlop"));
		   jcbMaLopGv.addItem(rs.getString("idlop"));
		   
		  	}
		  
		 } catch (Exception e) {
		  e.printStackTrace();
		 } finally {
			connectUtil.disconnect(conn);
		 }
	}
	private void getIdMon() {
		
		String sql = "SELECT * FROM project.mon";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		 try {
			 
			PreparedStatement statement =conn.prepareStatement(sql);
			ResultSet   rs = statement.executeQuery();
			
		  while (rs.next()) {

		   // Display comboBox set from databse
		   jcbMonDay.addItem(rs.getString("idmon"));  
		  	}
		  
		 } catch (Exception e) {
		  e.printStackTrace();
		 } finally {
			connectUtil.disconnect(conn);
		 }
	}
	
	private void showTableBangDiem() {
		// Name Column table
	
		Vector<String> cols = new Vector<String>();
		cols.addElement("STT");
		cols.addElement("ID Học Sinh");
		cols.addElement("Tên Học Sinh");
		cols.addElement("Điểm 15p");
		cols.addElement("Điểm 45p");
		cols.addElement("Điểm thi");
		cols.addElement("Tổng Kết");
		cols.addElement("Kết Quả");
		cols.addElement("Môn");
		cols.addElement("Lớp");
		cols.addElement("ID Giáo Viên");
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		// Data table
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			
			
			PreparedStatement statement = conn.prepareStatement("Select * From  project.diem INNER JOIN project.sinhvien ON diem.idhs = sinhvien.idhs INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.lop ON sinhvien.idlop = lop.idlop");
			ResultSet result = statement.executeQuery();
			
			int i = 0;
			while (result.next()) {
				
				Vector xemdiem = new Vector<Object>();
				
				xemdiem.addElement(i++);
				xemdiem.addElement(result.getString("diem.idhs"));
				xemdiem.addElement(result.getString("sinhvien.hoten"));
				xemdiem.addElement(result.getFloat("diem.diem15"));
				xemdiem.addElement(result.getFloat("diem.diem45"));
				xemdiem.addElement(result.getFloat("diem.diemthi"));
				xemdiem.addElement(result.getFloat("diem.tongket"));
				xemdiem.addElement(result.getString("diem.ketqua"));
				xemdiem.addElement(result.getString("mon.mon"));
				xemdiem.addElement(result.getString("lop.lop"));
				xemdiem.addElement(result.getString("diem.idgv"));
				
				data.add(xemdiem);
			}
		} catch (Exception e) {
			
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
	
}
	
	private void showTableSinhVienSearch() {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("ID");
		cols.addElement("Họ Tên");
		cols.addElement("ID Lớp");
		cols.addElement("Ngày Sinh");
		cols.addElement("Địa Chỉ");
		cols.addElement("Giới Tính");
		cols.addElement("Số Điện Thoại");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.sinhvien";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
		
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
	
			while (result.next()) {
				Vector hocsinh = new Vector();
				hocsinh.addElement(result.getString("idhs"));
				hocsinh.addElement(result.getString("hoten"));
				hocsinh.addElement(result.getString("idlop"));
				hocsinh.addElement(result.getDate("ngaysinh"));
				hocsinh.addElement(result.getString("diachi"));
				hocsinh.addElement(result.getString("gioitinh"));
				hocsinh.addElement(result.getString("sdt"));

				data.add(hocsinh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table_Searchsinhvien.setModel(new DefaultTableModel(data, cols));
	}
	
	public void showTableGiaoVienSearch() {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("ID");
		cols.addElement("Họ Tên");
		cols.addElement("ID Môn Dạy");
		cols.addElement("Ngày Sinh");
		cols.addElement("Giới Tính");
		cols.addElement("Email");
		cols.addElement("Số Điện Thoại");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.giaovien";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Vector giaovien = new Vector();
				giaovien.addElement(result.getString("idgv"));
				giaovien.addElement(result.getString("hoten"));
				giaovien.addElement(result.getString("idmon"));
				giaovien.addElement(result.getDate("ngaysinh"));
				giaovien.addElement(result.getString("gioitinh"));
				giaovien.addElement(result.getString("email"));
				giaovien.addElement(result.getString("sdt"));
				
				data.add(giaovien);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table_Searchgiaovien.setModel(new DefaultTableModel(data, cols));
	}
	
	public void showTableLopSearch() {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã Lớp");
		cols.addElement("Tên Lớp");
	
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.lop";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Vector lop = new Vector();
				
				lop.addElement(result.getString("idlop"));
				lop.addElement(result.getString("lop"));
	
				data.add(lop);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table_Searchlop.setModel(new DefaultTableModel(data, cols));
	}
	
	public void showTableMonSearch() {
		// Name Column table
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã Môn Học");
		cols.addElement("Tên Môn Học");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.mon";
		
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Vector mon = new Vector();
			
				mon.addElement(result.getString("idmon"));
				mon.addElement(result.getString("mon"));
	
				data.add(mon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		table_Searchmon.setModel(new DefaultTableModel(data, cols));
	}
	
	public void DangXuat() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		int hoi = JOptionPane.showConfirmDialog(null, "                 Thoát hả?", null,
				JOptionPane.YES_NO_OPTION);
		if (hoi == JOptionPane.YES_OPTION) {
			this.dispose();
			LoginFrame loginframe = new LoginFrame();
			loginframe.setVisible(true);
		}
	}
}
