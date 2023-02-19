package com.schifty.nick_schiffman_inventory;

// Model for the inventory Discription currently does not get used
public class InventoryModel {

    // Var Def
    private int id;
    private String item;
    private int inventory;
    private String discription;


    // Main cunstructor
    public InventoryModel(int id, String item, int inventory, String discription){
        this.id = id;
        this.item = item;
        this.inventory = inventory;
        this.discription = discription;
    }
    public InventoryModel(){

    }

    // To string def
    @Override
    public String toString() {
        return "InventoryModel{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", inventory=" + inventory +
                ", discription='" + discription + '\'' +
                '}';
    }

    // Public setters and getters since Vars are set to private

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

    public String getInventoryStr() {
        return Integer.toString(inventory);
    }

    public String getDiscription() {
        return discription;
    }
}
