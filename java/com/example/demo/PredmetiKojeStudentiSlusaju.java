package com.example.demo;

public class PredmetiKojeStudentiSlusaju {

    private int brIndeksa;
    private int godUpisa;
    private int godStudija;
    private String imeStudenta;
    private String prezimeStudenta;
    private String nazivPredmeta;
    private int ESPB;
    private int idPredmeta;

    public PredmetiKojeStudentiSlusaju(int brIndeksa, int godUpisa, int godStudija, String imeStudenta, String prezimeStudenta, int idPredmeta, String nazivPredmeta, int ESPB) {
        this.brIndeksa = brIndeksa;
        this.godUpisa = godUpisa;
        this.godStudija = godStudija;
        this.imeStudenta = imeStudenta;
        this.prezimeStudenta = prezimeStudenta;
        this.nazivPredmeta = nazivPredmeta;
        this.ESPB = ESPB;
        this.idPredmeta = idPredmeta;
    }

    public int getBrIndeksa() {
        return brIndeksa;
    }
    public int getIdPredmeta() {
        return idPredmeta;
    }
    public int getGodUpisa() {
        return godUpisa;
    }

    public int getGodStudija() {
        return godStudija;
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public String getPrezimeStudenta() {
        return prezimeStudenta;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public int getESPB() {
        return ESPB;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    public void setGodUpisa(int godUpisa) {
        this.godUpisa = godUpisa;
    }
    public void setIdPredmeta(int idPredmeta) {
        this.idPredmeta = idPredmeta;
    }

    public void setGodStudija(int godStudija) {
        this.godStudija = godStudija;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public void setPrezimeStudenta(String prezimeStudenta) {
        this.prezimeStudenta = prezimeStudenta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public void setESPB(int ESPB) {
        this.ESPB = ESPB;
    }
}
