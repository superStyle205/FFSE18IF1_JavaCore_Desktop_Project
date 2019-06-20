package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.bean.HoSoHocSinh;
import model.bean.HocSinh;
import model.dao.HoSoHocSinhDao;
import model.dao.StudentDao;

public class FormHoSoHocSinhView extends JFrame implements ActionListener, MouseListener {
	private JTextField searchHS;
	private JScrollPane scroll;
	private JLabel lblmhs;
	private JTextField txtmhs;
	private JLabel lblhoten;
	private JTextField txthoten;
	private JLabel lbldiachi;
	private JTextField txtdiachi;
	private JLabel lbldantoc;
	private JTextField txtdantoc;
	private JLabel lblnamsinh;
	private JTextField txtnamsinh;
	private JLabel lblemail;
	private JTextField txtemail;
	private JLabel lblhotencha;
	private JTextField txthotencha;
	private JLabel lblhotenme;
	private JTextField txthotenme;
	private JLabel lblghichu;
	private JTextField txtghichu;

	private JLabel lblmalop;
	private JLabel lblgt;
	private JComboBox malop;
	private JComboBox gioitinh;

	private int idSinhVien;
	private JButton btnSearchHs;
	private JButton btnAddHS;
	private JButton btnUpdateHS;
	private JButton btnDeleteHS;
	private JButton btnCleanHS;
	private JTable tableHS;

	private HoSoHocSinhDao hosodao;
	private DefaultTableModel tablemodel;

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

	public void chayhoso() {
		add(managerTab());
		// loadgram();
		// Tiêu đề
		setTitle("Admin");
		// Hiển thị cửa số ra. Nếu false hiển thị mặc định 3 ổ cửa sổ X + -
		setVisible(true);
		// Chỉnh kích thước rộng dài của cửa sổ
		setSize(1250, 800);
		// Hiển thị cửa sổ ở giữa màn hình. Nếu không null nó sẽ xuất hiện ở góc
		// màn hình.
		setLocationRelativeTo(null);
		// Khi click vào X đỏ thì sẽ tắt cửa sổ. Nếu không có hàm này thì sẽ
		// không tắt được.
		setDefaultCloseOperation(0);
		// Tắt chức năng phóng to màn hình của form.
		setResizable(false);
		// Sự kiện khi bấm nút đỏ thoát form thì chỉ thoát form hiện tại.
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();

		JSplitPane hshs = hosohocsinh();

		myTabled.addTab("Hồ Sơ Học Sinh", imageIconHSHS, hshs);

		return myTabled;
	}

	public JPanel hosohocsinhRight() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddHS = new JButton("Thêm", imageIconAdd);
		btnAddHS.setForeground(Color.BLUE);
		btnAddHS.addActionListener(this);
		btnAddHS.setPreferredSize(new Dimension(110, 50));

		btnUpdateHS = new JButton("Sửa", imageIconUpdate);
		btnUpdateHS.setForeground(Color.BLUE);
		btnUpdateHS.addActionListener(this);
		btnUpdateHS.setPreferredSize(new Dimension(110, 50));

		btnDeleteHS = new JButton("Xóa", imageIconDelete);
		btnDeleteHS.setForeground(Color.BLUE);
		btnDeleteHS.addActionListener(this);
		btnDeleteHS.setPreferredSize(new Dimension(110, 50));

		btnCleanHS = new JButton("Clean", imageIconClean);
		btnCleanHS.setForeground(Color.BLUE);
		btnCleanHS.addActionListener(this);
		btnCleanHS.setPreferredSize(new Dimension(110, 50));

