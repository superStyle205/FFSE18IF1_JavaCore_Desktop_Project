package coffemanagermvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelChooseQuantityItem extends Panel {
    private Object[] options = {"XÁC NHẬN", "HỦY"};
    private JButton btnSubtractItem;
    private JButton btnPlusItem;
    private JTextField tfSoluong;
    private JLabel jLabel;
    private JPanel containerPanle;

    public PanelChooseQuantityItem(String string, int noItem) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        containerPanle = new JPanel();
        containerPanle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JPanel containerJLabel = new JPanel();
        jLabel = new JLabel(string);
        containerJLabel.add(jLabel);

        jLabel.setSize(50, 50);
        btnSubtractItem = new JButton("-");
        btnSubtractItem.setActionCommand("subtract");
        tfSoluong = new JTextField(3);
        btnPlusItem = new JButton("+");
        btnPlusItem.setActionCommand("plus");

        tfSoluong.setText("" + 1);
        tfSoluong.setHorizontalAlignment(JTextField.CENTER);


        containerPanle.add(btnSubtractItem);
        containerPanle.add(tfSoluong);
        containerPanle.add(btnPlusItem);

        add(containerJLabel,BorderLayout.CENTER);
        add(containerPanle, BorderLayout.CENTER);


        btnSubtractItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(tfSoluong.getText()) > noItem) {
                    tfSoluong.setText("" + noItem);
                } else if (!tfSoluong.getText().equals("1")) {
                    tfSoluong.setText("" + (Integer.parseInt(tfSoluong.getText()) - 1));
                }
            }
        });

        btnPlusItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(tfSoluong.getText()) >= noItem) {
                    tfSoluong.setText("" + noItem);
                }else {
                    tfSoluong.setText("" + (Integer.parseInt(tfSoluong.getText()) + 1));
                }
            }
        });
    }

    public JTextField getTfSoluong() {
        return tfSoluong;
    }
}
