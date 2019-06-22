package ft.coffee.view.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import common.grouptable.ColumnGroup;
import common.grouptable.JCustomTable;

public class ThuNganTabContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel thuNganTableModel;
	private JCustomTable thuNganTable;
	private JScrollPane thuNganTablePanel;

	public ThuNganTabContentPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.RED);
		thuNganTableModel = new DefaultTableModel();
		thuNganTableModel.addColumn("TT");
		thuNganTableModel.addColumn("So ban");
		thuNganTableModel.addColumn("So CT");
		thuNganTableModel.addColumn("So mon");
		thuNganTableModel.addColumn("Thieu");
		thuNganTableModel.addColumn("So tien");
		thuNganTableModel.addColumn("Gio vao");
		thuNganTableModel.addColumn("Thoi gian");
		thuNganTableModel.addColumn("So khach");
		thuNganTableModel.addColumn("Khach hang");
		thuNganTableModel.addColumn("Nhan vien phuc vu");
		thuNganTableModel.addColumn("Ghi chu");

		thuNganTable = new JCustomTable(thuNganTableModel);

		// group column
		ColumnGroup chungTuColumnGroup = new ColumnGroup("Chung Tu");
		chungTuColumnGroup.add(thuNganTable.getColumn(1));
		chungTuColumnGroup.add(thuNganTable.getColumn(2));
		thuNganTable.addColumnGroup(chungTuColumnGroup);
		
		ColumnGroup thucDonColumnGroup = new ColumnGroup("Thuc don");
		thucDonColumnGroup.add(thuNganTable.getColumn(3));
		thucDonColumnGroup.add(thuNganTable.getColumn(4));
		thucDonColumnGroup.add(thuNganTable.getColumn(5));
		thuNganTable.addColumnGroup(thucDonColumnGroup);

		thuNganTablePanel = new JScrollPane(thuNganTable);
		add(thuNganTablePanel, BorderLayout.CENTER);
	}
}
