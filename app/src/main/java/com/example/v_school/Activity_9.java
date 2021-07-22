package com.example.v_school;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Activity_9 extends AppCompatActivity {
    Button guithongbao;
    CheckedParentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Gửi thông báo");
        setContentView(R.layout.activity_9);
        guithongbao = (Button) findViewById(R.id.btn_guithongbao);
        // lay list tu activity 8
        Bundle bundle = getIntent().getExtras();
        ArrayList<Account> checkedParents = (ArrayList<Account>) bundle.getSerializable("checkedParents");
        // ds cac phu huynh nhan thong bao
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_parent);
        adapter = new CheckedParentAdapter(checkedParents);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
