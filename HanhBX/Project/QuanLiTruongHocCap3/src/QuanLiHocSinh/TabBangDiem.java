package QuanLiHocSinh;

import java.awt.event.MouseListener;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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

import Model.Dao.BangDiemDao;
import Model.bean.BangDiem;
import TrangChu.TrangChu;

public class TabBangDiem extends JPanel implements ActionListener,MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
	private JPanel panelinputBD;
	private JPanel panelCongCuBD;
	private JLabel lblTimKiemBD;
	private JLabel lblBangDiem;
	private JLabel lblMaHocSinhBD;
	private JLabel lblTenHocSinhBD;
	private JLabel lblSoThuTuBD;
	private JLabel lblLopBD;
	private JLabel lblMonToanBD;
	private JLabel lblMonVatLiBD;
	private JLabel lblMonHoaHocBD;
	private JLabel lblMonSinhHocBD;
	private JLabel lblMonLichSuBD;
	private JLabel lblMonDiaLiBD;
	private JLabel lblMonGDCDBD;
	private JLabel lblMonCongNgheBD;
	private JLabel lblMonTiengAnhBD;
	private JLabel lblMonNguVanBD;
	private JLabel lblMonTheDucBD;
	private JLabel lblMonGDQPBD;
	private JLabel lblMonTinHocBD;
	private JLabel lblSapXepBD;
	
	private JTable jTableBangDiem;
	private DefaultTableModel tableBangDiem;
	private JScrollPane jScrollPaneBangDiem;
	
	private JButton btnTimKiemBD;
	private JButton btnThemBD;
	private JButton btnSuaBD;
	private JButton btnXoaBD;
	private JButton btnCleanBD;
	private JButton btnInBD;
	private JButton btnThoatBD;
	private JButton btnLoadBD;
	private JButton btnAZBD;
	private JButton btnZABD;
	private JButton btnCleanTimKiemBD;
	
	private JTextField textFieldTimKiemBD;
	private JTextField textFieldSoThuTuBD;
	private JTextField textFieldMaHocSinhBD;
	private JTextField textFieldTenHocSinhBD;
	private JComboBox<String> comboBoxLopBD;
	private JTextField textFieldMonToanBD;
	private JTextField textFieldMonVatLiBD;
	private JTextField textFieldMonHoaHocBD;
	private JTextField textFieldMonSinhHocBD;
	private JTextField textFieldMonLichSuBD;
	private JTextField textFieldMonDiaLiBD;
	private JTextField textFieldMonGDCDBD;
	private JTextField textFieldMonCongNgheBD;
	private JTextField textFieldMonNguVanBD;
	private JTextField textFieldMonTinHocBD;
	private JTextField textFieldMonTiengAnhBD;
	private JTextField textFieldMonTheDucBD;
	private JTextField textFieldMonGDQPBD;
	
	private BangDiemDao bangDiemDao;
	public TabBangDiem(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		bangDiemDao = new BangDiemDao();
		{
			lblBangDiem = new JLabel("BẢNG ĐIỂM");
			lblBangDiem.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblBangDiem.setForeground(Color.RED);
			lblBangDiem.setBounds(900, 50, 337, 37);
			add(lblBangDiem);
		}
		{
			 tableBangDiem = new DefaultTableModel();
			 tableBangDiem.addColumn("Số thứ tự");
			 tableBangDiem.addColumn("Mã sinh viên");
			 tableBangDiem.addColumn("Tên sinh viên");
			 tableBangDiem.addColumn("lớp");
			 tableBangDiem.addColumn("KT 1tiết Toán");
			 tableBangDiem.addColumn("KT 1tiết Vật lí");
			 tableBangDiem.addColumn("KT 1tiết Hóa Học");
			 tableBangDiem.addColumn("KT 1tiết Sinh Học");
			 tableBangDiem.addColumn("KT 1tiết Lịch Sử");
			 tableBangDiem.addColumn("KT 1tiết Địa Lí");
			 tableBangDiem.addColumn("KT 1tiết GDCD");
			 tableBangDiem.addColumn("KT 1tiết CN");
			 tableBangDiem.addColumn("KT 1tiết Tin Học");
			 tableBangDiem.addColumn("KT 1tiết Ngữ Văn");
			 tableBangDiem.addColumn("KT 1tiết Tiếng Anh");
			 tableBangDiem.addColumn("KT 1tiết QDQP");
			 tableBangDiem.addColumn("KT 1tiết Thể Dục");
			 jTableBangDiem = new JTable(tableBangDiem);
			 TableColumnModel columnModelBD = jTableBangDiem.getColumnModel();
			 columnModelBD.getColumn(0).setPreferredWidth(10);	
			 columnModelBD.getColumn(1).setPreferredWidth(50);
			 columnModelBD.getColumn(2).setPreferredWidth(150);
			 columnModelBD.getColumn(3).setPreferredWidth(50);
			 columnModelBD.getColumn(4).setPreferredWidth(100);
			 columnModelBD.getColumn(5).setPreferredWidth(50);
			 columnModelBD.getColumn(6).setPreferredWidth(70);
			 columnModelBD.getColumn(7).setPreferredWidth(70);
			 columnModelBD.getColumn(8).setPreferredWidth(70);
			 columnModelBD.getColumn(9).setPreferredWidth(100);
			 columnModelBD.getColumn(10).setPreferredWidth(100);
			 columnModelBD.getColumn(11).setPreferredWidth(70);
			 columnModelBD.getColumn(12).setPreferredWidth(70);
			 columnModelBD.getColumn(13).setPreferredWidth(70);
			 columnModelBD.getColumn(14).setPreferredWidth(70);
			 columnModelBD.getColumn(15).setPreferredWidth(70);
			 columnModelBD.getColumn(16).setPreferredWidth(70);
			 jTableBangDiem.addMouseListener(this);
			 jScrollPaneBangDiem = new JScrollPane(jTableBangDiem);
			 jScrollPaneBangDiem.setBounds(0, 116, 1900, 530);
			 add(jScrollPaneBangDiem);

		}
		{
			panelinputBD = new JPanel();
			panelinputBD.setBackground(Color.LIGHT_GRAY);
			panelinputBD.setBounds(0, 650, 1158, 300);
			add(panelinputBD);
			panelinputBD.setLayout(null);
			{
				lblSoThuTuBD = new JLabel("Số Thứ Tự");
				lblSoThuTuBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblSoThuTuBD.setBounds(27, 31, 80, 14);
				panelinputBD.add(lblSoThuTuBD);
			}
			{
				textFieldSoThuTuBD = new JTextField();
				textFieldSoThuTuBD.setBounds(138, 26, 100, 26);
				panelinputBD.add(textFieldSoThuTuBD);
				textFieldSoThuTuBD.setColumns(10);
			}
			{
				lblMaHocSinhBD = new JLabel("Mã Học Sinh");
				lblMaHocSinhBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMaHocSinhBD.setBounds(27, 75, 80, 14);
				panelinputBD.add(lblMaHocSinhBD);
			}
			{
				textFieldMaHocSinhBD = new JTextField();
				textFieldMaHocSinhBD.setBounds(138, 70, 101, 26);
				panelinputBD.add(textFieldMaHocSinhBD);
				textFieldMaHocSinhBD.setColumns(10);
			}
			{
				lblTenHocSinhBD = new JLabel("Tên Học Sinh");
				lblTenHocSinhBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblTenHocSinhBD.setBounds(27, 117, 91, 26);
				panelinputBD.add(lblTenHocSinhBD);
			}
			{
				textFieldTenHocSinhBD = new JTextField();
				textFieldTenHocSinhBD.setBounds(138, 118, 128, 26);
				panelinputBD.add(textFieldTenHocSinhBD);
				textFieldTenHocSinhBD.setColumns(10);
			}
			{
				lblMonToanBD = new JLabel("Toán");
				lblMonToanBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonToanBD.setBounds(309, 28, 66, 20);
				panelinputBD.add(lblMonToanBD);
			}
			{
				textFieldMonToanBD = new JTextField();
				textFieldMonToanBD.setBounds(385, 26, 86, 26);
				panelinputBD.add(textFieldMonToanBD);
				textFieldMonToanBD.setColumns(10);
			}
			{
				lblMonVatLiBD = new JLabel("Vật Lí");
				lblMonVatLiBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonVatLiBD.setBounds(309, 91, 46, 14);
				panelinputBD.add(lblMonVatLiBD);
			}
			{
				textFieldMonVatLiBD = new JTextField();
				textFieldMonVatLiBD.setBounds(385, 86, 86, 26);
				panelinputBD.add(textFieldMonVatLiBD);
				textFieldMonVatLiBD.setColumns(10);
			}
			{
				lblMonHoaHocBD = new JLabel("Hóa Học");
				lblMonHoaHocBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonHoaHocBD.setBounds(309, 146, 68, 30);
				panelinputBD.add(lblMonHoaHocBD);
			}
			{
				textFieldMonHoaHocBD = new JTextField();
				textFieldMonHoaHocBD.setBounds(385, 150, 86, 24);
				panelinputBD.add(textFieldMonHoaHocBD);
				textFieldMonHoaHocBD.setColumns(10);
			}
			{
				lblMonSinhHocBD = new JLabel("Sinh Học");
				lblMonSinhHocBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonSinhHocBD.setBounds(532, 31, 66, 14);
				panelinputBD.add(lblMonSinhHocBD);
			}
			{
				textFieldMonSinhHocBD = new JTextField();
				textFieldMonSinhHocBD.setBounds(608, 26, 86, 26);
				panelinputBD.add(textFieldMonSinhHocBD);
				textFieldMonSinhHocBD.setColumns(10);
			}
			{
				lblMonLichSuBD = new JLabel("Lịch Sử");
				lblMonLichSuBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonLichSuBD.setBounds(532, 91, 46, 14);
				panelinputBD.add(lblMonLichSuBD);
			}
			{
				textFieldMonLichSuBD = new JTextField();
				textFieldMonLichSuBD.setBounds(608, 86, 86, 26);
				panelinputBD.add(textFieldMonLichSuBD);
				textFieldMonLichSuBD.setColumns(10);
			}
			{
				lblMonDiaLiBD = new JLabel("Địa Lí");
				lblMonDiaLiBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonDiaLiBD.setBounds(532, 151, 46, 20);
				panelinputBD.add(lblMonDiaLiBD);
			}
			{
				textFieldMonDiaLiBD = new JTextField();
				textFieldMonDiaLiBD.setBounds(608, 150, 86, 24);
				panelinputBD.add(textFieldMonDiaLiBD);
				textFieldMonDiaLiBD.setColumns(10);
			}
			{
				lblMonGDCDBD = new JLabel("GDCD");
				lblMonGDCDBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonGDCDBD.setBounds(745, 31, 46, 14);
				panelinputBD.add(lblMonGDCDBD);
			}
			{
				textFieldMonGDCDBD = new JTextField();
				textFieldMonGDCDBD.setBounds(823, 26, 86, 26);
				panelinputBD.add(textFieldMonGDCDBD);
				textFieldMonGDCDBD.setColumns(10);
			}
			{
				lblMonCongNgheBD = new JLabel("Công Nghệ");
				lblMonCongNgheBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonCongNgheBD.setBounds(745, 85, 80, 26);
				panelinputBD.add(lblMonCongNgheBD);
			}
			{
				textFieldMonCongNgheBD = new JTextField();
				textFieldMonCongNgheBD.setBounds(823, 84, 86, 30);
				panelinputBD.add(textFieldMonCongNgheBD);
				textFieldMonCongNgheBD.setColumns(10);
			}
			{
				lblMonTinHocBD = new JLabel("Tin Học");
				lblMonTinHocBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonTinHocBD.setBounds(745, 155, 46, 14);
				panelinputBD.add(lblMonTinHocBD);
			}
			{
				textFieldMonTinHocBD = new JTextField();
				textFieldMonTinHocBD.setBounds(823, 148, 86, 30);
				panelinputBD.add(textFieldMonTinHocBD);
				textFieldMonTinHocBD.setColumns(10);
			}
			{
				lblMonNguVanBD = new JLabel("Ngữ Văn");
				lblMonNguVanBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonNguVanBD.setBounds(954, 30, 68, 14);
				panelinputBD.add(lblMonNguVanBD);
			}
			{
				textFieldMonNguVanBD = new JTextField();
				textFieldMonNguVanBD.setBounds(1042, 23, 86, 30);
				panelinputBD.add(textFieldMonNguVanBD);
				textFieldMonNguVanBD.setColumns(10);
			}
			{
				lblMonTiengAnhBD = new JLabel("Tiếng Anh");
				lblMonTiengAnhBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonTiengAnhBD.setBounds(954, 80, 68, 14);
				panelinputBD.add(lblMonTiengAnhBD);
			}
			{
				textFieldMonTiengAnhBD = new JTextField();
				textFieldMonTiengAnhBD.setBounds(1042, 70, 86, 30);
				panelinputBD.add(textFieldMonTiengAnhBD);
				textFieldMonTiengAnhBD.setColumns(10);
			}
			{
				lblMonGDQPBD = new JLabel("GDQP");
				lblMonGDQPBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonGDQPBD.setBounds(957, 123, 46, 14);
				panelinputBD.add(lblMonGDQPBD);
			}
			{
				textFieldMonGDQPBD = new JTextField();
				textFieldMonGDQPBD.setBounds(1042, 115, 86, 30);
				panelinputBD.add(textFieldMonGDQPBD);
				textFieldMonGDQPBD.setColumns(10);
			}
			{
				lblMonTheDucBD = new JLabel("Thể Dục");
				lblMonTheDucBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMonTheDucBD.setBounds(954, 165, 68, 14);
				panelinputBD.add(lblMonTheDucBD);
			}
			{
				textFieldMonTheDucBD = new JTextField();
				textFieldMonTheDucBD.setBounds(1042, 160, 86, 26);
				panelinputBD.add(textFieldMonTheDucBD);
				textFieldMonTheDucBD.setColumns(10);
			}
			{
				lblLopBD = new JLabel("Lớp");
				lblLopBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblLopBD.setBounds(27, 170, 46, 14);
				panelinputBD.add(lblLopBD);
			}
			{
				comboBoxLopBD = new JComboBox<String>();
				comboBoxLopBD.setBounds(139, 160, 120, 30);
				panelinputBD.add(comboBoxLopBD);
				comboBoxLopBD.addItem("10A1");
				comboBoxLopBD.addItem("10A2");
				comboBoxLopBD.addItem("10A3");
				comboBoxLopBD.addItem("10A4");
				comboBoxLopBD.addItem("10A5");
				comboBoxLopBD.addItem("10A6");
				comboBoxLopBD.addItem("10A7");
				comboBoxLopBD.addItem("10A8");
				comboBoxLopBD.addItem("10A9");
				comboBoxLopBD.addItem("10A10");
				comboBoxLopBD.addItem("11A1");
				comboBoxLopBD.addItem("11A2");
				comboBoxLopBD.addItem("11A3");
				comboBoxLopBD.addItem("11A4");
				comboBoxLopBD.addItem("11A5");
				comboBoxLopBD.addItem("11A6");
				comboBoxLopBD.addItem("11A7");
				comboBoxLopBD.addItem("11A8");
				comboBoxLopBD.addItem("11A9");
				comboBoxLopBD.addItem("11A10");
				comboBoxLopBD.addItem("12A1");
				comboBoxLopBD.addItem("12A2");
				comboBoxLopBD.addItem("12A3");
				comboBoxLopBD.addItem("12A4");
				comboBoxLopBD.addItem("12A5");
				comboBoxLopBD.addItem("12A6");
				comboBoxLopBD.addItem("12A7");
				comboBoxLopBD.addItem("12A8");
				comboBoxLopBD.addItem("12A9");
				comboBoxLopBD.addItem("12A10");
			}
			{
				btnThemBD = new JButton("Thêm");
				btnThemBD.setBounds(200, 220, 130, 39);
				btnThemBD.setIcon(new ImageIcon("add.png"));
				btnThemBD.addActionListener(this);
				panelinputBD.add(btnThemBD);
			}
			{
				btnSuaBD = new JButton("Sửa");
				btnSuaBD.setBounds(400, 220, 130, 39);
				btnSuaBD.setIcon(new ImageIcon("update.png"));
				btnSuaBD.addActionListener(this);
				panelinputBD.add(btnSuaBD);
			}
			{
				btnXoaBD = new JButton("Xóa");
				btnXoaBD.setBounds(600, 220, 130, 39);
				btnXoaBD.setIcon(new ImageIcon("delete.png"));
				btnXoaBD.addActionListener(this);
				panelinputBD.add(btnXoaBD);
			}
			{
				btnCleanBD = new JButton("Clean");
				btnCleanBD.setBounds(800, 220, 130, 39);
				btnCleanBD.setIcon(new ImageIcon("clean.png"));
				btnCleanBD.addActionListener(this);
				panelinputBD.add(btnCleanBD);
			}
		}
		{
			panelCongCuBD = new JPanel();
			panelCongCuBD.setBackground(Color.LIGHT_GRAY);
			panelCongCuBD.setBounds(1168, 650, 730, 300);
			add(panelCongCuBD);
			panelCongCuBD.setLayout(null);
		
			{
				btnInBD = new JButton("In");
				btnInBD.setBounds(550, 130, 120, 80);
				btnInBD.setIcon(new ImageIcon("printer.png"));
				btnInBD.setFont(new Font("Tahoma", Font.BOLD, 16));
				btnInBD.addActionListener(this);
				panelCongCuBD.add(btnInBD);
			}
			{
				lblSapXepBD = new JLabel("Sắp Xếp");
				lblSapXepBD.setForeground(Color.RED);
				lblSapXepBD.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblSapXepBD.setBounds(110, 155, 76, 27);
				panelCongCuBD.add(lblSapXepBD);
			}
			{
				btnAZBD = new JButton("A - Z");
				btnAZBD.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAZBD.setIcon(new ImageIcon("AZ.png"));
				btnAZBD.setBounds(250, 150, 95, 35);
				btnAZBD.addActionListener(this);
				panelCongCuBD.add(btnAZBD);
			}
			{
				btnZABD = new JButton("Z - A");
				btnZABD.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnZABD.setBounds(410,150, 95, 35);
				btnZABD.setIcon(new ImageIcon("ZA.png"));
				btnZABD.addActionListener(this);
				panelCongCuBD.add(btnZABD);
			}
		}
		{
			lblTimKiemBD = new JLabel("Mã Học Sinh");
			lblTimKiemBD.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTimKiemBD.setBounds(55, 69, 86, 14);
			add(lblTimKiemBD);
		}
		{
			textFieldTimKiemBD = new JTextField();
			textFieldTimKiemBD.setBounds(150, 55, 130, 40);
			add(textFieldTimKiemBD);
			textFieldTimKiemBD.setColumns(10);
		}
		{
			btnTimKiemBD = new JButton("Tìm Kiếm");
			btnTimKiemBD.setBounds(302, 55, 115, 40);
//			getRootPane().setDefaultButton(btnTimKiemBD);
			btnTimKiemBD.setIcon(new ImageIcon("timkiem.png"));
			btnTimKiemBD.addActionListener(this);
			add(btnTimKiemBD);
		}
		{
			btnThoatBD = new JButton("Thoát");
			btnThoatBD.setBounds(1600, 50, 115, 40);
			btnThoatBD.setIcon(new ImageIcon("thoat.png"));
			btnThoatBD.addActionListener(this);
			add(btnThoatBD);  
		}
		{
			btnLoadBD = new JButton("Load");
			btnLoadBD.setBounds(540, 55, 100, 40);
			btnLoadBD.setIcon(new ImageIcon("load.png"));
			btnLoadBD.addActionListener(this);
			add(btnLoadBD);
		}
		{
			btnCleanTimKiemBD = new JButton("Clean");
			btnCleanTimKiemBD.setBounds(430, 55, 100, 40);
			btnCleanTimKiemBD.setIcon(new ImageIcon("clean.png"));
			btnCleanTimKiemBD.addActionListener(this);
			add(btnCleanTimKiemBD);
		}
		
		loadDataforTableBD();
	}
	public void loadDataforTableBD() {
		tableBangDiem.setRowCount(0);
		BangDiemDao bangDiemDao = new BangDiemDao();
		List<BangDiem> listBangDiem = bangDiemDao.getAllDiemBD();
		for(BangDiem bangDiem:listBangDiem) {
			tableBangDiem.addRow(new String [] {"" + bangDiem.getSoThuTu(),bangDiem.getMaHS(),bangDiem.getTenHS(),bangDiem.getLop(),bangDiem.getDiemMonToan(), 
					bangDiem.getDiemMonVatLi(),bangDiem.getDiemMonHoaHoc(),bangDiem.getDiemMonSinhHoc(),bangDiem.getDiemMonLichSu(),bangDiem.getDiemMonDiaLi(),
					bangDiem.getDiemMonGDCD(),bangDiem.getDiemMonCongNghe(),bangDiem.getDiemMonTin(),bangDiem.getDiemMonNguVan(),bangDiem.getDiemMonTiengAnh(),
					bangDiem.getDiemMonGDQP(),bangDiem.getDiemMonTheDuc()});
		}
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		textFieldSoThuTuBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 0));
		textFieldMaHocSinhBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 1));
		textFieldTenHocSinhBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 2));
		comboBoxLopBD.setSelectedItem(jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 3));
		textFieldMonToanBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 4));
		textFieldMonVatLiBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 5));
		textFieldMonHoaHocBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 6));
		textFieldMonSinhHocBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 7));
		textFieldMonLichSuBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 8));
		textFieldMonDiaLiBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 9));
		textFieldMonGDCDBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 10));
		textFieldMonCongNgheBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 11));
		textFieldMonTinHocBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 12));
		textFieldMonNguVanBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 13));
		textFieldMonTiengAnhBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 14));
		textFieldMonGDQPBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 15));
		textFieldMonTheDucBD.setText((String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(), 16));
		textFieldMaHocSinhBD.setEnabled(false);
		textFieldSoThuTuBD.setEnabled(false);
		
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
		if(action == btnLoadBD) {
			loadDataforTableBD();
		}
		else if(action == btnTimKiemBD) {
			timKiemDiemBD();
		}
		else if(action == btnCleanTimKiemBD) {
			textFieldTimKiemBD.setText("");
		}
		else if(action == btnThoatBD) {
			int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
				jFrame.dispose();
			}
		}
		else if(action == btnThemBD) {
			if(textFieldSoThuTuBD.getText().equals("")|| textFieldMaHocSinhBD.getText().equals("")|| textFieldTenHocSinhBD.getText().equals("")
					|| textFieldMonToanBD.getText().equals("")|| textFieldMonVatLiBD.getText().equals("")|| textFieldMonHoaHocBD.getText().equals("")
					|| textFieldMonSinhHocBD.getText().equals("")|| textFieldMonLichSuBD.getText().equals("")|| textFieldMonDiaLiBD.getText().equals("")
					|| textFieldMonGDCDBD.getText().equals("")|| textFieldMonCongNgheBD.getText().equals("")|| textFieldMonTinHocBD.getText().equals("")
					|| textFieldMonNguVanBD.getText().equals("")|| textFieldMonTiengAnhBD.getText().equals("")|| textFieldMonGDQPBD.getText().equals("")
					|| textFieldMonTheDucBD.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"bạn hãy nhập đầy đủ thông tin học sinh");
			}
			else {
			addDiemBD();
			loadDataforTableBD();
			
			}
		}
		else if(action == btnSuaBD) {
			if(textFieldSoThuTuBD.getText().equals("")|| textFieldMaHocSinhBD.getText().equals("")|| textFieldTenHocSinhBD.getText().equals("")
					|| textFieldMonToanBD.getText().equals("")|| textFieldMonVatLiBD.getText().equals("")|| textFieldMonHoaHocBD.getText().equals("")
					|| textFieldMonSinhHocBD.getText().equals("")|| textFieldMonLichSuBD.getText().equals("")|| textFieldMonDiaLiBD.getText().equals("")
					|| textFieldMonGDCDBD.getText().equals("")|| textFieldMonCongNgheBD.getText().equals("")|| textFieldMonTinHocBD.getText().equals("")
					|| textFieldMonNguVanBD.getText().equals("")|| textFieldMonTiengAnhBD.getText().equals("")|| textFieldMonGDQPBD.getText().equals("")
					|| textFieldMonTheDucBD.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "bạn hãy chọn học sinh trong bảng để sửa");
			}
			else {
			updateDiemBD();
			loadDataforTableBD();
			JOptionPane.showMessageDialog(null,"bạn đã update điểm học sinh thành công");
			}
		}
		else if(action == btnXoaBD) {
			deleteDiemBD();
			loadDataforTableBD();
		}
		else if(action == btnCleanBD) {
			cleanTableBD();
			
			
		}
		else if(action == btnAZBD) {
			tableBangDiem.setRowCount(0);
			
			List<BangDiem> listBangDiem = bangDiemDao.showTableByAZBD();
			for(BangDiem bangDiem : listBangDiem) {
				tableBangDiem.addRow(new String [] {"" + bangDiem.getSoThuTu(),bangDiem.getMaHS(),bangDiem.getTenHS(),bangDiem.getLop(),bangDiem.getDiemMonToan(), 
					bangDiem.getDiemMonVatLi(),bangDiem.getDiemMonHoaHoc(),bangDiem.getDiemMonSinhHoc(),bangDiem.getDiemMonLichSu(),bangDiem.getDiemMonDiaLi(),
					bangDiem.getDiemMonGDCD(),bangDiem.getDiemMonCongNghe(),bangDiem.getDiemMonTin(),bangDiem.getDiemMonNguVan(),bangDiem.getDiemMonTiengAnh(),
					bangDiem.getDiemMonGDQP(),bangDiem.getDiemMonTheDuc()});
			}
			
		}
		else if(action == btnZABD) {
			tableBangDiem.setRowCount(0);
			
			List<BangDiem> listBangDiem = bangDiemDao.showTableByZABD();
			for(BangDiem bangDiem : listBangDiem) {
				tableBangDiem.addRow(new String [] {"" + bangDiem.getSoThuTu(),bangDiem.getMaHS(),bangDiem.getTenHS(),bangDiem.getLop(),bangDiem.getDiemMonToan(), 
					bangDiem.getDiemMonVatLi(),bangDiem.getDiemMonHoaHoc(),bangDiem.getDiemMonSinhHoc(),bangDiem.getDiemMonLichSu(),bangDiem.getDiemMonDiaLi(),
					bangDiem.getDiemMonGDCD(),bangDiem.getDiemMonCongNghe(),bangDiem.getDiemMonTin(),bangDiem.getDiemMonNguVan(),bangDiem.getDiemMonTiengAnh(),
					bangDiem.getDiemMonGDQP(),bangDiem.getDiemMonTheDuc()});
			}
			
		}
		
	}
