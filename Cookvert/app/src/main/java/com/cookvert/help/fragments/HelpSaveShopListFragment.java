package com.cookvert.help.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cookvert.R;

public class HelpSaveShopListFragment extends Fragment {

    public HelpSaveShopListFragment(){

    }

    public static HelpSaveShopListFragment newInstance(){
        return new HelpSaveShopListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.fragment_help_save_shopping_lists, container, false);

        return layout;
    }
}
