package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.HocSinh;
import model.bean.MonHoc;
import model.dao.MonHocDao;
import model.dao.StudentDao;

public class FormQuanLiMonHoc extends JFrame implements ActionListener, MouseListener {

	private JLabel lblmagiaovien;
	private JTextField txtmagiaovien;
	private JLabel lblstd;
	private JTextField txtstd;

	private MonHocDao mhdao;

	private JButton btnSearchmon;
	private JTextField searchmon;
	private JLabel tkmon;
	private JLabel lblquanlimon;
	private JLabel lblmamon, lbaltenmon;
	private JComboBox mamon, tenmon;
	private JButton btnAdd, btnUpdate, btnDelete, btnClean, btnExit;
	private DefaultTableModel tablemodel;
	private JScrollPane jScrollPane;
	private JTable table;

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
	ImageIcon imageIconMonhoc = new ImageIcon("book.png");
	ImageIcon imageIconbinh = new ImageIcon("howto.gif");

	public void chaymon() {
		setSize(1200, 700);
		setTitle("Quán Lí Môn");
		setVisible(true);
		add(managerTab());

	}

	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();
		JPanel monhoc = quanlimon();
		myTabled.addTab("Quản Lí Môn Học", imageIconMonhoc, monhoc);
		return myTabled;
	}

	public JPanel quanlimon() {
		JPanel pnMain = new JPanel();
		Container conn = getContentPane();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);

		JPanel lblquanlimonhoc = new JPanel();
		lblquanlimon = new JLabel("QUẢN LÝ MÔN HỌC");
		lblquanlimon.setForeground(Color.BLUE);
		lblquanlimon.setFont(new Font("Time New Roman", Font.BOLD, 30));
		lblquanlimonhoc.add(lblquanlimon);
		pnMain.add(lblquanlimonhoc);

		// khhu vực layout jcombobox
		JPanel pnComborBox = new JPanel();
		JPanel pnComborBox2 = new JPanel();
		pnComborBox.setLayout(new FlowLayout());
		lblmamon = new JLabel("Mã Môn Học");
		mamon = new JComboBox<>();
		mamon.addItem("");
		mamon.addItem("Toan123");

		lbaltenmon = new JLabel("Tên Môn Học ");
		tenmon = new JComboBox<>();
		tenmon.addItem("");
		tenmon.addItem("Toán");
		tenmon.addItem("Lí");
		tenmon.addItem("Hóa");
		tenmon.addItem("Anh");
		tenmon.addItem("Văn");
		tenmon.addItem("Sinh Học");
		tenmon.addItem("Công Nghệ");
		tenmon.addItem("Lịch Sử");
		tenmon.addItem("GDCD");
		jScrollPane = new JScrollPane();
		jScrollPane.add(tenmon);
		lbaltenmon.setPreferredSize(new Dimension(150, 25));

		lblmagiaovien = new JLabel("Mã Giáo Viên");
		txtmagiaovien = new JTextField(20);
		lblstd = new JLabel("Số Tiết Dạy");
		txtstd = new JTextField(20);

		tkmon = new JLabel("Tìm Môn Học");
		searchmon = new JTextField(10);
		searchmon.setPreferredSize(new Dimension(20, 20));
		btnSearchmon = new JButton("Tìm", imageIconSearch);
		btnSearchmon.addActionListener(this);
		getRootPane().setDefaultButton(btnSearchmon);
		btnSearchmon.setPreferredSize(new Dimension(95, 30));

		// pnComborBox.add(cbChonKhoi);
		pnComborBox.add(lblmamon);
		pnComborBox.add(mamon);
		pnComborBox.add(lbaltenmon);
		pnComborBox.add(tenmon);
		
		
		pnComborBox.add(lblmagiaovien);
		pnComborBox.add(txtmagiaovien);
		pnComborBox2.add(lblstd);
		pnComborBox2.add(txtstd);
		
		//add vào nut button search
		pnComborBox2.add(tkmon);
		pnComborBox2.add(searchmon);
		pnComborBox2.add(btnSearchmon);
		pnMain.add(pnComborBox);
		pnMain.add(pnComborBox2);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));

		Border BorderButton = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton = new TitledBorder(BorderButton, "Chọn Chức Năng");
		titledBorderButton.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton.setTitleColor(Color.red);
		pnButton.setBorder(titledBorderButton);

		btnAdd = new JButton("Add");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnClean = new JButton("Clean");
		btnExit = new JButton("Exit");
		pnButton.add(btnAdd);
		pnButton.add(btnUpdate);
		pnButton.add(btnDelete);
		pnButton.add(btnClean);
		pnButton.add(btnExit);

		btnAdd.setForeground(Color.blue);
		btnUpdate.setForeground(Color.blue);
		btnDelete.setForeground(Color.blue);
		btnClean.setForeground(Color.blue);
		btnExit.setForeground(Color.blue);

		btnAdd.setPreferredSize(btnUpdate.getPreferredSize());
		btnDelete.setPreferredSize(btnUpdate.getPreferredSize());
		btnClean.setPreferredSize(btnUpdate.getPreferredSize());
		btnExit.setPreferredSize(btnUpdate.getPreferredSize());

		pnMain.add(pnButton);

		tablemodel = new DefaultTableModel();

		tablemodel.addColumn("Mã Môn Học ");
		tablemodel.addColumn("Tên Môn Học");
		tablemodel.addColumn("Mã Giáo Viên");
		tablemodel.addColumn("Số Tiết Dạy");

		table = new JTable(tablemodel);
		table.addMouseListener(this);
		jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnMain.add(jScrollPane);
		
		loadgram() ;
		return pnMain;
	}
	
	public void loadgram() {

		// xoa du lieu cu
				tablemodel.setRowCount(0);
				MonHocDao mhDao = new MonHocDao();

				ArrayList<MonHoc> listMH = mhDao.getAllUser();
				for (MonHoc mh : listMH) {
					tablemodel.addRow(new String[] { "" + mh.getMamon(), mh.getTenmonhoc(), "" + mh.getMagiaovien(), mh.getSotietday() });
				}

		
	}
	

	private void clear() {
//		mamon.setSelectedItem("");
//		tenmon.setSelectedItem("");
		txtmagiaovien.setText("");
		txtstd.setText("");

	}

	private void deleteUser() {
		mhdao = new MonHocDao();
		mhdao.deleteUser(mamon.getSelectedItem().toString());

	}

	private void updateUser() {
		MonHoc mh = new MonHoc();
		mh.setMamon(mamon.getSelectedItem().toString());
		mh.setTenmonhoc(tenmon.getSelectedItem().toString());
		mh.setSotietday(txtstd.getText());
		mh.setMagiaovien(Integer.parseInt(txtmagiaovien.getText()));

		mhdao = new MonHocDao();
		mhdao.updateUser(mh);
	}

	private void addUser() {
		MonHoc mh = new MonHoc();
		mh.setMamon(mamon.getSelectedItem().toString());
		mh.setTenmonhoc(tenmon.getSelectedItem().toString());
		mh.setSotietday(txtstd.getText());
		mh.setMagiaovien(Integer.parseInt(txtmagiaovien.getText()));

		mhdao = new MonHocDao();
		mhdao.updateUser(mh);

	}

	private void searchInfor() {
		tablemodel.setRowCount(0);
		String mamonhoc = searchmon.getText();

		mhdao = new MonHocDao();
		MonHoc studentinfor = new MonHoc();
		studentinfor = mhdao.searchInfor(mamonhoc);

		tablemodel.addRow(new String[] { "" + studentinfor.getMamon(), studentinfor.getTenmonhoc(),
				studentinfor.getSotietday() });
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = table.getSelectedRow();
		txtmagiaovien.setText((String) table.getValueAt(rowSelected, 2));
		txtstd.setText((String) table.getValueAt(rowSelected, 3));
	
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
		if (action == btnAdd) {
			if (mamon.getSelectedItem().toString().equals("") || tenmon.getSelectedItem().toString().equals("")
					|| txtmagiaovien.getText().equals("") || txtstd.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			 loadgram();

		} else if (action == btnUpdate) {
			if (mamon.getSelectedItem().toString().equals("") || tenmon.getSelectedItem().toString().equals("")
					|| txtmagiaovien.getText().equals("") || txtstd.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				updateUser();
			}

			 loadgram();
		} else if (action == btnDelete) {
			deleteUser();
			 loadgram();
		} else if (action == btnSearchmon) {
			searchInfor();

		} else  {
			clear();
		}

	}

	public static void main(String[] args) {
		FormQuanLiMonHoc mh = new FormQuanLiMonHoc();
		mh.chaymon();

	}

}
