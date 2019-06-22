package coffemanagermvc.view;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JTextField tfNameLogin;
    private JTextField tfPassLogin;
    private JButton btnLogin;
    private JLabel notification;


    public Login() {
        super("ĐĂNG NHẬP");

        tfNameLogin = new JTextField();
        tfPassLogin = new JPasswordField();
        notification = new JLabel();
        btnLogin = new JButton("ĐĂNG NHẬP");


        designLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 320);
        setLocationRelativeTo(null);
    }

    public void designLayout() {
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel panelContainer = new JPanel();

        panelContainer.setBorder(BorderFactory.createEmptyBorder(50,0,20,0));
        panelContainer.setLayout(new GridLayout(2,2,3,10));
        JLabel lbNameLogin = new JLabel("TÊN ĐĂNG NHẬP");
        lbNameLogin.setFont(new Font("aria",Font.BOLD, 16));
        JLabel lbPassLogin = new JLabel("MẬT KHẨU");
        lbPassLogin.setFont(new Font("aria",Font.BOLD, 16));

        tfNameLogin.setPreferredSize(new Dimension(200, 50));
        tfNameLogin.setFont(new Font("aria",Font.BOLD, 15));
        tfPassLogin.setPreferredSize(new Dimension(200, 50));
        tfPassLogin.setFont(new Font("aria",Font.BOLD, 15));

        panelContainer.add(lbNameLogin);
        panelContainer.add(tfNameLogin);
        panelContainer.add(lbPassLogin);
        panelContainer.add(tfPassLogin);

        JPanel panelContainer2 = new JPanel();
        panelContainer2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelContainer2.setPreferredSize(new Dimension(500,50));

        notification.setForeground(Color.red);
        panelContainer2.add(notification);

        btnLogin.setPreferredSize(new Dimension(150,50));

        add(panelContainer);
        add(btnLogin);
        add(panelContainer2);
    }

    public void onLogin(){
        getTfNameLogin().setText("");
        getTfPassLogin().setText("");
        getNotification().setText("");
        dispose();
    }

    public boolean isManager(String role){
        return role.equalsIgnoreCase("Quản lí");
    }

    public JTextField getTfNameLogin() {
        return tfNameLogin;
    }

    public JTextField getTfPassLogin() {
        return tfPassLogin;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JLabel getNotification() {
        return notification;
    }
}
