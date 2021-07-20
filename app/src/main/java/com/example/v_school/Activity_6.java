package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_6 extends AppCompatActivity {

    private TextView tvUsername;
    private TextView tvPhone;
    private TextView tvAdd;
    private Button btnEdiprofile;
    private Button btnChangepass;
    private Button btnBack;
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        String username = getIntent().getStringExtra("username");
        String phone = getIntent().getStringExtra("phone");
        String pass = getIntent().getStringExtra("password");
        myDatabase = new MyDatabase(this);
        Account loginAccount = new Account();
        loginAccount = myDatabase.loginAccount(phone, pass);

        tvUsername = (TextView) findViewById(R.id.txtUsername);
        tvUsername.setText(username);
        tvPhone = (TextView) findViewById(R.id.txtPhone);
        tvPhone.setText(phone);
        tvAdd = (TextView) findViewById(R.id.txtAdd);
        tvAdd.setText(loginAccount.getAddress());

        //CODE NUT' BACK
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
//                System.exit(0);
            }
        });
    }
}