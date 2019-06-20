package quanly;

import giaovien.diem;
import giaovien.hocsinh;

import java.awt.BorderLayout;
import java.awt.Button;
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

import userdao.diemDao;

public class quanlydiem extends JFrame implements ActionListener, MouseListener {
	private DefaultTableModel table;
	private JTable table1;
	private JScrollPane jsr;
	private JButton button, btAdd, btUpdate, btDelete, btClean;
	private diemDao diemdao;
	private JTextField txtMaM, txtMaSV, txtTenM, txtDhk1, txtDhk2, txtDtb;

	// private JList<hocsinh> listHocSinh;

	public quanlydiem(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public JPanel addControls() {
		diemdao = new diemDao();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel tieuDe = new JPanel();
		tieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbTieuDe = new JLabel("Quản Lý Điểm");
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
		chucNang.setLayout(new FlowLayout(FlowLayout.CENTER));
		Border BorderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton = new TitledBorder(BorderButton, "Nhập");
		titledBorderButton.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton.setTitleColor(Color.blue);
		chucNang.setBorder(titledBorderButton);

		JLabel lbMaM = new JLabel("Mã Sinh Viên");
		txtMaM = new JTextField(12);
		JLabel lbMaSv = new JLabel("Tên Sinh Viên");
		txtMaSV = new JTextField(12);
		JLabel lbTenM = new JLabel("Tên Môn");
		txtTenM = new JTextField(12);
		JLabel lbDhk1 = new JLabel("Điểm Kiểm Tra hk 1");
		txtDhk1 = new JTextField(12);
		JLabel lbDhk2 = new JLabel("Điểm Kiểm Tra hk2");
		txtDhk2 = new JTextField(12);
		JLabel lbDtb = new JLabel("Điểm Trung Bình");
		txtDtb = new JTextField(12);

		chucNang.add(lbMaSv);
		chucNang.add(txtMaSV);
		chucNang.add(lbMaM);
		chucNang.add(txtMaM);
		chucNang.add(lbTenM);
		chucNang.add(txtTenM);
		chucNang.add(lbDhk1);
		chucNang.add(txtDhk1);
		chucNang.add(lbDhk2);
		chucNang.add(txtDhk2);
		chucNang.add(lbDtb);
		chucNang.add(txtDtb);
		pnMain.add(chucNang);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel pnSubButton = new JPanel();
		btAdd = new JButton("ADD");
		btAdd.setIcon(new ImageIcon("B:\\icon\\add-icon.png"));
		btUpdate = new JButton("UPDATE");
		btUpdate.setIcon(new ImageIcon(
				"B:\\icon\\Actions-edit-clear-history-icon.png"));
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

		pnButton.add(pnSubButton, BorderLayout.CENTER);
		Border BorderButton1 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton1 = new TitledBorder(BorderButton,
				"Chọn Chức Năng");
		titledBorderButton1.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton1.setTitleColor(Color.blue);
		pnButton.setBorder(titledBorderButton1);
		pnMain.add(pnButton);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setLayout(new BorderLayout());

		Border BorderDanhSach2 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titleBorderDanhSach2 = new TitledBorder(BorderDanhSach2,
				"Danh Sách");
		titleBorderDanhSach2.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach2.setTitleColor(Color.blue);
		pnDanhSach.setBorder(titleBorderDanhSach2);
		table = new DefaultTableModel();

		table.addColumn("Mã Sinh Viên");
		table.addColumn("Tên Sinh Viên");
		table.addColumn("Tên Môn");
		table.addColumn("Điểm Kiểm Tra hk 1");
		table.addColumn("Điểm Kiểm Tra hk2");
		table.addColumn("Điểm Trung Bình");

		table1 = new JTable(table);
		jsr = new JScrollPane(table1);
		pnDanhSach.add(jsr);
		pnMain.add(pnDanhSach);
		return pnMain;
	}

	private void loadData() {
		table.setRowCount(0);
		ArrayList<diem> listUser = diemdao.getAllUser();
		for (diem user : listUser) {
			table.addRow(new String[] { "" + user.getMaMon(), user.getTenMon(),
					user.getDiemKtrHK1(), user.getDiemKtrHK2(),
					user.getDiemTB() });
		}
	}

	public void addEvents() {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int rowSelected = table1.getSelectedRow();

		txtMaM.setText((String) table1.getValueAt(rowSelected, 0));
		txtTenM.setText((String) table1.getValueAt(rowSelected, 1));
		txtDhk1.setText((String) table1.getValueAt(rowSelected, 2));
		txtDhk2.setText((String) table1.getValueAt(rowSelected, 3));
		txtDtb.setText((String) table1.getValueAt(rowSelected, 4));

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
		// TODO Auto-generated method stub
		diem user = new diem();

		user.setMaMon(txtMaM.getText());
		user.setTenMon(txtTenM.getText());
		user.setDiemKtrHK1(txtDhk1.getText());
		user.setDiemKtrHK2(txtDhk2.getText());
		user.setDiemTB(txtDtb.getText());

		diemdao.addUser(user);
	}

	private void updateLop() {
		// TODO Auto-generated method stub
		diem user = new diem();

		user.setMaMon(txtMaM.getText());
		user.setTenMon(txtTenM.getText());
		user.setDiemKtrHK1(txtDhk1.getText());
		user.setDiemKtrHK2(txtDhk2.getText());
		user.setDiemTB(txtDtb.getText());

		diemdao.updateUser(user);
	}

	private void deleteLop() {
		// TODO Auto-generated method stub
		String username = (String) table1
				.getValueAt(table1.getSelectedRow(), 0);
		diemdao.deleteUser(username);
	}

	private void clearLop() {
		// TODO Auto-generated method stub
		txtMaM.setText("");
		txtTenM.setText("");
		txtDhk1.setText("");
		txtDhk2.setText("");
		txtDtb.setText("");

	}
}
