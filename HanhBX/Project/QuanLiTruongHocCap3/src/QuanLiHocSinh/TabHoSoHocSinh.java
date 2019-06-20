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
import javax.swing.table.TableColumnModel;

import Model.Dao.HoSoHocSinhDao;
import Model.bean.HoSoHocSinh;
import TrangChu.TrangChu;

public class TabHoSoHocSinh extends JPanel implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
	private JPanel panelInputHSHS;
	private JPanel panelCongCuHSHS;
	private JLabel lblMaHocSinhTimKiemHSHS;
	private JLabel lblHoSoHocSinh;
	private JLabel lblSoThuTuHSHS;
	private JLabel lblTenHocSinhHSHS;
	private JLabel lblMaHocSinhHSHS;
	private JLabel lblGioiTinhHSHS;
	private JLabel lblNgaySinhHSHS;
	private JLabel lblLopHSHS;
	private JLabel lblDiaChiHSHS;
	private JLabel lblDanTocHSHS;
	private JLabel lblTonGiaoHSHS;
	private JLabel lblTenBoHSHS;
	private JLabel lblTenMeHSHS;
	private JLabel lblNgheNghiepBoHSHS;
	private JLabel lblNgheNghiepMeHSHS;
	private JLabel lblSoDienThoaiBoHSHS;
	private JLabel lblSoDienThoaiMeHSHS;
	
	private JTextField textFieldTimKiemHSHS;
	private JTextField textFieldMaHocSinhHSHS;
	private JTextField textFieldTenHocSinhHSHS;
	private JTextField textFieldSoThuTuHSHS;
	private JComboBox<String> comboBoxGioiTinhHSHS;
	private JTextField textFieldNgaySinhHSHS;
	private JComboBox<String> comboBoxLopHSHS;
	private JTextField textFieldDiaChiHSHS;
	private JTextField textFieldDanTocHSHS;
	private JComboBox<String> comboBoxTonGiaoHSHS;
	private JTextField textFieldTenBoHSHS;
	private JTextField textFieldTenMeHSHS;
	private JTextField textFieldNgheNghiepBoHSHS;
	private JTextField textFieldNgheNghiepMeHSHS;
	private JTextField textFieldSoDienThoaiBoHSHS;
	private JTextField textFieldSoDienThoaiMeHSHS;
	
	private JButton btnTimKiemHSHS;
	private JButton btnCleanTimKiemHSHS;
	private JButton btnLoadHSHS;
	private JButton btnThoatHSHS;
	private JButton btnThemHSHS;
	private JButton btnSuaHSHS;
	private JButton btnXoaHSHS;
	private JButton btnCleanHSHS;
	private JButton btnAZHSHS;
	private JButton btnZAHSHS;
	
	private JTable jTableHSHS;
	private DefaultTableModel tableHSHS;
	private JScrollPane jScrollPaneHSHS;
	private HoSoHocSinhDao hoSoHocSinhDao;

	
	public TabHoSoHocSinh(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		hoSoHocSinhDao = new HoSoHocSinhDao();
		
		lblHoSoHocSinh = new JLabel("HỒ SƠ HỌC SINH");
		lblHoSoHocSinh.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHoSoHocSinh.setForeground(Color.RED);
		lblHoSoHocSinh.setBounds(825, 62, 307, 42);
		add(lblHoSoHocSinh);
		
		panelInputHSHS= new JPanel();
		panelInputHSHS.setBorder(new LineBorder(new Color(102, 255, 0)));
		panelInputHSHS.setBackground(Color.LIGHT_GRAY);
		panelInputHSHS.setBounds(0, 213, 1529, 314);
		add(panelInputHSHS);
		panelInputHSHS.setLayout(null);
		{
			lblSoThuTuHSHS = new JLabel("Số Thứ Tự");
			lblSoThuTuHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSoThuTuHSHS.setBounds(71, 35, 85, 33);
			panelInputHSHS.add(lblSoThuTuHSHS);
		}
		{
			textFieldSoThuTuHSHS = new JTextField();
			textFieldSoThuTuHSHS.setBounds(166, 30, 189, 38);
			panelInputHSHS.add(textFieldSoThuTuHSHS);
			textFieldSoThuTuHSHS.setColumns(10);
		}
		{
			lblMaHocSinhHSHS = new JLabel("Mã Học Sinh");
			lblMaHocSinhHSHS.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblMaHocSinhHSHS.setBounds(71, 100, 85, 38);
			panelInputHSHS.add(lblMaHocSinhHSHS);
		}
		{
			textFieldMaHocSinhHSHS = new JTextField();
			textFieldMaHocSinhHSHS.setBounds(166, 100, 189, 38);
			panelInputHSHS.add(textFieldMaHocSinhHSHS);
			textFieldMaHocSinhHSHS.setColumns(10);
		}
		{
			lblTenHocSinhHSHS = new JLabel("Tên Học Sinh");
			lblTenHocSinhHSHS.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTenHocSinhHSHS.setBounds(71, 166, 85, 38);
			panelInputHSHS.add(lblTenHocSinhHSHS);
		}
		{
			textFieldTenHocSinhHSHS = new JTextField();
			textFieldTenHocSinhHSHS.setBounds(166, 166, 189, 38);
			panelInputHSHS.add(textFieldTenHocSinhHSHS);
			textFieldTenHocSinhHSHS.setColumns(10);
		}
		{
			lblGioiTinhHSHS = new JLabel("Giới Tính");
			lblGioiTinhHSHS.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblGioiTinhHSHS.setBounds(71, 231, 85, 36);
			panelInputHSHS.add(lblGioiTinhHSHS);
		}
		
		comboBoxGioiTinhHSHS = new JComboBox<String>();
		comboBoxGioiTinhHSHS.setBounds(166, 229, 189, 38);
		comboBoxGioiTinhHSHS.addItem("Nam");
		comboBoxGioiTinhHSHS.addItem("Nữ");
		panelInputHSHS.add(comboBoxGioiTinhHSHS);
		
		lblNgaySinhHSHS= new JLabel("Ngày Sinh");
		lblNgaySinhHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgaySinhHSHS.setBounds(420, 35, 94, 26);
		panelInputHSHS.add(lblNgaySinhHSHS);
		{
			textFieldNgaySinhHSHS = new JTextField();
			textFieldNgaySinhHSHS.setBounds(524, 30, 189, 38);
			panelInputHSHS.add(textFieldNgaySinhHSHS);
			textFieldNgaySinhHSHS.setColumns(10);
		}
		{
			lblLopHSHS = new JLabel("Lớp");
			lblLopHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblLopHSHS.setBounds(420, 100, 76, 38);
			panelInputHSHS.add(lblLopHSHS);
		}
		{
			comboBoxLopHSHS = new JComboBox<String>();
			comboBoxLopHSHS.setBounds(524, 101, 189, 38);
			comboBoxLopHSHS.addItem("10A1");
			comboBoxLopHSHS.addItem("10A2");
			comboBoxLopHSHS.addItem("10A3");
			comboBoxLopHSHS.addItem("10A4");
			comboBoxLopHSHS.addItem("10A5");
			comboBoxLopHSHS.addItem("10A6");
			comboBoxLopHSHS.addItem("10A7");
			comboBoxLopHSHS.addItem("10A8");
			comboBoxLopHSHS.addItem("10A9");
			comboBoxLopHSHS.addItem("10A10");
			comboBoxLopHSHS.addItem("11A1");
			comboBoxLopHSHS.addItem("11A2");
			comboBoxLopHSHS.addItem("11A3");
			comboBoxLopHSHS.addItem("11A4");
			comboBoxLopHSHS.addItem("11A5");
			comboBoxLopHSHS.addItem("11A6");
			comboBoxLopHSHS.addItem("11A7");
			comboBoxLopHSHS.addItem("11A8");
			comboBoxLopHSHS.addItem("11A9");
			comboBoxLopHSHS.addItem("11A10");
			comboBoxLopHSHS.addItem("12A1");
			comboBoxLopHSHS.addItem("12A2");
			comboBoxLopHSHS.addItem("12A3");
			comboBoxLopHSHS.addItem("12A4");
			comboBoxLopHSHS.addItem("12A5");
			comboBoxLopHSHS.addItem("12A6");
			comboBoxLopHSHS.addItem("12A7");
			comboBoxLopHSHS.addItem("12A8");
			comboBoxLopHSHS.addItem("12A9");
			comboBoxLopHSHS.addItem("12A10");
			panelInputHSHS.add(comboBoxLopHSHS);
		}
		{
			lblDiaChiHSHS = new JLabel("Địa Chỉ");
			lblDiaChiHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDiaChiHSHS.setBounds(420, 166, 94, 38);
			panelInputHSHS.add(lblDiaChiHSHS);
		}
		{
			textFieldDiaChiHSHS= new JTextField();
			textFieldDiaChiHSHS.setBounds(524, 167, 189, 38);
			panelInputHSHS.add(textFieldDiaChiHSHS);
			textFieldDiaChiHSHS.setColumns(10);
		}
		{
			lblDanTocHSHS = new JLabel("Dân Tộc");
			lblDanTocHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDanTocHSHS.setBounds(420, 231, 76, 36);
			panelInputHSHS.add(lblDanTocHSHS);
		}
		{
			textFieldDanTocHSHS = new JTextField();
			textFieldDanTocHSHS.setBounds(524, 231, 189, 36);
			panelInputHSHS.add(textFieldDanTocHSHS);
			textFieldDanTocHSHS.setColumns(10);
		}
		{
			lblTonGiaoHSHS = new JLabel("Tôn Giáo");
			lblTonGiaoHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTonGiaoHSHS.setBounds(791, 30, 94, 38);
			panelInputHSHS.add(lblTonGiaoHSHS);
		}
		{
			comboBoxTonGiaoHSHS = new JComboBox<String>();
			comboBoxTonGiaoHSHS.setBounds(909, 30, 189, 38);
			comboBoxTonGiaoHSHS.addItem("Có");
			comboBoxTonGiaoHSHS.addItem("Không");
			panelInputHSHS.add(comboBoxTonGiaoHSHS);
		}
		{
			lblTenBoHSHS = new JLabel("Tên Bố");
			lblTenBoHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTenBoHSHS.setBounds(791, 100, 94, 38);
			panelInputHSHS.add(lblTenBoHSHS);
		}
		{
			textFieldTenBoHSHS = new JTextField();
			textFieldTenBoHSHS.setBounds(909, 100, 189, 38);
			panelInputHSHS.add(textFieldTenBoHSHS);
			textFieldTenBoHSHS.setColumns(10);
		}
		{
			lblTenMeHSHS = new JLabel("Tên Mẹ");
			lblTenMeHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTenMeHSHS.setBounds(791, 166, 94, 38);
			panelInputHSHS.add(lblTenMeHSHS);
		}
		{
			textFieldTenMeHSHS = new JTextField();
			textFieldTenMeHSHS.setBounds(909, 166, 189, 38);
			panelInputHSHS.add(textFieldTenMeHSHS);
			textFieldTenMeHSHS.setColumns(10);
		}
		{
			lblNgheNghiepBoHSHS = new JLabel("Nghề Nghiệp Bố");
			lblNgheNghiepBoHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNgheNghiepBoHSHS.setBounds(791, 231, 122, 36);
			panelInputHSHS.add(lblNgheNghiepBoHSHS);
		}
		{
			textFieldNgheNghiepBoHSHS = new JTextField();
			textFieldNgheNghiepBoHSHS.setBounds(909, 231, 189, 36);
			panelInputHSHS.add(textFieldNgheNghiepBoHSHS);
			textFieldNgheNghiepBoHSHS.setColumns(10);
		}
		{
			lblNgheNghiepMeHSHS = new JLabel("Nghề Nghiệp Mẹ");
			lblNgheNghiepMeHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNgheNghiepMeHSHS.setBounds(1176, 30, 116, 38);
			panelInputHSHS.add(lblNgheNghiepMeHSHS);
		}
		{
			textFieldNgheNghiepMeHSHS = new JTextField();
			textFieldNgheNghiepMeHSHS.setBounds(1301, 30, 189, 38);
			panelInputHSHS.add(textFieldNgheNghiepMeHSHS);
			textFieldNgheNghiepMeHSHS.setColumns(10);
		}
		{
			lblSoDienThoaiBoHSHS = new JLabel("SDT Bố");
			lblSoDienThoaiBoHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSoDienThoaiBoHSHS.setBounds(1176, 100, 102, 38);
			panelInputHSHS.add(lblSoDienThoaiBoHSHS);
		}
		{
			textFieldSoDienThoaiBoHSHS = new JTextField();
			textFieldSoDienThoaiBoHSHS.setBounds(1301, 100, 189, 38);
			panelInputHSHS.add(textFieldSoDienThoaiBoHSHS);
			textFieldSoDienThoaiBoHSHS.setColumns(10);
		}
		{
			lblSoDienThoaiMeHSHS = new JLabel("SDT Mẹ");
			lblSoDienThoaiMeHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSoDienThoaiMeHSHS.setBounds(1176, 166, 102, 38);
			panelInputHSHS.add(lblSoDienThoaiMeHSHS);
		}
		{
			textFieldSoDienThoaiMeHSHS = new JTextField();
			textFieldSoDienThoaiMeHSHS.setBounds(1301, 166, 189, 38);
			panelInputHSHS.add(textFieldSoDienThoaiMeHSHS);
			textFieldSoDienThoaiMeHSHS.setColumns(10);
		}
		{
			panelCongCuHSHS = new JPanel();
			panelCongCuHSHS.setBorder(new LineBorder(new Color(51, 255, 0)));
			panelCongCuHSHS.setBackground(Color.LIGHT_GRAY);
			panelCongCuHSHS.setBounds(1536, 213, 363, 314);
			add(panelCongCuHSHS);
			panelCongCuHSHS.setLayout(null);
			
			btnThemHSHS = new JButton("Thêm");
			btnThemHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnThemHSHS.setIcon(new ImageIcon("add.png"));
			btnThemHSHS.setBounds(44, 57, 132, 45);
			btnThemHSHS.addActionListener(this);
			panelCongCuHSHS.add(btnThemHSHS);
			
			btnSuaHSHS = new JButton("Sửa");
			btnSuaHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSuaHSHS.setIcon(new ImageIcon("update.png"));
			btnSuaHSHS.setBounds(201, 57, 132, 45);
			btnSuaHSHS.addActionListener(this);
			panelCongCuHSHS.add(btnSuaHSHS);
			
			btnXoaHSHS = new JButton("Xóa");
			btnXoaHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnXoaHSHS.setIcon(new ImageIcon("delete.png"));
			btnXoaHSHS.setBounds(44, 135, 132, 45);
			btnXoaHSHS.addActionListener(this);
			panelCongCuHSHS.add(btnXoaHSHS);
			
			btnCleanHSHS= new JButton("Clean");
			btnCleanHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCleanHSHS.setIcon(new ImageIcon("clean.png"));
			btnCleanHSHS.setBounds(201, 136, 132, 45);
			btnCleanHSHS.addActionListener(this);
			panelCongCuHSHS.add(btnCleanHSHS);
			
			btnAZHSHS = new JButton("A -Z");
			btnAZHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAZHSHS.setIcon(new ImageIcon("AZ.png"));
			btnAZHSHS.setBounds(44, 214, 132, 45);
			btnAZHSHS.addActionListener(this);
			panelCongCuHSHS.add(btnAZHSHS);
			
			btnZAHSHS = new JButton("Z - A");
			btnZAHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnZAHSHS.setIcon(new ImageIcon("ZA.png"));
			btnZAHSHS.setBounds(201, 214, 132, 45);
			btnZAHSHS.addActionListener(this);
			panelCongCuHSHS.add(btnZAHSHS);
		}
		tableHSHS = new DefaultTableModel();
		tableHSHS.addColumn("Stt");
		tableHSHS.addColumn("Mã Sinh Viên");
		tableHSHS.addColumn("Tên Sinh Viên");
		tableHSHS.addColumn("Giới tính");
		tableHSHS.addColumn("Ngày sinh");
		tableHSHS.addColumn("Lớp");
		tableHSHS.addColumn("Địa chỉ");
		tableHSHS.addColumn("Dân tộc");
		tableHSHS.addColumn("Tôn giáo");
		tableHSHS.addColumn("Tên bố");
		tableHSHS.addColumn("Tên mẹ");
		tableHSHS.addColumn("Nghề nghiệp bố");
		tableHSHS.addColumn("Nghề nghiệp mẹ");
		tableHSHS.addColumn("Số điện thoại bố");
		tableHSHS.addColumn("Số điện thoại mẹ");
		jTableHSHS= new JTable(tableHSHS);
		TableColumnModel columnModelHSHS = jTableHSHS.getColumnModel();
		columnModelHSHS.getColumn(0).setPreferredWidth(10);	
		columnModelHSHS.getColumn(1).setPreferredWidth(50);
		columnModelHSHS.getColumn(2).setPreferredWidth(150);
		columnModelHSHS.getColumn(3).setPreferredWidth(50);
		columnModelHSHS.getColumn(4).setPreferredWidth(100);
		columnModelHSHS.getColumn(5).setPreferredWidth(50);
		columnModelHSHS.getColumn(6).setPreferredWidth(200);
		columnModelHSHS.getColumn(7).setPreferredWidth(50);
		columnModelHSHS.getColumn(8).setPreferredWidth(50);
		columnModelHSHS.getColumn(9).setPreferredWidth(100);
		columnModelHSHS.getColumn(10).setPreferredWidth(100);
		columnModelHSHS.getColumn(11).setPreferredWidth(70);
		columnModelHSHS.getColumn(12).setPreferredWidth(70);
		columnModelHSHS.getColumn(13).setPreferredWidth(70);
		columnModelHSHS.getColumn(14).setPreferredWidth(70);
		jTableHSHS.addMouseListener(this);
		jScrollPaneHSHS = new JScrollPane(jTableHSHS);
		jScrollPaneHSHS.setBounds(0, 530, 1899, 410);
		add(jScrollPaneHSHS);
		
		{
			lblMaHocSinhTimKiemHSHS = new JLabel("Mã Học Sinh");
			lblMaHocSinhTimKiemHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblMaHocSinhTimKiemHSHS.setBounds(614, 141, 126, 36);
			add(lblMaHocSinhTimKiemHSHS);
		}
		{
			textFieldTimKiemHSHS = new JTextField();
			textFieldTimKiemHSHS.setBounds(741, 141, 217, 36);
			add(textFieldTimKiemHSHS);
			textFieldTimKiemHSHS.setColumns(10);
		}
		{
			btnTimKiemHSHS = new JButton("Tìm Kiếm");
			btnTimKiemHSHS.setBounds(994, 141, 138, 36);
//			getRootPane().setDefaultButton(btnTimKiemHSHS);
			btnTimKiemHSHS.setIcon(new ImageIcon("timkiem.png"));
			btnTimKiemHSHS.addActionListener(this);
			add(btnTimKiemHSHS);
		}
		{
			btnCleanTimKiemHSHS = new JButton("Clean");
			btnCleanTimKiemHSHS.setBounds(1156, 141, 104, 36);
			btnCleanTimKiemHSHS.setIcon(new ImageIcon("clean.png"));
			btnCleanTimKiemHSHS.addActionListener(this);
			add(btnCleanTimKiemHSHS);
		}
		{
			btnLoadHSHS = new JButton("Load");
			btnLoadHSHS.setBounds(1280, 141, 104, 36);
			btnLoadHSHS.setIcon(new ImageIcon("load.png"));
			btnLoadHSHS.addActionListener(this);
			add(btnLoadHSHS);
		}
		{
			btnThoatHSHS = new JButton("Thoát");
			btnThoatHSHS.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnThoatHSHS.setIcon(new ImageIcon("thoat.png"));
			btnThoatHSHS.setBounds(1691, 62, 118, 36);
			btnThoatHSHS.addActionListener(this);
			add(btnThoatHSHS);
		}
		loadDataforTableHSHS();
	}
	
	public void loadDataforTableHSHS() {
		tableHSHS.setRowCount(0);
		hoSoHocSinhDao = new HoSoHocSinhDao();
		List<HoSoHocSinh> listHoSoHocSinh = hoSoHocSinhDao.getAllHoSoHocSinh();
		for(HoSoHocSinh hoSoHocSinh : listHoSoHocSinh) {
			tableHSHS.addRow(new String[] {"" + hoSoHocSinh.getSoThuTu(),hoSoHocSinh.getMaHS(),hoSoHocSinh.getTenHS(),hoSoHocSinh.getGioiTinh(),hoSoHocSinh.getNgaySinh(),hoSoHocSinh.getLop(),hoSoHocSinh.getDiaChi(),hoSoHocSinh.getDanToc(),
					hoSoHocSinh.getTonGiao(),hoSoHocSinh.getTenBo(),hoSoHocSinh.getTenMe(),hoSoHocSinh.getNgheNghiepBo(),hoSoHocSinh.getNgheNghiepMe(),hoSoHocSinh.getSoDienThoaiBo(),hoSoHocSinh.getSoDienThoaiMe()});
			
		}
	}
	public void mouseClicked(MouseEvent e) {
		textFieldSoThuTuHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 0));
		textFieldMaHocSinhHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 1));
		textFieldTenHocSinhHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 2));
		comboBoxGioiTinhHSHS.setSelectedItem(jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 3));
		textFieldNgaySinhHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 4));
		comboBoxLopHSHS.setSelectedItem(jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 5));
		textFieldDiaChiHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 6));
		textFieldDanTocHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 7));
		comboBoxTonGiaoHSHS.setSelectedItem(jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 8));
		textFieldTenBoHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 9));
		textFieldTenMeHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 10));
		textFieldNgheNghiepBoHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 11));
		textFieldNgheNghiepMeHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 12));
		textFieldSoDienThoaiBoHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 13));
		textFieldSoDienThoaiMeHSHS.setText((String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(), 14));
		textFieldSoThuTuHSHS.setEditable(false);
		textFieldMaHocSinhHSHS.setEditable(false);
		
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
		if(action == btnTimKiemHSHS) {
			timKiemHSHS();
		}
		else if(action == btnLoadHSHS) {
			loadDataforTableHSHS();
		}
		else if(action == btnCleanTimKiemHSHS) {
			textFieldTimKiemHSHS.setText("");
		}
		else if(action == btnThoatHSHS) {
			int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
				jFrame.dispose();
			}
		}
		else if(action == btnThemHSHS) {
			if(textFieldSoThuTuHSHS.getText().equals("")||textFieldMaHocSinhHSHS.getText().equals("")||textFieldTenHocSinhHSHS.getText().equals("")||textFieldNgaySinhHSHS.getText().equals("")||
					textFieldDiaChiHSHS.getText().equals("")||textFieldDanTocHSHS.getText().equals("")||textFieldTenBoHSHS.getText().equals("")||textFieldTenMeHSHS.getText().equals("")||
					textFieldNgheNghiepBoHSHS.getText().equals("")||textFieldNgheNghiepMeHSHS.getText().equals("")||textFieldSoDienThoaiBoHSHS.getText().equals("")||textFieldSoDienThoaiMeHSHS.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy nhập đầy đủ thông tin");
			}
			else {
				addHSHS();
				loadDataforTableHSHS();
			
			}
		}
		else if(action == btnSuaHSHS) {
			if(textFieldSoThuTuHSHS.getText().equals("")||textFieldMaHocSinhHSHS.getText().equals("")||textFieldTenHocSinhHSHS.getText().equals("")||textFieldNgaySinhHSHS.getText().equals("")||
					textFieldDiaChiHSHS.getText().equals("")||textFieldDanTocHSHS.getText().equals("")||textFieldTenBoHSHS.getText().equals("")||textFieldTenMeHSHS.getText().equals("")||
					textFieldNgheNghiepBoHSHS.getText().equals("")||textFieldNgheNghiepMeHSHS.getText().equals("")||textFieldSoDienThoaiBoHSHS.getText().equals("")||textFieldSoDienThoaiMeHSHS.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy chọn học sinh trong bảng để sửa");
			}
			else {
				updateHSHS();
				loadDataforTableHSHS();
				JOptionPane.showMessageDialog(null, "bạn đã sửa hồ sơ học sinh thành công");
			}
		}
		else if(action == btnXoaHSHS) {
			deleteHSHS();
			loadDataforTableHSHS();
		}
		else if (action == btnCleanHSHS) {
			cleanHSHS();
		}
		else if(action == btnAZHSHS) {
			tableHSHS.setRowCount(0);
			List<HoSoHocSinh> listHoSoHocSinh = hoSoHocSinhDao.showTableByAZ();
			for(HoSoHocSinh hoSoHocSinh : listHoSoHocSinh) {
				tableHSHS.addRow(new String[] {"" + hoSoHocSinh.getSoThuTu(),hoSoHocSinh.getMaHS(),hoSoHocSinh.getTenHS(),hoSoHocSinh.getGioiTinh(),hoSoHocSinh.getNgaySinh(),hoSoHocSinh.getLop(),hoSoHocSinh.getDiaChi(),hoSoHocSinh.getDanToc(),
						hoSoHocSinh.getTonGiao(),hoSoHocSinh.getTenBo(),hoSoHocSinh.getTenMe(),hoSoHocSinh.getNgheNghiepBo(),hoSoHocSinh.getNgheNghiepMe(),hoSoHocSinh.getSoDienThoaiBo(),hoSoHocSinh.getSoDienThoaiMe()});
			}
		}
		else if(action == btnZAHSHS) {
			tableHSHS.setRowCount(0);
			List<HoSoHocSinh> listHoSoHocSinh = hoSoHocSinhDao.showTableByZA();
			for(HoSoHocSinh hoSoHocSinh : listHoSoHocSinh) {
				tableHSHS.addRow(new String[] {"" + hoSoHocSinh.getSoThuTu(),hoSoHocSinh.getMaHS(),hoSoHocSinh.getTenHS(),hoSoHocSinh.getGioiTinh(),hoSoHocSinh.getNgaySinh(),hoSoHocSinh.getLop(),hoSoHocSinh.getDiaChi(),hoSoHocSinh.getDanToc(),
						hoSoHocSinh.getTonGiao(),hoSoHocSinh.getTenBo(),hoSoHocSinh.getTenMe(),hoSoHocSinh.getNgheNghiepBo(),hoSoHocSinh.getNgheNghiepMe(),hoSoHocSinh.getSoDienThoaiBo(),hoSoHocSinh.getSoDienThoaiMe()});
			}
		}
		
	}
	private void timKiemHSHS() {
		tableHSHS.setRowCount(0);
		String mahs = textFieldTimKiemHSHS.getText();
		HoSoHocSinh hoSoHocSinh = new HoSoHocSinh();
		hoSoHocSinh = hoSoHocSinhDao.getHoSoHocSinhByMaHS(mahs);
		if(mahs.equals(hoSoHocSinh.getMaHS())) {
			tableHSHS.addRow(new String[] {"" + hoSoHocSinh.getSoThuTu(),hoSoHocSinh.getMaHS(),hoSoHocSinh.getTenHS(),hoSoHocSinh.getGioiTinh(),hoSoHocSinh.getNgaySinh(),hoSoHocSinh.getLop(),hoSoHocSinh.getDiaChi(),hoSoHocSinh.getDanToc(),
					hoSoHocSinh.getTonGiao(),hoSoHocSinh.getTenBo(),hoSoHocSinh.getTenMe(),hoSoHocSinh.getNgheNghiepBo(),hoSoHocSinh.getNgheNghiepMe(),hoSoHocSinh.getSoDienThoaiBo(),hoSoHocSinh.getSoDienThoaiMe()});
		}
		else if(mahs.equals("")) {
			JOptionPane.showMessageDialog(null, "bạn hãy nhập mã học sinh để tìm kiếm");
		}
		else if(!mahs.equals(hoSoHocSinh.getMaHS())) {
			JOptionPane.showMessageDialog(null, "mã học sinh không tồn tại trong danh sách");
		}
		
	}
	private void addHSHS() {
		ckeckAddHSHS();
			
	}
	private void ckeckAddHSHS() {
		String stt = textFieldSoThuTuHSHS.getText();
		String mahs = textFieldMaHocSinhHSHS.getText();
		if(hoSoHocSinhDao.checkaddHSHS(mahs, stt)==false) {
			JOptionPane.showMessageDialog(null, "số thứ tự hoặc mã học sinh đã tồn tại");
		}
		else {
			HoSoHocSinh hoSoHocSinh = new HoSoHocSinh();
			hoSoHocSinh.setSoThuTu(textFieldSoThuTuHSHS.getText());
			hoSoHocSinh.setMaHS(textFieldMaHocSinhHSHS.getText());
			hoSoHocSinh.setTenHS(textFieldTenHocSinhHSHS.getText());
			hoSoHocSinh.setGioiTinh((String) comboBoxGioiTinhHSHS.getSelectedItem());
			hoSoHocSinh.setNgaySinh(textFieldNgaySinhHSHS.getText());
			hoSoHocSinh.setLop((String) comboBoxLopHSHS.getSelectedItem());
			hoSoHocSinh.setDiaChi(textFieldDiaChiHSHS.getText());
			hoSoHocSinh.setDanToc(textFieldDanTocHSHS.getText());
			hoSoHocSinh.setTonGiao((String) comboBoxTonGiaoHSHS.getSelectedItem());
			hoSoHocSinh.setTenBo(textFieldTenBoHSHS.getText());
			hoSoHocSinh.setTenMe(textFieldTenMeHSHS.getText());
			hoSoHocSinh.setNgheNghiepBo(textFieldNgheNghiepBoHSHS.getText());
			hoSoHocSinh.setNgheNghiepMe(textFieldNgheNghiepMeHSHS.getText());
			hoSoHocSinh.setSoDienThoaiBo(textFieldSoDienThoaiBoHSHS.getText());
			hoSoHocSinh.setSoDienThoaiMe(textFieldSoDienThoaiMeHSHS.getText());
			hoSoHocSinhDao.addHoSoHocSinh(hoSoHocSinh);
			JOptionPane.showMessageDialog(null, "bạn đã thêm hồ sơ học sinh thành công");
			
		}
	}
	private void updateHSHS() {
		HoSoHocSinh hoSoHocSinh = new HoSoHocSinh();
		hoSoHocSinh.setSoThuTu(textFieldSoThuTuHSHS.getText());
		hoSoHocSinh.setMaHS(textFieldMaHocSinhHSHS.getText());
		hoSoHocSinh.setTenHS(textFieldTenHocSinhHSHS.getText());
		hoSoHocSinh.setGioiTinh((String) comboBoxGioiTinhHSHS.getSelectedItem());
		hoSoHocSinh.setNgaySinh(textFieldNgaySinhHSHS.getText());
		hoSoHocSinh.setLop((String) comboBoxLopHSHS.getSelectedItem());
		hoSoHocSinh.setDiaChi(textFieldDiaChiHSHS.getText());
		hoSoHocSinh.setDanToc(textFieldDanTocHSHS.getText());
		hoSoHocSinh.setTonGiao((String) comboBoxTonGiaoHSHS.getSelectedItem());
		hoSoHocSinh.setTenBo(textFieldTenBoHSHS.getText());
		hoSoHocSinh.setTenMe(textFieldTenMeHSHS.getText());
		hoSoHocSinh.setNgheNghiepBo(textFieldNgheNghiepBoHSHS.getText());
		hoSoHocSinh.setNgheNghiepMe(textFieldNgheNghiepMeHSHS.getText());
		hoSoHocSinh.setSoDienThoaiBo(textFieldSoDienThoaiBoHSHS.getText());
		hoSoHocSinh.setSoDienThoaiMe(textFieldSoDienThoaiMeHSHS.getText());
		hoSoHocSinhDao.updateHoSoHocSinh(hoSoHocSinh);
		
	}
	private void deleteHSHS() {
		String mahs = (String) jTableHSHS.getValueAt(jTableHSHS.getSelectedRow(),1);
		int choose = JOptionPane.showConfirmDialog(null,"bạn có muốn xóa hồ sơ học sinh có mã "+ mahs+" không?","Xóa",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			hoSoHocSinhDao.deleteHoSoHocSinh(mahs);
			JOptionPane.showMessageDialog(null,"bạn đã xóa hồ sơ học sinh có mã " + mahs +" thành công");
		}
	}
	private void cleanHSHS() {
		textFieldSoThuTuHSHS.setText("");
		textFieldMaHocSinhHSHS.setText("");
		textFieldTenHocSinhHSHS.setText("");
		textFieldNgaySinhHSHS.setText("");
		textFieldDiaChiHSHS.setText("");
		textFieldDanTocHSHS.setText("");
		textFieldTenBoHSHS.setText("");
		textFieldTenMeHSHS.setText("");
		textFieldNgheNghiepBoHSHS.setText("");
		textFieldNgheNghiepMeHSHS.setText("");
		textFieldSoDienThoaiBoHSHS.setText("");
		textFieldSoDienThoaiMeHSHS.setText("");
		textFieldSoThuTuHSHS.setEditable(true);
		textFieldMaHocSinhHSHS.setEditable(true);
	}

}
