package com.example.v_school.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.v_school.Account;
import com.example.v_school.MainActivity;
import com.example.v_school.MyDatabase;
import com.example.v_school.R;
import com.example.v_school.Student;

import org.jetbrains.annotations.NotNull;

public class quanly_Fragment extends Fragment {
    private MainActivity mainActivity;
    private Account account;
    private TextView userName;
    private TextView className;
    private Student student;
    private MyDatabase myDatabase;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quanly, container,false);
    }
    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        myDatabase = new MyDatabase(context);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivity = (MainActivity)getActivity();
//        account = mainActivity.getAccount();
        student = myDatabase.getStudentsByParent(account.getId()).get(0);
        InitUI();
        userName.setText(student.getName());
        className.setText(student.getClasses());
    }


    public void InitUI(){
        userName  = (TextView) getView().findViewById(R.id.txtUserName);
        className  = (TextView) getView().findViewById(R.id.txtLop);
    }
}
