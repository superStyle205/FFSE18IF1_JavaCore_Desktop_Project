package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.BangDiem;
import model.bean.HocSinh;
import model.dao.BangDiemDao;
import model.dao.StudentDao;

public class FromBangDiem extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lbCapNhatDiem;
	private JLabel lbChonLop, lbChonMon, lbChonHocKi;
	private JLabel lbMaHocSinh, lbTenHocSinh, lbltelop, lbGhiChu, lb15pLan1, lb15pLan2, lb45p;
	private JTextField txtMaHocSinh,  txtGhiChu, txtdmieng, txtd15p, txt45p, txtthi;
	private JButton btnAdd, btnUpdate, btnDelete, btnClean, btnExit;
	private JComboBox cbChonMon, malop,  mamon;
	// private JComboBox cbChonKhoi;
	private JComboBox cbChonLop;
	private JComboBox cbChonHocKi;
	private DefaultTableModel table;
	private JScrollPane sc;
	private JTable tab;
	
	private BangDiemDao bddao;

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

	// public FromBangDiem(){}

	public void chaybangdiem() {
		setSize(1200, 700);
		setTitle("bảng điểm học sinh");
		add(managerTab());
		loadgram();

	}

	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();
		JPanel diem = quanlidiem();
		myTabled.addTab("Quản Lí Điểm", imageIconDIEM, diem);
		return myTabled;
	}

	public JPanel quanlidiem() {
		JPanel pnMain = new JPanel();
		Container conn = getContentPane();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);

		JPanel pnCapNhatDiem = new JPanel();
		lbCapNhatDiem = new JLabel("QUẢN LÝ ĐIỂM HỌC SINH");
		lbCapNhatDiem.setFont(new Font("Time New Roman", Font.BOLD, 30));
		pnCapNhatDiem.add(lbCapNhatDiem);
		pnMain.add(pnCapNhatDiem);

		JPanel pnComborBox = new JPanel();
		pnComborBox.setLayout(new FlowLayout());
		// lbChonKhoi = new JLabel("Chọn Khối: ");
		// cbChonKhoi = new JComboBox<>();
		// cbChonKhoi.setPreferredSize(new Dimension(150, 25));
		lbChonLop = new JLabel("Mã Môn: ");
		cbChonLop = new JComboBox<>();
		cbChonLop.addItem("");
		cbChonLop.addItem("lp111");
		cbChonLop.addItem("lp190");
		cbChonLop.addItem("lp123");
		cbChonLop.setPreferredSize(new Dimension(150, 25));
		lbChonMon = new JLabel("Chọn Môn: ");
		cbChonMon = new JComboBox<>();
		cbChonMon.addItem("");
		cbChonMon.addItem("Toán");
		cbChonMon.addItem("Lí");
		cbChonMon.addItem("Hóa");
		cbChonMon.addItem("Anh");
		cbChonMon.addItem("Văn");
		cbChonMon.addItem("Công Nghệ");
		cbChonMon.addItem("Địa");
		cbChonMon.addItem("Sinh Học");
		cbChonMon.addItem("Lịch Sử");
		cbChonMon.addItem("GDCD");

		sc = new JScrollPane();
		cbChonMon.add(sc);
		cbChonMon.setPreferredSize(new Dimension(150, 25));
		lbChonHocKi = new JLabel("Chọn Học Kì: ");
		cbChonHocKi = new JComboBox<>();
		cbChonHocKi.addItem("");
		cbChonHocKi.addItem("kì 1");
		cbChonHocKi.addItem("Kì 2");
		cbChonHocKi.setPreferredSize(new Dimension(150, 25));
		// pnComborBox.add(lbChonKhoi);
		// pnComborBox.add(cbChonKhoi);
		pnComborBox.add(lbChonLop);
		pnComborBox.add(cbChonLop);
		pnComborBox.add(lbChonMon);
		pnComborBox.add(cbChonMon);
		pnComborBox.add(lbChonHocKi);
		pnComborBox.add(cbChonHocKi);
		pnMain.add(pnComborBox);

		JPanel pnbtnNhapDiem = new JPanel();
		pnbtnNhapDiem.setLayout(new GridLayout(2, 4));

		Border BorderButton1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton1 = new TitledBorder(BorderButton1, "Nhập Điểm");
		titledBorderButton1.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton1.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton1.setTitleColor(Color.red);
		pnbtnNhapDiem.setBorder(titledBorderButton1);
		JPanel pnMaHocSinh = new JPanel();
		lbMaHocSinh = new JLabel("Mã Học Sinh:");
		txtMaHocSinh = new JTextField(10);
		pnMaHocSinh.add(lbMaHocSinh);
		pnMaHocSinh.add(txtMaHocSinh);
		pnbtnNhapDiem.add(pnMaHocSinh);

