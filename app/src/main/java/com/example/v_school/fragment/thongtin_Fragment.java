package com.example.v_school.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.v_school.R;
import com.example.v_school.databinding.FragmentThongtinBinding;

import org.jetbrains.annotations.NotNull;


public class thongtin_Fragment extends Fragment {

    TextView title;
    public thongtin_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_thongtin,container,false);
        return root;
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        title = (TextView) getView().findViewById(R.id.text_thongtin);
        title.setText("Thông tin ứng dụng");
    }
}