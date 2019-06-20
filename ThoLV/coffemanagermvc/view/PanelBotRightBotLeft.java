package coffemanagermvc.view;


import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelBotRightBotLeft {
    private JPanel panelBotRightBotLeft;
    private JButton btnAddItem;
    private JButton btnDeleteItem;
    private JButton btnTransferTable;
    private JButton btnRegroupTable;
    public PanelBotRightBotLeft() {
        panelBotRightBotLeft = new JPanel();
        btnAddItem = new JButton("THÊM MÓN");
        btnDeleteItem = new JButton("XÓA MÓN");
        btnTransferTable = new JButton("CHUYỂN BÀN");
        btnRegroupTable = new JButton("GỘP BÀN");

        /*
        design panel bot right bot left
         */
        panelBotRightBotLeft.setLayout(Properties.layoutBotRightBotLeft);
        panelBotRightBotLeft.setPreferredSize(new Dimension(Properties.widthPanelBotRightBotLeft, Properties.heightPanelBotRightBotLeft));

        /*
        set size cho các button add item, delete item, transfer table, regroup table
         */
        btnAddItem.setPreferredSize(new Dimension(Properties.widthBtnBotRightBot, Properties.heightBtnBotRightBot));
        btnDeleteItem.setPreferredSize(new Dimension(Properties.widthBtnBotRightBot, Properties.heightBtnBotRightBot));
        btnTransferTable.setPreferredSize(new Dimension(Properties.widthBtnBotRightBot, Properties.heightBtnBotRightBot));
        btnRegroupTable.setPreferredSize(new Dimension(Properties.widthBtnBotRightBot, Properties.heightBtnBotRightBot));

        panelBotRightBotLeft.add(btnAddItem);
        panelBotRightBotLeft.add(btnDeleteItem);
        panelBotRightBotLeft.add(btnTransferTable);
        panelBotRightBotLeft.add(btnRegroupTable);
    }

    public void setEnableBtn(boolean regroupTable, boolean deleteItem){
        btnDeleteItem.setEnabled(deleteItem);
        btnRegroupTable.setEnabled(regroupTable);
        btnTransferTable.setEnabled(regroupTable);
    }

    public void atTheStart(){
        btnDeleteItem.setEnabled(false);
        btnTransferTable.setEnabled(false);
        btnRegroupTable.setEnabled(false);
    }

    public JPanel getPanelBotRightBotLeft() {
        return panelBotRightBotLeft;
    }

    public JButton getBtnAddItem() {
        return btnAddItem;
    }

    public JButton getBtnDeleteItem() {
        return btnDeleteItem;
    }

    public JButton getBtnTransferTable() {
        return btnTransferTable;
    }

    public JButton getBtnRegroupTable() {
        return btnRegroupTable;
    }
}
