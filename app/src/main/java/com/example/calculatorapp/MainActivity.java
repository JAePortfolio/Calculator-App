package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    private int operandCnt = 1;
    private double result = 0;
    private boolean operandsInputted = false;
    public String numDisplay = "";

    public void digitPress(View view) { // This see's which number is pressed and appends it
        numDisplay = ""; // Empty the string at the start
        operandsInputted = true; // Inputting numbers
        switch (view.getId()) {
            case R.id.button_digitZero: // If 0 is pressed, append 0 to the numDisplay
                numDisplay = numDisplay + "0";
                break;
            case R.id.button_digitOne:
                numDisplay = numDisplay + "1";
                break;
            case R.id.button_digitTwo:
                numDisplay = numDisplay + "2";
                break;
            case R.id.button_digitThree:
                numDisplay = numDisplay + "3";
                break;
            case R.id.button_digitFour:
                numDisplay = numDisplay + "4";
                break;
            case R.id.button_digitFive:
                numDisplay = numDisplay + "5";
                break;
            case R.id.button_digitSix:
                numDisplay = numDisplay + "6";
                break;
            case R.id.button_digitSeven:
                numDisplay = numDisplay + "7";
                break;
            case R.id.button_digitEight:
                numDisplay = numDisplay + "8";
                break;
            case R.id.button_digitNine:
                numDisplay = numDisplay + "9";
                break;
        }
        updateTextView(); // Update current view
    }

    public void action_arithPress(View view) {
        if (operandsInputted == true) {
            if (operandCnt <= 1) { // Counting amount of operands
                operandOne = Integer.parseInt(numDisplay); // Convert String to Int
                operandCnt++;
                switch (view.getId()) { // Assigns operation id based on button pressed
                    case R.id.button_arithAddition:
                        operationID = 0;
                        updateTextView();
                        break;
                    case R.id.button_arithSubtraction:
                        operationID = 1;
                        updateTextView();
                        break;
                    case R.id.button_arithMultiplication:
                        operationID = 2;
                        updateTextView();
                        break;
                    case R.id.button_arithDivision:
                        operationID = 3;
                        updateTextView();
                        break;
                }
            }
            else {
                throwErrorMessageOperands();
            }
        }
    }

    public void equalsButton(View view){
        if(operandsInputted == true) {
            operandTwo = Integer.parseInt(numDisplay); // Convert String to Int
            switch (operationID) {
                case 0: // Addition
                    result = operandOne + operandTwo;
                    numDisplay = Double.toString(result);
                    updateTextView();
                    break;
                case 1: // Subtraction
                    result = operandOne - operandTwo;
                    break;
                case 2: // Multiplication
                    result = operandOne * operandTwo;
                    break;
                case 3: // Division
                    result = (double) operandOne / (double) operandTwo;
                    break;
            }
            numDisplay = Double.toString(result);
            updateTextView();
        }
        else{
            throwErrorMessageNoNums();
        }
    }

    public void clearButton(View view){// What the clear button does
        operandOne = 0;
        operandTwo = 0;
        result = 0;
        numDisplay = "0";
        operandsInputted = false;
        operandCnt = 1;
        updateTextView();
    }

    public void updateTextView() { // Updates the text view
        TextView textView = findViewById(R.id.calcResult);
        textView.setText(numDisplay);
    }

    public void throwErrorMessageNoNums(){ // No numbers inputted error
        Context context = getApplicationContext();
        Toast errorMessage = Toast.makeText(context, "You didn't enter any numbers", Toast.LENGTH_SHORT);
        errorMessage.show();
    }

    public void throwErrorMessageOperands(){ // Simple calculator, only supports two numbers at a time
        Context context = getApplicationContext();
        Toast errorMessage = Toast.makeText(context, "Only two operands at a time please!", Toast.LENGTH_SHORT);
        errorMessage.show();
    }
}