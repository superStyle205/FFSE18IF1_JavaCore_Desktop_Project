package QuanLiHocSinh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class TabBangDiem extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TabBangDiem() {
		setLayout(null);
		setSize(1350, 720);
		
		JLabel label = new JLabel("");
		label.setBounds(576, 70, 46, 14);
		add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(10, 74, 286, 635);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 Th\u1EE9 T\u1EF1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 25, 77, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 13, 132, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblHVTn = new JLabel("H\u1ECD v\u00E0 T\u00EAn");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHVTn.setBounds(10, 86, 77, 14);
		panel.add(lblHVTn);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 79, 132, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTon = new JLabel("To\u00E1n");
		lblTon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTon.setBounds(10, 149, 65, 14);
		panel.add(lblTon);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 149, 132, 31);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblL = new JLabel("L\u00ED");
		lblL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblL.setBounds(10, 242, 65, 14);
		panel.add(lblL);
		
		textField_3 = new JTextField();
		textField_3.setBounds(127, 235, 132, 31);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblHa = new JLabel("H\u00F3a");
		lblHa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHa.setBounds(10, 318, 46, 14);
		panel.add(lblHa);
		
		textField_4 = new JTextField();
		textField_4.setBounds(127, 316, 132, 31);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTin = new JLabel("Tin");
		lblTin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTin.setBounds(10, 400, 46, 14);
		panel.add(lblTin);
		
		textField_5 = new JTextField();
		textField_5.setBounds(127, 398, 132, 40);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTngim = new JLabel("T\u1ED5ng \u0110i\u1EBBm");
		lblTngim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTngim.setBounds(10, 482, 77, 14);
		panel.add(lblTngim);
		
		textField_6 = new JTextField();
		textField_6.setBounds(127, 480, 132, 31);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTrngBnhMn = new JLabel("Tr\u00F9ng B\u00ECnh M\u00F4n");
		lblTrngBnhMn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrngBnhMn.setBounds(0, 544, 106, 14);
		panel.add(lblTrngBnhMn);
		
		textField_7 = new JTextField();
		textField_7.setBounds(127, 542, 132, 31);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblXpLoi = new JLabel("X\u1EBFp Lo\u1EA1i");
		lblXpLoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblXpLoi.setBounds(10, 610, 96, 14);
		panel.add(lblXpLoi);
		
		textField_8 = new JTextField();
		textField_8.setBounds(127, 597, 132, 31);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblBngim = new JLabel("B\u1EA2NG \u0110I\u1EBAM");
		lblBngim.setForeground(Color.RED);
		lblBngim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBngim.setBounds(627, 11, 119, 27);
		add(lblBngim);
	}
	public static void main(String[] args) {
		TabBangDiem tabBangDiem = new TabBangDiem();
		tabBangDiem.setVisible(true);
	}
}
