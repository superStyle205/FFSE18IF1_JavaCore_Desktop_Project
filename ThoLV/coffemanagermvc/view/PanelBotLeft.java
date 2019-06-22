package coffemanagermvc.view;

import coffemanagermvc.model.Properties;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelBotLeft {

    private JPanel panelBotLeft;
    private ArrayList<JPanel> subPanelBotLeft;
    private ArrayList<JButton> btnTable;
    public PanelBotLeft() {
        panelBotLeft = new JPanel();
        subPanelBotLeft = new ArrayList<>();
        btnTable = new ArrayList<>();

        /*
        design panel container bot left
        panelBotLeft chứa panel có chứa bàn của các khu và có scroll(nếu có) => set layout là card layout
         */
        panelBotLeft.setPreferredSize(new Dimension(Properties.widthPanelBotLeft, Properties.heightPanelBotLeft));
        panelBotLeft.setLayout(new CardLayout(0, 0));

        /*
         tạo buttons table và add vào panel bot left
          */
        createBtnTable(subPanelBotLeft, btnTable, panelBotLeft);
    }

    public void createBtnTable(ArrayList<JPanel> panelBotLeft, ArrayList<JButton> btnTable, JPanel panelContainer) {

        int widthPanelBotLeft = Properties.widthPanelBotLeft;
        int widthBtnTable = (widthPanelBotLeft - (Properties.soBanMoiHang + 1) * Properties.flowLayoutBotLeftGgap) / Properties.soBanMoiHang;
        int heightBtnTable = widthBtnTable;
        int heightPanelBotLeft;

        // Khởi tạo các panel bot left, buttons bàn, add button bàn vào panel bot left
        for (int i = 0; i < Properties.tenKhu.length; i++) {

            /*
            set chiều cao của panel bot left theo số hàng button bàn trong mỗi panel bot left
             */
            if (Properties.soBanCuaTungKhu[i] % Properties.soBanMoiHang == 0) {
                heightPanelBotLeft = (heightBtnTable + Properties.flowLayoutBotLeftHgap) * (Properties.soBanCuaTungKhu[i] / Properties.soBanMoiHang);
            } else {
                heightPanelBotLeft = (heightBtnTable + Properties.flowLayoutBotLeftHgap) * ((Properties.soBanCuaTungKhu[i] + 1) / Properties.soBanMoiHang);
            }

            /*
            khởi tạo và design panel bot left
             */
            panelBotLeft.add(new JPanel());
            panelBotLeft.get(i).setLayout(Properties.layoutBotLeft);
            panelBotLeft.get(i).setPreferredSize(new Dimension(widthPanelBotLeft, heightPanelBotLeft));

            /*
            add panel bot left vào panel scroll
            add panel scroll vào panel container bot left
             */
            JScrollPane scrollPaneBotLeft = new JScrollPane(panelBotLeft.get(i), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            panelContainer.add(scrollPaneBotLeft, Properties.tenKhu[i]);

            /*
            create button table
            */
            for (int y = 0; y < Properties.soBanCuaTungKhu[i]; y++) {
                btnTable.add(new JButton(Properties.nameTable.get(btnTable.size())));
                btnTable.get(btnTable.size()-1).setPreferredSize(new Dimension(widthBtnTable, heightBtnTable));
                btnTable.get(btnTable.size()-1).setFont(Properties.fontBtnTable);
                panelBotLeft.get(i).add(btnTable.get(btnTable.size()-1));
            }
        }
    }

    public void clickBtnTable(int index){
        btnTable.get(index).setForeground(Color.BLACK);
        btnTable.get(index).setBackground(Properties.colorBtnAction);
    }

    public void showArea(int index){
        CardLayout cardLayout = (CardLayout) panelBotLeft.getLayout();
        cardLayout.show(panelBotLeft, Properties.tenKhu[index]);
    }

    public void atTheStart(){
        CardLayout cardLayout = (CardLayout) panelBotLeft.getLayout();
        cardLayout.show(panelBotLeft, Properties.tenKhu[0]);

        for (JButton btn : btnTable){
            btn.setBackground(new JButton().getBackground());
        }
        btnTable.get(0).setBackground(Properties.colorBtnAction);
    }

    public JPanel getPanelBotLeft() {
        return panelBotLeft;
    }

    public ArrayList<JButton> getBtnTable() {
        return btnTable;
    }
}
