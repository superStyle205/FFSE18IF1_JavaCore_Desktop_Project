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

import model.bean.HocSinh;
import model.dao.StudentDao;

public class FromQuanLiSinhVienView extends JFrame implements ActionListener, MouseListener {
	// All
	private JScrollPane scroll;

	// Student Area (Khu vực học sinh)
	private StudentDao svdao;
	private int idSinhVien;
	private JButton btnAddHS;
	private JButton btnUpdateHS;
	private JButton btnDeleteHS;
	private JButton btnCleanHS;
	private JTable tableHS;
	private JButton btnSearchHS;
	private JTextField searchHS;
	private JLabel lblmahocsinh;
	private JTextField txtmahocsinh;
	private JLabel lblhotem;
	private JTextField txthoten;
	private JLabel lbldiachi;
	private JTextField txtdiachi;
	private JLabel lblemail;
	private JTextField txtemail;
	private JLabel lblmalop;
	private JTextField txtmalop;
	private JLabel lblnamsinh;
	private JTextField txtnamsinh;
	private JLabel lblnamhoc;
	private JTextField txtnamhoc;
	private JComboBox gioitinh;
	private JLabel lblgioitinh;
	// private JTextField txtgioitinh;
	private JLabel lblDeleteValueFood;
	private JTextField deleteValueFood;
	private JButton btnDeletePermanentlyHS;

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
	private DefaultTableModel model;

	public void display() {
		add(managerTab());
		loadgram();
		// Tiêu đề
		setTitle("Admin");
		// Hiển thị cửa số ra. Nếu false hiển thị mặc định 3 ổ cửa sổ X + -
		setVisible(true);
		// Chỉnh kích thước rộng dài của cửa sổ
		setSize(1200, 700);
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

		
		JSplitPane managerstudent = quanlihocsinh();
	
		
		myTabled.addTab("Quản Lí Học Sinh", imageIconQLHS, managerstudent);
	
		return myTabled;
	}

