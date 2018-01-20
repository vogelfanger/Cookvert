package com.cookvert.recipes.fragments;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cookvert.R;

/**
 * Created by Elmo on 11/09/2017.
 */

public class ExportAsShopListDialog extends DialogFragment{

    private OnExportAsShopListListener mListener;

    public ExportAsShopListDialog() {
        // Required empty public constructor
    }

    public static ExportAsShopListDialog newInstance(){
        return new ExportAsShopListDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.dialog_edit_text_with_message, null);

        final TextView message = (TextView) layout.findViewById(R.id.text_dialog_message);
        message.setText(R.string.message_dialog_export_from_recipe_to_shop_list);

        final EditText iName = (EditText) layout.findViewById(R.id.text_edit_name_dialog);
        iName.setHint(R.string.hint_enter_name_shop_list);

        // use dialog builder to build the rest of the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_new_shop_list);

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ExportAsShopListDialog.this.getDialog().cancel();
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
        if (context instanceof OnExportAsShopListListener) {
            mListener = (OnExportAsShopListListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnExportAsShopListListener");
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
                mListener.onExportAsShopList(iName.getText().toString());
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
    public interface OnExportAsShopListListener {
        void onExportAsShopList(String name);
    }
}
