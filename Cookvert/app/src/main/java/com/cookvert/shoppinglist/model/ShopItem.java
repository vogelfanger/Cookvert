package com.cookvert.shoppinglist.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Single item in a shopping lists.
 */

public class ShopItem {

    private String name;
    private boolean selected;
    private int id; //unique identifier, not stored in database

    public static AtomicInteger atomicInt = new AtomicInteger();

    public ShopItem(){
        name = "";
        selected = false;
        this.id = atomicInt.incrementAndGet();
    }

    public ShopItem(String name){
        this.name = name;
        selected = false;
        this.id = atomicInt.incrementAndGet();
    }

    public ShopItem(String name, boolean selected){
        this.name = name;
        this.selected = selected;
        this.id = atomicInt.incrementAndGet();
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

    public int getId() {
        return id;
    }
}
