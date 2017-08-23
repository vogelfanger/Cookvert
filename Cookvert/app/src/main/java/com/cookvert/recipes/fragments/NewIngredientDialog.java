package com.cookvert.recipes.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.cookvert.R;
import com.cookvert.recipes.model.Unit;
import com.cookvert.util.ResourceHelper;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewIngredientDialog.OnNewIngredientListener} interface
 * to handle interaction events.
 */
public class NewIngredientDialog extends DialogFragment {

    private OnNewIngredientListener mListener;
    private int spinnerRes;
    private Unit spinnerUnit;

    public NewIngredientDialog() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewIngredientListener) {
            mListener = (OnNewIngredientListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNewIngredientListener");
        }
    }

    public static NewIngredientDialog newInstance() {
        NewIngredientDialog fragment = new NewIngredientDialog();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_edit_ingredient, null);

        //use all unit items in the spinner
        spinnerRes = R.array.spinner_all_units;
        final EditText iAmount = (EditText) layout.findViewById(R.id.text_amount_edit_ingredient_dialog);
        final EditText iName = (EditText) layout.findViewById(R.id.text_name_edit_ingredient_dialog);

        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner_edit_ingredient_dialog);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), spinnerRes, R.layout.spinner_item_dialog);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerUnit = ResourceHelper.getUnitByName(adapter.getItem(position).toString(), getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_new_ingredient);

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NewIngredientDialog.this.getDialog().cancel();
            }
        });


        AlertDialog ad = builder.create();
        //add custom listener upon showing the dialog
        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                //replace positive button listener with custom listener to ensure correct user input
                Button posButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                posButton.setOnClickListener(new CorrectInputListener(((AlertDialog)dialog), iAmount, iName));
            }
        });
        return ad;
    }

    /**
     * Custom listener that handles incorrect user inputs in dialog.
     */
    class CorrectInputListener implements View.OnClickListener{

        private final Dialog dialog;
        private final EditText iAmount;
        private final EditText iName;

        public CorrectInputListener(Dialog dialog, EditText iAmount, EditText iName){
            this.dialog = dialog;
            this.iAmount = iAmount;
            this.iName = iName;
        }
        @Override
        public void onClick(View v) {
            //see if amount or name fields are empty and put up a warning if necessary
            if (iAmount.getText().toString().length() == 0) {
                iAmount.setError(getContext().getText(R.string.error_no_amount));
                if (iName.getText().toString().length() == 0) {
                    iName.setError(getContext().getText(R.string.error_no_name));
                }
            } else if (iName.getText().toString().length() == 0) {
                iName.setError(getContext().getText(R.string.error_no_name));
            } else {
                //send data from text fields and spinner to listener Activity and dismiss dialog
                mListener.onNewIngredient(Double.parseDouble(iAmount.getText().toString()),
                        spinnerUnit.getUnitKey(), iName.getText().toString());
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
    public interface OnNewIngredientListener {
        void onNewIngredient(Double amount, int unitKey, String name);
    }
}
