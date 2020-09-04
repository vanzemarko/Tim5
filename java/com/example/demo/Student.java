package com.example.demo;

public class Student {

    private int id;
    private int index;
    private int godUpisa;
    private String ime;
    private String prezime;
    private int godStudija;

    public Student(int id, int index, int godUpisa, String ime, String prezime, int godStudija) {
        this.id = id;
        this.index = index;
        this.godUpisa = godUpisa;
        this.ime = ime;
        this.prezime = prezime;
        this.godStudija = godStudija;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getGodUpisa() {
        return godUpisa;
    }

    public void setGodUpisa(int godUpisa) {
        this.godUpisa = godUpisa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodStudija() {
        return godStudija;
    }

    public void setGodStudija(int godStudija) {
        this.godStudija = godStudija;
    }
}
