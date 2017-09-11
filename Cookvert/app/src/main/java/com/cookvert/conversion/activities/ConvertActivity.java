package com.cookvert.conversion.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.conversion.fragments.ChangeUnitDialog;
import com.cookvert.conversion.fragments.ConvertTemperatureDialog;
import com.cookvert.conversion.fragments.ConvertedRecipeFragment;
import com.cookvert.conversion.fragments.ExportRecipeDialog;
import com.cookvert.conversion.fragments.ExportShopListDialog;
import com.cookvert.conversion.fragments.ImportRecipeDialog;
import com.cookvert.help.HelpActivity;
import com.cookvert.navigation.DrawerListAdapter;
import com.cookvert.navigation.NavigationItem;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.activities.EditRecipeActivity;
import com.cookvert.recipes.activities.RecipesActivity;
import com.cookvert.recipes.fragments.EditIngredientDialog;
import com.cookvert.recipes.fragments.InstructionFragment;
import com.cookvert.conversion.adapters.MyConvertedIngredientRecyclerViewAdapter;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.fragments.NewIngredientDialog;
import com.cookvert.recipes.fragments.NewRecipeDialog;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;
import com.cookvert.conversion.fragments.ScaleRecipeDialog;
import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.Unit;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.activities.EditShopListActivity;
import com.cookvert.shoppinglist.activities.ShopListsActivity;
import com.cookvert.shoppinglist.fragments.NewShopListDialog;
import com.cookvert.shoppinglist.model.ShopList;

import java.util.ArrayList;

/**
 *
 */
