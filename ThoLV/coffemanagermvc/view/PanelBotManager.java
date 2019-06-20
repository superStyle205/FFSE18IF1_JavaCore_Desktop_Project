package coffemanagermvc.view;

import coffemanagermvc.model.Properties;
import coffemanagermvc.model.connect.UserDAO;
import coffemanagermvc.model.bean.User;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PanelBotManager {
    private UserDAO userDAO;
    private PanelAccount panelAccount;
    private JPanel panelBot;
    private JPanel panelBotLeft;
    private JPanel panelBotRight;
    private DefaultTableModel dmAccount;
    private JTable tbAccount;
    private JButton btnPlus;
    private JButton btnUpdate;
    private JButton btnDelete;

    public PanelBotManager() {
        userDAO = new UserDAO();
        panelAccount = new PanelAccount();
        panelBot = new JPanel();
        dmAccount = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbAccount = new JTable(dmAccount);
        btnPlus = new JButton("Thêm");
        btnUpdate = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        panelBot.setLayout(Properties.layoutBot);
        panelBot.setPreferredSize(new Dimension(Properties.widthPanelBot, Properties.heightPanelBot));
        panelBotLeftManager();
        panelBotRightManager();

        panelBot.add(panelBotLeft);
        panelBot.add(panelBotRight);

        setEnableBtnUpdateAnhBtnDelete(false);
        setItemTable();
        clickTable();
    }

    public void panelBotLeftManager() {
        int tongTiLeCot = Properties.tinhTong(Properties.columnLengthRatioDMBM);
        panelBotLeft = new JPanel();
        panelBotLeft.setPreferredSize(new Dimension(Properties.widthPanelBot / 5 * 4, Properties.heightPanelBot));
        JScrollPane scrollMenu;

        dmAccount.setColumnIdentifiers(Properties.nameColumnBM);
        tbAccount.setRowHeight(30);
        tbAccount.getTableHeader().setFont(Properties.fontHeaderTable);
        tbAccount.setFont(Properties.fontTable);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        //set độ rộng cột cho bảng
        for (int i = 0; i < Properties.columnLengthRatioDMBM.length; i++) {
            int widthColum = (Properties.widthPanelBot / 5 * 4) / tongTiLeCot * Properties.columnLengthRatioDMBM[i];
            // design column table
            tbAccount.getColumnModel().getColumn(i).setPreferredWidth(widthColum);
            tbAccount.getColumnModel().setColumnMargin(15);
            // phần tên món không chỉnh cắn giữa
            if (i != 1) {
                tbAccount.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }


        //add scroll vào subPanelBotRightTop
        scrollMenu = new JScrollPane(tbAccount, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setPreferredSize((new Dimension(Properties.widthPanelBot / 5 * 4, Properties.heightPanelBot)));
        panelBotLeft.add(scrollMenu);
    }

    public void panelBotRightManager() {
        panelBotRight = new JPanel();
        panelBotRight.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        panelBotRight.setPreferredSize(new Dimension(Properties.widthPanelBot / 5, Properties.heightPanelBot));

        btnPlus.setPreferredSize(new Dimension(150, 50));
        btnUpdate.setPreferredSize(new Dimension(150, 50));
        btnDelete.setPreferredSize(new Dimension(150, 50));

        panelBotRight.add(btnPlus);
        panelBotRight.add(btnUpdate);
        panelBotRight.add(btnDelete);
    }

    public void clickTable() {
        tbAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setEnableBtnUpdateAnhBtnDelete(true);
            }
        });
    }

    public void plusItem(Component component) {
        /*
        reset text field in panel account
        show OpationPanel account
        check emty text field
        standardize string in text field
        plus account
         */
        //reset text field in panel account
        panelAccount.reset();
        boolean showOpationPanel = true;
        while (showOpationPanel) {
            // show OpationPanel account
            int result = showOpationPanel(component, "Thêm tài khoản");
            // when click button "Xác nhận"
            if (result == JOptionPane.YES_OPTION) {
                //check emty text field
                if (panelAccount.checkEmTyTextField()) {
                    // standardize string in text field
                    panelAccount.trimTextField();
                    if (checkSameItem(-1)) {
                        // plus account
                        userDAO.addUser(panelAccount.addAccout());
                        setItemTable();
                        setEnableBtnUpdateAnhBtnDelete(false);
                        showOpationPanel = false;
                    }
                }
            } else {
                showOpationPanel = false;
            }
        }
    }

    public void updateItem(Component component) {
        /*
        reset text field int panel account
        set text for text field in panel account
        show OpationPanel account
        check emty text field
        standardize string in text field
        update item
         */

        // reset text field int panel account
        panelAccount.reset();
        // set text for text field in panel account
        setValueForTextFieldInPanelAccount();
        boolean showOpationPanel = true;
        while (showOpationPanel) {
            //show OpationPanel account
            int result = showOpationPanel(component, "Sửa tài khoản");
            //when click button "Xác nhận"
            if (result == JOptionPane.YES_OPTION) {
                //check emty text field
                if (panelAccount.checkEmTyTextField()) {
                    // standardize string in text field
                    panelAccount.trimTextField();
                    if (checkSameItem(tbAccount.getSelectedRow())) {
                        // update item
                        userDAO.updateUser(panelAccount.addAccout());
                        setItemTable();
                        setEnableBtnUpdateAnhBtnDelete(false);
                        showOpationPanel = false;
                    }
                }
            } else {
                showOpationPanel = false;
            }
        }
    }

    public void deteleItem() {
        // delete item
        userDAO.deleteUser(tbAccount.getValueAt(tbAccount.getSelectedRow(), 2).toString());
        setItemTable();
        setEnableBtnUpdateAnhBtnDelete(false);
    }

    public boolean checkSameItem(int rowchoose) {
        for (int i = 0; i < tbAccount.getRowCount(); i++) {
            if (i == rowchoose) {
                continue;
            }
            if (panelAccount.getTfMaNhanVien().getText().equalsIgnoreCase(tbAccount.getValueAt(i, 0).toString())) {
                panelAccount.getLbNotication().setText("Trùng mã nhân viên");
                return false;
            }
            if (panelAccount.getTfTenNhanVien().getText().equalsIgnoreCase(tbAccount.getValueAt(i, 1).toString())) {
                panelAccount.getLbNotication().setText("Trùng tên nhân viên");
                return false;
            }
            if (panelAccount.getTfTaiKhoan().getText().equalsIgnoreCase(tbAccount.getValueAt(i, 2).toString())) {
                panelAccount.getLbNotication().setText("Trùng tài khoản");
                return false;
            }
        }
        return true;

    }

    public void setItemTable() {
        dmAccount.getDataVector().removeAllElements();
        List<User> userList = userDAO.getAllUser();
        for (User user : userList) {
            dmAccount.addRow(new String[]{user.getId(), user.getFullName(), user.getName(), user.getPassword(), user.getRole()});
        }
        tbAccount.clearSelection();
    }

    public void setEnableBtnUpdateAnhBtnDelete(boolean bl) {
        btnUpdate.setEnabled(bl);
        btnDelete.setEnabled(bl);
    }

    public int showOpationPanel(Component component, String title) {
        return JOptionPane.showOptionDialog(component, panelAccount, title,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, Properties.options, null);
    }

    public void setValueForTextFieldInPanelAccount() {
        panelAccount.getTfMaNhanVien().setText(tbAccount.getValueAt(tbAccount.getSelectedRow(), 0).toString());
        panelAccount.getTfTenNhanVien().setText(tbAccount.getValueAt(tbAccount.getSelectedRow(), 1).toString());
        panelAccount.getTfTaiKhoan().setText(tbAccount.getValueAt(tbAccount.getSelectedRow(), 2).toString());
        panelAccount.getTfMatKhau().setText(tbAccount.getValueAt(tbAccount.getSelectedRow(), 3).toString());
        panelAccount.getCbRole().setSelectedIndex(panelAccount.getIndex(tbAccount.getValueAt(tbAccount.getSelectedRow(),4).toString()));
    }

    public JPanel getPanelBot() {
        return panelBot;
    }

    public void setPanelBot(JPanel panelBot) {
        this.panelBot = panelBot;
    }

    public DefaultTableModel getDmAccount() {
        return dmAccount;
    }

    public void setDmAccount(DefaultTableModel dmAccount) {
        this.dmAccount = dmAccount;
    }

    public JTable getTbAccount() {
        return tbAccount;
    }

    public void setTbAccount(JTable tbAccount) {
        this.tbAccount = tbAccount;
    }

    public JButton getBtnPlus() {
        return btnPlus;
    }

    public void setBtnPlus(JButton btnPlus) {
        this.btnPlus = btnPlus;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public PanelAccount getPanelAccount() {
        return panelAccount;
    }

    public void setPanelAccount(PanelAccount panelAccount) {
        this.panelAccount = panelAccount;
    }
}
