package com.cookvert.shoppinglist.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookvert.R;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.adapters.ShopItemRecyclerViewAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShopItemListFragment.OnShopItemListInteractionListener} interface
 * to handle interaction events.
 */
public class ShopItemListFragment extends Fragment {

    private OnShopItemListInteractionListener mListener;

    public ShopItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            //New adapter parameter
            recyclerView.setAdapter(
                    new ShopItemRecyclerViewAdapter(getShopItemList(), mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnShopItemListInteractionListener) {
            mListener = (OnShopItemListInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnShopItemListInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private List getShopItemList(){
        return ShopListManager.getInstance().getFocusedShopList().getItems();
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
    public interface OnShopItemListInteractionListener {
        void onShopItemNameClick(ShopItemRecyclerViewAdapter.ViewHolder holder, int itemPosition);
        void onShopItemCheboxClick(ShopItemRecyclerViewAdapter.ViewHolder holder,
                                   int itemPosition, boolean checked);
        void setShopItemListAdapter(ShopItemRecyclerViewAdapter adapter);
        void onContextMenuCreated(int itemPosition);
    }
}
