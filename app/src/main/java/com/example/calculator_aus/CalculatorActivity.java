package com.example.calculator_aus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

public class CalculatorActivity extends AppCompatActivity {
    private String num1 = ""; //第一個數
    private String num2 = ""; //第二個數
    private boolean dotFlag = false; //紀錄是否存在"."
    private boolean countFlag = false; //記錄是否點擊運算元
    private String todo = ""; //運算子
    private String lastNum = ""; //上一個計算數值
    private String result =  ""; //結果


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
        countFlag = false;
        num1 = "";
        num2 = "";
        todo = "";
        lastNum = "";
        result =  "";
    }
    public void onClickBtnBack(View view) {

        if(countFlag && num2 != ""){
            if(num2.length() == 0 || num2.length()-1 == 0) {
                num2 = "";
            }else{
                num2 = num2.substring(0,num2.length()-1);
            }
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num1.toString());
        } else if (!countFlag && num1 != ""){
            if(num1.length() == 0 || num1.length()-1 == 0) {
                num1 = "";
            }else{
                num1 = num1.substring(0,num1.length()-1);
            }
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num1.toString());
        }
    }


    public void onClickDot(View view) {
        if (!dotFlag) {
            if (countFlag) {
                num2 += num2.equals("") ? "0." : ".";
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num2.toString());
            } else {
                num1 += num1.equals("") ? "0." : ".";
                TextView txtResultView = findViewById(R.id.txtResultView);
                txtResultView.setText(num1.toString());
            }
        }
        dotFlag = true;
    }
    
    public void onClickPlus(View view) {
        countFlag = true;
        dotFlag = false;
        todo = "plus";
        if(!num2.equals("")) {doCalculation();}
    }
    public void onClickMinus(View view) {
        countFlag = true;
        dotFlag = false;
        todo = "minus";
        if(!num2.equals("")) {doCalculation();}
    }
    public void onClickMultiplied(View view) {
        countFlag = true;
        dotFlag = false;
        todo = "multiplied";
        if(!num2.equals("")) {doCalculation();}
    }
    public void onClickDivided(View view) {
        countFlag = true;
        dotFlag = false;
        todo = "divided";
        if(!num2.equals("")) {doCalculation();}
    }

    public void onClickEquals(View view) {
        doCalculation();
        countFlag = false;
        dotFlag = false;
    }

    private void doShowOnView(String num) {
        if(countFlag) {
            num2 += num;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num2.toString());
        }else{
            num1 += num;
            TextView txtResultView = findViewById(R.id.txtResultView);
            txtResultView.setText(num1.toString());
        }
    }

    /*
     * 確認是否為需要呈現小數
     */
    private void chkUseDouble() {
        int dotIndex = result.indexOf('.'); //find dot position
        String afterDot = result.substring(dotIndex+1, result.length()); //find out integer after the dot
        if(afterDot.equals("0")) {result = result.substring(0,dotIndex); } //if after dot is 0, means the number has been divided
    }

    /*
     * 計算
     */
    private void doCalculation() {
        TextView txtResultView = findViewById(R.id.txtResultView);
        if(todo.equals("plus")) {
            if (num2.equals("")) { //when click again but haven't input num2
                result = String.valueOf(Double.valueOf(num1) + Double.valueOf(lastNum));
            } else {
//                result = String.valueOf(Double.valueOf(num1) + Double.valueOf(num2));
                result = String.valueOf(Calculation.add(Double.valueOf(num1), Double.valueOf(num2)));
            }
        }else if(todo.equals("minus")){
            if(num2.equals("")) {
                result = String.valueOf(Double.valueOf(num1) - Double.valueOf(lastNum));
            }else {
                result = String.valueOf(Double.valueOf(num1) - Double.valueOf(num2));
            }
        }else if(todo.equals("multiplied")){
            if(num2.equals("")) {
                result = String.valueOf(Double.valueOf(num1) * Double.valueOf(lastNum));
            }else {
                result = String.valueOf(Double.valueOf(num1) * Double.valueOf(num2));
            }
        }else if(todo.equals("divided")){
            if(num2.equals("")) {
                result = String.valueOf(Double.valueOf(num1) / Double.valueOf(lastNum));
            }else {
                result = String.valueOf(Double.valueOf(num1) / Double.valueOf(num2));
            }
        }
        chkUseDouble();
        if(!num2.equals("")) lastNum = num2;
        num1 = result;
        num2 = "";
        txtResultView.setText(result.toString());
    }
}