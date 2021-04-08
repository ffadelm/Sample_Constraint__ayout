package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        switch (nama){
            case "Anang":
                tvnama.setText("Anang A");
                tvnomor.setText("081234567890");
                break;
            case "Badrul":
                tvnama.setText("Badrul M");
                tvnomor.setText("087898745678");
                break;
            case "Cecep":
                tvnama.setText("Cecep B");
                tvnomor.setText("081209876543");
                break;
            case "Dodit":
                tvnama.setText("Dodit K");
                tvnomor.setText("087812345680");
                break;
            case "Ewing":
                tvnama.setText("Ewing HD");
                tvnomor.setText("083489682749");
                break;
            case "Fadel":
                tvnama.setText("Fadel FM");
                tvnomor.setText("082176515234");
                break;
            case "Gopal":
                tvnama.setText("Gopal I");
                tvnomor.setText("081426739204");
                break;
            case "Hamdani":
                tvnama.setText("Hamdani L");
                tvnomor.setText("089623419980");
                break;
            case "Iwan":
                tvnama.setText("Iwan Moh");
                tvnomor.setText("089678787244");
                break;
            case "Jamal":
                tvnama.setText("Jamaludin");
                tvnomor.setText("081369356254");
                break;
        }

    }
}