package com.cookvert.shoppinglist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.data.DBHelper;
import com.cookvert.data.GoogleDriveManager;
import com.cookvert.help.activities.HelpActivity;
import com.cookvert.help.activities.SignInOptionsActivity;
import com.cookvert.recipes.activities.RecipesActivity;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.adapters.ShopListRecyclerViewAdapter;
import com.cookvert.shoppinglist.fragments.DeleteShopListDialog;
import com.cookvert.shoppinglist.fragments.NewShopListDialog;
import com.cookvert.shoppinglist.fragments.RenameShopListDialog;
import com.cookvert.shoppinglist.fragments.ShopListsFragment;

public class ShopListsActivity extends AppCompatActivity implements
        NewShopListDialog.OnNewShopListListener,
        ShopListsFragment.OnShopListFragmentInteractionListener,
        RenameShopListDialog.OnRenameShopListListener,
        DeleteShopListDialog.OnDeleteShopListListener{

    ShopListRecyclerViewAdapter shopListAdapter;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

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

        // set up drawer from layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        // make home button in app bar visible
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.navigation_item_convert:
                        startActivity(new Intent(ShopListsActivity.this, ConvertActivity.class));
                        return true;
                    case R.id.navigation_item_recipes:
                        startActivity(new Intent(ShopListsActivity.this, RecipesActivity.class));
                        return true;
                    case R.id.navigation_item_shop_lists:
                        // activity already selected, NOP
                        return true;
                    case R.id.navigation_item_sign_in:
                        startActivity(new Intent(ShopListsActivity.this, SignInOptionsActivity.class));
                        return true;
                    case R.id.navigation_item_help:
                        startActivity(new Intent(ShopListsActivity.this, HelpActivity.class));
                        return true;
                }
                return false;
            }
        });

        // preselect item based on current activity
        navigationView.getMenu().getItem(2).setChecked(true);
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

    @Override
    protected void onStop() {
        if(GoogleDriveManager.getInstance().signedIn()){
            try {
                GoogleDriveManager.getInstance().saveAppDataToDrive(this);
            }catch (Exception e){
                Log.e("RecipesActivity", "Saving to Drive failed", e);
            }
        }
        super.onStop();
    }



    //****************************************************************************************************
    //                                   FRAGMENT INTERACTION METHODS
    //****************************************************************************************************



    @Override
    public void onContextMenuCreated(int itemPosition) {
        ShopListManager.getInstance().setFocusShopList(itemPosition);
    }

    @Override
    public void onDeleteShopList() {
        ShopListManager.getInstance().deleteShopList();
        shopListAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);
        Toast toast = Toast.makeText(this, R.string.toast_shop_list_deleted, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onNewShopList(String name) {
        ShopListManager.getInstance().addShopList(name);
        shopListAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);
        startActivity(new Intent(ShopListsActivity.this, EditShopListActivity.class));
    }

    @Override
    public void onRenameShopList(String name) {
        ShopListManager.getInstance().renameShopList(name);
        shopListAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);
    }

    @Override
    public void onShopListFragmentInteraction(
            ShopListRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        // set selected shop list to focus in ShopListManager
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
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() == getResources().getString(R.string.action_edit_shop_list)){
            RenameShopListDialog rDialog = RenameShopListDialog.newInstance(
                    ShopListManager.getInstance().getFocusedShopList().getName());
            rDialog.show(getSupportFragmentManager(), "renameShopListDialog");
            return true;
        }
        else if(item.getTitle() == getResources().getString(R.string.action_delete)){
            DeleteShopListDialog dDialog = DeleteShopListDialog.newInstance();
            dDialog.show(getSupportFragmentManager(), "deleteShopListDialog");
            return true;
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

        }
        return super.onOptionsItemSelected(item);
    }
}
