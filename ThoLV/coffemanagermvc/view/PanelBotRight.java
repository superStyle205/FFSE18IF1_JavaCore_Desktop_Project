package coffemanagermvc.view;



import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelBotRight {
    private JPanel panelBotRight;
    private PanelBotRightTop panelBotRightTop;
    private PanelBotRightBot panelBotRightBot;

    public PanelBotRight() {
        panelBotRightTop = new PanelBotRightTop();
        panelBotRightBot = new PanelBotRightBot();
        panelBotRight = new JPanel();


        panelBotRight.setLayout(Properties.layoutBotRight);
        panelBotRight.setPreferredSize(new Dimension(Properties.widthPanelBotRight, Properties.heightPanelBotRight));
        panelBotRight.setBorder(BorderFactory.createTitledBorder("Chi tiết bàn " + Properties.nameTable.get(0)));
        panelBotRight.add(panelBotRightTop.getPanelBotRightTop());
        panelBotRight.add(panelBotRightBot.getPanelBotRightBot());
    }

    public void setTitleBorder(int index){
        panelBotRight.setBorder(BorderFactory.createTitledBorder("Chi tiết bàn " + Properties.nameTable.get(index)));
    }

    public JPanel getPanelBotRight() {
        return panelBotRight;
    }

    public PanelBotRightTop getPanelBotRightTop() {
        return panelBotRightTop;
    }

    public PanelBotRightBot getPanelBotRightBot() {
        return panelBotRightBot;
    }
}
