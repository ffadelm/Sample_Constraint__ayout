package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActHasil extends AppCompatActivity {
    //deklarasi variable
    TextView txEmail, txPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_hasil);

        txEmail = findViewById(R.id.tvEmail);
        txPass = findViewById(R.id.tvPass);

        //mengambil data dari Intent
        Bundle bundle = getIntent().getExtras();

        //menyimpan data ke variable baru
        String email = bundle.getString("e");
        String pass = bundle.getString("p");

        txEmail.setText(email);
        txPass.setText(pass);
    }
}