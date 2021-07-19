package com.example.v_school;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText phone;
    EditText password;

    MyDatabase myDatabase;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (pref.getString("mydata","")!=null){
            Intent i = new Intent(MainActivity.this, Activity_2.class);
            i.putExtra("username",pref.getString("mydata","").toString());
            startActivityForResult(i, 10);
            finish();
        }
        setContentView(R.layout.activity_main);
        phone = (EditText) findViewById(R.id.edit_phone);
        password = (EditText) findViewById(R.id.edit_password);
        myDatabase=new MyDatabase(this);
    }

    public void login(View view){
        String phoneCheck = phone.getText().toString();
        String passwordCheck =  password.getText().toString();
        Account loginAccount = new Account();
        loginAccount =  myDatabase.loginAccount(phoneCheck, passwordCheck);
        if (loginAccount!=null){
            Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Activity_2.class);
            i.putExtra("username", loginAccount.getUsername());
            startActivityForResult(i, 10);
            editor = pref.edit();
            editor.putString("mydata", loginAccount.getUsername());
            editor.commit();
        }else{
            Toast.makeText(MainActivity.this, "Sai số điện thoại hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }
}