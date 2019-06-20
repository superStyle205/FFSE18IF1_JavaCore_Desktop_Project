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

import Model.Dao.QuanLiDiemDao;
import Model.bean.QuanLiDiem;
import TrangChu.TrangChu;

public class TabQuanLiDiem extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
//	private JPanel tabQuanLiDiem;
	private JLabel lblQuanLiDiem;
	private JLabel lblTimKiem;
	private JLabel lblSoThuTuQLD;
	private JLabel lblMaHocSinhQLD;
	private JLabel lblTenHocSinhQLD;
	private JLabel lblMonHocQLD;
	private JLabel lblDiemHocKi1;
	private JLabel lblDiemHocKi2;
	private JLabel lblDiemCuoiNam;
	private JLabel lblSapXepQLD;
	private JTextField textFieldSoThuTuQLD;
	private JTextField textFieldTimKiemQLD;
	private JTextField textFieldMaHocSinhQLD;
	private JTextField textFieldTenHocSinhQLD;
	private JTextField textFieldDiemHocKi1;
	private JTextField textFieldDiemHocKi2;
	private JTextField textFieldDiemCuoiNam;
	private JComboBox<String> comboBoxMonHocQLD;
	private JButton btnThoatQLD;
	private JButton btnThemQLD;
	private JButton btnSuaQLD;
	private JButton btnXoaQLD;
	private JButton btnCleanQLD;
	private JButton btnAZQLD;
	private JButton btnZAQLD;
	private JButton btnTimKiemQLD;
	private JButton btnCleanTimKiemQLD;
	private JButton btnLoad;
	private JButton btnInQLD;
	private JPanel panelCongCuQLD;
	private JPanel panelSapXepQLD;
	private DefaultTableModel tableQLD;
	private JTable jTableQLD;
	private JScrollPane jScrollPaneTableQLD;
	private QuanLiDiemDao quanLiDiemDao;
	
	
	public TabQuanLiDiem(JFrame jFrame) {
		this.jFrame = jFrame;	
		setLayout(null);
		 quanLiDiemDao = new QuanLiDiemDao();
		{
			lblQuanLiDiem = new JLabel("QUẢN LÍ ĐIỂM");
			lblQuanLiDiem.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblQuanLiDiem.setForeground(Color.RED);
			lblQuanLiDiem.setBounds(850, 20, 284, 40);
			add(lblQuanLiDiem);
		}
		{
			btnThoatQLD = new JButton("Thoát");
			btnThoatQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnThoatQLD.setIcon(new ImageIcon("thoat.png"));
			btnThoatQLD.setBounds(1700, 65, 105, 40);
			btnThoatQLD.addActionListener(this);
			add(btnThoatQLD);
		}
		{
			lblTimKiem = new JLabel("Mã học sinh");
			lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTimKiem.setBounds(650, 108, 81, 30);
			add(lblTimKiem);
		}
		
		textFieldTimKiemQLD = new JTextField();
		textFieldTimKiemQLD.setBounds(750, 101, 185, 40);
		add(textFieldTimKiemQLD);
		textFieldTimKiemQLD.setColumns(10);
		
		btnTimKiemQLD = new JButton("Tìm Kiếm");
		btnTimKiemQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiemQLD.setBounds(1000, 100, 125, 40);
//		getRootPane().setDefaultButton(btnTimKiemQLD);
		btnTimKiemQLD.setIcon(new ImageIcon("timkiem.png"));
		btnTimKiemQLD.addActionListener(this);
		add(btnTimKiemQLD);
		
		btnCleanTimKiemQLD = new JButton("Clean");
		btnCleanTimKiemQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCleanTimKiemQLD.setBounds(1160, 100, 105, 40);
		btnCleanTimKiemQLD.setIcon(new ImageIcon("clean.png"));
		btnCleanTimKiemQLD.addActionListener(this);
		add(btnCleanTimKiemQLD);
		
		btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoad.setBounds(1300, 100, 110, 40);
		btnLoad.addActionListener(this);
		btnLoad.setIcon(new ImageIcon("load.png"));
		add(btnLoad);
		
		tableQLD = new DefaultTableModel();
		tableQLD.addColumn("Số thứ tự");
		tableQLD.addColumn("Mã học sinh");
		tableQLD.addColumn("Tên học sinh");
		tableQLD.addColumn("Môn học");
		tableQLD.addColumn("Điểm học kì 1");
		tableQLD.addColumn("Điểm học kì 2");
		tableQLD.addColumn("Điểm cuối năm");
		jTableQLD = new JTable(tableQLD);
		jTableQLD.setBounds(10, 318, 1159, -115);
		jTableQLD.addMouseListener(this);
		jScrollPaneTableQLD = new JScrollPane(jTableQLD);
		jScrollPaneTableQLD.setBounds(400, 165, 1500, 625);
		jScrollPaneTableQLD.setMaximumSize(new Dimension(1500, 200));
		add(jScrollPaneTableQLD);
		{
			panelCongCuQLD = new JPanel();
			panelCongCuQLD.setBounds(0, 165, 390, 785);
			panelCongCuQLD.setBackground(Color.LIGHT_GRAY);
			add(panelCongCuQLD);
			panelCongCuQLD.setLayout(null);
			{
				lblSoThuTuQLD = new JLabel("Số thứ tự");
				lblSoThuTuQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoThuTuQLD.setBounds(36, 68, 88, 17);
				panelCongCuQLD.add(lblSoThuTuQLD);
			}
			{
				textFieldSoThuTuQLD = new JTextField();
				textFieldSoThuTuQLD.setBounds(180, 62, 118, 33);
				panelCongCuQLD.add(textFieldSoThuTuQLD);
				textFieldSoThuTuQLD.setColumns(10);
			}
			{
				lblMaHocSinhQLD = new JLabel("Mã học sinh");
				lblMaHocSinhQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblMaHocSinhQLD.setBounds(36, 121, 88, 28);
				panelCongCuQLD.add(lblMaHocSinhQLD);
			}
			{
				textFieldMaHocSinhQLD = new JTextField();
				textFieldMaHocSinhQLD.setBounds(181, 121, 149, 33);
				panelCongCuQLD.add(textFieldMaHocSinhQLD);
				textFieldMaHocSinhQLD.setColumns(10);
			}
			{
				lblTenHocSinhQLD = new JLabel("Tên học sinh");
				lblTenHocSinhQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTenHocSinhQLD.setBounds(36, 182, 88, 30);
				panelCongCuQLD.add(lblTenHocSinhQLD);
			}
			{
				textFieldTenHocSinhQLD = new JTextField();
				textFieldTenHocSinhQLD.setBounds(176, 183, 170, 33);
				panelCongCuQLD.add(textFieldTenHocSinhQLD);
				textFieldTenHocSinhQLD.setColumns(10);
			}
			{
				lblMonHocQLD = new JLabel("Môn học");
				lblMonHocQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblMonHocQLD.setBounds(36, 249, 75, 29);
				panelCongCuQLD.add(lblMonHocQLD);
			}
			
			comboBoxMonHocQLD = new JComboBox<String>();
			comboBoxMonHocQLD.setFont(new Font("Tahoma", Font.BOLD, 12));
			comboBoxMonHocQLD.addItem("Toán");
			comboBoxMonHocQLD.addItem("Vật Lí");
			comboBoxMonHocQLD.addItem("Hóa Học");
			comboBoxMonHocQLD.addItem("Sinh Học");
			comboBoxMonHocQLD.addItem("Ngữ Văn");
			comboBoxMonHocQLD.addItem("Lịch Sử");
			comboBoxMonHocQLD.addItem("Địa Lí");
			comboBoxMonHocQLD.addItem("GDCD");
			comboBoxMonHocQLD.addItem("Tiếng Anh");
			comboBoxMonHocQLD.addItem("Tin Học");
			comboBoxMonHocQLD.addItem("Công Nghệ");
			comboBoxMonHocQLD.addItem("Thể Dục");
			comboBoxMonHocQLD.addItem("GDQP & AN");
			comboBoxMonHocQLD.setBounds(179, 248, 120, 33);
			panelCongCuQLD.add(comboBoxMonHocQLD);
			{
				lblDiemHocKi1 = new JLabel("Điểm HK1");
				lblDiemHocKi1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDiemHocKi1.setBounds(36, 316, 99, 31);
				panelCongCuQLD.add(lblDiemHocKi1);
			}
			{
				textFieldDiemHocKi1 = new JTextField();
				textFieldDiemHocKi1.setBounds(175, 317, 171, 33);
				panelCongCuQLD.add(textFieldDiemHocKi1);
				textFieldDiemHocKi1.setColumns(10);
			}
			{
				lblDiemHocKi2 = new JLabel("Điểm HK2");
				lblDiemHocKi2.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDiemHocKi2.setBounds(36, 378, 75, 35);
				panelCongCuQLD.add(lblDiemHocKi2);
			}
			{
				textFieldDiemHocKi2 = new JTextField();
				textFieldDiemHocKi2.setBounds(176, 374, 170, 39);
				panelCongCuQLD.add(textFieldDiemHocKi2);
				textFieldDiemHocKi2.setColumns(10);
			}
			{
				lblDiemCuoiNam = new JLabel("Điểm cuối năm");
				lblDiemCuoiNam.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDiemCuoiNam.setBounds(36, 440, 109, 31);
				panelCongCuQLD.add(lblDiemCuoiNam);
			}
			{
				textFieldDiemCuoiNam = new JTextField();
				textFieldDiemCuoiNam.setBounds(176, 438, 170, 39);
				panelCongCuQLD.add(textFieldDiemCuoiNam);
				textFieldDiemCuoiNam.setColumns(10);
			}
			{
				btnThemQLD = new JButton("Thêm");
				btnThemQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnThemQLD.setBounds(48, 600, 109, 39);
				btnThemQLD.setIcon(new ImageIcon("add.png"));
				btnThemQLD.addActionListener(this);
				panelCongCuQLD.add(btnThemQLD);
			}
			{
				btnSuaQLD = new JButton("Sửa");
				btnSuaQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnSuaQLD.setBounds(221,600, 109, 39);
				btnSuaQLD.setIcon(new ImageIcon("update.png"));
				btnSuaQLD.addActionListener(this);
				panelCongCuQLD.add(btnSuaQLD);
			}
			{
				btnXoaQLD = new JButton("Xóa");
				btnXoaQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnXoaQLD.setBounds(47, 700, 110, 39);
				btnXoaQLD.setIcon(new ImageIcon("delete.png"));
				btnXoaQLD.addActionListener(this);
				panelCongCuQLD.add(btnXoaQLD);
			}
			{
				btnCleanQLD = new JButton("Clean");
				btnCleanQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnCleanQLD.setBounds(221, 700, 109, 39);
				btnCleanQLD.setIcon(new ImageIcon("clean.png"));
				btnCleanQLD.addActionListener(this);
				panelCongCuQLD.add(btnCleanQLD);
			}
		}

		{
			panelSapXepQLD = new JPanel();
			panelSapXepQLD.setBackground(Color.LIGHT_GRAY);
			panelSapXepQLD.setBounds(400,790, 1500, 160);
			add(panelSapXepQLD);
			panelSapXepQLD.setLayout(null);
			{
				btnInQLD = new JButton("In");
				btnInQLD.setBounds(1250, 50, 126, 70);
				btnInQLD.setIcon(new ImageIcon("printer.png"));
				panelSapXepQLD.add(btnInQLD);
				btnInQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
			}
			{
				lblSapXepQLD = new JLabel("Sắp Xếp");
				lblSapXepQLD.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblSapXepQLD.setBounds(400, 65, 77, 26);
				panelSapXepQLD.add(lblSapXepQLD);
			}
			{
				btnAZQLD = new JButton("A - Z");
				btnAZQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnAZQLD.setBounds(510, 55, 105, 44);
				btnAZQLD.addActionListener(this);
				btnAZQLD.setIcon(new ImageIcon("AZ.png"));
				panelSapXepQLD.add(btnAZQLD);
			}
			{
				btnZAQLD = new JButton("Z - A");
				btnZAQLD.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnZAQLD.addActionListener(this);
				btnZAQLD.setBounds(650, 55, 105, 44);
				btnZAQLD.setIcon(new ImageIcon("ZA.png"));
				panelSapXepQLD.add(btnZAQLD);
			}
		}
		loadDataforTableQLD();
	}
	public void loadDataforTableQLD() {

		// xóa dữ liệu cũ
		tableQLD.setRowCount(0);

		QuanLiDiemDao quanLiDiemDao = new QuanLiDiemDao();

		List<QuanLiDiem> listQuanLiDiem = quanLiDiemDao.getAllDiemQLD();

		for (QuanLiDiem quanLiDiem : listQuanLiDiem) {
			tableQLD.addRow(new String[] { "" + quanLiDiem.getSoThuTu(), quanLiDiem.getMaHS(), quanLiDiem.getTenHS(),
					quanLiDiem.getMonHoc(), quanLiDiem.getDiemHocKi1(), quanLiDiem.getDiemHocKi2(), quanLiDiem.getDiemCuoiNam()
			});
			
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		textFieldSoThuTuQLD.setText((String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 0));
		textFieldMaHocSinhQLD.setText((String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 1));
		textFieldTenHocSinhQLD.setText((String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 2));
		comboBoxMonHocQLD.setSelectedItem(jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 3));
		textFieldDiemHocKi1.setText((String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 4));
		textFieldDiemHocKi2.setText((String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 5));
		textFieldDiemCuoiNam.setText((String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 6));
		textFieldMaHocSinhQLD.setEnabled(false);
		textFieldSoThuTuQLD.setEnabled(false);
		
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
	
		if (action == btnCleanTimKiemQLD) {
			textFieldTimKiemQLD.setText("");
		}
		else if(action == btnThemQLD) {
			if(textFieldSoThuTuQLD.getText().equals("")||textFieldMaHocSinhQLD.getText().equals("")||textFieldTenHocSinhQLD.getText().equals("")||
					textFieldDiemHocKi1.getText().equals("")||textFieldDiemHocKi2.getText().equals("")||textFieldDiemCuoiNam.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy nhập đầy đủ thông tin của học sinh");
			}
			else {
			addDiemQLD();
			loadDataforTableQLD();
		
			}
		}
		else if (action == btnSuaQLD) {
			if(textFieldSoThuTuQLD.getText().equals("")||textFieldMaHocSinhQLD.getText().equals("")||textFieldTenHocSinhQLD.getText().equals("")||
					textFieldDiemHocKi1.getText().equals("")||textFieldDiemHocKi2.getText().equals("")||textFieldDiemCuoiNam.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy chọn học sinh trong bảng để sửa");
			}
			else {
			updateDiemQLD();
			loadDataforTableQLD();
			JOptionPane.showMessageDialog(null,"bạn đã update điểm học sinh thành công");
			}
			
		}
		else if (action == btnXoaQLD) {
			deleteTableQLD();
			loadDataforTableQLD();
		}
		else if(action == btnCleanQLD) {
			textFieldSoThuTuQLD.setText("");
			textFieldMaHocSinhQLD.setText("");
			textFieldTenHocSinhQLD.setText("");
			textFieldDiemHocKi1.setText("");
			textFieldDiemHocKi2.setText("");
			textFieldDiemCuoiNam.setText("");
			textFieldMaHocSinhQLD.setEnabled(true);
			textFieldSoThuTuQLD.setEnabled(true);
		}
		else if(action == btnAZQLD) {
			tableQLD.setRowCount(0);
//			QuanLiDiemDao quanLiDiemDao = new QuanLiDiemDao();
			List<QuanLiDiem> listQuanLiDiem = quanLiDiemDao.showTableByAZQLD();
			for(QuanLiDiem quanLiDiem: listQuanLiDiem) {
				tableQLD.addRow(new String[] {""+ quanLiDiem.getSoThuTu(),quanLiDiem.getMaHS(),quanLiDiem.getTenHS(),quanLiDiem.getMonHoc(),
						quanLiDiem.getDiemHocKi1(),quanLiDiem.getDiemHocKi2(),quanLiDiem.getDiemCuoiNam()});
			}
		}
		else if(action == btnZAQLD) {
			tableQLD.setRowCount(0);
//			QuanLiDiemDao quanLiDiemDao = new QuanLiDiemDao();
			List<QuanLiDiem> listQuanLiDiem = quanLiDiemDao.showTableByZAQLD();
			for(QuanLiDiem quanLiDiem: listQuanLiDiem) {
				tableQLD.addRow(new String[] {""+ quanLiDiem.getSoThuTu(),quanLiDiem.getMaHS(),quanLiDiem.getTenHS(),quanLiDiem.getMonHoc(),
						quanLiDiem.getDiemHocKi1(),quanLiDiem.getDiemHocKi2(),quanLiDiem.getDiemCuoiNam()});
			}
		}
		else if(action == btnTimKiemQLD) {
			timKiemQLD();
		}
		else if(action == btnLoad) {
			loadDataforTableQLD();
		}
		else if(action == btnThoatQLD) {
			int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
				jFrame.dispose();
			}
		}
		
	}
		private void addDiemQLD() {
			ckeckaddQLD();
			
			
		}
		private void ckeckaddQLD() {
			String stt = textFieldSoThuTuQLD.getText();
			String mahs = textFieldMaHocSinhQLD.getText();
			if(quanLiDiemDao.checkaddQLD(mahs,stt)==false) {
				JOptionPane.showMessageDialog(null,"Số thứ tự hoặc mã học sinh đã tồn tại");
			}else{
				QuanLiDiem quanLiDiem = new QuanLiDiem();
				quanLiDiem.setSoThuTu(textFieldSoThuTuQLD.getText());
				quanLiDiem.setMaHS(textFieldMaHocSinhQLD.getText());
				quanLiDiem.setTenHS(textFieldTenHocSinhQLD.getText());
				quanLiDiem.setMonHoc((String) comboBoxMonHocQLD.getSelectedItem());
				quanLiDiem.setDiemHocKi1(textFieldDiemHocKi1.getText());	
				quanLiDiem.setDiemHocKi2(textFieldDiemHocKi2.getText());
				quanLiDiem.setDiemCuoiNam(textFieldDiemCuoiNam.getText());
				quanLiDiemDao.addDiemQLD(quanLiDiem);
				JOptionPane.showMessageDialog(null, "bạn đã thêm điểm thành công");
				
			}
		}
		private void updateDiemQLD() {
			QuanLiDiem quanLiDiem = new QuanLiDiem();
			quanLiDiem.setSoThuTu(textFieldSoThuTuQLD.getText());
			quanLiDiem.setMaHS(textFieldMaHocSinhQLD.getText());
			quanLiDiem.setTenHS(textFieldTenHocSinhQLD.getText());
			quanLiDiem.setMonHoc((String) comboBoxMonHocQLD.getSelectedItem());
			quanLiDiem.setDiemHocKi1(textFieldDiemHocKi1.getText());
			quanLiDiem.setDiemHocKi2(textFieldDiemHocKi2.getText());
			quanLiDiem.setDiemCuoiNam(textFieldDiemCuoiNam.getText());
			quanLiDiemDao.updateDiemQLD(quanLiDiem);
		}
		private void deleteTableQLD() {
			
			String mahs = (String) jTableQLD.getValueAt(jTableQLD.getSelectedRow(), 1);
			int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa thông tin điểm học sinh có mã học sinh "+ mahs +" không?","Xóa",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				quanLiDiemDao.deleteDiemQLD(mahs);
				JOptionPane.showMessageDialog(null, "bạn đã xóa thông tin điểm của học sinh có mã học sinh " + mahs + " thành công");
			}
		}
		private void timKiemQLD() {
			String mahs = textFieldTimKiemQLD.getText();
			tableQLD.setRowCount(0);
			QuanLiDiem quanLiDiem = new QuanLiDiem();
			quanLiDiem = quanLiDiemDao.getDiemByMaHSQLD(mahs);
			if(mahs.equals(quanLiDiem.getMaHS())) {
				tableQLD.addRow(new String[] {"" + quanLiDiem.getSoThuTu(),quanLiDiem.getMaHS(),quanLiDiem.getTenHS(),quanLiDiem.getMonHoc(),
							quanLiDiem.getDiemHocKi1(),quanLiDiem.getDiemHocKi2(),quanLiDiem.getDiemCuoiNam()});
			}
			
			else if(mahs.equals("")) {
				loadDataforTableQLD();
				JOptionPane.showMessageDialog(null,"bạn hãy nhập mã học sinh để tìm kiếm điểm của học sinh");
			}
			else if(!mahs.equals(quanLiDiem.getMaHS())) {
				loadDataforTableQLD();
				JOptionPane.showMessageDialog(null,"mã học sinh bạn nhập không tồn tại trong danh sách");
			}
		}

}
