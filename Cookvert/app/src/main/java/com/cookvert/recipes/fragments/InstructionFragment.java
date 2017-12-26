package com.cookvert.recipes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cookvert.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstructionFragment.OnEditInstructionsListener} interface
 * to handle interaction events.
 * Use the {@link InstructionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstructionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ENABLED = "enabled";
    private static final String ARG_INSTRUCTIONS = "instructions";
    private static final String ARG_SECTION_NUMBER = "section_number";

    // TODO: Rename and change types of parameters
    private boolean isEnabled; //value for EditText
    private String instructionString;

    private OnEditInstructionsListener mListener;
    private EditText instructions;

    public InstructionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param enabled Parameter 1.
     * @param instructionString Parameter 2.
     * @return A new instance of fragment InstructionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstructionFragment newInstance(int sectionID, int enabled, String instructionString) {
        InstructionFragment fragment = new InstructionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionID);
        args.putInt(ARG_ENABLED, enabled);
        args.putString(ARG_INSTRUCTIONS, instructionString);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //EditText is unenabled
            if (getArguments().getInt(ARG_ENABLED) == 0){
                isEnabled = false;
            }
            //EditText is enabled
            else{
                isEnabled = true;
            }
            instructionString = getArguments().getString(ARG_INSTRUCTIONS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_instruction, container, false);

        instructions = (EditText) layout.findViewById(R.id.text_instructions);
        //put previously saved instructions to EditText
        instructions.setText(instructionString, EditText.BufferType.EDITABLE);

        //This button becomes visible when EditText gets focus
        final Button buttonDone = (Button) layout.findViewById(R.id.button_confirm_instructions_keyboard);

        if(isEnabled == true){
            //EditText is not focusable at first
            instructions.setFocusable(false);

            //make EditText focusable on click
            instructions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    instructions.setFocusableInTouchMode(true);
                }
            });
        }
        // if editing is not enabled, darken the text color and make text non-interactable.
        else{
            instructions.setTextColor(getResources().getColor(R.color.colorBlack));
            instructions.setKeyListener(null);
            instructions.setCursorVisible(false);
        }

        //set FocusChange listener for EditText to make extra button visible with soft keyboard.
        //in order to make the button appear above keyboard, Activity needs to have
        // android:windowSoftInputMode="adjustResize" as attribute
        instructions.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                //make button visible when focus is gained
                if(b == true){
                    buttonDone.setVisibility(View.VISIBLE);
                }
                //make button disappear when focus is lost
                else{
                    buttonDone.setVisibility(View.GONE);
                }
            }
        });

        //when button is pressed, send EditText data to listener, clear focus and hide keyboard
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onEditInstructions(instructions.getText().toString());
                instructions.clearFocus();
                instructions.setFocusable(false);
                mListener.onHideKeyboard(layout);
            }
        });
        return layout;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEditInstructionsListener) {
            mListener = (OnEditInstructionsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnEditInstructionsListener");
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
     * TODO these methods could be combined, if they are not needed separately
     */
    public interface OnEditInstructionsListener {
        void onEditInstructions(String instructions);
        void onHideKeyboard(View view);
    }

    public void setNewInstructions(String newInstructions){
        if(instructions != null) {
            instructions.setText(newInstructions);
            if(instructions == null) {
                instructions.setText("");
            }
        }
    }
}
