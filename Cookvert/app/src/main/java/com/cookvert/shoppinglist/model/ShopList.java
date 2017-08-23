package com.cookvert.shoppinglist.model;

import android.support.annotation.NonNull;

import com.cookvert.data.DBContract;

import java.text.Collator;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Shopping list that consists of ShopItems.
 */

public class ShopList implements Comparable<ShopList> {

    private String name;
    private ArrayList<ShopItem> items;
    private int id; //unique identifier, not stored in database

    public static AtomicInteger atomicInt = new AtomicInteger();

    public ShopList(){
        name = "";
        items = new ArrayList<>();
        this.id = atomicInt.incrementAndGet();
    }

    public ShopList(String name){
        this.name = name;
        items = new ArrayList<>();
        this.id = atomicInt.incrementAndGet();
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

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(@NonNull ShopList shopList) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        return collator.compare(this.name, shopList.name);
    }
}
