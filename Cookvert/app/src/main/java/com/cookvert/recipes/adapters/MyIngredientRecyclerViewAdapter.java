package com.cookvert.recipes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.recipes.fragments.OriginalRecipeFragment.
        OnOriginalListFragmentInteractionListener;
import com.cookvert.recipes.model.Ingredient;

import java.util.List;

/**
 * TODO Change name into IngredientRecycler....
 */
public class MyIngredientRecyclerViewAdapter extends
        RecyclerView.Adapter<MyIngredientRecyclerViewAdapter.ViewHolder> {

    private final List<Ingredient> mValues;
    private final OnOriginalListFragmentInteractionListener mListener;

    public MyIngredientRecyclerViewAdapter(List<Ingredient> items,
                                           OnOriginalListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        //Bind the adapter to the activity
        mListener.setOriginalRecipeAdapter(MyIngredientRecyclerViewAdapter.this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ingredient_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mAmountView.setText(mValues.get(position).getRoundedAmount());
        Context context = (Context) mListener; //Get the context for the getString() method
        holder.mUnitView.setText(context.getString(mValues.get(position).getUnit().getRes()));
        holder.mNameView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the activity that an item has been selected.
                    mListener.onOriginalListFragmentInteraction(holder, position);
                }
            }
        });

        // add divider for item

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mAmountView;
        public final TextView mUnitView;
        public final TextView mNameView;
        public Ingredient mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mAmountView = (TextView) view.findViewById(R.id.converted_amount);
            mUnitView = (TextView) view.findViewById(R.id.converted_unit);
            mNameView = (TextView) view.findViewById(R.id.converted_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mAmountView.getText() +
                    mUnitView.getText() + mNameView.getText() + "'";
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
