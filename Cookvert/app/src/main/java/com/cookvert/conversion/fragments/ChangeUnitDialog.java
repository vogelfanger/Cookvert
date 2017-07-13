package com.cookvert.conversion.fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.recipes.model.Unit;
import com.cookvert.util.ResourceHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChangeUnitDialog#newInstance} factory method to
 * create an instance of this fragment.
 * //TODO actions for dialog through an interface
 */
public class ChangeUnitDialog extends DialogFragment {
    // the fragment initialization parameters
    private static final String ARG_SPINNER = "spinnerType";
    private static final String ARG_SPINNER_UNIT_POSITION = "selectedUnitPosition";

    private OnChangeUnitListener mListener;
    private int spinnerRes; //spinner resource id
    private Unit spinnerUnit; //unit type selected from the spinner


    public ChangeUnitDialog() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnChangeUnitListener) {
            mListener = (OnChangeUnitListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChangeUnitListener");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param spinnerItemsRes Resource id of spinner (mass/volume units).
     * @return A new instance of fragment ChangeUnitDialog.
     */
    public static ChangeUnitDialog newInstance(int spinnerItemsRes, int ingUnitKey) {
        ChangeUnitDialog fragment = new ChangeUnitDialog();
        Bundle args = new Bundle();
        args.putInt(ARG_SPINNER, spinnerItemsRes);
        args.putInt(ARG_SPINNER_UNIT_POSITION, ingUnitKey);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //TODO change layout and layout name to be more general
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_spinner_dialog, null);

        //get spinner item list from arguments
        spinnerRes = getArguments().getInt(ARG_SPINNER);
        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner_change_unit_dialog);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), spinnerRes, R.layout.spinner_item_dialog);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        spinner.setAdapter(adapter);

        spinner.setSelection(getArguments().getInt(ARG_SPINNER_UNIT_POSITION));

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
        builder.setTitle(R.string.all_change_unit);

        builder.setPositiveButton(R.string.all_done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onChangeUnit(spinnerUnit.getUnitKey());
            }
        });
        builder.setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ChangeUnitDialog.this.getDialog().cancel();
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
    public interface OnChangeUnitListener {
        void onChangeUnit(int unitKey);
    }
}
