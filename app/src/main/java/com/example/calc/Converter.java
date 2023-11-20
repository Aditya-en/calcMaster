package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Converter extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_converter);
//    }

    private EditText inputEditText;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);


        inputEditText = findViewById(R.id.editTextNumberDecimal);
        convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });
    }

    private void convert() {
        // Get the input value
        String inputValue = inputEditText.getText().toString();

        Toast.makeText(this, "Input value: " + inputValue, Toast.LENGTH_SHORT).show();

        Spinner spinner = findViewById(R.id.spinner);

        // Create a list of units
        List<String> units = new ArrayList<>();
        units.add("km");
        units.add("m");
        units.add("cm");
        units.add("mm");
        units.add("yard");
        units.add("inches");
        units.add("feet");
        units.add("litre");
        units.add("ml");
        units.add("kg");
        units.add("celsius");
        units.add("fahrenheit");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set a listener to handle spinner item selections
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedUnit = units.get(position);
                Toast.makeText(Converter.this, "Selected Unit: " + selectedUnit, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        Spinner spinner1 = findViewById(R.id.spinner2);

        // Create a list of units
        List<String> units1 = new ArrayList<>();
        units1.add("km");
        units1.add("m");
        units1.add("cm");
        units1.add("mm");
        units1.add("yard");
        units1.add("inches");
        units1.add("feet");
        units1.add("litre");
        units1.add("ml");
        units1.add("kg");
        units1.add("celsius");
        units1.add("fahrenheit");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedUnit = units1.get(position);
                Toast.makeText(Converter.this, "Selected Unit: " + selectedUnit, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }
}