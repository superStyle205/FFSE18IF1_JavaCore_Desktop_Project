package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.bean.HocSinh;
import model.bean.Student;
import model.dao.StudentDao;

public class FormAdminView extends JFrame implements ActionListener, MouseListener {

	// All
	private JScrollPane scroll;

	// Revenue Area (Khu vực doanh thu)
	private JButton btnRevenue;
	private JTable tableRevenue;

	// Student Area (Khu vực học sinh)
	private StudentDao svdao;
	private int idSinhVien;
	private JButton btnAddHS;
	private JButton btnUpdateHS;
	private JButton btnDeleteHS;
	private JButton btnCleanHS;
	private JTable tableHS;
	private JButton btnSearchHS;
	private JTextField searchHS;
	private JLabel lblmahocsinh;
	private JTextField txtmahocsinh;
	private JLabel lblhotem;
	private JTextField txthoten;
	private JLabel lbldiachi;
	private JTextField txtdiachi;
	private JLabel lblemail;
	private JTextField txtemail;
	private JLabel lblmalop;
	private JTextField txtmalop;
	private JLabel lblnamsinh;
	private JTextField txtnamsinh;
	private JLabel lblnamhoc;
	private JTextField txtnamhoc;
	private JComboBox gioitinh;
	private JLabel lblgioitinh;
	// private JTextField txtgioitinh;
	private JLabel lblDeleteValueFood;
	private JTextField deleteValueFood;
	private JButton btnDeletePermanentlyHS;

	// Teacher Area (Khu vực giáo viên )
	private JButton btnSearchGV;
	private JTextField searchGV;
	private JButton btnAddGV;
	private JButton btnUpdateGV;
	private JButton btnDeleteGV;
	private JButton btnCleanGV;
	private JTable tableGV;
	private JLabel lblmagiaovien;
	private JTextField txtgv;
	private JLabel lblhoten;
	private JTextField txthotenn;
	private JLabel lblgioitinhgv;
	private JComboBox gioitinhgv;
	private JLabel lblmalopgv;
	private JTextField txtmalopgv;
	private JLabel lblnamsinhgv;
	private JTextField txtnamsinhgv;

	private JLabel lblDeleteValueFoodCategory;
	private JTextField deleteValueFoodCategory;
	private DefaultTableModel modelgv;
	// private JButton btnDeletePermanentlyFoodCategory;

	// Student records Area (Khu vực hồ sơ học sinh)
	private JButton btnAddTable;
	private JButton btnUpdateTable;
	private JButton btnDeleteTable;
	private JButton btnCleanTable;
	private JTable table;
	private JLabel lblIdTableFood;
	private JTextField idTableFood;
	private JLabel lblTableFoodName;
	private JTextField tableFoodName;
	private JLabel lblStatus;
	private JTextField tableStatus;
	private JLabel lblDeleteValueTable;
	private JTextField deleteValueTable;
	private JButton btnDeletePermanentlyTable;

	// Teacher Profile Area (Khu vực hồ sơ giáo viên)
	private JButton btnAddUser;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;
	private JButton btnCleanUser;
	private JTable tableUser;
	private JLabel lblUsername;
	private JTextField username;
	private JLabel lblPassword;
	private JTextField password;
	private JLabel lblType;
	private JTextField type;
	private JLabel lblDeleteValueUser;
	private JTextField deleteValueUser;
	private JButton btnDeletePermanentlyUser;

	// User Area (Khu vực thông tin người dùng)
	private JButton btnAddEmployees;
	private JButton btnUpdateEmployees;
	private JButton btnDeleteEmployees;
	private JButton btnCleanEmployees;
	private JTable tableEmployees;
	private JLabel lblIdEmployees;
	private JTextField idEmployees;
	private JLabel lblUsername_employees;
	private JTextField username_employees;
	private JLabel lblFullName;
	private JTextField fullName;
	private JLabel lblAge;
	private JTextField age;
	private JLabel lblAddress;
	private JTextField address;
	private JLabel lblPhoneNumber;
	private JTextField phoneNumber;
	private JLabel lblHomeTown;
	private JTextField homeTown;
	private JLabel lblIdentityCard;
	private JTextField identityCard;
	private JLabel lblDeleteValueEmployees;
	private JTextField deleteValueEmployees;
	private JButton btnDeletePermanentlyEmployees;

