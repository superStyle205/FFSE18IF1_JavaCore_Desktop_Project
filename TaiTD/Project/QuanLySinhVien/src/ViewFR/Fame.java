//package ViewFR;
//
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//
//import Dao.GiaoVienDao;
//import Dao.HocSinhDao;
//import model.bean.Diem;
//import model.bean.GiaoVien;
//import model.bean.HocSinh;
//
//public class Fame extends JFrame implements ActionListener, MouseListener {
//
//	private DefaultTableModel tableModel;
//	private DefaultTableModel tableMode2;
//	private DefaultTableModel tableMode3;
//	
//	private JScrollPane jScrollPane;
//	private JPanel contentPane;
//	
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_4;
//		
//	private JTextField textField_1_1;	
//	private JTextField textField_2_1;	
//	private JTextField textField_3_1;
//	private JTextField textField_4_1;
//	
//	private JTextField textField_5_1;
//	private JTextField textField_6_1;
//	private JTextField textField_7_1;
//	private JTextField textField_8_1;
//	
//	private JTable table;
//	private JTable table_1;
//	private JTable table_2;
//	
//	private CardLayout cardlayout;
//	
//	JPanel panel_4;
//
//	private JButton btnThm, btnSa, btnXa, btnRs;
//	private JButton btnThm1, btnSa1, btnXa1, btnRs1;
//	private JButton btnThm2, btnSa2, btnXa2, btnRs2;
//	
//	private JLabel lblNewLabel;
//	private JLabel lblNewLabel_4;
//	private JLabel lblNewLabel_5;
//	private JLabel lblNewLabel_6;
//	
//	private JComboBox gioiTinh;
//	
//	private HocSinhDao hsDao,diemDao;
//	private GiaoVienDao gvDao;
//
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//
//		Fame frame = new Fame();
//		frame.setVisible(true);
//		 //frame.gg();
//	}
//
//	/**
//	 * Create the frame.
//	 */
//
//	public  Fame() {
//
//		// di();
//		setSize(1131, 625);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// setVisible(true);
//
//		// }
//		// public void di(){
//		hsDao = new HocSinhDao();
//		gvDao = new GiaoVienDao();
//		diemDao = new HocSinhDao();
//
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBounds(0, 0, 1115, 586);
//		contentPane.add(tabbedPane);
//
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("Trang chủ", null, panel, null);
//
//		JPanel panel_1 = new JPanel();
//		tabbedPane.addTab("Quản Lý", null, panel_1, null);
//		panel_1.setLayout(null);
//
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(224, 255, 255));
//		panel_3.setBounds(12, 12, 181, 534);
//		panel_1.add(panel_3);
//		panel_3.setLayout(null);
//		
//		// quản lý học sinh
//
//		JPanel panel_5 = new JPanel();
//
//		JPanel panel_6 = new JPanel();
//		
//		JPanel panel_7 = new JPanel();
//
//		JButton btnNewButton = new JButton("Quản Lý Học Sinh");
//
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cardlayout.show(panel_4, "card1");
//			}
//		});
//		btnNewButton.setBounds(12, 25, 157, 47);
//		panel_3.add(btnNewButton);
//
//		JButton btnNewButton_1 = new JButton("Quản Lý Giáo Viên");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cardlayout.show(panel_4, "card2");
//			}
//		});
//		btnNewButton_1.setBounds(12, 103, 157, 47);
//		panel_3.add(btnNewButton_1);
//
//		JButton btnNewButton_2 = new JButton("Quản Lý Điểm");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cardlayout.show(panel_4, "card3");
//			}
//		});
//		btnNewButton_2.setBounds(12, 189, 157, 47);
//		panel_3.add(btnNewButton_2);
//
//		JButton btnNewButton_3 = new JButton("Quản Lý Khoa");
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton_3.setBounds(12, 264, 157, 47);
//		panel_3.add(btnNewButton_3);
//
//		JButton btnNewButton_4 = new JButton("Quản Lý Lớp");
//		btnNewButton_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnNewButton_4.setBounds(12, 346, 157, 47);
//		panel_3.add(btnNewButton_4);
//
//		JButton btnNewButton_5 = new JButton("Quản Lý Môn");
//		btnNewButton_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnNewButton_5.setBounds(12, 428, 157, 47);
//		panel_3.add(btnNewButton_5);
//
//		panel_5.setBackground(new Color(224, 255, 255));
//
//		panel_5.setLayout(null);
//
//	    lblNewLabel = new JLabel("Mã Sinh Viên :");
//		lblNewLabel.setBounds(12, 14, 85, 28);
//		panel_5.add(lblNewLabel);
//
//		textField = new JTextField();
//		textField.setBounds(108, 16, 108, 25);
//		panel_5.add(textField);
//		textField.setColumns(10);
//
//		JLabel lblNewLabel_1 = new JLabel("Tên Sinh Viên :");
//		lblNewLabel_1.setBounds(12, 50, 85, 28);
//		panel_5.add(lblNewLabel_1);
//
//		textField_1 = new JTextField();
//		textField_1.setBounds(108, 52, 108, 25);
//		panel_5.add(textField_1);
//		textField_1.setColumns(10);
//
//		JLabel lblNewLabel_2 = new JLabel("Lớp :");
//		lblNewLabel_2.setBounds(12, 96, 55, 16);
//		panel_5.add(lblNewLabel_2);
//
//		textField_2 = new JTextField();
//		textField_2.setBounds(108, 92, 108, 25);
//		panel_5.add(textField_2);
//		textField_2.setColumns(10);
//
//		JLabel lblNewLabel_3 = new JLabel("Giới Tính :");
//		lblNewLabel_3.setBounds(12, 139, 61, 16);
//		panel_5.add(lblNewLabel_3);
//
//		gioiTinh = new JComboBox<>();
//		gioiTinh.setBounds(108, 135, 108, 25);
//		panel_5.add(gioiTinh);
//		gioiTinh.addItem("");
//		gioiTinh.addItem("Nam");
//		gioiTinh.addItem("Nữ");
//		//gioiTinh.setColumns(10);
//		
//
//		JLabel lblNmSinh = new JLabel("Ngày Sinh :");
//		lblNmSinh.setBounds(12, 183, 85, 16);
//		panel_5.add(lblNmSinh);
//
//		textField_4 = new JTextField();
//		textField_4.setBounds(108, 179, 108, 25);
//		panel_5.add(textField_4);
//		textField_4.setColumns(10);
//
//		btnThm = new JButton("Thêm");
//		btnThm.setBounds(65, 244, 121, 39);
//		panel_5.add(btnThm);
//
//		btnSa = new JButton("Sửa");
//		btnSa.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnSa.setBounds(66, 310, 120, 39);
//		panel_5.add(btnSa);
//
//		btnXa = new JButton("Xóa");
//		btnXa.setBounds(66, 371, 120, 39);
//		panel_5.add(btnXa);
//
//		btnRs = new JButton("Reset");
//		btnRs.setBounds(67, 430, 120, 39);
//		panel_5.add(btnRs);
//
//		btnThm.addActionListener(this);
//		btnSa.addActionListener(this);
//		btnXa.addActionListener(this);
//		btnRs.addActionListener(this);
//
//		tableModel = new DefaultTableModel();
//		tableModel.addColumn("Mã Sinh Viên");
//		tableModel.addColumn("Tên Sinh Viên");
//		tableModel.addColumn("Lớp");
//		tableModel.addColumn("Giới Tính");
//		tableModel.addColumn("Ngày Sinh");
//
//		table = new JTable(tableModel);
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(253, 0, 630, 529);
//		panel_5.add(scrollPane);
//
//		JPanel panel_2 = new JPanel();
//		tabbedPane.addTab("Tìm Kiếm", null, panel_2, null);
//		panel_2.setLayout(null);
//         
//		table.addMouseListener(this);
//		
//		/*table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				try {
//					int rowSelected = table.getSelectedRow();
//					textField.setText((String) table.getValueAt(rowSelected, 0));
//					textField_1.setText((String) table.getValueAt(rowSelected, 1));
//					textField_2.setText((String) table.getValueAt(rowSelected, 2));
//					gioiTinh.setSelectedItem((String) table.getValueAt(rowSelected, 3));
//					textField_4.setText((String) table.getValueAt(rowSelected, 4));
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		});*/
//
//		panel_4 = new JPanel();
//		cardlayout = new CardLayout();
//		panel_4.setLayout(cardlayout);
//
//		panel_4.add("card1", panel_5);
//		panel_4.add("card2", panel_6);
//		panel_4.add("card3", panel_7);
//
//		panel_4.setBorder(UIManager.getBorder("DesktopIcon.border"));
//		panel_4.setBackground(SystemColor.menu);
//		panel_4.setBounds(220, 12, 890, 534);
//		panel_1.add(panel_4);
//		
//		//quản lý giáo viên
//		//panel_6.setBorder(UIManager.getBorder("DesktopIcon.border"));
//		panel_6.setBackground(new Color(224, 255, 255));
//		panel_6.setLayout(null);
//		
//		
//		JLabel lblNewLabel = new JLabel("Mã Giáo Viên :");
//		lblNewLabel.setBounds(12, 14, 85, 28);
//		panel_6.add(lblNewLabel);
//
//		textField_1_1 = new JTextField();
//		textField_1_1.setBounds(108, 16, 108, 25);
//		panel_6.add(textField_1_1);
//		textField_1_1.setColumns(10);
//
//		 lblNewLabel_4 = new JLabel("Tên Giáo Viên :");
//		 lblNewLabel_4.setBounds(12, 50, 85, 28);
//		panel_6.add(lblNewLabel_4);
//
//		textField_2_1 = new JTextField();
//		textField_2_1.setBounds(108, 52, 108, 25);
//		panel_6.add(textField_2_1);
//		textField_2_1.setColumns(10);
//
//		 lblNewLabel_5 = new JLabel("Chuyên Ngành :");
//		 lblNewLabel_5.setBounds(12, 96, 95, 16);
//		panel_6.add(lblNewLabel_5);
//
//		textField_3_1 = new JTextField();
//		textField_3_1.setBounds(108, 92, 108, 25);
//		panel_6.add(textField_3_1);
//		textField_3_1.setColumns(10);
//
//		 lblNewLabel_6 = new JLabel("Mã Khoa :");
//		 lblNewLabel_6.setBounds(12, 139, 61, 16);
//		panel_6.add(lblNewLabel_6);
//
//		textField_4_1 = new JTextField();
//		textField_4_1.setBounds(108, 135, 108, 25);
//		panel_6.add(textField_4_1);
//		textField_4_1.setColumns(10);
//
//		btnThm1 = new JButton("Thêm");
//		btnThm1.setBounds(65, 244, 121, 39);
//		panel_6.add(btnThm1);
//
//		btnSa1 = new JButton("Sửa");
//		btnSa1.setBounds(66, 310, 120, 39);
//		panel_6.add(btnSa1);
//
//		btnXa1 = new JButton("Xóa");
//		btnXa1.setBounds(66, 371, 120, 39);
//		panel_6.add(btnXa1);
//
//		btnRs1 = new JButton("Reset");
//		btnRs1.setBounds(67, 430, 120, 39);
//		panel_6.add(btnRs1);
//		
//		tableMode2 = new DefaultTableModel();
//		tableMode2.addColumn("Mã Giáo Viên");
//		tableMode2.addColumn("Tên Giáo Viên");
//		tableMode2.addColumn("Chuyên Ngành");
//		tableMode2.addColumn("Mã Khoa");
//
//		table_1 = new JTable(tableMode2);
//	    jScrollPane = new JScrollPane(table_1);
//	    jScrollPane.setBounds(253, 0, 630, 529);
//		panel_6.add(jScrollPane);
//		
//		btnThm1.addActionListener(this);
//		btnSa1.addActionListener(this);
//		btnXa1.addActionListener(this);
//		btnRs1.addActionListener(this);
//		
//		/*table_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				try {
//					int dd = table_1.getSelectedRow();
//					textField_1_1.setText((String) table_1.getValueAt(dd, 0));
//					textField_2_1.setText((String) table_1.getValueAt(dd, 1));
//					textField_3_1.setText((String) table_1.getValueAt(dd, 2));
//					textField_4_1.setText((String) table_1.getValueAt(dd, 3));
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		});*/
//		
//		//quản lý điểm
//		panel_7.setBackground(new Color(224, 255, 255));
//		panel_7.setLayout(null);
//		
//	    lblNewLabel = new JLabel("Mã Sinh Viên :");
//		lblNewLabel.setBounds(12, 14, 85, 28);
//		panel_7.add(lblNewLabel);
//
//		textField_5_1 = new JTextField();
//		textField_5_1.setBounds(108, 16, 108, 25);
//		panel_7.add(textField_5_1);
//		textField_5_1.setColumns(10);
//
//		 lblNewLabel_4 = new JLabel("Mã Môn Học :");
//		 lblNewLabel_4.setBounds(12, 50, 85, 28);
//		panel_7.add(lblNewLabel_4);
//
//		textField_6_1 = new JTextField();
//		textField_6_1.setBounds(108, 52, 108, 25);
//		panel_7.add(textField_6_1);
//		textField_6_1.setColumns(10);
//
//		 lblNewLabel_5 = new JLabel("Lần Thi :");
//		 lblNewLabel_5.setBounds(12, 96, 95, 16);
//		panel_7.add(lblNewLabel_5);
//
//		textField_7_1 = new JTextField();
//		textField_7_1.setBounds(108, 92, 108, 25);
//		panel_7.add(textField_7_1);
//		textField_7_1.setColumns(10);
//
//		 lblNewLabel_6 = new JLabel("Điểm Thi :");
//		 lblNewLabel_6.setBounds(12, 139, 61, 16);
//		panel_7.add(lblNewLabel_6);
//
//		textField_8_1 = new JTextField();
//		textField_8_1.setBounds(108, 135, 108, 25);
//		panel_7.add(textField_8_1);
//		textField_8_1.setColumns(10);
//		
//		btnThm2 = new JButton("Thêm");
//		btnThm2.setBounds(65, 244, 121, 39);
//		panel_7.add(btnThm2);
//
//		btnSa2 = new JButton("Sửa");
//		btnSa2.setBounds(66, 310, 120, 39);
//		panel_7.add(btnSa2);
//
//		btnXa2 = new JButton("Xóa");
//		btnXa2.setBounds(66, 371, 120, 39);
//		panel_7.add(btnXa2);
//
//		btnRs2 = new JButton("Reset");
//		btnRs2.setBounds(67, 430, 120, 39);
//		panel_7.add(btnRs2);
//		
//		tableMode3 = new DefaultTableModel();
//		tableMode3.addColumn("Mã Sinh Viên");
//		tableMode3.addColumn("Mã Môn Học");
//		tableMode3.addColumn("Lần thi");
//		tableMode3.addColumn("Điểm Thi");
//
//		table_2 = new JTable(tableMode3);
//	    jScrollPane = new JScrollPane(table_2);
//	    jScrollPane.setBounds(253, 0, 630, 529);
//		panel_7.add(jScrollPane);
//		
//		btnThm2.addActionListener(this);
//		btnSa2.addActionListener(this);
//		btnXa2.addActionListener(this);
//		btnRs2.addActionListener(this);
//		
//		table_2.addMouseListener(this);
//		
//		loadData();
//		
//	}
//
//	private void loadData() {
//		tableModel.setRowCount(0);
//		ArrayList<HocSinh> listHS = hsDao.getAllHS();
//		for (HocSinh hs : listHS) {
//			tableModel.addRow(new String[] { "" + hs.getMaSinhVien(), hs.getTenSinhVien(), hs.getLop(),
//					hs.getGioiTinh(), hs.getNgaySinh() });
//		}
//		
//		tableMode2.setRowCount(0);
//		ArrayList<GiaoVien> listGV = gvDao.getAllGV();
//		for (GiaoVien gv : listGV){
//			tableMode2.addRow(new String[] {"" + gv.getMaGV(), gv.getTenGV(), gv.getChuyenNganh(), gv.getMaKhoa()});
//		}
//		
//		tableMode3.setRowCount(0);
//		ArrayList<Diem> listDiem = diemDao.getAllDiem();
//		for (Diem diem : listDiem){
//			tableMode3.addRow(new String[] {"" + diem.getMaSV(), diem.getMaMH(), diem.getLanThi(), diem.getDiemThi()});
//		}
//	}
//	
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		int rowSelected = table.getSelectedRow();
//		
//		textField.setText((String) table.getValueAt(rowSelected, 0));
//		textField_1.setText((String) table.getValueAt(rowSelected, 1));
//		textField_2.setText((String) table.getValueAt(rowSelected, 2));
//		gioiTinh.setSelectedItem((String) table.getValueAt(rowSelected, 3));
//		textField_4.setText((String) table.getValueAt(rowSelected, 4));
//
//	}	
//	
//
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object action = e.getSource();
//		if (action == btnThm) {
//			addHS();
//			loadData();
//		} else if (action == btnSa) {
//			updateHS();
//			loadData();
//		} else if (action == btnXa) {
//			deleteHS();
//			loadData();
//		} else {
//			clearHS();
//		}
//		
//	  /*  Object action1 = e.getSource();	
//	    if(action1 == btnThm1){
//	    	addGv();
//	    	loadData();
//	    }else if (action1 == btnSa1){
//	    	updateHS();
//	    	loadData();
//	    }else if (action1 == btnXa1) {
//			deleteGV();
//			loadData();
//	    }else {
//	    	clearHS();
//	    }*/
//	    
//	    Object action2 = e.getSource();	
//	    if(action2 == btnThm2){
//	    	addHS();
//	    	loadData();
//	    }else if (action2 == btnSa2){
//	    	updateHS();
//	    	loadData();
//	    }else if (action2 == btnXa2) {
//			deleteGV();
//			loadData();
//	    }else {
//	    	clearHS();
//	    }
//
//	}
//
//	private void clearHS() {
//		textField.setText("");
//		textField_1.setText("");
//		textField_2.setText("");
//		gioiTinh.setSelectedItem("");
//		textField_4.setText("");
//		
//		textField_1_1.setText("");
//		textField_2_1.setText("");
//		textField_3_1.setText("");
//		textField_4_1.setText("");
//
//	}
//
//	private void deleteGV(){
//		String gv = (String) table_1.getValueAt(table_1.getSelectedRow(),0);
//        gvDao.deleteGV(gv);
//	}
//	
//	private void deleteHS() {
//		String hs = (String) table.getValueAt(table.getSelectedRow(), 0);
//		hsDao.deleteUser(hs);
//		
//		
//	}
//
//	private void updateHS() {
//		HocSinh hs = new HocSinh();
//
//		hs.setMaSinhVien(textField.getText());
//		hs.setTenSinhVien(textField_1.getText());
//		hs.setLop(textField_2.getText());
//		hs.setGioiTinh(gioiTinh.getSelectedItem().toString());
//		hs.setNgaySinh(textField_4.getText());
//
//		hsDao.updateUser(hs);
//		
//
//	}
//
//	private void addHS() {
//		//quan ly hoc sinh
//		HocSinh hs = new HocSinh();
//		
//		hs.setMaSinhVien(textField.getText());
//		hs.setTenSinhVien(textField_1.getText());
//		hs.setLop(textField_2.getText());
//	    hs.setGioiTinh(gioiTinh.getSelectedItem().toString());
//		hs.setNgaySinh(textField_4.getText());
//		
//		hsDao.addUser(hs);
//		
//		// quan ly giao vien
//		  
//		Diem d = new Diem();
//		d.setMaSV(textField_5_1.getText());
//		d.setMaMH(textField_6_1.getText());
//		d.setLanThi(textField_7_1.getText());
//		d.setDiemThi(textField_8_1.getText());
//		
//		diemDao.addDiem(d);
//		
//	}
//	
//	/*private void addGv(){
//		GiaoVien gv = new GiaoVien();
//		gv.setMaGV(textField_1_1.getText());
//		gv.setTenGV(textField_2_1.getText());
//		gv.setChuyenNganh(textField_3_1.getText());
//		gv.setMaKhoa(textField_4_1.getText());
//		gvDao.addGV(gv);
//	}*/
//}
