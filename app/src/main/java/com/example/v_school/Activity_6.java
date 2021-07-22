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
    MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        String id = getIntent().getStringExtra("id");


        myDatabase = new MyDatabase(this);
         Account loginAccount = myDatabase.getAccById(id);
        String add = loginAccount.getAddress();


        tvUsername = (TextView) findViewById(R.id.txtUsername);
        tvUsername.setText(loginAccount.getUsername());
        tvPhone = (TextView) findViewById(R.id.txtPhone);
        tvPhone.setText(loginAccount.getPhone());
        tvAdd = (TextView) findViewById(R.id.txtAdd);
        tvAdd.setText(loginAccount.getAddress());


        // CODE NUT' EDIT PROFILE
        btnEdiprofile = (Button) findViewById(R.id.btnEdit);
        btnEdiprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_6.this, Activity_Editprofile.class);
                intent.putExtra("username", loginAccount.getUsername());
                intent.putExtra("phone", loginAccount.getPhone());
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