package QuanLiHocSinh;

import java.awt.event.MouseListener;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Dao.HoSoHocSinhDao;
import Model.Dao.ThongKeHSDao;
import Model.bean.HoSoHocSinh;
import Model.bean.ThongKeHS;
import TrangChu.TrangChu;

public class TabThongKeHocSinh extends JPanel implements ActionListener,MouseListener{
	private JFrame jFrame;
	private JPanel panelThongKeToanTruong;
	private JPanel panelInputTK;
	private JPanel panelSapXepTK;
	
	private JLabel lblThongKe;
	private JLabel lblThongKeToanTruong;
	private JLabel lblSapXepTK;
	private JLabel lblTongSoHocSinh;
	private JLabel lblTongSoHocSinh1;
	private JLabel lblTongSoLop;
	private JLabel lblTongSoLop1;
	private JLabel lblTongSoHSNam;
	private JLabel lblTongSoHSNam1;
	private JLabel lblTongSoHSNu;
	private JLabel lblTongSoHSNu1;
	private JLabel lblTongSoHSGioi;
	private JLabel lblTongSoHSGioi1;
	private JLabel lblTongSoHSKha;
	private JLabel lblTongSoHSKha1;
	private JLabel lblTongSoHSTB;
	private JLabel lblTongSoHSTB1;
	private JLabel lblTongSoHSYeu;
	private JLabel lblTongSoHSYeu1;
	private JLabel lblTongSoHKTot;
	private JLabel lblTongSoHKTot1;
	private JLabel lblTongSoHKKha;
	private JLabel lblTongSoHKKha1;
	private JLabel lblTongSoHKTB;
	private JLabel lblTongSoHKTB1;
	private JLabel lblTongSoHKYeu;
	private JLabel lblTongSoHKYeu1;
	private JLabel lblTongSoHSThiLai;
	private JLabel lblTongSoHSThiLai1;
	private JLabel lblTongSoHSOLaiLop;
	private JLabel lblTongSoHSOLaiLop1;
	private JLabel lblNamHoc;
	
	
	private JLabel lblSoThuTuTK;
	private JLabel lblLopTK;
	private JLabel lblTongSoTK;
	private JLabel lblTongSoHSNuTK;
	private JLabel lblTongSoHSNamTK;
	private JLabel lblTongSoHSGioiTK;
	private JLabel lblTongSoHSKhaTK;
	private JLabel lblTongSoHSTBTK;
	private JLabel lblTongSoHSYeuTK;
	private JLabel lblTongSoHKTotTK;
	private JLabel lblTongSoHKKhaTK;
	private JLabel lblTongSoHKTBTK;
	private JLabel lblTongSoHKYeuTK;
	private JLabel lblTongSoHSThiLaiTK;
	private JLabel lblTongSoHSOLaiLopTK;
	
	private JButton btnThemTK;
	private JButton btnSuaTK;
	private JButton btnXoaTK;
	private JButton btnCleanTK;
	private JButton btnAZTK;
	private JButton btnZATK;
	private JButton btnThoatTK;
	private JButton btnInTK;
	
	private JTextField textFieldSoThuTuTK;
	private JComboBox<String> comboBoxLopTK;
	private JTextField textFieldTongSoNamTK;
	private JTextField textFieldTongSoNuTK;
	private JTextField textFieldTongSoHSGioiTK;
	private JTextField textFieldTongSoHSKhaTK;
	private JTextField textFieldTongSoHSTBTK;
	private JTextField textFieldTongSoHSYeuTK;
	private JTextField textFieldTongSoHKTotTK;
	private JTextField textFieldTongSoHKKhaTK;
	private JTextField textFieldTongSoHKTBTK;
	private JTextField textFieldTongSoHKYeuTK;
	private JTextField textFieldTongSoHSOLaiLopTK;
	private JTextField textFieldTongSoHSThiLaiTK;
	private JTextField textFieldTongSoTK;
	
	private JTable jTableTK;
	private DefaultTableModel tableTK;
	private JScrollPane jScrollPaneTK;
	