////		JPanel pnTenHocSinh = new JPanel();
////		lbTenHocSinh = new JLabel("Mã Môn ");
////		mamon = new JComboBox<>();
////		mamon.addItem("");
////		mamon.addItem("Toan123");
//		pnTenHocSinh.add(lbTenHocSinh);
//		pnTenHocSinh.add(mamon);
//		pnbtnNhapDiem.add(pnTenHocSinh);

		JPanel pnMiengLan1 = new JPanel();
		lbltelop = new JLabel("Mã Lớp ");
		malop = new JComboBox<>();
		malop.addItem("");
		malop.addItem("lp190");
		malop.addItem("lp111");
		pnMiengLan1.add(lbltelop);
		pnMiengLan1.add(malop);
		pnbtnNhapDiem.add(pnMiengLan1);

		JPanel pn15pLan1 = new JPanel();
		lb15pLan1 = new JLabel("Miệng: ");
		txtdmieng = new JTextField(10);
		pn15pLan1.add(lb15pLan1);
		pn15pLan1.add(txtdmieng);
		pnbtnNhapDiem.add(pn15pLan1);

		JPanel pn15pLan2 = new JPanel();
		lb15pLan2 = new JLabel("15p: ");
		txtd15p = new JTextField(10);
		pn15pLan2.add(lb15pLan2);
		pn15pLan2.add(txtd15p);
		pnbtnNhapDiem.add(pn15pLan2);

		JPanel pn45p = new JPanel();
		lb45p = new JLabel("45p: ");
		txt45p = new JTextField(10);
		pn45p.add(lb45p);
		pn45p.add(txt45p);
		pnbtnNhapDiem.add(pn45p);

		JPanel pnHocKi = new JPanel();
		JLabel lbHocKi = new JLabel("Điểm Thi: ");
		 txtthi = new JTextField(10);
		pnHocKi.add(lbHocKi);
		pnHocKi.add(txtthi);
		pnbtnNhapDiem.add(pnHocKi);

		JPanel pnGhiChu = new JPanel();
		lbGhiChu = new JLabel("Ghi chú: ");
		txtGhiChu = new JTextField(10);
		pnGhiChu.add(lbGhiChu);
		pnGhiChu.add(txtGhiChu);
		pnbtnNhapDiem.add(pnGhiChu);

		lbGhiChu.setPreferredSize(lb15pLan1.getPreferredSize());
		lb15pLan2.setPreferredSize(lbMaHocSinh.getPreferredSize());
