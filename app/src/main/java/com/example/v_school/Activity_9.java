package com.example.v_school;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Activity_9 extends AppCompatActivity {
    Button guithongbao;
    EditText chude;
    EditText noidung;
    CheckedParentAdapter adapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    MyDatabase myDatabase;
    SharedPreferences pref;
    Account currentAccount = new Account();
    NetworkChangeReceiver netReceiver = new NetworkChangeReceiver();
    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Gửi thông báo");
        setContentView(R.layout.activity_9);
        myDatabase = new MyDatabase(this);
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        registerReceiver(netReceiver, intentFilter);
//        myDatabase = new MyDatabase(this);
        guithongbao = (Button) findViewById(R.id.btn_guithongbao);
        chude = (EditText) findViewById(R.id.txt_topicNoti);
        noidung = (EditText) findViewById(R.id.txt_contentNoti);

        //curent Account
        currentAccount = myDatabase.getAccountByPhone(pref.getString("currentPhone", "").toString());
        Log.d("currentAcc", "" + currentAccount.toString());
        // lay list tu activity 8
        Bundle bundle = getIntent().getExtras();
        // danh sach phu huynh can gui tb
        ArrayList<Account> checkedParents = (ArrayList<Account>) bundle.getSerializable("checkedParents");

        // ds cac phu huynh nhan thong bao
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_parent);
        adapter = new CheckedParentAdapter(checkedParents);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        // click gui thong bao
        guithongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!netReceiver.isOnline(Activity_9.this)) {
                    Toast.makeText(Activity_9.this, "Vui lòng kiểm tra kết nối!", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        String topic = chude.getText().toString();
                        String message = noidung.getText().toString();


                        if (topic.isEmpty() || message.isEmpty()) {
                            Toast.makeText(Activity_9.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_LONG).show();

                        } else {
                            // get current day
                            Date currentTime = Calendar.getInstance().getTime();
                            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                            String day = dateFormat.format(currentTime);
                            int numberOfParentRecieve = checkedParents.size();
                            // them tb vao db
                            for (Account pr : checkedParents) {
                                myDatabase.insertNoti(currentAccount.getId(), pr.getId(), topic, message, day);

                            }
                            // danh sach thong bao vua them vao db
                            ArrayList<Notification> listNotiNewest = new ArrayList<>();
                            listNotiNewest = myDatabase.getNotiNewest(numberOfParentRecieve);
                            // them tb vao firebase
                            for (Notification nt : listNotiNewest) {
                                rootNode = FirebaseDatabase.getInstance();
                                reference = rootNode.getReference("notification");
                                String userId = reference.push().getKey();
                                reference.child(userId).setValue(nt);
                            }
                            Toast.makeText(Activity_9.this, "Thêm thông báo thành công!", Toast.LENGTH_LONG).show();
                            checkedParents.clear();
                            Intent i = new Intent(Activity_9.this, Activity_8.class);
                            startActivity(i);

                        }


                    } catch (Exception e) {
                        Toast.makeText(Activity_9.this, "Thêm thông báo thất bại! Thử lại sau", Toast.LENGTH_SHORT).show();
                        checkedParents.clear();
                    }
                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netReceiver);
    }
}
