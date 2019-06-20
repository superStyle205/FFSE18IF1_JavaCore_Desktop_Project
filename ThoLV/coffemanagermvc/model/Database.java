package coffemanagermvc.model;

public class Database {
    int idAreaChoose = 0;
    int idTableChoose = 0;
    int rowChoose;
    int idTableChooseDialog = -1;
    int idBtnChooseTop = 0;
    String stringAccept;

    public int getIdAreaChoose() {
        return idAreaChoose;
    }

    public void setIdAreaChoose(int idAreaChoose) {
        this.idAreaChoose = idAreaChoose;
    }

    public int getIdTableChoose() {
        return idTableChoose;
    }

    public void setIdTableChoose(int idTableChoose) {
        this.idTableChoose = idTableChoose;
    }

    public int getRowChoose() {
        return rowChoose;
    }

    public void setRowChoose(int rowChoose) {
        this.rowChoose = rowChoose;
    }

    public int getIdTableChooseDialog() {
        return idTableChooseDialog;
    }

    public void setIdTableChooseDialog(int idTableChooseDialog) {
        this.idTableChooseDialog = idTableChooseDialog;
    }

    public String getStringAccept() {
        return stringAccept;
    }

    public void setStringAccept(String stringAccept) {
        this.stringAccept = stringAccept;
    }

    public int getIdBtnChooseTop() {
        return idBtnChooseTop;
    }

    public void setIdBtnChooseTop(int idBtnChooseTop) {
        this.idBtnChooseTop = idBtnChooseTop;
    }
}