	// thêm icon cho các tap và các nút button thêm , sửa , xóa , clean,.
	ImageIcon imageIconAdd = new ImageIcon("add.png");
	ImageIcon imageIconUpdate = new ImageIcon("update.png");
	ImageIcon imageIconDelete = new ImageIcon("delete.png");
	ImageIcon imageIconClean = new ImageIcon("clean.png");
	ImageIcon imageIconSearch = new ImageIcon("searchh.png");
	ImageIcon imageIconQLHS = new ImageIcon("student.png");
	ImageIcon imageIconQLGV = new ImageIcon("classroom.png");
	ImageIcon imageIconHSHS = new ImageIcon("folder.png");
	ImageIcon imageIconDIEM = new ImageIcon("diem.png");
	ImageIcon imageIconThongke = new ImageIcon("tk.png");
	private DefaultTableModel model;

	public FormAdminView() {
		add(managerTab());
		loadgram();
		// Tiêu đề
		setTitle("Admin");
		// Hiển thị cửa số ra. Nếu false hiển thị mặc định 3 ổ cửa sổ X + -
		setVisible(true);
		// Chỉnh kích thước rộng dài của cửa sổ
		setSize(1200, 700);
		// Hiển thị cửa sổ ở giữa màn hình. Nếu không null nó sẽ xuất hiện ở góc
		// màn hình.
		setLocationRelativeTo(null);
		// Khi click vào X đỏ thì sẽ tắt cửa sổ. Nếu không có hàm này thì sẽ
		// không tắt được.
		setDefaultCloseOperation(0);
		// Tắt chức năng phóng to màn hình của form.
		setResizable(false);
		// Sự kiện khi bấm nút đỏ thoát form thì chỉ thoát form hiện tại.
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();

		JPanel statistical = quanlithongke();
		JSplitPane managerstudent = quanlihocsinh();
		JSplitPane managerteacher = quanligiaovien();
		JSplitPane student = hosohocsinh();
		JSplitPane PointStudent = managerUserArea();
		JSplitPane employees = managerEmployeesArea();

		myTabled.addTab("Thống Kê", imageIconThongke, statistical);
		myTabled.addTab("Quản Lí Học Sinh", imageIconQLHS, managerstudent);
		myTabled.addTab("Quản Lí Giáo Viên", imageIconQLGV, managerteacher);
		myTabled.addTab("Hồ Sơ Học Sinh", imageIconHSHS, student);
		myTabled.addTab("Quản Lí Điểm Học Sinh", imageIconDIEM, PointStudent);
		// myTabled.addTab("Quản Lí Điểm Học Sinh", teacher);
		myTabled.addTab("Quản lí thông tin người dùng", employees);

		return myTabled;
	}

	public JPanel quanlithongke() {
		JPanel panel = new JPanel();

		JPanel managerDate = new JPanel(new GridLayout(1, 3, 5, 5));
		JPanel managerTable = new JPanel();

		btnRevenue = new JButton("Thống kê");
		btnRevenue.addActionListener(this);

		tableRevenue = new JTable(model);
		tableRevenue.setPreferredSize(new Dimension(800, 5000));
		scroll = new JScrollPane(tableRevenue);
		scroll.setPreferredSize(new Dimension(1150, 580));

		managerDate.add(btnRevenue);
		managerTable.add(scroll, tableRevenue);

		panel.add(managerDate);
		panel.add(managerTable);

		return panel;
	}

	public JPanel quanlihocsinhLeft() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddHS = new JButton("Thêm", imageIconAdd);
		btnAddHS.addActionListener(this);
		btnAddHS.setPreferredSize(new Dimension(110, 50));

		btnUpdateHS = new JButton("Sửa", imageIconUpdate);
		btnUpdateHS.addActionListener(this);
		btnUpdateHS.setPreferredSize(new Dimension(110, 50));

		btnDeleteHS = new JButton("Xóa", imageIconDelete);
		btnDeleteHS.addActionListener(this);
		btnDeleteHS.setPreferredSize(new Dimension(110, 50));

