package coffemanagermvc.view;

import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelContainerPanelCenterPanelBot{
    private JPanel panelContainerPanelCenterPanelBot;
    private PanelCenter panelCenterMain;
    private PanelCenter panelCenterManager;
    private PanelBot panelBot;
    private PanelBotManager panelBotManager;

    public PanelContainerPanelCenterPanelBot(){
        panelCenterMain = new PanelCenter(Properties.tenKhu);
        panelBot = new PanelBot();
        panelCenterManager = new PanelCenter(Properties.nameBtnCenterManager);
        panelBotManager = new PanelBotManager();
        panelContainerPanelCenterPanelBot = new JPanel();

        panelContainerPanelCenterPanelBot.setLayout(new CardLayout(0,0));
        panelContainerPanelCenterPanelBot.setSize(new Dimension(Properties.widthPanelBot,Properties.heightPanelCenter + Properties.heightPanelBot));

        layoutForMain();
        layoutForManager();
    }

    public void layoutForMain(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel.setPreferredSize(new Dimension(Properties.widthPanelBot,Properties.heightPanelCenter + Properties.heightPanelBot));

        panel.add(panelCenterMain.getPanelCenter());
        panel.add(panelBot.getPanelBot());
        panelContainerPanelCenterPanelBot.add(panel,Properties.tenBtnTop[0]);
    }

    public void layoutForManager(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel.setPreferredSize(new Dimension(Properties.widthPanelBot,Properties.heightPanelCenter + Properties.heightPanelBot));

        panel.add(panelCenterManager.getPanelCenter());
        panel.add(panelBotManager.getPanelBot());
        panelContainerPanelCenterPanelBot.add(panel,Properties.tenBtnTop[3]);
    }

    public void showLayout(int index){
        CardLayout cardLayout = (CardLayout) getPanelContainerPanelCenterPanelBot().getLayout();
        cardLayout.show(getPanelContainerPanelCenterPanelBot(), Properties.tenBtnTop[index]);
    }

    public void atTheStart(){
        CardLayout cardLayout = (CardLayout) getPanelContainerPanelCenterPanelBot().getLayout();
        cardLayout.show(getPanelContainerPanelCenterPanelBot(), Properties.tenBtnTop[0]);
        panelCenterMain.atTheStart();
        panelBot.getPanelBotLeft().atTheStart();
        panelBot.getPanelBotRight().getPanelBotRightTop().atTheStart();
        panelBot.getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotLeft().atTheStart();
        panelBot.getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotRight().atTheStart();
    }

    public JPanel getPanelContainerPanelCenterPanelBot() {
        return panelContainerPanelCenterPanelBot;
    }

    public PanelCenter getPanelCenterMain() {
        return panelCenterMain;
    }

    public PanelBot getPanelBot() {
        return panelBot;
    }

    public PanelBotManager getPanelBotManager() {
        return panelBotManager;
    }
}
