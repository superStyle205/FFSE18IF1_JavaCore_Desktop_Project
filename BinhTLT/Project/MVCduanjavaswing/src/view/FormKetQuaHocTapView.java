package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Lop;
import model.dao.KetQuaHocTapDao;
import model.dao.LopHocDao;

public class FormKetQuaHocTapView extends JFrame implements ActionListener, MouseListener{

	
	
	private JButton btnAdd, btnUpdate, btnDelete, btnClean;
	private JLabel lblqlmm;
	private JScrollPane jScrollPane;
	private JLabel lblmhs;
	private JTextField mhs;
	private JLabel lblmalop;
	private JComboBox malop;
	private JLabel lblhoten;
	private JTextField txthoten;
	private JLabel lblhocluc;
	private JComboBox hocluc;
	private JLabel lblhk;
	private JComboBox hanhkiem;
	private JLabel lblgpa;
	private JTextField txtgpa;
	private JLabel lblxeploai;
	private JTextField txtxeploai;
	private JLabel lblnienkhoa;
	private JComboBox nienkhoa;
	
	private JTable table;
	private DefaultTableModel tablemodel;
	
	private KetQuaHocTapDao kthtdao;
	
	
	// thêm icon cho các tap và các nút button thêm , sửa , xóa , clean,.
	ImageIcon imageIconAdd = new ImageIcon("add.png");
	ImageIcon imageIconUpdate = new ImageIcon("update.png");
	ImageIcon imageIconDelete = new ImageIcon("delete.png");
	ImageIcon imageIconClean = new ImageIcon("clean.png");
	ImageIcon imageIconSearch = new ImageIcon("searchh.png");
	ImageIcon imageIconQLHS = new ImageIcon("student.png");
	ImageIcon imageIconQLGV = new ImageIcon("classroom.png");
	ImageIcon imageIconHSHS = new ImageIcon("folder.png");
	ImageIcon imageIconDIEM = new ImageIcon("diem.png");
	ImageIcon imageIconThongke = new ImageIcon("tk.png");
	ImageIcon imageIconMonhoc = new ImageIcon("book.png");
	ImageIcon imageIconbinh = new ImageIcon("howto.gif");
		
