package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Activity_2 extends AppCompatActivity {
    private Button btnThongbao;
    private Button btnQuanly;
    private Button btnCaidat;
    private Button btnHotro;
    private TextView textViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        textViewUsername = (TextView) findViewById(R.id.txtUsernameMenu);
        String username = getIntent().getStringExtra("username");
        textViewUsername.setText("Xin chào " + username);
        String role = getIntent().getStringExtra("role");

        if (role.equals("PARENT")) {
            // CODE NUT' THONG BAO' CHO PARENT
            btnThongbao = (Button) findViewById(R.id.btnThongbao);
            btnThongbao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_2.this, Activity_7.class);
                    startActivity(intent);

                }
            });
        } else {
            // CODE NUT' THONG BAO' CHO SCHOOL
            Toast.makeText(getApplicationContext(), "Chức năng đang phát triển!",
                    Toast.LENGTH_SHORT).show();;
        }

        if (role.equals("PARENT")) {
            // CODE NUT' QUAN? LY'
            btnQuanly = (Button) findViewById(R.id.btnQuanly);
            btnQuanly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_2.this, Activity_7.class);
                    startActivity(intent);

                }
            });
        } else {
            // CODE NUT' QUAN? LY' CHO SCHOOL
            btnQuanly = (Button) findViewById(R.id.btnQuanly);
            btnQuanly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity_2.this, Activity_8.class);
                    startActivity(intent);

                }
            });
        }


        // CODE NUT' CAI` DAT
        btnCaidat = (Button) findViewById(R.id.btnCaidat);
        btnCaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this, Activity_6.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                intent.putExtra("phone", getIntent().getStringExtra("phone"));
                intent.putExtra("password", getIntent().getStringExtra("password"));
                startActivity(intent);

            }
        });

        // CODE NUT' HO~ TRO.
        btnHotro = (Button) findViewById(R.id.btnHotro);
        btnHotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_2.this, Activity_7.class);
                startActivity(intent);

            }
        });



    }
}