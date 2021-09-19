package com.example.calculator_aus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalculatorActivity extends AppCompatActivity {
    private String num1, num2 = "";
    private boolean dotFlag = false;
    private boolean countFlag = false;
    private String todo = "";
    private String result =  "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    }

    public void onClickBtn0(View view) {
        if(countFlag) {
            if(!num2.equals("")) {
                num2 += 0;
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num2.toString());
            }
        }else{
            if(!num1.equals("")) {
                num1 += 0;
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num1.toString());
            }
        }
    }

    public void onClickBtn1(View view) {
        if(countFlag) {
            num2 += 1;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num2.toString());
        }else {
            num1 += 1;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num1.toString());
        }
    }

    public void onClickBtn2(View view) {
        if(countFlag) {
            num2 += 2;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num2.toString());
        }else {
            num1 += 2;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num1.toString());
        }
    }

    public void onClickBtn3(View view) {
        num1 += 3;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtn4(View view) {
        num1 += 4;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtn5(View view) {
        num1 += 5;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtn6(View view) {
        num1 += 6;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtn7(View view) {
        num1 += 7;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtn8(View view) {
        num1 += 8;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtn9(View view) {
        num1 += 9;
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText(num1.toString());
    }

    public void onClickBtnClear(View view) {
        num1 = "";
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText("");
        dotFlag = false;
        num1 = "";
        num2 = "";
    }

    public void onClickDot(View view) {
        if(!dotFlag) {
            if(countFlag) {
                num1 += ".";
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num1.toString());
                dotFlag = true;
            }else {
                num2 += ".";
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num2.toString());
                dotFlag = true;
            }
        }
    }
    
    public void onClickPlus(View view) {
        countFlag = true;
        todo = "plus";
        
    }

    public void onClickEquals(View view) {
        TextView txtResultView = findViewById(R.id.txtResultView);
        if(todo.equals("plus")) {
            result = String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));

        }else if(todo.equals("")) {

        }else{

        }
        txtResultView.setText(result.toString());
        countFlag = false;
        num2 = "";
    }
}