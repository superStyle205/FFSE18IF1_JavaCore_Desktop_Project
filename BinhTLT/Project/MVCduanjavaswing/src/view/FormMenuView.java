package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class FormMenuView extends JFrame {

	private JLabel menu;
	private JLabel hoc;
	ImageIcon imageIconDIEM = new ImageIcon("diem.png");
	ImageIcon imageIconbook = new ImageIcon("howto.gif");

	public void chaymenu() {
		setSize(1200, 700);
		setTitle("Menu Trường Học");
		setVisible(true);
		add(managerTab());
		// loadgram();
	}

	public JTabbedPane managerTab() {
		JTabbedPane myTabled = new JTabbedPane();
		JPanel menu = quanlimenu();
		myTabled.addTab("Trang Chủ", imageIconDIEM, menu);
		return myTabled;
	}

	public JPanel quanlimenu() {
		JPanel pnMain = new JPanel();
		Container conn = getContentPane();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
	
		conn.add(pnMain);

		JPanel menuct = new JPanel();
		menu = new JLabel("TRANG CHỦ NHÀ TRƯỜNG");
		menuct.setBackground(Color.green);
		menu.setForeground(Color.RED);

		menu.setFont(new Font("Time New Roman", Font.BOLD, 30));
		menuct.add(menu);
		pnMain.add(menuct);
		
		JPanel hoch = new JPanel();
		hoch.setLayout(new BoxLayout(hoch, BoxLayout.Y_AXIS));
		hoc = new JLabel("Sự Học Như Con Thuyền Ngược Nước");
		hoc.add(hoch);
		
		
		JPanel anhanh = new JPanel();
		anhanh.setLayout(new BoxLayout(anhanh, BoxLayout.X_AXIS));
		JLabel anh = new JLabel(imageIconbook);
		anhanh.add(anh);
		
		anh.setPreferredSize(new Dimension(1000, 1000));
		pnMain.add(anh);
		pnMain.add(hoc);

		return pnMain;

	}

	public static void main(String[] args) {
		FormMenuView menu = new FormMenuView();
		menu.chaymenu();
	}

}
