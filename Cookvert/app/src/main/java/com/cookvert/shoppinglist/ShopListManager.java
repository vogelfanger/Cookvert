package com.cookvert.shoppinglist;

import android.database.Cursor;
import android.util.Log;

import com.cookvert.data.DBContract;
import com.cookvert.data.DBHelper;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.shoppinglist.model.ShopItem;
import com.cookvert.shoppinglist.model.ShopList;
import com.cookvert.util.Cookvert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 */

public class ShopListManager {

    private static final String LOG_TAG = "ShopListManager"; // tag for Log entries

    private static ShopListManager manager = new ShopListManager();
    private ArrayList<ShopList> shoppingLists;
    private int focusShopList;
    private int focusShopItem;

    // maps connecting object ids to database primary keys
    private HashMap<Integer, Long> shopListMap;
    private HashMap<Integer, Long> shopItemMap;

    // private constructor prevents multiple instances
    private ShopListManager() {
        shoppingLists = new ArrayList<>();
        shopListMap = new HashMap<>();
        shopItemMap = new HashMap<>();

        // read shopping lists from database
        readShopListsFromDB();

        // read shop items for each list
        for(ShopList sl : shoppingLists){
            readShopItemsFromDB(sl);
        }

        sortShopLists();
        focusShopList = 0;
        focusShopItem = 0;
    }

    public static ShopListManager getInstance(){
        return manager;
    }

    public int getFocusShopList() {
        return focusShopList;
    }

    public ArrayList<ShopList> getShoppingLists() {
        return shoppingLists;
    }

    public void setFocusShopList(int focusShopList) {
        this.focusShopList = focusShopList;
    }

    public int getFocusShopItem() {
        return focusShopItem;
    }

    public void setFocusShopItem(int focusShopItem) {
        this.focusShopItem = focusShopItem;
    }

    public void setShoppingLists(ArrayList<ShopList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }

    public void setShopListMap(HashMap<Integer, Long> shopListMap) {
        this.shopListMap = shopListMap;
    }

    public void setShopItemMap(HashMap<Integer, Long> shopItemMap) {
        this.shopItemMap = shopItemMap;
    }

    //****************************************************************************************************
    //                               LIST INTERACTION METHODS
    //****************************************************************************************************



    /**
     * Adds new shop list to manager's list and inserts it into database.
     * Row id of inserted list is also put into shop list map.
     * @param name shop list name
     */
    public void addShopList(String name){
        ShopList list = new ShopList(name);
        shoppingLists.add(list);
        // sort list of shopping lists to keep them in alphabetical order
        sortShopLists();
        focusShopList = shoppingLists.indexOf(list);

        // insert new shopping list to database
        long dbID = DBHelper.getInstance(Cookvert.getAppContext()).insertShoppingList(name);
        // save database key to map
        shopListMap.put(list.getId(), dbID);
    }

    /**
     * Adds new shop item into focused shop list and inserts it into database.
     * Row id of inserted item is also put into shop item map.
     * @param name shop item name
     */
    public void addShopItem(String name){
        ShopItem item = new ShopItem(name);
        getFocusedShopList().getItems().add(item);

        // get database key of shop list and use it to insert new shop item to database
        long listID = shopListMap.get(getFocusedShopList().getId());
        long dbID = DBHelper.getInstance(Cookvert.getAppContext()).insertShopItem(
                name, item.isSelected(), listID);
        // save database key to map
        shopItemMap.put(item.getId(), dbID);
    }

    /**
     * Deletes focused shop item from manager's list and the database.
     */
    public void deleteShopItem(){
        long dbID = shopItemMap.get(getFocusedShopItem().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).deleteShopItem(dbID);
        getFocusedShopList().getItems().remove(focusShopItem);
    }

    /**
     * Deletes focused shop list from manager's list and the database.
     */
    public void deleteShopList(){
        long dbID = shopListMap.get(getFocusedShopList().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).deleteShoppingList(dbID);
        shoppingLists.remove(focusShopList);
    }