public void timKiemDiemBD() {
		
		String mahs = textFieldTimKiemBD.getText();
		tableBangDiem.setRowCount(0);
		BangDiem bangDiem = new BangDiem();
		bangDiem = bangDiemDao.getDiemByMaHSBD(mahs);
		if(mahs.equals(bangDiem.getMaHS())) {
			tableBangDiem.addRow(new String[] {"" +  bangDiem.getSoThuTu(),bangDiem.getMaHS(),bangDiem.getTenHS(),bangDiem.getLop(),bangDiem.getDiemMonToan(), 
					bangDiem.getDiemMonVatLi(),bangDiem.getDiemMonHoaHoc(),bangDiem.getDiemMonSinhHoc(),bangDiem.getDiemMonLichSu(),bangDiem.getDiemMonDiaLi(),
					bangDiem.getDiemMonGDCD(),bangDiem.getDiemMonCongNghe(),bangDiem.getDiemMonTin(),bangDiem.getDiemMonNguVan(),bangDiem.getDiemMonTiengAnh(),
					bangDiem.getDiemMonGDQP(),bangDiem.getDiemMonTheDuc()});
		}
		else if (mahs.equals("")) {
			loadDataforTableBD();
			JOptionPane.showMessageDialog(null,"bạn hãy nhập mã học sinh để tìm kiếm điểm của học sinh");
		}
		else if(!mahs.equals(bangDiem.getMaHS())) {
			loadDataforTableBD();
			JOptionPane.showMessageDialog(null,"mã học sinh bạn nhập không tồn tại trong danh sách");
		}
	}
	public void addDiemBD() {
		ckeckaddDiemBD();
	}
	private void ckeckaddDiemBD() {
		String stt = textFieldSoThuTuBD.getText();
		String mahs = textFieldMaHocSinhBD.getText();
		if(bangDiemDao.checkaddBD(mahs,stt)==false) {
			JOptionPane.showMessageDialog(null,"Số thứ tự hoặc mã học sinh đã tồn tại");
		}else{
			BangDiem bangDiem = new BangDiem();
			bangDiem.setSoThuTu(textFieldSoThuTuBD.getText());
			bangDiem.setMaHS(textFieldMaHocSinhBD.getText());
			bangDiem.setTenHS(textFieldTenHocSinhBD.getText());
			bangDiem.setLop((String) comboBoxLopBD.getSelectedItem());
			bangDiem.setDiemMonToan(textFieldMonToanBD.getText());
			bangDiem.setDiemMonVatLi(textFieldMonVatLiBD.getText());
			bangDiem.setDiemMonHoaHoc(textFieldMonHoaHocBD.getText());
			bangDiem.setDiemMonSinhHoc(textFieldMonSinhHocBD.getText());
			bangDiem.setDiemMonLichSu(textFieldMonLichSuBD.getText());
			bangDiem.setDiemMonDiaLi(textFieldMonDiaLiBD.getText());
			bangDiem.setDiemMonGDCD(textFieldMonGDCDBD.getText());
			bangDiem.setDiemMonCongNghe(textFieldMonCongNgheBD.getText());
			bangDiem.setDiemMonTin(textFieldMonTinHocBD.getText());
			bangDiem.setDiemMonNguVan(textFieldMonNguVanBD.getText());
			bangDiem.setDiemMonTiengAnh(textFieldMonTiengAnhBD.getText());
			bangDiem.setDiemMonGDQP(textFieldMonGDQPBD.getText());
			bangDiem.setDiemMonTheDuc(textFieldMonTheDucBD.getText());
			bangDiemDao.addDiemBD(bangDiem);
			JOptionPane.showMessageDialog(null, "bạn đã thêm điểm thành công");
		}
	}
	public void updateDiemBD() {
		BangDiem bangDiem = new BangDiem();
		bangDiem.setSoThuTu(textFieldSoThuTuBD.getText());
		bangDiem.setMaHS(textFieldMaHocSinhBD.getText());
		bangDiem.setTenHS(textFieldTenHocSinhBD.getText());
		bangDiem.setLop((String) comboBoxLopBD.getSelectedItem());
		bangDiem.setDiemMonToan(textFieldMonToanBD.getText());
		bangDiem.setDiemMonVatLi(textFieldMonVatLiBD.getText());
		bangDiem.setDiemMonHoaHoc(textFieldMonHoaHocBD.getText());
		bangDiem.setDiemMonSinhHoc(textFieldMonSinhHocBD.getText());
		bangDiem.setDiemMonLichSu(textFieldMonLichSuBD.getText());
		bangDiem.setDiemMonDiaLi(textFieldMonDiaLiBD.getText());
		bangDiem.setDiemMonGDCD(textFieldMonGDCDBD.getText());
		bangDiem.setDiemMonCongNghe(textFieldMonCongNgheBD.getText());
		bangDiem.setDiemMonTin(textFieldMonTinHocBD.getText());
		bangDiem.setDiemMonNguVan(textFieldMonNguVanBD.getText());
		bangDiem.setDiemMonTiengAnh(textFieldMonTiengAnhBD.getText());
		bangDiem.setDiemMonGDQP(textFieldMonGDQPBD.getText());
		bangDiem.setDiemMonTheDuc(textFieldMonTheDucBD.getText());
		bangDiemDao.updateDiemBD(bangDiem);
	}

	public void deleteDiemBD() {
		String mahs = (String) jTableBangDiem.getValueAt(jTableBangDiem.getSelectedRow(),1);
		int choose = JOptionPane.showConfirmDialog(null,"bạn có muốn xóa điểm của học sinh có mã "+ mahs+" không?","Xóa",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
		bangDiemDao.deleteDiemBD(mahs);
		JOptionPane.showMessageDialog(null,"bạn đã xóa thông tin điểm của học sinh có mã "+ mahs+ " thành công");
		}
	}
	public void cleanTableBD() {
		textFieldSoThuTuBD.setText("");
		textFieldMaHocSinhBD.setText("");
		textFieldTenHocSinhBD.setText("");
		textFieldMonToanBD.setText("");
		textFieldMonVatLiBD.setText("");
		textFieldMonHoaHocBD.setText("");
		textFieldMonSinhHocBD.setText("");
		textFieldMonLichSuBD.setText("");
		textFieldMonDiaLiBD.setText("");
		textFieldMonGDCDBD.setText("");
		textFieldMonCongNgheBD.setText("");
		textFieldMonTinHocBD.setText("");
		textFieldMonNguVanBD.setText("");
		textFieldMonTiengAnhBD.setText("");
		textFieldMonGDQPBD.setText("");
		textFieldMonTheDucBD.setText("");
		textFieldMaHocSinhBD.setEnabled(true);
		textFieldSoThuTuBD.setEnabled(true);
	}
}
