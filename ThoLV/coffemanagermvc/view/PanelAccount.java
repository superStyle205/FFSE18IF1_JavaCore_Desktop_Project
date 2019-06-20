package coffemanagermvc.view;

import coffemanagermvc.model.Properties;
import coffemanagermvc.model.bean.User;

import javax.swing.*;
import java.awt.*;

public class PanelAccount extends JPanel {
    private JTextField tfMaNhanVien;
    private JTextField tfTenNhanVien;
    private JTextField tfTaiKhoan;
    private JTextField tfMatKhau;
    private JComboBox cbRole;

    private JLabel lbMaNhanVien;
    private JLabel lbTenNhanVien;
    private JLabel lbTaiKhoan;
    private JLabel lbMatKhau;
    private JLabel lbRole;
    private JLabel lbNotication;

    public PanelAccount(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        tfMaNhanVien = new JTextField();
        tfTenNhanVien = new JTextField();
        tfTaiKhoan = new JTextField();
        tfMatKhau = new JTextField();
        cbRole = new JComboBox();
        for (int i = 0 ; i < Properties.role.length; i++){
            cbRole.addItem(Properties.role[i].toString());
        }

        tfMaNhanVien.setFont(Properties.fontTF);
        tfMaNhanVien.setEnabled(false);
        tfTenNhanVien.setFont(Properties.fontTF);
        tfTaiKhoan.setFont(Properties.fontTF);
        tfMatKhau.setFont(Properties.fontTF);


        lbMaNhanVien = new JLabel("Mã nhân viên :");
        lbTenNhanVien = new JLabel("Tên nhân viên :");
        lbTaiKhoan= new JLabel("Tài khoản :");
        lbMatKhau= new JLabel("Mật khẩu :");
        lbRole = new JLabel("Chức vụ :");

        lbNotication= new JLabel();

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(5,2,0,10));
        container.setPreferredSize(new Dimension(30,150));

        container.add(lbMaNhanVien);
        container.add(tfMaNhanVien);
        container.add(lbTenNhanVien);
        container.add(tfTenNhanVien);
        container.add(lbTaiKhoan);
        container.add(tfTaiKhoan);
        container.add(lbMatKhau);
        container.add(tfMatKhau);
        container.add(lbRole);
        container.add(cbRole);

        JPanel panelContainer2 = new JPanel();
        panelContainer2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelContainer2.setPreferredSize(new Dimension(500,50));

        lbNotication.setForeground(Color.red);
        panelContainer2.add(lbNotication);

        add(container,BorderLayout.CENTER);
        add(panelContainer2,BorderLayout.CENTER);
    }

    public void reset(){
        tfMaNhanVien.setText("");
        tfTenNhanVien.setText("");
        tfTaiKhoan.setText("");
        tfMatKhau.setText("");
        lbNotication.setText("");
    }

    public User addAccout(){
        /*
        tạo user từ các textfield
         */
        User user = new User();
        user.setId(tfMaNhanVien.getText());
        user.setFullName(tfTenNhanVien.getText());
        user.setName(tfTaiKhoan.getText());
        user.setPassword(tfMatKhau.getText());
        user.setRole((String) cbRole.getSelectedItem());
        return user;
    }

    public boolean checkEmTyTextField(){

        if (tfTenNhanVien.getText().equals("") || tfTaiKhoan.getText().equals("") || tfMatKhau.getText().equals("")){
            lbNotication.setText("Không được để trống");
         return false;
        }
        return true;
    }

    public void trimTextField(){
        tfTenNhanVien.setText(tfTenNhanVien.getText().trim());
        tfTaiKhoan.setText(tfTaiKhoan.getText().trim());
        tfMatKhau.setText(tfMatKhau.getText().trim());
    }

    public int getIndex(String value) {
        for (int i = 0; i < cbRole.getItemCount(); i++)
        {
            String item = cbRole.getItemAt(i).toString();
            if (item.equalsIgnoreCase(value))
            {
                return i;
            }
        }
        return -1;
    }

    public JTextField getTfMaNhanVien() {
        return tfMaNhanVien;
    }

    public void setTfMaNhanVien(JTextField tfMaNhanVien) {
        this.tfMaNhanVien = tfMaNhanVien;
    }

    public JTextField getTfTenNhanVien() {
        return tfTenNhanVien;
    }

    public void setTfTenNhanVien(JTextField tfTenNhanVien) {
        this.tfTenNhanVien = tfTenNhanVien;
    }

    public JTextField getTfTaiKhoan() {
        return tfTaiKhoan;
    }

    public void setTfTaiKhoan(JTextField tfTaiKhoan) {
        this.tfTaiKhoan = tfTaiKhoan;
    }

    public JTextField getTfMatKhau() {
        return tfMatKhau;
    }

    public void setTfMatKhau(JTextField tfMatKhau) {
        this.tfMatKhau = tfMatKhau;
    }

    public JLabel getLbNotication() {
        return lbNotication;
    }

    public void setLbNotication(JLabel lbNotication) {
        this.lbNotication = lbNotication;
    }

    public JComboBox getCbRole() {
        return cbRole;
    }

    public void setCbRole(JComboBox cbRole) {
        this.cbRole = cbRole;
    }
}
