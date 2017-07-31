package com.cookvert.shoppinglist.model;

import com.cookvert.data.DBContract;

import java.util.ArrayList;

/**
 * Shopping list that consists of ShopItems.
 */

public class ShoppingList {

    private String name;
    private ArrayList<ShopItem> items;

    public ShoppingList(){
        name = "";
        items = new ArrayList<>();
    }

    public ShoppingList(String name){
        this.name = name;
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ShopItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ShopItem> items) {
        this.items = items;
    }
}
