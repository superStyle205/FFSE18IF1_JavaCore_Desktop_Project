package coffemanagermvc.view;

import coffemanagermvc.model.Properties;
import coffemanagermvc.model.bean.ItemsAreSelling;
import coffemanagermvc.model.bean.Menu;
import coffemanagermvc.model.connect.MenuDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class DialogMenu extends JPanel {
    private MenuDAO menuDAO;
    private JPanel panelTop;
    private JPanel panelCenter;
    private JPanel panelBot;
    private JPanel panelBotLeft;
    private JPanel panelBotRight;
    private DefaultTableModel table;
    private JTable tableItem;
    private JTextField[] tfSoLuong;
    private JButton btnPlusItem;
    private JButton btnSubtractItem;
    private Integer[] soLuongs;
    private JButton[] btnTop;
    private JScrollPane scrollMenu;
    private JButton btnCancel;
    private JButton btnAccept;
    private DefaultTableModel dmCheck;
    private JTable tbCheck;

    private int rowchooseTableMenu;

    public DialogMenu() {
        menuDAO = new MenuDAO();
        panelTop = new JPanel();
        panelCenter = new JPanel();
        panelBot = new JPanel();
        panelBotLeft = new JPanel();
        panelBotRight = new JPanel();
        table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3 || column == 4) {
                    return true;
                }
                return false;
            }
        };
        tableItem = new JTable(table);
        tfSoLuong = new JTextField[100];
        btnPlusItem = new JButton();
        btnSubtractItem = new JButton();
        soLuongs = new Integer[100];
        btnTop = new JButton[Properties.nameBtnTopDM.length];
        scrollMenu = new JScrollPane();
        btnCancel = new JButton("HỦY");
        btnAccept = new JButton("XÁC NHẬN");
        dmCheck = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbCheck = new JTable(dmCheck);

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setPreferredSize(new Dimension(Properties.widthPanelMainWindown, Properties.heightPanelMainWindown));

        panleTop();
        panelCenter();
        panelBot();

        add(panelTop);
        add(panelCenter);
        add(panelBot);

        setItemForTbCheckByTableMenu();
    }

    public void panleTop() {
        panelTop.setLayout(Properties.layoutDMTop);
        panelTop.setPreferredSize(new Dimension(Properties.widthPanelBot, Properties.heightPanelTop));

        for (int i = 0; i < Properties.nameBtnTopDM.length; i++) {
            btnTop[i] = new JButton(Properties.nameBtnTopDM[i]);
            btnTop[i].setPreferredSize(new Dimension((Properties.widthPanelBot - (Properties.nameBtnTopDM.length + 1) * Properties.flowLayoutDMTopHgap) / Properties.nameBtnTopDM.length, Properties.heightPanelTop - (2 * Properties.flowLayoutDMTopGgap)));
            panelTop.add(btnTop[i]);
        }
    }

    public void panelCenter() {
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelCenter.setPreferredSize(new Dimension(Properties.widthPanelBot, Properties.heightPanelBotRightTop * 3 / 2));


        table.setColumnIdentifiers(Properties.columnsNameDM);
        tableItem.setRowHeight(30);
        tableItem.getTableHeader().setFont(Properties.fontHeaderTable);
        tableItem.setFont(Properties.fontTable);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        //set độ rộng cột cho bảng
        int tongTiLeCot = Properties.tinhTong(Properties.columnLengthRatioDM);
        for (int i = 0; i < Properties.columnLengthRatioDM.length; i++) {
            int widthColum = Properties.widthPanelBot / tongTiLeCot * Properties.columnLengthRatioDM[i];
            // design column table
            tableItem.getColumnModel().getColumn(i).setPreferredWidth(widthColum);
            tableItem.getColumnModel().setColumnMargin(15);
            // phần tên món không chỉnh cắn giữa
            if (i != 1 && i != 4) {
                tableItem.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }


        //add scroll vào subPanelBotRightTop
        scrollMenu = new JScrollPane(tableItem, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setPreferredSize((new Dimension(Properties.widthPanelBot, Properties.heightPanelBotRightTop * 3 / 2)));
        panelCenter.add(scrollMenu);
    }

    public void panelBot() {
        panelBot.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelBot.setPreferredSize(new Dimension(Properties.widthPanelBot, Properties.heightPanleBot));

        panelBotLeft();
        panelBotRight();

        panelBot.add(panelBotLeft);
        panelBot.add(panelBotRight);
    }

    public void panelBotLeft() {
        panelBotLeft.setPreferredSize(new Dimension(Properties.widthPanelBot * 2 / 3, Properties.heightPanleBot));

        dmCheck.setColumnIdentifiers(Properties.columnsCheck);
        tbCheck.setRowHeight(30);
        tbCheck.getTableHeader().setFont(Properties.fontHeaderTable);
        tbCheck.setFont(Properties.fontTable);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        //set độ rộng cột cho bảng
        int tongTileCotCheck = Properties.tinhTong(Properties.columnLengthRatioCheck);
        for (int i = 0; i < Properties.columnLengthRatioCheck.length; i++) {
            int widthColum = (Properties.widthPanelBot / 3 * 2) / tongTileCotCheck * Properties.columnLengthRatioCheck[i];
            // design column table
            tbCheck.getColumnModel().getColumn(i).setPreferredWidth(widthColum);
            tbCheck.getColumnModel().setColumnMargin(15);
            // phần số lượng chỉnh cắn giữa
            if (i == 1) {
                tbCheck.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }

        //add scroll vào subPanelBotRightTop
        scrollMenu = new JScrollPane(tbCheck, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollMenu.setPreferredSize((new Dimension(Properties.widthPanelBot * 2 / 3, Properties.heightPanleBot)));
        panelBotLeft.add(scrollMenu);
    }

    public void panelBotRight() {
        panelBotRight.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelBotRight.setPreferredSize(new Dimension(Properties.widthPanelBot / 3, Properties.heightPanleBot));

        btnCancel.setPreferredSize(new Dimension(Properties.widthPanelBot / 9 * 2, Properties.heightPanleBot / 3));
        btnAccept.setPreferredSize(new Dimension(Properties.widthPanelBot / 9 * 2, Properties.heightPanleBot / 3));

        panelBotRight.add(btnCancel);
        panelBotRight.add(btnAccept);
    }

    public void setItemForTbCheckByTableMenu() {
        tableItem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowchooseTableMenu = tableItem.getSelectedRow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        tableItem.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setItemForTbCheck(rowchooseTableMenu);
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    public void setItemForTbCheck(int index) {
        /*
        Kiểm tra sự trùng lặp của item thêm vào với item trong bàn được thêm
        Thêm mới nếu không trùng
        Lấy số lượng theo số lượng từ TableItem nếu trùng, nếu số lượng từ TableItem = 0 thì xóa Item
         */
        String nameItem = tableItem.getValueAt(index, 1).toString();
        int rowSameItemInTbCheck = checkSameItem(nameItem);
        Object[] objects = new Object[3];
        if (rowSameItemInTbCheck == -1 && soLuongs[index] != 0) {
            objects[0] = nameItem;
            objects[1] = soLuongs[index];
            try {
                objects[2] = tableItem.getValueAt(index, 4).toString();
            } catch (Exception e) {
                objects[2] = "";
            }
            dmCheck.addRow(objects);
        } else if (rowSameItemInTbCheck != -1 && soLuongs[index] != 0) {
            dmCheck.setValueAt(soLuongs[index], rowSameItemInTbCheck, 1);
            try {
                dmCheck.setValueAt(tableItem.getValueAt(index, 4).toString(), rowSameItemInTbCheck, 2);
            } catch (Exception e) {
                dmCheck.setValueAt("", rowSameItemInTbCheck, 2);
            }
        } else if (rowSameItemInTbCheck != -1 && soLuongs[index] == 0) {
            dmCheck.removeRow(rowSameItemInTbCheck);
        }
    }

    public int checkSameItem(String nameItem) {
        for (int i = 0; i < tbCheck.getRowCount(); i++) {
            if (nameItem.equalsIgnoreCase(tbCheck.getValueAt(i, 0).toString())) {
                return i;
            }
        }
        return -1;
    }

    public void setGiaTriBanDauSoLuong() {
        for (int i = 0; i < 100; i++) {
            soLuongs[i] = 0;
        }
    }

    public void setItemTable() {
        List<Menu> menuList = menuDAO.getAll();
        /*
        xóa hết phần tử trong table để set lại từ đầu
         */
        stopEditing();
        setGiaTriBanDauSoLuong();
        table.getDataVector().removeAllElements();
        dmCheck.getDataVector().removeAllElements();

        for (int i = 0; i < menuList.size(); i++) {
            table.addRow(new String[]{"" + (i + 1), menuList.get(i).getName(), menuList.get(i).getPrice()});
            tableItem.getColumnModel().getColumn(3).setCellRenderer(new PanelRenderer());
            tableItem.getColumnModel().getColumn(3).setCellEditor(new ButtonsEditor(tableItem));
        }
    }

    public void stopEditing() {
        if (tableItem.isEditing()) {
            tableItem.getCellEditor().stopCellEditing();
        }
    }

    public ItemsAreSelling coppyItemToSql(int row, String idTable) {
        String note;
        //nếu coppy item từ menu thì note = phần ghi chú ở menu, còn không thì note =""
        try {
            note = table.getValueAt(row, 4).toString().trim();
        } catch (Exception a) {
            note = "";
        }

        ItemsAreSelling itemsAreSelling = new ItemsAreSelling();
        itemsAreSelling.setIdTable(idTable);
        itemsAreSelling.setIdItem(menuDAO.getIdByName(table.getValueAt(row, 1).toString()));
        itemsAreSelling.setNoItem(Integer.parseInt(getTfSoLuong()[row].getText()));
        itemsAreSelling.setNote(note);

        return itemsAreSelling;
    }

    public JButton getBtnAccept() {
        return btnAccept;
    }

    public void setBtnAccept(JButton btnAccept) {
        this.btnAccept = btnAccept;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JTextField[] getTfSoLuong() {
        return tfSoLuong;
    }

    public void setTfSoLuong(JTextField[] tfSoLuong) {
        this.tfSoLuong = tfSoLuong;
    }

    public DefaultTableModel getTable() {
        return table;
    }

    public void setTable(DefaultTableModel table) {
        this.table = table;
    }

    public JTable getTableItem() {
        return tableItem;
    }

    public void setTableItem(JTable tableItem) {
        this.tableItem = tableItem;
    }

    /*
       tạo ra panel chứa các button cà textfield
       renderer để có thể click được các button đó
     */

    public class ColumnPane extends JPanel {

        public ColumnPane(int row) {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

            btnSubtractItem = new JButton("-");
            btnSubtractItem.setActionCommand("subtract");
            tfSoLuong[row] = new JTextField(3);
            btnPlusItem = new JButton("+");
            btnPlusItem.setActionCommand("plus");

            tfSoLuong[row].setText("" + soLuongs[row]);
            tfSoLuong[row].setHorizontalAlignment(JTextField.CENTER);
            add(btnSubtractItem);
            add(tfSoLuong[row]);
            add(btnPlusItem);

            btnSubtractItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = tableItem.getSelectedRow();

                    if (soLuongs[i] != 0) {
                        soLuongs[i] -= 1;
                    }
                    tfSoLuong[i].setText("" + soLuongs[i]);
                    setItemForTbCheck(i);
                }
            });

            btnPlusItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = tableItem.getSelectedRow();
                    soLuongs[i] += 1;
                    tfSoLuong[i].setText("" + soLuongs[i]);
                    setItemForTbCheck(i);
                }
            });

            tfSoLuong[row].addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                }

                public void focusLost(FocusEvent e) {
                    int row = tableItem.getSelectedRow();
                    soLuongs[row] = Integer.parseInt(tfSoLuong[row].getText());
                    tfSoLuong[row].setText("" + soLuongs[row]);
                    setItemForTbCheck(row);
                }
            });

            tableItem.addMouseListener(new MouseListener() {
                public void mouseReleased(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    int row = tableItem.getSelectedRow();
                    try {
                        soLuongs[row] = Integer.parseInt(tfSoLuong[row].getText());
                    } catch (Exception a) {

                    }
                    tfSoLuong[row].setText("" + soLuongs[row]);
                    setItemForTbCheck(row);
                }

                public void mouseExited(MouseEvent e) {
                    try {
                        int row = tableItem.getSelectedRow();
                        soLuongs[row] = Integer.parseInt(tfSoLuong[row].getText());
                        tfSoLuong[row].setText("" + soLuongs[row]);
                        setItemForTbCheck(row);
                    } catch (Exception a) {
                    }
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseClicked(MouseEvent e) {
                }
            });
        }
    }

    class PanelRenderer implements TableCellRenderer {
        public PanelRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            tableItem.setCellSelectionEnabled(false);
            return new ColumnPane(row);
        }

    }

    class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {
        private final JTable table;
        private Object o;

        public ButtonsEditor(JTable table) {
            super();
            this.table = table;
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            return new ColumnPane(row);
        }

        @Override
        public Object getCellEditorValue() {
            return o;
        }

        private class EditingStopHandler extends MouseAdapter implements ActionListener {
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }
    }
}
