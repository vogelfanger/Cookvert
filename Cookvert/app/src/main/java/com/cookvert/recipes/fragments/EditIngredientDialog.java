package com.cookvert.recipes.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
 * Use the {@link EditIngredientDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditIngredientDialog extends DialogFragment {

    private OnEditIngredientListener mListener;
    private int spinnerRes; //spinner item list resource id
    private Unit spinnerUnit; //unit type selected from the spinner

    //argument key strings
    private static final String ARG_AMOUNT = "ingredientAmount";
    private static final String ARG_UNIT = "ingredientUnit";
    private static final String ARG_NAME = "ingredientName";

    public EditIngredientDialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment EditIngredientDialog.
     */
    public static EditIngredientDialog newInstance(String ingAmount, int ingUnitPos, String ingName) {
        EditIngredientDialog fragment = new EditIngredientDialog();
        Bundle args = new Bundle();
        args.putString(ARG_AMOUNT, ingAmount);
        args.putInt(ARG_UNIT, ingUnitPos);
        args.putString(ARG_NAME, ingName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEditIngredientListener) {
            mListener = (OnEditIngredientListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnEditIngredientListener");
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        hideKeyboard();
        super.onDismiss(dialog);
    }

    // Hides keyboard using separate runnable
    private void hideKeyboard(){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) getActivity().getCurrentFocus().getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_edit_ingredient, null);

        final EditText iAmount = (EditText) layout.findViewById(R.id.text_amount_edit_ingredient_dialog);
        final EditText iName = (EditText) layout.findViewById(R.id.text_name_edit_ingredient_dialog);

        spinnerRes = R.array.spinner_all_units;
        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner_edit_ingredient_dialog);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), spinnerRes, R.layout.spinner_item_dialog);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        spinner.setAdapter(adapter);

        //set argument values to text fields and spinner
        iAmount.setText(getArguments().get(ARG_AMOUNT).toString());
        spinner.setSelection(getArguments().getInt(ARG_UNIT));
        iName.setText(getArguments().get(ARG_NAME).toString());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerUnit = ResourceHelper.getUnitByName(
                        adapter.getItem(position).toString(), getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_edit_ingredient);

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditIngredientDialog.this.getDialog().cancel();
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
            //see if amount is missing and put up a warning if necessary
            if (iAmount.getText().toString().length() == 0) {
                iAmount.setError(getContext().getText(R.string.error_no_amount));
            }
            // see if amount is too large
            else if(Double.parseDouble(iAmount.getText().toString()) >= 99995){
                iAmount.setError(getContext().getText(R.string.error_amount_too_large));
            }
            else {
                //send data from text fields and spinner to listener Activity and dismiss dialog
                if (iName.getText().toString().length() == 0) {
                    mListener.onEditIngredient(Double.parseDouble(iAmount.getText().toString()),
                            spinnerUnit.getUnitKey(), "");
                } else{
                    mListener.onEditIngredient(Double.parseDouble(iAmount.getText().toString()),
                            spinnerUnit.getUnitKey(), iName.getText().toString());
                }

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
    public interface OnEditIngredientListener {
        void onEditIngredient(Double amount, int unitKey, String name);
    }
}
