package QuanLiHocSinh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Model.Dao.ThongTinHocSinhDao;
import Model.bean.HocSinh;
import TrangChu.TrangChu;

public class TabThongTinHocSinh extends JPanel implements ActionListener,MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	
	private JFrame jFrame;
	private JTextField textFieldTimKiem;
	private JLabel lblTimKiemMHS;
	private JButton btnTimKiem;
	private JLabel lblThongTinHocSinh;
	private DefaultTableModel tableThongTinHocSinh;
	private JTable jTableThongTinHocSinh;
	private JScrollPane jScrollPaneTableThongTinHocSinh;
	private JPanel panelCongCu;
	private JLabel lblSoThuTu;
	private JTextField textFieldSoThuTu;
	private JLabel lblMaHocSinh;
	private JTextField textFieldMaHocSinh;
	private JLabel lblTenHocSinh;
	private JTextField textFieldTenHocSinh;
	private JLabel lblGioiTinh;
	private JComboBox<String> comboBoxGioiTinh;
	private JLabel lblNgaySinh;
	private JTextField textFieldNgaySinh;
	private JLabel lblDiaChi;
	private JTextField textFieldDiaChi;
	private JLabel lblTenLop;
	private JComboBox<String> comboBoxTenLop;
	private JLabel lblSoDienThoai;
	private JTextField textFieldSoDienThoai;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnClean;
	private JButton btnThoat;
	private JPanel panelSapXep;
	private JLabel lblSapXep;
	private JButton btnAZ;
	private JButton btnZA;
	private JButton btnCleanTimKiemTTHS;
	private JButton btnLoadTTHS;
	private ThongTinHocSinhDao thongTinHocSinhDao;
	
	public TabThongTinHocSinh(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		thongTinHocSinhDao = new ThongTinHocSinhDao();
		
		{
			lblThongTinHocSinh = new JLabel("THÔNG TIN HỌC SINH");
			lblThongTinHocSinh.setBounds(800, 42, 350, 42);
			lblThongTinHocSinh.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblThongTinHocSinh.setForeground(Color.RED);
			add(lblThongTinHocSinh);
			tableThongTinHocSinh = new DefaultTableModel();
			tableThongTinHocSinh.addColumn("Số TT");
			tableThongTinHocSinh.addColumn("Mã học sinh");
			tableThongTinHocSinh.addColumn("Tên học sinh");
			tableThongTinHocSinh.addColumn("Giới tính");
			tableThongTinHocSinh.addColumn("Ngày sinh");
			tableThongTinHocSinh.addColumn("Địa chỉ");
			tableThongTinHocSinh.addColumn("Tên lớp");
			tableThongTinHocSinh.addColumn("Số điện thoại");
			jTableThongTinHocSinh = new JTable(tableThongTinHocSinh);
			TableColumnModel columnModelTTHS = jTableThongTinHocSinh.getColumnModel();
			columnModelTTHS.getColumn(0).setPreferredWidth(10);	
			columnModelTTHS.getColumn(1).setPreferredWidth(50);
			columnModelTTHS.getColumn(2).setPreferredWidth(150);
			columnModelTTHS.getColumn(3).setPreferredWidth(50);
			columnModelTTHS.getColumn(4).setPreferredWidth(100);
			columnModelTTHS.getColumn(5).setPreferredWidth(250);
			columnModelTTHS.getColumn(6).setPreferredWidth(40);
			columnModelTTHS.getColumn(7).setPreferredWidth(50);
	
			jTableThongTinHocSinh.addMouseListener(this);
			jScrollPaneTableThongTinHocSinh = new JScrollPane(jTableThongTinHocSinh);
			jScrollPaneTableThongTinHocSinh.setBounds(390, 119, 1510,700);
			jScrollPaneTableThongTinHocSinh.setMaximumSize(new Dimension(1500, 200));
			add(jScrollPaneTableThongTinHocSinh);

		}
		
		{
			textFieldTimKiem = new JTextField();
			textFieldTimKiem.setBounds(130, 50, 150, 35);
			add(textFieldTimKiem);
			textFieldTimKiem.setColumns(10);

		}
		{
			lblTimKiemMHS = new JLabel("Mã học sinh");
			lblTimKiemMHS.setBounds(30, 60, 76, 14);
			add(lblTimKiemMHS);
		}
		{ 
			btnTimKiem = new JButton("Tìm Kiếm");
			btnTimKiem.setBounds(300, 50, 115, 35);
			btnTimKiem.setIcon(new ImageIcon("timkiem.png"));
			add(btnTimKiem);
			btnTimKiem.addActionListener(this);
			
		}
		{ 
			btnCleanTimKiemTTHS = new JButton("Clean");
			btnCleanTimKiemTTHS.setBounds(430, 50, 115, 35);
			btnCleanTimKiemTTHS.setIcon(new ImageIcon("clean.png"));
			add(btnCleanTimKiemTTHS);
			btnCleanTimKiemTTHS.addActionListener(this);
		}
		{ 
			btnLoadTTHS = new JButton("Load");
			btnLoadTTHS.setBounds(560, 50, 115, 35);
			btnLoadTTHS.setIcon(new ImageIcon("clean.png"));
			add(btnLoadTTHS);
			btnLoadTTHS.addActionListener(this);
		}
		{
			panelCongCu = new JPanel();
			panelCongCu.setBackground(Color.LIGHT_GRAY);
		
			panelCongCu.setBounds(0, 118, 380, 835);
			
			add(panelCongCu);
			panelCongCu.setLayout(null);
			{
				lblSoThuTu = new JLabel("Số  TT");
				lblSoThuTu.setForeground(Color.RED); 
				lblSoThuTu.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoThuTu.setBounds(35, 42, 61, 31);
				panelCongCu.add(lblSoThuTu);
			}
			{
				textFieldSoThuTu = new JTextField();
				textFieldSoThuTu.setBounds(131, 42, 164, 31);
				panelCongCu.add(textFieldSoThuTu);
				textFieldSoThuTu.setColumns(10);
			}
			{
				lblMaHocSinh = new JLabel("Mã Học Sinh");
				lblMaHocSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblMaHocSinh.setForeground(Color.RED);
				lblMaHocSinh.setBounds(35, 97, 89, 31);
				panelCongCu.add(lblMaHocSinh);
			}
			{
				textFieldMaHocSinh = new JTextField();
				textFieldMaHocSinh.setBounds(131, 97, 164, 31);
				panelCongCu.add(textFieldMaHocSinh);
				textFieldMaHocSinh.setColumns(10);
			}
			{
				lblTenHocSinh = new JLabel("Tên Học Sinh");
				lblTenHocSinh.setForeground(Color.RED);
				lblTenHocSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTenHocSinh.setBounds(35, 157, 102, 28);
				panelCongCu.add(lblTenHocSinh);
			}
			{
				textFieldTenHocSinh = new JTextField();
				textFieldTenHocSinh.setBounds(131, 154, 192, 31);
				panelCongCu.add(textFieldTenHocSinh);
				textFieldTenHocSinh.setColumns(10);
			}

			comboBoxGioiTinh = new JComboBox<String>();
			comboBoxGioiTinh.setBounds(131, 205, 102, 28);
			comboBoxGioiTinh.addItem("Nam");
			comboBoxGioiTinh.addItem("Nữ");
			panelCongCu.add(comboBoxGioiTinh);

			lblGioiTinh = new JLabel("Giới Tính");
			lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGioiTinh.setForeground(Color.RED);
			lblGioiTinh.setBounds(35, 216, 89, 14);
			panelCongCu.add(lblGioiTinh);
			{
				lblNgaySinh = new JLabel("Ngày Sinh");
				lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNgaySinh.setForeground(Color.RED);
				lblNgaySinh.setBounds(35, 262, 89, 20);
				panelCongCu.add(lblNgaySinh);
			}
			{
				textFieldNgaySinh = new JTextField();
				textFieldNgaySinh.setBounds(131, 259, 166, 31);
				panelCongCu.add(textFieldNgaySinh);
				textFieldNgaySinh.setColumns(10);
			}
			{
				lblDiaChi = new JLabel("Địa Chỉ");
				lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDiaChi.setForeground(Color.RED);
				lblDiaChi.setBounds(35, 328, 89, 28);
				panelCongCu.add(lblDiaChi);
			}
			{
				textFieldDiaChi = new JTextField();
				textFieldDiaChi.setBounds(131, 325, 192, 31);
				panelCongCu.add(textFieldDiaChi);
				textFieldDiaChi.setColumns(10);
			}
			{
				lblTenLop = new JLabel("Tên Lớp");
				lblTenLop.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTenLop.setForeground(Color.RED);
				lblTenLop.setBounds(35, 397, 89, 17);
				panelCongCu.add(lblTenLop);
			}
			{
				lblSoDienThoai = new JLabel("Số ĐT");
				lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoDienThoai.setForeground(Color.RED);
				lblSoDienThoai.setBounds(35, 448, 89, 28);
				panelCongCu.add(lblSoDienThoai);
			}
			{
				textFieldSoDienThoai = new JTextField();
				textFieldSoDienThoai.setBounds(131, 439, 164, 37);
				panelCongCu.add(textFieldSoDienThoai);
				textFieldSoDienThoai.setColumns(10);
			}
			{
				comboBoxTenLop = new JComboBox<String>();
				comboBoxTenLop.setBounds(132, 389, 101, 28);
				comboBoxTenLop.addItem("10A1");
				comboBoxTenLop.addItem("10A2");
				comboBoxTenLop.addItem("10A3");
				comboBoxTenLop.addItem("10A4");
				comboBoxTenLop.addItem("10A5");
				comboBoxTenLop.addItem("10A6");
				comboBoxTenLop.addItem("10A7");
				comboBoxTenLop.addItem("10A8");
				comboBoxTenLop.addItem("10A9");
				comboBoxTenLop.addItem("10A10");
				comboBoxTenLop.addItem("11A1");
				comboBoxTenLop.addItem("11A2");
				comboBoxTenLop.addItem("11A3");
				comboBoxTenLop.addItem("11A4");
				comboBoxTenLop.addItem("11A5");
				comboBoxTenLop.addItem("11A6");
				comboBoxTenLop.addItem("11A7");
				comboBoxTenLop.addItem("11A8");
				comboBoxTenLop.addItem("11A9");
				comboBoxTenLop.addItem("11A10");
				comboBoxTenLop.addItem("12A1");
				comboBoxTenLop.addItem("12A2");
				comboBoxTenLop.addItem("12A3");
				comboBoxTenLop.addItem("12A4");
				comboBoxTenLop.addItem("12A5");
				comboBoxTenLop.addItem("12A6");
				comboBoxTenLop.addItem("12A7");
				comboBoxTenLop.addItem("12A8");
				comboBoxTenLop.addItem("12A9");
				comboBoxTenLop.addItem("12A10");
				panelCongCu.add(comboBoxTenLop);
			}
			{
				btnThem = new JButton("Thêm");
				btnThem.setIcon(new ImageIcon("add.png"));
				btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnThem.setBounds(50, 600, 110, 40);
				btnThem.addActionListener(this);
				panelCongCu.add(btnThem);
			}
			{
				btnSua = new JButton("Sửa");
				btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnSua.setIcon(new ImageIcon("update.png"));
				btnSua.addActionListener(this);
				btnSua.setBounds(215, 600, 110, 40);
				panelCongCu.add(btnSua);
			}
			{
				btnXoa = new JButton("Xóa");
				btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnXoa.setIcon(new ImageIcon("delete.png"));
				btnXoa.setBounds(50, 700, 110, 40);
				btnXoa.addActionListener(this);
				panelCongCu.add(btnXoa);
			}
			{
				btnClean = new JButton("Clean");
				btnClean.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnClean.setIcon(new ImageIcon("clean.png"));
				btnClean.addActionListener(this);
				btnClean.setBounds(215, 700, 110, 40);
				panelCongCu.add(btnClean);
			}
		}
		{
			btnThoat = new JButton("Thoát");
			btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnThoat.setIcon(new ImageIcon("thoat.png"));
			btnThoat.addActionListener(this);
			btnThoat.setBounds(1700, 40, 100, 30);
			add(btnThoat);

		}
		{
			panelSapXep = new JPanel();
			panelSapXep.setBackground(Color.LIGHT_GRAY);
			panelSapXep.setBounds(390, 800, 1510, 154);
			add(panelSapXep);
			panelSapXep.setLayout(null);
			{
				lblSapXep = new JLabel("Sắp Xếp");
				lblSapXep.setForeground(Color.RED);
				lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblSapXep.setBounds(330, 70, 76, 27);
				panelSapXep.add(lblSapXep);
			}
			{
				btnAZ = new JButton("A - Z");
				btnAZ.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAZ.setIcon(new ImageIcon("AZ.png"));
				btnAZ.setBounds(450, 65, 95, 35);
				btnAZ.addActionListener(this);
				panelSapXep.add(btnAZ);
			}
			{
				btnZA = new JButton("Z - A");
				btnZA.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnZA.setBounds(600, 65, 95, 35);
				btnZA.setIcon(new ImageIcon("ZA.png"));
				btnZA.addActionListener(this);
				panelSapXep.add(btnZA);
			}
			
		}
		
//		container.add(tabThongTinHocSinh);
		loadDataforTableTTHS();
	
	}

	public void loadDataforTableTTHS() {

		// xóa dữ liệu cũ
		tableThongTinHocSinh.setRowCount(0);

		ThongTinHocSinhDao thongTinHocSinhDao = new ThongTinHocSinhDao();

		List<HocSinh> listHocSinh = thongTinHocSinhDao.getAllHocSinh();

		for (HocSinh hocsinh : listHocSinh) {
			tableThongTinHocSinh.addRow(new String[] { "" + hocsinh.getSoThuTu(), hocsinh.getMaHS(), hocsinh.getTenHS(),
					hocsinh.getGioiTinh(), hocsinh.getNgaySinh(), hocsinh.getDiaChi(), hocsinh.getTenLop(),
					hocsinh.getSoDienThoai() });

		}
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		textFieldSoThuTu.setText((String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 0));
		textFieldMaHocSinh
				.setText((String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 1));
		textFieldTenHocSinh
				.setText((String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 2));
		comboBoxGioiTinh.setSelectedItem(jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 3));
		textFieldNgaySinh.setText((String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 4));
		textFieldDiaChi.setText((String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 5));
		comboBoxTenLop.setSelectedItem(jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 6));
		textFieldSoDienThoai
				.setText((String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 7));
		textFieldMaHocSinh.setEnabled(false);
		textFieldSoThuTu.setEnabled(false);
		
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

		if (action == btnThoat) {
			int a = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if (a == JOptionPane.YES_OPTION) {

				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
				jFrame.dispose();
			}
		} else if (action == btnTimKiem) {
			timKiem();
		} 
		else if(action == btnCleanTimKiemTTHS) {
			textFieldTimKiem.setText("");
		}
		else if(action == btnLoadTTHS) {
			loadDataforTableTTHS();
		}
		else if (action == btnThem) {
				
			
			
			if (textFieldSoThuTu.getText().equals("") || textFieldMaHocSinh.getText().equals("")
					|| textFieldTenHocSinh.getText().equals("") || textFieldNgaySinh.getText().equals("")
					|| textFieldDiaChi.getText().equals("") || textFieldSoDienThoai.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "hãy nhập đầy đủ thông tin học sinh");
			}
			else {
				addTTHS();
				loadDataforTableTTHS();
		
			}
			
		} 
		else if (action == btnSua) {
			if (textFieldSoThuTu.getText().equals("") || textFieldMaHocSinh.getText().equals("")
					|| textFieldTenHocSinh.getText().equals("") || textFieldNgaySinh.getText().equals("")
					|| textFieldDiaChi.getText().equals("") || textFieldSoDienThoai.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy chọn học sinh trong bảng để sửa");
			}

			else {
				updateTTHS();
				loadDataforTableTTHS();
				JOptionPane.showMessageDialog(null,"bạn đã update học sinh thành công");
			}
		} else if (action == btnXoa) {
			deleteTTHS();
			loadDataforTableTTHS();

		} else if (action == btnClean) {
			textFieldSoThuTu.setText("");
			textFieldMaHocSinh.setText("");
			textFieldTenHocSinh.setText("");
			textFieldNgaySinh.setText("");
			textFieldDiaChi.setText("");
			textFieldSoDienThoai.setText("");
			textFieldMaHocSinh.setEnabled(true);
			textFieldSoThuTu.setEnabled(true);
		}

		else if (action == btnAZ) {
			tableThongTinHocSinh.setRowCount(0);
			ThongTinHocSinhDao thongTinHocSinhDao = new ThongTinHocSinhDao();
			List<HocSinh> listHocSinh = thongTinHocSinhDao.showTableByAZ();
			for (HocSinh hocsinh : listHocSinh) {
				tableThongTinHocSinh.addRow(new String[] { "" + hocsinh.getSoThuTu(), hocsinh.getMaHS(),
						hocsinh.getTenHS(), hocsinh.getGioiTinh(), hocsinh.getNgaySinh(), hocsinh.getDiaChi(),
						hocsinh.getTenLop(), hocsinh.getSoDienThoai() });
			}

		} else if (action == btnZA) {
			tableThongTinHocSinh.setRowCount(0);
			ThongTinHocSinhDao thongTinHocSinhDao = new ThongTinHocSinhDao();
			List<HocSinh> listHocSinh = thongTinHocSinhDao.showTableByZA();
			for (HocSinh hocsinh : listHocSinh) {
				tableThongTinHocSinh.addRow(new String[] { "" + hocsinh.getSoThuTu(), hocsinh.getMaHS(),
						hocsinh.getTenHS(), hocsinh.getGioiTinh(), hocsinh.getNgaySinh(), hocsinh.getDiaChi(),
						hocsinh.getTenLop(), hocsinh.getSoDienThoai() });

			}
		}
		
	}
	private void deleteTTHS() {
		String mahs = (String) jTableThongTinHocSinh.getValueAt(jTableThongTinHocSinh.getSelectedRow(), 1);
		int choose = JOptionPane.showConfirmDialog(null,
				"bạn có muốn xóa thông tin học sinh có mã học sinh " + mahs + " không?","Xóa",JOptionPane.YES_OPTION);
		if (choose == JOptionPane.YES_OPTION) {
			thongTinHocSinhDao.deleteHocSinh(mahs);
			JOptionPane.showMessageDialog(null, "bạn đã xóa học sinh có mã học sinh " + mahs + " thành công");
		}

	}

	private void updateTTHS() {
		HocSinh hocsinh = new HocSinh();
		hocsinh.setSoThuTu(textFieldSoThuTu.getText());
		hocsinh.setMaHS(textFieldMaHocSinh.getText());
		hocsinh.setTenHS(textFieldTenHocSinh.getText());
		hocsinh.setGioiTinh((String) comboBoxGioiTinh.getSelectedItem());
		hocsinh.setNgaySinh(textFieldNgaySinh.getText());
		hocsinh.setDiaChi(textFieldDiaChi.getText());
		hocsinh.setTenLop((String) comboBoxTenLop.getSelectedItem());
		hocsinh.setSoDienThoai(textFieldSoDienThoai.getText());
		thongTinHocSinhDao.updateHocSinh(hocsinh);

	}

	private void addTTHS() {
		checkaddTTHS() ;
	
	}
	private void checkaddTTHS() {
		String stt = textFieldSoThuTu.getText();
		String mahs = textFieldMaHocSinh.getText();
		if(thongTinHocSinhDao.checkaddTTHS(mahs,stt)==false) {
			JOptionPane.showMessageDialog(null,"Số thứ tự hoặc mã học sinh đã tồn tại");
		}else{
			HocSinh hocsinh = new HocSinh();
			hocsinh.setSoThuTu(textFieldSoThuTu.getText());
			hocsinh.setMaHS(textFieldMaHocSinh.getText());
			hocsinh.setTenHS(textFieldTenHocSinh.getText());
			hocsinh.setGioiTinh((String) comboBoxGioiTinh.getSelectedItem());
			hocsinh.setNgaySinh(textFieldNgaySinh.getText());
			hocsinh.setDiaChi(textFieldDiaChi.getText());
			hocsinh.setTenLop((String) comboBoxTenLop.getSelectedItem());
			hocsinh.setSoDienThoai(textFieldSoDienThoai.getText());
			thongTinHocSinhDao.addHocSinh(hocsinh);
			JOptionPane.showMessageDialog(null, "bạn đã thêm thông tin học sinh thành công");
		}
		
		
	}
	private void timKiem() {
		String mahs = textFieldTimKiem.getText();
		HocSinh hocsinh = new HocSinh();
		tableThongTinHocSinh.setRowCount(0);
		ThongTinHocSinhDao thongTinHocSinhDao = new ThongTinHocSinhDao();
		hocsinh = thongTinHocSinhDao.getHocSinhByMaHS(mahs);
		if (mahs.equals(hocsinh.getMaHS())) {
			tableThongTinHocSinh.addRow(new String[] { "" + hocsinh.getSoThuTu(), hocsinh.getMaHS(), hocsinh.getTenHS(),
					hocsinh.getGioiTinh(), hocsinh.getNgaySinh(), hocsinh.getDiaChi(), hocsinh.getTenLop(),
					hocsinh.getSoDienThoai() });
		} else if (mahs.equals("")) {
			loadDataforTableTTHS();
			JOptionPane.showMessageDialog(null, "bạn hãy nhập mã học sinh để tìm kiếm thông tin");
		} else if (!mahs.equals(hocsinh.getMaHS())) {
			loadDataforTableTTHS();
			JOptionPane.showMessageDialog(null, "mã học sinh bạn nhập không có trong danh sách");

		}

	}
	
}
