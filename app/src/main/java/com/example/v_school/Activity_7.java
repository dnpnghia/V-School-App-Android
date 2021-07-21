package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Activity_7 extends AppCompatActivity {
    private RecyclerView rvList;
    private List<Notification> noTiList = new ArrayList<>();
    private NotificationAdapter noTiAdapter;
    DatabaseReference myRef;
    FirebaseDatabase rootNode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thông báo");
        setContentView(R.layout.activity_7);

        rootNode = FirebaseDatabase.getInstance();
        myRef = rootNode.getReference("notification");


//        noTiList = null;
//        rvList.setHasFixedSize(true);
//        noTiAdapter sanPhamAdapter= new noTiAdapter(noTiList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//        rvList.setLayoutManager(linearLayoutManager);
//        rvList.setAdapter(sanPhamAdapter);
//        btnthem.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//////                String tensp = edtTenSP.getText().toString();
//////                String masp = edtMaSP.getText().toString();
//////                String moTa = edtMoTa.getText().toString();
//////                String giaTien = edtGiaTien.getText().toString();
////                SanPham sanpham = new SanPham();
////                sanpham.setTenSP(tensp);
////                sanpham.setMaSP(masp);
////                sanpham.setMoTa(moTa);
////                sanpham.setGiaTien(giaTien);
////                myDatabase.insertData(sanpham.getTenSP(),sanpham.getMaSP(),sanpham.getGiaTien(),sanpham.getMoTa());
////                sanPhamList.add(sanpham);
////                sanPhamAdapter.notifyDataSetChanged();
////                Toast.makeText(MainActivity.this,"Added "+sanpham.getMaSP().toString()+" "+sanpham.getGiaTien()+" Successfully",Toast.LENGTH_SHORT).show();
////            }
////        });
//        sanPhamAdapter.setMyOnClickItemListener(new MyOnClickItemListener() {
//            @Override
//            public void onClick(SanPham sanpham) {
//                Intent intent = new Intent(MainActivity.this,ChiTietSanPham.class);
//                intent.putExtra("tenthongbao",sanpham.getTenSP());
//                intent.putExtra("ngay",sanpham.getMaSP());
//                intent.putExtra("noidung",sanpham.getMoTa());
//
//                startActivity(intent);
//            }
//        });



    }
}