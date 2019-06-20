package coffemanagermvc.view;



import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelBotRightBotRight {
    private JPanel panelBotRightBotRight;
    private JButton btnTransferItem;
    private JButton btnPay;
    private JLabel lbTotal;
    public PanelBotRightBotRight() {
        panelBotRightBotRight = new JPanel();
        btnTransferItem = new JButton("CHUYỂN MÓN");
        btnPay = new JButton("THANH TOÁN");
        lbTotal = new JLabel("Tổng tiền: 0");

        /*
        design panel bot right
         */
        panelBotRightBotRight.setLayout(Properties.layoutBotRightBotRight);
        panelBotRightBotRight.setPreferredSize(new Dimension(Properties.widthPanelBotRightBotRight, Properties.heightPanelBotRightBotRight));

        /*
        design label lbTotal
         */
        lbTotal.setForeground(Properties.colorTotal);
        lbTotal.setFont(Properties.fontTotal);

        /*
        design button tranfer item và button pay
         */
        btnTransferItem.setPreferredSize(new Dimension(Properties.widthBtnBotRightBot, Properties.heightBtnBotRightBot));
        btnPay.setPreferredSize(new Dimension(Properties.widthBtnBotRightBot + 40, Properties.heightBtnBotRightBot));
        btnPay.setForeground(Properties.colorPay);
        btnPay.setFont(Properties.fontPay);

        /*
        tạo các container panel chưa từng button và label
        sắp xếp các container panel trong panel bot right bot left
        sắp xếp các button và label trong các container panel
        để đặt các button và label đúng vào vị trí mong muốn,
         */
        JPanel containerBtnTransferItem = new JPanel();
        containerBtnTransferItem.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        containerBtnTransferItem.setPreferredSize(new Dimension(Properties.widthPanelBotRightBotRight, Properties.heightBtnBotRightBot / 3 * 4));
        containerBtnTransferItem.add(btnTransferItem);

        JPanel containerTotal = new JPanel();
        containerTotal.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        containerTotal.setPreferredSize(new Dimension(Properties.widthPanelBotRightBotRight - 30, Properties.heightBtnBotRightBot / 12 * 6));
        containerTotal.add(lbTotal);

        JPanel containerBtnPay = new JPanel();
        containerBtnPay.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        containerBtnPay.setPreferredSize(new Dimension(Properties.widthPanelBotRightBotRight - 40, Properties.heightBtnBotRightBot));
        containerBtnPay.add(btnPay);

        panelBotRightBotRight.add(containerBtnTransferItem);
        panelBotRightBotRight.add(containerTotal);
        panelBotRightBotRight.add(containerBtnPay);
    }

    public void setEnableBtn(boolean pay,boolean transferItem){
        btnPay.setEnabled(pay);
        btnTransferItem.setEnabled(transferItem);
    }

    public void atTheStart(){
        btnTransferItem.setEnabled(false);
        btnPay.setEnabled(false);
    }

    public JPanel getPanelBotRightBotRight() {
        return panelBotRightBotRight;
    }

    public void setLbTotal(int total){
        lbTotal.setText("Tổng :" + total);
    }

    public JButton getBtnTransferItem() {
        return btnTransferItem;
    }

    public JButton getBtnPay() {
        return btnPay;
    }
}
