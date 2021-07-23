package com.example.v_school.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.v_school.R;

import org.jetbrains.annotations.NotNull;


public class dieukhoan_Fragment extends Fragment {
//
//    private dieukhoan_ViewModel dieukhoanViewModel;
//    private FragmentDieukhoanBinding binding;
    private  TextView title;
    private View view;
    public dieukhoan_Fragment() {
        // Required empty public constructor
    }


    // function return view of fragment from file layou xml
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dieukhoan, container,false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        title = (TextView) getView().findViewById(R.id.text_dieukhoan);
        title.setText("Điều khoản");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}