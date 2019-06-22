package QuanLiHocSinh;

import java.awt.Color;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Dao.KetQuaHocTapDao;
import Model.bean.KetQuaHocTap;
import TrangChu.TrangChu;

public class TabKetQuaHocTap extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
	private JPanel panelCongCuKQHT;
	private JPanel panelSapXepKQHT;
	private JLabel lblKetQuaHocTap;
	private JLabel lblMaHocSinhTimKiemKQHT;
	private JLabel lblMaHocSinhKQHT;
	private JLabel lblSoThuTuKQHT;
	private JLabel lblTenHocSinhKQHT;
	private JLabel lblDiemTongKetKQHT;
	private JLabel lblXepLoaiKQHT;
	private JLabel lblHanhKiemKQHT;
	private JLabel lblKetQuaKQHT;
	private JLabel lblSapXepKQHT;
	
	private JTextField textFieldMaHocSinhTimKiemKQHT;
	private JTextField textFieldMaHocSinhKQHT;
	private JTextField textFieldTenHocSinhKQHT;
	private JTextField textFieldSoThuTuKQHT;
	private JTextField textFieldDiemTongKetKQHT;
	private JComboBox<String> comboBoxXepLoaiKQHT;
	private JComboBox<String> comboBoxHanhKiemKQHT;
	private JComboBox<String> comboBoxKetQuaKQHT;
	
	private JButton btnTimKiemKQHT;
	private JButton btnCleanTimKiemKQHT;
	private JButton btnLoadKQHT;
	private JButton btnThemKQHT;
	private JButton btnSuaKQHT;
	private JButton btnXoaKQHT;
	private JButton btnCleanKQHT;
	private JButton btnAZKQHT;
	private JButton btnZAKQHT;
	private JButton btnInKQHT;
	private JButton btnThoatKQHT;
	
	private JTable jTableKQHT;
	private DefaultTableModel tableKQHT;
	private JScrollPane jScrollPaneKQHT;
	private KetQuaHocTapDao ketQuaHocTapDao;
	

	public TabKetQuaHocTap(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		ketQuaHocTapDao = new KetQuaHocTapDao();
		setBackground(new Color(240, 255, 255));
		
		{
			lblKetQuaHocTap = new JLabel("KẾT QUẢ HỌC TẬP");
			lblKetQuaHocTap.setForeground(Color.RED);
			lblKetQuaHocTap.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblKetQuaHocTap.setBounds(819, 44, 292, 41);
			add(lblKetQuaHocTap);
		}
		{
			tableKQHT = new DefaultTableModel();
			tableKQHT.addColumn("Số thứ tự");
			tableKQHT.addColumn("Mã Học Sinh");
			tableKQHT.addColumn("Tên Học Sinh");
			tableKQHT.addColumn("Điểm Tổng kết");
			tableKQHT.addColumn("Xếp loại");
			tableKQHT.addColumn("Hạnh Kiểm");
			tableKQHT.addColumn("Kết Quả");
			jTableKQHT = new JTable(tableKQHT);
			jTableKQHT.addMouseListener(this);
			jScrollPaneKQHT = new JScrollPane(jTableKQHT);
			jScrollPaneKQHT.setBounds(475,209,1425,610);
			add(jScrollPaneKQHT);
		}
		{
			panelCongCuKQHT = new JPanel();
			panelCongCuKQHT.setBackground(new Color(192, 192, 192));
			panelCongCuKQHT.setBorder(new LineBorder(new Color(0, 0, 255), 1));
			panelCongCuKQHT.setBounds(0, 209, 471, 754);
			add(panelCongCuKQHT);
			panelCongCuKQHT.setLayout(null);
			{
				lblSoThuTuKQHT = new JLabel("Số thứ tự");
				lblSoThuTuKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoThuTuKQHT.setBounds(56, 57, 93, 33);
				panelCongCuKQHT.add(lblSoThuTuKQHT);
			}
			{
				textFieldSoThuTuKQHT = new JTextField();
				textFieldSoThuTuKQHT.setBounds(187, 57, 209, 36);
				panelCongCuKQHT.add(textFieldSoThuTuKQHT);
				textFieldSoThuTuKQHT.setColumns(10);
			}
			{
				lblMaHocSinhKQHT = new JLabel("Mã Học Sinh");
				lblMaHocSinhKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblMaHocSinhKQHT.setBounds(56, 136, 115, 33);
				panelCongCuKQHT.add(lblMaHocSinhKQHT);
			}
			{
				textFieldMaHocSinhKQHT = new JTextField();
				textFieldMaHocSinhKQHT.setBounds(187, 133, 209, 36);
				panelCongCuKQHT.add(textFieldMaHocSinhKQHT);
				textFieldMaHocSinhKQHT.setColumns(10);
			}
			{
				lblTenHocSinhKQHT = new JLabel("Tên Học Sinh");
				lblTenHocSinhKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTenHocSinhKQHT.setBounds(56, 219, 115, 33);
				panelCongCuKQHT.add(lblTenHocSinhKQHT);
			}
			{
				textFieldTenHocSinhKQHT = new JTextField();
				textFieldTenHocSinhKQHT.setBounds(187, 216, 209, 36);
				panelCongCuKQHT.add(textFieldTenHocSinhKQHT);
				textFieldTenHocSinhKQHT.setColumns(10);
			}
			{
				lblDiemTongKetKQHT = new JLabel("Điểm Tổng Kết");
				lblDiemTongKetKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDiemTongKetKQHT.setBounds(56, 297, 115, 36);
				panelCongCuKQHT.add(lblDiemTongKetKQHT);
			}
			{
				textFieldDiemTongKetKQHT = new JTextField();
				textFieldDiemTongKetKQHT.setBounds(187, 297, 207, 36);
				panelCongCuKQHT.add(textFieldDiemTongKetKQHT);
				textFieldDiemTongKetKQHT.setColumns(10);
			}
			{
				lblXepLoaiKQHT = new JLabel("Xếp loại");
				lblXepLoaiKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblXepLoaiKQHT.setBounds(56, 375, 115, 36);
				panelCongCuKQHT.add(lblXepLoaiKQHT);
			}
			{
				comboBoxXepLoaiKQHT = new JComboBox<String>();
				comboBoxXepLoaiKQHT.addItem("Giỏi");
				comboBoxXepLoaiKQHT.addItem("Khá");
				comboBoxXepLoaiKQHT.addItem("Trung Bình");
				comboBoxXepLoaiKQHT.addItem("Yếu");
				comboBoxXepLoaiKQHT.setBounds(188, 375, 208, 36);
				panelCongCuKQHT.add(comboBoxXepLoaiKQHT);
			}
			{
				lblHanhKiemKQHT = new JLabel("Hạnh Kiểm");
				lblHanhKiemKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblHanhKiemKQHT.setBounds(56, 461, 93, 33);
				panelCongCuKQHT.add(lblHanhKiemKQHT);
			}
			{
				comboBoxHanhKiemKQHT = new JComboBox<String>();
				comboBoxHanhKiemKQHT.addItem("Tốt");
				comboBoxHanhKiemKQHT.addItem("Khá");
				comboBoxHanhKiemKQHT.addItem("Trung Bình");
				comboBoxHanhKiemKQHT.addItem("Yếu");
				comboBoxHanhKiemKQHT.addItem("Kém");
				comboBoxHanhKiemKQHT.setBounds(187, 458, 209, 36);
				panelCongCuKQHT.add(comboBoxHanhKiemKQHT);
			}
			{
				lblKetQuaKQHT = new JLabel("Kết Quả");
				lblKetQuaKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblKetQuaKQHT.setBounds(56, 538, 93, 30);
				panelCongCuKQHT.add(lblKetQuaKQHT);
			}
			{
				comboBoxKetQuaKQHT = new JComboBox<String>();
				comboBoxKetQuaKQHT.addItem("Được lên lớp");
				comboBoxKetQuaKQHT.addItem("Thi lại");
				comboBoxKetQuaKQHT.addItem("Ở lại lớp");
				comboBoxKetQuaKQHT.setBounds(184, 535, 212, 33);
				panelCongCuKQHT.add(comboBoxKetQuaKQHT);
			}
			{
				btnThemKQHT = new JButton("Thêm");
				btnThemKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnThemKQHT.setBounds(56, 599, 120, 42);
				btnThemKQHT.setIcon(new ImageIcon("add.png"));
				btnThemKQHT.addActionListener(this);
				panelCongCuKQHT.add(btnThemKQHT);
			}
			{
				btnSuaKQHT = new JButton("Sửa");
				btnSuaKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnSuaKQHT.setBounds(281, 599, 115, 42);
				btnSuaKQHT.setIcon(new ImageIcon("update.png"));
				btnSuaKQHT.addActionListener(this);
				panelCongCuKQHT.add(btnSuaKQHT);
			}
			{
				btnXoaKQHT = new JButton("Xóa");
				btnXoaKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnXoaKQHT.setBounds(56, 681, 120, 42);
				btnXoaKQHT.setIcon(new ImageIcon("delete.png"));
				btnXoaKQHT.addActionListener(this);
				panelCongCuKQHT.add(btnXoaKQHT);
			}
			{
				btnCleanKQHT = new JButton("Clean");
				btnCleanKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnCleanKQHT.setBounds(281, 681, 115, 42);
				btnCleanKQHT.setIcon(new ImageIcon("clean.png"));
				btnCleanKQHT.addActionListener(this);
				panelCongCuKQHT.add(btnCleanKQHT);
			}
		}
		{
			panelSapXepKQHT = new JPanel();
			panelSapXepKQHT.setBackground(new Color(192, 192, 192));
			panelSapXepKQHT.setBorder(new LineBorder(new Color(0, 0, 205), 1));
			panelSapXepKQHT.setBounds(473, 817, 1426, 146);
			add(panelSapXepKQHT);
			panelSapXepKQHT.setLayout(null);
			{
				lblSapXepKQHT = new JLabel("Sắp Xếp");
				lblSapXepKQHT.setForeground(Color.RED);
				lblSapXepKQHT.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSapXepKQHT.setBounds(211, 62, 101, 33);
				panelSapXepKQHT.add(lblSapXepKQHT);
			}
			{
				btnAZKQHT = new JButton("A -Z");
				btnAZKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnAZKQHT.setBounds(374, 56, 125, 48);
				btnAZKQHT.setIcon(new ImageIcon("AZ.png"));
				btnAZKQHT.addActionListener(this);
				panelSapXepKQHT.add(btnAZKQHT);
			}
			{
				btnZAKQHT = new JButton("Z - A");
				btnZAKQHT.setForeground(new Color(0, 0, 0));
				btnZAKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnZAKQHT.setBounds(553, 56, 125, 48);
				btnZAKQHT.setIcon(new ImageIcon("ZA.png"));
				btnZAKQHT.addActionListener(this);
				panelSapXepKQHT.add(btnZAKQHT);
			}
			{
				btnInKQHT = new JButton("In");
				btnInKQHT.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnInKQHT.setBounds(1214, 49, 130, 62);
				btnInKQHT.setIcon(new ImageIcon("printer.png"));
				btnInKQHT.addActionListener(this);
				panelSapXepKQHT.add(btnInKQHT);
			}
		}
		{
			lblMaHocSinhTimKiemKQHT = new JLabel("Mã Học Sinh");
			lblMaHocSinhTimKiemKQHT.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMaHocSinhTimKiemKQHT.setBounds(473, 126, 115, 41);
			add(lblMaHocSinhTimKiemKQHT);
		}
		{
			textFieldMaHocSinhTimKiemKQHT = new JTextField();
			textFieldMaHocSinhTimKiemKQHT.setBounds(585, 126, 202, 41);
			add(textFieldMaHocSinhTimKiemKQHT);
			textFieldMaHocSinhTimKiemKQHT.setColumns(10);
		}
		{
			btnTimKiemKQHT = new JButton("Tìm Kiếm");
			btnTimKiemKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnTimKiemKQHT.setBounds(845, 126, 125, 41);
//			getRootPane().setDefaultButton(btnTimKiemKQHT);
			btnTimKiemKQHT.setIcon(new ImageIcon("timkiem.png"));
			btnTimKiemKQHT.addActionListener(this);
			add(btnTimKiemKQHT);
		}
		{
			btnCleanTimKiemKQHT = new JButton("Clean");
			btnCleanTimKiemKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnCleanTimKiemKQHT.setBounds(993, 126, 118, 41);
			btnCleanTimKiemKQHT.setIcon(new ImageIcon("clean.png"));
			btnCleanTimKiemKQHT.addActionListener(this);
			add(btnCleanTimKiemKQHT);
		}
		{
			btnLoadKQHT = new JButton("Load");
			btnLoadKQHT.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLoadKQHT.setBounds(1139, 126, 122, 41);
			btnLoadKQHT.setIcon(new ImageIcon("load.png"));
			btnLoadKQHT.addActionListener(this);
			add(btnLoadKQHT);
		}
		{
			btnThoatKQHT = new JButton("Thoát");
			btnThoatKQHT.setBounds(1680, 61, 133, 41);
			btnThoatKQHT.setIcon(new ImageIcon("thoat.png"));
			btnThoatKQHT.addActionListener(this);
			add(btnThoatKQHT);
		}
		loadDataforTableKQHT();
		
	}
	public void loadDataforTableKQHT() {
		tableKQHT.setRowCount(0);
		KetQuaHocTapDao ketQuaHocTapDao = new KetQuaHocTapDao();
		List<KetQuaHocTap> listKetQuaHocTap = ketQuaHocTapDao.getAllKetQuaKQHT();
		for(KetQuaHocTap ketQuaHocTap : listKetQuaHocTap) {
			tableKQHT.addRow(new String[] {"" + ketQuaHocTap.getSoThuTu(),ketQuaHocTap.getMaHS(),ketQuaHocTap.getTenHS(),ketQuaHocTap.getDiemTongKet(),ketQuaHocTap.getXepLoai(),ketQuaHocTap.getHanhKiem(),ketQuaHocTap.getKetQua() });
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		textFieldSoThuTuKQHT.setText((String) jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 0));
		textFieldMaHocSinhKQHT.setText((String) jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 1));
		textFieldTenHocSinhKQHT.setText((String) jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 2));
		textFieldDiemTongKetKQHT.setText((String) jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 3));
		comboBoxXepLoaiKQHT.setSelectedItem(jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(),4));
		comboBoxHanhKiemKQHT.setSelectedItem(jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 5));
		comboBoxKetQuaKQHT.setSelectedItem(jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 6));
		textFieldMaHocSinhKQHT.setEditable(false);
		textFieldSoThuTuKQHT.setEditable(false);
		
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
		if(action == btnCleanTimKiemKQHT) {
			 textFieldMaHocSinhTimKiemKQHT.setText("");
		}
		else if(action == btnLoadKQHT) {
			loadDataforTableKQHT();
		}
		else if(action == btnTimKiemKQHT) {
			timKiemKQHT();
			
		}
		else if(action == btnThoatKQHT) {
			int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát?","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
				jFrame.dispose();
			}
		}
		else if(action == btnAZKQHT) {
			tableKQHT.setRowCount(0);
			List<KetQuaHocTap> listKetQuaHocTap = ketQuaHocTapDao.showTableByAZKQHT();
			for(KetQuaHocTap ketQuaHocTap : listKetQuaHocTap) {
				tableKQHT.addRow(new String [] {""+ ketQuaHocTap.getSoThuTu(),ketQuaHocTap.getMaHS(),ketQuaHocTap.getTenHS(),ketQuaHocTap.getDiemTongKet(),ketQuaHocTap.getXepLoai(),ketQuaHocTap.getHanhKiem(),ketQuaHocTap.getKetQua()});
			}
		}
		else if(action == btnZAKQHT) {
			tableKQHT.setRowCount(0);
			List<KetQuaHocTap> listKetQuaHocTap = ketQuaHocTapDao.showTableByZAKQHT();
			for(KetQuaHocTap ketQuaHocTap : listKetQuaHocTap) {
				tableKQHT.addRow(new String [] {""+ ketQuaHocTap.getSoThuTu(),ketQuaHocTap.getMaHS(),ketQuaHocTap.getTenHS(),ketQuaHocTap.getDiemTongKet(),ketQuaHocTap.getXepLoai(),ketQuaHocTap.getHanhKiem(),ketQuaHocTap.getKetQua()});
			}
		}
		else if(action == btnThemKQHT) {
			if(textFieldSoThuTuKQHT.getText().equals("")||textFieldMaHocSinhKQHT.getText().equals("")||textFieldTenHocSinhKQHT.equals("")||
					textFieldDiemTongKetKQHT.equals("")) {
				JOptionPane.showMessageDialog(null,"bạn hãy nhập đầy đủ thông tin học sinh");
			}
			else {
			addKetQuaKQHT();
			loadDataforTableKQHT();
		
			}
		}
		else if(action == btnSuaKQHT) {
			if(textFieldSoThuTuKQHT.getText().equals("")||textFieldMaHocSinhKQHT.getText().equals("")||textFieldTenHocSinhKQHT.equals("")||
					textFieldDiemTongKetKQHT.equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy chọn học sinh trong bảng để sửa");
			}
			else {
			updateKetQuaKQHT();
			loadDataforTableKQHT();
			JOptionPane.showMessageDialog(null,"bạn đã update kết quả học tập của học sinh thành công");
			}
		}
		else if(action == btnXoaKQHT) {
			deleteKetQuaKQHT();
			loadDataforTableKQHT();
		}
		else if (action == btnCleanKQHT) {
			cleanKetQuaKQHT();
		}
		
	}
	public void timKiemKQHT() {
		tableKQHT.setRowCount(0);
		String mahs = textFieldMaHocSinhTimKiemKQHT.getText();
		KetQuaHocTap ketQuaHocTap = new KetQuaHocTap();
		ketQuaHocTap = ketQuaHocTapDao.getKetQuaByMaHSKQHT(mahs);
		if(mahs.equals(ketQuaHocTap.getMaHS())) {
			tableKQHT.addRow(new String[] {"" + ketQuaHocTap.getSoThuTu(),ketQuaHocTap.getMaHS(),ketQuaHocTap.getTenHS(),ketQuaHocTap.getDiemTongKet(),ketQuaHocTap.getXepLoai(),ketQuaHocTap.getHanhKiem(),ketQuaHocTap.getKetQua()});
		}
		else if(mahs.equals("")) {
			loadDataforTableKQHT();
			JOptionPane.showMessageDialog(null,"bạn hãy nhập mã học sinh để tìm kiếm kết quả học sinh");
		}
		else if(!mahs.equals(ketQuaHocTap.getMaHS())) {
			loadDataforTableKQHT();
			JOptionPane.showMessageDialog(null,"mã học sinh bạn nhập không tồn tại trong danh sách");
		}
	}
	public void addKetQuaKQHT() {
		ckeckaddKetQuaKQHT();
		
	}
	private void ckeckaddKetQuaKQHT() {
		String stt = textFieldSoThuTuKQHT.getText();
		String mahs = textFieldMaHocSinhKQHT.getText();
		if(ketQuaHocTapDao.checkaddKQHT(mahs,stt)==false) {
			JOptionPane.showMessageDialog(null,"Số thứ tự hoặc mã học sinh đã tồn tại");
		}else{
			KetQuaHocTap ketQuaHocTap = new KetQuaHocTap();
			ketQuaHocTap.setSoThuTu(textFieldSoThuTuKQHT.getText());
			ketQuaHocTap.setMaHS(textFieldMaHocSinhKQHT.getText());
			ketQuaHocTap.setTenHS(textFieldTenHocSinhKQHT.getText());
			ketQuaHocTap.setDiemTongKet(textFieldDiemTongKetKQHT.getText());
			ketQuaHocTap.setXepLoai((String) comboBoxXepLoaiKQHT.getSelectedItem());
			ketQuaHocTap.setHanhKiem((String) comboBoxHanhKiemKQHT.getSelectedItem());
			ketQuaHocTap.setKetQua((String) comboBoxKetQuaKQHT.getSelectedItem());
			ketQuaHocTapDao.addKetQuaKQHT(ketQuaHocTap);
			JOptionPane.showMessageDialog(null, "bạn đã thêm kết quả thành công");
			
		}
	}
	private void updateKetQuaKQHT() {
		KetQuaHocTap ketQuaHocTap = new KetQuaHocTap();
	
		ketQuaHocTap.setSoThuTu(textFieldSoThuTuKQHT.getText());
		ketQuaHocTap.setMaHS(textFieldMaHocSinhKQHT.getText());
		ketQuaHocTap.setTenHS(textFieldTenHocSinhKQHT.getText());
		ketQuaHocTap.setDiemTongKet(textFieldDiemTongKetKQHT.getText());
		ketQuaHocTap.setXepLoai((String) comboBoxXepLoaiKQHT.getSelectedItem());
		ketQuaHocTap.setHanhKiem((String) comboBoxHanhKiemKQHT.getSelectedItem());
		ketQuaHocTap.setKetQua((String) comboBoxKetQuaKQHT.getSelectedItem());
		ketQuaHocTapDao.updateKetQuaKQHT(ketQuaHocTap);
	}
	private void deleteKetQuaKQHT() {
		
		String mahs = (String) jTableKQHT.getValueAt(jTableKQHT.getSelectedRow(), 1);
		int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa kết quả của học sinh có mã học sinh " + mahs + " không?","Xóa",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
		ketQuaHocTapDao.deleteKetQuaKQHT(mahs);
		JOptionPane.showMessageDialog(null, "bạn đã xóa học sinh thành công");
		}
	}
	private void cleanKetQuaKQHT() {
		textFieldSoThuTuKQHT.setText("");
		textFieldMaHocSinhKQHT.setText("");
		textFieldTenHocSinhKQHT.setText("");
		textFieldDiemTongKetKQHT.setText("");
		textFieldSoThuTuKQHT.setEditable(true);
		textFieldMaHocSinhKQHT.setEditable(true);
	}

}
