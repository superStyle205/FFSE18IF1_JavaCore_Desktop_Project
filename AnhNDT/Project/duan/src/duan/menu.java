package duan;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JList;

import quanly.quanlydiem;
import quanly.quanlygiaovien;
import quanly.quanlyhocsinh;
import quanly.quanlylop;
import quanly.quanlymon;

public class menu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private quanlydiem qlD = new quanlydiem("");
	private quanlygiaovien qlGV = new quanlygiaovien("");
	private quanlyhocsinh qlHS = new quanlyhocsinh("");
	private quanlylop qlL = new quanlylop("");
	private quanlymon qlM = new quanlymon("");
	 

	public menu() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnQLDiem = qlD.addControls();
		JPanel pnQLGiaoVien = qlGV.addControls();
		JPanel pnQLHS = qlHS.addControls();
		JPanel pnQLLop = qlL.addControls();
		JPanel pnQLMon	= qlM.addControls();
		
		JTabbedPane myTabled = new JTabbedPane();
		myTabled.addTab("Quản Lý Điểm",null,pnQLDiem);
		myTabled.addTab("Quản Lý Giáo Viên",null,pnQLGiaoVien);
		myTabled.addTab("Quản Lý Học Sinh", null,pnQLHS);
		myTabled.addTab("Quản Lý Lớp",null,pnQLLop);
		myTabled.addTab("Quản Lý Môn",null,pnQLMon);

		pnMain.add(myTabled);
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		menu frame = new menu();
		//frame.setVisible(true);
		frame.menu();

	}

	/**
	 * Create the frame.
	 */
	public  void menu() {

		
		setSize(972, 586);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setVisible(true);
		 }
		
		
		
		
		
	
//	
	}

