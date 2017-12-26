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

public class HelpScaleSavedRecipeFragment extends Fragment{

    public HelpScaleSavedRecipeFragment(){

    }

    public static HelpScaleSavedRecipeFragment newInstance(){
        return new HelpScaleSavedRecipeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.fragment_help_scale_saved_recipe, container, false);

        // this text view will have part of the text as bold
        final TextView content4 = (TextView) layout.findViewById(R.id.text_content_4);

        // get the resource string parts for the text view
        String content4bold = getActivity().getResources().getString(
                R.string.help_scale_saved_recipe_content_4part1_bold);
        String content4after = getActivity().getResources().getString(
                R.string.help_scale_saved_recipe_content_4part2);

        // build the bold parts and set final texts into the text view
        content4.setText(TextEditor.addBoldSection(content4bold, content4after));

        return layout;
    }
}
