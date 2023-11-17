package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Initializing the text boxes
    TextView txtInput;
    TextView txtOutput;
    private boolean isOperatorClicked = false;

    @Override
    public void onClick(View v) {

        System.out.println("Button pressed");

        // The logic for operators starts here
        if (!isOperatorClicked) {
            if (v.getId() == R.id.btnAdd) {
                txtInput.setText(txtInput.getText().toString() + "+");
                isOperatorClicked = true;
            } else if (v.getId() == R.id.btnMinus) {
                txtInput.setText(txtInput.getText().toString() + "-");
                isOperatorClicked = true;
            } else if (v.getId() == R.id.btnMultiply) {
                txtInput.setText(txtInput.getText().toString() + "*");
                isOperatorClicked = true;
            } else if (v.getId() == R.id.btnDivide) {
                txtInput.setText(txtInput.getText().toString() + "/");
                isOperatorClicked = true;
            } else if (v.getId() == R.id.btnMod) {
                txtInput.setText(txtInput.getText().toString() + "%");
                isOperatorClicked = true;
            } else {
                isOperatorClicked = false;
            }

        }

//        if (v.getId() == R.id.btnAdd || v.getId() == R.id.btnMinus || v.getId() == R.id.btnDivide || v.getId() == R.id.btnMultiply || v.getId() == R.id.btnMod) {
//  //          isOperatorClicked = true;
//        }
        // Code for managing backspace and all clear button
        if (v.getId() == R.id.allClear) {
            txtInput.setText("");
            isOperatorClicked = false;
            System.out.println("All Clear button pressed");
        } else if (v.getId() == R.id.back) {
            isOperatorClicked = false;
            System.out.println("Back button pressed");
            if (!txtInput.getText().toString().isEmpty())
                txtInput.setText(txtInput.getText().toString().substring(0, txtInput.getText().toString().length() - 1));
        }

        //the Code for implementing button presses starts here

        else if (v.getId() == R.id.btn1) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "1");
        } else if (v.getId() == R.id.btn2) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "2");
        } else if (v.getId() == R.id.btn3) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "3");
        } else if (v.getId() == R.id.btn4) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "4");
        } else if (v.getId() == R.id.btn5) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "5");
        } else if (v.getId() == R.id.btn6) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "6");
        } else if (v.getId() == R.id.btn7) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "7");
        } else if (v.getId() == R.id.btn8) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "8");
        } else if (v.getId() == R.id.btn9) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "9");
        } else if (v.getId() == R.id.btn0) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "0");
        } else if (v.getId() == R.id.btn00) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + "00");
        } else if (v.getId() == R.id.btnDot) {
            isOperatorClicked = false;
            txtInput.setText(txtInput.getText().toString() + ".");
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initializing the buttons
        Button allClear = findViewById(R.id.allClear);
        Button back = findViewById(R.id.back);
        Button btnMod = findViewById(R.id.btnMod);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btn00 = findViewById(R.id.btn00);
        Button btn0 = findViewById(R.id.btn0);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnEquals = findViewById(R.id.btnEquals);

        // Initializing the text boxes
        txtInput = findViewById(R.id.txtInput);
        txtOutput = findViewById(R.id.txtOutput);


        // Setting OnClickListeners
        allClear.setOnClickListener(this);
        back.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btn00.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnEquals.setOnClickListener(this);

    }

}