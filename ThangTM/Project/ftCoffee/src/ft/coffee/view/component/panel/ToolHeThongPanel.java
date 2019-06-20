package ft.coffee.view.component.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ToolHeThongPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	// cac item cho cum he thong
	private JButton btnDanhMuc;
	private JButton btnTuyChon;
	private JButton btnSanPham;
	private JButton btnMatKhau;
	private JButton btnExit;

	public ToolHeThongPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		btnDanhMuc = new JButton();
		createButton(btnDanhMuc, "Danh mục", "manageCategory.png");
		btnTuyChon = new JButton();
		createButton(btnTuyChon, "Tùy chọn", "opition.png");
		btnSanPham = new JButton();
		createButton(btnSanPham, "Sản phẩm", "manageCategory.png");
		btnMatKhau = new JButton();
		createButton(btnMatKhau, "Mật khẩu", "opition.png");

		btnExit = new JButton();
		createButton(btnExit, "Thoát", "logout.png");

		btnExit.addActionListener(this);
	}

	public JButton getBtnDanhMuc() {
		return btnDanhMuc;
	}

	public JButton getBtnTuyChon() {
		return btnTuyChon;
	}

	public JButton getBtnSanPham() {
		return btnSanPham;
	}

	public JButton getBtnMatKhau() {
		return btnMatKhau;
	}

	private void createButton(JButton button, String btnTitle, String imgName) {
		button.setText(btnTitle);
		button.setPreferredSize(new Dimension(95, 70));
		button.setIcon(new ImageIcon("image/" + imgName));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);

		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			System.exit(0);
		}
	}

}
