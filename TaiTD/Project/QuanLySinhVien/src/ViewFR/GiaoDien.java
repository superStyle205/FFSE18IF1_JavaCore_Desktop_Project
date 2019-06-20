package ViewFR;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.DiemDao;
import Dao.GiaoVienDao;
import Dao.HocSinhDao;
import Dao.KhoaDao;
import Dao.LopDao;
import Dao.MonHocDao;
import model.bean.Diem;
import model.bean.GiaoVien;
import model.bean.HocSinh;
import model.bean.Khoa;
import model.bean.Lop;
import model.bean.MonHoc;
import javax.swing.ImageIcon;
import java.awt.Font;

public class GiaoDien extends JFrame implements ActionListener, MouseListener {
	

	private JPanel contentPane;
	
	private DefaultTableModel tableModel;
	private DefaultTableModel tableMode2;
	private DefaultTableModel tableMode3;
	private DefaultTableModel tableMode4;
	private DefaultTableModel tableMode5;
	private DefaultTableModel tableMode6;
	
	private JScrollPane jScrollPane;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
		
	private JTextField textField_1_1;	
	private JTextField textField_2_1;	
	private JTextField textField_3_1;
	private JTextField textField_4_1;
	
	private JTextField textField_5_1;
	private JTextField textField_6_1;
	private JTextField textField_7_1;
	private JTextField textField_8_1;
	
	private JTextField textFieldMaKhoa;
	private JTextField textFieldTenKhoa;
	
	private JTextField tfMaLop;
	private JTextField tfTenLop;
	private JTextField tfMaKhoa;
	
	private JTextField tfMaMonHoc;
	private JTextField tfTenMonHoc;
	private JTextField tfSoGio;
	
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;;
	
	private CardLayout cardlayout;
	
	JPanel panel_4;

	private JButton btnThm, btnSa, btnXa, btnRs;
	private JButton btnThm1, btnSa1, btnXa1, btnRs1;
	private JButton btnThm2, btnSa2, btnXa2, btnRs2;
	private JButton btnThm3, btnSa3, btnXa3, btnRs3;
	private JButton btnThm4, btnSa4, btnXa4, btnRs4;
	private JButton btnThm5, btnSa5, btnXa5, btnRs5;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	private JComboBox gioiTinh;
	
	private HocSinhDao hsDao;
	private DiemDao diemDao;
	private GiaoVienDao gvDao;
	private KhoaDao khoaDao;
	private LopDao lopDao;
	private MonHocDao mhDao;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;

