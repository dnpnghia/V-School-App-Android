package com.example.v_school;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import android.view.Menu;
import android.view.View;
import android.view.Window;

//import com.example.v_school.databinding.Activity3Binding;
//import com.google.android.material.navigation.NavigationView;
//import com.google.android.material.snackbar.Snackbar;
//import android.view.View;
//import android.view.Window;

import android.widget.EditText;
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

//        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//        if (pref.getString("mydata", "") != null) {
//            Intent i = new Intent(MainActivity.this, Activity_2.class);
//            i.putExtra("username", pref.getString("mydata", "").toString());
//            startActivityForResult(i, 10);
//            finish();
//        }
        setContentView(R.layout.activity_main);
        phone = (EditText) findViewById(R.id.edit_phone);
        password = (EditText) findViewById(R.id.edit_password);
        myDatabase = new MyDatabase(this);
    }

    public void login(View view) {
        try {
            String phoneCheck = phone.getText().toString();
            String passwordCheck = password.getText().toString();
            Account loginAccount = new Account();
            loginAccount = myDatabase.loginAccount(phoneCheck, passwordCheck);
            if (loginAccount != null) {
                Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Activity_2.class);
                i.putExtra("username", loginAccount.getUsername().toString());
                i.putExtra("phone", loginAccount.getPhone().toString());
                i.putExtra("password", passwordCheck);
                startActivity(i);
                finish();

//            editor = pref.edit();
//            editor.putString("mydata", loginAccount.getUsername());
//            editor.commit();
            } else {
                Toast.makeText(MainActivity.this, "Sai số điện thoại hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
        }


    }
}
//
//
//public class MainActivity extends AppCompatActivity {
//    private AppBarConfiguration mAppBarConfiguration;
//    private Activity3Binding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = Activity3Binding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        setSupportActionBar(binding.appBarMain.toolbar);
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//    }
//
//    // add menu for actionbar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//
//
//    }
//}
