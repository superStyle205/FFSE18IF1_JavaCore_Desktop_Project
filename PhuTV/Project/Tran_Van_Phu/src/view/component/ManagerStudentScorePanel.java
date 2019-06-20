package view.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.bean.Score;
import model.dao.ScoreDao;

public class ManagerStudentScorePanel extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	public static final String TAB_NAME = "Quản Lý Điểm Học Sinh";
	public static final ImageIcon TAB_ICON = new ImageIcon("bangdiem.png");
	
	private JPanel contentPanel;
	private JPanel pnButton;
	private JPanel pnTableScore;

	private JButton btnAddScore;
	private JButton btnUpdateScore;
	private JButton btnDeleteScore;
	private JButton btnCleanScore;
	private JButton btnLoad;

	private JTextField txtTimKiem;
	private JButton btnSearch;
	private JLabel lblTiemKiem;
	
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JScrollPane jScrollPane;
	
	private ScoreDao scoreDao;
	
	private JLabel lblMaHocSinh;
	private JLabel lblMaMonHoc;
	private JLabel lblDiemDauNam;
	private JLabel lblDiemGiuaKy;
	private JLabel lblDiemCuoiKy;
	private JLabel lblDiemTongKet;
	
	private JTextField txtMaHocSinh;
	private JTextField txtMaMonHoc;
	private JTextField txtDiemDauNam;
	private JTextField txtDiemGiuaKy;
	private JTextField txtDiemCuoiKy;
	private JTextField txtDiemTongKet;

	public ManagerStudentScorePanel() {
		setBackground(Color.green);
		setBounds(60, 50, 1800, 965);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		scoreDao = new ScoreDao();
		initScreen();
	}

	private void initScreen() {
		JPanel panel = new JPanel();
		JLabel lblQuanLyBangDiem = new JLabel("QUẢN  LÝ  BẢNG ĐIỂM");
		lblQuanLyBangDiem.setFont(new Font("SVN-Agency FB", Font.BOLD, 30));
		lblQuanLyBangDiem.setAlignmentX(CENTER_ALIGNMENT);
		add(lblQuanLyBangDiem);
		
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(12, 72, 539, 738);
		add(panel);
		panel.setLayout(null);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông Tin Bảng Điểm",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBounds(10, 10, 570, 815);
		panel.add(contentPanel);
		contentPanel.setLayout(null);
		
		lblMaHocSinh = new JLabel(" Mã Học Sinh :");
		lblMaHocSinh.setFont(new Font("SVN-Agency FB", Font.BOLD, 23));
		lblMaHocSinh.setBounds(12, 64, 122, 33);
		contentPanel.add(lblMaHocSinh);
		
		txtMaHocSinh = new JTextField();
		txtMaHocSinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMaHocSinh.setColumns(10);
		txtMaHocSinh.setBounds(146, 64, 412, 35);
		contentPanel.add(txtMaHocSinh);
		
		lblMaMonHoc = new JLabel("Mã Môn Học :");
		lblMaMonHoc.setFont(new Font("SVN-Agency FB", Font.BOLD, 23));
		lblMaMonHoc.setBounds(12, 172, 122, 33);
		contentPanel.add(lblMaMonHoc);
		
		txtMaMonHoc = new JTextField();
		txtMaMonHoc.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMaMonHoc.setColumns(10);
		txtMaMonHoc.setBounds(146, 172, 412, 35);
		contentPanel.add(txtMaMonHoc);
		
		lblDiemDauNam = new JLabel("Điểm Đầu Năm :");
		lblDiemDauNam.setFont(new Font("SVN-Agency FB", Font.BOLD, 23));
		lblDiemDauNam.setBounds(12, 296, 122, 33);
		contentPanel.add(lblDiemDauNam);
		
		txtDiemDauNam = new JTextField();
		txtDiemDauNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDiemDauNam.setColumns(10);
		txtDiemDauNam.setBounds(146, 294, 412, 35);
		contentPanel.add(txtDiemDauNam);
		
		lblDiemGiuaKy = new JLabel("Điểm Giữa Kỳ :");
		lblDiemGiuaKy.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		lblDiemGiuaKy.setBounds(12, 414, 122, 33);
		contentPanel.add(lblDiemGiuaKy);
		
		txtDiemGiuaKy = new JTextField();
		txtDiemGiuaKy.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDiemGiuaKy.setColumns(10);
		txtDiemGiuaKy.setBounds(146, 412, 412, 35);
		contentPanel.add(txtDiemGiuaKy);
		
		lblDiemCuoiKy = new JLabel("Điểm Cuối Kỳ :");
		lblDiemCuoiKy.setFont(new Font("SVN-Agency FB", Font.BOLD, 23));
		lblDiemCuoiKy.setBounds(12, 534, 122, 33);
		contentPanel.add(lblDiemCuoiKy);
		
		txtDiemCuoiKy = new JTextField();
		txtDiemCuoiKy.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDiemCuoiKy.setColumns(10);
		txtDiemCuoiKy.setBounds(146, 532, 412, 35);
		contentPanel.add(txtDiemCuoiKy);
		
		lblDiemTongKet = new JLabel("Điểm Tổng Kết :");
		lblDiemTongKet.setFont(new Font("SVN-Agency FB", Font.BOLD, 23));
		lblDiemTongKet.setBounds(12, 670, 122, 33);
		contentPanel.add(lblDiemTongKet);
		
		txtDiemTongKet = new JTextField();
		txtDiemTongKet.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDiemTongKet.setColumns(10);
		txtDiemTongKet.setBounds(146, 668, 412, 35);
		contentPanel.add(txtDiemTongKet);
		
		// them button
		pnButton = new JPanel();
		pnButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnButton.setBounds(592, 13, 1173, 236);
		panel.add(pnButton);
		pnButton.setLayout(null);

		btnAddScore = new JButton("ADD");
		btnAddScore.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\add.png"));
		btnAddScore.setForeground(Color.RED);
		btnAddScore.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnAddScore.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAddScore.setBounds(58, 129, 152, 77);
		pnButton.add(btnAddScore);
		btnAddScore.addActionListener(this);

		btnUpdateScore = new JButton("UPDATE");
		btnUpdateScore.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\refresh.png"));
		btnUpdateScore.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUpdateScore.setForeground(Color.RED);
		btnUpdateScore.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnUpdateScore.setBounds(344, 129, 152, 77);
		pnButton.add(btnUpdateScore);
		btnUpdateScore.addActionListener(this);

		btnDeleteScore = new JButton("DELETE");
		btnDeleteScore.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\delete.png"));
		btnDeleteScore.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDeleteScore.setForeground(Color.RED);
		btnDeleteScore.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnDeleteScore.setBounds(639, 129, 152, 77);
		pnButton.add(btnDeleteScore);
		btnDeleteScore.addActionListener(this);

		btnCleanScore = new JButton("CLEAN");
		btnCleanScore.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\eraser.png"));
		btnCleanScore.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCleanScore.setForeground(Color.RED);
		btnCleanScore.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		btnCleanScore.setBounds(941, 129, 152, 77);
		pnButton.add(btnCleanScore);
		btnCleanScore.addActionListener(this);

		lblTiemKiem = new JLabel("Tìm Kiếm(ML)");
		lblTiemKiem.setFont(new Font("SVN-Agency FB", Font.BOLD, 25));
		lblTiemKiem.setBounds(22, 13, 142, 46);
		pnButton.add(lblTiemKiem);
//		getRootPane().setDefaultButton(btnSearch);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(166, 13, 806, 46);
		pnButton.add(txtTimKiem);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\loupe.png"));
		btnSearch.setBounds(984, 13, 62, 46);
		pnButton.add(btnSearch);
		
		btnLoad = new JButton("");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object action = e.getSource();
				if (action == btnLoad) {
					loadDataScore();
				}
			}
		});
		btnLoad.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\folder.png"));
		btnLoad.setBounds(1063, 13, 62, 46);
		pnButton.add(btnLoad);
		btnSearch.addActionListener(this);
	
		
		// table
		pnTableScore = new JPanel();
		pnTableScore.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTableScore.setBounds(592, 262, 1173, 563);
		panel.add(pnTableScore);
		pnTableScore.setLayout(null);
		
		tableModel = new DefaultTableModel();

		tableModel.addColumn("Số Thứ Tự");
		tableModel.addColumn("Mã Học Sinh");
		tableModel.addColumn("Mã Môn Học");
		tableModel.addColumn("Điểm Đầu Năm");
		tableModel.addColumn("Điểm Giữa Kỳ");
		tableModel.addColumn("Điểm Cuối Kỳ");
		tableModel.addColumn("Điểm Tổng Kết");

		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(12, 13, 1149, 537);
		jScrollPane.setMaximumSize(new Dimension(1300, 300));
		jTable.addMouseListener(this);
		pnTableScore.add(jScrollPane);
		
		loadDataScore();
	}

	private void loadDataScore() {
		tableModel.setRowCount(0);
		List<Score> listData = scoreDao.getData();
		for (Score scoreStudent : listData){
			tableModel.addRow(new String[] {"" +scoreStudent.getStt(), scoreStudent.getMaHocSinh(), scoreStudent.getMaMonHoc(), scoreStudent.getDiemDauNam(), scoreStudent.getDiemGiuaKy(),
					scoreStudent.getDiemCuoiKy(), scoreStudent.getDiemCuoiKy()});
		}		
	}
	
	private void addScoreStudent(){
		Score scoreStudent = new Score();
		
		scoreStudent.setMaHocSinh(txtMaHocSinh.getText());
		scoreStudent.setMaMonHoc(txtMaMonHoc.getText());
		scoreStudent.setDiemDauNam(txtDiemDauNam.getText());
		scoreStudent.setDiemGiuaKy(txtDiemGiuaKy.getText());
		scoreStudent.setDiemCuoiKy(txtDiemCuoiKy.getText());
		scoreStudent.setDiemTongKet(txtDiemTongKet.getText());
		
		scoreDao.addScore(scoreStudent);
		JOptionPane.showMessageDialog(null, "Bạn Đã Thêm Điểm Học Sinh Thành Công " );
	}

	private void updateScoreStudent(){
		Score scoreStudent = new Score();
		
		int rowSelected = jTable.getSelectedRow();
		
		scoreStudent.setStt(Integer.parseInt((String) jTable.getValueAt(rowSelected, 0)));
		scoreStudent.setMaHocSinh(txtMaHocSinh.getText());
		scoreStudent.setMaMonHoc(txtMaMonHoc.getText());
		scoreStudent.setDiemDauNam(txtDiemDauNam.getText());
		scoreStudent.setDiemGiuaKy(txtDiemGiuaKy.getText());
		scoreStudent.setDiemCuoiKy(txtDiemCuoiKy.getText());
		scoreStudent.setDiemTongKet(txtDiemTongKet.getText());
		
		scoreDao.updateScore(scoreStudent);
		JOptionPane.showMessageDialog(null, "Bạn Đã Sửa Điểm Học Sinh Thành Công " );
	}
	private void deleteScoreStudent(){
		String Stt = (String) jTable.getValueAt(jTable.getSelectedRow(),0);
		
		scoreDao.deleteScore(Stt);
		JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Thành Công Điểm Học Sinh ");
	}
	
	private void cleanClassStudent(){
		txtMaHocSinh.setText("");
		txtMaMonHoc.setText("");
		txtDiemDauNam.setText("");
		txtDiemGiuaKy.setText("");
		txtDiemCuoiKy.setText("");
		txtDiemTongKet.setText("");
	}
	
	private void searchScoreStudent(){
		tableModel.setRowCount(0);
		String Stt = txtTimKiem.getText();
		
		Score scoreStudent = new Score();
		scoreStudent = scoreDao.searchScore(Stt);
		
		tableModel.addRow(new String[] {"" +scoreStudent.getStt(), scoreStudent.getMaHocSinh(), scoreStudent.getMaMonHoc(), scoreStudent.getDiemDauNam(), scoreStudent.getDiemGiuaKy(),
				scoreStudent.getDiemCuoiKy(), scoreStudent.getDiemCuoiKy()});
		JOptionPane.showMessageDialog(null, "Bạn Đã Tìm Điểm Học Sinh Thành Công");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelected = jTable.getSelectedRow();
		
		txtMaHocSinh.setText((String) jTable.getValueAt(rowSelected, 1));
		txtMaMonHoc.setText((String) jTable.getValueAt(rowSelected, 2));
		txtDiemDauNam.setText((String) jTable.getValueAt(rowSelected, 3));
		txtDiemGiuaKy.setText((String) jTable.getValueAt(rowSelected, 4));
		txtDiemCuoiKy.setText((String) jTable.getValueAt(rowSelected, 5));
		txtDiemTongKet.setText((String) jTable.getValueAt(rowSelected, 6));
		
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
		Object action = e.getSource();
		if (action == btnAddScore) {
			addScoreStudent();
			loadDataScore();
		} else if (action == btnUpdateScore) {
			updateScoreStudent();
			loadDataScore();
		} else if (action == btnDeleteScore) {
			deleteScoreStudent();
			loadDataScore();
		} else if (action == btnSearch) {
			searchScoreStudent();
		} else {
			cleanClassStudent();
		}
	}
}
