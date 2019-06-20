package ft.coffee.view.component.panel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static final String CARD_HE_THONG = "cardHeThong";
	public static final String CARD_THU_NGAN = "cardThuNgan";
	public static final String CARD_DEFAULT = "cardDefault";

	// control item
	private JButton btnHeThong;
	private JButton btnThuNgan;
	private CardLayout mCardLayout;
	private JPanel toolContentPanel;
	private ToolHeThongPanel cardHeThong;
	private ToolThuNganPanel cardThuNgan;
	private DefaultPanel defaultPanel;

	public HeaderPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(Integer.MAX_VALUE, 115));

		// phan tab
		initTabButtonView();

		// phan menu item
		initToolItemView();
	}

	public ToolHeThongPanel getCardHeThong() {
		return cardHeThong;
	}

	private void initTabButtonView() {
		JPanel tabButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tabButtonPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 31));
		btnHeThong = new JButton("Hệ Thống");
		btnThuNgan = new JButton("Thu Ngân");

		btnHeThong.addActionListener(this);
		btnThuNgan.addActionListener(this);

		tabButtonPanel.add(btnHeThong);
		tabButtonPanel.add(btnThuNgan);

		this.add(tabButtonPanel);
	}

	private void initToolItemView() {
		cardHeThong = new ToolHeThongPanel();
		cardThuNgan = new ToolThuNganPanel();
		defaultPanel = new DefaultPanel();

		mCardLayout = new CardLayout();
		toolContentPanel = new JPanel();
		toolContentPanel.setLayout(mCardLayout);
		toolContentPanel.add(defaultPanel, CARD_DEFAULT);
		toolContentPanel.add(cardHeThong, CARD_HE_THONG);
		toolContentPanel.add(cardThuNgan, CARD_THU_NGAN);

		this.add(toolContentPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnHeThong) {
			showCardWithName(CARD_HE_THONG);
		} else if (action == btnThuNgan) {
			showCardWithName(CARD_THU_NGAN);
		}
	}

	public void showCardWithName(String cardName) {
		mCardLayout.show(toolContentPanel, cardName);
	}

}
