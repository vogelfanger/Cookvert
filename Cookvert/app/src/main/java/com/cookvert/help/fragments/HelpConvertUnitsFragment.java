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

/**
 *
 */

public class HelpConvertUnitsFragment extends Fragment{

    public HelpConvertUnitsFragment() {
    }

    public static HelpConvertUnitsFragment newInstance(){
        return new HelpConvertUnitsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.fragment_help_convert_units, container, false);

        // these text views will have part of their text as bold
        final TextView content3 = (TextView) layout.findViewById(R.id.text_content_3);
        final TextView content4 = (TextView) layout.findViewById(R.id.text_content_4);
        final TextView content7 = (TextView) layout.findViewById(R.id.text_content_7);

        // get the resource string parts for the text views
        String content3bold = getActivity().getResources().getString(
                R.string.help_convert_units_content_3part1_bold);
        String content3after = getActivity().getResources().getString(
                R.string.help_convert_units_content_3part2);
        String content4bold = getActivity().getResources().getString(
                R.string.help_convert_units_content_4part1_bold);
        String content4after = getActivity().getResources().getString(
                R.string.help_convert_units_content_4part2);
        String content7bold = getActivity().getResources().getString(
                R.string.help_convert_units_content_7part1_bold);
        String content7after = getActivity().getResources().getString(
                R.string.help_convert_units_content_7part2);

        // build the bold parts and set final texts into the text views
        content3.setText(TextEditor.addBoldSection(content3bold, content3after));
        content4.setText(TextEditor.addBoldSection(content4bold, content4after));
        content7.setText(TextEditor.addBoldSection(content7bold, content7after));

        return layout;
    }
}
