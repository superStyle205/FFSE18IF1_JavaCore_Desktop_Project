package view.component;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ManagerHomePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final String TAB_NAME = "Trang Chủ";
	public static final ImageIcon TAB_ICON = new ImageIcon("truong.png");
	
	public ManagerHomePanel() {
		setBackground(new Color(127, 255, 212));
		setBounds(60, 50, 1800, 965);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\duy-tan.jpg"));
		lblNewLabel.setBounds(339, 71, 1110, 661);
		add(lblNewLabel);

	}

}
