package coffemanagermvc.controller;

import coffemanagermvc.model.Database;
import coffemanagermvc.model.connect.ItemsAreSellingDAO;
import coffemanagermvc.model.Properties;
import coffemanagermvc.model.connect.UserDAO;
import coffemanagermvc.model.bean.ItemsAreSelling;
import coffemanagermvc.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ItemsAreSellingDAO itemsAreSellingDAO;
    private UserDAO userDAO;
    private Database database;
    private Main main;
    private PanelChooseQuantityItem panelChooseQuantityItem;
    private DialogTable dialogTable;
    private DialogMenu dialogMenu;
    private JOptionPane optionPane;
    private Login login;



    public Controller() {
        itemsAreSellingDAO =new ItemsAreSellingDAO();
        userDAO = new UserDAO();
        database = new Database();
        main = new Main();
        dialogTable = new DialogTable();
        dialogMenu = new DialogMenu();
        optionPane = new JOptionPane();
        login = new Login();

        login.setVisible(true);
        setValueForTable();

        eventInPanelTop();
        eventInPanelCenter();
        eventInPanelBot();
        eventInDialogTable();
        eventInDialogMenu();
        evenInLogin();
        evenInPanelBotManager();
    }

    public void setValueForTable(){
        List<ItemsAreSelling> itemsAreSellings = itemsAreSellingDAO.getAllItems();

        main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().setItemTable(itemsAreSellings);
        main.getCcb().getPanelBot().SetForegroundBtnTable();
    }

    public void eventInPanelTop() {
        //click button logout
        clickBtnLogout();

        // click button manager
        clickBtnTop();
    }

    public void eventInPanelCenter() {
        clickBtnAreaInMainWindown();
    }

    public void eventInPanelBot() {
        // click button table main windown
        clickBtnTableMainWindown();

        // click table main windowm
        clickTableMainWindown();

        // click button add item
        clickBtnAddItemMainWindown();

        // Click Button Delete item
        clickBtnDeleteMainWindown();

        // Click Button Transfer Item
        clickBtnTransferItemMainWindown();

        //Click button Transfer Table
        clickBtnTransferTableMainWindown();

        // Click button ReGroup Table
        clickBtnReGroupTableMainWindown();

        //click button Pay
        clickBtnPayMainWindown();

    }

    public void eventInDialogTable() {
        // Click button table in Dialog Table
        clickBtnTableDialogTable();

        //Click button cancel in Dialog Table
        clickBtnCancelDialogTable();

        //Click button accept in Dialog Table
        clickBtnAcceptDialog();
    }

    public void eventInDialogMenu() {
        // click button accept in Dialog Menu
        clickBtnCancelDialogMenu();

        // click button accept in Dialog Menu
        clickBtnAcceptDialogMenu();
    }

    public void evenInLogin(){
        // Click button login
        clickBtnLogin();
    }

    public void evenInPanelBotManager(){
        //Click button Plus
        clickBtnPlusPanelBotManager();

        //Click button Update
        clickBtnUpdatePanelBotManager();

        //Click button delete
        clickBtnDeletePanelBotManager();
    }
    /*
        event for button in Panel Top
     */
    public void clickBtnLogout(){
        JButton btnAction = main.getPanelTop().getBtnDangxuat();
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getMainFrame().dispose();
                login.setVisible(true);
            }
        });
    }

    public void clickBtnTop(){
        for (int i = 0 ; i < main.getPanelTop().getBtnTop().length ; i++) {
            int id = i;
            JButton btnAction = main.getPanelTop().getBtnTop()[i];
            btnAction.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    main.getCcb().showLayout(id);
                    main.getPanelTop().clickBtnTop(database.getIdBtnChooseTop(), id);
                    database.setIdBtnChooseTop(id);
                }
            });
        }
    }

    /*
        event for button in Panel Center
     */
    public void clickBtnAreaInMainWindown() {
        for (int i = 0; i < main.getCcb().getPanelCenterMain().getBtnArea().size(); i++) {
            JButton btnAction = main.getCcb().getPanelCenterMain().getBtnArea().get(i);
            int id = i;
            btnAction.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    main.getCcb().getPanelCenterMain().clickBtnArea(database.getIdAreaChoose(), id);
                    main.getCcb().getPanelBot().getPanelBotLeft().showArea(id);
                    database.setIdAreaChoose(id);
                }
            });
        }
    }


    /*
        event for button in Panel Bot
     */
    public void clickBtnTableMainWindown() {
        for (int i = 0; i < main.getCcb().getPanelBot().getPanelBotLeft().getBtnTable().size(); i++) {
            /*
            set background và màu chữ cho button table trước đó
            set idTableChoose = id button vừa click
            hiển thị bàn tương ứng cứ button table
             */
            JButton btnAction = main.getCcb().getPanelBot().getPanelBotLeft().getBtnTable().get(i);
            int id = i;
            btnAction.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBackgroundAndForegroundButtons(database.getIdTableChoose(), main.getCcb().getPanelBot().getPanelBotLeft().getBtnTable(), true);
                    database.setIdTableChoose(id);
                    showTable();
                }
            });
        }
    }

    public void clickTableMainWindown() {
        /*
        set rowChoose =  hàng vừa click
        set enable button transfer item và button delete item
         */
        for (int i = 0; i < main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().getTableOrder().size(); i++) {
            int id = i;
            JTable tableAction = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().getTableOrder().get(i);
            tableAction.addMouseListener(new MouseListener() {
                public void mouseReleased(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseClicked(MouseEvent e) {
                    database.setRowChoose(tableAction.getSelectedRow());
                    setEnableBtnPanleBotRight(id);
                }
            });
        }
    }

    public void clickBtnAddItemMainWindown() {
        /*
        set item DialogMenu
        hiển thị DialogMenu
         */
        JButton btnAction = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotLeft().getBtnAddItem();
        btnAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogMenu.setItemTable();
                optionPane.showOptionDialog(null, dialogMenu, "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            }
        });
    }

    public void clickBtnDeleteMainWindown() {
        /*
        Hiển thị Panle ChooseQuanTityItem với title xóa món
         */
        JButton btnAction = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotLeft().getBtnDeleteItem();
        btnAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseQuantityItem("Xóa món");
            }
        });
    }

    public void clickBtnTransferItemMainWindown() {
        /*
        set stringAccept = "transferItem"
        set enable cho những bàn đang có item trong dialog table
        hiển thị dialog table
        */
        JButton btnAction = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotRight().getBtnTransferItem();
        btnAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDialogTable("transferItem", true);
            }
        });
    }

    public void clickBtnTransferTableMainWindown() {
        /*
        set stringAccept = ""
        set disable cho những bàn đang có item trong dialog table
        hiển thị dialog table
         */
        JButton btnAction = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotLeft().getBtnTransferTable();
        btnAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                database.setIdTableChooseDialog(-1);
                showDialogTable("", false);
            }
        });
    }

    public void clickBtnReGroupTableMainWindown() {
        /*
        set stringAccept = ""
        set disable cho những bàn đang có item trong dialog table
        hiển thị dialog table
         */
        JButton btnAction =  main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotLeft().getBtnRegroupTable();
        btnAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDialogTable("", true);
            }
        });
    }

    public void clickBtnPayMainWindown() {
        /*
        xóa toàn bộ item trong table
        hiển thị lại table
         */
        JButton btnAction =  main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotRight().getBtnPay();
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsAreSellingDAO.deleteAllItemInTable(Integer.toString(database.getIdTableChoose()));
                main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().refreshTable(database.getIdTableChoose());
                showTable();
            }
        });
    }


    /*
        event for button in Dialog Table
     */
    public void clickBtnTableDialogTable() {
         /*
         set background và màu chữ cho button table trước đó
         set idTableChooseDialog = id button vừa click
         set background và màu chữ cho button vừa click
         set enable button accept trong DialogTable
         */
        for (int i = 0; i < dialogTable.getBtnTable().size(); i++) {
            int id = i;
            JButton btnAction = dialogTable.getBtnTable().get(i);
            btnAction.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //set background và màu chữ cho button table trước đó
                    setBackgroundAndForegroundButtons(database.getIdTableChooseDialog(), dialogTable.getBtnTable(), true);

                    //set idTableChooseDialog = id button vừa click
                    database.setIdTableChooseDialog(id);

                    //set background và màu chữ cho button vừa click
                    dialogTable.setBtnAction(id);

                    //set enable button accept trong DialogTable
                    dialogTable.getBtnAccept().setEnabled(true);
                }
            });
        }
    }

    public void clickBtnCancelDialogTable(){
        dialogTable.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionPane.getRootFrame().dispose();
            }
        });
    }

    public void clickBtnAcceptDialog() {
        /*
        kiểm tra String stringAccept và thực hiện yêu cầu
        đóng dialog table
         */
        JButton btnAction = dialogTable.getBtnAccept();
        btnAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                Kiểm tra String stringAccept
                 */
                if (database.getStringAccept().equals("transferItem")) {
                    // hiển thị Panel ChooseQuanTityItem với title chuyển món
                    chooseQuantityItem("Chuyển món");
                } else {
                    main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().transferTable(database.getIdTableChoose(),database.getIdTableChooseDialog());

                    //set hiển thị button bàn mới
                    setBackgroundAndForegroundButtons(database.getIdTableChoose(), main.getCcb().getPanelBot().getPanelBotLeft().getBtnTable(), true);

                    //set idTableChoose = idTableChooseDialog
                    database.setIdTableChoose(database.getIdTableChooseDialog());

                    //hiển thị bàn mới
                    showTable();

                    //đóng dialog table
                    optionPane.getRootFrame().dispose();

                }
            }
        });
    }

    /*
        event for button in Dialog Menu
     */
    public void clickBtnCancelDialogMenu(){
        JButton btnAction = dialogMenu.getBtnCancel();
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionPane.getRootFrame().dispose();
            }
        });
    }

    public void clickBtnAcceptDialogMenu() {
        JButton btnAction = dialogMenu.getBtnAccept();
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogMenu.stopEditing();
                for (int i = 0; i < dialogMenu.getTableItem().getRowCount(); i++) {
                    if (!dialogMenu.getTfSoLuong()[i].getText().equalsIgnoreCase("0")) {

                        main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().addItem(
                                database.getIdTableChoose(),
                                dialogMenu.coppyItemToSql(i,Integer.toString(database.getIdTableChoose())));
                    }
                }
                optionPane.getRootFrame().dispose();
                showTable();
            }
        });
    }

     /*
        event for button in Login
     */
     public void clickBtnLogin(){
         JButton btnAction  = login.getBtnLogin();
         btnAction.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String name = login.getTfNameLogin().getText();
                 String password = login.getTfPassLogin().getText();
                 if (userDAO.isExistUser(name,password)){
                     main.getMainFrame().setVisible(true);
                     main.getPanelTop().getLbNameLogin().setText(userDAO.getFullName(name));
                     if (!login.isManager(userDAO.getRole(name))){
                         main.getPanelTop().getBtnTop()[3].setEnabled(false);
                     }else {
                         main.getPanelTop().getBtnTop()[3].setEnabled(true);
                     }
                     main.atTheStart();
                     login.onLogin();
                 }else {
                     login.getNotification().setText("Tài khoản hoặc mật khẩu sai.");
                 }
             }
         });
     }

     /*
     event for button in Panle Bot Manager
      */
     public void clickBtnPlusPanelBotManager(){
         /*
         thực hiện thêm account
          */
         JButton btnAction = main.getCcb().getPanelBotManager().getBtnPlus();
         btnAction.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //thực hiện thêm account
                 main.getCcb().getPanelBotManager().plusItem(main.getMainFrame());
             }
         });
     }

     public void clickBtnUpdatePanelBotManager() {
         /*
         thực hiện thay đổi thông tin
         nếu account sửa thông tin trùng với account đang đăng nhập thì phần tên kế nút đăng xuất sẽ thay đổi theo tên vừa mới sửa
          */
         JButton btnAction = main.getCcb().getPanelBotManager().getBtnUpdate();
         btnAction.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String nameOfAccount = main.getCcb().getPanelBotManager().getTbAccount().getValueAt(
                         main.getCcb().getPanelBotManager().getTbAccount().getSelectedRow(),1).toString();
                 // thực hiện thay đổi thông tin
                 main.getCcb().getPanelBotManager().updateItem(main.getMainFrame());
                 //nếu account sửa thông tin trùng với account đang đăng nhập thì phần tên kế nút đăng xuất sẽ thay đổi theo tên vừa mới sửa
                 if (nameOfAccount.equalsIgnoreCase(main.getPanelTop().getLbNameLogin().getText())) {
                     main.getPanelTop().getLbNameLogin().setText(main.getCcb().getPanelBotManager().getPanelAccount().getTfTenNhanVien().getText());
                 }
             }
         });
     }

     public void clickBtnDeletePanelBotManager(){
         JButton btnAction = main.getCcb().getPanelBotManager().getBtnDelete();
         btnAction.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String nameOfAccount = main.getCcb().getPanelBotManager().getTbAccount().getValueAt(
                         main.getCcb().getPanelBotManager().getTbAccount().getSelectedRow(),1).toString();
                 if (nameOfAccount.equalsIgnoreCase(main.getPanelTop().getLbNameLogin().getText())) {
                     JOptionPane.showMessageDialog(null,"Không thể xóa");
                 }else {
                     main.getCcb().getPanelBotManager().deteleItem();
                 }
             }
         });
     }

    /*
   interface design function
   */
    public void showTable() {
        int id = database.getIdTableChoose();
        /*
        design button table
        set lại tổng tiền
        set lại border table
        set lại hiển thị button bot right bot
         */

        //design button table
        main.getCcb().getPanelBot().getPanelBotLeft().clickBtnTable(id);

        //set lại tổng tiền
        int totalPrice = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().getTotal(id);
        main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotRight().setLbTotal(totalPrice);

        //set lại border table
        main.getCcb().getPanelBot().getPanelBotRight().setTitleBorder(id);


        //set lại hiển thị button bot right bot
        setEnableBtnPanleBotRight(id);

        //show table
        main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().showTable(id);
    }

    public void setEnableBtnPanleBotRight(int index) {
        boolean checkItemTable = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().checkItemTable(index);
        boolean checkSelectedTable = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().checkSelectedTable(index);
        main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotLeft().setEnableBtn(checkItemTable, checkSelectedTable);
        main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightBot().getPanelBotRightBotRight().setEnableBtn(checkItemTable, checkSelectedTable);
    }

    public void setBackgroundAndForegroundButtons(int idTable, ArrayList<JButton> btnTable, boolean showTable){
        /*
        Set background  mặc định cho button table
        Bàn có item thì được set màu chữ
        bàn có item được set able theo showTable
         */

        //Set background  mặc định cho button table
        if (idTable != -1) {
            btnTable.get(idTable).setBackground(new JButton().getBackground());
            //Bàn có item thì được set màu chữ
            if (main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().getTotal(idTable) > 0) {
                btnTable.get(idTable).setEnabled(showTable);
                btnTable.get(idTable).setForeground(Properties.colorBtnAction);
            } else {
                btnTable.get(idTable).setForeground(Properties.colorBtnTableEmptyItem);
                btnTable.get(idTable).setEnabled(true);
            }
        }
    }

    public void showDialogTable(String stringAccept, boolean BGandFG) {
        /*
        set btnAccept = string
        set background, màu chữ và enable cho button table trong dialod table
        hiển thị dialog table
        set dis able cho button bàn tương ứng với bàn được chọn ở main windown
         */

        //set btnAccept = string
        database.setStringAccept(stringAccept);

        //set background, màu chữ và enable cho button table trong dialog table
        for (int i = 0; i < dialogTable.getBtnTable().size(); i++) {
            setBackgroundAndForegroundButtons(i, dialogTable.getBtnTable(), BGandFG);
        }

        //set disable cho button bàn tương ứng với bàn được chọn ở main windown
        dialogTable.getBtnTable().get(database.getIdTableChoose()).setEnabled(false);

        //set disable button accept
        dialogTable.getBtnAccept().setEnabled(false);

        //hiển thị dialog table
        optionPane.showOptionDialog(null, dialogTable, "Chọn bàn", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
}

    public void chooseQuantityItem(String title) {
        /*
        tên item được chọn bao gồm cả phần ghi chú
        số lượng của item được chọn
        khai báo và hiển thị panelChooseQuantityItem với item được chọn
        nếu phần số lượng là chữ cái set số lượng = 0
        set disable cho button accept
        đóng dialog table
         */

        PanelBotRightTop panelBotRightTop = main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop();
        int numberOfTfSoLuong;
        //tên item được chọn bao gồm cả phần ghi chú
        String string = panelBotRightTop.getTableOrder().get(database.getIdTableChoose()).getValueAt(database.getRowChoose(), 1).toString();

        //số lượng của item được chọn
        int noItem = Integer.parseInt(panelBotRightTop.getTableOrder().get(database.getIdTableChoose()).getValueAt(database.getRowChoose(), 3).toString());

        //khai báo và hiển thị panelChooseQuantityItem với item được chọn
        panelChooseQuantityItem = new PanelChooseQuantityItem(string, noItem);
        int result = JOptionPane.showOptionDialog(null, panelChooseQuantityItem, title,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, Properties.options, Properties.options);

        //nếu phần số lượng là chữ cái hoặc <0 set số lượng = 0
        try {
            numberOfTfSoLuong = Integer.parseInt(panelChooseQuantityItem.getTfSoluong().getText());
        } catch (Exception a) {
            numberOfTfSoLuong = 0;
        }

        if (result == JOptionPane.YES_OPTION && numberOfTfSoLuong > 0) {
            switch (title) {
                case "Xóa món":
                    // xóa item
                    main.getCcb().getPanelBot().getPanelBotRight().getPanelBotRightTop().deleteItem(numberOfTfSoLuong, database.getIdTableChoose(), database.getRowChoose());
                    //đặt lại hiển thị
                    showTable();
                    break;
                case "Chuyển món":
                    panelBotRightTop.transferItem(numberOfTfSoLuong, database.getIdTableChoose(), database.getIdTableChooseDialog(), database.getRowChoose());

                    //set lại background và màu chữ cho button table có item chuyển tới
                    setBackgroundAndForegroundButtons(database.getIdTableChooseDialog(), main.getCcb().getPanelBot().getPanelBotLeft().getBtnTable(), true);

                    // set lại hiển thị bàn vừa chuyển
                    showTable();

                    //đóng dialog table
                    optionPane.getRootFrame().dispose();
            }
        }
    }
}