	public void chayketquahoctap(){
		setSize(1200, 700);
		setTitle("Kết Quả Học Tập");
		setVisible(true);
	
		add(managerTab());
	}
	//hàm chạy tap
	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();
		JPanel kqht = ketquahoctap();
		myTabled.addTab("Quản Lí Môn Học", imageIconMonhoc, kqht);
		return myTabled;
	}
	
	//ham quản lí tất cả các giá trị thêm vào
	public JPanel ketquahoctap() {
		JPanel pnMain = new JPanel();
		Container conn = getContentPane();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);
		
		JPanel lblqlm = new JPanel();
		lblqlmm = new JLabel("KẾT QUẢ HỌC TẬP");
		lblqlmm.setForeground(Color.BLUE);
		lblqlmm.setFont(new Font("Time New Roman", Font.BOLD, 30));
		lblqlm.add(lblqlmm);
		pnMain.add(lblqlm);
		
		//khhu vực layout jcombobox
				JPanel pnComborBox = new JPanel();
				JPanel pnComborBox2 = new JPanel();
				pnComborBox.setLayout(new FlowLayout());
				lblmhs = new JLabel("Mã Học Sinh");
				mhs = new JTextField(10);
				
				lblmalop = new  JLabel("Mã Lớp");
				malop = new JComboBox<>();
				malop.addItem("lp111");
				malop.addItem("lp123");
				malop.addItem("lp190");
				
				lblhoten = new JLabel("Họ Tên");
				txthoten =  new JTextField(10);
				lblhocluc = new JLabel("Học Lực");
				hocluc = new JComboBox<>();
				hocluc.addItem("");
				hocluc.addItem("Giỏi");
				hocluc.addItem("Khá");
				hocluc.addItem("Trung Bình");
				hocluc.addItem("Yếu");
				
				lblhk = new JLabel("Hạnh Kiểm");
				hanhkiem = new JComboBox<>();
				hanhkiem.addItem("");
				hanhkiem.addItem("Tốt");
				hanhkiem.addItem("Khá");
				hanhkiem.addItem("Trung Bình");
				hanhkiem.addItem("Yếu");
				
				lblgpa = new JLabel("Điểm Trung Bình");
				txtgpa =  new JTextField(10);
				
				lblxeploai = new JLabel("Xếp Loại");
				txtxeploai = new JTextField(10);
				
				lblnienkhoa = new JLabel("Niên Khóa");
				nienkhoa = new JComboBox<>();
				nienkhoa.addItem("");
				nienkhoa.addItem("2018-2020");
				
				lblhk.setPreferredSize(lblmhs.getPreferredSize());
				hanhkiem.setPreferredSize(lblmhs.getPreferredSize());
			
				lblxeploai.setPreferredSize(lblmhs.getPreferredSize());
				
				pnComborBox.add(lblmhs);
				pnComborBox.add(mhs);
				pnComborBox.add(lblmalop);
				pnComborBox.add(malop);
				pnComborBox.add(lblhoten);
				pnComborBox.add(txthoten);
				pnComborBox.add(lblhocluc);
				pnComborBox.add(hocluc);
				pnComborBox2.add(lblhk);
				pnComborBox2.add(hanhkiem);
				pnComborBox2.add(lblgpa);
				pnComborBox2.add(txtgpa);
				pnComborBox2.add(lblxeploai);
				pnComborBox2.add(txtxeploai);
				pnComborBox2.add(lblnienkhoa);
				pnComborBox2.add(nienkhoa);
				
				pnMain.add(pnComborBox);
				pnMain.add(pnComborBox2);
				
				
				JPanel pnButton = new JPanel();
				pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));

				Border BorderButton = BorderFactory.createLineBorder(Color.blue);
				TitledBorder titledBorderButton = new TitledBorder(BorderButton, "Chọn Chức Năng");
				titledBorderButton.setTitleFont(new Font("Time New Roman", Font.BOLD, 20));
				titledBorderButton.setTitleJustification(TitledBorder.CENTER);
				titledBorderButton.setTitleColor(Color.red);
				pnButton.setBorder(titledBorderButton);

				btnAdd = new JButton("Add");
				btnUpdate = new JButton("Update");
				btnDelete = new JButton("Delete");
				btnClean = new JButton("Clean");

				pnButton.add(btnAdd);
				pnButton.add(btnUpdate);
				pnButton.add(btnDelete);
				pnButton.add(btnClean);

				btnAdd.setForeground(Color.blue);
				btnUpdate.setForeground(Color.blue);
				btnDelete.setForeground(Color.blue);
				btnClean.setForeground(Color.blue);

				btnAdd.setPreferredSize(btnUpdate.getPreferredSize());
				btnDelete.setPreferredSize(btnUpdate.getPreferredSize());
				btnClean.setPreferredSize(btnUpdate.getPreferredSize());
				pnMain.add(pnButton);
				
				
				//panel cho các bản table
				JPanel pntable= new JPanel();
				pntable.setLayout(new BoxLayout(pntable, BoxLayout.Y_AXIS));
				tablemodel = new DefaultTableModel();
				
				tablemodel.addColumn("Mã Học Sinh");
				tablemodel.addColumn("Mã Lớp ");
				tablemodel.addColumn("Họ Tên");
				tablemodel.addColumn("Học Lực");
				tablemodel.addColumn("Hạnh Kiểm");
				tablemodel.addColumn("Điểm Trung Bình");
				tablemodel.addColumn("Xếp Loại");
				tablemodel.addColumn("Tên Niên Khóa");
				
				table = new JTable(tablemodel);
				table.addMouseListener(this);
				jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				pntable.add(jScrollPane);

				pnMain.add(pntable);

				return pnMain;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = table.getSelectedRow();
		mhs.setText((String) table.getValueAt(rowSelected, 0));
		txthoten.setText((String) table.getValueAt(rowSelected, 1));
		txtgpa.setText((String) table.getValueAt(rowSelected, 2));
		txtxeploai.setText((String) table.getValueAt(rowSelected, 3));
		
	}
	
	
	private void clear() {
		mhs.setText("");
		malop.setSelectedItem("");
		txthoten.setText("");
		hocluc.setSelectedItem("");
		hanhkiem.setSelectedItem("");
		txtgpa.setText("");
		txtxeploai.setText("");
		nienkhoa.setSelectedItem("");
		
	}

	private void deleteUser() {
		kthtdao = new KetQuaHocTapDao();
//		+

	}

	private void updateUser() {
		Lop hs = new Lop();
		hs.setMalop(malop.getSelectedItem().toString());
		hs.setTenlop(txttenlop.getText());
		hs.setGvchu_nghiem(txtgvch.getText());
		hs.setMakhoa(makhoa.getSelectedItem().toString());
		hs.setMakhoi(makhoi.getSelectedItem().toString());
		hs.setTennienkhoa(nienkhoa.getSelectedItem().toString());
		
		lopdao = new LopHocDao();
		lopdao.updateUser(hs);
	}

	private void addUser() {
		Lop hs = new Lop();
		hs.setMalop(malop.getSelectedItem().toString());
		hs.setTenlop(txttenlop.getText());
		hs.setGvchu_nghiem(txtgvch.getText());
		hs.setMakhoa(makhoa.getSelectedItem().toString());
		hs.setMakhoi(makhoi.getSelectedItem().toString());
		hs.setTennienkhoa(nienkhoa.getSelectedItem().toString());
		
		lopdao = new LopHocDao();
		lopdao.updateUser(hs);

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
		
		
	}
		public static void main(String[] args) {
			FormKetQuaHocTapView kqht = new FormKetQuaHocTapView();
			kqht.chayketquahoctap();
		}
	
}
