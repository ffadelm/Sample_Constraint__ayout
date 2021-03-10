package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successfully");
                    builder.setMessage("Welcome to Apps....");

                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (email.equals(mail) || pass.equals(sandi)) {
                    if (email.equals(mail)) {
                        Toast ps = Toast.makeText(getApplicationContext(),
                                "Invalid Password", Toast.LENGTH_SHORT);
                        ps.show();
                    } else {
                        Toast es = Toast.makeText(getApplicationContext(),
                                "Invalid Email", Toast.LENGTH_LONG);
                        es.show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Invalid Email and Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}