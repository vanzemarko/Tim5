package com.example.demo;

public class PolozeniIspit {

    private int sifraPredmeta;
    private String naziv;
    private int brIndeksa;
    private int godUpisa;
    private String imeStudenta;
    private String prezimeStudenta;
    private int ocena;
    private String tip;
    private int godinaStudija;
    private int idStudenta;

    public PolozeniIspit(int sifraPredmeta, String naziv, int brIndeksa, int godUpisa, String imeStudenta, String prezimeStudenta, int ocena, String tip, int godinaStudija, int idStudenta) {
        this.sifraPredmeta = sifraPredmeta;
        this.naziv = naziv;
        this.brIndeksa = brIndeksa;
        this.godUpisa = godUpisa;
        this.imeStudenta = imeStudenta;
        this.prezimeStudenta = prezimeStudenta;
        this.ocena = ocena;
        this.tip = tip;
        this.godinaStudija = godinaStudija;
        this.idStudenta = idStudenta;
    }

    public int getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    public int getSifraPredmeta() {
        return sifraPredmeta;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getBrIndeksa() {
        return brIndeksa;
    }

    public int getGodUpisa() {
        return godUpisa;
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public String getPrezimeStudenta() {
        return prezimeStudenta;
    }

    public int getOcena() {
        return ocena;
    }

    public String getTip() {
        return tip;
    }

    public void setSifraPredmeta(int sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    public void setGodUpisa(int godUpisa) {
        this.godUpisa = godUpisa;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public void setPrezimeStudenta(String prezimeStudenta) {
        this.prezimeStudenta = prezimeStudenta;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }
}
