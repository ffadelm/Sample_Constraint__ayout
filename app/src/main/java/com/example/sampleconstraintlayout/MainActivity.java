package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edemail, edpassword;

    Button bSignin;

    String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edemail = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);
        bSignin = findViewById(R.id.btLogin);


        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = "admin@mail.com";
                String sandi = "admin";

                email = edemail.getText().toString();
                pass = edpassword.getText().toString();

                if (email.equals(mail) && pass.equals(sandi)) {
                    //membuat alert dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successfully");
                    builder.setMessage("Welcome to Apps, click Yes to continue");

                    //ketika di klik YES maka akan diarahkan ke activity selanjutnya
                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //membuat objek bundle
                            Bundle b = new Bundle();
                            b.putString("e", email.trim());
                            b.putString("p", pass.trim());
                            //membuat intent untuk berpindah ke activity selanjutnya
                            Intent i = new Intent(getApplicationContext(), Home_activity.class);
                            i.putExtras(b);
                            startActivity(i);
                        }
                    });
                    //mengeksekusi alert dialog
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if (email.equals(mail) || pass.equals(sandi)) {
                    if (email.equals(mail)) {
                        Toast wrongPass = Toast.makeText(getApplicationContext(),
                                "Invalid Password!!!", Toast.LENGTH_SHORT);
                        wrongPass.show();
                    } else {
                        Toast wrongEmail = Toast.makeText(getApplicationContext(),
                                "Invalid Email!!!", Toast.LENGTH_LONG);
                        wrongEmail.show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Invalid Email and Password !!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //membuat kondisi jika memilih mnDaftar
        if(item.getItemId() == R.id.mnDaftar){
            //memanggil ACT pendaftaran
            Intent i = new Intent(getApplicationContext(), Pendaftaran.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}