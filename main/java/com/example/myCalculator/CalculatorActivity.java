package com.example.myCalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editText;
    private String str = "";
    private Eval eval = new Eval();
    private boolean hasDot = false;

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
                if (str.equals("") || !("+-*/".contains(str.substring(str.length()-1)))){
                    opClick("+");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.equals("") || !("-".contains(str.substring(str.length()-1)))){
                    opClick("-");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!str.equals("") && !("+-*/".contains(str.substring(str.length()-1)))) {
                    opClick("*");
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!str.equals("") && !("+-*/".contains(str.substring(str.length()-1)))){
                    opClick("/");
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasDot) {
                    if (str.equals("") || "+-*/".contains(str.substring(str.length()-1)))
                        numClick("0");
                    hasDot = true;
                    numClick(".");
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!str.equals("")){
                    editText.setText(String.valueOf(calculate(str)));
                    cancel();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                cancel();
            }
        });

    }

    private void cancel() {
        hasDot = false;
        str = "";
    }

    private void numClick(String num) {
        str = str + num;
        editText.setText(str);
    }

    private void opClick(String num) {
            hasDot = false;
            numClick(num);
    }

    private double calculate(String expression) {
        try {
            return this.eval.eval(expression);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

}
