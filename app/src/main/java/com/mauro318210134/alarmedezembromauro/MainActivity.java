package com.mauro318210134.alarmedezembromauro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBoxDom, checkBoxSeg, checkBoxTer, checkBoxQua, checkBoxQui, checkBoxSex, checkBoxSab;
    Button btnAgendar;
    EditText edtHora;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxDom = findViewById(R.id.checkBoxDom);
        checkBoxSeg = findViewById(R.id.checkBoxSeg);
        checkBoxTer = findViewById(R.id.checkBoxTer);
        checkBoxQua = findViewById(R.id.checkBoxQua);
        checkBoxQui = findViewById(R.id.checkBoxQui);
        checkBoxSex = findViewById(R.id.checkBoxSex);
        checkBoxSab = findViewById(R.id.checkBoxSab);

        btnAgendar = findViewById(R.id.btnAgendar);
        edtHora = findViewById(R.id.edtHora);

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}