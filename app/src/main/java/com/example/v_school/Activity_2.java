package com.example.v_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Activity_2 extends AppCompatActivity {
    private Button btnThongbao;
    private Button btnQuanly;
    private Button btnCaidat;
    private Button btnHotro;
    private TextView textViewUsername;
    DatabaseReference myRef;
    FirebaseDatabase rootNode;


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
                    Toast.LENGTH_SHORT).show();

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

        // Read from the database
        rootNode = FirebaseDatabase.getInstance();
        myRef = rootNode.getReference("notification");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(getApplicationContext(), "Có thông báo mới !!!",
                        Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}