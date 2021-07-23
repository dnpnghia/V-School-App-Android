package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;


import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.v_school.databinding.Activity3Binding;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {


    EditText phone;
    EditText password;
    MyDatabase myDatabase;
    TextView quenMk;

    SharedPreferences pref;
    SharedPreferences.Editor editor;


    private AppBarConfiguration mAppBarConfiguration;
    private Activity3Binding binding;
    private String username = "";
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDatabase = new MyDatabase(this);
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        Account currentAccount = myDatabase.getAccountByPhone(pref.getString("currentPhone", "").toString());
        setContentView(R.layout.activity_main);
        phone = (EditText) findViewById(R.id.edit_phone);
        password = (EditText) findViewById(R.id.edit_password);
        quenMk =(TextView) findViewById(R.id.txt_quenmk);
        quenMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://v-school.vn/reset-password"));
                startActivity(intent);
            }
        });
    }

    public void login(View view) {
        try {
            String phoneCheck = phone.getText().toString().trim();
            String passwordCheck = password.getText().toString();
            Account loginAccount = new Account();
            loginAccount = myDatabase.loginAccount(phoneCheck, passwordCheck);
            if (loginAccount != null) {

                Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                ;
                // if login success
                // procces create next view for drawerview
                username = loginAccount.getUsername().toString().trim();
                account = loginAccount;
                binding = Activity3Binding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());
                setSupportActionBar(binding.appBarMain.toolbar);
                editor = pref.edit();
                editor.putString("currentPhone", loginAccount.getPhone());
                editor.commit();
                DrawerLayout drawer = binding.drawerLayout;
                NavigationView navigationView = binding.navView;
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                navigationView.getMenu().findItem(R.id.nav_dangxuat).setOnMenuItemClickListener(menuItem -> {
                    logout();
                    return true;
                });
                View heaaderView = navigationView.getHeaderView(0);
                TextView navUserName = (TextView) heaaderView.findViewById(R.id.txtNavUsername);
                TextView navUserRole = (TextView) heaaderView.findViewById(R.id.txtUserRole);
                navUserName.setText(account.getUsername());
                navUserRole.setText(account.getRole());

                mAppBarConfiguration = new AppBarConfiguration.Builder(
                        R.id.nav_home, R.id.nav_dieukhoan, R.id.nav_thongtin, R.id.nav_dangxuat)

                        .setDrawerLayout(drawer)
                        .build();
                NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
                NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
                NavigationUI.setupWithNavController(navigationView, navController);


            }
            else {
                Toast.makeText(MainActivity.this, "Sai số điện thoại hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            System.out.println(e);
            Toast.makeText(MainActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
        }
    }

    public void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


