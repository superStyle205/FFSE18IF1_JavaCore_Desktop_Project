package view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.bean.Teacher;
import model.dao.TeacherDao;

public class ManagerStudentTeacherPanel extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	public static final String TAB_NAME = "Quản Lý Giáo Viên";
	public static final ImageIcon TAB_ICON = new ImageIcon("teacher.png");
	
	private JPanel contentPanel;
	private JPanel pnButton;
	private JPanel pnTableTeacher;
	
	private JLabel lblHoTenGiaoVien;
	private JLabel lblChucVu;
	private JLabel lblGioiTinh;
	private JLabel lblDiaChi;
	private JLabel lblSoDienThoai;
	
	private JTextField txtHoTenGiaoVien;
	private JTextField txtChucVu;
	
	private JRadioButton rdbNam;
	private JRadioButton rdbNu;
	private ButtonGroup btnGroupTeacher;
	
	
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;

	private JButton btnAddTeacher;
	private JButton btnUpdateTeacher;
	private JButton btnDeleteTeacher;
	private JButton btnCleanTeacher;

	private JTextField txtTimKiem;
	private JButton btnSearch;
	private JLabel lblTiemKiem;
	
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JScrollPane jScrollPane;
	
	private TeacherDao teacherDao;
	private JButton btnLoad;
	
	public ManagerStudentTeacherPanel() {
		setBackground(Color.magenta);
		setBounds(60, 50, 1800, 965);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		teacherDao = new TeacherDao();
		initScreen();
	}
	private void initScreen() {
		JPanel panel = new JPanel();
		JLabel lblQuanLyGiaoVien = new JLabel("QUẢN  LÝ  GIÁO  VIÊN");
		lblQuanLyGiaoVien.setFont(new Font("SVN-Agency FB", Font.BOLD, 30));
		lblQuanLyGiaoVien.setAlignmentX(CENTER_ALIGNMENT);
		add(lblQuanLyGiaoVien);
		
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(12, 72, 539, 738);
		add(panel);
		panel.setLayout(null);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông Tin Giáo Viên",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBounds(10, 10, 570, 815);
		panel.add(contentPanel);
		contentPanel.setLayout(null);
		
		lblHoTenGiaoVien = new JLabel("Họ Tên Giáo Viên :");
		lblHoTenGiaoVien.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		lblHoTenGiaoVien.setBounds(12, 77, 122, 33);
		contentPanel.add(lblHoTenGiaoVien);
		
		txtHoTenGiaoVien = new JTextField();
		txtHoTenGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtHoTenGiaoVien.setColumns(10);
		txtHoTenGiaoVien.setBounds(146, 75, 412, 35);
		contentPanel.add(txtHoTenGiaoVien);
		
		lblChucVu = new JLabel("Chức Vụ :");
		lblChucVu.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		lblChucVu.setBounds(12, 215, 122, 33);
		contentPanel.add(lblChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(146, 213, 412, 35);
		contentPanel.add(txtChucVu);
		
		lblGioiTinh = new JLabel("Giới Tính :");
		lblGioiTinh.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		lblGioiTinh.setBounds(12, 380, 122, 33);
		contentPanel.add(lblGioiTinh);
		
		rdbNam = new JRadioButton("Nam");
		rdbNam.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		rdbNam.setBounds(142, 382, 127, 25);
		contentPanel.add(rdbNam);

		rdbNu = new JRadioButton("Nữ");
		rdbNu.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		rdbNu.setBounds(273, 382, 127, 25);
		contentPanel.add(rdbNu);
		
		btnGroupTeacher = new ButtonGroup();
		btnGroupTeacher.add(rdbNam);
		btnGroupTeacher.add(rdbNu);
		
		lblDiaChi = new JLabel("Địa Chỉ :");
		lblDiaChi.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		lblDiaChi.setBounds(12, 549, 122, 33);
		contentPanel.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(146, 547, 412, 35);
		contentPanel.add(txtDiaChi);
		
		lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		lblSoDienThoai.setBounds(12, 713, 122, 33);
		contentPanel.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(146, 711, 412, 35);
		contentPanel.add(txtSoDienThoai);
		
		// them button
		pnButton = new JPanel();
		pnButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnButton.setBounds(592, 13, 1173, 236);
		panel.add(pnButton);
		pnButton.setLayout(null);

		btnAddTeacher = new JButton("ADD");
		btnAddTeacher.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\add.png"));
		btnAddTeacher.setForeground(Color.RED);
		btnAddTeacher.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnAddTeacher.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAddTeacher.setBounds(58, 129, 152, 77);
		pnButton.add(btnAddTeacher);
		btnAddTeacher.addActionListener(this);

		btnUpdateTeacher = new JButton("UPDATE");
		btnUpdateTeacher.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\refresh.png"));
		btnUpdateTeacher.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUpdateTeacher.setForeground(Color.RED);
		btnUpdateTeacher.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnUpdateTeacher.setBounds(344, 129, 152, 77);
		pnButton.add(btnUpdateTeacher);
		btnUpdateTeacher.addActionListener(this);

		btnDeleteTeacher = new JButton("DELETE");
		btnDeleteTeacher.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\delete.png"));
		btnDeleteTeacher.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDeleteTeacher.setForeground(Color.RED);
		btnDeleteTeacher.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnDeleteTeacher.setBounds(639, 129, 152, 77);
		pnButton.add(btnDeleteTeacher);
		btnDeleteTeacher.addActionListener(this);

		btnCleanTeacher = new JButton("CLEAN");
		btnCleanTeacher.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\eraser.png"));
		btnCleanTeacher.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCleanTeacher.setForeground(Color.RED);
		btnCleanTeacher.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnCleanTeacher.setBounds(941, 129, 152, 77);
		pnButton.add(btnCleanTeacher);
		btnCleanTeacher.addActionListener(this);

		lblTiemKiem = new JLabel("Tìm Kiếm(MGV)");
		lblTiemKiem.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTiemKiem.setBounds(22, 13, 142, 46);
		pnButton.add(lblTiemKiem);
//		getRootPane().setDefaultButton(btnSearch);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(166, 13, 822, 46);
		pnButton.add(txtTimKiem);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\loupe.png"));
		btnSearch.setBounds(1000, 13, 62, 46);
		pnButton.add(btnSearch);
		
		btnLoad = new JButton("");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object action = e.getSource();
				if (action == btnLoad) {
					loadDataTeacher();
				}
			}
		});
		btnLoad.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\folder.png"));
		btnLoad.setBounds(1074, 13, 62, 46);
		pnButton.add(btnLoad);
		btnSearch.addActionListener(this);
	
		
		// table
		pnTableTeacher = new JPanel();
		pnTableTeacher.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTableTeacher.setBounds(592, 262, 1173, 563);
		panel.add(pnTableTeacher);
		pnTableTeacher.setLayout(null);
		
		tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã Giáo Viên");
		tableModel.addColumn("Họ Tên Giáo Viên");
		tableModel.addColumn("Chức Vụ");
		tableModel.addColumn("Giới Tính");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Số Điện Thoại");

		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(12, 13, 1149, 537);
		jScrollPane.setMaximumSize(new Dimension(1300, 300));
		jTable.addMouseListener(this);
		pnTableTeacher.add(jScrollPane);
		
		loadDataTeacher();
		
	}
	private void loadDataTeacher() {
		tableModel.setRowCount(0);
		List<Teacher> listData = teacherDao.getData();
		for (Teacher teacher : listData){
			tableModel.addRow(new String[] {"" +teacher.getMaGiaoVien(), teacher.getHoTenGiaoVien(), teacher.getChucVu(), teacher.getGioiTinh(),
					teacher.getDiaChi(),teacher.getSoDienThoai()});
		}		
	}
	
	private void addTeacher(){
		Teacher teacher = new Teacher();
		
		teacher.setHoTenGiaoVien(txtHoTenGiaoVien.getText());
		teacher.setChucVu(txtChucVu.getText());
		
		if (rdbNam.isSelected()) {
			teacher.setGioiTinh("Nam");
		} else {
			teacher.setGioiTinh("Nữ");
		}
		
		teacher.setDiaChi(txtDiaChi.getText());
		teacher.setSoDienThoai(txtSoDienThoai.getText());
		
		teacherDao.addTeacher(teacher);
		JOptionPane.showMessageDialog(null, "Bạn Đã Thêm Thông Tin Giáo Viên Thành Công " );
	}

	private void updateTeacher(){
		Teacher teacher = new Teacher();
		
		int rowSelected = jTable.getSelectedRow();
		
		teacher.setMaGiaoVien(Integer.parseInt((String) jTable.getValueAt(rowSelected, 0)));
		teacher.setHoTenGiaoVien(txtHoTenGiaoVien.getText());
		teacher.setChucVu(txtChucVu.getText());
		if (rdbNam.isSelected()) {
			teacher.setGioiTinh("Nam");
		} else {
			teacher.setGioiTinh("Nu");
		}
		teacher.setDiaChi(txtDiaChi.getText());
		teacher.setSoDienThoai(txtSoDienThoai.getText());
		
		teacherDao.updateTeacher(teacher);
		JOptionPane.showMessageDialog(null, "Bạn Đã Sửa Giáo Viên Thành Công " );
		
	}
	
	private void deleteteacher(){
		String maGiaoVien = (String) jTable.getValueAt(jTable.getSelectedRow(),0);
		
		teacherDao.deleteTeacher(maGiaoVien);
		JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Giáo Viên Thành Công " );
	}
	
	private void cleanTeacher(){
		txtHoTenGiaoVien.setText("");
		txtChucVu.setText("");
		btnGroupTeacher.clearSelection();
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
	}
	
	private void searchTeacher(){
		tableModel.setRowCount(0);
		String maGiaoVien = txtTimKiem.getText();
		
		Teacher teacher = new Teacher();
		teacher = teacherDao.searchTeacher(maGiaoVien);
		
		tableModel.addRow(new String[] {"" +teacher.getMaGiaoVien(), teacher.getHoTenGiaoVien(), teacher.getChucVu(), teacher.getGioiTinh(),
				teacher.getDiaChi(),teacher.getSoDienThoai()});
	
		JOptionPane.showMessageDialog(null, "Bạn Đã Tìm Thành Công Giáo Viên Có Mã : " + maGiaoVien,"Title", JOptionPane.QUESTION_MESSAGE );
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = jTable.getSelectedRow();
		
		txtHoTenGiaoVien.setText((String) jTable.getValueAt(rowSelected, 1));
		txtChucVu.setText((String) jTable.getValueAt(rowSelected, 2));
		if (jTable.getValueAt(rowSelected, 3).toString().equals("Nam")) {
			rdbNam.setSelected(true);
			rdbNu.setSelected(false);
		} else if (jTable.getValueAt(rowSelected, 3).toString().equals("Nu")) {
			rdbNam.setSelected(false);
			rdbNu.setSelected(true);
		}
		txtDiaChi.setText((String) jTable.getValueAt(rowSelected, 4));
		txtSoDienThoai.setText((String) jTable.getValueAt(rowSelected, 5));
		
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
		if (action == btnAddTeacher) {
			addTeacher();
			loadDataTeacher();
		} else if (action == btnUpdateTeacher) {
			updateTeacher();
			loadDataTeacher();
		} else if (action == btnDeleteTeacher) {
			deleteteacher();
			loadDataTeacher();
		} else if (action == btnSearch) {
			searchTeacher();
		} else {
			cleanTeacher();
		}
	}

	
}
