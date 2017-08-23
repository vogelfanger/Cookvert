package com.cookvert.shoppinglist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.shoppinglist.fragments.ShopItemListFragment;
import com.cookvert.shoppinglist.model.ShopItem;

import java.util.List;

/**
 *
 */

public class ShopItemRecyclerViewAdapter extends
        RecyclerView.Adapter<ShopItemRecyclerViewAdapter.ViewHolder> {

    private final List<ShopItem> mValues;
    ShopItemListFragment.OnShopItemListInteractionListener mListener;
    // flag informing when checkbox is being bind
    boolean onBind;

    public ShopItemRecyclerViewAdapter(
            List<ShopItem> items, ShopItemListFragment.OnShopItemListInteractionListener listener){
        mValues = items;
        mListener = listener;
        mListener.setShopItemListAdapter(ShopItemRecyclerViewAdapter.this);
    }

    @Override
    public ShopItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_shop_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopItemRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());

        holder.mNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onShopItemNameClick(holder, position);
            }
        });

        // set checkbox listener to null at first to prevent illegal states
        holder.mCheckBox.setOnCheckedChangeListener(null);
        // set initial value for checkbox
        holder.mCheckBox.setChecked(holder.mItem.isSelected());
        // set new checkbox listener
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mListener.onShopItemCheboxClick(holder, position, b);
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
        public final CheckBox mCheckBox;
        public ShopItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.text_shop_item_name);
            mCheckBox = (CheckBox) view.findViewById(R.id.checkbox_shop_item);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
