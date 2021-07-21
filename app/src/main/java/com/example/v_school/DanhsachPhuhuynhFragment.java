package com.example.v_school;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DanhsachPhuhuynhFragment extends Fragment {
    List<Account> parentList = new ArrayList<>();
    ParentAdapter adapter;
    MyDatabase myDatabase;
Button gui;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View v = inflater.inflate(R.layout.fragment_phuhuynhlist, container, false);
        gui = (Button) v.findViewById(R.id.btn_guithongbao);
                RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycle_parent);
        Context context = v.getContext();
        myDatabase = new MyDatabase(context);
        parentList.addAll(myDatabase.getParents());

        adapter = new ParentAdapter(parentList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(container.getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;

    }


}
