package com.example.calc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

public class Converter extends AppCompatActivity {

    private EditText inputEditText, resultEditText;
    private Spinner fromSpinner, toSpinner;
    private Button convertButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.editTextNumberDecimal);
        resultEditText = findViewById(R.id.editTextText2);
        fromSpinner = findViewById(R.id.spinner);
        toSpinner = findViewById(R.id.spinner2);
        convertButton = findViewById(R.id.convertButton);

        // Define the units arrays
        final String[] lengthUnits = {"km", "m", "cm", "mm", "yard", "inches", "feet"};
        final String[] volumeUnits = {"litre", "ml"};
        final String[] weightUnits = {"kg", "grams"};

        // Create ArrayAdapter for the spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set adapters for spinners
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        // Set item selected listeners for spinners
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                performConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                performConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        // Set click listener for the convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    private void performConversion() {
        // Get user input and selected units
        double inputValue;
        try {
            inputValue = Double.parseDouble(inputEditText.getText().toString());
        } catch (NumberFormatException e) {
            resultEditText.setText("Invalid Input");
            return;
        }
        String fromUnit = fromSpinner.getSelectedItem().toString();
        String toUnit = toSpinner.getSelectedItem().toString();

        // Perform conversion based on units
        double result = convert(fromUnit, toUnit, inputValue);

        // Display the result in the resultEditText
        resultEditText.setText(String.valueOf(result));
    }

    private double convert(String fromUnit, String toUnit, double value) {
        // Conversion logic for different units
        // Add your conversion logic here
        double result = value; // Default: return the input value

        if (fromUnit.equals("km")) {
            // Perform conversion from km to other units
            if (toUnit.equals("m")) {
                result = value * 1000; // 1 km = 1000 m
            } else if (toUnit.equals("cm")) {
                result = value * 100000; // 1 km = 100000 cm
            } else if (toUnit.equals("mm")) {
                result = value * 1000000; // 1 km = 1000000 mm
            } else if (toUnit.equals("yard")) {
                result = value * 1094; // 1 km = 1094 yard
            } else if (toUnit.equals("inches")) {
                result = value * 39370.1; // 1 km = 39370.1 inches
            } else if (toUnit.equals("feet")) {
                result = value * 3280.84; // 1 km = 3280.84 feet
            }
        } else if (fromUnit.equals("m")) {
            // Perform conversion from m to other units
            if (toUnit.equals("km")) {
                result = value / 1000; // 1 m = 0.001 km
            } else if (toUnit.equals("cm")) {
                result = value * 100; // 1 m = 100 cm
            } else if (toUnit.equals("mm")) {
                result = value * 1000; // 1 m = 1000 mm
            } else if (toUnit.equals("yard")) {
                result = value * 1.094; // 1 m = 1.094 yard
            } else if (toUnit.equals("inches")) {
                result = value * 39.3701; // 1 m = 39.3701 inches
            } else if (toUnit.equals("feet")) {
                result = value * 3.28084; // 1 m = 3.28084 feet
            }
        }
        // Add similar blocks for other units (litre, ml, kg, grams) as needed

        return result;
    }
}
