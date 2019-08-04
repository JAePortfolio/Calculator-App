package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int operandOne = 0; // Initialize to 0 by default
    private int operandTwo = 0;
    private int operationID;
    private double result = 0;
    public String numDisplay = "";

    public void digitPress(View view) {
        switch (view.getId()) {
            case R.id.button_digitZero:
                numDisplay = numDisplay + "0";
                updateTextView();
                break;
            case R.id.button_digitOne:
                numDisplay = numDisplay + "1";
                updateTextView();
                break;
            case R.id.button_digitTwo:
                numDisplay = numDisplay + "2";
                updateTextView();
                break;
            case R.id.button_digitThree:
                numDisplay = numDisplay + "3";
                updateTextView();
                break;
            case R.id.button_digitFour:
                numDisplay = numDisplay + "4";
                updateTextView();
                break;
            case R.id.button_digitFive:
                numDisplay = numDisplay + "5";
                updateTextView();
                break;
            case R.id.button_digitSix:
                numDisplay = numDisplay + "6";
                updateTextView();
                break;
            case R.id.button_digitSeven:
                numDisplay = numDisplay + "7";
                updateTextView();
                break;
            case R.id.button_digitEight:
                numDisplay = numDisplay + "8";
                updateTextView();
                break;
            case R.id.button_digitNine:
                numDisplay = numDisplay + "9";
                updateTextView();
                break;
        }
    }

    public void action_arithPress(View view) {
        switch (view.getId()) {
            case R.id.button_arithAddition:
                operandOne = Integer.parseInt(numDisplay); // Convert String to Int
                numDisplay = "";
                operationID = 0;
                //updateTextView();
                break;
            case R.id.button_arithSubtraction:
                operandOne = Integer.parseInt(numDisplay); // Convert String to Int
                numDisplay = "";
                operationID = 1;
                //updateTextView();
                break;
            case R.id.button_arithMultiplication:
                operandOne = Integer.parseInt(numDisplay); // Convert String to Int
                numDisplay = "";
                operationID = 2;
                //updateTextView();
                break;
            case R.id.button_arithDivision:
                operandOne = Integer.parseInt(numDisplay); // Convert String to Int
                numDisplay = "";
                operationID = 3;
                //updateTextView();
                break;
        }
    }

    public void equalsButton(View view){
        switch (operationID){
            case 0: // Addition
                operandTwo = Integer.parseInt(numDisplay); // Convert String to Int
                result = operandOne + operandTwo;
                numDisplay = Double.toString(result);
                updateTextView();
                break;
            case 1: // Subtraction
                operandTwo = Integer.parseInt(numDisplay); // Convert String to Int
                result = operandOne - operandTwo;
                numDisplay = Double.toString(result);
                updateTextView();
                break;
            case 2: // Multiplication
                operandTwo = Integer.parseInt(numDisplay); // Convert String to Int
                result = operandOne * operandTwo;
                numDisplay = Double.toString(result);
                updateTextView();
                break;
            case 3: // Division
                operandTwo = Integer.parseInt(numDisplay); // Convert String to Int
                result = operandOne / operandTwo;
                numDisplay = Double.toString(result);
                updateTextView();
                break;
        }
    }

    public void clearButton(View view){
        operandOne = 0;
        operandTwo = 0;
        result = 0;
        numDisplay = "";
        updateTextView();
    }

    public void updateTextView() {
        TextView textView = findViewById(R.id.calcResult);
        textView.setText(numDisplay);
    }
}