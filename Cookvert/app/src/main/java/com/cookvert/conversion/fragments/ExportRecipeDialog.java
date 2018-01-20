package com.cookvert.conversion.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.data.DBHelper;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.model.RecipeCategory;
import com.cookvert.util.ResourceHelper;

/**
 *
 */

public class ExportRecipeDialog extends DialogFragment{

    private OnExportRecipeListener mListener;

    // setting selected from spinner, true when original ingredients are used
    private boolean useOriginal;

    public ExportRecipeDialog() {
        // Required empty public constructor
    }

    public static ExportRecipeDialog newInstance(){
        return new ExportRecipeDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.dialog_export_recipe_from_convert, null);

        final TextView message = (TextView) layout.findViewById(R.id.text_dialog_message);
        message.setText(R.string.message_dialog_export_recipe);

        final EditText iName = (EditText) layout.findViewById(R.id.text_edit_name_dialog);
        iName.setHint(R.string.hint_enter_name_recipe);

        final Spinner recipeType = (Spinner) layout.findViewById(R.id.spinner_export_recipe_type);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.spinner_recipe_type_selection, R.layout.spinner_item_dialog);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        recipeType.setAdapter(adapter);

        // preselect first spinner setting
        recipeType.setSelection(0);
        useOriginal = true;

        recipeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 if(position == 0){
                     useOriginal = true;
                 }else{
                     useOriginal = false;
                 }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // use dialog builder to build the rest of the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_new_recipe);

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ExportRecipeDialog.this.getDialog().cancel();
            }
        });
        AlertDialog ad = builder.create();
        //add custom listener upon showing the dialog
        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                //replace positive button listener with custom listener to ensure correct user input
                Button posButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                posButton.setOnClickListener(new CorrectInputListener(((AlertDialog)dialog), iName));
            }
        });
        return ad;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnExportRecipeListener) {
            mListener = (OnExportRecipeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnExportRecipeListener");
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
        private final EditText iName;

        public CorrectInputListener(Dialog dialog, EditText iName){
            this.dialog = dialog;
            this.iName = iName;
        }
        @Override
        public void onClick(View v) {
            //see if name field is empty and show error if necessary
            if (iName.getText().toString().length() == 0) {
                iName.setError(getContext().getText(R.string.error_no_name));
            }else {
                //send data from text field to listener and dismiss dialog
                mListener.onExportRecipe(iName.getText().toString(), useOriginal);
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
    public interface OnExportRecipeListener {
        void onExportRecipe(String name, boolean useOriginal);
    }
}
