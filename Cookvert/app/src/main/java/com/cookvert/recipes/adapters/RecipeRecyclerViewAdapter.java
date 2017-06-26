package com.cookvert.recipes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.recipes.fragments.RecipeListFragment;
import com.cookvert.recipes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vogelfanger on 23.6.2017.
 */
public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder>{

    private final List<Recipe> values;
    private final RecipeListFragment.OnRecipeListFragmentInteractionListener listener;

    public RecipeRecyclerViewAdapter(ArrayList<Recipe> items, RecipeListFragment.OnRecipeListFragmentInteractionListener listener) {
        this.values = items;
        this.listener = listener;
        //Bind the adapter to the activity
        this.listener.setRecipeListAdapter(RecipeRecyclerViewAdapter.this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipe_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.item = values.get(position);
        holder.nameView.setText(values.get(position).name);

        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onRecipeListFragmentInteraction(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    /**
     * ViewHolder containing a single Recipe item
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView nameView;
        public Recipe item;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            nameView = (TextView) view.findViewById(R.id.recipe_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nameView.getText() + "'";
        }
    }


}
