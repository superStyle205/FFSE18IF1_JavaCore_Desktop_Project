package quanly;



import giaovien.hocsinh;
import giaovien.khoi;
import giaovien.lop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



import userdao.lopDao;


public class quanlylop  extends JFrame implements ActionListener,MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JComboBox<khoi> cboKhoi;
	private JList<hocsinh> listLop;
	private JLabel lblMa, lblTenLop, lblGiaoVienChuNhiem,  lblKhoa;
	private JTextField txtMa, txtTenLop, txtGiaoVienChuNhiem, txtKhoa;
	private JButton btAdd, btDelete, btClean, btUpdate;
	private DefaultTableModel table;
	private JTable table1;
	private JScrollPane jsr;
	private lopDao lopDao;
	public quanlylop(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}

	
	public JPanel addControls() {
		lopDao = new lopDao();
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		
		JPanel tieuDe = new JPanel();
		tieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbTieuDe = new JLabel("Quản Lý Lớp");
		lbTieuDe.setFont(new Font("Time New Roman", Font.BOLD, 20));
		tieuDe.add(lbTieuDe);
		pnMain.add(tieuDe);

		JPanel timKiem = new JPanel();
		timKiem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel lbTimKiem = new JLabel("Tìm Kiếm");
		JTextField txtTimKiem = new JTextField(16);
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		timKiem.add(lbTimKiem);
		timKiem.add(txtTimKiem);
		timKiem.add(btnTimKiem);
		pnMain.add(timKiem);
		
		JPanel pnKhoi = new JPanel();
		pnKhoi.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnMain.add(pnKhoi);
		JLabel lblKhoi = new JLabel("Chọn Khối: ");
		cboKhoi = new JComboBox<khoi>();
		cboKhoi.setPreferredSize(new Dimension(200, 25));
		pnKhoi.add(lblKhoi);
		pnKhoi.add(cboKhoi);

		pnMain.add(pnKhoi);

		
		
		JPanel danhSach = new JPanel();
		danhSach.setLayout(new BorderLayout());
		Border BorderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton = new TitledBorder(BorderButton, "Danh Sách");
		titledBorderButton.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton.setTitleColor(Color.blue);
		danhSach.setBorder(titledBorderButton);

		table = new DefaultTableModel();

		table.addColumn("Mã Lớp");
		table.addColumn("Tên Lớp");
		table.addColumn("Tên Giáo Viên Chủ Nhiệm");
		table.addColumn("Khóa");
		
		table1 = new JTable(table);
		jsr = new JScrollPane(table1);
		danhSach.add(jsr);
		pnMain.add(danhSach);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel pnSubButton = new JPanel();
		btAdd = new JButton("ADD");
		btAdd.setIcon(new ImageIcon("B:\\icon\\add-icon.png"));
		btUpdate = new JButton("UPDATE");
		btUpdate.setIcon(new ImageIcon("B:\\icon\\Actions-edit-clear-history-icon.png"));
		btDelete = new JButton("DELETE");
		btDelete.setIcon(new ImageIcon("B:\\icon\\Actions-edit-delete-icon.png"));
		btClean = new JButton("Clean");
		btClean.setIcon(new ImageIcon("B:\\icon\\Button-Delete-icon.png"));
		pnSubButton.add(btAdd);
		pnSubButton.add(btUpdate);
		pnSubButton.add(btDelete);
		pnSubButton.add(btClean);
		
		btAdd.addActionListener(this);
		btUpdate.addActionListener(this);
		btDelete.addActionListener(this);
		btClean.addActionListener(this);
//		table1.addMouseListener(this);
	

		pnButton.add(pnSubButton,BorderLayout.CENTER);
		Border BorderButton1 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton1 = new TitledBorder(BorderButton,
				"Chọn Chức Năng");
		titledBorderButton1.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton1.setTitleColor(Color.blue);
		pnButton.setBorder(titledBorderButton1);
		pnMain.add(pnButton);

		JPanel chucNang = new JPanel();
		chucNang.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Border BorderButton2 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton2 = new TitledBorder(BorderButton, "Nhập");
		titledBorderButton2.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton2.setTitleColor(Color.blue);
		chucNang.setBorder(titledBorderButton2);

		lblMa = new JLabel("Mã Lớp");
		txtMa = new JTextField(12);
		lblTenLop = new JLabel("Tên Lớp");
		txtTenLop = new JTextField(12);
		lblGiaoVienChuNhiem = new JLabel("Tên Giáo Viên Chủ Nhiệm");
		txtGiaoVienChuNhiem = new JTextField(12);
		lblKhoa = new JLabel("Khóa");
		txtKhoa = new JTextField(12);
		

		chucNang.add(lblMa);
		chucNang.add(txtMa);
		chucNang.add(lblTenLop);
		chucNang.add(txtTenLop);
		chucNang.add(lblGiaoVienChuNhiem);
		chucNang.add(txtGiaoVienChuNhiem);
		chucNang.add(lblKhoa);
		chucNang.add(txtKhoa);
		
		pnMain.add(chucNang);
		loadData();
		return pnMain;

	}
	private void loadData() {
		table.setRowCount(0);
		ArrayList<lop> listUser = lopDao.getAllUser();
		for (lop user : listUser) {
			table.addRow(new String[] { "" + user.getId(),
					 user.getTenHs(),
					user.getTenGV(), user.getKhoa()});
		}
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int rowSelected = table1.getSelectedRow();

		txtMa.setText((String) table1.getValueAt(rowSelected, 0));
		txtTenLop.setText((String) table1.getValueAt(rowSelected, 1));
		txtGiaoVienChuNhiem.setText((String) table1.getValueAt(rowSelected, 2));
		txtKhoa.setText((String) table1.getValueAt(rowSelected, 3));
		

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
		// TODO Auto-generated method stub
		Object action = e.getSource();
		if (action == btAdd) {
			addLop();
			 loadData();
		} else if (action == btUpdate) {
			updateLop();
			loadData();
		} else if (action == btDelete) {
			deleteLop();
			loadData();
		} else {
			clearLop();
		}
	}
		
	
	private void addLop() {
		lop user = new lop();

		user.setId(txtMa.getText());
		user.setTenHs(txtTenLop.getText());
		user.setTenGV(txtGiaoVienChuNhiem.getText());
		user.setKhoa(txtKhoa.getText());

		lopDao.addUser(user);
	}
	private void updateLop() {
		lop user = new lop();

		user.setId(txtMa.getText());
		user.setTenHs(txtTenLop.getText());
		user.setTenGV(txtGiaoVienChuNhiem.getText());
		user.setKhoa(txtKhoa.getText());
		

		lopDao.updateUser(user);
	}
	private void deleteLop() {

		String username = (String) table1
				.getValueAt(table1.getSelectedRow(), 0);
		lopDao.deleteUser(username);

	}
	private void clearLop() {
		txtMa.setText("");
		txtTenLop.setText("");
		txtGiaoVienChuNhiem.setText("");
		txtKhoa.setText("");
		
	}
}
