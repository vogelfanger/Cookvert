package com.cookvert.conversion.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.recipes.RecipeManager;
import java.util.List;

/**
 *
 */

public class ImportRecipeDialog extends DialogFragment{

    private OnImportRecipeListener mListener;
    private int selectedRecipePosition; // category of recipe selected from the spinner
    private List<String> recipes;

    public ImportRecipeDialog() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnImportRecipeListener) {
            mListener = (OnImportRecipeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnImportRecipeListener");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ChangeUnitDialog.
     */
    public static ImportRecipeDialog newInstance() {
        return new ImportRecipeDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_spinner, null);

        TextView message = (TextView) layout.findViewById(R.id.text_dialog_message);
        message.setText(R.string.message_dialog_import_recipe);

        // get list of recipes from recipe manager
        recipes = RecipeManager.getInstance().listAllRecipes();

        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner_dialog);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_item_dialog, recipes);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        spinner.setAdapter(adapter);

        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRecipePosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.action_load_recipe);

        builder.setPositiveButton(R.string.all_done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onImportRecipe(selectedRecipePosition);
            }
        });
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImportRecipeDialog.this.getDialog().cancel();
            }
        });
        return builder.create();
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
    public interface OnImportRecipeListener {
        void onImportRecipe(int recipePosition);
    }
}
