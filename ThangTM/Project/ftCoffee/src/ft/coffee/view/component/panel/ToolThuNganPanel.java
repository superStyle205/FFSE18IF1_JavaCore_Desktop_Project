package ft.coffee.view.component.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ToolThuNganPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// cac item cho cum thu ngan
	private JButton btnMauIn;
	private JButton btnMayIn;
	private JButton btnSoDo;

	public ToolThuNganPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		btnMauIn = new JButton();
		createButton(btnMauIn, "Mẫu in", "manageCategory.png");
		btnMayIn = new JButton();
		createButton(btnMayIn, "Máy in", "manageCategory.png");
		btnSoDo = new JButton();
		createButton(btnSoDo, "Sơ đồ", "manageCategory.png");
	}

	private void createButton(JButton button, String btnTitle, String imgName) {
		button.setText(btnTitle);
		button.setPreferredSize(new Dimension(95, 70));
		button.setIcon(new ImageIcon("image/" + imgName));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);

		add(button);
	}
}