public class ConvertActivity extends AppCompatActivity
        implements OriginalRecipeFragment.OnOriginalListFragmentInteractionListener,
                    ConvertedRecipeFragment.OnConvertedListFragmentInteractionListener,
                    InstructionFragment.OnEditInstructionsListener,
                    NewIngredientDialog.OnNewIngredientListener,
                    EditIngredientDialog.OnEditIngredientListener,
                    ScaleRecipeDialog.OnScaleRecipeListener,
                    ChangeUnitDialog.OnChangeUnitListener,
                    ExportShopListDialog.OnExportShopListListener,
                    ExportRecipeDialog.OnExportRecipeListener,
                    ImportRecipeDialog.OnImportRecipeListener{

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
    private MyIngredientRecyclerViewAdapter originalAdapter;
    private MyConvertedIngredientRecyclerViewAdapter convertedAdapter;

    private FloatingActionButton fab;
    // text view at the bottom of the activity
    private TextView multiplierView;
    // text for multiplierView, multplier is added after this text dynamically
    private String muliplierText;

    //recipe instructions given as argument from another Activity
    private String argInstructions;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

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

        muliplierText = getResources().getString(R.string.text_multiplier_amount);
        // set text for multiplier view at the bottom of the activity
        multiplierView = (TextView) findViewById(R.id.text_multiplier_covert_activity);
        multiplierView.setText(
                muliplierText + " " + String.valueOf(ConvertManager.getInstance().getMultiplier()));

        // set up drawer from layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        // make home button in app bar visible
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.navigation_item_convert:
                        // activity already selected, NOP
                        return true;
                    case R.id.navigation_item_recipes:
                        startActivity(new Intent(ConvertActivity.this, RecipesActivity.class));
                        return true;
                    case R.id.navigation_item_shop_lists:
                        startActivity(new Intent(ConvertActivity.this, ShopListsActivity.class));
                        return true;
                    case R.id.navigation_item_help:
                        startActivity(new Intent(ConvertActivity.this, HelpActivity.class));
                        return true;
                }
                return false;
            }
        });

        // preselect item based on current activity
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert, menu);
        return true;

    }



    //****************************************************************************************************
    //                                    FRAGMENT INTERACTION METHODS
    //****************************************************************************************************


    /**
     * Called when user interacts with a list item in OriginalRecipeFragment.
     * Opens a popup menu, where the user can edit the ingredient.
     * @param item
     */
    @Override
    public void onOriginalListFragmentInteraction(MyIngredientRecyclerViewAdapter.ViewHolder item,
                                                  int itemPosition) {
        //set selected ingredient to focus, so that ConvertManager can edit the correct ingredient
        ConvertManager.getInstance().setFocusPosition(itemPosition);

        //create dialog using selected ingredient data as arguments
        String argAmount = Double.toString(ConvertManager.getInstance().getOriginalFocusIngredient().getAmount());
        //selected unit's position when spinner contains all units
        int argUnitPos1 = ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().wholeListPosition();
        String argName = ConvertManager.getInstance().getOriginalFocusIngredient().getName();

        EditIngredientDialog eDialog = EditIngredientDialog.newInstance(argAmount, argUnitPos1, argName);
        eDialog.show(getSupportFragmentManager(), "editIngredientDialog");
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
    public void onConvertedListFragmentInteraction(
            MyConvertedIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        //set the selected ingredient to focus in ConvertManager
        ConvertManager.getInstance().setFocusPosition(itemPosition);

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
    }

    /**
     * Called when ingredient in list is long clicked (Context menu is created).
     * Sets selected ingredient position to focus in ConvertManager, so that actions from
     * Context menu are executed on the right list item.
     * @param itemPosition Selected ingredient position in list
     */
    @Override
    public void onContextMenuCreated(int itemPosition) {
        ConvertManager.getInstance().setFocusPosition(itemPosition);
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

    @Override
    public void onImportRecipe(int recipePosition) {
        ConvertManager.getInstance().importRecipeFromDialog(recipePosition);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();

        // remove old instructions page, if it exists
        if(fragments.size() >= 3) {
            fragments.remove(2);
        }
        // add instructions fragment to pager
        argInstructions = RecipeManager.getInstance().
                getAllRecipes().get(recipePosition).getInstructions();
        fragments.add(InstructionFragment.newInstance(2, 0, argInstructions));
        mSectionsPagerAdapter.notifyDataSetChanged();

        Toast toast = Toast.makeText(
                this, R.string.toast_recipe_loaded, Toast.LENGTH_SHORT);
        toast.show();
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

    @Override
    public void onExportRecipe(String name, boolean useOriginal) {
        // set up recipe in convert manager
        Recipe recipe = ConvertManager.getInstance().exportAsRecipe(name, useOriginal);
        // add recipe to recipe manager
        RecipeManager.getInstance().importRecipe(recipe);
        startActivity(new Intent(ConvertActivity.this, EditRecipeActivity.class));

        //show toast
        Toast toast = Toast.makeText(
                this, R.string.toast_recipe_saved, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onExportShopList(String name) {
        // Set up new shop list in convert manager
        ShopList list = ConvertManager.getInstance().exportAsShopList(
                getApplicationContext(), name);
        // add shop list to shop list manager
        ShopListManager.getInstance().importShopList(list);
        startActivity(new Intent(ConvertActivity.this, EditShopListActivity.class));

        // show toast
        Toast toast = Toast.makeText(
                this, R.string.toast_shop_list_saved, Toast.LENGTH_SHORT);
        toast.show();
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
        multiplierView.setText(muliplierText + " " + String.valueOf(multiplier));
    }


    //****************************************************************************************************
    //*****                                  MENU INTERACTION METHODS                                ********
    //****************************************************************************************************



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // Change unit
        if(item.getTitle() == getResources().getString(R.string.action_change_unit)) {
            //selected unit's position in spinner is given as argument for dialogs
            int argUnitPos;
            //selected unit is mass unit
            if (ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isMassUnit()) {
                argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().massListPosition();
                ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_mass_units, argUnitPos);
                cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
            }
            //selected unit is volume unit
            else if (ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isPiece() == false) {
                argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().volumeListPosition();
                ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_volume_units, argUnitPos);
                cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
            }
            //selected unit is piece, can't be converted
            else {
                Toast toast = Toast.makeText(this, R.string.error_unit_piece_converted, Toast.LENGTH_SHORT);
                toast.show();
            }
            return true;
        }

        // Edit ingredient
        if(item.getTitle() == getResources().getString(R.string.action_edit_ingredient)) {
            //create dialog using selected ingredient data as arguments
            String argAmount = Double.toString(ConvertManager.getInstance().getOriginalFocusIngredient().getAmount());
            //selected unit's position when spinner contains all units
            int argUnitPos1 = ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().wholeListPosition();
            String argName = ConvertManager.getInstance().getOriginalFocusIngredient().getName();

            EditIngredientDialog eDialog = EditIngredientDialog.newInstance(argAmount, argUnitPos1, argName);
            eDialog.show(getSupportFragmentManager(), "editIngredientDialog");
            return true;
        }

        // Delete ingredient
        if(item.getTitle() == getResources().getString(R.string.action_delete)) {
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

            // home button opens drawer
            case R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);

            case R.id.action_clear_lists:
                ConvertManager.getInstance().deleteAllIngredients();
                originalAdapter.notifyDataSetChanged();
                convertedAdapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(
                        this, R.string.toast_ingredients_removed, Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.action_convert_temperature:
                Ingredient temp = ConvertManager.getInstance().getOriginalTemperature();
                if(temp.getUnit() == Unit.CELSIUS){
                    ConvertTemperatureDialog cDialog = ConvertTemperatureDialog.newInstance(
                            temp.getAmount(), 0);
                    cDialog.show(getSupportFragmentManager(), "convertTemperatureDialog");
                }else{
                    ConvertTemperatureDialog cDialog = ConvertTemperatureDialog.newInstance(
                            temp.getAmount(), 1);
                    cDialog.show(getSupportFragmentManager(), "convertTemperatureDialog");
                }
                return true;

            case R.id.action_load_recipe:
                ImportRecipeDialog imDialog = ImportRecipeDialog.newInstance();
                imDialog.show(getSupportFragmentManager(), "importRecipeDialog");
                return true;

            case R.id.action_new_recipe:
                ExportRecipeDialog erDialog = ExportRecipeDialog.newInstance();
                erDialog.show(getSupportFragmentManager(), "exportRecipeDialog");
                return true;

            case R.id.action_new_shopping_list:
                ExportShopListDialog dialog = ExportShopListDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "exportShopItemDialog");
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
    //                                      PAGER ADAPTER
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
