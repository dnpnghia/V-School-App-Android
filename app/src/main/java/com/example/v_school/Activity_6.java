package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.v_school.databinding.FragmentHomeBinding;

public class Activity_6 extends AppCompatActivity {

    private TextView tvUsername;
    private TextView tvPhone;
    private TextView tvAdd;
    private Button btnEdiprofile;
    private Button btnChangepass;
    private Button btnBack;
    private  String id;
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
        String add = loginAccount.getAddress();
        id = loginAccount.getId();

        tvUsername = (TextView) findViewById(R.id.txtUsername);
        tvUsername.setText(username);
        tvPhone = (TextView) findViewById(R.id.txtPhone);
        tvPhone.setText(phone);
        tvAdd = (TextView) findViewById(R.id.txtAdd);
        tvAdd.setText(loginAccount.getAddress());


        // CODE NUT' EDIT PROFILE
        btnEdiprofile = (Button) findViewById(R.id.btnEdit);
        btnEdiprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_6.this, Activity_Editprofile.class);
                intent.putExtra("username", username);
                intent.putExtra("phone", phone);
                intent.putExtra("address", add);
                intent.putExtra("id", id);
                startActivity(intent);

            }
        });

        //CODE NUT' BACK
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Account account = new Account();
        account = myDatabase.getAccById(getIntent().getStringExtra("id"));
        tvUsername = (TextView) findViewById(R.id.txtUsername);
        tvUsername.setText(account.getUsername());
        tvPhone = (TextView) findViewById(R.id.txtPhone);
        tvPhone.setText(account.getPhone());
        tvAdd = (TextView) findViewById(R.id.txtAdd);
        tvAdd.setText(account.getAddress());

    }

}