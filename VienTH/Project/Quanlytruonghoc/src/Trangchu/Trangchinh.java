package Trangchu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trangchinh extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Trangchinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 755);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel.setBounds(0, 0, 1162, 271);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý trường học");
		lblNewLabel.setIcon(new ImageIcon("school.png"));
		lblNewLabel.setBounds(119, 13, 309, 41);
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBounds(0, 273, 1136, 435);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Học Sinh");
		btnNewButton.setIcon(new ImageIcon("student.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(204, 50, 182, 103);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Điểm Số");
		btnNewButton_1.setIcon(new ImageIcon("diem.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(764, 50, 182, 103);
		panel_1.add(btnNewButton_1);

		JButton btnGioVin = new JButton("Giáo Viên");
		btnGioVin.setIcon(new ImageIcon("giaovien.png"));
		btnGioVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGioVin.setBounds(484, 50, 182, 103);
		panel_1.add(btnGioVin);

		JButton btnThngTin = new JButton("Thông Tin\r\n");
		btnThngTin.setIcon(new ImageIcon("thongtin.png"));
		btnThngTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThngTin.setBounds(484, 208, 182, 103);
		panel_1.add(btnThngTin);

		JButton btnTiKhon = new JButton("Tài Khoản\r\n");
		btnTiKhon.setIcon(new ImageIcon("taikhoan.png"));
		btnTiKhon.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTiKhon.setBounds(204, 208, 182, 103);
		panel_1.add(btnTiKhon);

		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.setIcon(new ImageIcon("logout.png"));
		btnngXut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnngXut.setBounds(764, 208, 182, 103);
		panel_1.add(btnngXut);
	}

	public static void main(String[] args) {

		Trangchinh trangchu = new Trangchinh();
		trangchu.setVisible(true);

	}
}
