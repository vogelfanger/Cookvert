package com.cookvert.recipes.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.cookvert.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewCategoryDialog.OnNewCategoryListener} interface
 * to handle interaction events.
 * Use the {@link NewCategoryDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewCategoryDialog extends DialogFragment {

    private OnNewCategoryListener mListener;

    public NewCategoryDialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment NewCategoryDialog.
     */
    public static NewCategoryDialog newInstance() {
        NewCategoryDialog fragment = new NewCategoryDialog();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_edit_text, null);

        final EditText iName = (EditText) layout.findViewById(R.id.text_edit_name_dialog);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_new_category);

        builder.setPositiveButton(R.string.all_done, null); //onClickListener is overridden later
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NewCategoryDialog.this.getDialog().cancel();
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
                mListener.onNewCategory(iName.getText().toString());
                dialog.dismiss();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewCategoryListener) {
            mListener = (OnNewCategoryListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNewCategoryListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnNewCategoryListener {
        void onNewCategory(String name);
    }
}
