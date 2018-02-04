package com.cookvert.conversion.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.cookvert.R;
import com.google.android.gms.common.SignInButton;

public class SignInDialog extends DialogFragment {

    private OnSignInListener mListener;

    public SignInDialog() {
        // Required empty public constructor
    }

    public static SignInDialog newInstance(){
        return new SignInDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(
                R.layout.dialog_sign_in, null);

        SignInButton signInButton = layout.findViewById(R.id.button_google_sign_in);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSignIn(false, SignInDialog.this);
            }
        });

        // use dialog builder to build the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_sign_in);

        // This dialog only has one button that dismisses the dialog.
        builder.setPositiveButton(R.string.action_sign_in_not_now, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onSignIn(true, SignInDialog.this);
            }
        }); //onClickListener is overridden later
        AlertDialog ad = builder.create();
        return ad;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSignInListener) {
            mListener = (OnSignInListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSignInListener");
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
    public interface OnSignInListener {
        void onSignIn(boolean notNow, SignInDialog dialog);
    }
}
