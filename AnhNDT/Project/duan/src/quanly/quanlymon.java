package quanly;

import giaovien.lop;
import giaovien.mon;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import userdao.monDao;

public class quanlymon extends JFrame implements  ActionListener,MouseListener {
	private DefaultTableModel table;
	private JTable table1;
	private JScrollPane jsr;
	private JButton button, btAdd, btUpdate, btDelete, btClean;
	private monDao mondao;
	private JTextField txtMa,txtTen,txtMGV,txtGV,txtSoTiet,txtGChu;
	// private JList<hocsinh> listHocSinh;

	public quanlymon(String title) {
		super(title);
		addControls();
		addEvents();
	}
	
	public JPanel addControls() {
		mondao = new monDao();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		//
		
		JPanel tieuDe = new JPanel();
		tieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbTieuDe = new JLabel("Quản Lý Môn Học");
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

		JPanel chucNang = new JPanel();
		chucNang.setLayout(new GridLayout(2, 3));
		Border BorderButton1 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton1 = new TitledBorder(BorderButton1,
				"Nhập");
		titledBorderButton1.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton1.setTitleColor(Color.blue);
		chucNang.setBorder(titledBorderButton1);

		JPanel pnMa = new JPanel();
		JLabel lbMa = new JLabel("Mã Môn");
		txtMa = new JTextField(12);
		pnMa.add(lbMa);
		pnMa.add(txtMa);
		chucNang.add(pnMa);

		JPanel pnMon = new JPanel();
		JLabel lbTen = new JLabel("Tên Môn");
		txtTen = new JTextField(12);
		pnMon.add(lbTen);
		pnMon.add(txtTen);
		chucNang.add(pnMon);

		JPanel pnMaGV = new JPanel();
		JLabel lbMGV = new JLabel("Mã Giáo Viên Bộ Môn");
		txtMGV = new JTextField(12);
		pnMaGV.add(lbMGV);
		pnMaGV.add(txtMGV);
		chucNang.add(pnMaGV);

		JPanel pnTenGV = new JPanel();
		JLabel lbGV = new JLabel("Giáo Viên Bộ Môn");
		txtGV = new JTextField(12);
		pnTenGV.add(lbGV);
		pnTenGV.add(txtGV);
		chucNang.add(pnTenGV);

		JPanel pnSoTiet = new JPanel();
		JLabel lbSoTiet = new JLabel("Số Tiết");
		txtSoTiet = new JTextField(12);
		pnSoTiet.add(lbSoTiet);
		pnSoTiet.add(txtSoTiet);
		chucNang.add(pnSoTiet);

		JPanel pnGhiChu = new JPanel();
		JLabel lbDtb = new JLabel("Ghi Chú");
		txtGChu = new JTextField(12);
		pnGhiChu.add(lbDtb);
		pnGhiChu.add(txtGChu);
		chucNang.add(pnGhiChu);

		pnMain.add(chucNang);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		btAdd = new JButton("ADD");
		btAdd.setIcon(new ImageIcon("B:\\icon\\add-icon.png"));
		btUpdate = new JButton("UPDATE");
		btUpdate.setIcon(new ImageIcon("B:\\icon\\Actions-edit-clear-history-icon.png"));
		btDelete = new JButton("DELETE");
		btDelete.setIcon(new ImageIcon("B:\\icon\\Actions-edit-delete-icon.png"));
		btClean = new JButton("Clean");
		btClean.setIcon(new ImageIcon("B:\\icon\\Button-Delete-icon.png"));
		pnButton.add(btAdd);
		pnButton.add(btUpdate);
		pnButton.add(btDelete);
		pnButton.add(btClean);
		
		btAdd.addActionListener(this);
		btUpdate.addActionListener(this);
		btDelete.addActionListener(this);
		btClean.addActionListener(this);
		
		
		Border BorderButton2 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton2 = new TitledBorder(BorderButton2,
				"Chọn Chức Năng");
		titledBorderButton2.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton2.setTitleColor(Color.blue);
		pnButton.setBorder(titledBorderButton2);
		pnMain.add(pnButton);
		
		JPanel danhSach = new JPanel();
		danhSach.setLayout(new BorderLayout());
		Border BorderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton = new TitledBorder(BorderButton,
				"Danh Sách");
		titledBorderButton.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton.setTitleColor(Color.blue);
		danhSach.setBorder(titledBorderButton);

		table = new DefaultTableModel();

		table.addColumn("Mã Môn");
		table.addColumn("Tên Môn");
		table.addColumn("Mã Giáo Viên Bộ Môn");
		table.addColumn("Giáo Viên Bộ Môn");
		table.addColumn("Số Tiết");
		table.addColumn("Ghi Chú");
		table1 = new JTable(table);
		jsr = new JScrollPane(table1);
		danhSach.add(jsr);
		pnMain.add(danhSach);
		table1.addMouseListener(this);
		
		return pnMain;
		

	}
	private void loadData() {
		table.setRowCount(0); //reset chương trình	
		ArrayList<mon> listUser = mondao.getAllMon();
		for (mon user : listUser) {
			table.addRow(new String[] { "" + user.getMaMon(),
					user.getTenMon(), user.getMaGV(),user.getTenGV(),
					user.getSoTiet(), user.getGhiChu() });//chạy chương trình lấy dữ liệu từ sql
		}
	}
	public void addEvents() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int rowSelected = table1.getSelectedRow();

		txtMa.setText((String) table1.getValueAt(rowSelected, 0));
		txtTen.setText((String) table1.getValueAt(rowSelected, 1));
		txtMGV.setText((String) table1.getValueAt(rowSelected, 2));
		txtGV.setText((String) table1.getValueAt(rowSelected, 3));
		txtSoTiet.setText((String) table1.getValueAt(rowSelected, 4));
		txtGChu.setText((String) table1.getValueAt(rowSelected, 5));
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

	private void clearLop() {
		// TODO Auto-generated method stub
		txtMa.setText("");
		txtTen.setText("");
		txtMGV.setText("");
		txtGV.setText("");
		txtSoTiet.setText("");
		txtGChu.setText("");
	}

	private void deleteLop() {
		// TODO Auto-generated method stub
		String username = (String) table1
				.getValueAt(table1.getSelectedRow(), 0);
		mondao.deleteUser(username);
	}

	private void updateLop() {
		// TODO Auto-generated method stub
		mon user = new mon();

		user.setMaMon(txtMa.getText());
		user.setTenMon(txtTen.getText());
		user.setMaGV(txtMGV.getText());
		user.setTenGV(txtGV.getText());
		user.setSoTiet(txtSoTiet.getText());
		user.setGhiChu(txtGChu.getText());

		mondao.updateUser(user);
	}
	

	private void addLop() {
		// TODO AutosetMaMon-generated method stub
		mon user = new mon();

		user.setMaMon(txtMa.getText());
		user.setTenMon(txtTen.getText());
		user.setMaGV(txtMGV.getText());
		user.setTenGV(txtGV.getText());
		user.setSoTiet(txtSoTiet.getText());
		user.setGhiChu(txtGChu.getText());
		

		mondao.addUser(user);
	}
	}

	
