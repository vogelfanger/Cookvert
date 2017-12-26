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

public class HelpSaveRecipesFragment extends Fragment{

    public HelpSaveRecipesFragment(){

    }

    public static HelpSaveRecipesFragment newInstance(){
        return new HelpSaveRecipesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.fragment_help_save_recipes, container, false);

        // this text view will have part of the text as bold
        final TextView content5 = (TextView) layout.findViewById(R.id.text_content_5);

        // get the resource string parts for the text view
        String content5bold = getActivity().getResources().getString(
                R.string.help_save_recipes_content_5part1_bold);
        String content5after = getActivity().getResources().getString(
                R.string.help_save_recipes_content_5part2);

        // build the bold parts and set final texts into the text view
        content5.setText(TextEditor.addBoldSection(content5bold, content5after));

        return layout;
    }
}
