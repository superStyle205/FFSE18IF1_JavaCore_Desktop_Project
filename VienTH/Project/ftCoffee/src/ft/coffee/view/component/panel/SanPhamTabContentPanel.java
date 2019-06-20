package ft.coffee.view.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class SanPhamTabContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane leftScrollContainer;
	private JPanel leftContainer;
	private JScrollPane rightScrollContainer;
	private JPanel rightContainer;
	private JSplitPane contentSplitPanel;

	public SanPhamTabContentPanel() {
		setLayout(new BorderLayout());
		leftContainer = new JPanel();
		leftScrollContainer = new JScrollPane(leftContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rightContainer = new JPanel();
		rightScrollContainer = new JScrollPane(rightContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		contentSplitPanel = new JSplitPane();
		contentSplitPanel.setBackground(Color.WHITE);
		contentSplitPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		contentSplitPanel.setLeftComponent(leftScrollContainer);
		contentSplitPanel.setRightComponent(rightScrollContainer);
		contentSplitPanel.setOneTouchExpandable(true);
		contentSplitPanel.setDividerLocation(250);

		add(contentSplitPanel, BorderLayout.CENTER);
	}
}
