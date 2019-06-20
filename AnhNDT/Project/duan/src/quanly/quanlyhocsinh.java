package quanly;


import giaovien.hocsinh;
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

import userdao.hocsinhDao;

public class quanlyhocsinh extends JFrame implements ActionListener,MouseListener {
	private DefaultTableModel table;
	private JTable table1;
	private JScrollPane jsr;
	private JButton button, btAdd, btUpdate, btDelete,btClean;
	private JList<hocsinh> listHocSinh;
	private JTextField txtMa,txtTen,txtTuoi,txtDiaChi,txtSdt,txtEmail;
	private hocsinhDao hocsinhdao;
	public quanlyhocsinh(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public JPanel addControls() {
		hocsinhdao = new hocsinhDao();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		//
		JPanel tieuDe = new JPanel();
		tieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbTieuDe = new JLabel("Quản Lý Học Sinh");
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
		
		
		JPanel danhSach = new JPanel();
		danhSach.setLayout(new BorderLayout());
		Border BorderButton = BorderFactory.createLineBorder(Color.red);
		TitledBorder titledBorderButton = new TitledBorder(BorderButton, "Danh Sách");
		titledBorderButton.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton.setTitleColor(Color.blue);
		danhSach.setBorder(titledBorderButton);

		table = new DefaultTableModel();

		table.addColumn("Mã");
		table.addColumn("Tên");
		table.addColumn("Tuổi");
		table.addColumn("Địa Chỉ");
		table.addColumn("Số Điện Thoại");
		table.addColumn("Email");

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
		table1.addMouseListener(this);
	

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

		JLabel lbMa = new JLabel("Mã");
		 txtMa = new JTextField(12);
		JLabel lbTen = new JLabel("Tên");
		 txtTen = new JTextField(12);
		JLabel lbTuoi = new JLabel("Tuổi");
		 txtTuoi = new JTextField(12);
		JLabel lbDiaChi = new JLabel("Địa Chỉ");
		 txtDiaChi = new JTextField(12);
		JLabel lbSdt = new JLabel("Số Điện Thoại");
		 txtSdt = new JTextField(12);
		JLabel lbEmail = new JLabel("Email");
		 txtEmail = new JTextField(12);

		chucNang.add(lbMa);
		chucNang.add(txtMa);
		chucNang.add(lbTen);
		chucNang.add(txtTen);
		chucNang.add(lbTuoi);
		chucNang.add(txtTuoi);
		chucNang.add(lbDiaChi);
		chucNang.add(txtDiaChi);
		chucNang.add(lbSdt);
		chucNang.add(txtSdt);
		chucNang.add(lbEmail);
		chucNang.add(txtEmail);
		pnMain.add(chucNang);

		return pnMain;
	}
	private void loadData() {
		table.setRowCount(0); 	
		ArrayList<hocsinh> listUser = hocsinhdao.getAllUser();
		for (hocsinh user : listUser) {
			table.addRow(new String[] { "" + user.getMa(),
					user.getTen(), user.getTuoi(),
					user.getSdt(), user.getDiaChi(),user.getEmail() });
		}
	}
	public void addEvents() {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int rowSelected = table1.getSelectedRow();

		txtMa.setText((String) table1.getValueAt(rowSelected, 0));
		txtTen.setText((String) table1.getValueAt(rowSelected, 1));
		txtTuoi.setText((String) table1.getValueAt(rowSelected, 2));
		txtSdt.setText((String) table1.getValueAt(rowSelected, 3));
		txtDiaChi.setText((String) table1.getValueAt(rowSelected, 4));
		txtEmail.setText((String) table1.getValueAt(rowSelected, 5));
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
		if (action  == btAdd) {
			addHocSinh();
			 loadData();
		} else if (action == btUpdate) {
			updateHocSinh();
			loadData();
		} else if (action == btDelete) {
			deleteHocSinh();
			loadData();
		} else {
			clearHocSinh();
		}
	}

	private void addHocSinh() {
		// TODO Auto-generated method stub
		hocsinh user = new hocsinh();

		user.setMa(txtMa.getText());
		user.setTen(txtTen.getText());
		user.setTuoi(txtTuoi.getText());
		user.setSdt(txtSdt.getText());
		user.setDiaChi(txtDiaChi.getText());
		user.setEmail(txtEmail.getText());
		
		hocsinhdao.addUser(user);
	}

	private void updateHocSinh() {
		// TODO Auto-generated method stub
		hocsinh user = new hocsinh();

		user.setMa(txtMa.getText());
		user.setTen(txtTen.getText());
		user.setTuoi(txtTuoi.getText());
		user.setSdt(txtSdt.getText());
		user.setDiaChi(txtDiaChi.getText());
		user.setEmail(txtEmail.getText());
		

		hocsinhdao.updateUser(user);
	}

	private void deleteHocSinh() {
		// TODO Auto-generated method stub
		String username = (String) table1
				.getValueAt(table1.getSelectedRow(), 0);
		hocsinhdao.deleteUser(username);
	}

	private void clearHocSinh() {
		// TODO Auto-generated method stub
		txtMa.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtSdt.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
	}
	}


	
