package coffemanagermvc.view;


import coffemanagermvc.model.connect.ItemsAreSellingDAO;
import coffemanagermvc.model.connect.MenuDAO;
import coffemanagermvc.model.Properties;
import coffemanagermvc.model.bean.ItemsAreSelling;
import coffemanagermvc.model.bean.TableItemsAreSelling;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelBotRightTop {
    private MenuDAO menuDAO;
    private ItemsAreSellingDAO itemsAreSellingDAO;
    private JPanel panelBotRightTop;
    private ArrayList<JTable> tableOrder;
    private ArrayList<DefaultTableModel> table;

    public PanelBotRightTop() {
        menuDAO = new MenuDAO();
        itemsAreSellingDAO = new ItemsAreSellingDAO();
        panelBotRightTop = new JPanel();
        tableOrder = new ArrayList<>();
        table = new ArrayList<>();
        ArrayList<JScrollPane> scrollpanelBotRightTop = new ArrayList<>();

        /*
        design panel bot right top
         */
        panelBotRightTop.setPreferredSize(new Dimension(Properties.widthPanelBotRightTop, Properties.heightPanelBotRightTop));
        panelBotRightTop.setLayout(Properties.layoutContainerBotRightTop);

        /*
        tạo table và add vào panel bot right top
         */
        int tongSoBan = Properties.tinhTong(Properties.soBanCuaTungKhu);
        for (int i = 0; i < tongSoBan; i++) {
            /*
            tạo và design table tạo tên cột
             */
            table.add(new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
            table.get(i).setColumnIdentifiers(Properties.tenCot);
            tableOrder.add(new JTable(table.get(i)));
            tableOrder.get(i).setRowHeight(30);
            tableOrder.get(i).getTableHeader().setFont(Properties.fontHeaderTable);
            tableOrder.get(i).setFont(Properties.fontTable);

            /*
            set độ rộng cột cho bảng
             */
            int tongTiLeCot = Properties.tinhTong(Properties.tiLeChieuDaiCuaTungCot);
            for (int y = 0; y < Properties.tiLeChieuDaiCuaTungCot.length; y++) {
                int widthColum = Properties.widthPanelBotRightTop / tongTiLeCot * Properties.tiLeChieuDaiCuaTungCot[y];
                /*
                design column table
                 */
                tableOrder.get(i).getColumnModel().getColumn(y).setPreferredWidth(widthColum);
                tableOrder.get(i).getColumnModel().setColumnMargin(15);
                /*
                 căn giữa thành phần trong bản
                 phần tên món không chỉnh cắn giữa
                  */
                if (y != 1) {
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                    tableOrder.get(i).getColumnModel().getColumn(y).setCellRenderer(centerRenderer);
                }
            }
            /*
            add subPanelBotRightTop vào scroll panel
             */
            scrollpanelBotRightTop.add(new JScrollPane(tableOrder.get(i), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
            panelBotRightTop.add(Properties.nameTable().get(i), scrollpanelBotRightTop.get(i));
        }
    }

    public void atTheStart() {
        CardLayout cardLayout = (CardLayout) panelBotRightTop.getLayout();
        cardLayout.show(panelBotRightTop, Properties.nameTable.get(0));
        tableOrder.get(0).clearSelection();
    }

    public void setItemTable(List<ItemsAreSelling> itemsAreSellings) {
        for (int i = 0; i < itemsAreSellings.size(); i++) {
            TableItemsAreSelling tb = new TableItemsAreSelling(itemsAreSellings.get(i));
            table.get(tb.getTable()).addRow(new String[]{
                    "" + (table.get(tb.getTable()).getRowCount() + 1),
                    tb.getNameItem(), "" + tb.getPrice(),
                    "" + tb.getNoItem(),
                    "" + tb.getTotalMoney()}
                    );
        }
    }

    public void showTable(int index) {
        CardLayout cardLayout = (CardLayout) panelBotRightTop.getLayout();
        cardLayout.show(panelBotRightTop, Properties.nameTable.get(index));
    }

    public int getTotal(int index) {
        /*
        lấy tổng tiền trong bàn
         */
        int total = 0;
        for (int i = 0; i < tableOrder.get(index).getRowCount(); i++) {
            total += Integer.parseInt(tableOrder.get(index).getValueAt(i, 4).toString());
        }
        return total;
    }

    public void refreshTable(int idTable){
        table.get(idTable).setRowCount(0);
        setItemTable(itemsAreSellingDAO.getAllItemsByTable(Integer.toString(idTable)));
    }

    public ItemsAreSelling coppyItemToSql(int idTable, int row, int noItem) {

        ItemsAreSelling itemsAreSelling = new ItemsAreSelling();
        List<String> strings = Properties.separatingCharacterStrings(table.get(idTable).getValueAt(row, 1).toString());
        itemsAreSelling.setIdTable(Integer.toString(idTable));
        itemsAreSelling.setIdItem(menuDAO.getIdByName(strings.get(0)));
        itemsAreSelling.setNoItem(noItem);
        itemsAreSelling.setNote(strings.get(1));

        return itemsAreSelling;
    }

    public void deleteItem(int soLuong, int idTable, int idRow) {
        /*
        nếu số lượng item cần xóa nhỏ hơn số lượng có sẵn thì xóa số lượng rồi set lại tổng tiền
        nếu số lượng item cần xóa bằng số lượng có sẵn thì xóa item
         */
        ItemsAreSelling itemsAreSelling = coppyItemToSql(idTable, idRow, soLuong);

        if (soLuong < Integer.parseInt(table.get(idTable).getValueAt(idRow, 3).toString())) {
            itemsAreSellingDAO.deleteItemInTable(itemsAreSelling);
            refreshTable(idTable);
        } else {
            itemsAreSellingDAO.deleteRowItemInTable(itemsAreSelling);
            refreshTable(idTable);
        }
    }

    public void addItem(int idtableReceive, ItemsAreSelling itemsAreSelling) {
        /*
        nếu trùng item thì cộng dồn số lượng
        nếu không thì thêm mới
         */
        if (itemsAreSellingDAO.checkSameItem(itemsAreSelling,Integer.toString(idtableReceive))) {
            itemsAreSellingDAO.plusItemInTable(itemsAreSelling);
            refreshTable(idtableReceive);
        } else {
            itemsAreSellingDAO.addItem(itemsAreSelling);
            refreshTable(idtableReceive);
        }
    }

    public int transferItem(int soLuong, int idTableContainerItemMove, int idTableReceive, int rowOfItem) {
        /*
        tạo bản sao của đối tượng được chọn
        add bản sao vào bàn được chọn
        xóa item từ bàn cũ
         */

        if (soLuong > Integer.parseInt(table.get(idTableContainerItemMove).getValueAt(rowOfItem, 3).toString())) {
            soLuong = Integer.parseInt(table.get(idTableContainerItemMove).getValueAt(rowOfItem, 3).toString());
        }
        //tạo bản sao của đối tượng được chọn
        ItemsAreSelling itemsAreSelling = coppyItemToSql(idTableContainerItemMove, rowOfItem, soLuong);
        itemsAreSelling.setIdTable(Integer.toString(idTableReceive));

        //add bản sao vào bàn được chọn
        addItem(idTableReceive, itemsAreSelling);

        //xóa item từ bàn cũ
        deleteItem(soLuong, idTableContainerItemMove, rowOfItem);

        return -1;
    }

    public void transferTable(int idTableMove, int idTableReceive) {
        /*
        tạo bảng sao item của bàn cũ
        add bản sao vào bàn được chọn
        xóa các item của bàn cũ
        set hiển thị button bàn cũ
        set idTableChoose = idTableChooseDialog
        hiển thị bàn mới
         */
        for (int z = 0; z < table.get(idTableMove).getRowCount(); z++) {
            //tạo bản sao item của bàn cũ

            ItemsAreSelling itemsAreSelling = coppyItemToSql(idTableMove, z, Integer.parseInt(tableOrder.get(idTableMove).getValueAt(z, 3).toString()));
            itemsAreSelling.setIdTable(Integer.toString(idTableReceive));

            //add bản sao vào bàn được chọn
            addItem(idTableReceive, itemsAreSelling);
        }

        //xóa các item của bàn cũ
        itemsAreSellingDAO.deleteAllItemInTable(Integer.toString(idTableMove));
        table.get(idTableMove).setRowCount(0);
    }

    public boolean checkItemTable(int index) {
        return getTotal(index) != 0 ? true : false;
    }

    public boolean checkSelectedTable(int index) {
        return tableOrder.get(index).getSelectedRow() != -1 ? true : false;
    }

    public JPanel getPanelBotRightTop() {
        return panelBotRightTop;
    }

    public ArrayList<JTable> getTableOrder() {
        return tableOrder;
    }

    public ArrayList<DefaultTableModel> getTable() {
        return table;
    }
}