    /**
     * Updates focused shop item's name in manager's list and the database.
     * @param name new shop item name
     */
    public void editShopItem(String name){
        long dbID = shopItemMap.get(getFocusedShopItem().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateShopItem(
                name, getFocusedShopItem().isSelected(), dbID);
        getFocusedShopItem().setName(name);
    }

    public void importShopList(ShopList list){
        // add new shop list to manager and database
        addShopList(list.getName());
        // add copies of each shop item to inserted shop list
        for(ShopItem i : list.getItems()){
            addShopItem(i.getName());
        }
    }

    /**
     * Updates focused shop list's name in manager's list and the database.
     * @param name new shop list name
     */
    public void renameShopList(String name){
        long dbID = shopListMap.get(getFocusedShopList().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateShoppingList(name, dbID);
        getFocusedShopList().setName(name);
    }

    /**
     * Updates focused shop item's checkbox value in manager's list and the database.
     * If the item is selected, item is also moved to the end of the shop list.
     * If the item is unselected, item is moved above all selected items.
     * @param selected new checkbox value for shop item
     */
    public void selectShopItem(boolean selected){
        long dbID = shopItemMap.get(getFocusedShopItem().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateShopItem(
                getFocusedShopItem().getName(), selected, dbID);
        getFocusedShopItem().setSelected(selected);

        ShopItem focusItem = getFocusedShopItem();
        // if item is selected, move it to the end of the list.
        if(selected){
            getFocusedShopList().getItems().remove(focusItem);
            getFocusedShopList().getItems().add(focusItem);
        }
        // if item is unselected, it is moved above selected items.
        else{
            int counter = 0;
            for(ShopItem s : getFocusedShopList().getItems()){
                if(s.isSelected()){
                    getFocusedShopList().getItems().remove(focusItem);
                    getFocusedShopList().getItems().add(counter-1, focusItem);
                    return;
                } else{
                    counter++;
                }
            }
            getFocusedShopList().getItems().remove(focusItem);
            getFocusedShopList().getItems().add(counter-1, focusItem);
            return;
        }

        // update focus position
        focusShopItem = getFocusedShopList().getItems().indexOf(focusItem);
    }



    //****************************************************************************************************
    //                                         PUBLIC METHODS
    //****************************************************************************************************

    /**
     * Iterates through focused shop list
     * and arranges the shop items so that checked items appear last in the list.
     */
    public void sortShopItems(){
        ArrayList<ShopItem> checkedItems = new ArrayList<>();
        //collect checked items from the shop list
        for(ShopItem si : shoppingLists.get(focusShopList).getItems()){
            // if shop item is checked, move it to the end of the shop list
            if(si.isSelected()){
                checkedItems.add(si);
            }
        }
        // put collected items to the bottom of the list
        for(ShopItem s : checkedItems){
            shoppingLists.get(focusShopList).getItems().remove(s);
            shoppingLists.get(focusShopList).getItems().add(s);
        }
    }

    public void sortShopLists(){
        Collections.sort(shoppingLists);
    }

    /**
     * Sorts the items in focused shop list and returns it.
     * @return currently focused shop list
     */
    public ShopList getFocusedShopList(){
        //sort items before giving the list to outer classes
        sortShopItems();
        return shoppingLists.get(focusShopList);
    }

    public ShopItem getFocusedShopItem(){
        return shoppingLists.get(focusShopList).getItems().get(focusShopItem);
    }


    //****************************************************************************************************
    //                                         PRIVATE METHODS
    //****************************************************************************************************

    private void readShopItemsFromDB(ShopList list){
        long dbID = shopListMap.get(list.getId());
        Cursor cursor = DBHelper.getInstance(Cookvert.getAppContext()).readShopItemsInList(dbID);

        String nameArg;
        int selectedArg;
        long idArg;
        ShopItem si;

        while(cursor.moveToNext()){
            // read primary key, name and checkbox value from database
            idArg = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.ShopItem._ID));
            nameArg = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBContract.ShopItem.NAME));
            selectedArg = cursor.getInt(
                    cursor.getColumnIndexOrThrow(DBContract.ShopItem.SELECTED));

            //create new shop item and put primary key into map
            if(selectedArg == 1){
                si = new ShopItem(nameArg, true);
            } else{
                si = new ShopItem(nameArg, false);
            }
            list.getItems().add(si);
            shopItemMap.put(si.getId(), idArg);
        }
        cursor.close();
        Log.d(LOG_TAG, "shop items were read successfully from shop list, num of items:"
                + String.valueOf(list.getItems().size()));
    }

    private void readShopListsFromDB(){
        Cursor cursor = DBHelper.getInstance(Cookvert.getAppContext()).readAllShoppingLists();

        String nameArg;
        long idArg;
        ShopList sl;

        while(cursor.moveToNext()){
            // read primary key and name from database
            idArg = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.ShopList._ID));
            nameArg = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBContract.ShopList.NAME));

            // create new shop list and put primary key into map
            sl = new ShopList(nameArg);
            shoppingLists.add(sl);
            shopListMap.put(sl.getId(), idArg);
        }
        cursor.close();
        Log.d(LOG_TAG, "shop lists were read successfully from db, num of shop lists:"
                + String.valueOf(shoppingLists.size()));
    }
}
