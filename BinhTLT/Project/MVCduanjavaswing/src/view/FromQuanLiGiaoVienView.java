package view;

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

import model.bean.GiaoVien;
import model.bean.HocSinh;
import model.dao.StudentDao;
import model.dao.TeaCherDao;

public class FromQuanLiGiaoVienView extends JFrame implements ActionListener, MouseListener {
	// Teacher Area (Khu vực giáo viên )

	private TeaCherDao gvDao;
	private JScrollPane scroll;
	private JButton btnSearchGV;
	private JTextField searchGV;
	private JButton btnAddGV;
	private JButton btnUpdateGV;
	private JButton btnDeleteGV;
	private JButton btnCleanGV;
	private JTable tableGV;
	private JLabel lblmagiaovien;
	private JTextField txtgv;
	private JLabel lblhoten;
	private JTextField txthotenn;
	private JLabel lblgioitinhgv;
	private JComboBox gioitinhgv;
	private JLabel lblmalopgv;
	private JComboBox lop;
	private JLabel lblnamsinhgv;
	private JTextField txtnamsinhgv;
	
	private JLabel lblmamon;
	private JComboBox mamon;

	private JLabel lblDeleteValueFoodCategory;
	private JTextField deleteValueFoodCategory;
	private DefaultTableModel modelgv;
	private JScrollPane jScrollPane;
	// private JButton btnDeletePermanentlyFoodCategory;

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

	public void hienthi() {
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
		JSplitPane managerteacher = quanligiaovien();
		myTabled.addTab("Quản Lí Giáo Viên", imageIconQLGV, managerteacher);
		
		return myTabled;
	}

	public JPanel quanligiaovienLeft() {
		JPanel panel = new JPanel();
		JPanel managerButton = new JPanel();
		JPanel managerTable = new JPanel(new GridLayout(1, 1, 5, 5));

		// quản lí panel trên trái
		btnAddGV = new JButton("Thêm", imageIconAdd);
		btnAddGV.addActionListener(this);
		btnAddGV.setPreferredSize(new Dimension(110, 50));

		btnUpdateGV = new JButton("Sửa", imageIconUpdate);
		btnUpdateGV.addActionListener(this);
		btnUpdateGV.setPreferredSize(new Dimension(110, 50));

		btnDeleteGV = new JButton("Xóa", imageIconDelete);
		btnDeleteGV.addActionListener(this);
		btnDeleteGV.setPreferredSize(new Dimension(110, 50));

		btnCleanGV = new JButton("Clean", imageIconClean);
		btnCleanGV.addActionListener(this);
		btnCleanGV.setPreferredSize(new Dimension(110, 50));

		modelgv = new DefaultTableModel();
		modelgv.addColumn("Mã Giáo Viên");
		modelgv.addColumn("Họ Tên");
		modelgv.addColumn("Giới Tính");
		modelgv.addColumn("Mã Lớp");
		modelgv.addColumn("Năm Sinh");
		modelgv.addColumn("Mã Môn");

		tableGV = new JTable(modelgv);
		tableGV.addMouseListener(this);
		tableGV.setPreferredSize(new Dimension(450, 2000));
		// Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có
		// thanh cuộn ngang và doc để xem dữ liệu)
		scroll = new JScrollPane(tableGV);
		scroll.setPreferredSize(new Dimension(720, 540));

		managerButton.add(btnAddGV);
		managerButton.add(btnUpdateGV);
		managerButton.add(btnDeleteGV);
		managerButton.add(btnCleanGV);
		managerTable.add(scroll, tableGV);

		panel.add(managerButton);
		panel.add(managerTable);
		
		 loadgram();
		return panel;
	}

	public void loadgram() {
		modelgv.setRowCount(0);
		TeaCherDao giaovienDao = new TeaCherDao();

		ArrayList<GiaoVien> listGV = giaovienDao.getAllUser();
		for (GiaoVien gv : listGV) {
			modelgv.addRow(new String[] { "" + gv.getMagiaovien(), gv.getHoten(), gv.getGioitinh(), gv.getMalop(),
					gv.getNamsinh(),gv.getMamon() });
		}

	}

