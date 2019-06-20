import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Giaodien extends JFrame implements ActionListener, MouseListener {
	private JTextField txt_masv, txt_hoten, txt_ngaysinh, txt_gioitinh, txt_diachi, txt_malop;
	private JButton addsv, updatesv, Deletesv, CLearsv;
	DefaultTableModel model;
	private JTable table;
	private JScrollPane sc;

	private JTextField txt_magv, txt_tengv, txt_gioitinhgv, txt_phone, txt_email, txt_phanloaigv;
	private JButton addgv, updategv, deletegv, cleragv;
	DefaultTableModel model1;
	private JTable table1;
	private JScrollPane sc1;

	private DefaultTableModel model2;
	private JTable table2;
	private JScrollPane sc2;
	private JTextField txt_mamon, txt_magv2, txt_hocki, txt_makhoa;
	private JComboBox cb_tenmon;
	private JButton addmon, updatemon, deletemon, clearmon;

	private DefaultTableModel modelkq;
	private JTable tablekq;
	private JScrollPane sckq;
	private JButton addKetqua, updateketqua, deleteketqua, clearketqua;
	private JTextField txt_masvkq, txt_hotenkq, txt_malopkq, txt_hanhkiemkq, txt_mamonkq, txt_dtb, txt_diemthilan1,
			txt_diemthilan2, txt_diemtongket;

	public Giaodien() {
		taotap();
		this.setSize(930, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void taotap() {
		taotable1();
		JTabbedPane tabbed = new JTabbedPane();
		JPanel tab1 = new JPanel();
		JPanel lb1 = new JPanel();
		JLabel lb11 = new JLabel("Thông tin sinh viên");
		lb11.setFont(new Font("Courier New", Font.BOLD, 20));
		lb1.add(lb11);
		JPanel Tren = new JPanel();
		Tren.setLayout(new BorderLayout());
		Tren.add(sc);
		Tren.setPreferredSize(new Dimension(900, 280));
		JPanel Duoi = new JPanel();
		Duoi.setPreferredSize(new Dimension(900, 280));
		JPanel Duoileft = new JPanel();
		Duoileft.setPreferredSize(new Dimension(730, 280));
		JLabel lbleft1 = new JLabel("Mã Sinh Viên :");
		txt_masv = new JTextField(20);
		Duoileft.add(lbleft1);
		Duoileft.add(txt_masv);
		JLabel lbleft2 = new JLabel("Họ và tên :");
		txt_hoten = new JTextField(20);
		Duoileft.add(lbleft2);
		Duoileft.add(txt_hoten);
		JLabel lbleft3 = new JLabel("Ngày sinh :");
		txt_ngaysinh = new JTextField(20);
		Duoileft.add(lbleft3);
		Duoileft.add(txt_ngaysinh);
		JLabel lbleft4 = new JLabel("Giới tính :");
		txt_gioitinh = new JTextField(20);
		Duoileft.add(lbleft4);
		Duoileft.add(txt_gioitinh);
		JLabel lbleft5 = new JLabel("Địa chỉ :");
		txt_diachi = new JTextField(20);
		Duoileft.add(lbleft5);
		Duoileft.add(txt_diachi);
		JLabel lbleft6 = new JLabel("Mã lớp :");
		txt_malop = new JTextField(20);
		Duoileft.add(lbleft6);
		Duoileft.add(txt_malop);
		lbleft1.setPreferredSize(new Dimension(100, 50));
		lbleft2.setPreferredSize(new Dimension(100, 50));
		lbleft3.setPreferredSize(new Dimension(100, 50));
		lbleft5.setPreferredSize(new Dimension(100, 50));
		lbleft4.setPreferredSize(new Dimension(100, 50));
		lbleft6.setPreferredSize(new Dimension(100, 50));
		JPanel aa = new JPanel();
		JLabel lbleft7 = new JLabel("Tìm kiếm :");
		JTextField txt_timkiem = new JTextField(30);
		JButton btntimkiemsv = new JButton("Tìm Kiếm");
		btntimkiemsv.addActionListener(this);
		aa.add(lbleft7);
		aa.add(txt_timkiem);
		aa.add(btntimkiemsv);
		JPanel Duoiright = new JPanel();
		Duoiright.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JPanel subDuoiRight = new JPanel();
		subDuoiRight.setPreferredSize(new Dimension(150, 280));
		addsv = new JButton("Add");
		updatesv = new JButton("UPDATE");
		Deletesv = new JButton("DELETE");
		CLearsv = new JButton("CLEAR");
		addsv.setAlignmentX(Component.CENTER_ALIGNMENT);
		updatesv.setAlignmentX(Component.CENTER_ALIGNMENT);
		Deletesv.setAlignmentX(Component.CENTER_ALIGNMENT);
		CLearsv.setAlignmentX(Component.CENTER_ALIGNMENT);
		subDuoiRight.add(addsv);
		addsv.addActionListener(this);
		subDuoiRight.add(updatesv);
		updatesv.addActionListener(this);
		subDuoiRight.add(Deletesv);
		Deletesv.addActionListener(this);
		subDuoiRight.add(CLearsv);
		CLearsv.addActionListener(this);
		subDuoiRight.setLayout(new BoxLayout(subDuoiRight, BoxLayout.Y_AXIS));
		Duoiright.add(subDuoiRight);
		JSplitPane slit1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Duoileft, Duoiright);
		Duoi.add(aa);
		Duoi.add(slit1);
		JSplitPane slit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Tren, Duoi);
		tab1.add(lb1);
		tab1.add(slit);

		JPanel tab2 = new JPanel();
		tab2.setLayout(new BoxLayout(tab2, BoxLayout.Y_AXIS));

		JPanel qll = new JPanel();
		JLabel quanlygiangvien = new JLabel("Quản Lí Giảng Viên");
		quanlygiangvien.setFont(new Font("Courier New", Font.BOLD, 20));
		qll.add(quanlygiangvien);
		tab2.add(qll);
		JPanel tk = new JPanel();
		tk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JTextField timkiem = new JTextField(15);
		JButton lblTimKiem = new JButton("Tìm Kiếm");
		tk.add(timkiem);
		tk.add(lblTimKiem);
		tab2.add(tk);

		JPanel chitiec = new JPanel();
		chitiec.setLayout(new GridLayout(2, 3));
		JLabel lbgv1 = new JLabel("Mã giảng viên");
		txt_magv = new JTextField(15);
		chitiec.add(lbgv1);
		chitiec.add(txt_magv);
		JLabel lbgv2 = new JLabel("Tên giảng viên");
		txt_tengv = new JTextField(15);
		chitiec.add(lbgv2);
		chitiec.add(txt_tengv);
		JLabel lbgv3 = new JLabel("Giới tính");
		txt_gioitinhgv = new JTextField(15);
		chitiec.add(lbgv3);
		chitiec.add(txt_gioitinhgv);
		JLabel lbgv4 = new JLabel("Phone");
		txt_phone = new JTextField(15);
		chitiec.add(lbgv4);
		chitiec.add(txt_phone);
		JLabel lbgv5 = new JLabel("Email");
		txt_email = new JTextField(15);
		chitiec.add(lbgv5);
		chitiec.add(txt_email);
		JLabel lbgv6 = new JLabel("Phân loại ");
		txt_phanloaigv = new JTextField(15);
		chitiec.add(lbgv6);
		chitiec.add(txt_phanloaigv);

		Border BorderButton1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton1 = new TitledBorder(BorderButton1, "Nhập Thông Tin");
		titledBorderButton1.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton1.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton1.setTitleColor(Color.red);
		chitiec.setBorder(titledBorderButton1);
		tab2.add(chitiec);

		JPanel chucnang = new JPanel();

		addgv = new JButton("ADD");
		addgv.addActionListener(this);
		updategv = new JButton("UPDATE");
		updategv.addActionListener(this);
		deletegv = new JButton("DELETE");
		deletegv.addActionListener(this);
		cleragv = new JButton("CLEAR");
		cleragv.addActionListener(this);
		chucnang.add(addgv);
		chucnang.add(updategv);
		chucnang.add(deletegv);
		chucnang.add(cleragv);
		Border BorderButton2 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton2 = new TitledBorder(BorderButton2, "Chọn Chức Năng");
		titledBorderButton2.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton2.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton2.setTitleColor(Color.red);
		chucnang.setBorder(titledBorderButton2);
		tab2.add(chucnang);

		JPanel table1 = new JPanel();
		table1.setLayout(new BorderLayout());

		taotable2();
		table1.add(sc1);

		tab2.add(table1);

		JPanel tab3 = new JPanel();

		JPanel lb3 = new JPanel();
		JLabel lb31 = new JLabel("Quản Lí Môn Học");
		lb31.setFont(new Font("Courier New", Font.BOLD, 20));
		lb3.add(lb31);
		tab3.add(lb3);
		JPanel leftmon = new JPanel();

		leftmon.setLayout(new BoxLayout(leftmon, BoxLayout.Y_AXIS));
		Border BorderButton3 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderButton3 = new TitledBorder(BorderButton3, "Thông Tin");
		titledBorderButton3.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
		titledBorderButton3.setTitleJustification(TitledBorder.CENTER);
		titledBorderButton3.setTitleColor(Color.red);
		leftmon.setBorder(titledBorderButton3);
		JPanel mamon = new JPanel();
		JLabel mamonlb = new JLabel("Mã Môn");
		txt_mamon = new JTextField(15);
		mamon.add(mamonlb);
		mamon.add(txt_mamon);
		leftmon.add(mamon);
		JPanel tenmon = new JPanel();
		JLabel tenmonlb = new JLabel("Tên Môn");
		cb_tenmon = new JComboBox();
		cb_tenmon.addItem("Mác Lê Nin");
		cb_tenmon.addItem("Tu tuong HCM");
		cb_tenmon.addItem("Lịch Sử Việt Nam");
		cb_tenmon.addItem("Văn Hóa Việt Nam");
		cb_tenmon.addItem("Tin Học");
		tenmon.add(tenmonlb);
		tenmon.add(cb_tenmon);
		leftmon.add(tenmon);
		JPanel magv = new JPanel();
		JLabel magvlb = new JLabel("Mã Giáo Viên");
		txt_magv2 = new JTextField(15);
		magv.add(magvlb);
		magv.add(txt_magv2);
		leftmon.add(magv);
		JPanel hocki = new JPanel();
		JLabel hockilb = new JLabel("Học Kì");
		txt_hocki = new JTextField(15);
		hocki.add(hockilb);
		hocki.add(txt_hocki);
		leftmon.add(hocki);
		JPanel makhoa = new JPanel();
		JLabel makhoalb = new JLabel("Mã Khoa");
		txt_makhoa = new JTextField(15);
		makhoa.add(makhoalb);
		makhoa.add(txt_makhoa);
		leftmon.add(makhoa);
		mamonlb.setPreferredSize(new Dimension(100, 30));
		tenmonlb.setPreferredSize(new Dimension(100, 30));
		magvlb.setPreferredSize(new Dimension(100, 30));
		hockilb.setPreferredSize(new Dimension(100, 30));
		makhoalb.setPreferredSize(new Dimension(100, 30));
		leftmon.setPreferredSize(new Dimension(300, 400));

		JPanel rightmon = new JPanel();
		rightmon.setLayout(new BorderLayout());
		JPanel table2 = new JPanel();
		table2.setLayout(new BorderLayout());

		taotable3();
		table2.add(sc2);

		rightmon.setPreferredSize(new Dimension(580, 400));
		rightmon.add(table2);
		JSplitPane mon = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftmon, rightmon);

		tab3.add(mon);

		JPanel btnmon = new JPanel();
		addmon = new JButton("ADD");
		addmon.addActionListener(this);
		updatemon = new JButton("UPDATE");
		updatemon.addActionListener(this);
		deletemon = new JButton("DELETE");
		deletemon.addActionListener(this);
		clearmon = new JButton("CLEAR");
		clearmon.addActionListener(this);
		btnmon.add(addmon);
		btnmon.add(updatemon);
		btnmon.add(deletemon);
		btnmon.add(clearmon);

		tab3.add(btnmon);

		JPanel tab4 = new JPanel();
		JPanel tab5 = new JPanel();
		JPanel lb5 = new JPanel();
		JLabel lb51 = new JLabel("Quản Lí Kết Quả Sinh Viên");
		lb51.setFont(new Font("Courier New", Font.BOLD, 20));
		lb5.add(lb51);
		tab5.add(lb5);

		JPanel kqtren = new JPanel();
		kqtren.setLayout(new BorderLayout());
		kqtren.setPreferredSize(new Dimension(930, 300));
		JPanel kqtrenleft = new JPanel();

		kqtrenleft.setPreferredSize(new Dimension(300, 300));
		JLabel masvkq = new JLabel("Mã Sinh Viên :");
		txt_masvkq = new JTextField(15);
		kqtrenleft.add(masvkq);
		kqtrenleft.add(txt_masvkq);
		JLabel hotenkq = new JLabel("Họ Tên :");
		txt_hotenkq = new JTextField(15);
		kqtrenleft.add(hotenkq);
		kqtrenleft.add(txt_hotenkq);
		// JLabel malopkq = new JLabel("Mã Lớp :");
		// txt_malopkq = new JTextField(15);
		// kqtrenleft.add(malopkq);
		// kqtrenleft.add(txt_malopkq);
		JLabel hanhkiemkq = new JLabel("Hạnh Kiểm :");
		txt_hanhkiemkq = new JTextField(15);
		kqtrenleft.add(hanhkiemkq);
		kqtrenleft.add(txt_hanhkiemkq);
		JLabel mamonkq = new JLabel("Mã Môn :");
		txt_mamonkq = new JTextField(15);
		kqtrenleft.add(mamonkq);
		kqtrenleft.add(txt_mamonkq);
		masvkq.setPreferredSize(new Dimension(100, 50));
		hotenkq.setPreferredSize(new Dimension(100, 50));
		// malopkq.setPreferredSize(new Dimension(100, 50));
		hanhkiemkq.setPreferredSize(new Dimension(100, 50));
		mamonkq.setPreferredSize(new Dimension(100, 50));

		JPanel kqtrenright = new JPanel();
		kqtrenright.setLayout(new BorderLayout());

		JPanel kqtrenrigthtren = new JPanel();
		kqtrenrigthtren.setLayout(new BorderLayout());
		JPanel kqtrenrigthtrenleft = new JPanel();
		kqtrenrigthtrenleft.setLayout(new BoxLayout(kqtrenrigthtrenleft, BoxLayout.Y_AXIS));
		JLabel dtb = new JLabel("Điểm Trung Bình : ");
		txt_dtb = new JTextField(15);
		kqtrenrigthtrenleft.add(dtb);
		kqtrenrigthtrenleft.add(txt_dtb);
		JLabel diemthilan1 = new JLabel("Điểm Thi Lần 1 : ");
		txt_diemthilan1 = new JTextField(15);
		kqtrenrigthtrenleft.add(diemthilan1);
		kqtrenrigthtrenleft.add(txt_diemthilan1);
		JLabel diemthilan2 = new JLabel("Điểm Thi Lần 2 : ");
		txt_diemthilan2 = new JTextField(15);
		kqtrenrigthtrenleft.add(diemthilan2);
		kqtrenrigthtrenleft.add(txt_diemthilan2);

		JLabel diemtongket = new JLabel("Điểm Tổng Kết : ");
		txt_diemtongket = new JTextField(8);
		kqtrenrigthtrenleft.add(diemtongket);
		kqtrenrigthtrenleft.add(txt_diemtongket);

		kqtrenrigthtrenleft.setPreferredSize(new Dimension(300, 210));
		JPanel kqtrenrigthtrenright = new JPanel();

		Border BorderButton4 = BorderFactory.createLineBorder(Color.blue);

		TitledBorder titledBorderButton4 = new TitledBorder(BorderButton4, "Thông Tin Tìm Kiếm");
		titledBorderButton4.setTitleFont(new Font("Time New Roman", Font.BOLD, 15));
		titledBorderButton4.setTitleJustification(TitledBorder.CENTER);

		kqtrenrigthtrenright.setBorder(titledBorderButton4);
		JPanel radio = new JPanel();
		JRadioButton radiobtn1 = new JRadioButton("Mã Sinh Viên");

		JRadioButton radiobtn2 = new JRadioButton("Lớp");
		radio.add(radiobtn1);
		radio.add(radiobtn2);
		kqtrenrigthtrenright.add(radio);
		radio.setPreferredSize(new Dimension(150, 70));

		JPanel radio2 = new JPanel();
		JTextField timkiemkq = new JTextField(12);
		timkiemkq.setPreferredSize(new Dimension(25, 25));
		JButton btntimkiem = new JButton("Tìm Kiếm");
		radio2.add(timkiemkq);
		radio2.add(btntimkiem);
		kqtrenrigthtrenright.add(radio2);
		radio2.setPreferredSize(new Dimension(150, 70));
		kqtrenrigthtrenright.setPreferredSize(new Dimension(220, 210));
		JSplitPane kqtrenrigthtren1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, kqtrenrigthtrenleft,
				kqtrenrigthtrenright);
		kqtrenrigthtren.add(kqtrenrigthtren1);

		JPanel kqtrenrigthduoi = new JPanel();
		addKetqua = new JButton("ADD");
		addKetqua.addActionListener(this);
		updateketqua = new JButton("UPDATE");
		updateketqua.addActionListener(this);
		deleteketqua = new JButton("DELETE");
		deleteketqua.addActionListener(this);
		clearketqua = new JButton("CLEAR");
		clearketqua.addActionListener(this);
		kqtrenrigthduoi.add(addKetqua);
		kqtrenrigthduoi.add(updateketqua);
		kqtrenrigthduoi.add(deleteketqua);
		kqtrenrigthduoi.add(clearketqua);
		kqtrenrigthduoi.setPreferredSize(new Dimension(530, 50));

		JSplitPane kqtrenright1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, kqtrenrigthtren, kqtrenrigthduoi);
		kqtrenright.add(kqtrenright1);
		kqtrenright.setPreferredSize(new Dimension(530, 300));
		JSplitPane kqtren1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, kqtrenleft, kqtrenright);

		kqtren.add(kqtren1);

		JPanel kqduoi = new JPanel();
		kqduoi.setLayout(new BorderLayout());
		kqduoi.setPreferredSize(new Dimension(930, 300));
		taotablekq();
		kqduoi.add(sckq);
		JSplitPane kq = new JSplitPane(JSplitPane.VERTICAL_SPLIT, kqtren, kqduoi);

		tab5.add(kq);

		JPanel tab6 = new JPanel();

		tabbed.add(tab1, "Sinh viên");
		tabbed.add(tab2, "Giảng viên");
		tabbed.add(tab3, "Môn");
		tabbed.add(tab4, "Lớp");
		tabbed.add(tab5, "Kết quả");
		tabbed.add(tab6, "Khoa");

		Container conn = getContentPane();
		conn.add(tabbed);
	}
	
