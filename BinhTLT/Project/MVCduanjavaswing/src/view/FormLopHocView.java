package view;

import java.awt.CardLayout;
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

import model.bean.HoSoHocSinh;
import model.bean.Lop;
import model.dao.HoSoHocSinhDao;
import model.dao.LopHocDao;

public class FormLopHocView extends JFrame implements ActionListener, MouseListener {
	private JLabel tkmon;
	private JTextField searchmon;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JScrollPane jScrollPane;

	private JLabel lbldlop;
	private JScrollPane scroll;
	private JLabel lblmalop;
	private JComboBox malop;
	private JLabel lbltenlop;
	private JTextField txttenlop;
	private JLabel lblgvchung;
	private JTextField txtgvch;
	private JLabel lblmakhoa;
	private JComboBox makhoa;
	private JLabel lblmakhoi;
	private JComboBox makhoi;
	private JLabel lblnienkhoa;
	private JComboBox nienkhoa;
	private JTextField search;

	
	private LopHocDao lopdao;
	private JButton btnAdd, btnUpdate, btnDelete, btnClean, btnsearch;

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

	public void chaylophoc() {
		setSize(1200, 700);
		setTitle("bảng điểm học sinh");
		setVisible(true);
		 add(managerTab());
		// loadgram();
	}

	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();
		JPanel lop = quanlilop();
		myTabled.addTab("Quản Lí Điểm", imageIconDIEM, lop);
		return myTabled;
	}

	public JPanel quanlilop() {
		JPanel pnMain1 = new JPanel(); // Panel main	
		Container conn = getContentPane();
		pnMain1.setLayout(new BoxLayout(pnMain1, BoxLayout.Y_AXIS));
		conn.add(pnMain1);

		JPanel qlloppanel = new JPanel();
		//qlloppanel.setLayout(new BoxLayout(qlloppanel, BoxLayout.Y_AXIS));
		lbldlop = new JLabel("QUẢN LỚP HỌC");
		lbldlop.setFont(new Font("Time New Roman", Font.BOLD, 30));
		qlloppanel.add(lbldlop);
		pnMain1.add(qlloppanel);

		JPanel pnComborBox = new JPanel();
		JPanel pnComborBox2 = new JPanel();
		pnComborBox.setLayout(new FlowLayout());

		lblmalop = new JLabel("Mã Lớp");
		malop = new JComboBox<>();
		malop.addItem("");
		malop.addItem("lp111");
		malop.addItem("lp123");
		malop.addItem("lp190");

		lbltenlop = new JLabel("Tên Lớp");
		txttenlop = new JTextField(10);

		lblgvchung = new JLabel("Gv_Chủ nghiệm");
		txtgvch = new JTextField(10);
		lblmakhoa = new JLabel("Mã Khoa");
		makhoa = new JComboBox<>();
		makhoa.addItem("");

		lblmakhoi = new JLabel("Mã Khối");
		makhoi = new JComboBox<>();
		makhoi.addItem("");

		lblnienkhoa = new JLabel("Tên Niên Khóa");
		nienkhoa = new JComboBox<>();
		nienkhoa.addItem("");

		tkmon = new JLabel("Tìm Mã Lớp");
		searchmon = new JTextField(10);
		searchmon.setPreferredSize(new Dimension(20, 20));
		btnsearch = new JButton("Tìm", imageIconSearch);
		btnsearch.addActionListener(this);
		getRootPane().setDefaultButton(btnsearch);
		btnsearch.setPreferredSize(new Dimension(95, 30));

		pnComborBox.add(lblmalop);
		pnComborBox.add(malop);
		pnComborBox.add(lbltenlop);
		pnComborBox.add(txttenlop);
		pnComborBox.add(lblgvchung);
		pnComborBox.add(txtgvch);
		pnComborBox2.add(lblmakhoa);
		pnComborBox2.add(makhoa);
		pnComborBox2.add(lblmakhoi);
		pnComborBox2.add(makhoi);
		pnComborBox2.add(lblnienkhoa);
		pnComborBox2.add(nienkhoa);
		pnComborBox2.add(tkmon);
		pnComborBox2.add(searchmon);
		pnComborBox2.add(btnsearch);

		pnMain1.add(pnComborBox);
		pnMain1.add(pnComborBox2);

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

		pnButton.add(btnAdd);
		pnButton.add(btnUpdate);
		pnButton.add(btnDelete);
		pnButton.add(btnClean);

		btnAdd.setForeground(Color.blue);
		btnUpdate.setForeground(Color.blue);
		btnDelete.setForeground(Color.blue);
		btnClean.setForeground(Color.blue);

		btnAdd.setPreferredSize(btnUpdate.getPreferredSize());
		btnDelete.setPreferredSize(btnUpdate.getPreferredSize());
		btnClean.setPreferredSize(btnUpdate.getPreferredSize());
		pnMain1.add(pnButton);
		JPanel pntable= new JPanel();
		pntable.setLayout(new BoxLayout(pntable, BoxLayout.Y_AXIS));
		tablemodel = new DefaultTableModel();

		tablemodel.addColumn("Mã Lớp ");
		tablemodel.addColumn("Tên Lớp");
		tablemodel.addColumn("Gv Chủ Nghiệm");
		tablemodel.addColumn("Mã Khoa");
		tablemodel.addColumn("Mã Khối");
		tablemodel.addColumn("Tên Niên Khóa");

		table = new JTable(tablemodel);
		table.addMouseListener(this);
		jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pntable.add(jScrollPane);

		pnMain1.add(pntable);

		loadgram();
		return pnMain1;
		

	}
	
	
	private void clear() {
		malop.setSelectedItem("");
		txttenlop.setText("");
		txtgvch.setText("");
		makhoa.setSelectedItem("");
		makhoi.setSelectedItem("");
		nienkhoa.setSelectedItem("");
		
	}

	private void deleteUser() {
		lopdao = new LopHocDao();
		lopdao.deleteUser(malop.getSelectedItem().toString());

	}

	private void updateUser() {
		Lop hs = new Lop();
		hs.setMalop(malop.getSelectedItem().toString());
		hs.setTenlop(txttenlop.getText());
		hs.setGvchu_nghiem(txtgvch.getText());
		hs.setMakhoa(makhoa.getSelectedItem().toString());
		hs.setMakhoi(makhoi.getSelectedItem().toString());
		hs.setTennienkhoa(nienkhoa.getSelectedItem().toString());
		
		lopdao = new LopHocDao();
		lopdao.updateUser(hs);
	}

	private void addUser() {
		Lop hs = new Lop();
		hs.setMalop(malop.getSelectedItem().toString());
		hs.setTenlop(txttenlop.getText());
		hs.setGvchu_nghiem(txtgvch.getText());
		hs.setMakhoa(makhoa.getSelectedItem().toString());
		hs.setMakhoi(makhoi.getSelectedItem().toString());
		hs.setTennienkhoa(nienkhoa.getSelectedItem().toString());
		
		lopdao = new LopHocDao();
		lopdao.updateUser(hs);

	}

	private void searchInfor() {
		tablemodel.setRowCount(0);
		String malop = search.getText();

		lopdao = new LopHocDao();
		Lop studentinfor = new Lop();
		studentinfor = lopdao.searchInfor(malop);

		tablemodel.addRow(new String[] { "" + studentinfor.getMalop(), studentinfor.getTenlop(),
				studentinfor.getGvchu_nghiem(), studentinfor.getMakhoa(), studentinfor.getMakhoi(), studentinfor.getTennienkhoa(),
				 });
	}
	
	public void loadgram() {
		tablemodel.setRowCount(0);
		LopHocDao lopDao = new LopHocDao();

		ArrayList<Lop> listlop = lopDao.getAllUser();
		for (Lop lop : listlop) {
			tablemodel.addRow(new String[] { "" + lop.getMalop(), lop.getMalop(), lop.getGvchu_nghiem(), lop.getMakhoa(),
					lop.getMakhoa(), lop.getTennienkhoa() });
		}

	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = table.getSelectedRow();
		txtgvch.setText((String) table.getValueAt(rowSelected, 0));
		
		
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object action = e.getSource();
		if (action == btnAdd) {
			if (malop.getSelectedItem().toString().equals("") || txttenlop.getText().equals("") || txtgvch.getText().equals("")
					|| makhoa.getSelectedItem().toString().equals("") || makhoi.getSelectedItem().toString().equals("")
					|| nienkhoa.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			loadgram();

		} else if (action == btnUpdate) {
			if (malop.getSelectedItem().toString().equals("") || txttenlop.getText().equals("") || txtgvch.getText().equals("")
					|| makhoa.getSelectedItem().toString().equals("") || makhoi.getSelectedItem().toString().equals("")
					|| nienkhoa.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				updateUser();
			}

			loadgram();
		} else if (action == btnDelete) {
			deleteUser();
			loadgram();
		} else if (action == btnsearch) {
			searchInfor();
			
		} else {
			clear();
		}
	}
	public static void main(String[] args) {
		FormLopHocView lp = new FormLopHocView();
		lp.chaylophoc();
	}


}
