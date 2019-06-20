package ViewFr;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.SinhVien;
import DAO.SinhVienDao;

public class FrSinhVien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	private JTable jtable;
	private JScrollPane jScrollPane;

	private JButton jbAddSv;
	private JButton jbUpdateSv;
	private JButton jbDeleteSv;
	private JButton jbClear;

	private JLabel lbID;
	private JLabel lbTen;
	private JLabel lbLop;
	private JLabel lbNienKhoa;
	private JLabel lbDiem;

	private JTextField txtId;
	private JTextField txtTen;
	private JTextField txtLop;
	private JTextField txtNienKhoa;
	private JTextField txtDiem;

	public static void main(String[] args) {

		FrSinhVien frSinhVien = new FrSinhVien();
		frSinhVien.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public FrSinhVien() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Tên sinh viên");
		tableModel.addColumn("Lớp");
		tableModel.addColumn("Niên khóa");
		tableModel.addColumn("Điểm");

		jtable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jtable);

		// sự kiện cho hàng table

		jtable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int rowSelected = jtable.getSelectedRow();

				txtId.setText((String) jtable.getValueAt(rowSelected, 0));
				txtTen.setText((String) jtable.getValueAt(rowSelected, 1));
				txtLop.setText((String) jtable.getValueAt(rowSelected, 2));
				txtNienKhoa.setText((String) jtable.getValueAt(rowSelected, 3));
				txtDiem.setText((String) jtable.getValueAt(rowSelected, 4));

			}
		});

		// thêm button

		jbAddSv = new JButton("Add");
		jbUpdateSv = new JButton("Update");
		jbDeleteSv = new JButton("Delete");
		jbClear = new JButton("Clear");

		jbAddSv.addActionListener(this);
		jbUpdateSv.addActionListener(this);
		jbDeleteSv.addActionListener(this);
		jbClear.addActionListener(this);

		JPanel jpaneActionButton = new JPanel();

		jpaneActionButton.add(jbAddSv);
		jpaneActionButton.add(jbUpdateSv);
		jpaneActionButton.add(jbDeleteSv);
		jpaneActionButton.add(jbClear);

		// thêm lable

		lbID = new JLabel("Mã Sinh Viên ");
		lbTen = new JLabel("Tên ");
		lbLop = new JLabel("Lớp ");
		lbNienKhoa = new JLabel("Niên khóa ");
		lbDiem = new JLabel("Điểm ");

		//

		// thêm textfiled

		txtId = new JTextField(10);
		txtTen = new JTextField(20);
		txtLop = new JTextField(10);
		txtNienKhoa = new JTextField(10);
		txtDiem = new JTextField(10);

		JPanel paneInputInfo = new JPanel();

		paneInputInfo.add(lbID);
		paneInputInfo.add(txtId);

		paneInputInfo.add(lbTen);
		paneInputInfo.add(txtTen);

		paneInputInfo.add(lbLop);
		paneInputInfo.add(txtLop);

		paneInputInfo.add(lbNienKhoa);
		paneInputInfo.add(txtNienKhoa);

		paneInputInfo.add(lbDiem);
		paneInputInfo.add(txtDiem);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(jScrollPane);
		container.add(jpaneActionButton);
		container.add(paneInputInfo);

		loadDataForTable();

	}

	private void loadDataForTable() {

		// xóa dữ liêu cũ trùng lặp
		tableModel.setRowCount(0);

		SinhVienDao sinhvienDao = new SinhVienDao();
		ArrayList<SinhVien> listUser = sinhvienDao.getALLSinhVien();

		for (SinhVien sinhvien : listUser) {
			tableModel.addRow(new String[] { "" + sinhvien.getId(), sinhvien.getTen(), sinhvien.getLop(),
					sinhvien.getNienkhoa(), sinhvien.getDiem() });
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == jbAddSv) {
			addSv();
			loadDataForTable();
			clearInputInfo();
		} else if (action == jbUpdateSv) {
			updateWindow();
			loadDataForTable();

		} else if (action == jbDeleteSv) {
			deleteUser();
			loadDataForTable();
			clearInputInfo();
		} else {
			clearInputInfo();
		}

	}

	SinhVienDao sinhvienDao = new SinhVienDao();

	private void addSv() {

		SinhVien sinhvien = new SinhVien();

		sinhvien.setId(txtId.getText());
		sinhvien.setTen(txtTen.getText());
		sinhvien.setLop(txtLop.getText());
		sinhvien.setNienkhoa(txtNienKhoa.getText());
		sinhvien.setDiem(txtDiem.getText());

		sinhvienDao.addSv(sinhvien);

	}

	private void updateWindow() {

		SinhVien sinhvien = new SinhVien();

		sinhvien.setId(txtId.getText());
		sinhvien.setTen(txtTen.getText());
		sinhvien.setLop(txtLop.getText());
		sinhvien.setNienkhoa(txtNienKhoa.getText());
		sinhvien.setDiem(txtDiem.getText());

		sinhvienDao.updateSv(sinhvien);

	}

	private void deleteUser() {

		String id = (String) jtable.getValueAt(jtable.getSelectedRow(), 0);
		sinhvienDao.deleteSv(id);

	}

	private void clearInputInfo() {

		txtId.setText("");
		txtTen.setText("");
		txtLop.setText("");
		txtNienKhoa.setText("");
		txtDiem.setText("");

	}

}
