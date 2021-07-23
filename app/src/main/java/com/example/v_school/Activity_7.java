package com.example.v_school;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Activity_7 extends AppCompatActivity {
    private RecyclerView rvList;
    private List<Notification> noTiList = new ArrayList<>();
    private List<Notification> newList = new ArrayList<>();
    private NotificationAdapter noTiAdapter;
    private EditText inputSearch;
    private ImageButton btnSearch;
    private MyDatabase myDatabase = new MyDatabase(this);
    public static FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = rootNode.getReference().child("notification");
    private NotificationAdapter notificationAdapter = new NotificationAdapter(noTiList);
    private Account login = new Account();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thông báo");
        setContentView(R.layout.activity_7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvList = findViewById(R.id.recyclerview);


//        for (int i = 1; i < 11; i++) {
//            Notification notification = new Notification();
//            notification.setId(i);
//            notification.setTopic("Thong bao nghi hoc " + i);
//            notification.setDay("10/10/2021");
//            notification.setIdFrom("nghiadnp");
//            notification.setIdTo("khanhln");
//            if (i % 2 == 0) notification.setIsRead(1);
//            notification.setMessage("qwdqdbqwdiqwudhqwdiqduiqwhd");
//            noTiList.add(notification);
//        }

        String id = getIntent().getStringExtra("id");
        noTiList.clear();
        login = myDatabase.getAccById(id);
        newList = myDatabase.getAllNoti(login);
        Toast.makeText(getApplicationContext(), login.getId(),
                Toast.LENGTH_SHORT).show();
        for (int i = 0; i < newList.size(); i++) {
            noTiList.add(newList.get(i));
        }
        rvList.setHasFixedSize(true);


        inputSearch = (EditText) findViewById(R.id.edtSearch);
        btnSearch = (ImageButton) findViewById(R.id.imageButton);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Activity_7.this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(notificationAdapter);
        ArrayList<Notification> listNew = new ArrayList<>();
        for (int l = 0; l < noTiList.size(); l++) {
            if (noTiList.get(l).getIsRead() == 0) {
                listNew.add(noTiList.get(l));
            }
        }
        NotificationAdapter notificationAdapter = new NotificationAdapter(listNew);
        rvList.setAdapter(notificationAdapter);
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NotNull DataSnapshot snapshot, @Nullable String s) {
                Notification notification = new Notification();
                notification = snapshot.getValue(Notification.class);
                boolean flag = true;
                for (Notification noti: noTiList) {
                    if (noti.getIdTo().equals(notification.getIdTo()) && noti.getDay().equals(noti.getDay())) {
                        flag = false;
                        break;
                    }

                }
                if (flag){
                    myDatabase.insertNoti(notification.getIdFrom(), notification.getIdTo(), notification.getTopic(),
                            notification.getMessage(), notification.getDay());
                    if (notification.getIdTo().equals(login.getId()) ) {
                        Toast.makeText(getApplicationContext(), "Có thông báo mới !!!",
                                Toast.LENGTH_SHORT).show();
                        noTiList.add(notification);
                        notificationAdapter.notifyDataSetChanged();

                    }
                }


            }

            @Override
            public void onChildChanged(@NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
            }

            @Override
            public void onChildRemoved(@NotNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


        notificationAdapter.setMyOnClickItemListener(new MyOnClickItemListener() {
            @Override
            public void onClick(Notification notification) {
                Intent intent = new Intent(Activity_7.this, ChiTietThongBao.class);
                intent.putExtra("tenthongbao", notification.getTopic());
                intent.putExtra("ngay", notification.getDay());
                intent.putExtra("noidung", notification.getMessage());
                myDatabase.setIsRead(notification.getId());
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCHR = inputSearch.getText().toString();
                if (inputSearch.getText().toString().length() > 0) {
                    ArrayList<Notification> listNew = new ArrayList<>();
                    for (int l = 0; l < noTiList.size(); l++) {
                        String topic = noTiList.get(l).getTopic().toLowerCase();
                        if (topic.contains(strCHR.toLowerCase())) {
                            listNew.add(noTiList.get(l));
                        }
                    }

                    NotificationAdapter notificationAdapter = new NotificationAdapter(listNew);
                    rvList.setAdapter(notificationAdapter);
                } else {

                    NotificationAdapter notificationAdapter = new NotificationAdapter(noTiList);
                    rvList.setAdapter(notificationAdapter);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

            ArrayList<Notification> listNew = new ArrayList<>();
            for (int l = 0; l < noTiList.size(); l++) {
                if (noTiList.get(l).getIsRead() == 0) {
                    listNew.add(noTiList.get(l));
                }
            }
            NotificationAdapter notificationAdapter = new NotificationAdapter(listNew);
            rvList.setAdapter(notificationAdapter);


        notificationAdapter.notifyDataSetChanged();

    }

}