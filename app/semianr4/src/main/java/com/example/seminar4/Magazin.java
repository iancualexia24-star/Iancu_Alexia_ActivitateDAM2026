package com.example.seminar4;

public class Magazin {
    public String nume;
    public String adresa;
    public boolean deschis;
    public String categorie;
    public String tip;
    public float rating;
    public boolean livrare;
    @Override
    public String toString() {
        return nume + "\n"
                + "Adresă: " + adresa + "\n"
                + "Categorie: " + categorie + "\n"
                + "Tip: " + tip + "\n"
                + "Rating: " + rating + "/5" + "\n"
                + "Deschis: " + (deschis ? "Da" : "Nu") + "\n"
                + "Livrare: " + (livrare ? "Da" : "Nu");
    }

}