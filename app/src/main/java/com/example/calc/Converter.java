package com.example.calc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


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


        final String[] lengthUnits = {"km", "m", "cm", "mm", "yard", "inches", "feet","kg", "gram","tonne",
                "litre","ml","m^3","cm^3","celsius","fahrenheit","kelvin"};

        // Create ArrayAdapter for the spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,lengthUnits);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);




        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);


        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                performConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

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

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void performConversion() {

        double inputValue;
        try {
            inputValue = Double.parseDouble(inputEditText.getText().toString());
        } catch (NumberFormatException e) {
            resultEditText.setText("Output");
            return;
        }
        String fromUnit = fromSpinner.getSelectedItem().toString();
        String toUnit = toSpinner.getSelectedItem().toString();


        double result = convert(fromUnit, toUnit, inputValue);


        resultEditText.setText(String.valueOf(result));
    }

    private double convert(String fromUnit, String toUnit, double value) {

        double result = value;

        if (fromUnit.equals("km")) {

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
            } else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }




        } else if (fromUnit.equals("m")) {

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
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }

        }else if (fromUnit.equals("cm")) {

            if (toUnit.equals("km")) {
                result = value / 100000; // 1 m = 0.00001 km
            } else if (toUnit.equals("cm")) {
                result = value * 1; // 1 cm = 1 cm
            }else if (toUnit.equals("m")) {
                result = value / 100; // 1 cm = .01 m
            }else if (toUnit.equals("mm")) {
                result = value * 10; // 1 cm = 10 mm
            } else if (toUnit.equals("yard")) {
                result = value / 91.44; // 1 cm = 0.0109361 yard
            } else if (toUnit.equals("inches")) {
                result = value / 2.54; // 1 cm = .3933701 inches
            } else if (toUnit.equals("feet")) {
                result = value / 30.48; // 1 cm = .0328084 feet
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        } else if (fromUnit.equals("inches")) {

            if (toUnit.equals("km")) {
                result = value / 393370; // 1 inch approx to 2.5e^-5 km
            } else if (toUnit.equals("m")) {
                result = value / 39.37; // 1 inch =.0254 m
            } else if (toUnit.equals("mm")) {
                result = value * 25.4; // 1 inch = 25.4 mm
            } else if (toUnit.equals("cm")) {
                result = value * 2.54; // 1 inch =2.54 cm
            } else if (toUnit.equals("yard")) {
                result = value / 36; // 1 inch = .0277778 yard
            } else if (toUnit.equals("inches")) {
                result = value * 1; // 1 inch = 1inches
            } else if (toUnit.equals("feet")) {
                result = value / 12; // 1 inch = .083333 feet
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        }else if (fromUnit.equals("yard")) {

            if (toUnit.equals("km")) {
                result = value / 1094; // 1 yard approx to 0.0009144km
            } else if (toUnit.equals("m")) {
                result = value /1.094; // 1 yard =.9144 m
            } else if (toUnit.equals("mm")) {
                result = value * 914.4 ; // 1 yard = 914.4 mm
            } else if (toUnit.equals("cm")) {
                result = value * 91.44; // 1 yard =91.44 cm
            } else if (toUnit.equals("yard")) {
                result = value * 1; // 1 yard = 1 yard
            } else if (toUnit.equals("inches")) {
                result = value *36; // 1 yard = 36 inches
            } else if (toUnit.equals("feet")) {
                result = value * 3 ; // 1 yard = 3 feet
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        }else if (fromUnit.equals("feet")) {

            if (toUnit.equals("km")) {
                result = value / 3281; // 1 yard feet to 0.0003048 km
            } else if (toUnit.equals("m")) {
                result = value / 3.281; // 1 feet =.3048 m
            } else if (toUnit.equals("mm")) {
                result = value * 304.8; // 1 feet = 304.8 mm
            } else if (toUnit.equals("cm")) {
                result = value * 30.48; // 1 feet =30.48cm
            } else if (toUnit.equals("yard")) {
                result = value * 3; // 1 feet = .3333 yard
            } else if (toUnit.equals("inches")) {
                result = value * 12; // 1 feet = 12 inches
            } else if (toUnit.equals("feet")) {
                result = value * 1; // 1 feet =1  feet
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        }else if (fromUnit.equals("mm")) {

            if (toUnit.equals("km")) {
                result = value / 1000000; // 1 m = 0.000001 km
            } else if (toUnit.equals("cm")) {
                result = value / 10; // 1 mm = .1 cm
            } else if (toUnit.equals("m")) {
                result = value / 1000; // 1 mm = .001 m
            } else if (toUnit.equals("mm")) {
                result = value * 1; // 1 mm = 1 mm
            } else if (toUnit.equals("yard")) {
                result = value / 914.4; // 1 mm=0.00109361 yard
            } else if (toUnit.equals("inches")) {
                result = value / 25.4; // 1 mm = .03933701 inches
            } else if (toUnit.equals("feet")) {
                result = value / 304.8; // 1 mm = .00328084 feet
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        } else if (fromUnit.equals("kg")) {
            // Perform conversion from m to other units
            if (toUnit.equals("kg")) {
                result = value *1;
            }
            if (toUnit.equals("gram")) {
                result = value * 1000;
            }
            if (toUnit.equals("tonne")) {
                result = value / 10000;
            }
            if (toUnit.equals("pound")) {
                result = value * 2.205;
            }        } else if (fromUnit.equals("gram")) {
            // Perform conversion from m to other units
            if (toUnit.equals("gram")) {
                result = value*1;
            }
            if (toUnit.equals("kg")) {
                result = value / 1000;
            }
            if (toUnit.equals("tonne")) {
                result = value / 1000000;
            }
            if (toUnit.equals("pound")) {
                result = value / 453.6;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }

        } else if (fromUnit.equals("tonne")) {
            // Perform conversion from m to other units
            if (toUnit.equals("tonne")) {
                result = value*1;
            }
            if (toUnit.equals("kg")) {
                result = value * 1000;
            }
            if (toUnit.equals("gram")) {
                result = value * 1000000;
            }
            if (toUnit.equals("pound")) {
                result = value * 2205;
            }
        } else if (fromUnit.equals("pound")) {
            // Perform conversion from m to other units
            if (toUnit.equals("pound")) {
                result = value *1;
            }
            if (toUnit.equals("kg")) {
                result = value / 2.205;
            }
            if (toUnit.equals("tonne")) {
                result = value / 2205;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }



        } else if (fromUnit.equals("litre")) {
            // Perform conversion from m to other units
            if (toUnit.equals("litre")) {
                result = value * 1;
            }
            if (toUnit.equals("ml")) {
                result = value * 1000;
            }
            if (toUnit.equals("m^3")) {
                result = value / 1000;
            }
            if (toUnit.equals("cm^3")) {
                result = value / 1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }


        }else if (fromUnit.equals("ml")) {
            // Perform conversion from m to other units
            if (toUnit.equals("ml")) {
                result = value * 1;
            }
            if (toUnit.equals("litre")) {
                result = value * 1000;
            }
            if (toUnit.equals("m^3")) {
                result = value / 1000000;
            }
            if (toUnit.equals("cm^3")) {
                result = value / 1000000000;
            }if (toUnit.equals("m^3")) {
                result = value / 1000;
            }
            if (toUnit.equals("cm^3")) {
                result = value / 1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }

        } else if (fromUnit.equals("celsius")) {
            // Perform conversion from m to other units
            if (toUnit.equals("celsius")) {
                result = value* 1;
            }
            if (toUnit.equals("fahrenheit")) {
                result = value * 1.8 + 32;
            }
            if (toUnit.equals("kelvin")) {
                result = value + 273.15;
            }if (toUnit.equals("m^3")) {
                result = value /0;
            }
            if (toUnit.equals("cm^3")) {
                result = value / 1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        } else if (fromUnit.equals("fahrenheit")) {
            // Perform conversion from m to other units
            if (toUnit.equals("fahrenheit")) {
                result = value* 1;
            }
            if (toUnit.equals("celsius")) {
                result = value * .555555 - 32 * .555555;
            }
            if (toUnit.equals("celsius")) {
                result = value * .555555 - 32 * .555555 + 237.15;
            }if (toUnit.equals("cm^3")) {
                result = value / 1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }

        } else if (fromUnit.equals("kelvin")) {
            // Perform conversion from m to other units
            if (toUnit.equals("kelvin")) {
                result = value* 1;
            }
            if (toUnit.equals("celsius")) {
                result = value-273.15;
            }
            if (toUnit.equals("fahrenheit")) {
                result = value * 1.8 - 273.15 * 1.8 + 32;
            }if (toUnit.equals("cm^3")) {
                result = value / 1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        }else if (fromUnit.equals("m^3")) {
            // Perform conversion from m to other units
            if (toUnit.equals("m^3")) {
                result = value * 1;
            }
            if (toUnit.equals("ml")) {
                result = value /1000000;
            }
            if (toUnit.equals("litre")) {
                result = value * 1000;
            }
            if (toUnit.equals("cm^3")) {
                result = value * 1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        }else if (fromUnit.equals("cm^3")) {
            // Perform conversion from m to other units
            if (toUnit.equals("cm^3")) {
                result = value * 1;
            }
            if (toUnit.equals("ml")) {
                result = value *1;
            }
            if (toUnit.equals("litre")) {
                result = value/ 1000;
            }
            if (toUnit.equals("m^3")) {
                result = value /1000000;
            }else {
                Toast.makeText(this, "Choose valid conversion units", Toast.LENGTH_SHORT).show();

            }
        }



        return result;
    }
}
