package coffemanagermvc.view;

import coffemanagermvc.model.Properties;

import javax.swing.*;

public class Main {
    private JFrame mainFrame;
    private PanelTop panelTop;
    private PanelContainerPanelCenterPanelBot ccb;

    public Main(){
        panelTop = new PanelTop();
        ccb = new PanelContainerPanelCenterPanelBot();

        mainFrame = new JFrame(Properties.title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(Properties.widthMainWindow,Properties.heightMainWindow);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(Properties.layoutMainWinDown);

        mainFrame.add(panelTop.getPanelTop());
        mainFrame.add(ccb.getPanelContainerPanelCenterPanelBot());
        atTheStart();
    }

    public void atTheStart(){
        panelTop.atTheStart();
        ccb.atTheStart();
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public PanelTop getPanelTop() {
        return panelTop;
    }

    public PanelContainerPanelCenterPanelBot getCcb() {
        return ccb;
    }
}
