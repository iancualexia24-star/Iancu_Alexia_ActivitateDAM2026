package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int CERERE_MAGAZIN = 1;
    private TextView rezultatTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rezultatTV = findViewById(R.id.tvRezultat);
        Button adaugaButton = findViewById(R.id.btnAdauga);

        adaugaButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Adauga_Produs.class);
            startActivityForResult(intent, CERERE_MAGAZIN);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CERERE_MAGAZIN
                && resultCode == RESULT_OK
                && data != null
                && data.getExtras() != null) {

            Bundle date = data.getExtras();

            Magazin magazin = new Magazin();
            magazin.nume = date.getString("nume", "");
            magazin.adresa = date.getString("adresa", "");
            magazin.deschis = date.getBoolean("deschis");
            magazin.categorie = date.getString("categorie", "");
            magazin.tip = date.getString("tip", "");
            magazin.rating = date.getFloat("rating");
            magazin.livrare = date.getBoolean("livrare");

            rezultatTV.setText(getString(
                    R.string.result_format,
                    magazin.nume,
                    magazin.adresa,
                    getString(magazin.deschis ? R.string.yes : R.string.no),
                    magazin.categorie,
                    magazin.tip,
                    magazin.rating,
                    getString(magazin.livrare ? R.string.yes : R.string.no)
            ));
        }
    }
}