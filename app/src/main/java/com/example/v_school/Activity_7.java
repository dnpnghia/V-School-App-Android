package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Activity_7 extends AppCompatActivity {
    private RecyclerView rvList;
    private List<Notification> noTiList = new ArrayList<>();
    private NotificationAdapter noTiAdapter;
    DatabaseReference myRef;
    FirebaseDatabase rootNode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thông báo");
        setContentView(R.layout.activity_7);
        rvList = findViewById(R.id.recyclerview);

        rootNode = FirebaseDatabase.getInstance();
        myRef = rootNode.getReference("notification");


        for(int i = 1;i<11;i++)
        {
            Notification notification = new Notification();
            notification.setTopic("Thong bao nghi hoc "+i);
            notification.setDay("10/10/2021");
            notification.setIdFrom("nghiadnp");
            notification.setIdTo("khanhln");
            notification.setMessage("qwdqdbqwdiqwudhqwdiqduiqwhd");
            noTiList.add(notification);
        }
        rvList.setHasFixedSize(true);
        NotificationAdapter notificationAdapter= new NotificationAdapter(noTiList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Activity_7.this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(notificationAdapter);

        notificationAdapter.setMyOnClickItemListener(new MyOnClickItemListener() {
            @Override
            public void onClick(Notification notification) {
                Intent intent = new Intent(Activity_7.this,ChiTietThongBao.class);
                intent.putExtra("tenthongbao",notification.getTopic());
                intent.putExtra("ngay",notification.getDay());
                intent.putExtra("noidung",notification.getMessage());
                startActivity(intent);
            }
        });



    }
}