	private ThongKeHSDao thongKeHSDao;
	public TabThongKeHocSinh(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);
		thongKeHSDao = new ThongKeHSDao();
		{
			lblThongKe = new JLabel("THỐNG KÊ");
			lblThongKe.setForeground(Color.RED);
			lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblThongKe.setBounds(895, 43, 299, 48);
			add(lblThongKe);
		}
		{
			tableTK = new DefaultTableModel();
			tableTK.addColumn("STT");
			tableTK.addColumn("Lớp");
			tableTK.addColumn("Tổng số");
			tableTK.addColumn("Học sinh nam");
			tableTK.addColumn("Học sinh Nữ");
			tableTK.addColumn("Học Sinh Giỏi");
			tableTK.addColumn("Học Sinh Khá");
			tableTK.addColumn("Học Sinh TB");
			tableTK.addColumn("Học Sinh Yếu");
			tableTK.addColumn("Hạnh Kiểm Tốt ");
			tableTK.addColumn("Hạnh Kiểm Khá");
			tableTK.addColumn("Hạnh Kiểm TB");
			tableTK.addColumn("Hạnh Kiểm Yếu");
			tableTK.addColumn("HS Ở Lại Lớp");
			tableTK.addColumn("HS Thi Lại");
			jTableTK = new JTable(tableTK);
			jTableTK.addMouseListener(this);
			jScrollPaneTK = new JScrollPane(jTableTK);
			jScrollPaneTK.setBounds(356, 113, 1543, 314);
			add(jScrollPaneTK);
		}
		{
			panelSapXepTK = new JPanel();
			panelSapXepTK.setBorder(new LineBorder(Color.GRAY));
			panelSapXepTK.setBackground(SystemColor.controlHighlight);
			panelSapXepTK.setBounds(356, 879, 1543, 84);
			add(panelSapXepTK);
			panelSapXepTK.setLayout(null);
			{
				btnAZTK = new JButton("A -Z");
				btnAZTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnAZTK.setIcon(new ImageIcon("AZ.png"));
				btnAZTK.addActionListener(this);
				btnAZTK.setBounds(719, 22, 135, 40);
				panelSapXepTK.add(btnAZTK);
			}
			{
				btnZATK = new JButton("Z - A");
				btnZATK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnZATK.setIcon(new ImageIcon("ZA.png"));
				btnZATK.addActionListener(this);
				btnZATK.setBounds(918, 22, 135, 40);
				panelSapXepTK.add(btnZATK);
			}
			{
				lblSapXepTK = new JLabel("Sắp Xếp");
				lblSapXepTK.setForeground(Color.RED);
				lblSapXepTK.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblSapXepTK.setBounds(553, 22, 110, 40);
				panelSapXepTK.add(lblSapXepTK);
			}
		}
		{
			panelThongKeToanTruong = new JPanel();
			panelThongKeToanTruong.setBorder(new LineBorder(Color.GRAY));
			panelThongKeToanTruong.setBackground(SystemColor.controlHighlight);
			panelThongKeToanTruong.setBounds(0, 113, 350, 850);
			add(panelThongKeToanTruong);
			panelThongKeToanTruong.setLayout(null);
			{
				lblThongKeToanTruong = new JLabel("THỐNG KÊ HỌC SINH TOÀN TRƯỜNG");
				lblThongKeToanTruong.setForeground(Color.RED);
				lblThongKeToanTruong.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblThongKeToanTruong.setBounds(21, 27, 308, 27);
				panelThongKeToanTruong.add(lblThongKeToanTruong);
			}
			{
				lblTongSoHocSinh = new JLabel("Tổng số học sinh :");
				lblTongSoHocSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHocSinh.setBounds(21, 97, 151, 32);
				panelThongKeToanTruong.add(lblTongSoHocSinh);
			}
			{
				lblTongSoHocSinh1 = new JLabel("1000");
				lblTongSoHocSinh1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHocSinh1.setBounds(224, 97, 92, 32);
				panelThongKeToanTruong.add(lblTongSoHocSinh1);
			}
			{
				lblTongSoLop = new JLabel("Tổng số lớp :");
				lblTongSoLop.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoLop.setBounds(21, 154, 151, 27);
				panelThongKeToanTruong.add(lblTongSoLop);
			}
			{
				lblTongSoLop1 = new JLabel("30");
				lblTongSoLop1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoLop1.setBounds(224, 154, 92, 27);
				panelThongKeToanTruong.add(lblTongSoLop1);
			}
			{
				lblTongSoHSNam = new JLabel("Tổng số hs nam :");
				lblTongSoHSNam.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSNam.setBounds(21, 212, 151, 32);
				panelThongKeToanTruong.add(lblTongSoHSNam);
			}
			{
				lblTongSoHSNam1 = new JLabel("600");
				lblTongSoHSNam1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSNam1.setBounds(224, 212, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHSNam1);
			}
			{
				lblTongSoHSNu = new JLabel("Tổng Số hs nữ :");
				lblTongSoHSNu.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSNu.setBounds(21, 271, 151, 32);
				panelThongKeToanTruong.add(lblTongSoHSNu);
			}
			{
				lblTongSoHSNu1 = new JLabel("400");
				lblTongSoHSNu1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSNu1.setBounds(224, 271, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHSNu1);
			}
			{
				lblTongSoHSGioi = new JLabel("Tổng số hs giỏi :");
				lblTongSoHSGioi.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSGioi.setBounds(21, 330, 151, 32);
				panelThongKeToanTruong.add(lblTongSoHSGioi);
			}
			{
				lblTongSoHSGioi1 = new JLabel("150");
				lblTongSoHSGioi1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSGioi1.setBounds(224, 328, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHSGioi1);
			}
			{
				lblTongSoHSKha = new JLabel("Tổng Số hs khá :");
				lblTongSoHSKha.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSKha.setBounds(21, 383, 151, 32);
				panelThongKeToanTruong.add(lblTongSoHSKha);
			}
			{
				lblTongSoHSKha1 = new JLabel("400");
				lblTongSoHSKha1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSKha1.setBounds(224, 383, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHSKha1);
			}
			{
				lblTongSoHSTB = new JLabel("Tổng số hs trung bình :");
				lblTongSoHSTB.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSTB.setBounds(21, 426, 162, 32);
				panelThongKeToanTruong.add(lblTongSoHSTB);
			}
			{
				lblTongSoHSTB1 = new JLabel("400");
				lblTongSoHSTB1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSTB1.setBounds(224, 426, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHSTB1);
			}
			{
				lblTongSoHSYeu = new JLabel("Tổng số hs yếu :");
				lblTongSoHSYeu.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSYeu.setBounds(21, 480, 162, 27);
				panelThongKeToanTruong.add(lblTongSoHSYeu);
			}
			{
				lblTongSoHSYeu1 = new JLabel("50");
				lblTongSoHSYeu1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSYeu1.setBounds(224, 480, 70, 27);
				panelThongKeToanTruong.add(lblTongSoHSYeu1);
			}
			{
				lblTongSoHKTot = new JLabel("Tổng số HK tốt :");
				lblTongSoHKTot.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKTot.setBounds(21, 526, 204, 32);
				panelThongKeToanTruong.add(lblTongSoHKTot);
			}
			{
				lblTongSoHKTot1 = new JLabel("900");
				lblTongSoHKTot1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHKTot1.setBounds(224, 526, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHKTot1);
			}
			{
				lblTongSoHKKha = new JLabel("Tổng số HK khá :");
				lblTongSoHKKha.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKKha.setBounds(21, 579, 140, 32);
				panelThongKeToanTruong.add(lblTongSoHKKha);
			}
			{
				lblTongSoHKKha1 = new JLabel("50");
				lblTongSoHKKha1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHKKha1.setBounds(224, 579, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHKKha1);
			}
			{
				lblTongSoHKTB = new JLabel("Tổng số HK trung bình :");
				lblTongSoHKTB.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKTB.setBounds(21, 630, 185, 32);
				panelThongKeToanTruong.add(lblTongSoHKTB);
			}
			{
				lblTongSoHKTB1 = new JLabel("50");
				lblTongSoHKTB1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHKTB1.setBounds(220, 630, 74, 32);
				panelThongKeToanTruong.add(lblTongSoHKTB1);
			}
			{
				lblTongSoHKYeu = new JLabel("Tổng số hk yếu :");
				lblTongSoHKYeu.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKYeu.setBounds(21, 683, 162, 32);
				panelThongKeToanTruong.add(lblTongSoHKYeu);
			}
			{
				lblTongSoHKYeu1 = new JLabel("0");
				lblTongSoHKYeu1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHKYeu1.setBounds(224, 683, 70, 32);
				panelThongKeToanTruong.add(lblTongSoHKYeu1);
			}
			{
				lblTongSoHSOLaiLop = new JLabel("Tổng số hs ở lại lớp :");
				lblTongSoHSOLaiLop.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSOLaiLop.setBounds(21, 729, 185, 32);
				panelThongKeToanTruong.add(lblTongSoHSOLaiLop);
			}
			{
				lblTongSoHSOLaiLop1 = new JLabel("20");
				lblTongSoHSOLaiLop1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSOLaiLop1.setBounds(224, 726, 46, 35);
				panelThongKeToanTruong.add(lblTongSoHSOLaiLop1);
			}
			{
				lblTongSoHSThiLai = new JLabel("Tổng số hs thi lại :");
				lblTongSoHSThiLai.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSThiLai.setBounds(21, 778, 140, 32);
				panelThongKeToanTruong.add(lblTongSoHSThiLai);
			}
			{
				lblTongSoHSThiLai1 = new JLabel("50");
				lblTongSoHSThiLai1.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTongSoHSThiLai1.setBounds(220, 776, 74, 34);
				panelThongKeToanTruong.add(lblTongSoHSThiLai1);
			}
		}
		{
			panelInputTK = new JPanel();
			panelInputTK.setBorder(new LineBorder(Color.GRAY));
			panelInputTK.setBackground(SystemColor.controlHighlight);
			panelInputTK.setBounds(356, 434, 1543, 441);
			add(panelInputTK);
			panelInputTK.setLayout(null);
			{
				lblSoThuTuTK = new JLabel("Số thứ tự");
				lblSoThuTuTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSoThuTuTK.setBounds(44, 41, 105, 36);
				panelInputTK.add(lblSoThuTuTK);
			}
			{
				textFieldSoThuTuTK = new JTextField();
				textFieldSoThuTuTK.setBounds(161, 41, 128, 36);
				panelInputTK.add(textFieldSoThuTuTK);
				textFieldSoThuTuTK.setColumns(10);
			}
			{
				lblLopTK = new JLabel("Lớp");
				lblLopTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblLopTK.setBounds(44, 112, 73, 36);
				panelInputTK.add(lblLopTK);
			}
			{
				comboBoxLopTK = new JComboBox<String>();
				comboBoxLopTK.addItem("10A1");
				comboBoxLopTK.addItem("10A2");
				comboBoxLopTK.addItem("10A3");
				comboBoxLopTK.addItem("10A4");
				comboBoxLopTK.addItem("10A5");
				comboBoxLopTK.addItem("10A6");
				comboBoxLopTK.addItem("10A7");
				comboBoxLopTK.addItem("10A8");
				comboBoxLopTK.addItem("10A9");
				comboBoxLopTK.addItem("10A10");
				comboBoxLopTK.addItem("11A1");
				comboBoxLopTK.addItem("11A2");
				comboBoxLopTK.addItem("11A3");
				comboBoxLopTK.addItem("11A4");
				comboBoxLopTK.addItem("11A5");
				comboBoxLopTK.addItem("11A6");
				comboBoxLopTK.addItem("11A7");
				comboBoxLopTK.addItem("11A8");
				comboBoxLopTK.addItem("11A9");
				comboBoxLopTK.addItem("11A10");
				comboBoxLopTK.addItem("12A1");
				comboBoxLopTK.addItem("12A2");
				comboBoxLopTK.addItem("12A3");
				comboBoxLopTK.addItem("12A4");
				comboBoxLopTK.addItem("12A5");
				comboBoxLopTK.addItem("12A6");
				comboBoxLopTK.addItem("12A7");
				comboBoxLopTK.addItem("12A8");
				comboBoxLopTK.addItem("12A9");
				comboBoxLopTK.addItem("12A10");
				comboBoxLopTK.setBounds(161, 112, 128, 36);
				panelInputTK.add(comboBoxLopTK);
			}
			{
				lblTongSoTK = new JLabel("Tổng số");
				lblTongSoTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoTK.setBounds(44, 188, 73, 36);
				panelInputTK.add(lblTongSoTK);
			}
			{
				textFieldTongSoTK = new JTextField();
				textFieldTongSoTK.setBounds(161, 188, 128, 36);
				panelInputTK.add(textFieldTongSoTK);
				textFieldTongSoTK.setColumns(10);
			}
			{
				lblTongSoHSNamTK = new JLabel("Tổng số nam");
				lblTongSoHSNamTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSNamTK.setBounds(44, 268, 105, 36);
				panelInputTK.add(lblTongSoHSNamTK);
			}
			{
				textFieldTongSoNamTK = new JTextField();
				textFieldTongSoNamTK.setBounds(161, 268, 128, 36);
				panelInputTK.add(textFieldTongSoNamTK);
				textFieldTongSoNamTK.setColumns(10);
			}
			{
				lblTongSoHSNuTK = new JLabel("Tổng số nữ");
				lblTongSoHSNuTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSNuTK.setBounds(44, 347, 105, 36);
				panelInputTK.add(lblTongSoHSNuTK);
			}
			{
				textFieldTongSoNuTK = new JTextField();
				textFieldTongSoNuTK.setBounds(161, 347, 128, 36);
				panelInputTK.add(textFieldTongSoNuTK);
				textFieldTongSoNuTK.setColumns(10);
			}
			{
				lblTongSoHSGioiTK = new JLabel("Tổng số học sinh giỏi");
				lblTongSoHSGioiTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSGioiTK.setBounds(394, 41, 171, 37);
				panelInputTK.add(lblTongSoHSGioiTK);
			}
			{
				textFieldTongSoHSGioiTK = new JTextField();
				textFieldTongSoHSGioiTK.setBounds(575, 43, 128, 36);
				panelInputTK.add(textFieldTongSoHSGioiTK);
				textFieldTongSoHSGioiTK.setColumns(10);
			}
			{
				lblTongSoHSKhaTK = new JLabel("Tổng số học sinh khá");
				lblTongSoHSKhaTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSKhaTK.setBounds(394, 112, 155, 36);
				panelInputTK.add(lblTongSoHSKhaTK);
			}
			{
				textFieldTongSoHSKhaTK = new JTextField();
				textFieldTongSoHSKhaTK.setBounds(575, 112, 128, 36);
				panelInputTK.add(textFieldTongSoHSKhaTK);
				textFieldTongSoHSKhaTK.setColumns(10);
			}
			{
				lblTongSoHSTBTK = new JLabel("Tổng số học sinh TB");
				lblTongSoHSTBTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSTBTK.setBounds(394, 188, 155, 36);
				panelInputTK.add(lblTongSoHSTBTK);
			}
			{
				textFieldTongSoHSTBTK = new JTextField();
				textFieldTongSoHSTBTK.setBounds(575, 188, 128, 36);
				panelInputTK.add(textFieldTongSoHSTBTK);
				textFieldTongSoHSTBTK.setColumns(10);
			}
			{
				lblTongSoHSYeuTK = new JLabel("Tổng số học sinh yếu");
				lblTongSoHSYeuTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSYeuTK.setBounds(394, 268, 155, 36);
				panelInputTK.add(lblTongSoHSYeuTK);
			}
			{
				textFieldTongSoHSYeuTK = new JTextField();
				textFieldTongSoHSYeuTK.setBounds(575, 268, 128, 36);
				panelInputTK.add(textFieldTongSoHSYeuTK);
				textFieldTongSoHSYeuTK.setColumns(10);
			}
			{
				lblTongSoHKTotTK = new JLabel("Tổng số HK Tốt");
				lblTongSoHKTotTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKTotTK.setBounds(394, 347, 155, 36);
				panelInputTK.add(lblTongSoHKTotTK);
			}
			{
				textFieldTongSoHKTotTK = new JTextField();
				textFieldTongSoHKTotTK.setBounds(575, 347, 128, 36);
				panelInputTK.add(textFieldTongSoHKTotTK);
				textFieldTongSoHKTotTK.setColumns(10);
			}
			{
				lblTongSoHKKhaTK = new JLabel("Tổng số HK Khá");
				lblTongSoHKKhaTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKKhaTK.setBounds(798, 41, 171, 36);
				panelInputTK.add(lblTongSoHKKhaTK);
			}
			{
				textFieldTongSoHKKhaTK = new JTextField();
				textFieldTongSoHKKhaTK.setBounds(962, 41, 128, 36);
				panelInputTK.add(textFieldTongSoHKKhaTK);
				textFieldTongSoHKKhaTK.setColumns(10);
			}
			{
				lblTongSoHKTBTK = new JLabel("Tổng số HK TB");
				lblTongSoHKTBTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKTBTK.setBounds(798, 112, 136, 36);
				panelInputTK.add(lblTongSoHKTBTK);
			}
			{
				textFieldTongSoHKTBTK = new JTextField();
				textFieldTongSoHKTBTK.setBounds(962, 112, 128, 36);
				panelInputTK.add(textFieldTongSoHKTBTK);
				textFieldTongSoHKTBTK.setColumns(10);
			}
			{
				lblTongSoHKYeuTK = new JLabel("Tổng số HK Yếu");
				lblTongSoHKYeuTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHKYeuTK.setBounds(798, 188, 136, 36);
				panelInputTK.add(lblTongSoHKYeuTK);
			}
			{
				textFieldTongSoHKYeuTK = new JTextField();
				textFieldTongSoHKYeuTK.setBounds(962, 188, 128, 36);
				panelInputTK.add(textFieldTongSoHKYeuTK);
				textFieldTongSoHKYeuTK.setColumns(10);
			}
			{
				lblTongSoHSThiLaiTK = new JLabel("Tổng số HS thi lại");
				lblTongSoHSThiLaiTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSThiLaiTK.setBounds(798, 268, 136, 36);
				panelInputTK.add(lblTongSoHSThiLaiTK);
			}
			{
				textFieldTongSoHSThiLaiTK = new JTextField();
				textFieldTongSoHSThiLaiTK.setBounds(962, 268, 128, 36);
				panelInputTK.add(textFieldTongSoHSThiLaiTK);
				textFieldTongSoHSThiLaiTK.setColumns(10);
			}
			{
				lblTongSoHSOLaiLopTK = new JLabel("Tổng số HS ở lại lớp");
				lblTongSoHSOLaiLopTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTongSoHSOLaiLopTK.setBounds(798, 347, 171, 36);
				panelInputTK.add(lblTongSoHSOLaiLopTK);
			}
			{
				textFieldTongSoHSOLaiLopTK = new JTextField();
				textFieldTongSoHSOLaiLopTK.setBounds(962, 347, 128, 36);
				panelInputTK.add(textFieldTongSoHSOLaiLopTK);
				textFieldTongSoHSOLaiLopTK.setColumns(10);
			}
			{
				btnThemTK = new JButton("Thêm");
				btnThemTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnThemTK.setIcon(new ImageIcon("add.png"));
				btnThemTK.addActionListener(this);
				btnThemTK.setBounds(1181, 80, 136, 36);
				panelInputTK.add(btnThemTK);
			}
			{
				btnSuaTK = new JButton("Sửa");
				btnSuaTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnSuaTK.setIcon(new ImageIcon("update.png"));
				btnSuaTK.addActionListener(this);
				btnSuaTK.setBounds(1181, 152, 136, 36);
				panelInputTK.add(btnSuaTK);
			}
			{
				btnXoaTK = new JButton("Xóa");
				btnXoaTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnXoaTK.setIcon(new ImageIcon("delete.png"));
				btnXoaTK.addActionListener(this);
				btnXoaTK.setBounds(1181, 233, 136, 36);
				panelInputTK.add(btnXoaTK);
			}
			{
				btnCleanTK = new JButton("Clean");
				btnCleanTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnCleanTK.setIcon(new ImageIcon("clean.png"));
				btnCleanTK.addActionListener(this);
				btnCleanTK.setBounds(1181, 303, 136, 36);
				panelInputTK.add(btnCleanTK);
			}
			{
				btnInTK = new JButton("In");
				btnInTK.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnInTK.setIcon(new ImageIcon("printer.png"));
				btnInTK.addActionListener(this);
				btnInTK.setBounds(1390, 174, 128, 83);
				panelInputTK.add(btnInTK);
			}
		}
			btnThoatTK = new JButton("Thoát");
			btnThoatTK.setBounds(1686, 31, 107, 37);
			btnThoatTK.addActionListener(this);
			btnThoatTK.setIcon(new ImageIcon("thoat.png"));
			add(btnThoatTK);
		{
			lblNamHoc = new JLabel("Năm Học : 2019 - 2020");
			lblNamHoc.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNamHoc.setBounds(69, 31, 223, 48);
			add(lblNamHoc);
		}
		
