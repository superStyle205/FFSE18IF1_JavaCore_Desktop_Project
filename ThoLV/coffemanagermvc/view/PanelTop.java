package coffemanagermvc.view;

import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;

public class PanelTop extends JFrame {
    // View uses Swing framework to display UI to user
    private JPanel panelTop;
    private JButton[] btnTop;
    private JButton btnDangxuat;
    private JLabel lbNameLogin;
    private int hgap  =  5;


    public PanelTop() {
        panelTop = new JPanel();
        lbNameLogin = new JLabel();
        btnTop = new JButton[Properties.tenBtnTop.length];
        btnDangxuat = new JButton("Đăng xuất");

        //design panel top
        panelTop.setLayout(Properties.layoutCenter);
        panelTop.setPreferredSize(new Dimension(Properties.widthPanelCenter, Properties.heightPanelCenter));
        panelTop.setBackground(Properties.colorBackGroundPanelTop);
        element();
    }

    public void element() {
        int widthBtn = (Properties.widthPanelCenter - ((Properties.soBtnCenter + 1) * Properties.flowLayoutCenterGgap)) / Properties.soBtnTop;
        int heightBtn = Properties.heightPanelCenter - Properties.flowLayoutCenterHgap * 2;
        /*
        add thành phần top vào panelTop
         */
        for (int i = 0; i < Properties.tenBtnTop.length; i++) {
            btnTop[i] = new JButton(Properties.tenBtnTop[i]);
            btnTop[i].setPreferredSize(new Dimension(widthBtn,heightBtn));
            panelTop.add(btnTop[i]);
        }

        int widthPanle = Properties.widthPanelTop - Properties.tenBtnTop.length*(widthBtn+hgap) - 15;
        JPanel panelContainerName = new JPanel();
        panelContainerName.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelContainerName.setPreferredSize(new Dimension(widthPanle,heightBtn));
        panelContainerName.setBackground(Properties.colorBackGroundPanelTop);

        btnDangxuat.setPreferredSize(new Dimension(widthBtn,heightBtn));
        // design name login

        lbNameLogin.setFont(Properties.fontNameLogin);
        lbNameLogin.setForeground(Properties.colorNameLogin);
        panelContainerName.add(lbNameLogin);
        panelContainerName.add(btnDangxuat);
        panelTop.add(panelContainerName);

    }

    public void clickBtnTop(int btnBefore, int btnAfter){
        btnTop[btnBefore].setBackground(new JButton().getBackground());
        btnTop[btnAfter].setBackground(Properties.colorBtnAction);
    }

    public void atTheStart(){
        for (JButton btn:btnTop){
            btn.setBackground(new JButton().getBackground());
        }
        btnTop[0].setBackground(Properties.colorBtnAction);
    }

    public JPanel getPanelTop() {
        return panelTop;
    }

    public JButton[] getBtnTop() {
        return btnTop;
    }

    public JButton getBtnDangxuat() {
        return btnDangxuat;
    }

    public JLabel getLbNameLogin() {
        return lbNameLogin;
    }
}