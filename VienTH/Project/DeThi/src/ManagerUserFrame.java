import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManagerUserFrame extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private JTable jTable;
	private JScrollPane jScrollPane;

	private JButton btnAddUser;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;
	private JButton btnClean;

	private JLabel lblMaSinhVien;
	private JLabel lblTenSinhVien;
	private JLabel lblLop;
	private JLabel lblNienKhoa;
	private JLabel lblDiemTrungBinh;

	private JLabel qlsv;
	private JPanel qlsv1;

	private JTextField txtMaSinhVien;
	private JTextField txtTenSinhVien;
	private JTextField txtLop;
	private JTextField txtNienKhoa;
	private JTextField txtDiemTrungBinh;
	private UserDao userDao;

	public ManagerUserFrame() {
		super("Quản lý sinh Viên");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		qlsv = new JLabel("QUẢN LÝ SINH VIÊN");
		qlsv1 = new JPanel();
		qlsv1.setLayout(new FlowLayout());
		qlsv1.add(qlsv);

		userDao = new UserDao();

		// table user
		tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã Sinh Viên");
		tableModel.addColumn("Tên Sinh Viên");
		tableModel.addColumn("Lớp");
		tableModel.addColumn("Niên Khóa");
		tableModel.addColumn("Điểm Trung Bình");
		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setMaximumSize(new Dimension(1000, 600));
		jTable.addMouseListener((MouseListener) this);

		btnAddUser = new JButton("Add");
		btnUpdateUser = new JButton("Update");
		btnDeleteUser = new JButton("Delete");
		btnClean = new JButton("Clean");
		JPanel paneActionButton = new JPanel();
		paneActionButton.add(btnAddUser);
		paneActionButton.add(btnUpdateUser);
		paneActionButton.add(btnDeleteUser);
		paneActionButton.add(btnClean);

		btnAddUser.addActionListener((ActionListener) this);
		btnUpdateUser.addActionListener((ActionListener) this);
		btnDeleteUser.addActionListener((ActionListener) this);
		btnClean.addActionListener((ActionListener) this);

		lblMaSinhVien = new JLabel("Mã Sinh Viên : ");
		lblTenSinhVien = new JLabel("Tên Sinh Viên : ");
		lblLop = new JLabel("Lớp : ");
		lblNienKhoa = new JLabel("Niên Khóa : ");
		lblDiemTrungBinh = new JLabel("Điểm Trung Bình : ");

		txtMaSinhVien = new JTextField(7);
		txtTenSinhVien = new JTextField(15);
		txtLop = new JTextField(8);
		txtNienKhoa = new JTextField(10);
		txtDiemTrungBinh = new JTextField(6);

		JPanel paneInputInfo = new JPanel();
		paneInputInfo.add(lblMaSinhVien);
		paneInputInfo.add(txtMaSinhVien);
		paneInputInfo.add(lblTenSinhVien);
		paneInputInfo.add(txtTenSinhVien);
		paneInputInfo.add(lblLop);
		paneInputInfo.add(txtLop);
		paneInputInfo.add(lblNienKhoa);
		paneInputInfo.add(txtNienKhoa);
		paneInputInfo.add(lblDiemTrungBinh);
		paneInputInfo.add(txtDiemTrungBinh);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(qlsv1);
		container.add(jScrollPane);
		container.add(paneActionButton);
		container.add(paneInputInfo);

		loadDataforTableUser();

	}

	private void loadDataforTableUser() {
		// xoa du lieu cu
		tableModel.setRowCount(0);

		// su dung ham UserDao#getAllUser() de lay tat ca thong tin user trong database
		ArrayList<User> listqlsv = UserDao.getAllUser();
		// duyet danh sach user lay tu database va them vao table
		for (User user : listqlsv) {
			tableModel.addRow(new String[] { "" + user.getMasinhvien(), user.getTensinhvien(), user.getLop(),
					user.getNienkhoa(), user.getDiemtrungbinh() });
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = jTable.getSelectedRow();

		txtMaSinhVien.setText((String) jTable.getValueAt(rowSelected, 0));
		txtTenSinhVien.setText((String) jTable.getValueAt(rowSelected, 1));
		txtLop.setText((String) jTable.getValueAt(rowSelected, 2));
		txtNienKhoa.setText((String) jTable.getValueAt(rowSelected, 3));
		txtDiemTrungBinh.setText((String) jTable.getValueAt(rowSelected, 4));

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
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAddUser) {
			if (txtMaSinhVien.getText().equals("") || String.valueOf(txtTenSinhVien.getText()).equals("")
					|| String.valueOf(txtLop.getText()).equals("") || String.valueOf(txtNienKhoa.getText()).equals("")
					|| String.valueOf(txtDiemTrungBinh.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			} else {
				addUser();
				loadDataforTableUser();
			}
			loadDataforTableUser();
		} else if (action == btnUpdateUser) {
			if (txtMaSinhVien.getText().equals("") || String.valueOf(txtTenSinhVien.getText()).equals("")
					|| String.valueOf(txtLop.getText()).equals("") || String.valueOf(txtNienKhoa.getText()).equals("")
					|| String.valueOf(txtDiemTrungBinh.getText()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			} else {
				updateUser();
				loadDataforTableUser();

			}
			loadDataforTableUser();
		} else if (action == btnDeleteUser) {
			deleteUser();
			loadDataforTableUser();
		} else {
			clearInputInfoUser();
		}

	}

	private void clearInputInfoUser() {
		txtMaSinhVien.setText("");
		txtTenSinhVien.setText("");
		txtLop.setText("");
		txtNienKhoa.setText("");
		txtDiemTrungBinh.setText("");
	}

	private void deleteUser() {
		String MaSinhVien = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);
		userDao.deleteUser(MaSinhVien);

	}

	private void updateUser() {
		User user = new User();
		user.setMasinhvien(txtMaSinhVien.getText());
		user.setTensinhvien(txtTenSinhVien.getText());
		user.setLop(txtLop.getText());
		user.setNienkhoa(txtNienKhoa.getText());
		user.setDiemtrungbinh(txtDiemTrungBinh.getText());

		userDao.updateUser(user);

	}

	private void addUser() {

		User user = new User();

		user.setMasinhvien(txtMaSinhVien.getText());
		user.setTensinhvien(txtTenSinhVien.getText());
		user.setLop(txtLop.getText());
		user.setNienkhoa(txtNienKhoa.getText());
		user.setDiemtrungbinh(txtDiemTrungBinh.getText());

		userDao.addUser(user);

	}

	public static void main(String[] args) {

		ManagerUserFrame qlsv = new ManagerUserFrame();
		qlsv.setVisible(true);
	}

}

