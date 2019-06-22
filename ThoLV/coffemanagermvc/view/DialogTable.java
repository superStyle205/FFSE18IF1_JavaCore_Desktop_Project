package coffemanagermvc.view;


import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DialogTable extends JPanel {
    private PanelBotLeft panelBotLeft;
    private PanelCenter panelCenter;
    private JPanel panelDialogTableTop;
    private JPanel panelContainerDialogTableCenterLeft;
    private ArrayList<JPanel> panelDialogCenter;
    private JPanel panelDialogTableCenterRight;

    private ArrayList<JButton> btnArea;
    private ArrayList<JButton> btnTable;

    private int idAreaChoose;
    private JButton btnCancel;
    private JButton btnAccept;

    public DialogTable() {
        panelBotLeft = new PanelBotLeft();
        panelCenter = new PanelCenter(Properties.tenKhu);
        panelDialogTableTop = new JPanel();
        panelContainerDialogTableCenterLeft = new JPanel();
        panelDialogCenter = new ArrayList<>();
        panelDialogTableCenterRight = new JPanel();
        btnArea = new ArrayList<>();
        btnTable = new ArrayList<>();
        btnCancel = new JButton("HỦY BỎ");
        btnAccept = new JButton("XÁC NHẬN");
        idAreaChoose = 0;

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setPreferredSize(new Dimension(Properties.widthPanelBotLeft + Properties.widthPanelDialogTableCenterRight + 20, Properties.heightPanelMainWindown - 60));
        /*
        khởi tạo button area
         */
        panelCenter.createBtnArea(panelDialogTableTop, btnArea, Properties.tenKhu);

        /*
        khởi tạo button table
         */
        panelContainerDialogTableCenterLeft.setPreferredSize(new Dimension(Properties.widthPanelBotLeft, Properties.heightPanelBotLeft));
        panelContainerDialogTableCenterLeft.setLayout(new CardLayout(0, 0));
        panelBotLeft.createBtnTable(panelDialogCenter, btnTable, panelContainerDialogTableCenterLeft);

        panelDialogTableCenterRight.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        panelDialogTableCenterRight.setPreferredSize(new Dimension(Properties.widthPanelDialogTableCenterRight, Properties.heightPanelBotLeft));

        btnCancel.setPreferredSize(new Dimension(Properties.widthPanelDialogTableCenterRight - 30, Properties.widthPanelDialogTableCenterRight / 3));
        btnAccept.setPreferredSize(new Dimension(Properties.widthPanelDialogTableCenterRight - 30, Properties.widthPanelDialogTableCenterRight / 3));

        panelDialogTableCenterRight.add(btnCancel);
        panelDialogTableCenterRight.add(btnAccept);

        add(panelDialogTableTop);
        add(panelContainerDialogTableCenterLeft);
        add(panelDialogTableCenterRight);

        /*
        at the start
         */
        btnArea.get(idAreaChoose).setBackground(Properties.colorBtnAction);
        clickBtnArea();
    }

    public void clickBtnArea() {
        for (int i = 0; i < btnArea.size(); i++) {
            int id = i;
            JButton btnAction = btnArea.get(i);
            btnAction.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnArea.get(idAreaChoose).setBackground(new JButton().getBackground());
                    btnAction.setBackground(Properties.colorBtnAction);
                    idAreaChoose = id;

                    CardLayout cardLayout = (CardLayout) panelContainerDialogTableCenterLeft.getLayout();
                    cardLayout.show(panelContainerDialogTableCenterLeft, Properties.tenKhu[id]);
                }
            });
        }
    }

    public void setBtnAction(int index) {
        btnTable.get(index).setBackground(Properties.colorBtnAction);
        btnTable.get(index).setForeground(Color.BLACK);
    }

    public ArrayList<JButton> getBtnTable() {
        return btnTable;
    }

    public JButton getBtnAccept() {
        return btnAccept;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

}
