package com.schifty.nick_schiffman_inventory;

public class InventoryModel {

    private int id;
    private String item;
    private int inventory;
    private String discription;


    public InventoryModel(int id, String item, int inventory, String discription){
        this.id = id;
        this.item = item;
        this.inventory = inventory;
        this.discription = discription;
    }
    public InventoryModel(){

    }

    @Override
    public String toString() {
        return "InventoryModel{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", inventory=" + inventory +
                ", discription='" + discription + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getInventory() {
        return inventory;
    }

    public String getDiscription() {
        return discription;
    }
}
