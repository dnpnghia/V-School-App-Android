package com.example.v_school.dieukhoan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.v_school.databinding.FragmentDieukhoanBinding;


public class dieukhoan_Fragment extends Fragment {

    private dieukhoan_ViewModel dieukhoanViewModel;
    private FragmentDieukhoanBinding binding;

    public dieukhoan_Fragment() {
        // Required empty public constructor
    }



// function return view of fragment from file layou xml
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dieukhoanViewModel =
                new ViewModelProvider(this).get(dieukhoan_ViewModel.class);

        binding = FragmentDieukhoanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        dieukhoanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}