//	public void timkiem1() {
//		String hoten = txt_hoten.getText();
//		ArrayList<Sinhvien> sinhvien = null;
//		try {
//			if(hoten.equals())
//		}cacth(SQLException e){
//			
//		}
//	}
	
	
	// Sinh viên
	public void taotable1() {
		model = new DefaultTableModel();
		model.addColumn("Mã sinh viên");
		model.addColumn("Họ và Tên");
		model.addColumn("Ngày sinh");
		model.addColumn("Giới tính");
		model.addColumn("Địa chỉ");
		model.addColumn("Mã lớp");
		table = new JTable(model);
		sc = new JScrollPane(table);
		LoadSinhvien();
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				String masv = (String) table.getValueAt(row, 0);
				String hoten = (String) table.getValueAt(row, 1);
				String ngaysinh = (String) table.getValueAt(row, 2);
				String gioitinh = (String) table.getValueAt(row, 3);
				String diachi = (String) table.getValueAt(row, 4);
				String malop = (String) table.getValueAt(row, 5);
				txt_masv.setText(masv);
				txt_hoten.setText(hoten);
				txt_ngaysinh.setText(ngaysinh);
				txt_gioitinh.setText(gioitinh);
				txt_diachi.setText(diachi);
				txt_malop.setText(malop);
			}
		});
	}

	public void LoadSinhvien() {
		model.setRowCount(0);
		DaoSinhVien daosinh = new DaoSinhVien();
		ArrayList<Sinhvien> listSinhvien = daosinh.getAlluser();
		for (Sinhvien sv : listSinhvien) {
			model.addRow(new String[] { sv.getMasv(), sv.getHoten(), sv.getNgaysinh(), sv.getGioitinh(), sv.getDiachi(),
					sv.getMalop() });
		}
	}

	public void Addsv() {
		String masv = txt_masv.getText();
		String hoten = txt_hoten.getText();
		String ngaysinh = txt_ngaysinh.getText();
		String gioitinh = txt_gioitinh.getText();
		String diachi = txt_diachi.getText();
		String malop = txt_malop.getText();
		Sinhvien sv = new Sinhvien();
		sv.setMasv(masv);
		sv.setHoten(hoten);
		sv.setNgaysinh(ngaysinh);
		sv.setGioitinh(gioitinh);
		sv.setDiachi(diachi);
		sv.setMalop(malop);
		DaoSinhVien daosv = new DaoSinhVien();
		daosv.AddSinhVien(sv);

	}

	public void Updatesv() {
		String masv = txt_masv.getText();
		String hoten = txt_hoten.getText();
		String ngaysinh = txt_ngaysinh.getText();
		String gioitinh = txt_gioitinh.getText();
		String diachi = txt_diachi.getText();
		String malop = txt_malop.getText();
		Sinhvien sv = new Sinhvien();
		sv.setMasv(masv);
		sv.setHoten(hoten);
		sv.setNgaysinh(ngaysinh);
		sv.setGioitinh(gioitinh);
		sv.setDiachi(diachi);
		sv.setMalop(malop);
		DaoSinhVien daosv = new DaoSinhVien();
		daosv.UpdateSinhvien(sv);
	}

	public void Deletesv() {
		String masv = txt_masv.getText();
		DaoSinhVien daosv = new DaoSinhVien();
		daosv.DeleteSinhvien(masv);
	}

	public void Cleansv() {
		txt_masv.setText("");
		txt_hoten.setText("");
		txt_ngaysinh.setText("");
		txt_gioitinh.setText("");
		txt_diachi.setText("");
		txt_malop.setText("");
	}

	// Giảng viên

	public void taotable2() {

		model1 = new DefaultTableModel();
		model1.addColumn("Mã giảng viên");
		model1.addColumn("Tên giảng viên");
		model1.addColumn("Giới tính");
		model1.addColumn("Phone");
		model1.addColumn("Email");
		model1.addColumn("Phân loại giảng viên");
		table1 = new JTable(model1);
		table1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table1.getSelectedRow();
				int col = table1.getSelectedColumn();
				String magv = (String) table1.getValueAt(row, 0);
				String tengv = (String) table1.getValueAt(row, 1);
				String gioitinh = (String) table1.getValueAt(row, 2);
				String phone = (String) table1.getValueAt(row, 3);
				String email = (String) table1.getValueAt(row, 4);
				String phanloaigv = (String) table1.getValueAt(row, 5);
				txt_magv.setText(magv);
				txt_tengv.setText(tengv);
				txt_gioitinhgv.setText(gioitinh);
				txt_phone.setText(phone);
				txt_email.setText(email);

				txt_phanloaigv.setText(phanloaigv);

			}
		});
		sc1 = new JScrollPane(table1);
		LoadGiangvien();
	}

	public void LoadGiangvien() {
		model1.setRowCount(0);
		DaoGiangVien daogiangvien = new DaoGiangVien();
		ArrayList<GiangVien> listgiangvien = daogiangvien.getAlluser();
		for (GiangVien qlgv : listgiangvien) {
			model1.addRow(new String[] { qlgv.getMagv(), qlgv.getTengv(), qlgv.getGioitinh(), qlgv.getPhone(),
					qlgv.getEmail(), qlgv.getPhanloaigv() });
		}
	}

	public void AddGiangvien() {
		String magv = txt_magv.getText();
		String tengv = txt_tengv.getText();
		String gioitinh = txt_gioitinhgv.getText();
		String phone = txt_phone.getText();
		String email = txt_email.getText();
		String phanloaigv = txt_phanloaigv.getText();
		GiangVien gv = new GiangVien();
		gv.setMagv(magv);
		gv.setTengv(tengv);
		gv.setGioitinh(gioitinh);
		gv.setPhone(phone);
		gv.setEmail(email);
		gv.setPhanloaigv(phanloaigv);
		DaoGiangVien daogiangvien = new DaoGiangVien();
		daogiangvien.AddGiangvien(gv);
	}

	public void Updategiangvien() {
		String magv = txt_magv.getText();
		String tengv = txt_tengv.getText();
		String gioitinh = txt_gioitinhgv.getText();
		String phone = txt_phone.getText();
		String email = txt_email.getText();
		String phanloaigv = txt_phanloaigv.getText();
		GiangVien gv = new GiangVien();
		gv.setMagv(magv);
		gv.setTengv(tengv);
		gv.setGioitinh(gioitinh);
		gv.setPhone(phone);
		gv.setEmail(email);
		gv.setPhanloaigv(phanloaigv);
		DaoGiangVien daogiangvien = new DaoGiangVien();
		daogiangvien.UpdateGiangvien(gv);
	}

	public void Deletegv() {
		String magv = txt_magv.getText();
		DaoGiangVien daogiangvien = new DaoGiangVien();
		daogiangvien.DeleteGiangvien(magv);
	}

	public void cleargv() {
		txt_magv.setText("");
		txt_tengv.setText("");
		txt_gioitinhgv.setText("");
		txt_phone.setText("");
		txt_email.setText("");
		txt_phanloaigv.setText("");
	}

	// môn

	public void taotable3() {
		model2 = new DefaultTableModel();
		model2.addColumn("Mã Môn");
		model2.addColumn("Tên Môn");
		model2.addColumn("Mã Giảng Viên");
		model2.addColumn("Học Kì");
		model2.addColumn("Mã Khoa");

		table2 = new JTable(model2);
		table2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void setSelectedValue(JComboBox comboBox, String value) {
				for (int i = 0; i < comboBox.getItemCount(); i++) {
					Object item1 = comboBox.getItemAt(i);
					String item = item1.toString();
					if (item.equalsIgnoreCase(value)) {
						comboBox.setSelectedIndex(i);
						break;
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub txt_mamon,txt_magv2,txt_hocki,txt_makhoa;
				int row = table2.getSelectedRow();
				int col = table2.getSelectedColumn();
				String mamon = (String) table2.getValueAt(row, 0);
				String tenmon = (String) table2.getValueAt(row, 1);
				String magv2 = (String) table2.getValueAt(row, 2);
				String hocki = (String) table2.getValueAt(row, 3);
				String makhoa = (String) table2.getValueAt(row, 4);

				txt_mamon.setText(mamon);
				// cb_tenmon.setSelectedItem(tenmon);
				setSelectedValue(cb_tenmon, tenmon);
				txt_magv2.setText(magv2);
				txt_hocki.setText(hocki);
				txt_makhoa.setText(makhoa);

			}
		});
		sc2 = new JScrollPane(table2);
		loadMon();
	}

	public void loadMon() {
		model2.setRowCount(0);
		DaoMon daomon = new DaoMon();
		ArrayList<Mon> listmon = daomon.getAlluser();
		for (Mon mon : listmon) {
			model2.addRow(
					new String[] { mon.getMamon(), mon.getTenmon(), mon.getMagv(), mon.getHocki(), mon.getMakhoa() });
		}
	}

	// txt_mamon,txt_magv2,txt_hocki,txt_makhoa;
	public void addmon() {
		String mamon = txt_mamon.getText();
		String tenmon = (String) cb_tenmon.getSelectedItem();
		String magv = txt_magv2.getText();
		String hocki = txt_hocki.getText();
		String makhoa = txt_makhoa.getText();
		Mon mon = new Mon();
		mon.setMamon(mamon);
		mon.setTenmon(tenmon);
		mon.setMagv(magv);
		mon.setHocki(hocki);
		mon.setMakhoa(makhoa);
		DaoMon daomon = new DaoMon();
		daomon.AddMon(mon);
	}

	public void updatemon() {
		String mamon = txt_mamon.getText();
		String tenmon = (String) cb_tenmon.getSelectedItem();
		String magv = txt_magv2.getText();
		String hocki = txt_hocki.getText();
		String makhoa = txt_makhoa.getText();
		Mon mon = new Mon();
		mon.setMamon(mamon);
		mon.setTenmon(tenmon);
		mon.setMagv(magv);
		mon.setHocki(hocki);
		mon.setMakhoa(makhoa);
		DaoMon daomon = new DaoMon();
		daomon.UpdateMon(mon);
	}

	public void deletemon() {
		String mamon = txt_mamon.getText();
		DaoMon daomon = new DaoMon();
		daomon.DeleteMon(mamon);
	}

	// txt_mamon,txt_magv2,txt_hocki,txt_makhoa;
	public void clearmon() {
		txt_mamon.setText("");
		txt_magv2.setText("");
		txt_hocki.setText("");
		txt_makhoa.setText("");
	}

	public void taotablekq() {
		modelkq = new DefaultTableModel();
		modelkq.addColumn("Mã Sinh Viên");
		modelkq.addColumn("Họ và Tên");
		// modelkq.addColumn("Mã Lớp");
		modelkq.addColumn("Hạnh Kiểm");
		modelkq.addColumn("Mã Môn");
		modelkq.addColumn("Điểm Trung Bình");
		modelkq.addColumn("Điểm Thi Lần 1 ");
		modelkq.addColumn("Điểm Thi Lần 2 ");
		modelkq.addColumn("Điểm Tổng Kết");
		tablekq = new JTable(modelkq);
		tablekq.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tablekq.getSelectedRow();
				int col = tablekq.getSelectedColumn();
				String masv = (String) tablekq.getValueAt(row, 0);
				String hoten = (String) tablekq.getValueAt(row, 1);

				String hanhkiem = (String) tablekq.getValueAt(row, 2);
				String mamon = (String) tablekq.getValueAt(row, 3);
				String diemtb = (String) tablekq.getValueAt(row, 4);
				String diemthilan1 = (String) tablekq.getValueAt(row, 5);
				String diemthilan2 = (String) tablekq.getValueAt(row, 6);
				String diemtongket = (String) tablekq.getValueAt(row, 7);
				txt_masvkq.setText(masv);
				txt_hotenkq.setText(hoten);

				txt_hanhkiemkq.setText(hanhkiem);
				txt_mamonkq.setText(mamon);
				txt_dtb.setText(diemtb);
				txt_diemthilan1.setText(diemthilan1);
				txt_diemthilan2.setText(diemthilan2);
				txt_diemtongket.setText(diemtongket);

			}
		});
		sckq = new JScrollPane(tablekq);
		loadketqua();
	}

	public void loadketqua() {
		modelkq.setRowCount(0);
		DaoKetQua daoketqua = new DaoKetQua();
		ArrayList<Ketqua> listketqua = daoketqua.getAlluser();
		for (Ketqua kq : listketqua) {
			modelkq.addRow(new String[] { kq.getMasv(), kq.getHoten(), kq.getHanhkiem(), kq.getMamon(), kq.getDiemtb(),
					kq.getDiemthilan1(), kq.getDiemthilan2(), kq.getDiemtongket()

			});
		}
	}

	// txt_masvkq,txt_hotenkq,txt_malopkq,txt_hanhkiemkq,txt_mamonkq,txt_dtb,txt_diemthilan1,txt_diemthilan2,txt_diemtongket;
	public void addketqua() {
		String masv = txt_masvkq.getText();
		String hoten = txt_hotenkq.getText();

		String hanhkiem = txt_hanhkiemkq.getText();
		String mamon = txt_mamonkq.getText();
		String diemtb = txt_dtb.getText();
		String diemthilan1 = txt_diemthilan1.getText();
		String diemthilan2 = txt_diemthilan2.getText();
		String diemtongket = txt_diemtongket.getText();
		Ketqua kq = new Ketqua();
		kq.setMasv(masv);
		kq.setHoten(hoten);

		kq.setHanhkiem(hanhkiem);
		kq.setMamon(mamon);
		kq.setDiemtb(diemtb);
		kq.setDiemthilan1(diemthilan1);
		kq.setDiemthilan2(diemthilan2);
		kq.setDiemtongket(diemtongket);
		DaoKetQua daokq = new DaoKetQua();
		daokq.AddKetqua(kq);
	}

	public void updateketqua() {
		String masv = txt_masvkq.getText();
		String hoten = txt_hotenkq.getText();

		String hanhkiem = txt_hanhkiemkq.getText();
		String mamon = txt_mamonkq.getText();
		String diemtb = txt_dtb.getText();
		String diemthilan1 = txt_diemthilan1.getText();
		String diemthilan2 = txt_diemthilan2.getText();
		String diemtongket = txt_diemtongket.getText();
		Ketqua kq = new Ketqua();
		kq.setMasv(masv);
		kq.setHoten(hoten);

		kq.setHanhkiem(hanhkiem);
		kq.setMamon(mamon);
		kq.setDiemtb(diemtb);
		kq.setDiemthilan1(diemthilan1);
		kq.setDiemthilan2(diemthilan2);
		kq.setDiemtongket(diemtongket);
		DaoKetQua daokq = new DaoKetQua();
		daokq.UpdateKetqua(kq);
	}

	public void deletekq() {
		String masv = txt_masvkq.getText();
		DaoKetQua daokq = new DaoKetQua();
		daokq.DeleteKetqua(masv);
		;
	}

	public void clearkq() {
		txt_masvkq.setText("");
		txt_hotenkq.setText("");
		txt_hanhkiemkq.setText("");
		txt_mamonkq.setText("");
		txt_dtb.setText("");
		txt_diemthilan1.setText("");
		txt_diemthilan2.setText("");
		txt_diemtongket.setText("");

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addsv) {

			Addsv();
			LoadSinhvien();
		} else if (e.getSource() == updatesv) {
			Updatesv();
			LoadSinhvien();
		} else if (e.getSource() == Deletesv) {
			Deletesv();
			LoadSinhvien();
		} else if (e.getSource() == CLearsv) {
			Cleansv();
			LoadSinhvien();
		} else if (e.getSource() == addgv) {

			AddGiangvien();
			LoadGiangvien();
		} else if (e.getSource() == updategv) {

			Updategiangvien();
			LoadGiangvien();
		} else if (e.getSource() == deletegv) {

			Deletegv();
			LoadGiangvien();
		} else if (e.getSource() == cleragv) {

			cleargv();
			LoadGiangvien();
		} else if (e.getSource() == addmon) {
			addmon();
			loadMon();
		} else if (e.getSource() == updatemon) {
			updatemon();
			loadMon();

		} else if (e.getSource() == deletemon) {

			deletemon();
			loadMon();
		} else if (e.getSource() == clearmon) {

			clearmon();
			loadMon();
		} else if (e.getSource() == addKetqua) {

			addketqua();
			loadketqua();
		} else if (e.getSource() == updateketqua) {

			updateketqua();
			loadketqua();
		} else if (e.getSource() == deleteketqua) {

			deletekq();
			loadketqua();
		} else if (e.getSource() == clearketqua) {

			clearkq();
			loadketqua();
		}
	}

	// addKetqua , updateketqua, deleteketqua , clearketqua ;clearkq()
	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
