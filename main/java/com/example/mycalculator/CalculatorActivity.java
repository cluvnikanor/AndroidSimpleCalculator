package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editText;
    private double val1;
    private double val2;
    private double x;
    private String str = "", operation;
    private boolean firstValue = true, result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        Button button0 = (Button) findViewById(R.id.calc_button_0);
        Button button1 = (Button) findViewById(R.id.calc_button_1);
        Button button2 = (Button) findViewById(R.id.calc_button_2);
        Button button3 = (Button) findViewById(R.id.calc_button_3);
        Button button4 = (Button) findViewById(R.id.calc_button_4);
        Button button5 = (Button) findViewById(R.id.calc_button_5);
        Button button6 = (Button) findViewById(R.id.calc_button_6);
        Button button7 = (Button) findViewById(R.id.calc_button_7);
        Button button8 = (Button) findViewById(R.id.calc_button_8);
        Button button9 = (Button) findViewById(R.id.calc_button_9);
        Button buttonAdd = (Button) findViewById(R.id.calc_button_add);
        Button buttonSub = (Button) findViewById(R.id.calc_button_sub);
        Button buttonMul = (Button) findViewById(R.id.calc_button_mul);
        Button buttonDiv = (Button) findViewById(R.id.calc_button_div);
        Button buttonCancel = (Button) findViewById(R.id.calc_button_cancel);
        Button buttonDot = (Button) findViewById(R.id.calc_button_dot);
        Button buttonEquals = (Button) findViewById(R.id.calc_button_equals);

        editText = (EditText) findViewById(R.id.calc_edit_text);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numClick("9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstValue && !str.equals("") && "01234567890".contains(String.valueOf(str.charAt(str.length() - 1)))) {
                    operationClick("+");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstValue && str.equals("")) {
                    str = "-";
                    editText.setText("-");
                } else {
                    if ("01234567890".contains(String.valueOf(str.charAt(str.length() - 1)))) {
                        operationClick("-");
                    }
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstValue && !str.equals("") && "01234567890".contains(String.valueOf(str.charAt(str.length() - 1)))) {
                    operationClick("*");
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstValue && !str.equals("") && "01234567890".contains(String.valueOf(str.charAt(str.length() - 1)))) {
                    operationClick("/");
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!str.contains(".")) {
                    str = str + ".";
                    editText.setText(editText.getText() + ".");
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2 = Double.parseDouble(str);
                if (!firstValue && !(operation.equals("/") && val2 == 0)) {
                    x = compute(operation);
                    result = true;
                    editText.setText(String.valueOf(x));
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }

    private void cancel() {
        str = "";
        firstValue = true;
        editText.setText("");
    }

    private void numClick(String num) {
        if (result) {
            cancel();
            result = false;
        }
        str = str + num;
        editText.setText(editText.getText() + num);
    }

    private void operationClick(String op) {
        operation = op;
        if (!(!firstValue && !op.equals("/") && val2==0)){ //checking divide by zero
            if (firstValue){
                val1 = Double.parseDouble(str);
            }
            else {
                val1 = compute(op); // to compute another expression
            }
            firstValue = false;
            str = "";
            editText.setText(editText.getText() + op);
        }
    }

    private double compute(String op) {
        switch (operation) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
        }
        return 0;
    }

}
