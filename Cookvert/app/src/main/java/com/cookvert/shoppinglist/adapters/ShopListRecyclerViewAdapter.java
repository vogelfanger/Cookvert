package com.cookvert.shoppinglist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.shoppinglist.fragments.ShopListsFragment.
        OnShopListFragmentInteractionListener;
import com.cookvert.shoppinglist.model.ShopList;

import java.util.List;

/**
 *
 */

public class ShopListRecyclerViewAdapter extends
        RecyclerView.Adapter<ShopListRecyclerViewAdapter.ViewHolder> {

    private final List<ShopList> mValues;
    private final OnShopListFragmentInteractionListener mListener;

    public ShopListRecyclerViewAdapter(List<ShopList> mValues,
                                       OnShopListFragmentInteractionListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
        // bind adapter to activity
        this.mListener.setShopListAdapter(ShopListRecyclerViewAdapter.this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shop_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the activity that an item has been selected.
                    mListener.onShopListFragmentInteraction(holder, position);
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
        public final TextView mNameView;
        public ShopList mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.shopping_list_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}