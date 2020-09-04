package com.example.demo;

public class Predmet {

    private int id;
    private String naziv;
    private int espb;
    private String tip;
    private int godStudija;

    public Predmet(int id, int godStudija, String naziv, int espb, String tip) {
        this.id = id;
        this.godStudija = godStudija;
        this.naziv = naziv;
        this.espb = espb;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGodStudija(int godStudija) { this.godStudija = godStudija; }

    public int getGodStudija() { return godStudija; }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEspb() {
        return espb;
    }

    public String getTip() {
        return tip;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}


