package com.cookvert.shoppinglist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.data.DBHelper;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.adapters.ShopItemRecyclerViewAdapter;
import com.cookvert.shoppinglist.fragments.DeleteShopListDialog;
import com.cookvert.shoppinglist.fragments.EditShopItemDialog;
import com.cookvert.shoppinglist.fragments.NewShopItemDialog;
import com.cookvert.shoppinglist.fragments.RenameShopListDialog;
import com.cookvert.shoppinglist.fragments.ShopItemListFragment;

public class EditShopListActivity extends AppCompatActivity implements
        ShopItemListFragment.OnShopItemListInteractionListener,
        NewShopItemDialog.OnNewShopItemListener,
        DeleteShopListDialog.OnDeleteShopListListener,
        EditShopItemDialog.OnEditShopItemListener,
        RenameShopListDialog.OnRenameShopListListener {

    private ShopItemRecyclerViewAdapter shopItemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shop_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set shop list name as title for actionbar
        getSupportActionBar().setTitle(
                ShopListManager.getInstance().getFocusedShopList().getName());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewShopItemDialog nDialog = NewShopItemDialog.newInstance();
                nDialog.show(getSupportFragmentManager(), "newShopItemDialog");
            }
        });

        // enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_shop_list, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        // close database connection when activity is destroyed
        DBHelper.getInstance(getApplicationContext()).close();
        super.onDestroy();
    }



    //****************************************************************************************************
    //                                  FRAGMENT INTERACTION METHODS
    //****************************************************************************************************



    @Override
    public void onContextMenuCreated(int itemPosition) {
        ShopListManager.getInstance().setFocusShopItem(itemPosition);
    }

    @Override
    public void onDeleteShopList() {
        startActivity(new Intent(getApplicationContext(), ShopListsActivity.class));
        ShopListManager.getInstance().deleteShopList();
        Toast toast = Toast.makeText(this, R.string.toast_shop_list_deleted, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onEditShopItem(String name) {
        ShopListManager.getInstance().editShopItem(name);
        shopItemListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNewShopItem(String name) {
        ShopListManager.getInstance().addShopItem(name);
        shopItemListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRenameShopList(String name) {
        ShopListManager.getInstance().renameShopList(name);
        shopItemListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setShopItemListAdapter(ShopItemRecyclerViewAdapter adapter) {
        shopItemListAdapter = adapter;
    }

    @Override
    public void onShopItemNameClick(ShopItemRecyclerViewAdapter.ViewHolder holder, int itemPosition) {
        ShopListManager.getInstance().setFocusShopItem(itemPosition);
        EditShopItemDialog eDialog = EditShopItemDialog.newInstance(
                ShopListManager.getInstance().getFocusedShopItem().getName());
        eDialog.show(getSupportFragmentManager(), "editShopItemDialog");
    }

    @Override
    public void onShopItemCheboxClick(ShopItemRecyclerViewAdapter.ViewHolder holder,
                                      int itemPosition, boolean checked) {
        ShopListManager.getInstance().setFocusShopItem(itemPosition);
        ShopListManager.getInstance().selectShopItem(checked);
        holder.mCheckBox.setChecked(checked);
        shopItemListAdapter.notifyDataSetChanged();
    }



    //****************************************************************************************************
    //                                  MENU INTERACTION METHODS
    //****************************************************************************************************


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle() == getResources().getString(R.string.action_edit_shop_item)){
            EditShopItemDialog eDialog = EditShopItemDialog.newInstance(
                    ShopListManager.getInstance().getFocusedShopItem().getName());
            eDialog.show(getSupportFragmentManager(), "editShopItemDialog");
            return true;
        }

        // Delete shop item
        else if(item.getTitle() == getResources().getString(R.string.action_delete)){
            ShopListManager.getInstance().deleteShopItem();
            shopItemListAdapter.notifyDataSetChanged();
            return true;
        }
        return false;
    }

    /**
     * Handles actions for app bar menu interactions
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(EditShopListActivity.this, ShopListsActivity.class));
                return true;

            case R.id.action_rename_shop_list:
                RenameShopListDialog rDialog = RenameShopListDialog.newInstance(
                        ShopListManager.getInstance().getFocusedShopList().getName());
                rDialog.show(getSupportFragmentManager(), "renameShopListDialog");
                return true;

            case R.id.action_delete_shop_list:
                DeleteShopListDialog dDialog = DeleteShopListDialog.newInstance();
                dDialog.show(getSupportFragmentManager(), "deleteShopListDialog");
                return true;
        }
        return false;
    }
}