	public JPanel quanligiaovienRight() {
		JPanel panel = new JPanel();

		JPanel manager = new JPanel(new GridLayout(13, 1, 5, 5));
		JPanel managerButton = new JPanel();

		searchGV = new JTextField(20);
		btnSearchGV = new JButton("Tìm", imageIconSearch);
		btnSearchGV.addActionListener(this);
		btnSearchGV.setPreferredSize(new Dimension(100, 50));

		lblmagiaovien = new JLabel("Mã Giáo Viên");
		txtgv = new JTextField(30);
		txtgv.setEnabled(false);
		lblhoten = new JLabel("Họ Tên");
		txthotenn = new JTextField(30);
		lblgioitinhgv = new JLabel("Giới Tính");
		gioitinhgv = new JComboBox<>();
		gioitinhgv.addItem("");
		gioitinhgv.addItem("Nam");
		gioitinhgv.addItem("Nữ");

		lblmalopgv = new JLabel("Mã Lớp");
		lop = new JComboBox<>();
		lop.addItem("");
		lop.addItem("lp123");
		lop.addItem("lp111");
		lop.addItem("lp190");
		lblnamsinhgv = new JLabel("Năm Sinh");
		txtnamsinhgv = new JTextField(30);
		lblmamon = new JLabel("Mã Môn");
		mamon =  new JComboBox<>();
		mamon.addItem("");
		mamon.addItem("Toán10");
		mamon.addItem("Anh11");
		mamon.addItem("Anh10");
		mamon.addItem("Hóa11");
		mamon.addItem("Hóa12");
		mamon.addItem("Toán11");
		mamon.addItem("Lí11");
		mamon.addItem("Văn10");
		mamon.addItem("Sinh10");
		mamon.addItem("Sinh11");
		mamon.addItem("Sinh12");
		
		jScrollPane = new JScrollPane();
		jScrollPane.add(mamon);
		lblmamon.setPreferredSize(new Dimension(150, 25));
		
		

		managerButton.add(searchGV);
		managerButton.add(btnSearchGV);

		manager.add(lblmagiaovien);
		manager.add(txtgv);
		manager.add(lblhoten);
		manager.add(txthotenn);
		manager.add(lblgioitinhgv);
		manager.add(gioitinhgv);
		manager.add(lblmalopgv);
		manager.add(lop);
		manager.add(lblnamsinhgv);
		manager.add(txtnamsinhgv);
		manager.add(lblmamon);
		manager.add(mamon);

		panel.add(manager);
		panel.add(managerButton);

		return panel;
	}

	public JSplitPane quanligiaovien() {
		JSplitPane managerArea = new JSplitPane();

		managerArea.setLeftComponent(quanligiaovienLeft());
		managerArea.setRightComponent(quanligiaovienRight());

		managerArea.setDividerLocation(780);

		return managerArea;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = tableGV.getSelectedRow();
		txtgv.setText((String) tableGV.getValueAt(rowSelected, 0));
		txthotenn.setText((String) tableGV.getValueAt(rowSelected,1));
		txtnamsinhgv.setText((String) tableGV.getValueAt(rowSelected, 4));
		
		

	}

	private void clear() {
		
		txtgv.setText("");
		txtnamsinhgv.setText("");
		txthotenn.setText("");
		mamon.setSelectedItem("");
		gioitinhgv.setSelectedItem("");
		

	}

	private void deleteUser() {
		gvDao = new TeaCherDao();
		gvDao.deleteUser(txtgv.getText());
		
	}

	private void updateUser() {
		GiaoVien gv = new GiaoVien();
//		gv.setMagiaovien(Integer.parseInt(txtgv.getText()));
		gv.setHoten(txthotenn.getText());
		gv.setGioitinh(gioitinhgv.getSelectedItem().toString());
		gv.setMalop(lop.getSelectedItem().toString());
		gv.setNamsinh(txtnamsinhgv.getText());
		gv.setMamon(mamon.getSelectedItem().toString());
		
		gvDao = new TeaCherDao();
		gvDao.updateUser(gv);
	}

		private void search(){
			tableGV.setRowHeight(0);
			GiaoVien gv = new GiaoVien();
			String magiaovien = searchGV.getText();
			gvDao = new TeaCherDao();
			gvDao.search(magiaovien);
		}
	private void addUser() {
		GiaoVien gv = new GiaoVien();

//		gv.setMagiaovien(Integer.parseInt(txtgv.getText()));
		gv.setHoten(txthotenn.getText());
		gv.setGioitinh(gioitinhgv.getSelectedItem().toString());
		gv.setMalop(lop.getSelectedItem().toString());
		gv.setNamsinh(txtnamsinhgv.getText());
		gv.setMamon(mamon.getSelectedItem().toString());
		
		gvDao = new TeaCherDao();
		gvDao.addUser(gv);
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
		if (action == btnAddGV) {
			if (txthotenn.getText().equals("") || txtnamsinhgv.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				addUser();
			}

			loadgram();

		} else if (action == btnUpdateGV) {
			if (txtgv.getText().equals("") || String.valueOf(txthotenn.getText()).equals("")
					|| String.valueOf(txtnamsinhgv.getText()).equals("")

			) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");

			} else {
				updateUser();
			}

			loadgram();
		} else if (action == btnDeleteGV) {
			deleteUser();
			loadgram();
		} else  if (action == btnSearchGV){
			search();
			loadgram();
		}else{
			clear();
		}

	}

	public static void main(String[] args) {
		FromQuanLiGiaoVienView gv = new FromQuanLiGiaoVienView();
		gv.hienthi();
	}
}
