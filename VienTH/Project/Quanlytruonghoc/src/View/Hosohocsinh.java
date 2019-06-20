package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Model.bean.DanhMucLop;
import Model.bean.Hoso;

public class Hosohocsinh extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	JComboBox<DanhMucLop> cboDanhMuc;
	JList<Hoso> listHocSinh;
	JTextField txtMa, txtTen, txtNgaySinh, txtGioiTinh, txtLop, txtQueQuan;
	JButton btnLuu, btnSuu, btnXoa, btnThoat;

	public Hosohocsinh() {
		super("Hồ sơ học sinh");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

//			Danh mục
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pnDanhMuc = new JPanel();
		pnDanhMuc.setLayout(new FlowLayout());
		pnMain.add(pnDanhMuc);
		JLabel lblDanhMuc = new JLabel("Chọn Danh Mục");
		cboDanhMuc = new JComboBox<DanhMucLop>();
		cboDanhMuc.setPreferredSize(new Dimension(200, 30));
		pnDanhMuc.add(lblDanhMuc);
		pnDanhMuc.add(cboDanhMuc);
		Container con = getContentPane();
		con.add(pnMain);

//			Danh Sách và chi tiết
		JPanel pnDanhSachvaChiTet = new JPanel();
		pnDanhSachvaChiTet.setLayout(new GridLayout(1, 2));
		pnMain.add(pnDanhSachvaChiTet);
		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setLayout(new BorderLayout());
//			Danh sách
		Border borderDanhSach = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderDanhSach = new TitledBorder(borderDanhSach, "Danh sách học sinh");
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.RED);
		pnDanhSach.setBorder(titleBorderDanhSach);

		listHocSinh = new JList<Hoso>();
		JScrollPane sc = new JScrollPane(listHocSinh, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnDanhSach.add(sc, BorderLayout.CENTER);
		pnDanhSachvaChiTet.add(pnDanhSach);
//			Chi tiết
		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new GridLayout(2, 4));

		Border borderChitiet = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderChitiet = new TitledBorder(borderChitiet, "Chi tiết học sinh");
		titleBorderChitiet.setTitleJustification(TitledBorder.CENTER);
		titleBorderChitiet.setTitleColor(Color.RED);
		pnChiTiet.setBorder(titleBorderChitiet);

		pnDanhSachvaChiTet.add(pnChiTiet);

		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout());
		JLabel lblMa = new JLabel("Mã học sinh :");
		txtMa = new JTextField(13);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnChiTiet.add(pnMa);

		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Tên học sinh :");
		txtTen = new JTextField(13);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnChiTiet.add(pnTen);

		JPanel pnNgaysinh = new JPanel();
		pnNgaysinh.setLayout(new FlowLayout());
		JLabel lblNgaySinh = new JLabel(" Ngày sinh :");
		txtNgaySinh = new JTextField(13);
		pnNgaysinh.add(lblNgaySinh);
		pnNgaysinh.add(txtNgaySinh);
		pnChiTiet.add(pnNgaysinh);

		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setLayout(new FlowLayout());
		JLabel lblGioiTinh = new JLabel("Giới tính :");
		txtGioiTinh = new JTextField(13);
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(txtGioiTinh);
		pnChiTiet.add(pnGioiTinh);

		JPanel pnQueQuan = new JPanel();
		pnQueQuan.setLayout(new FlowLayout());
		JLabel lblQueQuan = new JLabel("Quê quán :");
		txtQueQuan = new JTextField(13);
		pnQueQuan.add(lblQueQuan);
		pnQueQuan.add(txtQueQuan);
		pnChiTiet.add(pnQueQuan);

		JPanel pnLop = new JPanel();
		pnLop.setLayout(new FlowLayout());
		JLabel lblLop = new JLabel("Học lớp :");
		txtLop = new JTextField(13);
		pnLop.add(lblLop);
		pnLop.add(txtLop);
		pnChiTiet.add(pnLop);

		pnDanhSachvaChiTet.add(pnChiTiet);
		JPanel pnButton = new JPanel();

		Border borderButton = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderButton = new TitledBorder(borderButton, "Các chức năng");
		titleBorderButton.setTitleJustification(TitledBorder.CENTER);
		titleBorderButton.setTitleColor(Color.RED);
		pnButton.setBorder(titleBorderButton);

		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnLuu = new JButton("Lưu");
		btnSuu = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");

		pnButton.add(btnLuu);
		pnButton.add(btnSuu);
		pnButton.add(btnXoa);
		pnButton.add(btnThoat);
		pnMain.add(pnButton);

		lblMa.setPreferredSize(lblTen.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTen.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTen.getPreferredSize());
		lblQueQuan.setPreferredSize(lblTen.getPreferredSize());
		lblLop.setPreferredSize(lblTen.getPreferredSize());

	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Hosohocsinh hshs = new Hosohocsinh();
		hshs.setVisible(true);
	}

}
