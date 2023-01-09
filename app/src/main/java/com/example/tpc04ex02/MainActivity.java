package com.example.tpc04ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_nombre;
    Button btn_reinitialiser, btn_quitter;
    Button btn_afficher;
    TextView tv_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        et_nombre = findViewById(R.id.et_nomber);
        btn_reinitialiser = findViewById(R.id.btn_reinitialiser);
        btn_quitter = findViewById(R.id.btn_quitter);
        btn_afficher = findViewById(R.id.btn_afficher);
        tv_table = findViewById(R.id.tv_table);

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

        btn_afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!et_nombre.getText().toString().equals("")) {
                        tv_table.setText("");
                        int i = 0;
                        while (i <= tv_table.getMaxLines()) {
                            int res = Integer.parseInt(et_nombre.getText().toString()) * i;
                            String tableMultiplication = et_nombre.getText().toString() + " * " + i + " = " + res + "\n";
                            tv_table.append(tableMultiplication);
                            i++;
                        }
                    } else {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Veuillez saisir un entier!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}