	public static void main(String[] args) {
					GiaoDien frame = new GiaoDien();
					//frame.setVisible(true);
					frame.gg();
	}
	public void gg() {
				di();
				setSize(1131, 686);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				 }
		 public void di(){
				hsDao = new HocSinhDao();
				gvDao = new GiaoVienDao();
				diemDao = new DiemDao();
				khoaDao = new KhoaDao();
				lopDao = new LopDao();
				mhDao = new MonHocDao();

				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(0, 0, 1115, 686);
				contentPane.add(tabbedPane);

				JPanel panel = new JPanel();
				tabbedPane.addTab("Trang chủ", null, panel, null);
				panel.setLayout(null);
				
				JPanel panel_11 = new JPanel();
				panel_11.setBounds(10, 11, 1090, 299);
				panel.add(panel_11);
				panel_11.setLayout(null);
				
				lblNewLabel_7 = new JLabel("New label");
				lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\2016115182418520.jpg"));
				lblNewLabel_7.setBounds(365, 11, 463, 259);
				panel_11.add(lblNewLabel_7);

				JPanel panel_1 = new JPanel();
				tabbedPane.addTab("Quản Lý", null, panel_1, null);
				panel_1.setLayout(null);

				JPanel panel_3 = new JPanel();
				panel_3.setBounds(12, 12, 181, 534);
				panel_3.setBackground(new Color(224, 255, 255));
				panel_1.add(panel_3);
				panel_3.setLayout(null);

				JPanel panel_5 = new JPanel();
				JPanel panel_6 = new JPanel();
				JPanel panel_7 = new JPanel();
				JPanel panel_8 = new JPanel();
				JPanel panel_9 = new JPanel();
				JPanel panel_10 = new JPanel();

				JButton btnNewButton = new JButton("Quản Lý Học Sinh");

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardlayout.show(panel_4, "card1");
					}
				});
				btnNewButton.setBounds(12, 25, 157, 47);
				panel_3.add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Quản Lý Giáo Viên");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardlayout.show(panel_4, "card2");
					}
				});
				btnNewButton_1.setBounds(12, 103, 157, 47);
				panel_3.add(btnNewButton_1);

				JButton btnNewButton_2 = new JButton("Quản Lý Điểm");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardlayout.show(panel_4, "card3");
					}
				});
				btnNewButton_2.setBounds(12, 189, 157, 47);
				panel_3.add(btnNewButton_2);

				JButton btnNewButton_3 = new JButton("Quản Lý Khoa");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardlayout.show(panel_4, "card4");
					}
				});
				btnNewButton_3.setBounds(12, 264, 157, 47);
				panel_3.add(btnNewButton_3);

				JButton btnNewButton_4 = new JButton("Quản Lý Lớp");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardlayout.show(panel_4, "card5");
					}
				});
				btnNewButton_4.setBounds(12, 346, 157, 47);
				panel_3.add(btnNewButton_4);

				JButton btnNewButton_5 = new JButton("Quản Lý Môn");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cardlayout.show(panel_4, "card6");
					}
				});
				btnNewButton_5.setBounds(12, 428, 157, 47);
				panel_3.add(btnNewButton_5);
		// quản lý học sinh
				panel_5.setBackground(new Color(224, 255, 255));
			    panel_5.setLayout(null);

			    lblNewLabel = new JLabel("Mã Sinh Viên :");
			    lblNewLabel.setBounds(12, 65, 85, 28);
				panel_5.add(lblNewLabel);

				textField = new JTextField();
				textField.setBounds(108, 68, 108, 25);
				panel_5.add(textField);
				textField.setColumns(10);

				JLabel lblNewLabel_1 = new JLabel("Tên Sinh Viên :");
				lblNewLabel_1.setBounds(12, 102, 85, 28);
				panel_5.add(lblNewLabel_1);

				textField_1 = new JTextField();
				textField_1.setBounds(108, 104, 108, 25);
				panel_5.add(textField_1);
				textField_1.setColumns(10);

				JLabel lblNewLabel_2 = new JLabel("Lớp :");
				lblNewLabel_2.setBounds(12, 161, 55, 16);
				panel_5.add(lblNewLabel_2);

				textField_2 = new JTextField();
				textField_2.setBounds(108, 157, 108, 25);
				panel_5.add(textField_2);
				textField_2.setColumns(10);

				JLabel lblNewLabel_3 = new JLabel("Giới Tính :");
				lblNewLabel_3.setBounds(12, 208, 61, 16);
				panel_5.add(lblNewLabel_3);

				gioiTinh = new JComboBox<>();
				gioiTinh.setBounds(108, 204, 108, 25);
				panel_5.add(gioiTinh);
				gioiTinh.addItem("");
				gioiTinh.addItem("Nam");
				gioiTinh.addItem("Nữ");
			
				JLabel lblNmSinh = new JLabel("Ngày Sinh :");
				lblNmSinh.setBounds(12, 260, 85, 16);
				panel_5.add(lblNmSinh);

				textField_4 = new JTextField();
				textField_4.setBounds(108, 251, 108, 25);
				panel_5.add(textField_4);
				textField_4.setColumns(10);

				btnThm = new JButton("Thêm");
				btnThm.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\add-icon.png"));
				btnThm.setBounds(66, 304, 121, 39);
				panel_5.add(btnThm);

				btnSa = new JButton("Sửa");
				btnSa.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\redo-icon.png"));
				btnSa.setBounds(66, 373, 120, 39);
				btnSa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				panel_5.add(btnSa);

				btnXa = new JButton("Xóa");
				btnXa.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\delete-icon.png"));
				btnXa.setBounds(66, 443, 120, 39);
				panel_5.add(btnXa);

				btnRs = new JButton("Reset");
				btnRs.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\Clear-icon.png"));
				btnRs.setBounds(66, 504, 120, 39);
				panel_5.add(btnRs);
				
				tableModel = new DefaultTableModel();
				tableModel.addColumn("Mã Sinh Viên");
				tableModel.addColumn("Tên Sinh Viên");
				tableModel.addColumn("Lớp");
				tableModel.addColumn("Giới Tính");
				tableModel.addColumn("Ngày Sinh");

				table = new JTable(tableModel);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(246, 55, 630, 529);
				panel_5.add(scrollPane);

				btnThm.addActionListener(this);
				btnSa.addActionListener(this);
				btnXa.addActionListener(this);
				btnRs.addActionListener(this);
				
				table.addMouseListener(this);

				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("Tìm Kiếm", null, panel_2, null);
				panel_2.setLayout(null);
		
				loadDataSV();
				
				panel_4 = new JPanel();
				panel_4.setBounds(220, 11, 890, 598);
				cardlayout = new CardLayout();
				panel_4.setLayout(cardlayout);

				panel_4.add("card1", panel_5);
				
				lblNewLabel_8 = new JLabel("                              QUẢN LÝ SINH VIÊN");
				lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNewLabel_8.setBounds(204, 11, 420, 33);
				panel_5.add(lblNewLabel_8);
				panel_4.add("card2", panel_6);
				panel_4.add("card3", panel_7);
				panel_4.add("card4", panel_8);
				panel_4.add("card5", panel_9);
				panel_4.add("card6", panel_10);

				panel_4.setBorder(UIManager.getBorder("DesktopIcon.border"));
				panel_4.setBackground(SystemColor.menu);
				panel_1.add(panel_4);
				
		//quản lý giáo viên
				panel_6.setBackground(new Color(224, 255, 255));
				panel_6.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Mã Giáo Viên :");
				lblNewLabel.setBounds(12, 87, 85, 28);
				panel_6.add(lblNewLabel);

				textField_1_1 = new JTextField();
				textField_1_1.setBounds(108, 89, 108, 25);
				panel_6.add(textField_1_1);
				textField_1_1.setColumns(10);

				 lblNewLabel_4 = new JLabel("Tên Giáo Viên :");
				 lblNewLabel_4.setBounds(12, 137, 85, 28);
				panel_6.add(lblNewLabel_4);

				textField_2_1 = new JTextField();
				textField_2_1.setBounds(108, 139, 108, 25);
				panel_6.add(textField_2_1);
				textField_2_1.setColumns(10);

				 lblNewLabel_5 = new JLabel("Chuyên Ngành :");
				 lblNewLabel_5.setBounds(12, 193, 95, 16);
				panel_6.add(lblNewLabel_5);

				textField_3_1 = new JTextField();
				textField_3_1.setBounds(108, 189, 108, 25);
				panel_6.add(textField_3_1);
				textField_3_1.setColumns(10);

				 lblNewLabel_6 = new JLabel("Mã Khoa :");
				 lblNewLabel_6.setBounds(20, 242, 61, 16);
				panel_6.add(lblNewLabel_6);

				textField_4_1 = new JTextField();
				textField_4_1.setBounds(108, 238, 108, 25);
				panel_6.add(textField_4_1);
				textField_4_1.setColumns(10);

				btnThm1 = new JButton("Thêm");
				btnThm1.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\add-icon.png"));
				btnThm1.setBounds(66, 288, 121, 39);
				panel_6.add(btnThm1);

				btnSa1 = new JButton("Sửa");
				btnSa1.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\redo-icon.png"));
				btnSa1.setBounds(66, 360, 120, 39);
				panel_6.add(btnSa1);

				btnXa1 = new JButton("Xóa");
				btnXa1.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\delete-icon.png"));
				btnXa1.setBounds(65, 432, 120, 39);
				panel_6.add(btnXa1);

				btnRs1 = new JButton("Reset");
				btnRs1.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\Clear-icon.png"));
				btnRs1.setBounds(65, 497, 120, 39);
				panel_6.add(btnRs1);
				
				tableMode2 = new DefaultTableModel();
				tableMode2.addColumn("Mã Giáo Viên");
				tableMode2.addColumn("Tên Giáo Viên");
				tableMode2.addColumn("Chuyên Ngành");
				tableMode2.addColumn("Mã Khoa");

				table_1 = new JTable(tableMode2);
			    jScrollPane = new JScrollPane(table_1);
			    jScrollPane.setBounds(246, 56, 630, 529);
				panel_6.add(jScrollPane);
				
				lblNewLabel_9 = new JLabel("              QUẢN LÝ GIÁO VIÊN");
				lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNewLabel_9.setBounds(246, 11, 343, 34);
				panel_6.add(lblNewLabel_9);
				
				btnThm1.addActionListener(this);
				btnSa1.addActionListener(this);
				btnXa1.addActionListener(this);
				btnRs1.addActionListener(this);
				
				table_1.addMouseListener(this);
		        loadDataGV();
		
		//quản lý điểm
		
				panel_7.setBackground(new Color(224, 255, 255));
				panel_7.setLayout(null);
		
				lblNewLabel = new JLabel("Mã Sinh Viên :");
				lblNewLabel.setBounds(12, 85, 85, 28);
				panel_7.add(lblNewLabel);
		
				textField_5_1 = new JTextField();
				textField_5_1.setBounds(108, 87, 108, 25);
				panel_7.add(textField_5_1);
				textField_5_1.setColumns(10);
		
				 lblNewLabel_4 = new JLabel("Mã Môn Học :");
				 lblNewLabel_4.setBounds(12, 138, 85, 28);
				panel_7.add(lblNewLabel_4);
		
				textField_6_1 = new JTextField();
				textField_6_1.setBounds(108, 140, 108, 25);
				panel_7.add(textField_6_1);
				textField_6_1.setColumns(10);
		
				 lblNewLabel_5 = new JLabel("Lần Thi :");
				 lblNewLabel_5.setBounds(12, 193, 95, 16);
				panel_7.add(lblNewLabel_5);
		
				textField_7_1 = new JTextField();
				textField_7_1.setBounds(108, 189, 108, 25);
				panel_7.add(textField_7_1);
				textField_7_1.setColumns(10);
		
				 lblNewLabel_6 = new JLabel("Điểm Thi :");
				 lblNewLabel_6.setBounds(12, 237, 61, 16);
				panel_7.add(lblNewLabel_6);
		
				textField_8_1 = new JTextField();
				textField_8_1.setBounds(108, 233, 108, 25);
				panel_7.add(textField_8_1);
				textField_8_1.setColumns(10);
				
				btnThm2 = new JButton("Thêm");
				btnThm2.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\add-icon.png"));
				btnThm2.setBounds(65, 287, 121, 39);
				panel_7.add(btnThm2);
		
				btnSa2 = new JButton("Sửa");
				btnSa2.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\redo-icon.png"));
				btnSa2.setBounds(66, 355, 120, 39);
				panel_7.add(btnSa2);
		
				btnXa2 = new JButton("Xóa");
				btnXa2.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\delete-icon.png"));
				btnXa2.setBounds(65, 416, 120, 39);
				panel_7.add(btnXa2);
		
				btnRs2 = new JButton("Reset");
				btnRs2.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\Clear-icon.png"));
				btnRs2.setBounds(65, 490, 120, 39);
				panel_7.add(btnRs2);
				
				tableMode3 = new DefaultTableModel();
				tableMode3.addColumn("Mã Sinh Viên");
				tableMode3.addColumn("Mã Môn Học");
				tableMode3.addColumn("Lần thi");
				tableMode3.addColumn("Điểm Thi");
		
				table_2 = new JTable(tableMode3);
			    jScrollPane = new JScrollPane(table_2);
			    jScrollPane.setBounds(246, 56, 630, 529);
				panel_7.add(jScrollPane);
				
				lblNewLabel_10 = new JLabel("                            QUẢN LÝ ĐIỂM");
				lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNewLabel_10.setBounds(246, 11, 410, 34);
				panel_7.add(lblNewLabel_10);
				
				btnThm2.addActionListener(this);
				btnSa2.addActionListener(this);
				btnXa2.addActionListener(this);
				btnRs2.addActionListener(this);
				
				table_2.addMouseListener(this);
				loadDataDiem();
		//quản lý khoa
				panel_8.setBackground(new Color(224, 255, 255));
				panel_8.setLayout(null);
		
				lblNewLabel = new JLabel("Mã Khoa :");
				lblNewLabel.setBounds(63, 147, 85, 28);
				panel_8.add(lblNewLabel);
		
				textFieldMaKhoa = new JTextField();
				textFieldMaKhoa.setBounds(171, 149, 108, 25);
				panel_8.add(textFieldMaKhoa);
				textFieldMaKhoa.setColumns(10);
		
				 lblNewLabel_4 = new JLabel("Mã Môn Học :");
				 lblNewLabel_4.setBounds(63, 205, 85, 28);
				 panel_8.add(lblNewLabel_4);
		
				 textFieldTenKhoa = new JTextField();
				 textFieldTenKhoa.setBounds(171, 207, 108, 25);
				panel_8.add(textFieldTenKhoa);
				textFieldTenKhoa.setColumns(10);
				
				btnThm3 = new JButton("Thêm");
				btnThm3.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\add-icon.png"));
				btnThm3.setBounds(52, 357, 121, 39);
				panel_8.add(btnThm3);
		
				btnSa3 = new JButton("Sửa");
				btnSa3.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\redo-icon.png"));
				btnSa3.setBounds(199, 357, 120, 39);
				panel_8.add(btnSa3);
		
				btnXa3 = new JButton("Xóa");
				btnXa3.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\delete-icon.png"));
				btnXa3.setBounds(52, 435, 120, 39);
				panel_8.add(btnXa3);
		
				btnRs3 = new JButton("Reset");
				btnRs3.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\Clear-icon.png"));
				btnRs3.setBounds(199, 435, 120, 39);
				panel_8.add(btnRs3);
				
				tableMode4 = new DefaultTableModel();
				tableMode4.addColumn("Mã Khoa");
				tableMode4.addColumn("Mã Môn Học");
		
				table_3 = new JTable(tableMode4);
			    jScrollPane = new JScrollPane(table_3);
			    jScrollPane.setBounds(403, 55, 473, 529);
			    panel_8.add(jScrollPane);
			    
			    lblNewLabel_11 = new JLabel("                 QUẢN LÝ KHOA");
			    lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
			    lblNewLabel_11.setBounds(273, 11, 267, 28);
			    panel_8.add(lblNewLabel_11);
				
				btnThm3.addActionListener(this);
				btnSa3.addActionListener(this);
				btnXa3.addActionListener(this);
				btnRs3.addActionListener(this);
				
				table_3.addMouseListener(this);
				
				loadDataKhoa();
		//quản lý lớp
				panel_9.setBackground(new Color(224, 255, 255));
				panel_9.setLayout(null);
		
				lblNewLabel = new JLabel("Mã Lớp :");
				lblNewLabel.setBounds(57, 155, 85, 28);
				panel_9.add(lblNewLabel);
		
				tfMaLop = new JTextField();
				tfMaLop.setBounds(152, 157, 108, 25);
				panel_9.add(tfMaLop);
				tfMaLop.setColumns(10);
		
				lblNewLabel_4 = new JLabel("Tên Lớp :");
				lblNewLabel_4.setBounds(57, 206, 85, 28);
				panel_9.add(lblNewLabel_4);
		
				tfTenLop = new JTextField();
				tfTenLop.setBounds(152, 208, 108, 25);
				panel_9.add(tfTenLop);
				tfTenLop.setColumns(10);
		
				 lblNewLabel_5 = new JLabel("Mã Khoa :");
				 lblNewLabel_5.setBounds(57, 270, 95, 16);
				 panel_9.add(lblNewLabel_5);
		
				tfMaKhoa = new JTextField();
				tfMaKhoa.setBounds(152, 266, 108, 25);
				panel_9.add(tfMaKhoa);
				tfMaKhoa.setColumns(10);
				
				btnThm4 = new JButton("Thêm");
				btnThm4.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\add-icon.png"));
				btnThm4.setBounds(57, 356, 121, 39);
				panel_9.add(btnThm4);
		
				btnSa4 = new JButton("Sửa");
				btnSa4.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\redo-icon.png"));
				btnSa4.setBounds(199, 356, 120, 39);
				panel_9.add(btnSa4);
		
				btnXa4 = new JButton("Xóa");
				btnXa4.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\delete-icon.png"));
				btnXa4.setBounds(53, 426, 120, 39);
				panel_9.add(btnXa4);
		
				btnRs4 = new JButton("Reset");
				btnRs4.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\Clear-icon.png"));
				btnRs4.setBounds(199, 426, 120, 39);
				panel_9.add(btnRs4);
				
				tableMode5 = new DefaultTableModel();
				tableMode5.addColumn("Mã Lớp");
				tableMode5.addColumn("Tên Lớp");
				tableMode5.addColumn("Mã Khoa");
		
				table_4 = new JTable(tableMode5);
			    jScrollPane = new JScrollPane(table_4);
			    jScrollPane.setBounds(373, 57, 503, 529);
			    panel_9.add(jScrollPane);
			    
			    lblNewLabel_12 = new JLabel("                   QUẢN LÝ LỚP");
			    lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
			    lblNewLabel_12.setBounds(254, 11, 267, 31);
			    panel_9.add(lblNewLabel_12);
				
				btnThm4.addActionListener(this);
				btnSa4.addActionListener(this);
				btnXa4.addActionListener(this);
				btnRs4.addActionListener(this);
				
				table_4.addMouseListener(this);
				loadDataLop();
		//quản lý Môn Học
				panel_10.setBackground(new Color(224, 255, 255));
				panel_10.setLayout(null);
		
				lblNewLabel = new JLabel("Mã Môn Học :");
				lblNewLabel.setBounds(57, 186, 85, 28);
				panel_10.add(lblNewLabel);
		
				tfMaMonHoc = new JTextField();
				tfMaMonHoc.setBounds(152, 188, 108, 25);
				panel_10.add(tfMaMonHoc);
				tfMaMonHoc.setColumns(10);
		
				lblNewLabel_4 = new JLabel("Tên Môn Học :");
				lblNewLabel_4.setBounds(57, 236, 85, 28);
				panel_10.add(lblNewLabel_4);
		
				tfTenMonHoc = new JTextField();
				tfTenMonHoc.setBounds(152, 238, 108, 25);
				panel_10.add(tfTenMonHoc);
				tfTenMonHoc.setColumns(10);
		
				 lblNewLabel_5 = new JLabel("Số Giờ :");
				 lblNewLabel_5.setBounds(57, 289, 95, 16);
				 panel_10.add(lblNewLabel_5);
		
				tfSoGio = new JTextField();
				tfSoGio.setBounds(152, 285, 108, 25);
				panel_10.add(tfSoGio);
				tfSoGio.setColumns(10);
				
				btnThm5 = new JButton("Thêm");
				btnThm5.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\add-icon.png"));
				btnThm5.setBounds(57, 356, 121, 39);
				panel_10.add(btnThm5);
		
				btnSa5 = new JButton("Sửa");
				btnSa5.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\redo-icon.png"));
				btnSa5.setBounds(199, 356, 120, 39);
				panel_10.add(btnSa5);
		
				btnXa5 = new JButton("Xóa");
				btnXa5.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\delete-icon.png"));
				btnXa5.setBounds(53, 422, 120, 39);
				panel_10.add(btnXa5);
		
				btnRs5 = new JButton("Reset");
				btnRs5.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\ảnh của ben\\Clear-icon.png"));
				btnRs5.setBounds(199, 422, 120, 39);
				panel_10.add(btnRs5);
				
				tableMode6 = new DefaultTableModel();
				tableMode6.addColumn("Mã Môn Học");
				tableMode6.addColumn("Tên Môn Học");
				tableMode6.addColumn("Số Giờ");
		
				table_5 = new JTable(tableMode6);
			    jScrollPane = new JScrollPane(table_5);
			    jScrollPane.setBounds(373, 57, 503, 529);
			    panel_10.add(jScrollPane);
			    
			    lblNewLabel_13 = new JLabel("           QUẢN LÝ MÔN");
			    lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 17));
			    lblNewLabel_13.setBounds(273, 11, 191, 29);
			    panel_10.add(lblNewLabel_13);
				
				btnThm5.addActionListener(this);
				btnSa5.addActionListener(this);
				btnXa5.addActionListener(this);
				btnRs5.addActionListener(this);
				
				table_5.addMouseListener(this);
				loadDataMH();
	}
	private void loadDataSV() {
		tableModel.setRowCount(0);
		ArrayList<HocSinh> listHS = hsDao.getAllSV();
		for (HocSinh hs : listHS) {
			tableModel.addRow(new String[] { "" + hs.getMaSinhVien(), hs.getTenSinhVien(), hs.getLop(),
					hs.getGioiTinh(), hs.getNgaySinh() });
		}
	}
	private void loadDataGV(){
		tableMode2.setRowCount(0);
		ArrayList<GiaoVien> listGV = gvDao.getAllGV();
		for (GiaoVien gv : listGV){
			tableMode2.addRow(new String[] {"" + gv.getMaGV(), gv.getTenGV(), gv.getChuyenNganh(), gv.getMaKhoa()});
		}
	}
	private void loadDataDiem(){
		tableMode3.setRowCount(0);
		ArrayList<Diem> listDiem = diemDao.getAllDiem();
		for (Diem dd : listDiem){
			tableMode3.addRow(new String[] {"" + dd.getMaSV(), dd.getMaMH(), dd.getLanThi(), dd.getDiemThi()});
		}
	}
	private void loadDataKhoa(){
		tableMode4.setRowCount(0);
		ArrayList<Khoa> listKhoa = khoaDao.getAllKhoa();
		for (Khoa kk : listKhoa){
			tableMode4.addRow(new String[] {"" + kk.getMaKhoa(), kk.getTenKhoa()});
		}
	}
	private void loadDataLop(){
		tableMode5.setRowCount(0);
		ArrayList<Lop> listLop = lopDao.getAllLop();
		for (Lop ll : listLop){
			tableMode5.addRow(new String[] {"" + ll.getMaLop(), ll.getTenLop(), ll.getMaKhoa()});
		}
	}
	private void loadDataMH(){
		tableMode6.setRowCount(0);
		ArrayList<MonHoc> listMH = mhDao.getAllMH();
		for (MonHoc mh : listMH){
			tableMode6.addRow(new String[] {"" + mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getSoGio()});
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()== table){
			int rowSelected = table.getSelectedRow();
			textField.setText((String) table.getValueAt(rowSelected, 0));
			textField_1.setText((String) table.getValueAt(rowSelected, 1));
			textField_2.setText((String) table.getValueAt(rowSelected, 2));
			gioiTinh.setSelectedItem((String) table.getValueAt(rowSelected, 3));
			textField_4.setText((String) table.getValueAt(rowSelected, 4));
		}else if(e.getSource()==table_1){
			int gv = table_1.getSelectedRow();
			textField_1_1.setText((String) table_1.getValueAt(gv, 0));
			textField_2_1.setText((String) table_1.getValueAt(gv, 1));
			textField_3_1.setText((String) table_1.getValueAt(gv, 2));
			textField_4_1.setText((String) table_1.getValueAt(gv, 3));
		}else if(e.getSource()==table_2){
			int dd = table_2.getSelectedRow();
			textField_5_1.setText((String) table_2.getValueAt(dd, 0));
			textField_6_1.setText((String) table_2.getValueAt(dd, 1));
			textField_7_1.setText((String) table_2.getValueAt(dd, 2));
			textField_8_1.setText((String) table_2.getValueAt(dd, 3));
		}else if(e.getSource()==table_3){
			int kk = table_3.getSelectedRow();
			textFieldMaKhoa.setText((String) table_3.getValueAt(kk, 0));
			textFieldTenKhoa.setText((String) table_3.getValueAt(kk, 1));
		}else if(e.getSource()==table_4){
			int ll = table_4.getSelectedRow();
			tfMaLop.setText((String) table_4.getValueAt(ll, 0));
			tfTenLop.setText((String) table_4.getValueAt(ll,1));
			tfMaKhoa.setText((String) table_4.getValueAt(ll, 2));
		}else if(e.getSource()==table_5){
			int mh = table_5.getSelectedRow();
			tfMaMonHoc.setText((String) table_5.getValueAt(mh, 0));
			tfTenMonHoc.setText((String) table_5.getValueAt(mh,1));
			tfSoGio.setText((String) table_5.getValueAt(mh, 2));
		}
  
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object action = e.getSource();
		if (action == btnThm) {
			addSV();
			loadDataSV();
		} else if (action == btnSa) {
			updateSV();
			loadDataSV();
		} else if (action == btnXa) {
			deleteSV();
			loadDataSV();
		} else {
			clearHS();
		}
		
		 Object action1 = e.getSource();	
		    if(action1 == btnThm1){
		    	addGV();
		    	loadDataGV();
		    }else if (action1 == btnSa1){
		    	updateGV();
		    	loadDataGV();
		    }else if (action1 == btnXa1) {
				deleteGV();
				loadDataGV();
		    }else {
		    	clearGV();
		    }
		
		    Object action2 = e.getSource();	
		    if(action2 == btnThm2){
		    	addDiem();
		    	loadDataDiem();
		    }else if (action2 == btnSa2){
		    	updateDiem();
		    	loadDataDiem();
		    }else if (action2 == btnXa2) {
				deleteDiem();
				loadDataDiem();
		    }else {
		    	clearDiem();
		    }
		    
		    Object action3 = e.getSource();	
		    if(action3 == btnThm3){
		    	addKhoa();
		    	loadDataKhoa();
		    }else if (action3 == btnSa3){
		    	updateKhoa();
		    	loadDataKhoa();
		    }else if (action3 == btnXa3) {
				deleteKhoa();
				loadDataKhoa();
		    }else {
		    	clearKhoa();
		    }
		    
		    Object action4 = e.getSource();	
		    if(action4 == btnThm4){
		    	addLop();
		    	loadDataLop();
		    }else if (action4 == btnSa4){
		    	updateLop();
		    	loadDataLop();
		    }else if (action4 == btnXa4) {
				deleteLop();
				loadDataLop();
		    }else {
		    	clearLop();
		    }
		    
		    Object action5 = e.getSource();	
		    if(action5 == btnThm5){
		    	addMH();
		    	loadDataMH();
		    }else if (action5 == btnSa5){
		    	updateMH();
		    	loadDataMH();
		    }else if (action5 == btnXa5) {
				deleteMH();
				loadDataMH();
		    }else {
		    	clearMH();
		    }
	}
	
	// quản lý Sinh vien
			private void clearHS() {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				gioiTinh.setSelectedItem("");
				textField_4.setText("");
				
				}
			private void deleteSV() {
				String hs = (String) table.getValueAt(table.getSelectedRow(), 0);
				hsDao.deleteUser(hs);
			}
			private void updateSV() {
				//System.out.println(textField.getText());
				HocSinh hs = new HocSinh();
				hs.setMaSinhVien(textField.getText());
				hs.setTenSinhVien(textField_1.getText());
				hs.setLop(textField_2.getText());
				hs.setGioiTinh(gioiTinh.getSelectedItem().toString());
				hs.setNgaySinh(textField_4.getText());
				hsDao.updateUser(hs);
			}
			private void addSV() {
				
				HocSinh hs = new HocSinh();
				hs.setMaSinhVien(textField.getText());
				hs.setTenSinhVien(textField_1.getText());
				hs.setLop(textField_2.getText());
			    hs.setGioiTinh(gioiTinh.getSelectedItem().toString());
				hs.setNgaySinh(textField_4.getText());
				hsDao.addUser(hs);
			}
    // quản lý giáo viên
			private void addGV(){
				
				GiaoVien gv = new GiaoVien();
				gv.setMaGV(textField_1_1.getText());
				gv.setTenGV(textField_2_1.getText());
				gv.setChuyenNganh(textField_3_1.getText());
				gv.setMaKhoa(textField_4_1.getText());
				gvDao.addGV(gv);
			}
		    private void updateGV(){
		    	GiaoVien gv = new GiaoVien();
				gv.setMaGV(textField_1_1.getText());
				gv.setTenGV(textField_2_1.getText());
				gv.setChuyenNganh(textField_3_1.getText());
				gv.setMaKhoa(textField_4_1.getText());
				gvDao.updateGV(gv);
		    }
		    private void deleteGV(){
		    	String gv = (String) table_1.getValueAt(table_1.getSelectedRow(),0);
		        gvDao.deleteGV(gv);
		    }
		    private void clearGV(){
		    	textField_1_1.setText("");
				textField_2_1.setText("");
				textField_3_1.setText("");
				textField_4_1.setText("");
		    }
    
    //quản lý điểm
			private void addDiem(){
				Diem dd = new Diem();
				dd.setMaSV(textField_5_1.getText());
				dd.setMaMH(textField_6_1.getText());
				dd.setLanThi(textField_7_1.getText());
				dd.setDiemThi(textField_8_1.getText());
				diemDao.addDiem(dd);
			}
			private void updateDiem(){
				Diem dd = new Diem();
				dd.setMaSV(textField_5_1.getText());
				dd.setMaMH(textField_6_1.getText());
				dd.setLanThi(textField_7_1.getText());
				dd.setDiemThi(textField_8_1.getText());
				diemDao.updateDiem(dd);
			}
			private void deleteDiem(){
				String dd = (String) table_2.getValueAt(table_2.getSelectedRow(), 0);
				diemDao.deleteDiem(dd);
			}
			private void clearDiem(){
				textField_5_1.setText("");
				textField_6_1.setText("");
				textField_7_1.setText("");
				textField_8_1.setText("");
			}
	//quản lý khoa
			private void addKhoa(){
				Khoa kk = new Khoa();
				kk.setMaKhoa(textFieldMaKhoa.getText());
				kk.setTenKhoa(textFieldTenKhoa.getText());
				khoaDao.addKhoa(kk);
			}
			private void updateKhoa(){
				Khoa kk = new Khoa();
				kk.setMaKhoa(textFieldMaKhoa.getText());
				kk.setTenKhoa(textFieldTenKhoa.getText());
				khoaDao.updateKhoa(kk);
			}
			private void deleteKhoa(){
				String kk = (String) table_3.getValueAt(table_3.getSelectedRow(),0);
		        khoaDao.deleteKhoa(kk);
			}
			private void clearKhoa(){
				textFieldMaKhoa.setText("");
				textFieldTenKhoa.setText("");
			}
	//quản lý lớp
			private void addLop(){
				Lop ll = new Lop();
				ll.setMaLop(tfMaLop.getText());
				ll.setTenLop(tfTenLop.getText());
				ll.setMaKhoa(tfMaKhoa.getText());
				lopDao.addLop(ll);
			}
			private void updateLop(){
				Lop ll = new Lop();
				ll.setMaLop(tfMaLop.getText());
				ll.setTenLop(tfTenLop.getText());
				ll.setMaKhoa(tfMaKhoa.getText());
				lopDao.updateLop(ll);
			}
			private void deleteLop(){
				String ll = (String) table_4.getValueAt(table_4.getSelectedRow(),0);
		        lopDao.deleteLop(ll);
			}
			private void clearLop(){
				tfMaLop.setText("");
				tfTenLop.setText("");
				tfMaKhoa.setText("");
			}
	//quản lý môn học
			private void addMH(){
				MonHoc mh = new MonHoc();
				mh.setMaMonHoc(tfMaMonHoc.getText());
				mh.setTenMonHoc(tfTenMonHoc.getText());
				mh.setSoGio(tfSoGio.getText());
				mhDao.addMH(mh);
			}
			private void updateMH(){
				MonHoc mh = new MonHoc();
				mh.setMaMonHoc(tfMaMonHoc.getText());
				mh.setTenMonHoc(tfTenMonHoc.getText());
				mh.setSoGio(tfSoGio.getText());
				mhDao.updateMH(mh);
			}
			private void deleteMH(){
				String mh = (String) table_5.getValueAt(table_5.getSelectedRow(),0);
		        mhDao.deleteMH(mh);
			}
			private void clearMH(){
				tfMaMonHoc.setText("");
				tfTenMonHoc.setText("");
				tfSoGio.setText("");
			}
}
