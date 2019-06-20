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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Class;
import model.dao.ClassDao;

public class ManagerStudentClassPanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	public static final String TAB_NAME = "Quản Lý Lớp Học";
	public static final ImageIcon TAB_ICON = new ImageIcon("class.png");

	private JPanel contentPanel;
	private JLabel lblMaGiaoVien;
	private JTextField txtMaGiaoVien;

	private JLabel lblTenLop;
	private JTextField txtTenLop;

	private JLabel lblTenLopTruong;
	private JTextField txtTenLopTruong;

	private JPanel pnButton;

	private JButton btnAddInfor;
	private JButton btnUpdateInfor;
	private JButton btnDeleteInfor;
	private JButton btnCleanInfor;

	private JTextField txtTimKiem;
	private JButton btnSearch;
	private JLabel lblTiemKiem;

	private JPanel pnTableInfor;
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JScrollPane jScrollPane;

	private ClassDao classDao;
	private JButton btnLoad;

	public ManagerStudentClassPanel() {
		setBackground(Color.yellow);
		setBounds(60, 50, 1800, 965);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		classDao = new ClassDao();
		initScreen();
	}

	private void initScreen() {
		JPanel panel = new JPanel();
		JLabel lblQuanLyLopHoc = new JLabel("QUẢN  LÝ  LỚP HỌC");
		lblQuanLyLopHoc.setFont(new Font("SVN-Agency FB", Font.BOLD, 30));
		lblQuanLyLopHoc.setAlignmentX(CENTER_ALIGNMENT);
		add(lblQuanLyLopHoc);

		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(12, 72, 539, 738);
		add(panel);
		panel.setLayout(null);

		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông Tin Lớp Học",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBounds(10, 10, 570, 815);
		panel.add(contentPanel);
		contentPanel.setLayout(null);

		lblMaGiaoVien = new JLabel(" Mã Giáo Viên :");
		lblMaGiaoVien.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblMaGiaoVien.setBounds(12, 61, 122, 33);
		contentPanel.add(lblMaGiaoVien);

		txtMaGiaoVien = new JTextField();
		txtMaGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMaGiaoVien.setColumns(10);
		txtMaGiaoVien.setBounds(146, 59, 412, 35);
		contentPanel.add(txtMaGiaoVien);

		lblTenLop = new JLabel("Tên Lớp :");
		lblTenLop.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTenLop.setBounds(12, 332, 122, 33);
		contentPanel.add(lblTenLop);

		txtTenLop = new JTextField();
		txtTenLop.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenLop.setColumns(10);
		txtTenLop.setBounds(146, 330, 412, 35);
		contentPanel.add(txtTenLop);

		lblTenLopTruong = new JLabel("Lớp Trưởng :");
		lblTenLopTruong.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTenLopTruong.setBounds(12, 608, 122, 33);
		contentPanel.add(lblTenLopTruong);

		txtTenLopTruong = new JTextField();
		txtTenLopTruong.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenLopTruong.setColumns(10);
		txtTenLopTruong.setBounds(146, 606, 412, 35);
		contentPanel.add(txtTenLopTruong);

		// them button
		pnButton = new JPanel();
		pnButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnButton.setBounds(592, 13, 1173, 236);
		panel.add(pnButton);
		pnButton.setLayout(null);

		btnAddInfor = new JButton("ADD");
		btnAddInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\add.png"));
		btnAddInfor.setForeground(Color.RED);
		btnAddInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnAddInfor.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAddInfor.setBounds(58, 129, 152, 77);
		pnButton.add(btnAddInfor);
		btnAddInfor.addActionListener(this);

		btnUpdateInfor = new JButton("UPDATE");
		btnUpdateInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\refresh.png"));
		btnUpdateInfor.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUpdateInfor.setForeground(Color.RED);
		btnUpdateInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnUpdateInfor.setBounds(344, 129, 152, 77);
		pnButton.add(btnUpdateInfor);
		btnUpdateInfor.addActionListener(this);

		btnDeleteInfor = new JButton("DELETE");
		btnDeleteInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\delete.png"));
		btnDeleteInfor.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDeleteInfor.setForeground(Color.RED);
		btnDeleteInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnDeleteInfor.setBounds(639, 129, 152, 77);
		pnButton.add(btnDeleteInfor);
		btnDeleteInfor.addActionListener(this);

		btnCleanInfor = new JButton("CLEAN");
		btnCleanInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\eraser.png"));
		btnCleanInfor.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCleanInfor.setForeground(Color.RED);
		btnCleanInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnCleanInfor.setBounds(941, 129, 152, 77);
		pnButton.add(btnCleanInfor);
		btnCleanInfor.addActionListener(this);

		lblTiemKiem = new JLabel("Tìm Kiếm(ML)");
		lblTiemKiem.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTiemKiem.setBounds(22, 13, 142, 46);
		pnButton.add(lblTiemKiem);
		// getRootPane().setDefaultButton(btnSearch);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(166, 13, 817, 46);
		pnButton.add(txtTimKiem);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\loupe.png"));
		btnSearch.setBounds(995, 13, 62, 46);
		
		pnButton.add(btnSearch);

		btnLoad = new JButton("");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object action = e.getSource();
				if (action == btnLoad) {
					loadDataClass();
				}
			}
		});
		btnLoad.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\folder.png"));
		btnLoad.setBounds(1069, 13, 62, 46);
		pnButton.add(btnLoad);
		btnSearch.addActionListener(this);

		// table
		pnTableInfor = new JPanel();
		pnTableInfor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTableInfor.setBounds(592, 262, 1173, 563);
		panel.add(pnTableInfor);
		pnTableInfor.setLayout(null);

		tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã Lớp");
		tableModel.addColumn("Mã Giáo Viên");
		tableModel.addColumn("Tên Lớp");
		tableModel.addColumn("Tên Lớp Trưởng");

		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(12, 13, 1149, 537);
		jScrollPane.setMaximumSize(new Dimension(1300, 300));
		jTable.addMouseListener(this);
		pnTableInfor.add(jScrollPane);

		// load data

		loadDataClass();

	}

	private void loadDataClass() {
		tableModel.setRowCount(0);
		List<Class> listData = classDao.getData();
		for (Class classStudent : listData) {
			tableModel.addRow(new String[] { "" + classStudent.getMaLop(), classStudent.getMaGiaoVien(),
					classStudent.getTenLop(), classStudent.getTenLopTruong() });
		}
	}

	private void addClassStudent() {
		Class classStudent = new Class();

		classStudent.setMaGiaoVien(txtMaGiaoVien.getText());
		classStudent.setTenLop(txtTenLop.getText());
		classStudent.setTenLopTruong(txtTenLopTruong.getText());

		classDao.addClass(classStudent);
		JOptionPane.showMessageDialog(null, "Bạn Đã Thêm Thông Tin Lớp Học Thành Công " );
	}

	private void updateClassStudent() {
		Class classStudent = new Class();
		int rowSelected = jTable.getSelectedRow();
		classStudent.setMaLop(Integer.parseInt((String) jTable.getValueAt(rowSelected, 0)));
		classStudent.setMaGiaoVien(txtMaGiaoVien.getText());
		classStudent.setTenLop(txtTenLop.getText());
		classStudent.setTenLopTruong(txtTenLopTruong.getText());

		classDao.updateClass(classStudent);
		JOptionPane.showMessageDialog(null, "Bạn Đã Sửa Thông Tin Lớp Học Thành Công " );

	}

	private void deleteClassStudent() {
		String maLop = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);

		classDao.deleteClass(maLop);
		JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Thông Tin Lớp Học Thành Công " );
	}

	private void cleanClassStudent() {
		txtMaGiaoVien.setText("");
		txtTenLop.setText("");
		txtTenLopTruong.setText("");
	}

	private void searchClassStudent() {
		tableModel.setRowCount(0);
		String maLop = txtTimKiem.getText();

		Class classStudent = new Class();
		classStudent = classDao.searchClass(maLop);

		tableModel.addRow(new String[] { "" + classStudent.getMaLop(), classStudent.getMaGiaoVien(),
				classStudent.getTenLop(), classStudent.getTenLopTruong() });
		JOptionPane.showMessageDialog(null, "Bạn Đã Tìm Lớp Học Thành Công ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAddInfor) {
			addClassStudent();
			loadDataClass();
		} else if (action == btnUpdateInfor) {
			updateClassStudent();
			loadDataClass();
		} else if (action == btnDeleteInfor) {
			deleteClassStudent();
			loadDataClass();
		} else if (action == btnSearch) {
			searchClassStudent();
		} else {
			cleanClassStudent();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = jTable.getSelectedRow();

		txtMaGiaoVien.setText((String) jTable.getValueAt(rowSelected, 1));
		txtTenLop.setText((String) jTable.getValueAt(rowSelected, 2));
		txtTenLopTruong.setText((String) jTable.getValueAt(rowSelected, 3));

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

}
