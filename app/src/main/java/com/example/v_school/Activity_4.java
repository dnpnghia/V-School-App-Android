package com.example.v_school;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_4 extends AppCompatActivity {
    private MainActivity mainActivity;
    private  MyDatabase myDatabase;
    private Account account;
    private TextView userName,className;
    private Button btnDiem, btnHocPhi,btnDiemDanh, btnThongtin;
    Student student;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        InitUI();
        String accountId = getIntent().getStringExtra("accountID");
        Toast.makeText(getApplicationContext(), accountId, Toast.LENGTH_SHORT).show();
        myDatabase = new MyDatabase(this);
        student = myDatabase.getStudentsByParent(accountId).get(0);
        userName.setText(student.getName().toString());
        className.setText("Lop: "+student.getClasses().toString());
        btnDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_4.this,Activity_grade.class);
                intent.putExtra("studentName", student.getName());
                intent.putExtra("studentId", student.getId());
                Toast.makeText(Activity_4.this, student.getId(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void InitUI(){
        userName =(TextView) findViewById(R.id.txtChildName);
        className =(TextView) findViewById(R.id.txtLop);
        btnDiem = (Button)findViewById(R.id.btnDiem);
    }

}
