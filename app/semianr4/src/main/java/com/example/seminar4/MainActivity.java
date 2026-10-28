package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Magazin> magazine = new ArrayList<>();

    private static final int CERERE_MAGAZIN = 1;
    private TextView rezultatTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rezultatTV = findViewById(R.id.tvRezultat);
        Button btnAdauga = findViewById(R.id.btnAdauga);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Adauga_Produs.class
                );

                startActivityForResult(intent, CERERE_MAGAZIN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CERERE_MAGAZIN && resultCode == RESULT_OK && data != null && data.getExtras() != null)
        {
            Bundle date = data.getExtras();

            Magazin magazin = new Magazin();
            magazin.nume = date.getString("nume", "");
            magazin.adresa = date.getString("adresa", "");
            magazin.deschis = date.getBoolean("deschis");
            magazin.categorie = date.getString("categorie", "");
            magazin.tip = date.getString("tip", "");
            magazin.rating = date.getFloat("rating");
            magazin.livrare = date.getBoolean("livrare");
            magazine.add(magazin);
            rezultatTV.setText(magazin.toString());
        }
    }

    public void deschideLista(View view) {
        Intent intent = new Intent(
                getApplicationContext(),
                ListaMagazine.class
        );

        startActivity(intent);
    }
}