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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Subject;
import model.dao.SubjectDao;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ManagerStudentSubjectPanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	public static final String TAB_NAME = "Quản Lý Môn Học";
	public static final ImageIcon TAB_ICON = new ImageIcon("monhoc.png");

	private JPanel contentPanel;
	private JLabel lblTenMonHoc;
	private JTextField txtTenMonHoc;

	private JPanel pnButton;
	private JPanel pnTable;

	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLoad;
	private JButton btnClean;

	private JTextField txtTimKiem;
	private JButton btnSearch;
	private JLabel lblTimKiem;

	private DefaultTableModel tableModel;
	private JTable jTable;
	private JScrollPane jScrollPane;

	private SubjectDao subjectDao;

	public ManagerStudentSubjectPanel() {
		setBackground(Color.cyan);
		setBounds(60, 50, 1800, 965);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		subjectDao = new SubjectDao();
		initScreen();
	}

	private void initScreen() {
		JPanel panel = new JPanel();
		JLabel lblQuanLyGiaoVien = new JLabel("QUẢN  LÝ  MÔN  HỌC");
		lblQuanLyGiaoVien.setFont(new Font("SVN-Agency FB", Font.BOLD, 30));
		lblQuanLyGiaoVien.setAlignmentX(CENTER_ALIGNMENT);
		add(lblQuanLyGiaoVien);

		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(12, 72, 539, 738);
		add(panel);
		panel.setLayout(null);

		contentPanel = new JPanel();
		contentPanel.setBorder(
				new TitledBorder(UIManager.getBorder("Button.border"), "Nh\u1EADp Th\u00F4ng Tin M\u00F4n H\u1ECDc",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBounds(40, 40, 834, 244);
		panel.add(contentPanel);
		contentPanel.setLayout(null);

		lblTenMonHoc = new JLabel("Tên Môn Học :");
		lblTenMonHoc.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTenMonHoc.setBounds(84, 40, 122, 33);
		contentPanel.add(lblTenMonHoc);

		txtTenMonHoc = new JTextField();
		txtTenMonHoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenMonHoc.setColumns(10);
		txtTenMonHoc.setBounds(227, 40, 559, 35);
		contentPanel.add(txtTenMonHoc);

		btnAdd = new JButton("ADD");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\add.png"));
		btnAdd.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnAdd.setBounds(59, 109, 152, 77);
		contentPanel.add(btnAdd);
		btnAdd.addActionListener(this);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\refresh.png"));
		btnUpdate.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnUpdate.setBounds(244, 109, 152, 77);
		contentPanel.add(btnUpdate);
		btnUpdate.addActionListener(this);

		btnDelete = new JButton("DELETE");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\delete.png"));
		btnDelete.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnDelete.setBounds(425, 109, 152, 77);
		contentPanel.add(btnDelete);
		btnDelete.addActionListener(this);

		btnClean = new JButton("CLEAN");
		btnClean.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\eraser.png"));
		btnClean.setHorizontalTextPosition(SwingConstants.LEFT);
		btnClean.setForeground(Color.RED);
		btnClean.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnClean.setBounds(609, 109, 152, 77);
		contentPanel.add(btnClean);
		btnClean.addActionListener(this);

		pnButton = new JPanel();
		pnButton.setBounds(888, 40, 850, 244);
		panel.add(pnButton);
		pnButton.setLayout(null);

		lblTimKiem = new JLabel("Nhập Mã Để Tìm Kiếm Môn Học");
		lblTimKiem.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTimKiem.setBounds(285, 25, 270, 46);
		pnButton.add(lblTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(80, 84, 671, 46);
		pnButton.add(txtTimKiem);

		btnSearch = new JButton("SEARCHE");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\loupe.png"));
		btnSearch.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSearch.setForeground(Color.RED);
		btnSearch.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnSearch.setBounds(229, 154, 168, 58);
		pnButton.add(btnSearch);

		btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object action = e.getSource();
				if (action == btnLoad) {
					loadDataSubject();
				}
			}
		});
		btnLoad.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\folder.png"));
		btnLoad.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLoad.setForeground(Color.RED);
		btnLoad.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnLoad.setBounds(492, 154, 168, 58);
		pnButton.add(btnLoad);
		btnSearch.addActionListener(this);

		// table
		pnTable = new JPanel();
		pnTable.setBounds(389, 297, 977, 498);
		panel.add(pnTable);

		tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã Môn Học");
		tableModel.addColumn("Tên Môn Học");

		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(214, 51, 547, 402);

		jScrollPane.setMaximumSize(new Dimension(1300, 500));
		jTable.addMouseListener(this);
		pnTable.setLayout(null);
		pnTable.add(jScrollPane);

		loadDataSubject();
	}

	private void loadDataSubject() {
		tableModel.setRowCount(0);
		List<Subject> listData = subjectDao.getData();
		for (Subject subject : listData) {
			tableModel.addRow(new String[] { "" + subject.getMaMonHoc(), subject.getTenMonHoc() });
		}
	}

	private void addSubject() {
		Subject subject = new Subject();
		subject.setTenMonHoc(txtTenMonHoc.getText());
		subjectDao.addSubject(subject);
		JOptionPane.showMessageDialog(null, "Bạn Đã Thêm Môn Học Thành Công " );
	}

	private void updateSubject() {
		Subject subject = new Subject();

		int rowSelected = jTable.getSelectedRow();

		subject.setMaMonHoc(Integer.parseInt((String) jTable.getValueAt(rowSelected, 0)));
		subject.setTenMonHoc(txtTenMonHoc.getText());

		subjectDao.updateSubject(subject);
		JOptionPane.showMessageDialog(null, "Bạn Đã Sửa Môn Học Thành Công " );

	}

	private void deleteSubject() {
		String maMonHoc = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);

		subjectDao.deleteSubject(maMonHoc);
		JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Môn Học Thành Công " );
	}

	private void cleanSubject() {
		txtTenMonHoc.setText("");
	}

	private void searchSubject() {
		tableModel.setRowCount(0);
		String maMonHoc = txtTimKiem.getText();

		Subject subject = new Subject();
		subject = subjectDao.searchSubject(maMonHoc);

		tableModel.addRow(new String[] { "" + subject.getMaMonHoc(), subject.getTenMonHoc() });
		JOptionPane.showMessageDialog(null, "Bạn Đã Tìm Môn Học Thành Công " );
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = jTable.getSelectedRow();

		txtTenMonHoc.setText((String) jTable.getValueAt(rowSelected, 1));

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
		if (action == btnAdd) {
			addSubject();
			loadDataSubject();
		} else if (action == btnUpdate) {
			updateSubject();
			loadDataSubject();
		} else if (action == btnDelete) {
			deleteSubject();
			loadDataSubject();
		} else if (action == btnSearch) {
			searchSubject();
		} else {
			cleanSubject();
		}
	}
}
