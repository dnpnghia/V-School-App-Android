package com.example.v_school;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietThongBao extends AppCompatActivity {

    private String tenthongbao;
    private String noidung;
    private String ngay;
    TextView txtviewTen;
    TextView txtviewNoidung;
    TextView txtviewNgay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietthongbao);
        if(getIntent() !=null)
        {
            tenthongbao = getIntent().getStringExtra("tenthongbao");
            noidung = getIntent().getStringExtra("ngay");
            ngay = getIntent().getStringExtra("noidung");

        }
        txtviewTen = findViewById(R.id.txtTenthongbaochitiet);
        txtviewNoidung = findViewById(R.id.txtNoidungchitiet);
        txtviewNgay = findViewById(R.id.txtNgaychitiet);

//        int tienCT = Integer.parseInt(String.valueOf(giatienSPct));
        txtviewTen.setText(tenthongbao);
        txtviewNgay.setText("Ngày: "+ngay);
        txtviewNoidung.setText("Nội dung: "+noidung);

    }
}