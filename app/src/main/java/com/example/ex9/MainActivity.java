package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText inputEditText;
    double result = 0;
    double prevNum = 0;
    String operator = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.inputEditText);
        Intent intent = getIntent();
        double resultFromSecondActivity = intent.getDoubleExtra("result", 0);
        inputEditText.setText(String.valueOf(resultFromSecondActivity));
    }

    public void performMathOperation(View view) {
        if (count == 0) {
            prevNum = Double.parseDouble(inputEditText.getText().toString());
        }
        count++;

        switch (view.getId()) {
            case R.id.plusButton:
                operator = "+";
                break;
            case R.id.minusButton:
                operator = "-";
                break;
            case R.id.multiplyButton:
                operator = "*";
                break;
            case R.id.divideButton:
                operator = "/";
                break;
        }

        inputEditText.setText("");
    }


    public void calculateResult(View view) {
        double newNumber = Double.parseDouble(inputEditText.getText().toString());
        switch (operator) {
            case "+":
                result = prevNum + newNumber;
                break;
            case "-":
                result = prevNum - newNumber;
                break;
            case "*":
                result = prevNum * newNumber;
                break;
            case "/":
                result = prevNum / newNumber;
                break;
        }
        inputEditText.setText(String.valueOf(result));
        count = 0;
    }

    public void clearInput(View view) {
        inputEditText.setText("");
        prevNum = 0;
        operator = "";
        count = 0;
    }

    public void goToSecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
