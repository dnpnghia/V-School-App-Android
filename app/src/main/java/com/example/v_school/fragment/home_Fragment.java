package com.example.v_school.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.v_school.Account;
import com.example.v_school.Activity_2;
import com.example.v_school.Activity_7;
import com.example.v_school.MainActivity;
import com.example.v_school.R;
import com.example.v_school.databinding.Activity3Binding;

import org.jetbrains.annotations.NotNull;

public class home_Fragment extends Fragment {

    private Button btnThongbao;
    private Button btnQuanly;
    private Button btnCaidat;
    private Button btnHotro;
    private TextView textViewUsername;
    private View root;
    private MainActivity mainActivity;
    private Account account;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
         root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        btnQuanly = getView().findViewById(R.id.btnQuanly);
        textViewUsername = getView().findViewById(R.id.txtUsernameMenu);
        mainActivity = (MainActivity)getActivity();
//        account = mainActivity.getAccount();
        textViewUsername.setText("Xin chao " + account.getUsername());
        btnQuanly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Fragment fragment;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(account.getRole().equals("PARENT"))
                    fragment = new quanly_Fragment();
                else if (account.getRole().equals("SCHOOL"))
                    fragment = new listphuhuynh_Fragment();
                else
                    fragment = null;
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,fragment ).addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        root = null;
    }
}
