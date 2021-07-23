package com.example.v_school.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.v_school.Account;
import com.example.v_school.Activity_4;
import com.example.v_school.Activity_5;
import com.example.v_school.Activity_6;
import com.example.v_school.Activity_7;
import com.example.v_school.Activity_8;
import com.example.v_school.MainActivity;
import com.example.v_school.MyDatabase;
import com.example.v_school.Notification;
import com.example.v_school.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class home_Fragment extends Fragment {

    private Button btnThongbao;
    private Button btnQuanly;
    private Button btnCaidat;
    private Button btnHotro;
    private TextView textViewUsername;
    private View root;
    private MainActivity mainActivity;
    private Account account;
    DatabaseReference myRef;
    FirebaseDatabase rootNode;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        InitUI();
        mainActivity = (MainActivity) getActivity();
        account = mainActivity.getAccount();
        textViewUsername.setText("Xin chào, " + account.getUsername());
        // button quan ly
        btnQuanly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in;
                if (account.getRole().equals("PARENT")) {
                    in = new Intent(getActivity(), Activity_4.class);
                    in.putExtra("accountID", account.getId());
                    startActivity(in);
                } else if (account.getRole().equals("SCHOOL")) {
                    // add activity of quan ly truong hoc
                    Intent intent = new Intent(getActivity(), Activity_8.class);
                    startActivity(intent);
                    
                } else
                    Toast.makeText(getActivity(), "get action fail", Toast.LENGTH_SHORT).show();
            }
        });
        // button thong bao
        btnThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Activity_7.class);
                in.putExtra("id", account.getId());
                startActivity(in);

            }
        });

        // button ho tro
        btnHotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Activity_5.class);
                startActivity(in);
            }
        });
        //button cai dat
        btnCaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_6.class);
                intent.putExtra("id", account.getId());
                startActivity(intent);
            }
        });


        // Read from the database
        rootNode = FirebaseDatabase.getInstance();
        myRef = rootNode.getReference("notification");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NotNull DataSnapshot snapshot, @Nullable String s) {
                Notification notification = new Notification();
                notification = snapshot.getValue(Notification.class);

                if (notification.getIdTo().equals(account.getId())) {
                    Toast.makeText(getActivity().getApplicationContext(), "Có thông báo mới !!!", Toast.LENGTH_SHORT).show();
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
    }

    public void InitUI() {
        btnQuanly = getView().findViewById(R.id.btnQuanly);
        btnThongbao = getView().findViewById(R.id.btnThongbao);
        btnHotro = getView().findViewById(R.id.btnHotro);
        btnCaidat = getView().findViewById(R.id.btnCaidat);
        textViewUsername = getView().findViewById(R.id.txtUsernameMenu);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        root = null;
    }


    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}