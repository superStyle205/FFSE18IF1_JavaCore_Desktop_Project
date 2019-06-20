package coffemanagermvc.view;


import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelBot extends JFrame {

    private JPanel panelBot;
    private PanelBotLeft panelBotLeft;
    private PanelBotRight panelBotRight;

    public PanelBot() {
        panelBotLeft = new PanelBotLeft();
        panelBotRight = new PanelBotRight();
        panelBot = new JPanel();

        panelBot.setLayout(Properties.layoutBot);
        panelBot.setPreferredSize(new Dimension(Properties.widthPanelBot, Properties.heightPanelBot));

        panelBot.add(panelBotLeft.getPanelBotLeft());
        panelBot.add(panelBotRight.getPanelBotRight());
    }

    public void SetForegroundBtnTable(){
        /*
        bàn có chứa item được setForeground thành màu colorBtnAction
         */
        for(int i = 1; i < getPanelBotRight().getPanelBotRightTop().getTable().size(); i++){
            if (getPanelBotRight().getPanelBotRightTop().getTable().get(i).getRowCount() > 0){
                getPanelBotLeft().getBtnTable().get(i).setForeground(Properties.colorBtnAction);
            }
        }
        getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotRight().setLbTotal(getPanelBotRight().getPanelBotRightTop().getTotal(0));
    }

    public JPanel getPanelBot() {
        return panelBot;
    }

    public PanelBotLeft getPanelBotLeft() {
        return panelBotLeft;
    }

    public PanelBotRight getPanelBotRight() {
        return panelBotRight;
    }
}
