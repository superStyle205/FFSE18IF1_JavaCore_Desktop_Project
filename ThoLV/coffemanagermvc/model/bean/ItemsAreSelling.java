package coffemanagermvc.model.bean;

public class ItemsAreSelling {
    private String idTable;
    private String idItem;
    private int noItem;
    private String note;

    public ItemsAreSelling(){

    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public int getNoItem() {
        return noItem;
    }

    public void setNoItem(int noItem) {
        this.noItem = noItem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
