package com.cookvert.help.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cookvert.R;

public class HelpEditItemsFragment extends Fragment {

    public HelpEditItemsFragment() {
    }

    public static HelpEditItemsFragment newInstance(){
        return new HelpEditItemsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.fragment_help_edit_items, container, false);

        return layout;
    }
}
