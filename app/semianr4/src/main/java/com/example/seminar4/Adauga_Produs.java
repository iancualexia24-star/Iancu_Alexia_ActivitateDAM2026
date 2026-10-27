package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Adauga_Produs extends AppCompatActivity {

    private EditText numeET;
    private EditText adresaET;
    private CheckBox deschisCB;
    private RadioGroup categorieRG;
    private Spinner tipSpinner;
    private RatingBar ratingBar;
    private SwitchCompat livrareSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_produs);

        numeET = findViewById(R.id.nume_ET);
        adresaET = findViewById(R.id.adresa_ET);
        deschisCB = findViewById(R.id.eValabil_CB);
        categorieRG = findViewById(R.id.rgCategorie);
        tipSpinner = findViewById(R.id.spTip);
        ratingBar = findViewById(R.id.ratingMagazin);
        livrareSwitch = findViewById(R.id.switchLivrare);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.tipuri_magazin,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipSpinner.setAdapter(adapter);
    }

    public void culegeDate(View view) {
        String nume = numeET.getText().toString().trim();
        String adresa = adresaET.getText().toString().trim();

        if (nume.isEmpty()) {
            numeET.setError(getString(R.string.error_name));
            return;
        }

        if (adresa.isEmpty()) {
            adresaET.setError(getString(R.string.error_address));
            return;
        }

        Magazin magazin = new Magazin();
        magazin.nume = nume;
        magazin.adresa = adresa;
        magazin.deschis = deschisCB.isChecked();
        magazin.categorie = categorieRG.getCheckedRadioButtonId() == R.id.rbCarti
                ? getString(R.string.cat_books)
                : getString(R.string.cat_food);
        magazin.tip = tipSpinner.getSelectedItem().toString();
        magazin.rating = ratingBar.getRating();
        magazin.livrare = livrareSwitch.isChecked();

        Bundle date = new Bundle();
        date.putString("nume", magazin.nume);
        date.putString("adresa", magazin.adresa);
        date.putBoolean("deschis", magazin.deschis);
        date.putString("categorie", magazin.categorie);
        date.putString("tip", magazin.tip);
        date.putFloat("rating", magazin.rating);
        date.putBoolean("livrare", magazin.livrare);

        Intent rezultat = new Intent();
        rezultat.putExtras(date);
        setResult(RESULT_OK, rezultat);
        finish();
    }
}