package ft.coffee.view.component.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FooterPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public FooterPanel() {
		this.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
		setBackground(Color.YELLOW);
	}
}
