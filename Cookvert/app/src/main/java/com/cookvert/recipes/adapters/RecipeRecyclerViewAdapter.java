package com.cookvert.recipes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.recipes.fragments.RecipeListFragment;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.RecipeCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class RecipeRecyclerViewAdapter extends BaseExpandableListAdapter{

    private final List<RecipeCategory> mValues;
    private final RecipeListFragment.OnRecipeListFragmentInteractionListener mListener;

    public RecipeRecyclerViewAdapter(ArrayList<RecipeCategory> items, RecipeListFragment.OnRecipeListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        //Bind the adapter to the activity
        mListener.setRecipeListAdapter(RecipeRecyclerViewAdapter.this);
    }



    @Override
    public int getGroupCount() {
        return mValues.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mValues.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ParentRecipeCategoryViewHolder parentViewHolder;

        //inflate category layout, create a new view holder and bind it into the view
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recipe_category, parent, false);
            parentViewHolder = new ParentRecipeCategoryViewHolder(convertView);
            convertView.setTag(parentViewHolder);
        }else {
            //if layout is already inflated, get the view from tag
            parentViewHolder = (ParentRecipeCategoryViewHolder) convertView.getTag();
        }

        //set the data for text view
        RecipeCategory rc = mValues.get(groupPosition);
        parentViewHolder.nameView.setText(rc.name);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //return number of recipes in the category
        return mValues.get(groupPosition).recipes.size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mValues.get(groupPosition).recipes.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final ChildRecipeViewHolder childViewHolder;

        //inflate category layout, create a new view holder and bind it into the view
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recipe_list_row, parent, false);
            childViewHolder = new ChildRecipeViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }else{
            //if layout is already inflated, get the view from tag
            childViewHolder = (ChildRecipeViewHolder) convertView.getTag();
        }

        //set the data for text view
        Recipe r = mValues.get(groupPosition).recipes.get(childPosition);
        childViewHolder.nameView.setText(r.name);

        childViewHolder.nameView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.onRecipeListFragmentInteraction(groupPosition, childPosition);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * ViewHolder containing a single recipe category item
     * //TODO add an arrow to layout?
     */
    public class ParentRecipeCategoryViewHolder {
        public final View view;
        public final TextView nameView;
        public RecipeCategory item;

        public ParentRecipeCategoryViewHolder(View view) {
            this.view = view;
            nameView = (TextView) view.findViewById(R.id.recipe_category_name);
        }
    }

    /**
     * ViewHolder containing a single recipe item
     */
    public class ChildRecipeViewHolder {
        public final View view;
        public final TextView nameView;
        public Recipe item;

        public ChildRecipeViewHolder(View view) {
            this.view = view;
            nameView = (TextView) view.findViewById(R.id.recipe_name);
        }
    }




}
