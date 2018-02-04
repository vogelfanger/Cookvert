package com.cookvert.recipes.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.cookvert.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RenameRecipeDialog.OnRenameRecipeListener} interface
 * to handle interaction events.
 */
public class RenameRecipeDialog extends DialogFragment {

    public static final String ARG_NAME = "recipeName";
    private OnRenameRecipeListener mListener;

    public RenameRecipeDialog() {
        // Required empty public constructor
    }

    public static RenameRecipeDialog newInstance(String name){
        RenameRecipeDialog fragment = new RenameRecipeDialog();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_edit_text, null);

        final EditText rName = (EditText) layout.findViewById(R.id.text_edit_name_dialog);
        rName.setText(getArguments().getString(ARG_NAME));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_rename_recipe);

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RenameRecipeDialog.this.getDialog().cancel();
            }
        });
        AlertDialog ad = builder.create();
        //add custom listener upon showing the dialog
        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                //replace positive button listener with custom listener to ensure correct user input
                Button posButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                posButton.setOnClickListener(new CorrectInputListener(((AlertDialog)dialog), rName));
            }
        });
        return ad;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRenameRecipeListener) {
            mListener = (OnRenameRecipeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRenameRecipeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Custom listener that handles incorrect user inputs in dialog.
     */
    class CorrectInputListener implements View.OnClickListener{

        private final Dialog dialog;
        private final EditText rName;

        public CorrectInputListener(Dialog dialog, EditText iName){
            this.dialog = dialog;
            this.rName = iName;
        }
        @Override
        public void onClick(View v) {
            //see if name field is empty and put up a warning if necessary
            if (rName.getText().toString().length() == 0) {
                rName.setError(getContext().getText(R.string.error_no_name));
            }else {
                //send data from text field to listener and dismiss dialog
                mListener.onRenameRecipe(rName.getText().toString());
                dialog.dismiss();
            }
        }
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
    public interface OnRenameRecipeListener {
        void onRenameRecipe(String name);
    }
}
