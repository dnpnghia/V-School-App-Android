package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_2 extends AppCompatActivity {
    private Button btnThongbao;
    private Button btnQuanly;
    private Button btnCaidat;
    private Button btnHotro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // CODE NUT' THONG BAO'
        btnThongbao = (Button) findViewById(R.id.btnThongbao);
        btnThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(), "login success!",
//                            Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_2.this, Activity_7.class);
//                    intent.putExtra("email", email.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        // CODE NUT' QUAN? LY'
        btnQuanly = (Button) findViewById(R.id.btnQuanly);
        btnQuanly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(), "login success!",
//                            Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_2.this, Activity_7.class);
//                    intent.putExtra("email", email.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        // CODE NUT' CAI` DAT
        btnCaidat = (Button) findViewById(R.id.btnCaidat);
        btnCaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(), "login success!",
//                            Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_2.this, Activity_6.class);
//                    intent.putExtra("email", email.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        // CODE NUT' HO~ TRO.
        btnHotro = (Button) findViewById(R.id.btnHotro);
        btnHotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(), "login success!",
//                            Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_2.this, Activity_7.class);
//                    intent.putExtra("email", email.getText().toString());
                startActivity(intent);
                finish();
            }
        });

    }
}