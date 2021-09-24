package com.example.calculator_aus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalculatorActivity extends AppCompatActivity {
    private String num1 = "";
    private String num2 = "";
    private boolean dotFlag = false;
    private boolean countFlag = false;
    private String todo = "";
    private String lastNum = "";
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
        doShowOnView("1");
    }

    public void onClickBtn2(View view) { doShowOnView("2"); }

    public void onClickBtn3(View view) {
        doShowOnView("3");
    }

    public void onClickBtn4(View view) {
        doShowOnView("4");
    }

    public void onClickBtn5(View view) { doShowOnView("5"); }

    public void onClickBtn6(View view) {
        doShowOnView("6");
    }

    public void onClickBtn7(View view) {
        doShowOnView("7");
    }

    public void onClickBtn8(View view) {
        doShowOnView("8");
    }

    public void onClickBtn9(View view) {
        doShowOnView("9");
    }

    public void onClickBtnClear(View view) {
        TextView txtResultView = findViewById(R.id.txtResultView);
        txtResultView.setText("");
        dotFlag = false;
        countFlag =false;
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
    public void onClickMinus(View view) {
        countFlag = true;
        todo = "minus";
    }
    public void onClickMultiplied(View view) {
        countFlag = true;
        todo = "multiplied";
    }
    public void onClickDivided(View view) {
        countFlag = true;
        todo = "divided";
    }

    public void onClickEquals(View view) {
        TextView txtResultView = findViewById(R.id.txtResultView);
        if(todo.equals("plus")) {
            if(num2.equals("")) { //when click again but haven't input num2
                result = String.valueOf(Integer.valueOf(num1) + Integer.valueOf(lastNum));
            }else {
                result = String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
            }
            if(!num2.equals("")) lastNum = num2;
            num1 = result;
            num2 = "";
            txtResultView.setText(result.toString());
        }
        //countFlag = false;

        if(todo.equals("minus")){
            if(num2.equals("")) {//
                result = String.valueOf(Integer.valueOf(num1) - Integer.valueOf(lastNum));
            }else {
                result = String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2));
            }
            if(!num2.equals("")) lastNum = num2;
            num1 = result;
            num2 = "";
            txtResultView.setText(result.toString());
        }
        if(todo.equals("multiplied")){
            if(num2.equals("")) {//
                result = String.valueOf(Integer.valueOf(num1) * Integer.valueOf(lastNum));
            }else {
                result = String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2));
            }
            if(!num2.equals("")) lastNum = num2;
            num1 = result;
            num2 = "";
            txtResultView.setText(result.toString());
        }
        if(todo.equals("divided")){
            if(num2.equals("")) {//
                result = String.valueOf(Integer.valueOf(num1) / Integer.valueOf(lastNum));
            }else {
                result = String.valueOf(Integer.valueOf(num1) / Integer.valueOf(num2));
            }
            if(!num2.equals("")) lastNum = num2;
            num1 = result;
            num2 = "";
            txtResultView.setText(result.toString());
        }
    }

    private void doShowOnView(String num) {
        if(countFlag) {
            if(!num1.equals(""))
            {
            num2 += num;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num2.toString());
            }else{
                num1 += num;
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num1.toString());
            }
        }else{
            num1 += num;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num1.toString());
        }
    }
}