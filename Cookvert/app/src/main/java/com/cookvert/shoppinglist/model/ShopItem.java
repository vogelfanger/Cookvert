package com.cookvert.shoppinglist.model;

/**
 * Single item in a shopping lists.
 */

public class ShopItem {

    private String name;
    private boolean selected;

    public ShopItem(){
        name = "";
        selected = false;
    }

    public ShopItem(String name){
        this.name = name;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