		btnCleanHS = new JButton("Clean", imageIconClean);
		btnCleanHS.addActionListener(this);
		btnCleanHS.setPreferredSize(new Dimension(110, 50));

		model = new DefaultTableModel();
		model.addColumn("Mã Học Sinh");
		model.addColumn("Họ Tên");

		model.addColumn("Email");
		model.addColumn("Địa Chỉ");
		model.addColumn("Mã Lớp");
		model.addColumn("Năm Sinh");
		model.addColumn("Năm Học");
		model.addColumn("Giới Tính");

		tableHS = new JTable(model);
		tableHS.addMouseListener(this);
		tableHS.setPreferredSize(new Dimension(500, 2000));
		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableHS);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddHS);
		managerButton.add(btnUpdateHS);
		managerButton.add(btnDeleteHS);
		managerButton.add(btnCleanHS);
		managerTable.add(scroll, tableHS);

		panel.add(managerButton);
		panel.add(managerTable);

		return panel;
	}

	public void loadgram() {
		model.setRowCount(0);
		StudentDao studentDao = new StudentDao();

		ArrayList<HocSinh> listHS = studentDao.getAllUser();
		for (HocSinh hs : listHS) {
			model.addRow(new String[] { "" + hs.getMahocsinh(), hs.getHoten(), hs.getEmail(), hs.getDiachi(),
					hs.getMalop(), hs.getNamsinh(), hs.getNamhoc(), hs.getGioitinh() });
		}

	}

	public JPanel quanlihocsinhRight() {
		JPanel panel = new JPanel();
		JPanel magagerSearch = new JPanel();
		JPanel manager = new JPanel(new GridLayout(16, 1, 5, 5));
		JPanel managerButton = new JPanel();

		// Giao diện phía trên
		searchHS = new JTextField(20);
		btnSearchHS = new JButton("Tìm", imageIconSearch);
		btnSearchHS.addActionListener(this);
		btnSearchHS.setPreferredSize(new Dimension(110, 50));

		// Giao diện phía trái và giữa
		lblmahocsinh = new JLabel("Mã Học Sinh");
		txtmahocsinh = new JTextField(30);
		txtmahocsinh.setEnabled(false);

		lblhotem = new JLabel("Họ Tên");
		txthoten = new JTextField(30);
		lblgioitinh = new JLabel("Giới Tính");
		gioitinh = new JComboBox();
		gioitinh.addItem("");
		gioitinh.addItem("Nam");
		gioitinh.addItem("Nữ");
		lblemail = new JLabel("Email");
		txtemail = new JTextField(30);
		lbldiachi = new JLabel("Địa Chỉ");
		txtdiachi = new JTextField(30);
		lblmalop = new JLabel("Mã Lớp");
		txtmalop = new JTextField(30);
		lblnamsinh = new JLabel("Năm Sinh");
		txtnamsinh = new JTextField(30);
		lblnamhoc = new JLabel("Năm Học");
		txtnamhoc = new JTextField(30);

		// btnDeletePermanentlyHS = new JButton("Xóa vĩnh viễn",
		// imageIconDelete);
		// btnDeletePermanentlyHS.addActionListener(this);
		// btnDeletePermanentlyHS.setPreferredSize(new Dimension(140, 50));

		magagerSearch.add(searchHS);
		magagerSearch.add(btnSearchHS);
		manager.add(lblmahocsinh);
		manager.add(txtmahocsinh);
		manager.add(lblhotem);
		manager.add(txthoten);
		manager.add(lblgioitinh);
		manager.add(gioitinh);
		manager.add(lblemail);
		manager.add(txtemail);
		manager.add(lbldiachi);
		manager.add(txtdiachi);
		manager.add(lblmalop);
		manager.add(txtmalop);
		manager.add(lblnamsinh);
		manager.add(txtnamsinh);
		manager.add(lblnamhoc);
		manager.add(txtnamhoc);

		// manager.setBackground(Color.GREEN);
		// manager.add(lblDeleteValueFood);
		// manager.add(deleteValueFood);
		// managerButton.add(btnDeletePermanentlyHS);

		panel.add(magagerSearch);
		panel.add(manager);
		panel.add(managerButton);

		panel.setBackground(Color.cyan);

		return panel;
	}

	public JSplitPane quanlihocsinh() {
		JSplitPane managerArea = new JSplitPane();

		managerArea.setLeftComponent(quanlihocsinhLeft());
		managerArea.setRightComponent(quanlihocsinhRight());
		managerArea.setDividerLocation(780);

		return managerArea;
	}

	public JPanel quanligiaovienLeft() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddGV = new JButton("Thêm", imageIconAdd);
		btnAddGV.addActionListener(this);
		btnAddGV.setPreferredSize(new Dimension(110, 50));

		btnUpdateGV = new JButton("Sửa", imageIconUpdate);
		btnUpdateGV.addActionListener(this);
		btnUpdateGV.setPreferredSize(new Dimension(110, 50));

		btnDeleteGV = new JButton("Xóa", imageIconDelete);
		btnDeleteGV.addActionListener(this);
		btnDeleteGV.setPreferredSize(new Dimension(110, 50));

		btnCleanGV = new JButton("Clean", imageIconClean);
		btnCleanGV.addActionListener(this);
		btnCleanGV.setPreferredSize(new Dimension(110, 50));

		modelgv = new DefaultTableModel();
		modelgv.addColumn("Mã Giáo Viên");
		modelgv.addColumn("Họ Tên");
		modelgv.addColumn("Giới Tính");
		modelgv.addColumn("Mã Lớp");
		modelgv.addColumn("Năm Sinh");

		tableGV = new JTable(modelgv);
		tableGV.addMouseListener(this);
		tableGV.setPreferredSize(new Dimension(450, 2000));
		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableGV);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddGV);
		managerButton.add(btnUpdateGV);
		managerButton.add(btnDeleteGV);
		managerButton.add(btnCleanGV);
		managerTable.add(scroll, tableGV);

		panel.add(managerButton);
		panel.add(managerTable);

		return panel;
	}

	public JPanel quanligiaovienRight() {
		JPanel panel = new JPanel();

		JPanel manager = new JPanel(new GridLayout(13, 1, 5, 5));
		JPanel managerButton = new JPanel();

		searchGV = new JTextField(20);
		btnSearchGV = new JButton("Tìm", imageIconSearch);
		btnSearchGV.addActionListener(this);
		btnSearchGV.setPreferredSize(new Dimension(100, 50));

		lblmagiaovien = new JLabel("Mã Giáo Viên");
		txtgv = new JTextField(30);
		lblhotem = new JLabel("Họ Tên");
		txthotenn = new JTextField(30);
		lblgioitinhgv = new JLabel("Giới Tính");
		gioitinhgv = new JComboBox<>();
		gioitinhgv.addItem("");
		gioitinhgv.addItem("Nam");
		gioitinhgv.addItem("Nữ");

		lblmalopgv = new JLabel("Mã Lớp");
		txtmalopgv = new JTextField(30);
		lblnamsinhgv = new JLabel("Ngày Sinh");
		txtnamsinhgv = new JTextField(30);

		managerButton.add(searchGV);
		managerButton.add(btnSearchGV);

		manager.add(lblmagiaovien);
		manager.add(txtgv);
		manager.add(lblhotem);
		manager.add(txthotenn);
		manager.add(lblgioitinhgv);
		manager.add(gioitinhgv);
		manager.add(lblmalopgv);
		manager.add(txtmalopgv);
		manager.add(lblnamsinhgv);
		manager.add(txtnamsinhgv);

		panel.add(manager);
		panel.add(managerButton);

		return panel;
	}

	public JSplitPane quanligiaovien() {
		JSplitPane managerArea = new JSplitPane();

		managerArea.setLeftComponent(quanligiaovienLeft());
		managerArea.setRightComponent(quanligiaovienRight());

		managerArea.setDividerLocation(780);

		return managerArea;
	}

	public JPanel hosohocsinhLeft() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddTable = new JButton("Thêm", imageIconAdd);
		btnAddTable.addActionListener(this);
		btnAddTable.setPreferredSize(new Dimension(100, 50));

		btnUpdateTable = new JButton("Sửa", imageIconUpdate);
		btnUpdateTable.addActionListener(this);
		btnUpdateTable.setPreferredSize(new Dimension(100, 50));

		btnDeleteTable = new JButton("Xóa", imageIconDelete);
		btnDeleteTable.addActionListener(this);
		btnDeleteTable.setPreferredSize(new Dimension(100, 50));

		btnCleanTable = new JButton("Clean", imageIconClean);
		btnCleanTable.addActionListener(this);
		btnCleanTable.setPreferredSize(new Dimension(100, 50));

		table = new JTable();
		table.addMouseListener(this);
		table.setPreferredSize(new Dimension(450, 2000));
		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddTable);
		managerButton.add(btnUpdateTable);
		managerButton.add(btnDeleteTable);
		managerButton.add(btnCleanTable);
		managerTable.add(scroll, table);

		panel.add(managerButton);
		panel.add(managerTable);

		return panel;
	}

	public JPanel hosohocsinhRight() {
		JPanel panel = new JPanel();

		JPanel manager = new JPanel(new GridLayout(9, 1, 5, 5));
		JPanel managerButton = new JPanel();
		// Giao diện phía trái và giữa
		lblIdTableFood = new JLabel("ID");
		idTableFood = new JTextField(30);
		idTableFood.setEnabled(false);
		lblTableFoodName = new JLabel("Tên bàn");
		tableFoodName = new JTextField(30);
		lblStatus = new JLabel("Trạng thái");
		tableStatus = new JTextField(30);
		lblDeleteValueTable = new JLabel("Giá trị xóa");
		deleteValueTable = new JTextField(30);
		btnDeletePermanentlyTable = new JButton("Xóa vĩnh viễn", imageIconDelete);
		btnDeletePermanentlyTable.addActionListener(this);
		btnDeletePermanentlyTable.setPreferredSize(new Dimension(140, 50));

		manager.add(lblIdTableFood);
		manager.add(idTableFood);
		manager.add(lblTableFoodName);
		manager.add(tableFoodName);
		manager.add(lblStatus);
		manager.add(tableStatus);
		manager.add(lblDeleteValueTable);
		manager.add(deleteValueTable);
		managerButton.add(btnDeletePermanentlyTable);

		panel.add(manager);
		panel.add(managerButton);

		return panel;
	}

	public JSplitPane hosohocsinh() {
		JSplitPane managerArea = new JSplitPane();

		managerArea.setLeftComponent(hosohocsinhLeft());
		managerArea.setRightComponent(hosohocsinhRight());

		managerArea.setDividerLocation(780);

		return managerArea;
	}

	public JPanel managerUserAreaLeft() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddUser = new JButton("Thêm", imageIconAdd);
		btnAddUser.setPreferredSize(new Dimension(100, 50));
		btnAddUser.addActionListener(this);

		btnUpdateUser = new JButton("Sửa", imageIconUpdate);
		btnUpdateUser.addActionListener(this);
		btnUpdateUser.setPreferredSize(new Dimension(100, 50));

		btnDeleteUser = new JButton("Xóa", imageIconDelete);
		btnDeleteUser.addActionListener(this);
		btnDeleteUser.setPreferredSize(new Dimension(100, 50));

		btnCleanUser = new JButton("Clean", imageIconClean);
		btnCleanUser.addActionListener(this);
		btnCleanUser.setPreferredSize(new Dimension(100, 50));

		tableUser = new JTable(model);
		tableUser.addMouseListener(this);
		tableUser.setPreferredSize(new Dimension(450, 2000));

		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableUser);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddUser);
		managerButton.add(btnUpdateUser);
		managerButton.add(btnDeleteUser);
		managerButton.add(btnCleanUser);
		managerTable.add(scroll, tableUser);

		panel.add(managerButton);
		panel.add(managerTable);

		return panel;
	}

	public JPanel managerUserAreaRight() {
		JPanel panel = new JPanel();

		JPanel manager = new JPanel(new GridLayout(9, 1, 5, 5));
		JPanel managerButton = new JPanel();

		// Giao diện phía trái và giữa
		lblUsername = new JLabel("Tên tài khoản");
		username = new JTextField(30);
		lblPassword = new JLabel("Mật khẩu");
		password = new JTextField(30);
		lblType = new JLabel("Loại tài khoản");
		type = new JTextField(30);
		lblDeleteValueUser = new JLabel("Giá trị xóa");
		deleteValueUser = new JTextField(30);
		btnDeletePermanentlyUser = new JButton("Xóa vĩnh viễn", imageIconDelete);
		btnDeletePermanentlyUser.addActionListener(this);
		btnDeletePermanentlyUser.setPreferredSize(new Dimension(140, 50));

		manager.add(lblUsername);
		manager.add(username);
		manager.add(lblPassword);
		manager.add(password);
		manager.add(lblType);
		manager.add(type);
		manager.add(lblDeleteValueUser);
		manager.add(deleteValueUser);
		managerButton.add(btnDeletePermanentlyUser);

		panel.add(manager);
		panel.add(managerButton);

		return panel;
	}

	public JSplitPane managerUserArea() {
		JSplitPane manager = new JSplitPane();

		manager.setLeftComponent(managerUserAreaLeft());
		manager.setRightComponent(managerUserAreaRight());

		manager.setDividerLocation(780);

		return manager;
	}

	public JPanel managerEmployeesAreaLeft() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddEmployees = new JButton("Thêm", imageIconAdd);
		btnAddEmployees.setPreferredSize(new Dimension(100, 50));
		btnAddEmployees.addActionListener(this);

		btnUpdateEmployees = new JButton("Sửa", imageIconUpdate);
		btnUpdateEmployees.addActionListener(this);
		btnUpdateEmployees.setPreferredSize(new Dimension(100, 50));

		btnDeleteEmployees = new JButton("Xóa", imageIconDelete);
		btnDeleteEmployees.addActionListener(this);
		btnDeleteEmployees.setPreferredSize(new Dimension(100, 50));

		btnCleanEmployees = new JButton("Clean", imageIconClean);
		btnCleanEmployees.addActionListener(this);
		btnCleanEmployees.setPreferredSize(new Dimension(100, 50));

		tableEmployees = new JTable(model);
		tableEmployees.addMouseListener(this);
		tableEmployees.setPreferredSize(new Dimension(530, 2000));

		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableEmployees);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddEmployees);
		managerButton.add(btnUpdateEmployees);
		managerButton.add(btnDeleteEmployees);
		managerButton.add(btnCleanEmployees);
		managerTable.add(scroll, tableEmployees);

		panel.add(managerButton);
		panel.add(managerTable);

		return panel;
	}

	public JPanel managerEmployeesAreaRight() {
		JPanel panel = new JPanel();

		JPanel manager = new JPanel(new GridLayout(19, 1, 5, 5));

		JPanel managerButton = new JPanel();

		// Giao diện phía trái và giữa
		lblIdEmployees = new JLabel("ID");
		idEmployees = new JTextField(25);
		idEmployees.setEnabled(false);
		lblUsername_employees = new JLabel("Tài khoản");
		username_employees = new JTextField(25);
		lblFullName = new JLabel("Họ và tên");
		fullName = new JTextField(25);
		lblAge = new JLabel("Tuổi");
		age = new JTextField(25);
		lblAddress = new JLabel("Địa chỉ");
		address = new JTextField(25);
		lblPhoneNumber = new JLabel("Số điện thoại");
		phoneNumber = new JTextField(25);
		lblHomeTown = new JLabel("Quê quán");
		homeTown = new JTextField(25);
		lblIdentityCard = new JLabel("Số chứng minh nhân dân");
		identityCard = new JTextField(25);
		lblDeleteValueEmployees = new JLabel("Giá trị xóa");
		deleteValueEmployees = new JTextField(30);
		btnDeletePermanentlyEmployees = new JButton("Xóa vĩnh viễn", imageIconDelete);
		btnDeletePermanentlyEmployees.addActionListener(this);
		btnDeletePermanentlyEmployees.setPreferredSize(new Dimension(140, 50));

		manager.add(lblIdEmployees);
		manager.add(idEmployees);
		manager.add(lblUsername_employees);
		manager.add(username_employees);
		manager.add(lblFullName);
		manager.add(fullName);
		manager.add(lblAge);
		manager.add(age);
		manager.add(lblAddress);
		manager.add(address);
		manager.add(lblPhoneNumber);
		manager.add(phoneNumber);
		manager.add(lblHomeTown);
		manager.add(homeTown);
		manager.add(lblIdentityCard);
		manager.add(identityCard);
		manager.add(lblDeleteValueEmployees);
		manager.add(deleteValueEmployees);
		managerButton.add(btnDeletePermanentlyEmployees);

		panel.add(manager);
		panel.add(managerButton);

		return panel;
	}

	public JSplitPane managerEmployeesArea() {
		JSplitPane manager = new JSplitPane();

		manager.setLeftComponent(managerEmployeesAreaLeft());
		manager.setRightComponent(managerEmployeesAreaRight());

		manager.setDividerLocation(780);

		return manager;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int rowSelected = tableHS.getSelectedRow();
		txtmahocsinh.setText((String) tableHS.getValueAt(rowSelected, 0));
		txthoten.setText((String) tableHS.getValueAt(rowSelected, 1));
		txtemail.setText((String) tableHS.getValueAt(rowSelected, 2));
		txtdiachi.setText((String) tableHS.getValueAt(rowSelected, 3));
		txtmalop.setText((String) tableHS.getValueAt(rowSelected, 4));
		txtnamsinh.setText((String) tableHS.getValueAt(rowSelected, 5));
		txtnamhoc.setText((String) tableHS.getValueAt(rowSelected, 6));

		// gioitinh.setToolTipText((String) tableHS.getValueAt(rowSelected, 6));

	}

	private void clear() {
		txtmahocsinh.setText("");
		txthoten.setText("");
		txtdiachi.setText("");
		txtemail.setText("");
		txtnamsinh.setText("");
		txtnamhoc.setText("");
		txtmalop.setText("");

	}

	private void deleteUser() {
		svdao = new StudentDao();
		svdao.deleteUser(txtmahocsinh.getText());
		// String id = (String) (tableHS.getValueAt(tableHS.getSelectedRow(),
		// 0));
		// svdao.deleteUser(id);

	}

	private void updateUser() {
		HocSinh hs = new HocSinh();
		hs.setMahocsinh(Integer.parseInt(txtmahocsinh.getText()));
		hs.setHoten(txthoten.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setMalop(txtmalop.getText());
		hs.setEmail(txtemail.getText());
		hs.setNamsinh(txtnamsinh.getText());
		hs.setNamhoc(txtnamhoc.getText());
		hs.setGioitinh(gioitinh.getSelectedItem().toString());
		svdao = new StudentDao();
		svdao.updateUser(hs);
	}

	private void addUser() {
		HocSinh hs = new HocSinh();
		// hs.setMahocsinh(Integer.parseInt(txtmahocsinh.getText()));
		hs.setHoten(txthoten.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setMalop(txtmalop.getText());
		hs.setEmail(txtemail.getText());
		hs.setNamsinh(txtnamsinh.getText());
		hs.setNamhoc(txtnamhoc.getText());
		hs.setGioitinh(gioitinh.getSelectedItem().toString());
		svdao = new StudentDao();
		svdao.addUser(hs);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAddHS) {
			if (txthoten.getText().equals("") || txtemail.getText().equals("") || txtdiachi.getText().equals("")
					|| txtmalop.getText().equals("") || txtnamsinh.getText().equals("")
					|| txtnamhoc.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			loadgram();

		} else if (action == btnUpdateHS) {
			if (txtmahocsinh.getText().equals("") || String.valueOf(txthoten.getText()).equals("")
					|| String.valueOf(txtemail.getText()).equals("") || String.valueOf(txtdiachi.getText()).equals("")
					|| String.valueOf(txtmalop.getText()).equals("") || String.valueOf(txtnamsinh.getText()).equals("")
					|| String.valueOf(txtnamhoc.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				updateUser();
			}

			loadgram();
		} else if (action == btnDeleteHS) {
			deleteUser();
			loadgram();
		} else {
			clear();
		}

	}
}
