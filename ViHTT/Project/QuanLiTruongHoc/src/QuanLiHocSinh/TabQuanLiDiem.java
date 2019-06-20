package QuanLiHocSinh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TabQuanLiDiem extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_6;
	private DefaultTableModel table;
	private JTable jTable;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TabQuanLiDiem() {
		setLayout(null);
		setSize(1350, 720);
		
		JLabel lblQunLim = new JLabel("QU\u1EA2N L\u00CD \u0110I\u1EC2M");
		lblQunLim.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLim.setForeground(Color.RED);
		lblQunLim.setBounds(571, 44, 150, 33);
		add(lblQunLim);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(0, 110, 291, 525);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 th\u1EE9 t\u1EF1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 45, 86, 25);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 44, 113, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1EDBp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 234, 67, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00F4n H\u1ECDc");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setBounds(10, 307, 67, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 301, 113, 31);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110i\u1EC3m gi\u1EEFa k\u1EF3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 378, 101, 25);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 377, 113, 31);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("M\u00E3 H\u1ECDc Sinh");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 104, 86, 25);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(134, 103, 113, 31);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("T\u00EAn H\u1ECDc Sinh");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 167, 97, 31);
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(134, 169, 113, 31);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 240, 113, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("N\u0103m H\u1ECDc");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(39, 581, 97, 14);
		panel.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 565, 113, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u0110i\u1EC3m cu\u1ED1i k\u1EF3");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 454, 101, 25);
		panel.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(134, 453, 113, 31);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(311, 89, -2, -3);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(Color.GRAY));
		panel_2.setBounds(294, 511, 1046, 124);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(72, 41, 121, 48);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("S\u1EEDa");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(258, 41, 121, 48);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X\u00F3a");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(467, 41, 121, 48);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clean");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(689, 41, 121, 48);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("In");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(919, 41, 105, 48);
		panel_2.add(btnNewButton_4);
		
		table = new DefaultTableModel();
		table.addColumn("Số thứ tự");
		table.addColumn("Mã học sinh");
		table.addColumn("Tên Học sinh");
		table.addColumn("Lớp");
		table.addColumn("Môn học");
		table.addColumn("Điểm giữa kỳ");
		table.addColumn("Điểm cuối kỳ");
		table.addColumn("Năm học");
		jTable = new JTable(table);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(294, 110, 1046, 400);
		add(jScrollPane);
		

		
		
		
		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBounds(294, 110, 1046, 400);
//		add(panel_3);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThot.setBounds(1230, 43, 89, 38);
		add(btnThot);
	}
}
