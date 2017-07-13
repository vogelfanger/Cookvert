package com.cookvert.recipes.fragments;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.cookvert.R;
import com.cookvert.recipes.RecipeManager;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChangeCategoryDialog.OnChangeCategoryListener} interface
 * to handle interaction events.
 */
public class ChangeCategoryDialog extends DialogFragment {

    private static final String ARG_CATEGORY = "categoryPosition";
    private OnChangeCategoryListener mListener;
    private int categoryPosition; //help variable representing selected category position

    public ChangeCategoryDialog() {
        // Required empty public constructor
    }

    public static ChangeCategoryDialog newInstance(int categoryPosition){
        ChangeCategoryDialog fragment = new ChangeCategoryDialog();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY, categoryPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //TODO change layout and layout name to be more general
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_spinner_dialog, null);

        //set up spinner and adapter
        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner_change_unit_dialog);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item_dialog,
                RecipeManager.getInstance().getCategoryNames());
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        spinner.setAdapter(adapter);

        //set selected category from arguments
        spinner.setSelection(getArguments().getInt(ARG_CATEGORY));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //set help variable
                categoryPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_change_category);

        builder.setPositiveButton(R.string.all_done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //send selected item position to listener
                mListener.onChangeCategory(categoryPosition);
            }
        });
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ChangeCategoryDialog.this.getDialog().cancel();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnChangeCategoryListener) {
            mListener = (OnChangeCategoryListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChangeCategoryListener");
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
    public interface OnChangeCategoryListener {
        void onChangeCategory(int categoryPosition);
    }
}
