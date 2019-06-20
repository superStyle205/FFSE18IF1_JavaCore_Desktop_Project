package view;
//package Swing;
//
//public class FromThongke {
//	package swing;
//
//	import java.awt.Dimension;
//	import java.awt.GridLayout;
//	import java.awt.event.ActionEvent;
//	import java.awt.event.ActionListener;
//	import java.awt.event.ItemEvent;
//	import java.awt.event.ItemListener;
//	import java.util.List;
//	import javax.swing.JButton;
//	import javax.swing.JComboBox;
//	import javax.swing.JPanel;
//	import javax.swing.JScrollPane;
//	import javax.swing.JSplitPane;
//	import javax.swing.JTable;
//	import javax.swing.JTextField;
//	import javax.swing.table.DefaultTableModel;
//
//import model.dao.TeaCherDao;
//
//
//	public class FormThongKe extends JSplitPane implements ActionListener, ItemListener {
//		private static final long serialVersionUID = 1L;
//		TeaCherDao giaovien = new TeaCherDao();
//		
//		private DefaultTableModel modeltable;
//		private JButton btListThanhVien;
//		private JButton btListTacGia;
//		private JTable tableDanhSach;
//		private JTextField txtTimKiem;
//		private JButton btListNhaXuatBan;
//		private JButton btListTheLoaiSach;
//		private JComboBox <TinhThanhPho> cbMaThanhPho;
//		
//		public FormThongKe() {
//			this.setLeftComponent(khung());
//		}
//		public JPanel khung() {
//			JPanel panel = new JPanel();
//			JPanel baoCao = new JPanel(new GridLayout(1, 6, 5, 5));
//			JPanel bang = new JPanel(new GridLayout(1, 1, 5, 5));
//			
//			txtTimKiem = new JTextField(15);
//			btListTacGia = new JButton("Tác Giả");
//			btListTacGia.addActionListener(this);
//			btListThanhVien = new JButton("Thành Viên");
//			btListThanhVien.addActionListener(this);
//			btListNhaXuatBan = new JButton("Nhà Xuất Bản");
//			btListNhaXuatBan.addActionListener(this);
//			btListTheLoaiSach = new JButton("The Loai Sach");
//			btListTheLoaiSach.addActionListener(this);
//			cbMaThanhPho = new JComboBox<TinhThanhPho>();
//			cbMaThanhPho.setPreferredSize(new Dimension(20, 30));
//			cbMaThanhPho.addItemListener(this);
//			
//			cbMaThanhPho.removeAllItems();
//			List<TinhThanhPho> listTinhThanhPho = thanhPho.getAllTinhThanhPho();
//			cbMaThanhPho.addItem(null);
//			for (TinhThanhPho thanhphoiteam : listTinhThanhPho) {
//				cbMaThanhPho.addItem(thanhphoiteam);
//			}
//			baoCao.add(txtTimKiem);
//			baoCao.add(cbMaThanhPho);
//			baoCao.add(btListThanhVien);
//			baoCao.add(btListNhaXuatBan);
//			baoCao.add(btListTheLoaiSach);
//			baoCao.add(btListTacGia);
//			cbMaThanhPho.addItemListener(this);
//			tableDanhSach = new JTable(modeltable);
//			tableDanhSach.setPreferredSize(new Dimension(750, 2000));
//			JScrollPane jpanel = new JScrollPane(tableDanhSach);
//			jpanel.setPreferredSize(new Dimension(1150, 550));
//			bang.add(jpanel);
//			
//			panel.add(baoCao);
//			panel.add(bang);
//			return panel;
//		}
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			if(e.getSource() == btListTacGia) {
//				modeltable = new DefaultTableModel();
//				modeltable.addColumn("Tên Tác Giã");
//				modeltable.addColumn("Tác Phẩm");
//				modeltable.addColumn("Số Lượng Tồn Kho");
//				modeltable.addColumn("Đã Mượn");
//				tableDanhSach = new JTable(modeltable);
//			}
//			if(e.getSource() == btListThanhVien) {
//				modeltable = new DefaultTableModel();
//				modeltable.addColumn("Tên Thành Viên");
//				modeltable.addColumn("Ngày Mượn");
//				modeltable.addColumn("Tên Sách");
//				List<ThanhVien> listThanhVien = thanhVien.getThongKeTV(txtTimKiem.getText());
//				modeltable.setRowCount(0);
//				for(ThanhVien thanhVienItem : listThanhVien) {
//					modeltable.addRow(new String[] {thanhVienItem.getTentv(),
//							thanhVienItem.getNgayMuon(),
//							thanhVienItem.getTenSach()});
//				}
//				tableDanhSach.setModel(modeltable);
//				
//			}
//			
//			if(e.getSource() == btListNhaXuatBan) {
//				modeltable = new DefaultTableModel();
//				modeltable.addColumn("Tên Nhà Xuất Bản");
//				modeltable.addColumn("Tên Sách");
//				modeltable.addColumn("Tồn Kho");
//				modeltable.addColumn("Đã Mượn");
//			}
//			
//			if(e.getSource() == btListTheLoaiSach) {
//				modeltable = new DefaultTableModel();
//				modeltable.addColumn("Tên Thể Loại Sách");
//				modeltable.addColumn("Tồn Kho");
//				modeltable.addColumn("Đã Mượn");
//			}
//		}
//		@Override
//		public void itemStateChanged(ItemEvent arg0) {
//			modeltable = new DefaultTableModel();
//			modeltable.addColumn("Tên Thành Viên");
//			modeltable.addColumn("Ngày Mượn");
//			modeltable.addColumn("Tên Sách");
//			String maThanhPho = ((TinhThanhPho) cbMaThanhPho.getSelectedItem()).getMatp();
//			List<ThanhVien> listThanhVien = thanhVien.getThongKe(maThanhPho);
//			modeltable.setRowCount(0);
//			for(ThanhVien thanhVienItem : listThanhVien) {
//				modeltable.addRow(new String[] {thanhVienItem.getTentv(),
//						thanhVienItem.getNgayMuon(),
//						thanhVienItem.getTenSach()});
//			}
//			tableDanhSach.setModel(modeltable);
//			
//		}
//
//	}
//
//}
