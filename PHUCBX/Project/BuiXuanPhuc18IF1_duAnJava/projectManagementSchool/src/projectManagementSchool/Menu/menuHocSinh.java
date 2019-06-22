package projectManagementSchool.Menu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import projectManagementSchool.QuanLy.QuanLyDiemTungMon;
import projectManagementSchool.QuanLy.QuanLyHoSoHocSinh;
import projectManagementSchool.QuanLy.QuanLyLop;

public class menuHocSinh extends JFrame implements ActionListener, MouseListener {

	private QuanLyLop qlLop = new QuanLyLop("");
	private QuanLyHoSoHocSinh qlHoSoHocSinh = new QuanLyHoSoHocSinh("");
	private QuanLyDiemTungMon qlDiemTungMon = new QuanLyDiemTungMon("");
	private static final long serialVersionUID = 1L;

	public menuHocSinh(String title) {

		super(title);
		addControls();
		addEvents();

	}
	
	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	public void showWindown() {
		this.setSize(new Dimension(getMaximumSize()));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void addControls() {
		Container conn = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);

		JPanel pnCtrlsQuanLyLop = qlLop.addControls();
		JPanel pnCtrlsQuanLyHoSoHocSinh = qlHoSoHocSinh.addControls();
		JPanel pnCtrlsQuanLyDiemTungMon = qlDiemTungMon.addControls();
		JTabbedPane myTabled = new JTabbedPane();
		myTabled.addTab("Quản Lý Học Sinh", null, pnCtrlsQuanLyLop);
		myTabled.addTab("Quản Lý Hồ Sơ Học Sinh", null, pnCtrlsQuanLyHoSoHocSinh);
		myTabled.addTab("Quản Lý Điểm Từng Môn", null, pnCtrlsQuanLyDiemTungMon);

		pnMain.add(myTabled);
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

}
