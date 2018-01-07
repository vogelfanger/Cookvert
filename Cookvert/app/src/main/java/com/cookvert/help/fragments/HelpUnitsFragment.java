package com.cookvert.help.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.util.TextEditor;

public class HelpUnitsFragment extends Fragment{

    public HelpUnitsFragment() {
    }

    public static HelpUnitsFragment newInstance(){
        return new HelpUnitsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.fragment_help_units, container, false);

        return layout;
    }
}
