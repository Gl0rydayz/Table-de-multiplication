package com.example.tpc04ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_nombre;
    Button btn_reinitialiser, btn_quitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        et_nombre = findViewById(R.id.et_nomber);
        btn_reinitialiser = findViewById(R.id.btn_reinitialiser);
        btn_quitter = findViewById(R.id.btn_quitter);

        btn_reinitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        btn_quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}