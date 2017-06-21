package com.cookvert.conversion.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.conversion.fragments.ConvertedRecipeFragment.OnConvertedListFragmentInteractionListener;
import com.cookvert.conversion.fragments.dummy.DummyContent.DummyItem;
import com.cookvert.recipes.model.Ingredient;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnConvertedListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 * TODO move to adapter folder?
 */
public class MyConvertedIngredientRecyclerViewAdapter extends RecyclerView.Adapter<MyConvertedIngredientRecyclerViewAdapter.ViewHolder> {

    private final List<Ingredient> mValues;
    private final OnConvertedListFragmentInteractionListener mListener;

    public MyConvertedIngredientRecyclerViewAdapter(List<Ingredient> items, OnConvertedListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        mListener.setConvertedRecipeAdapter(MyConvertedIngredientRecyclerViewAdapter.this);
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
        //TODO Create a method for rounding the decimals correctly
        holder.mAmountView.setText(mValues.get(position).getRoundedAmount());
        Context context = (Context) mListener; //Get the context for the getString() method
        //TODO Create a method for extracting short name for units and use it here
        holder.mUnitView.setText(context.getString(mValues.get(position).getUnit().getRes()));
        holder.mNameView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the activity that an item has been selected.
                    mListener.onConvertedListFragmentInteraction(holder, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
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
            return super.toString() + " '" + mAmountView.getText() + mUnitView.getText() + mNameView.getText() + "'";
        }
    }
}
