package com.cookvert.shoppinglist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookvert.R;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.adapters.ShopListRecyclerViewAdapter;
import com.cookvert.shoppinglist.model.ShopList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShopListsFragment.OnShopListFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ShopListsFragment extends Fragment {

    private OnShopListFragmentInteractionListener mListener;

    public ShopListsFragment() {
        // Required empty public constructor
    }

    public static ShopListsFragment newInstance(){
        ShopListsFragment fragment = new ShopListsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_lists, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new ShopListRecyclerViewAdapter(
                    ShopListManager.getInstance().getShoppingLists(), mListener));
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnShopListFragmentInteractionListener) {
            mListener = (OnShopListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnShopListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnShopListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onShopListFragmentInteraction(
                ShopListRecyclerViewAdapter.ViewHolder item, int itemPosition);
        void setShopListAdapter(ShopListRecyclerViewAdapter adapter);
        void onContextMenuCreated(int itemPosition);
    }
}
