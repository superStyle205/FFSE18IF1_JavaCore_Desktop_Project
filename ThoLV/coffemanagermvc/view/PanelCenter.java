package coffemanagermvc.view;



import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCenter extends JFrame {
    private JPanel panelCenter;
    private ArrayList<JButton> btnArea;


    public PanelCenter(String[] nameBtn) {
        panelCenter = new JPanel();
        btnArea = new ArrayList<>();

        /*
         design panel center
          */
        panelCenter.setLayout(Properties.layoutCenter);
        panelCenter.setPreferredSize(new Dimension(Properties.widthPanelCenter, Properties.heightPanelCenter));
        panelCenter.setBackground(Properties.colorBackGroundPanelCenter);
        createBtnArea(panelCenter, btnArea, nameBtn);
    }

    public void createBtnArea(JPanel panelCenter, ArrayList<JButton> btnArea, String[] nameBtn) {


        /*
        set chiều cao chiều dài của btnKhu
         */
        int widthBtnCenter = (Properties.widthPanelCenter - ((Properties.soBtnCenter + 1) * Properties.flowLayoutCenterGgap)) / Properties.soBtnCenter;
        int heightBtnCenter = Properties.heightPanelCenter - Properties.flowLayoutCenterHgap * 2;

        /*
        tạo button khu và add vào panel center
         */
        for (int i = 0; i < nameBtn.length; i++) {
            btnArea.add(new JButton(nameBtn[i]));
            btnArea.get(i).setPreferredSize(new Dimension(widthBtnCenter, heightBtnCenter));
            panelCenter.add(btnArea.get(i));
        }
    }

    public void clickBtnArea(int indexAfter, int indexBefore) {
        btnArea.get(indexAfter).setBackground(new JButton().getBackground());
        btnArea.get(indexBefore).setBackground(Properties.colorBtnAction);
    }

    public void atTheStart(){
        for (JButton btn:btnArea){
            btn.setBackground(new JButton().getBackground());
        }
        btnArea.get(0).setBackground(Properties.colorBtnAction);
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public ArrayList<JButton> getBtnArea() {
        return btnArea;
    }
}