	public JPanel quanlihocsinhLeft() {
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

		model = new DefaultTableModel();
		model.addColumn("Mã Học Sinh");
		model.addColumn("Họ Tên");

		model.addColumn("Email");
		model.addColumn("Địa Chỉ");
		model.addColumn("Mã Lớp");
		model.addColumn("Năm Sinh");
		model.addColumn("Năm Học");
		model.addColumn("Giới Tính");

		tableHS = new JTable(model);
		tableHS.addMouseListener(this);
		tableHS.setPreferredSize(new Dimension(500, 2000));
		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableHS);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddHS);
		managerButton.add(btnUpdateHS);
		managerButton.add(btnDeleteHS);
		managerButton.add(btnCleanHS);
		managerTable.add(scroll, tableHS);

		panel.add(managerButton);
		panel.add(managerTable);
		loadgram();
		return panel;
	}

	public void loadgram() {
		model.setRowCount(0);
		StudentDao studentDao = new StudentDao();

		ArrayList<HocSinh> listHS = studentDao.getAllUser();
		for (HocSinh hs : listHS) {
			model.addRow(new String[] { "" + hs.getMahocsinh(), hs.getHoten(), hs.getEmail(), hs.getDiachi(),
					hs.getMalop(), hs.getNamsinh(), hs.getNamhoc(), hs.getGioitinh() });
		}

	}

	public JPanel quanlihocsinhRight() {
		JPanel panel = new JPanel();
		JPanel magagerSearch = new JPanel();
		JPanel manager = new JPanel(new GridLayout(16, 1, 5, 5));
		JPanel managerButton = new JPanel();

		// Giao diện phía trên
		searchHS = new JTextField(20);
		btnSearchHS = new JButton("Tìm", imageIconSearch);
		btnSearchHS.addActionListener(this);
		getRootPane().setDefaultButton(btnSearchHS);
		btnSearchHS.setPreferredSize(new Dimension(110, 50));

		// Giao diện phía trái và giữa
		lblmahocsinh = new JLabel("Mã Học Sinh");
		txtmahocsinh = new JTextField(30);
		txtmahocsinh.setEnabled(false);

		lblhotem = new JLabel("Họ Tên");
		lblhotem.setForeground(Color.blue);
		txthoten = new JTextField(30);
		lblgioitinh = new JLabel("Giới Tính");
		gioitinh = new JComboBox();
		gioitinh.addItem("");
		gioitinh.addItem("Nam");
		gioitinh.addItem("Nữ");
		lblemail = new JLabel("Địa Chỉ");
		txtemail = new JTextField(30);
		lbldiachi = new JLabel("Email");
		txtdiachi = new JTextField(30);
		lblmalop = new JLabel("Mã Lớp");
		txtmalop = new JTextField(30);
		lblnamsinh = new JLabel("Năm Sinh");
		txtnamsinh = new JTextField(30);
		lblnamhoc = new JLabel("Năm Học");
		txtnamhoc = new JTextField(30);

		magagerSearch.add(searchHS);
		magagerSearch.add(btnSearchHS);
		manager.add(lblmahocsinh);
		manager.add(txtmahocsinh);
		manager.add(lblhotem);
		manager.add(txthoten);
		manager.add(lblgioitinh);
		manager.add(gioitinh);
		manager.add(lblemail);
		manager.add(txtemail);
		manager.add(lbldiachi);
		manager.add(txtdiachi);
		manager.add(lblmalop);
		manager.add(txtmalop);
		manager.add(lblnamsinh);
		manager.add(txtnamsinh);
		manager.add(lblnamhoc);
		manager.add(txtnamhoc);

		// manager.setBackground(Color.GREEN);
		// manager.add(lblDeleteValueFood);
		// manager.add(deleteValueFood);
		// managerButton.add(btnDeletePermanentlyHS);

		panel.add(magagerSearch);
		panel.add(manager);
		panel.add(managerButton);

		panel.setBackground(Color.cyan);

		return panel;
	}

	public JSplitPane quanlihocsinh() {
		JSplitPane managerArea = new JSplitPane();

		managerArea.setLeftComponent(quanlihocsinhLeft());
		managerArea.setRightComponent(quanlihocsinhRight());
		managerArea.setDividerLocation(780);

		return managerArea;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = tableHS.getSelectedRow();
		txtmahocsinh.setText((String) tableHS.getValueAt(rowSelected, 0));
		txthoten.setText((String) tableHS.getValueAt(rowSelected, 1));
		txtemail.setText((String) tableHS.getValueAt(rowSelected, 2));
		txtdiachi.setText((String) tableHS.getValueAt(rowSelected, 3));
		txtmalop.setText((String) tableHS.getValueAt(rowSelected, 4));
		txtnamsinh.setText((String) tableHS.getValueAt(rowSelected, 5));
		txtnamhoc.setText((String) tableHS.getValueAt(rowSelected, 6));

	}

	private void clear() {
		txtmahocsinh.setText("");
		txthoten.setText("");
		txtdiachi.setText("");
		txtemail.setText("");
		txtnamsinh.setText("");
		txtnamhoc.setText("");
		txtmalop.setText("");

	}

	private void deleteUser() {
		svdao = new StudentDao();
		svdao.deleteUser(txtmahocsinh.getText());
		
	}

	private void updateUser() {
		HocSinh hs = new HocSinh();
		hs.setMahocsinh(Integer.parseInt(txtmahocsinh.getText()));
		hs.setHoten(txthoten.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setMalop(txtmalop.getText());
		hs.setEmail(txtemail.getText());
		hs.setNamsinh(txtnamsinh.getText());
		hs.setNamhoc(txtnamhoc.getText());
		hs.setGioitinh(gioitinh.getSelectedItem().toString());
		svdao = new StudentDao();
		svdao.updateUser(hs);
	}

	private void addUser() {
		HocSinh hs = new HocSinh();
		// hs.setMahocsinh(Integer.parseInt(txtmahocsinh.getText()));
		hs.setHoten(txthoten.getText());
		hs.setDiachi(txtdiachi.getText());
		hs.setMalop(txtmalop.getText());
		hs.setEmail(txtemail.getText());
		hs.setNamsinh(txtnamsinh.getText());
		hs.setNamhoc(txtnamhoc.getText());
		hs.setGioitinh(gioitinh.getSelectedItem().toString());
		svdao = new StudentDao();
		svdao.addUser(hs);

	}

	private void searchInfor() {
		model.setRowCount(0);
		String mahocsinh = searchHS.getText();

		svdao = new StudentDao();
		HocSinh studentinfor = new HocSinh();
		studentinfor = svdao.searchInfor(mahocsinh);

		model.addRow(new String[] { "" + studentinfor.getMahocsinh(), studentinfor.getHoten(),
				studentinfor.getGioitinh(), studentinfor.getDiachi(), studentinfor.getEmail(), studentinfor.getMalop(),
				studentinfor.getNamsinh(), studentinfor.getNamhoc() });
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
		if (action == btnAddHS) {
			if (txthoten.getText().equals("") || txtemail.getText().equals("") || txtdiachi.getText().equals("")
					|| txtmalop.getText().equals("") || txtnamsinh.getText().equals("")
					|| txtnamhoc.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			loadgram();

		} else if (action == btnUpdateHS) {
			if (txtmahocsinh.getText().equals("") || String.valueOf(txthoten.getText()).equals("")
					|| String.valueOf(txtemail.getText()).equals("") || String.valueOf(txtdiachi.getText()).equals("")
					|| String.valueOf(txtmalop.getText()).equals("") || String.valueOf(txtnamsinh.getText()).equals("")
					|| String.valueOf(txtnamhoc.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				updateUser();
			}

			loadgram();
		} else if (action == btnDeleteHS) {
			deleteUser();
			loadgram();
		} else if (action == btnSearchHS) {
			searchInfor();
			
		} else {
			clear();
		}

	}

	public static void main(String[] args) {
		FromQuanLiSinhVienView gv = new FromQuanLiSinhVienView();
		gv.display();
	}
}
