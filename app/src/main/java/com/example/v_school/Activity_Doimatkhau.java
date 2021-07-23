package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Doimatkhau extends AppCompatActivity {
    private EditText edtMkcu;
    private EditText edtMkmoi;
    private EditText edtXacnhanMk;
    private Button btnCapnhat;

    MyDatabase myDatabase;
    private String mkcu;
    private String mkmoi;
    private String xacnhan;
    String mk="";
    String id="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Đổi mật khẩu");
        setContentView(R.layout.activity_doimatkhau);
        edtMkcu = (EditText) findViewById(R.id.txt_mkCu);
        edtMkmoi = (EditText) findViewById(R.id.txt_mMoi);
        edtXacnhanMk = (EditText) findViewById(R.id.txt_xacnhanMk);

        myDatabase = new MyDatabase(this);


        //CODE NUT' CAP nHAT
        btnCapnhat = (Button) findViewById(R.id.btnDoiMK);
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mkcu = edtMkcu.getText().toString();
                mkmoi = edtMkmoi.getText().toString();
                xacnhan = edtXacnhanMk.getText().toString();
                mk = getIntent().getStringExtra("mk");
                id = getIntent().getStringExtra("id");

                boolean flag = true;

                if (mkcu.equals("") || mkmoi.equals("") || (xacnhan.equals(""))) {
                    flag = false;
                }


                if (mkcu.equals(mk) == false) {
                 flag = false;
                }

                if (mkmoi.equals(xacnhan) == false) {
                   flag = false;
                }

                if (flag) {
                    Toast.makeText(getApplicationContext(), "Cập nhật mật khẩu  thành công!",
                            Toast.LENGTH_SHORT).show();
                    myDatabase.changePass(id,mkmoi);
                }else {
                    Toast.makeText(getApplicationContext(), "Cập nhật mật khẩu không thành công!!",
                            Toast.LENGTH_SHORT).show();
                }


            }


        });


    }
}