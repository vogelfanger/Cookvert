package com.cookvert.help.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cookvert.BuildConfig;
import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.help.HelpManager;
import com.cookvert.help.adapters.HelpItemRecyclerViewAdapter;
import com.cookvert.help.fragments.HelpListFragment;
import com.cookvert.recipes.activities.RecipesActivity;
import com.cookvert.shoppinglist.activities.ShopListsActivity;

/**
 *
 */

public class HelpActivity extends AppCompatActivity
        implements HelpListFragment.OnHelpListFragmentInteractionListener{

    private HelpItemRecyclerViewAdapter adapter;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        // Get version name from build config and set it to text view
        TextView versionName = (TextView)  findViewById(R.id.text_about_version_number);
        versionName.setText(getResources().getString(R.string.help_about_version) + BuildConfig.VERSION_NAME);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                        startActivity(new Intent(HelpActivity.this, ConvertActivity.class));
                        return true;
                    case R.id.navigation_item_recipes:
                        startActivity(new Intent(HelpActivity.this, RecipesActivity.class));
                        return true;
                    case R.id.navigation_item_shop_lists:
                        startActivity(new Intent(HelpActivity.this, ShopListsActivity.class));
                        return true;
                    case R.id.navigation_item_sign_in:
                        startActivity(new Intent(HelpActivity.this, SignInOptionsActivity.class));
                        return true;
                    case R.id.navigation_item_help:
                        // activity already selected, NOP
                        return true;
                }
                return false;
            }
        });

        // preselect item based on current activity
        navigationView.getMenu().getItem(3).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }



    //****************************************************************************************************
    //                                   FRAGMENT INTERACTION METHODS
    //****************************************************************************************************



    @Override
    public void onHelpListFragmentInteraction(
            HelpItemRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        HelpManager.getInstance().setFocusPosition(itemPosition);

        // add focused help topic into intent and launch HelpContentActivity
        Intent intent = new Intent(HelpActivity.this, HelpContentActivity.class);
        Bundle b = new Bundle();
        b.putString(HelpManager.ARG_HELP_CONTENT, HelpManager.getInstance().getFocusedHelpTopic());
        intent.putExtras(b);
        startActivity(intent);
    }

    @Override
    public void setHelpListAdapter(HelpItemRecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }



    //****************************************************************************************************
    //                                   MENU INTERACTION METHODS
    //****************************************************************************************************



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