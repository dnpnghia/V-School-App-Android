package com.example.v_school;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_4 extends AppCompatActivity {
    private MainActivity mainActivity;
    private  MyDatabase myDatabase;
    private Account account;
    private TextView userName,className;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        InitUI();
        String accountId = getIntent().getStringExtra("accountID");
        myDatabase = new MyDatabase(this);
        Student student = myDatabase.getStudentsByParent(accountId).get(0);
        userName.setText(student.getName().toString());
        className.setText(student.getClasses().toString());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void InitUI(){
        userName =(TextView) findViewById(R.id.txtChildName);
        className =(TextView) findViewById(R.id.txtLop);
    }

}
