package com.example.calculator_aus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnToCalculatorActive);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculatorView();
            }
        });
    }

    public void onClickButton(View view) {
        EditText edtFirstName = findViewById(R.id.edtFirstName);
        TextView txtFirstName = findViewById(R.id.txtFirstName);
        txtFirstName.setText(txtFirstName.getText()+" : "+edtFirstName.getText().toString());

        EditText edtLastName = findViewById(R.id.edtLastName);
        TextView txtLastName = findViewById(R.id.txtLastName);
        txtLastName.setText(txtLastName.getText()+" : "+edtLastName.getText().toString());

        EditText edtEmail = findViewById(R.id.edtEmail);
        TextView txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(txtEmail.getText()+" : "+edtEmail.getText().toString());
    }

    public void openCalculatorView() {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void btnSwitchCalculatorActive(View view) {

    }
}