		loadDataforTableTK();
		
	}
	public void loadDataforTableTK() {
		tableTK.setRowCount(0);
		thongKeHSDao = new ThongKeHSDao();
		List<ThongKeHS> listThongKeHS = thongKeHSDao.getAllThongKeHS();
		for(ThongKeHS thongKeHS : listThongKeHS) {
			tableTK.addRow(new String[] {"" + thongKeHS.getSoThuTu(),thongKeHS.getLop(),thongKeHS.getTongSo(),thongKeHS.getSoHocSinhNam(),thongKeHS.getSoHocSinhNu(),
					thongKeHS.getSoHocSinhGioi(),
					thongKeHS.getSoHocSinhKha(),thongKeHS.getSoHocSinhTB(),thongKeHS.getSoHocSinhYeu(),thongKeHS.getSoHanhKiemTot(),
					thongKeHS.getSoHanhKiemKha(),thongKeHS.getSoHanhKiemTB(),thongKeHS.getSoHanhKiemYeu(),thongKeHS.getSoHocSinhOLaiLop(),
					thongKeHS.getSoHocSinhThiLai()});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		textFieldSoThuTuTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),0));
		comboBoxLopTK.setSelectedItem(jTableTK.getValueAt(jTableTK.getSelectedRow(),1));
		textFieldTongSoTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),2));
		textFieldTongSoNamTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),3));
		textFieldTongSoNuTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),4));
		textFieldTongSoHSGioiTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),5));
		textFieldTongSoHSKhaTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),6));
		textFieldTongSoHSTBTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),7));
		textFieldTongSoHSYeuTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),8));
		textFieldTongSoHKTotTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),9));
		textFieldTongSoHKKhaTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),10));
		textFieldTongSoHKTBTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),11));
		textFieldTongSoHKYeuTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),12));
		textFieldTongSoHSOLaiLopTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),13));
		textFieldTongSoHSThiLaiTK.setText((String) jTableTK.getValueAt(jTableTK.getSelectedRow(),14));
		textFieldSoThuTuTK.setEditable(false);
		comboBoxLopTK.setEditable(false);
		
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
		if(action == btnThoatTK) {
			int choose = JOptionPane.showConfirmDialog(null, "bạn có muốn thoát","Thoát",JOptionPane.YES_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				TrangChu trangChu = new TrangChu();
				trangChu.loadTrangChu();
				trangChu.setVisible(true);
				jFrame.dispose();
			}
		}
		else if(action == btnThemTK) {
			if(textFieldSoThuTuTK.getText().equals("")||textFieldTongSoTK.getText().equals("")||
					textFieldTongSoNamTK.getText().equals("")||textFieldTongSoNuTK.getText().equals("")||textFieldTongSoHSGioiTK.getText().equals("")||
					textFieldTongSoHSKhaTK.getText().equals("")||textFieldTongSoHSTBTK.getText().equals("")||textFieldTongSoHSYeuTK.getText().equals("")||
					textFieldTongSoHKTotTK.getText().equals("")||textFieldTongSoHKKhaTK.getText().equals("")||textFieldTongSoHKTBTK.getText().equals("")||
					textFieldTongSoHKYeuTK.getText().equals("")||textFieldTongSoHSOLaiLopTK.getText().equals("")||textFieldTongSoHSThiLaiTK.getText().equals("")||
					textFieldTongSoNamTK.getText().equals("")||textFieldTongSoNuTK.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"bạn hãy nhập đầy đủ thông tin");
			}
			else {
				addThongKe();
				loadDataforTableTK();
				
			}
		}
		else if(action == btnSuaTK) {
			updateThongKe();
			loadDataforTableTK();
			JOptionPane.showMessageDialog(null, "bạn đã update thống kê thành công");
		}
		else if (action == btnXoaTK) {
			deleteThongKe();
			loadDataforTableTK();
		}
		else if(action == btnCleanTK) {
			cleantk();
		}
		else if(action == btnAZTK) {
			tableTK.setRowCount(0);
			ThongKeHSDao thongKeHSDao = new ThongKeHSDao();
			List<ThongKeHS> listThongKeHS = thongKeHSDao.showTableByAZTK();
			for(ThongKeHS thongKeHS : listThongKeHS) {
				tableTK.addRow(new String[] {"" + thongKeHS.getSoThuTu(),thongKeHS.getLop(),thongKeHS.getTongSo(),thongKeHS.getSoHocSinhNam(),thongKeHS.getSoHocSinhNu(),
						thongKeHS.getSoHocSinhGioi(),
						thongKeHS.getSoHocSinhKha(),thongKeHS.getSoHocSinhTB(),thongKeHS.getSoHocSinhYeu(),thongKeHS.getSoHanhKiemTot(),
						thongKeHS.getSoHanhKiemKha(),thongKeHS.getSoHanhKiemTB(),thongKeHS.getSoHanhKiemYeu(),thongKeHS.getSoHocSinhOLaiLop(),
						thongKeHS.getSoHocSinhThiLai()});
			}
		}
		else if(action == btnZATK) {
			tableTK.setRowCount(0);
			ThongKeHSDao thongKeHSDao = new ThongKeHSDao();
			List<ThongKeHS> listThongKeHS = thongKeHSDao.showTableByZATK();
			for(ThongKeHS thongKeHS : listThongKeHS) {
				tableTK.addRow(new String[] {"" + thongKeHS.getSoThuTu(),thongKeHS.getLop(),thongKeHS.getTongSo(),thongKeHS.getSoHocSinhNam(),thongKeHS.getSoHocSinhNu(),
						thongKeHS.getSoHocSinhGioi(),
						thongKeHS.getSoHocSinhKha(),thongKeHS.getSoHocSinhTB(),thongKeHS.getSoHocSinhYeu(),thongKeHS.getSoHanhKiemTot(),
						thongKeHS.getSoHanhKiemKha(),thongKeHS.getSoHanhKiemTB(),thongKeHS.getSoHanhKiemYeu(),thongKeHS.getSoHocSinhOLaiLop(),
						thongKeHS.getSoHocSinhThiLai()});
		}
	}
		
	}
	private void addThongKe() {
		ckeckaddThongKe();
	}
	private void ckeckaddThongKe() {
		String stt = textFieldSoThuTuTK.getText();
		String lop = (String) comboBoxLopTK.getSelectedItem();
		if(thongKeHSDao.checkaddTK(stt,lop)==false) {
			JOptionPane.showMessageDialog(null,"Số thứ tự hoặc tên lớp đã tồn tại");
		}
		else {
			ThongKeHS thongKeHS = new ThongKeHS();
			thongKeHS.setSoThuTu(textFieldSoThuTuTK.getText());
			thongKeHS.setLop((String) comboBoxLopTK.getSelectedItem());
			thongKeHS.setTongSo(textFieldTongSoTK.getText());
			thongKeHS.setSoHocSinhNam(textFieldTongSoNamTK.getText());
			thongKeHS.setSoHocSinhNu(textFieldTongSoNuTK.getText());
			thongKeHS.setSoHocSinhGioi(textFieldTongSoHSGioiTK.getText());
			thongKeHS.setSoHocSinhKha(textFieldTongSoHSKhaTK.getText());
			thongKeHS.setSoHocSinhTB(textFieldTongSoHSTBTK.getText());
			thongKeHS.setSoHocSinhYeu(textFieldTongSoHSYeuTK.getText());
			thongKeHS.setSoHanhKiemTot(textFieldTongSoHKTotTK.getText());
			thongKeHS.setSoHanhKiemKha(textFieldTongSoHKKhaTK.getText());
			thongKeHS.setSoHanhKiemTB(textFieldTongSoHKTBTK.getText());
			thongKeHS.setSoHanhKiemYeu(textFieldTongSoHKYeuTK.getText());
			thongKeHS.setSoHocSinhOLaiLop(textFieldTongSoHSOLaiLopTK.getText());
			thongKeHS.setSoHocSinhThiLai(textFieldTongSoHSThiLaiTK.getText());
			thongKeHSDao.addThongKeHS(thongKeHS);
			JOptionPane.showMessageDialog(null, "bạn đã thêm thống kê thành công");
			
			
		}
	}
	private void updateThongKe() {
		ThongKeHS thongKeHS = new ThongKeHS();
		thongKeHS.setSoThuTu(textFieldSoThuTuTK.getText());
		thongKeHS.setLop((String) comboBoxLopTK.getSelectedItem());
		thongKeHS.setTongSo(textFieldTongSoTK.getText());
		thongKeHS.setSoHocSinhNam(textFieldTongSoNamTK.getText());
		thongKeHS.setSoHocSinhNu(textFieldTongSoNuTK.getText());
		thongKeHS.setSoHocSinhGioi(textFieldTongSoHSGioiTK.getText());
		thongKeHS.setSoHocSinhKha(textFieldTongSoHSKhaTK.getText());
		thongKeHS.setSoHocSinhTB(textFieldTongSoHSTBTK.getText());
		thongKeHS.setSoHocSinhYeu(textFieldTongSoHSYeuTK.getText());
		thongKeHS.setSoHanhKiemTot(textFieldTongSoHKTotTK.getText());
		thongKeHS.setSoHanhKiemKha(textFieldTongSoHKKhaTK.getText());
		thongKeHS.setSoHanhKiemTB(textFieldTongSoHKTBTK.getText());
		thongKeHS.setSoHanhKiemYeu(textFieldTongSoHKYeuTK.getText());
		thongKeHS.setSoHocSinhOLaiLop(textFieldTongSoHSOLaiLopTK.getText());
		thongKeHS.setSoHocSinhThiLai(textFieldTongSoHSThiLaiTK.getText());
		thongKeHSDao.updateThongKe(thongKeHS);
	}
	private void deleteThongKe() {
		String lop = (String) jTableTK.getValueAt( jTableTK.getSelectedRow(),1);
		int choose = JOptionPane.showConfirmDialog(null,"bạn muốn xóa thống kê của lớp có tên "+ lop+" không?","Xóa",JOptionPane.YES_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			thongKeHSDao.deleteThongKe(lop);
			JOptionPane.showMessageDialog(null, "bạn đã xóa thành công thống kê của lớp có tên "+ lop+" thành công");
		}
	
	}
	private void cleantk() {
		textFieldSoThuTuTK.setText("");
		textFieldTongSoTK.setText("");
		textFieldTongSoNamTK.setText("");
		textFieldTongSoNuTK.setText("");
		textFieldTongSoHSGioiTK.setText("");
		textFieldTongSoHSKhaTK.setText("");
		textFieldTongSoHSTBTK.setText("");
		textFieldTongSoHSYeuTK.setText("");
		textFieldTongSoHKTotTK.setText("");
		textFieldTongSoHKKhaTK.setText("");
		textFieldTongSoHKTBTK.setText("");
		textFieldTongSoHKYeuTK.setText("");
		textFieldTongSoHSOLaiLopTK.setText("");
		textFieldTongSoHSThiLaiTK.setText("");
		textFieldSoThuTuTK.setEditable(true);
		textFieldTongSoTK.setEditable(true);
		
	}
}
