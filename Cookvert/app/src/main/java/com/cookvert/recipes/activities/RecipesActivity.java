package com.cookvert.recipes.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cookvert.R;
import com.cookvert.menu.MainActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.adapters.RecipeRecyclerViewAdapter;
import com.cookvert.recipes.fragments.InstructionFragment;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;
import com.cookvert.recipes.fragments.RecipeListFragment;

public class RecipesActivity extends AppCompatActivity
                             implements RecipeListFragment.OnRecipeListFragmentInteractionListener{



    RecipeRecyclerViewAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //update adapter in case recipe was deleted in EditRecipeActivity
        //recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipes, menu);
        return true;
    }

    //****************************************************************************************************
    //*****                               FRAGMENT INTERACTION METHODS                               *****
    //****************************************************************************************************

    @Override
    public void onRecipeListFragmentInteraction(int categoryPosition, int recipePosition) {
        //set focus point for RecipeManager so that the right recipe can be edited
        RecipeManager.getInstance().focusCategory = categoryPosition;
        RecipeManager.getInstance().focusRecipe = recipePosition;
        //start new activity where ingredient data can be edited
        startActivity(new Intent(getApplicationContext(), EditRecipeActivity.class));
    }

    @Override
    public void setRecipeListAdapter(RecipeRecyclerViewAdapter adapter) {
        recipeAdapter = adapter;
    }

    /**
     * Handles actions for app bar menu interactions
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //TODO implement actions for each item
        switch (item.getItemId()) {
            case R.id.action_new_category:
                return true;
            case R.id.action_main_menu:
                startActivity(new Intent(RecipesActivity.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