		tablemodel = new DefaultTableModel();
		tablemodel.addColumn("Mã Lớp ");
		tablemodel.addColumn("Mã Học Sinh");
		tablemodel.addColumn("Họ Tên");
		tablemodel.addColumn("Địa Chỉ");
		;
		tablemodel.addColumn("DanToc");
		tablemodel.addColumn("Năm Sinh");
		tablemodel.addColumn("Giới Tính");
		tablemodel.addColumn("Email");
		tablemodel.addColumn("Họ Tên Cha");
		tablemodel.addColumn("Họ Tên Mẹ");
		tablemodel.addColumn("Ghi chú");
		tableHS = new JTable(tablemodel);
		tableHS.addMouseListener(this);
		tableHS.setPreferredSize(new Dimension(500, 2000));
		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableHS);
		scroll.setPreferredSize(new Dimension(790, 600));

		managerButton.add(btnAddHS);
		managerButton.add(btnUpdateHS);
		managerButton.add(btnDeleteHS);
		managerButton.add(btnCleanHS);
		managerTable.add(scroll, tableHS);

		panel.add(managerButton);
		panel.add(managerTable);

		return panel;
	}

	public JPanel hosohocsinhLeft() {
		JPanel panel = new JPanel();
		JPanel magagerSearch = new JPanel();
		JPanel manager = new JPanel(new GridLayout(34, 1, 1, 1));
		JPanel managerButton = new JPanel();

		// Giao diện phía trên
		searchHS = new JTextField(20);
		btnSearchHs = new JButton("Tìm", imageIconSearch);
		btnSearchHs.addActionListener(this);
		getRootPane().setDefaultButton(btnSearchHs);
		btnSearchHs.setPreferredSize(new Dimension(110, 50));

		// Giao diện phía trái và giữa
		lblmalop = new JLabel("Mã Lớp");
		lblmalop.setForeground(Color.BLUE);
		malop = new JComboBox<>();
		malop.addItem("");
		malop.addItem("lp111");
		malop.addItem("lp190");
		malop.addItem("lp123");

		lblmhs = new JLabel("Mã Học Sinh");
		lblmhs.setForeground(Color.BLUE);
		txtmhs = new JTextField();
		txtmhs.setEnabled(false);

		lblhoten = new JLabel("Họ Tên");
		lblhoten.setForeground(Color.blue);
		txthoten = new JTextField();

		lbldiachi = new JLabel("Địa Chỉ");
		lbldiachi.setForeground(Color.blue);
		txtdiachi = new JTextField();

		lbldantoc = new JLabel("Dân Tộc");
		lbldantoc.setForeground(Color.blue);
		txtdantoc = new JTextField(30);

		lblnamsinh = new JLabel("Năm Sinh");
		lblnamsinh.setForeground(Color.BLUE);
		txtnamsinh = new JTextField(30);

		lblgt = new JLabel("Giới Tính");
		lblgt.setForeground(Color.BLUE);
		gioitinh = new JComboBox<>();
		gioitinh.addItem("");
		gioitinh.addItem("Nam");
		gioitinh.addItem("Nữ");

		lblemail = new JLabel("Email");
		lblemail.setForeground(Color.BLUE);
		txtemail = new JTextField(30);

		lblhotencha = new JLabel("Họ Tên Cha");
		lblhotencha.setForeground(Color.blue);
		txthotencha = new JTextField(30);

		lblhotenme = new JLabel("Họ Tên Mẹ");
		lblhotenme.setForeground(Color.BLUE);
		txthotenme = new JTextField(30);

		lblghichu = new JLabel("Ghi Chú");
		lblghichu.setForeground(Color.blue);
		txtghichu = new JTextField(30);

		magagerSearch.add(searchHS);
		magagerSearch.add(btnSearchHs);
		manager.add(lblmalop);
		manager.add(malop);
		manager.add(lblmhs);
		manager.add(txtmhs);
		manager.add(lblhoten);
		manager.add(txthoten);
		manager.add(lbldiachi);
		manager.add(txtdiachi);
		manager.add(lbldantoc);
		manager.add(txtdantoc);
		manager.add(lblnamsinh);
		manager.add(txtnamsinh);

		manager.add(lblgt);
		manager.add(gioitinh);
		manager.add(lblemail);
		manager.add(txtemail);
		manager.add(lblhotencha);
		manager.add(txthotencha);
		manager.add(lblhotenme);
		manager.add(txthotenme);
		manager.add(lblghichu);
		manager.add(txtghichu);
		scroll = new JScrollPane();
		scroll.add(manager);

		panel.add(magagerSearch);
		panel.add(manager);
		panel.add(managerButton);

		panel.setBackground(Color.WHITE);

		return panel;

	}

	public JSplitPane hosohocsinh() {
		JSplitPane managerArea = new JSplitPane();

		managerArea.setLeftComponent(hosohocsinhLeft());
		managerArea.setRightComponent(hosohocsinhRight());
		managerArea.setDividerLocation(400);

		return managerArea;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = tableHS.getSelectedRow();
		txtmhs.setText((String) tableHS.getValueAt(rowSelected, 0));
		txthoten.setText((String) tableHS.getValueAt(rowSelected, 1));
		txtdiachi.setText((String) tableHS.getValueAt(rowSelected, 2));
		txtdantoc.setText((String) tableHS.getValueAt(rowSelected, 3));
		txtnamsinh.setText((String) tableHS.getValueAt(rowSelected, 4));
		txtemail.setText((String) tableHS.getValueAt(rowSelected, 5));
		txthotencha.setText((String) tableHS.getValueAt(rowSelected, 6));
		txthotenme.setText((String) tableHS.getValueAt(rowSelected, 7));
		txtghichu.setText((String) tableHS.getValueAt(rowSelected, 8));

	}

	private void clear() {
		malop.setSelectedItem("");
		txtmhs.setText("");
		txthoten.setText("");
		txtdiachi.setText("");
		txtdantoc.setText("");
		txtnamsinh.setText("");
		gioitinh.setSelectedItem("");
		txtemail.setText("");
		txthotencha.setText("");
		txthotenme.setText("");
		txtghichu.setText("");

	}

	private void deleteUser() {
		hosodao = new HoSoHocSinhDao();
		hosodao.deleteUser(malop.getSelectedItem().toString());

	}

	private void updateUser() {
		HoSoHocSinh hs = new HoSoHocSinh();
		hs.setMalop(malop.getSelectedItem().toString());
		hs.setMahocsinh(Integer.parseInt(txtmhs.getText()));
		hs.setHoten(txthoten.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setDantoc(txtdantoc.getText());
		hs.setNamsinh(txtnamsinh.getText());
		hs.setGioitinh(gioitinh.getSelectedItem().toString());
		hs.setEmail(txtemail.getText());
		hs.setHotencha(txthoten.getText());
		hs.setHotenme(txthotenme.getText());
		hs.setGhichu(txtghichu.getText());
		hosodao = new HoSoHocSinhDao();
		hosodao.updateUser(hs);
	}

	private void addUser() {
		HoSoHocSinh hs = new HoSoHocSinh();
		hs.setMalop(malop.getSelectedItem().toString());
		hs.setMahocsinh(Integer.parseInt(txtmhs.getText()));
		hs.setHoten(txthoten.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setDantoc(txtdantoc.getText());
		hs.setNamsinh(txtnamsinh.getText());
		hs.setGioitinh(gioitinh.getSelectedItem().toString());
		hs.setEmail(txtemail.getText());
		hs.setHotencha(txthoten.getText());
		hs.setHotenme(txthotenme.getText());
		hs.setGhichu(txtghichu.getText());
		hosodao = new HoSoHocSinhDao();
		hosodao.updateUser(hs);

	}

	private void searchInfor() {
		tablemodel.setRowCount(0);
		String malop = searchHS.getText();

		hosodao = new HoSoHocSinhDao();
		HoSoHocSinh studentinfor = new HoSoHocSinh();
		studentinfor = hosodao.searchInfor(malop);

		tablemodel.addRow(new String[] { "" + studentinfor.getMahocsinh(), studentinfor.getMalop(),
				studentinfor.getHoten(), studentinfor.getGioitinh(), studentinfor.getDiachi(), studentinfor.getEmail(),
				studentinfor.getMalop(), studentinfor.getNamsinh(), studentinfor.getHotencha(),
				studentinfor.getHotenme(), studentinfor.getGhichu() });
	}
	
	
	public void loadgram() {
//		model.setRowCount(0);
//		StudentDao studentDao = new StudentDao();
//
//		ArrayList<HocSinh> listHS = studentDao.getAllUser();
//		for (HocSinh hs : listHS) {
//			model.addRow(new String[] { "" + hs.getMahocsinh(), hs.getHoten(), hs.getEmail(), hs.getDiachi(),
//					hs.getMalop(), hs.getNamsinh(), hs.getNamhoc(), hs.getGioitinh() });
//		}

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
		if (action == btnAddHS) {
			if (malop.getSelectedItem().toString().equals("") || txtemail.getText().equals("")
					|| txtdiachi.getText().equals("") || txtmhs.getText().equals("") || txtnamsinh.getText().equals("")
					|| txthoten.getText().equals("") || txthotencha.getText().equals("")
					|| gioitinh.getSelectedItem().toString().equals("") || txthotenme.getText().equals("")
					|| txtghichu.getText().equals("") || txtdantoc.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			loadgram();

		} else if (action == btnUpdateHS) {
			if (malop.getSelectedItem().toString().equals("") || txtemail.getText().equals("")
					|| txtdiachi.getText().equals("") || txtmhs.getText().equals("") || txtnamsinh.getText().equals("")
					|| txthoten.getText().equals("") || txthotencha.getText().equals("")
					|| gioitinh.getSelectedItem().toString().equals("") || txthotenme.getText().equals("")
					|| txtghichu.getText().equals("") || txtdantoc.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				updateUser();
			}

			loadgram();
		} else if (action == btnDeleteHS) {
			deleteUser();
			loadgram();
		} else if (action == btnSearchHs) {
			searchInfor();

		} else {
			clear();
		}

	}

	public static void main(String[] args) {
		FormHoSoHocSinhView hshs = new FormHoSoHocSinhView();
		hshs.chayhoso();
	}
}
