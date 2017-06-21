package com.cookvert.conversion.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.cookvert.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScaleRecipeDialog extends DialogFragment {

    private static final String ARG_MULTIPLIER = "recipeMultiplier";
    private OnScaleRecipeListener mListener;


    public ScaleRecipeDialog() {
        // Required empty public constructor
    }

    public static ScaleRecipeDialog newInstance(String multiplier) {
        ScaleRecipeDialog fragment = new ScaleRecipeDialog();
        Bundle args = new Bundle();
        args.putString(ARG_MULTIPLIER, multiplier);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnScaleRecipeListener) {
            mListener = (OnScaleRecipeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnScaleRecipeListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_scale_recipe_dialog, null);

        final EditText iMultiplier = (EditText) layout.findViewById(R.id.text_multiplier_amount_scale_recipe_dialog);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_scale_recipe);

        //set argument multiplier to text view
        iMultiplier.setText(getArguments().getString(ARG_MULTIPLIER));

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ScaleRecipeDialog.this.getDialog().cancel();
            }
        });

        AlertDialog ad = builder.create();
        //add custom listener upon showing the dialog
        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                //replace positive button listener with custom listener to ensure correct user input
                Button posButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                posButton.setOnClickListener(new CorrectInputListener(((AlertDialog)dialog), iMultiplier));
            }
        });
        return ad;
    }

    /**
     * Custom listener that handles incorrect user inputs in dialog.
     */
    class CorrectInputListener implements View.OnClickListener{

        private final Dialog dialog;
        private final EditText iMultiplier;

        public CorrectInputListener(Dialog dialog, EditText iMultiplier){
            this.dialog = dialog;
            this.iMultiplier = iMultiplier;
        }
        @Override
        public void onClick(View v) {
            //see if multiplier field is empty and put up a warning if necessary
            if(iMultiplier.getText().toString().length() == 0) {
                iMultiplier.setError(getContext().getText(R.string.error_no_multiplier));
            }else{
                //send data from text field to listener Activity and dismiss dialog
                mListener.onScaleRecipe(Double.parseDouble(iMultiplier.getText().toString()));
                dialog.dismiss();
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnScaleRecipeListener {
        void onScaleRecipe(double multiplier);
    }

}
