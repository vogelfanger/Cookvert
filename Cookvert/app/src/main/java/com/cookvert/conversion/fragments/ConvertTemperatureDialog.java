package com.cookvert.conversion.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.recipes.model.Unit;

public class ConvertTemperatureDialog extends DialogFragment {

    // the fragment initialization parameters
    private static final String ARG_TEMPERATURE_AMOUNT = "temperatureAmount";
    private static final String ARG_SPINNER_UNIT_POSITION = "selectedUnitPosition";

    Unit spinnerUnit; // unit type selected from spinner

    public ConvertTemperatureDialog() {
        // Required empty public constructor
    }

    public static ConvertTemperatureDialog newInstance(double tempAmount, int tempUnitKey) {
        ConvertTemperatureDialog fragment = new ConvertTemperatureDialog();
        Bundle args = new Bundle();
        args.putInt(ARG_SPINNER_UNIT_POSITION, tempUnitKey);
        args.putDouble(ARG_TEMPERATURE_AMOUNT, tempAmount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_convert_temperature, null);

        final TextView message = (TextView) layout.findViewById(R.id.text_dialog_message);
        message.setText(R.string.message_dialog_convert_temperature);

        final TextView convertedTemp =
                (TextView) layout.findViewById(R.id.text_converted_temperature);
        // get text from ConvertManager
        convertedTemp.setText(ConvertManager.getInstance().getTemperatureText(getActivity()));

        final EditText tempAmount =
                (EditText) layout.findViewById(R.id.edit_text_temperature);
        tempAmount.setText(String.valueOf(getArguments().getDouble(ARG_TEMPERATURE_AMOUNT)));

        tempAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 0) {
                    // do nothing when view has no text
                }else if(editable.toString().length() == 1 && editable.toString().charAt(0) == '-'){
                    // do nothing if text only has char '-'
                }else {
                    // convert temperature in ConvertManager when amount is edited
                    ConvertManager.getInstance().editTemperature(
                            Double.parseDouble(editable.toString()));
                    // set converted amount to text view
                    convertedTemp.setText(
                            ConvertManager.getInstance().getTemperatureText(getActivity()));
                }
            }
        });

        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner_temperature);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.spinner_temperature_units, R.layout.spinner_item_dialog);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_dialog);
        spinner.setAdapter(adapter);
        spinner.setSelection(getArguments().getInt(ARG_SPINNER_UNIT_POSITION));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    spinnerUnit = Unit.CELSIUS;
                }else{
                    spinnerUnit = Unit.FAHRENHEIT;
                }
                // Convert temperature in ConvertManager
                ConvertManager.getInstance().editTemperature(spinnerUnit);
                // Set conversion result to text view
                convertedTemp.setText(
                        ConvertManager.getInstance().getTemperatureText(getActivity()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(layout);
        builder.setTitle(R.string.title_dialog_convert_temperature);

        builder.setPositiveButton(R.string.all_done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // dismiss dialog when button is pressed
                ConvertTemperatureDialog.this.dismiss();
            }
        });

        return builder.create();
    }
}
