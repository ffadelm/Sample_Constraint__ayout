package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {
    //deklarasi variable dengan tipe data edit text
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //deklarasi variable dengan tipe data floating button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.EdEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepas);
        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Membuat kondisi untuk mengcek apakah edittext kosong?
                if (edtNama.getText().toString().isEmpty() ||
                    edtAlamat.getText().toString().isEmpty() ||
                    edtEmail.getText().toString().isEmpty() ||
                    edtPassword.getText().toString().isEmpty() ||
                    edtrepass.getText().toString().isEmpty()){
                    //menampilkan pesan notif jika seluruh eduttext wajib diisi
                    Snackbar.make(v, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                }
                else {
                    //membuat kondisi dimana untuk mengecek data sama atau tidak
                    if(edtPassword.getText().toString().equals(edtrepass.getText().toString())){
                        //menampilkan pesan notif jika done
                        Toast.makeText(getApplicationContext(), "Pendaftaran berhasil...",
                                Toast.LENGTH_LONG).show();

                        //untuk kembali ke act Main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        //menampilkan bahwa data tidak sama
                        Snackbar.make(v, "Password dan Repasssword Harus Sama!!!..",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}