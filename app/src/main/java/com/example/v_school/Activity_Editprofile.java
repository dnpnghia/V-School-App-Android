package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Editprofile extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPhone;
    private EditText edtAdd;
    private Button btnEdiprofile;

    private Button btnBack;
    MyDatabase myDatabase;
    private String name;
    private String phone;
    private String add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Cập nhật thông tin");
        setContentView(R.layout.activity_editprofile);
        edtUsername = (EditText) findViewById(R.id.editCapnhatten);
        edtUsername.setHint(getIntent().getStringExtra("username"));
        edtPhone = (EditText) findViewById(R.id.editCapnhatsodienthoai);
        edtPhone.setHint(getIntent().getStringExtra("phone"));
        edtAdd = (EditText) findViewById(R.id.editCapnhatdiachi);
        edtAdd.setHint(getIntent().getStringExtra("address"));

        myDatabase = new MyDatabase(this);

        //CODE NUT' CAP nHAT
        btnEdiprofile = (Button) findViewById(R.id.btnEditCapnhatthongtin);
        btnEdiprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                name = edtUsername.getText().toString();
                phone = edtPhone.getText().toString();
                add = edtAdd.getText().toString();
                if (name.equals("") || phone.equals("") || (add.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin không thành công!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    myDatabase.editProfile(getIntent().getStringExtra("id"), name, phone, add);
                    Toast.makeText(getApplicationContext(), "Cập nhật thông tin thành công!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //CODE NUT' BACK
//        btnBack = (Button) findViewById(R.id.btnBackCapnhatthongtin);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                finish();
//            }
//        });
    }
}