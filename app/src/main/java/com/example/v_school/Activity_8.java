package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Button;

public class Activity_8 extends AppCompatActivity {
Button guithongbao_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Phụ huynh");
        setContentView(R.layout.activity_8);
        if (findViewById(R.id.your_placeholderActivity8)!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholderActivity8, new DanhsachPhuhuynhFragment());
            ft.commit();
        }
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.your_placeholderActivity8, fragment);
        fragmentTransaction.commit();


    }
}