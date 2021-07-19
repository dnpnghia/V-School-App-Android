package com.example.v_school.thongtinFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.v_school.databinding.FragmentThongtinBinding;


public class thongtin_Fragment extends Fragment {
    private thongtin_ViewModel thongtinViewModel;
    private FragmentThongtinBinding binding;

    public thongtin_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thongtinViewModel = new ViewModelProvider(this).get(thongtin_ViewModel.class);
        binding = FragmentThongtinBinding.inflate(inflater,container,false);
        View root =binding.getRoot();
        TextView textView = binding.textHome;
        thongtinViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}