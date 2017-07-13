package com.cookvert.conversion.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.conversion.fragments.ChangeUnitDialog;
import com.cookvert.conversion.fragments.ConvertedRecipeFragment;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.fragments.EditIngredientDialog;
import com.cookvert.recipes.fragments.InstructionFragment;
import com.cookvert.conversion.adapters.MyConvertedIngredientRecyclerViewAdapter;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.fragments.NewIngredientDialog;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;
import com.cookvert.conversion.fragments.ScaleRecipeDialog;
import com.cookvert.menu.MainActivity;

import java.util.ArrayList;

/**
 * TODO implement instructions page when recipe section is finished
 */
public class ConvertActivity extends AppCompatActivity
        implements OriginalRecipeFragment.OnOriginalListFragmentInteractionListener,
                    ConvertedRecipeFragment.OnConvertedListFragmentInteractionListener,
                    InstructionFragment.OnEditInstructionsListener,
                    PopupMenu.OnMenuItemClickListener,
                    NewIngredientDialog.OnNewIngredientListener,
                    EditIngredientDialog.OnEditIngredientListener,
                    ScaleRecipeDialog.OnScaleRecipeListener,
                    ChangeUnitDialog.OnChangeUnitListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    // page adapter for each page fragment
    private SectionsPagerAdapter mSectionsPagerAdapter;
    //list of fragments used in view pager
    private ArrayList<Fragment> fragments = new ArrayList<>();

    // list adapters for original and converted recipes
    MyIngredientRecyclerViewAdapter originalAdapter;
    MyConvertedIngredientRecyclerViewAdapter convertedAdapter;

    FloatingActionButton fab;

    //recipe instructions given as argument from another Activity
    private String argInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //add list fragments to fragment list
        fragments.add(OriginalRecipeFragment.newInstance(1));
        fragments.add(ConvertedRecipeFragment.newInstance(1,1));

        //if recipe instructions were given as extra, add instruction fragment
        if(getIntent().hasExtra(RecipeManager.ARG_RECIPE_INSTRUCTIONS)){
            argInstructions = getIntent().getExtras().getString(RecipeManager.ARG_RECIPE_INSTRUCTIONS);
            fragments.add(InstructionFragment.newInstance(2, 0, argInstructions));
        }

        //create pager adapter using fragment list
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragments);

        // Set up the ViewPager with pager adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewIngredientDialog nDialog = NewIngredientDialog.newInstance();
                nDialog.show(getSupportFragmentManager(), "newIngredientDialog");
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        fab.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fab.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        fab.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert, menu);
        return true;

    }


    //****************************************************************************************************
    //*****                               FRAGMENT INTERACTION METHODS                               *****
    //****************************************************************************************************


    /**
     * Called when user interacts with a list item in OriginalRecipeFragment.
     * Opens a popup menu, where the user can edit the ingredient.
     * @param item
     */
    @Override
    public void onOriginalListFragmentInteraction(MyIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        //set the selected ingredient to focus, so that ConvertManager can edit the correct ingredient
        ConvertManager.getInstance().setFocusPosition(itemPosition);
        PopupMenu popup = new PopupMenu(this, item.mView);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup_original_recipe);
        popup.show();
    }

    @Override
    public void setOriginalRecipeAdapter(MyIngredientRecyclerViewAdapter adapter) {
        originalAdapter = adapter;
    }

    /**
     * Called when user interacts with a list item in ConvertedRecipeFragment.
     * Opens a popup menu, where the user can change unit.
     * @param item
     */
    @Override
    public void onConvertedListFragmentInteraction(MyConvertedIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        //set the selected ingredient to focus, so that ConvertManager can edit the correct ingredient
        ConvertManager.getInstance().setFocusPosition(itemPosition);
        PopupMenu popup = new PopupMenu(this, item.mView);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup_converted_recipe);
        popup.show();
    }

    @Override
    public void setConvertedRecipeAdapter(MyConvertedIngredientRecyclerViewAdapter adapter) {
        convertedAdapter = adapter;
    }

    /**
     * Instructions are uneditable in this Activity, so this method does nothing
     */
    @Override
    public void onEditInstructions(String instructions) {
    }

    /**
     * Instructions are uneditable in this Activity, so this method does nothing
     */
    @Override
    public void onHideKeyboard(View view) {
    }

    /**
     *
     *
     *
     */
    @Override
    public void onNewIngredient(Double amount, int unitKey, String name){
        ConvertManager.getInstance().addIngredient(amount, unitKey, name);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }

    /**
     *
     *
     *
     */
    @Override
    public void onEditIngredient(Double amount, int unitKey, String name) {
        ConvertManager.getInstance().editIngredient(amount, unitKey, name);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }

    @Override
    public void onChangeUnit(int unitKey) {
        ConvertManager.getInstance().changeUnit(unitKey);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }

    /**
     *
     * @param multiplier
     */
    @Override
    public void onScaleRecipe(double multiplier) {
        ConvertManager.getInstance().changeMultiplier(multiplier);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }


    //****************************************************************************************************
    //*****                                  MENU INTERACTION METHODS                                ********
    //****************************************************************************************************



    /**
     * Handles actions for popup menus in lists.
     * @param item
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){

            //set the correct unit menu according to the selected unit
            case R.id.popup_change_unit:
                //selected unit's position in spinner is given as argument for dialogs
                int argUnitPos;
                //selected unit is mass unit
                if(ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isMassUnit()){
                    argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().massListPosition();
                    ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_mass_units, argUnitPos);
                    cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
                }
                //selected unit is volume unit
                else if(ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isPiece() == false){
                    argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().volumeListPosition();
                    ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_volume_units, argUnitPos);
                    cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
                }
                //selected unit is piece, can't be converted
                else{
                    Toast toast = Toast.makeText(this, R.string.error_unit_piece_converted, Toast.LENGTH_SHORT);
                    toast.show();
                }
                return true;

            case R.id.popup_edit:
                //create dialog using selected ingredient data as arguments
                String argAmount = Double.toString(ConvertManager.getInstance().getOriginalFocusIngredient().getAmount());
                //selected unit's position when spinner contains all units
                int argUnitPos1 = ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().wholeListPosition();
                String argName = ConvertManager.getInstance().getOriginalFocusIngredient().getName();

                EditIngredientDialog eDialog = EditIngredientDialog.newInstance(argAmount, argUnitPos1, argName);
                eDialog.show(getSupportFragmentManager(), "editIngredientDialog");
                return true;
            case R.id.popup_delete:
                //delete ingredient and update lists
                ConvertManager.getInstance().deleteIngredient();
                originalAdapter.notifyDataSetChanged();
                convertedAdapter.notifyDataSetChanged();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_load_recipe:
                //TODO open dialog with database access
                return true;

            case R.id.action_new_recipe:
                //TODO open dialog
                return true;

            case R.id.action_new_shopping_list:
                //TODO open dialog and open activity
                return true;

            case R.id.action_main_menu:
                startActivity(new Intent(ConvertActivity.this, MainActivity.class));
                return true;

            case R.id.action_scale_recipe:
                //put recipe multiplier as argument for dialog
                ScaleRecipeDialog sDialog = ScaleRecipeDialog.newInstance(Double.toString(ConvertManager.getInstance()
                        .getMultiplier()));
                sDialog.show(getSupportFragmentManager(), "ScaleRecipeDialog");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



    //****************************************************************************************************
    //*****                                      PAGER ADAPTER                                       ********
    //****************************************************************************************************

    /**
     * Delete a fragment from list of fragments and update ViewPager
     * @param position
     */
    public void deletePageFragment(int position){
        if(position < fragments.size()){
            fragments.remove(position);
            mSectionsPagerAdapter.notifyDataSetChanged();
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        //list of fragments in pager, given as a parameter
        private ArrayList<Fragment> pagerFragments;

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<Fragment> pagerFragments) {
            super(fm);
            this.pagerFragments = pagerFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return pagerFragments.get(position);
        }

        @Override
        public int getCount() {
            return pagerFragments.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.title_pager_original_recipe);
                case 1:
                    return getResources().getString(R.string.title_pager_converted_recipe);
                case 2:
                    return getResources().getString(R.string.title_pager_recipe_instructions);
            }
            return null;
        }
    }
}
