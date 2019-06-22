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

import model.bean.Student;
import model.dao.StudentDao;

public class ManagerStudentInfoPanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	public static final String TAB_NAME = "Quản lý Thông Tin Học Sinh";
	public static final ImageIcon TAB_ICON = new ImageIcon("student.png");

	private JPanel contentPanel;

	private JLabel lblSdtPH;
	private JTextField txtSdtPH;

	private JLabel lblMaLop;
	private JTextField txtMaLop;

	private JLabel lblNienKhoa;
	private JTextField txtNienKhoa;

	private JLabel lblHoTen;
	private JTextField txtHoTen;

	private JLabel lblGioiTinh;
	private JRadioButton rdbNam;
	private JRadioButton rdbNu;
	private ButtonGroup btnGroupInfor;

	private JLabel lblNgaySinh;
	private JTextField txtNgaySinh;

	private JLabel lblNoiSinh;
	private JTextField txtNoiSinh;

	private JLabel lblDanToc;
	private JTextField txtDanToc;

	private JLabel lblTonGiao;
	private JTextField txtTonGiao;

	private JPanel pnButton;
	protected JButton btnAddInfor;
	protected JButton btnUpdateInfor;
	protected JButton btnDeleteInfor;
	protected JButton btnCleanInfor;
	private JTextField txtTimKiem;
	protected JButton btnSearch;
	private JLabel lblTiemKiem;

	private JPanel pnTableInfor;
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JScrollPane jScrollPane;

	private StudentDao studentDao;
	private JButton btnLoad;

	public ManagerStudentInfoPanel() {
		setBackground(Color.PINK);
		setBounds(60, 50, 1800, 965);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		studentDao = new StudentDao();
		initScreen();

	}

	private void initScreen() {
		JPanel panel = new JPanel();
		JLabel lblQuanLyThongTin = new JLabel("QUẢN  LÝ  THÔNG  TIN  HỌC  SINH");
		lblQuanLyThongTin.setFont(new Font("SVN-Agency FB", Font.BOLD, 30));
		lblQuanLyThongTin.setAlignmentX(CENTER_ALIGNMENT);
		add(lblQuanLyThongTin);

		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(12, 72, 539, 738);
		add(panel);
		panel.setLayout(null);
		{
			contentPanel = new JPanel();
			contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông Tin Học Sinh",
					TitledBorder.CENTER, TitledBorder.TOP, null, null));
			contentPanel.setBackground(new Color(240, 240, 240));
			contentPanel.setBounds(10, 10, 570, 815);
			panel.add(contentPanel);
			contentPanel.setLayout(null);

			lblHoTen = new JLabel("Họ Tên :");
			lblHoTen.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblHoTen.setBounds(15, 132, 122, 33);
			contentPanel.add(lblHoTen);

			txtHoTen = new JTextField();
			txtHoTen.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtHoTen.setColumns(10);
			txtHoTen.setBounds(145, 130, 412, 35);
			contentPanel.add(txtHoTen);

			lblNgaySinh = new JLabel("Ngày Sinh :");
			lblNgaySinh.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblNgaySinh.setBounds(15, 204, 122, 33);
			contentPanel.add(lblNgaySinh);

			txtNgaySinh = new JTextField();
			txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtNgaySinh.setColumns(10);
			txtNgaySinh.setBounds(145, 202, 412, 35);
			contentPanel.add(txtNgaySinh);

			lblGioiTinh = new JLabel("Giới Tính :");
			lblGioiTinh.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblGioiTinh.setBounds(15, 280, 122, 33);
			contentPanel.add(lblGioiTinh);

			rdbNam = new JRadioButton("Nam");
			rdbNam.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			rdbNam.setBounds(142, 285, 127, 25);
			contentPanel.add(rdbNam);

			rdbNu = new JRadioButton("Nữ");
			rdbNu.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			rdbNu.setBounds(273, 285, 127, 25);
			contentPanel.add(rdbNu);

			btnGroupInfor = new ButtonGroup();
			btnGroupInfor.add(rdbNam);
			btnGroupInfor.add(rdbNu);

			lblNoiSinh = new JLabel("Nơi Sinh :");
			lblNoiSinh.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblNoiSinh.setBounds(15, 358, 122, 33);
			contentPanel.add(lblNoiSinh);

			txtNoiSinh = new JTextField();
			txtNoiSinh.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtNoiSinh.setColumns(10);
			txtNoiSinh.setBounds(145, 356, 412, 35);
			contentPanel.add(txtNoiSinh);

			lblDanToc = new JLabel("Dân Tộc :");
			lblDanToc.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblDanToc.setBounds(15, 451, 122, 33);
			contentPanel.add(lblDanToc);

			txtDanToc = new JTextField();
			txtDanToc.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtDanToc.setColumns(10);
			txtDanToc.setBounds(145, 449, 412, 35);
			contentPanel.add(txtDanToc);

			lblTonGiao = new JLabel("Tôn Giáo :");
			lblTonGiao.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblTonGiao.setBounds(15, 545, 122, 33);
			contentPanel.add(lblTonGiao);

			txtTonGiao = new JTextField();
			txtTonGiao.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtTonGiao.setColumns(10);
			txtTonGiao.setBounds(145, 543, 412, 35);
			contentPanel.add(txtTonGiao);

			lblNienKhoa = new JLabel("Niên Khóa :");
			lblNienKhoa.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblNienKhoa.setBounds(15, 645, 122, 33);
			contentPanel.add(lblNienKhoa);

			txtNienKhoa = new JTextField();
			txtNienKhoa.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtNienKhoa.setColumns(10);
			txtNienKhoa.setBounds(145, 643, 412, 35);
			contentPanel.add(txtNienKhoa);

			lblMaLop = new JLabel("Mã Lớp :");
			lblMaLop.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblMaLop.setBounds(15, 63, 122, 33);
			contentPanel.add(lblMaLop);

			txtMaLop = new JTextField();
			txtMaLop.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtMaLop.setColumns(10);
			txtMaLop.setBounds(145, 63, 412, 35);
			contentPanel.add(txtMaLop);

			lblSdtPH = new JLabel("SĐT PH:");
			lblSdtPH.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
			lblSdtPH.setBounds(15, 742, 122, 33);
			contentPanel.add(lblSdtPH);

			txtSdtPH = new JTextField();
			txtSdtPH.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtSdtPH.setColumns(10);
			txtSdtPH.setBounds(145, 740, 412, 35);
			contentPanel.add(txtSdtPH);

			{
				pnButton = new JPanel();
				pnButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				pnButton.setBounds(592, 13, 1173, 236);
				panel.add(pnButton);
				pnButton.setLayout(null);

				// THEM BUTTON
				{
					btnAddInfor = new JButton("ADD");
					btnAddInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\add.png"));

					btnAddInfor.setForeground(Color.RED);
					btnAddInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));

					btnAddInfor.setHorizontalTextPosition(SwingConstants.LEFT);
					btnAddInfor.setBounds(58, 129, 152, 77);
					pnButton.add(btnAddInfor);
					btnAddInfor.addActionListener(this);
				}
				{
					btnUpdateInfor = new JButton("UPDATE");

					btnUpdateInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\refresh.png"));
					btnUpdateInfor.setHorizontalTextPosition(SwingConstants.LEFT);
					btnUpdateInfor.setForeground(Color.RED);
					btnUpdateInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
					btnUpdateInfor.setBounds(344, 129, 152, 77);
					pnButton.add(btnUpdateInfor);
					btnUpdateInfor.addActionListener(this);
				}
				{
					btnDeleteInfor = new JButton("DELETE");
					btnDeleteInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\delete.png"));
					btnDeleteInfor.setHorizontalTextPosition(SwingConstants.LEFT);
					btnDeleteInfor.setForeground(Color.RED);
					btnDeleteInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
					btnDeleteInfor.setBounds(639, 129, 152, 77);
					pnButton.add(btnDeleteInfor);
					btnDeleteInfor.addActionListener(this);
				}
				{
					btnCleanInfor = new JButton("CLEAN");

					btnCleanInfor.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\eraser.png"));
					btnCleanInfor.setHorizontalTextPosition(SwingConstants.LEFT);
					btnCleanInfor.setForeground(Color.RED);
					btnCleanInfor.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
					btnCleanInfor.setBounds(941, 129, 152, 77);
					pnButton.add(btnCleanInfor);
					btnCleanInfor.addActionListener(this);
				}
				{
					txtTimKiem = new JTextField();
					txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
					txtTimKiem.setColumns(10);
					txtTimKiem.setBounds(166, 13, 823, 46);
					pnButton.add(txtTimKiem);

					btnSearch = new JButton("");
					btnSearch.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\loupe.png"));
					btnSearch.setBounds(1001, 13, 62, 46);
					pnButton.add(btnSearch);
					btnSearch.addActionListener(this);

					lblTiemKiem = new JLabel("Tìm Kiếm(MHS)");
					lblTiemKiem.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
					lblTiemKiem.setBounds(22, 13, 142, 46);
					pnButton.add(lblTiemKiem);
				}

				btnLoad = new JButton("");
				btnLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Object action = e.getSource();
						if (action == btnLoad) {
							loadDataInfor();
						}
					}
				});
				btnLoad.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\folder.png"));
				btnLoad.setBounds(1075, 13, 62, 46);
				pnButton.add(btnLoad);
			}
			{
				pnTableInfor = new JPanel();
				pnTableInfor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				pnTableInfor.setBounds(592, 262, 1173, 563);
				panel.add(pnTableInfor);
				pnTableInfor.setLayout(null);

			}

			// table
			tableModel = new DefaultTableModel();
			tableModel.addColumn("Mã Học Sinh");
			tableModel.addColumn("Mã Lớp");
			tableModel.addColumn("Họ Tên");
			tableModel.addColumn("Ngày Sinh");
			tableModel.addColumn("Giới Tính");
			tableModel.addColumn("Nơi Sinh");
			tableModel.addColumn("Dân Tộc");
			tableModel.addColumn("Tôn Giáo");
			tableModel.addColumn("Niên Khóa");
			tableModel.addColumn("SĐT Phụ Huynh");

			jTable = new JTable(tableModel);
			jScrollPane = new JScrollPane(jTable);
			jScrollPane.setBounds(12, 13, 1149, 537);
			jScrollPane.setMaximumSize(new Dimension(1300, 300));
			jTable.addMouseListener(this);
			pnTableInfor.add(jScrollPane);

			// loaddata
			loadDataInfor();
		}
	}

	private void loadDataInfor() {
		tableModel.setRowCount(0);
		List<Student> listData = studentDao.getData();
		for (Student studentinfor : listData) {
			tableModel.addRow(new String[] { "" + studentinfor.getMaHocSinh(), studentinfor.getMaLop(),
					studentinfor.getHoTen(), studentinfor.getNgaySinh(), studentinfor.getGioiTinh(),
					studentinfor.getNoiSinh(), studentinfor.getDanToc(), studentinfor.getTonGiao(),
					"" + studentinfor.getNienKhoa(), "" + studentinfor.getSdtPhuHuynh() });
		}
	}

	private void addInforStudent() {
		Student studentInfor = new Student();

		studentInfor.setMaLop(txtMaLop.getText());
		studentInfor.setHoTen(txtHoTen.getText());
		studentInfor.setNgaySinh(txtNgaySinh.getText());
		if (rdbNam.isSelected()) {
			studentInfor.setGioiTinh("Nam");
		} else {
			studentInfor.setGioiTinh("Nu");
		}
		studentInfor.setNoiSinh(txtNoiSinh.getText());
		studentInfor.setDanToc(txtDanToc.getText());
		studentInfor.setTonGiao(txtTonGiao.getText());
		studentInfor.setNienKhoa(txtNienKhoa.getText());
		studentInfor.setSdtPhuHuynh(txtSdtPH.getText());

		studentDao.addInfor(studentInfor);

		JOptionPane.showMessageDialog(null, "Bạn Đã Thêm Thông Tin Học Sinh Thành Công ");
	}

	private void updateInforStudent() {
		Student studentInfor = new Student();
		int rowSelected = jTable.getSelectedRow();
		studentInfor.setMaHocSinh(Integer.parseInt((String) jTable.getValueAt(rowSelected, 0)));
		studentInfor.setMaLop(txtMaLop.getText());
		studentInfor.setHoTen(txtHoTen.getText());
		studentInfor.setNgaySinh(txtNgaySinh.getText());
		if (rdbNam.isSelected()) {
			studentInfor.setGioiTinh("Nam");
		} else {
			studentInfor.setGioiTinh("Nu");
		}
		studentInfor.setNoiSinh(txtNoiSinh.getText());
		studentInfor.setDanToc(txtDanToc.getText());
		studentInfor.setTonGiao(txtTonGiao.getText());
		studentInfor.setNienKhoa(txtNienKhoa.getText());
		studentInfor.setSdtPhuHuynh(txtSdtPH.getText());

		studentDao.updateInfor(studentInfor);
		JOptionPane.showMessageDialog(null, "Bạn Đã Sửa Thông Tin Học Sinh Thành Công ");
	}

	private void deleteInforStudent() {
		String maHocSinh = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);

		studentDao.deleteInfor(maHocSinh);

		JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Thành Công Học Sinh Có Mã : " + maHocSinh, "Title",
				JOptionPane.QUESTION_MESSAGE);
	}

	private void clearInforStudent() {
		txtMaLop.setText("");
		txtHoTen.setText("");
		txtNgaySinh.setText("");
		btnGroupInfor.clearSelection();
		txtNoiSinh.setText("");
		txtDanToc.setText("");
		txtTonGiao.setText("");
		txtNienKhoa.setText("");
		txtSdtPH.setText("");
	}

	private void searchInforStudent() {

		String maHocSinh = txtTimKiem.getText();

		Student studentinfor = new Student();
		studentinfor = studentDao.searchInfor(maHocSinh);
		tableModel.setRowCount(0);

		tableModel.addRow(new String[] { "" + studentinfor.getMaHocSinh(), studentinfor.getHoTen(),
				studentinfor.getNgaySinh(), studentinfor.getGioiTinh(), studentinfor.getNoiSinh(),
				studentinfor.getDanToc(), studentinfor.getTonGiao(), studentinfor.getMaLop() });
		JOptionPane.showMessageDialog(null, "Bạn Đã Tìm Thành Công Học Sinh Có Mã : " + maHocSinh, "Title",
				JOptionPane.QUESTION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAddInfor) {
			addInforStudent();
			loadDataInfor();
		} else if (action == btnUpdateInfor) {
			updateInforStudent();
			loadDataInfor();
		} else if (action == btnDeleteInfor) {
			deleteInforStudent();
			loadDataInfor();
		} else if (action == btnSearch) {
			searchInforStudent();
		} else {
			clearInforStudent();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = jTable.getSelectedRow();

		txtMaLop.setText((String) jTable.getValueAt(rowSelected, 1));
		txtHoTen.setText((String) jTable.getValueAt(rowSelected, 2));
		txtNgaySinh.setText((String) jTable.getValueAt(rowSelected, 3));

		if (jTable.getValueAt(rowSelected, 4).toString().equals("Nam")) {
			rdbNam.setSelected(true);
			rdbNu.setSelected(false);
		} else if (jTable.getValueAt(rowSelected, 4).toString().equals("Nu")) {
			rdbNam.setSelected(false);
			rdbNu.setSelected(true);
		}
		txtNoiSinh.setText((String) jTable.getValueAt(rowSelected, 5));
		txtDanToc.setText((String) jTable.getValueAt(rowSelected, 6));
		txtTonGiao.setText((String) jTable.getValueAt(rowSelected, 7));
		txtNienKhoa.setText((String) jTable.getValueAt(rowSelected, 8));
		txtSdtPH.setText((String) jTable.getValueAt(rowSelected, 9));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
