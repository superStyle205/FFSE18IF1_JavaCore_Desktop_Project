package ft.coffee.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChangePasswordFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnHuy;
	private JFrame frame;
	
	public ChangePasswordFrame(JFrame frame) {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// hide title bar
		this.setUndecorated(true);

		this.frame = frame;
		Container container = getContentPane();
		container.setBackground(Color.PINK);
		btnHuy = new JButton("Hủy");
		container.add(btnHuy);
		btnHuy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setEnabled(true);
		this.dispose();
	}
}
