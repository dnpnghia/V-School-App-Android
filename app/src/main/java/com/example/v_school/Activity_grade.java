package com.example.v_school;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Activity_grade extends AppCompatActivity {
 EditText diemToan, diemVan, diemAnh, diemTong;
 TextView txtChildName;
 MyDatabase myDatabase;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);
        InitUI();
        myDatabase = new MyDatabase(this);
        String studentId =  getIntent().getStringExtra("studentId");
        String studentName = getIntent().getStringExtra("studentName");
        Toast.makeText(this, "studentID"+studentId, Toast.LENGTH_SHORT).show();
        txtChildName.setText(studentName);
        ArrayList<Grade> listGrade = new ArrayList<>();
        listGrade = myDatabase.getGradeByStudent(studentId);
        try {
            if(!listGrade.isEmpty()){
                Toast.makeText(Activity_grade.this,listGrade.size()+"",Toast.LENGTH_LONG).show();
                diemToan.setText(listGrade.get(0).getToan()+"");
                diemVan.setText(listGrade.get(0).getVan()+"");
                diemAnh.setText(listGrade.get(0).getAnh()+"");
                diemTong.setText(listGrade.get(0).getTb()+"");
            }
            else {
                Toast.makeText(Activity_grade.this,listGrade.size()+"",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void InitUI(){
        diemToan = (EditText) findViewById(R.id.edtToan);
        diemVan = (EditText) findViewById(R.id.edtVan);
        diemAnh = (EditText) findViewById(R.id.edtAnh);
        diemTong = (EditText) findViewById(R.id.edtTong);
        txtChildName = (TextView) findViewById(R.id.txtChildName);
    }
}
