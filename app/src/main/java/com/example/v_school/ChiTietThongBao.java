package com.example.v_school;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietThongBao extends AppCompatActivity {

    private String tenthongbao;
    private String noidung;
    private String ngay;
    private TextView txtviewTen;
    private TextView txtviewNoidung;
    private TextView txtviewNgay;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietthongbao);
        if(getIntent() !=null)
        {
            tenthongbao = getIntent().getStringExtra("tenthongbao");
            noidung = getIntent().getStringExtra("noidung");
            ngay = getIntent().getStringExtra("ngay");

        }
        txtviewTen = findViewById(R.id.txtTenthongbaochitiet);
        txtviewNoidung = findViewById(R.id.txtNoidungchitiet);
        txtviewNgay = findViewById(R.id.txtNgaychitiet);

        txtviewTen.setText(tenthongbao);
        txtviewNgay.setText(ngay);
        txtviewNoidung.setText(noidung);


        //CODE NUT' BACK
        btnBack = (Button) findViewById(R.id.btnBackChitiet);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}