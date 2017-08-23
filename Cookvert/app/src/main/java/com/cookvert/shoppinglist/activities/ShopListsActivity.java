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

import com.cookvert.R;
import com.cookvert.data.DBHelper;
import com.cookvert.menu.MainActivity;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.adapters.ShopListRecyclerViewAdapter;
import com.cookvert.shoppinglist.fragments.NewShopListDialog;
import com.cookvert.shoppinglist.fragments.ShopListsFragment;

public class ShopListsActivity extends AppCompatActivity implements
        PopupMenu.OnMenuItemClickListener,
        NewShopListDialog.OnNewShopListListener,
        ShopListsFragment.OnShopListFragmentInteractionListener{

    ShopListRecyclerViewAdapter shopListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplists);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewShopListDialog dialog = NewShopListDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "newShopListDialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop_lists, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        // close database connection when activity is destroyed
        DBHelper.getInstance(getApplicationContext()).close();
        super.onDestroy();
    }



    //****************************************************************************************************
    //                                   FRAGMENT INTERACTION METHODS
    //****************************************************************************************************


    @Override
    public void onNewShopList(String name) {
        ShopListManager.getInstance().addShopList(name);
        shopListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onShopListFragmentInteraction(
            ShopListRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        // set selected shoplist to focus in ShopListManager
        ShopListManager.getInstance().setFocusShopList(itemPosition);
        startActivity(new Intent(ShopListsActivity.this, EditShopListActivity.class));
    }


    @Override
    public void setShopListAdapter(ShopListRecyclerViewAdapter adapter) {
        shopListAdapter = adapter;
    }



    //****************************************************************************************************
    //                                   MENU INTERACTION METHODS
    //****************************************************************************************************



    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.popup_rename_shoplist:
                //TODO implement dialog
                return true;
            case R.id.popup_delete_shoplist:
                // TODO delete shoplist and make toast
        }
        return false;
    }

    /**
     * Handles actions for app bar menu interactions
     * @param item Selected menu item
     * @return true, if item was selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_main_menu:
                startActivity(new Intent(ShopListsActivity.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
