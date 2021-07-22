package com.example.v_school;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Activity_8 extends AppCompatActivity {
    List<Account> parentList = new ArrayList<>();
    ParentAdapter adapter;
    MyDatabase myDatabase;
    Button chonParent_btn;
    StringBuffer sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Phụ huynh");
        setContentView(R.layout.activity_8);
        chonParent_btn = (Button) findViewById(R.id.btn_selectParent);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_parent);

        myDatabase = new MyDatabase(this);
        parentList.addAll(myDatabase.getParents());
        adapter = new ParentAdapter(parentList, this);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        // btn chọn người gửi
        chonParent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb = new StringBuffer();
                for (Account pr : adapter.checkedParents) {
                    sb.append(pr.getId());
                    sb.append(", ");
                }
                if (adapter.checkedParents.size() > 0) {
                    Toast.makeText(Activity_8.this, sb.toString(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Activity_8.this, Activity_9.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("checkedParents", adapter.checkedParents);
                    i.putExtras(bundle);
                    startActivity(i);
                } else {
                    Toast.makeText(Activity_8.this, "Vui lòng chọn phụ huynh!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}