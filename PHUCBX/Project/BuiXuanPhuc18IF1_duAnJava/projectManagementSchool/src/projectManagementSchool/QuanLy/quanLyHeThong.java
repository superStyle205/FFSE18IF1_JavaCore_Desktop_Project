package projectManagementSchool.QuanLy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class quanLyHeThong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public quanLyHeThong(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addControls();
		addEvents();
	}

	public JPanel addControls() {
		// TODO Auto-generated method stub
		JPanel pnMain = new JPanel();

		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnImg = new JPanel();
		pnImg.setLayout(new FlowLayout(FlowLayout.CENTER));
		ImageIcon img = new ImageIcon("anh.png");
		JLabel lblImg = new JLabel(img);
		pnImg.add(lblImg);
		pnMain.add(pnImg);
		
		JPanel pnHuongDan = new JPanel();
		pnHuongDan.setLayout(new GridLayout(1,2));
			JPanel pnleftHuongDan = new JPanel();
			pnleftHuongDan.setLayout(new BoxLayout(pnleftHuongDan, BoxLayout.Y_AXIS));
				Font font = new Font("Time New Roman",Font.BOLD,25);
				JLabel lblBuoc1 = new JLabel("Bước 1: Kiểm tra và nhập,sửa,xóa,... Lớp và giáo viên");
				lblBuoc1.setFont(font);
				JLabel lblBuoc2 = new JLabel("Bước 2: Kiểm tra và nhập,sửa,xóa... học sinh trong lớp");
				lblBuoc2.setFont(font);
				JLabel lblBuoc3 = new JLabel("Bước 3: Kiểm tra và nhập,sửa,xóa,... môn học");
				lblBuoc3.setFont(font);
				JLabel lblBuoc4 = new JLabel("Bước 4: Kiểm tra và nhập,sửa,xóa,...lương giáo viên");
				lblBuoc4.setFont(font);
				JLabel lblBuoc5 = new JLabel("Bước 5: Kiểm tra và nhập,sửa,xóa,...điểm học sinh");
				lblBuoc5.setFont(font);
				pnleftHuongDan.add(lblBuoc1);
				pnleftHuongDan.add(lblBuoc2);
				pnleftHuongDan.add(lblBuoc3);
				pnleftHuongDan.add(lblBuoc4);
				pnleftHuongDan.add(lblBuoc5);
			pnHuongDan.add(pnleftHuongDan);
			JPanel pnRightHuongDan = new JPanel();
			ImageIcon imgHuongDan = new ImageIcon("Untitled.png");
			JLabel lblImgHuongDan = new JLabel(imgHuongDan);
			pnRightHuongDan.add(lblImgHuongDan);
			pnHuongDan.add(pnRightHuongDan);
		Border BorderHuongDan = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titledBorderChiTiet = new TitledBorder(BorderHuongDan, "Hướng Dẫn Sử Dụng Phần Mềm");
		titledBorderChiTiet.setTitleFont(new Font("Time New Roman", Font.BOLD, 25));
		titledBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titledBorderChiTiet.setTitleColor(Color.red);
		pnHuongDan.setBorder(titledBorderChiTiet);
		pnMain.add(pnHuongDan);
		return pnMain;

	}

	private void addEvents() {
		// TODO Auto-generated method stub

	}

}
