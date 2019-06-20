package coffemanagermvc.view;



import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelBotRightBot {
    private JPanel panelBotRightBot;
    private PanelBotRightBotLeft panelBotRightBotLeft;
    private PanelBotRightBotRight panelBotRightBotRight;

    public PanelBotRightBot() {
        panelBotRightBot = new JPanel();
        panelBotRightBotLeft = new PanelBotRightBotLeft();
        panelBotRightBotRight = new PanelBotRightBotRight();

        panelBotRightBot.setLayout(Properties.layoutBotRightBot);
        panelBotRightBot.setPreferredSize(new Dimension(Properties.widthPanelBotRightBot, Properties.heightPanelBotRightBot));

        panelBotRightBot.add(panelBotRightBotLeft.getPanelBotRightBotLeft());
        panelBotRightBot.add(panelBotRightBotRight.getPanelBotRightBotRight());
    }

    public JPanel getPanelBotRightBot() {
        return panelBotRightBot;
    }

    public PanelBotRightBotLeft getPanelBotRightBotLeft() {
        return panelBotRightBotLeft;
    }

    public PanelBotRightBotRight getPanelBotRightBotRight() {
        return panelBotRightBotRight;
    }
}
