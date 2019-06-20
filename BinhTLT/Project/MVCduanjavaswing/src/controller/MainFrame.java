package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
//import Swing.ManagerTab;

public class MainFrame extends JFrame {
	private JTabbedPane ControllerManagerTab;

	public MainFrame() {
		ManagerTab managerTab = new ManagerTab();

		add(managerTab);
		

		setTitle("Admin");
		setVisible(true);
		setSize(1200, 725);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(0);
		// Tắt chức năng phóng to màn hình của form.
		setResizable(false);
		// Sự kiện khi bấm nút đỏ thoát form thì chỉ thoát form hiện tại.
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

}
