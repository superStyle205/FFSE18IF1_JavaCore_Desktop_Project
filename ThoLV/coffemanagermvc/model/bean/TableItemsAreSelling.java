package coffemanagermvc.model.bean;

import coffemanagermvc.model.connect.MenuDAO;
import coffemanagermvc.model.Properties;

public class TableItemsAreSelling {
    private MenuDAO menuDAO;
    private Integer table;
    private String nameItem;
    private Integer price;
    private Integer noItem;
    private Integer totalMoney;

    public TableItemsAreSelling(){
        menuDAO = new MenuDAO();
    }

    public TableItemsAreSelling(ItemsAreSelling itemsAreSelling){
        menuDAO = new MenuDAO();
        this.table = Integer.parseInt(itemsAreSelling.getIdTable());
        this.nameItem = Properties.newToString(menuDAO.getNameById(itemsAreSelling.getIdItem()),itemsAreSelling.getNote());
        this.noItem = itemsAreSelling.getNoItem();
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Integer getPrice() {
        int price =menuDAO.getPriceByName(Properties.separatingCharacterStrings(nameItem).get(0));
        return  price;
    }

    public Integer getNoItem() {
        return noItem;
    }

    public void setNoItem(Integer noItem) {
        this.noItem = noItem;
    }

    public Integer getTotalMoney() {
        int totalMoney = getPrice()*getNoItem();
        return totalMoney;
    }
}