//		lb45p.setPreferredSize(lbTenHocSinh.getPreferredSize());
		lbltelop.setPreferredSize(lbHocKi.getPreferredSize());
		pnMain.add(pnbtnNhapDiem);

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

		table = new DefaultTableModel();

		table.addColumn("Mã Học Sinh");
		table.addColumn("Mã Môn");
		table.addColumn("Mã Lớp");
		table.addColumn("Điểm Miệng");
		table.addColumn("Điểm 15p");
		table.addColumn("Điểm 45p ");
		table.addColumn("Điểm Thi");
		table.addColumn("Học Kì");
		table.addColumn("Ghi Chú");

		tab = new JTable(table);
		tab.addMouseListener(this);
		sc = new JScrollPane(tab, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnMain.add(sc);
		
		loadgram();
		return pnMain;
	}

	public void loadgram() {

		 table.setRowCount(0);
		 BangDiemDao bdDao = new BangDiemDao();
		
		 ArrayList<BangDiem> listbd = bdDao.getAllUser();
		 for (BangDiem bd : listbd) {
		 table.addRow(new String[] { "" + bd.getMahocsinh(),bd.getMamon(), bd.getMalop(),
		 bd.getDiem_mieng(), bd.getDiem_15p(), bd.getDiem_45p(),
		 bd.getDiem_thi(), bd.getMahocki(),bd.getGhichu() });
		 }

	}
	
	private void updateUser() {
		BangDiem hs = new BangDiem();
		hs.setMahocsinh(Integer.parseInt(txtMaHocSinh.getText()));
		
		hs.setMamon(cbChonMon.getSelectedItem().toString());
		hs.setMalop(cbChonLop.getSelectedItem().toString());
		hs.setMahocki(cbChonHocKi.getSelectedItem().toString());
		hs.setDiem_mieng(txtdmieng.getText());
		hs.setDiem_15p(txtd15p.getText());
		hs.setDiem_45p(txt45p.getText());
		hs.setDiem_thi(txtthi.getText());
		hs.setGhichu(txtGhiChu.getText());
		bddao = new BangDiemDao();
		bddao.updateUser(hs);
	}

	private void addUser() {
		BangDiem hs = new BangDiem();
		hs.setMahocsinh(Integer.parseInt(txtMaHocSinh.getText()));
		
		hs.setMamon(cbChonMon.getSelectedItem().toString());
		hs.setMalop(cbChonLop.getSelectedItem().toString());
		hs.setMahocki(cbChonHocKi.getSelectedItem().toString());
		hs.setDiem_mieng(txtdmieng.getText());
		hs.setDiem_15p(txtd15p.getText());
		hs.setDiem_45p(txt45p.getText());
		hs.setDiem_thi(txtthi.getText());
		hs.setGhichu(txtGhiChu.getText());
		
		bddao = new BangDiemDao();
		bddao.addUser(hs);

	}
	private void clear() {
		txtMaHocSinh.setText("");
		malop.setSelectedItem("");
		txt45p.setText("");
		txtd15p.setText("");
		txtdmieng.setText("");
		txtMaHocSinh.setText("");
		txtthi.setText("");
		cbChonHocKi.setSelectedItem("");
		txtGhiChu.setText("");

	}

	private void deleteUser() {
		bddao = new BangDiemDao();
		bddao.deleteUser(txtMaHocSinh.getText());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = tab.getSelectedRow();
		txtdmieng.setText((String) tab.getValueAt(rowSelected, 3));
		txtd15p.setText((String) tab.getValueAt(rowSelected, 4));
		txt45p.setText((String) tab.getValueAt(rowSelected, 5));
		txtGhiChu.setText((String) tab.getValueAt(rowSelected	, 8));
		txtMaHocSinh.setText((String) tab.getValueAt(rowSelected, 0));
		txtthi.setText((String) tab.getValueAt(rowSelected, 6));

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
		cbChonHocKi.showPopup();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		cbChonHocKi.hidePopup();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAdd) {
			if (txtdmieng.getText().equals("") || txt45p.getText().equals("") || txtd15p.getText().equals("")
					|| malop.getSelectedItem().toString().equals("") || txtMaHocSinh.getText().equals("")
					|| txtthi.getText().equals("") || mamon.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			loadgram();

		} else if (action == btnUpdate) {
			if (txtdmieng.getText().equals("") || txt45p.getText().equals("") || txtd15p.getText().equals("")
					|| malop.getSelectedItem().toString().equals("") || txtMaHocSinh.getText().equals("")
					|| txtthi.getText().equals("") || mamon.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");


			} else {
				updateUser();
			}

			loadgram();
		} else if (action == btnDelete) {
			deleteUser();
			loadgram();
		

		} else {
			clear();
		}

	}

	public static void main(String[] args) {
		FromBangDiem ql = new FromBangDiem();
		ql.chaybangdiem();
		ql.setVisible(true);
	}
}
