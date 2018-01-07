package com.cookvert.help.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cookvert.R;
import com.cookvert.help.HelpManager;
import com.cookvert.help.fragments.HelpConvertSavedRecipeFragment;
import com.cookvert.help.fragments.HelpConvertTemperatureFragment;
import com.cookvert.help.fragments.HelpConvertUnitsFragment;
import com.cookvert.help.fragments.HelpSaveRecipesFragment;
import com.cookvert.help.fragments.HelpScaleSavedRecipeFragment;
import com.cookvert.help.fragments.HelpUnitsFragment;

/**
 *
 */

public class HelpContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_content);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set help topic as title for actionbar
        getSupportActionBar().setTitle(HelpManager.getInstance().getFocusedHelpTopic());

        // enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // make sure activity is using correct layout file
        if (findViewById(R.id.help_content_fragment) != null) {

            //if fragment already exists, no need to create a new one
            if (savedInstanceState != null) {
                return;
            }

            getSupportFragmentManager().beginTransaction().replace(
                    R.id.help_content_fragment, getContentFragment()).commit();
        }

    }

    @Override
    //TODO if there is a need for options menu, make and inflate a new menu layout
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    /**
     * Returns a new fragment based on data taken from intent extras
     * @return new fragment object
     */
    private Fragment getContentFragment(){
        String key = getIntent().getExtras().getString(HelpManager.ARG_HELP_CONTENT);

        if(key.equals(getResources().getString(R.string.title_help_how_to_convert))){
            return HelpConvertUnitsFragment.newInstance();
        }

        else if(key.equals(getResources().getString(
                R.string.title_help_how_to_convert_saved_recipe))){
            return HelpConvertSavedRecipeFragment.newInstance();
        }

        else if(key.equals(getResources().getString(
                R.string.title_help_how_to_convert_temperature))){
            return HelpConvertTemperatureFragment.newInstance();
        }

        else if(key.equals(getResources().getString(R.string.title_help_how_to_save_recipes))){
            return HelpSaveRecipesFragment.newInstance();
        }

        else if(key.equals(getResources().getString(R.string.title_help_how_to_scale_recipe))){
            return HelpScaleSavedRecipeFragment.newInstance();
        }
        else if(key.equals(getResources().getString(R.string.title_help_which_units_to_use))){
            return HelpUnitsFragment.newInstance();
        }

        return null;
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
