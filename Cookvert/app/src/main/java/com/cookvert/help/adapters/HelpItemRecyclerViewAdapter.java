package com.cookvert.help.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.help.fragments.HelpListFragment.OnHelpListFragmentInteractionListener;

import java.util.List;

/**
 * Adapter for HelpListFragment
 */

public class HelpItemRecyclerViewAdapter extends
        RecyclerView.Adapter<HelpItemRecyclerViewAdapter.ViewHolder>{

    private final List<String> mValues;
    private final OnHelpListFragmentInteractionListener mListener;

    public HelpItemRecyclerViewAdapter(List<String> mValues,
                                       OnHelpListFragmentInteractionListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
        // bind adapter to activity
        this.mListener.setHelpListAdapter(HelpItemRecyclerViewAdapter.this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_help_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mNameView.setText(mValues.get(position));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the activity that an item has been selected.
                    mListener.onHelpListFragmentInteraction(holder, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        public final TextView mNameView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.help_item_name);
        }
    }
}
