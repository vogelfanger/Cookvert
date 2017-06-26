package com.cookvert.recipes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.cookvert.R;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.adapters.RecipeRecyclerViewAdapter;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;
import com.cookvert.recipes.fragments.RecipeListFragment;

public class RecipesActivity extends AppCompatActivity
                             implements RecipeListFragment.OnRecipeListFragmentInteractionListener{



    RecipeRecyclerViewAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        //TODO is this really necessary?
        if (findViewById(R.id.fragment_container) != null) {
            // Do nothing when restored from previous state to prevent overlapping fragments
            if (savedInstanceState != null) {
                return;
            }
            //Create recipe list fragment and place it to fragment container
            RecipeListFragment recipeListFragment = RecipeListFragment.newInstance("", "");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, recipeListFragment, "recipeListFragment").commit();
        }
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipes, menu);
        return true;
    }


    //TODO add list interaction implementation
    @Override
    public void onRecipeListFragmentInteraction(RecipeRecyclerViewAdapter.ViewHolder item, int itemPosition) {

    }

    @Override
    public void setRecipeListAdapter(RecipeRecyclerViewAdapter adapter) {
        recipeAdapter = adapter;
    }

}
